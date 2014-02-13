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
