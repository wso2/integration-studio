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

import java.util.List;

import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.wst.wsdl.Definition;

/**
 * Content provider for PartnerLinkTypes.
 * 
 * Expects a Definition as input.
 */

public class PartnerLinkTypeContentProvider extends AbstractContentProvider  {

	
	@Override
	public void collectElements ( Object input, List list) {
		
		if (input instanceof Definition) {
			EList extensibilityElementList = ((Definition)input).getEExtensibilityElements();
			for (int i = 0, j = extensibilityElementList.size(); i < j; i++) {
				Object maybePlt = extensibilityElementList.get(i);
				if (maybePlt instanceof PartnerLinkType) {
					list.add(maybePlt);
				}
			}
			return;
		}
		
		// check if we can extract any definitions
		List definitions = ModelHelper.getDefinitions( input );
		
		if (definitions.size() > 0) {
			collectComplex(definitions,list);
			return ;
		}
		
		// try basic complex types (list,array)
		collectComplex ( input, list );
	}	
	
	
	
}
