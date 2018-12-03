package com.sdr.bbs.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.util.SubscriptionSender;

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

		 subscriptionSender.setSubject(subject);	// 제목
		 subscriptionSender.setBody(body + setSign());			// 내용
		 subscriptionSender.setHtmlFormat(false);		// 내용에 html태그 사용여부
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

	 private static String setSign() throws SystemException {
		 String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		 return "\n\n\n\n\n\nSincerely,\nSDR Administrator\n"+smtpUser;
	 }
}

 