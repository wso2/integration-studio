/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregate Mediator Input Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AggregateMediatorInputConnectorImpl extends InputConnectorImpl implements AggregateMediatorInputConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregateMediatorInputConnectorImpl() {
		super();
	}
	

/*	public boolean shouldConnect(OutputConnector sourceEnd) {
		EObject container = sourceEnd.eContainer();
		if(container instanceof AggregateMediator){
			if(this.eContainer.equals(container)){
				return false;
			}
		}
		enable multiple input links 
		return true;
	}*/

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.AGGREGATE_MEDIATOR_INPUT_CONNECTOR;
	}

} //AggregateMediatorInputConnectorImpl
