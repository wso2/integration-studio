/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.model.dd;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isActive <em>Active</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isRetired <em>Retired</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isInMemory <em>In Memory</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProcessEvents <em>Process Events</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProvide <em>Provide</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getMexInterceptors <em>Mex Interceptors</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getBpel11wsdlFileName <em>Bpel11wsdl File Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getBamServerProfiles <em>Bam Server Profiles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType()
 * @model extendedMetaData="name='process_._type' kind='elementOnly'"
 * @generated
 */
public interface ProcessType extends EObject {
	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Active flag, if set process will be activated once
	 *                                     deployed. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #isSetActive()
	 * @see #unsetActive()
	 * @see #setActive(boolean)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Active()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='active' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isSetActive()
	 * @see #unsetActive()
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActive()
	 * @see #isActive()
	 * @see #setActive(boolean)
	 * @generated
	 */
	void unsetActive();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isActive <em>Active</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Active</em>' attribute is set.
	 * @see #unsetActive()
	 * @see #isActive()
	 * @see #setActive(boolean)
	 * @generated
	 */
	boolean isSetActive();

	/**
	 * Returns the value of the '<em><b>Retired</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Retired flag, if set process will be retired once
	 *                                     deployed. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Retired</em>' attribute.
	 * @see #isSetRetired()
	 * @see #unsetRetired()
	 * @see #setRetired(boolean)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Retired()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='retired' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isRetired();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isRetired <em>Retired</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retired</em>' attribute.
	 * @see #isSetRetired()
	 * @see #unsetRetired()
	 * @see #isRetired()
	 * @generated
	 */
	void setRetired(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isRetired <em>Retired</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRetired()
	 * @see #isRetired()
	 * @see #setRetired(boolean)
	 * @generated
	 */
	void unsetRetired();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isRetired <em>Retired</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Retired</em>' attribute is set.
	 * @see #unsetRetired()
	 * @see #isRetired()
	 * @see #setRetired(boolean)
	 * @generated
	 */
	boolean isSetRetired();

	/**
	 * Returns the value of the '<em><b>In Memory</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Should the process be persistent or only execute
	 *                                     in-memory.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>In Memory</em>' attribute.
	 * @see #isSetInMemory()
	 * @see #unsetInMemory()
	 * @see #setInMemory(boolean)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_InMemory()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='in-memory' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isInMemory();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isInMemory <em>In Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Memory</em>' attribute.
	 * @see #isSetInMemory()
	 * @see #unsetInMemory()
	 * @see #isInMemory()
	 * @generated
	 */
	void setInMemory(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isInMemory <em>In Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInMemory()
	 * @see #isInMemory()
	 * @see #setInMemory(boolean)
	 * @generated
	 */
	void unsetInMemory();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isInMemory <em>In Memory</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>In Memory</em>' attribute is set.
	 * @see #unsetInMemory()
	 * @see #isInMemory()
	 * @see #setInMemory(boolean)
	 * @generated
	 */
	boolean isSetInMemory();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                     A user-defined property that will be attached to a process upon
	 *                                     deployment.
	 *                                 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Property()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PropertyType> getProperty();

	/**
	 * Returns the value of the '<em><b>Process Events</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Events</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Events</em>' containment reference.
	 * @see #setProcessEvents(TProcessEvents)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_ProcessEvents()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='process-events' namespace='##targetNamespace'"
	 * @generated
	 */
	TProcessEvents getProcessEvents();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProcessEvents <em>Process Events</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Events</em>' containment reference.
	 * @see #getProcessEvents()
	 * @generated
	 */
	void setProcessEvents(TProcessEvents value);

	/**
	 * Returns the value of the '<em><b>Provide</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provide</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provide</em>' containment reference list.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Provide()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='provide' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TProvide> getProvide();

	/**
	 * Returns the value of the '<em><b>Invoke</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invoke</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invoke</em>' containment reference list.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Invoke()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='invoke' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TInvoke> getInvoke();

	/**
	 * Returns the value of the '<em><b>Mex Interceptors</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                     List of message exchange interceptors that should be registered for this process.
	 *                                 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mex Interceptors</em>' containment reference.
	 * @see #setMexInterceptors(MexInterceptorsType)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_MexInterceptors()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='mex-interceptors' namespace='##targetNamespace'"
	 * @generated
	 */
	MexInterceptorsType getMexInterceptors();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getMexInterceptors <em>Mex Interceptors</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mex Interceptors</em>' containment reference.
	 * @see #getMexInterceptors()
	 * @generated
	 */
	void setMexInterceptors(MexInterceptorsType value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Process type -- indicates which process defintion should be used
	 *                                     for the process.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(QName)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='element' name='type' namespace='##targetNamespace'"
	 * @generated
	 */
	QName getType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(QName value);

	/**
	 * Returns the value of the '<em><b>Bpel11wsdl File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                 Allows you to specify a WSDL for BPEL 1.1 processes which do not support an "import" element.
	 *                                 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bpel11wsdl File Name</em>' attribute.
	 * @see #setBpel11wsdlFileName(String)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Bpel11wsdlFileName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='bpel11wsdlFileName'"
	 * @generated
	 */
	String getBpel11wsdlFileName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getBpel11wsdlFileName <em>Bpel11wsdl File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bpel11wsdl File Name</em>' attribute.
	 * @see #getBpel11wsdlFileName()
	 * @generated
	 */
	void setBpel11wsdlFileName(String value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_FileName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fileName'"
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(QName)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	QName getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(QName value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(org.eclipse.bpel.model.Process)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_Model()
	 * @model transient="true"
	 * @generated
	 */
	org.eclipse.bpel.model.Process getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(org.eclipse.bpel.model.Process value);

	/**
	 * Returns the value of the '<em><b>Bam Server Profiles</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bam Server Profiles</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bam Server Profiles</em>' containment reference.
	 * @see #setBamServerProfiles(TBamServerProfiles)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getProcessType_BamServerProfiles()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='bamServerProfiles' namespace='##targetNamespace'"
	 * @generated
	 */
	TBamServerProfiles getBamServerProfiles();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getBamServerProfiles <em>Bam Server Profiles</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bam Server Profiles</em>' containment reference.
	 * @see #getBamServerProfiles()
	 * @generated
	 */
	void setBamServerProfiles(TBamServerProfiles value);

} // ProcessType
