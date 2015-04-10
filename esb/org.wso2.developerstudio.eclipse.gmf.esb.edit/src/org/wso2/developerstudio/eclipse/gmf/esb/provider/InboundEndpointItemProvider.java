/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InboundEndpointItemProvider
	extends EsbElementItemProvider
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
	public InboundEndpointItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addSequencePropertyDescriptor(object);
			addOnErrorSequencePropertyDescriptor(object);
			addProtocolPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_name_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_sequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_sequence_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the On Error Sequence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOnErrorSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_onErrorSequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_onErrorSequence_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Protocol feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProtocolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InboundEndpoint_protocol_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InboundEndpoint_protocol_feature", "_UI_InboundEndpoint_type"),
				 EsbPackage.Literals.INBOUND_ENDPOINT__PROTOCOL,
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
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.INBOUND_ENDPOINT__CONTAINER);
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
	 * This returns InboundEndpoint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InboundEndpoint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((InboundEndpoint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_InboundEndpoint_type") :
			getString("_UI_InboundEndpoint_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(InboundEndpoint.class)) {
			case EsbPackage.INBOUND_ENDPOINT__NAME:
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
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
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createInboundEndpointSequenceInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createInboundEndpointSequenceOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createInboundEndpointOnErrorSequenceInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createInboundEndpointOnErrorSequenceOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.INBOUND_ENDPOINT__CONTAINER,
				 EsbFactory.eINSTANCE.createInboundEndpointContainer()));
	}

}
