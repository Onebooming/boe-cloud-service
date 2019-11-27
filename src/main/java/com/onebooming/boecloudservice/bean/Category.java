package com.onebooming.boecloudservice.bean;

import java.sql.Timestamp;

/**
 * @author Onebooming
 */
public class Category {
    private Long id;
    private String cateName;//种类名
    private Timestamp date;//日期

    public Category() {
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
