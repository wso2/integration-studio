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
import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceSessionType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadBalanceEndPointItemProvider
    extends ParentEndPointItemProvider
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
    public LoadBalanceEndPointItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        super.getPropertyDescriptors(object);

        LoadBalanceEndPoint endPoint = (LoadBalanceEndPoint) object;
        
        // Algorithm.
        addAlgorithmPropertyDescriptor(object);
                
        // Session type.
        addSessionTypePropertyDescriptor(object);

        // Session timeout.
        if (!endPoint.getSessionType().equals(LoadBalanceSessionType.NONE)) {
        	addSessionTimeoutPropertyDescriptor(object);
        }

        return itemPropertyDescriptors;
    }

    /**
	 * This adds a property descriptor for the Algorithm feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addAlgorithmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_algorithm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_algorithm_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__ALGORITHM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Session Type feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addSessionTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_sessionType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_sessionType_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__SESSION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Session Timeout feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addSessionTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_sessionTimeout_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_sessionTimeout_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This returns LoadBalanceEndPoint.gif.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LoadBalanceEndPoint"));
	}

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    
    public String getText(Object object) {
    	EndPoint endpoint = (EndPoint) object;
    	String name = endpoint.isAnonymous() ? getString("_UI_Anonymous_label") : endpoint.getEndpointName();
        return String.format("%s [%s]", name, getString("_UI_LoadBalanceEndPoint_qualifier")); 
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

		switch (notification.getFeatureID(LoadBalanceEndPoint.class)) {
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
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
     */
    
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    	newChildDescriptors.add
        (createChildParameter
            (EsbPackage.Literals.PARENT_END_POINT__CHILDREN,
             EsbFactory.eINSTANCE.createAddressEndPoint()));

    	newChildDescriptors.add
        (createChildParameter
            (EsbPackage.Literals.PARENT_END_POINT__CHILDREN,
             EsbFactory.eINSTANCE.createWsdlEndPoint()));

    	newChildDescriptors.add
        (createChildParameter
            (EsbPackage.Literals.PARENT_END_POINT__CHILDREN,
             EsbFactory.eINSTANCE.createFailoverEndPoint()));

    	newChildDescriptors.add
        (createChildParameter
            (EsbPackage.Literals.PARENT_END_POINT__CHILDREN,
             EsbFactory.eINSTANCE.createLoadBalanceEndPoint()));
    	
    	newChildDescriptors.add
        (createChildParameter
            (EsbPackage.Literals.PARENT_END_POINT__CHILDREN,
             EsbFactory.eINSTANCE.createDynamicLoadBalanceEndPoint()));
    }

}
