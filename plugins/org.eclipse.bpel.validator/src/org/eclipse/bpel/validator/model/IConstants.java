/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator.model;

import javax.xml.namespace.QName;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 18, 2006
 *
 */

@SuppressWarnings("nls")
public interface IConstants {

	/**
	 * Ask for the resource Path that the INode belongs to.
	 */
	public final String META_RESOURCE_PATH = "meta.resource.path"; //$NON-NLS-1$
	
	
	/**
	 * We use the JAXEN XPath Expression parser. Return the function meta
	 * information for the validator from IModelQuery.
	 */
	public static final String META_JAXEN_XPATH_FUNCTION_CONTEXT = "meta.jaxen.xpath.function.context"; //$NON-NLS-1$
	
	/** 
	 * Parse a duration string.
	 */
	public static final String META_XML_PARSE_DURATION = "meta.parse.xml.duration"; //$NON-NLS-1$
	
	/**
	 * Parse XML Date and time
	 */
	public static final String META_XML_PARSE_DATE_AND_TIME = "meta.parse.xml.dateAndTime"; //$NON-NLS-1$
	
	/**
	 * Will print errors/warnings if the runtime indicates that XPath functions must be resovled
	 * and there is no meta information about them.
	 */
	public static final String META_XPATH_MUST_RESOLVE_FUNCTIONS = "meta.must.resolve.functions";  //$NON-NLS-1$
	
	/**
	 * Lookup the prefix and return the Namespace given.
	 */
	
	public static final String META_XMLNS_PREFIX2NS = "meta.prefix.to.ns";
	
	
	/** The default expression language */
	public static final String XMLNS_XPATH_EXPRESSION_LANGUAGE  = "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0"; //$NON-NLS-1$
	public static final String XMLNS_XPATH_EXPRESSION_LANGUAGE_XPATH2  = "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath2.0"; //$NON-NLS-1$

	/** A variant from previous spec iterations */
	public static final String XMLNS_XPATH_EXPRESSION_LANGUAGE_2 = "http://www.w3.org/TR/1999/REC-xpath-19991116"; //$NON-NLS-1$
	
	/** The default query language */
	public static final String XMLNS_XPATH_QUERY_LANGUAGE = "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0";
	public static final String XMLNS_XPATH_QUERY_LANGUAGE_XPATH2 = "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath2.0";

	public static final String XMLNS_XPATH_QUERY_LANGUAGE_2 = "http://www.w3.org/TR/1999/REC-xpath-19991116";
	
	/** Namespaces ...
	 * 
	 */
	
	public static final String XMLNS_XSI = "http://www.w3.org/2001/XMLSchema-instance";

	/** XSD Namespace */
	public static final String XMLNS_XSD = "http://www.w3.org/2001/XMLSchema";

	/** WSDL namespace	 */
	public static final String XMLNS_WSDL = "http://schemas.xmlsoap.org/wsdl/";

	/** vprop namespace */
	public static final String XMLNS_VPROP = "http://docs.oasis-open.org/wsbpel/2.0/varprop";

	/** old vprop namespace */
	public static final String XMLNS_VPROP_OLD = "http://schemas.xmlsoap.org/ws/2004/03/business-process/";
	
	
	public static final String XMLNS_SREF = "http://docs.oasis-open.org/wsbpel/2.0/serviceref";

	/** Partner link namespace */
	public static final String XMLNS_PLNK = "http://docs.oasis-open.org/wsbpel/2.0/plnktype";

	/** Other partner link namespace */
	public static final String XMLNS_PLNK_OLD = "http://schemas.xmlsoap.org/ws/2004/03/partner-link/";

	/** The BPEL 2.0 executable namespace */
	public static final String XMLNS_BPEL20_EXECUTABLE = "http://docs.oasis-open.org/wsbpel/2.0/process/executable";
	public static final String XMLNS_ODE_E4X = "http://ode.apache.org/extensions/e4x";

	/** The old pre 2.0 NS */
	public static final String XMLNS_BPEL20_OLD = "http://schemas.xmlsoap.org/ws/2004/03/business-process/"; //$NON-NLS-1$
	
	/** Abstract BPEL 2.0 Process namespace */
	public static final String XMLNS_ABSTRACT = "http://docs.oasis-open.org/wsbpel/2.0/process/abstract";
	
	
	/**
	 *  The BPEL 1.1 namespace.
	 */	
	public static final String XMLNS_BPEL_11 = "http://";  //$NON-NLS-1$
	
