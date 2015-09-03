package org.wso2.developerstudio.eclipse.platform.core.event;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.osgi.framework.Bundle;
import org.osgi.service.event.EventHandler;



public class EsbEditorEvent {
	private static IEventBroker iEventBroker;
	public static final String EVENT_TOPIC_SAVE_EDITORS = "SAVE_APIM_DATA";
	
	public static void CreateBroker(String pluginId){
		
		Bundle bundle = Platform.getBundle(pluginId);
		IEclipseContext eclipseContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		eclipseContext.set(org.eclipse.e4.core.services.log.Logger.class, null);		
		iEventBroker = eclipseContext.get(IEventBroker.class);	
	}
	
	public static void subscribe(EventHandler eventHandler){
		iEventBroker.subscribe(EVENT_TOPIC_SAVE_EDITORS, eventHandler);
	}

	public static IEventBroker getiEventBroker() {
		return iEventBroker;
	}


}
