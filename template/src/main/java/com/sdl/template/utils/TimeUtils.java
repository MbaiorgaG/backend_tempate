package com.sdl.template.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class TimeUtils {


  public static LocalDate dateFromTimeStamp(Timestamp date) {
    LocalDateTime dateTime = date.toLocalDateTime();
    return dateTime.toLocalDate();
  }

  public static boolean isTimeStampValid(Timestamp inputString) {
    SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
    try {
      format.parse(inputString.toString());
      Pattern p = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}[.]?\\d{1,6}$");
      return p.matcher(inputString.toString()).matches();
    } catch (ParseException e) {
      return false;
    }
  }

}
