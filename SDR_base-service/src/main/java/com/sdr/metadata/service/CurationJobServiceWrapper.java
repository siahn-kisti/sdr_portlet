package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CurationJobService}.
 *
 * @author jaesung
 * @see CurationJobService
 * @generated
 */
public class CurationJobServiceWrapper implements CurationJobService,
    ServiceWrapper<CurationJobService> {
    private CurationJobService _curationJobService;

    public CurationJobServiceWrapper(CurationJobService curationJobService) {
        _curationJobService = curationJobService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _curationJobService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _curationJobService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _curationJobService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public boolean getCurationCallBack(int step, java.lang.String location,
        java.lang.String jobUuid, java.lang.String jobStatus,
        java.lang.String jobStartDt, java.lang.String jobEndDt) {
        return _curationJobService.getCurationCallBack(step, location, jobUuid,
            jobStatus, jobStartDt, jobEndDt);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CurationJobService getWrappedCurationJobService() {
        return _curationJobService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCurationJobService(
        CurationJobService curationJobService) {
        _curationJobService = curationJobService;
    }

    @Override
    public CurationJobService getWrappedService() {
        return _curationJobService;
    }

    @Override
    public void setWrappedService(CurationJobService curationJobService) {
        _curationJobService = curationJobService;
    }
}
