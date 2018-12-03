package com.sdr.metadata.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sdr.metadata.NoSuchCollectionException;
import com.sdr.metadata.NoSuchDataTypeException;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.persistence.DatasetActionableDynamicQuery;

public class DatasetIndexer extends BaseIndexer {
    public static final String[] CLASS_NAMES = {Dataset.class.getName()};
    public static final String PORTLET_ID = "SDR_base-portlet";
    // public static ArrayList<String> additionalKeys = new ArrayList<String>();

    private static Log log = LogFactoryUtil.getLog(DatasetIndexer.class);

    public DatasetIndexer() {
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
        Dataset dataset = (Dataset) obj;
        deleteDocument(dataset.getCompanyId(), dataset.getDatasetId());
    }

    @Override
    protected Document doGetDocument(Object obj) throws Exception {
        // TODO Auto-generated method stub

        log.debug("###  DatasetIndexer doGetDocument ::: start 5");

        Dataset dataset = (Dataset) obj;
        Document document = getBaseModelDocument(PORTLET_ID, dataset);

        document.addText(Field.ENTRY_CLASS_NAME, Dataset.class.getName());
        document.addNumber(Field.CLASS_PK, dataset.getDatasetId());
        document.addKeywordSortable(Field.TITLE, dataset.getTitle());

        User user = UserLocalServiceUtil.getUser(dataset.getUserId());
        document.addNumber(Field.USER_ID, dataset.getUserId());
        document.addKeywordSortable(Field.USER_NAME, user.getScreenName());

        document.addDate(Field.CREATE_DATE, dataset.getCreateDate());
        document.addDate(Field.PUBLISH_DATE, dataset.getPublishDate());
        document.addNumber(Field.VERSION, dataset.getVersion());
        document.addNumber("status", dataset.getStatus());
        // Omit Checksum, DOI, Location

        // need exact field Name
        document.addNumber("datasetId", dataset.getDatasetId());
        document.addNumber("collectionId", dataset.getCollectionId());
        document.addNumber("dataTypeId", dataset.getDataTypeId());

        //document.addKeyword("DM", dataset.getDescriptiveMetadata());
        // Parse Descriptive Metadata to key:value pairs & Find Datatype of each value
        // Array or JSON object are filtered out and only key:value are indexed
        String DM = dataset.getDescriptiveMetadata();
        if (!DM.isEmpty()) {
            JSONObject jsonobj = JSONFactoryUtil.createJSONObject(DM);
            Iterator<String> keys = jsonobj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonobj.getString(key);
                //log.debug("### key : " + key + " value : " + value + " type : " + typecheck(value));
                switch (typecheck(value)) {
                    case 1:    // JSON object -> String
                        document.addText(key, value);
                        // additionalKeys.add(key);
                        break;
                    case 2:    // JSON array -> Double, Integer, String array
                        JSONArray value_temp = JSONFactoryUtil.createJSONArray(value);
                        int value_length = value_temp.length();
                        switch (typecheck(value_temp.getString(0))) {
                            case 3: // Integer
                                int[] arr_int = new int[value_length];
                                for (int i = 0; i < value_length; i++) {
                                    arr_int[i] = value_temp.getInt(i);
                                }
                                document.addNumber(key, arr_int);
                                document.addNumber(key + "_count", value_length);
                                break;
                            case 4: // Double
                                // JSON array to Double Array
                                Double[] arr_d = new Double[value_length];
                                for (int i = 0; i < value_length; i++) {
                                    arr_d[i] = value_temp.getDouble(i);
                                }
                                document.addNumber(key, arr_d);
                                document.addNumber(key + "_count", value_length);
                                break;
                            case 5: // String
                                // JSON array to String Array
                                String[] arr_str = new String[value_length];
                                for (int i = 0; i < value_length; i++) {
                                    arr_str[i] = value_temp.getString(i);
                                }
                                document.addText(key, arr_str);
                                document.addNumber(key + "_count", value_length);
                                break;
                            default: // Else (coordinate)
                                document.addText(key, value_temp.toString());
                                break;
                        }

                        break;
                    case 3:    // Integer
                        int num = Integer.parseInt(value);
                        document.addNumber(key, num);
                        //additionalKeys.add(key);
                        break;
                    case 4:    // Double
                        double num_d = Double.parseDouble(value);
                        document.addNumber(key, num_d);
                        // additionalKeys.add(key);
                        break;
                    case 5: // String
                        String str = value;
                        document.addText(key, str);
                        // additionalKeys.add(key);
                        break;
                }
            }
        }
        log.debug("###  DatasetIndexer doGetDocument ::: metadata while end");

