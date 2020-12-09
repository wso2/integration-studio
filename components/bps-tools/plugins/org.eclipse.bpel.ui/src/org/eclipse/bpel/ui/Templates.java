/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation
 *******************************************************************************/

package org.eclipse.bpel.ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.bpel.ui.wizards.WSDLServiceDetail;
import org.osgi.framework.Bundle;

/**
 * You can think of BPEL templates as a 1 dimensional list of stencils that are
 * used to create an initial BPEL process.
 * <p>
 * Each template for a process may contain just 1 resource - just the template
 * for the BPEL process itself. But it may also contain other resources which
 * are useful in creating that particular process from that particular template.
 * Simply put, a template may have 1-N template resources that need to be
 * created as a result of creating what appears to be a single process file.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 */

public class Templates {

	/** this file defines the properties for a particular template */
	static final String TEMPLATE_PROPERTIES = "template.properties"; //$NON-NLS-1$

	/** location within the bundle where we look for templates */
	static final String TEMPLATE_LOCATION = "/templates/"; //$NON-NLS-1$

	/** default template file encoding, for a given set of template resources */
	static final String DEFAULT_ENCODING = "UTF-8"; //$NON-NLS-1$

	/** the main bpel file has this extension */
	@Deprecated
	// use content type instead of bpel file extensions
	static final String BPEL_FILE_EXTENSION = ".bpel"; //$NON-NLS-1$

	/** Entries which are directories of the bundle */
	static final String BUNDLE_DIRECTORY = "/"; //$NON-NLS-1$

	/** Key or property under which the name of the template is present */
	public static final String PROPERTY_NAME = "name"; //$NON-NLS-1$

	/** The key name of the template */
	public static final String PROPERTY_KEY = "key"; //$NON-NLS-1$
	
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7165
	/** All of the known template keys */
	public static final String TEMPLATE_KEY_ASYNC = "async";
	public static final String TEMPLATE_KEY_SYNC = "sync";
	public static final String TEMPLATE_KEY_EMPTY = "empty";
	/** Add more above, as new templates are created */

	/**
	 * Key or property under which the encoding information for the template
	 * resources is present
	 */
	public static final String PROPERTY_ENCODING = "encoding"; //$NON-NLS-1$

	/** Key or property under which the description of the template is present */
	public static final String PROPERTY_DESCRIPTION = "description"; //$NON-NLS-1$

	/** avoid empty string */
	static final String EMPTY = ""; //$NON-NLS-1$

	static final String[] EMPTY_NAMES = {};

	/** Templates contribute namespaces to the new file wizard */
	Set<String> mNamespaceNames = new TreeSet<String>();

	/**
	 * Templates indexed by name, sorted by name, according to the natural
	 * ordering
	 */
	Map<String, Template> mTemplateByName = new TreeMap<String, Template>();

	/** Templates indexed by id, sorted by name */
	Map<String, Template> mTemplateByKey = new HashMap<String, Template>();

	/**
	 * Initialize the template information from the bundle passed. This is
	 * typically the bundle of the plugin.
	 * 
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @param bundle
	 *            the bundle where the template information ought to be looked
	 *            for
	 */

	@SuppressWarnings("nls")
	public void initializeFrom(Bundle bundle) {
		initializeFrom(bundle, TEMPLATE_LOCATION);
	}

	/**
	 * @param templateLocation
	 */

	public void initializeFrom(String templateLocation) {
		initializeFrom(BPELUIPlugin.INSTANCE.getBundle(), templateLocation);
	}

	/**
	 * @param bundle
	 * @param templateLocation
	 */

