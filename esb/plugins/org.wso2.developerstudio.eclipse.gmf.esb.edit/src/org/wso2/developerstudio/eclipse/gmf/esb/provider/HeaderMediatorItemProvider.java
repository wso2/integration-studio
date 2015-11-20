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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderAction;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderValueType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HeaderMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderMediatorItemProvider(AdapterFactory adapterFactory) {
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
		HeaderMediator headerMediator=(HeaderMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
			super.getPropertyDescriptors(object);

			addHeaderActionPropertyDescriptor(object);
			addScopePropertyDescriptor(object);
			if (headerMediator.getHeaderAction().equals(HeaderAction.SET)) {
				addValueTypePropertyDescriptor(object);
				if (headerMediator.getValueType().equals(HeaderValueType.LITERAL)) {				
					addValueLiteralPropertyDescriptor(object);
					addHeaderNamePropertyDescriptor(object);
				}else if(headerMediator.getValueType().equals(HeaderValueType.EXPRESSION)) {
					addValueExpressionPropertyDescriptor(object);
					addHeaderNamePropertyDescriptor(object);
				}else {
					addValueInlinePropertyDescriptor(object);
				}			
			}else if(headerMediator.getHeaderAction().equals(HeaderAction.REMOVE)){
				addHeaderNamePropertyDescriptor(object);
			}
		
		return itemPropertyDescriptors;
	}
	

	 /**
	 * This adds a property descriptor for the Header Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHeaderNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HeaderMediator_headerName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HeaderMediator_headerName_feature", "_UI_HeaderMediator_type"),
				 EsbPackage.Literals.HEADER_MEDIATOR__HEADER_NAME,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}


	/**
	 * This adds a property descriptor for the Header Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHeaderActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HeaderMediator_headerAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HeaderMediator_headerAction_feature", "_UI_HeaderMediator_type"),
				 EsbPackage.Literals.HEADER_MEDIATOR__HEADER_ACTION,
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
				 getString("_UI_HeaderMediator_valueType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HeaderMediator_valueType_feature", "_UI_HeaderMediator_type"),
				 EsbPackage.Literals.HEADER_MEDIATOR__VALUE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HeaderMediator_scope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HeaderMediator_scope_feature", "_UI_HeaderMediator_type"),
				 EsbPackage.Literals.HEADER_MEDIATOR__SCOPE,
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
				 getString("_UI_HeaderMediator_valueLiteral_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HeaderMediator_valueLiteral_feature", "_UI_HeaderMediator_type"),
				 EsbPackage.Literals.HEADER_MEDIATOR__VALUE_LITERAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	
	
	/**
	 * This adds a property descriptor for the Value Inline feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueInlinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HeaderMediator_valueInline_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HeaderMediator_valueInline_feature", "_UI_HeaderMediator_type"),
				 EsbPackage.Literals.HEADER_MEDIATOR__VALUE_INLINE,
				 true,
				 true,
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
				 getString("_UI_HeaderMediator_valueExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HeaderMediator_valueExpression_feature", "_UI_HeaderMediator_type"),
				 EsbPackage.Literals.HEADER_MEDIATOR__VALUE_EXPRESSION,
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
			childrenFeatures.add(EsbPackage.Literals.HEADER_MEDIATOR__HEADER_NAME);
			childrenFeatures.add(EsbPackage.Literals.HEADER_MEDIATOR__VALUE_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.HEADER_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.HEADER_MEDIATOR__OUTPUT_CONNECTOR);
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
	 * This returns HeaderMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/HeaderMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((HeaderMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_HeaderMediator_type") :
			getString("_UI_HeaderMediator_type") + " " + label;
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

		switch (notification.getFeatureID(HeaderMediator.class)) {
			case EsbPackage.HEADER_MEDIATOR__HEADER_ACTION:
			case EsbPackage.HEADER_MEDIATOR__VALUE_TYPE:
			case EsbPackage.HEADER_MEDIATOR__SCOPE:
			case EsbPackage.HEADER_MEDIATOR__VALUE_LITERAL:
			case EsbPackage.HEADER_MEDIATOR__VALUE_INLINE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.HEADER_MEDIATOR__HEADER_NAME:
			case EsbPackage.HEADER_MEDIATOR__VALUE_EXPRESSION:
			case EsbPackage.HEADER_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.HEADER_MEDIATOR__OUTPUT_CONNECTOR:
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
				(EsbPackage.Literals.HEADER_MEDIATOR__HEADER_NAME,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.HEADER_MEDIATOR__VALUE_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.HEADER_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createHeaderMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.HEADER_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createHeaderMediatorOutputConnector()));
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
			childFeature == EsbPackage.Literals.HEADER_MEDIATOR__HEADER_NAME ||
			childFeature == EsbPackage.Literals.HEADER_MEDIATOR__VALUE_EXPRESSION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
