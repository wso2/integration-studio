/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.util;

/**
 * 
 */

@SuppressWarnings("nls")
public class BPELConstants {
	
	/** The BPEL namespace from 2003 */
	public static final String NAMESPACE_2003 = "http://schemas.xmlsoap.org/ws/2003/03/business-process/";
	
	/** The BPEL namespace from 2004 */
	public static final String NAMESPACE_2004 = "http://schemas.xmlsoap.org/ws/2004/03/business-process/";

	/** The 2.0 BPEL Namespace */
	public static final String NAMESPACE_2007 = "http://docs.oasis-open.org/wsbpel/2.0/process/executable";
	
	/** The 2.0 BPEL Namespace for abstract processes */
	public static final String NAMESPACE_ABSTRACT_2007 = "http://docs.oasis-open.org/wsbpel/2.0/process/abstract";
	
	
	/** The default query language */
	public static final String XMLNS_XPATH_QUERY_LANGUAGE_2007 = "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0";

	/** The "old" default query language */
	public static final String XMLNS_XPATH_QUERY_LANGUAGE_2004 = "http://www.w3.org/TR/1999/REC-xpath-19991116";

	/** The current query language */
	public static final String XMLNS_XPATH_QUERY_LANGUAGE = XMLNS_XPATH_QUERY_LANGUAGE_2007;
	
	/** The default expression language */
	public static final String XMLNS_XPATH_EXPRESSION_LANGUAGE_2007 = "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0";

	/** The "old" default expression language */
	public static final String XMLNS_XPATH_EXPRESSION_LANGUAGE_2004 = "http://www.w3.org/TR/1999/REC-xpath-19991116";

	/** The current expression language */
	public static final String XMLNS_XPATH_EXPRESSION_LANGUAGE = XMLNS_XPATH_EXPRESSION_LANGUAGE_2007;
	
	/** The Abstract Process Profile for Observable Behavior */
	public static final String NAMESPACE_ABSTRACT_PROFILE_OB = "http://docs.oasis-open.org/wsbpel/2.0/process/abstract/ap11/2006/08";
	
	/** Abstract Process Profile for Templates */
	public static final String NAMESPACE_ABSTRACT_PROFILE_T = "http://docs.oasis-open.org/wsbpel/2.0/process/abstract/simple-template/2006/08";
	
	/**
	 * The current namespace.
	 */
	public static String NAMESPACE = NAMESPACE_2007;

    /**
     * The preferred namespace prefix.
     */
    public static final String PREFIX = "bpel";
    
    /**
	 * The current abstract process profile namespace.
	 */
	public static String NAMESPACE_ABSTRACT_PROFILE = NAMESPACE_ABSTRACT_PROFILE_T;
	
	/**
	 *  failureHandling extension provided by ODE: JIRA:TOOLS-785
	 *  Constants;
	 *  
	 */
	public static String NAMESPACE_FAILURE_HANDLING_URL = "http://ode.apache.org/activityRecovery";
	public static String NAMESPACE_FAILURE_HANDLING_PREFIX = "ext";
	public static String NODE_FAILURE_HANDLING= "failureHandling";
	
	public static String NODE_FAULT_ON_FAILURE = "ext:faultOnFailure";
	public static String NODE_RETRY_FOR = "ext:retryFor";
	public static String NODE_RETRY_DELAY = "ext:retryDelay";
	
    /**
	 * Tests if <code>namespace</code> equals any of the valid namespaces.
	 * @param namespace The namespace
	 * @return true if partner link namespace.
	 */
	
	public static boolean isBPELNamespace (String namespace)
	{
		return namespace != null
			&& ( (namespace.equals(NAMESPACE_2004)) || 
				 (namespace.equals(NAMESPACE_2007)) ||
				 (namespace.equals(NAMESPACE_ABSTRACT_2007)) );
	}
	
    /**
     * Standard faults defined in the BPEL specification.
     */
	public static final String[] standardFaults = {
		"ambiguousReceive",	//$NON-NLS-1$ 	 
		"completionConditionFailure",
		"conflictingReceive", //$NON-NLS-1$ 
		"conflictingRequest",  //$NON-NLS-1$
		"correlationViolation", //$NON-NLS-1$ 
		"invalidBranchCondition", //$NON-NLS-1$ 
		"invalidExpressionValue", //$NON-NLS-1$ 
		"invalidVariables", //$NON-NLS-1$		 
		"joinFailure", //$NON-NLS-1$		
		"mismatchedAssignmentFailure", //$NON-NLS-1$
		"missingReply", //$NON-NLS-1$
		"missingRequest", //$NON-NLS-1$   
		"scopeInitializationFailure", //$NON-NLS-1$
		"selectionFailure", //$NON-NLS-1$
		"subLanguageExecutionFault", //$NON-NLS-1$
		"uninitializedPartnerRole", //$NON-NLS-1$
		"uninitializedVariable", //$NON-NLS-1$
		"unsupportedReference", //$NON-NLS-1$ 	
		"xsltInvalidSource", //$NON-NLS-1$ 
		"xsltStylesheetNotFound", //$NON-NLS-1$ 

	};
    
	

