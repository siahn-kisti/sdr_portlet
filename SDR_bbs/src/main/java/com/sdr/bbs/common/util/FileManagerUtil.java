package com.sdr.bbs.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type File manager util.
 */
public class FileManagerUtil {
    private static String _upload_servlet_request_max_size = "com.liferay.portal.upload.UploadServletRequestImpl.max.size";
    private static String _dl_file_max_size = "dl.file.max.size";
    private static String _dl_file_extensions = "dl.file.extensions";
    private static long _parent_folder_id = 0L;
    private static String _resource_upload_folder_name = PortletProps.get("resource.upload.folder.name");
    private static String _resource_upload_folder_desc = PortletProps.get("resource.upload.folder.desc");
    private static String _resource_upload_file_desc = PortletProps.get("resource.upload.file.desc");

    private static String _dl_store_file_system_root_dir = "dl.store.file.system.root.dir";
    private static String _dl_file_entry_thumbnail_custom1_max_height = "dl.file.entry.thumbnail.custom1.max.height";
    private static String _dl_file_entry_thumbnail_custom1_max_width = "dl.file.entry.thumbnail.custom1.max.width";
    private static String _dl_file_entry_thumbnail_custom2_max_height = "dl.file.entry.thumbnail.custom2.max.height";
    private static String _dl_file_entry_thumbnail_custom2_max_width = "dl.file.entry.thumbnail.custom2.max.width";
    private static String _dl_file_entry_thumbnail_enabled = "dl.file.entry.thumbnail.enabled";
    private static String _dlpreviewableprocessor_thumbnail_path = "document_thumbnail/";

    private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;


    private static Log _log = LogFactoryUtil.getLog(FileManagerUtil.class);

