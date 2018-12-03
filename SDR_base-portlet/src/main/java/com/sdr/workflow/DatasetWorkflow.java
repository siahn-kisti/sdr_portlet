package com.sdr.workflow;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sdr.curation.CurateSender;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.DatasetClp;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.metadata.util.SdrBeanUtils;

import javax.portlet.PortletSession;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Dataset workflow.
 */
public class DatasetWorkflow {

    private static Log _log = LogFactoryUtil.getLog(DatasetWorkflow.class);
    private final static boolean _enable_versioning = false;


    /**
     * Signal workflow instance.
     *
     * @param companyId the company id
     * @param groupId   the group id
     * @param datasetId the dataset id
     * @param userId    the user id
     * @param status    the status
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    public static void signalWorkflowInstance(long companyId, long groupId, long datasetId, long userId, String status)
            throws PortalException, SystemException {
        WorkflowInstanceLink wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId,
                groupId, Dataset.class.getName(), datasetId);
        WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
                wil.getWorkflowInstanceId());
        WorkflowInstanceManagerUtil.signalWorkflowInstance(companyId, userId,
                wil.getWorkflowInstanceId(), status, workflowInstance.getWorkflowContext());

    }

    /**
     * Start workflow instance.
     *
     * @param dataset        the dataset
     * @param serviceContext the service context
     * @param collectionName the collection name
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    public static void startWorkflowInstance(Dataset dataset, ServiceContext serviceContext, String collectionName)
            throws PortalException, SystemException {
        _log.debug("### DatasetWorkflow startWorkflowInstance : start" + collectionName + " : " + serviceContext);

        if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(dataset.getCompanyId(), dataset.getGroupId(), Dataset.class.getName())) {
            _log.debug("### has workflow definition ");
            HashMap<String, Object> workflowContext = new HashMap<String, Object>();
            workflowContext.put("collectionName", collectionName);
            workflowContext.put("datasetName", dataset.getTitle());
            serviceContext.setAttribute("workflowContext", workflowContext);

            WorkflowHandlerRegistryUtil.startWorkflowInstance(
                    dataset.getCompanyId(), dataset.getGroupId(), dataset.getUserId(),
                    Dataset.class.getName(), dataset.getDatasetId(), dataset, serviceContext);

        } else {
            _log.debug("### no workflow definition ");
            //DatasetLocalServiceUtil.updateStatus(dataset.getUserId(),
            //        dataset.getDatasetId(), WorkflowConstants.STATUS_DRAFT, serviceContext);
            DatasetLocalServiceUtil.updateStatus(dataset.getUserId(),
                    dataset.getDatasetId(), WorkflowConstants.STATUS_SCHEDULED, serviceContext);
        }
        _log.debug("### DatasetWorkflow startWorkflowInstance : end");
    }

    /**
     * Delete workflow instance.
     *
     * @param companyId the company id
     * @param groupId   the group id
     * @param datasetId the dataset id
     * @param userId    the user id
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    public static void deleteWorkflowInstance(long companyId, long groupId, long datasetId, long userId) throws PortalException, SystemException {
        if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(companyId, groupId, Dataset.class.getName())) {

            WorkflowInstanceLink wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, groupId, Dataset.class.getName(), datasetId);
            WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, wil.getWorkflowInstanceId());

            Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
            User user = UserLocalServiceUtil.fetchUser(userId);

            if (user == null) {
                long validUserId = PortalUtil.getValidUserId(companyId, userId);

                workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, String.valueOf(validUserId));
            }

            WorkflowHandler workflowHandler = WorkflowHandlerRegistryUtil.getWorkflowHandler(Dataset.class.getName());
            workflowHandler.updateStatus(WorkflowConstants.STATUS_DRAFT, workflowContext);

            WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLink(companyId, groupId, Dataset.class.getName(), datasetId);
        }
    }

    /**
     * Status update.
     *
     * @param list           the list
     * @param flag           the flag
     * @param themeDisplay   the theme display
     * @param serviceContext the service context
     * @param portSession    the port session
     * @param workflowId     the workflow id
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    public static void statusUpdate(List<Dataset> list, String flag, ThemeDisplay themeDisplay, ServiceContext serviceContext, PortletSession portSession, String workflowId, List<Long> curationIdList) throws PortalException, SystemException {

        _log.debug("::: Workflow Status Update ::: workflowId::" + workflowId + " : " + flag);

        long userId = themeDisplay.getUserId();

        int statusNum = 0;
        String statusStr = null;
        flag = flag.toLowerCase();
        switch (flag) {
            case "reindex":
                statusStr = "reindex";
                // TODO : need to delete previous indexes
                break;
            case "approved":
            case "approve":
            case "accept":
                statusNum = WorkflowConstants.STATUS_APPROVED;
                statusStr = "approve";
                break;
            case "reject":
                statusNum = WorkflowConstants.STATUS_DENIED;
                statusStr = "reject";
                break;
            case "resubmit":
                statusNum = WorkflowConstants.STATUS_EXPIRED;
                statusStr = "resubmit";
                break;
            case "drop":
            case "dropndelete":
                statusNum = WorkflowConstants.STATUS_INACTIVE;
                statusStr = "inactive";
                break;
        }

        Map map = new HashMap();
        map.put("total", list.size());

        try {
            List<Long> dsIdList = new ArrayList<>();
            int dsCnt = 0;

            for (int i = 0; i < list.size(); i++) {
                Dataset dataset = list.get(i);

                if (statusStr.equals("reindex")) {
                    Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Dataset.class);
                    indexer.reindex(dataset);
                } else {
                    if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(dataset.getCompanyId(), dataset.getGroupId(), Dataset.class.getName())) {
                        if (statusStr.equals("resubmit")) {
                            cleanseFilesOnResubmit(dataset);

                            if (dataset.getStatus() == WorkflowConstants.STATUS_APPROVED) {
                                if ( _enable_versioning == true) {
                                    DatasetLocalServiceUtil.updateStatus(userId, dataset.getDatasetId(), WorkflowConstants.STATUS_INACTIVE, serviceContext);
                                    dataset.setDatasetId(0);
                                    dataset = DatasetLocalServiceUtil.save(dataset, serviceContext);
                                }
                                DatasetWorkflow.startWorkflowInstance(dataset, serviceContext, CollectionLocalServiceUtil.getCollection(dataset.getCollectionId()).getTitle());
                            } else {
                                DatasetWorkflow.signalWorkflowInstance(dataset.getCompanyId(), dataset.getGroupId(), dataset.getDatasetId(), userId, statusStr);
                            }

                            dsIdList.add(dataset.getDatasetId());
                            dsCnt++;
                        } else if (statusStr.equals("approve") || statusStr.equals("reject")) {
                            if (dataset.getStatus() != WorkflowConstants.STATUS_PENDING) {
                                continue;
                            }
                            DatasetWorkflow.signalWorkflowInstance(dataset.getCompanyId(), dataset.getGroupId(), dataset.getDatasetId(), userId, statusStr);
                            if (statusStr.equals("approve") && dataset.getStatus() != WorkflowConstants.STATUS_APPROVED) {
                                // DatasetLocalServiceUtil.updateStatus(userId, dataset.getDatasetId(), statusNum, null);
                            }
                        } else if (statusStr.equals("inactive")) {
                            cleanseFilesOnResubmit(dataset);

                            try {
                                DatasetWorkflow.deleteWorkflowInstance(dataset.getCompanyId(), dataset.getGroupId(), dataset.getDatasetId(), userId);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (flag.contains("delete")) {
                                String location = dataset.getLocation();
                                if (!location.isEmpty())  FileService.removeFile(location);
                            }
                            DatasetServiceUtil.deleteDataset(dataset.getDatasetId(), serviceContext);
                        }
                        _log.debug("--signalworkflowinstance -- " + statusStr);
                    } else {
                        if (statusStr == "resubmit") {
                            cleanseFilesOnResubmit(dataset);

                            if ( dataset.getStatus() == WorkflowConstants.STATUS_APPROVED) {
                                if ( _enable_versioning == true) {
                                    DatasetLocalServiceUtil.updateStatus(userId, dataset.getDatasetId(), WorkflowConstants.STATUS_INACTIVE, serviceContext);
                                    dataset.setDatasetId(0);
                                    dataset = DatasetLocalServiceUtil.save(dataset, serviceContext);
                                }
                            }
                            dsIdList.add(dataset.getDatasetId());
                            dsCnt++;
                            statusNum = WorkflowConstants.STATUS_SCHEDULED;
                        }

                        DatasetLocalServiceUtil.updateStatus(userId, dataset.getDatasetId(), statusNum, null);

                        if (statusStr.equals("inactive")) {
                            cleanseFilesOnResubmit(dataset);

                            if (flag.contains("delete")) {
                                String location = dataset.getLocation();
                                if (!location.isEmpty())  FileService.removeFile(location);
                            }
                            DatasetServiceUtil.deleteDataset(dataset.getDatasetId(), serviceContext);
                        }
                        _log.debug("--updateStatus -- " + statusNum);
                    }


                }

                if (dsCnt >= 100) {
                    CurateSender.send(dsIdList, curationIdList, serviceContext);
                    dsIdList.clear();
                    dsCnt = 0;
                }

                map.put("count", i);
                portSession.setAttribute(workflowId, map);
                _log.debug("### portSession.getAttribute(workflowId).toString(); :" + portSession.getAttribute(workflowId).toString());
                Thread.sleep(500);
            }


            // curate remaining dataset
            if (dsCnt > 0) {
                CurateSender.send(dsIdList, curationIdList, serviceContext);
            }


        } catch (PrincipalException e) {
            // TODO : Permission Error
            e.printStackTrace();
        } catch (SystemException | InterruptedException e) {
            _log.error(e.getMessage());
            throw new SystemException(e.getMessage());
        } finally {
            portSession.removeAttribute(workflowId);
        }
    }


    private static void cleanseFilesOnResubmit(Dataset dataset) {
        String metaLocation = dataset.getMetalocation();
        if ( (metaLocation != null) && (! metaLocation.isEmpty())) FileService.removeFile(metaLocation);

        if (dataset.getRetrieveSignature() > 0) {
            FileService.deleteDirectoryFromSignature(dataset.getRetrieveSignature(),0);
        }

        if (dataset.getCurateSignature() > 0) {
            FileService.deleteDirectoryFromSignature(0, dataset.getCurateSignature());
        }
    }
}