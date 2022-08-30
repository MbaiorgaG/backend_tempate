package com.sdl.template.events;

import org.springframework.context.ApplicationEvent;

public class CalculateAgeEvent extends ApplicationEvent {



  public CalculateAgeEvent(Object source) {
    super(source);
  }
}
