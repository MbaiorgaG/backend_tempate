package com.sdl.template.services;

import com.sdl.template.dtos.UserRequest;
import com.sdl.template.dtos.UserResponse;
import com.sdl.template.utils.TimeUtils;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


  @Override
  public UserResponse calculateAge(UserRequest dob) {
    LocalDate localDate = TimeUtils.dateFromTimeStamp(dob.getDob());
    LocalDate currentDate = LocalDate.now();
    int years = Period.between(localDate, currentDate).getYears();
    return new UserResponse(years);
  }
}
