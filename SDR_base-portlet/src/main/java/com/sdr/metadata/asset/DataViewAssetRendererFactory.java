package com.sdr.metadata.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.service.DataViewLocalServiceUtil;

public class DataViewAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = DataView.class.getName();
	
	public static final String TYPE = "DataView";
	
	// Permission Method
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		DataView dataView = DataViewLocalServiceUtil.getDataView(classPK);
		return new DataViewAssetRenderer(dataView);
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return TYPE;
	}
	
	public boolean isLinkable() {
		return _LINKABLE;
	}
	
	private static final boolean _LINKABLE = true;

}
