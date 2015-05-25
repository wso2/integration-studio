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
import java.util.Iterator;
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

import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CloudConnectorOperationItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorOperationItemProvider(AdapterFactory adapterFactory) {
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
		super.getPropertyDescriptors(object);
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		//addConnectorParametersPropertyDescriptor(object);
		addConfigRefPropertyDescriptor(object);
		addAvailableConfigsPropertyDescriptor(object);
		addNewConfigPropertyDescriptor(object);
		addParameterEditorTypePropertyDescriptor(object);
		
		Iterator<CallTemplateParameter> iterator=((CloudConnectorOperation)object).getConnectorParameters().iterator();
		while(iterator.hasNext()){
			CallTemplateParameter callTemplateParameter=iterator.next();
			addCustomConnectorParametersPropertyDescriptor(object,callTemplateParameter);
		}	
		
		return itemPropertyDescriptors;
	}	
	
	protected void addCustomConnectorParametersPropertyDescriptor(Object object,CallTemplateParameter callTemplateParameter) {		
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 callTemplateParameter.getParameterName(),
				 "Cloud connector operation parameter",
				 null,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null){
				@Override
				public Object getPropertyValue(Object object) {					
					Iterator<CallTemplateParameter> iterator=((CloudConnectorOperation)object).getConnectorParameters().iterator();
					while(iterator.hasNext()){
						CallTemplateParameter callTemplateParameter=iterator.next();
						if(displayName.equals(callTemplateParameter.getParameterName())){
							if(((CloudConnectorOperation)object).getParameterEditorType().equals(CloudConnectorOperationParamEditorType.INLINE)){
								return createPropertyValueWrapper(object, callTemplateParameter.getParameterValue());
							}else if(((CloudConnectorOperation)object).getParameterEditorType().equals(CloudConnectorOperationParamEditorType.NAMESPACED_PROPERTY_EDITOR)){
								return createPropertyValueWrapper(object, callTemplateParameter.getParameterExpression().getPropertyValue());
							}
						}
					}					
					return null;					
				}
			});		
	}

	/**
	 * This adds a property descriptor for the Connector Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectorParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CloudConnectorOperation_connectorParameters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CloudConnectorOperation_connectorParameters_feature", "_UI_CloudConnectorOperation_type"),
				 EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Config Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CloudConnectorOperation_configRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CloudConnectorOperation_configRef_feature", "_UI_CloudConnectorOperation_type"),
				 EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONFIG_REF,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Connector Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectorNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CloudConnectorOperation_connectorName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CloudConnectorOperation_connectorName_feature", "_UI_CloudConnectorOperation_type"),
				 EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Operation Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperationNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CloudConnectorOperation_operationName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CloudConnectorOperation_operationName_feature", "_UI_CloudConnectorOperation_type"),
				 EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__OPERATION_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cloud Connector Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCloudConnectorNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CloudConnectorOperation_cloudConnectorName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CloudConnectorOperation_cloudConnectorName_feature", "_UI_CloudConnectorOperation_type"),
				 EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the New Config feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNewConfigPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CloudConnectorOperation_newConfig_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CloudConnectorOperation_newConfig_feature", "_UI_CloudConnectorOperation_type"),
				 EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Available Configs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAvailableConfigsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CloudConnectorOperation_availableConfigs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CloudConnectorOperation_availableConfigs_feature", "_UI_CloudConnectorOperation_type"),
				 EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__AVAILABLE_CONFIGS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parameter Editor Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParameterEditorTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CloudConnectorOperation_parameterEditorType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CloudConnectorOperation_parameterEditorType_feature", "_UI_CloudConnectorOperation_type"),
				 EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE,
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
			childrenFeatures.add(EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS);
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
	 * This returns CloudConnectorOperation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CloudConnectorOperation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CloudConnectorOperation)object).getConnectorName();
		return label == null || label.length() == 0 ?
			getString("_UI_CloudConnectorOperation_type") :
			getString("_UI_CloudConnectorOperation_type") + " " + label;
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

		switch (notification.getFeatureID(CloudConnectorOperation.class)) {
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONFIG_REF:
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME:
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OPERATION_NAME:
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME:
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG:
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__AVAILABLE_CONFIGS:
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR:
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR:
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS:
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
				(EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCloudConnectorOperationInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCloudConnectorOperationOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS,
				 EsbFactory.eINSTANCE.createCallTemplateParameter()));
	}

}
