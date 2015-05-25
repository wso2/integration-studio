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

import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CallTemplateMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTemplateMediatorItemProvider(AdapterFactory adapterFactory) {
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
		addAvailableTemplatesPropertyDescriptor(object);
		addTargetTemplatePropertyDescriptor(object);
		addParameterPropertyDescriptor(object);
		addDescriptionPropertyDescriptor(object);

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Available Templates feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAvailableTemplatesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CallTemplateMediator_availableTemplates_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CallTemplateMediator_availableTemplates_feature", "_UI_CallTemplateMediator_type"),
				 EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CallTemplateMediator_targetTemplate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CallTemplateMediator_targetTemplate_feature", "_UI_CallTemplateMediator_type"),
				 EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This add a property descriptor for the CallTemplate Parameter feature. 
	 * @param object
	 */
	
	protected void addParameterPropertyDescriptor (Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_CallTemplateParameter_parameterName_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_CallTemplateParameter_parameterName_feature", "_UI_CallTemplateMediator_type"),
				EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS,
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
			childrenFeatures.add(EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS);
			childrenFeatures.add(EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR);
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
	 * This returns CallTemplateMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CallTemplateMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CallTemplateMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_CallTemplateMediator_type") :
			getString("_UI_CallTemplateMediator_type") + " " + label;
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

		switch (notification.getFeatureID(CallTemplateMediator.class)) {
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES:
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR:
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
				(EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS,
				 EsbFactory.eINSTANCE.createCallTemplateParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCallTemplateMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCallTemplateMediatorOutputConnector()));
	}

}
