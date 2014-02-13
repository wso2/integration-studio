/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractEndPointItemProvider
    extends EndPointItemProvider
    implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource {
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
     */
    
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {    	        
        super.getPropertyDescriptors(object);
        
        AbstractEndPoint endPoint = (AbstractEndPoint) object;

        // Reliable messaging.
        addReliableMessagingEnabledPropertyDescriptor(object);
        if (endPoint.isReliableMessagingEnabled()) {
        	addReliableMessagingPolicyPropertyDescriptor(object);
        }
        
        // Security.
        addSecurityEnabledPropertyDescriptor(object);
        if (endPoint.isSecurityEnabled()) {
        	addSecurityPolicyPropertyDescriptor(object);
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
            
        return itemPropertyDescriptors;
    }

    /**
	 * This adds a property descriptor for the Reliable Messaging Enabled feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_QoSPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Reliable Messaging Policy feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 false,
				 null,
				 getString("_UI_QoSPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Security Enabled feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_QoSPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Security Policy feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 false,
				 null,
				 getString("_UI_QoSPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Addressing Enabled feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_QoSPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Addressing Version feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_QoSPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Addressing Separate Listener feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_QoSPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Time Out Duration feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_TimeoutPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Time Out Action feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_TimeoutPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Retry Error Codes feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_RetryPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Retry Count feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_RetryPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Retry Delay feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_RetryPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Suspend Error Codes feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_SuspendPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Suspend Initial Duration feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_SuspendPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Suspend Maximum Duration feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_SuspendPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Suspend Progression Factor feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
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
				 getString("_UI_SuspendPropertyCategory"),
				 null));
	}

    /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public String getText(Object object) {
		String label = ((AbstractEndPoint)object).getEndpointName();
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
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY:
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
