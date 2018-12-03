package com.sdr.metadata.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sdr.metadata.service.ApiKeyLocalServiceUtil;
import com.sdr.metadata.service.ApiKeyServiceUtil;
import com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil;
import com.sdr.metadata.service.AssetEntries_AssetTagsServiceUtil;
import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.CollectionServiceUtil;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;
import com.sdr.metadata.service.Collection_AllowedUserServiceUtil;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.Collection_UserServiceUtil;
import com.sdr.metadata.service.CurateLocalServiceUtil;
import com.sdr.metadata.service.CurateServiceUtil;
import com.sdr.metadata.service.CurationJobLocalServiceUtil;
import com.sdr.metadata.service.CurationJobServiceUtil;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;
import com.sdr.metadata.service.DataTypeSchemaServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil;
import com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil;
import com.sdr.metadata.service.DataViewComponentsLocalServiceUtil;
import com.sdr.metadata.service.DataViewComponentsServiceUtil;
import com.sdr.metadata.service.DataViewLocalServiceUtil;
import com.sdr.metadata.service.DataViewServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.metadata.service.DatatypeRuleLocalServiceUtil;
import com.sdr.metadata.service.DatatypeRuleServiceUtil;
import com.sdr.metadata.service.GroupRuleLocalServiceUtil;
import com.sdr.metadata.service.GroupRuleServiceUtil;
import com.sdr.metadata.service.IceBreakerVcTokenLocalServiceUtil;
import com.sdr.metadata.service.IceBreakerVcTokenServiceUtil;
import com.sdr.metadata.service.MlGuiParameterLocalServiceUtil;
import com.sdr.metadata.service.MlGuiParameterServiceUtil;
import com.sdr.metadata.service.PpLogicLocalServiceUtil;
import com.sdr.metadata.service.PpLogicServiceUtil;
import com.sdr.metadata.service.ReqMakeSiteLocalServiceUtil;
import com.sdr.metadata.service.ReqMakeSiteServiceUtil;
import com.sdr.metadata.service.SdrOrganizationsLocalServiceUtil;
import com.sdr.metadata.service.SdrOrganizationsServiceUtil;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;
import com.sdr.metadata.service.SdrUsersServiceUtil;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;
import com.sdr.metadata.service.SimulationJobServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ApiKeyLocalServiceUtil.clearService();

            ApiKeyServiceUtil.clearService();
            AssetEntries_AssetTagsLocalServiceUtil.clearService();

            AssetEntries_AssetTagsServiceUtil.clearService();
            CollectionLocalServiceUtil.clearService();

            CollectionServiceUtil.clearService();
            Collection_AllowedUserLocalServiceUtil.clearService();

            Collection_AllowedUserServiceUtil.clearService();
            Collection_UserLocalServiceUtil.clearService();

            Collection_UserServiceUtil.clearService();
            CurateLocalServiceUtil.clearService();

            CurateServiceUtil.clearService();
            CurationJobLocalServiceUtil.clearService();

            CurationJobServiceUtil.clearService();
            DatasetLocalServiceUtil.clearService();

            DatasetServiceUtil.clearService();
            DataTypeLocalServiceUtil.clearService();

            DataTypeServiceUtil.clearService();
            DataType_dataTypeSchema_essentialLocalServiceUtil.clearService();

            DataType_dataTypeSchema_essentialServiceUtil.clearService();
            DatatypeRuleLocalServiceUtil.clearService();

            DatatypeRuleServiceUtil.clearService();
            DataTypeSchemaLocalServiceUtil.clearService();

            DataTypeSchemaServiceUtil.clearService();
            DataViewLocalServiceUtil.clearService();

            DataViewServiceUtil.clearService();
            DataViewComponentsLocalServiceUtil.clearService();

            DataViewComponentsServiceUtil.clearService();
            GroupRuleLocalServiceUtil.clearService();

            GroupRuleServiceUtil.clearService();
            IceBreakerVcTokenLocalServiceUtil.clearService();

            IceBreakerVcTokenServiceUtil.clearService();
            MlGuiParameterLocalServiceUtil.clearService();

            MlGuiParameterServiceUtil.clearService();
            PpLogicLocalServiceUtil.clearService();

            PpLogicServiceUtil.clearService();
            ReqMakeSiteLocalServiceUtil.clearService();

            ReqMakeSiteServiceUtil.clearService();
            SdrOrganizationsLocalServiceUtil.clearService();

            SdrOrganizationsServiceUtil.clearService();
            SdrUsersLocalServiceUtil.clearService();

            SdrUsersServiceUtil.clearService();
            SimulationJobLocalServiceUtil.clearService();

            SimulationJobServiceUtil.clearService();
        }
    }
}
