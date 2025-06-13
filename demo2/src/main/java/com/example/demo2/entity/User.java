package com.example.demo2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user4")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",  nullable = false, unique = true)
    private String userName;

    private String email;

    private Integer age;

    public User(String userName, String email, Integer age){
        this.userName = userName;
        this.email = email;
        this.age = age;
    }
}
