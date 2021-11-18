/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.web.command;

import java.util.List;

/**
 *
 * @author 19110
 */
public class AbstractCommand<T> {
    protected T pojo;
    private String crudaction;
    private List<T> listResult;
    private String tableId = "tableList";
    private int maxPageItems = 5;
    private int totalItems = 0;
    private int firstItem = 0;
    private String sortExpression;
    private String sortDirection;
    private String[] checkList;
    private String messageResponse;
    private int page = 1;
    private String urlType;
    private int totalPages;

    public T getPojo() {
        return pojo;
    }

    public void setPojo(T pojo) {
        this.pojo = pojo;
    }

    public String getCrudaction() {
        return crudaction;
    }

    public void setCrudaction(String crudaction) {
        this.crudaction = crudaction;
    }
    
    
}
