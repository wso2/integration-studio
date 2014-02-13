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
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;
import org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorItemProvider;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CalloutMediatorItemProvider
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
	public CalloutMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		CalloutMediator calloutMediator = (CalloutMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);
		
		addEndpointTypePropertyDescriptor(object);
		if(calloutMediator.getEndpointType()==CallOutMediatorEndpointType.ANONYMOUS){
			addServiceURLPropertyDescriptor(object);
		}else{
			addEndpointKeyPropertyDescriptor(object);
		}
		
		addSoapActionPropertyDescriptor(object);
		addPathToAxis2xmlPropertyDescriptor(object);
		addPathToAxis2RepositoryPropertyDescriptor(object);
		addPassHeadersPropertyDescriptor(object);
		
		addPayloadTypePropertyDescriptor(object);
		if (calloutMediator.getPayloadType().equals(CalloutPayloadType.MESSAGE_ELEMENT)) {
			addPayloadMessageXpathPropertyDescriptor(object);
		} else {
			addPayloadRegistryKeyPropertyDescriptor(object);
		}
		
		addResultTypePropertyDescriptor(object);
		if (calloutMediator.getResultType().equals(CalloutResultType.MESSAGE_ELEMENT)) {
			addResultMessageXpathPropertyDescriptor(object);
		} else {
			addResultContextPropertyPropertyDescriptor(object);
		}	
		
		addUseServerConfigPropertyDescriptor(object);
		
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Service URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addServiceURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_serviceURL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_serviceURL_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__SERVICE_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Soap Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSoapActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_soapAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_soapAction_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__SOAP_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Path To Axis2xml feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPathToAxis2xmlPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_pathToAxis2xml_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_pathToAxis2xml_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Path To Axis2 Repository feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPathToAxis2RepositoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_pathToAxis2Repository_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_pathToAxis2Repository_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Payload Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPayloadTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_payloadType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_payloadType_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_PayloadPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Payload Message Xpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPayloadMessageXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_payloadMessageXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_payloadMessageXpath_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_PayloadPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Payload Registry Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPayloadRegistryKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_payloadRegistryKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_payloadRegistryKey_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_PayloadPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Result Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_resultType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_resultType_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__RESULT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ResultPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Result Message Xpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultMessageXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_resultMessageXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_resultMessageXpath_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_ResultPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Result Context Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultContextPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_resultContextProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_resultContextProperty_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ResultPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Pass Headers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPassHeadersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_passHeaders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_passHeaders_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__PASS_HEADERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Server Config feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseServerConfigPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_useServerConfig_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_useServerConfig_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__USE_SERVER_CONFIG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addEndpointTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_EndpointType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_EndpointType_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__ENDPOINT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addEndpointKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_endpointKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_endpointKey_feature", "_UI_CalloutMediator_type"),
				 MediatorsPackage.Literals.CALLOUT_MEDIATOR__ENDPOINT_KEY,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This returns CalloutMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CalloutMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return getString("_UI_CalloutMediator_type");
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

		switch (notification.getFeatureID(CalloutMediator.class)) {
			case MediatorsPackage.CALLOUT_MEDIATOR__SERVICE_URL:
			case MediatorsPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY:
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
			case MediatorsPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
			case MediatorsPackage.CALLOUT_MEDIATOR__USE_SERVER_CONFIG:
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
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
