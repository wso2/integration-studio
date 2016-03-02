/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XSLT Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getXsltSchemaKeyType <em>Xslt Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getXsltStaticSchemaKey <em>Xslt Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getXsltDynamicSchemaKey <em>Xslt Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getXsltKey <em>Xslt Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getSourceXPath <em>Source XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator()
 * @model
 * @generated
 */
public interface XSLTMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(XSLTMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	XSLTMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(XSLTMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(XSLTMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	XSLTMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(XSLTMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Xslt Schema Key Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Schema Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xslt Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #setXsltSchemaKeyType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_XsltSchemaKeyType()
	 * @model
	 * @generated
	 */
	KeyType getXsltSchemaKeyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getXsltSchemaKeyType <em>Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xslt Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #getXsltSchemaKeyType()
	 * @generated
	 */
	void setXsltSchemaKeyType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Xslt Static Schema Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Static Schema Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xslt Static Schema Key</em>' containment reference.
	 * @see #setXsltStaticSchemaKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_XsltStaticSchemaKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getXsltStaticSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getXsltStaticSchemaKey <em>Xslt Static Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xslt Static Schema Key</em>' containment reference.
	 * @see #getXsltStaticSchemaKey()
	 * @generated
	 */
	void setXsltStaticSchemaKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Xslt Dynamic Schema Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Dynamic Schema Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xslt Dynamic Schema Key</em>' containment reference.
	 * @see #setXsltDynamicSchemaKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_XsltDynamicSchemaKey()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getXsltDynamicSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getXsltDynamicSchemaKey <em>Xslt Dynamic Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xslt Dynamic Schema Key</em>' containment reference.
	 * @see #getXsltDynamicSchemaKey()
	 * @generated
	 */
	void setXsltDynamicSchemaKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Xslt Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xslt Key</em>' containment reference.
	 * @see #setXsltKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_XsltKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getXsltKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getXsltKey <em>Xslt Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xslt Key</em>' containment reference.
	 * @see #getXsltKey()
	 * @generated
	 */
	void setXsltKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Source XPath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source XPath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source XPath</em>' containment reference.
	 * @see #setSourceXPath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_SourceXPath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSourceXPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator#getSourceXPath <em>Source XPath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source XPath</em>' containment reference.
	 * @see #getSourceXPath()
	 * @generated
	 */
	void setSourceXPath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<XSLTProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<XSLTFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.XSLTResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXSLTMediator_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<XSLTResource> getResources();

} // XSLTMediator
