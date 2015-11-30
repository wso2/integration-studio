/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.EndpointReferenceRole;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Part;

/**
 * A way to look at a copy rule side (either LHS or RHS).
 * 
 * An adapter for To and From  in our model which helps to dissolve the 
 * To/From model dependency that currently exists. 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 11, 2007
 *
 */

public interface IVirtualCopyRuleSide {
	
	
	/**
	 * 
	 * @return The variable of the copy rule side
	 */
	public Variable getVariable();
	
	/**
	 * Set the variable of the side to the variable passed.
	 * @param aModel the variable
	 */
	
	void setVariable ( Variable aModel ) ;
	
	/**
	 * Get the property.
	 * @return the property
	 */
	public Property getProperty ();
	
	/**
	 * Set property
	 * @param property the property to set
	 */
	public void setProperty (Property property);
	
	/**
	 * Get the part of the message
	 * @return the part of the message
	 */
	public Part getPart ();
	
	/**
	 * Set the part of the message
	 * @param part
	 */
	
	public void setPart ( Part part );
	
	/**
	 * Get the query
	 * @return the query
	 */
	public Query getQuery ();
	
	/**
	 * Set the query
	 * @param query
	 */
	public void setQuery (Query query) ;
	
	
	/**
	 * Get the partner link
	 * @return the partner link
	 */
	public PartnerLink getPartnerLink () ;
	
	/**
	 * Set the partner link
	 * @param pl the partner link
	 */
	public void setPartnerLink ( PartnerLink pl );
	
	/**
	 * Get the endpoint reference
	 * @return the endpoint reference
	 */
	public EndpointReferenceRole getEndpointReference ();
	
	/**
	 * Set the endpoint reference role.
	 * @param role
	 */
	
	public void setEndpointReference ( EndpointReferenceRole role );
	
	/**
	 * 
	 * @return the expression associated with this Copy Rule side.
	 */
	public Expression getExpression ();
	
	
	/**
	 * Set the expression associated with this copy rule side.
	 * @param expression
	 */
	
	public void setExpression (Expression expression);
	
	
	
	/**
	 * Return the target of this virtual copy rule (it is either a to or a from)
	 *  
	 * @return target of the virtual copy rule side
	 */
	public EObject getCopyRuleSide ();
	
	
	
	/** 
	 * Answer true of this copy rule side represents a From, which is a the source of the
	 * assignment.
	 * 
	 * Otherwise, it is a target
	 * 
	 * @return true if source, false otherwise.
	 */
	
	public boolean isSource () ;
	
	
}


