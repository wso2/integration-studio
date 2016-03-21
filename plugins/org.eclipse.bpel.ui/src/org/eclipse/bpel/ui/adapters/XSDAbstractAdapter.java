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
/**
 * 
 */
package org.eclipse.bpel.ui.adapters;

import java.util.Map;

import org.eclipse.bpel.model.adapters.AbstractAdapter;
import org.eclipse.bpel.model.adapters.IStatefullAdapter;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

import org.eclipse.xsd.XSDNamedComponent;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 *
 */

public class XSDAbstractAdapter extends AbstractAdapter 
	implements ILabeledElement, IStatefullAdapter 
{
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PART_32);
	}	

	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PART_16);
	}	

	public String getNamespacePrefix(String namespace) {
		Object context = getContext();
		// if this is 
		if (context instanceof EObject) {
			EObject eObject = (EObject) context;
			return BPELUtils.getNamespacePrefix(eObject, namespace);
		} else if (context instanceof Map) {
			return (String) ((Map)context).get(namespace);
		}
		
		return null;
	}

	public String getTypeLabel ( Object obj ) {
		return obj.getClass().getName();
	}
	
	
	public String getLabel ( Object obj  )
	{	
		XSDNamedComponent component = (XSDNamedComponent) BPELUtil.resolveXSDObject(obj);;
		String name =  component.getName();
		String ns = component.getTargetNamespace();
		
		if (name == null) {
			return getTypeLabel( obj );
		}
		
		if (ns == null) {
			return name;
		}
		
		String prefix = getNamespacePrefix(ns);
		
		if (prefix == null) {
			return "{" + ns + "}" + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return prefix + ":" + name; //$NON-NLS-1$
	}	
}