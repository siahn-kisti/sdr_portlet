package com.sdr.ml.common.util;

import javax.portlet.PortletSession;

public class SessionUtils {

	/**
	 * Potlet Session 추가
	 *
	 * @param session  PortletSession
	 * @param key String
	 * @param value String
	 */
    public static void setPotletSession(PortletSession session, String key, String value){

        session.setAttribute(key,value, PortletSession.PORTLET_SCOPE);
    }

	/**
	 * Potlet Session 반환
	 *
	 * @param session  PortletSession
	 * @param key String
	 *
	 * @return String
	 */
    public static String getPotletSession(PortletSession session, String key){

        String value = (String) session.getAttribute(key, PortletSession.PORTLET_SCOPE);

        if(value == null){
            value = "";
        }

        return value;
    }

	/**
	 * Potlet Session 삭제
	 *
	 * @param session  PortletSession
	 * @param key String
	 */
    public static void removePotletSession(PortletSession session, String key){

        session.removeAttribute(key, PortletSession.PORTLET_SCOPE);
    }







	/**
	 * Application Session 추가
	 *
	 * @param session  PortletSession
	 * @param key String
	 * @param value String
	 */
    public static void setApplicationSession(PortletSession session, String key, String value){

        session.setAttribute(key,value, PortletSession.APPLICATION_SCOPE);
    }

	/**
	 * Application Session 반환
	 *
	 * @param session  PortletSession
	 * @param key String
	 *
	 * @return String
	 */
    public static String getApplicationSession(PortletSession session, String key){

        String value = (String) session.getAttribute(key, PortletSession.APPLICATION_SCOPE);

        if(value == null){
            value = "";
        }

        return value;
    }

	/**
	 * Application Session 삭제
	 *
	 * @param session  PortletSession
	 * @param key String
	 */
    public static void removeApplicationSession(PortletSession session, String key){

        session.removeAttribute(key, PortletSession.APPLICATION_SCOPE);
    }
}
