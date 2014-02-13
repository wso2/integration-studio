/**
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

import org.eclipse.emf.ecore.EObject;
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

import org.wso2.developerstudio.eclipse.esb.ApiResource;
import org.wso2.developerstudio.eclipse.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.ApiResource} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ApiResourceItemProvider
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
	public ApiResourceItemProvider(AdapterFactory adapterFactory) {
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
		ApiResource apiResource = (ApiResource) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
			super.getPropertyDescriptors(object);

			addUrlStylePropertyDescriptor(object);
			
			if(apiResource.getUrlStyle().equals(ApiResourceUrlStyle.URI_TEMPLATE)){
				addUriTemplatePropertyDescriptor(object);
			} else if (apiResource.getUrlStyle().equals(ApiResourceUrlStyle.URL_MAPPING)){
				addUrlMappingPropertyDescriptor(object);
			}
			
			addAllowGetPropertyDescriptor(object);
			addAllowPostPropertyDescriptor(object);
			addAllowPutPropertyDescriptor(object);
			addAllowDeletePropertyDescriptor(object);
			addAllowOptionsPropertyDescriptor(object);
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Url Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addUrlStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ApiResource_urlStyle_feature"),
				 getString("_UI_ApiResource_urlStyle_description"),
				 EsbPackage.Literals.API_RESOURCE__URL_STYLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Uri Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addUriTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ApiResource_uriTemplate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ApiResource_uriTemplate_feature", "_UI_ApiResource_type"),
				 EsbPackage.Literals.API_RESOURCE__URI_TEMPLATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Url Mapping feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addUrlMappingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ApiResource_urlMapping_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ApiResource_urlMapping_feature", "_UI_ApiResource_type"),
				 EsbPackage.Literals.API_RESOURCE__URL_MAPPING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Get feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowGetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ApiResource_allowGet_feature"),
				 getString("_UI_ApiResource_allowGet_description"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_GET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Post feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowPostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ApiResource_allowPost_feature"),
				 getString("_UI_ApiResource_allowPost_description"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_POST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Put feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowPutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ApiResource_allowPut_feature"),
				 getString("_UI_ApiResource_allowPut_description"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_PUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Delete feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ApiResource_allowDelete_feature"),
				 getString("_UI_ApiResource_allowDelete_description"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_DELETE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Options feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowOptionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ApiResource_allowOptions_feature"),
				 getString("_UI_ApiResource_allowOptions_description"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_OPTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
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
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION);
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
	 * This returns ApiResource.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ApiResource"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = null;
		ApiResource resource = (ApiResource)object;
		ApiResourceUrlStyle urlStyle = resource.getUrlStyle();
		if(urlStyle.equals(ApiResourceUrlStyle.URI_TEMPLATE)){
			label = resource.getUriTemplate() == null ? null : "URI-Template : " +resource.getUriTemplate();
		} else if (urlStyle.equals(ApiResourceUrlStyle.URL_MAPPING)){
			label = resource.getUrlMapping() == null ? null : "URL-Mapping : " +resource.getUrlMapping();
		}
		return label == null || label.length() == 0 ?
			getString("_UI_ApiResource_type") :
			getString("_UI_ApiResource_type") + " [" + label + "]";
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

		switch (notification.getFeatureID(ApiResource.class)) {
			case EsbPackage.API_RESOURCE__URL_STYLE:
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
			case EsbPackage.API_RESOURCE__URL_MAPPING:
			case EsbPackage.API_RESOURCE__ALLOW_GET:
			case EsbPackage.API_RESOURCE__ALLOW_POST:
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION:
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION:
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION:
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
				(EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_CONFIGURATION,
				 EsbFactory.eINSTANCE.createApiInSequenceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION,
				 EsbFactory.eINSTANCE.createApiOutSequenceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION,
				 EsbFactory.eINSTANCE.createApiFaultSequenceConfiguration()));
	}

}
