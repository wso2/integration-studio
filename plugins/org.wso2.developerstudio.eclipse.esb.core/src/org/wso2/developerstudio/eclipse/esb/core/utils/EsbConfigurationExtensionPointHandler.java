package org.wso2.developerstudio.eclipse.esb.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.esb.core.Activator;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEndpointProvider;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEndpointProviderData;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ILocalEntryProvider;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ILocalEntryProviderData;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ISequenceProvider;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ISequenceProviderData;
import org.wso2.developerstudio.eclipse.esb.core.internal.impl.EndpointProviderDataImpl;
import org.wso2.developerstudio.eclipse.esb.core.internal.impl.LocalEntryProviderDataImpl;
import org.wso2.developerstudio.eclipse.esb.core.internal.impl.SequenceProviderDataImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EsbConfigurationExtensionPointHandler {
	private static String ESB_CONFIGURATION_EXTENSION="org.wso2.developerstudio.eclipse.esb.configurationProvider";
	
	private static List<IEndpointProviderData> endpointProviderList;
	private static List<ISequenceProviderData> sequenceProviderList;
	private static List<ILocalEntryProviderData> localentryProviderList;
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public static IEndpointProviderData[] getEndpointProviders(boolean refresh){
		if (refresh){
			for (IEndpointProviderData providerData : endpointProviderList) {
				providerData.getProvider().refresh();
			}
		}
		return endpointProviderList.toArray(new IEndpointProviderData[]{});
	}
	
	public static ISequenceProviderData[] getSequenceProviders(boolean refresh){
		if (refresh){
			for (ISequenceProviderData providerData : sequenceProviderList) {
				providerData.getProvider().refresh();
			}
		}
		return sequenceProviderList.toArray(new ISequenceProviderData[]{});
	}
	
	public static ILocalEntryProviderData[] getLocalEntryProviders(boolean refresh){
		if (refresh){
			for (ILocalEntryProviderData providerData : localentryProviderList) {
				providerData.getProvider().refresh();
			}
		}
		return localentryProviderList.toArray(new ILocalEntryProviderData[]{});
	}
	
	static {
		endpointProviderList=new ArrayList<IEndpointProviderData>();
		sequenceProviderList=new ArrayList<ISequenceProviderData>();
		localentryProviderList=new ArrayList<ILocalEntryProviderData>();

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(ESB_CONFIGURATION_EXTENSION);
		for (IConfigurationElement e : config) {		
			try {
				if (e.getName().equalsIgnoreCase("endpoint")) {
					EndpointProviderDataImpl providers = new EndpointProviderDataImpl();
					providers.setId(e.getAttribute("id"));
					providers.setName(e.getAttribute("name"));
					IEndpointProvider providerObj = (IEndpointProvider) e
							.createExecutableExtension("class");
					providers.setProvider(providerObj);
					endpointProviderList.add(providers);
				} else if (e.getName().equalsIgnoreCase("sequence")) {
					SequenceProviderDataImpl providers = new SequenceProviderDataImpl();
					providers.setId(e.getAttribute("id"));
					providers.setName(e.getAttribute("name"));
					ISequenceProvider providerObj = (ISequenceProvider) e
							.createExecutableExtension("class");
					providers.setProvider(providerObj);
					sequenceProviderList.add(providers);
					
				}else if (e.getName().equalsIgnoreCase("localentry")) {
					LocalEntryProviderDataImpl providers = new LocalEntryProviderDataImpl();
					providers.setId(e.getAttribute("id"));
					providers.setName(e.getAttribute("name"));
					ILocalEntryProvider providerObj = (ILocalEntryProvider) e
							.createExecutableExtension("class");
					providers.setProvider(providerObj);
					localentryProviderList.add(providers);
					
				}
			} catch (Exception ex) {
				log.error(ex);
			}
		}
		
	}
}
