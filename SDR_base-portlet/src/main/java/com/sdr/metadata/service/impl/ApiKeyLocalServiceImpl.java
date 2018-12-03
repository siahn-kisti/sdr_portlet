package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.NoSuchApiKeyException;
import com.sdr.metadata.model.ApiKey;
import com.sdr.metadata.model.impl.ApiKeyImpl;
import com.sdr.metadata.service.base.ApiKeyLocalServiceBaseImpl;

/**
 * The implementation of the api key local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.ApiKeyLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.ApiKeyLocalServiceBaseImpl
 * @see com.sdr.metadata.service.ApiKeyLocalServiceUtil
 */
public class ApiKeyLocalServiceImpl extends ApiKeyLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.ApiKeyLocalServiceUtil} to access the api key local service.
     */

	/**
	 * Get.
	 *
	 * @param userId
	 * @return ApiKey
	 */
    public ApiKey get(long userId) {
    	//TODO: pk값 없을시 NoSuchApiKeyException 오류.. 로그에 WARN으로 기록됨.. 그냥 오류없이 null을 받고싶음..

		ApiKey apiKey = null;
		try {
			apiKey = apiKeyPersistence.findByPrimaryKey(userId);
		} catch (SystemException e) {
			//e.printStackTrace();
		} catch (NoSuchApiKeyException e) {
			//e.printStackTrace();
		}
		return apiKey;
	}

	/**
	 * Save.
	 *
	 * @param userId
	 * @param apiKey
	 * @return ApiKey
	 * @throws SystemException
	 */
    public ApiKey save(long userId, String apiKey) throws SystemException {

    	ApiKey vo = new ApiKeyImpl();
    	vo.setUserId(userId);
    	vo.setApiKey(apiKey);

    	apiKeyPersistence.update(vo);

    	return vo;
	}

}
