/*
 * Copyright (c) 2010, 2012 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.ui.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ImportResolver;
import org.eclipse.bpel.model.util.ImportResolverRegistry;
import org.eclipse.bpel.ui.details.providers.AbstractContentProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Definition;
//import org.eclipse.wst.wsdl.Import;
import org.eclipse.wst.wsdl.util.WSDLConstants;

/*
 * Content provider for the NamespacesPrefixesSection table in the Namespaces Property Tab.
 * Input is the BPEL Activity or Process object currently selected in the editor canvas.
 * The provider collects all of the namespaces in scope for the input EObject and tries
 * to correlate them with imported artifacts. The result, a list of NamespacePrefixesElement,
 * is displayed in the table Namespaces Property Tab.
 *
 * @see https://jira.jboss.org/browse/JBIDE-6765
 * @author Bob Brodt
 * @date Aug 13, 2010
 */
public class NamespacePrefixesProvider extends AbstractContentProvider  {
	
	/**
	 * @see org.eclipse.bpel.ui.details.providers.AbstractContentProvider#collectElements(java.lang.Object, java.util.List)
	 */
	@Override
	public void collectElements(Object input, List<Object> list)  {
		
		List<NamespacePrefixElement> elements = new ArrayList<NamespacePrefixElement>();
		
		// build the list of elements
		// find the process for this BPEL model object
		Process process = null;
		if (input instanceof EObject)
		{
			EObject context = (EObject)input;
			process = BPELUtils.getProcess(input);
			// walk up the BPEL activity ancestry starting at the input element
			// and collect all in-scope namespace info
			while (context!=null)
			{
				// https://jira.jboss.org/browse/JBIDE-6917
				try
				{
					Map<String, String> map = BPELUtils.getNamespaceMap(context);
					for (Map.Entry<String,String> e : map.entrySet())
					{
						String ns = e.getValue().toString();
						NamespacePrefixElement elem = new NamespacePrefixElement((String)e.getKey(), ns, context,null); 
						elements.add(elem);
						if( BPELConstants.NAMESPACE_2007.equals(ns) ||
								process.getTargetNamespace().equals(ns))
						{
							elem.location = process.eResource().getURI().lastSegment();
						}
					}
				}
				catch (Exception e)
				{
					// ignore namespace map in extension activity eObjects ... for now
				}
				context = context.eContainer();
			}
		}

		// get the list of imports from the Process and try to correlate
		// the namespaces to the imported artifact in which it's defined
		List<Object> imports = new ArrayList<Object>();
		if ( process!=null )
		{
			for (org.eclipse.bpel.model.Import imp : process.getImports())
			{
				imports.add(imp);
				
				if ( imp.getImportType().equals(WSDLConstants.WSDL_NAMESPACE_URI) )
				{
					// yikes! don't load WSDLs from WS sites - this takes forever!
					if (!imp.getLocation().startsWith("http://") && !imp.getLocation().startsWith("https://"))
					{
						ImportResolver r = ImportResolverRegistry.INSTANCE.getResolvers(imp.getImportType())[0];
						// https://jira.jboss.org/browse/JBIDE-6917
						List<Object> rl = r.resolve(imp, ImportResolver.RESOLVE_DEFINITION);
						if (rl.size()>0)
						{
							Definition wsdl = (Definition) rl.get(0);
							recurseImports(wsdl.getImports(), imports, elements);
						}
					}
				}
			}
		}
		
		// now match up the namespaces from the imports to the local namespace maps in elements
		for (Object o : imports)
		{
			String namespace = "";
			String location = "";
			if (o instanceof org.eclipse.wst.wsdl.Import)
			{
				location = ((org.eclipse.wst.wsdl.Import)o).getLocationURI();
				namespace = ((org.eclipse.wst.wsdl.Import)o).getNamespaceURI();
			}
			else if (o instanceof org.eclipse.bpel.model.Import)
			{
				location = ((org.eclipse.bpel.model.Import)o).getLocation();
				namespace = ((org.eclipse.bpel.model.Import)o).getNamespace();
			}
			else
				continue;
			
			boolean found = false;
			for (NamespacePrefixElement elem : elements)
			{
				if (namespace.equals(elem.namespace))
				{
					if (elem.location==null)
						elem.location = location;
					found = true;
				}
			}
			if (!found)
			{
				// here's a namespace that wasn't found in any BPEL activity scope
				// let's add it to our list with an empty ns prefix and context.
				elements.add(new NamespacePrefixElement("", namespace, null, location));
			}
		}
		
		list.addAll(elements);
		// sort list alphabetically on prefix name
		Collections.sort(list,new Comparator<Object>()
		{
			public int compare(Object o1, Object o2) {
				return ((NamespacePrefixElement)o1).prefix.compareTo(((NamespacePrefixElement)o2).prefix);
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	private void recurseImports(@SuppressWarnings("rawtypes") Map m, List<Object> imports, List<NamespacePrefixElement>elements)
	{
		@SuppressWarnings("rawtypes")
		Iterator iter=m.entrySet().iterator();
		
		while(iter.hasNext())
		{
			@SuppressWarnings("rawtypes")
			Map.Entry e = (Entry) iter.next();
			ArrayList<org.eclipse.wst.wsdl.Import> v = (ArrayList<org.eclipse.wst.wsdl.Import>)e.getValue();
			for (org.eclipse.wst.wsdl.Import wsdlImp : v)
			{
				boolean foundNew = true;
				for (Object o : imports)
				{
					if (o instanceof org.eclipse.wst.wsdl.Import)
					{
						if ( ((org.eclipse.wst.wsdl.Import)o).getLocationURI().equals(wsdlImp.getLocationURI()) )
							foundNew = false;
					}
					else if (o instanceof org.eclipse.bpel.model.Import)
					{
						if ( ((org.eclipse.bpel.model.Import)o).getLocation().equals(wsdlImp.getLocationURI()) )
							foundNew = false;
					}
				}
				if (foundNew)
					imports.add(wsdlImp);
				
				// FIXME: we need to be able to support WSDL locations outside of the containing project!
				if (!wsdlImp.getLocationURI().startsWith("http://"))
				{
					if (wsdlImp.getDefinition()!=null)
					{
						// let's see if this WSDL defines a namespace for which we're missing a location
						for (NamespacePrefixElement elem : elements)
						{
							if (elem.location==null)
							{
								Map<Object,Object> ns = wsdlImp.getDefinition().getNamespaces();
								for (Map.Entry<Object,Object> ens : ns.entrySet())
								{
									if (ens.getValue().equals(elem.namespace))
									{
										elem.location = wsdlImp.getLocationURI();
										break;
									}
								}
								
							}
						}
						recurseImports(wsdlImp.getDefinition().getImports(), imports, elements);
					}
				}
			}
		}
	}
}
