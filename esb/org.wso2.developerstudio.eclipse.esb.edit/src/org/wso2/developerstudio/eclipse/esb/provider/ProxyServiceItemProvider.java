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
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.ProxyService;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.ProxyService} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProxyServiceItemProvider
	extends ConfigurationElementItemProvider
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
	public ProxyServiceItemProvider(AdapterFactory adapterFactory) {
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
			addPinnedServersPropertyDescriptor(object);
			addServiceGroupPropertyDescriptor(object);
			addTraceEnabledPropertyDescriptor(object);
			addStatisticsEnabledPropertyDescriptor(object);
			addTransportsPropertyDescriptor(object);
			addReliableMessagingEnabledPropertyDescriptor(object);
			addSecurityEnabledPropertyDescriptor(object);
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
				 getString("_UI_ProxyService_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_name_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Service Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addServiceGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_serviceGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_serviceGroup_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__SERVICE_GROUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Pinned Servers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPinnedServersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_pinnedServers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_pinnedServers_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__PINNED_SERVERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_traceEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_traceEnabled_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__TRACE_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Statistics Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatisticsEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_statisticsEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_statisticsEnabled_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__STATISTICS_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Transports feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransportsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_transports_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_transports_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__TRANSPORTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Reliable Messaging Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReliableMessagingEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_reliableMessagingEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_reliableMessagingEnabled_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_QoSPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Security Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecurityEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_securityEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_securityEnabled_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__SECURITY_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_QoSPropertyCategory"),
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
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__WSDL_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__ENDPOINT_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__SERVICE_PARAMETERS);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__SERVICE_POLICIES);
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
	 * This returns ProxyService.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProxyService"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return String.format("%s [%s]", ((ProxyService) object).getName(), getString("_UI_ProxyService_qualifier"));
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

		switch (notification.getFeatureID(ProxyService.class)) {
			case EsbPackage.PROXY_SERVICE__NAME:
			case EsbPackage.PROXY_SERVICE__PINNED_SERVERS:
			case EsbPackage.PROXY_SERVICE__SERVICE_GROUP:
			case EsbPackage.PROXY_SERVICE__TRACE_ENABLED:
			case EsbPackage.PROXY_SERVICE__STATISTICS_ENABLED:
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION:
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION:
			case EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION:
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION:
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION:
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
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
				(EsbPackage.Literals.PROXY_SERVICE__WSDL_CONFIGURATION,
				 EsbFactory.eINSTANCE.createProxyWsdlConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION,
				 EsbFactory.eINSTANCE.createProxyInSequenceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__ENDPOINT_CONFIGURATION,
				 EsbFactory.eINSTANCE.createProxyEndpointConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION,
				 EsbFactory.eINSTANCE.createProxyOutSequenceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION,
				 EsbFactory.eINSTANCE.createProxyFaultSequenceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__SERVICE_PARAMETERS,
				 EsbFactory.eINSTANCE.createProxyServiceParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__SERVICE_POLICIES,
				 EsbFactory.eINSTANCE.createProxyServicePolicy()));
	}

}
