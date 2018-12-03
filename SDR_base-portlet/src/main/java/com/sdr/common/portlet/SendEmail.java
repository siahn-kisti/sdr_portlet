package com.sdr.common.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.sdr.common.util.CommonUtil;
import com.sdr.community.CommunityConstants;
import com.sdr.metadata.model.ReqMakeSite;

import java.text.SimpleDateFormat;

/**
 * The type Send email.
 */
public class SendEmail {

    /**
     * Send.
     *
     * @param subject  the subject
     * @param body     the body
     * @param fromUser the from user
     * @param toUser   the to user
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    public static void send(String subject, String body, User fromUser, User toUser) throws SystemException, PortalException {
//		 MailEngine.send(sender, receiver, subject, body);
        SubscriptionSender subscriptionSender = new SubscriptionSender();

        subscriptionSender.setSubject(subject);    // 제목
        subscriptionSender.setBody(body + setSign());            // 내용
        subscriptionSender.setHtmlFormat(false);        // 내용에 html태그 사용여부
        subscriptionSender.setUserId(toUser.getUserId());//
        subscriptionSender.setCompanyId(toUser.getCompanyId());
        subscriptionSender.setFrom(fromUser.getEmailAddress(), "SDR Administrator");
        subscriptionSender.setMailId("user", toUser.getUserId());

        subscriptionSender.addRuntimeSubscribers(toUser.getEmailAddress(), toUser.getFullName());
        subscriptionSender.flushNotificationsAsync();
    }

    /**
     * Send from admin.
     *
     * @param subject the subject
     * @param body    the body
     * @param toUser  the to user
     * @throws SystemException the system exception
     */
    public static void sendFromAdmin(String subject, String body, User toUser) throws SystemException {
        // send( @get admin email@, receiver, subject, body);
        User admin = CommonUtil.getAdmin();
        String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
        admin.setEmailAddress(smtpUser);
        try {
            send(subject, body, admin, toUser);
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send to admin.
     *
     * @param subject the subject
     * @param body    the body
     * @throws SystemException the system exception
     */
    public static void sendToAdmin(String subject, String body) throws SystemException {
        // send( @default log email@, @get admin email@, subject, body);
        User admin = CommonUtil.getAdmin();
        String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
        admin.setEmailAddress(smtpUser);
        try {
            send(subject, body, admin, admin);
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send req community.
     *
     * @param vo the vo
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    public static void send_reqCommunity(ReqMakeSite vo) throws SystemException, PortalException {
        User reqUser = UserLocalServiceUtil.getUser(vo.getUserId());

        String subject = "[Notification] Request for Make Community";

        String body = "\nRequest User Infomation\n";
        body += "--------------------" + "\n";
        body += "User : " + reqUser.getFullName() + "\n";
        body += "Email : " + reqUser.getEmailAddress() + "\n\n\n";

        body += "Request Infomation" + "\n";
        body += "--------------------" + "\n";
        body += "Community Name : " + vo.getName() + "\n";
        body += "Community Description : " + vo.getDescription() + "\n";
        body += "Purpose of request : " + vo.getMessage() + "\n";
        body += "Request Date : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(vo.getRequestDate()) + "\n";

        sendToAdmin(subject, body);
    }

    /**
     * Send confirm community.
     *
     * @param vo the vo
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    public static void send_confirmCommunity(ReqMakeSite vo) throws SystemException, PortalException {
        User reqUser = UserLocalServiceUtil.getUser(vo.getUserId());
        String status = "";
        if (vo.getStatus() == CommunityConstants.STATUS_REJECT) status = "Rejected";
        else if (vo.getStatus() == CommunityConstants.STATUS_APPROVE) status = "Approved";

        String subject = "[Notification] Answer request for make community";

        String body = "Request Infomation" + "\n";
        body += "--------------------" + "\n";
        body += "Community Name : " + vo.getName() + "\n";
        body += "Community Description : " + vo.getDescription() + "\n";
        body += "Purpose of request : " + vo.getMessage() + "\n";
        body += "Request Date : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(vo.getRequestDate()) + "\n\n\n";

        body += "Answer Infomation\n";
        body += "--------------------" + "\n";
        body += "Result : " + status + "\n";
        body += "Answer Message : " + vo.getAnswer() + "\n";
        body += "Answer Date : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(vo.getConfirmDate()) + "\n\n\n";

        sendFromAdmin(subject, body, reqUser);
    }

    /**
     * Send workflow.
     *
     * @param subject the subject
     * @param body    the body
     * @param toUser  the to user
     * @throws SystemException the system exception
     */
    public static void send_workflow(String subject, String body, User toUser) throws SystemException {
        User admin = CommonUtil.getAdmin();
        String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
        admin.setEmailAddress(smtpUser);

        try {
            send(subject, body, admin, toUser == null ? admin : toUser);
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send review.
     *
     * @param collectionName the collection name
     * @param datasetName    the dataset name
     * @param toUser         the to user
     * @throws SystemException the system exception
     */
    public static void send_review(String collectionName, String datasetName, User toUser) throws SystemException {
        String subject = "Review Notification";
        String body = "You have a new submission waiting for your review in the workflow.\n";
        body += "Collection : " + collectionName + ", Dataset : " + datasetName + "\n";

        send_workflow(subject, body, toUser);
    }

    /**
     * Send approve.
     *
     * @param collectionName the collection name
     * @param datasetName    the dataset name
     * @param toUser         the to user
     * @throws SystemException the system exception
     */
    public static void send_approve(String collectionName, String datasetName, User toUser) throws SystemException {
        String subject = "Publish Notification";
        String body = "Your submission was approved by a reviewer.\n";
        body += "Collection : " + collectionName + ", Dataset : " + datasetName + "\n";

        send_workflow(subject, body, toUser);
    }

    /**
     * Send reject.
     *
     * @param collectionName the collection name
     * @param datasetName    the dataset name
     * @param toUser         the to user
     * @throws SystemException the system exception
     */
    public static void send_reject(String collectionName, String datasetName, User toUser) throws SystemException {
        String subject = "Reject Notification";
        String body = "Your submission was rejected by a reviewer, please modify and resubmit.\n";
        body += "Collection : " + collectionName + ", Dataset : " + datasetName + "\n";

        send_workflow(subject, body, toUser);
    }

    /**
     * @return String
     * @throws SystemException
     */
    private static String setSign() throws SystemException {
        String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
        return "\n\n\n\n\n\nSincerely,\nSDR Administrator\n" + smtpUser;
    }
}

 