/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.daoimpl;

import com.project.core.common.utils.HibernateUtil;
import com.project.core.dao.UsersDao;
import com.project.core.data.daoimpl.AbstractDao;
import com.project.core.persistence.entity.UsersEntity;

import org.apache.log4j.Logger;
import org.hibernate.*;

/**
 *
 * @author 19110
 */
public class UsersDaoImpl extends AbstractDao<Integer, UsersEntity> implements UsersDao {
    private final Logger log = Logger.getLogger(this.getClass());
    public Object[] checkLogin(String email, String telephone, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean isUserExist = false;
        String roleName = null;
        try {
            StringBuilder sql = new StringBuilder("FROM UsersEntity WHERE password= :password AND ");
            if(email != null) {
                sql.append("email= :email");
            } 
            if (telephone != null) {
                sql.append("telephone= :telephone");
            }
            Query query = session.createQuery(sql.toString());
            query.setParameter("password", password);
            if(email != null) {
                query.setParameter("email", email);
            }
            if (telephone != null) {
                query.setParameter("telephone", telephone);
            }
            if (query.list().size() > 0) {
                isUserExist = true;
                UsersEntity usersEntity = (UsersEntity) query.uniqueResult();
                roleName = usersEntity.getRoles().getRoleName();
            }
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }
        return new Object[] {isUserExist, roleName};
    }
}
