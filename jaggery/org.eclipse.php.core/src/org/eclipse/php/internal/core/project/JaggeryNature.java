package org.eclipse.php.internal.core.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.php.internal.core.PHPCorePlugin;

public class JaggeryNature implements IProjectNature {

	public static final String ID = PHPCorePlugin.ID + ".JAGNature"; //$NON-NLS-1$

	public void configure() throws CoreException {
		// TODO Auto-generated method stub

	}

	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}

	public IProject getProject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProject(IProject arg0) {
		// TODO Auto-generated method stub

	}

}
