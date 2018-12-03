package com.sdr.metadata.service.base;

import com.sdr.metadata.service.SimulationJobLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class SimulationJobLocalServiceClpInvoker {
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
    private String _methodName160;
    private String[] _methodParameterTypes160;
    private String _methodName161;
    private String[] _methodParameterTypes161;
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

    public SimulationJobLocalServiceClpInvoker() {
        _methodName0 = "addSimulationJob";

        _methodParameterTypes0 = new String[] {
                "com.sdr.metadata.model.SimulationJob"
            };

        _methodName1 = "createSimulationJob";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteSimulationJob";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteSimulationJob";

        _methodParameterTypes3 = new String[] {
                "com.sdr.metadata.model.SimulationJob"
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

        _methodName10 = "fetchSimulationJob";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getSimulationJob";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getSimulationJobs";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getSimulationJobsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateSimulationJob";

        _methodParameterTypes15 = new String[] {
                "com.sdr.metadata.model.SimulationJob"
            };

        _methodName160 = "getBeanIdentifier";

        _methodParameterTypes160 = new String[] {  };

        _methodName161 = "setBeanIdentifier";

        _methodParameterTypes161 = new String[] { "java.lang.String" };

        _methodName166 = "getList";

        _methodParameterTypes166 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName167 = "getOnebySimUuid";

        _methodParameterTypes167 = new String[] { "java.lang.String" };

        _methodName168 = "getListbySimUuid";

        _methodParameterTypes168 = new String[] { "java.lang.String" };

        _methodName169 = "getOnebyJobUuid";

        _methodParameterTypes169 = new String[] { "java.lang.String" };

        _methodName170 = "getListbyJobUuid";

        _methodParameterTypes170 = new String[] { "java.lang.String" };

        _methodName171 = "createSimulationWithJob";

        _methodParameterTypes171 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName172 = "createSimulation";

        _methodParameterTypes172 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName174 = "executeJob";

        _methodParameterTypes174 = new String[] { "java.util.Map" };

        _methodName175 = "cancelJob";

        _methodParameterTypes175 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName176 = "statusJob";

        _methodParameterTypes176 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Integer[][]"
            };

        _methodName177 = "statusSimList";

        _methodParameterTypes177 = new String[] {
                "java.lang.String", "java.util.List"
            };

        _methodName178 = "updateSimulation";

        _methodParameterTypes178 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName179 = "deleteSimulation";

        _methodParameterTypes179 = new String[] {
                "java.lang.String", "com.sdr.metadata.model.SimulationJob"
            };

        _methodName180 = "uploadFile";

        _methodParameterTypes180 = new String[] {
                "java.lang.String", "java.io.File"
            };

        _methodName181 = "uploadFile";

        _methodParameterTypes181 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.io.File"
            };

        _methodName182 = "uploadAllFiles";

        _methodParameterTypes182 = new String[] {
                "java.lang.String", "com.sdr.metadata.model.Dataset",
                "java.util.List"
            };

        _methodName183 = "createFolderOnIb";

        _methodParameterTypes183 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName184 = "submitEdisonJob";

        _methodParameterTypes184 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "com.liferay.portal.kernel.json.JSONArray"
            };

        _methodName187 = "downloadFileJob";

        _methodParameterTypes187 = new String[] {
                "java.lang.String", "java.lang.String",
                "javax.portlet.ResourceResponse", "java.lang.Integer[][]"
            };

        _methodName188 = "storeInSdr";

        _methodParameterTypes188 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long", "long", "java.lang.String",
                "javax.portlet.ActionRequest", "javax.portlet.ActionResponse"
            };

        _methodName189 = "directView";

        _methodParameterTypes189 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.Integer[][]"
            };

        _methodName190 = "curateSend";

        _methodParameterTypes190 = new String[] {
                "com.sdr.metadata.model.Dataset",
                "com.liferay.portal.service.ServiceContext",
                "javax.portlet.ActionRequest"
            };

        _methodName191 = "getEdisonFiles";

        _methodParameterTypes191 = new String[] {
                "java.lang.String", "long", "long", "java.lang.Integer[][]",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName192 = "getEdisonInputMetadata";

        _methodParameterTypes192 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.Integer[][]"
            };

        _methodName193 = "getEdisonInputFiles";

        _methodParameterTypes193 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.Integer[][]"
            };

        _methodName194 = "getEdisonInput";

        _methodParameterTypes194 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.Integer[][]"
            };

        _methodName195 = "getEdisonOutput";

        _methodParameterTypes195 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.Integer[][]"
            };

        _methodName196 = "validateEdisonJob";

        _methodParameterTypes196 = new String[] {
                "java.lang.String", "java.lang.Integer[][]"
            };

        _methodName197 = "getErrorLog";

        _methodParameterTypes197 = new String[] {
                "java.lang.String", "com.sdr.metadata.model.SimulationJob"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return SimulationJobLocalServiceUtil.addSimulationJob((com.sdr.metadata.model.SimulationJob) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return SimulationJobLocalServiceUtil.createSimulationJob(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return SimulationJobLocalServiceUtil.deleteSimulationJob(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return SimulationJobLocalServiceUtil.deleteSimulationJob((com.sdr.metadata.model.SimulationJob) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return SimulationJobLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return SimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return SimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return SimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return SimulationJobLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return SimulationJobLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return SimulationJobLocalServiceUtil.fetchSimulationJob(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getSimulationJob(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getSimulationJobs(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getSimulationJobsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return SimulationJobLocalServiceUtil.updateSimulationJob((com.sdr.metadata.model.SimulationJob) arguments[0]);
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            SimulationJobLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getList(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getOnebySimUuid((java.lang.String) arguments[0]);
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getListbySimUuid((java.lang.String) arguments[0]);
        }

        if (_methodName169.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getOnebyJobUuid((java.lang.String) arguments[0]);
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getListbyJobUuid((java.lang.String) arguments[0]);
        }

        if (_methodName171.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
            return SimulationJobLocalServiceUtil.createSimulationWithJob((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName172.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
            return SimulationJobLocalServiceUtil.createSimulation((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName174.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
            return SimulationJobLocalServiceUtil.executeJob((java.util.Map) arguments[0]);
        }

        if (_methodName175.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
            return SimulationJobLocalServiceUtil.cancelJob((java.lang.String) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName176.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
            return SimulationJobLocalServiceUtil.statusJob((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.Integer[]) arguments[2]);
        }

        if (_methodName177.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
            return SimulationJobLocalServiceUtil.statusSimList((java.lang.String) arguments[0],
                (java.util.List<com.sdr.metadata.model.SimulationJob>) arguments[1]);
        }

        if (_methodName178.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
            return SimulationJobLocalServiceUtil.updateSimulation((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName179.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
            return SimulationJobLocalServiceUtil.deleteSimulation((java.lang.String) arguments[0],
                (com.sdr.metadata.model.SimulationJob) arguments[1]);
        }

        if (_methodName180.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
            return SimulationJobLocalServiceUtil.uploadFile((java.lang.String) arguments[0],
                (java.io.File) arguments[1]);
        }

        if (_methodName181.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
            return SimulationJobLocalServiceUtil.uploadFile((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3], (java.io.File) arguments[4]);
        }

        if (_methodName182.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
            return SimulationJobLocalServiceUtil.uploadAllFiles((java.lang.String) arguments[0],
                (com.sdr.metadata.model.Dataset) arguments[1],
                (java.util.List<java.io.File>) arguments[2]);
        }

        if (_methodName183.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
            return SimulationJobLocalServiceUtil.createFolderOnIb((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName184.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
            return SimulationJobLocalServiceUtil.submitEdisonJob(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (com.liferay.portal.kernel.json.JSONArray) arguments[4]);
        }

        if (_methodName187.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
            return SimulationJobLocalServiceUtil.downloadFileJob((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (javax.portlet.ResourceResponse) arguments[2],
                (java.lang.Integer[]) arguments[3]);
        }

        if (_methodName188.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
            return SimulationJobLocalServiceUtil.storeInSdr((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                ((Long) arguments[4]).longValue(),
                (java.lang.String) arguments[5],
                (javax.portlet.ActionRequest) arguments[6],
                (javax.portlet.ActionResponse) arguments[7]);
        }

        if (_methodName189.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
            return SimulationJobLocalServiceUtil.directView((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.Integer[]) arguments[3]);
        }

        if (_methodName190.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
            SimulationJobLocalServiceUtil.curateSend((com.sdr.metadata.model.Dataset) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1],
                (javax.portlet.ActionRequest) arguments[2]);

            return null;
        }

        if (_methodName191.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getEdisonFiles((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.Integer[]) arguments[3],
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName192.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getEdisonInputMetadata((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.Integer[]) arguments[3]);
        }

        if (_methodName193.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getEdisonInputFiles((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.Integer[]) arguments[3]);
        }

        if (_methodName194.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getEdisonInput((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.Integer[]) arguments[4]);
        }

        if (_methodName195.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getEdisonOutput((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.Integer[]) arguments[4]);
        }

        if (_methodName196.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
            return SimulationJobLocalServiceUtil.validateEdisonJob((java.lang.String) arguments[0],
                (java.lang.Integer[]) arguments[1]);
        }

        if (_methodName197.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
            return SimulationJobLocalServiceUtil.getErrorLog((java.lang.String) arguments[0],
                (com.sdr.metadata.model.SimulationJob) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
