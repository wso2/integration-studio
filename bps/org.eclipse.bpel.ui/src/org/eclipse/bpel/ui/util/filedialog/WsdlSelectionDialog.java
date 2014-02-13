/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util.filedialog;

import java.util.Iterator;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.wst.wsdl.Definition;

public abstract class WsdlSelectionDialog extends FileAndComboSelectionDialog {

	ResourceSet callerResourceSet;
	ResourceSet resourceSet;

	public WsdlSelectionDialog(Shell shell, ResourceSet resourceSet, String message,
		String filterPatterns, boolean useDetails)
	{
		super(shell, BPELUtil.lastWSDLFilePath, message, filterPatterns, useDetails);
		this.callerResourceSet = resourceSet;
		this.resourceSet = BPELUtil.createResourceSetImpl();
	}

	/**
	 * This method should map the selectedModelObject to some identifier which can uniquely
	 * identify it within its resource (e.g. the object's name).  The result must be non-null.
	 *
	 * The mapping should be as robust as possible, since the model may already be loaded in
	 * memory and modified.
	 */
	protected abstract Object getIdFromModelObject(Object selectedModelObject);

	/**
	 * This method should map the given objectId back to a model object reachable from the
	 * given definition.  The objectId must be non-null and the result should be non-null.
	 */
	protected abstract Object getModelObjectFromId(Definition definition, Object objectId);


	
	protected void okPressed() {
		Object comboSelection = getComboSelection();
		super.okPressed();
		BPELUtil.lastWSDLFilePath = getFullPath();
		
		// hack: now load the model object into the real resourceSet
		this.resourceSet = callerResourceSet;
		Object objectId = getIdFromModelObject(comboSelection);
		setComboResult(null); 
		if (objectId != null) {
			Definition definition = (Definition)readModelFromSelectedFile();
			setComboResult(getModelObjectFromId(definition, objectId));
		}
		
	}

	
	protected Object readModelFromSelectedFile() {
		IPath path = getFullPath();
		if (path != null) {
			try {
				// Check for it first in the caller set.
				URIConverter converter = callerResourceSet.getURIConverter();
				URI uri = URI.createPlatformResourceURI(path.toString());
				URI normalizedURI = converter.normalize(uri);
				Resource wsdlResource = null;
				
				Iterator it = callerResourceSet.getResources().iterator();
				while (it.hasNext()) {
					Resource resource = (Resource)it.next();
					if (converter.normalize(resource.getURI()).equals(normalizedURI)) {
						wsdlResource = resource;
						break;
					}
				}
				
				// It wasn't in the caller set; create it now in the temp set
				if (wsdlResource == null) {
					wsdlResource = resourceSet.getResource(uri, true);
				}
				Definition definition = (Definition) wsdlResource.getContents().get(0);
				
				return definition;
			} catch (Exception e) {
				BPELUIPlugin.log(e);
			}
		}
		return null;
	}
}
