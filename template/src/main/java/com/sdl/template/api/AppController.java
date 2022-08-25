package com.sdl.template.api;

import com.sdl.template.dtos.ResponseHandler;
import com.sdl.template.dtos.UserRequest;
import com.sdl.template.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

  private final UserService userService;

  public AppController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("howold")
  public ResponseEntity<Object> ageCalculator(@RequestBody UserRequest dob) {

    try{
      return ResponseHandler.apiResponse(HttpStatus.OK, true, "success",
          userService.calculateAge(dob));
    }catch (RuntimeException exception){
      return ResponseHandler.apiResponse(HttpStatus.BAD_REQUEST, true, "fail",
          exception.getLocalizedMessage());
    }

  }

}