	/**
	 * The default BPEL 2.0 namespace.
	 */
	public static final String XMLNS_BPEL = XMLNS_BPEL20_EXECUTABLE;
	
	/** 
	 * E4X Name Space 
	 */
	public static final String XMLNS_E4X = "http://ode.apache.org/extensions/e4x";
	
	/**
	 * BPEL4PEOPLE Name Space
	 */
	public static final String XMLNS_BPEL4PEOPLE = "http://docs.oasis-open.org/ns/bpel4people/bpel4people/200803";
	//
    // constants
    //
    public static final String YES = "yes";
    public static final String NO  = "no";
    public static final String JOIN = "join";
    
    public static final String REQUEST = "request";
    public static final String RESPONSE = "response";
    public static final String REQUEST_RESPONSE = "request-response";
    public static final String IN = "in";
    public static final String OUT = "out";
    //
    
    public static final String PARTNER_ROLE = "partnerRole";
    public static final String MY_ROLE = "myRole";
         
    
    // Node names of the BPEL process definition.
    public static final QName ND_PROCESS = new QName(XMLNS_BPEL20_EXECUTABLE,"process");
    public static final QName ND_EMPTY = new QName(XMLNS_BPEL20_EXECUTABLE,"empty");
    public static final QName ND_INVOKE = new QName(XMLNS_BPEL20_EXECUTABLE,"invoke");
    public static final QName ND_RECEIVE = new QName(XMLNS_BPEL20_EXECUTABLE,"receive");
    public static final QName ND_REPLY = new QName(XMLNS_BPEL20_EXECUTABLE,"reply");
    public static final QName ND_ASSIGN = new QName(XMLNS_BPEL20_EXECUTABLE,"assign");
    public static final QName ND_WAIT = new QName(XMLNS_BPEL20_EXECUTABLE,"wait");
    public static final QName ND_THROW = new QName(XMLNS_BPEL20_EXECUTABLE,"throw");
    public static final QName ND_FLOW = new QName(XMLNS_BPEL20_EXECUTABLE,"flow");
    public static final QName ND_WHILE = new QName(XMLNS_BPEL20_EXECUTABLE,"while");
    public static final QName ND_REPEAT_UNTIL = new QName(XMLNS_BPEL20_EXECUTABLE,"repeatUntil");
    public static final QName ND_SEQUENCE = new QName(XMLNS_BPEL20_EXECUTABLE,"sequence");
    public static final QName ND_PICK = new QName(XMLNS_BPEL20_EXECUTABLE,"pick");
    public static final QName ND_SCOPE = new QName(XMLNS_BPEL20_EXECUTABLE,"scope");
    public static final QName ND_PARTNER_LINKS = new QName(XMLNS_BPEL20_EXECUTABLE,"partnerLinks");
    public static final QName ND_PARTNER_LINK = new QName(XMLNS_BPEL20_EXECUTABLE,"partnerLink");
    public static final QName ND_EVENT_HANDLERS = new QName(XMLNS_BPEL20_EXECUTABLE,"eventHandlers");
    public static final QName ND_FAULT_HANDLERS = new QName(XMLNS_BPEL20_EXECUTABLE,"faultHandlers");
    public static final QName ND_CATCH = new QName(XMLNS_BPEL20_EXECUTABLE,"catch");
    public static final QName ND_CATCH_ALL = new QName(XMLNS_BPEL20_EXECUTABLE,"catchAll");
    public static final QName ND_ON_MESSAGE = new QName(XMLNS_BPEL20_EXECUTABLE,"onMessage");
    public static final QName ND_ON_ALARM = new QName(XMLNS_BPEL20_EXECUTABLE,"onAlarm");
    public static final QName ND_ON_EVENT = new QName(XMLNS_BPEL20_EXECUTABLE,"onEvent");
    public static final QName ND_VARIABLES = new QName(XMLNS_BPEL20_EXECUTABLE,"variables");
    public static final QName ND_VARIABLE = new QName(XMLNS_BPEL20_EXECUTABLE,"variable");
    public static final QName ND_CORRELATION_SETS = new QName(XMLNS_BPEL20_EXECUTABLE,"correlationSets");
    public static final QName ND_CORRELATION_SET = new QName(XMLNS_BPEL20_EXECUTABLE,"correlationSet");
    public static final QName ND_SOURCE = new QName(XMLNS_BPEL20_EXECUTABLE,"source");
    public static final QName ND_SOURCES = new QName(XMLNS_BPEL20_EXECUTABLE,"sources");
    public static final QName ND_TARGET = new QName(XMLNS_BPEL20_EXECUTABLE,"target");
    public static final QName ND_TARGETS = new QName(XMLNS_BPEL20_EXECUTABLE,"targets");
    public static final QName ND_JOIN_CONDITION = new QName(XMLNS_BPEL20_EXECUTABLE,"joinCondition");
    public static final QName ND_TRANSITION_CONDITION = new QName(XMLNS_BPEL20_EXECUTABLE,"transitionCondition");
    public static final QName ND_COPY = new QName(XMLNS_BPEL20_EXECUTABLE,"copy");
    public static final QName ND_FROM = new QName(XMLNS_BPEL20_EXECUTABLE,"from");
    public static final QName ND_TO = new QName(XMLNS_BPEL20_EXECUTABLE,"to");
    public static final QName ND_LINKS = new QName(XMLNS_BPEL20_EXECUTABLE,"links");
    public static final QName ND_LINK = new QName(XMLNS_BPEL20_EXECUTABLE,"link");        
    public static final QName ND_IF = new QName(XMLNS_BPEL20_EXECUTABLE,"if");
    public static final QName ND_ELSEIF = new QName(XMLNS_BPEL20_EXECUTABLE,"elseif");
    public static final QName ND_ELSE = new QName(XMLNS_BPEL20_EXECUTABLE,"else");
    public static final QName ND_IMPORT = new QName(XMLNS_BPEL20_EXECUTABLE,"import");
    public static final QName ND_FROM_PART = new QName(XMLNS_BPEL20_EXECUTABLE,"fromPart");
    public static final QName ND_FROM_PARTS = new QName(XMLNS_BPEL20_EXECUTABLE,"fromParts");
    public static final QName ND_TO_PART = new QName(XMLNS_BPEL20_EXECUTABLE,"toPart");
    public static final QName ND_TO_PARTS = new QName(XMLNS_BPEL20_EXECUTABLE,"toParts");
    public static final QName ND_LITERAL = new QName(XMLNS_BPEL20_EXECUTABLE,"literal");
    public static final QName ND_QUERY = new QName(XMLNS_BPEL20_EXECUTABLE,"query");
    public static final QName ND_CONDITION = new QName(XMLNS_BPEL20_EXECUTABLE,"condition");
    public static final QName ND_UNTIL = new QName(XMLNS_BPEL20_EXECUTABLE,"until");
    public static final QName ND_FOR = new QName(XMLNS_BPEL20_EXECUTABLE,"for");
    
