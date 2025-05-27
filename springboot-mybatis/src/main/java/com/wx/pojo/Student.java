package com.wx.pojo;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentNo;
    private String sName;
    private String sex;
    private LocalDate birthdate;
    private Integer entrance;
    private String phone;
    private String Email;

//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentNo='" + studentNo + '\'' +
//                ", sName='" + sName + '\'' +
//                ", sex='" + sex + '\'' +
//                ", birthday=" + birthday +
//                ", entrance=" + entrance +
//                ", phone='" + phone + '\'' +
//                ", Email='" + Email + '\'' +
//                '}';
//    }
//
//    public String getStudentNo() {
//        return studentNo;
//    }
//
//    public void setStudentNo(String studentNo) {
//        this.studentNo = studentNo;
//    }
//
//    public String getsName() {
//        return sName;
//    }
//
//    public void setsName(String sName) {
//        this.sName = sName;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public LocalDate getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday = birthday;
//    }
//
//    public Integer getEntrance() {
//        return entrance;
//    }
//
//    public void setEntrance(Integer entrance) {
//        this.entrance = entrance;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String email) {
//        Email = email;
//    }
//
//    public Student() {
//    }
//
//    public Student(String studentNo, String sName, String sex, LocalDate birthday, Integer entrance, String phone, String email) {
//        this.studentNo = studentNo;
//        this.sName = sName;
//        this.sex = sex;
//        this.birthday = birthday;
//        this.entrance = entrance;
//        this.phone = phone;
//        Email = email;
//    }
}
