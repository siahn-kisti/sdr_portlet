package com.sdr.metadata.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sdr.metadata.model.Dataset;

public class DatasetAssetRenderer extends BaseAssetRenderer {

	private Dataset _dataset;
	
	public DatasetAssetRenderer (Dataset dataset) {
		_dataset = dataset;
	}
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return Dataset.class.getName();
	}

	public long getClassPK() {
		// TODO Auto-generated method stub
		return _dataset.getDatasetId();
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return _dataset.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		// TODO Auto-generated method stub
		return "Title: " + _dataset.getTitle();
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return _dataset.getTitle();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return _dataset.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		
		try {
			return UserLocalServiceUtil.getUser(_dataset.getUserId()).getScreenName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return "ERROR";
		}
	}

	@Override
	public String getUuid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template)
			throws Exception {
		// TODO Auto-generated method stub
		if(template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("sdr_dataset", _dataset);
			//  /html/[PORTLET_PATH]/[VIEW PAGE].jsp
			return "/assetPage/dataset";
		}
		else {
			return null;
		}
	}
	
	private Log _log;
}
