package com.khanalsharad.religiousheritageservice.user;

import lombok.Data;

@Data

public class UserResponseDto {
    private Long id;
    private String userName;
    private String address;
    private String email;
    private String phoneNumber;
}