    /**
     * Has folder boolean.
     *
     * @param themeDisplay the theme display
     * @param classPk      the class pk
     * @return the boolean
     */
    public static boolean hasFolder(ThemeDisplay themeDisplay, long classPk) {
        boolean hasFolder = false;
        try {
            Folder folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);

            if (Validator.isNotNull(folder))
                if (classPk > 0L) {
                    Folder subFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folder.getFolderId(), Long.toString(classPk));

                    if (Validator.isNotNull(subFolder)) hasFolder = true;
                } else {
                    hasFolder = true;
                }
        } catch (NoSuchFolderException e) {
            hasFolder = false;
//            if (_log.isDebugEnabled()) _log.debug(e.toString());
        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return hasFolder;
    }

    /**
     * Has folder boolean.
     *
     * @param themeDisplay the theme display
     * @param classPks     the class pks
     * @return the boolean
     */
    public static boolean hasFolder(ThemeDisplay themeDisplay, List<Long> classPks) {
        boolean hasFolder = true;
        try {
            Folder folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);

            if (Validator.isNotNull(folder)) {
                if ((Validator.isNotNull(classPks)) && (classPks.size() > 0)) {
                    long parentFolderId = folder.getFolderId();

                    for (int i = 0; i < classPks.size(); i++) {
                        folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, Long.toString(((Long) classPks.get(i)).longValue()));

                        if (Validator.isNull(folder)) {
                            hasFolder = false;
                            break;
                        }
                        parentFolderId = folder.getFolderId();
                    }
                }
            }
        } catch (Exception e) {
            hasFolder = false;
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return hasFolder;
    }

    /**
     * Add folder folder.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @param classPk       the class pk
     * @return the folder
     */
    public static Folder addFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay, long classPk) {
        Folder folder = null;
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);

            Folder parentFolder = null;

            if (!hasFolder(themeDisplay, 0L))
                parentFolder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), _parent_folder_id,
                        _resource_upload_folder_name, _resource_upload_folder_desc, serviceContext);
            else {
                parentFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);
            }

            if (Validator.isNotNull(parentFolder))
                if (classPk > 0L) {
                    Folder subFolder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
                            parentFolder.getFolderId(), Long.toString(classPk), _resource_upload_folder_desc, serviceContext);

                    if (Validator.isNotNull(subFolder)) folder = subFolder;
                } else {
                    folder = parentFolder;
                }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return folder;
    }

    /**
     * Add folder folder.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @param classPks      the class pks
     * @return the folder
     */
    public static Folder addFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay, List<Long> classPks) {
        Folder folder = null;
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);

            Folder parentFolder = null;

            if (!hasFolder(themeDisplay, 0L))
                parentFolder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), _parent_folder_id,
                        _resource_upload_folder_name, _resource_upload_folder_desc, serviceContext);
            else {
                parentFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);
            }

            if (Validator.isNotNull(parentFolder))
                if ((Validator.isNotNull(classPks)) && (classPks.size() > 0)) {
                    long parentFolderId = parentFolder.getFolderId();
                    List tempClassPks = new ArrayList();
                    Folder subFolder = null;

                    for (int i = 0; i < classPks.size(); i++) {
                        tempClassPks.add((Long) classPks.get(i));

                        if (hasFolder(themeDisplay, tempClassPks))
                            subFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
                                    parentFolderId, Long.toString(((Long) classPks.get(i)).longValue()));
                        else {
                            subFolder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
                                    parentFolderId, Long.toString(((Long) classPks.get(i)).longValue()), _resource_upload_folder_desc, serviceContext);
                        }

                        if (!Validator.isNotNull(subFolder)) break;
                        parentFolderId = subFolder.getFolderId();
                    }

                    if (Validator.isNotNull(subFolder)) folder = subFolder;
                } else {
                    folder = parentFolder;
                }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return folder;
    }

    /**
     * Gets folder.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @param classPk       the class pk
     * @return the folder
     */
    public static Folder getFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay, long classPk) {
        Folder folder = null;
        try {
            if (!hasFolder(themeDisplay, classPk)) {
                folder = addFolder(actionRequest, themeDisplay, classPk);
            } else {
                Folder parentFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);

                if (classPk > 0L)
                    folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolder.getFolderId(), Long.toString(classPk));
                else
                    folder = parentFolder;
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return folder;
    }

    /**
     * Gets folder.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @param classPks      the class pks
     * @return the folder
     */
    public static Folder getFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay, List<Long> classPks) {
        Folder folder = null;
        try {
            if (!hasFolder(themeDisplay, classPks)) {
                folder = addFolder(actionRequest, themeDisplay, classPks);
            } else {
                Folder parentFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);

                if ((Validator.isNotNull(classPks)) && (classPks.size() > 0)) {
                    long parentFolderId = parentFolder.getFolderId();
                    List tempClassPks = new ArrayList();
                    Folder subFolder = null;

                    for (int i = 0; i < classPks.size(); i++) {
                        tempClassPks.add((Long) classPks.get(i));

                        subFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
                                parentFolderId, Long.toString(((Long) classPks.get(i)).longValue()));

                        if (!Validator.isNotNull(subFolder)) break;
                        parentFolderId = subFolder.getFolderId();
                    }

                    if (Validator.isNotNull(subFolder)) folder = subFolder;
                } else {
                    folder = parentFolder;
                }
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return folder;
    }

    /**
     * Upload file long.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @param classPk       the class pk
     * @param fileName      the file name
     * @param mimeType      the mime type
     * @param file          the file
     * @return the long
     */
    public static long uploadFile(ActionRequest actionRequest, ThemeDisplay themeDisplay, long classPk, String fileName, String mimeType, File file) {
        long fileEntryId = 0L;
        try {
            UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

//      String fileName = uploadPortletRequest.getFileName(fileParam);
//      File file = uploadPortletRequest.getFile(fileParam);
//      String mimeType = uploadPortletRequest.getContentType(fileParam);
            Date today = new Date();
            String sourceFileName = Long.toString(today.getTime());

            Folder folder = getFolder(actionRequest, themeDisplay, classPk);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
            InputStream is = new FileInputStream(file);

            FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder.getFolderId(),
                    sourceFileName, mimeType, fileName, _resource_upload_file_desc, null, is, file.length(), serviceContext);

            if (Validator.isNotNull(fileEntry)) fileEntryId = fileEntry.getFileEntryId();
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return fileEntryId;
    }

    /**
     * Upload file long.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @param classPk       the class pk
     * @param fileParam     the file param
     * @return the long
     */
    public static long uploadFile(ActionRequest actionRequest, ThemeDisplay themeDisplay, long classPk, String fileParam) {
        long fileEntryId = 0L;
        try {
            UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

            String fileName = uploadPortletRequest.getFileName(fileParam);
            File file = uploadPortletRequest.getFile(fileParam);
            String mimeType = uploadPortletRequest.getContentType(fileParam);
            Date today = new Date();
            String sourceFileName = Long.toString(today.getTime());

            Folder folder = getFolder(actionRequest, themeDisplay, classPk);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
            InputStream is = new FileInputStream(file);

            FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder.getFolderId(),
                    sourceFileName, mimeType, fileName, _resource_upload_file_desc, null, is, file.length(), serviceContext);

            if (Validator.isNotNull(fileEntry)) fileEntryId = fileEntry.getFileEntryId();
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return fileEntryId;
    }

    /**
     * Upload file long.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @param classPks      the class pks
     * @param fileParam     the file param
     * @return the long
     */
    public static long uploadFile(ActionRequest actionRequest, ThemeDisplay themeDisplay, List<Long> classPks, String fileParam) {
        long fileEntryId = 0L;
        try {
            UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

            String fileName = uploadPortletRequest.getFileName(fileParam);
            File file = uploadPortletRequest.getFile(fileParam);
            String mimeType = uploadPortletRequest.getContentType(fileParam);
            Date today = new Date();
            String sourceFileName = Long.toString(today.getTime());

            Folder folder = getFolder(actionRequest, themeDisplay, classPks);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
            InputStream is = new FileInputStream(file);

            FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder.getFolderId(),
                    sourceFileName, mimeType, fileName, _resource_upload_file_desc, null, is, file.length(), serviceContext);

            if (Validator.isNotNull(fileEntry)) fileEntryId = fileEntry.getFileEntryId();
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return fileEntryId;
    }

    /**
     * Upload file long.
     *
     * @param actionRequest        the action request
     * @param uploadPortletRequest the upload portlet request
     * @param themeDisplay         the theme display
     * @param classPk              the class pk
     * @param fileParam            the file param
     * @return the long
     */
    public static long uploadFile(ActionRequest actionRequest, UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay, long classPk, String fileParam) {
        long fileEntryId = 0L;
        try {
            String fileName = uploadPortletRequest.getFileName(fileParam);
            File file = uploadPortletRequest.getFile(fileParam);
            String mimeType = uploadPortletRequest.getContentType(fileParam);
            Date today = new Date();
            String sourceFileName = Long.toString(today.getTime());

            Folder folder = getFolder(actionRequest, themeDisplay, classPk);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
            InputStream is = new FileInputStream(file);

            FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder.getFolderId(),
                    sourceFileName, mimeType, fileName, _resource_upload_file_desc, null, is, file.length(), serviceContext);

            if (Validator.isNotNull(fileEntry)) fileEntryId = fileEntry.getFileEntryId();
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return fileEntryId;
    }

    /**
     * Upload file long.
     *
     * @param actionRequest        the action request
     * @param uploadPortletRequest the upload portlet request
     * @param themeDisplay         the theme display
     * @param classPks             the class pks
     * @param fileParam            the file param
     * @return the long
     */
    public static long uploadFile(ActionRequest actionRequest, UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay, List<Long> classPks, String fileParam) {
        long fileEntryId = 0L;
        try {
            String fileName = uploadPortletRequest.getFileName(fileParam);
            File file = uploadPortletRequest.getFile(fileParam);
            String mimeType = uploadPortletRequest.getContentType(fileParam);
            Date today = new Date();
            String sourceFileName = Long.toString(today.getTime());

            Folder folder = getFolder(actionRequest, themeDisplay, classPks);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
            InputStream is = new FileInputStream(file);

            FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder.getFolderId(),
                    sourceFileName, mimeType, fileName, _resource_upload_file_desc, null, is, file.length(), serviceContext);

            if (Validator.isNotNull(fileEntry)) fileEntryId = fileEntry.getFileEntryId();
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return fileEntryId;
    }

    /**
     * Gets file entries.
     *
     * @param themeDisplay the theme display
     * @param classPk      the class pk
     * @return the file entries
     */
    public static List<DLFileEntry> getFileEntries(ThemeDisplay themeDisplay, long classPk) {
        List fileEntries = null;
        try {
            if (hasFolder(themeDisplay, classPk)) {
                Folder folder = null;

                Folder parentFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);

                if (classPk > 0L)
                    folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolder.getFolderId(), Long.toString(classPk));
                else {
                    folder = parentFolder;
                }

                fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return fileEntries;
    }

    /**
     * Gets file entries.
     *
     * @param themeDisplay the theme display
     * @param classPks     the class pks
     * @return the file entries
     */
    public static List<DLFileEntry> getFileEntries(ThemeDisplay themeDisplay, List<Long> classPks) {
        List fileEntries = null;
        try {
            if (hasFolder(themeDisplay, classPks)) {
                Folder folder = null;

                Folder parentFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);

                if ((Validator.isNotNull(classPks)) && (classPks.size() > 0)) {
                    long parentFolderId = parentFolder.getFolderId();
                    List tempClassPks = new ArrayList();
                    Folder subFolder = null;

                    for (int i = 0; i < classPks.size(); i++) {
                        tempClassPks.add((Long) classPks.get(i));

                        subFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
                                parentFolderId, Long.toString(((Long) classPks.get(i)).longValue()));

                        if (!Validator.isNotNull(subFolder)) break;
                        parentFolderId = subFolder.getFolderId();
                    }

                    if (Validator.isNotNull(subFolder)) folder = subFolder;
                } else {
                    folder = parentFolder;
                }

                fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return fileEntries;
    }

    /**
     * Gets file.
     *
     * @param themeDisplay the theme display
     * @param fileEntry    the file entry
     * @return the file
     */
    public static File getFile(ThemeDisplay themeDisplay, DLFileEntry fileEntry) {
        File file = null;

        if (Validator.isNotNull(fileEntry)) {
            try {
                file = DLFileEntryLocalServiceUtil.getFile(themeDisplay.getUserId(), fileEntry.getFileEntryId(), fileEntry.getVersion(), true);
            } catch (Exception e) {
                if (_log.isDebugEnabled()) _log.debug(e.toString());
            }
        }

        return file;
    }

    /**
     * Download file.
     *
     * @param response     the response
     * @param request      the request
     * @param themeDisplay the theme display
     * @param fileEntryId  the file entry id
     */
    public static void downloadFile(HttpServletResponse response, HttpServletRequest request, ThemeDisplay themeDisplay, long fileEntryId) {
        if (fileEntryId > 0L)
            try {
                DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);

                if (Validator.isNotNull(fileEntry)) {
                    File file = getFile(themeDisplay, fileEntry);

                    if (Validator.isNotNull(file)) {
                        InputStream is = new FileInputStream(file);
                        String fileName = fileEntry.getTitle();
                        String contentType = fileEntry.getMimeType();

                        ServletResponseUtil.sendFile(request, response, fileName, is, contentType);
                    }
                }
            } catch (Exception e) {
                if (_log.isDebugEnabled()) _log.debug(e.toString());
            }
    }

    /**
     * Download thumbnail.
     *
     * @param response     the response
     * @param request      the request
     * @param themeDisplay the theme display
     * @param fileEntryId  the file entry id
     */
    public static void downloadThumbnail(HttpServletResponse response, HttpServletRequest request, ThemeDisplay themeDisplay, long fileEntryId) {
        downloadThumbnail(response, request, themeDisplay, fileEntryId, 1);
    }

    /**
     * Download thumbnail.
     *
     * @param response     the response
     * @param request      the request
     * @param themeDisplay the theme display
     * @param fileEntryId  the file entry id
     * @param index        the index
     */
    public static void downloadThumbnail(HttpServletResponse response, HttpServletRequest request, ThemeDisplay themeDisplay, long fileEntryId, int index) {
        if (fileEntryId > 0L) {
            try {
                if (getDlFileEntryThumbnailEnabled()) {
                    DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);

                    StringBuilder sb = new StringBuilder(5);

                    sb.append(getDlStoreFileSystemRootDir());
                    sb.append("/" + themeDisplay.getCompanyId() + "/0/" + getThumbnailPath() + fileEntry.getGroupId());
                    sb.append(DLUtil.getDividedPath(fileEntry.getFileEntryId()));

                    if (index == 0)
                        sb.append("/" + fileEntry.getFileVersion().getFileVersionId() + "." + StringUtil.replace(fileEntry.getFileVersion().getExtension(), "jpeg", "jpg"));
                    else {
                        sb.append("/" + fileEntry.getFileVersion().getFileVersionId() + "-" + index + "." + StringUtil.replace(fileEntry.getFileVersion().getExtension(), "jpeg", "jpg"));
                    }

                    sb.append("/" + fileEntry.getFileVersion().getVersion());

                    if (Validator.isNotNull(sb)) {
                        InputStream is = new FileInputStream(sb.toString());

                        String fileName = fileEntry.getTitle();
                        String contentType = fileEntry.getMimeType();

                        ServletResponseUtil.sendFile(request, response, fileName, is, contentType);
                    }
                } else {
                    downloadFile(response, request, themeDisplay, fileEntryId);
                }
            } catch (Exception e) {
                if (_log.isDebugEnabled()) _log.debug(e.toString());
            }
        }
    }

    /**
     * Delete file entries in folder boolean.
     *
     * @param themeDisplay the theme display
     * @param classPk      the class pk
     * @return the boolean
     */
    public static boolean deleteFileEntriesInFolder(ThemeDisplay themeDisplay, long classPk) {
        boolean isDeleted = false;
        try {
            if (hasFolder(themeDisplay, classPk)) {
                if (classPk > 0L) {
                    Folder parentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);

                    DLAppServiceUtil.deleteFolder(themeDisplay.getScopeGroupId(), parentFolder.getFolderId(), Long.toString(classPk));
                }

                isDeleted = true;
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return isDeleted;
    }

    /**
     * Delete file entries in folder boolean.
     *
     * @param themeDisplay the theme display
     * @param classPks     the class pks
     * @return the boolean
     */
    public static boolean deleteFileEntriesInFolder(ThemeDisplay themeDisplay, List<Long> classPks) {
        boolean isDeleted = false;
        try {
            if (hasFolder(themeDisplay, classPks)) {
                Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), _parent_folder_id, _resource_upload_folder_name);

                if ((Validator.isNotNull(classPks)) && (classPks.size() > 0)) {
                    long parentFolderId = folder.getFolderId();
                    List tempClassPks = new ArrayList();

                    for (int i = 0; i < classPks.size(); i++) {
                        tempClassPks.add((Long) classPks.get(i));

                        folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
                                parentFolderId, Long.toString(((Long) classPks.get(i)).longValue()));

                        if (!Validator.isNotNull(folder)) break;
                        parentFolderId = folder.getFolderId();
                    }

                    if (Validator.isNotNull(folder)) {
                        DLAppServiceUtil.deleteFolder(folder.getFolderId());

                        isDeleted = true;
                    }
                }
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return isDeleted;
    }

    /**
     * Delete file entry boolean.
     *
     * @param themeDisplay the theme display
     * @param classPk      the class pk
     * @param fileEntryId  the file entry id
     * @return the boolean
     */
    public static boolean deleteFileEntry(ThemeDisplay themeDisplay, long classPk, long fileEntryId) {
        boolean isDeleted = false;
        try {
            if (hasFolder(themeDisplay, classPk)) {
                DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
                long folderId = fileEntry.getFolderId();

                DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileEntry);

                if ((folderId > 0L) && (DLFileEntryLocalServiceUtil.getFileEntriesCount(themeDisplay.getScopeGroupId(), folderId) == 0) &&
                        (DLAppServiceUtil.getFoldersCount(themeDisplay.getScopeGroupId(), folderId) == 0)) {
                    DLAppServiceUtil.deleteFolder(folderId);
                }

                isDeleted = true;
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return isDeleted;
    }

    /**
     * Delete file entry boolean.
     *
     * @param themeDisplay the theme display
     * @param classPks     the class pks
     * @param fileEntryId  the file entry id
     * @return the boolean
     */
    public static boolean deleteFileEntry(ThemeDisplay themeDisplay, List<Long> classPks, long fileEntryId) {
        boolean isDeleted = false;
        try {
            if (hasFolder(themeDisplay, classPks)) {
                DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
                long folderId = fileEntry.getFolderId();

                DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileEntry);

                if ((folderId > 0L) && (DLFileEntryLocalServiceUtil.getFileEntriesCount(themeDisplay.getScopeGroupId(), folderId) == 0) &&
                        (DLAppServiceUtil.getFoldersCount(themeDisplay.getScopeGroupId(), folderId) == 0)) {
                    DLAppServiceUtil.deleteFolder(folderId);
                }

                isDeleted = true;
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) _log.debug(e.toString());
        }

        return isDeleted;
    }

    /**
     * Gets upload servlet request max size.
     *
     * @return the upload servlet request max size
     */
    public static int getUploadServletRequestMaxSize() {
        int uploadServletRequestMaxSize = 0;

        uploadServletRequestMaxSize = Integer.parseInt(PropsUtil.get(_upload_servlet_request_max_size));

        return uploadServletRequestMaxSize;
    }

    /**
     * Gets dl file max size.
     *
     * @return the dl file max size
     */
    public static int getDlFileMaxSize() {
        int dlFileMaxSize = 0;

        dlFileMaxSize = Integer.parseInt(PropsUtil.get(_dl_file_max_size));

        return dlFileMaxSize;
    }

    /**
     * Gets system upload file size.
     *
     * @return the system upload file size
     */
    public static int getSystemUploadFileSize() {
        int systemUploadFileSize = 0;

        int uploadServletRequestMaxSize = getUploadServletRequestMaxSize();
        int dlFileMaxSize = getDlFileMaxSize();

        if (dlFileMaxSize == 0) {
            systemUploadFileSize = uploadServletRequestMaxSize;
        } else if (uploadServletRequestMaxSize >= dlFileMaxSize)
            systemUploadFileSize = dlFileMaxSize;
        else {
            systemUploadFileSize = uploadServletRequestMaxSize;
        }

        return systemUploadFileSize;
    }

    /**
     * Gets system upload file size in mb.
     *
     * @return the system upload file size in mb
     */
    public static int getSystemUploadFileSizeInMb() {
        int systemUploadFileSize = 0;

        systemUploadFileSize = getSystemUploadFileSize();
        systemUploadFileSize /= 1048576;

        return systemUploadFileSize;
    }

    /**
     * Gets availble upload file size.
     *
     * @param customSize the custom size
     * @return the availble upload file size
     */
    public static int getAvailbleUploadFileSize(int customSize) {
        int systemUploadFileSize = 0;
        systemUploadFileSize = getSystemUploadFileSize();

        if ((systemUploadFileSize > 0) && (
                (customSize == 0) || (customSize > systemUploadFileSize))) {
            customSize = systemUploadFileSize;
        }

        return customSize;
    }

    /**
     * Gets dl file extensions.
     *
     * @return the dl file extensions
     */
    public static String getDlFileExtensions() {
        String dlFileExtensions = "*";

        dlFileExtensions = PropsUtil.get(_dl_file_extensions);

        return dlFileExtensions;
    }

    /**
     * Gets available file extensions.
     *
     * @param customExtesions the custom extesions
     * @return the available file extensions
     */
    public static String getAvailableFileExtensions(String customExtesions) {
        String dlFileExtensions = "*";

        dlFileExtensions = PropsUtil.get(_dl_file_extensions);

        if (!dlFileExtensions.equals("*")) {
            if (customExtesions.equals("*")) {
                customExtesions = dlFileExtensions;
            } else {
                List tempAvailableFileExtensionsList = new ArrayList();

                if (Validator.isNotNull(customExtesions)) {
                    String[] stringArray = customExtesions.split(",");

                    for (int i = 0; i < stringArray.length; i++) {
                        tempAvailableFileExtensionsList.add(stringArray[i].trim());
                    }
                }

                boolean isFirst = true;

                for (int i = 0; i < tempAvailableFileExtensionsList.size(); i++) {
                    if (StringUtil.contains(dlFileExtensions, (String) tempAvailableFileExtensionsList.get(i), ",")) {
                        if (isFirst) {
                            customExtesions = (String) tempAvailableFileExtensionsList.get(i);
                            isFirst = false;
                        } else {
                            customExtesions = customExtesions + "," + (String) tempAvailableFileExtensionsList.get(i);
                        }
                    }
                }
            }
        }

        return customExtesions;
    }


    /**
     * Create folder folder.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @return the folder
     */
    public static Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
        boolean folderExist = isFolderExist(themeDisplay);
        Folder folder = null;
        if (!folderExist) {
            long repositoryId = themeDisplay.getScopeGroupId();
            try {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
                folder = DLAppServiceUtil.addFolder(repositoryId, PARENT_FOLDER_ID, _resource_upload_folder_name, _resource_upload_folder_desc, serviceContext);
            } catch (PortalException e1) {
                e1.printStackTrace();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }
        return folder;
    }

    /**
     * Is folder exist boolean.
     *
     * @param themeDisplay the theme display
     * @return the boolean
     */
    public static boolean isFolderExist(ThemeDisplay themeDisplay) {
        boolean folderExist = false;
        try {
            DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, _resource_upload_folder_name);
            folderExist = true;
            System.out.println("Folder is already Exist");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return folderExist;
    }

    /**
     * Gets folder.
     *
     * @param themeDisplay the theme display
     * @return the folder
     */
    public static Folder getFolder(ThemeDisplay themeDisplay) {
        Folder folder = null;
        try {
            folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, _resource_upload_folder_name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return folder;
    }


    /**
     * File upload.
     *
     * @param actionRequest the action request
     * @param themeDisplay  the theme display
     * @param classPk       the class pk
     */
    public static void fileUpload(ActionRequest actionRequest, ThemeDisplay themeDisplay, long classPk) {
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
        Folder folder = null;
//        Folder folder = getFolder(themeDisplay);
        InputStream is;
        File file;
        String title, description, mimeType;
        long repositoryId;
        for (Map.Entry<String, FileItem[]> file2 : files.entrySet()) {

            FileItem item[] = file2.getValue();

            try {
                for (FileItem fileItem : item) {
                    title = fileItem.getFileName();
                    description = title + "is uploaded from SDR_BBS";
                    repositoryId = themeDisplay.getScopeGroupId();
                    mimeType = fileItem.getContentType();
                    file = fileItem.getStoreLocation();
                    is = fileItem.getInputStream();

                    try {
                        byte[] bytes = FileUtil.getBytes(file);
                        if(bytes != null && bytes.length > 0) {
                            if(folder == null) folder = getFolder(actionRequest, themeDisplay, classPk);

                            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
                            DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType,
                                    title, description, "", is, file.getTotalSpace(), serviceContext);
                        }
                    } catch (PortalException e) {
                        e.printStackTrace();
                    } catch (SystemException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Gets dl store file system root dir.
     *
     * @return the dl store file system root dir
     */
    public static String getDlStoreFileSystemRootDir() {
        return PropsUtil.get(_dl_store_file_system_root_dir);
    }

    /**
     * Gets dl file entry thumbnail custom 1 max height.
     *
     * @return the dl file entry thumbnail custom 1 max height
     */
    public static int getDlFileEntryThumbnailCustom1MaxHeight() {
        return Integer.parseInt(PropsUtil.get(_dl_file_entry_thumbnail_custom1_max_height));
    }

    /**
     * Gets dl file entry thumbnail custom 1 max width.
     *
     * @return the dl file entry thumbnail custom 1 max width
     */
    public static int getDlFileEntryThumbnailCustom1MaxWidth() {
        return Integer.parseInt(PropsUtil.get(_dl_file_entry_thumbnail_custom1_max_width));
    }

    /**
     * Gets dl file entry thumbnail custom 2 max height.
     *
     * @return the dl file entry thumbnail custom 2 max height
     */
    public static int getDlFileEntryThumbnailCustom2MaxHeight() {
        return Integer.parseInt(PropsUtil.get(_dl_file_entry_thumbnail_custom2_max_height));
    }

    /**
     * Gets dl file entry thumbnail custom 2 max width.
     *
     * @return the dl file entry thumbnail custom 2 max width
     */
    public static int getDlFileEntryThumbnailCustom2MaxWidth() {
        return Integer.parseInt(PropsUtil.get(_dl_file_entry_thumbnail_custom2_max_width));
    }

    /**
     * Gets dl file entry thumbnail enabled.
     *
     * @return the dl file entry thumbnail enabled
     */
    public static boolean getDlFileEntryThumbnailEnabled() {
        return Boolean.parseBoolean(PropsUtil.get(_dl_file_entry_thumbnail_enabled));
    }

    /**
     * Gets thumbnail path.
     *
     * @return the thumbnail path
     */
    public static String getThumbnailPath() {
        return _dlpreviewableprocessor_thumbnail_path;
    }


}