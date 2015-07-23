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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PublishEventMediatorItemProvider extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addStreamNamePropertyDescriptor(object);
		addStreamVersionPropertyDescriptor(object);
		addEventSinkPropertyDescriptor(object);
		addMetaAttributesPropertyDescriptor(object);
		addCorrelationAttributesPropertyDescriptor(object);
		addPayloadAttributesPropertyDescriptor(object);
		addArbitraryAttributesPropertyDescriptor(object);
		addDescriptionPropertyDescriptor(object);

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Stream Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStreamNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishEventMediator_streamName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishEventMediator_streamName_feature", "_UI_PublishEventMediator_type"),
				 EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__STREAM_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stream Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStreamVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishEventMediator_streamVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishEventMediator_streamVersion_feature", "_UI_PublishEventMediator_type"),
				 EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__STREAM_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Event Sink feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEventSinkPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishEventMediator_eventSink_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishEventMediator_eventSink_feature", "_UI_PublishEventMediator_type"),
				 EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__EVENT_SINK,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Meta Attributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetaAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishEventMediator_metaAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishEventMediator_metaAttributes_feature", "_UI_PublishEventMediator_type"),
				 EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Correlation Attributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCorrelationAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishEventMediator_correlationAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishEventMediator_correlationAttributes_feature", "_UI_PublishEventMediator_type"),
				 EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Payload Attributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPayloadAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishEventMediator_payloadAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishEventMediator_payloadAttributes_feature", "_UI_PublishEventMediator_type"),
				 EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Arbitrary Attributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArbitraryAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishEventMediator_arbitraryAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishEventMediator_arbitraryAttributes_feature", "_UI_PublishEventMediator_type"),
				 EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES,
				 true,
				 false,
				 false,
				 null,
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
			childrenFeatures.add(EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR);
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
	 * This returns PublishEventMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PublishEventMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PublishEventMediator)object).getStreamName();
		return label == null || label.length() == 0 ?
			getString("_UI_PublishEventMediator_type") :
			getString("_UI_PublishEventMediator_type") + " " + label;
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

		switch (notification.getFeatureID(PublishEventMediator.class)) {
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_NAME:
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__STREAM_VERSION:
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__EVENT_SINK:
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES:
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES:
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES:
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR:
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
				(EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createPublishEventMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR,
				 EsbFactory.eINSTANCE.createPublishEventMediatorOutputConnector()));
	}

}
