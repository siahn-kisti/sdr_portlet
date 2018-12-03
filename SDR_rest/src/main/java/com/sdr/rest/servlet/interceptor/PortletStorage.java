package com.sdr.rest.servlet.interceptor;

import java.util.HashMap;

public class PortletStorage
{
	private static PortletStorage                        instance    = null;
	private HashMap<String, HashMap<String, Object>>    storage        = null;

	private PortletStorage()
	{
		storage = new HashMap<String, HashMap<String, Object>>();
	}

	public static PortletStorage getInstance()
	{
		if (instance == null)
			instance = new PortletStorage();

		return instance;
	}

	public void setValue(String sessionId, String key, Object value)
	{
		HashMap<String, Object> sessionValueMap = storage.get(sessionId);

		boolean isNew = sessionValueMap == null;
		if (isNew)
			sessionValueMap = new HashMap<String, Object>();

		sessionValueMap.put(key, value);
		if (isNew)
			storage.put(sessionId, sessionValueMap);
	}

	public Object getValue(String sessionId, String key)
	{
		HashMap<String, Object> sessionValueMap = storage.get(sessionId);

		if (sessionValueMap == null)
			return null;

		return sessionValueMap.get(key);
	}

	public void clearSession(String sessionId)
	{
		storage.remove(sessionId);
	}
}