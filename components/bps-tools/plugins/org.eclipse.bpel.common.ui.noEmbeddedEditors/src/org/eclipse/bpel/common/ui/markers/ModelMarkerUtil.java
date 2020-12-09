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
package org.eclipse.bpel.common.ui.markers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.ImageUtils;
import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;


public class ModelMarkerUtil {
    
    public static final String DECORATION_MARKER_PROVIDERS_EXTENSION_ID = "org.eclipse.bpel.common.ui.modelMarkerContentProviders";	 //$NON-NLS-1$  
    public static final String DECORATION_MARKER_PROVIDER_CONFIG_NAME = "modelMarkerContentProvider";	 //$NON-NLS-1$
    public static final String DECORATION_MARKER_PROVIDER_MARKER_TYPE_ATTR = "markerType";	 //$NON-NLS-1$
    public static final String DECORATION_MARKER_PROVIDER_CLASS_ATTR = "class";	 //$NON-NLS-1$
    
    private static Map markerTypeMap;
    
    /**
     * This class is not intended to be instantiated.
     */
    private ModelMarkerUtil() {
        
    }
    
    /**
     * Returns the marker from the list that should be displayed.  This takes
     * into account the priority, visible, and anchorPoint attributes of the
     * markers.  All markers in the list must be subtypes of the
     * graphicalMarker type defined in this plugin.
     * 
     * @param markers a list with each element implementing IMarker
     * @return IMarker the marker that should be displayed
     * @throws IllegalArgumentException a marker in the list was not
     * 				a subtype of graphicalMarker
     * @throws NullPointerException the anchorPoint was null
     */
    public static IMarker getDisplayMarker(List markers, String anchorPoint) {
        if (anchorPoint == null)
            throw new NullPointerException();
        return getDisplayMarker(markers.iterator(), anchorPoint);
    }
    
    /**
     * Returns the marker from the list that should be displayed.  This takes
     * into account the priority and visible attributes of the marker.
     * 
     * @param markers a list with each element implementing IMarker
     * @return IMarker the marker that should be displayed
     */
    public static IMarker getDisplayMarker(List markers) {
        return getDisplayMarker(markers.iterator(), null);
    }
    
