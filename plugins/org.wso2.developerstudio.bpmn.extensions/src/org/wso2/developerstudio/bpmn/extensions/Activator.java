package org.wso2.developerstudio.bpmn.extensions;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        addUserLibrary();
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /*
     * Adds a user library to runtime eclipse as Activiti Designer Extension.
     */
    public void addUserLibrary() throws CoreException, URISyntaxException, IOException {
        ClasspathContainerInitializer initializer = JavaCore
                .getClasspathContainerInitializer(JavaCore.USER_LIBRARY_CONTAINER_ID);
        String libraryName = ExtensionConstants.ACTIVITI_DESIGNER_EXTENSIONS;
        Bundle bundle = Platform.getBundle(ExtensionConstants.BUNDLE_ID);
        URL fileURL = bundle.getEntry(ExtensionConstants.WSO2_TASK_LIB_LOCATION);

        File file = new File(FileLocator.resolve(fileURL).toURI());
        IPath containerPath = new Path(JavaCore.USER_LIBRARY_CONTAINER_ID);
        initializer.requestClasspathContainerUpdate(containerPath.append(libraryName), null, new IClasspathContainer() {
            public IPath getPath() {
                return new Path(JavaCore.USER_LIBRARY_CONTAINER_ID).append(libraryName);
            }

            public int getKind() {
                return K_APPLICATION;
            }

            public String getDescription() {
                return libraryName;
            }

            public IClasspathEntry[] getClasspathEntries() {
                return new IClasspathEntry[] { JavaCore.newLibraryEntry(
                        new Path(file.getAbsolutePath()).makeAbsolute(), null, null) };
            }
        });

    }

}
