/*
* Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.gmf.esb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.NTLMMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.integrationstudio.gmf.esb.NTLMMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NTLMMediatorItemProvider extends MediatorItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NTLMMediatorItemProvider(AdapterFactory adapterFactory) {
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

            addUsernamePropertyDescriptor(object);
            addPasswordPropertyDescriptor(object);
            addHostPropertyDescriptor(object);
            addDomainPropertyDescriptor(object);
            addNtlmVersionPropertyDescriptor(object);
            addUsernameExpressionPropertyDescriptor(object);
            addPasswordExpressionPropertyDescriptor(object);
            addHostExpressionPropertyDescriptor(object);
            addDomainExpressionPropertyDescriptor(object);
            addNtlmVersionExpressionPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Username feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUsernamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_username_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_username_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__USERNAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Password feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addPasswordPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_password_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_password_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__PASSWORD,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Host feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addHostPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_host_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_host_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__HOST,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Domain feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDomainPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_domain_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_domain_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__DOMAIN,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Ntlm Version feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNtlmVersionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_ntlmVersion_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_ntlmVersion_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__NTLM_VERSION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Username Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUsernameExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_usernameExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_usernameExpression_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__USERNAME_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Password Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addPasswordExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_passwordExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_passwordExpression_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__PASSWORD_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Host Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addHostExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_hostExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_hostExpression_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__HOST_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Domain Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDomainExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_domainExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_domainExpression_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__DOMAIN_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Ntlm Version Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNtlmVersionExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NTLMMediator_ntlmVersionExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NTLMMediator_ntlmVersionExpression_feature", "_UI_NTLMMediator_type"),
                 EsbPackage.Literals.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION,
                 true,
                 false,
                 true,
                 null,
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
            childrenFeatures.add(EsbPackage.Literals.NTLM_MEDIATOR__INPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.NTLM_MEDIATOR__OUTPUT_CONNECTOR);
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
     * This returns NTLMMediator.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/NTLMMediator.png"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((NTLMMediator)object).getUsername();
        return label == null || label.length() == 0 ?
            getString("_UI_NTLMMediator_type") :
            getString("_UI_NTLMMediator_type") + " " + label;
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

        switch (notification.getFeatureID(NTLMMediator.class)) {
            case EsbPackage.NTLM_MEDIATOR__USERNAME:
            case EsbPackage.NTLM_MEDIATOR__PASSWORD:
            case EsbPackage.NTLM_MEDIATOR__HOST:
            case EsbPackage.NTLM_MEDIATOR__DOMAIN:
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR:
            case EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR:
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
                (EsbPackage.Literals.NTLM_MEDIATOR__INPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createNTLMMediatorInputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.NTLM_MEDIATOR__OUTPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createNTLMMediatorOutputConnector()));
    }

}
