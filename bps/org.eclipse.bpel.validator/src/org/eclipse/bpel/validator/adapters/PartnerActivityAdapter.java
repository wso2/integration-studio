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
package org.eclipse.bpel.validator.adapters;

/**
 * BPEL validation model dependency
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.PartnerActivity;
import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.INode;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 20, 2006
 */


public class PartnerActivityAdapter extends BasicAdapter {

	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.adapters.BasicAdapter#getNodeList(javax.xml.namespace.QName)
	 */
	
	@Override
	public List<INode> getNodeList ( QName name ) {
		PartnerActivity pa = (PartnerActivity) getTarget();
		
		if (IConstants.ND_CORRELATION.getLocalPart().equals( name )) {
			Correlations c = pa.getCorrelations();
			if (c != null) {
				ArrayList<INode> children = new ArrayList<INode> ( c.getChildren().size() );
				for(Correlation next : c.getChildren()) {
					children.add( adapt ( next, INode.class ));
				}				
			}
			return Collections.emptyList();
		}	
		return super.getNodeList(name);
	}
	


	
}
