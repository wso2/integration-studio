package org.wso2.developerstudio.eclipse.registry.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.MediaManager;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResourceProvider;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResourceProviderData;
import org.wso2.developerstudio.eclipse.registry.core.internal.impl.RegistryResourceProviderData;

public class RegistryManager {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String REGISTRY_RESOURCE_EXTENSION = "org.wso2.developerstudio.eclipse.greg.resourceProvider";
	private static List<IRegistryResourceProviderData> providerList;

	public static IRegistryResourceProviderData[] getResourceProviders(
			boolean refresh) {
		if (refresh) {
			for (IRegistryResourceProviderData providerData : providerList) {
				providerData.getProvider().refresh();
			}
		}
		return providerList.toArray(new IRegistryResourceProviderData[] {});
	}

	public static boolean isMediaTypeFilterPassed(
			Map<String, List<String>> filters, IFile registryResource){
		try {
			File file = registryResource.getLocation().toFile();
			return isMediaTypeFilterPassed(filters, file);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isMediaTypeFilterPassed(
			Map<String, List<String>> filters, File file){
		boolean passed = true;
		try {
			if (DeveloperStudioProviderUtils.isFilterPresent(filters,
					CSProviderConstants.FILTER_MEDIA_TYPE)) {
				String mediaType = getRegistryResourceMediaType(file);
				passed = DeveloperStudioProviderUtils.isMediaTypeFilterPassed(filters, mediaType);
			}
		} catch (Exception e) {
			passed=false;
		}
		return passed;
	}

	private static String getRegistryResourceMediaType(File file)
			throws XMLStreamException, FactoryConfigurationError,
			FileNotFoundException {
		String mediaType = null;
		File resourceMetadataFile = getResourceMetadataFile(file);
		if (resourceMetadataFile.exists()) {
			XMLStreamReader parser = XMLInputFactory.newInstance()
					.createXMLStreamReader(
							new FileInputStream(resourceMetadataFile));
			StAXOMBuilder builder = new StAXOMBuilder(parser);
			OMElement documentElement = builder.getDocumentElement();
			Iterator childrenWithLocalName = documentElement
					.getChildrenWithLocalName("mediaType");
			while (childrenWithLocalName.hasNext()) {
				OMElement mediaTypeElement = (OMElement) childrenWithLocalName
						.next();
				mediaType = mediaTypeElement.getText();
				break;
			}
		}
		if (mediaType == null) {
			mediaType = MediaManager.getMediaType(file);
		}
		return mediaType;
	}

	public static File getResourceMetadataFile(File file) {
		return new File(new File(file.getParentFile(),
				".meta"), "~" + file.getName() + ".xml");
	}

	static {
		providerList = new ArrayList<IRegistryResourceProviderData>();
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(REGISTRY_RESOURCE_EXTENSION);
		for (IConfigurationElement e : config) {
			try {
				RegistryResourceProviderData providers = new RegistryResourceProviderData();
				providers.setId(e.getAttribute("id"));
				providers.setName(e.getAttribute("name"));
				IRegistryResourceProvider providerObj = (IRegistryResourceProvider) e
						.createExecutableExtension("class");
				providers.setResourceProvider(providerObj);
				providerList.add(providers);
			} catch (Exception ex) {
				log.error(ex);
			}
		}
	}
}
