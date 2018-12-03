package com.sdr.rest.servlet;

import com.google.gson.Gson;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.servlet.ProtectedServletRequest;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.sdr.metadata.model.*;
import com.sdr.metadata.service.*;

import com.sdr.rest.servlet.interceptor.SecureRequestHandlerInterceptor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
public class RestServletController {

	private static Log _log = LogFactoryUtil.getLog(RestServletController.class);

	@RequestMapping(value = "/api")
	public String view() throws SystemException {
		return "SDR_rest/api";
	}


	/**
	 * 모든 사이트의 목록을 리스트
	 *
	 * @return List<Map>
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/site", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> site() throws SystemException {
		List<Map> result = new ArrayList<>();

		List<Group> list = GroupLocalServiceUtil.getGroups(-1,-1);
		for(Group g : list) {
			if(g.getSite() && g.getActive())
				result.add(g.getModelAttributes());
		}

		return result;
	}

	/**
	 * 모든 사이트의 목록을 리스트 개수
	 *
	 * @return long
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/site/count", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody int siteCount() throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Group.class, "group", PortletClassLoaderUtil.getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("group.active", true))
			.add(RestrictionsFactoryUtil.eq("group.site", true));
		return (int)GroupLocalServiceUtil.dynamicQueryCount(query);
	}
	/**
	 * 모든 사이트의 목록을 리스트 start, end
	 *
	 * @return List<Map>
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/site/start/{start}/end/{end}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> siteSize(@PathVariable("start") int start, @PathVariable("end") int end, Model model) throws SystemException {
		List<Map> result = new ArrayList<>();

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Group.class, "group", PortletClassLoaderUtil.getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("group.active", true))
			.add(RestrictionsFactoryUtil.eq("group.site", true));

		List<Group> list = GroupLocalServiceUtil.dynamicQuery(query, start, end);
		for(int i=0; i<list.size(); i++) {
			result.add(list.get(i).getModelAttributes());
		}
		return result;
	}


	private ServiceContext getServiceContext(long groupId){
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(PrincipalThreadLocal.getUserId());
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		return serviceContext;
	}
	/**
	 * {groupId}의 모든 컬렉션을 리스트
	 *
	 * @return List<Map>
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/site/{groupId}/collection", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> site(@PathVariable("groupId") long groupId) throws PrincipalException, PortalException, SystemException {
		List<Map> result = new ArrayList<>();

		List<Collection> list = CollectionServiceUtil.getList(groupId, getServiceContext(groupId));
		for(Collection c : list)
			result.add(c.getModelAttributes());

		return result;
	}

	/**
	 * {groupId}의 모든 컬렉션을 리스트개수
	 *
	 * @return int
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/site/{groupId}/collection/count", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody int siteCount(@PathVariable("groupId") long groupId) throws PortalException, SystemException {
		return CollectionServiceUtil.getCount(groupId, getServiceContext(groupId));
	}

	/**
	 * {groupId}의 모든 컬렉션을 리스트 start, end
	 *
	 * @return List<Map>
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/site/{groupId}/collection/start/{start}/end/{end}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> siteSize(@PathVariable("groupId") long groupId, @PathVariable("start") int start, @PathVariable("end") int end) throws PrincipalException, PortalException, SystemException {
		List<Map> result = new ArrayList<>();
		ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Collection.class, "collection", classLoader);
		query.add(RestrictionsFactoryUtil.eq("collection.groupId", groupId));

		List<Collection> list = CollectionLocalServiceUtil.dynamicQuery(query, start, end);
		for(Collection c : list)
			result.add(c.getModelAttributes());

		return result;
	}

	/**
	 * 모든 컬렉션의 목록을 반환
	 *
	 * @return List<Map>
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/collection", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> collection() throws PrincipalException, PortalException, SystemException {
		List<Map> result = new ArrayList<>();

		List<Collection> list = CollectionLocalServiceUtil.getList();
		for(Collection c : list)
			result.add(c.getModelAttributes());

		return result;
	}

	/**
	 * 모든 컬렉션의 목록의 개수 반환
	 *
	 * @return int
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/collection/count", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody int collectionCount() throws PrincipalException, PortalException, SystemException {
		return  CollectionLocalServiceUtil.getCount();
	}

	/**
	 * 모든 컬렉션의 목록을 리스트 start, end
	 *
	 * @return List<Map>
	 * @throws SystemException
	 */
	@RequestMapping(value = "/api/collection/start/{start}/end/{end}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> collectionSize(@PathVariable("start") int start, @PathVariable("end") int end) throws PrincipalException, PortalException, SystemException {
		List<Map> result = new ArrayList<>();

		List<Collection> list = CollectionLocalServiceUtil.getList(start,end);
		for(Collection c : list)
			result.add(c.getModelAttributes());

		return result;
	}

