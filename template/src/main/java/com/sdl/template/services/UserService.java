package com.sdl.template.services;

import com.sdl.template.dtos.UserRequest;
import com.sdl.template.dtos.UserResponse;


public interface UserService {

UserResponse calculateAge(UserRequest dob);

}
