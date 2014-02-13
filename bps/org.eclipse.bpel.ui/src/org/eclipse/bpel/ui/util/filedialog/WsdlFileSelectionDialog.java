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

import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.wst.wsdl.Definition;

public class WsdlFileSelectionDialog extends WorkbenchFileSelectionDialog {

	public WsdlFileSelectionDialog(Shell shell) {
		super(shell,BPELUtil.lastWSDLFilePath, Messages.WsdlFileSelectionDialog_Select_a_WSDL_File_1, IBPELUIConstants.EXTENSION_DOT_WSDL); 
	}
	
	public Definition readModelFromSelectedFile(){					
		IPath path = getFullPath();
		if (path != null) {
				ResourceSet resourceSet = BPELUtil.createResourceSetImpl();	
				URI uri = URI.createPlatformResourceURI(path.toString());
				Resource wsdlResource = resourceSet.getResource(uri, true);
				Definition definition = (Definition) wsdlResource.getContents().get(0);
				return definition;
		}
		return null;
	}
	
	public String getPath(){
		IPath path = getFullPath();
		if (path!=null){
			BPELUtil.lastWSDLFilePath = path;				
			return path.toString();
		}
		return ""; //$NON-NLS-1$
	}
}
