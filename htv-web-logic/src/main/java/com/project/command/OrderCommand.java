/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.command;

import com.project.core.dto.OrderItemDTO;
import com.project.core.web.command.AbstractCommand;

/**
 *
 * @author 19110
 */
public class OrderCommand extends AbstractCommand<OrderItemDTO>{
    public OrderCommand() {
        this.pojo = new OrderItemDTO();
    }
    
}
