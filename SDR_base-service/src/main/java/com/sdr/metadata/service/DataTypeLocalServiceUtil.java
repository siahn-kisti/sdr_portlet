package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DataType. This utility wraps
 * {@link com.sdr.metadata.service.impl.DataTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see DataTypeLocalService
 * @see com.sdr.metadata.service.base.DataTypeLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataTypeLocalServiceImpl
 * @generated
 */
public class DataTypeLocalServiceUtil {
    private static DataTypeLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DataTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the data type to the database. Also notifies the appropriate model listeners.
    *
    * @param dataType the data type
    * @return the data type that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType addDataType(
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addDataType(dataType);
    }

    /**
    * Creates a new data type with the primary key. Does not add the data type to the database.
    *
    * @param dataTypeId the primary key for the new data type
    * @return the new data type
    */
    public static com.sdr.metadata.model.DataType createDataType(
        long dataTypeId) {
        return getService().createDataType(dataTypeId);
    }

    /**
    * Deletes the data type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type that was removed
    * @throws PortalException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType deleteDataType(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataType(dataTypeId);
    }

    /**
    * Deletes the data type from the database. Also notifies the appropriate model listeners.
    *
    * @param dataType the data type
    * @return the data type that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType deleteDataType(
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataType(dataType);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.sdr.metadata.model.DataType fetchDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchDataType(dataTypeId);
    }

    /**
    * Returns the data type with the primary key.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type
    * @throws PortalException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType getDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataType(dataTypeId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the data types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data types
    * @param end the upper bound of the range of data types (not inclusive)
    * @return the range of data types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataTypes(start, end);
    }

    /**
    * Returns the number of data types.
    *
    * @return the number of data types
    * @throws SystemException if a system exception occurred
    */
    public static int getDataTypesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataTypesCount();
    }

    /**
    * Updates the data type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataType the data type
    * @return the data type that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType updateDataType(
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDataType(dataType);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypeSchemaDataType(long dataTypeSchemaId,
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addDataTypeSchemaDataType(dataTypeSchemaId, dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypeSchemaDataType(long dataTypeSchemaId,
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addDataTypeSchemaDataType(dataTypeSchemaId, dataType);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypeSchemaDataTypes(long dataTypeSchemaId,
        long[] dataTypeIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addDataTypeSchemaDataTypes(dataTypeSchemaId, dataTypeIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypeSchemaDataTypes(long dataTypeSchemaId,
        java.util.List<com.sdr.metadata.model.DataType> DataTypes)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addDataTypeSchemaDataTypes(dataTypeSchemaId, DataTypes);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void clearDataTypeSchemaDataTypes(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearDataTypeSchemaDataTypes(dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteDataTypeSchemaDataType(long dataTypeSchemaId,
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDataTypeSchemaDataType(dataTypeSchemaId, dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteDataTypeSchemaDataType(long dataTypeSchemaId,
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDataTypeSchemaDataType(dataTypeSchemaId, dataType);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteDataTypeSchemaDataTypes(long dataTypeSchemaId,
        long[] dataTypeIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDataTypeSchemaDataTypes(dataTypeSchemaId, dataTypeIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteDataTypeSchemaDataTypes(long dataTypeSchemaId,
        java.util.List<com.sdr.metadata.model.DataType> DataTypes)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDataTypeSchemaDataTypes(dataTypeSchemaId, DataTypes);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getDataTypeSchemaDataTypes(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataTypeSchemaDataTypes(dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getDataTypeSchemaDataTypes(
        long dataTypeSchemaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getDataTypeSchemaDataTypes(dataTypeSchemaId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getDataTypeSchemaDataTypes(
        long dataTypeSchemaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getDataTypeSchemaDataTypes(dataTypeSchemaId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static int getDataTypeSchemaDataTypesCount(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataTypeSchemaDataTypesCount(dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasDataTypeSchemaDataType(long dataTypeSchemaId,
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .hasDataTypeSchemaDataType(dataTypeSchemaId, dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasDataTypeSchemaDataTypes(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasDataTypeSchemaDataTypes(dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void setDataTypeSchemaDataTypes(long dataTypeSchemaId,
        long[] dataTypeIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().setDataTypeSchemaDataTypes(dataTypeSchemaId, dataTypeIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get list
    *
    * @return List<DataType>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getList()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList();
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @return List<DataType>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getList(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end);
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount();
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @return List<DataType>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword);
    }

    /**
    * Get count
    *
    * @param keyword
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword);
    }

    /**
    * Add data type
    *
    * @param Title
    * @param Description
    * @param curateRequired
    * @param fileValidationRule
    * @param location
    * @param serviceContext
    * @return DataType
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataType addDataType(long userId,
        java.lang.String Title, java.lang.String Description,
        boolean curateRequired, java.lang.String fileValidationRule,
        java.lang.String location, long defaultPpLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addDataType(userId, Title, Description, curateRequired,
            fileValidationRule, location, defaultPpLogicId, serviceContext);
    }

    /**
    * Update data type
    *
    * @param DataTypeID
    * @param Title
    * @param Description
    * @param curateRequired
    * @param fileValidationRule
    * @param location
    * @param serviceContext
    * @return DataType
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataType updateDataType(
        long DataTypeID, java.lang.String Title, java.lang.String Description,
        boolean curateRequired, java.lang.String fileValidationRule,
        java.lang.String location, long defaultPpLogicId, long allowedUserId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateDataType(DataTypeID, Title, Description,
            curateRequired, fileValidationRule, location, defaultPpLogicId,
            allowedUserId, status, serviceContext);
    }

    /**
    * Delete data type
    *
    * @param DataTypeID
    * @param serviceContext
    * @return DataType
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataType deleteDataType(
        long DataTypeID,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataType(DataTypeID, serviceContext);
    }

    /**
    * Get data type by title
    *
    * @param title
    * @return DataType
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataType getDataTypeByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataTypeByTitle(title);
    }

    /**
    * Save data type and schema
    *
    * @param datatype
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.DataType saveDataType(
        com.sdr.metadata.model.DataType datatype,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().saveDataType(datatype, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static DataTypeLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DataTypeLocalService.class.getName());

            if (invokableLocalService instanceof DataTypeLocalService) {
                _service = (DataTypeLocalService) invokableLocalService;
            } else {
                _service = new DataTypeLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(DataTypeLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DataTypeLocalService service) {
    }
}
