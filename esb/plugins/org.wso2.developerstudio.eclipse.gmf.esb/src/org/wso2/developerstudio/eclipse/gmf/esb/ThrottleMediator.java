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
 * A representation of the model object '<em><b>Throttle Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getPolicyType <em>Policy Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getPolicyKey <em>Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getPolicyEntries <em>Policy Entries</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getPolicyConfiguration <em>Policy Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnAcceptBranch <em>On Accept Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnRejectBranch <em>On Reject Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnAcceptOutputConnector <em>On Accept Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnRejectOutputConnector <em>On Reject Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getThrottleContainer <em>Throttle Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnAcceptBranchsequenceType <em>On Accept Branchsequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnAcceptBranchsequenceKey <em>On Accept Branchsequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnRejectBranchsequenceType <em>On Reject Branchsequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnRejectBranchsequenceKey <em>On Reject Branchsequence Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator()
 * @model
 * @generated
 */
public interface ThrottleMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * The default value is <code>"group_id"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_GroupId()
	 * @model default="group_id"
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Returns the value of the '<em><b>Policy Type</b></em>' attribute.
	 * The default value is <code>"INLINE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType
	 * @see #setPolicyType(ThrottlePolicyType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_PolicyType()
	 * @model default="INLINE"
	 * @generated
	 */
	ThrottlePolicyType getPolicyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getPolicyType <em>Policy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType
	 * @see #getPolicyType()
	 * @generated
	 */
	void setPolicyType(ThrottlePolicyType value);

	/**
	 * Returns the value of the '<em><b>Policy Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Key</em>' containment reference.
	 * @see #setPolicyKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_PolicyKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getPolicyKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getPolicyKey <em>Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Key</em>' containment reference.
	 * @see #getPolicyKey()
	 * @generated
	 */
	void setPolicyKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Max Concurrent Access Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Concurrent Access Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Concurrent Access Count</em>' attribute.
	 * @see #setMaxConcurrentAccessCount(int)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_MaxConcurrentAccessCount()
	 * @model
	 * @generated
	 */
	int getMaxConcurrentAccessCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Concurrent Access Count</em>' attribute.
	 * @see #getMaxConcurrentAccessCount()
	 * @generated
	 */
	void setMaxConcurrentAccessCount(int value);

	/**
	 * Returns the value of the '<em><b>Policy Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Entries</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_PolicyEntries()
	 * @model containment="true"
	 * @generated
	 */
	EList<ThrottlePolicyEntry> getPolicyEntries();

	/**
	 * Returns the value of the '<em><b>Policy Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Configuration</em>' containment reference.
	 * @see #setPolicyConfiguration(ThrottlePolicyConfiguration)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_PolicyConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ThrottlePolicyConfiguration getPolicyConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getPolicyConfiguration <em>Policy Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Configuration</em>' containment reference.
	 * @see #getPolicyConfiguration()
	 * @generated
	 */
	void setPolicyConfiguration(ThrottlePolicyConfiguration value);

	/**
	 * Returns the value of the '<em><b>On Accept Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Accept Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Branch</em>' containment reference.
	 * @see #setOnAcceptBranch(ThrottleOnAcceptBranch)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OnAcceptBranch()
	 * @model containment="true"
	 * @generated
	 */
	ThrottleOnAcceptBranch getOnAcceptBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnAcceptBranch <em>On Accept Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Branch</em>' containment reference.
	 * @see #getOnAcceptBranch()
	 * @generated
	 */
	void setOnAcceptBranch(ThrottleOnAcceptBranch value);

	/**
	 * Returns the value of the '<em><b>On Reject Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Reject Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Branch</em>' containment reference.
	 * @see #setOnRejectBranch(ThrottleOnRejectBranch)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OnRejectBranch()
	 * @model containment="true"
	 * @generated
	 */
	ThrottleOnRejectBranch getOnRejectBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnRejectBranch <em>On Reject Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Branch</em>' containment reference.
	 * @see #getOnRejectBranch()
	 * @generated
	 */
	void setOnRejectBranch(ThrottleOnRejectBranch value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(ThrottleMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ThrottleMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(ThrottleMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(ThrottleMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ThrottleMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(ThrottleMediatorOutputConnector value);

    /**
	 * Returns the value of the '<em><b>On Accept Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Accept Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Output Connector</em>' containment reference.
	 * @see #setOnAcceptOutputConnector(ThrottleMediatorOnAcceptOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OnAcceptOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
    ThrottleMediatorOnAcceptOutputConnector getOnAcceptOutputConnector();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnAcceptOutputConnector <em>On Accept Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Output Connector</em>' containment reference.
	 * @see #getOnAcceptOutputConnector()
	 * @generated
	 */
    void setOnAcceptOutputConnector(ThrottleMediatorOnAcceptOutputConnector value);

    /**
	 * Returns the value of the '<em><b>On Reject Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Reject Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Output Connector</em>' containment reference.
	 * @see #setOnRejectOutputConnector(ThrottleMediatorOnRejectOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OnRejectOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
    ThrottleMediatorOnRejectOutputConnector getOnRejectOutputConnector();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnRejectOutputConnector <em>On Reject Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Output Connector</em>' containment reference.
	 * @see #getOnRejectOutputConnector()
	 * @generated
	 */
    void setOnRejectOutputConnector(ThrottleMediatorOnRejectOutputConnector value);

    /**
	 * Returns the value of the '<em><b>Throttle Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Throttle Container</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Throttle Container</em>' containment reference.
	 * @see #setThrottleContainer(ThrottleContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_ThrottleContainer()
	 * @model containment="true"
	 * @generated
	 */
    ThrottleContainer getThrottleContainer();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getThrottleContainer <em>Throttle Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle Container</em>' containment reference.
	 * @see #getThrottleContainer()
	 * @generated
	 */
    void setThrottleContainer(ThrottleContainer value);

				/**
	 * Returns the value of the '<em><b>On Accept Branchsequence Type</b></em>' attribute.
	 * The default value is <code>"ANONYMOUS"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Accept Branchsequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Branchsequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType
	 * @see #setOnAcceptBranchsequenceType(ThrottleSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OnAcceptBranchsequenceType()
	 * @model default="ANONYMOUS"
	 * @generated
	 */
	ThrottleSequenceType getOnAcceptBranchsequenceType();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnAcceptBranchsequenceType <em>On Accept Branchsequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Branchsequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType
	 * @see #getOnAcceptBranchsequenceType()
	 * @generated
	 */
	void setOnAcceptBranchsequenceType(ThrottleSequenceType value);

				/**
	 * Returns the value of the '<em><b>On Accept Branchsequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Accept Branchsequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Branchsequence Key</em>' containment reference.
	 * @see #setOnAcceptBranchsequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OnAcceptBranchsequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOnAcceptBranchsequenceKey();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnAcceptBranchsequenceKey <em>On Accept Branchsequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Branchsequence Key</em>' containment reference.
	 * @see #getOnAcceptBranchsequenceKey()
	 * @generated
	 */
	void setOnAcceptBranchsequenceKey(RegistryKeyProperty value);

				/**
	 * Returns the value of the '<em><b>On Reject Branchsequence Type</b></em>' attribute.
	 * The default value is <code>"ANONYMOUS"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Reject Branchsequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Branchsequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType
	 * @see #setOnRejectBranchsequenceType(ThrottleSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OnRejectBranchsequenceType()
	 * @model default="ANONYMOUS"
	 * @generated
	 */
	ThrottleSequenceType getOnRejectBranchsequenceType();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnRejectBranchsequenceType <em>On Reject Branchsequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Branchsequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType
	 * @see #getOnRejectBranchsequenceType()
	 * @generated
	 */
	void setOnRejectBranchsequenceType(ThrottleSequenceType value);

				/**
	 * Returns the value of the '<em><b>On Reject Branchsequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Reject Branchsequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Branchsequence Key</em>' containment reference.
	 * @see #setOnRejectBranchsequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleMediator_OnRejectBranchsequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOnRejectBranchsequenceKey();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator#getOnRejectBranchsequenceKey <em>On Reject Branchsequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Branchsequence Key</em>' containment reference.
	 * @see #getOnRejectBranchsequenceKey()
	 * @generated
	 */
	void setOnRejectBranchsequenceKey(RegistryKeyProperty value);

} // ThrottleMediator
