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

import org.wso2.developerstudio.eclipse.gmf.esb.AbstractCommonTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractCommonTarget} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractCommonTargetItemProvider
	extends EsbNodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCommonTargetItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSequenceTypePropertyDescriptor(object);
			addSequencePropertyDescriptor(object);
			addEndpointTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_AbstractCommonTarget_sequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractCommonTarget_sequenceType_feature", "_UI_AbstractCommonTarget_type"),
				 EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractCommonTarget_sequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractCommonTarget_sequence_feature", "_UI_AbstractCommonTarget_type"),
				 EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractCommonTarget_endpointType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractCommonTarget_endpointType_feature", "_UI_AbstractCommonTarget_type"),
				 EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE,
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
			childrenFeatures.add(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT);
			childrenFeatures.add(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY);
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
	 * This returns AbstractCommonTarget.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AbstractCommonTarget"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		TargetSequenceType labelValue = ((AbstractCommonTarget)object).getSequenceType();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractCommonTarget_type") :
			getString("_UI_AbstractCommonTarget_type") + " " + label;
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

		switch (notification.getFeatureID(AbstractCommonTarget.class)) {
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE:
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY:
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT:
			case EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY:
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
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createDefaultEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createAddressEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createTemplateEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createHTTPEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createParentEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createFailoverEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createWSDLEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createLoadBalanceEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createNamedEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createAPIResourceEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createAddressingEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT,
				 EsbFactory.eINSTANCE.createRecipientListEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY,
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
			childFeature == EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