	//
    // constants
    //
    public static final String YES = "yes";
    public static final String NO  = "no";
    public static final String JOIN = "join";
    
    public static final String REQUEST = "request";
    public static final String RESPONSE = "response";
    public static final String REQUEST_RESPONSE = "request-response";
    //
    
    public static final String XMLNS = "xmlns";
    
    // node names (bpel XML)
    public static final String ND_PROCESS = "process";
    public static final String ND_OPAQUEACTIVITY = "opaqueActivity";
    public static final String ND_EMPTY = "empty";
    public static final String ND_INVOKE = "invoke";
    public static final String ND_RECEIVE = "receive";
    public static final String ND_REPLY = "reply";
    public static final String ND_ASSIGN = "assign";
    public static final String ND_WAIT = "wait";
    public static final String ND_THROW = "throw";
    public static final String ND_FLOW = "flow";
    public static final String ND_WHILE = "while";
    public static final String ND_REPEAT_UNTIL = "repeatUntil";
    public static final String ND_SEQUENCE = "sequence";
    public static final String ND_PICK = "pick";
    public static final String ND_SCOPE = "scope";
    public static final String ND_PARTNER_LINKS = "partnerLinks";
    public static final String ND_PARTNER_LINK = "partnerLink";
    public static final String ND_EVENT_HANDLERS = "eventHandlers";
    public static final String ND_FAULT_HANDLERS = "faultHandlers";
    public static final String ND_CATCH = "catch";
    public static final String ND_CATCH_ALL = "catchAll";
    public static final String ND_ON_MESSAGE = "onMessage";
    public static final String ND_ON_ALARM = "onAlarm";
    public static final String ND_ON_EVENT = "onEvent";
    public static final String ND_VARIABLES = "variables";
    public static final String ND_VARIABLE = "variable";
    public static final String ND_CORRELATION_SETS = "correlationSets";
    public static final String ND_CORRELATION_SET = "correlationSet";
    public static final String ND_SOURCE = "source";
    public static final String ND_SOURCES = "sources";
    public static final String ND_TARGET = "target";
    public static final String ND_TARGETS = "targets";
    public static final String ND_JOIN_CONDITION = "joinCondition";
    public static final String ND_TRANSITION_CONDITION = "transitionCondition";
    public static final String ND_COPY = "copy";
    public static final String ND_FROM = "from";
    public static final String ND_TO = "to";
    public static final String ND_LINKS = "links";
    public static final String ND_LINK = "link";        
    public static final String ND_IF = "if";
    public static final String ND_ELSEIF = "elseif";
    public static final String ND_ELSE = "else";
    public static final String ND_IMPORT = "import";
    public static final String ND_FROM_PART = "fromPart";
    public static final String ND_FROM_PARTS = "fromParts";
    public static final String ND_TO_PART = "toPart";
    public static final String ND_TO_PARTS = "toParts";
    public static final String ND_LITERAL = "literal";
    public static final String ND_QUERY = "query";
    public static final String ND_CONDITION = "condition";
    public static final String ND_UNTIL = "until";
    public static final String ND_FOR = "for";
    
    public static final String ND_FOR_EACH = "forEach";
    public static final String ND_START_COUNTER_VALUE = "startCounterValue";
    public static final String ND_FINAL_COUNTER_VALUE = "finalCounterValue";
    public static final String ND_COMPLETION_CONDITION = "completionCondition";
    public static final String ND_BRANCHES = "branches";
    public static final String ND_EXIT = "exit";
    public static final String ND_COMPENSATE_SCOPE = "compensateScope";
    public static final String ND_VALIDATE = "validate";
    public static final String ND_EXTENSION_ACTIVITY = "extensionActivity";
    
    public static final String ND_EXTENSION_ASSIGN_OPERATION = "extensionAssignOperation";
    
    public static final String ND_CORRELATIONS = "correlations";
    public static final String ND_CORRELATION = "correlation";
    public static final String ND_COMPENSATE = "compensate";
    public static final String ND_COMPENSATION_HANDLER = "compensationHandler";
    public static final String ND_RETHROW = "rethrow";
    public static final String ND_TERMINATION_HANDLER = "terminationHandler";
    public static final String ND_REPEAT_EVERY = "repeatEvery";
    
    public static final String ND_MESSAGE_EXCHANGES = "messageExchanges";
    public static final String ND_MESSAGE_EXCHANGE = "messageExchange";
    
    public static final String ND_EXTENSION = "extension";
    public static final String ND_EXTENSIONS = "extensions";
    
    
  
