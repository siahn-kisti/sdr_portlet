/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sdr.common.model;

/**
 * Contains constants used by roles, including the names of the default roles
 * and the role types.
 *
 * @author Brian Wing Shun Chan
 */
public class EdisonRoleConstants {

	public static final String ADMINISTRATOR = "Administrator";

	public static final String GUEST = "Guest";

	public static final String ORGANIZATION_ADMINISTRATOR =
		"Organization Administrator";

	public static final String ORGANIZATION_OWNER = "Organization Owner";

	public static final String ORGANIZATION_USER = "Organization User";

	public static final String OWNER = "Owner";

	public static final String PORTAL_CONTENT_REVIEWER =
		"Portal Content Reviewer";

	public static final String POWER_USER = "Power User";

	public static final String SITE_ADMINISTRATOR = "Site Administrator";

	public static final String SITE_CONTENT_REVIEWER = "Site Content Reviewer";

	public static final String SITE_MEMBER = "Site Member";

	public static final String SITE_OWNER = "Site Owner";

	public static final String[] SYSTEM_ORGANIZATION_ROLES = {
		ORGANIZATION_ADMINISTRATOR, ORGANIZATION_OWNER, ORGANIZATION_USER
	};

	public static final String[] SYSTEM_ROLES = {
		ADMINISTRATOR, GUEST, OWNER, POWER_USER, EdisonRoleConstants.USER, EdisonRoleConstants.TUTOR, EdisonRoleConstants.DEVELOPER, EdisonRoleConstants.STUDENT, EdisonRoleConstants.TEMP_USER, EdisonRoleConstants.PROFESSOR
	};

	public static final String[] SYSTEM_SITE_ROLES = {
		SITE_ADMINISTRATOR, SITE_MEMBER, SITE_OWNER, EdisonRoleConstants.VIRTUAL_LAB_OWNER, EdisonRoleConstants.VIRTUAL_LAB_MANAGER, EdisonRoleConstants.VIRTUAL_CLASS_OWNER, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER, EdisonRoleConstants.VIRTUAL_CLASS_MEMBER, EdisonRoleConstants.SOLVER_OWNER, EdisonRoleConstants.SOLVER_MANAGER,
		EdisonRoleConstants.CONTENT_OWNER, EdisonRoleConstants.CONTENT_MANAGER
	};

	public static final int TYPE_ORGANIZATION = 3;

	public static final String TYPE_ORGANIZATION_LABEL = "organization";

	public static final int TYPE_PROVIDER = 4;

	public static final int TYPE_REGULAR = 1;

	public static final String TYPE_REGULAR_LABEL = "regular";

	public static final int TYPE_SITE = 2;

	public static final String TYPE_SITE_LABEL = "site";

	public static final int[] TYPES_ORGANIZATION_AND_REGULAR =
		{TYPE_REGULAR, TYPE_ORGANIZATION};

	public static final int[] TYPES_ORGANIZATION_AND_REGULAR_AND_SITE = {
		TYPE_REGULAR, TYPE_ORGANIZATION, TYPE_SITE
	};

	public static final int[] TYPES_REGULAR = {TYPE_REGULAR};

	public static final int[] TYPES_REGULAR_AND_SITE =
		{TYPE_REGULAR, TYPE_SITE};

	public static final String USER = "User";

	public static String getTypeLabel(int type) {
		if (type == TYPE_ORGANIZATION) {
			return TYPE_ORGANIZATION_LABEL;
		}
		else if (type == TYPE_SITE) {
			return TYPE_SITE_LABEL;
		}
		else {
			return TYPE_REGULAR_LABEL;
		}
	}
	
	
	/*
	 * EDISON  USER Role
	 */
	//Regular Role
	public static final String TUTOR = "Tutor";
	
	public static final String DEVELOPER = "Developer";
	
	public static final String STUDENT = "Student";
	
	public static final String TEMP_USER = "Temp User";
	
	public static final String PROJECT = "Project";
	
	public static final String PROFESSOR = "Professor";
	
	//Site Role
	public static final String VIRTUAL_LAB_OWNER 		= "Virtual Lab Owner";
	
	public static final String VIRTUAL_LAB_MANAGER 		= "Virtual Lab Manager";
	
	public static final String VIRTUAL_CLASS_OWNER 		= "Virtual Class Owner";
	
	public static final String VIRTUAL_CLASS_MANAGER 	= "Virtual Class Manager";
	
	public static final String VIRTUAL_CLASS_MEMBER 	= "virtual Class Member";
	
	public static final String SOLVER_OWNER 			= "Solver Owner";
	
	public static final String SOLVER_MANAGER 			= "Solver Manager";
	
	public static final String CONTENT_OWNER 			= "Content Owner";
	
	public static final String CONTENT_MANAGER 			= "Content Manager";
	
	
	//Groups
	public static final String TUTOR_GROUP 		= "TUTOR_GROUP";
	
	public static final String DEVELOPER_GROUP 		= "DEVELOPER_GROUP";
	
	public static final String STUDENT_GROUP 		= "STUDENT_GROUP";
	
	public static final String PROJECT_GROUP 		= "PROJECT_GROUP";

}