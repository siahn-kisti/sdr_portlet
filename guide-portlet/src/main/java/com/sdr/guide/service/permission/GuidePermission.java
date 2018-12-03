package com.sdr.guide.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.sdr.guide.model.Guide;

/**
 * Created by heesangbb on 2017. 5. 12..
 */
public class GuidePermission {

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, String actionId)
			throws PortalException, SystemException {

		return permissionChecker
				.hasPermission(groupId, Guide.class.getName(), groupId, actionId);
	}
}
