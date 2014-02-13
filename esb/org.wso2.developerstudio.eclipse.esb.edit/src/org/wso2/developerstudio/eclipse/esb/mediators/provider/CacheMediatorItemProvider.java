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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
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
import org.wso2.developerstudio.eclipse.esb.UnexecutableCreateChildCommand;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheAction;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsFactory;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorItemProvider;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CacheMediatorItemProvider
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
	public CacheMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		CacheMediator cacheMediator = (CacheMediator) object;		
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addCacheIdPropertyDescriptor(object);
		addCacheScopePropertyDescriptor(object);
		addCacheActionPropertyDescriptor(object);
		
		if (cacheMediator.getCacheAction().equals(CacheAction.FINDER)) {
			addHashGeneratorPropertyDescriptor(object);
			addCacheTimeoutPropertyDescriptor(object);
			addMaxMessageSizePropertyDescriptor(object);
			addImplementationTypePropertyDescriptor(object);
			addMaxEntryCountPropertyDescriptor(object);
		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Cache Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCacheIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_cacheId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_cacheId_feature", "_UI_CacheMediator_type"),
				 MediatorsPackage.Literals.CACHE_MEDIATOR__CACHE_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cache Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCacheScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_cacheScope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_cacheScope_feature", "_UI_CacheMediator_type"),
				 MediatorsPackage.Literals.CACHE_MEDIATOR__CACHE_SCOPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cache Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCacheActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_cacheAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_cacheAction_feature", "_UI_CacheMediator_type"),
				 MediatorsPackage.Literals.CACHE_MEDIATOR__CACHE_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hash Generator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHashGeneratorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_hashGenerator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_hashGenerator_feature", "_UI_CacheMediator_type"),
				 MediatorsPackage.Literals.CACHE_MEDIATOR__HASH_GENERATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cache Timeout feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCacheTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_cacheTimeout_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_cacheTimeout_feature", "_UI_CacheMediator_type"),
				 MediatorsPackage.Literals.CACHE_MEDIATOR__CACHE_TIMEOUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Message Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxMessageSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_maxMessageSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_maxMessageSize_feature", "_UI_CacheMediator_type"),
				 MediatorsPackage.Literals.CACHE_MEDIATOR__MAX_MESSAGE_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Implementation Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImplementationTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_implementationType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_implementationType_feature", "_UI_CacheMediator_type"),
				 MediatorsPackage.Literals.CACHE_MEDIATOR__IMPLEMENTATION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Entry Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxEntryCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_maxEntryCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_maxEntryCount_feature", "_UI_CacheMediator_type"),
				 MediatorsPackage.Literals.CACHE_MEDIATOR__MAX_ENTRY_COUNT,
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
	 */
	
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		CacheMediator cacheMediator = (CacheMediator) object;
		if (childrenFeatures != null) {
			childrenFeatures.clear();
		}
		super.getChildrenFeatures(object);
		
		if (cacheMediator.getCacheAction().equals(CacheAction.FINDER)) {
			childrenFeatures.add(MediatorsPackage.Literals.CACHE_MEDIATOR__ON_HIT_BRANCH);
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
	 * This returns CacheMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CacheMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return getString("_UI_CacheMediator_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CacheMediator.class)) {
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ID:
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_SCOPE:
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ACTION:
			case MediatorsPackage.CACHE_MEDIATOR__HASH_GENERATOR:
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
			case MediatorsPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
			case MediatorsPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
			case MediatorsPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
				return;
			case MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH:
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
				(MediatorsPackage.Literals.CACHE_MEDIATOR__ON_HIT_BRANCH,
				 MediatorsFactory.eINSTANCE.createCacheOnHitBranch()));
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

	/**
	 * {@inheritDoc}
	 */
	protected Command createCreateChildCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, int index, Collection<?> collection) {
		CacheMediator cacheMediator = (CacheMediator) owner;
		if (value instanceof CacheOnHitBranch) {
			if (!cacheMediator.getCacheAction().equals(CacheAction.FINDER)) {				
				return new UnexecutableCreateChildCommand(domain, owner, feature, value, index, collection, this);
			}
		}
		return super.createCreateChildCommand(domain, owner, feature, value, index, collection);
	}
}
