/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getIterateID <em>Iterate ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#isSequentialMediation <em>Sequential Mediation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#isContinueParent <em>Continue Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#isPreservePayload <em>Preserve Payload</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getIterateExpression <em>Iterate Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getAttachPath <em>Attach Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getTarget <em>Target</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getTargetOutputConnector <em>Target Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getSequenceName <em>Sequence Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator()
 * @model
 * @generated
 */
public interface IterateMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Iterate ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterate ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterate ID</em>' attribute.
	 * @see #setIterateID(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_IterateID()
	 * @model
	 * @generated
	 */
	String getIterateID();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getIterateID <em>Iterate ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterate ID</em>' attribute.
	 * @see #getIterateID()
	 * @generated
	 */
	void setIterateID(String value);

	/**
	 * Returns the value of the '<em><b>Sequential Mediation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequential Mediation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequential Mediation</em>' attribute.
	 * @see #setSequentialMediation(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_SequentialMediation()
	 * @model
	 * @generated
	 */
	boolean isSequentialMediation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#isSequentialMediation <em>Sequential Mediation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequential Mediation</em>' attribute.
	 * @see #isSequentialMediation()
	 * @generated
	 */
	void setSequentialMediation(boolean value);

	/**
	 * Returns the value of the '<em><b>Continue Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Continue Parent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Continue Parent</em>' attribute.
	 * @see #setContinueParent(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_ContinueParent()
	 * @model
	 * @generated
	 */
	boolean isContinueParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#isContinueParent <em>Continue Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Continue Parent</em>' attribute.
	 * @see #isContinueParent()
	 * @generated
	 */
	void setContinueParent(boolean value);

	/**
	 * Returns the value of the '<em><b>Preserve Payload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preserve Payload</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preserve Payload</em>' attribute.
	 * @see #setPreservePayload(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_PreservePayload()
	 * @model
	 * @generated
	 */
	boolean isPreservePayload();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#isPreservePayload <em>Preserve Payload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preserve Payload</em>' attribute.
	 * @see #isPreservePayload()
	 * @generated
	 */
	void setPreservePayload(boolean value);

	/**
	 * Returns the value of the '<em><b>Iterate Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterate Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterate Expression</em>' containment reference.
	 * @see #setIterateExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_IterateExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getIterateExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getIterateExpression <em>Iterate Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterate Expression</em>' containment reference.
	 * @see #getIterateExpression()
	 * @generated
	 */
	void setIterateExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Attach Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attach Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attach Path</em>' containment reference.
	 * @see #setAttachPath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_AttachPath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getAttachPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getAttachPath <em>Attach Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attach Path</em>' containment reference.
	 * @see #getAttachPath()
	 * @generated
	 */
	void setAttachPath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(IterateTarget)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_Target()
	 * @model containment="true"
	 * @generated
	 */
	IterateTarget getTarget();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(IterateTarget value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(IterateMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	IterateMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(IterateMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(IterateMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	IterateMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(IterateMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Target Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Output Connector</em>' containment reference.
	 * @see #setTargetOutputConnector(IterateMediatorTargetOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_TargetOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	IterateMediatorTargetOutputConnector getTargetOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getTargetOutputConnector <em>Target Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Output Connector</em>' containment reference.
	 * @see #getTargetOutputConnector()
	 * @generated
	 */
	void setTargetOutputConnector(IterateMediatorTargetOutputConnector value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #setSequenceType(SequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_SequenceType()
	 * @model
	 * @generated
	 */
	SequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(SequenceType value);

	/**
	 * Returns the value of the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Key</em>' containment reference.
	 * @see #setSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_SequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getSequenceKey <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Key</em>' containment reference.
	 * @see #getSequenceKey()
	 * @generated
	 */
	void setSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Name</em>' attribute.
	 * @see #setSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getIterateMediator_SequenceName()
	 * @model
	 * @generated
	 */
	String getSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator#getSequenceName <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Name</em>' attribute.
	 * @see #getSequenceName()
	 * @generated
	 */
	void setSequenceName(String value);

} // IterateMediator
