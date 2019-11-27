package com.onebooming.boecloudservice.bean;

/**
 * 标签栏
 * @author Onebooming
 * @apiNote 2019/11/10
 */
public class Tags {
    private Long id;
    private String tagName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