	@SuppressWarnings( { "nls", "boxing", "unchecked" })
	public void initializeFrom(Bundle bundle, String templateLocation) {

		Enumeration<String> list = bundle.getEntryPaths(templateLocation);
		if (list == null) {
			return;
		}
		// got some elements, look for "template.properties"

		int count = 0;

		while (list.hasMoreElements()) {
			String nextRoot = list.nextElement();
			if (nextRoot.endsWith(BUNDLE_DIRECTORY) == false) {
				continue;
			}

			String nextEntry = nextRoot + TEMPLATE_PROPERTIES;
			// found another template

			URL nextURL = bundle.getEntry(nextEntry);
			if (nextURL == null) {
				// no such thing
				continue;
			}

			// looks like we have properties
			count += 1;

			Properties props = new Properties();
			InputStream is = null;

			try {
				is = nextURL.openStream();
				props.load(is);
			} catch (IOException e) {
				BPELUIPlugin.log(e);

				// skip to the next entry
				continue;

			} finally {
				try {
					is.close();
				} catch (Throwable t) {
				}
			}

			String name = props.getProperty(PROPERTY_NAME);

			// No name, no game.
			if (name == null) {
				continue;
			}

			String enc = props.getProperty(PROPERTY_ENCODING, DEFAULT_ENCODING);
			String desc = props.getProperty(PROPERTY_DESCRIPTION, EMPTY);

			// add any namespaces we are supplying ...
			mNamespaceNames.addAll(findProperties(props, "namespace.{0}"));

			Template template = new Template();
			template.mName = name;
			template.mDescription = desc;
			template.mProperties = (Map) props;

			mTemplateByName.put(name, template);
			String id = props.getProperty(PROPERTY_KEY);
			if (id != null) {
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
				// https://jira.jboss.org/browse/JBIDE-7165
				template.mKey = id;
				mTemplateByKey.put(id, template);
			}

			int hole = 3;
			for (int i = 0; hole >= 0; i++) {
				String key = MessageFormat.format("resource.{0}", i);
				String resourceName = props.getProperty(key);
				if (resourceName == null) {
					hole--;
					continue;
				}
				hole = 3;

				key = MessageFormat.format("resource.{0}.name", i);
				String nameTemplate = props.getProperty(key);

				String entryLoc = nextRoot + resourceName;

				TemplateResource resource = new TemplateResource();
				resource.mName = resourceName;
				resource.mContent = slurpContent(bundle.getEntry(entryLoc), enc);
				resource.mNameTemplate = nameTemplate;

				// add the resource which makes up this "template"
				template.add(resource);

			}

		}

	}

	/**
	 * Slurp the resource into memory and return as a String. If an exception
	 * occurs, it is logged, and the return value is empty string.
	 * 
	 * @param loc
	 *            the location from which we should slurp ...
	 * @param enc
	 *            the encoding to use
	 * @return the text
	 */

