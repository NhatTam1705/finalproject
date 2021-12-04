/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.data.daoimpl;

import com.project.core.common.constant.CoreConstant;
import com.project.core.common.utils.HibernateUtil;
import com.project.core.data.dao.GenericDao;

import java.util.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.apache.log4j.Logger;
import org.hibernate.*;

/**
 *
 * @author 19110
 */
public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {

    private final Logger log = Logger.getLogger(this.getClass());
    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
    }

    //find all
    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return list;
    }

    //update
    public T update(T entity) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object object = session.merge(entity);
            result = (T) object;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    //save
    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();;
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
    }

    //find by id
    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = (T) session.get(persistenceClass, id);
            if (result == null) {
                throw new ObjectNotFoundException(" NOT FOUND " + id, null);
            }
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return result;
    }
    //find by property
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object totalItem = 0;
        String[] params = new String[property.size()];
        Object[] values = new Object[property.size()];
        int i = 0;
        for (Map.Entry<String, Object> entry : property.entrySet()) {
            params[i] = (String) entry.getKey();
            values[i] = entry.getValue();
            i++;
        }
        try {
            StringBuilder sql1 = new StringBuilder("from ");
            sql1.append(getPersistenceClassName());
            if (property.size() > 0) {
                sql1.append(" where ");
                for (int j = 0; j < params.length; j++) {
                    if (j > 0) {
                        sql1.append(" and ");
                    }
                    sql1.append(params[j]).append(" = :").append(params[j]);
                }
            }
            if (sortExpression != null && sortDirection != null) {
                sql1.append(" order by ").append(sortExpression);
                sql1.append(" " + (sortDirection.equals(CoreConstant.SORT_ASC) ? "asc" : "desc"));
            }
            Query query1 = session.createQuery(sql1.toString());
            if (property.size() > 0) {
                for (int j = 0; j < params.length; j++) {
                    query1.setParameter(params[j], values[j]);
                }
            }
            if (offset != null && offset >= 0) {
                query1.setFirstResult(offset);
            }
            if (limit != null && limit > 0) {
                query1.setMaxResults(limit);
            }
            list = query1.list();
            StringBuilder sql2 = new StringBuilder("select count(*) from ");
            sql2.append(getPersistenceClassName());
            if (property.size() > 0) {
                sql2.append(" where ");
                for (int j = 0; j < params.length; j++) {
                    if (j > 0) {
                        sql2.append(" and ");
                    }
                    sql2.append(params[j]).append(" = :").append(params[j]);
                }
            }
            Query query2 = session.createQuery(sql2.toString());
            if (property.size() > 0) {
                for (int j = 0; j < params.length; j++) {
                    query2.setParameter(params[j], values[j]);
                }
            }
            totalItem = query2.list().get(0);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return new Object[]{totalItem, list};
    }
    //delete
    public Integer delete(List<ID> ids) {
        Integer count = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (ID item: ids) {
                T t = (T) session.get(persistenceClass, item);
                session.delete(t);
                count++;
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return count;
    }

    public T findEqualUnique(String property, Object value) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        T result = null;
        try {
            String sql = " FROM "+getPersistenceClassName()+" model WHERE model."+property+"= :value";
            Query query = session.createQuery(sql.toString());
            query.setParameter("value", value);
            result = (T) query.uniqueResult();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return result;
    }
}
