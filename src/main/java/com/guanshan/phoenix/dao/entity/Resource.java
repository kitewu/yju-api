package com.guanshan.phoenix.dao.entity;

public class Resource {
    private Integer id;

    private String name;

    private Integer type;

    private String url;

    private String width;

    private String height;

    public Resource(Integer id, String name, Integer type, String url, String width, String height) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public Resource() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }
}