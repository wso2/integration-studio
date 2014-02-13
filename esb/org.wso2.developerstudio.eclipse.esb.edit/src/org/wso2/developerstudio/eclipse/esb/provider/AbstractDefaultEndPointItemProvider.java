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
import org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint;
import org.wso2.developerstudio.eclipse.esb.EndPointMessageFormat;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractDefaultEndPointItemProvider
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
    public AbstractDefaultEndPointItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {    	
        super.getPropertyDescriptors(object);
        if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
        
        AbstractDefaultEndPoint abstractDefaultEndPoint = (AbstractDefaultEndPoint)object;
        addMessageFormatPropertyDescriptor(object);
        if(abstractDefaultEndPoint.getMessageFormat().equals(EndPointMessageFormat.GET)){
        	addRestTypePropertyDescriptor(object);
        }
        addAttachmentOptimizationPropertyDescriptor(object);
        addEncodingPropertyDescriptor(object);
        addStatisticsEnabledPropertyDescriptor(object);
        addTraceEnabledPropertyDescriptor(object);
        
        return itemPropertyDescriptors;
    }

    /**
	 * This adds a property descriptor for the Message Format feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addMessageFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDefaultEndPoint_messageFormat_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDefaultEndPoint_messageFormat_feature", "_UI_AbstractDefaultEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_DEFAULT_END_POINT__MESSAGE_FORMAT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Attachment Optimization feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addAttachmentOptimizationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDefaultEndPoint_attachmentOptimization_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDefaultEndPoint_attachmentOptimization_feature", "_UI_AbstractDefaultEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_DEFAULT_END_POINT__ATTACHMENT_OPTIMIZATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Encoding feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addEncodingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDefaultEndPoint_encoding_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDefaultEndPoint_encoding_feature", "_UI_AbstractDefaultEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_DEFAULT_END_POINT__ENCODING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Statistics Enabled feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addStatisticsEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDefaultEndPoint_statisticsEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDefaultEndPoint_statisticsEnabled_feature", "_UI_AbstractDefaultEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_DEFAULT_END_POINT__STATISTICS_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Trace Enabled feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addTraceEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDefaultEndPoint_traceEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDefaultEndPoint_traceEnabled_feature", "_UI_AbstractDefaultEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_DEFAULT_END_POINT__TRACE_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

    /**
	 * This adds a property descriptor for the Rest Type feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addRestTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDefaultEndPoint_restType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDefaultEndPoint_restType_feature", "_UI_AbstractDefaultEndPoint_type"),
				 EsbPackage.Literals.ABSTRACT_DEFAULT_END_POINT__REST_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
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
		String label = ((AbstractDefaultEndPoint)object).getEndpointName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractDefaultEndPoint_type") :
			getString("_UI_AbstractDefaultEndPoint_type") + " " + label;
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

		switch (notification.getFeatureID(AbstractDefaultEndPoint.class)) {
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__MESSAGE_FORMAT:
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ATTACHMENT_OPTIMIZATION:
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ENCODING:
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__STATISTICS_ENABLED:
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__TRACE_ENABLED:
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__REST_TYPE:
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
