package org.wso2.developerstudio.eclipse.qos.project.controller;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class QoSProjectFilter extends ViewerFilter {
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IProject) {
			try {
				if (((IProject) element).hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
					return true;
				}
			} catch (Exception e) {/*ignore*/}
		}
		return false;
	}

}
