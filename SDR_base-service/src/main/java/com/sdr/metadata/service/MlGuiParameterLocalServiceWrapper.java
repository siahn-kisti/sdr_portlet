package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MlGuiParameterLocalService}.
 *
 * @author jaesung
 * @see MlGuiParameterLocalService
 * @generated
 */
public class MlGuiParameterLocalServiceWrapper
    implements MlGuiParameterLocalService,
        ServiceWrapper<MlGuiParameterLocalService> {
    private MlGuiParameterLocalService _mlGuiParameterLocalService;

    public MlGuiParameterLocalServiceWrapper(
        MlGuiParameterLocalService mlGuiParameterLocalService) {
        _mlGuiParameterLocalService = mlGuiParameterLocalService;
    }

    /**
    * Adds the ml gui parameter to the database. Also notifies the appropriate model listeners.
    *
    * @param mlGuiParameter the ml gui parameter
    * @return the ml gui parameter that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.MlGuiParameter addMlGuiParameter(
        com.sdr.metadata.model.MlGuiParameter mlGuiParameter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.addMlGuiParameter(mlGuiParameter);
    }

    /**
    * Creates a new ml gui parameter with the primary key. Does not add the ml gui parameter to the database.
    *
    * @param mlGuiParameterId the primary key for the new ml gui parameter
    * @return the new ml gui parameter
    */
    @Override
    public com.sdr.metadata.model.MlGuiParameter createMlGuiParameter(
        long mlGuiParameterId) {
        return _mlGuiParameterLocalService.createMlGuiParameter(mlGuiParameterId);
    }

    /**
    * Deletes the ml gui parameter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mlGuiParameterId the primary key of the ml gui parameter
    * @return the ml gui parameter that was removed
    * @throws PortalException if a ml gui parameter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.MlGuiParameter deleteMlGuiParameter(
        long mlGuiParameterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.deleteMlGuiParameter(mlGuiParameterId);
    }

    /**
    * Deletes the ml gui parameter from the database. Also notifies the appropriate model listeners.
    *
    * @param mlGuiParameter the ml gui parameter
    * @return the ml gui parameter that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.MlGuiParameter deleteMlGuiParameter(
        com.sdr.metadata.model.MlGuiParameter mlGuiParameter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.deleteMlGuiParameter(mlGuiParameter);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _mlGuiParameterLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.MlGuiParameter fetchMlGuiParameter(
        long mlGuiParameterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.fetchMlGuiParameter(mlGuiParameterId);
    }

    /**
    * Returns the ml gui parameter with the primary key.
    *
    * @param mlGuiParameterId the primary key of the ml gui parameter
    * @return the ml gui parameter
    * @throws PortalException if a ml gui parameter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.MlGuiParameter getMlGuiParameter(
        long mlGuiParameterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.getMlGuiParameter(mlGuiParameterId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the ml gui parameters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ml gui parameters
    * @param end the upper bound of the range of ml gui parameters (not inclusive)
    * @return the range of ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> getMlGuiParameters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.getMlGuiParameters(start, end);
    }

    /**
    * Returns the number of ml gui parameters.
    *
    * @return the number of ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getMlGuiParametersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.getMlGuiParametersCount();
    }

    /**
    * Updates the ml gui parameter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mlGuiParameter the ml gui parameter
    * @return the ml gui parameter that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.MlGuiParameter updateMlGuiParameter(
        com.sdr.metadata.model.MlGuiParameter mlGuiParameter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.updateMlGuiParameter(mlGuiParameter);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _mlGuiParameterLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _mlGuiParameterLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _mlGuiParameterLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * get child rows
    *
    * @param parentId long
    * @param kind String
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> getChildList(
        long parentId, java.lang.String kind)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.getChildList(parentId, kind);
    }

    /**
    * get child rows
    *
    * @param kind String
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> getList(
        java.lang.String kind)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterLocalService.getList(kind);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MlGuiParameterLocalService getWrappedMlGuiParameterLocalService() {
        return _mlGuiParameterLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMlGuiParameterLocalService(
        MlGuiParameterLocalService mlGuiParameterLocalService) {
        _mlGuiParameterLocalService = mlGuiParameterLocalService;
    }

    @Override
    public MlGuiParameterLocalService getWrappedService() {
        return _mlGuiParameterLocalService;
    }

    @Override
    public void setWrappedService(
        MlGuiParameterLocalService mlGuiParameterLocalService) {
        _mlGuiParameterLocalService = mlGuiParameterLocalService;
    }
}
