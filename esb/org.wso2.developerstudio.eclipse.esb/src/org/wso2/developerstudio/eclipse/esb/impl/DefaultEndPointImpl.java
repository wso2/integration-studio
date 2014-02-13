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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultEndPointImpl extends AbstractDefaultEndPointImpl implements DefaultEndPoint {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 */
    protected DefaultEndPointImpl() {
		super();
		
		// Reliable messaging policy key.
		RegistryKeyProperty rmPolicyKey = getEsbFactory().createRegistryKeyProperty();
		rmPolicyKey.setPrettyName("Select RM Policy");
		rmPolicyKey.setKeyName("policy");
		rmPolicyKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setReliableMessagingPolicy(rmPolicyKey);

		// Security policy key.
		RegistryKeyProperty securityPolicyKey = getEsbFactory().createRegistryKeyProperty();
		securityPolicyKey.setPrettyName("Select Security Policy");
		securityPolicyKey.setKeyName("policy");
		securityPolicyKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setSecurityPolicy(securityPolicyKey);
	}

    /**
     * {@inheritDoc}
     */
    public void doLoad(Element self) throws Exception {
	    super.doLoad(self);
	    
	    // Get the <default/> element.
	    Element defaultElem = getChildElement(self, "default");
	    
	    // Delegate.
	    loadContent(defaultElem);
    }

    /**
     * {@inheritDoc}
     */
    public Element doSave(Element parent) throws Exception {
	    Element self = super.doSave(parent);
	    
	    // Create the <default/> element.
	    Element defaultElem = createChildElement(self, "default");
	    
	    // Delegate.
	    storeContent(defaultElem);
	    
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
		return EsbPackage.Literals.DEFAULT_END_POINT;
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //DefaultEndPointImpl
