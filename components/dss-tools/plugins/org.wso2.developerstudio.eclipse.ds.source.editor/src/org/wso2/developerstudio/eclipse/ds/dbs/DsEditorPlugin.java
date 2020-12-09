package org.wso2.developerstudio.eclipse.ds.dbs;

import org.osgi.framework.BundleContext;

import org.eclipse.ui.plugin.AbstractUIPlugin;

public final class DsEditorPlugin extends AbstractUIPlugin {

	private static DsEditorPlugin fgPlugin;

	public static DsEditorPlugin getDefault() {
		if (fgPlugin == null)
			throw new IllegalStateException(
			                                "plug-in has not yet been started or has already been shutdown");
		return fgPlugin;
	}

	public DsEditorPlugin() {
		assert fgPlugin == null;
		fgPlugin = this;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	public void stop(BundleContext context) throws Exception {
		fgPlugin = null;
		super.stop(context);
	}

}