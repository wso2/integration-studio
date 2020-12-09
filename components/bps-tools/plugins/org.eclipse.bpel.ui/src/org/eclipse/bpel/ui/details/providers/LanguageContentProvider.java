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
package org.eclipse.bpel.ui.details.providers;

import java.util.List;
import java.util.Locale;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 15, 2007
 *
 */
public class LanguageContentProvider extends AbstractContentProvider {
	/**
	 * @see org.eclipse.bpel.ui.details.providers.AbstractContentProvider#collectElements(java.lang.Object, java.util.List)
	 */
	@Override
	public void collectElements (Object input, List<Object> list)  {

		if (input instanceof Locale == false) {
			return ;
		}
		
		for(Locale locale : Locale.getAvailableLocales()) {
			list.add ( locale );
		}
		
	}
}
