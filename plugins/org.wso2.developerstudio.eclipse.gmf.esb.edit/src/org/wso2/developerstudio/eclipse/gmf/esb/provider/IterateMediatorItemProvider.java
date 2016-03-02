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
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IterateMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateMediatorItemProvider(AdapterFactory adapterFactory) {
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
		
		IterateMediator mediator = (IterateMediator) object;

		addIterateIDPropertyDescriptor(object);
		addSequentialMediationPropertyDescriptor(object);
		addContinueParentPropertyDescriptor(object);
		addPreservePayloadPropertyDescriptor(object);
		addIterateExpressionPropertyDescriptor(object);
		
		if(mediator.isPreservePayload()){
			addAttachPathPropertyDescriptor(object);
		}
		
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

		// addSoapActionPropertyDescriptor(object);
		// addToAddressPropertyDescriptor(object);
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Iterate ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIterateIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterateMediator_iterateID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_iterateID_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__ITERATE_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequential Mediation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSequentialMediationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterateMediator_sequentialMediation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_sequentialMediation_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Continue Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContinueParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterateMediator_continueParent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_continueParent_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__CONTINUE_PARENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Preserve Payload feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPreservePayloadPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterateMediator_preservePayload_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_preservePayload_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__PRESERVE_PAYLOAD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_IterateMediator_sequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_sequenceType_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__SEQUENCE_TYPE,
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
				 getString("_UI_IterateMediator_sequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_sequenceKey_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__SEQUENCE_KEY,
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
				 getString("_UI_IterateMediator_sequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_sequenceName_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__SEQUENCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_SequencePropertyCategory"),
				 null));
	}

	protected void addIterateExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterateMediator_iterateExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_iterateExpression_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__ITERATE_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}
	
	protected void addAttachPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterateMediator_attachPath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateMediator_attachPath_feature", "_UI_IterateMediator_type"),
				 EsbPackage.Literals.ITERATE_MEDIATOR__ATTACH_PATH,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}
	
	protected void addSoapActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterateTarget_soapAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateTarget_soapAction_feature", "_UI_IterateTarget_type"),
				 EsbPackage.Literals.ITERATE_TARGET__SOAP_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	protected void addToAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(0, createItemPropertyDescriptor(
				((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IterateTarget_toAddress_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IterateTarget_toAddress_feature", "_UI_IterateTarget_type"),
				 EsbPackage.Literals.ITERATE_TARGET__TO_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(EsbPackage.Literals.ITERATE_MEDIATOR__ITERATE_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.ITERATE_MEDIATOR__ATTACH_PATH);
			childrenFeatures.add(EsbPackage.Literals.ITERATE_MEDIATOR__TARGET);
			childrenFeatures.add(EsbPackage.Literals.ITERATE_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ITERATE_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ITERATE_MEDIATOR__MEDIATOR_FLOW);
			childrenFeatures.add(EsbPackage.Literals.ITERATE_MEDIATOR__SEQUENCE_KEY);
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
	 * This returns IterateMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IterateMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((IterateMediator)object).getSequenceName();
		return label == null || label.length() == 0 ?
			getString("_UI_IterateMediator_type") :
			getString("_UI_IterateMediator_type") + " " + label;
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

		switch (notification.getFeatureID(IterateMediator.class)) {
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_ID:
			case EsbPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
			case EsbPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
			case EsbPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_TYPE:
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
			case EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH:
			case EsbPackage.ITERATE_MEDIATOR__TARGET:
			case EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
			case EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW:
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY:
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
				(EsbPackage.Literals.ITERATE_MEDIATOR__ITERATE_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ITERATE_MEDIATOR__ATTACH_PATH,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ITERATE_MEDIATOR__TARGET,
				 EsbFactory.eINSTANCE.createIterateTarget()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ITERATE_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createIterateMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ITERATE_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createIterateMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createIterateMediatorTargetOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ITERATE_MEDIATOR__MEDIATOR_FLOW,
				 EsbFactory.eINSTANCE.createMediatorFlow()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ITERATE_MEDIATOR__SEQUENCE_KEY,
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
			childFeature == EsbPackage.Literals.ITERATE_MEDIATOR__ITERATE_EXPRESSION ||
			childFeature == EsbPackage.Literals.ITERATE_MEDIATOR__ATTACH_PATH;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
