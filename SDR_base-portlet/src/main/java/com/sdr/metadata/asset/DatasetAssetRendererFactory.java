package com.sdr.metadata.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetLocalServiceUtil;

public class DatasetAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = Dataset.class.getName();
	
	public static final String TYPE = "Dataset";
	
	// Permission Method
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		Dataset dataset = DatasetLocalServiceUtil.getDataset(classPK);
		return new DatasetAssetRenderer(dataset);
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
