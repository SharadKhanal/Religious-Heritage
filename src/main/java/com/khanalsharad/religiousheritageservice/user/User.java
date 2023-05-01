package com.khanalsharad.religiousheritageservice.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
 private String name;
 private String address;
 private String email;
 private String phoneNumber;
 private String password;
}
