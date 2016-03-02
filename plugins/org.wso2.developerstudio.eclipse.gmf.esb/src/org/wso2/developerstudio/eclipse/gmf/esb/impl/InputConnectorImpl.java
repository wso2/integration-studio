/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpointsOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceFaultContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediatorEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediatorOutputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InputConnectorImpl#getIncomingLinks <em>Incoming Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InputConnectorImpl extends EsbConnectorImpl implements InputConnector {
	/**
	 * The cached value of the '{@link #getIncomingLinks() <em>Incoming Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<EsbLink> incomingLinks;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.INPUT_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EsbLink> getIncomingLinks() {
		if (incomingLinks == null) {
			incomingLinks = new EObjectWithInverseResolvingEList<EsbLink>(EsbLink.class, this, EsbPackage.INPUT_CONNECTOR__INCOMING_LINKS, EsbPackage.ESB_LINK__TARGET);
		}
		return incomingLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean shouldConnect(OutputConnector sourceEnd) {
		EObject container = sourceEnd.eContainer();
		/*
		 * Avoid connecting send mediator output connector and endpoint inside the send mediator.  
		 */
		if(sourceEnd instanceof SendMediatorOutputConnector && this.eContainer instanceof EndPoint){
			return false;
		}
		/*
		 * Avoid connecting an endpoint to an element other than Send, Call, Clone mediator and LB, Failover, RecipientList endpoint's output connector.  
		 */
		if (!(sourceEnd instanceof SendMediatorEndpointOutputConnector) && !(sourceEnd instanceof CallMediatorEndpointOutputConnector) && !(sourceEnd instanceof CloneMediatorTargetOutputConnector)
				&& !(sourceEnd instanceof LoadBalanceEndPointOutputConnector) && !(sourceEnd instanceof FailoverEndPointOutputConnector) && !(sourceEnd instanceof RecipientListEndPointOutputConnector)
				&& this.eContainer instanceof EndPoint) {
			return false;
		}
		
		if(!(sourceEnd instanceof SendMediatorOutputConnector) && this instanceof ProxyInSequenceInputConnector){
			return false;
		}
		
		if (this.eContainer.equals(container)) {
			return false;
		} else if(sourceEnd.eContainer() instanceof EndPoint){
/*			if(this.eContainer instanceof EndPoint){
				return false;
			}*/
			if((getIncomingLinks().size() !=0) && (getIncomingLinks().get(0).getSource().eContainer() instanceof EndPoint)){
				if(sourceEnd.equals(getIncomingLinks().get(0).getSource())){
					/* Avoid connecting same nodes multiple times */
					return false;
				}
				return true;
			}
			
		} else if(this.eContainer instanceof EndPoint){
			for (Iterator<EsbLink> i = getIncomingLinks().iterator(); i.hasNext();){
				if(i.next().getSource().equals(sourceEnd)){
					/* Avoid connecting same nodes multiple times */
					return false;
				}
			}
			return true;
		}
		/*
		 * Avoid connecting Proxy/API resource output connector to the mediator in the fault sequence(TOOLS-3081)
		 */
		if((sourceEnd instanceof ProxyOutputConnector || sourceEnd instanceof APIResourceOutputConnector) && this.eContainer.eContainer().eContainer() instanceof ProxyServiceFaultContainer){
			return false;
		}
		// By default we allow only one incoming connection from any source.
		return getIncomingLinks().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.INPUT_CONNECTOR__INCOMING_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingLinks()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.INPUT_CONNECTOR__INCOMING_LINKS:
				return ((InternalEList<?>)getIncomingLinks()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.INPUT_CONNECTOR__INCOMING_LINKS:
				return getIncomingLinks();
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
			case EsbPackage.INPUT_CONNECTOR__INCOMING_LINKS:
				getIncomingLinks().clear();
				getIncomingLinks().addAll((Collection<? extends EsbLink>)newValue);
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
			case EsbPackage.INPUT_CONNECTOR__INCOMING_LINKS:
				getIncomingLinks().clear();
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
			case EsbPackage.INPUT_CONNECTOR__INCOMING_LINKS:
				return incomingLinks != null && !incomingLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InputConnectorImpl
