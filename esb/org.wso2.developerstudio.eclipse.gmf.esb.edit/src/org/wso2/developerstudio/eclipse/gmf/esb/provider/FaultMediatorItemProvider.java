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
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultDetailType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultReasonType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultSoapVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultStringType;

/**
 * This is the item provider adapter for a
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class FaultMediatorItemProvider extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FaultMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		FaultMediator faultMediator = (FaultMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addSoapVersionPropertyDescriptor(object);
		if (faultMediator.getSoapVersion().equals(FaultSoapVersion.SOAP_11)) {
			//addFaultCodeTypePropertyDescriptor(object);
			addFaultCodeSoap11PropertyDescriptor(object);
			addFaultStringTypePropertyDescriptor(object);

			if (faultMediator.getFaultStringType().equals(FaultStringType.VALUE)) {
				addFaultStringValuePropertyDescriptor(object);
			} else {
				addFaultStringExpressionPropertyDescriptor(object);
			}
			
			/*if(faultMediator.getFaultCodeType().equals(FaultCodeType.EXPRESSION)){
				addFaultCodeExpressionPropertyDescriptor(object);	
			}else{
				addFaultCodeSoap11PropertyDescriptor(object);
			}*/

			addFaultActorPropertyDescriptor(object);
		}else if (faultMediator.getSoapVersion().equals(FaultSoapVersion.SOAP_12)) {
			//addFaultCodeTypePropertyDescriptor(object);
			addFaultCodeSoap12PropertyDescriptor(object);
			addFaultReasonTypePropertyDescriptor(object);

			if (faultMediator.getFaultReasonType().equals(FaultReasonType.VALUE)) {
				addFaultReasonValuePropertyDescriptor(object);
			} else {
				addFaultReasonExpressionPropertyDescriptor(object);
			}
			
			/*if(faultMediator.getFaultCodeType().equals(FaultCodeType.EXPRESSION)){
				addFaultCodeExpressionPropertyDescriptor(object);	
			}else{
				addFaultCodeSoap12PropertyDescriptor(object);
			}*/

			addRoleNamePropertyDescriptor(object);
			addNodeNamePropertyDescriptor(object);
		} else {

			addFaultReasonTypePropertyDescriptor(object);
			if (faultMediator.getFaultReasonType().equals(FaultReasonType.VALUE)) {
				addFaultReasonValuePropertyDescriptor(object);
			} else {
				addFaultReasonExpressionPropertyDescriptor(object);
			}

		}

		addFaultDetailTypePropertyDescriptor(object);
		if (faultMediator.getFaultDetailType().equals(FaultDetailType.EXPRESSION)) {
			addFaultDetailExpressionPropertyDescriptor(object);
		} else {
			addFaultDetailValuePropertyDescriptor(object);
		}	
		
		addSerializeResponsePropertyDescriptor(object);
		if (faultMediator.isSerializeResponse()) {
			addMarkAsResponsePropertyDescriptor(object);
		}
		addDescriptionPropertyDescriptor(object);
		
		return itemPropertyDescriptors;
	}

	protected void addFaultStringExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_FaultMediator_faultStringExpression_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_FaultMediator_faultStringExpression_feature",
						"_UI_FaultMediator_type"),
				EsbPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION,
				true, false, false, ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
				"Reason", null));
	}

	protected void addFaultReasonExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_FaultMediator_faultReasonExpression_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_FaultMediator_faultReasonExpression_feature",
						"_UI_FaultMediator_type"),
				EsbPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION,
				true, false, false, ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
				"Reason", null));
	}

	protected void addFaultDetailExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_FaultMediator_faultDetailExpression_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_FaultMediator_faultDetailExpression_feature",
						"_UI_FaultMediator_type"),
				EsbPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION,
				true, false, false, ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
				"Detail", null));
	}

	/**
	 * This adds a property descriptor for the Soap Version feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSoapVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_soapVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_soapVersion_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__SOAP_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Serialize Response feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSerializeResponsePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_serializeResponse_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_serializeResponse_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__SERIALIZE_RESPONSE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mark As Response feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMarkAsResponsePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_markAsResponse_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_markAsResponse_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__MARK_AS_RESPONSE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Code Soap11 feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addFaultCodeSoap11PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultCodeSoap11_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultCodeSoap11_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_SOAP11,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Code",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Code Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultCodeTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultCodeType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultCodeType_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Code Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultCodeExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultCodeExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultCodeExpression_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault String Type feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addFaultStringTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultStringType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultStringType_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Reason",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault String Value feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addFaultStringValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultStringValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultStringValue_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Reason",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Actor feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFaultActorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultActor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultActor_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_ACTOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Code Soap12 feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addFaultCodeSoap12PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultCodeSoap12_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultCodeSoap12_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_SOAP12,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Code",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Reason Type feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addFaultReasonTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultReasonType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultReasonType_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Reason",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Reason Value feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addFaultReasonValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultReasonValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultReasonValue_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Reason",
				 null));
	}

	/**
	 * This adds a property descriptor for the Role Name feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRoleNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_roleName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_roleName_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__ROLE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Node Name feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNodeNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_nodeName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_nodeName_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__NODE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Detail Type feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addFaultDetailTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultDetailType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultDetailType_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Detail",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Detail Value feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addFaultDetailValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultMediator_faultDetailValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultMediator_faultDetailValue_feature", "_UI_FaultMediator_type"),
				 EsbPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Detail",
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EsbPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION);
			childrenFeatures.add(EsbPackage.Literals.FAULT_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.FAULT_MEDIATOR__OUTPUT_CONNECTOR);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns FaultMediator.gif. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FaultMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((FaultMediator)object).getRoleName();
		return label == null || label.length() == 0 ?
			getString("_UI_FaultMediator_type") :
			getString("_UI_FaultMediator_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(FaultMediator.class)) {
			case EsbPackage.FAULT_MEDIATOR__SOAP_VERSION:
			case EsbPackage.FAULT_MEDIATOR__SERIALIZE_RESPONSE:
			case EsbPackage.FAULT_MEDIATOR__MARK_AS_RESPONSE:
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_TYPE:
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
			case EsbPackage.FAULT_MEDIATOR__FAULT_ACTOR:
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
			case EsbPackage.FAULT_MEDIATOR__ROLE_NAME:
			case EsbPackage.FAULT_MEDIATOR__NODE_NAME:
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION:
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
			case EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAULT_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createFaultMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAULT_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createFaultMediatorOutputConnector()));
	}

	/**
	 * This returns the label text for
	 * {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EsbPackage.Literals.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION ||
			childFeature == EsbPackage.Literals.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION ||
			childFeature == EsbPackage.Literals.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION ||
			childFeature == EsbPackage.Literals.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
