package com.sdl.template.config;

import com.sdl.template.events.CalculateAgeEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class CalculateAgeEventPublisher implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher publisher;


  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.publisher = applicationEventPublisher;
  }

  public void publish(CalculateAgeEvent event){
    this.publisher.publishEvent(event);
  }
}
