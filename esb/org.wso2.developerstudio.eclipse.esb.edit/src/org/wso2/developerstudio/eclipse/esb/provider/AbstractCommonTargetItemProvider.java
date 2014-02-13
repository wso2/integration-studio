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
package org.wso2.developerstudio.eclipse.esb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
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
import org.wso2.developerstudio.eclipse.esb.AbstractCommonTarget;
import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.MediatorSequence;
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;
import org.wso2.developerstudio.eclipse.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.esb.UnexecutableCreateChildCommand;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.AbstractCommonTarget} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractCommonTargetItemProvider
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
	public AbstractCommonTargetItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		AbstractCommonTarget target = (AbstractCommonTarget) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addSequenceTypePropertyDescriptor(object);
		if (target.getSequenceType().equals(TargetSequenceType.REGISTRY_REFERENCE)) {
			addSequenceKeyPropertyDescriptor(object);
		}
				
		addEndpointTypePropertyDescriptor(object);
		if (target.getEndpointType().equals(TargetEndpointType.REGISTRY_REFERENCE)) {
			addEndpointKeyPropertyDescriptor(object);
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
				 getString("_UI_AbstractCommonTarget_sequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractCommonTarget_sequenceType_feature", "_UI_AbstractCommonTarget_type"),
				 EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE,
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
				 getString("_UI_AbstractCommonTarget_sequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractCommonTarget_sequenceKey_feature", "_UI_AbstractCommonTarget_type"),
				 EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractCommonTarget_endpointType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractCommonTarget_endpointType_feature", "_UI_AbstractCommonTarget_type"),
				 EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractCommonTarget_endpointKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractCommonTarget_endpointKey_feature", "_UI_AbstractCommonTarget_type"),
				 EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY,
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
		AbstractCommonTarget target = (AbstractCommonTarget) object;
		if (childrenFeatures != null) {
			childrenFeatures.clear();
		}
		super.getChildrenFeatures(object);
		
		if (target.getSequenceType().equals(TargetSequenceType.ANONYMOUS)) {
			childrenFeatures.add(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE);
		}
		
		if (target.getEndpointType().equals(TargetEndpointType.ANONYMOUS)) {
			childrenFeatures.add(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		ModelObjectState labelValue = ((AbstractCommonTarget)object).getObjectState();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractCommonTarget_type") :
			getString("_UI_AbstractCommonTarget_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AbstractCommonTarget.class)) {
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE:
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY:			
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE:
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT:
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
	 */
	
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		MediatorSequence sequence = EsbFactory.eINSTANCE.createMediatorSequence();
		sequence.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE, sequence));
		
		EndPoint endpoint = EsbFactory.eINSTANCE.createDefaultEndPoint();
		endpoint.setAnonymous(true);

		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT, endpoint));

		endpoint = EsbFactory.eINSTANCE.createAddressEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT, endpoint));

		endpoint = EsbFactory.eINSTANCE.createWsdlEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT, endpoint));

		endpoint = EsbFactory.eINSTANCE.createFailoverEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT, endpoint));

		endpoint = EsbFactory.eINSTANCE.createLoadBalanceEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT, endpoint));
		
		endpoint = EsbFactory.eINSTANCE.createDynamicLoadBalanceEndPoint();
		endpoint.setAnonymous(true);
		
		newChildDescriptors.add(createChildParameter(
				EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT, endpoint));
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected Command createCreateChildCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, int index, Collection<?> collection) {
		AbstractCommonTarget target = (AbstractCommonTarget) owner;
		TargetSequenceType sequenceType = target.getSequenceType();
		TargetEndpointType endpointType = target.getEndpointType();		
		
		if (value instanceof MediatorSequence && (!sequenceType.equals(TargetSequenceType.ANONYMOUS))) {
			return new UnexecutableCreateChildCommand(domain, owner, feature, value, index, collection, this);
		} else if (value instanceof EndPoint && (!endpointType.equals(TargetEndpointType.ANONYMOUS))) {
			return new UnexecutableCreateChildCommand(domain, owner, feature, value, index, collection, this);
		}
		
		return super.createCreateChildCommand(domain, owner, feature, value, index, collection);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		if (child instanceof MediatorSequence) {
			return String.format("%s (%s)",
					getString("_UI_MediatorSequence_type"),
					getString("_UI_Anonymous_label"));
		} else if (child instanceof EndPoint) {
			EndPoint endpoint = (EndPoint) child;
			return String.format("%s (%s)",
					getString("_UI_" + endpoint.eClass().getName() + "_type"),
					getString("_UI_Anonymous_label"));
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}
}
