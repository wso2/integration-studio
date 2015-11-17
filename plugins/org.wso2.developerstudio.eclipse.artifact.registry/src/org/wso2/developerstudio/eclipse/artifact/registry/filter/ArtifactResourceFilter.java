package org.wso2.developerstudio.eclipse.artifact.registry.filter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class ArtifactResourceFilter extends ViewerFilter{

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		
		if (element instanceof IFile) {

			IFile file = (IFile) element;
			if (file.getName().equals("artifact.xml") && file.getParent() instanceof IProject) {
				return false;
			}
		}

		return true;
	}

}
