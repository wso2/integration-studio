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

package org.eclipse.bpel.ui.details.providers;

import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.details.tree.ITreeNode;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;


/**
 * Filter which excludes from a set of Variables those variables whose
 * types do not match the appropriate settings in the filter. 
 */ 

public class VariableFilter extends ViewerFilter
	implements IFilter
{
	
	Message fMessage;
	XSDElementDeclaration fElementDeclaration;
	XSDTypeDefinition fTypeDefinition;
	
	/**
	 * Brand new shiny variable filter.
	 */
	public VariableFilter () {
		
	}
	
	/**
	 * Clear the filter
	 */
	
	public void clear () {
		fMessage = null;
		fElementDeclaration = null;
		fTypeDefinition = null;		
	}
	
	/**
	 * Set type of filter to be the message msg
	 * @param msg the message
	 */
	public void setType ( Message msg ) {
		fMessage = msg;
	}
	
	/**
	 * Set the type of filter to be this element declaration.
	 * @param decl
	 */
	public void setType ( XSDElementDeclaration decl ) {
		fElementDeclaration = decl;
	}
	
	/**
	 * Set this type of filter to be type definition.
	 * @param typeDef
	 */
	public void setType ( XSDTypeDefinition typeDef) {
		fTypeDefinition = typeDef;
	}
	
	/**
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select (Viewer viewer, Object parentElement, Object element) {
		
		if (element instanceof ITreeNode) {
			return select ( ((ITreeNode)element).getModelObject() );			
		}
		return select ( element );
	}

	/** 
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	
	public boolean select (Object toTest) {

		if (toTest == null) {
			return false;
		}
		
				
		if ( Variable.class.isInstance(toTest) ) {
			
			Variable v = (Variable) toTest;
			
			if (fMessage == null && fElementDeclaration == null && fTypeDefinition == null) {
				return true;
			}
			
			if (fMessage != null) {
				
				if (fMessage.equals ( v.getMessageType() )) {
					return true;
				}
				
				if (fMessage.getEParts().size() == 1) {				
					Part part = (Part) fMessage.getEParts().get(0);
					XSDElementDeclaration decl = part.getElementDeclaration();
					if (decl != null && decl.equals( v.getXSDElement() )) {
						return true;
					}
				}
				
			}
			
			if (fElementDeclaration != null) {
				if (fElementDeclaration.equals( v.getXSDElement() )) {
					return true;
				}
			}
			
			
			if (fTypeDefinition != null) {
				if (fTypeDefinition.equals( v.getType() )) {
					return true;
				}				
			}
		
			return false;			
		}
		
		return true;
	}
	
	
}