    public static final QName ND_FOR_EACH = new QName(XMLNS_BPEL20_EXECUTABLE,"forEach");
    public static final QName ND_START_COUNTER_VALUE = new QName(XMLNS_BPEL20_EXECUTABLE,"startCounterValue");
    public static final QName ND_FINAL_COUNTER_VALUE = new QName(XMLNS_BPEL20_EXECUTABLE,"finalCounterValue");
    public static final QName ND_COMPLETION_CONDITION = new QName(XMLNS_BPEL20_EXECUTABLE,"completionCondition");
    public static final QName ND_BRANCHES = new QName(XMLNS_BPEL20_EXECUTABLE,"branches");
    public static final QName ND_EXIT = new QName(XMLNS_BPEL20_EXECUTABLE,"exit");
    public static final QName ND_COMPENSATE_SCOPE = new QName(XMLNS_BPEL20_EXECUTABLE,"compensateScope");
    public static final QName ND_VALIDATE = new QName(XMLNS_BPEL20_EXECUTABLE,"validate");
    public static final QName ND_EXTENSION_ACTIVITY = new QName(XMLNS_BPEL20_EXECUTABLE,"extensionActivity");
    
    public static final QName ND_EXTENSION_ASSIGN_OPERATION = new QName(XMLNS_BPEL20_EXECUTABLE,"extensionAssignOperation");
    public static final QName ND_Snippet = new QName(XMLNS_ODE_E4X,"snippet");
    
    public static final QName ND_CORRELATIONS = new QName(XMLNS_BPEL20_EXECUTABLE,"correlations");
    public static final QName ND_CORRELATION = new QName(XMLNS_BPEL20_EXECUTABLE,"correlation");
    public static final QName ND_COMPENSATE = new QName(XMLNS_BPEL20_EXECUTABLE,"compensate");
    public static final QName ND_COMPENSATION_HANDLER = new QName(XMLNS_BPEL20_EXECUTABLE,"compensationHandler");
    public static final QName ND_RETHROW = new QName(XMLNS_BPEL20_EXECUTABLE,"rethrow");
    public static final QName ND_TERMINATION_HANDLER = new QName(XMLNS_BPEL20_EXECUTABLE,"terminationHandler");
    public static final QName ND_REPEAT_EVERY = new QName(XMLNS_BPEL20_EXECUTABLE,"repeatEvery");
    
