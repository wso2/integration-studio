/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.provider.ModelObjectItemProvider;

/**
 * A custom item provider that wraps emf generated item providers. This is
 * useful when we need to globally control the behaviour of model objects
 * on the ui.
 */
public class CustomDelegatingItemProvider 
	extends ItemProviderAdapter 
	implements 
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	
	/**
	 * Internally wrapped item provider.
	 */
	private ModelObjectItemProvider actualItemProvider;
	
	/**
	 * Creates a new custom item provider wrapping the specified {@link ModelObjectItemProvider}.
	 * 
	 * @param itemProvider internally used {@link ModelObjectItemProvider} instance.
	 */
	public CustomDelegatingItemProvider(ModelObjectItemProvider itemProvider) {
        super(itemProvider.getAdapterFactory());
        this.actualItemProvider = itemProvider;
    }	
	
	/**
	 * {@inheritDoc}
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		ModelObject modelObj = (ModelObject) object;
		switch (modelObj.getObjectState()) {
			case NORMAL: 
				return actualItemProvider.getPropertyDescriptors(object);
			default: 
				return new ArrayList<IItemPropertyDescriptor>();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getChildren(Object object) {
		ModelObject modelObj = (ModelObject) object;
		switch (modelObj.getObjectState()) {
			case NORMAL: 
				return actualItemProvider.getChildren(object);
			default:
				return new ArrayList<EStructuralFeature>();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Object getImage(Object object) {
		ModelObject modelObj = (ModelObject) object;
		switch (modelObj.getObjectState()) {
			case WORKING:
				return overlayImage(object, getResourceLocator().getImage("full/obj16/ModelObjectWorking"));
			case INCOMPLETE:
				return overlayImage(object, getResourceLocator().getImage("full/obj16/ModelObjectIncomplete"));
			case INVALID:
				return overlayImage(object, getResourceLocator().getImage("full/obj16/ModelObjectInvalid"));
			default:
				return actualItemProvider.getImage(object);			
		}
    }

	/**
	 * {@inheritDoc}
	 */
	public String getText(Object object) {
		ModelObject modelObj = (ModelObject) object;
		switch (modelObj.getObjectState()) {
			case WORKING:
				return getString("_UI_ModelObject_working");
			case INCOMPLETE:
				return getString("_UI_ModelObject_incomplete");
			case INVALID:
				return getString("_UI_ModelObject_invalid");
			default:
				return actualItemProvider.getText(object);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		// This is required to make sure that all the children are refreshed when model object state changes.
		if (EsbPackage.MODEL_OBJECT__OBJECT_STATE == notification.getFeatureID(ModelObject.class)) {
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
		} else {
			actualItemProvider.notifyChanged(notification);
		}	       
    }

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
		ModelObject modelObj = (ModelObject) object;
		switch (modelObj.getObjectState()) {
			case NORMAL:
				return actualItemProvider.getNewChildDescriptors(object, editingDomain, sibling);
			default:
				// Return empty list.
				return new ArrayList<Object>();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Command createCommand(Object object, EditingDomain domain, Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		return actualItemProvider.createCommand(object, domain, commandClass, commandParameter);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ResourceLocator getResourceLocator() {
        return actualItemProvider.getResourceLocator();
    }
}
