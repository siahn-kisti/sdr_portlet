package com.sdr.curation;

public class ErrorConst {
    public static final int _OK = 0;

    /* system error : never happens */
    public static final int _ERROR_PORTAL_EXCEPTION = 10;
    public static final int _ERROR_IO_EXCEPTION = 11;

    /* preprocessing launching error */
    public static final int _ERROR_DOCKER_EXEC   = 101;
    public static final int _ERROR_PREPROCESSING = 102;
    public static final int _ERROR_INVALID_COMMAND_IN_SIMPLE = 111;
    public static final int _ERROR_INVALID_ARGS_IN_SIMPLE = 112;
    public static final int _ERROR_INVALID_BUFFER_IN_SIMPLE = 113;
    public static final int _ERROR_INVALID_OUT_IN_SIMPLE = 114;


    /* basic DB error : never happens */
    public static final int _ERROR_INVALID_DATASET = 201;
    public static final int _ERROR_INVALID_DATATYPE = 202;
    public static final int _ERROR_INVALID_COLLECTION = 203;


    /* ERROR Code for Validation */
    public static final int _ERROR_INVALID_DATA_LOCATION = 301;
    public static final int _ERROR_INVALID_DATA_SOURCE = 302;
    public static final int _ERROR_VALIDATE_FILE = 303;
    public static final int _ERROR_TOO_LONG_METADATA = 304;
    public static final int _ERROR_OPEN_METADATA = 305;
    public static final int _ERROR_VALIDATE_METADATA = 306;
    public static final int _ERROR_CREATE_CHECKSUM = 307;

    // ERROR code for Simulation Job
    public static final int _ERROR_CONNECTION = 401;
    public static final int _ERROR_AUTH = 402;
    public static final int _ERROR_INVALIDE_JOB = 403;
    public static final int _ERROR_BAD_HTTP_REQEUST = 404;
    public static final int _ERROR_UNKNOWN_HTTP = 405;
    public static final int _ERROR_TOKEN = 406;
    public static final int _ERROR_INVALIDE_CALLBACK = 407;

    // ERROR code for Simulation job IO Handling
    public static final int _ERROR_SIM_OUTPUT = 501;
    public static final int _ERROR_SIM_INPUT = 502;
    public static final int _ERROR_SIM_META = 503;
    public static final int _ERROR_JOB_STATUS = 504;
    public static final int _ERROR_JOB_NOT_SUCCESS = 505;


    public static String getErrorMessage(int code) {
        switch (code) {
            /* system error : never happens */
            case _ERROR_PORTAL_EXCEPTION :
                return "Portal Exception";
            case _ERROR_IO_EXCEPTION :
                return "IO Exception";

            /* preprocessing launching error */
            case _ERROR_DOCKER_EXEC :
                return "Error in launching Container";
            case _ERROR_PREPROCESSING :
                return "Error in launching Preprocessing Logic";

            /* basic DB error : never happens */
            case _ERROR_INVALID_DATASET :
                return "Invalid Dataset";
            case _ERROR_INVALID_DATATYPE :
                return "Invalid Data Type";
            case _ERROR_INVALID_COLLECTION :
                return "Invalid Collection";

            /* ERROR Code for Validation */
            case _ERROR_INVALID_DATA_LOCATION :
                return "Invalid Data Location";
            case _ERROR_INVALID_DATA_SOURCE :
                return "Invalid Import Source";
            case _ERROR_VALIDATE_FILE :
                return "File Validation Error";
            case _ERROR_TOO_LONG_METADATA :
                return "too long metadata";
            case _ERROR_OPEN_METADATA :
                return "Error to open metadata file";
            case _ERROR_VALIDATE_METADATA :
                return "Error to validate metadata file";
            case _ERROR_CREATE_CHECKSUM :
                return "Error to create checksum";

            // ERROR code for Simulation Job
            case _ERROR_CONNECTION :
                return "Connection Error to access the Simulation Job";
            case _ERROR_AUTH :
                return "Authentication Error to access the Simulation Job";
            case _ERROR_INVALIDE_JOB :
                return "Invalid Job ID";
            case _ERROR_BAD_HTTP_REQEUST :
                return "Bad HTTP Request";
            case _ERROR_UNKNOWN_HTTP :
                return "Unknown HTTP Error";
            case _ERROR_TOKEN :
                return "Invalid Authentication Token";
            case _ERROR_INVALIDE_CALLBACK :
                return "invalid callback URL";

            // ERROR code for Simulation job IO Handling
            case _ERROR_SIM_OUTPUT :
                return "Error in handling Simulation Output";
            case _ERROR_SIM_INPUT :
                return "Error in handling Simulation Input";
            case _ERROR_SIM_META  :
                return "Error in handling Simulation Metadata";
            case _ERROR_JOB_STATUS :
                return "Job Status Error";
            case _ERROR_JOB_NOT_SUCCESS :
                return "Job is not Finished yet or Failed. Check Status";


            default :
                return "Unknown Error Code : " + code ;
        }
    }


    public static String getUserErrorMessage(int code) {
        switch (code) {
            /* system error : never happens */
            case _ERROR_PORTAL_EXCEPTION :
            case _ERROR_IO_EXCEPTION :
                return "Portal Error. Please Contact System Admin.";

            /* preprocessing launching error */
            case _ERROR_DOCKER_EXEC :
            case _ERROR_PREPROCESSING :
                return "Error in Preprocess. Please refer log messages";

            /* basic DB error : never happens */
            case _ERROR_INVALID_DATASET :
            case _ERROR_INVALID_COLLECTION :
                return "Inconsistent DB Error. Please Contact System Admin.";
            case _ERROR_INVALID_DATATYPE :
                return "Given Data Type is invalid";


            /* ERROR Code for Validation */
            case _ERROR_INVALID_DATA_LOCATION :
                return "Invalid Data Location";
            case _ERROR_INVALID_DATA_SOURCE :
                return "Invalid Import Source";
            case _ERROR_VALIDATE_FILE :
                return "Error in validating Files";
            case _ERROR_TOO_LONG_METADATA :
                return "Too long metadata";
            case _ERROR_OPEN_METADATA :
                return "Error to open metadata file";
            case _ERROR_VALIDATE_METADATA :
                return "Error in validating metadata file";
            case _ERROR_CREATE_CHECKSUM :
                return "Error to create checksum";

            // ERROR code for Simulation Job
            case _ERROR_INVALIDE_JOB :
                return "Invalid EDISON Job ID";
            case _ERROR_CONNECTION :
                return "Connection Error to access the Simulation Job";
            case _ERROR_AUTH :
                return "Authentication Error to access the Simulation Job";
            case _ERROR_BAD_HTTP_REQEUST :
                return "Bad HTTP Request";
            case _ERROR_UNKNOWN_HTTP :
                return "Unknown HTTP Error";
            case _ERROR_TOKEN :
                return "Invalid Authentication Token";
            case _ERROR_INVALIDE_CALLBACK :
                return "invalid callback URL";

            // ERROR code for Simulation job IO Handling
            case _ERROR_SIM_OUTPUT :
            case _ERROR_SIM_INPUT :
            case _ERROR_SIM_META  :
                return "Error to retrieving Simulation Result";
            case _ERROR_JOB_STATUS :
                return "Job Status Error";
            case _ERROR_JOB_NOT_SUCCESS :
                return "Job is not Finished yet or Failed. Check Status";


            default :
                return "Unknown Error Code : " + code ;
        }
    }
}
