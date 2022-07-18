//package com.example.springboot2.model;
//
//import javax.persistence.*;
//
//@Entity
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false, unique = true)
//    private String code;
//
//    @Column(nullable = false, length = 30)
//    private String name;
//
//    @Column(nullable = false, length = 30)
//    private String address;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false, unique = true)
//    private String phone;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getMa() {
//        return code;
//    }
//
//    public void setMa(String ma) {
//        this.code = ma;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSdt() {
//        return phone;
//    }
//    public void setSdt(String sdt) {
//        this.phone = sdt;
//    }
//}
