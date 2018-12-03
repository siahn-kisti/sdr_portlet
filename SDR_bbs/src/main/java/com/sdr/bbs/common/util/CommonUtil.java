package com.sdr.bbs.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sdr.bbs.common.model.BbsPostVo;
import com.sdr.bbs.model.BbsPost;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * The type Common util.
 */
public class CommonUtil {

	private static Log log = LogFactoryUtil.getLog(CommonUtil.class);

	/**
	 * Instantiates a new Common util.
	 */
	public CommonUtil() {
		super();
	}

	/**
	 * Gets dataset search context.
	 *
	 * @param companyId    the company id
	 * @param scopeGroupId the scope group id
	 * @param entryClass   the entry class
	 * @return the dataset search context
	 * @Methods Name : getDatasetSearchContext
	 * @작성일 : 2017. 7. 20.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : Dataset SearchContext 가져오기
	 */
	public static SearchContext getDatasetSearchContext(long companyId, long scopeGroupId, Class<?> entryClass) {
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);

		long[] groupIds = { scopeGroupId };
		searchContext.setGroupIds(groupIds);

		String[] entryClassNames = { entryClass.getName() };
		searchContext.setEntryClassNames(entryClassNames);

		return searchContext;
	}


	/**
	 * Gets admin.
	 *
	 * @return the admin
	 */
	public static User getAdmin() {
		final long companyId = PortalUtil.getDefaultCompanyId();
		Role role = null;
		try {
			role = getRoleById(companyId, RoleConstants.ADMINISTRATOR);
			for (final User admin : UserLocalServiceUtil.getRoleUsers(role.getRoleId())) {
				return admin;
			}
		} catch (final Exception e) {
			log.error("Utils::getAdmin Exception", e);
		}
		return null;
	}

	/**
	 * Gets role by id.
	 *
	 * @param companyId the company id
	 * @param roleStrId the role str id
	 * @return the role by id
	 */
	public static Role getRoleById(final long companyId, final String roleStrId) {
		try {
			return RoleLocalServiceUtil.getRole(companyId, roleStrId);
		} catch (final Exception e) {
			log.error("Utils::getRoleById Exception", e);
		}
		return null;
	}
}
