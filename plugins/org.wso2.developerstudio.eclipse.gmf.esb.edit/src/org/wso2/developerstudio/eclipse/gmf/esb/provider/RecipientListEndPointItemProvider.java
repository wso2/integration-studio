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
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndpointType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RecipientListEndPointItemProvider
	extends ParentEndPointItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientListEndPointItemProvider(AdapterFactory adapterFactory) {
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
		RecipientListEndPoint endpoint = (RecipientListEndPoint)object;
		
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);
		
		addEndpointTypePropertyDescriptor(object);
		if (endpoint.getEndpointType().getLiteral().equals(RecipientListEndpointType.VALUE.getLiteral())) {
			addEndpointsValuePropertyDescriptor(object);
			addMaxCachePropertyDescriptor(object);
		} else if (endpoint.getEndpointType().getLiteral().equals(RecipientListEndpointType.XPATH.getLiteral())) {
			addEndpointsExpressionPropertyDescriptor(object);
			addMaxCachePropertyDescriptor(object);
		}
	
		addPropertiesPropertyDescriptor(object);
		addDescriptionPropertyDescriptor(object);
		
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
				 getString("_UI_RecipientListEndPoint_endpointType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RecipientListEndPoint_endpointType_feature", "_UI_RecipientListEndPoint_type"),
				 EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoints Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointsValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RecipientListEndPoint_endpointsValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RecipientListEndPoint_endpointsValue_feature", "_UI_RecipientListEndPoint_type"),
				 EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoints Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointsExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RecipientListEndPoint_endpointsExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RecipientListEndPoint_endpointsExpression_feature", "_UI_RecipientListEndPoint_type"),
				 EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Cache feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxCachePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RecipientListEndPoint_maxCache_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RecipientListEndPoint_maxCache_feature", "_UI_RecipientListEndPoint_type"),
				 EsbPackage.Literals.RECIPIENT_LIST_END_POINT__MAX_CACHE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW);
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
	 * This returns RecipientListEndPoint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RecipientListEndPoint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RecipientListEndPoint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_RecipientListEndPoint_type") :
			getString("_UI_RecipientListEndPoint_type") + " " + label;
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

		switch (notification.getFeatureID(RecipientListEndPoint.class)) {
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE:
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE:
			case EsbPackage.RECIPIENT_LIST_END_POINT__MAX_CACHE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR:
			case EsbPackage.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR:
			case EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR:
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION:
			case EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW:
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
				(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRecipientListEndPointInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRecipientListEndPointOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRecipientListEndPointWestOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW,
				 EsbFactory.eINSTANCE.createMediatorFlow()));
	}

}
