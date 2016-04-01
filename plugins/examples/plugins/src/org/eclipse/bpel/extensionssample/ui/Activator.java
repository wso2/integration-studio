package org.eclipse.bpel.extensionssample.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.bpel.extensionsample.model.ModelPackage;
import org.eclipse.bpel.extensionssample.ui.factories.ExtensionSampleUIAdapterFactory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.bpel.extensionssample.ui";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		BPELUtil.registerAdapterFactory(ModelPackage.eINSTANCE, ExtensionSampleUIAdapterFactory.getInstance());
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
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
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		URL baseURL = getBundle().getEntry("/");
		createImageDescriptor(ExtensionSampleUIConstants.DEFAULT_ICON_16, baseURL);
		createImageDescriptor(ExtensionSampleUIConstants.DEFAULT_ICON_32, baseURL);
	}

	private void createImageDescriptor(String id, URL baseURL) {
		URL url = null;
		try {
			url = new URL(baseURL, "icons/" + id);
		} catch (MalformedURLException e) {
			getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getLocalizedMessage()));
		}
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(url);
		getImageRegistry().put(id, descriptor);
	}

	public ImageDescriptor getImageDescriptor(String key) {
		return getImageRegistry().getDescriptor(key);
	}

}
