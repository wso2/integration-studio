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
 * A representation of the model object '<em><b>Element Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getColumn <em>Column</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getExport <em>Export</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getRequiredRoles <em>Required Roles</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getExportType <em>Export Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getXsdType <em>Xsd Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getElement <em>Element</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getCallQuery <em>Call Query</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#isIsComplexType <em>Is Complex Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getQueryParam <em>Query Param</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getValue <em>Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getArrayName <em>Array Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping()
 * @model extendedMetaData="name='element_._type' kind='mixed'"
 * @generated
 */
public interface ElementMapping extends EObject {
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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Column()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='column' namespace='##targetNamespace'"
	 * @generated
	 */
	String getColumn();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(String value);

	/**
	 * Returns the value of the '<em><b>Export</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export</em>' attribute.
	 * @see #setExport(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Export()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='export' namespace='##targetNamespace'"
	 * @generated
	 */
	String getExport();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getExport <em>Export</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export</em>' attribute.
	 * @see #getExport()
	 * @generated
	 */
	void setExport(String value);

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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Required Roles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Roles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Roles</em>' attribute.
	 * @see #setRequiredRoles(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_RequiredRoles()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='requiredRoles' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRequiredRoles();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getRequiredRoles <em>Required Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Roles</em>' attribute.
	 * @see #getRequiredRoles()
	 * @generated
	 */
	void setRequiredRoles(String value);

	/**
	 * Returns the value of the '<em><b>Export Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Type</em>' attribute.
	 * @see #setExportType(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_ExportType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='exportType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getExportType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getExportType <em>Export Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Type</em>' attribute.
	 * @see #getExportType()
	 * @generated
	 */
	void setExportType(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Namespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='namespace' namespace='##targetNamespace'"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Xsd Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xsd Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xsd Type</em>' attribute.
	 * @see #setXsdType(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_XsdType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='xsdType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getXsdType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getXsdType <em>Xsd Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xsd Type</em>' attribute.
	 * @see #getXsdType()
	 * @generated
	 */
	void setXsdType(String value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.ds.ElementMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Element()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ElementMapping> getElement();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.ds.AttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Attribute()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='attribute' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AttributeMapping> getAttribute();

	/**
	 * Returns the value of the '<em><b>Call Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Query</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Query</em>' containment reference.
	 * @see #setCallQuery(CallQuery)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_CallQuery()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='call-query' namespace='##targetNamespace'"
	 * @generated
	 */
	CallQuery getCallQuery();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getCallQuery <em>Call Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Query</em>' containment reference.
	 * @see #getCallQuery()
	 * @generated
	 */
	void setCallQuery(CallQuery value);

	/**
	 * Returns the value of the '<em><b>Is Complex Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Complex Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Complex Type</em>' attribute.
	 * @see #setIsComplexType(boolean)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_IsComplexType()
	 * @model extendedMetaData="kind='attribute' name='isComplexType' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isIsComplexType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#isIsComplexType <em>Is Complex Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Complex Type</em>' attribute.
	 * @see #isIsComplexType()
	 * @generated
	 */
	void setIsComplexType(boolean value);

	/**
	 * Returns the value of the '<em><b>Query Param</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Param</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Param</em>' attribute.
	 * @see #setQueryParam(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_QueryParam()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='query-param' namespace='##targetNamespace'"
	 * @generated
	 */
	String getQueryParam();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getQueryParam <em>Query Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Param</em>' attribute.
	 * @see #getQueryParam()
	 * @generated
	 */
	void setQueryParam(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_Optional()
	 * @model default="false"
	 *        extendedMetaData="kind='attribute' name='optional' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>Array Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Name</em>' attribute.
	 * @see #setArrayName(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getElementMapping_ArrayName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='arrayName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getArrayName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getArrayName <em>Array Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Name</em>' attribute.
	 * @see #getArrayName()
	 * @generated
	 */
	void setArrayName(String value);

	/*
	 * boolean isComplex();
	 * 
	 * void setComplex(boolean isComplex);
	 */

} // ElementMapping
