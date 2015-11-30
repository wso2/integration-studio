/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.reordering.extensions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.bpel.model.BPELPlugin;
import org.eclipse.bpel.model.reordering.IExtensibilityElementListHandler;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;


/**
 * @author Original Contribution IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 6, 2007
 */


@SuppressWarnings("nls")
public class ExtensionFactory {
	
	/**	 */
	static public final ExtensionFactory INSTANCE = new ExtensionFactory();
	
	private static final String ATTRIBUTE_CLASS = "class";
	/**	 */
	public static final String ID_EXTENSION_REORDERING = "extensions_reordering";
				
	
	/**
	 * @param type
	 * @return ?
	 */
	
	public List<IExtensibilityElementListHandler> createHandlers(String type) {
		
		List<IExtensibilityElementListHandler> handlers = new ArrayList<IExtensibilityElementListHandler>();
		
		for (IConfigurationElement element : findExtensionConfigurationElementsByID(type)) {
			IExtensibilityElementListHandler handler = _createExtensibilityElementListHandler(element);
			if(handler != null) {
				handlers.add(handler);
			}		
		}
		return handlers;
	}
	
	private IExtensibilityElementListHandler _createExtensibilityElementListHandler(IConfigurationElement element) {	
		if (element == null) {
			return null;
		}
		
		IExtensibilityElementListHandler classifier = null; 
		try {
			classifier =  (IExtensibilityElementListHandler)(element.createExecutableExtension(ATTRIBUTE_CLASS));
		} catch (Exception e) {
			classifier = null;	
		}
		return classifier;
	}

	
	private List<IConfigurationElement> findExtensionConfigurationElementsByID(String extensionpointID) {
		
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(BPELPlugin.PLUGIN_ID, extensionpointID);		
		if (elements == null) {
			return Collections.emptyList();
		}
		
		List<IConfigurationElement> elementsFound = new ArrayList<IConfigurationElement>();
		
		for (IConfigurationElement nextElement : elements) {
			if (nextElement.getName().equals(extensionpointID)) {
				elementsFound.add(nextElement);			
			}
		}
		
		return elementsFound;
	}
	
}
