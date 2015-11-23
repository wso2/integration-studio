/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.ecore.EClass;

import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default End Point Input Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultEndPointInputConnectorImpl extends InputConnectorImpl implements DefaultEndPointInputConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultEndPointInputConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.DEFAULT_END_POINT_INPUT_CONNECTOR;
	}
	
	
/*	public boolean shouldConnect(OutputConnector sourceEnd) {
		// making endpoint usable by more than one sequence
		return true;
	}*/

} //DefaultEndPointInputConnectorImpl
