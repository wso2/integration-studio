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
package org.eclipse.bpel.ui.details.providers;

import java.util.List;

import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Types;
import org.eclipse.xsd.XSDSchema;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 19, 2006
 *
 */
public class XSDSchemaContentProvider extends AbstractContentProvider {

	@Override
	public void collectElements(Object input, List list) {
		if (collectComplex(input, list)) {
			return ;
		}
		
		if (input instanceof XSDSchema) {
			list.add ( input );
		} else if (input instanceof Definition) {
			Definition defn = (Definition) input;
			Types types = defn.getETypes();
			if (types == null) {
				return;
			}
			list.addAll( types.getSchemas() );			
		}
		
	}
	
	

}
