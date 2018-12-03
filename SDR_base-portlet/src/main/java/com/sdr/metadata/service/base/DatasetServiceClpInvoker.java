package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DatasetServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DatasetServiceClpInvoker {
    private String _methodName154;
    private String[] _methodParameterTypes154;
    private String _methodName155;
    private String[] _methodParameterTypes155;
    private String _methodName160;
    private String[] _methodParameterTypes160;
    private String _methodName161;
    private String[] _methodParameterTypes161;
    private String _methodName162;
    private String[] _methodParameterTypes162;
    private String _methodName163;
    private String[] _methodParameterTypes163;
    private String _methodName164;
    private String[] _methodParameterTypes164;
    private String _methodName165;
    private String[] _methodParameterTypes165;
    private String _methodName166;
    private String[] _methodParameterTypes166;
    private String _methodName167;
    private String[] _methodParameterTypes167;
    private String _methodName168;
    private String[] _methodParameterTypes168;
    private String _methodName169;
    private String[] _methodParameterTypes169;
    private String _methodName170;
    private String[] _methodParameterTypes170;
    private String _methodName171;
    private String[] _methodParameterTypes171;
    private String _methodName172;
    private String[] _methodParameterTypes172;
    private String _methodName173;
    private String[] _methodParameterTypes173;
    private String _methodName174;
    private String[] _methodParameterTypes174;
    private String _methodName175;
    private String[] _methodParameterTypes175;
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

    public DatasetServiceClpInvoker() {
        _methodName154 = "getBeanIdentifier";

        _methodParameterTypes154 = new String[] {  };

        _methodName155 = "setBeanIdentifier";

        _methodParameterTypes155 = new String[] { "java.lang.String" };

        _methodName160 = "getList";

        _methodParameterTypes160 = new String[] {
                "long", "int", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName161 = "getList";

        _methodParameterTypes161 = new String[] {
                "int", "int", "java.lang.String", "long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName162 = "getList";

        _methodParameterTypes162 = new String[] {
                "int", "int", "java.lang.String", "long", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName163 = "getList";

        _methodParameterTypes163 = new String[] {
                "int", "int", "java.lang.String", "long", "int"
            };

        _methodName164 = "getDataset";

        _methodParameterTypes164 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName165 = "search";

        _methodParameterTypes165 = new String[] {
                "javax.portlet.RenderRequest", "javax.portlet.RenderResponse"
            };

        _methodName166 = "querySearch";

        _methodParameterTypes166 = new String[] {
                "javax.portlet.RenderRequest", "javax.portlet.RenderResponse"
            };

        _methodName167 = "querySearchEngine";

        _methodParameterTypes167 = new String[] {
                "com.liferay.portal.service.ServiceContext",
                "com.liferay.portal.kernel.search.SearchContext",
                "com.liferay.portal.kernel.search.BooleanQuery"
            };

        _methodName168 = "querySearchEngine";

        _methodParameterTypes168 = new String[] {
                "com.liferay.portal.service.ServiceContext",
                "com.liferay.portal.kernel.search.SearchContext",
                "com.liferay.portal.kernel.search.BooleanQuery",
                "com.liferay.portal.kernel.dao.search.SearchContainer",
                "com.liferay.portal.kernel.search.Sort[][]"
            };

        _methodName169 = "createDataset";

        _methodParameterTypes169 = new String[] {
                "com.sdr.metadata.model.Dataset",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName170 = "save";

        _methodParameterTypes170 = new String[] {
                "com.sdr.metadata.model.DatasetClp",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName171 = "save";

        _methodParameterTypes171 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName172 = "update";

        _methodParameterTypes172 = new String[] {
                "long", "java.lang.Long", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName173 = "submit";

        _methodParameterTypes173 = new String[] {
                "long", "long", "java.lang.String", "java.io.File",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName174 = "submit";

        _methodParameterTypes174 = new String[] {
                "long", "long", "long", "java.lang.String", "java.io.File",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName175 = "submit";

        _methodParameterTypes175 = new String[] {
                "long", "long", "long", "long", "long", "java.lang.String",
                "java.io.File", "com.liferay.portal.service.ServiceContext"
            };

        _methodName176 = "save";

        _methodParameterTypes176 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "long", "int",
                "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName177 = "curate";

        _methodParameterTypes177 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName178 = "mlDatasetCurate";

        _methodParameterTypes178 = new String[] {
                "long", "long", "long", "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName179 = "directCurate";

        _methodParameterTypes179 = new String[] {
                "com.sdr.metadata.model.Dataset", "long",
                "java.lang.Integer[][]",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName180 = "submit";

        _methodParameterTypes180 = new String[] {
                "com.sdr.metadata.model.DatasetClp", "java.io.File",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName181 = "deleteDataset";

        _methodParameterTypes181 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName182 = "deleteDatasetAndFiles";

        _methodParameterTypes182 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName183 = "getGroupId";

        _methodParameterTypes183 = new String[] { "long" };

        _methodName184 = "checksumDataset";

        _methodParameterTypes184 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName185 = "findByVersion";

        _methodParameterTypes185 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName186 = "countByParent";

        _methodParameterTypes186 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return DatasetServiceUtil.getBeanIdentifier();
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            DatasetServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return DatasetServiceUtil.getList(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            return DatasetServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName162.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
            return DatasetServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                ((Integer) arguments[4]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[5]);
        }

        if (_methodName163.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
            return DatasetServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                ((Integer) arguments[4]).intValue());
        }

        if (_methodName164.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
            return DatasetServiceUtil.getDataset(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName165.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
            return DatasetServiceUtil.search((javax.portlet.RenderRequest) arguments[0],
                (javax.portlet.RenderResponse) arguments[1]);
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return DatasetServiceUtil.querySearch((javax.portlet.RenderRequest) arguments[0],
                (javax.portlet.RenderResponse) arguments[1]);
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            return DatasetServiceUtil.querySearchEngine((com.liferay.portal.service.ServiceContext) arguments[0],
                (com.liferay.portal.kernel.search.SearchContext) arguments[1],
                (com.liferay.portal.kernel.search.BooleanQuery) arguments[2]);
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return DatasetServiceUtil.querySearchEngine((com.liferay.portal.service.ServiceContext) arguments[0],
                (com.liferay.portal.kernel.search.SearchContext) arguments[1],
                (com.liferay.portal.kernel.search.BooleanQuery) arguments[2],
                (com.liferay.portal.kernel.dao.search.SearchContainer) arguments[3],
                (com.liferay.portal.kernel.search.Sort[]) arguments[4]);
        }

        if (_methodName169.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
            return DatasetServiceUtil.createDataset((com.sdr.metadata.model.Dataset) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            return DatasetServiceUtil.save((com.sdr.metadata.model.DatasetClp) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName171.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
            return DatasetServiceUtil.save(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Integer) arguments[4]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[5]);
        }

        if (_methodName172.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
            return DatasetServiceUtil.update(((Long) arguments[0]).longValue(),
                (java.lang.Long) arguments[1], (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName173.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
            return DatasetServiceUtil.submit(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.io.File) arguments[3],
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName174.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
            return DatasetServiceUtil.submit(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3], (java.io.File) arguments[4],
                (com.liferay.portal.service.ServiceContext) arguments[5]);
        }

        if (_methodName175.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
            return DatasetServiceUtil.submit(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                ((Long) arguments[3]).longValue(),
                ((Long) arguments[4]).longValue(),
                (java.lang.String) arguments[5], (java.io.File) arguments[6],
                (com.liferay.portal.service.ServiceContext) arguments[7]);
        }

        if (_methodName176.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
            return DatasetServiceUtil.save(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                ((Long) arguments[5]).longValue(),
                ((Integer) arguments[6]).intValue(),
                (java.lang.String) arguments[7],
                (java.lang.String) arguments[8],
                (com.liferay.portal.service.ServiceContext) arguments[9]);
        }

        if (_methodName177.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
            return DatasetServiceUtil.curate(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName178.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
            DatasetServiceUtil.mlDatasetCurate(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (com.liferay.portal.service.ServiceContext) arguments[5]);

            return null;
        }

        if (_methodName179.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
            DatasetServiceUtil.directCurate((com.sdr.metadata.model.Dataset) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.Integer[]) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);

            return null;
        }

        if (_methodName180.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
            return DatasetServiceUtil.submit((com.sdr.metadata.model.DatasetClp) arguments[0],
                (java.io.File) arguments[1],
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName181.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
            return DatasetServiceUtil.deleteDataset(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName182.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
            return DatasetServiceUtil.deleteDatasetAndFiles(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName183.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
            return DatasetServiceUtil.getGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName184.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
            return DatasetServiceUtil.checksumDataset(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName185.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
            return DatasetServiceUtil.findByVersion(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName186.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
            return DatasetServiceUtil.countByParent(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
