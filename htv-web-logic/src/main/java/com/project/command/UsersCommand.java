/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.command;

import java.util.List;

import com.project.core.dto.RolesDTO;
import com.project.core.dto.UserImportDTO;
import com.project.core.dto.UsersDTO;
import com.project.core.web.command.AbstractCommand;

/**
 *
 * @author 19110
 */
public class UsersCommand extends AbstractCommand<UsersDTO>{
    public UsersCommand() {
        this.pojo = new UsersDTO();
    }
    private List<RolesDTO> roles;
    private Integer roleId;
    private List<UserImportDTO> userImportDTOS;
    private String newPassword;
    private String confirmPassword;

    public List<RolesDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesDTO> roles) {
        this.roles = roles;
    }

    public Integer getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<UserImportDTO> getUserImportDTOS() {
        return userImportDTOS;
    }

    public void setUserImportDTOS(List<UserImportDTO> userImportDTOS) {
        this.userImportDTOS = userImportDTOS;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
