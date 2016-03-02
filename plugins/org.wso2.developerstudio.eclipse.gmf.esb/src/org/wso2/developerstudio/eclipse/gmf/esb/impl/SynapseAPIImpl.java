/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.APIHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synapse API</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SynapseAPIImpl#getApiName <em>Api Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SynapseAPIImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SynapseAPIImpl#getHostName <em>Host Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SynapseAPIImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SynapseAPIImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SynapseAPIImpl#getHandlers <em>Handlers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SynapseAPIImpl extends EsbElementImpl implements SynapseAPI {
	/**
	 * The default value of the '{@link #getApiName() <em>Api Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiName()
	 * @generated
	 * @ordered
	 */
	protected static final String API_NAME_EDEFAULT = "api_name";

	/**
	 * The cached value of the '{@link #getApiName() <em>Api Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiName()
	 * @generated
	 * @ordered
	 */
	protected String apiName = API_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_EDEFAULT = "/context";

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected String context = CONTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getHostName() <em>Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostName()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostName() <em>Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostName()
	 * @generated
	 * @ordered
	 */
	protected String hostName = HOST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final int PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected int port = PORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<APIResource> resources;

	/**
	 * The cached value of the '{@link #getHandlers() <em>Handlers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandlers()
	 * @generated
	 * @ordered
	 */
	protected EList<APIHandler> handlers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynapseAPIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SYNAPSE_API;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApiName() {
		return apiName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApiName(String newApiName) {
		String oldApiName = apiName;
		apiName = newApiName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SYNAPSE_API__API_NAME, oldApiName, apiName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(String newContext) {
		String oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SYNAPSE_API__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostName(String newHostName) {
		String oldHostName = hostName;
		hostName = newHostName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SYNAPSE_API__HOST_NAME, oldHostName, hostName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(int newPort) {
		int oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SYNAPSE_API__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<APIResource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<APIResource>(APIResource.class, this, EsbPackage.SYNAPSE_API__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<APIHandler> getHandlers() {
		if (handlers == null) {
			handlers = new EObjectContainmentEList<APIHandler>(APIHandler.class, this, EsbPackage.SYNAPSE_API__HANDLERS);
		}
		return handlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SYNAPSE_API__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case EsbPackage.SYNAPSE_API__HANDLERS:
				return ((InternalEList<?>)getHandlers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.SYNAPSE_API__API_NAME:
				return getApiName();
			case EsbPackage.SYNAPSE_API__CONTEXT:
				return getContext();
			case EsbPackage.SYNAPSE_API__HOST_NAME:
				return getHostName();
			case EsbPackage.SYNAPSE_API__PORT:
				return getPort();
			case EsbPackage.SYNAPSE_API__RESOURCES:
				return getResources();
			case EsbPackage.SYNAPSE_API__HANDLERS:
				return getHandlers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.SYNAPSE_API__API_NAME:
				setApiName((String)newValue);
				return;
			case EsbPackage.SYNAPSE_API__CONTEXT:
				setContext((String)newValue);
				return;
			case EsbPackage.SYNAPSE_API__HOST_NAME:
				setHostName((String)newValue);
				return;
			case EsbPackage.SYNAPSE_API__PORT:
				setPort((Integer)newValue);
				return;
			case EsbPackage.SYNAPSE_API__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends APIResource>)newValue);
				return;
			case EsbPackage.SYNAPSE_API__HANDLERS:
				getHandlers().clear();
				getHandlers().addAll((Collection<? extends APIHandler>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.SYNAPSE_API__API_NAME:
				setApiName(API_NAME_EDEFAULT);
				return;
			case EsbPackage.SYNAPSE_API__CONTEXT:
				setContext(CONTEXT_EDEFAULT);
				return;
			case EsbPackage.SYNAPSE_API__HOST_NAME:
				setHostName(HOST_NAME_EDEFAULT);
				return;
			case EsbPackage.SYNAPSE_API__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case EsbPackage.SYNAPSE_API__RESOURCES:
				getResources().clear();
				return;
			case EsbPackage.SYNAPSE_API__HANDLERS:
				getHandlers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.SYNAPSE_API__API_NAME:
				return API_NAME_EDEFAULT == null ? apiName != null : !API_NAME_EDEFAULT.equals(apiName);
			case EsbPackage.SYNAPSE_API__CONTEXT:
				return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
			case EsbPackage.SYNAPSE_API__HOST_NAME:
				return HOST_NAME_EDEFAULT == null ? hostName != null : !HOST_NAME_EDEFAULT.equals(hostName);
			case EsbPackage.SYNAPSE_API__PORT:
				return port != PORT_EDEFAULT;
			case EsbPackage.SYNAPSE_API__RESOURCES:
				return resources != null && !resources.isEmpty();
			case EsbPackage.SYNAPSE_API__HANDLERS:
				return handlers != null && !handlers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (apiName: ");
		result.append(apiName);
		result.append(", context: ");
		result.append(context);
		result.append(", hostName: ");
		result.append(hostName);
		result.append(", port: ");
		result.append(port);
		result.append(')');
		return result.toString();
	}

} //SynapseAPIImpl
