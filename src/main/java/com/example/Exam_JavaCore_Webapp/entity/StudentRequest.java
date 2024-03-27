package com.example.Exam_JavaCore_Webapp.entity;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

public class StudentRequest {
    private String address;
    private Timestamp birthday;
    private MultipartFile imageReq;
    private String imageUrl;
    private String phoneNumber;
    private Boolean sex;
    private String studentName;
    private int studentId;

    public StudentRequest() {
    }

    public StudentRequest(String address, Timestamp birthday, MultipartFile imageReq, String imageUrl, String phoneNumber, Boolean sex, String studentName, int studentId) {
        this.address = address;
        this.birthday = birthday;
        this.imageReq = imageReq;
        this.imageUrl = imageUrl;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public MultipartFile getImageReq() {
        return imageReq;
    }

    public void setImageReq(MultipartFile imageReq) {
        this.imageReq = imageReq;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
