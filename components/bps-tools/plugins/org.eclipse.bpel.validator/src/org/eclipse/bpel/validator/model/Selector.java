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

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;


/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 18, 2006
 *
 */

@SuppressWarnings("nls")

public class Selector {		
	
		
	/** Selection of all nodes at a given level */
	
	public static final String ALL = "*";  //$NON-NLS-1$
	
	
	/**
	 * Brand new shiny selector.
	 */
	
	public  Selector () {
	}
	
	/**
	 * Select the nodes according to the simple path specified.
	 * 
	 * @param context
	 * @param segments
	 * @return the selected INode or null
	 */
	
	
	public INode selectNode ( INode context, Object ... segments ) {
		List<INode> nodes = selectNodes ( context, segments );
		return ( nodes.size() > 0 ? nodes.get(0) : null);
	}
	
	
	/**
	 * Select a parent node 
	 * @param context
	 * @param filter
	 * @return the parent node that matches the filer
	 */
	
	public INode selectParent (INode context, IFilter<INode> filter) {
		
		if (context == null) {
			return context;
		}
		
		do {			
			if (filter.select(context)) {
				return context;
			}
			context = context.parentNode();
		} while (context != null);
		
		return context;
	}
	
	
	/**
	 * Select the node given a context node according to the simple
	 * path specified. The path is a list of arguments that are either
	 * String or numbers. 
	 * 
	 * @param context
	 * @param segments
	 * 
	 * @return the list of nodes that matches the selection.
	 */
	
	
	@SuppressWarnings("unchecked")
	public List<INode> selectNodes ( INode context, Object ... segments ) {
				
		List<INode> list = new ArrayList<INode>();
		
		int n;
		String s;
		IFilter<INode> filter;
		
		for (Object obj : segments) {
			
			// if we ever don't have context, then we are done
			if (context == null) {
				break;
			}
			
			// filter just filters what's in the list so far
			if (obj instanceof IFilter) {
				
				filter = (IFilter<INode>) obj;
				
				List<INode> newList = new ArrayList<INode>();
				for(INode node : list ) {
					if (filter.select(node)) {
						newList.add(node);
					}
				}
				
				list = newList;				
				context = list.size() > 0 ? (INode) list.get(0) : null;
				
			} else 	if (obj instanceof String) {
				
				list = selectNodesByName ( context, (String) obj );				
				context = list.size() > 0 ? (INode) list.get(0) : null;
				
			} else if (obj instanceof QName) { 
				list = selectNodesByName ( context, (QName) obj );
				context = list.size() > 0 ? (INode) list.get(0) : null;
			} else if (obj instanceof Number) {
				
				// selection of new context			
			
				n = ((Number)obj).intValue() - 1;				
				list.clear();
				
				try {
					context = list.get(n);
					if (context != null) {
						list.add ( context );
					}
					
				} catch (IndexOutOfBoundsException ioobe) {
					context = null; 
				}
				
			} else {
				// no idea what I am doing.
				list.clear();				
				context = null;
			}			
		}
		
		return list;
	}
	
	
	/**
	 * Select nodes by Name.
	 * 
	 * @param context
	 * @param s
	 * @return a list of nodes matching the name
	 */
	

	List<INode> selectNodesByName ( INode context, QName s ) {
	
		List<INode> list = new ArrayList<INode>();
		
		if (s.getLocalPart().equals("..")) {
			
			INode parent = context.parentNode();
			if (parent != null) {
				list.add(parent);
			}
			
		} else {
			
			List<INode> children = context.children();
			if (s.equals(ALL) ) {
				list.addAll( children );
			} else {
				for(INode n : children) {
					if (s.equals(n.nodeName())) {
						list.add(n);
					}
				}
			}			
		}
		return list;
	}		
	
	/**
	 * Select nodes by Name.
	 * 
	 * @param context
	 * @param s
	 * @return a list of nodes matching the name
	 */
	

	List<INode> selectNodesByName ( INode context, String s ) {
	
		List<INode> list = new ArrayList<INode>();
		
		if (s.equals("..")) {
			INode parent = context.parentNode();
			if (parent != null) {
				list.add(parent);
			}
		} else {
			
			List<INode> children = context.children();
			if (s.equals(ALL) ) {
				list.addAll( children );
			} else {
				for(INode n : children) {
					if (s.equals(n.nodeName().getLocalPart())) {
						list.add(n);
					}
				}
			}			
		}
		return list;
	}		
	
}
