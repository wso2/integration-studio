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
package org.eclipse.bpel.ui.details.providers;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.ui.details.tree.ITreeNode;
import org.eclipse.bpel.ui.details.tree.PartnerLinkTreeNode;
import org.eclipse.bpel.ui.details.tree.PartnerLinkTypeTreeNode;
import org.eclipse.bpel.ui.details.tree.PortTypeTreeNode;
import org.eclipse.bpel.ui.util.ListMap;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.PortType;


/**
 * Provides a tree of model objects representing some expansion of the underlying graph
 * of model objects whose roots are the Variables of a Process. 
 */
public class PartnerLinkTypeTreeContentProvider extends ModelTreeContentProvider {

	boolean isPropertyTree;
	private CompositeContentProvider fContentProvider;	
	
	
	public PartnerLinkTypeTreeContentProvider( boolean isCondensed ) {
		super(isCondensed);
		
		fContentProvider = new CompositeContentProvider ();
		fContentProvider.add ( new PartnerLinkTypeContentProvider() );
		fContentProvider.add ( new PortTypeContentProvider() );	
		
	}

	public boolean isPropertyTree() { return isPropertyTree; }

	
	
	@Override
	public Object[] primGetElements (Object inputElement) {
		
		ITreeNode result = getTreeNode ( inputElement );
		if (result != null) {
			return new Object[] { result } ;
		}
		
		
		if (inputElement instanceof Definition) {									
			
			return (Object[]) ListMap.Map ( 
					fContentProvider.getElements( inputElement ) ,						
					new ListMap.Visitor () {		
						public Object visit (Object obj) {
							Object r = getTreeNode ( obj );
							return (r == null ? ListMap.IGNORE : r );
						}					
					},
					EMPTY_ARRAY );							
		}
		
		return EMPTY_ARRAY;
	}
	
	
	ITreeNode getTreeNode ( Object inputElement ) {
		
		if (inputElement instanceof PartnerLinkType) {
			return	new PartnerLinkTypeTreeNode ((PartnerLinkType)inputElement,isCondensed);
		}
		
		if (inputElement instanceof PortType) {
			return new PortTypeTreeNode ((PortType) inputElement,isCondensed);
		}
		
		if (inputElement instanceof PartnerLink) {
			return new PartnerLinkTreeNode ((PartnerLink) inputElement, isCondensed );
		}
		
		return null;
		
	}
}