/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.service;

import java.util.List;

import com.project.core.dto.ManuFacterDTO;

/**
 *
 * @author 19110
 */
public interface ManuFacterService {
    List<ManuFacterDTO> findAll();
    ManuFacterDTO findById(Integer manufacterId);
}
