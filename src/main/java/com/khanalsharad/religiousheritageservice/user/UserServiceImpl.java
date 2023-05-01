package com.khanalsharad.religiousheritageservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        User user =new User();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User savedUser = userRepository.save(user);
        return getUserResponse(savedUser);
    }

    public UserResponseDto getUserResponse(User user){
        UserResponseDto response = new UserResponseDto();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setAddress(user.getAddress());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEmail(user.getEmail());
    return response;
    }
    @Override
    public UserResponseListDto getUsers() {
        List<UserResponseDto> userResponseDto =new ArrayList<>();
        List<User>users = userRepository.findAll();

        for(User user: users){
            userResponseDto.add(getUserResponse(user));
        }

        UserResponseListDto response = new UserResponseListDto();
        response.setUsers(userResponseDto);

        response.setTotal(userResponseDto.size());

        return response;
    }

    @Override
    public UserResponseDto updateUser(long id, User user) {
        Optional<User>optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user1=optionalUser.get();
            user1.setName(user.getName());
            user1.setAddress(user.getAddress());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setEmail(user.getEmail());

            User savedUser= userRepository.save(user1);
            return getUserResponse(savedUser);

        }

        return null;
    }

    @Override
    public UserResponseDto findByUserId(long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
         return getUserResponse(user.get());
        }
        else{
            System.out.println("oops user not found!!!");
        }
        return null;
    }

    @Override
    public UserResponseDto deleteUserById(long id) throws Exception{
        Optional<User> user =userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
        }else
        {
            throw new Exception ("oops user cant be deleted!!!");
        }
        return  null;
    }


}
