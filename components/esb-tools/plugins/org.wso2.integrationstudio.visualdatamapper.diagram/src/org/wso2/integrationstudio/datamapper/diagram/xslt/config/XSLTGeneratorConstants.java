/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.datamapper.diagram.xslt.config;

public final class XSLTGeneratorConstants {

    private XSLTGeneratorConstants() {
    }

    /* node types in the .datamapper file
     
       object type nodes : contain child nodes
       array type nodes : contain array of child nodes
       string type nodes : contain only a string value in it
       number type nodes : contain only a number value in it
       boolean type nodes : contain only a boolean value in it
       
    */
    public static final String OBJECT_TYPE = "object";
    public static final String ARRAY_TYPE = "array";
    public static final String STRING_TYPE = "string";
    public static final String NUMBER_TYPE = "number";
    public static final String BOOLEAN_TYPE = "boolean";
    
    // node names in the .datamapper file
    public static final String TYPE = "type";
    public static final String ITEMS_TYPE = "items_type";
    public static final String INPUT = "input";
    public static final String OUTPUT = "output";
    public static final String TREE_NODE = "treeNode";
    public static final String OPERATOR_TYPE = "operatorType";
    public static final String NAMESPACE = "namespaces";

    // arithmetic operators
    public static final String ADD = "ADD";
    public static final String SUBTRACT = "SUBTRACT";
    public static final String DIVIDE = "DIVIDE";
    public static final String MULTIPLY = "MULTIPLY";
    public static final String CEILING = "CEILING";
    public static final String FLOOR = "FLOOR";
    public static final String ROUND = "ROUND";
    public static final String SET_PRECISION = "SET_PRECISION";
    public static final String ABSOLUTE = "ABSOLUTE";
    public static final String MIN = "MIN";
    public static final String MAX = "MAX";

    // common operators
    public static final String CONSTANT = "CONSTANT";
    public static final String GLOBAL_VARIABLE = "GLOBAL_VARIABLE";
    public static final String PROPERTIES_OPERATOR = "PROPERTIES";
    public static final String COMPARE = "COMPARE";

    // conditional operators
    public static final String IF_ELSE = "IF_ELSE";

    // string operators
    public static final String CONCAT = "CONCAT";
    public static final String LOWERCASE = "LOWERCASE";
    public static final String UPPERCASE = "UPPERCASE";
    public static final String STRING_LENGTH = "STRING_LENGTH";
    public static final String SPLIT = "SPLIT";
    public static final String STARTS_WITH = "STARTS_WITH";
    public static final String ENDS_WITH = "ENDS_WITH";
    public static final String SUBSTRING = "SUBSTRING";
    public static final String REPLACE = "REPLACE";
    public static final String MATCH = "MATCH";
    public static final String TRIM = "TRIM";

    // type_conversion operators
    public static final String TO_STRING = "TO_STRING";
    public static final String STRING_TO_NUMBER = "STRING_TO_NUMBER";
    public static final String STRING_TO_BOOLEAN = "STRING_TO_BOOLEAN";

    // boolean operators
    public static final String NOT = "NOT";
    public static final String AND = "AND";
    public static final String OR = "OR";

    // XML attributes
    public static final String NAME = "name";
    public static final String SELECT = "select";
    public static final String TEST = "test";

    // xsl tag names
    public static final String XSL_VALUE_OF = "xsl:value-of";
    public static final String XSL_PARAM = "xsl:param";
    public static final String XSL_IF = "xsl:if";
    public static final String XSL_VARIABLE = "xsl:variable";
    public static final String XSL_FOR_EACH = "xsl:for-each";
    public static final String XSL_TEMPLATE = "xsl:template";
    public static final String XSL_ATTRIBUTE = "xsl:attribute";

    // node types
    public static final String AT_NODE = "/@node";
    public static final String AT_OPERATORS = "//@operators";
    public static final String ATTRIBUTES_INITIALS = "@";

    public static final String INCOMING_LINK = "incomingLink";
    public static final String OUT_NODE = "outNode";
    public static final String IN_NODE = "inNode";
    public static final String LEVEL = "level";
    public static final String PROPERTIES = "properties";
    public static final String KEY = "key";
    public static final String NODE = "node";
    public static final String VALUE = "value";
    public static final String LEFT_CONNECTORS = "leftConnectors";
    public static final String LEFT_CONTAINER = "leftContainer";
    public static final String BASIC_CONTAINER = "basicContainer";
    public static final String DELIMITER = "delimiter";

    public static final String XMLNS_XSL = "xmlns:xsl";
    public static final String XMLNS_XS = "xmlns:xs";
    public static final String VERSION = "version";
    public static final String XMLNS_OWN = "xmlns:own";
    public static final String XSL_STYLESHEET = "xsl:stylesheet";
    public static final String MATCH_LOWER_CASE = "match";
    public static final String XSL_FUNCTION = "xsl:function";
    public static final String OWN_SET_PRECISION = "own:setPrecision";
    public static final String RESULT_STRING = "resultString";
    public static final String EMPTY_STRING = "";
    public static final String DOT_SYMBOL = "\\.";
    public static final String SLASH = "/";
    public static final String SCOPE = "scope";
    public static final String DEFAULT_SCOPE = "DEFAULT";
    public static final String DEFAULT_VALUE = "defaultValue";
    public static final String DEFAULT_NAME = "defaultName";
    public static final String CUSTOM_FUNCTION = "CUSTOM_FUNCTION";
    public static final String FUNCTION_DEFINITION = "functionDefinition";
    public static final String XSL_NAMESPACE_URI = "http://www.w3.org/1999/XSL/Transform";
    public static final String XS_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema";
    public static final String XSLT_VERSION = "2.0";
    public static final String XSLT_FUNCTION_DECLARE_URI = "http://ownfunction.org";
    public static final String RUN_TIME_PROPERTIES = "xmlns:runTimeProperties";
    public static final String NOT_XSLT_COMPATIBLE = "xmlns:notXSLTCompatible";
    public static final String INPUT_FIRST_ELEMENT = "xmlns:firstElementOfTheInput";
    public static final String NOT_XSLT_COMPATIBLE_DEFAULT = "true";
    public static final String XSLT_COMPATIBLE_DEFAULT = "false";
    public static final String EXTENSION_ELEMENT_PREFIXES = "extension-element-prefixes";
    public static final String EXTENSION_ELEMENT_PREFIXES_VALUES = "xs own runTimeProperties notXSLTCompatible firstElementOfTheInput";
    public static final String EXTENSION_ELEMENT_PREFIXES_VALUES_WITHOUT_PROPERTY = "xs own notXSLTCompatible firstElementOfTheInput";
    public static final String NAMESPACE_ELEMENT_XPATH = "//properties[@key=\"namespaces\"]";
    public static final String NAMESPACE_GENERAL_PREFIX = "xmlns:";
    public static final String NAMESPACE_ATTRIBUTE_VALUE = "value";

    public static final String APOSTROPHE = "'";
    public static final String COMMA = ",";
}