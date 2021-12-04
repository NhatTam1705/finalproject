/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.project.core.common.utils.HibernateUtil;
import com.project.core.dao.ProductDao;
import com.project.core.data.daoimpl.AbstractDao;
import com.project.core.persistence.entity.ProductEntity;

import org.hibernate.*;

/**
 *
 * @author 19110
 */
public class ProductDaoImpl extends AbstractDao<Integer, ProductEntity> implements ProductDao {
    public List<ProductEntity> findByProducts(List<String> productNames) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
        try {
            StringBuilder sql = new StringBuilder(" FROM ProductEntity pe WHERE pe.productName IN(:productNames) ");
            Query query = session.createQuery(sql.toString());
            query.setParameterList("productNames", productNames);
            productEntities = query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return productEntities;
    }
}