    public static final QName ND_MESSAGE_EXCHANGES = new QName(XMLNS_BPEL20_EXECUTABLE,"messageExchanges");
    public static final QName ND_MESSAGE_EXCHANGE = new QName(XMLNS_BPEL20_EXECUTABLE,"messageExchange");
    
    public static final QName ND_EXTENSION = new QName(XMLNS_BPEL20_EXECUTABLE,"extension");
    public static final QName ND_EXTENSIONS = new QName(XMLNS_BPEL20_EXECUTABLE,"extensions");
    
    
  
    // BPEL Attribute node names. Note that these do not use the namespace component of QName
    
    public static final QName AT_NAME = new QName("name");
    public static final QName AT_TARGET_NAMESPACE = new QName("targetNamespace");    
    public static final QName AT_ISOLATED = new QName("isolated");
    public static final QName AT_QUERYLANGUAGE = new QName("queryLanguage");
    public static final QName AT_EXPRESSIONLANGUAGE = new QName("expressionLanguage");
    public static final QName AT_EXIT_ON_STANDARD_FAULT = new QName("exitOnStandardFault");    
    public static final QName AT_SUPPRESS_JOIN_FAILURE = new QName("suppressJoinFailure");
    public static final QName AT_JOIN_CONDITION = new QName("joinCondition");
    public static final QName AT_VARIABLE_ACCESS_SERIALIZABLE = new QName("variableAccessSerializable");
    public static final QName AT_ENABLE_INSTANCE_COMPENSATION = new QName("enableInstanceCompensation");
    public static final QName AT_ABSTRACT_PROCESSES = new QName("abstractProcess");
    public static final QName AT_PARTNER_LINK_TYPE = new QName("partnerLinkType");
    public static final QName AT_FAULT_NAME = new QName("faultName");
    public static final QName AT_FAULT_VARIABLE = new QName("faultVariable");
    public static final QName AT_PARTNER = new QName("partner");
    public static final QName AT_PARTNER_LINK = new QName("partnerLink");
    public static final QName AT_PORT_TYPE = new QName("portType");
    public static final QName AT_OPERATION = new QName("operation");
    public static final QName AT_VARIABLE = new QName("variable");
    public static final QName AT_FOR = new QName("for");
    public static final QName AT_UNTIL = new QName("until");
    public static final QName AT_MESSAGE_TYPE = new QName("messageType");
    public static final QName AT_TYPE = new QName("type");
    public static final QName AT_ELEMENT = new QName("element");
    public static final QName AT_PROPERTIES = new QName("properties");
    public static final QName AT_LINK_NAME = new QName("linkName");
    public static final QName AT_TRANSITION_CONDITION = new QName("transitionCondition");
    public static final QName AT_INPUT_VARIABLE = new QName("inputVariable");
    public static final QName AT_OUTPUT_VARIABLE = new QName("outputVariable");
    public static final QName AT_CREATE_INSTANCE = new QName("createInstance");
    public static final QName AT_PART = new QName("part");
    // fix  Bug 323945
    public static final QName AT_HEADER = new QName("header");
    public static final QName AT_QUERY = new QName("query");
    public static final QName AT_OPAQUE = new QName("opaque");
    public static final QName AT_PROPERTY = new QName("property");
    public static final QName AT_EXPRESSION = new QName("expression");
    public static final QName AT_CONDITION = new QName("condition");
    public static final QName AT_MY_ROLE = new QName("myRole");
    public static final QName AT_PARTNER_ROLE = new QName("partnerRole");
    public static final QName AT_SET = new QName("set");
    public static final QName AT_INITIATE = new QName("initiate");
    public static final QName AT_PATTERN = new QName("pattern");
    public static final QName AT_LANGUAGE = new QName("language");
    public static final QName AT_VERSION = new QName("version");
    public static final QName AT_IMPORT = new QName("import");
    public static final QName AT_IMPORT_TYPE = new QName("importType");
    public static final QName AT_LOCATION = new QName("location");
    public static final QName AT_NAMESPACE = new QName("namespace");
    public static final QName AT_ENDPOINT_REFERENCE = new QName("endpointReference");
    public static final QName AT_SCOPE = new QName("scope");
    public static final QName AT_LABEL = new QName("label");
    public static final QName AT_LABEL_STATUS = new QName("status");
    public static final QName AT_TIMEOUT = new QName("timeout");
    public static final QName AT_SUPPRESS_COORD_FAILURE = new QName("suppressCoordinationFailure");
    public static final QName AT_FROM = new QName("from");
    public static final QName AT_TO = new QName("to");
    public static final QName AT_VARIABLES = new QName("variables");
    public static final QName AT_TARGET = new QName("target");
    public static final QName AT_TO_VARIABLE = new QName("toVariable");
    public static final QName AT_FROM_VARIABLE = new QName("fromVariable");
    public static final QName AT_INITIALIZE_PARTNER_ROLE = new QName("initializePartnerRole");
    public static final QName AT_VALIDATE = new QName("validate");
    public static final QName AT_KEEP_SRC_ELEMENT_NAME = new QName("keepSrcElementName");
    public static final QName AT_ACTIVITY = new QName("activity");
    public static final QName AT_ACTIVITIES = new QName("activities");
    public static final QName AT_LINKS = new QName("links");
    public static final QName AT_SUCCESSFUL_BRANCHES_ONLY = new QName("successfulBranchesOnly" );    
    public static final QName AT_FAULT_MESSAGE_TYPE = new QName("faultMessageType");
    public static final QName AT_FAULT_ELEMENT = new QName("faultElement");
    public static final QName AT_COUNTER_NAME = new QName("counterName");
    public static final QName AT_PARALLEL = new QName("parallel");
    public static final QName AT_KEEP_SRC_ELEMENT = new QName("keepSrcElement");
    public static final QName AT_MUST_UNDERSTAND = new QName("mustUnderstand");
    
