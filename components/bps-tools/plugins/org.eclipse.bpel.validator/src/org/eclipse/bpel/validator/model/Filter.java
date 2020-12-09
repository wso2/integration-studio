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

import java.util.Comparator;

import javax.xml.namespace.QName;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 13, 2007
 *
 */
public class Filter {
	
	String fName;
	
	
	/**
	 * @return the name of this filter.
	 */
	public String getName () {
		return fName;
	}
	
	/**
	 * @param name
	 */
	public void setName ( String name ) {
		fName = name;
	}
	
	/**
	 * Comparator for QNames.
	 * 
	 */
	
	public static Comparator<QName> QNAME_COMPARATOR = new Comparator<QName>() {
		
		public int compare(QName o1, QName o2) {
			int result = o1.getLocalPart().compareTo(o2.getLocalPart());
			if (result == 0) {
				return o1.getNamespaceURI().compareTo(o2.getNamespaceURI());
			}			
			return result;
		}	
	};
	
	/**
	 * 
	 */
	public static Comparator<String> STRING_COMPARATOR = new Comparator<String>() {

		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}		
	};
	
	/**
	 * Create a readable values list.
	 * 
	 * @param vals the values
	 * @return the possible values passed as "readable" string.
	 */
	
	@SuppressWarnings("nls")
	protected String toString ( Object ... vals ) {
		StringBuilder sb = new StringBuilder();
		for(Object n : vals) {
			sb.append("\"").append(n).append("\"").append(", ");
		}
		sb.setLength(sb.length()-2);					
		return sb.toString();
	}
	
	
	/***
	 * @see java.lang.Object#toString()
	 */
	@Override	
	public String toString () {
		if (fName != null) {
			return fName;
		}
		return super.toString();
	}
}
