package com.khanalsharad.religiousheritageservice.user;

import com.khanalsharad.religiousheritageservice.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User extends BaseEntity<Long>{
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private long id;
 private String userName;
 private String address;
 private String email;
 private String phoneNumber;
 private String password;
  private boolean loggedIn;
}
