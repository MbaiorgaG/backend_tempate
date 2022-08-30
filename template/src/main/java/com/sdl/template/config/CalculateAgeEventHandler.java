package com.sdl.template.config;

import com.sdl.template.events.CalculateAgeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalculateAgeEventHandler implements ApplicationListener<CalculateAgeEvent> {

  private final Logger logger = LoggerFactory.getLogger(getClass());


  @Override
  public void onApplicationEvent(CalculateAgeEvent event) {
    logger.info("On Calculate Age publish this event", event.toString());
  }
}
