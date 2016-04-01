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

import java.util.Arrays;
import java.util.Comparator;

/**
 * Simple value filter
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 * @param <T> The type
 * @date Jan 26, 2007
 * 
 */
public class ValueFilter<T> extends Filter implements IFilter<T> {

	T[] fList;
	Comparator<T> fComparator;
		
	/**
	 * @param comparator
	 * @param values
	 */
	public ValueFilter (Comparator<T> comparator, T ... values) {
		fList = values;
		fComparator = comparator;
		Arrays.sort(fList, fComparator);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @param node
	 *            the node (name)
	 * @return whether node passes the filter.
	 * @see org.eclipse.bpel.validator.model.IFilter#select(java.lang.Object)
	 */
	public boolean select(T node) {
		if (fComparator != null) {
			return (Arrays.binarySearch(fList, node,fComparator) >= 0);
		}
		return (Arrays.binarySearch(fList, node ) >= 0);
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return toString(fList);
	}
}