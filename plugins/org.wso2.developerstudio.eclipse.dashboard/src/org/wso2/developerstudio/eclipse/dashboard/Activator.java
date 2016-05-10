package org.wso2.developerstudio.eclipse.dashboard;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.wso2.developerstudio.eclipse.carbonserver.base.util.ServerExtensionsRegistryUtils;
import org.wso2.developerstudio.eclipse.carbonserver40.register.product.servers.DynamicServer40ExtensionGenerator;
import org.wso2.developerstudio.eclipse.carbonserver42.register.product.servers.DynamicServer42ExtensionGenerator;
import org.wso2.developerstudio.eclipse.carbonserver44.register.product.servers.DynamicServer44ExtensionGenerator;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.wso2.developerstudio.eclipse.dashboad"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		// Registering WSO2 servers
		registerProductServers();
		super.start(context);
		plugin = this;
	}

	private void registerProductServers() {
		ServerExtensionsRegistryUtils serverExtensionsRegistryUtils = new ServerExtensionsRegistryUtils();
			IConfigurationElement[] registeredServers = serverExtensionsRegistryUtils.retrieveRegisteredProductServers();
			
			DynamicServer44ExtensionGenerator dynamicServerExtensionGenerator = new DynamicServer44ExtensionGenerator();
			dynamicServerExtensionGenerator.readProductServerExtensions(registeredServers,serverExtensionsRegistryUtils);
			DynamicServer42ExtensionGenerator dynamicServer42ExtensionGenerator = new DynamicServer42ExtensionGenerator();
			dynamicServer42ExtensionGenerator.readProductServerExtensions(registeredServers,serverExtensionsRegistryUtils);
			DynamicServer40ExtensionGenerator dynamicServer40ExtensionGenerator = new DynamicServer40ExtensionGenerator();
			dynamicServer40ExtensionGenerator.readProductServerExtensions(registeredServers,serverExtensionsRegistryUtils);

	}

	/*
	 * (non-Javadoc)
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

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
