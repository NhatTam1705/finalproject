/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.command;

import java.util.List;

import com.project.core.dto.RolesDTO;
import com.project.core.dto.UsersDTO;
import com.project.core.web.command.AbstractCommand;

/**
 *
 * @author 19110
 */
public class UsersCommand extends AbstractCommand<UsersDTO>{
    private List<RolesDTO> roles;

    public List<RolesDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesDTO> roles) {
        this.roles = roles;
    }

    public UsersCommand() {
        this.pojo = new UsersDTO();
    }

    
}
