/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.validation.internal.operations.WorkbenchContext;
import org.eclipse.wst.validation.internal.operations.WorkbenchReporter;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 13, 2007
 *
 */
public class ValidatorHelper extends WorkbenchContext {

	@Override
	public void registerResource(IResource resource) {
		if(resource!=null) {
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			if(getValidationFileURIs()==null) {
				setValidationFileURIs(new ArrayList<String>());
			}
			getValidationFileURIs().add(resource.getFullPath().toOSString());
		} else {
			Activator.getDefault().getLog().log(new Status(IStatus.WARNING,Activator.PLUGIN_ID,"Cannot register null resource for validation"));
		}
	}

}
