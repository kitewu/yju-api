package com.guanshan.phoenix.webdomain;

public class ReqUpdateTeacher {
    private int teacherId;
    private String teacherName;
    private int teacherTitleId;
    private int gender;
    private String teacherContact;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherTitleId() {
        return teacherTitleId;
    }

    public void setTeacherTitleId(int teacherTitleId) {
        this.teacherTitleId = teacherTitleId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getTeacherContact() {
        return teacherContact;
    }

    public void setTeacherContact(String teacherContact) {
        this.teacherContact = teacherContact;
    }
}
