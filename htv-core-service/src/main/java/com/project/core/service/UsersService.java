/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service;

import com.project.core.dto.UsersDTO;

/**
 *
 * @author 19110
 */
public interface UsersService {
    UsersDTO isUserExist(UsersDTO dto);
    UsersDTO findRoleByUser(UsersDTO dto);
}
