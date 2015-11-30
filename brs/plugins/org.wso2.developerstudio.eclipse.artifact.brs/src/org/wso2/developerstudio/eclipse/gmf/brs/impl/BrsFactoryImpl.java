/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.brs.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.wso2.developerstudio.eclipse.gmf.brs.BrsFactory;
import org.wso2.developerstudio.eclipse.gmf.brs.BrsPackage;
import org.wso2.developerstudio.eclipse.artifact.brs.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.brs.impl.RegistryKeyPropertyImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BrsFactoryImpl extends EFactoryImpl implements BrsFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BrsFactory init() {
		try {
			BrsFactory theEsbFactory = (BrsFactory)EPackage.Registry.INSTANCE.getEFactory(BrsPackage.eNS_URI);
			if (theEsbFactory != null) {
				return theEsbFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BrsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BrsFactoryImpl() {
		super();
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty createRegistryKeyProperty() {
		RegistryKeyPropertyImpl registryKeyProperty = new RegistryKeyPropertyImpl();
		return registryKeyProperty;
	}


} 
