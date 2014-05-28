/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getConditionType <em>Condition Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getRegex <em>Regex</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getPassOutputConnector <em>Pass Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getFailOutputConnector <em>Fail Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getXpath <em>Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getSource <em>Source</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getFilterContainer <em>Filter Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator()
 * @model
 * @generated
 */
public interface FilterMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Condition Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorConditionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorConditionType
	 * @see #setConditionType(FilterMediatorConditionType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_ConditionType()
	 * @model
	 * @generated
	 */
	FilterMediatorConditionType getConditionType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getConditionType <em>Condition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorConditionType
	 * @see #getConditionType()
	 * @generated
	 */
	void setConditionType(FilterMediatorConditionType value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_Source()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSource();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Filter Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filter Container</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Container</em>' containment reference.
	 * @see #setFilterContainer(FilterContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_FilterContainer()
	 * @model containment="true"
	 * @generated
	 */
    FilterContainer getFilterContainer();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getFilterContainer <em>Filter Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Container</em>' containment reference.
	 * @see #getFilterContainer()
	 * @generated
	 */
    void setFilterContainer(FilterContainer value);

    /**
	 * Returns the value of the '<em><b>Regex</b></em>' attribute.
	 * The default value is <code>"default_regex"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regex</em>' attribute.
	 * @see #setRegex(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_Regex()
	 * @model default="default_regex"
	 * @generated
	 */
	String getRegex();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getRegex <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex</em>' attribute.
	 * @see #getRegex()
	 * @generated
	 */
	void setRegex(String value);

	/**
	 * Returns the value of the '<em><b>Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xpath</em>' containment reference.
	 * @see #setXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_Xpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getXpath <em>Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xpath</em>' containment reference.
	 * @see #getXpath()
	 * @generated
	 */
	void setXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(FilterMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	FilterMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(FilterMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(FilterMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
    FilterMediatorOutputConnector getOutputConnector();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
    void setOutputConnector(FilterMediatorOutputConnector value);

    /**
	 * Returns the value of the '<em><b>Pass Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pass Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pass Output Connector</em>' containment reference.
	 * @see #setPassOutputConnector(FilterMediatorPassOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_PassOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	FilterMediatorPassOutputConnector getPassOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getPassOutputConnector <em>Pass Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pass Output Connector</em>' containment reference.
	 * @see #getPassOutputConnector()
	 * @generated
	 */
	void setPassOutputConnector(FilterMediatorPassOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Fail Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fail Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fail Output Connector</em>' containment reference.
	 * @see #setFailOutputConnector(FilterMediatorFailOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterMediator_FailOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	FilterMediatorFailOutputConnector getFailOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator#getFailOutputConnector <em>Fail Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fail Output Connector</em>' containment reference.
	 * @see #getFailOutputConnector()
	 * @generated
	 */
	void setFailOutputConnector(FilterMediatorFailOutputConnector value);

} // FilterMediator
