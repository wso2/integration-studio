/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.contentassist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.fnmeta.model.Argument;
import org.eclipse.bpel.fnmeta.model.Function;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.expressions.Functions;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 27, 2006
 *
 */

@SuppressWarnings("nls")
public class FunctionTemplatesContentAssistProcessor extends TemplateCompletionProcessor {
		
	static final String XPATH_FUNCTIONS = "xpath.functions";
	
	/** Template context type */
	TemplateContextType fTemplateContextType;

	/** Build the templates */
	Template[] fTemplates = {};
		
	/** The context model object */
	EObject fModel;
	
	
	/**
	 * @param model
	 */

	public void setModel (Object model) {
		assert model instanceof EObject : "argument is not an EObject";
		fModel = (EObject) model;	
	}
	
	/**
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getContextType(org.eclipse.jface.text.ITextViewer, org.eclipse.jface.text.IRegion)
	 */
	@Override
	protected TemplateContextType getContextType (ITextViewer viewer, IRegion region) {
		if (fTemplateContextType == null) {
			fTemplateContextType = new TemplateContextType (XPATH_FUNCTIONS,"XPath functions");  //$NON-NLS-1$
		}
		return fTemplateContextType;		
	}

	/**
	 * 
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getImage(org.eclipse.jface.text.templates.Template)
	 */
	@Override
	protected Image getImage(Template template) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_EXPR_FUNCTION);		
	}

	/**
	 * Compute the templates that we use as the completion proposals for our
	 * functions.  
	 * 
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getTemplates(java.lang.String)
	 */
	@Override
	protected Template[] getTemplates (String contextTypeId) {
		
		if ( XPATH_FUNCTIONS.equals ( contextTypeId )) {
			
			if (fTemplates.length == 0) {
				
				Map<String,Function> fnMap = Functions.getInstance(BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE).getFunctions();
				List<Template> list = new ArrayList<Template>( fnMap.size() );
				
				for(Function fn : fnMap.values() ) {
					
					String ns = fn.getNamespace();
					
					if (BPELUtils.isEmptyOrWhitespace(ns) || BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE.equals(ns) ) {
						list.add(new Template (fn.getName(),fn.getHelp(),contextTypeId,getPattern(fn),true)) ;
					} else {
						String pfx = getPrefix ( ns , fn.getPrefix() );
						if (pfx == null) {
							continue ;
						}
						list.add(new Template (pfx + ":" + fn.getName(),fn.getHelp(),contextTypeId,getPattern(fn),true)) ;
					}
				}
				fTemplates = list.toArray(fTemplates);
				
				if (fTemplates.length > 1) {
					Arrays.sort(fTemplates,new Comparator<Template> () {
						public int compare(Template o1, Template o2) {
							return o1.getName().compareTo(o2.getName() );
						}						
					});
				}

			}
		}
		return fTemplates;
	}		
	
	
	String getPrefix ( String ns , String preferredPrefix ) {
		
		/** 
		 * Namespaces must be mapped to a prefix as the template proposal is going
		 * to generate a proposal where the prefix is used.
		 */
		
		String pfx = BPELUtils.getNamespacePrefix (fModel, ns);			
		
		/** Valid, already mapped prefix */
		if (BPELUtils.isEmptyOrWhitespace(pfx) == false) {
			return pfx;
		}
	
		/** Not yet mapped */			
		pfx = preferredPrefix;		
		if (BPELUtils.isValidPrefixName(pfx) ) {
			// problem
			return null;
		}
		
		return pfx;

	}
				
	/** This has to be someplace else, as this really just XPath formatting */
	
	@SuppressWarnings("boxing")
	String getPattern( Function fn ) {
		
		StringBuilder builder = new StringBuilder(128);
		
		String ns = fn.getNamespace();
		if (BPELUtils.isEmptyOrWhitespace(ns) == false && BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE.equals(ns) == false) {
			// map the namespace prefix. 
			String pfx = getPrefix( ns, fn.getPrefix() );
			// This must not be null here			
			assert (pfx != null) : "Prefix for ns=" + ns + " cannot be null here" ;			
			builder.append(pfx).append(":");
		}
		
		builder.append(fn.getName()).append("(");
		
		int argCount = fn.getArguments().size();
		
		for(Argument a : fn.getArguments()) {
			builder.append("${").append(a.getName()).append("}");
			switch (a.getOptionality()) {
				case OPTIONAL : 
					builder.append("?");
					break;
				case OPTIONAL_MANY : 
					builder.append("*");
					break;
				case REQUIRED :
					break;
			}
			
			builder.append(", ");
		}
		if (argCount > 0) {
			// delete the last ", "
			builder.setLength( builder.length() - 2);
		}
		
		builder.append(")");
		return builder.toString();				
	}
}
