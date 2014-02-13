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
package org.wso2.developerstudio.eclipse.esb.mediators.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorItemProvider;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FaultMediatorItemProvider
	extends MediatorItemProvider
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
	public FaultMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		FaultMediator faultMediator = (FaultMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addSoapVersionPropertyDescriptor(object);
		if (faultMediator.getSoapVersion().equals(FaultSoapVersion.SOAP_11)) {
			addFaultCodeSoap11PropertyDescriptor(object);
			addFaultStringTypePropertyDescriptor(object);

			if (faultMediator.getFaultStringType().equals(FaultStringType.VALUE)) {
				addFaultStringValuePropertyDescriptor(object);
			} else {
				addFaultStringExpressionPropertyDescriptor(object);
			}

			addFaultActorPropertyDescriptor(object);
		} else {
			addFaultCodeSoap12PropertyDescriptor(object);

			addFaultReasonTypePropertyDescriptor(object);
			if (faultMediator.getFaultReasonType().equals(FaultReasonType.VALUE)) {
				addFaultReasonValuePropertyDescriptor(object);
			} else {
				addFaultReasonExpressionPropertyDescriptor(object);
			}

			addRoleNamePropertyDescriptor(object);
			addNodeNamePropertyDescriptor(object);
		}

		addFaultDetailTypePropertyDescriptor(object);
		if (faultMediator.getFaultDetailType().equals(FaultDetailType.EXPRESSION)) {
			addFaultDetailExpressionPropertyDescriptor(object);
		} else {
			addFaultDetailValuePropertyDescriptor(object);
		}		

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Soap Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSoapVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_soapVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_soapVersion_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__SOAP_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Code Soap11 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultCodeSoap11PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultCodeSoap11_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultCodeSoap11_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_SOAP11,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Code Soap12 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultCodeSoap12PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultCodeSoap12_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultCodeSoap12_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_SOAP12,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Reason Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultReasonTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultReasonType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultReasonType_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Reason Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultReasonValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultReasonValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultReasonValue_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Reason Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultReasonExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultReasonExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultReasonExpression_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Role Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoleNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_roleName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_roleName_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__ROLE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Node Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNodeNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_nodeName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_nodeName_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__NODE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Detail Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultDetailTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultDetailType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultDetailType_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Detail Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultDetailValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultDetailValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultDetailValue_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Detail Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultDetailExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultDetailExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultDetailExpression_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault String Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultStringTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultStringType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultStringType_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault String Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultStringValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultStringValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultStringValue_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault String Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultStringExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultStringExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultStringExpression_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Actor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultActorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultActor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultActor_feature", "_UI_FaultMediator_type"),
				 MediatorsPackage.Literals.FAULT_MEDIATOR__FAULT_ACTOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns FaultMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FaultMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return getString("_UI_FaultMediator_type");
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

		switch (notification.getFeatureID(FaultMediator.class)) {
			case MediatorsPackage.FAULT_MEDIATOR__SOAP_VERSION:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_ACTOR:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
			case MediatorsPackage.FAULT_MEDIATOR__ROLE_NAME:
			case MediatorsPackage.FAULT_MEDIATOR__NODE_NAME:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public ResourceLocator getResourceLocator() {
		return EsbEditPlugin.INSTANCE;
	}

}
