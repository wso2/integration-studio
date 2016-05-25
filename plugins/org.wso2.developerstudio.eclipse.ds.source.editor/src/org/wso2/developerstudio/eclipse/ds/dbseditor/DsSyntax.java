package org.wso2.developerstudio.eclipse.ds.dbseditor;

public interface DsSyntax {

	public static final String[] rootTag = { "data" };

	public static final String[] leveLOne = { "description", "config", "query", "event-trigger",
	                                         "operation", "resource" };

	public static final String[] configLevel = { "property" };

	public static final String[] queryLevel = { "sql", "result", "param", "sparql", "properties",
	                                           "excel", "gspread" };
	public static final String[] gspreadLevel = { "worksheetnumber", "startingrow", "maxrowcount",
	                                             "hasheader" };

	public static final String[] exelLevel = { "workbookname", "hasheader", "startingrow",
	                                          "maxrowcount" };

	public static final String[] resultLevel = { "element", "attribute", "call-query" };

	public static final String[] queryParamLevel = { "validateLongRange", "validateDoubleRange",
	                                                "validateLength", "validatePattern",
	                                                "validateCustom" };

	public static final String[] callQueryLevel = { "with-param" };

	public static final String[] eventTrigLevel = { "expression", "target-topic", "subscriptions" };

	public static final String[] eventTrigSubscriptionLevel = { "subscription" };

	public static final String[] operationLevel = { "call-query", "call-query-group" };

	public static final String[] callQueryGroupLevel = { "call-query" };

	public static final String[] resourceLevel = { "call-query" };

	public static final String[] propertyLevel = { "property" };

	// Attributes
	public static final String[] dataAttributes = { "name", "enableBatchRequests",
	                                               "enableBoxcarring", "serviceStatus", "baseURI",
	                                               "enableDTP", "serviceGroup" };

	public static final String[] configAttributes = { "id" };

	public static final String[] queryAttributes = { "id", "useConfig", "input-event-trigger",
	                                                "output-event-trigger", "returnGeneratedKeys",
	                                                "keyColumns" };

	public static final String[] eventTriggerAttributes = { "id", "language" };

	public static final String[] operationAttributes = { "name", "disableStreaming",
	                                                    "returnRequestStatus" };

	public static final String[] resourceAttributes = { "path", "method" };

	public static final String[] propertyAttributes = { "name" };

	public static final String[] resultAttributes = { "element", "rowName", "defaultNamespace",
	                                                 "xsltPath", "useColumnNumbers" };

	public static final String[] elementAtrributes = { "name", "column", "xsdType",
	                                                  "requiredRoles", "export" };

	public static final String[] resultAttributeAtrributes = { "name", "column", "xsdType",
	                                                          "requiredRoles" };

	public static final String[] resultParamAttributes = { "name", "paramType", "sqlType", "type",
	                                                      "ordinal", "defaultValue", "structType" };

	public static final String[] validaterAtrributes = { "minimum", "maximum" };

	public static final String[] validaterPatternAttributes = { "validatePattern" };

	public static final String[] validateCustomAttributes = { "validateCustom" };

	public static final String[] callQueryAttributes = { "href" };

	public static final String[] withParamAttributes = { "name", "query-param", "column" };

	public static final String[] sqlAtrributes = { "dialect" };

	Object[] allWords = { rootTag, leveLOne, configLevel, queryLevel, gspreadLevel, exelLevel,
	                     resourceLevel, queryParamLevel, callQueryLevel, eventTrigLevel,
	                     eventTrigSubscriptionLevel, operationLevel, callQueryGroupLevel };

}