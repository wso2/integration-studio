/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.provider;


import java.util.ArrayList;
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
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NamedEndpointItemProvider
	extends AbstractEndPointItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedEndpointItemProvider(AdapterFactory adapterFactory) {
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
		}else{
	        itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
	    }
		addInLinePropertyDescriptor(object);
		addReferringEndpointTypePropertyDescriptor(object);
		if(((NamedEndpoint)object).getReferringEndpointType().equals(KeyType.DYNAMIC)){
			addDynamicReferenceKeyPropertyDescriptor(object);
		}else {
			addStaticReferenceKeyPropertyDescriptor(object);
		}
		
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NamedEndpoint_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedEndpoint_name_feature", "_UI_NamedEndpoint_type"),
				 EsbPackage.Literals.NAMED_ENDPOINT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Referring Endpoint Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferringEndpointTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NamedEndpoint_referringEndpointType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedEndpoint_referringEndpointType_feature", "_UI_NamedEndpoint_type"),
				 EsbPackage.Literals.NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dynamic Reference Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDynamicReferenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NamedEndpoint_dynamicReferenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedEndpoint_dynamicReferenceKey_feature", "_UI_NamedEndpoint_type"),
				 EsbPackage.Literals.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Static Reference Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStaticReferenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NamedEndpoint_staticReferenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedEndpoint_staticReferenceKey_feature", "_UI_NamedEndpoint_type"),
				 EsbPackage.Literals.NAMED_ENDPOINT__STATIC_REFERENCE_KEY,
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
			childrenFeatures.add(EsbPackage.Literals.NAMED_ENDPOINT__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.NAMED_ENDPOINT__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.NAMED_ENDPOINT__STATIC_REFERENCE_KEY);
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
	 * This returns NamedEndpoint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/NamedEndpoint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((NamedEndpoint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_NamedEndpoint_type") :
			getString("_UI_NamedEndpoint_type") + " " + label;
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

		switch (notification.getFeatureID(NamedEndpoint.class)) {
			case EsbPackage.NAMED_ENDPOINT__NAME:
			case EsbPackage.NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.NAMED_ENDPOINT__INPUT_CONNECTOR:
			case EsbPackage.NAMED_ENDPOINT__OUTPUT_CONNECTOR:
			case EsbPackage.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY:
			case EsbPackage.NAMED_ENDPOINT__STATIC_REFERENCE_KEY:
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
				(EsbPackage.Literals.NAMED_ENDPOINT__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createNamedEndpointInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.NAMED_ENDPOINT__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createNamedEndpointOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.NAMED_ENDPOINT__STATIC_REFERENCE_KEY,
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
			childFeature == EsbPackage.Literals.ABSTRACT_END_POINT__INBOUND_POLICY ||
			childFeature == EsbPackage.Literals.ABSTRACT_END_POINT__OUTBOUND_POLICY ||
			childFeature == EsbPackage.Literals.NAMED_ENDPOINT__STATIC_REFERENCE_KEY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
