/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.project.core.common.utils.HibernateUtil;
import com.project.core.dao.RolesDao;
import com.project.core.data.daoimpl.AbstractDao;
import com.project.core.persistence.entity.RolesEntity;

import org.hibernate.*;
/**
 *
 * @author 19110
 */
public class RolesDaoImpl extends AbstractDao<Integer, RolesEntity> implements RolesDao {
    public List<RolesEntity> findByRoles(List<String> roles) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RolesEntity> roleEntities = new ArrayList<RolesEntity>();
        try {
            StringBuilder sql = new StringBuilder(" FROM RolesEntity re WHERE re.roleName IN(:roles) ");
            Query query = session.createQuery(sql.toString());
            query.setParameterList("roles", roles);
            roleEntities = query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return roleEntities;
    }
}
    

