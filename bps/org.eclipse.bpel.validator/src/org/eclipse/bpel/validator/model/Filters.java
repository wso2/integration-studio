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

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.helpers.NCNameWordDetector;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 6, 2006
 *
 */

@SuppressWarnings("nls")
public class Filters implements IConstants {

	/** Scope or process filter. */
	static public final IFilter<INode> SCOPE_OR_PROCESS = new NodeNameFilter ( ND_SCOPE, ND_PROCESS );

	/** Scope selector */
	public static final IFilter<INode> SCOPE = new NodeNameFilter( ND_SCOPE ) ;
	
	/** Process selector/filter */
	public static final IFilter<INode> PROCESS = new NodeNameFilter ( ND_PROCESS );
	
	/** Flow */
	public static final IFilter<INode> FLOW = new NodeNameFilter( ND_FLOW );
	
	/** Boolean filter values */
	static public final IFilter<String> BOOLEAN_FILTER = new ValueFilter<String> ( Filter.STRING_COMPARATOR, BOOLEAN_VALUES );
	
	/** Initiate filter values */
	public static final IFilter<String> INITIATE_FILTER = new ValueFilter<String> (Filter.STRING_COMPARATOR,INITIATE_VALUES);

	/** End point values */
	public static final IFilter<String> ENDPOINT_FILTER = new ValueFilter<String> (Filter.STRING_COMPARATOR,ENDPOINT_VALUES);

	/** Correlation pattern values */
	public static final IFilter<String> PATTERN_FILTER = new ValueFilter<String> ( Filter.STRING_COMPARATOR,PATTERN_VALUES );
	
	/** Repeatable nodes */
	public static final IFilter<INode> REPEATABLE_CONSTRUCT = new NodeNameFilter ( REPEATABLE_NODES );
	
	/** Event handler boundary */
	public static final IFilter<INode> FAULT_HANDLER_BOUNDARY = new NodeNameFilter ( FAULT_HANDLER_BOUNDARY_NODES );
	
	/** FCT-Handlers */
	public static final IFilter<INode> FCT_HANDLER = new NodeNameFilter ( FCT_HANDLERS );
	
	/** The BPEL activities filter */
	static public final IFilter<INode> ACTIVITIES = new NodeNameFilter( BPEL_ACTIVITIES ) {
		@Override
		public String toString() {
			return "text.bpel.activities.filter";
		}
	};

	
	/** Activity containers filter */
	static public final IFilter<INode> ACTIVITY_CONTAINER = new NodeNameFilter( BPEL_ACTIVITIES_CONTAINERS ) {
		@Override
		public String toString() {
			return "text.bpel.activities.container.filter";
		}
		
	};

	
	/** The Any filter */
	public static final IFilter<INode> ANY = new NodeNameFilter(new QName("*"));
	
	/** The empty filter */
	public static final IFilter<INode> EMPTY = new NodeNameFilter();
	
	/** An NC_NAME Filter */
	public static final IFilter<String> NC_NAME = new IFilter<String> () {
		
		NCNameWordDetector fWordDetector = new NCNameWordDetector();
		
		public boolean select (String name) {
			return fWordDetector.isValid(name);
		}
		
		@Override
		public String toString() {
			return "Valid-NCName";
		}
	};
	
	
	/**
	 * Standard faults filter.
	 */
	
	static public final IFilter<QName> STANDARD_FAULTS = new ValueFilter<QName>( Filter.QNAME_COMPARATOR, BPEL_STANDARD_FAULTS) ;			
	
}
