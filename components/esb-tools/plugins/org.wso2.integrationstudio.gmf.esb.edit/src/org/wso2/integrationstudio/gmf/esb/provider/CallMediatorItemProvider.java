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
package org.wso2.integrationstudio.gmf.esb.provider;

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

import org.wso2.integrationstudio.gmf.esb.CallMediator;
import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.SendMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.integrationstudio.gmf.esb.CallMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CallMediatorItemProvider extends MediatorItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CallMediatorItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        CallMediator callMediator = (CallMediator) object;
        if (itemPropertyDescriptors != null) {
            itemPropertyDescriptors.clear();
        }
        super.getPropertyDescriptors(object);

        addEndpointTypePropertyDescriptor(object);
        addEnableBlockingCallsPropertyDescriptor(object);
        switch (callMediator.getEndpointType()) {
        case NONE:
        case INLINE:
            break;
        case REGISRTYKEY:
            addEndpointRegistrykeyPropertyDescriptor(object);
            break;
        case XPATH:
            addEndpointXpathPropertyDescriptor(object);
            break;
        }

        addDescriptionPropertyDescriptor(object);
        
        addSourceTypePropertyDescriptor(object);
        addContentTypePropertyDescriptor(object);
        switch (callMediator.getSourceType()) {
        case NONE:
        case BODY:
            break;
        case PROPERTY:
            addSourcePropertyPropertyDescriptor(object);
            break;
        case INLINE:
            addSourcePayloadPropertyDescriptor(object);
            break;
        case CUSTOM:
            addSourceXpathPropertyDescriptor(object);
        }
        addTargetTypePropertyDescriptor(object);
        switch (callMediator.getTargetType()) {
        case NONE:
        case BODY:
            break;
        case PROPERTY:
            addTargetPropertyPropertyDescriptor(object);
            break;
        }

        return itemPropertyDescriptors;
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
                 getString("_UI_CallMediator_endpointType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_endpointType_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_TYPE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Enable Blocking Calls feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEnableBlockingCallsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_enableBlockingCalls_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_enableBlockingCalls_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Endpoint Registrykey feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEndpointRegistrykeyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_endpointRegistrykey_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_endpointRegistrykey_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Endpoint Xpath feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEndpointXpathPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_endpointXpath_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_endpointXpath_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_XPATH,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Source Xpath feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addSourceXpathPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_sourceXPath_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_sourceXPath_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__SOURCE_XPATH,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }
    
    /**
     * This adds a property descriptor for the Source Payload feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSourcePayloadPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_sourcePayload_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_sourcePayload_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__SOURCE_PAYLOAD,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Source Property feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSourcePropertyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_sourceProperty_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_sourceProperty_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__SOURCE_PROPERTY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Target Property feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTargetPropertyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_targetProperty_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_targetProperty_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__TARGET_PROPERTY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Source Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSourceTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_sourceType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_sourceType_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__SOURCE_TYPE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Target Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTargetTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_targetType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_targetType_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__TARGET_TYPE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Content Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addContentTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_contentType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_contentType_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__CONTENT_TYPE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Init Axis2 Client Options feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addInitAxis2ClientOptionsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallMediator_initAxis2ClientOptions_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallMediator_initAxis2ClientOptions_feature", "_UI_CallMediator_type"),
                 EsbPackage.Literals.CALL_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
            childrenFeatures.add(EsbPackage.Literals.CALL_MEDIATOR__INPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.CALL_MEDIATOR__OUTPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.CALL_MEDIATOR__MEDIATOR_FLOW);
            childrenFeatures.add(EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY);
            childrenFeatures.add(EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_XPATH);
            childrenFeatures.add(EsbPackage.Literals.CALL_MEDIATOR__SOURCE_XPATH);
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
     * This returns CallMediator.png.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/CallMediator.png"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((CallMediator)object).getDescription();
        return label == null || label.length() == 0 ?
            getString("_UI_CallMediator_type") :
            getString("_UI_CallMediator_type") + " " + label;
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

        switch (notification.getFeatureID(CallMediator.class)) {
            case EsbPackage.CALL_MEDIATOR__ENDPOINT_TYPE:
            case EsbPackage.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS:
            case EsbPackage.CALL_MEDIATOR__SOURCE_PAYLOAD:
            case EsbPackage.CALL_MEDIATOR__SOURCE_PROPERTY:
            case EsbPackage.CALL_MEDIATOR__TARGET_PROPERTY:
            case EsbPackage.CALL_MEDIATOR__SOURCE_TYPE:
            case EsbPackage.CALL_MEDIATOR__TARGET_TYPE:
            case EsbPackage.CALL_MEDIATOR__CONTENT_TYPE:
            case EsbPackage.CALL_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR:
            case EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR:
            case EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR:
            case EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW:
            case EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY:
            case EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH:
            case EsbPackage.CALL_MEDIATOR__SOURCE_XPATH:
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
                (EsbPackage.Literals.CALL_MEDIATOR__INPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createCallMediatorInputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.CALL_MEDIATOR__OUTPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createCallMediatorOutputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createCallMediatorEndpointOutputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.CALL_MEDIATOR__MEDIATOR_FLOW,
                 EsbFactory.eINSTANCE.createMediatorFlow()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY,
                 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_XPATH,
                 EsbFactory.eINSTANCE.createNamespacedProperty()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.CALL_MEDIATOR__SOURCE_XPATH,
                 EsbFactory.eINSTANCE.createNamespacedProperty()));
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
            childFeature == EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_XPATH ||
            childFeature == EsbPackage.Literals.CALL_MEDIATOR__SOURCE_XPATH;

        if (qualify) {
            return getString
                ("_UI_CreateChild_text2",
                 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

}
