/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator.model;

/**
 * Only JDK dependencies here please ...
 */
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ListResourceBundle;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


/**
 * Messages loads and caches possibly several resource bundles 
 * that contain the validator messages.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 18, 2006
 *
 */

@SuppressWarnings("nls")

public class Messages {
	
	static private String DOT = "."; //$NON-NLS-1$
			
	static final Map<String,Messages> BUNDLES = new HashMap<String,Messages> ();
	
	/** The empty resource bundle */
	static final ResourceBundle EMPTY_BUNDLE = new ListResourceBundle() {
		@Override
		protected Object[][] getContents() {
			return new Object[][] {
				{"empty", "empty"}
			};
		}		
	};
	
	String fBundleName;
	
	/** By default assume we have not successfully loaded the bundle */
	ResourceBundle fBundle = EMPTY_BUNDLE;	
	
	/**
	 * Temporary for monkey scripts ..
	 */
	
	static public void clear () {
		
		synchronized ( BUNDLES ) {
			BUNDLES.clear();
		}		
	}
		

			
	/**
	 * Return the messages for the bundle name.
	 * 
	 * @param bundleName
	 * @return the messages for that bundle name.
	 */
		
	static final public Messages getMessages ( String bundleName ) {
		
		Messages msg = BUNDLES.get( bundleName );
		if (msg == null) {
			msg = new Messages ( bundleName );
			synchronized ( BUNDLES ) {
				BUNDLES.put( bundleName, msg ) ;
			}
		}
		return msg;
	}
	
	
		
	static String keyFor ( Class<?> clazz, String name ) {
		String pName = clazz.getPackage().getName();
		return pName + DOT + name; 		
	}
	
	/**
	 * 
	 * Get the messages from the specific bundle. We read and cache 
	 * the messages on the first access.
	 * 
	 * @param bundleName
	 * 
	 */
	
	
	public Messages ( String bundleName ) {
				
		fBundleName = bundleName;
		 
		String resourceName = fBundleName.replace('.','/') + ".properties";
		URL resourceURL = getClass().getClassLoader().getResource( resourceName );
		if (resourceURL == null) {
			return ;			
		}
		
		try {
			fBundle = new PropertyResourceBundle ( resourceURL.openStream() );
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}


	/**
	 * Return true of the message bundle contains the key
	 * indicated.
	 * 
	 * @param key
	 * @return return true of the message bundle has the key indicated.
	 */
	
	public boolean containsKey ( final String key ) {
		
		try {
			return fBundle.getString(key) != null;
		} catch (MissingResourceException mre) {
			return false;
		}
	}
	
	
	/**
	 * Get the message stored under the key.
	 * 
	 * @param key
	 * @return the value stored, or some default
	 */
	
	public String get ( final String key ) {
		return get(key,16);
	}
		
	
	
	private String get (final String key, final int level) {
		String value;
		
		try {						
			value = fBundle.getString(key).trim();
			
			String newKey = aliasFrom (value);
			
			if (newKey != null) {
				if (level > 0) {
					return get ( newKey , level-1);
				}
				return missingKey ( newKey );

			}
			
		} catch (MissingResourceException e) {
			return missingKey(key);
		}
		
		return value;
	}

	/**
	 * 
	 * @param key
	 * @return the missing key format string
	 */

	static public final String missingKey (String key) {
		StringBuilder sb = new StringBuilder(64);
		sb.append("!!").append(key).append("! [0={0},1={1},2={2},3={3},4={4},5={5}]");
		return sb.toString();
	}
	
	/**
	 * Get the message stored under the key. If not found, then return the default
	 * value passed.
	 * 
	 * @param key the key to find in the bundle.
	 * @param def the default value is the resource is missing in the bundle
	 * @return the value stored, or some default
	 */
	
	public String get ( final String key , String def ) {
		return get(key,def,16);
	}
	
	
	
	String get ( final String key, String def, int level) {
		
		String value;
		
		try {
			
			value =  fBundle.getString(key);
			
			String newKey = aliasFrom(value);
			
			if (newKey != null) {
				
				if (level > 0) {
					return get(newKey,def,level-1);
				}
				
				return def;
			}
			
		} catch (MissingResourceException e) {
			return def;
		}
		return value;
	}
	
	
	
	String aliasFrom ( final String value ) {
	
		int len = value.length();
		if (len < 5) {
			return null;
		}
		
		char ch1 = value.charAt(0);
		char ch2 = value.charAt(1);
		char chL = value.charAt( len - 1) ;
		
		// ${xxxx}
		
		if (ch1 == '$' && ch2 == '{' && chL == '}') {
			return value.substring(2,len-1);
		}		
		return null;		
	}
}
