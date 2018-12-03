package com.sdr.metadata.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.service.CollectionLocalServiceUtil;

public class CollectionAssetRendererFactory  extends BaseAssetRendererFactory {
	
	public static final String CLASS_NAME = Collection.class.getName();
	
	public static final String TYPE = "Collection";
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		Collection collection = CollectionLocalServiceUtil.getCollection(classPK);
		return new CollectionAssetRenderer(collection);
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
