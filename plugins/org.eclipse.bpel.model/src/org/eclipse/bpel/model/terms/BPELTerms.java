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
package org.eclipse.bpel.model.terms;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.bpel.model.BPELPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;

/**
 * The main plugin class to be used in the desktop.
 */
public class BPELTerms {
	// preference key.
	public static final String PREF_BPEL_TERMS_PATH = "pref_bpel_terms_path"; //$NON-NLS-1$
	
	private ResourceBundle resourceBundle = null;
	private String currentTerms = null;
	
	private static String TERMS_PACKAGE = "org.eclipse.bpel.terms"; //$NON-NLS-1$
	
	public static String SPEC_TERMS_PATH = TERMS_PACKAGE+".spec_terms"; //$NON-NLS-1$
	
	protected boolean loadTerms(String terms) {
		if (terms != null && terms.equals(currentTerms)) return true; 
		currentTerms = terms;
		ResourceBundle newResourceBundle = null;
		try {
			newResourceBundle = ResourceBundle.getBundle(terms);
		} catch (MissingResourceException x) {
			return false;
		}
		resourceBundle = newResourceBundle;
		return true;
	}
	
	Preferences.IPropertyChangeListener prefListener = new Preferences.IPropertyChangeListener() {
		public void propertyChange(PropertyChangeEvent event) {
			if (PREF_BPEL_TERMS_PATH.equals(event.getProperty())) {
				loadTerms(getPluginPreferences().getString(PREF_BPEL_TERMS_PATH));
			}
		}
	};

	//The shared instance.
	private static BPELTerms plugin;
	
	/**
	 * The constructor.
	 */
	public BPELTerms() {
		plugin = this;
	}

	/**
	 * Returns the shared instance. This method must work in both
	 * the eclipse and non-eclipse case.
	 */
	public synchronized static BPELTerms getDefault() { 
		// Lazy initialization for the non-eclipse case
		if (plugin == null) {
			plugin = new BPELTerms();
			// Initialize the resource bundle to the spec terms since
			// we don't have any preferences store.
			plugin.loadTerms(SPEC_TERMS_PATH);
		}
		return plugin;
	}
	
	/**
	 * Returns the plugin's resource bundle,
	 */
	protected ResourceBundle getResourceBundle() {
		if (resourceBundle == null) {
			if (Platform.isRunning()) {
				Preferences prefs = getPluginPreferences();
				prefs.setDefault(PREF_BPEL_TERMS_PATH, SPEC_TERMS_PATH);
				loadTerms(prefs.getString(PREF_BPEL_TERMS_PATH));
				prefs.addPropertyChangeListener(prefListener);
			}	
		}
		return resourceBundle;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getString(String key) {
		ResourceBundle bundle = BPELTerms.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	* Retrieves a message with one parameter from the catalog. This is just a convenience
	* wrapper for {@link #get(String,Object[])}.
	* @param key The key of the message to retrieve.
	* @param var The substitution variable to use.
	* @return The message text or <code>null</code>, if the key cannot be found.
	*/
	public static String getString(String key, Object var) {
		return getString(key, new Object[] { var });
	}
	
	/**
	* Retrieves a message with an arbitrary number of parameters from the catalog.
	* <ul>
	* <li>If you specify less variables than there are parameters, the placeholders for
	*     the missing parameters will be left as-is. This is also true if you omit
	*     the variables at all using {@link #get(String)}.</li>
	* <li>If you specify a <code>null</code> variable, the corresponding placeholder
	*     will be replaced with the string <code>null</code>.</li>
	* <li>If you specify any variables at all when retrieving a message (it does not matter
	*     if they are actually used or not), you must escape the single quote character
	*     by doubling it in the message string. In contrast, if you don't specify any
	*     variables by using the {@link #get(String)} method (again, it does not matter if they
	*     are actually used), you must not escape the single quote character.</li>
	* </ul>
	* @param key The key of the message to retrieve.
	* @param vars The list of substitution variables to use.
	* @return The message text or <code>null</code>, if the key cannot be found.
	*/
	public static String getString(String key, Object[] vars)
	{
	  String text = getString(key);
	  return text == null ? null : MessageFormat.format(text, vars);
	}
	
	/**
	 * Return the name of the currently-selected catalogue. This method must
	 * work whether we are in an eclipse or non-eclipse environment.
	 * @return the name of the currently-selected catalogue. The result will
	 * be either 
	 */
	public static String getCatalogName() {
		// Plugin preferences will not exist in a non-eclipse environment.
		if (Platform.isRunning()) {
			return BPELTerms.getDefault().getPluginPreferences().getString(PREF_BPEL_TERMS_PATH);
		}
		return SPEC_TERMS_PATH;
	}
	
	// TODO: temp method - should be removed
	public Preferences getPluginPreferences() {
		return BPELPlugin.getPlugin().getPluginPreferences();
	}
	
	// TODO: temp method - should be removed
	public void savePluginPreferences() {
		BPELPlugin.getPlugin().savePluginPreferences();
	}
}
