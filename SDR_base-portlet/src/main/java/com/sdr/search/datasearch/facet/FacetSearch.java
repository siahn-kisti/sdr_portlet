package com.sdr.search.datasearch.facet;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The type Facet search.
 */
public class FacetSearch {
    private static Log _log = LogFactoryUtil.getLog(FacetSearch.class);

    /**
     * Facet search map.
     *
     * @param facetParams the facet params
     * @param map         the map
     * @param flag        the flag
     * @return the map
     * @throws NumberFormatException the number format exception
     * @throws PortalException       the portal exception
     * @throws SystemException       the system exception
     */
    public static Map<String, Object> facetSearch(Map<String, Object> facetParams, Map<String, Object> map, String flag) throws NumberFormatException, PortalException, SystemException {

        _log.debug("### Facet Search In");

        DynamicQuery dynamicQuery = null;
        Criterion criterion = null;
        Long contributorId = null;
        Long assetTagIds = null;

        if (flag.equals("dataset")) {
            dynamicQuery = DatasetLocalServiceUtil.dynamicQuery();
            dynamicQuery.setProjection(ProjectionFactoryUtil.property("datasetId"));
            criterion = RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED);
        } else {
            dynamicQuery = CollectionLocalServiceUtil.dynamicQuery();
            dynamicQuery.setProjection(ProjectionFactoryUtil.property("collectionId"));
        }

