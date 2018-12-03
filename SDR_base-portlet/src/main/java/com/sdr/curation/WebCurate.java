package com.sdr.curation;

/*
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet; 
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.metadata.model.Dataset;
*/

public class WebCurate {
	//implements CurateInterface {

	/*
	private static Log log = LogFactoryUtil.getLog(WebCurate.class);
	 
	@Override
	public String curate(Dataset dataset, String datatype) {
		
		String curateUrl = getCurateUrl(dataset.getDatasetPK(), datatype, getDataLocation(dataset) );
		if (curateUrl == null || curateUrl.isEmpty()) {
			System.err.println("Please check if curateRequest variable is set properly in the portlet.properties file");
			// TODO : handle the Rest (Status Change)
			return null;
		}

		String result = curateExecution(curateUrl);
		if (result == null || result.isEmpty() ){
			System.err.println("Please check if docker environment is set properly at " + curateUrl);
			// TODO : handle the Rest (Status Change)
			return null;	
		}
		
		return result;
	}

	protected String getDataLocation(Dataset dataset) {
		// TODO : return dataset.getLocation();
		return "hello";
	}

	protected String getCurateUrl(Long id, String type, String location) {
		String curateUrl = null;
		try {	    
			curateUrl = com.liferay.util.portlet.PortletProps.get("curateRequest");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		String param = "?id=" + id + "&type=" + URLEncoder.encode(type)  + "&location=" + URLEncoder.encode(location);	
		return curateUrl + param;
	}


	protected String curateExecution(String curateUrl) {	
		String result = null;

		HttpClient Ncli = HttpClientBuilder.create().build();
		HttpResponse response = null;
		try {	
			response = Ncli.execute( new HttpGet(curateUrl) ); 
			result = EntityUtils.toString( response.getEntity() ); 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	// TODO : delete below log message
		System.out.println("Response : " + result);  
		return result;
	}
	*/	
}