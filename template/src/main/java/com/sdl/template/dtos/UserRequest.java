package com.sdl.template.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

  @NotNull
  @JsonFormat(shape= Shape.BINARY, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
  private Timestamp dob;



}
