package com.sdr.guide.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sdr.guide.model.Guide;
import com.sdr.guide.service.GuideLocalServiceUtil;
import com.sdr.guide.service.permission.GuidePermission;

/**
 * Created by heesangbb on 2017. 5. 13..
 */
public class GuideAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = Guide.class.getName();

	public static final String TYPE = "entry";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {

		Guide guide = GuideLocalServiceUtil.getGuide(classPK);

		return new GuideAssetRenderer(guide);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
			throws Exception {

		return GuidePermission.contains(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	private static final boolean _LINKABLE = true;

}
