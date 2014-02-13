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
package org.wso2.developerstudio.eclipse.esb.mediators.provider;


import java.util.ArrayList;
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

import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;
import org.wso2.developerstudio.eclipse.esb.UnexecutableCreateChildCommand;

import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementSequence;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;

import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorBranchItemProvider;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EntitlementMediatorOnRejectBranchItemProvider
	extends MediatorBranchItemProvider
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
	public EntitlementMediatorOnRejectBranchItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		 EntitlementMediatorOnRejectBranch branch= (EntitlementMediatorOnRejectBranch)object;
		if (itemPropertyDescriptors != null) {
				itemPropertyDescriptors.clear();
		}
			super.getPropertyDescriptors(object);
			addSequenceTypePropertyDescriptor(object);
			if(branch.getSequenceType().equals(EntitlementSequence.REGISTRY_REFERENCE)){
			 addSequenceKeyPropertyDescriptor(object);
			}
			return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediatorOnRejectBranch_sequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediatorOnRejectBranch_sequenceType_feature", "_UI_EntitlementMediatorOnRejectBranch_type"),
				 MediatorsPackage.Literals.ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMeditorOnRejectBranch_sequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMeditorOnRejectBranch_sequenceKey_feature", "_UI_EntitlementMeditorOnRejectBranch_type"),
				 MediatorsPackage.Literals.ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns EntitlementMeditorOnRejectBranch.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EntitlementMeditorOnRejectBranch"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *  
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_EntitlementMediatorOnRejectBranch_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *  
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		switch (notification.getFeatureID(EntitlementMediatorOnAcceptBranch.class)) {
			case MediatorsPackage.ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_TYPE:
			case MediatorsPackage.ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_KEY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		 EntitlementMediatorOnRejectBranch branch= (EntitlementMediatorOnRejectBranch)object;
		
		if (childrenFeatures != null) {
			childrenFeatures.clear();
		} else {
			childrenFeatures = new ArrayList<EStructuralFeature>();
		}
		
		if (branch.getSequenceType().equals(EntitlementSequence.ANONYMOUS)) {
			super.getChildrenFeatures(object);
		}
		
		return childrenFeatures;
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

	
	protected Command createCreateChildCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, int index, Collection<?> collection) {
		EntitlementMediatorOnRejectBranch branch = (EntitlementMediatorOnRejectBranch) owner;
		if (value instanceof Mediator) {
			if (!branch.getSequenceType().equals(EntitlementSequence.ANONYMOUS)) {				
				return new UnexecutableCreateChildCommand(domain, owner, feature, value, index, collection, this);
			}
		}
		return super.createCreateChildCommand(domain, owner, feature, value, index, collection);
	}
	
}
