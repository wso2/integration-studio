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
package org.eclipse.bpel.ui.util;

import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.tools.CreationTool;


/**
 * @author IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date January 2006
 *
 */

public class BPELCreationToolEntry extends CombinedTemplateCreationEntry  {

	/**
	 * Return a brand new shiny Creation Tool Entry.
	 * @param label
	 * @param shortDesc
	 * @param aFactory
	 */
	
	public BPELCreationToolEntry(String label, String shortDesc, AbstractUIObjectFactory aFactory) {
		super(label, shortDesc, aFactory, aFactory.getSmallImageDescriptor(), aFactory.getLargeImageDescriptor());
		// setType("not-a-builtin-type"); // hack! //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.gef.palette.ToolEntry#createTool()
	 */
	@Override
	public Tool createTool() {
		CreationFactory aFactory = (CreationFactory)getToolProperty(CreationTool.PROPERTY_CREATION_FACTORY);
		CreationTool tool = new BPELCreationTool(aFactory);
		tool.setUnloadWhenFinished(true);
		return tool;
	}

	/**
	 * 
	 * @return Return the UI object factory.
	 */
	
	public AbstractUIObjectFactory getUIObjectFactory() {
		CreationFactory aFactory = (CreationFactory) getToolProperty(CreationTool.PROPERTY_CREATION_FACTORY);
		return (AbstractUIObjectFactory) aFactory;
	}
}