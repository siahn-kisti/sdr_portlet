package com.sdr.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class JunitSample {
	public String getName(User user) throws PortalException, SystemException {
		String name = UserLocalServiceUtil.getUser(user.getUserId()).getFirstName();
		return "Mr "+name;
	}
}
