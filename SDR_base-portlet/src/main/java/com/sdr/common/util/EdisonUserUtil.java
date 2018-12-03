package com.sdr.common.util;

import java.util.ArrayList;
import java.util.List;

import com.sdr.common.model.EdisonRoleConstants;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;

public class EdisonUserUtil {
	
	private static Log _log = LogFactoryUtil.getLog(EdisonUserUtil.class);
	
	/**
	 * 해당 유저의 사이트 룰 리스트 조회
	 * @param user
	 * @return
	 */
	public static List<Role> getUserSiteRoles(User user){
		List<Role> returnList = new ArrayList<Role>();
		
		try{
			List<UserGroupRole> userGroupList = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId());
			for(UserGroupRole userGroupRole:userGroupList){
				returnList.add(userGroupRole.getRole());
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		return returnList;
	}
	
	/**
	 * 해당 유저의 레귤러 룰 리스트 조회
	 * @param user
	 * @return
	 */
	public static List<Role> getUserRegularRoles(User user){
		List<Role> returnList = new ArrayList<Role>();
		try{
			returnList = RoleLocalServiceUtil.getUserRoles(user.getUserId());
			for(UserGroup userGroup : user.getUserGroups()){
				List<Role> roleList =RoleLocalServiceUtil.getGroupRoles(userGroup.getGroup().getGroupId());
				for(Role role:roleList){
					returnList.add(role);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		
		return returnList;
	}
	
	/**
	 * 룰 타입에 따른  EDISON 포털에서 사용중인 룰 목록 조회
	 * @param roleType
	 * @return
	 */
	public static List<Role> getEdisonRoleList(int roleType){
		List<Role> returnList = new ArrayList<Role>();
		try{
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			List<Role> roleList = RoleLocalServiceUtil.getRoles(companyId);
			for(Role role : roleList){
				if(role.getType()==roleType){
					returnList.add(role);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		return returnList;
	}
	
	/**
	 * 해당 유저의 해당 그룹 삭제
	 * @param user
	 * @param groupName
	 */
	public static void deleteGroup(User user, String groupName){
		try{
			List<UserGroup> userGroupList = UserGroupLocalServiceUtil.getUserGroups(user.getCompanyId());
			UserGroup targetUserGroup = null;
			userFor:for(UserGroup userGroup : userGroupList){
				if(userGroup.getName().equals(groupName)){
					targetUserGroup = userGroup;
					break userFor;
				}
			}
			UserGroupLocalServiceUtil.deleteUserUserGroup(user.getUserId(),targetUserGroup.getUserGroupId());
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
	}
	
	/**
	 * 해당 유저의 해당 사이트룰 삭제
	 * @param user
	 * @param groupId
	 * @param siteRoleName
	 */
	public static void deleteSiteRole(User user,Long groupId, String siteRoleName){
		try{
			Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), siteRoleName);
			UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(user.getUserId(), groupId, new long[] {role.getRoleId()});
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		
	}
	
	/**
	 * 해당 유저의 해당 레귤러 룰 삭제
	 * @param user
	 * @param roleName
	 */
	public static void deleteRegularRole(User user,String roleName){
		try{
			Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), roleName);
			RoleLocalServiceUtil.deleteUserRole(user.getUserId(),role.getRoleId());
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		
	}
	
	
	/**
	 * 해당 유저에게 그룹 추가
	 * @param user
	 * @param groupName
	 * @throws SystemException 
	 */
	public static boolean addGroup(User user, String groupName) throws SystemException{
		if(isGroup(user,groupName)){return false;}else{
			List<UserGroup> userGroupList = UserGroupLocalServiceUtil.getUserGroups(user.getCompanyId());
			UserGroup targetUserGroup = null;
			userFor:for(UserGroup userGroup : userGroupList){
				if(userGroup.getName().equals(groupName)){
					targetUserGroup = userGroup;
					break userFor;
				}
			}
			
			UserGroupLocalServiceUtil.addUserUserGroup(user.getUserId(),targetUserGroup.getUserGroupId());
			return true;
		}
	}
	
	/**
	 * 해당 유저에게 사이트 룰 추가
	 * @param user
	 * @param groupId
	 * @param siteRoleName
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static boolean addSiteRole(User user,Long groupId, String siteRoleName) throws PortalException, SystemException{
		if(ArrayUtil.contains(EdisonRoleConstants.SYSTEM_SITE_ROLES,siteRoleName)){
			if(isSiteRole(user,groupId,siteRoleName)){return false;}else{
				Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), siteRoleName);
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(),groupId, new long[] {role.getRoleId()});
				return true;
			}
		}else{
			_log.error(siteRoleName+"<<---IS NOT SITE ROLE");
			return false;
		}
		
	}
	
	/**
	 * 해당 유저에게 레귤러 룰 추가
	 * @param user
	 * @param roleName
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static boolean addRegularRole(User user,String roleName) throws PortalException, SystemException{
		if(ArrayUtil.contains(EdisonRoleConstants.SYSTEM_ROLES,roleName)){
			if(isRegularRole(user, roleName)){return false;}else{
				Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), roleName);
				RoleLocalServiceUtil.addUserRole(user.getUserId(), role.getRoleId());
				return true;
			}
		}else{
			_log.error(roleName+"<<---IS NOT Regular ROLE");
			return false;
		}
		
			
	}
	
	/**
	 * 해당 그룹 포함 여부
	 * @param user
	 * @param groupName
	 * @return
	 */
	public static boolean isGroup(User user, String groupName){
		try{
			List<UserGroup> userGroupList = UserGroupLocalServiceUtil.getUserGroups(user.getCompanyId());
			UserGroup targetUserGroup = null;
			userFor:for(UserGroup userGroup : userGroupList){
				if(userGroup.getName().equals(groupName)){
					targetUserGroup = userGroup;
					break userFor;
				}
			}
			return UserGroupLocalServiceUtil.hasUserUserGroup(user.getUserId(), targetUserGroup.getUserGroupId());
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤 존재 여부 확인
	 * @param user
	 * @param roleName
	 * @return
	 */
	public static boolean isRegularRole(User user, String roleName){
		try{
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			return RoleServiceUtil.hasUserRole(user.getUserId(), companyId, roleName, true);
//			Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), roleName);
//			return RoleLocalServiceUtil.hasUserRole(user.getUserId(),role.getRoleId());
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}

	}
	
	/**
	 * 사이트 롤 존재 여부 확인
	 * @param user
	 * @param groupId
	 * @param siteRoleName
	 * @return
	 */
	public static boolean isSiteRole(User user,Long groupId, String siteRoleName){
		try{
			if(siteRoleName.equals(EdisonRoleConstants.SITE_MEMBER)){
				return GroupLocalServiceUtil.hasUserGroup(user.getUserId(), groupId);
			}else{
				return UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(),groupId,siteRoleName);
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
		
	}
	
	/**
	 * 해당 사이트의 튜터 권한을 가지고 있는지 조회
	 * @param user
	 * @param groupId
	 * @return
	 */
	public static boolean isSiteTutorThan(User user,Long groupId){
		try{
			if(isRegularRole(user,EdisonRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.POWER_USER)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.TUTOR)){
				if(isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_LAB_OWNER)){
					return true;
				}else if(isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER)){
					return true;
				}else if(isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER)){
					return true;
				}else if(isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER)){
					return true;
				}else if(isSiteRole(user, groupId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER)){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 해당 사이트의 개발자 권한을 가지고 있는지 조회
	 * @param user
	 * @param groupId
	 * @return
	 */
	public static boolean isSiteDeveloperThan(User user,Long groupId){
		try{
			if(isRegularRole(user,EdisonRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.POWER_USER)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.DEVELOPER)){
				if(isSiteRole(user, groupId, EdisonRoleConstants.SOLVER_OWNER)){
					return true;
				}else if(isSiteRole(user, groupId, EdisonRoleConstants.SOLVER_MANAGER)){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤을 기준으로 DEVELOPER 이상의 권한이 있는지를 확인
	 * @param user
	 * @return
	 */
	public static boolean isDeveloperThan(User user){
		try{
			if(isRegularRole(user,EdisonRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.POWER_USER)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.DEVELOPER)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤을 기준으로 Professor 이상의 권한이 있는지를 확인
	 * @param user
	 * @return
	 */
	public static boolean isProfessorThan(User user){
		try{
			if(isRegularRole(user,EdisonRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.POWER_USER)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.PROFESSOR)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤을 기준으로 TUTOR 이상의 권한이 있는지를 확인
	 * @param user
	 * @return
	 */
	public static boolean isTutorThan(User user){
		try{
			if(isRegularRole(user,EdisonRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.POWER_USER)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.TUTOR)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤을 기준으로 powerUser 이상의 권한이 있는지 확인
	 * @param user
	 * @return
	 */
	public static boolean isPowerUserThan(User user){
		try{
			if(isRegularRole(user,EdisonRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.POWER_USER)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 프로젝트롤을 기준으로 PROJECT 이상의 권한이 있는지 확인
	 * @param user
	 * @return
	 */
	public static boolean isProjectThan(User user){
		try {
			if(isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,EdisonRoleConstants.POWER_USER)){
				return true;
			}else if(isRegularRole(user, EdisonRoleConstants.PROJECT)){
				return true;
			}else{
				return false;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
}
