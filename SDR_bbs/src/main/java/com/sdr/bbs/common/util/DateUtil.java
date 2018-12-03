package com.sdr.bbs.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.theme.ThemeDisplay;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;

/**
 * The type Date util.
 */
public class DateUtil
{
  private static final String _SIMPLE_DATE_FORMAT_PATTERN_DMY = "dd/MM/yyyy";
  private static final String _SIMPLE_DATE_FORMAT_PATTERN_HTML5 = "yyyy-MM-dd";
  private static final String _SIMPLE_DATE_FORMAT_PATTERN_MDY = "MM/dd/yyyy";
  private static final String _SIMPLE_DATE_FORMAT_PATTERN_YMD = "yyyy/MM/dd";
  private static final String _MASK_DMY = "%d/%m/%Y";
  private static final String _MASK_MDY = "%m/%d/%Y";
  private static final String _MASK_YMD = "%Y/%m/%d";
  private static final String _SIMPLE_DATE_FORMAT_PATTERN_DMY_WITHOUT_YEAR = "dd/MM";
  private static final String _SIMPLE_DATE_FORMAT_PATTERN_HTML5_WITHOUT_YEAR = "MM-dd";
  private static final String _SIMPLE_DATE_FORMAT_PATTERN_MDY_WITHOUT_YEAR = "MM/dd";
  private static final String _SIMPLE_DATE_FORMAT_PATTERN_YMD_WITHOUT_YEAR = "MM/dd";
  private static final String _MASK_DMY_WITHOUT_YEAR = "%d/%m";
  private static final String _MASK_MDY_WITHOUT_YEAR = "%m/%d";
  private static final String _MASK_YMD_WITHOUT_YEAR = "%m/%d";
  private static Log _log = LogFactoryUtil.getLog(DateUtil.class);

  /**
   * Gets date formatted string.
   *
   * @param themeDisplay the theme display
   * @param request      the request
   * @param date         the date
   * @return the date formatted string
   */
  public static String getDateFormattedString(ThemeDisplay themeDisplay, HttpServletRequest request, Date date)
  {
    String formattedString = "";

    Format format = getDateFormat(themeDisplay, request);

    formattedString = format.format(date);

    return formattedString;
  }

  /**
   * Gets date formatted string without year.
   *
   * @param themeDisplay the theme display
   * @param request      the request
   * @param date         the date
   * @return the date formatted string without year
   */
  public static String getDateFormattedStringWithoutYear(ThemeDisplay themeDisplay, HttpServletRequest request, Date date)
  {
    String formattedString = "";

    Format format = getDateFormatWithoutYear(themeDisplay, request);

    formattedString = format.format(date);

    return formattedString;
  }

  /**
   * Gets date formatted string.
   *
   * @param themeDisplay the theme display
   * @param request      the request
   * @param cal          the cal
   * @return the date formatted string
   */
  public static String getDateFormattedString(ThemeDisplay themeDisplay, HttpServletRequest request, Calendar cal)
  {
    String formattedString = "";

    Format format = getDateFormat(themeDisplay, request);

    formattedString = format.format(cal.getTime());

    return formattedString;
  }

  /**
   * Gets date formatted string without year.
   *
   * @param themeDisplay the theme display
   * @param request      the request
   * @param cal          the cal
   * @return the date formatted string without year
   */
  public static String getDateFormattedStringWithoutYear(ThemeDisplay themeDisplay, HttpServletRequest request, Calendar cal)
  {
    String formattedString = "";

    Format format = getDateFormatWithoutYear(themeDisplay, request);

    formattedString = format.format(cal.getTime());

    return formattedString;
  }

