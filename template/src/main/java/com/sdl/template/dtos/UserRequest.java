package com.sdl.template.dtos;

import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRequest {

  @NotNull
  private Timestamp dob;

}
