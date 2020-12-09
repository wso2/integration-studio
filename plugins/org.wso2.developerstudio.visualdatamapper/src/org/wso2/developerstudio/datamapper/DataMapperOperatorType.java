/**
 */
package org.wso2.developerstudio.datamapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getDataMapperOperatorType()
 * @model
 * @generated
 */
public enum DataMapperOperatorType implements Enumerator {
	/**
	 * The '<em><b>OPERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPERATOR_VALUE
	 * @generated NOT
	 * @ordered
	 */
	OPERATOR(0, "OPERATOR", "OPERATOR"),

	/**
	 * The '<em><b>COMMON OPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMON_OPERATION_VALUE
	 * @generated NOT
	 * @ordered
	 */
	COMMON_OPERATION(1, "COMMON_OPERATION", "COMMON_OPERATION",OPERATOR),

	/**
	 * The '<em><b>DIRECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECT_VALUE
	 * @generated NOT
	 * @ordered
	 */
	DIRECT(21, "DIRECT", "DIRECT",COMMON_OPERATION),

	/**
	 * The '<em><b>STRING OPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_OPERATION_VALUE
	 * @generated NOT
	 * @ordered
	 */
	STRING_OPERATION(2, "STRING_OPERATION", "STRING_OPERATION",OPERATOR),

	/**
	 * The '<em><b>ARITHMATIC OPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARITHMATIC_OPERATION_VALUE
	 * @generated NOT
	 * @ordered
	 */
	ARITHMATIC_OPERATION(2, "ARITHMATIC_OPERATION", "ARITHMATIC_OPERATION",OPERATOR),

	/**
	 * The '<em><b>BOOLEAN OPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_OPERATION_VALUE
	 * @generated NOT
	 * @ordered
	 */
	BOOLEAN_OPERATION(3, "BOOLEAN_OPERATION", "BOOLEAN_OPERATION",OPERATOR),

	/**
	 * The '<em><b>CONDITIONAL OPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONDITIONAL_OPERATION_VALUE
	 * @generated NOT
	 * @ordered
	 */
	CONDITIONAL_OPERATION(4, "CONDITIONAL_OPERATION", "CONDITIONAL_OPERATION",OPERATOR),

	/**
	 * The '<em><b>CONSTANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_VALUE
	 * @generated NOT
	 * @ordered
	 */
	CONSTANT(5, "CONSTANT", "CONSTANT",COMMON_OPERATION),

	/**
	 * The '<em><b>EQUALS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUALS_VALUE
	 * @generated
	 * @ordered
	 */
	EQUALS(6, "EQUALS", "EQUALS"), /**
	 * The '<em><b>CONCAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONCAT_VALUE
	 * @generated NOT
	 * @ordered
	 */
	CONCAT(7, "CONCAT", "CONCAT",STRING_OPERATION),

	/**
	 * The '<em><b>SPLIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPLIT_VALUE
	 * @generated NOT
	 * @ordered
	 */
	SPLIT(8, "SPLIT", "SPLIT",STRING_OPERATION),

	/**
	 * The '<em><b>UPPERCASE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPPERCASE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	UPPERCASE(9, "UPPERCASE", "UPPERCASE",STRING_OPERATION),

	/**
	 * The '<em><b>LOWERCASE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWERCASE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	LOWERCASE(10, "LOWERCASE", "LOWERCASE",STRING_OPERATION),

	/**
	 * The '<em><b>CONTAINS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAINS_VALUE
	 * @generated
	 * @ordered
	 */
	CONTAINS(11, "CONTAINS", "CONTAINS"), /**
	 * The '<em><b>ADD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_VALUE
	 * @generated NOT
	 * @ordered
	 */
	ADD(12, "ADD", "ADD",ARITHMATIC_OPERATION),

	/**
	 * The '<em><b>SUBTRACT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBTRACT_VALUE
	 * @generated NOT
	 * @ordered
	 */
	SUBTRACT(13, "SUBTRACT", "SUBTRACT",ARITHMATIC_OPERATION),

	/**
	 * The '<em><b>MULTIPLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTIPLY_VALUE
	 * @generated NOT
	 * @ordered
	 */
	MULTIPLY(14, "MULTIPLY", "MULTIPLY",ARITHMATIC_OPERATION),

