package com.example.springboot2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_roles")
public class UserRoles {

    @Basic
    @Column(name = "user_id")
    private int userId;

    @Basic
    @Column(name = "role_id")
    private int roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
}
