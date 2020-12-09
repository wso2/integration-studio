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
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 10, 2007
 *
 */

public class MarkerAdapter extends AbstractStatefulAdapter implements 
		IStatus
{

	/**
	 * @see org.eclipse.core.runtime.IStatus#getChildren()
	 */
	public IStatus[] getChildren() {		
		return null;
	}

	/**
	 * @see org.eclipse.core.runtime.IStatus#getCode()
	 */
	
	public int getCode() {
		return 0;
	}

	/**
	 * @see org.eclipse.core.runtime.IStatus#getException()
	 */
	public Throwable getException() {		
		return null;
	}

	/**
	 * @see org.eclipse.core.runtime.IStatus#getMessage()
	 */
	public String getMessage() {
		IMarker marker = getTarget(null, IMarker.class);
		try {
			return (String) marker.getAttribute(IMarker.MESSAGE);
		} catch (CoreException ce) {
			return null;
		}
	}

	/**
	 * @see org.eclipse.core.runtime.IStatus#getPlugin()
	 */
	public String getPlugin() {
		return null;
	}

	/**
	 * @see org.eclipse.core.runtime.IStatus#getSeverity()
	 */
	@SuppressWarnings("boxing")
	public int getSeverity() {
		
		IMarker marker = getTarget(null, IMarker.class);
		
		try {
			int severity = (Integer) marker.getAttribute(IMarker.SEVERITY);
			switch (severity) {
				case IMarker.SEVERITY_ERROR :
					return IStatus.ERROR;
				case IMarker.SEVERITY_WARNING :
					return IStatus.WARNING;
				default :
					break;
			}				
		} catch (CoreException ce) {
			// ignore, return info 
		}
		
		return IStatus.INFO;	
	}
	

	/**
	 * @see org.eclipse.core.runtime.IStatus#isMultiStatus()
	 */
	public boolean isMultiStatus() {		
		return false;
	}

	/**
	 * @see org.eclipse.core.runtime.IStatus#isOK()
	 */
	public boolean isOK() {
		return (getSeverity() == IStatus.OK);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.core.runtime.IStatus#matches(int)
	 */
	
	public boolean matches (int severityMask) {
		return false;
	}
}
