/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.providers;

import javax.xml.namespace.QName;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.wsdl.Part;

public class PartLabelProvider extends ModelLabelProvider {
	
	@Override
	public String getText(Object object) {
		String result = super.getText(object);
		if (result != null) {
			String localPart = Messages.PartLabelProvider__none__1; 
			QName typeName = ((Part)object).getTypeName();
			if (typeName != null) {
				localPart = typeName.getLocalPart();
			} else {
				QName elementName = ((Part)object).getElementName();
				if (elementName != null) localPart = elementName.getLocalPart();
			}
			if (localPart == null || "".equals(localPart))  localPart = "??"; //$NON-NLS-1$ //$NON-NLS-2$
			return NLS.bind(Messages.PartLabelProvider_result_localPart, (new String[] {result, localPart})); 
		}
		return result;
	}
}
