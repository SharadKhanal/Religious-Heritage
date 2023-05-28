package com.khanalsharad.religiousheritageservice.core;

import com.khanalsharad.religiousheritageservice.user.UserResponseDto;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Data
@Component

public class BaseController<E,ID> {
//    private repository Repository;
//
//    @PostMapping
//    public UserResponseDto save( E e){
//    E savedEntity =repository.save(e);
//
//    }
}