	/**
	 * {collectionId} 컬렉션의 메타데이터를 반환
	 *
	 * @param collectionId
	 * @return Map
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/collection/{collectionId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map collection(@PathVariable("collectionId") long collectionId) throws SystemException, PortalException {
		Map result = new HashMap();

		ServiceContext serviceContext = getServiceContext(CollectionServiceUtil.getGroupId(collectionId));
		Collection c = CollectionServiceUtil.getCollection(collectionId, serviceContext);
		result = c.getModelAttributes();

		return result;
	}

	/**
	 * {collectionId} 컬렉션의 모든 데이터셋의 목록을 반환
	 *
	 * @param collectionId
	 * @return List<Map>
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/collection/{collectionId}/dataset", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> collectionDataset(@PathVariable("collectionId") long collectionId, @RequestParam(required = false) String[] property) throws SystemException, PortalException {
		List<Map> result = new ArrayList<>();

		java.lang.reflect.Field idField[] = null;
		idField = DatasetSoap.class.getDeclaredFields ();
		ArrayList<String> nameList = new ArrayList<>();
		ServiceContext serviceContext = getServiceContext(CollectionServiceUtil.getGroupId(collectionId));
		List<Dataset> list = DatasetServiceUtil.getList(collectionId, WorkflowConstants.STATUS_APPROVED, -1, -1, serviceContext);

		if(property != null && property.length > 0){
			result = customgFields(property, list);
		}else{
			for(Dataset c : list){
				result.add(	c.getModelAttributes());
			}
		}
		return result;
	}
	public List<Map> customgFields(String[] property, List<Dataset> list){
		List<Map> result = new ArrayList<>();
		java.lang.reflect.Field idField[] = null;
		idField = DatasetSoap.class.getDeclaredFields ();
		ArrayList<String> nameList = new ArrayList<>();
		for(int j=0; j < property.length; j++){
			for(int i=0; i < idField.length; i++){
				String fiieldName = idField[i].getName();
				fiieldName = fiieldName.substring(1);
				if(fiieldName.equals(property[j])){
					nameList.add(property[j]);
				}
			}
		}
		for(Dataset c : list){
			Map temp = new HashMap();
			for(int i=0; i < nameList.size(); i++){
				Map map  = c.getModelAttributes();
				temp.put(nameList.get(i), String.valueOf(map.get(nameList.get(i))));
			}
			result.add(temp);
		}

		return result;
	}

	/**
	 * {collectionId} 컬렉션의 모든 데이터셋의 목록의 개수 반환
	 *
	 * @param collectionId
	 * @return int
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/collection/{collectionId}/dataset/count", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody int collectionDatasetCount(@PathVariable("collectionId") long collectionId) throws SystemException, PortalException {
		ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");
		DynamicQuery query =  DynamicQueryFactoryUtil.forClass(Dataset.class, classLoader);
		query.add(RestrictionsFactoryUtil.eq("collectionId", collectionId));

		return (int)DatasetLocalServiceUtil.dynamicQueryCount(query);
	}

	/**
	 * {collectionId} 컬렉션의 모든 데이터셋의 목록을 반환 start, end
	 *
	 * @param collectionId
	 * @return List<Map>
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/collection/{collectionId}/dataset/start/{start}/end/{end}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> collectionDatasetSize(@PathVariable("collectionId") long collectionId,
														 @PathVariable("start") int start, @PathVariable("end") int end,
														 @RequestParam(required = false) String[] property) throws PortalException, SystemException {
		List<Map> result = new ArrayList<>();
		ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");
		DynamicQuery query =  DynamicQueryFactoryUtil.forClass(Dataset.class, classLoader);
		query.add(RestrictionsFactoryUtil.eq("collectionId", collectionId));
		List<Dataset> list = DatasetLocalServiceUtil.dynamicQuery(query, start, end);
		if(property != null && property.length > 0){
			result = customgFields(property, list);
		}else{
			for(Dataset c : list){
				result.add(	c.getModelAttributes());
			}
		}

		return result;
	}

	/**
	 * 모든 데이터 타입의 목록을 반환
	 *
	 * @return List<Map>
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/datatype", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> datatype() throws SystemException, PortalException {
		List<Map> result = new ArrayList<>();

		List<DataType> list = DataTypeServiceUtil.getList(getServiceContext(0));
		for(DataType c : list)
			result.add(c.getModelAttributes());

		return result;
	}

	/**
	 * 모든 데이터 타입의 목록의 개수 반환
	 *
	 * @return int
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/datatype/count", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody int datatypeCount() throws SystemException, PortalException {
		return DataTypeLocalServiceUtil.getCount();
	}

	/**
	 * 모든 데이터 타입의 목록을 반환리스트 start, end
	 *
	 * @return List<Map>
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/datatype/start/{start}/end/{end}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> datatypeSize(@PathVariable("start") int start, @PathVariable("end") int end) throws SystemException, PortalException {
		List<Map> result = new ArrayList<>();

		List<DataType> list = DataTypeLocalServiceUtil.getList(start,end);
		for(DataType c : list)
			result.add(c.getModelAttributes());

		return result;
	}


	/**
	 * {dataTypeId} 타입의 메타데이터를 반환
	 *
	 * @param dataTypeId
	 * @return Map
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/datatype/{dataTypeId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map dataType(@PathVariable("dataTypeId") long dataTypeId) throws SystemException, PortalException {
		Map result = new HashMap();

		DataType c = DataTypeServiceUtil.getDataType(dataTypeId, getServiceContext(0));
		result = c.getModelAttributes();

		return result;
	}

	/**
	 * {dataTypeId} 타입의 메타데이터를 반환
	 *
	 * @param dataTypeName
	 * @return Map
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/datatypeName/{dataTypeName}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map dataType(@PathVariable("dataTypeName") String dataTypeName) throws SystemException, PortalException {
		Map result = new HashMap();
		// TODO : Acccess Control
		DataType c = DataTypeLocalServiceUtil.getDataTypeByTitle(dataTypeName);
		if (c != null)
			result = c.getModelAttributes();

		return result;
	}

	/**
	 * {dataTypeId} 타입의 메타데이터를 반환
	 *
	 * @param dataTypeName
	 * @return Map
	 * @throws SystemException
	 * @throws PortalException
	 */

