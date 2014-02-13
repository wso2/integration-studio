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
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleOutMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Autoscale Out Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AutoscaleOutMediatorImpl extends MediatorImpl implements AutoscaleOutMediator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AutoscaleOutMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc} 
	 */
	protected void doLoad(Element self) throws Exception {
		// TODO Auto-generated method stub
		super.doLoad(self);
		
	}

	/**
	 * {@inheritDoc} 
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self=createChildElement(parent,"autoscaleOut");
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.AUTOSCALE_OUT_MEDIATOR;
	}

	
    public Map<String, ObjectValidator> validate() {
	    return new HashMap<String, ObjectValidator>();
    }

} //AutoscaleOutMediatorImpl
