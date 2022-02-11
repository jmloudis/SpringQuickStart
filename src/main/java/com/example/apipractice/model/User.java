package com.example.apipractice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

@Slf4j
@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long uid;

//    @Column(name = "first", nullable = false, length = 45)
//    private String firstName;
//
//    @Column(name = "last", nullable = false, length = 45)
//    private String lastName;

//    @Column(name = "email", unique = true, length = 45)
//    private String emailAddress;

//    @Column(name = "phone_num", length = 10)
//    private String phoneNumber;
//
//    @Column(name = "dob", length = 10)
//    private String dateOfBirth;
//
//    @Column(name = "address", length = 75)
//    private String address;
//
//    @Column(name = "state", length = 25)
//    private String state;
//
//    @Column(name = "zip_code", length = 5)
//    private String zipCode;

    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", length = 25)
    private String role = "ROLE_USER";

    @Column(name = "enabled")
    private boolean enabled = true;

    @Override
    public String toString() {
        return "User{" +
                "userID=" + uid +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
                ", username= '" + username + '\'' +
                ", role= '" + role + '\'' +
                '}';
    }
}
