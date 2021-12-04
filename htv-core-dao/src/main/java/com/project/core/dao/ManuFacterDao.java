/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.dao;

import java.util.List;

import com.project.core.data.dao.GenericDao;
import com.project.core.persistence.entity.ManuFacterEntity;

/**
 *
 * @author 19110
 */
public interface ManuFacterDao extends GenericDao<Integer, ManuFacterEntity> {
    List<ManuFacterEntity> findByManuFacters(List<String> manuFacters);
}
