package com.sdr.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.sdr.guide.model.Guide;
import com.sdr.guide.model.GuideClp;

public class SdrBeanUtils {

	public static void copyProperties(Object source, Object target) {
		org.springframework.beans.BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}
	
	public static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    emptyNames.add("primaryKey"); 			//long
	    emptyNames.add("cachedModel");			//boolean
	    emptyNames.add("escapedModel");			//boolean
	    emptyNames.add("new"); 					//boolean
	    
	    emptyNames.add("primaryKeyObj"); 		//java.io.Serializable
	    emptyNames.add("class"); 				//java.lang.Class
	    emptyNames.add("clpSerializerClass"); 	//java.lang.Class
	    emptyNames.add("modelClass"); 			//java.lang.Class
	    emptyNames.add("modelClassName"); 		//java.lang.String
	    emptyNames.add("uuid"); 				//java.lang.String
	    emptyNames.add("modelAttributes"); 		//java.util.Map
	    
	    emptyNames.add("expandoBridge"); 			//com.liferay.portlet.expando.model
	    emptyNames.add("expandoBridgeAttributes"); 	//com.liferay.portal.model
	    emptyNames.add("guideRemoteModel"); 		//com.liferay.portal.model
	    
	    for(java.beans.PropertyDescriptor pd : pds) {
	    	String type = pd.getPropertyType().getName();
	    	//System.out.println("type="+ type + "\t\t\t\t\t  name="+pd.getName());
	    	
			if (type.startsWith("java.io")) { emptyNames.add(pd.getName()); continue; } 
			else if (type.startsWith("java.lang.Class")) { emptyNames.add(pd.getName()); continue; } 
			else if (type.startsWith("java.util.Map")) { emptyNames.add(pd.getName()); continue; } 
			else if (type.startsWith("java.util.List")) { emptyNames.add(pd.getName()); continue; } 
			else if (type.startsWith("com.liferay")) { emptyNames.add(pd.getName()); continue; }
	    	
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	        else if("long".equals(type) && "0".equals(srcValue.toString())) emptyNames.add(pd.getName());
	    }
	    
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}

	
	//example
	public static void main(String[] args) throws Exception {
		
		Guide svo = new GuideClp();
		svo.setDatasetId(0);
		svo.setDataType("svo-type");
		svo.setTitle("svo-title");
		
		Guide tvo = new GuideClp();
		tvo.setDatasetId(1);
		tvo.setContributors("tvo-contributors");
		tvo.setCollectionName("tvo-collectionName");
		
		System.out.println("svo===>>"+svo.toString());
		
		SdrBeanUtils.copyProperties(svo, tvo);
		
		System.out.println("tvo===>>"+tvo.toString());
		
	}
	
	
}
