package com.sdr.common.util;

import com.liferay.util.portlet.PortletProps;

public class SimulationConstants {
	public static final String ICEBREAKER_URL = PortletProps.get("icebreakerUrl");
	public static final String ICEBREAKER_ZONE = PortletProps.get("icebreakerZone");
	public static final long SOLVER_ID = Long.parseLong(PortletProps.get("solverId"));
	public static final String SOLVER_NAME = PortletProps.get("solverName");;
	public static final String SOLVER_VERSION = PortletProps.get("solverVersion");
	public static final long NANO_GROUP = Long.parseLong(PortletProps.get("nanoGroup"));
	public static final String CLUSTER = PortletProps.get("cluster");
	public static final String ICEBREAKER_ADMIN_ID = PortletProps.get("icebreakerAdminId");
	public static final String ICEBREAKER_ADMIN_PWD = PortletProps.get("icebreakerAdminPwd");
	public static final String ICEBREAKER_USER_ID = PortletProps.get("icebreakerUserId");
	public static final String ICEBREAKER_USER_PWD = PortletProps.get("icebreakerUserPwd");
	
	public static final String _STATUS_SAVED = "SAVED";
	public static final String _STATUS_QUEUED = "QUEUED";
	public static final String _STATUS_RUNNING = "RUNNING";
	public static final String _STATUS_COMPLTE = "COMPLTE";
	public static final String _STATUS_SUCCESS = "SUCCESS";
	public static final String _STATUS_FAILED = "FAILED";
	public static final String _STATUS_CANCELED = "CANCELED";
	
	public static final String EDISON_URL = PortletProps.get("edisonUrl");
}
