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
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CalloutMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutMediatorItemProvider(AdapterFactory adapterFactory) {
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
		CalloutMediator calloutMediator = (CalloutMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
			super.getPropertyDescriptors(object);
			addEndpointTypePropertyDescriptor(object);
			if(calloutMediator.getEndpointType().equals(CalloutEndpointType.ADDRESS_ENDPOINT)){
				addAddressEndpointPropertyDescriptor(object);
			}else{
				addServiceURLPropertyDescriptor(object);
			}
			
			addSoapActionPropertyDescriptor(object);
			addPathToAxis2xmlPropertyDescriptor(object);
			addPathToAxis2RepositoryPropertyDescriptor(object);
			addInitAxis2ClientOptionsPropertyDescriptor(object);
			addPayloadTypePropertyDescriptor(object);
			addResultTypePropertyDescriptor(object);
			
			
			//addPassHeadersPropertyDescriptor(object);
			
			addPayloadTypePropertyDescriptor(object);
			if (calloutMediator.getPayloadType().equals(CalloutPayloadType.XPATH)) {
				addPayloadMessageXpathPropertyDescriptor(object);
			}else if(calloutMediator.getPayloadType().equals(CalloutPayloadType.PROPERTY)){
				addPayloadPropertyPropertyDescriptor(object);
			} 	
			
			addResultTypePropertyDescriptor(object);
			if (calloutMediator.getResultType().equals(CalloutResultType.XPATH)) {
				addResultMessageXpathPropertyDescriptor(object);
			} else {
				addResultContextPropertyPropertyDescriptor(object);
			}
			
			addSecurityTypePropertyDescriptor(object);
			if (calloutMediator.getSecurityType().equals(CalloutSecurityType.TRUE)) {
				addPoliciesPropertyDescriptor(object);
				if(calloutMediator.getPolicies().equals(CalloutSecurityPolicies.TRUE)){
					addOutboundPolicyKeyPropertyDescriptor(object);
					addInboundPolicyKeyPropertyDescriptor(object);
				}else{
					addPolicyKeyPropertyDescriptor(object);
				}
			}  
			
			addDescriptionPropertyDescriptor(object);
	
			
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Service URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addServiceURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_serviceURL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_serviceURL_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__SERVICE_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Service",
				 null));
	}

	/**
	 * This adds a property descriptor for the Soap Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSoapActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_soapAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_soapAction_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__SOAP_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Service",
				 null));
	}

	/**
	 * This adds a property descriptor for the Path To Axis2xml feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPathToAxis2xmlPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_pathToAxis2xml_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_pathToAxis2xml_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Service",
				 null));
	}

	/**
	 * This adds a property descriptor for the Path To Axis2 Repository feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPathToAxis2RepositoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_pathToAxis2Repository_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_pathToAxis2Repository_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Service",
				 null));
	}
	
	
	protected void addPayloadMessageXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_payloadMessageXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_payloadMessageXpath_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH,
				 true,
				 false,
				 false,
				 null,
				 "Source",
				 null));
	}
	
	/*protected void addPayloadRegistryKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_payloadRegistryKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_payloadRegistryKey_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY,
				 true,
				 false,
				 false,
				 null,
				 "Source",
				 null));
	}*/
	
	protected void addResultMessageXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_resultMessageXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_resultMessageXpath_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH,
				 true,
				 false,
				 false,
				 null,
				 "Target",
				 null));
	}
	
	

	/**
	 * This adds a property descriptor for the Payload Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPayloadTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_payloadType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_payloadType_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Source",
				 null));
	}

	/**
	 * This adds a property descriptor for the Result Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addResultTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_resultType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_resultType_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__RESULT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Target",
				 null));
	}

	/**
	 * This adds a property descriptor for the Result Context Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addResultContextPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_resultContextProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_resultContextProperty_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Target",
				 null));
	}

	/**
	 * This adds a property descriptor for the Pass Headers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPassHeadersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_passHeaders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_passHeaders_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__PASS_HEADERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Address Endpoint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAddressEndpointPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_AddressEndpoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_AddressEndpoint_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_ServicePropertyCategory"),
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
				 getString("_UI_CalloutMediator_EndpointType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_EndpointType_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__ENDPOINT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ServicePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Payload Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPayloadPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_payloadProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_payloadProperty_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_SourcePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Security Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecurityTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_securityType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_securityType_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__SECURITY_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_WSPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Outbound Policy Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutboundPolicyKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_outboundPolicyKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_outboundPolicyKey_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_WSPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Inbound Policy Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInboundPolicyKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_inboundPolicyKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_inboundPolicyKey_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_WSPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Policies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPoliciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_policies_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_policies_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__POLICIES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_WSPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Policy Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPolicyKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_policyKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_policyKey_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__POLICY_KEY,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_WSPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Init Axis2 Client Options feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInitAxis2ClientOptionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CalloutMediator_initAxis2ClientOptions_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CalloutMediator_initAxis2ClientOptions_feature", "_UI_CalloutMediator_type"),
				 EsbPackage.Literals.CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Service",
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
			childrenFeatures.add(EsbPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH);
			childrenFeatures.add(EsbPackage.Literals.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH);
			childrenFeatures.add(EsbPackage.Literals.CALLOUT_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT);
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
	 * This returns CalloutMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CalloutMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((CalloutMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_CalloutMediator_type") :
			getString("_UI_CalloutMediator_type") + " " + label;
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

		switch (notification.getFeatureID(CalloutMediator.class)) {
			case EsbPackage.CALLOUT_MEDIATOR__SERVICE_URL:
			case EsbPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
			case EsbPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
			case EsbPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_PROPERTY:
			case EsbPackage.CALLOUT_MEDIATOR__SECURITY_TYPE:
			case EsbPackage.CALLOUT_MEDIATOR__POLICIES:
			case EsbPackage.CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
			case EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT:
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
				(EsbPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CALLOUT_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCalloutMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createCalloutMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT,
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
			childFeature == EsbPackage.Literals.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH ||
			childFeature == EsbPackage.Literals.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
