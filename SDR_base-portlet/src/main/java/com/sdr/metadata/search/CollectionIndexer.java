package com.sdr.metadata.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.persistence.CollectionActionableDynamicQuery;


public class CollectionIndexer extends BaseIndexer {
    public static final String[] CLASS_NAMES = {Collection.class.getName()};
    public static final String PORTLET_ID = "SDR_base-portlet";

    private static Log log = LogFactoryUtil.getLog(CollectionIndexer.class);

    public CollectionIndexer() {
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
    protected String getPortletId(SearchContext serviceContext) {
        // TODO Auto-generated method stub
        return PORTLET_ID;
    }

    @Override
    protected void doDelete(Object obj) throws Exception {
        // TODO Auto-generated method stub
        Collection collection = (Collection) obj;
        deleteDocument(collection.getCompanyId(), collection.getCollectionId());
    }

    @Override
    protected Document doGetDocument(Object obj) throws Exception {
        // TODO Auto-generated method stub
        Collection collection = (Collection) obj;
        Document document = getBaseModelDocument(PORTLET_ID, collection);

        document.addText(Field.ENTRY_CLASS_NAME, Collection.class.getName());
        document.addNumber(Field.CLASS_PK, collection.getCollectionId());
        document.addText(Field.TITLE, collection.getTitle());

        // User ID -> User Screen Name
        User user = UserLocalServiceUtil.getUser(collection.getUserId());
        document.addText(Field.USER_NAME, user.getScreenName());

        document.addDate(Field.CREATE_DATE, collection.getCreateDate());
        document.addTextSortable(Field.DESCRIPTION, collection.getDescription());

        // Omit UsageRight, DOI, AccessPolicy
        document.addNumber("accessPolicy", collection.getAccessPolicy());

        document.addNumber(Field.GROUP_ID, getSiteGroupId(collection.getGroupId()));
        document.addNumber(Field.SCOPE_GROUP_ID, collection.getGroupId());
        document.addNumber(Field.COMPANY_ID, collection.getCompanyId());

        // Contributor Array
        List<Collection_User> usersByCollection = Collection_UserLocalServiceUtil.getUsersByCollection(collection.getCollectionId());
        int cntributorCnt = usersByCollection.size();
        if (cntributorCnt > 0) {
            Long[] arr_l = new Long[cntributorCnt];
            for (int i = 0; i < cntributorCnt; i++) {
                arr_l[i] = usersByCollection.get(i).getUserId();
            }
            document.addNumber("contributorId", arr_l);
        }

        log.debug("### Collection INDEXING DONE");
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
        Collection collection = (Collection) obj;
        Document document = getDocument(collection);
        SearchEngineUtil.updateDocument(getSearchEngineId(), collection.getCompanyId(), document);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        // TODO Auto-generated method stub
        long companyID = GetterUtil.getLong(ids[0]);
        reindexCollections(companyID);

    }

    protected void doReindex(String className, long classPK) throws Exception {
        // TODO Auto-generated method stub

        Collection collection = CollectionLocalServiceUtil.getCollection(classPK);
        doReindex(collection);
    }

    protected void reindexCollections(long companyId) throws PortalException,
            SystemException {

        final java.util.Collection<Document> documents = new ArrayList<Document>();

        ActionableDynamicQuery actionableDynamicQuery = new CollectionActionableDynamicQuery() {

            @Override
            protected void addCriteria(DynamicQuery dynamicQuery) {
            }

            @Override
            protected void performAction(Object object) throws PortalException {
                Collection collection = (Collection) object;

                Document document = getDocument(collection);

                documents.add(document);
            }
        };

        actionableDynamicQuery.setCompanyId(companyId);
        actionableDynamicQuery.performActions();
        SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
    }

}
