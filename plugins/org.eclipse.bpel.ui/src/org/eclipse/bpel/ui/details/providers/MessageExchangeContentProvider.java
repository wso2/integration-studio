/**
 * <copyright>
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 */
 
package org.eclipse.bpel.ui.details.providers;

import java.util.List;

import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Miriam Grundig (MGrundig@de.ibm.com)
 */
public class MessageExchangeContentProvider extends AbstractContentProvider{
	
	/**
	 * @see org.eclipse.bpel.ui.details.providers.AbstractContentProvider#collectElements(java.lang.Object, java.util.List)
	 */
	@Override
	public void collectElements (Object input, List<Object> list)  {
		EObject elem = (EObject) input;
		MessageExchanges messExs;
		List<MessageExchange> children;
		while(elem != null){
			if(elem instanceof Scope){
				messExs = ((Scope)elem).getMessageExchanges();
				if(messExs != null){
					children =  messExs.getChildren(); 
					for(MessageExchange child: children) {
						list.add ( child );
					}
				}
			}
			if (elem instanceof Process){
				messExs = ((Process)elem).getMessageExchanges();
				if(messExs != null){
					children =  messExs.getChildren(); 
					for(MessageExchange child: children) {
						list.add ( child );
					}
				}
			}
			elem = elem.eContainer();
		}
	}
}
