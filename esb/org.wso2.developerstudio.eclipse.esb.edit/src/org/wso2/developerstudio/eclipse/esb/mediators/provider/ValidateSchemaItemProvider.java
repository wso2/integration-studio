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
import org.wso2.developerstudio.eclipse.esb.mediators.KeyType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.ModelObjectItemProvider;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ValidateSchemaItemProvider extends ModelObjectItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ValidateSchemaItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		ValidateSchema validateSchema = (ValidateSchema) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);
		switch (validateSchema.getCurrentEsbVersion()) {
		case ESB301:
			addSchemaKeyPropertyDescriptor(object);
			break;
		case ESB400:
			addValidateSchemaKeyTypePropertyDescriptor(object);
			switch (validateSchema.getValidateSchemaKeyType()) {
			case STATIC:
				addValidateStaticSchemaKeyPropertyDescriptor(object);
				break;
			case DYNAMIC:
				addValidateDynamicSchemaKeyPropertyDescriptor(object);
				break;
			}

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Validate Static Schema Key feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidateStaticSchemaKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidateSchema_validateStaticSchemaKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidateSchema_validateStaticSchemaKey_feature", "_UI_ValidateSchema_type"),
				 MediatorsPackage.Literals.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Validate Dynamic Schema Key feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidateDynamicSchemaKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidateSchema_validateDynamicSchemaKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidateSchema_validateDynamicSchemaKey_feature", "_UI_ValidateSchema_type"),
				 MediatorsPackage.Literals.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Validate Schema Key Type feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidateSchemaKeyTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidateSchema_validateSchemaKeyType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidateSchema_validateSchemaKeyType_feature", "_UI_ValidateSchema_type"),
				 MediatorsPackage.Literals.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Schema Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSchemaKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidateSchema_schemaKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidateSchema_schemaKey_feature", "_UI_ValidateSchema_type"),
				 MediatorsPackage.Literals.VALIDATE_SCHEMA__SCHEMA_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns ValidateSchema.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ValidateSchema"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		ValidateSchema schema = (ValidateSchema) object;
		KeyType keyType = schema.getValidateSchemaKeyType();
		String keyValue = "";
		switch (schema.getValidateSchemaKeyType()) {
		case STATIC:
			keyValue=schema.getValidateStaticSchemaKey().getKeyValue();
			break;
		case DYNAMIC:
			keyValue=schema.getValidateDynamicSchemaKey().getPropertyValue();

		}
		return String.format("Schema (%s:%s)", keyType,keyValue);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ValidateSchema.class)) {
			case MediatorsPackage.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	@Override
	public ResourceLocator getResourceLocator() {
		return EsbEditPlugin.INSTANCE;
	}

}
