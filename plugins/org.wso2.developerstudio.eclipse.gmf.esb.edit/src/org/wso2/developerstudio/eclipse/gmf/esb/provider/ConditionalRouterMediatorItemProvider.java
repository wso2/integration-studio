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

import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConditionalRouterMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouterMediatorItemProvider(AdapterFactory adapterFactory) {
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

		addContinueAfterRoutePropertyDescriptor(object);
		addConditionalRouteBranchesPropertyDescriptor(object);
		addDescriptionPropertyDescriptor(object);

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Continue After Route feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContinueAfterRoutePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConditionalRouterMediator_continueAfterRoute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConditionalRouterMediator_continueAfterRoute_feature", "_UI_ConditionalRouterMediator_type"),
				 EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Conditional Route Branches feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditionalRouteBranchesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConditionalRouterMediator_conditionalRouteBranches_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConditionalRouterMediator_conditionalRouteBranches_feature", "_UI_ConditionalRouterMediator_type"),
				 EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES,
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
			childrenFeatures.add(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES);
			childrenFeatures.add(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW);
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
	 * This returns ConditionalRouterMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConditionalRouterMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((ConditionalRouterMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_ConditionalRouterMediator_type") :
			getString("_UI_ConditionalRouterMediator_type") + " " + label;
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

		switch (notification.getFeatureID(ConditionalRouterMediator.class)) {
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES:
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR:
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW:
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
				(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES,
				 EsbFactory.eINSTANCE.createConditionalRouteBranch()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createConditionalRouterMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createConditionalRouterMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createConditionalRouterMediatorAdditionalOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW,
				 EsbFactory.eINSTANCE.createMediatorFlow()));
	}

}
