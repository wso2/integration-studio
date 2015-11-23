package org.wso2.developerstudio.eclipse.updater;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.wso2.developerstudio.eclipse.updater.ui.ProvisioningWindow;

/**
 * The activator class controls the plug-in life cycle
 */
public class UpdaterPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.wso2.developerstudio.eclipse.updater"; //$NON-NLS-1$

	// The shared instance
	private static UpdaterPlugin plugin;
	private static BundleContext bundleCtx;
	
	/**
	 * The constructor
	 */
	public UpdaterPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		bundleCtx = context;
		plugin = this;
		// extract web interface file first.
		FileLocator.toFileURL(FileLocator.find(FrameworkUtil
				.getBundle(ProvisioningWindow.class), new Path(
				"WebInterface/updater"), null));
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		bundleCtx = null;
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static UpdaterPlugin getDefault() {
		return plugin;
	}

	public static BundleContext getContext() {
		return bundleCtx;
	}

}
