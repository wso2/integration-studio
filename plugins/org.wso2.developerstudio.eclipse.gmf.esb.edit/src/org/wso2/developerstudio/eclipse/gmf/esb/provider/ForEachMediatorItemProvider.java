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

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ForEachMediatorItemProvider extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachMediatorItemProvider(AdapterFactory adapterFactory) {
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
		
		ForEachMediator mediator = (ForEachMediator) object;

		addForEachIDPropertyDescriptor(object);
		addForEachExpressionPropertyDescriptor(object);
		
		addSequenceTypePropertyDescriptor(object);
		switch (mediator.getSequenceType()) {
		case REGISTRY_REFERENCE: {
			addSequenceKeyPropertyDescriptor(object);
			break;
		}
		case NAMED_REFERENCE: {
			addSequenceNamePropertyDescriptor(object);
			break;
		}
		case ANONYMOUS: {
			break;
		}
		}
		addDescriptionPropertyDescriptor(object);
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the For Each ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addForEachIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForEachMediator_forEachID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForEachMediator_forEachID_feature", "_UI_ForEachMediator_type"),
				 EsbPackage.Literals.FOR_EACH_MEDIATOR__FOR_EACH_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the For Each Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addForEachExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForEachMediator_forEachExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForEachMediator_forEachExpression_feature", "_UI_ForEachMediator_type"),
				 EsbPackage.Literals.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION,
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
				 getString("_UI_ForEachMediator_sequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForEachMediator_sequenceType_feature", "_UI_ForEachMediator_type"),
				 EsbPackage.Literals.FOR_EACH_MEDIATOR__SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_SequencePropertyCategory"),
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
				 getString("_UI_ForEachMediator_sequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForEachMediator_sequenceKey_feature", "_UI_ForEachMediator_type"),
				 EsbPackage.Literals.FOR_EACH_MEDIATOR__SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_SequencePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForEachMediator_sequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForEachMediator_sequenceName_feature", "_UI_ForEachMediator_type"),
				 EsbPackage.Literals.FOR_EACH_MEDIATOR__SEQUENCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_SequencePropertyCategory"),
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
			childrenFeatures.add(EsbPackage.Literals.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.FOR_EACH_MEDIATOR__ATTACH_PATH);
			childrenFeatures.add(EsbPackage.Literals.FOR_EACH_MEDIATOR__TARGET);
			childrenFeatures.add(EsbPackage.Literals.FOR_EACH_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.FOR_EACH_MEDIATOR__MEDIATOR_FLOW);
			childrenFeatures.add(EsbPackage.Literals.FOR_EACH_MEDIATOR__SEQUENCE_KEY);
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
	 * This returns ForEachMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ForEachMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ForEachMediator)object).getSequenceName();
		return label == null || label.length() == 0 ?
			getString("_UI_ForEachMediator_type") :
			getString("_UI_ForEachMediator_type") + " " + label;
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

		switch (notification.getFeatureID(ForEachMediator.class)) {
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_ID:
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_TYPE:
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION:
			case EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH:
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET:
			case EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
			case EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW:
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY:
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
				(EsbPackage.Literals.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FOR_EACH_MEDIATOR__ATTACH_PATH,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FOR_EACH_MEDIATOR__TARGET,
				 EsbFactory.eINSTANCE.createForEachTarget()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FOR_EACH_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createForEachMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createForEachMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createForEachMediatorTargetOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FOR_EACH_MEDIATOR__MEDIATOR_FLOW,
				 EsbFactory.eINSTANCE.createMediatorFlow()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FOR_EACH_MEDIATOR__SEQUENCE_KEY,
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
			childFeature == EsbPackage.Literals.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION ||
			childFeature == EsbPackage.Literals.FOR_EACH_MEDIATOR__ATTACH_PATH;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
