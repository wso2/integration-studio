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
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.ServiceRef;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;

/**
 * An AssignCategory for editing an EndpointReference.  This is a special type of
 * literal (though it is recognized by the deserializer, and represented in the model
 * as an EndpointReference object rather than as a literal).
 */
public class EndpointReferenceAssignCategory extends AssignCategoryBase {

	protected int lastChangeContext = -1;

	protected EndpointReferenceAssignCategory (BPELPropertySection ownerSection ) {
		super( ownerSection );		
	}

	protected class ContextModifyListener implements ModifyListener {
		int fContext;		
		/**
		 * Brand new shiny ContextModifyListener.
		 * @param context
		 */
		public ContextModifyListener(int context) {
			this.fContext = context;
		}
		/**
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		public void modifyText(ModifyEvent e) {
			lastChangeContext = fContext;
		}
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getName()
	 */
	@Override
	public String getName() { 
		return Messages.EndpointReferenceAssignCategory_Endpoint_Reference; 
	} 

	@Override
	protected void createClient2(Composite parent) {
		// TODO: Delegate to the endpoint handler to create the widgets
	}	

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isCategoryForModel (EObject aModel) {
		From from = BPELUtil.adapt(aModel, From.class);
		return from != null && from.getServiceRef() != null;
	}
	
	
	@SuppressWarnings("nls")
	@Override
	protected void load (IVirtualCopyRuleSide aModel) {
		
		// TODO: Delegate to the endpoint handler to populate the widgets
		// From from = BPELUtil.adapt(aModel.getCopyRuleSide(), From.class);
	}

	@SuppressWarnings("nls")
	@Override
	protected void store (IVirtualCopyRuleSide aModel) {
		From from = BPELUtil.adapt(aModel.getCopyRuleSide(), From.class); 			
		
		ServiceRef serviceRef = from.getServiceRef();  
		if (serviceRef == null) {
			serviceRef = BPELFactory.eINSTANCE.createServiceRef();
			from.setServiceRef(serviceRef);
		}
		// TODO: Delegate to the endpoint handler to store the endpoint
		// into the ServiceRef.
	}
}
