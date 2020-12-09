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
package org.eclipse.bpel.ui.editparts.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.IOutlineEditPartFactory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;


public class OutlineTreePartFactory implements EditPartFactory {
	
	public EditPart createEditPart(EditPart context, Object model) {
		IOutlineEditPartFactory factory = BPELUtil.adapt(model, IOutlineEditPartFactory.class);
		if (factory != null) {
			return factory.createOutlineEditPart(context, model);
		}
		return null;
	}

	/**
	 * Gets the model children in an special order and nesting for the Outline view.
	 * The root element on the tree are Partners, Variables, Correlation Sets and
	 * the first activity of the process.
	 */
	public static List getModelChildren(Object model) {
		if (model == null)  return Collections.EMPTY_LIST;
		List result = new ArrayList();
		if (model instanceof Process) {
			Process process = (Process)model;
			Object[] rootItems = {process.getPartnerLinks(), process.getVariables(), process.getCorrelationSets(), process.getMessageExchanges()};
			for (int i = 0; i < rootItems.length; i++) {
				if (rootItems[i] != null) {
					result.add(rootItems[i]);
				}
			}
			IContainer container = BPELUtil.adapt(model, IContainer.class);
			List children = container.getChildren(model);
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				Object element = iter.next();
				if (!(element instanceof PartnerLink || element instanceof Variable || element instanceof CorrelationSet || element instanceof MessageExchange)) {
					result.add(element);
				}
			}
			return result;
		}
		IContainer container = BPELUtil.adapt(model, IContainer.class);
		if (container == null)  return Collections.EMPTY_LIST;
		return container.getChildren(model);
	}
}