package com.sdr.metadata.service.base;

import com.sdr.metadata.service.CollectionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class CollectionLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName170;
    private String[] _methodParameterTypes170;
    private String _methodName171;
    private String[] _methodParameterTypes171;
    private String _methodName176;
    private String[] _methodParameterTypes176;
    private String _methodName177;
    private String[] _methodParameterTypes177;
    private String _methodName178;
    private String[] _methodParameterTypes178;
    private String _methodName179;
    private String[] _methodParameterTypes179;
    private String _methodName180;
    private String[] _methodParameterTypes180;
    private String _methodName181;
    private String[] _methodParameterTypes181;
    private String _methodName182;
    private String[] _methodParameterTypes182;
    private String _methodName183;
    private String[] _methodParameterTypes183;
    private String _methodName184;
    private String[] _methodParameterTypes184;
    private String _methodName185;
    private String[] _methodParameterTypes185;
    private String _methodName186;
    private String[] _methodParameterTypes186;
    private String _methodName187;
    private String[] _methodParameterTypes187;
    private String _methodName188;
    private String[] _methodParameterTypes188;
    private String _methodName189;
    private String[] _methodParameterTypes189;
    private String _methodName190;
    private String[] _methodParameterTypes190;
    private String _methodName191;
    private String[] _methodParameterTypes191;
    private String _methodName192;
    private String[] _methodParameterTypes192;
    private String _methodName193;
    private String[] _methodParameterTypes193;
    private String _methodName194;
    private String[] _methodParameterTypes194;
    private String _methodName195;
    private String[] _methodParameterTypes195;
    private String _methodName196;
    private String[] _methodParameterTypes196;
    private String _methodName197;
    private String[] _methodParameterTypes197;
    private String _methodName198;
    private String[] _methodParameterTypes198;
    private String _methodName200;
    private String[] _methodParameterTypes200;
    private String _methodName201;
    private String[] _methodParameterTypes201;
    private String _methodName203;
    private String[] _methodParameterTypes203;
    private String _methodName204;
    private String[] _methodParameterTypes204;
    private String _methodName205;
    private String[] _methodParameterTypes205;
    private String _methodName206;
    private String[] _methodParameterTypes206;

    public CollectionLocalServiceClpInvoker() {
        _methodName0 = "addCollection";

        _methodParameterTypes0 = new String[] {
                "com.sdr.metadata.model.Collection"
            };

        _methodName1 = "createCollection";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteCollection";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteCollection";

        _methodParameterTypes3 = new String[] {
                "com.sdr.metadata.model.Collection"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchCollection";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getCollection";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getCollections";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getCollectionsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateCollection";

        _methodParameterTypes15 = new String[] {
                "com.sdr.metadata.model.Collection"
            };

        _methodName170 = "getBeanIdentifier";

        _methodParameterTypes170 = new String[] {  };

        _methodName171 = "setBeanIdentifier";

        _methodParameterTypes171 = new String[] { "java.lang.String" };

        _methodName176 = "getGroupId";

        _methodParameterTypes176 = new String[] { "long" };

        _methodName177 = "getCount";

        _methodParameterTypes177 = new String[] {  };

        _methodName178 = "getList";

        _methodParameterTypes178 = new String[] {  };

        _methodName179 = "getCollectionIds";

        _methodParameterTypes179 = new String[] {  };

        _methodName180 = "collectionCommunityMap";

        _methodParameterTypes180 = new String[] {  };

        _methodName181 = "getList";

        _methodParameterTypes181 = new String[] { "int", "int" };

        _methodName182 = "getListOrderBy";

        _methodParameterTypes182 = new String[] {
                "int", "int", "com.liferay.portal.kernel.util.OrderByComparator",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName183 = "getList";

        _methodParameterTypes183 = new String[] { "int", "int", "java.lang.String" };

        _methodName184 = "getList";

        _methodParameterTypes184 = new String[] { "long" };

        _methodName185 = "getList";

        _methodParameterTypes185 = new String[] { "long", "int", "int" };

        _methodName186 = "getList";

        _methodParameterTypes186 = new String[] {
                "long", "int", "int", "java.lang.String"
            };

        _methodName187 = "getWritableList";

        _methodParameterTypes187 = new String[] {
                "int", "int", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName188 = "getWritableList";

        _methodParameterTypes188 = new String[] {
                "long", "int", "int", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName189 = "getCount";

        _methodParameterTypes189 = new String[] { "long" };

        _methodName190 = "getListByDatasetUserId";

        _methodParameterTypes190 = new String[] { "long" };

        _methodName191 = "getListByDatasetUserId";

        _methodParameterTypes191 = new String[] { "long", "int", "int" };

        _methodName192 = "getCountByDatasetUserId";

        _methodParameterTypes192 = new String[] { "long" };

        _methodName193 = "search";

        _methodParameterTypes193 = new String[] {
                "javax.portlet.RenderRequest", "javax.portlet.RenderResponse"
            };

        _methodName194 = "search";

        _methodParameterTypes194 = new String[] {
                "javax.portlet.ResourceRequest",
                "javax.portlet.ResourceResponse"
            };

        _methodName195 = "search";

        _methodParameterTypes195 = new String[] {
                "javax.portlet.PortletRequest",
                "com.liferay.portal.kernel.portlet.LiferayPortletURL"
            };

        _methodName196 = "convertVoToMap";

        _methodParameterTypes196 = new String[] { "java.util.List" };

        _methodName197 = "setPermission";

        _methodParameterTypes197 = new String[] { "long", "int" };

        _methodName198 = "getCollection";

        _methodParameterTypes198 = new String[] { "java.lang.String" };

        _methodName200 = "save";

        _methodParameterTypes200 = new String[] {
                "com.sdr.metadata.model.CollectionClp", "java.lang.String",
                "java.lang.String", "com.liferay.portal.service.ServiceContext"
            };

        _methodName201 = "delete";

        _methodParameterTypes201 = new String[] {
                "java.lang.Long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName203 = "getRelatedAsset";

        _methodParameterTypes203 = new String[] {
                "com.liferay.portlet.asset.model.AssetEntry", "java.lang.String"
            };

        _methodName204 = "getRelatedArticle";

        _methodParameterTypes204 = new String[] { "long" };

        _methodName205 = "getRelatedFileEntry";

        _methodParameterTypes205 = new String[] { "long" };

        _methodName206 = "reindexAllCollections";

        _methodParameterTypes206 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return CollectionLocalServiceUtil.addCollection((com.sdr.metadata.model.Collection) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return CollectionLocalServiceUtil.createCollection(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return CollectionLocalServiceUtil.deleteCollection(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return CollectionLocalServiceUtil.deleteCollection((com.sdr.metadata.model.Collection) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return CollectionLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return CollectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return CollectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return CollectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return CollectionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return CollectionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return CollectionLocalServiceUtil.fetchCollection(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return CollectionLocalServiceUtil.getCollection(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return CollectionLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return CollectionLocalServiceUtil.getCollections(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return CollectionLocalServiceUtil.getCollectionsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return CollectionLocalServiceUtil.updateCollection((com.sdr.metadata.model.Collection) arguments[0]);
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            return CollectionLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName171.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
            CollectionLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName176.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
            return CollectionLocalServiceUtil.getGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName177.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
            return CollectionLocalServiceUtil.getCount();
        }

        if (_methodName178.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
            return CollectionLocalServiceUtil.getList();
        }

        if (_methodName179.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
            return CollectionLocalServiceUtil.getCollectionIds();
        }

        if (_methodName180.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
            return CollectionLocalServiceUtil.collectionCommunityMap();
        }

        if (_methodName181.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
            return CollectionLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName182.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
            return CollectionLocalServiceUtil.getListOrderBy(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName183.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
            return CollectionLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName184.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
            return CollectionLocalServiceUtil.getList(((Long) arguments[0]).longValue());
        }

        if (_methodName185.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
            return CollectionLocalServiceUtil.getList(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName186.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
            return CollectionLocalServiceUtil.getList(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (java.lang.String) arguments[3]);
        }

        if (_methodName187.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
            return CollectionLocalServiceUtil.getWritableList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName188.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
            return CollectionLocalServiceUtil.getWritableList(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (java.lang.String) arguments[3],
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName189.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
            return CollectionLocalServiceUtil.getCount(((Long) arguments[0]).longValue());
        }

        if (_methodName190.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
            return CollectionLocalServiceUtil.getListByDatasetUserId(((Long) arguments[0]).longValue());
        }

        if (_methodName191.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
            return CollectionLocalServiceUtil.getListByDatasetUserId(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName192.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
            return CollectionLocalServiceUtil.getCountByDatasetUserId(((Long) arguments[0]).longValue());
        }

        if (_methodName193.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
            return CollectionLocalServiceUtil.search((javax.portlet.RenderRequest) arguments[0],
                (javax.portlet.RenderResponse) arguments[1]);
        }

        if (_methodName194.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
            return CollectionLocalServiceUtil.search((javax.portlet.ResourceRequest) arguments[0],
                (javax.portlet.ResourceResponse) arguments[1]);
        }

        if (_methodName195.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
            return CollectionLocalServiceUtil.search((javax.portlet.PortletRequest) arguments[0],
                (com.liferay.portal.kernel.portlet.LiferayPortletURL) arguments[1]);
        }

        if (_methodName196.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
            return CollectionLocalServiceUtil.convertVoToMap((java.util.List<com.sdr.metadata.model.Collection>) arguments[0]);
        }

        if (_methodName197.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
            return CollectionLocalServiceUtil.setPermission(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName198.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
            return CollectionLocalServiceUtil.getCollection((java.lang.String) arguments[0]);
        }

        if (_methodName200.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
            return CollectionLocalServiceUtil.save((com.sdr.metadata.model.CollectionClp) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName201.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
            return CollectionLocalServiceUtil.delete((java.lang.Long) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName203.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
            return CollectionLocalServiceUtil.getRelatedAsset((com.liferay.portlet.asset.model.AssetEntry) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName204.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
            return CollectionLocalServiceUtil.getRelatedArticle(((Long) arguments[0]).longValue());
        }

        if (_methodName205.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
            return CollectionLocalServiceUtil.getRelatedFileEntry(((Long) arguments[0]).longValue());
        }

        if (_methodName206.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
            CollectionLocalServiceUtil.reindexAllCollections();

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
