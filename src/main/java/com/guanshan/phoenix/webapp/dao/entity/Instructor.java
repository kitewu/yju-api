package com.guanshan.phoenix.webapp.dao.entity;

public class Instructor {

    private String contact;
    private Integer userId;
    private String name;
    private Integer gender;
    private String tno;
    private Integer id;

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public Integer getUser_id() {
        return userId;
    }
    public void setUser_id(Integer userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public String getTno() {
        return tno;
    }
    public void setTno(String tno) {
        this.tno = tno;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}