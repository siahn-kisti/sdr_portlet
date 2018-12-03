package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.common.util.CustomUtil;
import com.sdr.common.util.SimulationConstants;
import com.sdr.common.util.TokenProviderUtil;
import com.sdr.common.util.VCRegisterUtil;
import com.sdr.metadata.NoSuchIceBreakerVcTokenException;
import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.service.base.IceBreakerVcTokenLocalServiceBaseImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * The implementation of the ice breaker vc token local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.IceBreakerVcTokenLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.IceBreakerVcTokenLocalServiceBaseImpl
 * @see com.sdr.metadata.service.IceBreakerVcTokenLocalServiceUtil
 */
public class IceBreakerVcTokenLocalServiceImpl
    extends IceBreakerVcTokenLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.IceBreakerVcTokenLocalServiceUtil} to access the ice breaker vc token local service.
     */
	private static Log _log = LogFactoryUtil.getLog(IceBreakerVcTokenLocalServiceImpl.class);
	
    public IceBreakerVcToken getActivatedToken() throws SystemException, IOException, PortalException, ParseException {
        try {
            IceBreakerVcToken token = iceBreakerVcTokenPersistence.findByactivatedToken(1);
            return token;
        } catch (NoSuchIceBreakerVcTokenException e) {
            return null;
        }

    }

    public IceBreakerVcToken createToken(String userScreenName, String userPassword, String userEmailAddress) throws MalformedURLException, PortalException, SystemException, IOException, ParseException {

    	long thisGroupId = SimulationConstants.NANO_GROUP;
    	
        if(VCRegisterUtil.isVcInfo(userScreenName) == 200){

            Map<String, Object> newVcToken = TokenProviderUtil.getVcToken(userScreenName, userPassword);

            // Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다.
            if((int)newVcToken.get("resultCode") != 200){
                int updateResult = VCRegisterUtil.VCUpdate(userScreenName, userPassword, userEmailAddress);
                if(updateResult == 200){
                    newVcToken = TokenProviderUtil.getVcToken(userScreenName, userPassword);
                }
            }

            if((int)newVcToken.get("resultCode") == 200){
                // Add new token to database
                long tokenId = counterLocalService.increment();
                IceBreakerVcToken vcToken = iceBreakerVcTokenPersistence.create(tokenId);
                vcToken.setVcToken((String)newVcToken.get("vcToken"));
                vcToken.setVcTokenExpired((Date)newVcToken.get("vcTokenExpired"));
                vcToken.setActivate(1);
                vcToken.setResultCode(200);
                iceBreakerVcTokenPersistence.update(vcToken);
                return vcToken;

            } else{
            	_log.error("IceBreakerVcTokenLocalServiceImpl : Icebreaker getOrCreateToken Error !!");
                return null;
            }
        } else{
        	_log.error("IceBreakerVcTokenLocalServiceImpl : Icebreaker Admin account Error !!");
            return null;

        }

    }

    public IceBreakerVcToken getOrCreateToken() throws MalformedURLException, PortalException, SystemException, IOException, ParseException{

    	long thisGroupId = SimulationConstants.NANO_GROUP;
        String userScreenName = SimulationConstants.ICEBREAKER_USER_ID;
        String userPassword = SimulationConstants.ICEBREAKER_USER_PWD;
        String userEmailAddress = "kaka7537@kaist.ac.kr";

        IceBreakerVcToken vcToken = getActivatedToken();
        if(vcToken == null) {
            // If there is no token at all, create a new token
            return createToken(userScreenName, userPassword, userEmailAddress);
        }
        else {
            // Token exists in database and
            // check whether the token is expired or not
            if((Integer.parseInt(CustomUtil.dateToStringFormat(vcToken.getVcTokenExpired(), "yyyyMMdd"))) <= Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
                //시간이 지난 토큰인 경우 새로운 토큰 발행 및 커스텀 필드 저장
            	_log.debug("### IceBreaker Token was expired! Get new Token from IB ###");
                if(VCRegisterUtil.isVcInfo(userScreenName) == 200) {
                	Map<String, Object> newVcToken = TokenProviderUtil.getVcToken(userScreenName, userPassword);

                    //Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다.
                    if((int)newVcToken.get("resultCode") != 200){
                        int updateResult = VCRegisterUtil.VCUpdate(userScreenName, userPassword, userEmailAddress);
                        if(updateResult == 200){
                            newVcToken = TokenProviderUtil.getVcToken(userScreenName, userPassword);
                        }
                    }

                    if((int)newVcToken.get("resultCode") == 200){
                        // Set expired token activate value to 0
                        vcToken.setActivate(0);
                        updateIceBreakerVcToken(vcToken);

                        // Add new token to database
                        long tokenId = counterLocalService.increment();
                        IceBreakerVcToken finalVcToken = iceBreakerVcTokenPersistence.create(tokenId);
                        finalVcToken.setVcToken((String)newVcToken.get("vcToken"));
                        finalVcToken.setVcTokenExpired((Date)newVcToken.get("vcTokenExpired"));
                        finalVcToken.setActivate(1);
                        finalVcToken.setResultCode(200);
                        iceBreakerVcTokenPersistence.update(finalVcToken);

                        return finalVcToken;

                    } else{
                    	_log.error("IceBreakerVcTokenLocalServiceImpl : Icebreaker getOrCreateToken Error !!");
                        return null;
                    }
                }
                else {
                	_log.error("IceBreakerVcTokenLocalServiceImpl : Icebreaker Admin account Error !!");
                    return null;

                }
            } else {
                // If token is not expired, just return
                return vcToken;
            }

        }

    }
}
