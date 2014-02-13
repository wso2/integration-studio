/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getIterateID <em>Iterate ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isSequentialMediation <em>Sequential Mediation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isContinueParent <em>Continue Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isPreservePayload <em>Preserve Payload</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getIterateExpression <em>Iterate Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getAttachPath <em>Attach Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getIterateMediator()
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getIterateMediator_IterateID()
	 * @model
	 * @generated
	 */
	String getIterateID();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getIterateID <em>Iterate ID</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getIterateMediator_SequentialMediation()
	 * @model
	 * @generated
	 */
	boolean isSequentialMediation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isSequentialMediation <em>Sequential Mediation</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getIterateMediator_ContinueParent()
	 * @model
	 * @generated
	 */
	boolean isContinueParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isContinueParent <em>Continue Parent</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getIterateMediator_PreservePayload()
	 * @model
	 * @generated
	 */
	boolean isPreservePayload();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isPreservePayload <em>Preserve Payload</em>}' attribute.
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
	 * If the meaning of the '<em>Iterate Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterate Expression</em>' containment reference.
	 * @see #setIterateExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getIterateMediator_IterateExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getIterateExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getIterateExpression <em>Iterate Expression</em>}' containment reference.
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
	 * If the meaning of the '<em>Attach Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attach Path</em>' containment reference.
	 * @see #setAttachPath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getIterateMediator_AttachPath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getAttachPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getAttachPath <em>Attach Path</em>}' containment reference.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getIterateMediator_Target()
	 * @model containment="true"
	 * @generated
	 */
	IterateTarget getTarget();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(IterateTarget value);

} // IterateMediator
