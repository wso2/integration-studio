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

import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.util.WSDLResourceImpl;

/**
 * Content provider for Properties (NOT PropertyAliases!).
 * 
 * Expects a CorrelationSet, Definition or Process as input.
 */
public class PropertyContentProvider extends AbstractContentProvider {

	@Override
	public void collectElements(Object input, List list)  {
		
		if (input instanceof CorrelationSet) {
			CorrelationSet cs = (CorrelationSet) input;
			list.addAll( cs.getProperties() );			
		} else if (input instanceof Definition) {
			Definition def = (Definition)input;
			for (Iterator it = def.getEExtensibilityElements().iterator(); it.hasNext(); ) {
				Object object = it.next();
				if (object instanceof Property)  {
					list.add(object);
				}
			}			
		} else 	if (input instanceof Process) {
			// Walk all WSDL resources in the ResourceSet and scan each one for Properties.
			// This code is similar to BPELUtil.getPropertyAliasesForMessageType().
			
			// TODO: there should be a better way, e.g. builder keeping a map of what
			// properties and propertyAliases are available and where?
			
			ResourceSet resourceSet = ((Process)input).eResource().getResourceSet();			
			for (Iterator it = resourceSet.getResources().iterator(); it.hasNext(); ) {
				Resource resource = (Resource)it.next();
				if (resource instanceof WSDLResourceImpl) {
					for (TreeIterator treeIt = resource.getAllContents(); treeIt.hasNext(); ) {
						Object object = treeIt.next();
						if (object instanceof Property)  {
							list.add(object);
						}
					}
				}
			}			
		}	
		
	}
}