        document.addKeyword("PM", dataset.getProvenanceMetadata(), true);
        document.addText(Field.DESCRIPTION, dataset.getDescription());
        document.addText("location", dataset.getLocation());

        // DataType ID, Collection ID -> DataType Title, Collection Title
        DataType dataType = null;
        Collection collection = null;
        try {
            dataType = DataTypeLocalServiceUtil.getDataType(dataset.getDataTypeId());
            document.addText("DataType", dataType.getTitle());
        } catch (NoSuchDataTypeException e) {
            document.addText("DataType", "Default");
        }

        log.debug("###  DatasetIndexer doGetDocument ::: getDataType");

        try {
            collection = CollectionLocalServiceUtil.getCollection(dataset.getCollectionId());
            document.addText("Collection", collection.getTitle());
            document.addText("License", collection.getUsageRight().replace("_", "").replace("-", ""));
        } catch (NoSuchCollectionException e2) {
            document.addText("Collection", "Default");
        }

        log.debug("###  DatasetIndexer doGetDocument ::: getCollection");

        document.addNumber("FileNum", dataset.getFileNum());
        document.addNumber(Field.GROUP_ID, getSiteGroupId(dataset.getGroupId()));
        document.addNumber(Field.SCOPE_GROUP_ID, dataset.getGroupId());
        document.addNumber(Field.COMPANY_ID, dataset.getCompanyId());

        log.debug("### DatasetIndexer INDEXING DONE");

        return document;
    }

    public int typecheck(String obj) {
        try {
            JSONFactoryUtil.createJSONObject(obj);
            return 1;
        } catch (Exception e) {
            try {
                JSONFactoryUtil.createJSONArray(obj);
                return 2;
            } catch (Exception e2) {
                try {
                    Integer.parseInt(obj);
                    return 3;
                } catch (Exception e3) {
                    try {
                        Double.parseDouble(obj);
                        return 4;
                    } catch (Exception e4) {
                        return 5;
                    }
                }
            }
        }

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
        Dataset dataset = (Dataset) obj;
        Document document = getDocument(dataset);
        SearchEngineUtil.updateDocument(getSearchEngineId(), dataset.getCompanyId(), document);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        // TODO Auto-generated method stub
        long companyID = GetterUtil.getLong(ids[0]);
        reindexDatasets(companyID);

    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        // TODO Auto-generated method stub

        Dataset dataset = DatasetLocalServiceUtil.getDataset(classPK);
        doReindex(dataset);
    }

    protected void reindexDatasets(long companyId) throws PortalException,
            SystemException {

        final java.util.Collection<Document> documents = new ArrayList<Document>();

        ActionableDynamicQuery actionableDynamicQuery = new DatasetActionableDynamicQuery() {

            @Override
            protected void addCriteria(DynamicQuery dynamicQuery) {
            }

            @Override
            protected void performAction(Object object) throws PortalException {
                Dataset dataset = (Dataset) object;

                Document document = getDocument(dataset);
                String _tmpSEId = SearchEngineUtil.getSearchEngineId(document);

                //log.debug("###  DatasetIndexer perform1 ::: " + _tmpSEId);
                //log.debug("###  DatasetIndexer perform2 ::: " +  dataset.getCompanyId());
                //log.debug("###  DatasetIndexer perform3 ::: " + document);

                // documents.add(document);
                SearchEngineUtil.updateDocument(_tmpSEId, dataset.getCompanyId(), document);
            }

        };

        actionableDynamicQuery.setCompanyId(companyId);
        actionableDynamicQuery.performActions();

        // SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
    }

    //	@Override
    //    public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext)
    //        throws Exception {
    //        System.out.println("-----postProcessSearchQuery called------");
    //
    //        addSearchTerm(searchQuery, searchContext, "Contributor", true);
    //        addSearchTerm(searchQuery, searchContext, "DM", true);
    //        addSearchTerm(searchQuery, searchContext, "PM", true);
    //        addSearchTerm(searchQuery, searchContext, "DataType", true);
    //        addSearchTerm(searchQuery, searchContext, "Collection", true);
    //        addSearchTerm(searchQuery, searchContext, "FileNum", true);
    //
    //        for(String additionalKey : additionalKeys) {
    //        	addSearchTerm(searchQuery, searchContext, additionalKey, true);
    //        }
    //
    //        LinkedHashMap<String, Object> params = (LinkedHashMap<String, Object>)searchContext.getAttribute("params");
    //
    //        if (params != null) {
    //            String expandoAttributes = (String)params.get("expandoAttributes");
    //
    //            if (Validator.isNotNull(expandoAttributes)) {
    //                addSearchExpando(searchQuery, searchContext, expandoAttributes);
    //            }
    //        }
    //    }

}
