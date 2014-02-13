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
import org.wso2.developerstudio.eclipse.esb.EndPointWsdlType;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.WsdlEndPoint;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WsdlEndPointItemProvider
    extends AbstractEndPointItemProvider
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
    public WsdlEndPointItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        super.getPropertyDescriptors(object);

        WsdlEndPoint endPoint = (WsdlEndPoint) object;
        
        // Wsdl Type.
        addWsdlTypePropertyDescriptor(object);
        if (endPoint.getWsdlType().equals(EndPointWsdlType.URI)) {
        	addWsdlURIPropertyDescriptor(object);
        } else {
        	addWsdlXMLPropertyDescriptor(object);
        }
        
        addServicePropertyDescriptor(object);
        addPortPropertyDescriptor(object);
            
        return itemPropertyDescriptors;
    }

    /**
	 * This adds a property descriptor for the Wsdl Type feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addWsdlTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WsdlEndPoint_wsdlType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WsdlEndPoint_wsdlType_feature", "_UI_WsdlEndPoint_type"),
				 EsbPackage.Literals.WSDL_END_POINT__WSDL_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Wsdl URI feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addWsdlURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WsdlEndPoint_wsdlURI_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WsdlEndPoint_wsdlURI_feature", "_UI_WsdlEndPoint_type"),
				 EsbPackage.Literals.WSDL_END_POINT__WSDL_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Wsdl XML feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addWsdlXMLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WsdlEndPoint_wsdlXML_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WsdlEndPoint_wsdlXML_feature", "_UI_WsdlEndPoint_type"),
				 EsbPackage.Literals.WSDL_END_POINT__WSDL_XML,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Service feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addServicePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WsdlEndPoint_service_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WsdlEndPoint_service_feature", "_UI_WsdlEndPoint_type"),
				 EsbPackage.Literals.WSDL_END_POINT__SERVICE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Port feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WsdlEndPoint_port_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WsdlEndPoint_port_feature", "_UI_WsdlEndPoint_type"),
				 EsbPackage.Literals.WSDL_END_POINT__PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This returns WsdlEndPoint.gif.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/WsdlEndPoint"));
	}

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    
    public String getText(Object object) {
    	EndPoint endpoint = (EndPoint) object;
    	String name = endpoint.isAnonymous() ? getString("_UI_Anonymous_label") : endpoint.getEndpointName();
        return String.format("%s [%s]", name, getString("_UI_WsdlEndPoint_qualifier"));         
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

		switch (notification.getFeatureID(WsdlEndPoint.class)) {
			case EsbPackage.WSDL_END_POINT__WSDL_TYPE:
			case EsbPackage.WSDL_END_POINT__WSDL_URI:
			case EsbPackage.WSDL_END_POINT__WSDL_XML:
			case EsbPackage.WSDL_END_POINT__SERVICE:
			case EsbPackage.WSDL_END_POINT__PORT:
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
