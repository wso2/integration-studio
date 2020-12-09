package org.eclipse.bpel.validator;


import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.eclipse.bpel.fnmeta.model.FMPackage;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.adapters.AdapterRegistry;
import org.eclipse.bpel.validator.factory.BPELValidatorAdapterFactory;
import org.eclipse.bpel.validator.factory.FunctionMetaValidatorAdapterFactory;
import org.eclipse.bpel.validator.helpers.ModelQueryImpl;
import org.eclipse.bpel.validator.model.IFactory;
import org.eclipse.bpel.validator.model.IModelQuery;
import org.eclipse.bpel.validator.model.RuleFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */

@SuppressWarnings("nls")
public class Activator extends Plugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.bpel.validator"; //$NON-NLS-1$

	/** The shared instance */
	static Activator plugin;
	
	
	/**
	 * The constructor
	 */
	public Activator() {
		// nothing
	}

	/**
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	

	@Override
	public void start (BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		// hook up Java logging to the Eclipse error log		
		Logger logger = Logger.getLogger( PLUGIN_ID );
		Handler handler = new LogHandler();
		logger.addHandler( handler );
		
		initializeAndTime();
	}

	
	void initialize () {
		
		// factories 
		String epName = "factories";
		
		IExtensionPoint ep = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID,epName);
		
		if (ep != null) {
			
			for(IExtension e : ep.getExtensions() ) {
				for(IConfigurationElement ce : e.getConfigurationElements() ) {
					Object obj = null;
					try {
						obj = ce.createExecutableExtension("class");
					} catch (CoreException e1) {
						log(e1);
					}
					if (obj != null && obj instanceof IFactory) {
						RuleFactory.INSTANCE.registerFactory( (IFactory) obj);
					}
				}
			}
			
		} else {
			String name = PLUGIN_ID + "." + epName;
			log(null,IStatus.ERROR,"Extension point " + name + " is not avaialble.");
		}
		
		// modelQuery
		epName = "modelQuery";
		ep = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID,epName);
		if (ep != null) {
			for(IExtension e : ep.getExtensions() ) {
				for(IConfigurationElement ce : e.getConfigurationElements() ) {
					Object obj = null;
					try {
						obj = ce.createExecutableExtension("class");
					} catch (CoreException e1) {
						log(e1);						
					}
					if (obj != null && obj instanceof IModelQuery) {
						ModelQueryImpl.register( (IModelQuery) obj);
					}
				}
			}
		} else {
			String name = PLUGIN_ID + "." + epName;
			log(null,IStatus.ERROR,"Extension point " + name + " is not avaialble.");			
		}
		
		
		// Register our adapter providers
		AdapterRegistry.INSTANCE.registerAdapterFactory(
			    FMPackage.eINSTANCE,  FunctionMetaValidatorAdapterFactory.INSTANCE );
	
		AdapterRegistry.INSTANCE.registerAdapterFactory(
				BPELPackage.eINSTANCE,  BPELValidatorAdapterFactory.INSTANCE );			
	}

	IStatus initializeAndTime () {
		long start = System.currentTimeMillis();
		initialize ();			
		long end = System.currentTimeMillis();				
		IStatus	status = new Status(IStatus.INFO, PLUGIN_ID, 0,
				"Validator Startup " + (end - start) + "ms"
				,null); 
		return status;
	}
	
	void initializeAsync ( ) {
		Job job = new Job ("Registering Validator factories ...") {	
			@Override
			protected IStatus run (IProgressMonitor monitor) {
				IStatus status = initializeAndTime();
				monitor.done();
				done(Job.ASYNC_FINISH);
				return status;				
			}			
		};				
		job.setPriority(Job.SHORT);		
		job.schedule();
	}
	
	
	/**
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	
	@Override
	public void stop(BundleContext context) throws Exception {		
		plugin = null;
				
		AdapterRegistry.INSTANCE.unregisterAdapterFactory(
			    FMPackage.eINSTANCE,  FunctionMetaValidatorAdapterFactory.INSTANCE );

		AdapterRegistry.INSTANCE.registerAdapterFactory(
				BPELPackage.eINSTANCE,  BPELValidatorAdapterFactory.INSTANCE );			
		
		
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
	 * Utility methods for logging exceptions.
	 * @param e exception to log
	 * @param severity the severity to log the exception as.
	 * @param message
	 */
	public static void log (Exception e, int severity, String message ) {
		
		IStatus status = null;
		if (e instanceof CoreException) {
			status = ((CoreException)e).getStatus();
		} else {
			String m = message;
			if (m == null) {
				e.getMessage();
			}
			status = new Status(severity, PLUGIN_ID, 0, m==null? "<no message>" : m, e); //$NON-NLS-1$
		}
		
		plugin.getLog().log(status);
	}
	
	
	/** 
	 * Log an exception.
	 * @param e exception the log
	 */
	
	public static void log(Exception e) { 
		log(e, IStatus.ERROR,null); 
	}
	
		
	class LogHandler extends Handler {

		/** (non-Javadoc)
		 * @see java.util.logging.Handler#close()
		 */
		@Override
		public void close() throws SecurityException {			
			
		}

		/** (non-Javadoc)
		 * @see java.util.logging.Handler#flush()
		 */
		@Override
		public void flush() {
			
		}

		/** (non-Javadoc)
		 * @see java.util.logging.Handler#publish(java.util.logging.LogRecord)
		 */
		
		@SuppressWarnings("nls")
		@Override
		public void publish (LogRecord record) {								
			
			StringBuilder sb = new StringBuilder();
			sb.append(record.getThreadID());
			sb.append(":");
			sb.append(record.getLoggerName());
			sb.append(":");
			sb.append(record.getMessage());
			
			Throwable t = record.getThrown();
			int severity = IStatus.INFO;
			
			if (record.getLevel() == Level.SEVERE) {
				severity = IStatus.ERROR;
			} else if (record.getLevel() == Level.WARNING) {
				severity = IStatus.WARNING;
			}
			
			IStatus status = new Status(severity, PLUGIN_ID, 0,sb.toString() , t); //$NON-NLS-1$
			plugin.getLog().log(status);
		}
		
	}
}
