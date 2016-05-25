/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateLongRange <em>Validate Long Range</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateDoubleRange <em>Validate Double Range</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateLength <em>Validate Length</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidatePattern <em>Validate Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateCustom <em>Validate Custom</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getOrdinal <em>Ordinal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getParamType <em>Param Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getSqlType <em>Sql Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getStructType <em>Struct Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter()
 * @model extendedMetaData="name='param_._type' kind='mixed'"
 * @generated
 */
public interface QueryParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Validate Long Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Long Range</em>' containment
	 * reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Long Range</em>' containment reference.
	 * @see #setValidateLongRange(LongRangeValidator)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_ValidateLongRange()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='validateLongRange' namespace='##targetNamespace'"
	 * @generated
	 */
	LongRangeValidator getValidateLongRange();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateLongRange <em>Validate Long Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Long Range</em>' containment reference.
	 * @see #getValidateLongRange()
	 * @generated
	 */
	void setValidateLongRange(LongRangeValidator value);

	/**
	 * Returns the value of the '<em><b>Validate Double Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Double Range</em>' containment
	 * reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Double Range</em>' containment reference.
	 * @see #setValidateDoubleRange(DoubleRangeValidator)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_ValidateDoubleRange()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='validateDoubleRange' namespace='##targetNamespace'"
	 * @generated
	 */
	DoubleRangeValidator getValidateDoubleRange();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateDoubleRange <em>Validate Double Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Double Range</em>' containment reference.
	 * @see #getValidateDoubleRange()
	 * @generated
	 */
	void setValidateDoubleRange(DoubleRangeValidator value);

	/**
	 * Returns the value of the '<em><b>Validate Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Length</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Length</em>' containment reference.
	 * @see #setValidateLength(LengthValidator)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_ValidateLength()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='validateLength' namespace='##targetNamespace'"
	 * @generated
	 */
	LengthValidator getValidateLength();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateLength <em>Validate Length</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Length</em>' containment reference.
	 * @see #getValidateLength()
	 * @generated
	 */
	void setValidateLength(LengthValidator value);

	/**
	 * Returns the value of the '<em><b>Validate Pattern</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.ds.PatternValidator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Pattern</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Pattern</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_ValidatePattern()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='validatePattern' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PatternValidator> getValidatePattern();

	/**
	 * Returns the value of the '<em><b>Validate Custom</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.ds.CustomValidator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Custom</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Custom</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_ValidateCustom()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='validateCustom' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CustomValidator> getValidateCustom();

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_DefaultValue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='defaultValue' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ordinal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordinal</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordinal</em>' attribute.
	 * @see #setOrdinal(int)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_Ordinal()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='ordinal' namespace='##targetNamespace'"
	 * @generated
	 */
	int getOrdinal();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getOrdinal <em>Ordinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordinal</em>' attribute.
	 * @see #getOrdinal()
	 * @generated
	 */
	void setOrdinal(int value);

	/**
	 * Returns the value of the '<em><b>Param Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Type</em>' attribute.
	 * @see #setParamType(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_ParamType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='paramType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getParamType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getParamType <em>Param Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param Type</em>' attribute.
	 * @see #getParamType()
	 * @generated
	 */
	void setParamType(String value);

	/**
	 * Returns the value of the '<em><b>Sql Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sql Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sql Type</em>' attribute.
	 * @see #setSqlType(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_SqlType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='sqlType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSqlType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getSqlType <em>Sql Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sql Type</em>' attribute.
	 * @see #getSqlType()
	 * @generated
	 */
	void setSqlType(String value);

	/**
	 * Returns the value of the '<em><b>Struct Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Struct Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Struct Type</em>' attribute.
	 * @see #setStructType(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_StructType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='structType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getStructType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getStructType <em>Struct Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Struct Type</em>' attribute.
	 * @see #getStructType()
	 * @generated
	 */
	void setStructType(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getQueryParameter_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type' namespace='##targetNamespace'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // QueryParameter