	@RequestMapping(value = "/api/datatypeName/{dataTypeName}/dataset", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> dataTypeDataset(@PathVariable("dataTypeName") String dataTypeName) throws SystemException, PortalException {
		List<Map> result = new ArrayList<>();

		// TODO : Acccess Control
		DataType dataType = DataTypeLocalServiceUtil.getDataTypeByTitle(dataTypeName);
		if (dataType != null){
			List<Dataset> list = DatasetLocalServiceUtil.getDatasetsByDataType(dataType.getDataTypeId());
			for(Dataset c : list)
				result.add(c.getModelAttributes());
		}

		return result;
	}

	/**
	 * {datasetId} 데이터셋의 메타데이터를 반환
	 *
	 * @param datasetId
	 * @return Map
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/dataset/{datasetId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map dataset(@PathVariable("datasetId") long datasetId, @RequestParam(required = false) String[] property) throws SystemException, PortalException {
		Map result = new HashMap();

		ServiceContext serviceContext = getServiceContext(DatasetServiceUtil.getGroupId(datasetId));
		Dataset c = DatasetServiceUtil.getDataset(datasetId, serviceContext);

		if(property != null && property.length > 0){
			List<Dataset> list = new ArrayList<>();
			list.add(c);
			result.putAll(customgFields(property, list).get(0));
		}else{
			result = c.getModelAttributes();
			//result.put("dataTypeId", c.getDataTypeId());

			result.remove("publishDate");
			result.remove("version");
			result.remove("checksum");
			result.remove("descriptiveMetadata");
			result.remove("provenanceMetadata");
			result.remove("location");
			result.remove("metalocation");
			//result.remove("groupId");
			result.remove("companyId");
			result.remove("remote");
			result.remove("fileFinalized");
			result.remove("statusByUserId");
			result.remove("statusByUserName");
			result.remove("statusDate");
			result.remove("hashcode");

			Gson gson = new Gson();
			Map dmMap = new HashMap();
			dmMap = gson.fromJson(c.getDescriptiveMetadata(), dmMap.getClass());
			result.putAll(dmMap);
		}

		return result;
	}

	/**
	 * {datasetId} 데이터셋의 파일 리스트를 반환
	 *
	 * @param datasetId
	 * @return List<Map>
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/dataset/{datasetId}/file", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> datasetFile(@PathVariable("datasetId") long datasetId) throws SystemException, PortalException {
		List<Map> result = new ArrayList<>();

		Dataset c = DatasetServiceUtil.getDataset(datasetId,getServiceContext(DatasetServiceUtil.getGroupId(datasetId)) );
		String location = c.getLocation();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		File folder = new File(location);
		if (!folder.exists()) return null;

		ArrayList<File> files = new ArrayList<>();
		visitAllFiles(files, folder);

		for(File f : files) {
			Map map = new HashMap();
			map.put("name", f.getName());
			map.put("length", f.length());
			map.put("date", sdf.format(f.lastModified()));
			String path = f.getPath();
			String filePath = path.substring(path.indexOf("/uploaded/")+10);
			map.put("path", filePath);
			result.add(map);
		}

		return result;
	}
	/**
	 * {datasetId} 데이터셋의 파일 리스트를 반환리스트의 개수
	 *
	 * @param datasetId
	 * @return List<Map>
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/dataset/{datasetId}/file/count", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody int datasetFileCount(@PathVariable("datasetId") long datasetId) throws SystemException, PortalException {
		return (datasetFile(datasetId)).size();
	}

	/**
	 * {datasetId} 데이터셋의 파일 리스트를 반환리스트 start,end
	 *
	 * @param datasetId
	 * @return List<Map>
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/dataset/{datasetId}/file/start/{start}/end/{end}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Map> datasetFileSize(@PathVariable("datasetId") long datasetId, @PathVariable("start") int start, @PathVariable("end") int end) throws SystemException, PortalException {
		List<Map> result = new ArrayList<>();
		List<Map> tempListMap = datasetFile(datasetId);
		for(int i=0; i<tempListMap.size(); i++){
			if(start <= i && i < end){
				result.add(tempListMap.get(i));
			}
		}
		return result;
	}

	private void visitAllFiles(ArrayList files, File dir) {
		if(dir.isDirectory()) {
			File[] children = dir.listFiles();
			for(File f : children) {
				visitAllFiles(files,f);
			}
		} else {
			files.add(dir);
		}
	}


	/**
	 * {condition}의 검색조건으로 Advanced Search
	 *
	 * @param condition
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/search/{condition:.+}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void search(@PathVariable("condition") String condition, HttpServletResponse response)  {

		try {
			response.getWriter().print(search(0, condition, -1, -1, false));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * {condition}의 검색조건으로 Advanced Search의 개수
	 *
	 * @param condition
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/search/{condition:.+}/count", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void searchCount(@PathVariable("condition") String condition, HttpServletResponse response)  {

		try {
			response.getWriter().print(search(0, condition, -1, -1, true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {condition}의 검색조건으로 Advanced Search List start end
	 *
	 * @param condition
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/search/{condition:.+}/start/{start}/end/{end}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void searchSize(@PathVariable("condition") String condition, HttpServletResponse response, @PathVariable("start") int start, @PathVariable("end") int end)  {

		try {
			response.getWriter().print(search(0, condition, start, end, false));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * {datatype}별 {condition}의 검색조건으로 Advanced Search
	 *
	 * @param groupId
	 * @param condition
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	*/

	@RequestMapping(value = "/api/search/{condition}/site/{groupId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void searchDataType(@PathVariable("condition") String condition, @PathVariable("groupId") long groupId, HttpServletResponse response) throws SystemException, PortalException, IOException {
		response.getWriter().print(search(groupId, condition, -1, -1, false));
	}

	/**
	 * {datatype}별 {condition}의 검색조건으로 Advanced Search의 개수
	 *
	 * @param groupId
	 * @param condition
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */

	@RequestMapping(value = "/api/search/{condition}/site/{groupId}/count", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void searchDataTypeCount(@PathVariable("condition") String condition, @PathVariable("groupId") long groupId, HttpServletResponse response) throws SystemException, PortalException, IOException {
		response.getWriter().print(search(groupId, condition, -1, -1, true));
	}

	/**
	 * {start}와 {length} 기준으로 해단 데이터 건수만큼의 {groupId}와 {condition}의 검색조건으로 Advanced Search
	 *
	 * @param condition
	 * @param groupId
	 * @param start
	 * @param length
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException
	 */
	@RequestMapping(value = "/api/search/{condition}/site/{groupId}/start/{start}/length/{length}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void searchStartLength(@PathVariable("condition") String condition,@PathVariable("groupId") long groupId,
							   @PathVariable("start") int start, @PathVariable("length") int length,
							   HttpServletResponse response) throws SystemException, PortalException, IOException {
		response.getWriter().print(search(groupId, condition, start, length, false));
	}

	private StringBundler search(long groupId, String condition, int start, int length, boolean count) throws SystemException, PortalException {
		//JSONArray result = JSONFactoryUtil.createJSONArray();
		StringBundler result = null;

		String searchQuery = condition;

		SearchContext searchContext = new SearchContext();
		searchContext.setAndSearch(true);
		searchContext.setLike(false);
		searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());

		BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);
		mainQuery.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);


