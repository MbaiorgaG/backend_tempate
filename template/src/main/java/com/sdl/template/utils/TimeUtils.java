package com.sdl.template.utils;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeUtils {


  public static LocalDate dateFromTimeStamp(Timestamp date){
    LocalDateTime dateTime = date.toLocalDateTime();
    return dateTime.toLocalDate();
  }

}
