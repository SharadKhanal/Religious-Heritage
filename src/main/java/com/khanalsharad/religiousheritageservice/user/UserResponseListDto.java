package com.khanalsharad.religiousheritageservice.user;


import lombok.Data;

import java.util.List;
@Data
public class UserResponseListDto {
   private List<UserResponseDto> users;
    private long total;
}
