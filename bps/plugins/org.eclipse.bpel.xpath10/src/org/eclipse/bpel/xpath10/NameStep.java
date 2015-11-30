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

package org.eclipse.bpel.xpath10;

/**
 * Name step in a location path.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */

@SuppressWarnings("nls")
public class NameStep extends Step {
	
	String fPrefix ;
	String fLocalName;
	boolean matchesAnyName = false;
	
	/**
	 * Brand new shiny NameStep ...
	 * 
	 * @param axis 
	 * @param prefix
	 * @param name
	 */
	
	public NameStep ( int axis, String prefix, String name ) {
		super(axis);
		fPrefix = prefix;
		fLocalName = name;
		matchesAnyName = "*".equals(fLocalName);
	}
	
	/**
	 * @return the prefix in the name step.
	 */
	
	public String getPrefix () {
		return fPrefix;
	}
	/**
	 * @return the local name of the name step.
	 */
	
	public String getLocalName() {
		return fLocalName;
	}

	/**
	 * 
	 * @return is this a * ?
	 */
	public boolean isMatchesAnyName() {
        return matchesAnyName;
    }

    
	@Override
	protected String asString () {
		return asText();
	}
	
	@Override
	protected String asText() {
		StringBuilder buf = new StringBuilder(64);

		if (getPrefix() != null && getPrefix().length() > 0) {
			buf.append(getPrefix()).append(':');
		}
		buf.append(getLocalName());
		return buf.toString();
	}
}

