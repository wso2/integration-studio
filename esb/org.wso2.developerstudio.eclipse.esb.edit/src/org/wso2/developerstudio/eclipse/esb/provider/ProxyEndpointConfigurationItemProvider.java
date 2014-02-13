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
package org.wso2.developerstudio.eclipse.esb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyEndpointType;
import org.wso2.developerstudio.eclipse.esb.UnexecutableCreateChildCommand;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProxyEndpointConfigurationItemProvider
	extends ModelObjectItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyEndpointConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		ProxyEndpointConfiguration endpointConfiguration = (ProxyEndpointConfiguration) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addEndpointTypePropertyDescriptor(object);
		
		switch (endpointConfiguration.getEndpointType()) {
			case REGISTRY_REFERENCE: {
				addEndpointKeyPropertyDescriptor(object);
				break;
			}
			
			case NAMED_REFERENCE: {
				addEndpointNamePropertyDescriptor(object);
				break;
			}
			
			default: {
				// Do nothing.
			}
		}				
		
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Endpoint Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyEndpointConfiguration_endpointType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyEndpointConfiguration_endpointType_feature", "_UI_ProxyEndpointConfiguration_type"),
				 EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyEndpointConfiguration_endpointKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyEndpointConfiguration_endpointKey_feature", "_UI_ProxyEndpointConfiguration_type"),
				 EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyEndpointConfiguration_endpointName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyEndpointConfiguration_endpointName_feature", "_UI_ProxyEndpointConfiguration_type"),
				 EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		ProxyEndpointConfiguration endpointConfiguration = (ProxyEndpointConfiguration) object;
		if (childrenFeatures != null) {
			childrenFeatures.clear();
		}
		super.getChildrenFeatures(object);
		
		if (endpointConfiguration.getEndpointType().equals(ProxyEndpointType.ANONYMOUS)) {
			childrenFeatures.add(EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT);
		}
		
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ProxyEndpointConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProxyEndpointConfiguration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return getString("_UI_ProxyEndpointConfiguration_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ProxyEndpointConfiguration.class)) {
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY:
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		EndPoint endpoint = EsbFactory.eINSTANCE.createDefaultEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT,endpoint));

		endpoint = EsbFactory.eINSTANCE.createAddressEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, endpoint));

		endpoint = EsbFactory.eINSTANCE.createWsdlEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, endpoint));

		endpoint = EsbFactory.eINSTANCE.createFailoverEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, endpoint));

		endpoint = EsbFactory.eINSTANCE.createLoadBalanceEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, endpoint));
		
		endpoint = EsbFactory.eINSTANCE.createDynamicLoadBalanceEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, endpoint));
	}

	/**
	 * {@inheritDoc}
	 */
	protected Command createCreateChildCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, int index, Collection<?> collection) {
		ProxyEndpointConfiguration endpointConfiguration = (ProxyEndpointConfiguration) owner;
		if (value instanceof EndPoint) {
			if (!endpointConfiguration.getEndpointType().equals(ProxyEndpointType.ANONYMOUS)) {				
				return new UnexecutableCreateChildCommand(domain, owner, feature, value, index, collection, this);
			}
		}
		return super.createCreateChildCommand(domain, owner, feature, value, index, collection);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		if (child instanceof EndPoint) {
			EndPoint endpoint = (EndPoint) child;
			return String.format("%s (%s)",
					getString("_UI_" + endpoint.eClass().getName() + "_type"),
					getString("_UI_Anonymous_label"));
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}
}
