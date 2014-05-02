/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.extensions;

import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.core.runtime.IConfigurationElement;

public class UIObjectFactoryDescriptor {
	
	protected String id;
	protected String categoryId;
	protected AbstractUIObjectFactory factory;
	protected boolean specCompliant;
	protected IConfigurationElement configElement;

	public UIObjectFactoryDescriptor() {
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public AbstractUIObjectFactory getFactory() {
		return factory;
	}

	public void setFactory(AbstractUIObjectFactory factory) {
		this.factory = factory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSpecCompliant() {
		return specCompliant;
	}

	public void setSpecCompliant(boolean specCompliant) {
		this.specCompliant = specCompliant;
	}

	/**
	 * @return Returns the configElement.
	 */
	public IConfigurationElement getConfigElement() {
		return configElement;
	}

	/**
	 * @param configElement
	 *            The configElement to set.
	 */
	public void setConfigElement(IConfigurationElement configElement) {
		this.configElement = configElement;
	}
}
