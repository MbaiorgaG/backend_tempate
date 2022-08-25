package com.sdl.template.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;

class TimeUtilsTest {

  @Test
  public void calculate_localDate_from_dateTimeStamp(){
    String date = "1990-07-10 13:27:27.16";
    Timestamp timestamp = Timestamp.valueOf(date);
    LocalDate expected = LocalDate.of(1990, Month.JULY, 10);
    LocalDate actual = TimeUtils.dateFromTimeStamp(timestamp);
    assertEquals(expected, actual);

  }


  @Test
  public void validate_timeStamp(){
    String date = "1990-07-10 13:00:27.16";
    Timestamp timestamp = Timestamp.valueOf(date);
    boolean actual = TimeUtils.isTimeStampValid(timestamp);
    assertEquals(true, actual);
  }


}