    private static IMarker getDisplayMarker(Iterator i, String anchorPoint) {
        IMarker displayMarker = null;
        int displayMarkerPriority = 0;
        while(i.hasNext()) {
            IMarker marker = (IMarker) i.next();
            String visible = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_VISIBLE_ATTR, "true");	 //$NON-NLS-1$
            if (Boolean.valueOf(visible).equals(Boolean.FALSE))
                continue;
            
            if (anchorPoint != null) {
                // make sure that this marker is defined on the desired anchor point
                try {
	                String markerAnchorPoint = (String) marker.getAttribute(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR);
	                if (markerAnchorPoint == null) {
	                    // this attribute is not defined on this marker
	                    throw new IllegalArgumentException(Messages.ModelMarkerUtil_5); 
	                }
	                if (!anchorPoint.equals(markerAnchorPoint))
	                    continue;
                } catch (CoreException e) {
                }
            }
            
            int priority = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR, IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR_DEFAULT);
            if (displayMarker == null || priority > displayMarkerPriority) {
                displayMarker = marker;
                displayMarkerPriority = priority;
            }
        }
        return displayMarker;
    }
    
    /**
	 * Returns the image associated with this marker.  This invokes the
	 * getImage() method on the content provider for the marker type of
	 * the given marker.
	 * 
	 * If we can't find an image using the content provider we check to see if the
	 * marker is a problem marker and get the correct icon for it.
	 * 
	 * @param marker
	 * @return Image
	 */
	public static Image getImage(IMarker marker) {
	    try {
	        String markerType = marker.getType();
	        IModelMarkerContentProvider provider =
	            getModelMarkerContentProvider(markerType);
	
	        Image image = null;
	        
	        if (provider != null)
	            image = provider.getImage(marker);
	        
			if (image == null && marker.isSubtypeOf(IMarker.PROBLEM)) 
				image = ImageUtils.getImage(marker);
			
			return image;
	    } catch (CoreException e) {
	    	// Just ignore exceptions getting marker info.
	    	// It is possible that the marker no longer exists.
	    	// Eventually the UI will be notified that the
	    	// marker is removed and it will update.
	    	return null;
	    }
	}
    
    /**
	 * Returns the text associated with this marker.  This invokes the
	 * getImage() method on the content provider for the marker type of
	 * the given marker.
	 * 
	 * If we can't get the text using a content provider we check to see if the
	 * marker is a problem marker and get the correct text for it.
	 *
	 * @param marker
	 * @return String
	 */
	public static String getText(IMarker marker) {
	    try {
	    	
	        String markerType = marker.getType();
	        IModelMarkerContentProvider provider = getModelMarkerContentProvider(markerType);
	
	        String text = null;
	
	        if (provider != null) {
	            text = provider.getText(marker);
	        }
	
	    	if (text == null && marker.isSubtypeOf(IMarker.PROBLEM)) {
				text = (String)marker.getAttribute(IMarker.MESSAGE);
	    	}
			
	        return text;
	        
	    } catch (CoreException e) {
	    	// Just ignore exceptions getting marker info.
	    	// It is possible that the marker no longer exists.
	    	// Eventually the UI will be notified that the
	    	// marker is removed and it will update.
	        return null;
	    }
	}

    /**
     * Returns the content provider registered for the given marker's type.
     * If checkSupertypes is <code>true</code> then if no provider is found for the 
     * marker's specific type, supertypes are checked (in random order - first match is returned).
     * 
     * @param marker
     * @param checkSupertypes
     * @return IModelMarkerContentProvider or <code>null</code>
     */
    public static IModelMarkerContentProvider getModelMarkerContentProvider(IMarker marker, boolean checkSupertypes) {
    	
        if (markerTypeMap == null) {
            initializeMarkerTypeMap();
        }
        
        Object provider;
		try {
			provider = markerTypeMap.get(marker.getType());
			if (provider == null) {
				if (checkSupertypes) {
					// Check the supertypes
					Iterator iterator = markerTypeMap.keySet().iterator();
					while (iterator.hasNext() && provider == null) {
						String type = (String)iterator.next();
						if (marker.isSubtypeOf(type)) {
							provider = markerTypeMap.get(type);
							provider = checkProvider(type, provider);
						}
					}
				}
			} else {
				provider = checkProvider(marker.getType(), provider);
			}
		} catch (CoreException e) {
			// return null if the type cannot be determined
			return null;
		}
			
        return (IModelMarkerContentProvider) provider;
    }
    
    /**
     * Returns the content provider registered for the given marker type.
     * 
     * @param marker type
     * @return IModelMarkerContentProvider or <code>null</code>
     */
     
    public static IModelMarkerContentProvider getModelMarkerContentProvider(String markerType) {
        if (markerTypeMap == null) {
            initializeMarkerTypeMap();
        }
        if (markerTypeMap == null) {
        	return null;
        }
        Object provider = markerTypeMap.get(markerType);
        if (provider == null) {
            return null;
        }
        
        provider = checkProvider(markerType, provider); 
        	
        return (IModelMarkerContentProvider) provider;
    }
    
    /**
     * We lazily create marker content providers from the config element
     */
    private static IModelMarkerContentProvider checkProvider(String markerType, Object obj) {
    	Object provider = obj;
    	if (provider instanceof IConfigurationElement) {
	        // content provider needs to be initialized
	        IConfigurationElement config = (IConfigurationElement) provider;
	        try {
	            provider = config.createExecutableExtension(DECORATION_MARKER_PROVIDER_CLASS_ATTR);
	            
	            // replace the configuration element entry in the markerTypeMap with
	            // the new instance of the content provider
	            markerTypeMap.put(markerType, provider);
	        } catch (CoreException e) {
	            MultiStatus status = new MultiStatus(CommonUIPlugin.PLUGIN_ID, 0,
	                    new IStatus[]{e.getStatus()},
	                    NLS.bind(Messages.ModelMarkerUtil_6, (new Object[] { config.getDeclaringExtension().getUniqueIdentifier() })), 
	                    e);
	            CommonUIPlugin.getDefault().getLog().log(status);
	            return null;
	        } 
	    }
    	return (IModelMarkerContentProvider)provider;
    }

	private static void initializeMarkerTypeMap() {
        // load marker content providers
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(DECORATION_MARKER_PROVIDERS_EXTENSION_ID);
        if (extensionPoint == null) {
        	return ;
        }
        
        IExtension[] extensions = extensionPoint.getExtensions();
        markerTypeMap = new HashMap(extensions.length);
        for (int i = 0; i < extensions.length; i++) {
            IConfigurationElement[] configs = extensions[i].getConfigurationElements();
            for (int j = 0; j < configs.length; j++) {
                if (configs[j].getName().equals(DECORATION_MARKER_PROVIDER_CONFIG_NAME)) {
                    String markerType = configs[j].getAttribute(DECORATION_MARKER_PROVIDER_MARKER_TYPE_ATTR);
                    if (markerType == null) {
                        CommonUIPlugin.getDefault().getLog().log(createErrorStatus(
                            NLS.bind(Messages.ModelMarkerUtil_7, (new Object[] { extensions[i].getUniqueIdentifier() })))); 
                    } else
                    if (markerTypeMap.containsKey(markerType)) {
                        CommonUIPlugin.getDefault().getLog().log(createErrorStatus(
                            NLS.bind(Messages.ModelMarkerUtil_8, (new Object[] { markerType })))); 
                    } else {
                        markerTypeMap.put(markerType, configs[j]);
                    }
                }
            }
        }
	}
	
    private static Status createErrorStatus(String message) {
        return new Status(IStatus.ERROR, CommonUIPlugin.PLUGIN_ID, 0, message, null);
    }
}