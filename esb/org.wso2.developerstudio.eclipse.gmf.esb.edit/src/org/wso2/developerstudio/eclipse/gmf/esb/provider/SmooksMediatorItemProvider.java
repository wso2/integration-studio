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
import org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SmooksMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksMediatorItemProvider(AdapterFactory adapterFactory) {
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
		SmooksMediator mediator = (SmooksMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addConfigurationKeyPropertyDescriptor(object);
		addInputTypePropertyDescriptor(object);
		addInputExpressionPropertyDescriptor(object);
		addOutputTypePropertyDescriptor(object);
		addOutputMethodPropertyDescriptor(object);

		if (mediator.getOutputMethod().equals(OutputMethod.PROPERTY)) {
			addOutputPropertyPropertyDescriptor(object);

		} else if (mediator.getOutputMethod().equals(OutputMethod.EXPRESSION)) {
			addOutputActionPropertyDescriptor(object);
			addOutputExpressionPropertyDescriptor(object);
		}
		addDescriptionPropertyDescriptor(object);

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Configuration Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigurationKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SmooksMediator_configurationKey_feature"),
				 getString("_UI_SmooksMediator_configurationKey_description"),
				 EsbPackage.Literals.SMOOKS_MEDIATOR__CONFIGURATION_KEY,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_KeyPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Input Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SmooksMediator_inputType_feature"),
				 getString("_UI_SmooksMediator_inputType_description"),
				 EsbPackage.Literals.SMOOKS_MEDIATOR__INPUT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_InputPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Input Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SmooksMediator_inputExpression_feature"),
				 getString("_UI_SmooksMediator_inputExpression_description"),
				 EsbPackage.Literals.SMOOKS_MEDIATOR__INPUT_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_InputPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SmooksMediator_outputType_feature"),
				 getString("_UI_SmooksMediator_outputType_description"),
				 EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_OutputPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SmooksMediator_outputExpression_feature"),
				 getString("_UI_SmooksMediator_outputExpression_description"),
				 EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_OutputPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SmooksMediator_outputProperty_feature"),
				 getString("_UI_SmooksMediator_outputProperty_description"),
				 EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_OutputPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SmooksMediator_outputAction_feature"),
				 getString("_UI_SmooksMediator_outputAction_description"),
				 EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_OutputPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Method feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SmooksMediator_outputMethod_feature"),
				 getString("_UI_SmooksMediator_outputMethod_description"),
				 EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_METHOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_OutputPropertyCategory"),
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
			childrenFeatures.add(EsbPackage.Literals.SMOOKS_MEDIATOR__CONFIGURATION_KEY);
			childrenFeatures.add(EsbPackage.Literals.SMOOKS_MEDIATOR__INPUT_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.SMOOKS_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR);
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
	 * This returns SmooksMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SmooksMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SmooksMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_SmooksMediator_type") :
			getString("_UI_SmooksMediator_type") + " " + label;
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

		switch (notification.getFeatureID(SmooksMediator.class)) {
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_TYPE:
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_TYPE:
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_PROPERTY:
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_ACTION:
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_METHOD:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION:
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION:
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR:
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
				(EsbPackage.Literals.SMOOKS_MEDIATOR__CONFIGURATION_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SMOOKS_MEDIATOR__INPUT_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SMOOKS_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createSmooksMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createSmooksMediatorOutputConnector()));
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
			childFeature == EsbPackage.Literals.SMOOKS_MEDIATOR__INPUT_EXPRESSION ||
			childFeature == EsbPackage.Literals.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