  /**
   * Gets date format.
   *
   * @param themeDisplay the theme display
   * @param request      the request
   * @return the date format
   */
  public static Format getDateFormat(ThemeDisplay themeDisplay, HttpServletRequest request)
  {
    Format format = null;

    String simpleDateFormatPattern = "MM/dd/yyyy";

    if (BrowserSnifferUtil.isMobile(request)) {
      simpleDateFormatPattern = "yyyy-MM-dd";
    } else {
      DateFormat shortDateFormat = DateFormat.getDateInstance(3, themeDisplay.getLocale());

      SimpleDateFormat shortDateFormatSimpleDateFormat = (SimpleDateFormat)shortDateFormat;

      String shortDateFormatSimpleDateFormatPattern = shortDateFormatSimpleDateFormat.toPattern();

      if (shortDateFormatSimpleDateFormatPattern.indexOf("y") == 0)
        simpleDateFormatPattern = "yyyy/MM/dd";
      else if (shortDateFormatSimpleDateFormatPattern.indexOf("d") == 0) {
        simpleDateFormatPattern = "dd/MM/yyyy";
      }
    }

    format = new SimpleDateFormat(simpleDateFormatPattern);

    return format;
  }

  /**
   * Gets date format without year.
   *
   * @param themeDisplay the theme display
   * @param request      the request
   * @return the date format without year
   */
  public static Format getDateFormatWithoutYear(ThemeDisplay themeDisplay, HttpServletRequest request)
  {
    Format format = null;

    String simpleDateFormatPattern = "MM/dd";

    if (BrowserSnifferUtil.isMobile(request)) {
      simpleDateFormatPattern = "MM-dd";
    } else {
      DateFormat shortDateFormat = DateFormat.getDateInstance(3, themeDisplay.getLocale());

      SimpleDateFormat shortDateFormatSimpleDateFormat = (SimpleDateFormat)shortDateFormat;

      String shortDateFormatSimpleDateFormatPattern = shortDateFormatSimpleDateFormat.toPattern();

      if (shortDateFormatSimpleDateFormatPattern.indexOf("y") == 0)
        simpleDateFormatPattern = "MM/dd";
      else if (shortDateFormatSimpleDateFormatPattern.indexOf("d") == 0) {
        simpleDateFormatPattern = "dd/MM";
      }
    }

    format = new SimpleDateFormat(simpleDateFormatPattern);

    return format;
  }

  /**
   * Gets date mask.
   *
   * @param themeDisplay the theme display
   * @param request      the request
   * @return the date mask
   */
  public static String getDateMask(ThemeDisplay themeDisplay, HttpServletRequest request)
  {
    String mask = "%m/%d/%Y";

    if (!BrowserSnifferUtil.isMobile(request)) {
      DateFormat shortDateFormat = DateFormat.getDateInstance(3, themeDisplay.getLocale());

      SimpleDateFormat shortDateFormatSimpleDateFormat = (SimpleDateFormat)shortDateFormat;

      String shortDateFormatSimpleDateFormatPattern = shortDateFormatSimpleDateFormat.toPattern();

      if (shortDateFormatSimpleDateFormatPattern.indexOf("y") == 0)
        mask = "%Y/%m/%d";
      else if (shortDateFormatSimpleDateFormatPattern.indexOf("d") == 0) {
        mask = "%d/%m/%Y";
      }
    }

    return mask;
  }

  /**
   * Gets date mask without year.
   *
   * @param themeDisplay the theme display
   * @param request      the request
   * @return the date mask without year
   */
  public static String getDateMaskWithoutYear(ThemeDisplay themeDisplay, HttpServletRequest request)
  {
    String mask = "%m/%d";

    if (!BrowserSnifferUtil.isMobile(request)) {
      DateFormat shortDateFormat = DateFormat.getDateInstance(3, themeDisplay.getLocale());

      SimpleDateFormat shortDateFormatSimpleDateFormat = (SimpleDateFormat)shortDateFormat;

      String shortDateFormatSimpleDateFormatPattern = shortDateFormatSimpleDateFormat.toPattern();

      if (shortDateFormatSimpleDateFormatPattern.indexOf("y") == 0)
        mask = "%m/%d";
      else if (shortDateFormatSimpleDateFormatPattern.indexOf("d") == 0) {
        mask = "%d/%m";
      }
    }

    return mask;
  }

