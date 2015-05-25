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
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ValidateMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateMediatorItemProvider(AdapterFactory adapterFactory) {
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
			
			addSchemasPropertyDescriptor(object);
			addSourceXpathPropertyDescriptor(object);
			addFeaturesPropertyDescriptor(object);
			addResourcesPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source Xpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidateMediator_sourceXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidateMediator_sourceXpath_feature", "_UI_ValidateMediator_type"),
				 EsbPackage.Literals.VALIDATE_MEDIATOR__SOURCE_XPATH,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidateMediator_features_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidateMediator_features_feature", "_UI_ValidateMediator_type"),
				 EsbPackage.Literals.VALIDATE_MEDIATOR__FEATURES,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Schemas feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSchemasPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidateMediator_schemas_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidateMediator_schemas_feature", "_UI_ValidateMediator_type"),
				 EsbPackage.Literals.VALIDATE_MEDIATOR__SCHEMAS,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resources feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourcesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidateMediator_resources_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidateMediator_resources_feature", "_UI_ValidateMediator_type"),
				 EsbPackage.Literals.VALIDATE_MEDIATOR__RESOURCES,
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
			childrenFeatures.add(EsbPackage.Literals.VALIDATE_MEDIATOR__SOURCE_XPATH);
			childrenFeatures.add(EsbPackage.Literals.VALIDATE_MEDIATOR__FEATURES);
			childrenFeatures.add(EsbPackage.Literals.VALIDATE_MEDIATOR__SCHEMAS);
			childrenFeatures.add(EsbPackage.Literals.VALIDATE_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.VALIDATE_MEDIATOR__MEDIATOR_FLOW);
			childrenFeatures.add(EsbPackage.Literals.VALIDATE_MEDIATOR__RESOURCES);
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
	 * This returns ValidateMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ValidateMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((ValidateMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_ValidateMediator_type") :
			getString("_UI_ValidateMediator_type") + " " + label;
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

		switch (notification.getFeatureID(ValidateMediator.class)) {
			case EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
			case EsbPackage.VALIDATE_MEDIATOR__FEATURES:
			case EsbPackage.VALIDATE_MEDIATOR__SCHEMAS:
			case EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR:
			case EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW:
			case EsbPackage.VALIDATE_MEDIATOR__RESOURCES:
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
				(EsbPackage.Literals.VALIDATE_MEDIATOR__SOURCE_XPATH,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.VALIDATE_MEDIATOR__FEATURES,
				 EsbFactory.eINSTANCE.createValidateFeature()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.VALIDATE_MEDIATOR__SCHEMAS,
				 EsbFactory.eINSTANCE.createValidateSchema()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.VALIDATE_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createValidateMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createValidateMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createValidateMediatorOnFailOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.VALIDATE_MEDIATOR__MEDIATOR_FLOW,
				 EsbFactory.eINSTANCE.createMediatorFlow()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.VALIDATE_MEDIATOR__RESOURCES,
				 EsbFactory.eINSTANCE.createValidateResource()));
	}

}
