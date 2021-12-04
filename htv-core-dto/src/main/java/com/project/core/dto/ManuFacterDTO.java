/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.dto;

import java.io.Serializable;

/**
 *
 * @author 19110
 */
public class ManuFacterDTO implements Serializable{
    private Integer manufacterId;
    private String manufacterName;

    public Integer getManufacterId() {
        return manufacterId;
    }

    public void setManufacterId(Integer manufacterId) {
        this.manufacterId = manufacterId;
    }

    public String getManufacterName() {
        return manufacterName;
    }

    public void setManufacterName(String manufacterName) {
        this.manufacterName = manufacterName;
    }
    
    
}
