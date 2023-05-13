package com.khanalsharad.religiousheritageservice.user;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("religious-heritage/user")
public class UserController {
    public final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private Object requireNoNull(Object o){
    if(ObjectUtils.isEmpty(o)){
        return null;
    }
    return o;
    }

    @PostMapping
    public UserResponseDto saveUser(@RequestBody UserDto userDto){
    return userService.saveUser(userDto);
    }
    @GetMapping
    public UserResponseListDto getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable("id")long id){
        return userService.findByUserId(id);
    }
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable("id") long id, @RequestBody User user){
    return userService.updateUser(id,user);
    }

    @DeleteMapping("/delete/{id}")
    public UserResponseDto deleteUser(@PathVariable("id") long id) throws Exception{
        return userService.deleteUserById(id);
    }
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request){
        return userService.login(request);
    }

    @PostMapping("/logout")
    public LogoutResponseDto logout(@RequestBody LogoutRequestDto logoutRequestDto){
        return userService.logout(logoutRequestDto);
    }
}
