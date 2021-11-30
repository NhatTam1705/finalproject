/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.persistence.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 19110
 */
@Entity
@Table(name = "roles")
public class RolesEntity {
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UsersEntity> usersEntityList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UsersEntity> getUsersEntityList() {
        return usersEntityList;
    }

    public void setUsersEntityList(List<UsersEntity> usersEntityList) {
        this.usersEntityList = usersEntityList;
    }
}
