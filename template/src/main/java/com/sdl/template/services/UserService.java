package com.sdl.template.services;

import com.sdl.template.dtos.UserRequest;
import com.sdl.template.dtos.UserResponse;
import java.sql.Timestamp;
import org.springframework.http.ResponseEntity;

public interface UserService {

UserResponse calculateAge(UserRequest dob);

}