	String slurpContent(URL loc, String enc) {

		if (loc == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder(2 * 1048);
		char[] buf = new char[256];
		InputStreamReader isr = null;

		try {
			isr = new InputStreamReader(loc.openStream(), enc);

			do {
				int cnt = isr.read(buf);
				if (cnt < 0) {
					break;
				}
				sb.append(buf, 0, cnt);
			} while (true);

		} catch (Exception ex) {
			BPELUIPlugin.log(ex);
		} finally {
			try {
				isr.close();
			} catch (Throwable t) {
			}
		}

		return sb.toString();
	}

	List<String> findProperties(Properties props, String pattern) {

		List<String> list = new ArrayList<String>();
		int hole = 3;

		for (int i = 0; hole >= 0; i++) {

			String key = MessageFormat.format(pattern,
					new Object[] { Integer.valueOf( i )});
			String val = props.getProperty(key, null);
			if (val != null) {
				list.add(val);
				hole = 3;
			} else {
				hole--;
			}
		}

		return list;
	}

	/**
	 * @param key
	 * @return the template whose key is key
	 */

	public Template getTemplateByKey(String key) {
		return mTemplateByKey.get(key);
	}

	/**
	 * Return the template definition (which includes other resources that may
	 * be present) to the caller.
	 * 
	 * @param name
	 *            name of the template
	 * @return the template definition, including template resources
	 */

	public Template getTemplateByName(String name) {
		return mTemplateByName.get(name);
	}

	/**
	 * 
	 * @return Return the namespaces contributed by the templates.
	 */

	public String[] getNamespaceNames() {
		return mNamespaceNames.toArray(EMPTY_NAMES);
	}

	/**
	 * Return the template names that have been discovered.
	 * 
	 * @return Return the template names.
	 */

	public String[] getTemplateNames() {
		return mTemplateByName.keySet().toArray(EMPTY_NAMES);
	}

	/**
	 * A given "BPEL Process" Template has a name, description, and a list of
	 * resources (file templates) that will be used to create the initial
	 * process source file.
	 * 
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * 
	 */

	public class Template {

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7165
		/** Template key so we don't have to worry about using localized names everywhere */
		String mKey;
		
		/** Name of the process template */
		String mName;

		/** Description of this process template */
		String mDescription;

		Map<String, String> mProperties;

		/** list of resources that this template has (1-N) */
		List<TemplateResource> mResources = new ArrayList<TemplateResource>();

		/**
		 * @return the name
		 */
		public String getName() {
			return mName;
		}

		/**
		 * @return the key
		 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		 * @see https://jira.jboss.org/browse/JBIDE-7165
		 */
		public String getKey() {
			return mKey;
		}

		void add(TemplateResource resource) {
			mResources.add(resource);
			resource.mTemplate = this;
		}

		/**
		 * @return the template resources
		 */
		public List<TemplateResource> getResources() {
			return mResources;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return mDescription;
		}

		/**
		 * Return the property under the key or null if not found.
		 * 
		 * @param key
		 * @return the property under the key, or null.
		 */

		public String getProperty(String key) {
			return mProperties.get(key);
		}

		TemplateResource lookupResource(String name) {
			String name2 = mProperties.get(name);
			for (TemplateResource resource : mResources) {
				if (name.equals(resource.mName)) {
					return resource;
				}
				if (name2 != null && name2.equals(resource.mName)) {
					return resource;
				}
			}
			return null;
		}

	}

	/**
	 * A template resource is the actual file which will be used to create the
	 * source file or other auxiliary files for the BPEL process source.
	 * 
	 * @author Michal Chmielewski, (michal.chmielewski@oracle.com)
	 * 
	 */

	public class TemplateResource {

		/** The template I belong to */
		Template mTemplate = null;

		/** Name of the resource (from the bundle) */
		String mName;

		/** The content of the resource (slurped from the bundle) */
		String mContent;

		/**
		 * The name template, that is, the file name template if depended on
		 * process name
		 */
		String mNameTemplate;

		/**
		 * @return the content
		 */
		public String getContent() {
			return mContent;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return mName;
		}

		/**
		 * Process the content of the template and replace anything within
		 * ${...} by the corresponding key prent in the map passed.
		 * 
		 * @param args
		 *            the keys that will be replaced in the content
		 * @return the replaced content
		 */

		public String process(Map<String, Object> args) {

			return process(mContent, args);
		}

		/**
		 * Process the content of the template and replace anything within
		 * ${...} by the corresponding key present in the map passed.
		 * 
		 * @param args
		 *            the keys that will be replaced in the content
		 * @return the replaced content
		 */

		@SuppressWarnings("nls")
		String process(String src, Map<String, Object> args) {
			// empty content, empty result
			if (src == null) {
				return "";
			}

			// add the service and binding content
			int start = src.indexOf("</definitions>");
			if (start > 0) {
				StringBuffer ss = new StringBuffer(src.substring(0, start));
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
				// https://jira.jboss.org/browse/JBIDE-7165
				// use key instead of [possibly] localized template name
				Object key = args.get(Templates.PROPERTY_KEY);
				String protocol = (String) args.get("protocol");
				if (protocol!=null)
					protocol = protocol.toLowerCase();
				if (Templates.TEMPLATE_KEY_ASYNC.equals(key)) {
					if ("soap".equals(protocol)) {
						ss.append(WSDLServiceDetail.Async_SOAPDetail);
					} else {
						ss.append(WSDLServiceDetail.Async_HTTPDetail);
					}
				} else if (Templates.TEMPLATE_KEY_SYNC.equals(key)) {
					if ("soap".equals(protocol)) {
						ss.append(WSDLServiceDetail.Sync_SOAPDetail);
					} else {
						ss.append(WSDLServiceDetail.Sync_HTTPDetail);
					}
				} else if (Templates.TEMPLATE_KEY_EMPTY.equals(key)) {
					ss.append(WSDLServiceDetail.Empty_Detail);
				}
				ss.append("</definitions>");
				src = ss.toString();
			}
			StringBuilder sb = new StringBuilder(src.length());
			int cursor = 0;
			do {
				int openReplace = src.indexOf("${", cursor);
				if (openReplace < 0) {
					break;
				}
				sb.append(src.substring(cursor, openReplace));
				cursor = openReplace + 2;
				int closeReplace = src.indexOf("}", cursor);
				if (closeReplace < 0) {
					return sb.toString();
				}

				String expr = src.substring(cursor, closeReplace).trim();
				sb.append(lookup(expr, args));

				cursor = closeReplace + 1;
			} while (true);

			// the last segment
			sb.append(src.substring(cursor));
			return sb.toString();
		}

		@SuppressWarnings("nls")
		Object lookup(String key, Map<String, Object> args) {
			Object value = null;
			TemplateResource r = null;
			if (key.startsWith(":include:")) {
				key = key.substring(9);
				r = mTemplate.lookupResource(key);
				if (r != null) {
					value = r.mContent;
				}
			} else if (key.startsWith(":parse:")) {
				key = key.substring(7);
				r = mTemplate.lookupResource(key);
				/** Avoid recursion at this point */
				if (r != null && r != this) {
					value = r.process(args);
				}
			} else {
				value = args.get(key);
				if (value == null) {
					value = mTemplate.mProperties.get(key);
				}
			}
			return value;
		}

		/**
		 * Return the name of the resource
		 * 
		 * @param args
		 *            map of arguments that are used in replacing
		 * @return the name of the resource, after token replacement.
		 */

		public String getName(Map<String, Object> args) {

			if (mNameTemplate == null) {
				return mName;
			}
			return process(mNameTemplate, args);
		}

		/**
		 * Ask if this TemplateResource is specifically a BPEL source file.
		 * 
		 * @return Answer true if the extension is .bpel
		 */

		public boolean isProcess() {
			return mName.endsWith(BPEL_FILE_EXTENSION);
		}
	}

}
