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
 * A representation of the model object '<em><b>Rule Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetURL <em>Rule Set URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetSourceType <em>Rule Set Source Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetSourceCode <em>Rule Set Source Code</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetSourceKey <em>Rule Set Source Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#isStatefulSession <em>Stateful Session</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSessionProperties <em>Rule Session Properties</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getFactsConfiguration <em>Facts Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getResultsConfiguration <em>Results Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getChildMediatorsConfiguration <em>Child Mediators Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getChildMediatorsOutputConnector <em>Child Mediators Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getSourceValue <em>Source Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getTargetValue <em>Target Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getTargetResultXpath <em>Target Result Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getTargetXpath <em>Target Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getTargetAction <em>Target Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getInputWrapperName <em>Input Wrapper Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getInputNameSpace <em>Input Name Space</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getOutputWrapperName <em>Output Wrapper Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getOutputNameSpace <em>Output Name Space</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetType <em>Rule Set Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator()
 * @model
 * @generated
 */
public interface RuleMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Rule Set URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Set URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Set URL</em>' attribute.
	 * @see #setRuleSetURL(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_RuleSetURL()
	 * @model
	 * @generated
	 */
	String getRuleSetURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetURL <em>Rule Set URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Set URL</em>' attribute.
	 * @see #getRuleSetURL()
	 * @generated
	 */
	void setRuleSetURL(String value);

	/**
	 * Returns the value of the '<em><b>Rule Set Source Type</b></em>' attribute.
	 * The default value is <code>"INLINE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Set Source Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Set Source Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType
	 * @see #setRuleSetSourceType(RuleSourceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_RuleSetSourceType()
	 * @model default="INLINE"
	 * @generated
	 */
	RuleSourceType getRuleSetSourceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetSourceType <em>Rule Set Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Set Source Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType
	 * @see #getRuleSetSourceType()
	 * @generated
	 */
	void setRuleSetSourceType(RuleSourceType value);

	/**
	 * Returns the value of the '<em><b>Rule Set Source Code</b></em>' attribute.
	 * The default value is <code>"<code/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Set Source Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Set Source Code</em>' attribute.
	 * @see #setRuleSetSourceCode(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_RuleSetSourceCode()
	 * @model default="<code/>"
	 * @generated
	 */
	String getRuleSetSourceCode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetSourceCode <em>Rule Set Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Set Source Code</em>' attribute.
	 * @see #getRuleSetSourceCode()
	 * @generated
	 */
	void setRuleSetSourceCode(String value);

	/**
	 * Returns the value of the '<em><b>Rule Set Source Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Set Source Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Set Source Key</em>' containment reference.
	 * @see #setRuleSetSourceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_RuleSetSourceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getRuleSetSourceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetSourceKey <em>Rule Set Source Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Set Source Key</em>' containment reference.
	 * @see #getRuleSetSourceKey()
	 * @generated
	 */
	void setRuleSetSourceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Stateful Session</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stateful Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stateful Session</em>' attribute.
	 * @see #setStatefulSession(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_StatefulSession()
	 * @model default="true"
	 * @generated
	 */
	boolean isStatefulSession();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#isStatefulSession <em>Stateful Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stateful Session</em>' attribute.
	 * @see #isStatefulSession()
	 * @generated
	 */
	void setStatefulSession(boolean value);

	/**
	 * Returns the value of the '<em><b>Rule Session Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleSessionProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Session Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Session Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_RuleSessionProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuleSessionProperty> getRuleSessionProperties();

	/**
	 * Returns the value of the '<em><b>Facts Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facts Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facts Configuration</em>' containment reference.
	 * @see #setFactsConfiguration(RuleFactsConfiguration)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_FactsConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RuleFactsConfiguration getFactsConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getFactsConfiguration <em>Facts Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facts Configuration</em>' containment reference.
	 * @see #getFactsConfiguration()
	 * @generated
	 */
	void setFactsConfiguration(RuleFactsConfiguration value);

	/**
	 * Returns the value of the '<em><b>Results Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results Configuration</em>' containment reference.
	 * @see #setResultsConfiguration(RuleResultsConfiguration)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_ResultsConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RuleResultsConfiguration getResultsConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getResultsConfiguration <em>Results Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Results Configuration</em>' containment reference.
	 * @see #getResultsConfiguration()
	 * @generated
	 */
	void setResultsConfiguration(RuleResultsConfiguration value);

	/**
	 * Returns the value of the '<em><b>Child Mediators Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Mediators Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Mediators Configuration</em>' containment reference.
	 * @see #setChildMediatorsConfiguration(RuleChildMediatorsConfiguration)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_ChildMediatorsConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RuleChildMediatorsConfiguration getChildMediatorsConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getChildMediatorsConfiguration <em>Child Mediators Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Mediators Configuration</em>' containment reference.
	 * @see #getChildMediatorsConfiguration()
	 * @generated
	 */
	void setChildMediatorsConfiguration(RuleChildMediatorsConfiguration value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(RuleMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RuleMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(RuleMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(RuleMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RuleMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(RuleMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Child Mediators Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Mediators Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Mediators Output Connector</em>' containment reference.
	 * @see #setChildMediatorsOutputConnector(RuleMediatorChildMediatorsOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_ChildMediatorsOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RuleMediatorChildMediatorsOutputConnector getChildMediatorsOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getChildMediatorsOutputConnector <em>Child Mediators Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Mediators Output Connector</em>' containment reference.
	 * @see #getChildMediatorsOutputConnector()
	 * @generated
	 */
	void setChildMediatorsOutputConnector(RuleMediatorChildMediatorsOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Mediator Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediator Flow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #setMediatorFlow(MediatorFlow)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

	/**
	 * Returns the value of the '<em><b>Source Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Value</em>' attribute.
	 * @see #setSourceValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_SourceValue()
	 * @model
	 * @generated
	 */
	String getSourceValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getSourceValue <em>Source Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Value</em>' attribute.
	 * @see #getSourceValue()
	 * @generated
	 */
	void setSourceValue(String value);

	/**
	 * Returns the value of the '<em><b>Source Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Xpath</em>' containment reference.
	 * @see #setSourceXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_SourceXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSourceXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getSourceXpath <em>Source Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Xpath</em>' containment reference.
	 * @see #getSourceXpath()
	 * @generated
	 */
	void setSourceXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Target Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Value</em>' attribute.
	 * @see #setTargetValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_TargetValue()
	 * @model
	 * @generated
	 */
	String getTargetValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getTargetValue <em>Target Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Value</em>' attribute.
	 * @see #getTargetValue()
	 * @generated
	 */
	void setTargetValue(String value);

	/**
	 * Returns the value of the '<em><b>Target Result Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Result Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Result Xpath</em>' containment reference.
	 * @see #setTargetResultXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_TargetResultXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getTargetResultXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getTargetResultXpath <em>Target Result Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Result Xpath</em>' containment reference.
	 * @see #getTargetResultXpath()
	 * @generated
	 */
	void setTargetResultXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Target Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Xpath</em>' containment reference.
	 * @see #setTargetXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_TargetXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getTargetXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getTargetXpath <em>Target Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Xpath</em>' containment reference.
	 * @see #getTargetXpath()
	 * @generated
	 */
	void setTargetXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Target Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleActions}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleActions
	 * @see #setTargetAction(RuleActions)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_TargetAction()
	 * @model
	 * @generated
	 */
	RuleActions getTargetAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getTargetAction <em>Target Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleActions
	 * @see #getTargetAction()
	 * @generated
	 */
	void setTargetAction(RuleActions value);

	/**
	 * Returns the value of the '<em><b>Input Wrapper Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Wrapper Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Wrapper Name</em>' attribute.
	 * @see #setInputWrapperName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_InputWrapperName()
	 * @model
	 * @generated
	 */
	String getInputWrapperName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getInputWrapperName <em>Input Wrapper Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Wrapper Name</em>' attribute.
	 * @see #getInputWrapperName()
	 * @generated
	 */
	void setInputWrapperName(String value);

	/**
	 * Returns the value of the '<em><b>Input Name Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Name Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Name Space</em>' attribute.
	 * @see #setInputNameSpace(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_InputNameSpace()
	 * @model
	 * @generated
	 */
	String getInputNameSpace();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getInputNameSpace <em>Input Name Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Name Space</em>' attribute.
	 * @see #getInputNameSpace()
	 * @generated
	 */
	void setInputNameSpace(String value);

	/**
	 * Returns the value of the '<em><b>Output Wrapper Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Wrapper Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Wrapper Name</em>' attribute.
	 * @see #setOutputWrapperName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_OutputWrapperName()
	 * @model
	 * @generated
	 */
	String getOutputWrapperName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getOutputWrapperName <em>Output Wrapper Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Wrapper Name</em>' attribute.
	 * @see #getOutputWrapperName()
	 * @generated
	 */
	void setOutputWrapperName(String value);

	/**
	 * Returns the value of the '<em><b>Output Name Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Name Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Name Space</em>' attribute.
	 * @see #setOutputNameSpace(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_OutputNameSpace()
	 * @model
	 * @generated
	 */
	String getOutputNameSpace();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getOutputNameSpace <em>Output Name Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Name Space</em>' attribute.
	 * @see #getOutputNameSpace()
	 * @generated
	 */
	void setOutputNameSpace(String value);

	/**
	 * Returns the value of the '<em><b>Rule Set Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Set Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Set Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleType
	 * @see #setRuleSetType(RuleType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleMediator_RuleSetType()
	 * @model
	 * @generated
	 */
	RuleType getRuleSetType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator#getRuleSetType <em>Rule Set Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Set Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleType
	 * @see #getRuleSetType()
	 * @generated
	 */
	void setRuleSetType(RuleType value);

} // RuleMediator
