package org.wso2.developerstudio.eclipse.ds.presentation.md;

public interface DetailSectionCustomUiConstants {

	/**
	 * These constants have 1-1 mapping with UI_properties in
	 * org.wso2.developerstudio.eclipse.ds.edit plugin.properties
	 * If change constant here please change plugin.properties also.
	 */

	public String STRING = "String";
	public String LONG = "Long";
	public String BIGINTEGER = "BigInteger";
	public String DOUBLE = "Double";
	public String BOOLEAN = "Boolean";
	public String INTEGER = "Integer";
	// data service object constants

	public String DATA_SERVICE_NAME = "Data Service Name";
	public String DATA_SERVICE_GROUP = "Data Service Group";
	public String DATA_SERVICE_NAMESPACE = "Data Service Namespace";
	
	public String BASE_URI = "Base URI";
	public String ENABLE_BATCH_REQUESTS = "Enable Batch Requests";
	public String ENABLE_BOX_CARRING = "Enable Boxcarring";
	public String ENABLE_DTP = "Enable Distributed Transactions";
	
	public String DISABLE_STREAMING = "Disable Streaming";
	public String SERVICE_STATUS = "Service Status";

	public String DATA_SERVICE_DESCRIPTION = "Description";
	public String DATA_SERVICE_TRANSPORTS = "Transports";
	public String ENABLE_SECURITY = "Enable Security";
	public String DATA_SERVICE_POLICY = "Policy";
	public String DATA_SERVICE_PARAMETER_ALLOW_ROLES = "User Roles";

	public String DATA_SOURCE_CONFIGURATION_ID = "DataSource Id";

	public String QUERY_ID = "Query Id";
	public String QUERY_USE_CONFIG = "Data Source";
	public String QUERY_KEY_COLUMNS = "Key Columns";
	public String QUERY_INPUT_EVENT_TRIGGER = "Input Event Trigger";
	public String QUERY_OUTPUT_EVENT_TRIGGER = "Output Event Trigger";
	public String QUERY_RETURN_GENERATED_KEYS = "Return Generated Keys";

	public String QUERY_SQL = "SQL Statment";
	public String QUERY_SPARQL = "SPARQL Statment";
	public String QUERY_EXPRESSION = "Expression Statment";

	public String QUERY_TIMEOUT = "org.wso2.ws.dataservice.query_timeout";
	public String FETCH_DIRECTION = "org.wso2.ws.dataservice.fetch_direction";
	public String FETCH_SIZE = "org.wso2.ws.dataservice.fetch_size";
	public String MAX_FIELD_SIZE = "org.wso2.ws.dataservice.max_field_size";
	public String MAX_ROWS = "org.wso2.ws.dataservice.max_rows";

	public String RESULT_ROW_NAMESPACE = "Row Namespace";
	public String RESULT_GROUPED_BY_ELEMENT = "Grouped by Element";
	public String RESULT_ROW_NAME = "Row Name";
	public String RESULT_USE_COLUMN_NUMBERS = "Use Column Numbers";
	public String RESULT_ESCAPE_NONPRINTABLE_CHAR = "Escape Non-printable Characters";
	public String RESULT_XSLT_PATH = "XSLT Path";
	public String RESULT_OUTPUT_TYPE = "outputType";
	public String RESULT_OUTPUT_TYPE_LABEL = "Output Type";
	// Display items

	public String QUERY_TIMEOUT_DISPLAY = "Timeout (Seconds)";
	public String FETCH_DIRECTION_DISPLAY = "Fetch Direction";
	public String FETCH_SIZE_DISPLAY = "Fetch Size";
	public String MAX_FIELD_SIZE_DISPLAY = "Max Field Size (Bytes)";
	public String MAX_ROWS_DISPLAY = "Max Rows";

	public String ELEMENT_MAPPING_COLUMN_NAME = "Data Source Column Name";
	public String ELEMENT_MAPPING_QUERY_PARAM = "Data Source Query Param Name";
	public String ELEMENT_MAPPING_COLUMN_NUMBUR = "Data Source Column Number";
	public String ELEMENT_MAPPING_EXPORT = "Export Name";
	public String ELEMENT_MAPPING_OUTPUT_FIELD = "Output Field Name";
	public String ELEMENT_MAPPING_COMPLEX_NAME = "Element Name";
	public String ELEMENT_MAPING_ALLOWED_USER_ROLES = "Allowed User Roles";
	public String ELEMENT_MAPPING_SCHEMA_TYPE = "Schema Type";
	public String ELEMENT_MAPPING_NAMESPACE = "Element Namespace";
	public String ELEMENT_MAPPING_EXPORT_TYPE = "Export Type";
	public String ELEMENT_MAPPING_DATA_SOURCE_TYPE = "Data Source Type";
	public String ELEMENT_MAPPING_DAFAULT_VALUE = "Default Value";
	public String ELEMENT_MAPPING_OPTIONAL_PARAM = "Optional";
	public String ELEMENT_MAPPING_ARRAY_NAME = "Array Name";

	public String EXCEL_WORKBOOK_NAME = "Workbook Name";
	public String EXCEL_HAS_HEADER = "Headers available";
	public String EXCEL_STARTING_ROW = "Start reading from";
	public String EXCEL_MAX_ROW_COUNT = "Rows to read";

	public String GSPRED_WORK_SHEET_NUM = "Work Sheet Number";

	public String QUERY_PARAM_DEFAULT_VAL = "Default Value";
	public String QUERY_PARAM_MAPPING_NAME = "Mapping Name";
	public String QUERY_PARAM_ORDINAL = "Ordinal";
	public String QUERY_PARAM_TYPE = "Parameter Type";
	public String QUERY_PARAM_SQL_TYPE = "SQL Type";
	public String QUERY_PARAM_STRUCT_TYPE = "Struct Type";
	public String QUERY_PARAM_IN_OUT = "IN/OUT Type";

	public String VALIDATOR_MAXIMUM = "Maximum Value";
	public String VALIDATOR_MINIMUM = "Minimum Value";

	public String VALIDATOR_PATTORN = "Pattern";
	public String VALIDATOR_CUSTOM = "Class Name";

	public String EVENT_TRIGGER_EXPRESSION = "XPath";
	public String EVENT_TRIGGER_TARGET_TOPIC = "Target Topic";
	public String EVENT_TRIGGER_SUBSCRIPTION = "Subscription";
	public String EVENT_TRIGGER_ID = "Event Id";
	public String EVENT_TRIGGER_LANGUAGE = "Language";

	public String OPERATION_NAME = "Operation Name";
	public String OPERATION_DISABLE_STREAMING = "Disable Streaming";
	public String OPERATION_RETURN_REQUEST_STATUS = "Return Request Status";

	public String CALL_QUERY_LINK = "Query Id";

	public String PARAM_MAPPING_TYPE = "Mapping Type";
	public String PARAM_MAPPING_PARAM_NAME = "Query Parameter Name";
	public String PARAM_MAPPING_PARAM = "Query-Parameter";
	public String PARAM_MAPPING_COLUMN = "Column";
	public String PARAM_MAPPING_COMBO_VAL_0 = "column";
	public String PARAM_MAPPING_COMBO_VAL_1 = "query-param";

	public String RESOURCE_METHOD = "Resource Method";
	public String RESOUCE_PATH = "Resource Path";
	public String RESOURCE_RETURN_REQUEST_STATUS = "Return Request Status";

}
