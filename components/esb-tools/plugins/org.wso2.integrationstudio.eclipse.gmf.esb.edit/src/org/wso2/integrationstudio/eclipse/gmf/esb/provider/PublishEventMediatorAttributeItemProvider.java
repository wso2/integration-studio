/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.eclipse.gmf.esb.provider;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.integrationstudio.eclipse.gmf.esb.AttributeValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

/**
 * This is the item provider adapter for a {@link org.wso2.integrationstudio.eclipse.gmf.esb.PublishEventMediatorAttribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PublishEventMediatorAttributeItemProvider extends AbstractNameValueExpressionAttributeItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PublishEventMediatorAttributeItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addDefaultValuePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Default Value feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultValuePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PublishEventMediatorAttribute_defaultValue_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_PublishEventMediatorAttribute_defaultValue_feature", "_UI_PublishEventMediatorAttribute_type"),
                 EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR_ATTRIBUTE__DEFAULT_VALUE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This returns PublishEventMediatorAttribute.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/PublishEventMediatorAttribute"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public String getText(Object object) {
        String propertyName = ((PublishEventMediatorAttribute) object).getAttributeName();
        String propertyNameLabel = WordUtils.abbreviate(propertyName, 40, 45, " ...");
        String propertyValueType = ((PublishEventMediatorAttribute) object).getAttributeValueType().toString();
        String propertyValue = ((PublishEventMediatorAttribute) object).getAttributeValue();
        String propertyExpression = ((PublishEventMediatorAttribute) object).getAttributeExpression().toString();

        if (propertyValueType.equalsIgnoreCase(AttributeValueType.VALUE.getName())) {
            return propertyName == null || propertyName.length() == 0
                    ? getString("_UI_PublishEventMediatorAttribute_type")
                    : propertyValue != null
                            ? getString("_UI_PublishEventMediatorAttribute_type") + "  -  "
                                    + EEFPropertyViewUtil.spaceFormat(propertyNameLabel)
                                    + EEFPropertyViewUtil.spaceFormat(propertyValue)
                            : EEFPropertyViewUtil.spaceFormat(getString("_UI_PublishEventMediatorAttribute_type"))
                                    + EEFPropertyViewUtil.spaceFormat(propertyNameLabel);
        } else
            return propertyName == null || propertyName.length() == 0
                    ? getString("_UI_PublishEventMediatorAttribute_type")
                    : getString("_UI_PublishEventMediatorAttribute_type") + "  -  "
                            + EEFPropertyViewUtil.spaceFormat(propertyNameLabel)
                            + EEFPropertyViewUtil.spaceFormat(propertyExpression);
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

        switch (notification.getFeatureID(PublishEventMediatorAttribute.class)) {
            case EsbPackage.PUBLISH_EVENT_MEDIATOR_ATTRIBUTE__DEFAULT_VALUE:
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
