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

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Shell;


public abstract class ResourceSelectionDialog extends FileAndComboSelectionDialog {

	ResourceSet callerResourceSet;
	ResourceSet resourceSet;

	public ResourceSelectionDialog(Shell shell, ResourceSet resourceSet, String message,
								   String filterPatterns, boolean useDetails)
	{
		this(shell, null, resourceSet, message, filterPatterns, useDetails);
	}

	public ResourceSelectionDialog(Shell shell, IPath initialSelection, ResourceSet resourceSet,
								   String message, String filterPatterns, boolean useDetails)
	{
		super(shell, ((initialSelection != null) ? initialSelection : BPELUtil.lastWSDLFilePath),
			message, filterPatterns, useDetails);
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
	 * given modelRoot.  The objectId must be non-null and the result should be non-null.
	 */
	protected abstract Object getModelObjectFromId(Object modelRoot, Object objectId);


	
	protected void okPressed() {
		Object comboSelection = getComboSelection();
		super.okPressed();
		BPELUtil.lastWSDLFilePath = getFullPath();
		
		// hack: now load the model object into the real resourceSet
		this.resourceSet = callerResourceSet;
		Object objectId = getIdFromModelObject(comboSelection);
		setComboResult(null); 
		if (objectId != null) {
			Object modelRoot = readModelFromSelectedFile();
			setComboResult(getModelObjectFromId(modelRoot, objectId));
		}
		
	}

	
	protected Object readModelFromSelectedFile() {
		IPath path = getFullPath();
		if (path != null) {
			try {
				Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(path.toString()), true);
				return resource.getContents().isEmpty()? null : resource.getContents().get(0);

			} catch (Exception e) {
				BPELUIPlugin.log(e);
			}
		}
		return null;
	}
}
