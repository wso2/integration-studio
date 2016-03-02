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
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.RegistryKeyPropertyImpl;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataMapperMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperMediatorItemProvider(AdapterFactory adapterFactory) {
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

			addConfigurationPropertyDescriptor(object);
			addInputSchemaPropertyDescriptor(object);
			addOutputSchemaPropertyDescriptor(object);
			//addConfigurationLocalPathPropertyDescriptor(object);
			//addInputSchemaLocalPathPropertyDescriptor(object);
			//addOutputSchemaLocalPathPropertyDescriptor(object);
			addInputTypePropertyDescriptor(object);
			addOutputTypePropertyDescriptor(object);
		
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Input Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataMapperMediator_inputType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataMapperMediator_inputType_feature", "_UI_DataMapperMediator_type"),
				 EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	protected void addConfigurationPropertyDescriptor(Object object) {		
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataMapperMediator_configuration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataMapperMediator_configuration_feature", "_UI_DataMapperMediator_type"),
				 EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null){
					@Override
					public void setPropertyValue(Object object, Object value) {
						// TODO Auto-generated method stub
						super.setPropertyValue(object, value);
						if (value instanceof RegistryKeyPropertyImpl){
							String localPath = ((RegistryKeyPropertyImpl)value).getLocalPathOfRegistryKey();
							DataMapperMediatorImpl datamapperMediator = (DataMapperMediatorImpl)object;
						
							//SetCommand setCommand = new SetCommand(domain, owner, feature, value);
							//datamapperMediator.setConfigurationLocalPath(localPath);
							EditingDomain editingDomain = getEditingDomain(object);
							SetCommand setCmd = new SetCommand(editingDomain, datamapperMediator, EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH, localPath);
							if (setCmd.canExecute()) {
								editingDomain.getCommandStack().execute(setCmd);
							}
						}
					}
				
			});		
	}

	/**
	 * This adds a property descriptor for the Input Schema feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputSchemaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataMapperMediator_InputSchema_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataMapperMediator_InputSchema_feature", "_UI_DataMapperMediator_type"),
				 EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Schema feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputSchemaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataMapperMediator_outputSchema_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataMapperMediator_outputSchema_feature", "_UI_DataMapperMediator_type"),
				 EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Configuration Local Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigurationLocalPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataMapperMediator_configurationLocalPath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataMapperMediator_configurationLocalPath_feature", "_UI_DataMapperMediator_type"),
				 EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Input Schema Local Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputSchemaLocalPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataMapperMediator_inputSchemaLocalPath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataMapperMediator_inputSchemaLocalPath_feature", "_UI_DataMapperMediator_type"),
				 EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Schema Local Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputSchemaLocalPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataMapperMediator_outputSchemaLocalPath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataMapperMediator_outputSchemaLocalPath_feature", "_UI_DataMapperMediator_type"),
				 EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataMapperMediator_outputType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataMapperMediator_outputType_feature", "_UI_DataMapperMediator_type"),
				 EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_TYPE,
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
			childrenFeatures.add(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA);
			childrenFeatures.add(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA);
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
	 * This returns DataMapperMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DataMapperMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DataMapperMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_DataMapperMediator_type") :
			getString("_UI_DataMapperMediator_type") + " " + label;
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

		switch (notification.getFeatureID(DataMapperMediator.class)) {
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_TYPE:
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH:
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH:
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH:
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION:
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA:
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA:
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
				(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createDataMapperMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createDataMapperMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION ||
			childFeature == EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA ||
			childFeature == EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
