package com.guanshan.phoenix.dao.entity;

import java.util.Date;

public class Teacher {
    private Integer id;

    private Integer userId;

    private String tno;

    private String name;

    private Integer gender;

    private Date brithday;

    private Integer title;

    private String email;

    private String phone;

    public Teacher(Integer id, Integer userId, String tno, String name, Integer gender, Date brithday, Integer title, String email, String phone) {
        this.id = id;
        this.userId = userId;
        this.tno = tno;
        this.name = name;
        this.gender = gender;
        this.brithday = brithday;
        this.title = title;
        this.email = email;
        this.phone = phone;
    }

    public Teacher() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno == null ? null : tno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}