/*
 * Copyright (c) 2010 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.common.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

/**
 * Lightweight icon decorator for error/warning/info icons in Navigator view
 *
 * @see https://jira.jboss.org/browse/JBIDE-6016
 * @author Bob Brodt
 * @date Nov 16, 2010
 */
public class ResourceMarkerDecorator implements ILightweightLabelDecorator, ICommonUIConstants {

	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// Do not initialize these in constructor - BPEL plugin may not be available yet
	private static ImageDescriptor img_error = null;
	private static ImageDescriptor img_warning = null;
	private static ImageDescriptor img_info = null;
	
	public ResourceMarkerDecorator()
	{
		super();
	}
	
	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

	public void decorate(Object element, IDecoration decoration) {
		try {
			int severity = ((IResource)element).findMaxProblemSeverity(IMarker.PROBLEM, true, IResource.DEPTH_ONE);
			switch (severity) {
			case IMarker.SEVERITY_ERROR:
				if (img_error==null)
					img_error = CommonUIPlugin.getDefault().getImageRegistry().getDescriptor(ICommonUIConstants.ICON_ERROR);
				decoration.addOverlay(img_error);
				break;
			case IMarker.SEVERITY_WARNING:
				if (img_warning==null)
					img_warning = CommonUIPlugin.getDefault().getImageRegistry().getDescriptor(ICommonUIConstants.ICON_WARNING);
				decoration.addOverlay(img_warning);
				break;
			case IMarker.SEVERITY_INFO:
				if (img_info==null)
					img_info = CommonUIPlugin.getDefault().getImageRegistry().getDescriptor(ICommonUIConstants.ICON_INFO);
				decoration.addOverlay(img_info);
				break;
			}
		}
		catch(Exception e) {
		}
	}
}
