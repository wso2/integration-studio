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
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Part;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 11, 2007
 *
 */
// Bugzilla 330519
public class FromAdapter extends MarkerDelegateAdapter implements IVirtualCopyRuleSide {

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#getEndpointReference()
	 */
	public EndpointReferenceRole getEndpointReference() {
		From from = getTarget(null, From.class);
		return from.getEndpointReference();		
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#getPart()
	 */
	public Part getPart() {
		From from = getTarget(null, From.class);
		return from.getPart();
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#getPartnerLink()
	 */
	public PartnerLink getPartnerLink() {
		From from = getTarget(null, From.class);
		return from.getPartnerLink();
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#getProperty()
	 */
	public Property getProperty() {
		From from = getTarget(null, From.class);
		return from.getProperty();
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#getQuery()
	 */
	public Query getQuery() {
		From from = getTarget(null, From.class);
		return from.getQuery();
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#getVariable()
	 */
	public Variable getVariable() {
		From from = getTarget(null, From.class);
		return from.getVariable();
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#setEndpointReference(org.eclipse.bpel.model.EndpointReferenceRole)
	 */
	public void setEndpointReference(EndpointReferenceRole role) {			
		From from = getTarget(null, From.class);
		from.setEndpointReference(role);
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#setPart(org.eclipse.wst.wsdl.Part)
	 */
	public void setPart(Part part) {
		From from = getTarget(null, From.class);
		from.setPart(part);				
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#setPartnerLink(org.eclipse.bpel.model.PartnerLink)
	 */
	public void setPartnerLink(PartnerLink pl) {
		From from = getTarget(null, From.class);
		from.setPartnerLink(pl);		
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#setProperty(org.eclipse.bpel.model.messageproperties.Property)
	 */
	public void setProperty(Property property) {
		From from = getTarget(null, From.class);
		from.setProperty(property);				
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#setQuery(org.eclipse.bpel.model.Query)
	 */
	public void setQuery(Query query) {
		From from = getTarget(null, From.class);
		from.setQuery(query);				
		
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#setVariable(org.eclipse.bpel.model.Variable)
	 */
	public void setVariable(Variable aModel) {
		From from = getTarget(null, From.class);
		from.setVariable(aModel);				
	}
	
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#getExpression()
	 */
	
	public Expression getExpression () {
		From from = getTarget(null,From.class);
		return from.getExpression();
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#setExpression(org.eclipse.bpel.model.Expression)
	 */
	public void setExpression (Expression expression) {
		From from = getTarget(null,From.class);
		from.setExpression(expression);
	}
	

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#getCopyRuleSide()
	 */
	public EObject getCopyRuleSide() {
		return getTarget(null,From.class);
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide#isSource()
	 */
	public boolean isSource() {
		return true;
	}

}
