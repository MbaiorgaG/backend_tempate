package com.sdl.template.config;


import com.google.common.util.concurrent.RateLimiter;
import java.time.Duration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemplateConfiguration {

  @Bean
  public RateLimiter rateLimiter(){
    return RateLimiter.create(0.03d, Duration.ofSeconds(10));
  }

}
