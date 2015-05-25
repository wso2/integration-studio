/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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

import org.wso2.developerstudio.eclipse.gmf.esb.CacheAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CacheMediatorItemProvider
	extends MediatorItemProvider {
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
	 * @generated NOT
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
			
			addSequenceTypePropertyDescriptor(object);
			if(cacheMediator.getSequenceType().equals(CacheSequenceType.REGISTRY_REFERENCE)){
				//adding cache on hit property descriptor.
				addSequenceKeyPropertyDescriptor(object);
			}
		} 
		addDescriptionPropertyDescriptor(object);
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Cache Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addCacheIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_cacheId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_cacheId_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__CACHE_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "General",
				 null));
	}

	/**
	 * This adds a property descriptor for the Cache Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addCacheScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_cacheScope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_cacheScope_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__CACHE_SCOPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "General",
				 null));
	}

	/**
	 * This adds a property descriptor for the Cache Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addCacheActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_cacheAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_cacheAction_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__CACHE_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "General",
				 null));
	}

	/**
	 * This adds a property descriptor for the Hash Generator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addHashGeneratorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_hashGenerator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_hashGenerator_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__HASH_GENERATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "General",
				 null));
	}

	/**
	 * This adds a property descriptor for the Cache Timeout feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addCacheTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_cacheTimeout_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_cacheTimeout_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__CACHE_TIMEOUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "General",
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Message Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addMaxMessageSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_maxMessageSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_maxMessageSize_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__MAX_MESSAGE_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "General",
				 null));
	}

	/**
	 * This adds a property descriptor for the Implementation Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addImplementationTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_implementationType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_implementationType_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__IMPLEMENTATION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Implementation",
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Entry Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addMaxEntryCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_maxEntryCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_maxEntryCount_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__MAX_ENTRY_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "Implementation",
				 null));
	}
	
	/**
	 * This adds a property descriptor for the Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_sequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_sequenceType_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "On Cache Hit",
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CacheMediator_sequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CacheMediator_sequenceKey_feature", "_UI_CacheMediator_type"),
				 EsbPackage.Literals.CACHE_MEDIATOR__SEQUENCE_KEY,
				 true,
				 false,
				 true,
				 null,
				 "On Cache Hit",
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
			childrenFeatures.add(EsbPackage.Literals.CACHE_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CACHE_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CACHE_MEDIATOR__MEDIATOR_FLOW);
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
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((CacheMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_CacheMediator_type") :
			getString("_UI_CacheMediator_type") + " " + label;
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

		switch (notification.getFeatureID(CacheMediator.class)) {
			case EsbPackage.CACHE_MEDIATOR__CACHE_ID:
			case EsbPackage.CACHE_MEDIATOR__CACHE_SCOPE:
			case EsbPackage.CACHE_MEDIATOR__CACHE_ACTION:
			case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR:
			case EsbPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
			case EsbPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
			case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
			case EsbPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR:
			case EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW:
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
				(EsbPackage.Literals.CACHE_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCacheMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CACHE_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCacheMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCacheMediatorOnHitOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CACHE_MEDIATOR__MEDIATOR_FLOW,
				 EsbFactory.eINSTANCE.createMediatorFlow()));
	}

}
