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
package org.eclipse.bpel.validator;

import org.eclipse.core.resources.IMarker;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 14, 2007
 *
 */

@SuppressWarnings("nls")
public interface IBPELMarker extends IMarker {
	
	/**
	 * Our id
	 */
	String ID = "org.eclispe.bpel.validator.marker";
	
	/**
	 * The address XPath attribute of this marker
	 */
	String ADDRESS_XPATH = "address.xpath";
	
	/**
	 * The model address path of this marker
	 */
		
	String ADDRESS_MODEL = "address.model";
}
