package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.sdr.metadata.model.ApiKeyClp;
import com.sdr.metadata.model.AssetEntries_AssetTagsClp;
import com.sdr.metadata.model.CollectionClp;
import com.sdr.metadata.model.Collection_AllowedUserClp;
import com.sdr.metadata.model.Collection_UserClp;
import com.sdr.metadata.model.CurateClp;
import com.sdr.metadata.model.CurationJobClp;
import com.sdr.metadata.model.DataTypeClp;
import com.sdr.metadata.model.DataTypeSchemaClp;
import com.sdr.metadata.model.DataType_dataTypeSchema_essentialClp;
import com.sdr.metadata.model.DataViewClp;
import com.sdr.metadata.model.DataViewComponentsClp;
import com.sdr.metadata.model.DatasetClp;
import com.sdr.metadata.model.DatatypeRuleClp;
import com.sdr.metadata.model.GroupRuleClp;
import com.sdr.metadata.model.IceBreakerVcTokenClp;
import com.sdr.metadata.model.MlGuiParameterClp;
import com.sdr.metadata.model.PpLogicClp;
import com.sdr.metadata.model.ReqMakeSiteClp;
import com.sdr.metadata.model.SdrOrganizationsClp;
import com.sdr.metadata.model.SdrUsersClp;
import com.sdr.metadata.model.SimulationJobClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "SDR_base-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "SDR_base-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "SDR_base-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(ApiKeyClp.class.getName())) {
            return translateInputApiKey(oldModel);
        }

        if (oldModelClassName.equals(AssetEntries_AssetTagsClp.class.getName())) {
            return translateInputAssetEntries_AssetTags(oldModel);
        }

        if (oldModelClassName.equals(CollectionClp.class.getName())) {
            return translateInputCollection(oldModel);
        }

        if (oldModelClassName.equals(Collection_AllowedUserClp.class.getName())) {
            return translateInputCollection_AllowedUser(oldModel);
        }

        if (oldModelClassName.equals(Collection_UserClp.class.getName())) {
            return translateInputCollection_User(oldModel);
        }

        if (oldModelClassName.equals(CurateClp.class.getName())) {
            return translateInputCurate(oldModel);
        }

        if (oldModelClassName.equals(CurationJobClp.class.getName())) {
            return translateInputCurationJob(oldModel);
        }

        if (oldModelClassName.equals(DatasetClp.class.getName())) {
            return translateInputDataset(oldModel);
        }

        if (oldModelClassName.equals(DataTypeClp.class.getName())) {
            return translateInputDataType(oldModel);
        }

        if (oldModelClassName.equals(
                    DataType_dataTypeSchema_essentialClp.class.getName())) {
            return translateInputDataType_dataTypeSchema_essential(oldModel);
        }

        if (oldModelClassName.equals(DatatypeRuleClp.class.getName())) {
            return translateInputDatatypeRule(oldModel);
        }

        if (oldModelClassName.equals(DataTypeSchemaClp.class.getName())) {
            return translateInputDataTypeSchema(oldModel);
        }

        if (oldModelClassName.equals(DataViewClp.class.getName())) {
            return translateInputDataView(oldModel);
        }

        if (oldModelClassName.equals(DataViewComponentsClp.class.getName())) {
            return translateInputDataViewComponents(oldModel);
        }

        if (oldModelClassName.equals(GroupRuleClp.class.getName())) {
            return translateInputGroupRule(oldModel);
        }

        if (oldModelClassName.equals(IceBreakerVcTokenClp.class.getName())) {
            return translateInputIceBreakerVcToken(oldModel);
        }

        if (oldModelClassName.equals(MlGuiParameterClp.class.getName())) {
            return translateInputMlGuiParameter(oldModel);
        }

        if (oldModelClassName.equals(PpLogicClp.class.getName())) {
            return translateInputPpLogic(oldModel);
        }

        if (oldModelClassName.equals(ReqMakeSiteClp.class.getName())) {
            return translateInputReqMakeSite(oldModel);
        }

        if (oldModelClassName.equals(SdrOrganizationsClp.class.getName())) {
            return translateInputSdrOrganizations(oldModel);
        }

        if (oldModelClassName.equals(SdrUsersClp.class.getName())) {
            return translateInputSdrUsers(oldModel);
        }

        if (oldModelClassName.equals(SimulationJobClp.class.getName())) {
            return translateInputSimulationJob(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputApiKey(BaseModel<?> oldModel) {
        ApiKeyClp oldClpModel = (ApiKeyClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getApiKeyRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAssetEntries_AssetTags(
        BaseModel<?> oldModel) {
        AssetEntries_AssetTagsClp oldClpModel = (AssetEntries_AssetTagsClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAssetEntries_AssetTagsRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCollection(BaseModel<?> oldModel) {
        CollectionClp oldClpModel = (CollectionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCollectionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCollection_AllowedUser(
        BaseModel<?> oldModel) {
        Collection_AllowedUserClp oldClpModel = (Collection_AllowedUserClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCollection_AllowedUserRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCollection_User(BaseModel<?> oldModel) {
        Collection_UserClp oldClpModel = (Collection_UserClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCollection_UserRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCurate(BaseModel<?> oldModel) {
        CurateClp oldClpModel = (CurateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCurateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCurationJob(BaseModel<?> oldModel) {
        CurationJobClp oldClpModel = (CurationJobClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCurationJobRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputDataset(BaseModel<?> oldModel) {
        DatasetClp oldClpModel = (DatasetClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getDatasetRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputDataType(BaseModel<?> oldModel) {
        DataTypeClp oldClpModel = (DataTypeClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getDataTypeRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputDataType_dataTypeSchema_essential(
        BaseModel<?> oldModel) {
        DataType_dataTypeSchema_essentialClp oldClpModel = (DataType_dataTypeSchema_essentialClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getDataType_dataTypeSchema_essentialRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputDatatypeRule(BaseModel<?> oldModel) {
        DatatypeRuleClp oldClpModel = (DatatypeRuleClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getDatatypeRuleRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputDataTypeSchema(BaseModel<?> oldModel) {
        DataTypeSchemaClp oldClpModel = (DataTypeSchemaClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getDataTypeSchemaRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputDataView(BaseModel<?> oldModel) {
        DataViewClp oldClpModel = (DataViewClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getDataViewRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputDataViewComponents(BaseModel<?> oldModel) {
        DataViewComponentsClp oldClpModel = (DataViewComponentsClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getDataViewComponentsRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputGroupRule(BaseModel<?> oldModel) {
        GroupRuleClp oldClpModel = (GroupRuleClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getGroupRuleRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputIceBreakerVcToken(BaseModel<?> oldModel) {
        IceBreakerVcTokenClp oldClpModel = (IceBreakerVcTokenClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getIceBreakerVcTokenRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputMlGuiParameter(BaseModel<?> oldModel) {
        MlGuiParameterClp oldClpModel = (MlGuiParameterClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getMlGuiParameterRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputPpLogic(BaseModel<?> oldModel) {
        PpLogicClp oldClpModel = (PpLogicClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getPpLogicRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputReqMakeSite(BaseModel<?> oldModel) {
        ReqMakeSiteClp oldClpModel = (ReqMakeSiteClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getReqMakeSiteRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSdrOrganizations(BaseModel<?> oldModel) {
        SdrOrganizationsClp oldClpModel = (SdrOrganizationsClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSdrOrganizationsRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSdrUsers(BaseModel<?> oldModel) {
        SdrUsersClp oldClpModel = (SdrUsersClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSdrUsersRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSimulationJob(BaseModel<?> oldModel) {
        SimulationJobClp oldClpModel = (SimulationJobClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSimulationJobRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals("com.sdr.metadata.model.impl.ApiKeyImpl")) {
            return translateOutputApiKey(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.AssetEntries_AssetTagsImpl")) {
            return translateOutputAssetEntries_AssetTags(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.CollectionImpl")) {
            return translateOutputCollection(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.Collection_AllowedUserImpl")) {
            return translateOutputCollection_AllowedUser(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.Collection_UserImpl")) {
            return translateOutputCollection_User(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("com.sdr.metadata.model.impl.CurateImpl")) {
            return translateOutputCurate(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.CurationJobImpl")) {
            return translateOutputCurationJob(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("com.sdr.metadata.model.impl.DatasetImpl")) {
            return translateOutputDataset(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("com.sdr.metadata.model.impl.DataTypeImpl")) {
            return translateOutputDataType(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialImpl")) {
            return translateOutputDataType_dataTypeSchema_essential(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.DatatypeRuleImpl")) {
            return translateOutputDatatypeRule(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.DataTypeSchemaImpl")) {
            return translateOutputDataTypeSchema(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("com.sdr.metadata.model.impl.DataViewImpl")) {
            return translateOutputDataView(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.DataViewComponentsImpl")) {
            return translateOutputDataViewComponents(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.GroupRuleImpl")) {
            return translateOutputGroupRule(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.IceBreakerVcTokenImpl")) {
            return translateOutputIceBreakerVcToken(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.MlGuiParameterImpl")) {
            return translateOutputMlGuiParameter(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("com.sdr.metadata.model.impl.PpLogicImpl")) {
            return translateOutputPpLogic(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.ReqMakeSiteImpl")) {
            return translateOutputReqMakeSite(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.SdrOrganizationsImpl")) {
            return translateOutputSdrOrganizations(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("com.sdr.metadata.model.impl.SdrUsersImpl")) {
            return translateOutputSdrUsers(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.sdr.metadata.model.impl.SimulationJobImpl")) {
            return translateOutputSimulationJob(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("com.sdr.metadata.NoSuchApiKeyException")) {
            return new com.sdr.metadata.NoSuchApiKeyException();
        }

        if (className.equals(
                    "com.sdr.metadata.NoSuchAssetEntries_AssetTagsException")) {
            return new com.sdr.metadata.NoSuchAssetEntries_AssetTagsException();
        }

        if (className.equals("com.sdr.metadata.NoSuchCollectionException")) {
            return new com.sdr.metadata.NoSuchCollectionException();
        }

        if (className.equals(
                    "com.sdr.metadata.NoSuchCollection_AllowedUserException")) {
            return new com.sdr.metadata.NoSuchCollection_AllowedUserException();
        }

        if (className.equals("com.sdr.metadata.NoSuchCollection_UserException")) {
            return new com.sdr.metadata.NoSuchCollection_UserException();
        }

        if (className.equals("com.sdr.metadata.NoSuchCurateException")) {
            return new com.sdr.metadata.NoSuchCurateException();
        }

        if (className.equals("com.sdr.metadata.NoSuchCurationJobException")) {
            return new com.sdr.metadata.NoSuchCurationJobException();
        }

        if (className.equals("com.sdr.metadata.NoSuchDatasetException")) {
            return new com.sdr.metadata.NoSuchDatasetException();
        }

        if (className.equals("com.sdr.metadata.NoSuchDataTypeException")) {
            return new com.sdr.metadata.NoSuchDataTypeException();
        }

        if (className.equals(
                    "com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException")) {
            return new com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException();
        }

        if (className.equals("com.sdr.metadata.NoSuchDatatypeRuleException")) {
            return new com.sdr.metadata.NoSuchDatatypeRuleException();
        }

        if (className.equals("com.sdr.metadata.NoSuchDataTypeSchemaException")) {
            return new com.sdr.metadata.NoSuchDataTypeSchemaException();
        }

        if (className.equals("com.sdr.metadata.NoSuchDataViewException")) {
            return new com.sdr.metadata.NoSuchDataViewException();
        }

        if (className.equals(
                    "com.sdr.metadata.NoSuchDataViewComponentsException")) {
            return new com.sdr.metadata.NoSuchDataViewComponentsException();
        }

        if (className.equals("com.sdr.metadata.NoSuchGroupRuleException")) {
            return new com.sdr.metadata.NoSuchGroupRuleException();
        }

        if (className.equals(
                    "com.sdr.metadata.NoSuchIceBreakerVcTokenException")) {
            return new com.sdr.metadata.NoSuchIceBreakerVcTokenException();
        }

        if (className.equals("com.sdr.metadata.NoSuchMlGuiParameterException")) {
            return new com.sdr.metadata.NoSuchMlGuiParameterException();
        }

        if (className.equals("com.sdr.metadata.NoSuchPpLogicException")) {
            return new com.sdr.metadata.NoSuchPpLogicException();
        }

        if (className.equals("com.sdr.metadata.NoSuchReqMakeSiteException")) {
            return new com.sdr.metadata.NoSuchReqMakeSiteException();
        }

        if (className.equals("com.sdr.metadata.NoSuchSdrOrganizationsException")) {
            return new com.sdr.metadata.NoSuchSdrOrganizationsException();
        }

        if (className.equals("com.sdr.metadata.NoSuchSdrUsersException")) {
            return new com.sdr.metadata.NoSuchSdrUsersException();
        }

        if (className.equals("com.sdr.metadata.NoSuchSimulationJobException")) {
            return new com.sdr.metadata.NoSuchSimulationJobException();
        }

        return throwable;
    }

    public static Object translateOutputApiKey(BaseModel<?> oldModel) {
        ApiKeyClp newModel = new ApiKeyClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setApiKeyRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAssetEntries_AssetTags(
        BaseModel<?> oldModel) {
        AssetEntries_AssetTagsClp newModel = new AssetEntries_AssetTagsClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAssetEntries_AssetTagsRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCollection(BaseModel<?> oldModel) {
        CollectionClp newModel = new CollectionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCollectionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCollection_AllowedUser(
        BaseModel<?> oldModel) {
        Collection_AllowedUserClp newModel = new Collection_AllowedUserClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCollection_AllowedUserRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCollection_User(BaseModel<?> oldModel) {
        Collection_UserClp newModel = new Collection_UserClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCollection_UserRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCurate(BaseModel<?> oldModel) {
        CurateClp newModel = new CurateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCurateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCurationJob(BaseModel<?> oldModel) {
        CurationJobClp newModel = new CurationJobClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCurationJobRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputDataset(BaseModel<?> oldModel) {
        DatasetClp newModel = new DatasetClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setDatasetRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputDataType(BaseModel<?> oldModel) {
        DataTypeClp newModel = new DataTypeClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setDataTypeRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputDataType_dataTypeSchema_essential(
        BaseModel<?> oldModel) {
        DataType_dataTypeSchema_essentialClp newModel = new DataType_dataTypeSchema_essentialClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setDataType_dataTypeSchema_essentialRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputDatatypeRule(BaseModel<?> oldModel) {
        DatatypeRuleClp newModel = new DatatypeRuleClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setDatatypeRuleRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputDataTypeSchema(BaseModel<?> oldModel) {
        DataTypeSchemaClp newModel = new DataTypeSchemaClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setDataTypeSchemaRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputDataView(BaseModel<?> oldModel) {
        DataViewClp newModel = new DataViewClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setDataViewRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputDataViewComponents(
        BaseModel<?> oldModel) {
        DataViewComponentsClp newModel = new DataViewComponentsClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setDataViewComponentsRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputGroupRule(BaseModel<?> oldModel) {
        GroupRuleClp newModel = new GroupRuleClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setGroupRuleRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputIceBreakerVcToken(BaseModel<?> oldModel) {
        IceBreakerVcTokenClp newModel = new IceBreakerVcTokenClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setIceBreakerVcTokenRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputMlGuiParameter(BaseModel<?> oldModel) {
        MlGuiParameterClp newModel = new MlGuiParameterClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setMlGuiParameterRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputPpLogic(BaseModel<?> oldModel) {
        PpLogicClp newModel = new PpLogicClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setPpLogicRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputReqMakeSite(BaseModel<?> oldModel) {
        ReqMakeSiteClp newModel = new ReqMakeSiteClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setReqMakeSiteRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSdrOrganizations(BaseModel<?> oldModel) {
        SdrOrganizationsClp newModel = new SdrOrganizationsClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSdrOrganizationsRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSdrUsers(BaseModel<?> oldModel) {
        SdrUsersClp newModel = new SdrUsersClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSdrUsersRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSimulationJob(BaseModel<?> oldModel) {
        SimulationJobClp newModel = new SimulationJobClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSimulationJobRemoteModel(oldModel);

        return newModel;
    }
}