    // Some attribute values
    public static final String AT_VAL_IMPORT_XSD  = "http://www.w3.org/2001/XMLSchema";
    public static final String AT_VAL_IMPORT_WSDL = "http://schemas.xmlsoap.org/wsdl/";
        
    
    /** These are used in message.properties */
    public static final int    KIND_ATTRIBUTE= 2;
    public static final int    KIND_ACTIVITY = 1;
    public static final int    KIND_NODE     = 0;
    
    
    // WSDL nodes of interest
    public static final QName WSDL_ND_OPERATION = new QName(XMLNS_WSDL,"operation");
    public static final QName WSDL_ND_MESSAGE = new QName(XMLNS_WSDL,"message");    
    
    public static final QName WSDL_ND_INPUT = new QName(XMLNS_WSDL,"input");
    public static final QName WSDL_ND_OUTPUT = new QName(XMLNS_WSDL,"output");
    public static final QName WSDL_ND_FAULT = new QName(XMLNS_WSDL,"fault");
    
    public static final QName WSDL_ND_PORT_TYPE = new QName(XMLNS_WSDL,"portType");
    public static final QName WSDL_ND_PART = new QName(XMLNS_WSDL,"part");
          
    public static final QName WSDL_ND_DEFINITIONS = new QName(XMLNS_WSDL,"definitions");

    // WSDL attributes of interest
    public static final QName  WSDL_AT_INPUT = new QName("input");
    public static final QName  WSDL_AT_OUTPUT = new QName("output");
    public static final QName  WSDL_AT_MESSAGE = new QName("message");

    
    // Partner link extensions
    public static final QName PLNK_ND_PARTNER_LINK_TYPE = new QName(XMLNS_PLNK,"partnerLinkType");
    public static final QName PLNK_ND_ROLE = new QName(XMLNS_PLNK,"role");
    
    // Variable property extensions
    public static final QName VPROP_ND_PROPERTY = new QName(XMLNS_VPROP,"property");
    public static final QName VPROP_ND_PROPERTY_ALIAS = new QName(XMLNS_VPROP,"propertyAlias");    
    public static final QName VPROP_ND_QUERY = new QName(XMLNS_VPROP,"query");
               
    public static final QName  WSDL_AT_PROPERTY_NAME = new QName("propertyName");
    
        
    public static final String BOOLEAN_VALUES[] = { YES, NO };
    
    public static final String INITIATE_VALUES[] = { YES, JOIN, NO };
    
    public static final String ENDPOINT_VALUES [] = { MY_ROLE, PARTNER_ROLE };
    
    public static final String PATTERN_VALUES [] = { REQUEST , RESPONSE, REQUEST_RESPONSE, IN, OUT };
    
