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
package org.eclipse.bpel.common.ui;

import java.util.StringTokenizer;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

/**
 * Utility class.
 */
public final class Utils {

	/**
	 * Given an extension point name returns its configuration elements.
	 */
	public static IConfigurationElement[] getConfigurationElements(String extensionPointId) {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(CommonUIPlugin.PLUGIN_ID, extensionPointId);
		if (extensionPoint == null) {
			return null;
		}
		return extensionPoint.getConfigurationElements();
	}

	/**
	 * Stuff for manipulating generated code
	 * 
	 * The format for generated code is:

			//@generated:id
			// <generator 
			//       source (model)
			//             goes 
			//                 here>
			//@generated:end
			<generated java code here>

	 */
    /**
     * additional tags we need for the model serialization to be stored as Java comments
     */
    public static final String GEN_TAG = "//@generated:"; //$NON-NLS-1$
    /*
     * Note: GEN_TAG_MID assumed to be substring of the other GEN_TAG's in code below, don't change it without adjusting the logic
     * Also, adjust the similar code in the embedded editor if any.
     */
    public static final String GEN_TAG_MID = "//";  //$NON-NLS-1$
    public static final String GEN_TAG_END = "//@generated:end"; //$NON-NLS-1$
    public static final String EMBEDDED_SMAP_PREFIX = "//!SMAP!";	//$NON-NLS-1$
    
    /** 
	 * Utility function that strips out the generated comments for the generated Java code with embedded model.
	 * @param string - pass the entire block of Java code that is generated from the embedded's getCode function
	 * @return - returns the Java code with the embedded code subtracted out
	 */
	public static String getGeneratedCode(String string) {
	    StringBuffer sb = new StringBuffer();
	    StringTokenizer stringTokenizer = new StringTokenizer(string, "\n"); //$NON-NLS-1$
	    boolean inside = false;
	    while (stringTokenizer.hasMoreTokens()) {
	        String s = stringTokenizer.nextToken();
	        if (s.startsWith(GEN_TAG_MID) && !(s.startsWith(EMBEDDED_SMAP_PREFIX))) {
	        	// test for end first since GEN_TAG is a prefix of GEN_TAG_END	
	        	if (inside && s.startsWith(GEN_TAG_END)) {
	                inside = false;
	                continue;
	            }
	            if (s.startsWith(GEN_TAG)) {
	                inside = true;
	                continue; // with next line
	            }
	        } else if (!s.startsWith(EMBEDDED_SMAP_PREFIX)){ 
	            // it's not a commented line, so just regular Java code
	            sb.append(s);
	            sb.append("\n");
	            continue;
	        }
	            
	        if (!inside && !(s.startsWith(EMBEDDED_SMAP_PREFIX))) {
	            sb.append(s);
	            sb.append("\n");
	        }
	    }
	    return sb.toString();
	}
    
    /** 
     * Utility function that returns the id of the generator for the given generated Java code.
     * Returns <code>null</code> if no generator id is found
     * @param string - pass the entire block of Java code that is generated
     * @return - returns the Java code with the generated comment code subtracted out
     */
    public static String getGeneratorId(String string) {
    	if (string != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(string, "\n"); //$NON-NLS-1$
            while (stringTokenizer.hasMoreTokens()) {
                String s = stringTokenizer.nextToken();
                if (s.startsWith(GEN_TAG_MID)) {
                    if (s.startsWith(GEN_TAG)) {
                        return s.substring(GEN_TAG.length()); 
                    }
                } 
            }
    	}
        return null;
    }
}