		/* DataType
		if(dataTypes!=null && "".equals(dataTypes)){
			String dataTypeQuery = "AND (DataType:oqmd OR DataType:vasp)";
			String[] dataTypeArray = dataTypes.split(",");
			for (String dataType : dataTypeArray) {
				if(!"".equals(dataTypeQuery)) dataTypeQuery += " OR ";
				dataTypeQuery += "DataType:" + dataType;
			}
			if(!"".equals(condition)) condition += " AND ";
			condition += dataTypeQuery;
		}
		*/

		if (groupId != 0) {
			subQuery.addExactTerm("groupId", groupId);
			mainQuery.add(subQuery, BooleanClauseOccur.SHOULD);
		}

		if (!searchQuery.isEmpty()) {
			Query stringQuery = StringQueryFactoryUtil.create(searchQuery);
			mainQuery.add(stringQuery, BooleanClauseOccur.MUST);
		}

		_log.debug(" #### rest advanced query search : "+mainQuery);
		//Hits hits = SearchEngineUtil.search(searchContext, mainQuery);
		ServiceContext serviceContext = getServiceContext(0);

		/*pre search
		Query stringQuery = StringQueryFactoryUtil.create(condition);
		BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, stringQuery, BooleanClauseOccur.MUST.getName());
		searchContext.setBooleanClauses(new BooleanClause[] {clause});
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Dataset.class);
        */

