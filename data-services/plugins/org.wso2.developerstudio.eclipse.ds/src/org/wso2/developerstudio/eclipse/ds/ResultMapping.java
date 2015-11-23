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
 * A representation of the model object '<em><b>Result Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getElement <em>Element</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getCallQuery <em>Call Query</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getDefaultNamespace <em>Default Namespace</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getElementName <em>Element Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getRowName <em>Row Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#isUseColumnNumbers <em>Use Column Numbers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#isEscapeNonPrintableChar <em>Escape Non Printable Char</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getXsltPath <em>Xslt Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getOutputType <em>Output Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping()
 * @model extendedMetaData="name='result_._type' kind='mixed'"
 * @generated
 */
public interface ResultMapping extends EObject {
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
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_Mixed()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='elementWildcard' name=':mixed'"
     * @generated
     */
	FeatureMap getMixed();

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
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_Element()
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
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_Attribute()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='attribute' namespace='##targetNamespace'"
     * @generated
     */
	EList<AttributeMapping> getAttribute();

	/**
     * Returns the value of the '<em><b>Call Query</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.ds.CallQuery}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Query</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Call Query</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_CallQuery()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='call-query' namespace='##targetNamespace'"
     * @generated
     */
	EList<CallQuery> getCallQuery();

	/**
     * Returns the value of the '<em><b>Default Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Default Namespace</em>' attribute.
     * @see #setDefaultNamespace(String)
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_DefaultNamespace()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='defaultNamespace' namespace='##targetNamespace'"
     * @generated
     */
	String getDefaultNamespace();

	/**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getDefaultNamespace <em>Default Namespace</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Namespace</em>' attribute.
     * @see #getDefaultNamespace()
     * @generated
     */
	void setDefaultNamespace(String value);

	/**
     * Returns the value of the '<em><b>Element Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Element Name</em>' attribute.
     * @see #setElementName(String)
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_ElementName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='element' namespace='##targetNamespace'"
     * @generated
     */
	String getElementName();

	/**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getElementName <em>Element Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Element Name</em>' attribute.
     * @see #getElementName()
     * @generated
     */
	void setElementName(String value);

	/**
     * Returns the value of the '<em><b>Row Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Row Name</em>' attribute.
     * @see #setRowName(String)
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_RowName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='rowName' namespace='##targetNamespace'"
     * @generated
     */
	String getRowName();

	/**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getRowName <em>Row Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Row Name</em>' attribute.
     * @see #getRowName()
     * @generated
     */
	void setRowName(String value);

	/**
     * Returns the value of the '<em><b>Use Column Numbers</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Column Numbers</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Use Column Numbers</em>' attribute.
     * @see #setUseColumnNumbers(boolean)
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_UseColumnNumbers()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='useColumnNumbers' namespace='##targetNamespace'"
     * @generated
     */
	boolean isUseColumnNumbers();

	/**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#isUseColumnNumbers <em>Use Column Numbers</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Use Column Numbers</em>' attribute.
     * @see #isUseColumnNumbers()
     * @generated
     */
	void setUseColumnNumbers(boolean value);

	/**
     * Returns the value of the '<em><b>Escape Non Printable Char</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Escape Non Printable Char</em>' attribute
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Escape Non Printable Char</em>' attribute.
     * @see #setEscapeNonPrintableChar(boolean)
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_EscapeNonPrintableChar()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     * @generated
     */
	boolean isEscapeNonPrintableChar();

	/**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#isEscapeNonPrintableChar <em>Escape Non Printable Char</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Escape Non Printable Char</em>' attribute.
     * @see #isEscapeNonPrintableChar()
     * @generated
     */
	void setEscapeNonPrintableChar(boolean value);

	/**
     * Returns the value of the '<em><b>Xslt Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Path</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Xslt Path</em>' attribute.
     * @see #setXsltPath(String)
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_XsltPath()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='xsltPath' namespace='##targetNamespace'"
     * @generated
     */
	String getXsltPath();

	/**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getXsltPath <em>Xslt Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Xslt Path</em>' attribute.
     * @see #getXsltPath()
     * @generated
     */
	void setXsltPath(String value);

    /**
     * Returns the value of the '<em><b>Output Type</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Type</em>' attribute.
     * @see #setOutputType(String)
     * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResultMapping_OutputType()
     * @model default="" dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getOutputType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getOutputType <em>Output Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Type</em>' attribute.
     * @see #getOutputType()
     * @generated
     */
    void setOutputType(String value);

} // ResultMapping
