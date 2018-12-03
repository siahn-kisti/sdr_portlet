package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.sdr.metadata.model.AssetEntries_AssetTags;
import com.sdr.metadata.model.AssetEntries_AssetTagsClp;
import com.sdr.metadata.model.impl.AssetEntries_AssetTagsImpl;
import com.sdr.metadata.service.base.AssetEntries_AssetTagsLocalServiceBaseImpl;
import com.sdr.search.datasearch.facet.FacetSearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the asset entries_ asset tags local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.AssetEntries_AssetTagsLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.AssetEntries_AssetTagsLocalServiceBaseImpl
 * @see com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil
 */
public class AssetEntries_AssetTagsLocalServiceImpl
        extends AssetEntries_AssetTagsLocalServiceBaseImpl {

    /**
     * Save.
     *
     * @param entryId
     * @throws SystemException
     * @throws PortalException
     */
    public void save(Long entryId) throws SystemException, PortalException {

        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetEntries_AssetTags.class, AssetEntries_AssetTags.class.getClassLoader());
        dynamicQuery.add(PropertyFactoryUtil.forName("primaryKey.entryId").eq(entryId));
        List<AssetEntries_AssetTags> withDynamicQuery = assetEntries_AssetTagsPersistence.findWithDynamicQuery(dynamicQuery);

        if (withDynamicQuery.size() > 0) {
            delete(entryId);
        }

        List<AssetTag> entryTags = AssetTagLocalServiceUtil.getEntryTags(entryId);

        for (AssetTag assetTag : entryTags) {
            AssetEntries_AssetTags assetEntries_assetTags = new AssetEntries_AssetTagsClp();
            assetEntries_assetTags.setEntryId(entryId);
            assetEntries_assetTags.setTagId(assetTag.getTagId());
            assetEntries_AssetTagsPersistence.update(assetEntries_assetTags);
        }
    }

    /**
     * Delete.
     *
     * @param entryId
     * @throws SystemException
     * @throws PortalException
     */
    public void delete(Long entryId) throws SystemException, PortalException {

        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetEntries_AssetTags.class, AssetEntries_AssetTags.class.getClassLoader());
        dynamicQuery.add(PropertyFactoryUtil.forName("primaryKey.entryId").eq(entryId));
        List<AssetEntries_AssetTags> withDynamicQuery = assetEntries_AssetTagsPersistence.findWithDynamicQuery(dynamicQuery);

        for (AssetEntries_AssetTags assetTag : withDynamicQuery) {
            AssetEntries_AssetTags assetEntries_assetTags = new AssetEntries_AssetTagsClp();
            assetEntries_assetTags.setEntryId(entryId);
            assetEntries_assetTags.setTagId(assetTag.getTagId());
            assetEntries_AssetTagsPersistence.remove(assetEntries_assetTags);
        }
    }

	/**
	 * Get asset Map Data
	 *
	 * @param scopeGroupId
	 * @param tabName
	 * @param keywords
	 * @param searchSelect
	 * @param facetKeywords
	 *
	 * @throws SystemException
	 * @throws PortalException
	 *
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getAssetMap(Long scopeGroupId, Long scopeCompanyId, String tabName, String keywords, String searchSelect, String facetKeywords) throws SystemException, PortalException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> facetParams = new HashMap<String, Object>();

		if(scopeGroupId != null){
			try {
				if (scopeGroupId != GroupLocalServiceUtil.getGroup(scopeCompanyId, GroupConstants.GUEST).getGroupId()) {
					facetParams.put("groupId", Long.toString(scopeGroupId));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (!keywords.isEmpty()) {

			if (searchSelect.equals("id")) {
				facetParams.put("datasetId", keywords);
			} else if (searchSelect.equals("title")) {
//                problem with keyword "in"
//                subQuery.addTerm("title_sortable", keywords, true);
				facetParams.put("title", keywords);
			} else if (searchSelect.equals("description")) {
				facetParams.put("description", keywords);
			} else if (searchSelect.equals("titleDescription")) {
//                problem with keyword "in"
//                keywordQuery.addTerm("title_sortable", keywords, true);
				facetParams.put("titleDescription", keywords);
			}
		}

		if (tabName.equals("Collection")) {
			if (!facetKeywords.isEmpty()) {
				String[] facetKeys = facetKeywords.split(",");

				for (String facetKey : facetKeys) {
					String[] split = facetKey.split("_");
					if (split[0].equals("community")) {
						facetParams.put("groupId", split[1]);
					} else if (split[0].equals("contributor")) {
						for (int i = 1; i < split.length; i++) {
							facetParams.put("contributorId", split[i]);
						}

					} else if (split[0].equals("keyword")) {
						for (int i = 1; i < split.length; i++) {
							facetParams.put("assetTagIds", split[i]);
						}
					}
				}
			}
		} else {
			if (!facetKeywords.isEmpty()) {
				String[] facetKeys = facetKeywords.split(",");

				for (String facetKey : facetKeys) {
					String[] split = facetKey.split("_");
					if (split[0].equals("dataType")) {
						facetParams.put("dataTypeId", split[1]);
					} else if (split[0].equals("collection")) {
						facetParams.put("collectionId", split[1]);
					} else if (split[0].equals("keyword")) {
						for (int i = 1; i < split.length; i++) {
							facetParams.put("assetTagIds", split[i]);
						}
					}
				}
			}

			tabName = "Dataset";
		}

		FacetSearch.facetSearch(facetParams, resultMap, tabName.toLowerCase());

		return resultMap;
	}

}
