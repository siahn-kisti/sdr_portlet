package com.sdr.metadata.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.model.Dataset;

public class DataTypeSchemaAssetRenderer extends BaseAssetRenderer {

	private DataTypeSchema _dataTypeSchema;
	
	public DataTypeSchemaAssetRenderer (DataTypeSchema dataTypeSchema) {
		_dataTypeSchema = dataTypeSchema;
	}
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return DataTypeSchema.class.getName();
	}

	public long getClassPK() {
		// TODO Auto-generated method stub
		return _dataTypeSchema.getDataTypeSchemaId();
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return _dataTypeSchema.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		// TODO Auto-generated method stub
		return "Title: " + _dataTypeSchema.getTitle();
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return _dataTypeSchema.getTitle();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return "ADMIN";
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
			renderRequest.setAttribute("sdr_datatypeschema", _dataTypeSchema);
			//  /html/[PORTLET_PATH]/[VIEW PAGE].jsp
			return "/html/xxx/yyy.jsp";
		}
		else {
			return null;
		}
	}
	
	private Log _log;
}
