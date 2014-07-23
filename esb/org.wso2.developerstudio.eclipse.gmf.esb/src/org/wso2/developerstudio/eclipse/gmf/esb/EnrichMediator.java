/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enrich Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#isCloneSource <em>Clone Source</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getSourceXML <em>Source XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getTargetAction <em>Target Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getTargetXpath <em>Target Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getInlineType <em>Inline Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getInlineRegistryKey <em>Inline Registry Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator()
 * @model
 * @generated
 */
public interface EnrichMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Clone Source</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clone Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clone Source</em>' attribute.
	 * @see #setCloneSource(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_CloneSource()
	 * @model default="false"
	 * @generated
	 */
	boolean isCloneSource();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#isCloneSource <em>Clone Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clone Source</em>' attribute.
	 * @see #isCloneSource()
	 * @generated
	 */
	void setCloneSource(boolean value);

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceType
	 * @see #setSourceType(EnrichSourceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_SourceType()
	 * @model
	 * @generated
	 */
	EnrichSourceType getSourceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getSourceType <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceType
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(EnrichSourceType value);

	/**
	 * Returns the value of the '<em><b>Source Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Xpath</em>' containment reference.
	 * @see #setSourceXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_SourceXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSourceXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getSourceXpath <em>Source Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Xpath</em>' containment reference.
	 * @see #getSourceXpath()
	 * @generated
	 */
	void setSourceXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Source Property</b></em>' attribute.
	 * The default value is <code>"source_property"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Property</em>' attribute.
	 * @see #setSourceProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_SourceProperty()
	 * @model default="source_property"
	 * @generated
	 */
	String getSourceProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getSourceProperty <em>Source Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Property</em>' attribute.
	 * @see #getSourceProperty()
	 * @generated
	 */
	void setSourceProperty(String value);

	/**
	 * Returns the value of the '<em><b>Source XML</b></em>' attribute.
	 * The default value is <code>"<inline/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source XML</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source XML</em>' attribute.
	 * @see #setSourceXML(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_SourceXML()
	 * @model default="<inline/>"
	 * @generated
	 */
	String getSourceXML();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getSourceXML <em>Source XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source XML</em>' attribute.
	 * @see #getSourceXML()
	 * @generated
	 */
	void setSourceXML(String value);

	/**
	 * Returns the value of the '<em><b>Target Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetAction
	 * @see #setTargetAction(EnrichTargetAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_TargetAction()
	 * @model
	 * @generated
	 */
	EnrichTargetAction getTargetAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getTargetAction <em>Target Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetAction
	 * @see #getTargetAction()
	 * @generated
	 */
	void setTargetAction(EnrichTargetAction value);

	/**
	 * Returns the value of the '<em><b>Target Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetType
	 * @see #setTargetType(EnrichTargetType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_TargetType()
	 * @model
	 * @generated
	 */
	EnrichTargetType getTargetType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getTargetType <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetType
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(EnrichTargetType value);

	/**
	 * Returns the value of the '<em><b>Target Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Xpath</em>' containment reference.
	 * @see #setTargetXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_TargetXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getTargetXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getTargetXpath <em>Target Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Xpath</em>' containment reference.
	 * @see #getTargetXpath()
	 * @generated
	 */
	void setTargetXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Target Property</b></em>' attribute.
	 * The default value is <code>"target_property"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Property</em>' attribute.
	 * @see #setTargetProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_TargetProperty()
	 * @model default="target_property"
	 * @generated
	 */
	String getTargetProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getTargetProperty <em>Target Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Property</em>' attribute.
	 * @see #getTargetProperty()
	 * @generated
	 */
	void setTargetProperty(String value);

	/**
	 * Returns the value of the '<em><b>Inline Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceInlineType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inline Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inline Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceInlineType
	 * @see #setInlineType(EnrichSourceInlineType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_InlineType()
	 * @model
	 * @generated
	 */
	EnrichSourceInlineType getInlineType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getInlineType <em>Inline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inline Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceInlineType
	 * @see #getInlineType()
	 * @generated
	 */
	void setInlineType(EnrichSourceInlineType value);

	/**
	 * Returns the value of the '<em><b>Inline Registry Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inline Registry Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inline Registry Key</em>' containment reference.
	 * @see #setInlineRegistryKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_InlineRegistryKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getInlineRegistryKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getInlineRegistryKey <em>Inline Registry Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inline Registry Key</em>' containment reference.
	 * @see #getInlineRegistryKey()
	 * @generated
	 */
	void setInlineRegistryKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(EnrichMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EnrichMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(EnrichMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(EnrichMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEnrichMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EnrichMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(EnrichMediatorOutputConnector value);

} // EnrichMediator
