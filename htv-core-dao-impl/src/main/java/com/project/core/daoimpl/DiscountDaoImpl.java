/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.project.core.common.utils.HibernateUtil;
import com.project.core.dao.DiscountDao;
import com.project.core.data.daoimpl.AbstractDao;
import com.project.core.persistence.entity.DiscountEntity;

import org.hibernate.*;

/**
 *
 * @author 19110
 */
public class DiscountDaoImpl extends AbstractDao<Integer, DiscountEntity> implements DiscountDao {
    public List<DiscountEntity> findByDiscounts(List<String> discounts) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<DiscountEntity> discountEntities = new ArrayList<DiscountEntity>();
        try {
            StringBuilder sql = new StringBuilder(" FROM DiscountEntity de WHERE de.discountName IN(:discounts) ");
            Query query = session.createQuery(sql.toString());
            query.setParameterList("discounts", discounts);
            discountEntities = query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return discountEntities;
    }
}
