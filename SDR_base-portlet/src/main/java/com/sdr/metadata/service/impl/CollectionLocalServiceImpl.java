/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.NoSuchEntryException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLink;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.model.CollectionVo;
import com.sdr.file.FileService;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.CollectionClp;
import com.sdr.metadata.model.Collection_AllowedUser;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;
import com.sdr.metadata.service.base.CollectionLocalServiceBaseImpl;
import com.sdr.metadata.util.SdrBeanUtils;
import com.sdr.search.datasearch.facet.FacetSearch;
import org.springframework.util.StringUtils;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the collection local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.CollectionLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.CollectionLocalServiceBaseImpl
 * @see com.sdr.metadata.service.CollectionLocalServiceUtil
 */
public class CollectionLocalServiceImpl extends CollectionLocalServiceBaseImpl {

    private static Log _log = LogFactoryUtil.getLog(CollectionLocalServiceImpl.class);

    /*
    public Collection getCollection(long CollectionId) throws PortalException, SystemException {
        return collectionPersistence.findByCollectionId(CollectionId);
    }
    */

    /**
     * Get group id
     *
     * @param collectionId
     * @return long
     * @throws PortalException
     * @throws SystemException
     */
    public long getGroupId(long collectionId) throws PortalException, SystemException {
        Collection collection = getCollection(collectionId);
        return collection.getGroupId();
    }

    /**
     * Get count
     *
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount() throws SystemException, PortalException {
        return collectionPersistence.countAll();
    }

    /**
     * Get list
     *
     * @return List<Collection>
     * @throws SystemException
     */
    public List<Collection> getList() throws SystemException {
        return collectionPersistence.findAll();
    }


	/**
	 * Get list of Collection id
	 *
	 * @param collectionId
	 * @return long
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<Long> getCollectionIds() throws PortalException, SystemException {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		dynamicQuery.setProjection(ProjectionFactoryUtil.property("collectionId"));

		List collectionIds = CollectionLocalServiceUtil.dynamicQuery(dynamicQuery);

		return collectionIds;
	}


	/**
	 * Get a map of collection Community
	 *
	 * @return Map<String, Object>
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Map<String, Object> collectionCommunityMap() throws PortalException, SystemException {

		Map<String, Object> resultMap = FacetSearch.collectionCommunityFacet(this.getCollectionIds());

		return resultMap;
	}


    /**
     * Get list
     *
     * @param start
     * @param end
     * @return List<Collection>
     * @throws SystemException
     */
    public List<Collection> getList(int start, int end) throws SystemException {
        return collectionPersistence.findAll(start, end);
    }

    /**
     * Gets list order by.
     *
     * @param start      the start
     * @param end        the end
     * @param comparator the comparator
     * @return the list order by
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    public List<Collection> getListOrderBy(int start, int end, OrderByComparator comparator, ServiceContext serviceContext)
            throws SystemException, PortalException {

        if ( serviceContext.getScopeGroupId() != GroupLocalServiceUtil.getGroup( serviceContext.getCompanyId(), GroupConstants.GUEST).getGroupId()  ) {
            return collectionPersistence.findByGroupId( serviceContext.getScopeGroupId(), start, end, comparator) ;
        } else {
            return collectionPersistence.findAll( start, end, comparator ) ;
        }
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @return List<Collection>
     * @throws SystemException
     */
    public List<Collection> getList(int start, int end, String keyword) throws SystemException {

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Collection.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return collectionPersistence.findWithDynamicQuery(query, start, end);
    }


