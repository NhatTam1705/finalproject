/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.dao;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.project.core.data.dao.GenericDao;
import com.project.core.persistence.entity.OrderDetailsEntity;

/**
 *
 * @author 19110
 */
public interface OrderDetailsDao extends GenericDao<Integer, OrderDetailsEntity> {
    Integer saveReturnId(OrderDetailsEntity orderDetailsEntity);
}
