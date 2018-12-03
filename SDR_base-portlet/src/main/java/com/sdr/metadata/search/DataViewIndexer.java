package com.sdr.metadata.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataViewLocalServiceUtil;
import com.sdr.metadata.service.persistence.DataViewActionableDynamicQuery;

public class DataViewIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { DataView.class.getName() };
	public static final String PORTLET_ID = "SDR_base-portlet";
	
	private static Log log = LogFactoryUtil.getLog(DataViewIndexer.class);
	public DataViewIndexer() {
		setPermissionAware(false);
	}
	
	@Override
	public String[] getClassNames() {
		// TODO Auto-generated method stub
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}
	
	@Override
	protected String getPortletId(SearchContext searchContext) {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		// TODO Auto-generated method stub
		DataView dataView = (DataView) obj;
		deleteDocument(dataView.getCompanyId(), dataView.getDataViewId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		// TODO Auto-generated method stub
		DataView dataView = (DataView) obj;
		Document document = getBaseModelDocument(PORTLET_ID, dataView);
		
		document.addNumber(Field.CLASS_PK, dataView.getDataViewId());
		document.addText(Field.TITLE, dataView.getTitle());
		
		// DataView -> Only ADMIN user can register
		document.addText(Field.USER_NAME, "ADMIN");
		
		// DataType ID -> DataType Title
		DataType dataType = DataTypeLocalServiceUtil.getDataType(dataView.getDataTypeId());
		document.addText("DataType", dataType.getTitle());
		
		// Omit Location
		document.addText(Field.DESCRIPTION, dataView.getDescription());

		document.addNumber(Field.GROUP_ID, getSiteGroupId(dataView.getGroupId()));
		document.addNumber(Field.SCOPE_GROUP_ID, dataView.getGroupId());
		document.addNumber(Field.COMPANY_ID, dataView.getCompanyId());
		log.debug("### DataView INDEXING DONE");
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) throws Exception {
		// TODO Auto-generated method stub
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		// TODO Auto-generated method stub
		DataView dataView = (DataView) obj;
		Document document = getDocument(dataView);
		SearchEngineUtil.updateDocument(getSearchEngineId(),dataView.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		long companyID = GetterUtil.getLong(ids[0]);
		reindexDatasets(companyID);
		
	}

	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		
		DataView dataView = DataViewLocalServiceUtil.getDataView(classPK);
		doReindex(dataView);
	}
	
	protected void reindexDatasets(long companyId) throws PortalException,
			SystemException {

		final java.util.Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new DataViewActionableDynamicQuery () {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				DataView dataView = (DataView) object;

				Document document = getDocument(dataView);

				documents.add(document);
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.performActions();
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
	}
	
	@Override
    public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext)
        throws Exception {
        System.out.println("-----postProcessSearchQuery called------");

        addSearchTerm(searchQuery, searchContext, "DataType", true);

        LinkedHashMap<String, Object> params = (LinkedHashMap<String, Object>)searchContext.getAttribute("params");

        if (params != null) {
            String expandoAttributes = (String)params.get("expandoAttributes");

            if (Validator.isNotNull(expandoAttributes)) {
                addSearchExpando(searchQuery, searchContext, expandoAttributes);
            }
        }
    }
}
