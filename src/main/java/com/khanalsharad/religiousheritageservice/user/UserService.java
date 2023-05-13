package com.khanalsharad.religiousheritageservice.user;

public interface UserService {

    UserResponseDto saveUser(UserDto userDto);

    UserResponseListDto getUsers();

    UserResponseDto updateUser(long id, User user);

    UserResponseDto findByUserId(long id);

    UserResponseDto deleteUserById(long id) throws Exception;

    LoginResponseDto login(LoginRequestDto request);

    LogoutResponseDto logout(LogoutRequestDto logoutRequestDto);
}
