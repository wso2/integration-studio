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
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EntitlementMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		EntitlementMediator mediator= (EntitlementMediator)object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
			super.getPropertyDescriptors(object);

			addEntitlementServerURLPropertyDescriptor(object);
			addUsernamePropertyDescriptor(object);
			addPasswordPropertyDescriptor(object);
			addCallbackHandlerPropertyDescriptor(object);
			if(mediator.getCallbackHandler().equals(EntitlementCallbackHandler.CUSTOM)){
				addCallbackClassNamePropertyDescriptor(object);
			}
			
			addEntitlementClientTypePropertyDescriptor(object);
			if(mediator.getEntitlementClientType().equals(EntitlementClientType.THRIFT)){
				addThriftHostPropertyDescriptor(object);
				addThriftPortPropertyDescriptor(object);
			}
			addOnRejectSequenceTypePropertyDescriptor(object);
			if(mediator.getOnRejectSequenceType().equals(EntitlementSequenceType.REGISTRY_REFERENCE)){
				addOnRejectSequenceKeyPropertyDescriptor(object);
			}
			addOnAcceptSequenceTypePropertyDescriptor(object);
			if(mediator.getOnAcceptSequenceType().equals(EntitlementSequenceType.REGISTRY_REFERENCE)){
				addOnAcceptSequenceKeyPropertyDescriptor(object);
			}
			addAdviceSequenceTypePropertyDescriptor(object);
			if(mediator.getAdviceSequenceType().equals(EntitlementSequenceType.REGISTRY_REFERENCE)){
				addAdviceSequenceKeyPropertyDescriptor(object);
			}
			addObligationsSequenceTypePropertyDescriptor(object);
			if(mediator.getObligationsSequenceType().equals(EntitlementSequenceType.REGISTRY_REFERENCE)){
				addObligationsSequenceKeyPropertyDescriptor(object);
			}
			addDescriptionPropertyDescriptor(object);
		
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Entitlement Server URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntitlementServerURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_entitlementServerURL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_entitlementServerURL_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Username feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsernamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_username_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_username_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__USERNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_password_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_password_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Callback Class Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCallbackClassNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_callbackClassName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_callbackClassName_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Thrift Host feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addThriftHostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_thriftHost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_thriftHost_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__THRIFT_HOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Thrift Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addThriftPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_thriftPort_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_thriftPort_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__THRIFT_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Entitlement Client Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntitlementClientTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_entitlementClientType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_entitlementClientType_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the On Reject Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOnRejectSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_onRejectSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_onRejectSequenceType_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the On Accept Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOnAcceptSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_onAcceptSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_onAcceptSequenceType_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Advice Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdviceSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_adviceSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_adviceSequenceType_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Obligations Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addObligationsSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_obligationsSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_obligationsSequenceType_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the On Reject Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOnRejectSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_onRejectSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_onRejectSequenceKey_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the On Accept Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOnAcceptSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_onAcceptSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_onAcceptSequenceKey_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Advice Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdviceSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_adviceSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_adviceSequenceKey_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Obligations Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addObligationsSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_obligationsSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_obligationsSequenceKey_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Callback Handler feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCallbackHandlerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EntitlementMediator_callbackHandler_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EntitlementMediator_callbackHandler_feature", "_UI_EntitlementMediator_type"),
				 EsbPackage.Literals.ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER,
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
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR);
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
	 * This returns EntitlementMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EntitlementMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((EntitlementMediator)object).getUsername();
		return label == null || label.length() == 0 ?
			getString("_UI_EntitlementMediator_type") :
			getString("_UI_EntitlementMediator_type") + " " + label;
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

		switch (notification.getFeatureID(EntitlementMediator.class)) {
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL:
			case EsbPackage.ENTITLEMENT_MEDIATOR__USERNAME:
			case EsbPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME:
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_HOST:
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_PORT:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE:
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE:
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY:
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER:
			case EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR:
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR:
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
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER,
				 EsbFactory.eINSTANCE.createEntitlementContainer()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createEntitlementMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createEntitlementMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createEntitlementMediatorOnRejectOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createEntitlementMediatorOnAcceptOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createEntitlementMediatorAdviceOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createEntitlementMediatorObligationsOutputConnector()));
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
			childFeature == EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
