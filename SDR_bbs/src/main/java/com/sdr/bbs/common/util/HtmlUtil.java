package com.sdr.bbs.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import java.util.ArrayList;
import java.util.List;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

/**
 * The type Html util.
 */
public class HtmlUtil
{
  private static Log _log = LogFactoryUtil.getLog(HtmlUtil.class);

  /**
   * Gets attribute values by tag name.
   *
   * @param html          the html
   * @param tagName       the tag name
   * @param attributeName the attribute name
   * @return the attribute values by tag name
   */
  public static List<String> getAttributeValuesByTagName(String html, String tagName, String attributeName)
  {
    List values = null;

    if ((Validator.isNotNull(html)) && (Validator.isNotNull(tagName)) && (Validator.isNotNull(attributeName))) {
      Source source = new Source(html);
      List<Element> elements = source.getAllElements(tagName);

      if ((Validator.isNotNull(elements)) && (elements.size() > 0)) {
        values = new ArrayList();

        for (Element element : elements) {
          try {
            String attributeValue = element.getAttributeValue(attributeName);

            if (Validator.isNotNull(attributeValue))
              values.add(attributeValue);
            else
              values.add("");
          }
          catch (Exception e)
          {
            if (!_log.isDebugEnabled()) continue; _log.debug(e.toString());
          }
        }
      }
    }

    return values;
  }

  /**
   * Gets first attribute value by tag name.
   *
   * @param html          the html
   * @param tagName       the tag name
   * @param attributeName the attribute name
   * @return the first attribute value by tag name
   */
  public static String getFirstAttributeValueByTagName(String html, String tagName, String attributeName) {
    String value = "";

    if ((Validator.isNotNull(html)) && (Validator.isNotNull(tagName)) && (Validator.isNotNull(attributeName))) {
      Source source = new Source(html);
      List<Element> elements = source.getAllElements(tagName);

      if ((Validator.isNotNull(elements)) && (elements.size() > 0))
      {
        for (Element element : elements) {
          try {
            String attributeValue = element.getAttributeValue(attributeName);

            if (Validator.isNotNull(attributeValue)) {
              value = attributeValue;
            }
          }
          catch (Exception e)
          {
            if (!_log.isDebugEnabled()) continue; _log.debug(e.toString());
          }
        }
      }
    }

    return value;
  }
}