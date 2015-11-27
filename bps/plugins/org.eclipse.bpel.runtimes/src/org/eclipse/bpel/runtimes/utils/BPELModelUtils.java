/*******************************************************************************
 * Copyright (c) 2006, 2012 University College London Software Systems Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Bruno Wassermann - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes.utils;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Scope;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

/**
 * A bunch of helper methods to support runtime providers get data from the 
 * BPEL model. 
 *
 * @author Bruno Wassermann, written 11 May 2007
 */
public class BPELModelUtils {

	/**
	 * Return an <code>EList</code> containing all partnerLink elements defined
	 * on Scopes in this process.
	 * 
	 * @param process <code>EObject</code> representing the Process element
	 * @return <code>EList</code> containing all <code>PartnerLink</code>s 
	 * defined on any Scopes (or none)
	 */
	public static EList<PartnerLink> getScopePartnerLinks(final EObject process) {
		TreeIterator<EObject> contents = process.eAllContents();
		EList<PartnerLink> results = new BasicEList<PartnerLink>();
		
		while (contents.hasNext()) {
			EObject obj = contents.next();
			
			if (obj instanceof Scope) {
				results.addAll(((Scope) obj).getPartnerLinks().getChildren());
			}	
		}
		return results;
	}
}
