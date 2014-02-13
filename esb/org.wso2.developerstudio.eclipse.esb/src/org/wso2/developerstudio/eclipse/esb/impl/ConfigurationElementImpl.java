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

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.wso2.developerstudio.eclipse.esb.Comment;
import org.wso2.developerstudio.eclipse.esb.ConfigurationElement;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ConfigurationElementImpl extends ModelObjectImpl implements ConfigurationElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationElementImpl() {
		super();
	}

	
	protected void doLoad(Element self) throws Exception {
/*		int realCount=0;
		for (int i=0;i<self.getChildNodes().getLength();++i){
			if(self.getChildNodes().item(i) instanceof org.w3c.dom.Comment){
				Comment newComment= getEsbFactory().createComment();
				newComment.setValue(((org.w3c.dom.Comment)self.getChildNodes().item(i)).getTextContent());
				newComment.setPosition(realCount);
				getComment().add(newComment);				
			}
			++realCount;
			
			 * There is '#text' element in between actual elements.These elements should be avoid when we count.  
			 
			if(self.getChildNodes().item(i).getNodeName().equals("#text")){
				--realCount;
			}
		}	*/
		super.doLoad(self);
	}
	

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CONFIGURATION_ELEMENT;
	}

} //ConfigurationElementImpl
