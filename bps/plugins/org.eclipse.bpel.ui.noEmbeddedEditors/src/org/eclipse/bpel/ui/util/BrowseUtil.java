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
package org.eclipse.bpel.ui.util;

import org.eclipse.bpel.ui.dialogs.TypeSelectorDialog;
import org.eclipse.bpel.ui.dialogs.PartnerLinkTypeSelectorDialog;
import org.eclipse.bpel.ui.dialogs.TypeSelectorDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.wsdl.PortType;


/*
 * Added some new methods that browse for Message Types and XSD Simple Types and Elements.
 * These disable the type selection radio buttons and limit the display to only those types
 * that are relevant.
 *
 * @see https://jira.jboss.org/browse/JBIDE-7107
 * @author Bob Brodt
 * @date Oct 12, 2010
 */
public class BrowseUtil {

	public static PortType browseForPortType(ResourceSet resourceSet, Shell parent) {
		// TODO!
		return null;
	}
	
	public static Object browseForXSDTypeOrElement(EObject eObject, Shell parent) {		
		// https://issues.jboss.org/browse/JBIDE-8045
		// changed TypeSelectorDialog
		TypeSelectorDialog dialog = new TypeSelectorDialog (parent,eObject,
				TypeSelectorDialog.INCLUDE_SIMPLE_TYPES |
				TypeSelectorDialog.INCLUDE_COMPLEX_TYPES |
				TypeSelectorDialog.INCLUDE_ELEMENT_DECLARATIONS |
				TypeSelectorDialog.INCLUDE_PRIMITIVES
				);		
		if (dialog.open() != Window.OK) {
			return null;
		}
		Object obj[] = dialog.getResult();
		if (obj != null && obj.length > 0) {
			return obj[0];
		}
		return null;

	}

	/**
	 * @param input
	 * @param shell
	 * @return
	 */
	
	public static Object browseForPartnerLinkType (EObject eObject, Shell parent) {
		PartnerLinkTypeSelectorDialog dialog = new PartnerLinkTypeSelectorDialog (parent,eObject);		
		if (dialog.open() != Window.OK) {
			return null;
		}
		Object obj[] = dialog.getResult();
		if (obj != null && obj.length > 0) {
			return obj[0];
		}
		return null;

	}

	public static Object[] browseForXSDType(EObject eObject, Shell parent) {		
		// https://issues.jboss.org/browse/JBIDE-8045
		// removed use of specialized selection dialog
		TypeSelectorDialog dialog = new TypeSelectorDialog (parent,eObject,
				TypeSelectorDialog.INCLUDE_XSD_TYPES);
		if (dialog.open() != Window.OK) {
			return null;
		}
		Object obj[] = dialog.getResult();
		if (obj != null && obj.length > 0) {
			return obj;
		}
		return null;

	}

	public static Object[] browseForXSDElement(EObject eObject, Shell parent, boolean requireElementSelection) {		
		// https://issues.jboss.org/browse/JBIDE-8045
		// removed use of specialized selection dialog
		TypeSelectorDialog dialog = new TypeSelectorDialog (parent,eObject,
				TypeSelectorDialog.INCLUDE_ELEMENT_DECLARATIONS);
		dialog.setRequireLowerTreeSelection(requireElementSelection);
		if (dialog.open() != Window.OK) {
			return null;
		}
		Object obj[] = dialog.getResult();
		if (obj != null && obj.length > 0) {
			return obj;
		}
		return null;

	}

	public static Object[] browseForMessageType(EObject eObject, Shell parent, boolean requirePartSelection) {		
		// https://issues.jboss.org/browse/JBIDE-8045
		// removed use of specialized selection dialog
		TypeSelectorDialog dialog = new TypeSelectorDialog (parent,eObject,
				TypeSelectorDialog.INCLUDE_MESSAGE_TYPES);
		dialog.setRequireLowerTreeSelection(requirePartSelection);
		if (dialog.open() != Window.OK) {
			return null;
		}
		Object obj[] = dialog.getResult();
		if (obj != null && obj.length > 0) {
			return obj;
		}
		return null;

	}


	// https://issues.jboss.org/browse/JBIDE-8045
	public static Object[] browseForVariableType(EObject eObject, Shell parent, boolean requireElementSelection, int filter) {		
		TypeSelectorDialog dialog = new TypeSelectorDialog (parent,eObject,filter);
		dialog.setRequireLowerTreeSelection(requireElementSelection);
		if (dialog.open() != Window.OK) {
			return null;
		}
		Object obj[] = dialog.getResult();
		if (obj != null && obj.length > 0) {
			return obj;
		}
		return null;

	}
}