    // Attribute nodes
    public static final String AT_NAME = "name";
    public static final String AT_TARGET_NAMESPACE = "targetNamespace";    
    public static final String AT_ISOLATED = "isolated";
    public static final String AT_QUERYLANGUAGE = "queryLanguage";
    public static final String AT_EXPRESSIONLANGUAGE = "expressionLanguage";
    public static final String AT_EXIT_ON_STANDARD_FAULT = "exitOnStandardFault";    
    public static final String AT_SUPPRESS_JOIN_FAILURE = "suppressJoinFailure";
    public static final String AT_JOIN_CONDITION = "joinCondition";
    public static final String AT_VARIABLE_ACCESS_SERIALIZABLE = "variableAccessSerializable";
    public static final String AT_ENABLE_INSTANCE_COMPENSATION = "enableInstanceCompensation";
    public static final String AT_ABSTRACT_PROCESSES = "abstractProcess";
    public static final String AT_ABSTRACT_PROFILES = "abstractProcessProfile";
    public static final String AT_PARTNER_LINK_TYPE = "partnerLinkType";
    public static final String AT_FAULT_NAME = "faultName";
    public static final String AT_FAULT_VARIABLE = "faultVariable";
    public static final String AT_PARTNER = "partner";
    public static final String AT_PARTNER_LINK = "partnerLink";
    public static final String AT_MESSAGE_EXCHANGE = "messageExchange";
    public static final String AT_PORT_TYPE = "portType";
    public static final String AT_OPERATION = "operation";
    public static final String AT_VARIABLE = "variable";
    public static final String AT_FOR = "for";
    public static final String AT_UNTIL = "until";
    public static final String AT_MESSAGE_TYPE = "messageType";
    public static final String AT_TYPE = "type";
    public static final String AT_ELEMENT = "element";
    public static final String AT_PROPERTIES = "properties";
    public static final String AT_LINK_NAME = "linkName";
    public static final String AT_TRANSITION_CONDITION = "transitionCondition";
    public static final String AT_INPUT_VARIABLE = "inputVariable";
    public static final String AT_OUTPUT_VARIABLE = "outputVariable";
    public static final String AT_CREATE_INSTANCE = "createInstance";
    public static final String AT_PART = "part";
    public static final String AT_QUERY = "query";
    public static final String AT_OPAQUE = "opaque";
    public static final String AT_PROPERTY = "property";
    public static final String AT_EXPRESSION = "expression";
    public static final String AT_CONDITION = "condition";
    public static final String AT_MY_ROLE = "myRole";
    public static final String AT_PARTNER_ROLE = "partnerRole";
    public static final String AT_SET = "set";
    public static final String AT_INITIATE = "initiate";
    public static final String AT_PATTERN = "pattern";
    public static final String AT_LANGUAGE = "language";
    public static final String AT_VERSION = "version";
    public static final String AT_IMPORT = "import";
    public static final String AT_IMPORT_TYPE = "importType";
    public static final String AT_LOCATION = "location";
    public static final String AT_NAMESPACE = "namespace";
    public static final String AT_ENDPOINT_REFERENCE = "endpointReference";
    public static final String AT_SCOPE = "scope";
    public static final String AT_LABEL = "label";
    public static final String AT_LABEL_STATUS = "status";
    public static final String AT_TIMEOUT = "timeout";
    public static final String AT_SUPPRESS_COORD_FAILURE = "suppressCoordinationFailure";
    public static final String AT_FROM = "from";
    public static final String AT_TO = "to";
    public static final String AT_VARIABLES = "variables";
    public static final String AT_TARGET = "target";
    public static final String AT_TO_VARIABLE = "toVariable";
    public static final String AT_FROM_VARIABLE = "fromVariable";
    public static final String AT_INITIALIZE_PARTNER_ROLE = "initializePartnerRole";
    public static final String AT_VALIDATE = "validate";
    public static final String AT_KEEP_SRC_ELEMENT_NAME = "keepSrcElementName";
    public static final String AT_ACTIVITY = "activity";
    public static final String AT_ACTIVITIES = "activities";
    public static final String AT_LINKS = "links";
    public static final String AT_SUCCESSFUL_BRANCHES_ONLY = "successfulBranchesOnly" ;    
    public static final String AT_FAULT_MESSAGE_TYPE = "faultMessageType";
    public static final String AT_FAULT_ELEMENT = "faultElement";
    public static final String AT_COUNTER_NAME = "counterName";
    public static final String AT_PARALLEL = "parallel";
    public static final String AT_KEEP_SRC_ELEMENT = "keepSrcElement";
    public static final String AT_MUST_UNDERSTAND = "mustUnderstand";
    public static final String AT_IGNORE_MISSING_FROM_DATA = "ignoreMissingFromData";
    public static final String AT_SOURCE = "source";
    public static final String AT_REFERENCE_SCHEME = "reference-scheme";
    public static final String AT_XSI_TYPE = "xsi:type";
}
