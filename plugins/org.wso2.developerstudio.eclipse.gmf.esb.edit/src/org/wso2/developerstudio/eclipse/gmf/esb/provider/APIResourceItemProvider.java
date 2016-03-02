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

import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class APIResourceItemProvider
	extends EsbNodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceItemProvider(AdapterFactory adapterFactory) {
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
		APIResource apiResource = (APIResource) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
			super.getPropertyDescriptors(object);

			addUrlStylePropertyDescriptor(object);
			
			if(apiResource.getUrlStyle().equals(ApiResourceUrlStyle.URI_TEMPLATE)){
				addUriTemplatePropertyDescriptor(object);
			} else if (apiResource.getUrlStyle().equals(ApiResourceUrlStyle.URL_MAPPING)){
				addUrlMappingPropertyDescriptor(object);
			}
			
			addAllowGetPropertyDescriptor(object);
			addAllowPostPropertyDescriptor(object);
			addAllowPutPropertyDescriptor(object);
			addAllowDeletePropertyDescriptor(object);
			addAllowOptionsPropertyDescriptor(object);
			addAllowHeadPropertyDescriptor(object);
			addAllowPatchPropertyDescriptor(object);
			addProtocolPropertyDescriptor(object);
			
			addInSequenceTypePropertyDescriptor(object);
			switch (apiResource.getInSequenceType()){
				case REGISTRY_REFERENCE:{
					addInSequenceKeyPropertyDescriptor(object);
					break;
				}
				case NAMED_REFERENCE:{
					addInSequenceNamePropertyDescriptor(object);
					break;
				}
			}
			addOutSequenceTypePropertyDescriptor(object);
			switch (apiResource.getOutSequenceType()) {
				case REGISTRY_REFERENCE: {
					addOutSequenceKeyPropertyDescriptor(object);
					break;
				}
				case NAMED_REFERENCE: {
					addOutSequenceNamePropertyDescriptor(object);
					break;
				}
				}
			addFaultSequenceTypePropertyDescriptor(object);
			switch (apiResource.getFaultSequenceType()){
				case REGISTRY_REFERENCE:{
					addFaultSequenceKeyPropertyDescriptor(object);
					break;
				}
				case NAMED_REFERENCE:{
					addFaultSequenceNamePropertyDescriptor(object);
					break;
				}
		}
			
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Url Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUrlStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_urlStyle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_urlStyle_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__URL_STYLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Uri Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUriTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_uriTemplate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_uriTemplate_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__URI_TEMPLATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Url Mapping feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUrlMappingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_urlMapping_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_urlMapping_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__URL_MAPPING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Get feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowGetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_allowGet_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_allowGet_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_GET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Post feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowPostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_allowPost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_allowPost_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_POST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Put feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowPutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_allowPut_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_allowPut_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_PUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Delete feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_allowDelete_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_allowDelete_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_DELETE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Options feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowOptionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_allowOptions_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_allowOptions_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_OPTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Head feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowHeadPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_allowHead_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_allowHead_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_HEAD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Patch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addAllowPatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_allowPatch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_allowPatch_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__ALLOW_PATCH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_MethodsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the In Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_inSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_inSequenceType_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "In Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the In Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_inSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_inSequenceKey_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 "In Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the In Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_inSequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_inSequenceName_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "In Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Out Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOutSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_outSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_outSequenceType_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Out Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Out Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOutSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_outSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_outSequenceKey_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 "Out Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Out Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOutSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_outSequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_outSequenceName_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Out Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFaultSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_faultSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_faultSequenceType_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__FAULT_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Fault Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFaultSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_faultSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_faultSequenceKey_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__FAULT_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 "Fault Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFaultSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_faultSequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_faultSequenceName_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__FAULT_SEQUENCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Fault Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Protocol feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addProtocolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_APIResource_protocol_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_APIResource_protocol_feature", "_UI_APIResource_type"),
				 EsbPackage.Literals.API_RESOURCE__PROTOCOL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"), 
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
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__FAULT_INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__CONTAINER);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.API_RESOURCE__FAULT_SEQUENCE_KEY);
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
	 * This returns APIResource.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/APIResource"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((APIResource)object).getInSequenceName();
		return label == null || label.length() == 0 ?
			getString("_UI_APIResource_type") :
			getString("_UI_APIResource_type") + " " + label;
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

		switch (notification.getFeatureID(APIResource.class)) {
			case EsbPackage.API_RESOURCE__URL_STYLE:
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
			case EsbPackage.API_RESOURCE__URL_MAPPING:
			case EsbPackage.API_RESOURCE__ALLOW_GET:
			case EsbPackage.API_RESOURCE__ALLOW_POST:
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
			case EsbPackage.API_RESOURCE__ALLOW_HEAD:
			case EsbPackage.API_RESOURCE__ALLOW_PATCH:
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_TYPE:
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_NAME:
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_TYPE:
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_NAME:
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_TYPE:
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_NAME:
			case EsbPackage.API_RESOURCE__PROTOCOL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.API_RESOURCE__INPUT_CONNECTOR:
			case EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR:
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS:
			case EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR:
			case EsbPackage.API_RESOURCE__CONTAINER:
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY:
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY:
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY:
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
				(EsbPackage.Literals.API_RESOURCE__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createAPIResourceInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createAPIResourceOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createAPIResourceOutSequenceOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS,
				 EsbFactory.eINSTANCE.createAPIResourceInSequenceInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__FAULT_INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createAPIResourceFaultInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__CONTAINER,
				 EsbFactory.eINSTANCE.createProxyServiceContainer()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.API_RESOURCE__FAULT_SEQUENCE_KEY,
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
			childFeature == EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.API_RESOURCE__OUT_SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.API_RESOURCE__FAULT_SEQUENCE_KEY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
