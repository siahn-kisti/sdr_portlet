package com.sdr.metadata.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

/**
 * The type Metadata validator.
 */
public class MetadataValidator {

	private static Log _log = LogFactoryUtil.getLog(MetadataValidator.class);


	public static void validate(com.liferay.portal.kernel.json.JSONObject validateSchemaJson, String descriptiveMetadata) throws SystemException {
		JSONObject convertValidateSchemaJson = MetadataValidator.convertJSONObject(validateSchemaJson);
		JSONObject convertMetadata = new org.json.JSONObject(descriptiveMetadata);

		//_log.debug("### convertValidateSchemaJson ::: " +convertValidateSchemaJson);
		//_log.debug("### convertMetadata ::: " +convertMetadata);

		Schema schema = SchemaLoader.load(convertValidateSchemaJson);
		try {
			schema.validate(convertMetadata);
		} catch (ValidationException e) {

			String msg = "error: "+e.getMessage();
			for(ValidationException err : e.getCausingExceptions()){
				msg += "\nerror detail: "+err.getMessage();
				_log.error("### msg : " +err.getMessage());
			}
			//_log.error("### total msg : " +msg);

			throw new SystemException(msg);
		}

	}


	/**
	 * Convert json object json object.
	 *
	 * @param object the object
	 * @return the json object
	 */
	public static JSONObject convertJSONObject(com.liferay.portal.kernel.json.JSONObject object){
		JSONObject obj = new org.json.JSONObject(object.toString());
		return obj;

	}


	//--------------------------------------------------------------------------------------------


	/**
	 * Example test.
	 */
	public static void example_test(){

		String validateSchema = "{\n" +
				"\t\"type\" : \"object\",\n" +
				"\t\"properties\" : {\n" +
				"\t\t\"rectangle\" : {\"$ref\" : \"#/definitions/Rectangle\" }\n" +
				"\t},\n" +
				"\t\"definitions\" : {\n" +
				"\t\t\"size\" : {\n" +
				"\t\t\t\"type\" : \"number\",\n" +
				"\t\t\t\"minimum\" : 0\n" +
				"\t\t},\n" +
				"\t\t\"Rectangle\" : {\n" +
				"\t\t\t\"type\" : \"object\",\n" +
				"\t\t\t\"properties\" : {\n" +
				"\t\t\t\t\"a\" : {\"$ref\" : \"#/definitions/size\"},\n" +
				"\t\t\t\t\"b\" : {\"$ref\" : \"#/definitions/size\"}\n" +
				"\t\t\t}\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}";

		String metadata = "{\n" +
				"\t\"rectangle\" : {\n" +
				"\t\t\"a\" : -4,\n" +
				"\t\t\"b\" : \"aaa\"\n" +
				"\t}\n" +
				"}";

		JSONObject validateSchemaJson = new JSONObject(validateSchema);
		JSONObject metadataJson = new JSONObject(metadata);

		System.out.println("validateSchemaJson:::"+ validateSchemaJson);
		System.out.println("metadataJson:::"+metadataJson);

		example(validateSchemaJson, metadataJson);
	}


	/**
	 * Example.
	 *
	 * @param validateSchemaJson the validate schema json
	 * @param metadataJson       the metadata json
	 */
	public static void example(JSONObject validateSchemaJson, JSONObject metadataJson) {

		Schema schema = SchemaLoader.load(validateSchemaJson);
		try {
			schema.validate(metadataJson);
		} catch (ValidationException e) {
			// prints #/rectangle/a: -5.0 is not higher or equal to 0
			System.out.println(e.getMessage());

			for(ValidationException err : e.getCausingExceptions()){
				System.out.println(err.getMessage());
			}
		}

	}


	/**
	 * Data type schema test.
	 *
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
//----------------------------------------------------------------------------------------------------
	public static void dataTypeSchemaTest() throws PortalException, SystemException {

		Dataset dataset = DatasetLocalServiceUtil.getDataset(2122);
		long dataTypeId = dataset.getDataTypeId();

		JSONObject validateSchemaJson = convertJSONObject(DataTypeSchemaLocalServiceUtil.getDataTypeSchemaValidateRule(dataTypeId));
		JSONObject metadata = new JSONObject(dataset.getDescriptiveMetadata());

		_log.debug("### validateSchemaJson ::: " +validateSchemaJson);
		_log.debug("### metadata ::: " +metadata);

		Schema schema = SchemaLoader.load(validateSchemaJson);
		try {
			schema.validate(metadata);
		} catch (ValidationException e) {

			String msg = "error: "+e.getMessage();
			for(ValidationException err : e.getCausingExceptions()){
				msg += "\nerror detail: "+err.getMessage();
			}
			_log.error("### msg :::  " +msg);

			throw new SystemException(msg);
		}
	}



	/**
	 * Test.
	 */
	public static void test() {
		try {
			dataTypeSchemaTest();
		} catch (PortalException e) {
			_log.error("### dataTypeSchemaTest ::: " +e.getMessage());
		} catch (SystemException e) {
			_log.error("### dataTypeSchemaTest ::: " +e.getMessage());
		}
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {

		//example_test();
		//listToJson();

	}

}

