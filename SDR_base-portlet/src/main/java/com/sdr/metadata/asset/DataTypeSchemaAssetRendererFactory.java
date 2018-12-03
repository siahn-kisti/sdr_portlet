package com.sdr.metadata.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;

public class DataTypeSchemaAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = DataTypeSchema.class.getName();
	
	public static final String TYPE = "DataTypeSchema";
	
	// Permission Method
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		DataTypeSchema dataTypeSchema = DataTypeSchemaLocalServiceUtil.getDataTypeSchema(classPK);
		return new DataTypeSchemaAssetRenderer(dataTypeSchema);
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
