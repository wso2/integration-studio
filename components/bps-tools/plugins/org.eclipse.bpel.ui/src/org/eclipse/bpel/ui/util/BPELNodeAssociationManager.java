/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;

import org.eclipse.wst.wsdl.ui.internal.util.NodeAssociationManager;
import org.eclipse.wst.wsdl.ui.internal.extensions.INodeAssociationProvider;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BPELNodeAssociationManager extends NodeAssociationManager {
	protected INodeAssociationProvider wsdlProvider;
	protected INodeAssociationProvider xsdProvider;
	
	public BPELNodeAssociationManager() {             
		//FIXME init bpelProvider here
		super();
	}        

	@Override
	protected INodeAssociationProvider getAppicableProvider(Object object) {
		//FIXME add code for returning bpelProvider here
		return super.getAppicableProvider(object);
	}
    
	@Override
	public Object getModelObjectForNode(Object rootObject, Element targetNode) {
		//FIXME try super; delete is super is OK
		return super.getModelObjectForNode(rootObject, targetNode);
	}

	@Override
	public Node getNode(Object modelObject) {
		//FIXME try super; delete is super is OK
		return super.getNode(modelObject);
	}
	
	@Override
	protected Element[] getParentElementChain(Element element) {
		//FIXME try super; delete is super is OK
		return super.getParentElementChain(element);
	}
}