		Hits hits;

		//validate max length
		if(length>100000){
			throw new RestErrorException("You have limited the maximum search(100,000). Set param length to less than 100,000");
		}else if(length<0){
			searchContext.setStart(0);
			searchContext.setEnd(0);

			hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);

			if(hits.getLength()>100000){
				throw new RestErrorException("You have limited the maximum search(max 100,000). Change the search query or add params(start, length).");
			}
		}

		//search
		searchContext.setStart((start>-1)?start:-1);
		searchContext.setEnd((start+length>-1)?start+length:-1);
		hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);

		int docSize = hits.getDocs().length;
		if(count){
			result = new StringBundler();
			result.append(docSize);
		}else{
			result = getDatasetsByHits(hits);
		}

		return result;
	}

	private StringBundler getDatasetsByHits(Hits hits) throws PortalException, SystemException {
		if(hits.getDocs().length<=0)
			return new StringBundler("[]");

		//get schemaTypes
		Map<String, String> schemaTypes = getSchemaTypes(getSchemaKeys(), hits.doc(0));

		StringBundler result = new StringBundler();
		result.append("[");
		Document doc = null;
		JSONObject dataset = null;
		JSONArray arr = null;
		String[] values = null;

		//document to json
		int docSize = hits.getDocs().length;
		for (int i = 0; i < docSize; i++) {
			if(hits.doc(i).get(Field.CLASS_PK) != "" && hits.doc(i).get(Field.CLASS_PK) != null && hits.doc(i).get("dataTypeId") != "" && hits.doc(i).get("dataTypeId") != null){
				for (int retries = 0;; retries++) {
					try {

						doc = hits.doc(i);
						dataset = JSONFactoryUtil.createJSONObject();

						dataset.put("datasetId", Long.parseLong(doc.get(Field.CLASS_PK)));
						dataset.put("title", doc.get(Field.TITLE));
						dataset.put("userId", Long.parseLong(doc.get(Field.USER_ID)));
						dataset.put("userName", doc.get(Field.USER_NAME));
						dataset.put("createDate", doc.getDate(Field.CREATE_DATE));
						dataset.put("status", Long.parseLong(doc.get(Field.STATUS)));
						dataset.put("collectionId", Long.parseLong(doc.get("collectionId")));
						dataset.put("dataTypeId", Long.parseLong(doc.get("dataTypeId")));
						dataset.put("DataType", doc.get("DataType"));

						for (String key : schemaTypes.keySet()) {
							String val = schemaTypes.get(key);

							if (doc.getValues(key).length > 1) {
								arr = JSONFactoryUtil.createJSONArray();
								values = doc.getValues(key);

								int valSize = values.length;
								for (int k = 0; k < valSize; k++) {
									String ss = values[k];
									if (ss == null || "".equals(ss)) {
										arr.put(ss);
										continue;
									}
									if ("double".equals(val)) arr.put(Double.parseDouble(ss));
									else if ("int".equals(val)) arr.put(Integer.parseInt(ss));
									else if ("string".equals(val)) arr.put(ss);
									else if ("object".equals(val)) arr.put(JSONFactoryUtil.createJSONObject(ss));
									else if ("array".equals(val)) arr.put(JSONFactoryUtil.createJSONArray(ss));
									else {
										dataset.put(key, ss);
									}
								}
								dataset.put(key, arr);

							} else {
								String s = doc.get(key);
								if (s == null || "".equals(s)) {
									dataset.put(key, s);
									continue;
								}
								if ("string".equals(val)) dataset.put(key, s);
								else if ("double".equals(val)) dataset.put(key, Double.parseDouble(s));
								else if ("int".equals(val)) dataset.put(key, Integer.parseInt(s));
								else if ("object".equals(val)) dataset.put(key, JSONFactoryUtil.createJSONObject(s));
								else if ("array".equals(val)) dataset.put(key, JSONFactoryUtil.createJSONArray(s));
								else {
									dataset.put(key, s);
								}
							}
						}

						if (i > 0) result.append(",");
						result.append(dataset.toString());

						values = null;
						arr = null;
						dataset = null;
						doc = null;

						break;
					} catch (Exception e) {
						if (retries < 2) {
							schemaTypes = getSchemaTypes(getSchemaKeys(), doc);        //schema type 을 다시 조사
							//_log.info("### retries ::: " + retries);
							continue;
						}
					}
				}
			}
		}
		result.append("]");
		return result;
	}


	// 모든 DataType의 schema 정보를 가져온다(중복제거)
	private List<String> getSchemaKeys() throws SystemException, PortalException {
		List<String> schemaKeys = new ArrayList<String>();
		List<DataType> dataTypeList = DataTypeLocalServiceUtil.getList();
		for (DataType dataType : dataTypeList) {
			List<DataTypeSchema> schemaList = DataTypeSchemaLocalServiceUtil.getList(dataType.getDataTypeId());
			for(DataTypeSchema schema : schemaList){
				schemaKeys.add(schema.getTitle());
			}
		}
		schemaKeys = new ArrayList<String>(new HashSet<String>(schemaKeys));
		return schemaKeys;
	}

	// Document의 Schema Type을 가져온다
	private Map<String, String> getSchemaTypes(List<String> schemaKeys, Document tmpDoc){
		Map<String, String> schemaTypes  = new HashMap();
		for(String key : schemaKeys){
			if(tmpDoc.getValues(key).length>1) {
				String[] values = tmpDoc.getValues(key);
				for(String s : values){
					schemaTypes.put(key, getJsonType(s));
					//_log.debug("### schemaTypes ::: " +key + " : " + schemaTypes.get(key) + "  val : " + s);
					break;
				}
			} else {
				String s = tmpDoc.get(key);
				schemaTypes.put(key, getJsonType(s));
				//_log.debug("### schemaTypes ::: " +key + " : " + schemaTypes.get(key) + "  val : " +s);
			}
		}
		//_log.debug("### schemaTypes ::: " +schemaTypes.toString());
		return schemaTypes;

	}


	private String getJsonType(String s) {
		String type = "";
		try {
			JSONFactoryUtil.createJSONObject(s);
			type = "object";
		} catch (Exception e) {
			try {
				JSONFactoryUtil.createJSONArray(s);
				type = "array";
			} catch (Exception e2) {
				try {
					Integer.parseInt(s);
					type = "int";
				} catch (Exception e3) {
					try {
						Double.parseDouble(s);
						type = "double";
					} catch (Exception e4) {
						type = "string";
					}
				}
			}
		}
		return type;
	}



	/**
	 * {datasetId} 파일을 다운로드
	 *
	 * @param datasetId
	 * @param request
	 * @param response
	 * @return File
	 * @throws SystemException
	 * @throws IOException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/file/dataset/{datasetId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void datasetFile(@PathVariable("datasetId") long datasetId, HttpServletRequest request, HttpServletResponse response) throws SystemException, IOException, PortalException {

		ServiceContext serviceContext = getServiceContext(DatasetServiceUtil.getGroupId(datasetId));
		Dataset dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);
		String location = dataset.getLocation();
		String filePath = location + File.separator + ".." + File.separator + datasetId + ".zip";

		FileService.zip(location, filePath);
		File outputFile = new File(filePath);
		Path outputPath = outputFile.toPath();

		ServletResponseUtil.sendFile(request, response,
				outputFile.getName(),
				Files.readAllBytes(outputPath),
				Files.probeContentType(outputPath));

		outputFile.delete();
	}

	/**
	 * {datasetId}의 {FileName} 파일을 다운로드
	 *
	 * @param datasetId
	 * @param request
	 * @param response
	 * @return File
	 * @throws SystemException
	 * @throws IOException
	 * @throws PortalException
	 */
	@RequestMapping(value = "/api/file/dataset/{datasetId}/path/**", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void datasetFilePath(@PathVariable("datasetId") long datasetId, HttpServletRequest request, HttpServletResponse response) throws SystemException, IOException, PortalException {
		String pathVariable = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		int index_path = pathVariable.indexOf("/path/");
		String path = pathVariable.substring(index_path+5);

		Dataset dataset = DatasetServiceUtil.getDataset(datasetId, getServiceContext(-1));
		String location = dataset.getLocation();
		String filePath = location + path;

		File outputFile = new File(filePath);
		Path outputPath = outputFile.toPath();

		ServletResponseUtil.sendFile(request, response,
				outputFile.getName(),
				Files.readAllBytes(outputPath),
				Files.probeContentType(outputPath));
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	class RestErrorException extends SystemException {
		public RestErrorException(String e) {
			super(e);
		}
	}

}