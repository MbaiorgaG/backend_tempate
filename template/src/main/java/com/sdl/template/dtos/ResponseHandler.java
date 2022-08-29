package com.sdl.template.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@JsonInclude(Include.NON_NULL)
public class ResponseHandler {

  private HttpStatus status;

  private  boolean error;

  private String message;

  private  Object data;

  public ResponseHandler(HttpStatus status) {
    this.status = status;
  }

  public ResponseHandler(HttpStatus status, boolean error, String message, Object data) {
    this.status = status;
    this.error = error;
    this.message = message;
    this.data = data;
  }

  public ResponseHandler(HttpStatus status, String message, Object data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public ResponseHandler(HttpStatus status, boolean error, Object data) {
    this.status = status;
    this.error = error;
    this.data = data;
  }

  public ResponseHandler(HttpStatus status, boolean error, String message) {
    this.status = status;
    this.error = error;
    this.message = message;
  }

}
