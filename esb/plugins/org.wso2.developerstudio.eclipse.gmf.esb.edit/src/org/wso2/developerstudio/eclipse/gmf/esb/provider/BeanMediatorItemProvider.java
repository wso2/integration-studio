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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BeanMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanMediatorItemProvider(AdapterFactory adapterFactory) {
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
		BeanMediator beanMediator=(BeanMediator)object;
		
		super.getPropertyDescriptors(object);
		
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		
		addActionPropertyDescriptor(object);
		addVarPropertyDescriptor(object);
		addDescriptionPropertyDescriptor(object);
		
		switch(beanMediator.getAction()){
		case CREATE: 
			addClassPropertyDescriptor(object);
			break;
		case SET_PROPERTY:
			addPropertyPropertyDescriptor(object);
			addValueTypePropertyDescriptor(object);
			break;
		case GET_PROPERTY:
			addPropertyPropertyDescriptor(object);
			addTargetTypePropertyDescriptor(object);
			break;
		case REMOVE:
			break;
		}
		
		if(beanMediator.getAction().equals(BeanMediatorAction.SET_PROPERTY)){
		switch (beanMediator.getValueType()) {
		case LITERAL:
			addValueLiteralPropertyDescriptor(object);
			break;
		case EXPRESSION:
			addValueExpressionPropertyDescriptor(object);
			break;
		}
		}
		else if(beanMediator.getAction().equals(BeanMediatorAction.GET_PROPERTY)){
		switch (beanMediator.getTargetType()) {
		case LITERAL:
			addTargetLiteralPropertyDescriptor(object);
			break;
		case EXPRESSION:
			addTargetExpressionPropertyDescriptor(object);
			break;
		}	
		}
			
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_class_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_class_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_action_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_action_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Var feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVarPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_var_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_var_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__VAR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_property_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_property_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_valueType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_valueType_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__VALUE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value Literal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueLiteralPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_valueLiteral_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_valueLiteral_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__VALUE_LITERAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_valueExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_valueExpression_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__VALUE_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 null,
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
				 getString("_UI_BeanMediator_targetType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_targetType_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__TARGET_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Literal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetLiteralPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_targetLiteral_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_targetLiteral_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__TARGET_LITERAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BeanMediator_targetExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BeanMediator_targetExpression_feature", "_UI_BeanMediator_type"),
				 EsbPackage.Literals.BEAN_MEDIATOR__TARGET_EXPRESSION,
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
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EsbPackage.Literals.BEAN_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.BEAN_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.BEAN_MEDIATOR__VALUE_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.BEAN_MEDIATOR__TARGET_EXPRESSION);
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
	 * This returns BeanMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BeanMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BeanMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_BeanMediator_type") :
			getString("_UI_BeanMediator_type") + " " + label;
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

		switch (notification.getFeatureID(BeanMediator.class)) {
			case EsbPackage.BEAN_MEDIATOR__CLASS:
			case EsbPackage.BEAN_MEDIATOR__ACTION:
			case EsbPackage.BEAN_MEDIATOR__VAR:
			case EsbPackage.BEAN_MEDIATOR__PROPERTY:
			case EsbPackage.BEAN_MEDIATOR__VALUE_TYPE:
			case EsbPackage.BEAN_MEDIATOR__VALUE_LITERAL:
			case EsbPackage.BEAN_MEDIATOR__TARGET_TYPE:
			case EsbPackage.BEAN_MEDIATOR__TARGET_LITERAL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.BEAN_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.BEAN_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.BEAN_MEDIATOR__VALUE_EXPRESSION:
			case EsbPackage.BEAN_MEDIATOR__TARGET_EXPRESSION:
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
				(EsbPackage.Literals.BEAN_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createBeanMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.BEAN_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createBeanMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.BEAN_MEDIATOR__VALUE_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.BEAN_MEDIATOR__TARGET_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));
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
			childFeature == EsbPackage.Literals.BEAN_MEDIATOR__VALUE_EXPRESSION ||
			childFeature == EsbPackage.Literals.BEAN_MEDIATOR__TARGET_EXPRESSION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
