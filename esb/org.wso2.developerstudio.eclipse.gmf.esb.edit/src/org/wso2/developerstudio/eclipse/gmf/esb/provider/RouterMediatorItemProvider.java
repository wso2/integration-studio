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
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RouterMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediatorItemProvider(AdapterFactory adapterFactory) {
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
		addContinueAfterRoutingPropertyDescriptor(object);
		addRouterContainerPropertyDescriptor(object);
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Continue After Routing feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContinueAfterRoutingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RouterMediator_continueAfterRouting_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RouterMediator_continueAfterRouting_feature", "_UI_RouterMediator_type"),
				 EsbPackage.Literals.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Router Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRouterContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RouterMediator_routerContainer_feature"),
				 getString("_UI_RouterMediator_routerContainer_description"),
				 EsbPackage.Literals.ROUTER_MEDIATOR__ROUTER_CONTAINER,
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
			childrenFeatures.add(EsbPackage.Literals.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ROUTER_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ROUTER_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ROUTER_MEDIATOR__ROUTER_CONTAINER);
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
	 * This returns RouterMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RouterMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((RouterMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_RouterMediator_type") :
			getString("_UI_RouterMediator_type") + " " + label;
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

		switch (notification.getFeatureID(RouterMediator.class)) {
			case EsbPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
			case EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER:
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
				(EsbPackage.Literals.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRouterMediatorTargetOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ROUTER_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRouterMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ROUTER_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRouterMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ROUTER_MEDIATOR__ROUTER_CONTAINER,
				 EsbFactory.eINSTANCE.createRouterMediatorContainer()));
	}

}
