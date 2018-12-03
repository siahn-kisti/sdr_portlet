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
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;
import com.sdr.metadata.service.persistence.DataTypeSchemaActionableDynamicQuery;


public class DataTypeSchemaIndexer extends BaseIndexer  {
	public static final String[] CLASS_NAMES = { DataTypeSchema.class.getName() };
	public static final String PORTLET_ID = "SDR_base-portlet";
	private static Log log = LogFactoryUtil.getLog(DataTypeSchemaIndexer.class);
	public DataTypeSchemaIndexer() {
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
		DataTypeSchema dataTypeSchema = (DataTypeSchema) obj;
		deleteDocument(dataTypeSchema.getCompanyId(), dataTypeSchema.getDataTypeSchemaId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		// TODO Auto-generated method stub
		DataTypeSchema dataTypeSchema = (DataTypeSchema) obj;
		Document document = getBaseModelDocument(PORTLET_ID, dataTypeSchema);
		
		document.addNumber(Field.CLASS_PK, dataTypeSchema.getDataTypeSchemaId());
		
		// DataType ID -> DataType Title
//		DataType dataType = DataTypeLocalServiceUtil.getDataType(dataTypeSchema.getDataTypeId());
//		document.addText("DataType", dataType.getTitle());
		
		document.addText(Field.TITLE, dataTypeSchema.getTitle());
		document.addText("Reference", dataTypeSchema.getReference());
		document.addText("VariableType", dataTypeSchema.getVariableType());
		document.addText("VariableUnit", dataTypeSchema.getVariableUnit());
		//Do not index in the future
//		document.addKeyword("Essential", dataTypeSchema.getEssential());
//		document.addKeyword("ValidationRule", dataTypeSchema.getValidationRule());
		//TODO: modify columns
		
		document.addText(Field.DESCRIPTION, dataTypeSchema.getDescription());
		document.addNumber(Field.GROUP_ID, getSiteGroupId(dataTypeSchema.getGroupId()));
		document.addNumber(Field.SCOPE_GROUP_ID, dataTypeSchema.getGroupId());
		document.addNumber(Field.COMPANY_ID, dataTypeSchema.getCompanyId());
		log.debug("### DataTypeSchema INDEXING DONE");
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
		DataTypeSchema dataTypeSchema = (DataTypeSchema) obj;
		Document document = getDocument(dataTypeSchema);
		SearchEngineUtil.updateDocument(getSearchEngineId(), dataTypeSchema.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		long companyID = GetterUtil.getLong(ids[0]);
		reindexDatasets(companyID);
		
	}

	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		
		DataTypeSchema dataTypeSchema = DataTypeSchemaLocalServiceUtil.getDataTypeSchema(classPK);
		doReindex(dataTypeSchema);
	}
	
	protected void reindexDatasets(long companyId) throws PortalException,
			SystemException {

		final java.util.Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new DataTypeSchemaActionableDynamicQuery () {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				DataTypeSchema dataTypeSchema = (DataTypeSchema) object;

				Document document = getDocument(dataTypeSchema);

				documents.add(document);
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.performActions();
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
	}
	
/*	@Override
    public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext)
        throws Exception {
        System.out.println("-----postProcessSearchQuery called------");

        addSearchTerm(searchQuery, searchContext, "Reference", true);
        addSearchTerm(searchQuery, searchContext, "VariableType", true);
        addSearchTerm(searchQuery, searchContext, "VariableUnit", true);
        addSearchTerm(searchQuery, searchContext, "Essential", true);
        addSearchTerm(searchQuery, searchContext, "ValidationRule", true);
             
        LinkedHashMap<String, Object> params = (LinkedHashMap<String, Object>)searchContext.getAttribute("params");

        if (params != null) {
            String expandoAttributes = (String)params.get("expandoAttributes");

            if (Validator.isNotNull(expandoAttributes)) {
                addSearchExpando(searchQuery, searchContext, expandoAttributes);
            }
        }
    }*/
}
