/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.extension.model.impl;

import java.util.Iterator;

import org.eclipse.bpel.common.extension.model.Extension;
import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.extension.model.ExtensionmodelFactory;
import org.eclipse.bpel.common.extension.model.ExtensionmodelPackage;
import org.eclipse.bpel.common.extension.model.adapters.ExtendedObjectUserAdapter;
import org.eclipse.bpel.common.extension.model.adapters.impl.ExtensionMapAdapterImpl;
import org.eclipse.bpel.common.extension.model.util.ExtensionmodelAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtensionmodelFactoryImpl extends EFactoryImpl implements ExtensionmodelFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExtensionmodelPackage.EXTENSION_MAP: return createExtensionMap();
			case ExtensionmodelPackage.EXTENSION: return createExtension();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionMap createExtensionMapGen() {
		ExtensionMapImpl extensionMap = new ExtensionMapImpl();
		return extensionMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension createExtension() {
		ExtensionImpl extension = new ExtensionImpl();
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionmodelPackage getExtensionmodelPackage() {
		return (ExtensionmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExtensionmodelPackage getPackage() {
		return ExtensionmodelPackage.eINSTANCE;
	}

  /**
   * Method findExtensionSet.
   * Given a namespace and the contents of a Resource (as an EList), this
   * method will find the ExtensionMap object for the given namespace.
   * <code>null</code> is returned if one doesn't exists
   * @param namespace - ExtensionMap namespace
   * @param contents - Resource contents
   * @return ExtensionMap
   * @customized
   */
  public ExtensionMap findExtensionMap(String namespace, EList contents) {

	  ExtensionMap extensionSet = null;
		
	  for (Iterator iter = contents.iterator(); iter.hasNext();) {
		  EObject element = (EObject) iter.next();
			
		  if(element instanceof ExtensionMap && ((ExtensionMap)element).getNamespace().equals(namespace)){
			  extensionSet = (ExtensionMap)element;
		  }
			
	  }
		
	  if(extensionSet != null){
		  ExtensionmodelAdapterFactory adapterFactory = new ExtensionmodelAdapterFactory();
		  adapterFactory.adapt(extensionSet,ExtensionMapAdapterImpl.class);
	  }
		
	  return extensionSet;
  }


	/**
	 * @customized
	 */
	public ExtensionMap createExtensionMap() {
		
		ExtensionMap extensionMap = createExtensionMapGen();
		ExtensionmodelAdapterFactory adapterFactory = new ExtensionmodelAdapterFactory();
		adapterFactory.adapt(extensionMap,ExtensionMapAdapterImpl.class);
	
		return extensionMap;
	}
	
  /**
   * Method createExtensionSet.
   * Creates an ExtensionMap object for the given namespace.
   * @param namespace
   * @return ExtensionMap
   * @customized
   */
  public ExtensionMap createExtensionMap(String namespace) {

	  ExtensionMap extensionSet = ExtensionmodelFactory.eINSTANCE.createExtensionMap();
		
	  extensionSet.setNamespace(namespace);
				
	  return extensionSet;
  }


  /**
   * Method adaptEObject.
   * This method associates an adapter to a model object.
   * @param target - object to which the adaptor is to be associated
   * @param adapter - adapter to asociate to target
   * @customized
   */
  public void adaptEObject(EObject target, Adapter adapter) {
		
	  for (Iterator adapters = target.eAdapters().iterator(); adapters.hasNext(); )
	  {
		Adapter currAdapter = (Adapter)adapters.next();
		if (currAdapter.equals(adapter))
		{
		  return;
		}
	  }
		
	 target.eAdapters().add(adapter);
	   
  }
  
	/**
	 * @see org.eclipse.bpel.common.extension.model.ExtensionmodelFactory#findExtensionSets(java.lang.String, org.eclipse.emf.common.util.EList)
	 */
	public EList findExtensionMaps(String namespace, EList contents) {
		EList extensionSetList = new BasicEList();
			
		for (Iterator iter = contents.iterator(); iter.hasNext();) {
			EObject element = (EObject) iter.next();
			
			if(element instanceof ExtensionMap && ((ExtensionMap)element).getNamespace().equals(namespace)){
				extensionSetList.add(element);
				ExtensionmodelAdapterFactory adapterFactory = new ExtensionmodelAdapterFactory();
				adapterFactory.adapt(element,ExtensionMapAdapterImpl.class);
			}
			
		}
		
		return extensionSetList;
	}

	public Adapter getExtensionAdapter(EObject extendedObject, String namespace) {
		
		EList adapterList = extendedObject.eAdapters();
		for (Iterator iter = adapterList.iterator(); iter.hasNext();) {
			Adapter element = (Adapter) iter.next();
			if(element instanceof ExtendedObjectUserAdapter && ((ExtendedObjectUserAdapter)element).getNamespace().equals(namespace)){
				return element;				
			}
		}
		return null;
	}



} //ExtensionmodelFactoryImpl