    /**
     * Get list
     *
     * @param groupId
     * @return List<Collection>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection> getList(long groupId) throws PortalException, SystemException {
        return collectionPersistence.findByGroupId(groupId);
    }

    /**
     * Get list
     *
     * @param groupId
     * @param start
     * @param end
     * @return List<Collection>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection> getList(long groupId, int start, int end) throws PortalException, SystemException {
        return collectionPersistence.findByGroupId(groupId, start, end);
    }

    /**
     * Gets list.
     *
     * @param groupId the group id
     * @param start   the start
     * @param end     the end
     * @param keyword the keyword
     * @return the list
     * @throws SystemException the system exception
     */
    public List<Collection> getList(long groupId, int start, int end, String keyword) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Collection.class);
        Criterion criterion = PropertyFactoryUtil.forName("groupId").eq(groupId);

        if (!StringUtils.isEmpty(keyword)) {
            criterion = RestrictionsFactoryUtil.and(criterion, 
                    RestrictionsFactoryUtil.or(
                            PropertyFactoryUtil.forName("title").like("%" + keyword + "%"),
                            PropertyFactoryUtil.forName("description").like("%" + keyword + "%")
                    )
            );
        }
        
        query.add(criterion);
        query.addOrder(OrderFactoryUtil.asc("title"));
        return collectionPersistence.findWithDynamicQuery(query, start, end);
    }

    public List<Collection> getWritableList(int start, int end, String keyword, ServiceContext serviceContext) throws SystemException {
        return getWritableList((long) -1, start, end, keyword, serviceContext);
    }


    public List<Collection> getWritableList(long groupId, int start, int end, String keyword, ServiceContext serviceContext) throws SystemException {

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Collection.class);

        Criterion criterion = PropertyFactoryUtil.forName("userId").eq(serviceContext.getUserId());

        if ( groupId > 0 )
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("groupId").eq(groupId));

        if (!StringUtils.isEmpty(keyword)) {
            criterion = RestrictionsFactoryUtil.and(criterion,
                    PropertyFactoryUtil.forName("title").like("%" + keyword + "%") ) ;
        }

        query.add(criterion);
        query.addOrder(OrderFactoryUtil.asc("title"));


        List<Collection> listCollection = collectionPersistence.findWithDynamicQuery(query, start, end);
        List<Collection> resultCollection = new ArrayList<>()  ;
        long[] listCollectionId = new long[ listCollection.size()];
        for (int i=0; i<listCollection.size();i++) {
            // _log.debug("adding : " + listCollection.get(i).getTitle());
            resultCollection.add(listCollection.get(i));
            listCollectionId[i] = listCollection.get(i).getCollectionId();
        }

        try {
            List<Collection_AllowedUser> cau = Collection_AllowedUserLocalServiceUtil.getCollectionsByAllowedUser(serviceContext.getUserId());
            for (int i = 0; i < cau.size(); i++) {
                // _log.debug("trying : " + cau.get(i).getCollectionId());
                Collection coll = CollectionLocalServiceUtil.getCollection(cau.get(i).getCollectionId());
                //if ( coll.getGroupId() != serviceContext.getScopeGroupId()) continue;

                // ignore the same collection
                int j;
                for (j=0; j < listCollection.size(); j++)
                    if ( listCollection.get(j).getCollectionId() == coll.getCollectionId() )
                        break;
                if (j==listCollection.size()) resultCollection.add(coll);
            }
        } catch ( PortalException | SystemException e ) {
            // do Nothing
            e.printStackTrace();
        }

        return resultCollection;
    }

    /**
     * Get count
     *
     * @param groupId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(long groupId) throws SystemException, PortalException {
        return collectionPersistence.countByGroupId(groupId);
    }

    /**
     * Get list by dataset user id
     *
     * @param datasetUserId
     * @return List<Collection>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection> getListByDatasetUserId(long datasetUserId) throws PortalException, SystemException {

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Collection.class);
        Criterion criterion = RestrictionsFactoryUtil.eq("userId", datasetUserId);
        query.add(criterion);
        return collectionPersistence.findWithDynamicQuery(query);
    }

    /**
     * Get list by dataset user id
     *
     * @param datasetUserId
     * @param start
     * @param end
     * @return List<Collection>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection> getListByDatasetUserId(long datasetUserId, int start, int end) throws PortalException, SystemException {

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Dataset.class);
        Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("collectionId"));
        query.setProjection(projection);

        Criterion criterion = RestrictionsFactoryUtil.eq("userId", datasetUserId);

        query.add(criterion);

        List<Long> listByUserId = DatasetLocalServiceUtil.dynamicQuery(query);
        ArrayList<Collection> listByDatasetUserId = new ArrayList<Collection>();
        for (long collectionId : listByUserId) {
            listByDatasetUserId.add(collectionPersistence.findByCollectionId(collectionId));
        }

        Collections.sort(listByDatasetUserId);
        end = end > listByDatasetUserId.size() ? end = listByDatasetUserId.size() : end;
        return listByDatasetUserId.subList(start, end);
    }

    /**
     * Get count by dataset user id
     *
     * @param datasetUserId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCountByDatasetUserId(long datasetUserId) throws SystemException, PortalException {

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Dataset.class);
        Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("collectionId"));
        query.setProjection(projection);

        Criterion criterion = RestrictionsFactoryUtil.eq("userId", datasetUserId);

        query.add(criterion);

        List<Long> listByUserId = DatasetLocalServiceUtil.dynamicQuery(query);
        ArrayList<Collection> listByDatasetUserId = new ArrayList<Collection>();
        for (long collectionId : listByUserId) {
            listByDatasetUserId.add(collectionPersistence.findByCollectionId(collectionId));
        }

        return listByDatasetUserId.size();
    }

    public Map<String, Object> search(RenderRequest request, RenderResponse response)
            throws SearchException, ParseException {
        return search( request, (LiferayPortletURL) response.createRenderURL()) ;
    }

    public Map<String, Object> search(ResourceRequest request, ResourceResponse response)
            throws SearchException, ParseException {
        return search( request, (LiferayPortletURL) response.createResourceURL()) ;
    }

    /**
     * Search
     *
     * @param renderRequest
     * @param LiferayPortletURL
     * @return Map
     * @throws SearchException`
     * @throws ParseException
     */
    // public Map<String, Object> search(RenderRequest renderRequest, RenderResponse renderResponse) throws SearchException, ParseException {
    public Map<String, Object> search(PortletRequest renderRequest, LiferayPortletURL renderURL) throws SearchException, ParseException {

        Map<String, Object> map = new HashMap<String, Object>();

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long scopeGroupId = themeDisplay.getScopeGroupId();

        String keywords = ParamUtil.getString(renderRequest, "keywords");
        String searchSelect = ParamUtil.getString(renderRequest, "searchSelect");
        String facetKeywords = ParamUtil.getString(renderRequest, "facetKeywords");
        List<Long> categories = (List) renderRequest.getAttribute("categories");
        
        _log.debug("keyword ::: " + keywords + " searchFlag ::: " + searchSelect);
        
        SearchContainer<Collection> searchContainer = new SearchContainer<Collection>(renderRequest, renderURL, null, "there are no collections");

        SearchContext searchContext = new SearchContext();

        String sort = ParamUtil.getString(renderRequest, "sort", "lastest");

        if (ParamUtil.getInteger(renderRequest, "delta") == 0 && "databrowser".equals(renderRequest.getAttribute("databrowser"))) {
            searchContainer.setDelta(10);
        } else if(ParamUtil.getInteger(renderRequest, "delta") == 0 ){
			searchContainer.setDelta(5);
		}else {
            searchContainer.setDelta(searchContainer.getDelta());
        }

//        Map<String, Object> facetParams = new HashMap<String, Object>();

        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);

        subQuery.addExactTerm(Field.ENTRY_CLASS_NAME, Collection.class.getName());
        mainQuery.add(subQuery, BooleanClauseOccur.MUST);

        try {
            if (scopeGroupId != GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId()) {
                subQuery = BooleanQueryFactoryUtil.create(searchContext);
                subQuery.addExactTerm("groupId", scopeGroupId);
                mainQuery.add(subQuery, BooleanClauseOccur.MUST);
//                facetParams.put("groupId", Long.toString(scopeGroupId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!keywords.isEmpty()) {

            subQuery = BooleanQueryFactoryUtil.create(searchContext);

            if (searchSelect.equals("id")) {
                subQuery.addExactTerm("classPK", keywords);
//                facetParams.put("collectionId", keywords);
            } else if (searchSelect.equals("title")) {
//                problem with keyword "in"
//                subQuery.addTerm("title_sortable", keywords, true);
                subQuery.addTerm("title_sortable", keywords.toUpperCase(), true);
//                facetParams.put("title", keywords);
            } else if (searchSelect.equals("description")) {
                subQuery.addTerm("description_sortable", keywords, true);
//                facetParams.put("description", keywords);
            } else if (searchSelect.equals("titleDescription")) {
                BooleanQuery keywordQuery = BooleanQueryFactoryUtil.create(searchContext);
//                problem with keyword "in"
//                keywordQuery.addTerm("title_sortable", keywords, true);
                keywordQuery.addTerm("title_sortable", keywords.toUpperCase(), true);
                subQuery.add(keywordQuery, BooleanClauseOccur.SHOULD);

                keywordQuery = BooleanQueryFactoryUtil.create(searchContext);
                keywordQuery.addTerm("description_sortable", keywords, true);
                subQuery.add(keywordQuery, BooleanClauseOccur.SHOULD);
//                facetParams.put("titleDescription", keywords);
            }
            mainQuery.add(subQuery, BooleanClauseOccur.MUST);
        }

        if (!facetKeywords.isEmpty()) {
            subQuery = BooleanQueryFactoryUtil.create(searchContext);
            try {
                String[] facetKeys = facetKeywords.split(",");

                for (String facetKey : facetKeys) {
                    BooleanQuery keywordQuery = BooleanQueryFactoryUtil.create(searchContext);
                    String[] split = facetKey.split("_");
                    if (split[0].equals("community")) {
                        keywordQuery.addExactTerm("groupId", split[1]);
//                        facetParams.put("groupId", split[1]);
                    } else if (split[0].equals("contributor")) {
                        BooleanQuery contributorQuery = BooleanQueryFactoryUtil.create(searchContext);
                        for (int i = 1; i < split.length; i++) {
                            contributorQuery.addTerm("contributorId", split[i], false, BooleanClauseOccur.MUST);
//                            facetParams.put("contributorId", split[i]);
                        }
                        keywordQuery.add(contributorQuery, BooleanClauseOccur.MUST);

                    } else if (split[0].equals("keyword")) {
                        BooleanQuery tagQuery = BooleanQueryFactoryUtil.create(searchContext);
                        for (int i = 1; i < split.length; i++) {
                            tagQuery.addTerm("assetTagIds", split[i], false, BooleanClauseOccur.MUST);
//                            facetParams.put("assetTagIds", split[i]);
                        }
                        keywordQuery.add(tagQuery, BooleanClauseOccur.MUST);
                    }
                    subQuery.add(keywordQuery, BooleanClauseOccur.MUST);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            mainQuery.add(subQuery, BooleanClauseOccur.MUST);
        }
        
        // Category added
        if (categories != null && !categories.isEmpty()) {
        	subQuery = BooleanQueryFactoryUtil.create(searchContext);
        	for(long category : categories) {
        		BooleanQuery keywordQuery = BooleanQueryFactoryUtil.create(searchContext);
        		keywordQuery.addExactTerm("assetCategoryIds", category);
        		subQuery.add(keywordQuery, BooleanClauseOccur.SHOULD);
        	}
        	mainQuery.add(subQuery, BooleanClauseOccur.MUST);
        }
        
        
        _log.debug("mainQuery : " + mainQuery);

//        try {
//            FacetSearch.facetSearch(facetParams, map, "collection");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Sort[] sorts = new Sort[1];

        if (sort.equals("desc")) {
            sorts[0] = new Sort("title", true);
        } else if (sort.equals("lastest")) {
            sorts[0] = new Sort("createDate", true);
        } else if (sort.equals("oldest")) {
            sorts[0] = new Sort("createDate", false);
        } else {
            sorts[0] = new Sort("title", false);
        }

        Hits hits = SearchEngineUtil.search(SearchEngineUtil.SYSTEM_ENGINE_ID, themeDisplay.getCompanyId(), mainQuery, sorts, searchContainer.getStart(), searchContainer.getEnd());

        List<Map<String, Object>> collectionList = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < hits.getDocs().length; i++) {
            Document doc = hits.doc(i);

            long collectionId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

            Map<String, Object> collectionVo = new HashMap<String, Object>();

            try {
                Collection collection = CollectionLocalServiceUtil.getCollection(collectionId);

                collectionVo.put("vo", collection);
                collectionVo.put("userName", UserLocalServiceUtil.getUserById(collection.getUserId()).getFullName());
                collectionVo.put("communityname", GroupLocalServiceUtil.getGroup(collection.getGroupId()).getName());

                //assetTags
                List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(Collection.class.getName(), collection.getCollectionId());
                String[] assetTag = new String[assetTags.size()];
                if (assetTags.size() <= 0) {
                    assetTag = new String[1];
                    assetTag[0] = "no keyword";
                } else {
                    for (int j = 0; j < assetTag.length; j++) {
                        assetTag[j] = assetTags.get(j).getName();
                    }
                }
                collectionVo.put("assetTags", assetTag);

                List<Collection_User> contributorList = Collection_UserLocalServiceUtil.getUsersByCollection(collectionId);

                String[] contributors = new String[contributorList.size()];

                for (int j = 0; j < contributors.length; j++) {
                    SdrUsers sdrUsers = SdrUsersLocalServiceUtil.getSdrUsers(contributorList.get(j).getUserId());
                    contributors[j] = sdrUsers.getLastName() + " " + sdrUsers.getFirstName();
                }

                collectionVo.put("contributorNames", contributors);

                collectionVo.put("dsCnt", DatasetLocalServiceUtil.getCount(collectionId, WorkflowConstants.STATUS_APPROVED));

                Group group = GroupLocalServiceUtil.getGroup(collection.getGroupId());
                LayoutSet layoutSet = null;

                if (group.hasPublicLayouts()) {
                    layoutSet = group.getPublicLayoutSet();
                } else {
                    layoutSet = group.getPrivateLayoutSet();
                }

                //communityImagePath - not used
                /*
                String pathImage = null;
                JournalArticle ja = getRelatedArticle(collectionId);
                if (ja == null) {
                    pathImage = themeDisplay.getPathImage() + "/layout_set_logo?img_id=" + layoutSet.getLogoId() + "&t=" + WebServerServletTokenUtil.getToken(layoutSet.getLogoId());
                } else {
                	if(ja.getSmallImage())
                		pathImage = "/image/image_gallery?img_id=" + ja.getSmallImageId();
                	else
                		pathImage = themeDisplay.getPathImage() + "/layout_set_logo?img_id=" + layoutSet.getLogoId() + "&t=" + WebServerServletTokenUtil.getToken(layoutSet.getLogoId());
                }
                collectionVo.put("communityImagePath", PortalUtil.getPortalURL(themeDisplay) + pathImage);
                */
                //collectionImage
				String thumbImagePath = FileService.getSubPath(FileService.getCollectionPath(collectionId), FileService.LOC_IMAGE_THUMB);
				String collectionImage = FileService.getFilePath(thumbImagePath);
				if(collectionImage!=null && !"".equals(collectionImage))
					collectionVo.put("collectionImage", collectionImage);
                
                collectionVo.put("embago", PermissionConstant.checkEmbago(collection.getAccessPolicy(), collection.getCreateDate()));

            } catch (PortalException pe) {
                _log.error(pe.getLocalizedMessage());
                pe.printStackTrace();
            } catch (SystemException se) {
                _log.error(se.getLocalizedMessage());
                se.printStackTrace();
            }
            collectionList.add(collectionVo);
        }

        map.put("total", hits.getLength());
        map.put("delta", searchContainer.getDelta());
        map.put("searchContainer", searchContainer);
        map.put("collectionList", collectionList);

        return map;
    }

    
    public Map<String, Object> convertVoToMap(List<Collection> collectionList) {
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

    	int collectionLength = collectionList.size();
        for (int i = 0; i < collectionLength; i++) {
            
            Map<String, Object> collectionVo = new HashMap<String, Object>();
            try {
                Collection collection = collectionList.get(i);
                long collectionId = collection.getCollectionId();
                
                collectionVo.put("vo", collection);
                collectionVo.put("userName", UserLocalServiceUtil.getUserById(collection.getUserId()).getFullName());
                collectionVo.put("communityname", GroupLocalServiceUtil.getGroup(collection.getGroupId()).getName());

              
                Group group = GroupLocalServiceUtil.getGroup(collection.getGroupId());
                LayoutSet layoutSet = null;

                if (group.hasPublicLayouts()) {
                    layoutSet = group.getPublicLayoutSet();
                } else {
                    layoutSet = group.getPrivateLayoutSet();
                }

                //collectionImage
				String thumbImagePath = FileService.getSubPath(FileService.getCollectionPath(collectionId), FileService.LOC_IMAGE_THUMB);
				String collectionImage = FileService.getFilePath(thumbImagePath);
				if(collectionImage!=null && !"".equals(collectionImage))
					collectionVo.put("collectionImage", collectionImage);

            } catch (PortalException pe) {
                _log.error(pe.getLocalizedMessage());
                pe.printStackTrace();
            } catch (SystemException se) {
                _log.error(se.getLocalizedMessage());
                se.printStackTrace();
            }
            resultList.add(collectionVo);
        }

        map.put("collectionList", resultList);
    	
    	return map;
    }
    
    /**
     * Set permission
     *
     * @param collectionId
     * @param accessPolicy
     * @return Collection
     * @throws SystemException
     * @throws PortalException
     */
    public Collection setPermission(long collectionId, int accessPolicy) throws SystemException, PortalException {
        Collection collection = getCollection(collectionId);
        collection.setAccessPolicy(accessPolicy);
        updateCollection(collection);

        // Add Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Collection.class);
        indexer.reindex(collection);

        return collection;
    }


    public Collection getCollection(String title)
            throws PortalException, SystemException {
        return collectionPersistence.findByTitle(title);
    }

    private JournalArticle createNewArticle(Collection collection, User user, ServiceContext serviceContext)
            throws SystemException, PortalException {
        Map<Locale, String> titleMap = new HashMap<Locale, String>();
        titleMap.put(LocaleUtil.getDefault(), collection.getTitle());
        // Map<Locale, String> descriptionMap =  new HashMap<Locale, String>();
        String en_ES = LocaleUtil.getDefault().toString();
        String content = "<?xml version='"+1.0+"'?><root available-locales='"+en_ES+"' default-locale='"+en_ES+"'><static-content language-id='"+en_ES+"'><![CDATA[Please Edit This Page.]]></static-content></root>";

        try {
            JournalArticle article = JournalArticleLocalServiceUtil.addArticle(
                    user.getUserId(), collection.getGroupId(), 0,
                    titleMap, null, content, null, null, serviceContext);
            return article;
        } catch (PortalException | SystemException e) {
            e.printStackTrace();
            return null;
        }
    }

        /**
     * Save
     *
     * @param collection
     * @param serviceContext
     * @return Collection
     * @throws SystemException
     * @throws PortalException
     */
    public Collection save(CollectionClp collection, String contributorIds, String allowedUserIds, ServiceContext serviceContext) throws SystemException, PortalException {
        User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
        Date now = new Date();

        Collection saveCollection = new CollectionClp();

        long collectionId = collection.getCollectionId();
        JournalArticle article = null;

        boolean createNewCollection = false;
        if (collectionId > 0) {
            _log.debug("### update=" + collectionId);

            saveCollection = collectionPersistence.findByPrimaryKey(collectionId);
            SdrBeanUtils.copyProperties(collection, saveCollection);
            saveCollection.setSkipCurate(collection.getSkipCurate());
//			saveCollection.setModifiedDate(now); //수정일 반영 시
            _log.debug("collection:::" + collection.toString());
            _log.debug("saveCollection:::" + saveCollection.toString());
        } else {
            createNewCollection = true;
            collectionId = counterLocalService.increment();

            saveCollection = collectionPersistence.create(collectionId);
            SdrBeanUtils.copyProperties(collection, saveCollection);

            saveCollection.setUserId(user.getUserId());
            saveCollection.setCreateDate(now);
            saveCollection.setCompanyId(serviceContext.getCompanyId());

            String doi = FileService.mintDOI(collectionId);
            saveCollection.setDoi(doi);
            saveCollection.setSkipCurate(false);

            saveCollection.setAccessPolicy(PermissionConstant.getDefaultPerm());
            _log.debug("### insert=" + collectionId);

            article = createNewArticle(collection, user, serviceContext) ;
        }

        _log.debug("save:::" + saveCollection.toString());
        collectionPersistence.update(saveCollection);

        // Let the below code do not have Access Control. The above code already has it.
        CollectionVo collectionVo = new CollectionVo();

        Collection_UserLocalServiceUtil.deleteCollection_UserByCollectionId(collection.getCollectionId());
        if (!StringUtils.isEmpty(contributorIds)) {
            collectionVo.setContributorIds(contributorIds);

            for (long contributor : collectionVo.getContributors()) {
                Collection_UserLocalServiceUtil.addCollection_User(collection.getCollectionId(), contributor);
            }
        }

        Collection_AllowedUserLocalServiceUtil.deleteCollection_AllowedUser(collection.getCollectionId());

        if (!StringUtils.isEmpty(allowedUserIds)) {
            collectionVo.setAllowedUserIds(allowedUserIds);
            for (long allowedUser : collectionVo.getAllowedUsers()) {
                Collection_AllowedUserLocalServiceUtil.addCollection_AllowedUser(collection.getCollectionId(), allowedUser);
            }
        }


        // Add Asset
        AssetEntry assetEntry = assetEntryLocalService.updateEntry(saveCollection.getUserId(), saveCollection.getGroupId(),
                saveCollection.getCreateDate(), null, Collection.class.getName(), saveCollection.getCollectionId(), null, 0,
                serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, null, null, null,
                ContentTypes.TEXT_HTML, saveCollection.getTitle(), null, null, null, null, 0, 0, null, false);


        if ( createNewCollection ) {
            _log.debug("key ::: " + article.getResourcePrimKey());
            //article = JournalArticleLocalServiceUtil.getArticle(serviceContext.getScopeGroupId(), article.getArticleId());
            //_log.debug("key ::: " + article.getResourcePrimKey());
            AssetEntry jAssetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), article.getResourcePrimKey());
            long[] assetLink = { jAssetEntry.getEntryId() };
            assetLinkLocalService.updateLinks(saveCollection.getUserId(), assetEntry.getEntryId(),
                    assetLink, AssetLinkConstants.TYPE_RELATED);
        }
        
        assetEntries_AssetTagsLocalService.save(assetEntry.getEntryId());

        // Add Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Collection.class);
        indexer.reindex(saveCollection);

        return saveCollection;
    }

    /**
     * Delete
     *
     * @param collectionId
     * @return Collection
     * @throws SystemException
     * @throws PortalException
     */
    public Collection delete(Long collectionId, ServiceContext serviceContext) throws SystemException, PortalException {
//		Date now = new Date();
        _log.debug("delete:::" + collectionId);


        if (DatasetLocalServiceUtil.getCount(collectionId) > 0) {
            // TODO: Error Handling
            _log.debug("It is not allowed to remove this collection. It has more than one dataset.");
            throw new PortalException("It is not allowed to remove this collection. It has more than one dataset.");
        }

        Collection collection = collectionPersistence.findByPrimaryKey(collectionId);
        MBMessageLocalServiceUtil.deleteDiscussionMessages(Collection.class.getName(), collectionId);
        Collection_AllowedUserLocalServiceUtil.deleteCollection_AllowedUser(collectionId);
        Collection_UserLocalServiceUtil.deleteCollection_User(collectionId);
        _log.debug("delete:::" + collection);

        //TODO: 테스트용
        deleteCollection(collectionId);
        //collectionPersistence.remove(collectionId);

        // Delete Asset
        AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Collection.class.getName(), collectionId);
        if (assetEntry != null) {
            deleteArticle(assetEntry, collection.getGroupId(), serviceContext );

            _log.debug("deleting asset");
            assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
            assetEntries_AssetTagsLocalService.delete(assetEntry.getEntryId());
            assetEntryLocalService.deleteEntry(assetEntry);
            _log.debug("deleted asset");
        }

        _log.debug("deleting index");
        // Delete Index : The above deleteCollection is supposed to delete index, but it does not work at this moment
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Collection.class);
        indexer.delete(collection);
        _log.debug("deleted index");

		//delete files
		String collectionPath = FileService.getCollectionPath(collectionId);
		FileUtil.deltree(new File(collectionPath));
		_log.debug("deleted collection files : " + collectionPath);

        return collection;
    }

    private void deleteArticle(AssetEntry assetEntry, long groupId, ServiceContext serviceContext)
            throws SystemException, PortalException {
        JournalArticle ja = (JournalArticle) getRelatedAsset(assetEntry, JournalArticle.class.getName());
        if (ja != null) {
            _log.debug("article :: " + ja.getArticleId());
            JournalArticleLocalServiceUtil.deleteArticle(groupId, ja.getArticleId(), serviceContext );
        } else {
            _log.debug("No article is attached to the collection");
        }
    }


    public Object getRelatedAsset(AssetEntry assetEntry, String className) {
        AssetEntry jAssetEntry = null;
        try {
            _log.debug("looking for ::: " + className);
            List<AssetLink> assetLinks = AssetLinkLocalServiceUtil.getLinks(assetEntry.getEntryId());
            for (AssetLink al : assetLinks) {
                try {
                // log.debug("asset link ::: " + al.getEntryId1()  + " ::: " + al.getEntryId2());
                    if (assetEntry.getEntryId() == al.getEntryId1()) {
                        _log.debug("Found asset link ::: " + al.getEntryId2());
                        jAssetEntry = AssetEntryLocalServiceUtil.getAssetEntry(al.getEntryId2());
                        _log.debug("asset link class pk::: " + jAssetEntry.getClassPK() + " :::" + jAssetEntry.getClassName() + ":::" );

                        if ( jAssetEntry.getClassName().equals( className ) ) {
                            if ( className.equals(JournalArticle.class.getName())) {
                                JournalArticle ja = JournalArticleLocalServiceUtil.getLatestArticle(jAssetEntry.getClassPK());
                                _log.debug("article :: " + ja.getArticleId());
                                return ja;
                            } else if ( className.equals(DLFileEntry.class.getName())) {
                                DLFileEntry fe = DLFileEntryLocalServiceUtil.getDLFileEntry(jAssetEntry.getClassPK());
                                _log.debug("file entry :: " + fe.getFileEntryId());
                                return fe;
                            } else {
                                _log.debug("Type mismatch :: " + jAssetEntry.getClassName() + " ::: " + JournalArticle.class.getName());
                                continue;
                            }
                        }
                    }
                } catch (NoSuchEntryException e) {
                    continue;
                }
            }
        } catch ( PortalException | SystemException e ) {
            return null;
        }

        if ( jAssetEntry == null ) {
            _log.error("no article found :: ");
            // throw new SystemException("no article is linked to the collection");
            return null;
        }
        _log.error("You should not reach here !!! ");
        return null;
    }

    public JournalArticle getRelatedArticle(long collectionId) {
        AssetEntry jAssetEntry = null;
        try {
            AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(Collection.class.getName(), collectionId);
            // log.debug("asset entry ID :::" + assetEntry.getEntryId());
            return (JournalArticle) getRelatedAsset(assetEntry, JournalArticle.class.getName());
        } catch ( SystemException | PortalException e ) {
            return null;
        }
    }

    public DLFileEntry getRelatedFileEntry(long collectionId) {
        AssetEntry jAssetEntry = null;
        try {
            AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(Collection.class.getName(), collectionId);
            // log.debug("asset entry ID :::" + assetEntry.getEntryId());
            return (DLFileEntry) getRelatedAsset(assetEntry, DLFileEntry.class.getName());
        } catch ( SystemException | PortalException e ) {
            return null;
        }
    }


    public void reindexAllCollections() throws SystemException, PortalException {

        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Collection.class);

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());


        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);
        mainQuery.addExactTerm(Field.ENTRY_CLASS_NAME, Collection.class.getName());

        _log.debug("mainQuery : " + mainQuery);

        Hits hits = SearchEngineUtil.search(searchContext, mainQuery);

        int count = hits.getLength();

        _log.debug("dropping all collection indexes : " + count);

        for (int i = 0; i < count; i++) {
            Document doc = hits.doc(i);
            _log.debug("dropping  : " + doc.getUID());
            indexer.delete(Long.parseLong(doc.get(Field.COMPANY_ID)), doc.getUID());
        }

        count = getCount();
        _log.debug("reindex all collections : " + count);

        List<Collection> collectionList = getList();
         _log.debug("# collections ::: " + collectionList.size());

        for ( Collection col : collectionList ) {
            _log.debug("reindex ::: " + col.getTitle());
            indexer.reindex(col);
        }
    }


}