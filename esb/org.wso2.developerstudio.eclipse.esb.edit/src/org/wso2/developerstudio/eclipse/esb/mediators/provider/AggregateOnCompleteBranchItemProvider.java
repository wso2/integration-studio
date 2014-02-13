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
import org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorBranchItemProvider;


/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AggregateOnCompleteBranchItemProvider
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
	public AggregateOnCompleteBranchItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		AggregateOnCompleteBranch onCompleteBranch = (AggregateOnCompleteBranch) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}		
		super.getPropertyDescriptors(object);
		
		addAggregationExpressionPropertyDescriptor(object);
		
		addSequenceTypePropertyDescriptor(object);		
		if (onCompleteBranch.getSequenceType().equals(AggregateSequenceType.REGISTRY_REFERENCE)) {
			addSequenceKeyPropertyDescriptor(object);
		}
		
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Aggregation Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAggregationExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AggregateOnCompleteBranch_aggregationExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregateOnCompleteBranch_aggregationExpression_feature", "_UI_AggregateOnCompleteBranch_type"),
				 MediatorsPackage.Literals.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
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
				 getString("_UI_AggregateOnCompleteBranch_sequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregateOnCompleteBranch_sequenceType_feature", "_UI_AggregateOnCompleteBranch_type"),
				 MediatorsPackage.Literals.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE,
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
				 getString("_UI_AggregateOnCompleteBranch_sequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregateOnCompleteBranch_sequenceKey_feature", "_UI_AggregateOnCompleteBranch_type"),
				 MediatorsPackage.Literals.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
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
		AggregateOnCompleteBranch onCompleteBranch = (AggregateOnCompleteBranch) object;
		if (childrenFeatures != null) {
			childrenFeatures.clear();
		} else {
			childrenFeatures = new ArrayList<EStructuralFeature>();
		}
		
		if (onCompleteBranch.getSequenceType().equals(AggregateSequenceType.ANONYMOUS)) {
			super.getChildrenFeatures(object);
		}
		
		return childrenFeatures;
	}

	/**
	 * This returns AggregateOnCompleteBranch.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AggregateOnCompleteBranch"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return getString("_UI_AggregateOnCompleteBranch_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AggregateOnCompleteBranch.class)) {
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
				return;
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY:
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION:
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

	/**
	 * {@inheritDoc}
	 */
	protected Command createCreateChildCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, int index, Collection<?> collection) {
		AggregateOnCompleteBranch onCompleteBranch = (AggregateOnCompleteBranch) owner;

		if (value instanceof Mediator) {
			if (!onCompleteBranch.getSequenceType().equals(AggregateSequenceType.ANONYMOUS)) {				
				return new UnexecutableCreateChildCommand(domain, owner, feature, value, index, collection, this);
			}
		}
		
		return super.createCreateChildCommand(domain, owner, feature, value, index, collection);
	}

	
}
