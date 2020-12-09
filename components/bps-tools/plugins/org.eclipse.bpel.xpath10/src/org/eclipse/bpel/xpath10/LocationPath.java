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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Location path expression in XPath.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */

@SuppressWarnings("nls")

public class LocationPath extends Expr {

	List<Step> fSteps = new ArrayList<Step>();
	boolean fAbsolute = false;
	
	/**
	 * A brand new shiny LocationPath expression.
	 * 
	 * @param abs is it an absolute path ? true/false
	 * @param steps the steps in the path.
	 */
	public LocationPath ( boolean abs, Step ... steps) {
		super(null);
		fAbsolute = abs;
		for(Step s : steps) {
			addStep(s);			
		}		
	}
	
	/**
	 * Add a step to this path expression.
	 * 
	 * @param s step
	 */
	public void addStep (Step s) {
		if (s != null) {
			fSteps.add(s);
		}
	}
	
	/**
	 * Add as the first step of the path (from the beginning).
	 * 
	 * @param s
	 */
	public void addFirstStep (Step s) {
		if (s != null) {
			fSteps.add(0, s);
		}
	}
	
	/** 
	 * @return the steps in the location path expression.
	 */
	public List<Step> getSteps () {
		return fSteps;
	}
	
	/**
	 * @return is it an absolute path expression ?
	 */
	public boolean isAbsolute() {
		return fAbsolute;
	}
	
	/**
	 * Set if expression is absolute (from parser).
	 * @param v true/false 
	 */
	public void setIsAbsolute (boolean v) {
		fAbsolute = v;
	}
	

	@Override
	protected String asText()
    {
        StringBuilder buf = new StringBuilder();
        if (isAbsolute()) {
        	buf.append("/");
        }
        Iterator<Step> stepIter = getSteps().iterator();
        while (stepIter.hasNext())
        {
            buf.append(stepIter.next().getText());
            if (stepIter.hasNext())
            {
                buf.append("/");
            }
        }
        return buf.toString();
    }
	
	/**
	 * @see org.eclipse.bpel.xpath10.Expr#toString()
	 */
	
	@Override
	public String toString()
    {
        StringBuilder buf = new StringBuilder();
        buf.append("{");
        buf.append(getClass().getSimpleName());
        buf.append(",").append(isAbsolute()).append(",");
        
        Iterator<Step> stepIter = getSteps().iterator();
        while (stepIter.hasNext())
        {
            buf.append( stepIter.next() );
            if (stepIter.hasNext())
            {
                buf.append("/");
            }
        }
        buf.append("}");
        return buf.toString();
    }

	/**
	 * @see org.eclipse.bpel.xpath10.Expr#getPosition()
	 */
	@Override
	public int getPosition () 
	{
		return fSteps.size() > 0 ? fSteps.get(0).getPosition() : -1;
	}
	
	/**
	 * @see org.eclipse.bpel.xpath10.Expr#getEndPosition()
	 */
	@Override
	public int getEndPosition () {
		int size = fSteps.size();
		return size > 0 ? fSteps.get(size-1).getEndPosition() : -1;
	}
}
