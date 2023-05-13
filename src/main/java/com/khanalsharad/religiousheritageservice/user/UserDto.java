package com.khanalsharad.religiousheritageservice.user;

import lombok.Data;

@Data
public class UserDto {
    private String userName;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;
}
