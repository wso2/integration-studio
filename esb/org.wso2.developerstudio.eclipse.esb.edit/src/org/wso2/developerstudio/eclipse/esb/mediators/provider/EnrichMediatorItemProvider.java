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
import org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorItemProvider;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EnrichMediatorItemProvider
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
	public EnrichMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		EnrichMediator enrichMediator = (EnrichMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		switch (enrichMediator.getCurrentEsbVersion()) {
		case ESB301: {
			addCloneSourcePropertyDescriptor(object);
			addSourceTypePropertyDescriptor(object);
			switch (enrichMediator.getSourceType()) {
			case CUSTOM: {
				addSourceXpathPropertyDescriptor(object);
				break;
			}

			case PROPERTY: {
				addSourcePropertyPropertyDescriptor(object);
				break;
			}

			case INLINE: {
				addSourceXMLPropertyDescriptor(object);
				break;
			}
			}

			addTargetActionPropertyDescriptor(object);
			addTargetTypePropertyDescriptor(object);
			switch (enrichMediator.getTargetType()) {
			case CUSTOM: {
				addTargetXpathPropertyDescriptor(object);
				break;
			}

			case PROPERTY: {
				addTargetPropertyPropertyDescriptor(object);
				break;
			}
			}
		}
		break;

		case ESB400: {
			addCloneSourcePropertyDescriptor(object);
			addSourceTypePropertyDescriptor(object);
			switch (enrichMediator.getSourceType()) {
			case CUSTOM: {
				addSourceXpathPropertyDescriptor(object);
				break;
			}

			case PROPERTY: {
				addSourcePropertyPropertyDescriptor(object);
				break;
			}

			case INLINE: {
				addInlineTypePropertyDescriptor(object);
				switch (enrichMediator.getInlineType()) {
				case CONTENT: {
					addSourceXMLPropertyDescriptor(object);
					break;
				}
				case KEY: {
					addInlineRegistryKeyPropertyDescriptor(object);
					break;
				}
				}
				break;
			}
			}

			addTargetActionPropertyDescriptor(object);
			addTargetTypePropertyDescriptor(object);
			switch (enrichMediator.getTargetType()) {
			case CUSTOM: {
				addTargetXpathPropertyDescriptor(object);
				break;
			}

			case PROPERTY: {
				addTargetPropertyPropertyDescriptor(object);
				break;
			}
			}
		}
		break;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Clone Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCloneSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_cloneSource_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_cloneSource_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__CLONE_SOURCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_SourcePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_sourceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_sourceType_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__SOURCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_SourcePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Xpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_sourceXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_sourceXpath_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__SOURCE_XPATH,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_SourcePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_sourceProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_sourceProperty_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__SOURCE_PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_SourcePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source XML feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceXMLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_sourceXML_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_sourceXML_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__SOURCE_XML,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_SourcePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_targetAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_targetAction_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__TARGET_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_TargetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_targetType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_targetType_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__TARGET_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_TargetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Xpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_targetXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_targetXpath_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__TARGET_XPATH,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_TargetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_targetProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_targetProperty_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__TARGET_PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_TargetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Inline Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInlineTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_inlineType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_inlineType_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__INLINE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inline Registry Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInlineRegistryKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_inlineRegistryKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_inlineRegistryKey_feature", "_UI_EnrichMediator_type"),
				 MediatorsPackage.Literals.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns EnrichMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EnrichMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return getString("_UI_EnrichMediator_type");
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

		switch (notification.getFeatureID(EnrichMediator.class)) {
			case MediatorsPackage.ENRICH_MEDIATOR__CLONE_SOURCE:
			case MediatorsPackage.ENRICH_MEDIATOR__SOURCE_TYPE:
			case MediatorsPackage.ENRICH_MEDIATOR__SOURCE_XPATH:
			case MediatorsPackage.ENRICH_MEDIATOR__SOURCE_PROPERTY:
			case MediatorsPackage.ENRICH_MEDIATOR__SOURCE_XML:
			case MediatorsPackage.ENRICH_MEDIATOR__TARGET_ACTION:
			case MediatorsPackage.ENRICH_MEDIATOR__TARGET_TYPE:
			case MediatorsPackage.ENRICH_MEDIATOR__TARGET_XPATH:
			case MediatorsPackage.ENRICH_MEDIATOR__TARGET_PROPERTY:
			case MediatorsPackage.ENRICH_MEDIATOR__INLINE_TYPE:
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
