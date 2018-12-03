package com.sdr.guide.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sdr.guide.model.Guide;
import com.sdr.guide.service.permission.GuidePermission;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Locale;

/**
 * Created by heesangbb on 2017. 5. 13..
 */
public class GuideAssetRenderer extends BaseAssetRenderer {


	private Guide _guide;

	public GuideAssetRenderer(Guide guide) {

		_guide = guide;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {

		long guideId = _guide.getDatasetId();

		boolean contains = false;

		try {
			contains = GuidePermission.contains(permissionChecker, guideId, ActionKeys.UPDATE);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}

		return contains;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {

		long guideId = _guide.getDatasetId();

		boolean contains = false;

		try {
			contains = GuidePermission.contains(permissionChecker,
					guideId, ActionKeys.VIEW);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}

		return contains;
	}

	@Override
	public String getClassName() {
		return Guide.class.getName();
	}

	@Override
	public long getClassPK() {
		return _guide.getDatasetId();
	}

	@Override
	public long getGroupId() {
		return _guide.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return "Name: " + _guide.getTitle() + ". Message: "
				+ _guide.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {
		return _guide.getTitle();
	}

	@Override
	public long getUserId() {
		return _guide.getUserId();
	}

	@Override
	public String getUserName() {
		return _guide.getUserName();
	}

	@Override
	public String getUuid() {
		return _guide.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest,
						 RenderResponse renderResponse, String template) throws Exception {

		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("gb_guide", _guide);

			return "/html/guestbook/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	private Log _log;
}