        if (!facetParams.isEmpty()) {
            Iterator keywordItor = facetParams.keySet().iterator();

            while (keywordItor.hasNext()) {
                String key = (String) keywordItor.next();
                _log.debug(" ## : " + key + " : " + facetParams.get(key));
                if (key.equals("contributorId")) {
                    contributorId = Long.parseLong((String) facetParams.get(key));
                } else if (key.equals("assetTagIds")) {
                    assetTagIds = Long.parseLong((String) facetParams.get(key));
                }

                if (criterion == null) {
                    if (key.equals("title") || key.equals("description") || key.equals("titleDescription")) {

                        if (key.equals("titleDescription")) {
                            criterion = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.like("title", "%" + facetParams.get(key) + "%"), RestrictionsFactoryUtil.like("description", "%" + facetParams.get(key) + "%"));
                        } else {
                            criterion = RestrictionsFactoryUtil.like(key, "%" + facetParams.get(key) + "%");
                        }
                    } else if (key.equals("contributorId")) {
                        DynamicQuery contributorQuery = Collection_UserLocalServiceUtil.dynamicQuery().add(RestrictionsFactoryUtil.eq("primaryKey.userId", Long.parseLong((String) facetParams.get(key))));
                        contributorQuery.setProjection(ProjectionFactoryUtil.property("primaryKey." + flag + "Id"));
                        criterion = RestrictionsFactoryUtil.in(flag + "Id", Collection_UserLocalServiceUtil.dynamicQuery(contributorQuery));
                    } else if (key.equals("assetTagIds")) {
                        DynamicQuery entryIdQuery = AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery().add(RestrictionsFactoryUtil.eq("primaryKey.tagId", Long.parseLong((String) facetParams.get(key))));
                        entryIdQuery.setProjection(ProjectionFactoryUtil.property("primaryKey.entryId"));

                        DynamicQuery classPKQuery = AssetEntryLocalServiceUtil.dynamicQuery();
                        classPKQuery.add(RestrictionsFactoryUtil.in("entryId", AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery(entryIdQuery)));
                        classPKQuery.setProjection(ProjectionFactoryUtil.property("classPK"));

                        criterion = RestrictionsFactoryUtil.in(flag + "Id", AssetEntryLocalServiceUtil.dynamicQuery(classPKQuery));
                    } else {
                        long l = 0;
                        try {
                            l = Long.parseLong((String) facetParams.get(key));
                        } catch (NumberFormatException e) {

                        }
                        criterion = RestrictionsFactoryUtil.eq(key, l);
                    }
                } else {
                    if (key.equals("title") || key.equals("description") || key.equals("titleDescription")) {
                        if (key.equals("titleDescription")) {
                            criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.like("title", "%" + facetParams.get(key) + "%"), RestrictionsFactoryUtil.like("description", "%" + facetParams.get(key) + "%")));
                        } else {
                            criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like(key, "%" + facetParams.get(key) + "%"));
                        }
                    } else if (key.equals("contributorId")) {
                        DynamicQuery contributorQuery = Collection_UserLocalServiceUtil.dynamicQuery().add(RestrictionsFactoryUtil.eq("primaryKey.userId", Long.parseLong((String) facetParams.get(key))));
                        contributorQuery.setProjection(ProjectionFactoryUtil.property("primaryKey." + flag + "Id"));
                        criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.in(flag + "Id", Collection_UserLocalServiceUtil.dynamicQuery(contributorQuery)));
                    } else if (key.equals("assetTagIds")) {
                        DynamicQuery entryIdQuery = AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery().add(RestrictionsFactoryUtil.eq("primaryKey.tagId", Long.parseLong((String) facetParams.get(key))));
                        entryIdQuery.setProjection(ProjectionFactoryUtil.property("primaryKey.entryId"));
                        DynamicQuery classPKQuery = AssetEntryLocalServiceUtil.dynamicQuery();

                        classPKQuery.add(RestrictionsFactoryUtil.in("entryId", AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery(entryIdQuery)));
                        classPKQuery.setProjection(ProjectionFactoryUtil.property("classPK"));

                        criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.in(flag + "Id", AssetEntryLocalServiceUtil.dynamicQuery(classPKQuery)));
                    } else {
                        long l = 0;
                        try {
                            l = Long.parseLong((String) facetParams.get(key));
                        } catch (NumberFormatException e) {

                        }
                        criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq(key, l));
                    }
                }
            }
        }

        if (criterion != null) {
            dynamicQuery.add(criterion);
        }

        if (flag.equals("collection")) {
			List collectionIds = CollectionLocalServiceUtil.dynamicQuery(dynamicQuery);

            collectionCommunityFacet(collectionIds, map);
            collectionContributorFacet(dynamicQuery, map, contributorId);

        } else if (flag.equals("dataset")) {
			List collectionIds = CollectionLocalServiceUtil.getCollectionIds();

			collectionCommunityFacet(collectionIds, map);
            datasetCollectionFacet(dynamicQuery, map);
            datasetDataTypeFacet(dynamicQuery, map);
        }

        keywordFacet(dynamicQuery, map, assetTagIds, flag);

        return map;
    }

	/**
	 * Collection community facet
	 *
	 * @param collectionIds
	 * @return map
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static Map<String, Object> collectionCommunityFacet(List collectionIds) throws NumberFormatException, PortalException, SystemException {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		collectionCommunityFacet(collectionIds, resultMap);


		return resultMap;
	}

    /**
     * Collection community facet
     *
     * @param collectionIds
     * @param map
     * @return map
     * @throws NumberFormatException
     * @throws PortalException
     * @throws SystemException
     */
    private static Map<String, Object> collectionCommunityFacet(List collectionIds, Map<String, Object> map) throws NumberFormatException, PortalException, SystemException {

        DynamicQuery dynamicQuery1 = CollectionLocalServiceUtil.dynamicQuery();

        ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
        projectionList.add(ProjectionFactoryUtil.groupProperty("groupId"));
        projectionList.add(ProjectionFactoryUtil.rowCount(), "_count");
        dynamicQuery1.setProjection(projectionList);
        dynamicQuery1.addOrder(OrderFactoryUtil.desc("_count"));

        //List collectionId = CollectionLocalServiceUtil.dynamicQuery(dynamicQuery);
        if (collectionIds.size() > 0) {
            dynamicQuery1.add(RestrictionsFactoryUtil.in("collectionId", collectionIds));

            List<Object[]> dynamicList = CollectionLocalServiceUtil.dynamicQuery(dynamicQuery1);

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Iterator<Object[]> iterator = dynamicList.iterator();

            while (iterator.hasNext()) {

                Object[] next = iterator.next();
                Map<String, Object> fmap = new HashMap<String, Object>();

                fmap.put("communityId", (long) next[0]);
                fmap.put("communityName", GroupLocalServiceUtil.getGroup((long) next[0]).getName());
                fmap.put("communityCnt", (long) next[1]);

                list.add(fmap);
            }

            map.put("communityFacet", list);
        }

        return map;
    }

    /**
     * Collection contributor facet
     *
     * @param dynamicQuery
     * @param map
     * @param contributorId
     * @return map
     * @throws NumberFormatException
     * @throws PortalException
     * @throws SystemException
     */
    private static Map<String, Object> collectionContributorFacet(DynamicQuery dynamicQuery, Map<String, Object> map, Long contributorId) throws NumberFormatException, PortalException, SystemException {

        DynamicQuery dynamicQuery1 = Collection_UserLocalServiceUtil.dynamicQuery();

        Criterion criterion = null;

        List collectionId = CollectionLocalServiceUtil.dynamicQuery(dynamicQuery);

        if (collectionId.size() > 0) {

            criterion = RestrictionsFactoryUtil.in("primaryKey.collectionId", collectionId);
            if (contributorId != null) {
                criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("primaryKey.userId", contributorId));
            }

            dynamicQuery1.add(criterion);

            ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
            projectionList.add(ProjectionFactoryUtil.groupProperty("primaryKey.userId"));
            projectionList.add(ProjectionFactoryUtil.rowCount(), "_count");
            dynamicQuery1.setProjection(projectionList);
            dynamicQuery1.addOrder(OrderFactoryUtil.desc("_count"));

            List<Object[]> dynamicList = Collection_UserLocalServiceUtil.dynamicQuery(dynamicQuery1);

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Iterator<Object[]> iterator = dynamicList.iterator();

            while (iterator.hasNext()) {

                Object[] next = iterator.next();
                Map<String, Object> fmap = new HashMap<String, Object>();

                fmap.put("contributorId", (long) next[0]);
                fmap.put("contributorName", SdrUsersLocalServiceUtil.getSdrUsers((long) next[0]).getLastName() + " " + SdrUsersLocalServiceUtil.getSdrUsers((long) next[0]).getFirstName());
                fmap.put("contributorCnt", (long) next[1]);

                list.add(fmap);
            }

            map.put("contributorFacet", list);
        }

        return map;
    }

    /**
     * Dataset collection facet
     *
     * @param dynamicQuery
     * @param map
     * @return map
     * @throws NumberFormatException
     * @throws PortalException
     * @throws SystemException
     */
    private static Map<String, Object> datasetCollectionFacet(DynamicQuery dynamicQuery, Map<String, Object> map) throws NumberFormatException, PortalException, SystemException {

        DynamicQuery dynamicQuery1 = DatasetLocalServiceUtil.dynamicQuery();

        ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
        projectionList.add(ProjectionFactoryUtil.groupProperty("collectionId"));
        projectionList.add(ProjectionFactoryUtil.rowCount(), "_count");
        dynamicQuery1.setProjection(projectionList);
        dynamicQuery1.addOrder(OrderFactoryUtil.desc("_count"));

        List datasetId = DatasetLocalServiceUtil.dynamicQuery(dynamicQuery);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (datasetId.size() > 0) {
            dynamicQuery1.add(RestrictionsFactoryUtil.in("datasetId", datasetId));

            List<Object[]> dynamicList = DatasetLocalServiceUtil.dynamicQuery(dynamicQuery1);

            Iterator<Object[]> iterator = dynamicList.iterator();

            while (iterator.hasNext()) {

                Object[] next = iterator.next();
                Map<String, Object> fmap = new HashMap<String, Object>();

                fmap.put("collectionId", (long) next[0]);
                fmap.put("collectionName", CollectionLocalServiceUtil.getCollection((long) next[0]).getTitle());
                fmap.put("collectionCnt", (long) next[1]);

                list.add(fmap);
            }
        }
        map.put("collectionFacet", list);

        return map;
    }

    /**
     * Dataset data type facet
     *
     * @param dynamicQuery
     * @param map
     * @return map
     * @throws NumberFormatException
     * @throws PortalException
     * @throws SystemException
     */
    private static Map<String, Object> datasetDataTypeFacet(DynamicQuery dynamicQuery, Map<String, Object> map) throws NumberFormatException, PortalException, SystemException {

        DynamicQuery dynamicQuery1 = DatasetLocalServiceUtil.dynamicQuery();

        ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
        projectionList.add(ProjectionFactoryUtil.groupProperty("dataTypeId"));
        projectionList.add(ProjectionFactoryUtil.rowCount(), "_count");
        dynamicQuery1.setProjection(projectionList);
        dynamicQuery1.addOrder(OrderFactoryUtil.desc("_count"));

        List datasetId = DatasetLocalServiceUtil.dynamicQuery(dynamicQuery);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (datasetId.size() > 0) {

            dynamicQuery1.add(RestrictionsFactoryUtil.in("datasetId", datasetId));

            List<Object[]> dynamicList = DatasetLocalServiceUtil.dynamicQuery(dynamicQuery1);

            Iterator<Object[]> iterator = dynamicList.iterator();

            while (iterator.hasNext()) {

                Object[] next = iterator.next();
                Map<String, Object> fmap = new HashMap<String, Object>();

                fmap.put("dataTypeId", (long) next[0]);
                fmap.put("dataTypeName", DataTypeLocalServiceUtil.getDataType((long) next[0]).getTitle());
                fmap.put("dataTypeCnt", (long) next[1]);

                list.add(fmap);
            }
        }
        map.put("dataTypeFacet", list);

        return map;
    }

    /**
     * Keyword facet
     *
     * @param dynamicQuery
     * @param map
     * @param assetTagIds
     * @param flag
     * @return map
     * @throws NumberFormatException
     * @throws PortalException
     * @throws SystemException
     */
    private static Map<String, Object> keywordFacet(DynamicQuery dynamicQuery, Map<String, Object> map, Long assetTagIds, String flag) throws NumberFormatException, PortalException, SystemException {

        Criterion criterion = null;

        DynamicQuery dynamicQuery1 = AssetEntryLocalServiceUtil.dynamicQuery();
        dynamicQuery1.setProjection(ProjectionFactoryUtil.property("entryId"));

        List classPK = null;
        if (flag.equals("dataset")) {
            classPK = DatasetLocalServiceUtil.dynamicQuery(dynamicQuery);
            if (classPK.size() > 0) {
                criterion = RestrictionsFactoryUtil.eq("classNameId", ClassNameLocalServiceUtil.getClassNameId(Dataset.class.getName()));
                criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.in("classPK", classPK));
                dynamicQuery1.add(criterion);
            }
        } else {
            classPK = CollectionLocalServiceUtil.dynamicQuery(dynamicQuery);
            if (classPK.size() > 0) {
                criterion = RestrictionsFactoryUtil.eq("classNameId", ClassNameLocalServiceUtil.getClassNameId(Collection.class.getName()));
                criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.in("classPK", classPK));
                dynamicQuery1.add(criterion);
            }
        }

        DynamicQuery dynamicQuery2 = AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery();
        ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
        projectionList.add(ProjectionFactoryUtil.groupProperty("primaryKey.tagId"));
        projectionList.add(ProjectionFactoryUtil.rowCount(), "_count");
        dynamicQuery2.setProjection(projectionList);
        dynamicQuery2.addOrder(OrderFactoryUtil.desc("_count"));

        criterion = null;

        List entryId = AssetEntryLocalServiceUtil.dynamicQuery(dynamicQuery1);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (entryId.size() > 0 && classPK.size() > 0) {
            criterion = RestrictionsFactoryUtil.in("primaryKey.entryId", entryId);
            if (assetTagIds != null) {
                dynamicQuery2.add(RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("primaryKey.tagId", assetTagIds)));
            }
            dynamicQuery2.add(criterion);

            List<Object[]> dynamicList = AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery(dynamicQuery2);

            Iterator<Object[]> iterator = dynamicList.iterator();

            while (iterator.hasNext()) {

                Object[] next = iterator.next();
                Map<String, Object> fmap = new HashMap<String, Object>();

                fmap.put("keywordId", (long) next[0]);
                fmap.put("keywordName", AssetTagLocalServiceUtil.getTag((long) next[0]).getName());
                fmap.put("keywordCnt", (long) next[1]);

                list.add(fmap);
            }
        }

        map.put("keywordFacet", list);

        return map;
    }
}
