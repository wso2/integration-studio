/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.bpel.common.ui.ColorUtils;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.expressions.Functions;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ISaveContext;
import org.eclipse.core.resources.ISaveParticipant;
import org.eclipse.core.resources.ISavedState;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class BPELUIPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.bpel.ui"; //$NON-NLS-1$

	/**  */
	static public BPELUIPlugin INSTANCE;

	private ColorRegistry colorRegistry;
	protected boolean imagesAndColorsInitialized;

	// takes care of changes to the BPEL file
	private BPELResourceChangeListener resourceChangeListener;
	private ISaveParticipant saveParticipant;

	// The templates that are provided for new file creation
	private Templates mTemplates;


	/**
	 * Constructor.
	 */
	public BPELUIPlugin() {
		super();
	}


	/**
	 * @param path
	 * @return return the plugin URI
	 */
	public URI getURI ( String path ) {
		return URI.createPlatformPluginURI(getID() + path, false);
	}


	/**
	 * Creates an image without storing it in the image registry.
	 * @param relativeLocation the relative location of the icon in this plug-in, e.g. "icons/test.gif"
	 * @return the created image, or null if it could not be created (a log entry is created then)
	 */
	public static Image createImage( String relativeLocation ) {

		Image result = null;
		try {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin( BPELUIPlugin.PLUGIN_ID, relativeLocation );
			result = desc.createImage();

		} catch( Exception e ) {
			log( e, IStatus.WARNING );
		}

		return result;
	}


	/**
	 * @return
	 */
	public String getDefaultPage() {
		return getPreferenceStore().getString(IBPELUIConstants.DEFAULT_EDITOR_PAGE);
	}

	/**
	 * setDefaultPage
	 * Set the default page to open when the editor starts.
	 * @param page
	 */
	public void setDefaultPage(String page) {
		getPreferenceStore().setValue(IBPELUIConstants.DEFAULT_EDITOR_PAGE, page);
	}

	/**2
	 * Creates an image descriptor and places it in the image registry.
	 */
	private void createImageDescriptor(String id, URL baseURL) {
		URL url = null;
		try {
			url = new URL(baseURL, IBPELUIConstants.ICON_PATH + id);
		} catch (MalformedURLException e) {
			BPELUIPlugin.log(e);
		}
		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
		getImageRegistry().put(id, desc);
	}

	/**
	 * Returns the image descriptor for the given image ID.
	 * Returns null if there is no such image.
	 */
	public ImageDescriptor getImageDescriptor(String id) {
		return getImageRegistry().getDescriptor(id);
	}
	public Image getImage(String id) {
		return getImageRegistry().get(id);
	}


	public String getID () {
		return getBundle().getSymbolicName();
	}


	private void initializeColors() {
		this.colorRegistry = new ColorRegistry();

		RGB color_240_240_240 = ColorUtils.getRelativeRGB(240, 240, 240);
		RGB color_255_255_255 = ColorUtils.getRelativeRGB(255, 255, 255);
		this.colorRegistry.put(IBPELUIConstants.COLOR_FLOW_BORDER, ColorUtils.getRelativeRGB(112, 152, 224));

		this.colorRegistry.put(IBPELUIConstants.COLOR_GRADIENT_FROM, color_255_255_255);
		this.colorRegistry.put(IBPELUIConstants.COLOR_GRADIENT_TO, color_240_240_240);

		if (ColorUtils.isInvertedColorScheme()) {
			this.colorRegistry.put(IBPELUIConstants.COLOR_ACTIVITY_BORDER, ColorUtils.getRelativeRGB(25, 25, 25));
			this.colorRegistry.put(IBPELUIConstants.COLOR_COMPOSITE_ACTIVITY_BORDER, ColorUtils.getRelativeRGB(25, 25, 25));
			this.colorRegistry.put(IBPELUIConstants.COLOR_SCOPE_BORDER, ColorUtils.getRelativeRGB(25, 25, 25));
			this.colorRegistry.put(IBPELUIConstants.COLOR_IMPLICIT_LINK, ColorUtils.getRelativeRGB(25, 25, 25));
		} else {
			this.colorRegistry.put(IBPELUIConstants.COLOR_ACTIVITY_BORDER, ColorUtils.getRelativeRGB(176, 176, 176));
			this.colorRegistry.put(IBPELUIConstants.COLOR_COMPOSITE_ACTIVITY_BORDER, ColorUtils.getRelativeRGB(205, 205, 205));
			this.colorRegistry.put(IBPELUIConstants.COLOR_SCOPE_BORDER, ColorUtils.getRelativeRGB(205, 205, 205));
			this.colorRegistry.put(IBPELUIConstants.COLOR_IMPLICIT_LINK, ColorUtils.getRelativeRGB(200, 200, 200));
		}
		this.colorRegistry.put(IBPELUIConstants.COLOR_HILIGHT_NODE, ColorUtils.getRelativeRGB(255, 255, 0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_VARIABLE_BACKGROUND, ColorUtils.getRelativeRGB(255, 255, 255));
		this.colorRegistry.put(IBPELUIConstants.COLOR_VARIABLE_SEPARATOR, ColorUtils.getRelativeRGB(230, 230, 230));
		this.colorRegistry.put(IBPELUIConstants.COLOR_VARIABLE_REFERENCE, ColorUtils.getRelativeRGB(99, 151, 245));
		this.colorRegistry.put(IBPELUIConstants.COLOR_LINK_ONE, ColorUtils.getRelativeRGB(238, 197, 253));
		this.colorRegistry.put(IBPELUIConstants.COLOR_LINK_TWO, ColorUtils.getRelativeRGB(73, 0, 107));
		this.colorRegistry.put(IBPELUIConstants.COLOR_LINK_THREE, ColorUtils.getRelativeRGB(222, 144, 254));

		this.colorRegistry.put(IBPELUIConstants.COLOR_WHITE, ColorUtils.getRelativeRGB(255, 255, 255));
		this.colorRegistry.put(IBPELUIConstants.COLOR_BLACK, ColorUtils.getRelativeRGB(0,0,0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_RED, ColorUtils.getRelativeRGB(255,0,0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_DARK_RED, ColorUtils.getRelativeRGB(0x80, 0, 0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_GREEN, ColorUtils.getRelativeRGB( 0, 255, 0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_DARK_GREEN, ColorUtils.getRelativeRGB(0, 0x80, 0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_YELLOW, ColorUtils.getRelativeRGB(255, 255, 0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_DARK_YELLOW, ColorUtils.getRelativeRGB(0x80, 0x80, 0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_BLUE, ColorUtils.getRelativeRGB( 0, 0 ,255));
		this.colorRegistry.put(IBPELUIConstants.COLOR_DARK_BLUE, ColorUtils.getRelativeRGB(0, 0, 0x80));
		this.colorRegistry.put(IBPELUIConstants.COLOR_MAGENTA, ColorUtils.getRelativeRGB( 255, 0, 255));
		this.colorRegistry.put(IBPELUIConstants.COLOR_DARK_MAGENTA, ColorUtils.getRelativeRGB( 0x80, 0, 0x80));
		this.colorRegistry.put(IBPELUIConstants.COLOR_CYAN, ColorUtils.getRelativeRGB( 0, 255, 255));
		this.colorRegistry.put(IBPELUIConstants.COLOR_DARK_CYAN, ColorUtils.getRelativeRGB( 0, 0x80, 0x80));
		this.colorRegistry.put(IBPELUIConstants.COLOR_GRAY, ColorUtils.getRelativeRGB( 0xC0, 0xC0, 0xC0));
		this.colorRegistry.put(IBPELUIConstants.COLOR_DARK_GRAY, ColorUtils.getRelativeRGB(0x80, 0x80, 0x80));

		this.colorRegistry.put(IBPELUIConstants.COLOR_HANDLER_LINK_FH, ColorUtils.getRelativeRGB(222,145,29));
		this.colorRegistry.put(IBPELUIConstants.COLOR_HANDLER_LINK_CH, ColorUtils.getRelativeRGB(124,151,203));
		this.colorRegistry.put(IBPELUIConstants.COLOR_HANDLER_LINK_EH, ColorUtils.getRelativeRGB(179,179,179));
		this.colorRegistry.put(IBPELUIConstants.COLOR_HANDLER_LINK_TH, ColorUtils.getRelativeRGB(255,0,0));
	}

	/**
	 * TODO: registry should be moved to editors and removed from plug-in
	 */
	public ColorRegistry getColorRegistry() {
		if (this.colorRegistry == null) {
			initialize();
		}
		return this.colorRegistry;
	}

	@Override
	public ImageRegistry getImageRegistry() {
		ImageRegistry result = super.getImageRegistry();
		initialize();
		return result;
	}

	/**
	 * Initializes the table of images used in this plugin.
	 */
	private void initializeImages() {
		URL baseURL = getBundle().getEntry("/"); //$NON-NLS-1$

		// A little reflection magic ... so that we don't
		// have to add the createImageDescriptor every time
		// we add it to the IBPELUIConstants ..
		Field fields[] = IBPELUIConstants.class.getFields();
		for( Field f : fields ) {
			if (f.getType() != String.class) {
				continue;
			}
			String name = f.getName();
			if (name.startsWith("ICON_") || name.startsWith("CURSOR_")) {   //$NON-NLS-1$ //$NON-NLS-2$
				try {
					String value = (String) f.get(null);
					createImageDescriptor(value, baseURL);
				} catch (Exception e) {
					log(e);
				}
			}
		}
	}

	/**
	 * @see org.eclipse.core.runtime.Plugin#start(BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;

		initializePreferences();
		initializeResourceChangeListener();
		initFunctions ();
	}

	protected void initializePreferences() {
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(IBPELUIConstants.PREF_SHOW_FREEFORM_FLOW, true);
		store.setDefault(IBPELUIConstants.PREF_WARN_LINKS, true);
		store.setDefault(IBPELUIConstants.PREF_AUTO_FLOW_LAYOUT, false);
		store.setDefault(IBPELUIConstants.PREF_USE_ANIMATION, true);
		store.setDefault(IBPELUIConstants.PREF_CREATE_SPEC_COMPLIANT_PROCESS, false);
	}


	/**
	 * Installs the IResourceChangeListener for the BPEL Plugin. Also
	 * checks if there were any changes to BPEL files while the plug-in
	 * was not active.
	 */
	private void initializeResourceChangeListener() throws CoreException {
		this.resourceChangeListener = new BPELResourceChangeListener();
		// Add the save participant in a separate thread
		// to make sure that it doesn't block the UI thread and potentially cause
		// deadlocks with the code that caused our plugin to be started.
		Thread initSaveParticipantThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					workspace.addResourceChangeListener(BPELUIPlugin.this.resourceChangeListener, IResourceChangeEvent.POST_BUILD);
					ISavedState savedState = workspace.addSaveParticipant(BPELUIPlugin.this, getSaveParticipant());
					if (savedState != null) {
						savedState.processResourceChangeEvents(BPELUIPlugin.this.resourceChangeListener);
					}
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}
		});
		initSaveParticipantThread.setName("BPELUIPlugin init"); //$NON-NLS-1$
		initSaveParticipantThread.start();
	}

	public boolean activateZoomSupport() {
		return false;
	}



	public Templates getTemplates ()
	{
		if (this.mTemplates == null) {
			this.mTemplates = new Templates ();
			this.mTemplates.initializeFrom( getBundle() );
		}
		return this.mTemplates;
	}


	protected void initialize() {
		if (!this.imagesAndColorsInitialized) {
			this.imagesAndColorsInitialized = true;
			initializeImages();
			initializeColors();
		}
	}


	@SuppressWarnings("nls")
	void initFunctions () {

		Job job = new Job ("Reading XPath Function Registry ...") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				long start = System.currentTimeMillis();
				IStatus status;
				try {
					Functions.getInstance( BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE );
					status = new Status(IStatus.OK, PLUGIN_ID, 0, "Done",null); //$NON-NLS-1$
				} catch (Throwable t ) {
					log(t);
					status = new Status(IStatus.ERROR,PLUGIN_ID,0,t.getLocalizedMessage(),t);
				}
				long end = System.currentTimeMillis();
				System.out.println("InitFunctions took: " + (end - start) + "ms");

				monitor.done();
				done(Job.ASYNC_FINISH);
				return status;
			}
		};

		job.setPriority(Job.SHORT);
		job.schedule();

	}
	/**
	 * @see org.eclipse.core.runtime.Plugin#stop(BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {

		super.stop(context);

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if (workspace != null) {
			workspace.removeResourceChangeListener(this.resourceChangeListener);
		}
	}

	/**
	 * We are only interested in the resource delta while the plugin was
	 * not active and don't really care about the plug-in save lifecycle.
	 */
	private ISaveParticipant getSaveParticipant() {
		if (this.saveParticipant == null) {
			this.saveParticipant = new ISaveParticipant() {
				@Override
				public void doneSaving(ISaveContext context) {
				}
				@Override
				public void prepareToSave(ISaveContext context) throws CoreException {
				}
				@Override
				public void rollback(ISaveContext context) {
				}
				@Override
				public void saving(ISaveContext context) throws CoreException {
					context.needDelta();
				}
			};
		}
		return this.saveParticipant;
	}

	/**
	 * Returns the resource change listener.
	 */
	public BPELResourceChangeListener getResourceChangeListener() {
		return this.resourceChangeListener;
	}

	/**
	 * Return the dialog settings for a given object. The object may be a string
	 * or any other java object. In that case, the object's class name will be used
	 * to retrieve that section name.
	 *
	 * @param object
	 * @return the dialog settings for that object
	 *
	 */
	public IDialogSettings getDialogSettingsFor ( Object object )
	{
	    String name = object.getClass().getName();
	    if (object instanceof String) {
	        name = (String) object;
	    }

	    IDialogSettings main = getDialogSettings();
	    IDialogSettings settings = main.getSection( name );
	    if (settings == null) {
	        settings = main.addNewSection(name);
	    }
	    return settings;
	}


	/**
	 * Utility methods for logging exceptions.
	 */
	public static void log(Throwable e, int severity) {
		IStatus status = null;
		if (e instanceof CoreException) {
			status = ((CoreException)e).getStatus();
		} else {
			String m = e.getMessage();
			status = new Status(severity, PLUGIN_ID, 0, m==null? "<no message>" : m, e); //$NON-NLS-1$
		}
		System.out.println(e.getClass().getName()+": "+status); //$NON-NLS-1$
		INSTANCE.getLog().log(status);
	}


	/**
	 * Utility methods for logging exceptions.
	 */
	public static void log( Throwable e, String message, int severity ) {
		IStatus status = new Status( severity, PLUGIN_ID, message, e );
		INSTANCE.getLog().log( status );
	}

	/**
	 * @param throwable
	 */
	public static void log(Throwable throwable) {
		log(throwable, IStatus.ERROR); }
}
