package com.sdl.template.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;


public class UserResponse {

  private int years;

  public UserResponse(int years) {
    this.years = years;
  }

  public int getYears() {
    return years;
  }

  public void setYears(int years) {
    this.years = years;
  }


  @Override
  public String toString() {
    return "UserResponse{" +
        years + "years" +
        '}';
  }
}
