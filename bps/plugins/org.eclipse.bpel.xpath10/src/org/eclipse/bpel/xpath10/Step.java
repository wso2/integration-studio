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
import java.util.List;

/**
 * A step in the location path ...
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */

@SuppressWarnings("nls")
public class Step {

	int fAxis = 0;
	List<Predicate> fList = new ArrayList<Predicate>();
	
	int fStartPosition = -1;
	int fEndPosition = -1;
	
	/**
	 * Bran new step ... on the axis specified.
	 * 
	 * @param axis
	 */
	public Step (int axis) {
		fAxis = axis;			
	}
	
	
	/**
	 * @return return the text of this step.
	 */

	public String getText()
    {
        StringBuilder buf = new StringBuilder();
        buf.append(getAxisName());
        buf.append("::");
        buf.append(asText());
        
        for(Predicate p : fList) {
        	buf.append(p.getText());
        }
        return buf.toString();
    }
	
	protected String asText () {
		return "?";
	}
	
	/**
	 * @return the axis of this step.
	 */
	public int getAxis () {
		return fAxis;
	}
	
	/**
	 * Set the axis of this step (from parser).
	 * 
	 * @param axis the axis of this step.
	 */
	public void setAxis (int axis) {
		fAxis = axis;
	}
	
	/**
	 * Add a predicate to this step.
	 * 
	 * @param predicate
	 */
	public void addPredicate(Predicate predicate)
	{
		if (predicate != null) {
			fList.add(predicate);
		}
	}
	
    /**
     * @return all predicates of this step. 
     */
    public List<Predicate> getPredicates() {
    	return fList;
    }
    
    /**
     * @return the axis name.
     */
    public String getAxisName ()
    {
    	return Axis.getName(fAxis);
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    @Override
	public String toString () {
    	StringBuilder sb = new StringBuilder();
    	sb.append("{").append(getClass().getSimpleName()).append(",").append(getAxisName()).append(",");
    	sb.append(asString());
    	sb.append(",[");
    	for(Predicate p : fList) {
    		sb.append(p);
    		sb.append(",");
    	}
    	sb.append("]");
    	sb.append("}");
    	return sb.toString();
    }
    
    protected String asString () {
    	return null;
    }
    
    
    /**
     * @return the end position of this step in the input "stream"
     */
    public int getEndPosition() {
		return fEndPosition;
	}

    /**
     * @return the start position of this step in the input "stream"
     */

	public int getPosition() {
		return fStartPosition;
	}
	
	/**
	 * Set the position of this step in the input stream.
	 * This is called by the parser ...
	 * 
	 * @param start
	 * @param end
	 */
	public void setPosition (int start, int end) {
		fStartPosition = start;		
		fEndPosition = end;
	}
    
}
