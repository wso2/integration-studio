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
package org.eclipse.bpel.ui.commands;

import java.util.List;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;

/** 
 * Sets the "partnerLink" property of a model object.  This is supported
 * for Invoke/Receive/Reply activities.
 */
public class SetPartnerLinkCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_SELECT_PARTNERLINK; }

	public SetPartnerLinkCommand(EObject target, PartnerLink newPartnerLink)  {
		super(target, newPartnerLink);
	}

	@Override
	public Object get() {
		return ModelHelper.getPartnerLink(fTarget);
	}
	@Override
	public void set(Object o) {
	    PartnerLink pl = (PartnerLink)o;
		ModelHelper.setPartnerLink(fTarget, pl);
		
		Operation operation = null;
		
		if (pl != null) {
			PortType pt = null;
		    if (pl.getMyRole() != null){
		        pt = ModelHelper.getRolePortType(pl.getMyRole());	      
		    } else if (pl.getPartnerRole() != null){
		       pt = ModelHelper.getRolePortType(pl.getPartnerRole());
		    }
		    
		    if (pt != null){
		        List<Operation> ops = pt.getOperations();
		        if (ops.size() > 0) operation = ops.get(0);
		    }
		}
		// Not sure why we set an operation here.
		
        ModelHelper.setOperation(fTarget, operation);
	}
}
