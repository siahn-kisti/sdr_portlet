package com.sdr.bbs.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * The type String util.
 */
public class StringUtil
{
  private static Log _log = LogFactoryUtil.getLog(StringUtil.class);

  /**
   * Get string array from string string [ ].
   *
   * @param string    the string
   * @param delimeter the delimeter
   * @return the string [ ]
   */
  public static String[] getStringArrayFromString(String string, String delimeter)
  {
    String[] strings = string.split(delimeter);

    for (int i = 0; i < strings.length; i++) {
      strings[i] = strings[i].trim();
    }

    return strings;
  }

  /**
   * Gets string list from string.
   *
   * @param string    the string
   * @param delimeter the delimeter
   * @return the string list from string
   */
  public static List<String> getStringListFromString(String string, String delimeter) {
    List strings = new ArrayList();

    if (Validator.isNotNull(string)) {
      String[] stringArray = getStringArrayFromString(string, delimeter);

      for (int i = 0; i < stringArray.length; i++) {
        strings.add(stringArray[i]);
      }
    }

    return strings;
  }

  /**
   * Gets string from string list.
   *
   * @param strings   the strings
   * @param delimeter the delimeter
   * @return the string from string list
   */
  public static String getStringFromStringList(List<String> strings, String delimeter) {
    String string = "";

    boolean isFirst = true;

    if ((Validator.isNotNull(strings)) && (strings.size() > 0)) {
      for (int i = 0; i < strings.size(); i++) {
        if (Validator.isNotNull((String)strings.get(i))) {
          if (isFirst) {
            string = (String)strings.get(i);
            isFirst = false;
          } else {
            string = string + delimeter + (String)strings.get(i);
          }
        }
      }
    }

    return string;
  }

  /**
   * Gets string from long list.
   *
   * @param longs     the longs
   * @param delimeter the delimeter
   * @return the string from long list
   */
  public static String getStringFromLongList(List<Long> longs, String delimeter) {
    String string = "";

    boolean isFirst = true;

    if ((Validator.isNotNull(longs)) && (longs.size() > 0)) {
      for (int i = 0; i < longs.size(); i++) {
        if (isFirst) {
          string = String.valueOf(longs.get(i));
          isFirst = false;
        } else {
          string = string + delimeter + String.valueOf(longs.get(i));
        }
      }
    }

    return string;
  }
}