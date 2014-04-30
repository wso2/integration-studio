/**
 */
package org.wso2.developerstudio.datamapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Schema Data Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSchemaDataType()
 * @model
 * @generated
 */
public enum SchemaDataType implements Enumerator {
    /**
	 * The '<em><b>ARRAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #ARRAY_VALUE
	 * @generated
	 * @ordered
	 */
    ARRAY(0, "ARRAY", "ARRAY"),

    /**
	 * The '<em><b>BOOLEAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #BOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
    BOOLEAN(1, "BOOLEAN", "BOOLEAN"),

    /**
	 * The '<em><b>BYTES</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #BYTES_VALUE
	 * @generated
	 * @ordered
	 */
    BYTES(2, "BYTES", "BYTES"),

    /**
	 * The '<em><b>DOUBLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
    DOUBLE(3, "DOUBLE", "DOUBLE"),

    /**
	 * The '<em><b>ENUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #ENUM_VALUE
	 * @generated
	 * @ordered
	 */
    ENUM(4, "ENUM", "ENUM"),

    /**
	 * The '<em><b>FIXED</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FIXED_VALUE
	 * @generated
	 * @ordered
	 */
    FIXED(5, "FIXED", "FIXED"),

    /**
	 * The '<em><b>FLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #FLOAT_VALUE
	 * @generated
	 * @ordered
	 */
    FLOAT(6, "FLOAT", "FLOAT"),

    /**
	 * The '<em><b>INT</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #INT_VALUE
	 * @generated
	 * @ordered
	 */
    INT(7, "INT", "INT"),

    /**
	 * The '<em><b>LONG</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #LONG_VALUE
	 * @generated
	 * @ordered
	 */
    LONG(8, "LONG", "LONG"),

    /**
	 * The '<em><b>MAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #MAP_VALUE
	 * @generated
	 * @ordered
	 */
    MAP(9, "MAP", "MAP"),

    /**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #NULL_VALUE
	 * @generated
	 * @ordered
	 */
    NULL(10, "NULL", "NULL"),

    /**
	 * The '<em><b>RECORD</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #RECORD_VALUE
	 * @generated
	 * @ordered
	 */
    RECORD(11, "RECORD", "RECORD"),

    /**
	 * The '<em><b>STRING</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #STRING_VALUE
	 * @generated
	 * @ordered
	 */
    STRING(12, "STRING", "STRING"),

    /**
	 * The '<em><b>UNION</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #UNION_VALUE
	 * @generated
	 * @ordered
	 */
    UNION(13, "UNION", "UNION");

    /**
	 * The '<em><b>ARRAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ARRAY</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #ARRAY
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int ARRAY_VALUE = 0;

    /**
	 * The '<em><b>BOOLEAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BOOLEAN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int BOOLEAN_VALUE = 1;

    /**
	 * The '<em><b>BYTES</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BYTES</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #BYTES
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int BYTES_VALUE = 2;

    /**
	 * The '<em><b>DOUBLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DOUBLE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #DOUBLE
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int DOUBLE_VALUE = 3;

    /**
	 * The '<em><b>ENUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ENUM</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #ENUM
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int ENUM_VALUE = 4;

    /**
	 * The '<em><b>FIXED</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FIXED</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FIXED
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int FIXED_VALUE = 5;

    /**
	 * The '<em><b>FLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FLOAT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #FLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int FLOAT_VALUE = 6;

    /**
	 * The '<em><b>INT</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #INT
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int INT_VALUE = 7;

    /**
	 * The '<em><b>LONG</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>LONG</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #LONG
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int LONG_VALUE = 8;

    /**
	 * The '<em><b>MAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MAP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #MAP
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int MAP_VALUE = 9;

    /**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int NULL_VALUE = 10;

    /**
	 * The '<em><b>RECORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>RECORD</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #RECORD
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int RECORD_VALUE = 11;

    /**
	 * The '<em><b>STRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>STRING</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #STRING
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int STRING_VALUE = 12;

    /**
	 * The '<em><b>UNION</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>UNION</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #UNION
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int UNION_VALUE = 13;

    /**
	 * An array of all the '<em><b>Schema Data Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private static final SchemaDataType[] VALUES_ARRAY =
        new SchemaDataType[] {
			ARRAY,
			BOOLEAN,
			BYTES,
			DOUBLE,
			ENUM,
			FIXED,
			FLOAT,
			INT,
			LONG,
			MAP,
			NULL,
			RECORD,
			STRING,
			UNION,
		};

    /**
	 * A public read-only list of all the '<em><b>Schema Data Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final List<SchemaDataType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
	 * Returns the '<em><b>Schema Data Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static SchemaDataType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SchemaDataType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>Schema Data Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static SchemaDataType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SchemaDataType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>Schema Data Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static SchemaDataType get(int value) {
		switch (value) {
			case ARRAY_VALUE: return ARRAY;
			case BOOLEAN_VALUE: return BOOLEAN;
			case BYTES_VALUE: return BYTES;
			case DOUBLE_VALUE: return DOUBLE;
			case ENUM_VALUE: return ENUM;
			case FIXED_VALUE: return FIXED;
			case FLOAT_VALUE: return FLOAT;
			case INT_VALUE: return INT;
			case LONG_VALUE: return LONG;
			case MAP_VALUE: return MAP;
			case NULL_VALUE: return NULL;
			case RECORD_VALUE: return RECORD;
			case STRING_VALUE: return STRING;
			case UNION_VALUE: return UNION;
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

    /**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private SchemaDataType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
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
    
} //SchemaDataType
