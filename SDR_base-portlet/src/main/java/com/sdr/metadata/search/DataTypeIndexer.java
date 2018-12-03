package com.sdr.metadata.search;

import java.util.ArrayList;
import java.util.Collection;
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
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.persistence.DataTypeActionableDynamicQuery;

public class DataTypeIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { DataType.class.getName() };
	public static final String PORTLET_ID = "SDR_base-portlet";
	
	private static Log log = LogFactoryUtil.getLog(DataTypeIndexer.class);
	public DataTypeIndexer() {
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
	protected void doDelete(Object obj) throws Exception {
		// TODO Auto-generated method stub
		DataType dataType = (DataType) obj;
		deleteDocument(dataType.getCompanyId(), dataType.getDataTypeId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		// TODO Auto-generated method stub
		DataType dataType = (DataType) obj;
		Document document = getBaseModelDocument(PORTLET_ID, dataType);
		
		document.addNumber(Field.CLASS_PK, dataType.getDataTypeId());
		document.addText(Field.TITLE, dataType.getTitle().toLowerCase());
		document.addText(Field.DESCRIPTION, dataType.getDescription().toLowerCase());
		document.addNumber(Field.GROUP_ID, getSiteGroupId(dataType.getGroupId()));
		document.addNumber(Field.SCOPE_GROUP_ID, dataType.getGroupId());
		document.addNumber(Field.COMPANY_ID, dataType.getCompanyId());
		log.debug("### DataType INDEXING DONE");
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
		DataType dataType = (DataType) obj;
		Document document = getDocument(dataType);
		SearchEngineUtil.updateDocument(getSearchEngineId(), dataType.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		long companyID = GetterUtil.getLong(ids[0]);
		reindexDatasets(companyID);
		
	}

	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		
		DataType dataType = DataTypeLocalServiceUtil.getDataType(classPK);
		doReindex(dataType);
	}
	
	protected void reindexDatasets(long companyId) throws PortalException,
			SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new DataTypeActionableDynamicQuery () {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				DataType dataType = (DataType) object;

				Document document = getDocument(dataType);

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
        
        LinkedHashMap<String, Object> params = (LinkedHashMap<String, Object>)searchContext.getAttribute("params");

        if (params != null) {
            String expandoAttributes = (String)params.get("expandoAttributes");

            if (Validator.isNotNull(expandoAttributes)) {
                addSearchExpando(searchQuery, searchContext, expandoAttributes);
            }
        }
    }
	 
	@Override
	protected String getPortletId(SearchContext searchContext) {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}
}
