package com.sdr.metadata.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sdr.metadata.model.Collection;

public class CollectionAssetRenderer  extends BaseAssetRenderer {

private Collection _collection;
	
	public CollectionAssetRenderer (Collection collection) {
		_collection = collection;
	}
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return Collection.class.getName();
	}

	public long getClassPK() {
		// TODO Auto-generated method stub
		return _collection.getCollectionId();
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return _collection.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		// TODO Auto-generated method stub
		return "Title: " + _collection.getTitle();
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return _collection.getTitle();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return _collection.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		
		try {
			return UserLocalServiceUtil.getUser(_collection.getUserId()).getScreenName();
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
			renderRequest.setAttribute("sdr_collection", _collection);
			//  /html/[PORTLET_PATH]/[VIEW PAGE].jsp
			return "/assetPage/collection.jsp";
		}
		else {
			return null;
		}
	}
	
	private Log _log;
}
