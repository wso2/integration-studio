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

import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractEndPointItemProvider
	extends EndPointItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractEndPointItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {		
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
			super.getPropertyDescriptors(object);

	        AbstractEndPoint endPoint = (AbstractEndPoint) object;

	        addFormatPropertyDescriptor(object);
	        addOptimizePropertyDescriptor(object);
	        addTraceEnabledPropertyDescriptor(object);
	        addStatisticsEnabledPropertyDescriptor(object);
	        
	        // Reliable messaging.
	        addReliableMessagingEnabledPropertyDescriptor(object);
	        if (endPoint.isReliableMessagingEnabled()) {
	        	addReliableMessagingPolicyPropertyDescriptor(object);
	        }
	        
	        // Security.
	        addSecurityEnabledPropertyDescriptor(object);
	        if (endPoint.isSecurityEnabled()) {
	        	addSecurityPolicyPropertyDescriptor(object);
	        	addInboundSecurityPolicyPropertyDescriptor(object);
	        	addOutboundSecurityPolicyPropertyDescriptor(object);
	        }
	        
	        // Addressing.        
	        addAddressingEnabledPropertyDescriptor(object);
	        if (endPoint.isAddressingEnabled()) {
	        	addAddressingVersionPropertyDescriptor(object);
	        	addAddressingSeparateListenerPropertyDescriptor(object);
	        }
	        
	        // Timeout.                
	        addTimeOutDurationPropertyDescriptor(object);
	        addTimeOutActionPropertyDescriptor(object);
	        
	        // Retry.
	        addRetryErrorCodesPropertyDescriptor(object);
	        addRetryCountPropertyDescriptor(object);
	        addRetryDelayPropertyDescriptor(object);
	        
	        // Suspend.
	        addSuspendErrorCodesPropertyDescriptor(object);
	        addSuspendInitialDurationPropertyDescriptor(object);
	        addSuspendMaximumDurationPropertyDescriptor(object);
	        addSuspendProgressionFactorPropertyDescriptor(object);
	        
//			addReliableMessagingEnabledPropertyDescriptor(object);
//			addSecurityEnabledPropertyDescriptor(object);
//			addAddressingEnabledPropertyDescriptor(object);
//			addAddressingVersionPropertyDescriptor(object);
//			addAddressingSeparateListenerPropertyDescriptor(object);
//			addTimeOutDurationPropertyDescriptor(object);
//			addTimeOutActionPropertyDescriptor(object);
//			addRetryErrorCodesPropertyDescriptor(object);
//			addRetryCountPropertyDescriptor(object);
//			addRetryDelayPropertyDescriptor(object);
//			addSuspendErrorCodesPropertyDescriptor(object);
//			addSuspendInitialDurationPropertyDescriptor(object);
//			addSuspendMaximumDurationPropertyDescriptor(object);
//			addSuspendProgressionFactorPropertyDescriptor(object);
//			addReliableMessagingPolicyPropertyDescriptor(object);
//			addSecurityPolicyPropertyDescriptor(object);
	
	        addDescriptionPropertyDescriptor(object);
			if(object instanceof AbstractEndPoint){
				if(((AbstractEndPoint)object).eContainer() != null){
					if(((AbstractEndPoint)object).eContainer().eContainer() instanceof Template){
						addTemplateParametersPropertyDescriptor(object);		
					}
				}
			}
	        
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Reliable Messaging Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addReliableMessagingEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_reliableMessagingEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_reliableMessagingEnabled_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Security Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSecurityEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_securityEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_securityEnabled_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__SECURITY_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Addressing Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addAddressingEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_addressingEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_addressingEnabled_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__ADDRESSING_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Addressing Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addAddressingVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_addressingVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_addressingVersion_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__ADDRESSING_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Addressing Separate Listener feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addAddressingSeparateListenerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_addressingSeparateListener_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_addressingSeparateListener_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Time Out Duration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTimeOutDurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_timeOutDuration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_timeOutDuration_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__TIME_OUT_DURATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "Timeout",
				 null));
	}

	/**
	 * This adds a property descriptor for the Time Out Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTimeOutActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_timeOutAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_timeOutAction_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__TIME_OUT_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Timeout",
				 null));
	}

	/**
	 * This adds a property descriptor for the Retry Error Codes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addRetryErrorCodesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_retryErrorCodes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_retryErrorCodes_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__RETRY_ERROR_CODES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Endpoint Timeout State",
				 null));
	}

	/**
	 * This adds a property descriptor for the Retry Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addRetryCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_retryCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_retryCount_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__RETRY_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "Endpoint Timeout State",
				 null));
	}

	/**
	 * This adds a property descriptor for the Retry Delay feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addRetryDelayPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_retryDelay_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_retryDelay_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__RETRY_DELAY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "Endpoint Timeout State",
				 null));
	}

	/**
	 * This adds a property descriptor for the Suspend Error Codes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSuspendErrorCodesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_suspendErrorCodes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_suspendErrorCodes_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__SUSPEND_ERROR_CODES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Endpoint Suspend State",
				 null));
	}

	/**
	 * This adds a property descriptor for the Suspend Initial Duration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSuspendInitialDurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_suspendInitialDuration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_suspendInitialDuration_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "Endpoint Suspend State",
				 null));
	}

	/**
	 * This adds a property descriptor for the Suspend Maximum Duration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSuspendMaximumDurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_suspendMaximumDuration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_suspendMaximumDuration_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "Endpoint Suspend State",
				 null));
	}

	/**
	 * This adds a property descriptor for the Suspend Progression Factor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSuspendProgressionFactorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_suspendProgressionFactor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_suspendProgressionFactor_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 "Endpoint Suspend State",
				 null));
	}

	/**
	 * This adds a property descriptor for the Reliable Messaging Policy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addReliableMessagingPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_reliableMessagingPolicy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_reliableMessagingPolicy_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY,
				 true,
				 false,
				 true,
				 null,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Security Policy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSecurityPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_securityPolicy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_securityPolicy_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__SECURITY_POLICY,
				 true,
				 false,
				 true,
				 null,
				 "QoS",
				 null));
	}
	
	/**
	 * This adds a property descriptor for the inbound Policy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInboundSecurityPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_inboundPolicy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_inboundPolicy_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__INBOUND_POLICY,
				 true,
				 false,
				 true,
				 null,
				 "QoS",
				 null));
	}
	
	/**
	 * This adds a property descriptor for the outbound Policy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOutboundSecurityPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_outboundPolicy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_outboundPolicy_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__OUTBOUND_POLICY,
				 true,
				 false,
				 true,
				 null,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_format_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_format_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__FORMAT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Optimize feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOptimizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_optimize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_optimize_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__OPTIMIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Template Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemplateParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_templateParameters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_templateParameters_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Statistics Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addStatisticsEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_statisticsEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_statisticsEnabled_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__STATISTICS_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTraceEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractEndPoint_traceEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractEndPoint_traceEnabled_feature", "_UI_AbstractEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_END_POINT__TRACE_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Basic",
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
			childrenFeatures.add(EsbPackage.Literals.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS);
			childrenFeatures.add(EsbPackage.Literals.ABSTRACT_END_POINT__INBOUND_POLICY);
			childrenFeatures.add(EsbPackage.Literals.ABSTRACT_END_POINT__OUTBOUND_POLICY);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((AbstractEndPoint)object).getEndPointName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractEndPoint_type") :
			getString("_UI_AbstractEndPoint_type") + " " + label;
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

		switch (notification.getFeatureID(AbstractEndPoint.class)) {
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED:
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_ENABLED:
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_ENABLED:
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_VERSION:
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER:
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_DURATION:
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_ACTION:
			case EsbPackage.ABSTRACT_END_POINT__RETRY_ERROR_CODES:
			case EsbPackage.ABSTRACT_END_POINT__RETRY_COUNT:
			case EsbPackage.ABSTRACT_END_POINT__RETRY_DELAY:
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_ERROR_CODES:
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION:
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION:
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR:
			case EsbPackage.ABSTRACT_END_POINT__FORMAT:
			case EsbPackage.ABSTRACT_END_POINT__OPTIMIZE:
			case EsbPackage.ABSTRACT_END_POINT__STATISTICS_ENABLED:
			case EsbPackage.ABSTRACT_END_POINT__TRACE_ENABLED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS:
			case EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY:
			case EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY:
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
				(EsbPackage.Literals.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS,
				 EsbFactory.eINSTANCE.createTemplateParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_END_POINT__INBOUND_POLICY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ABSTRACT_END_POINT__OUTBOUND_POLICY,
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
			childFeature == EsbPackage.Literals.ABSTRACT_END_POINT__OUTBOUND_POLICY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
