/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.factories;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.ui.Policy;
import org.eclipse.bpel.ui.bpelactions.AbstractBPELAction;
import org.eclipse.bpel.ui.extensions.ActionDescriptor;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.extensions.UIObjectFactoryDescriptor;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EClass;


/**
 * A factory provider for BPEL model objects and other model objects used within the
 * BPEL editor.
 */
public class UIObjectFactoryProvider {

    private static UIObjectFactoryProvider instance;
	protected Map<EClass,AbstractUIObjectFactory> eClass2factory = new HashMap<EClass,AbstractUIObjectFactory>();
	
	/**
	 * @return the instance
	 */
	
	public static UIObjectFactoryProvider getInstance() {
	    if (instance == null) {
		    instance = new UIObjectFactoryProvider();
		    createUIObjectFactories(instance);
	    }
	    return instance;
	}
	
	protected static void createUIObjectFactories (UIObjectFactoryProvider provider) {
		// TODO: temporary HACK!
		for (EClass modelType : BPELUIObjectFactory.classArray) {
			provider.register(modelType, new BPELUIObjectFactory(modelType));
		}

		// TODO: this is even worse
//		for (int i = 0; i<BPELUIObjectFactory.bpelPlusClassArray.length; i++) {
//			EClass modelType = BPELUIObjectFactory.bpelPlusClassArray[i];
//			provider.register(modelType, new BPELUIObjectFactory(modelType));
//		}
		
		
		
		// List of extension ui object factories factories 
		UIObjectFactoryDescriptor[] factories = BPELUIRegistry.getInstance().getUIObjectFactoryDescriptors();
		
		// loop over List of extension ui object factories
		for (int i = 0; i < factories.length; i++) {
		    
		    // get the extension ui object factory
		    AbstractUIObjectFactory factory = factories[i].getFactory();
            
		    // get the classes for which the extension ui object factory is responsible
		    EClass[] classArray = ((IExtensionUIObjectFactory)factory).getClassArray();
		    
		    // get the configuration element of the extension ui object factory
		    IConfigurationElement factConfigElement = factories[i].getConfigElement();

		    // loop over classes for which the extension ui object factory is responsible
		    for (int j = 0; j < classArray.length; j++) {
		        // get the class name 
				EClass modelType = classArray[j];		
				IExtensionUIObjectFactory fact = null;
				try {
				    // create a extension ui object factory
                    fact = (IExtensionUIObjectFactory)factConfigElement. createExecutableExtension("class");
                    // set the class for which the factory is responsible
                    fact.setModelType(modelType);
                } catch (CoreException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
				
                // register the factory
				provider.register(modelType, (AbstractUIObjectFactory)fact);
			}
        }
		
		
		
		// TODO: We are currently overwritting the ones already provided above.
		// We should change that so that we do not create the ones for action twice.
		// (i.e. we should not use BPELUIObjectFactory.classArray neither BPELUIObjectFactory.bpelPlusClassArray		

		for(ActionDescriptor descriptor : BPELUIRegistry.getInstance().getActionDescriptors() ) {
            AbstractBPELAction action = descriptor.getAction();
            if (action != null) {
            	provider.register(action.getModelType(), new ActionUIObjectFactory(action));
            }
        }
	}
	
	/**
	 * 
	 * @param modelType
	 * @return the UI Object factory for the given model type.
	 */
	
	public AbstractUIObjectFactory getFactoryFor (EClass modelType) {
		return  eClass2factory.get(modelType);
	}
	
	/**
	 * @param modelType
	 * @param factory
	 */
	
	public void register (EClass modelType, AbstractUIObjectFactory factory) {
		Assert.isTrue(factory.getModelType() == modelType);
		
		eClass2factory.put(modelType, factory);
		if (Policy.DEBUG) {
			System.out.println("BPELUIObjectFactoryProvider registering EClass: "+modelType.getInstanceClassName()); //$NON-NLS-1$
		}
	}
}