	/**
	 * The '<em><b>DIVIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVIDE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	DIVIDE(15, "DIVIDE", "DIVIDE",ARITHMATIC_OPERATION),

	/**
	 * The '<em><b>ABSOLUTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	ABSOLUTE(16, "ABSOLUTE", "ABSOLUTE",ARITHMATIC_OPERATION),

	/**
	 * The '<em><b>ROUND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUND_VALUE
	 * @generated NOT
	 * @ordered
	 */
	ROUND(17, "ROUND", "ROUND",ARITHMATIC_OPERATION),

	/**
	 * The '<em><b>FLOOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOOR_VALUE
	 * @generated NOT
	 * @ordered
	 */
	FLOOR(18, "FLOOR", "FLOOR",ARITHMATIC_OPERATION),

	/**
	 * The '<em><b>CEILING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CEILING_VALUE
	 * @generated NOT
	 * @ordered
	 */
	CEILING(19, "CEILING", "CEILING",ARITHMATIC_OPERATION),

	/**
	 * The '<em><b>SET PRECISION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_PRECISION_VALUE
	 * @generated NOT
	 * @ordered
	 */
	SET_PRECISION(20, "SET_PRECISION", "SET_PRECISION",ARITHMATIC_OPERATION), /**
	 * The '<em><b>AND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AND_VALUE
	 * @generated NOT
	 * @ordered
	 */
	AND(21, "AND", "AND",BOOLEAN_OPERATION), /**
	 * The '<em><b>OR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OR_VALUE
	 * @generated NOT
	 * @ordered
	 */
	OR(22, "OR", "OR",BOOLEAN_OPERATION), /**
	 * The '<em><b>NOT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_VALUE
	 * @generated NOT
	 * @ordered
	 */
	NOT(23, "NOT", "NOT",BOOLEAN_OPERATION), /**
	 * The '<em><b>ENDS WITH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENDS_WITH_VALUE
	 * @generated NOT
	 * @ordered
	 */
	ENDS_WITH(24, "ENDS_WITH", "ENDS_WITH",STRING_OPERATION), /**
	 * The '<em><b>IF ELSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IF_ELSE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	IF_ELSE(25, "IF_ELSE", "IF_ELSE",CONDITIONAL_OPERATION), /**
	 * The '<em><b>STARTS WITH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STARTS_WITH_VALUE
	 * @generated NOT
	 * @ordered
	 */
	STARTS_WITH(26, "STARTS_WITH", "STARTS_WITH",STRING_OPERATION), /**
	 * The '<em><b>STRING LENGTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_LENGTH_VALUE
	 * @generated NOT
	 * @ordered
	 */
	STRING_LENGTH(27, "STRING_LENGTH", "STRING_LENGTH",STRING_OPERATION), /**
	 * The '<em><b>SUBSTRING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRING_VALUE
	 * @generated NOT
	 * @ordered
	 */
	SUBSTRING(28, "SUBSTRING", "SUBSTRING",STRING_OPERATION), /**
	 * The '<em><b>COMPARE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPARE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	COMPARE(29, "COMPARE", "COMPARE",COMMON_OPERATION), /**
	 * The '<em><b>CUSTOM FUNCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_FUNCTION_VALUE
	 * @generated NOT
	 * @ordered
	 */
	CUSTOM_FUNCTION(30, "CUSTOM_FUNCTION", "CUSTOM_FUNCTION",COMMON_OPERATION), /**
	 * The '<em><b>MATCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCH_VALUE
	 * @generated NOT
	 * @ordered
	 */
	MATCH(31, "MATCH", "MATCH",STRING_OPERATION), /**
	 * The '<em><b>MAX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_VALUE
	 * @generated NOT
	 * @ordered
	 */
	MAX(32, "MAX", "MAX",ARITHMATIC_OPERATION), /**
	 * The '<em><b>MIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIN_VALUE
	 * @generated NOT
	 * @ordered
	 */
	MIN(33, "MIN", "MIN",ARITHMATIC_OPERATION), /**
	 * The '<em><b>PROPERTIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROPERTIES_VALUE
	 * @generated NOT
	 * @ordered
	 */
	PROPERTIES(34, "PROPERTIES", "PROPERTIES",COMMON_OPERATION), /**
	 * The '<em><b>REPLACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPLACE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	REPLACE(35, "REPLACE", "REPLACE",STRING_OPERATION), /**
	 * The '<em><b>TRIM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIM_VALUE
	 * @generated NOT
	 * @ordered NOT
	 */
	TRIM(38, "TRIM", "TRIM",STRING_OPERATION), /**
	 * The '<em><b>TYPE CONVERSION OPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE_CONVERSION_OPERATION_VALUE
	 * @generated NOT
	 * @ordered NOT
	 */
	TYPE_CONVERSION_OPERATION(39, "TYPE_CONVERSION_OPERATION", "TYPE_CONVERSION_OPERATION",OPERATOR), /**
	 * The '<em><b>STRING TO BOOLEAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_TO_BOOLEAN_VALUE
	 * @generated NOT
	 * @ordered
	 */
	STRING_TO_BOOLEAN(36, "STRING_TO_BOOLEAN", "STRING_TO_BOOLEAN",TYPE_CONVERSION_OPERATION), /**
	 * The '<em><b>STRING TO NUMBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_TO_NUMBER_VALUE
	 * @generated NOT
	 * @ordered NOT
	 */
	STRING_TO_NUMBER(37, "STRING_TO_NUMBER", "STRING_TO_NUMBER",TYPE_CONVERSION_OPERATION), /**
	 * The '<em><b>INSTANTIATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANTIATE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	INSTANTIATE(40, "INSTANTIATE", "INSTANTIATE",COMMON_OPERATION), /**
	 * The '<em><b>GET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_VALUE
	 * @generated NOT
	 * @ordered
	 */
	GET(41, "GET", "GET",COMMON_OPERATION), /**
	 * The '<em><b>TO STRING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TO_STRING_VALUE
	 * @generated NOT
	 * @ordered
	 */
	TO_STRING(42, "TO_STRING", "TO_STRING",TYPE_CONVERSION_OPERATION), /**
	 * The '<em><b>GLOBAL VARIABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GLOBAL_VARIABLE_VALUE
	 * @generated NOT
	 * @ordered
	 */
	GLOBAL_VARIABLE(43, "GLOBAL_VARIABLE", "GLOBAL_VARIABLE",COMMON_OPERATION), /**
	 * The '<em><b>ADVANCED CUSTOM FUNCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADVANCED_CUSTOM_FUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	ADVANCED_CUSTOM_FUNCTION(44, "ADVANCED_CUSTOM_FUNCTION", "ADVANCED_CUSTOM_FUNCTION");

	/**
	 * The '<em><b>OPERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OPERATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPERATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPERATOR_VALUE = 0;

	/**
	 * The '<em><b>COMMON OPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMMON OPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMON_OPERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMMON_OPERATION_VALUE = 1;

	/**
	 * The '<em><b>DIRECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECT_VALUE = 21;

	/**
	 * The '<em><b>STRING OPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRING OPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_OPERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRING_OPERATION_VALUE = 2;

	/**
	 * The '<em><b>ARITHMATIC OPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARITHMATIC OPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARITHMATIC_OPERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARITHMATIC_OPERATION_VALUE = 2;

	/**
	 * The '<em><b>BOOLEAN OPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOOLEAN OPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_OPERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_OPERATION_VALUE = 3;

	/**
	 * The '<em><b>CONDITIONAL OPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONDITIONAL OPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONDITIONAL_OPERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONDITIONAL_OPERATION_VALUE = 4;

	/**
	 * The '<em><b>CONSTANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSTANT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTANT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSTANT_VALUE = 5;

	/**
	 * The '<em><b>EQUALS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUALS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUALS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUALS_VALUE = 6;

	/**
	 * The '<em><b>CONCAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONCAT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONCAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONCAT_VALUE = 7;

	/**
	 * The '<em><b>SPLIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPLIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPLIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPLIT_VALUE = 8;

	/**
	 * The '<em><b>UPPERCASE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UPPERCASE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPPERCASE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UPPERCASE_VALUE = 9;

	/**
	 * The '<em><b>LOWERCASE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWERCASE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWERCASE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWERCASE_VALUE = 10;

	/**
	 * The '<em><b>CONTAINS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTAINS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTAINS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINS_VALUE = 11;

	/**
	 * The '<em><b>ADD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADD_VALUE = 12;

	/**
	 * The '<em><b>SUBTRACT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBTRACT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBTRACT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBTRACT_VALUE = 13;

	/**
	 * The '<em><b>MULTIPLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MULTIPLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MULTIPLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLY_VALUE = 14;

	/**
	 * The '<em><b>DIVIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIVIDE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIVIDE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIVIDE_VALUE = 15;

	/**
	 * The '<em><b>ABSOLUTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ABSOLUTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ABSOLUTE_VALUE = 16;

	/**
	 * The '<em><b>ROUND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROUND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROUND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROUND_VALUE = 17;

	/**
	 * The '<em><b>FLOOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOOR_VALUE = 18;

	/**
	 * The '<em><b>CEILING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CEILING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CEILING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CEILING_VALUE = 19;

	/**
	 * The '<em><b>SET PRECISION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SET PRECISION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET_PRECISION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_PRECISION_VALUE = 20;

	/**
	 * The '<em><b>AND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AND_VALUE = 21;

	/**
	 * The '<em><b>OR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OR_VALUE = 22;

	/**
	 * The '<em><b>NOT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_VALUE = 23;

	/**
	 * The '<em><b>ENDS WITH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENDS WITH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENDS_WITH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENDS_WITH_VALUE = 24;

	/**
	 * The '<em><b>IF ELSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IF ELSE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IF_ELSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IF_ELSE_VALUE = 25;

	/**
	 * The '<em><b>STARTS WITH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STARTS WITH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STARTS_WITH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STARTS_WITH_VALUE = 26;

	/**
	 * The '<em><b>STRING LENGTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRING LENGTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_LENGTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRING_LENGTH_VALUE = 27;

	/**
	 * The '<em><b>SUBSTRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBSTRING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBSTRING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBSTRING_VALUE = 28;

	/**
	 * The '<em><b>COMPARE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPARE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPARE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPARE_VALUE = 29;

	/**
	 * The '<em><b>CUSTOM FUNCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CUSTOM FUNCTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_FUNCTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM_FUNCTION_VALUE = 30;

	/**
	 * The '<em><b>MATCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MATCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MATCH_VALUE = 31;

	/**
	 * The '<em><b>MAX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAX_VALUE = 32;

	/**
	 * The '<em><b>MIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MIN_VALUE = 33;

	/**
	 * The '<em><b>PROPERTIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROPERTIES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROPERTIES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTIES_VALUE = 34;

	/**
	 * The '<em><b>REPLACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REPLACE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPLACE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REPLACE_VALUE = 35;

	/**
	 * The '<em><b>TRIM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIM_VALUE = 38;

	/**
	 * The '<em><b>TYPE CONVERSION OPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TYPE CONVERSION OPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TYPE_CONVERSION_OPERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_CONVERSION_OPERATION_VALUE = 39;

	/**
	 * The '<em><b>STRING TO BOOLEAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRING TO BOOLEAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_TO_BOOLEAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRING_TO_BOOLEAN_VALUE = 36;

	/**
	 * The '<em><b>STRING TO NUMBER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRING TO NUMBER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_TO_NUMBER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRING_TO_NUMBER_VALUE = 37;

	/**
	 * The '<em><b>INSTANTIATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSTANTIATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANTIATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INSTANTIATE_VALUE = 40;

	/**
	 * The '<em><b>GET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GET_VALUE = 41;

	/**
	 * The '<em><b>TO STRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TO STRING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TO_STRING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TO_STRING_VALUE = 42;

	/**
	 * The '<em><b>GLOBAL VARIABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GLOBAL VARIABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GLOBAL_VARIABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GLOBAL_VARIABLE_VALUE = 43;

	/**
	 * The '<em><b>ADVANCED CUSTOM FUNCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADVANCED CUSTOM FUNCTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADVANCED_CUSTOM_FUNCTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADVANCED_CUSTOM_FUNCTION_VALUE = 44;

	/**
	 * An array of all the '<em><b>Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DataMapperOperatorType[] VALUES_ARRAY =
		new DataMapperOperatorType[] {
			OPERATOR,
			COMMON_OPERATION,
			DIRECT,
			STRING_OPERATION,
			ARITHMATIC_OPERATION,
			BOOLEAN_OPERATION,
			CONDITIONAL_OPERATION,
			CONSTANT,
			EQUALS,
			CONCAT,
			SPLIT,
			UPPERCASE,
			LOWERCASE,
			CONTAINS,
			ADD,
			SUBTRACT,
			MULTIPLY,
			DIVIDE,
			ABSOLUTE,
			ROUND,
			FLOOR,
			CEILING,
			SET_PRECISION,
			AND,
			OR,
			NOT,
			ENDS_WITH,
			IF_ELSE,
			STARTS_WITH,
			STRING_LENGTH,
			SUBSTRING,
			COMPARE,
			CUSTOM_FUNCTION,
			MATCH,
			MAX,
			MIN,
			PROPERTIES,
			REPLACE,
			TRIM,
			TYPE_CONVERSION_OPERATION,
			STRING_TO_BOOLEAN,
			STRING_TO_NUMBER,
			INSTANTIATE,
			GET,
			TO_STRING,
			GLOBAL_VARIABLE,
			ADVANCED_CUSTOM_FUNCTION,
		};

	/**
	 * A public read-only list of all the '<em><b>Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DataMapperOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataMapperOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataMapperOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataMapperOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataMapperOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataMapperOperatorType get(int value) {
		switch (value) {
			case OPERATOR_VALUE: return OPERATOR;
			case COMMON_OPERATION_VALUE: return COMMON_OPERATION;
			case DIRECT_VALUE: return DIRECT;
			case STRING_OPERATION_VALUE: return STRING_OPERATION;
			case BOOLEAN_OPERATION_VALUE: return BOOLEAN_OPERATION;
			case CONDITIONAL_OPERATION_VALUE: return CONDITIONAL_OPERATION;
			case CONSTANT_VALUE: return CONSTANT;
			case EQUALS_VALUE: return EQUALS;
			case CONCAT_VALUE: return CONCAT;
			case SPLIT_VALUE: return SPLIT;
			case UPPERCASE_VALUE: return UPPERCASE;
			case LOWERCASE_VALUE: return LOWERCASE;
			case CONTAINS_VALUE: return CONTAINS;
			case ADD_VALUE: return ADD;
			case SUBTRACT_VALUE: return SUBTRACT;
			case MULTIPLY_VALUE: return MULTIPLY;
			case DIVIDE_VALUE: return DIVIDE;
			case ABSOLUTE_VALUE: return ABSOLUTE;
			case ROUND_VALUE: return ROUND;
			case FLOOR_VALUE: return FLOOR;
			case CEILING_VALUE: return CEILING;
			case SET_PRECISION_VALUE: return SET_PRECISION;
			case OR_VALUE: return OR;
			case NOT_VALUE: return NOT;
			case ENDS_WITH_VALUE: return ENDS_WITH;
			case IF_ELSE_VALUE: return IF_ELSE;
			case STARTS_WITH_VALUE: return STARTS_WITH;
			case STRING_LENGTH_VALUE: return STRING_LENGTH;
			case SUBSTRING_VALUE: return SUBSTRING;
			case COMPARE_VALUE: return COMPARE;
			case CUSTOM_FUNCTION_VALUE: return CUSTOM_FUNCTION;
			case MATCH_VALUE: return MATCH;
			case MAX_VALUE: return MAX;
			case MIN_VALUE: return MIN;
			case PROPERTIES_VALUE: return PROPERTIES;
			case REPLACE_VALUE: return REPLACE;
			case TRIM_VALUE: return TRIM;
			case TYPE_CONVERSION_OPERATION_VALUE: return TYPE_CONVERSION_OPERATION;
			case STRING_TO_BOOLEAN_VALUE: return STRING_TO_BOOLEAN;
			case STRING_TO_NUMBER_VALUE: return STRING_TO_NUMBER;
			case INSTANTIATE_VALUE: return INSTANTIATE;
			case GET_VALUE: return GET;
			case TO_STRING_VALUE: return TO_STRING;
			case GLOBAL_VARIABLE_VALUE: return GLOBAL_VARIABLE;
			case ADVANCED_CUSTOM_FUNCTION_VALUE: return ADVANCED_CUSTOM_FUNCTION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;
	
	private final DataMapperOperatorType operatorCategory;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private DataMapperOperatorType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
		this.operatorCategory = null;
	}
	
	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private DataMapperOperatorType(int value, String name, String literal,DataMapperOperatorType operatorCategory) {
		this.value = value;
		this.name = name;
		this.literal = literal;
		this.operatorCategory = operatorCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

	public DataMapperOperatorType getOperatorCategory() {
		return operatorCategory;
	}
	
} //DataMapperOperatorType
