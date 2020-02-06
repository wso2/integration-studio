package org.wso2.developerstudio.eclipse.artifact.registry.filter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class ArtifactResourceFilter extends ViewerFilter {

    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        final String DOCKER_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.docker.distribution.project.nature";
        final String K8S_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.kubernetes.distribution.project.nature";

        if (element instanceof IFile) {

            IFile file = (IFile) element;
            if (file.getName().equals("artifact.xml") && file.getParent() instanceof IProject
                    || file.getName().equals("config.properties") && file.getParent() instanceof IProject) {
                return false;
            }
        } else if (element instanceof IFolder) {
            IFolder fodler = (IFolder) element;
            try {
                if ((fodler.getName().equals("CarbonHome") || fodler.getName().equals("CompositeApps")
                        || fodler.getName().equals("ConfigMapResources") || fodler.getName().equals("target"))
                        && fodler.getParent() instanceof IProject
                        && (((IProject) fodler.getParent()).hasNature(DOCKER_PROJECT_NATURE)
                                || ((IProject) fodler.getParent()).hasNature(K8S_PROJECT_NATURE))) {
                    return false;
                }
            } catch (CoreException e) {
                // ignore the exception
            }
        }

        return true;
    }
}
