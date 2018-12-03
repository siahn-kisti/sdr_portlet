package com.sdr.popup.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionConverterUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.util.portlet.PortletProps;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PopupUpload {

    private static Log _log = LogFactoryUtil.getLog(PopupUpload.class);

    private static String ROOT_FOLDER_NAME = PortletProps.get("fileupload.folder.name");
    private static String ROOT_FOLDER_DESCRIPTION = PortletProps.get("fileupload.folder.description");
    private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

    public static long uploadDocument(ActionRequest request, ActionResponse response) throws IOException, PortletException, PortalException, SystemException {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        createFolder(request, themeDisplay);
        return fileUpload(themeDisplay, request);
    }

    public static Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
        boolean folderExist = isFolderExist(themeDisplay);
        Folder folder = null;
        if (!folderExist) {
            long repositoryId = themeDisplay.getScopeGroupId();
            try {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
                serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
                serviceContext.setAddGroupPermissions(true);
                serviceContext.setAddGuestPermissions(true);
                folder = DLAppServiceUtil.addFolder(repositoryId, PARENT_FOLDER_ID, ROOT_FOLDER_NAME, ROOT_FOLDER_DESCRIPTION, serviceContext);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return folder;
    }

    public static boolean isFolderExist(ThemeDisplay themeDisplay) {
        boolean folderExist = false;
        try {
            DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
            folderExist = true;
            _log.debug("Folder is already Exist");
        } catch (Exception e) {
            _log.debug(e.getMessage());
        }
        return folderExist;
    }

    public static Folder getFolder(ThemeDisplay themeDisplay) {
        Folder folder = null;
        try {
            folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
        } catch (Exception e) {
            _log.debug(e.getMessage());
        }
        return folder;
    }

    public static long fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest) {
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        String fileName = uploadPortletRequest.getFileName("imageFile");
        File file = uploadPortletRequest.getFile("imageFile");
        String mimeType = uploadPortletRequest.getContentType("imageFile");
        String title = fileName;
        String description = "This file is added via programatically";
        long repositoryId = themeDisplay.getScopeGroupId();
        _log.debug("Title=>" + title);
        try {
            Folder folder = getFolder(themeDisplay);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
            serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(true);

            InputStream is = new FileInputStream(file);
            FileEntry fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType,
                    title, description, "", is, file.length(), serviceContext);

            return fileEntry.getFileEntryId();
        } catch (Exception e) {
            _log.debug(e.getMessage());
            return 0;
        }
    }

    public static void fileDelete(long imgPathId) throws SystemException, PortalException {
        DLAppServiceUtil.deleteFileEntry(imgPathId);
    }

}

