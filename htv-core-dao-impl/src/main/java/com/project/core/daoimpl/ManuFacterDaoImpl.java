/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.project.core.common.utils.HibernateUtil;
import com.project.core.dao.ManuFacterDao;
import com.project.core.data.daoimpl.AbstractDao;
import com.project.core.persistence.entity.ManuFacterEntity;

import org.hibernate.*;

/**
 *
 * @author 19110
 */
public class ManuFacterDaoImpl extends AbstractDao<Integer, ManuFacterEntity> implements ManuFacterDao {
    public List<ManuFacterEntity> findByManuFacters(List<String> manuFacters) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<ManuFacterEntity> manuFacterEntities = new ArrayList<ManuFacterEntity>();
        try {
            StringBuilder sql = new StringBuilder(" FROM ManuFacterEntity mfe WHERE mfe.manufacterName IN(:manuFacters) ");
            Query query = session.createQuery(sql.toString());
            query.setParameterList("manuFacters", manuFacters);
            manuFacterEntities = query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return manuFacterEntities;
    }
}
