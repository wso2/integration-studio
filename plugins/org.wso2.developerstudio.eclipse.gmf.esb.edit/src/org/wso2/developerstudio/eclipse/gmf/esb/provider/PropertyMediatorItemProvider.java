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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyName;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertyMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		
		PropertyMediator property = (PropertyMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);
		
		addPropertyNamePropertyDescriptor(object);
		if(property.getPropertyName().equals(PropertyName.NEW_PROPERTY_NAME)){
			addNewPropertyNamePropertyDescriptor(object);
		}
		addPropertyActionPropertyDescriptor(object);	
						
		if (property.getPropertyAction().equals(PropertyAction.SET)) {
			addValueTypePropertyDescriptor(object);
			if (property.getValueType().equals(PropertyValueType.LITERAL)) {
				addPropertyDataTypePropertyDescriptor(object);
				switch (property.getPropertyDataType()) {
					case OM: {
						addOMPropertyDescriptor(object);
						break;
					}

					case STRING: {
						addValuePropertyDescriptor(object);
						addValueStringPatternPropertyDescriptor(object);
						addValueStringCapturingGroupPropertyDescriptor(object);
						break;
					}
					case BOOLEAN:{
						addBooleanPropertyDescriptor(object);
						break;
					}

					default: {
						addValuePropertyDescriptor(object);
					}
				}
			} else {
				addValueExpressionPropertyDescriptor(object);
				/*if (property.getPropertyDataType() == PropertyDataType.STRING) {
					addValueStringPatternPropertyDescriptor(object);
					addValueStringCapturingGroupPropertyDescriptor(object);
				}*/
			}
		}								
		
		addPropertyScopePropertyDescriptor(object);	
		addDescriptionPropertyDescriptor(object);
		
		
		/*if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addPropertyNamePropertyDescriptor(object);
			addPropertyDataTypePropertyDescriptor(object);
			addPropertyActionPropertyDescriptor(object);
			addPropertyScopePropertyDescriptor(object);
			addValueTypePropertyDescriptor(object);
			addValueLiteralPropertyDescriptor(object);
			addExpressionPropertyDescriptor(object);
			addNamespacePrefixPropertyDescriptor(object);
			addNamespacePropertyDescriptor(object);
			addValueOMPropertyDescriptor(object);
			addValueStringPatternPropertyDescriptor(object);
			addValueStringCapturingGroupPropertyDescriptor(object);
		}*/
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Property Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_propertyName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_propertyName_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__PROPERTY_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Data Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyDataTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_propertyDataType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_propertyDataType_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_propertyAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_propertyAction_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__PROPERTY_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_propertyScope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_propertyScope_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__PROPERTY_SCOPE,
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
				 getString("_UI_PropertyMediator_valueType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_valueType_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__VALUE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_value_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_value_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_expression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_expression_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Namespace Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamespacePrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_namespacePrefix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_namespacePrefix_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__NAMESPACE_PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Namespace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamespacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_namespace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_namespace_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__NAMESPACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Boolean feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBooleanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_boolean_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_boolean_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__BOOLEAN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the OM feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOMPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_OM_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_OM_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__OM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value String Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueStringPatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_valueStringPattern_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_valueStringPattern_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value String Capturing Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueStringCapturingGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_valueStringCapturingGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_valueStringCapturingGroup_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}
	
	/**
	 * This adds a property descriptor for the New Property Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNewPropertyNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyMediator_newPropertyName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_newPropertyName_feature", "_UI_PropertyMediator_type"),
				 EsbPackage.Literals.PROPERTY_MEDIATOR__NEW_PROPERTY_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	protected void addValueExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PropertyMediator_valueExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_PropertyMediator_valueExpression_feature", "_UI_PropertyMediator_type"),
                 EsbPackage.Literals.PROPERTY_MEDIATOR__VALUE_EXPRESSION,
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
			childrenFeatures.add(EsbPackage.Literals.PROPERTY_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.PROPERTY_MEDIATOR__VALUE_EXPRESSION);
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
	 * This returns PropertyMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PropertyMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		PropertyName labelValue = ((PropertyMediator)object).getPropertyName();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_PropertyMediator_type") :
			getString("_UI_PropertyMediator_type") + " " + label;
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

		switch (notification.getFeatureID(PropertyMediator.class)) {
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_NAME:
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE:
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_ACTION:
			case EsbPackage.PROPERTY_MEDIATOR__PROPERTY_SCOPE:
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_TYPE:
			case EsbPackage.PROPERTY_MEDIATOR__VALUE:
			case EsbPackage.PROPERTY_MEDIATOR__EXPRESSION:
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE_PREFIX:
			case EsbPackage.PROPERTY_MEDIATOR__NAMESPACE:
			case EsbPackage.PROPERTY_MEDIATOR__BOOLEAN:
			case EsbPackage.PROPERTY_MEDIATOR__OM:
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_PATTERN:
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP:
			case EsbPackage.PROPERTY_MEDIATOR__NEW_PROPERTY_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.PROPERTY_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.PROPERTY_MEDIATOR__VALUE_EXPRESSION:
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
				(EsbPackage.Literals.PROPERTY_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createPropertyMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROPERTY_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createPropertyMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROPERTY_MEDIATOR__VALUE_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));
	}
}
