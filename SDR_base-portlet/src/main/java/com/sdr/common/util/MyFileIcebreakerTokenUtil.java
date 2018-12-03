package com.sdr.common.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sdr.common.model.EdisonExpando;
import com.sdr.common.model.EdisonRoleConstants;
import com.sdr.common.model.IcebreakerVcToken;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;

public class MyFileIcebreakerTokenUtil {
	
	public static IcebreakerVcToken getOrCreateToken(long thisGroupId, User user) throws MalformedURLException, PortalException, SystemException, IOException, ParseException{
		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();

		Group thisGroup = GroupLocalServiceUtil.getGroup(thisGroupId);		
		String userScreenName = "";
		String userPassword = "";
		String universityField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
		String virtualLabId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_LAB_ID);
		String classId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
		String majorField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR);
		
		if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)){
			userScreenName = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_ID);
			userPassword = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_PWD);
		}else{
			userScreenName = String.valueOf(user.getScreenName());
			userPassword = user.getPassword();
		}
		
		if(VCRegisterUtilforEdison.isVcInfo(thisGroupId, userScreenName) == 200){
			
			if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))){
			
				icebreakerVcToken.setVcToken(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))));				
				icebreakerVcToken.setVcTokenExpired(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId)), "0"));
	
				if(Integer.parseInt(icebreakerVcToken.getVcTokenExpired()) <= Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
					//시간이 지난 토큰인 경우 새로운 토큰 발행 및 커스텀 필드 저장				
					icebreakerVcToken = TokenProviderUtilforEdison.getVcToken(thisGroupId, userScreenName, userPassword);
		
					//Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다. 
					if(icebreakerVcToken.getResultCode() != 200){
						int updateResult = VCRegisterUtilforEdison.VCUpdate(thisGroupId, userScreenName, userPassword, user.getEmailAddress());
						if(updateResult==200){
							icebreakerVcToken = TokenProviderUtilforEdison.getVcToken(thisGroupId, userScreenName, userPassword);
						}
					}
					
					if(icebreakerVcToken.getResultCode() == 200){
						icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
						icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
						
						user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), icebreakerVcToken.getVcToken());
						user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), icebreakerVcToken.getVcTokenExpired());
					}else{
						System.out.println("SimulationLocalServiceImpl : Icebreaker getOrCreateToken Error !!");
					}
				}
			}else{
				//icebreaker 계정은 있으나 포털에 expando가 없는 경우 expando 추가 생성
				icebreakerVcToken = createExpandoUserVctoken(user, thisGroupId, userScreenName, userPassword);
			}
		}else{
			int resultRegist = VCRegisterUtilforEdison.VCRegist(thisGroupId, userScreenName, userPassword, user.getEmailAddress(), user.getFirstName(), universityField, virtualLabId, classId, majorField);
			if (resultRegist == 201) {
				//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
				icebreakerVcToken = createExpandoUserVctoken(user, thisGroupId, userScreenName, userPassword);
			}
		}
	
		return icebreakerVcToken;
	}
	
	public static IcebreakerVcToken createExpandoUserVctoken(User user, long thisGroupId, String userScreenName, String userPassword) throws SystemException, MalformedURLException, PortalException, IOException, ParseException {

		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
		
		//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
		icebreakerVcToken = TokenProviderUtilforEdison.getVcToken(thisGroupId, userScreenName, userPassword);										
		icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
		icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
		
		if(!user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))){		

			user.getExpandoBridge().addAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), false);
			user.getExpandoBridge().addAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), false);
			
			ExpandoColumn toKenColumn = ExpandoColumnLocalServiceUtil.getColumn(
																			user.getExpandoBridge().getCompanyId(), 
																			user.getExpandoBridge().getClassName(), 
																			ExpandoTableConstants.DEFAULT_TABLE_NAME, 
																			EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId)
																			);
			setExpandoPermissions(user.getExpandoBridge().getCompanyId(), toKenColumn); 
		
			ExpandoColumn expiredColumn = ExpandoColumnLocalServiceUtil.getColumn(
																			user.getExpandoBridge().getCompanyId(), 
																			user.getExpandoBridge().getClassName(), 
																			ExpandoTableConstants.DEFAULT_TABLE_NAME, 
																			EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId)
																			);
			setExpandoPermissions(user.getExpandoBridge().getCompanyId(), expiredColumn);
		}
		
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), icebreakerVcToken.getVcToken());
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), icebreakerVcToken.getVcTokenExpired());
		return icebreakerVcToken;
	}
	
	public static void setExpandoPermissions(long companyId, ExpandoColumn column) throws SystemException {
        
		try {
	 
			Role userRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.USER);
			Role adminRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.ADMINISTRATOR);
	 
	          
			if (userRole != null && adminRole != null) {
				// define actions 
				String[] actionIds = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
				
				Map<Long, String[]> map = new HashMap();
				map.put(userRole.getRoleId(), actionIds);
				map.put(adminRole.getRoleId(), actionIds);
	                
				// set the permission
				ResourcePermissionLocalServiceUtil.setResourcePermissions(
	                															companyId, 
	                															ExpandoColumn.class.getName(), 
	                															ResourceConstants.SCOPE_INDIVIDUAL, 
	                															String.valueOf(column.getColumnId()), 
	                															map
	                															);
	                	                
	            }
	      } catch (PortalException pe) {
	      }
	}
}