    public static final QName REPEATABLE_NODES [] = { 
    	ND_WHILE, ND_REPEAT_UNTIL, ND_FOR_EACH, ND_EVENT_HANDLERS, ND_COMPENSATION_HANDLER }; 
   
    
    public static final QName FAULT_HANDLER_BOUNDARY_NODES [] = {
    	ND_CATCH,ND_CATCH_ALL,ND_TERMINATION_HANDLER
    };
    
    /** FCT-Handlers as defined by the spec */
    public static final QName FCT_HANDLERS [] = {
    	ND_CATCH, ND_CATCH_ALL, ND_COMPENSATION_HANDLER, ND_TERMINATION_HANDLER 
    };
    
    static QName[] BPEL_ACTIVITIES = {
   		ND_RECEIVE,
		ND_REPLY,
		ND_INVOKE,
		ND_ASSIGN,
		ND_THROW,
		ND_EXIT,
		ND_WAIT,
		ND_EMPTY,
		ND_SEQUENCE,
		ND_IF,
		ND_WHILE,
		ND_REPEAT_UNTIL,
		ND_FOR_EACH,
		ND_PICK,
		ND_FLOW,
		ND_SCOPE,
		ND_COMPENSATE,
		ND_COMPENSATE_SCOPE,
		ND_RETHROW,
		ND_VALIDATE,
		ND_EXTENSION_ACTIVITY 	
		
		/*
		<receive>, <reply>, <invoke>, <assign>, <throw>, <exit>, <wait>
		<empty>, <sequence>, <if>, <while>, <repeatUntil>, <forEach>, <pick>
		<flow>, <scope>, <compensate>, <compensateScope>, <rethrow>, <validate>
		<extensionActivity>
		*/
    };
    
    
    static QName[] BPEL_ACTIVITIES_CONTAINERS = {
		ND_SEQUENCE,
		ND_IF,
		ND_ELSE,
		ND_ELSEIF,
		ND_WHILE,
		ND_REPEAT_UNTIL,
		ND_FOR_EACH,
		ND_PICK,
		ND_FLOW,
		ND_PROCESS,
		ND_SCOPE,
		ND_COMPENSATE,
		ND_COMPENSATE_SCOPE,
		ND_CATCH,
		ND_CATCH_ALL,
		ND_EXTENSION_ACTIVITY ,
		
		/** These three below can contain activities too */
		ND_ON_ALARM,
		ND_ON_EVENT,
		ND_ON_MESSAGE,
		
		/** Strangely enough these two can as well. */
		ND_TERMINATION_HANDLER,
		ND_COMPENSATION_HANDLER
		
		/*
		<receive>, <reply>, <invoke>, <assign>, <throw>, <exit>, <wait>
		<empty>, <sequence>, <if>, <while>, <repeatUntil>, <forEach>, <pick>
		<flow>, <scope>, <compensate>, <compensateScope>, <rethrow>, <validate>
		<extensionActivity>
		*/
    };
 
    static QName[] BPEL_STANDARD_FAULTS = {
    	new QName(XMLNS_BPEL,"ambiguousReceive"),
    	new QName(XMLNS_BPEL,"completionConditionFailure"),
    	new QName(XMLNS_BPEL,"conflictingReceive"),
    	new QName(XMLNS_BPEL,"conflictingRequest"),
    	new QName(XMLNS_BPEL,"correlationViolation"),
    	new QName(XMLNS_BPEL,"invalidBranchCondition"),
    	new QName(XMLNS_BPEL,"invalidExpressionValue"),
    	new QName(XMLNS_BPEL,"invalidVariables"),
    	new QName(XMLNS_BPEL,"joinFailure"),
    	new QName(XMLNS_BPEL,"mismatchedAssignmentFailure"),
    	new QName(XMLNS_BPEL,"missingReply"),
    	new QName(XMLNS_BPEL,"missingRequest"),
    	new QName(XMLNS_BPEL,"scopeInitializationFailure"),
    	new QName(XMLNS_BPEL,"selectionFailure"),
    	new QName(XMLNS_BPEL,"subLanguageExecutionFault"),
    	new QName(XMLNS_BPEL,"uninitializedPartnerRole"),
    	new QName(XMLNS_BPEL,"uninitializedVariable"),
    	new QName(XMLNS_BPEL,"unsupportedReference"),
    	new QName(XMLNS_BPEL,"xsltInvalidSource"),
    	new QName(XMLNS_BPEL,"xsltStylesheetNotFound")
    };
 	
	
}
