package org.wso2.developerstudio.eclipse.utils.ide;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

public class EclipseUtils {
	
	public static IPath getWorkspacePath(){
		return ResourcesPlugin.getWorkspace().getRoot().getLocation();
	}

	public static IPath getWorkspaceRelativePath(IPath library) {
		IPath workspacePath = EclipseUtils.getWorkspacePath();
		IPath returnPath = library.removeFirstSegments(workspacePath.segmentCount());
		return returnPath;
	}

}
