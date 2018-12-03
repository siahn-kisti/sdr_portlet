package com.sdr.metadata.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;


public class DataTypeAssetRendererFactory  extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = DataType.class.getName();
	
	public static final String TYPE = "DataType";

	// Permission Method
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		DataType datatype = DataTypeLocalServiceUtil.getDataType(classPK);
		return new DataTypeAssetRenderer(datatype);
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
