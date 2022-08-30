package com.sdl.template.api;

import com.google.common.util.concurrent.RateLimiter;
import com.sdl.template.config.CalculateAgeEventPublisher;
import com.sdl.template.dtos.ResponseHandler;
import com.sdl.template.dtos.UserRequest;
import com.sdl.template.dtos.UserResponse;
import com.sdl.template.events.CalculateAgeEvent;
import com.sdl.template.services.UserService;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class AppController {
final Logger logger = LoggerFactory.getLogger(getClass());
  private final UserService userService;
  private final CalculateAgeEventPublisher eventPublisher;

  private final RateLimiter rateLimiter;

  public AppController(UserService userService, CalculateAgeEventPublisher eventPublisher,
      RateLimiter rateLimiter) {
    this.userService = userService;
    this.eventPublisher = eventPublisher;
    this.rateLimiter = rateLimiter;
  }

  @GetMapping("howold")
  public ResponseHandler ageCalculator(@RequestBody UserRequest dob, HttpServletRequest request) {
    logger.info("request IP Address {}", request.getLocalPort());
    boolean isOk = rateLimiter.tryAcquire();
    if(isOk){
      try {

        UserResponse responseData = userService.calculateAge(dob);
        eventPublisher.publish(new CalculateAgeEvent(responseData));
        return new ResponseHandler(HttpStatus.OK, false, "success",
            responseData);
      } catch (RuntimeException exception) {
        eventPublisher.publish(new CalculateAgeEvent(exception.getLocalizedMessage()));
        return new ResponseHandler(HttpStatus.BAD_REQUEST, true, "Invalid request",
            exception.getLocalizedMessage());
      }
    }
    else
      return new ResponseHandler(HttpStatus.TOO_MANY_REQUESTS, true, "Only 1 request is allowed in 20 secs");
  }



}
