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
package org.eclipse.bpel.ui.extensions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IHoverHelper;
import org.eclipse.bpel.ui.bpelactions.AbstractBPELAction;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.properties.IAssignCategory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;


/**
 * Responsible for getting information from the BPEL UI extension points.
 */
public class BPELUIRegistry {

	static final String EXTPT_HOVERHELPERS = "hoverHelpers"; //$NON-NLS-1$
	static final String ELEMENT_HOVERHELPER = "hoverHelper"; //$NON-NLS-1$
	static final String ELEMENT_EDITOR = "editor"; //$NON-NLS-1$
	static final String ATT_EXPRESSION_LANGUAGE = "expressionLanguage"; //$NON-NLS-1$
	static final String ATT_CLASS = "class"; //$NON-NLS-1$
	static final String ATT_LABEL = "label"; //$NON-NLS-1$
	static final String EXTPT_ACTIONS = "actions"; //$NON-NLS-1$
	static final String EXTPT_ASSIGN_CATEGORY_ADDITIONS = "assignCategoryAdditions"; //$NON-NLS-1$
	static final String ELEMENT_CATEGORY = "category"; //$NON-NLS-1$
	static final String ATT_NAME = "name"; //$NON-NLS-1$
	static final String ATT_ID = "id"; //$NON-NLS-1$
	static final String ELEMENT_ACTION = "action"; //$NON-NLS-1$
	static final String ATT_CATEGORY_ID = "categoryId"; //$NON-NLS-1$
	static final String EXTPT_MODELLISTENER = "modelListener"; //$NON-NLS-1$
	static final String ELEMENT_LISTENER = "listener"; //$NON-NLS-1$
	static final String ATT_SPEC_COMPLIANT = "specCompliant"; //$NON-NLS-1$

	private static BPELUIRegistry instance;

	private HoverHelperDescriptor hoverHelperDescriptor;
	private ActionCategoryDescriptor[] fActionCategoryDescriptors;
	private ActionDescriptor[] fActionDescriptors;
	private ListenerDescriptor[] fListenerDescriptors;
	private UIObjectFactoryDescriptor[] uiObjectFactoryDescriptor;
	private IHoverHelper hoverHelper;

	private BPELUIRegistry() {
		readHoverHelpers();
		readActions();
		readListeners();
		readUIObjecFactories();
	}

	/**
	 * @return the singleton instance of this regitry.
	 */

	public static BPELUIRegistry getInstance() {
		if (instance == null) {
			instance = new BPELUIRegistry();
		}
		return instance;
	}


	/**
	 * Return the hover helper.
	 * @return the hover helper extension.
	 * @throws CoreException
	 */
	public IHoverHelper getHoverHelper() throws CoreException {

		if (this.hoverHelperDescriptor == null) {
			return null;
		}
		if (this.hoverHelper == null) {
			this.hoverHelper = this.hoverHelperDescriptor.createHoverHelper();
		}
		return this.hoverHelper;
	}

    /**
     * Return the UIObjectFactory descriptors
     */
	public UIObjectFactoryDescriptor[] getUIObjectFactoryDescriptors() {
        return this.uiObjectFactoryDescriptor;
    }

	/**
	 * Return all action descriptors.
	 * @return Return all action descriptors.
	 */
	public ActionDescriptor[] getActionDescriptors() {
	    return this.fActionDescriptors;
	}

	/**
	 * Returns the ActionDescriptor for the given EClass.
	 * @param target the target
	 * @return Returns the ActionDescriptor for the given EClass.
	 */
	public ActionDescriptor getActionDescriptor(EClass target) {
		for(ActionDescriptor descriptor : this.fActionDescriptors ) {
			if (descriptor.getAction().getModelType() == target) {
				return descriptor;
			}
		}
	    return null;
	}

	/**
	 * @return the action category descriptors.
	 */
	public ActionCategoryDescriptor[] getActionCategoryDescriptors() {
	    return this.fActionCategoryDescriptors;
	}

	/**
	 * @return the listener descriptors.
	 */
	public ListenerDescriptor[] getListenerDescriptors() {
	    return this.fListenerDescriptors;
	}

	private void readHoverHelpers() {

		for (IConfigurationElement helper : getConfigurationElements(EXTPT_HOVERHELPERS) ) {
			if (helper.getName().equals(ELEMENT_HOVERHELPER) == false) {
				continue;
			}

			String clazz = helper.getAttribute(ATT_CLASS);
			if (clazz == null) {
				continue;
			}

			HoverHelperDescriptor descriptor = new HoverHelperDescriptor();
			descriptor.setElement(helper);
			this.hoverHelperDescriptor = descriptor;
		}
	}

