/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.daoimpl;

import com.project.core.common.utils.HibernateUtil;
import com.project.core.dao.OrderDetailsDao;
import com.project.core.data.daoimpl.AbstractDao;
import com.project.core.persistence.entity.OrderDetailsEntity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 19110
 */
public class OrderDetailsDaoImpl extends AbstractDao<Integer, OrderDetailsEntity> implements OrderDetailsDao {
    public Integer saveReturnId(OrderDetailsEntity orderDetailsEntity) {
        Integer id = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(orderDetailsEntity);
            transaction.commit();
            id = orderDetailsEntity.getOrderId();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return id;
    }
}