  /**
   * Gets calendar.
   *
   * @param year         the year
   * @param month        the month
   * @param day          the day
   * @param hour         the hour
   * @param minutes      the minutes
   * @param seconds      the seconds
   * @param milliseconds the milliseconds
   * @param timeZone     the time zone
   * @return the calendar
   */
  public static Calendar getCalendar(int year, int month, int day, int hour, int minutes, int seconds, int milliseconds, TimeZone timeZone)
  {
    Calendar cal = CalendarFactoryUtil.getCalendar(timeZone);

    cal.set(1, year);
    cal.set(2, month);
    cal.set(5, day);
    cal.set(11, hour);
    cal.set(12, minutes);
    cal.set(13, seconds);
    cal.set(14, milliseconds);

    return cal;
  }

  /**
   * Is between boolean.
   *
   * @param betweenDate the between date
   * @param minDate     the min date
   * @param maxDate     the max date
   * @return the boolean
   */
  public static boolean isBetween(Date betweenDate, Date minDate, Date maxDate) {
    boolean isBetween = false;
    boolean isGreaterThanOrEqual = false;
    boolean isLessThanOrEqual = false;

    if (betweenDate.compareTo(minDate) >= 0) isGreaterThanOrEqual = true;
    if (betweenDate.compareTo(maxDate) <= 0) isLessThanOrEqual = true;

    isBetween = (isGreaterThanOrEqual) && (isLessThanOrEqual);

    return isBetween;
  }

  /**
   * Is between without time boolean.
   *
   * @param betweenDate the between date
   * @param minDate     the min date
   * @param maxDate     the max date
   * @return the boolean
   */
  public static boolean isBetweenWithoutTime(Date betweenDate, Date minDate, Date maxDate) {
    boolean isBetween = false;
    boolean isGreaterThanOrEqual = false;
    boolean isLessThanOrEqual = false;

    Calendar minCal = CalendarFactoryUtil.getCalendar();
    Calendar maxCal = CalendarFactoryUtil.getCalendar();

    minCal.setTime(minDate);
    minCal.set(11, 0);
    minCal.set(12, 0);
    minCal.set(13, 1);
    minCal.set(14, 0);

    maxCal.setTime(maxDate);
    maxCal.set(11, 23);
    maxCal.set(12, 59);
    maxCal.set(13, 59);
    maxCal.set(14, 0);

    minDate = minCal.getTime();
    maxDate = maxCal.getTime();

    if (betweenDate.compareTo(minDate) >= 0) isGreaterThanOrEqual = true;
    if (betweenDate.compareTo(maxDate) <= 0) isLessThanOrEqual = true;

    isBetween = (isGreaterThanOrEqual) && (isLessThanOrEqual);

    return isBetween;
  }

  /**
   * Gets date diff.
   *
   * @param date1    the date 1
   * @param date2    the date 2
   * @param timeUnit the time unit
   * @return the date diff
   */
  public static int getDateDiff(Date date1, Date date2, String timeUnit) {
    Long diff = Long.valueOf(0L);

    TimeUnit tu = null;

    if (timeUnit.equals("days"))
      tu = TimeUnit.DAYS;
    else if (timeUnit.equals("hours"))
      tu = TimeUnit.HOURS;
    else if (timeUnit.equals("minutes"))
      tu = TimeUnit.MINUTES;
    else if (timeUnit.equals("seconds"))
      tu = TimeUnit.SECONDS;
    else {
      tu = TimeUnit.DAYS;
    }

    diff = Long.valueOf(tu.convert(date2.getTime() - date1.getTime(), TimeUnit.MILLISECONDS));

    return diff.intValue();
  }
}