	/**
	 * Read all the actions and categories.
	 */
	private void readActions() {
	    List<ActionCategoryDescriptor> categories = new ArrayList<ActionCategoryDescriptor>();
	    List<ActionDescriptor> actions = new ArrayList<ActionDescriptor>();

		for (IConfigurationElement element : getConfigurationElements(EXTPT_ACTIONS)) {

			if (element.getName().equals(ELEMENT_CATEGORY)) {
				String name = element.getAttribute(ATT_NAME);
				String id = element.getAttribute(ATT_ID);
				if (name != null && id != null) {
					ActionCategoryDescriptor descriptor = new ActionCategoryDescriptor();
					descriptor.setName(name);
					descriptor.setId(id);
					categories.add(descriptor);
				}
			} else if (element.getName().equals(ELEMENT_ACTION)) {
				String id = element.getAttribute(ATT_ID);
				String category = element.getAttribute(ATT_CATEGORY_ID);
				String specCompliant = element.getAttribute(ATT_SPEC_COMPLIANT);
				if (category != null && id != null) {
					ActionDescriptor descriptor = new ActionDescriptor();
					descriptor.setId(id);
					descriptor.setCategoryId(category);
					descriptor.setSpecCompliant(Boolean.valueOf(specCompliant).booleanValue());
					try {
					    AbstractBPELAction action = (AbstractBPELAction)element.createExecutableExtension(ATT_CLASS);
						descriptor.setAction(action);
					} catch (CoreException e) {
						BPELUIPlugin.log(e);
					}
					actions.add(descriptor);

					// register AdapterFactory - since it has to be done only once we do it here
					AdapterFactory factory = descriptor.getAction().getAdapterFactory();
					if (factory != null) {
					    BPELUtil.registerAdapterFactory(descriptor.getAction().getModelType(), factory);
					}
				}
			}
		}

		this.fActionCategoryDescriptors = new ActionCategoryDescriptor[categories.size()];
		categories.toArray(this.fActionCategoryDescriptors);
		this.fActionDescriptors = new ActionDescriptor[actions.size()];
		actions.toArray(this.fActionDescriptors);
	}

    /**
     * Read all the actions and categories.
     */
    private void readUIObjecFactories() {

    	List factories = new ArrayList();
        IConfigurationElement[] extensions = getConfigurationElements("uiObjectFactories");
        for( IConfigurationElement element : extensions ) {
            if (element.getName().equals("factory")) {
                String id = element.getAttribute(ATT_ID);
                String category = element.getAttribute(ATT_CATEGORY_ID);
                String specCompliant = element.getAttribute(ATT_SPEC_COMPLIANT);
                if (category != null && id != null) {
                    UIObjectFactoryDescriptor descriptor = new UIObjectFactoryDescriptor();
                    descriptor.setId(id);
                    descriptor.setCategoryId(category);
                    descriptor.setSpecCompliant(Boolean.valueOf(specCompliant).booleanValue());
                    try {
                        AbstractUIObjectFactory factory = (AbstractUIObjectFactory) element.createExecutableExtension(ATT_CLASS);
                        descriptor.setFactory(factory);
                        descriptor.setConfigElement(element);
                    } catch (CoreException e) {
                        BPELUIPlugin.log(e);
                    }
                    factories.add(descriptor);
                }
            }
        }

        this.uiObjectFactoryDescriptor = new UIObjectFactoryDescriptor[factories.size()];
        factories.toArray(this.uiObjectFactoryDescriptor);
    }

    public List<IAssignCategory> getAdditionalAssignCategories() {
		List<IAssignCategory> assignCategories = new LinkedList<IAssignCategory>();
    	IConfigurationElement[] extensions = getConfigurationElements(EXTPT_ASSIGN_CATEGORY_ADDITIONS);
        for( IConfigurationElement element : extensions ) {
        	//String name = element.getAttribute(ATT_NAME);
        	try {
				IAssignCategory assignCategory = (IAssignCategory) element.createExecutableExtension(ATT_CLASS);
				assignCategories.add(assignCategory);
				System.out.println(assignCategory);
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
        }
		return assignCategories;
	}

	/**
	 * Read all the model listeners
	 */
	private void readListeners() {
	    List<ListenerDescriptor> listeners = new ArrayList<ListenerDescriptor>();

	    for (IConfigurationElement element : getConfigurationElements(EXTPT_MODELLISTENER)) {
			if (element.getName().equals(ELEMENT_LISTENER)) {
				String id = element.getAttribute(ATT_ID);
				if (id != null) {
					ListenerDescriptor descriptor = new ListenerDescriptor();
					descriptor.setId(id);
					try {
					    IModelListener listener = (IModelListener)element.createExecutableExtension(ATT_CLASS);
						descriptor.setModelListener(listener);
					} catch (CoreException e) {
						BPELUIPlugin.log(e);
					}
					listeners.add(descriptor);
				}
			}
		}

		this.fListenerDescriptors = new ListenerDescriptor[listeners.size()];
		listeners.toArray(this.fListenerDescriptors);
	}

	/**
	 * Given an extension point name returns its configuration elements.
	 */
	private IConfigurationElement[] getConfigurationElements(String extensionPointId) {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
			BPELUIPlugin.PLUGIN_ID, extensionPointId);
		if (extensionPoint == null) {
			return null;
		}
		return extensionPoint.getConfigurationElements();
	}
}
