/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.provider;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PayloadFactoryArgumentItemProvider extends EsbNodeItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PayloadFactoryArgumentItemProvider(AdapterFactory adapterFactory) {
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

            addArgumentTypePropertyDescriptor(object);
            addArgumentValuePropertyDescriptor(object);
            addArgumentExpressionPropertyDescriptor(object);
            addEvaluatorPropertyDescriptor(object);
            addLiteralPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Argument Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addArgumentTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PayloadFactoryArgument_argumentType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_PayloadFactoryArgument_argumentType_feature", "_UI_PayloadFactoryArgument_type"),
                 EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Argument Value feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addArgumentValuePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PayloadFactoryArgument_argumentValue_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_PayloadFactoryArgument_argumentValue_feature", "_UI_PayloadFactoryArgument_type"),
                 EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Argument Expression feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addArgumentExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PayloadFactoryArgument_argumentExpression_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_PayloadFactoryArgument_argumentExpression_feature", "_UI_PayloadFactoryArgument_type"),
                 EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Evaluator feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEvaluatorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PayloadFactoryArgument_evaluator_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_PayloadFactoryArgument_evaluator_feature", "_UI_PayloadFactoryArgument_type"),
                 EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__EVALUATOR,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Literal feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLiteralPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PayloadFactoryArgument_literal_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_PayloadFactoryArgument_literal_feature", "_UI_PayloadFactoryArgument_type"),
                 EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__LITERAL,
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
            childrenFeatures.add(EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION);
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
     * This returns PayloadFactoryArgument.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/PayloadFactoryArgument"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public String getText(Object object) {
        int maxLength = 40;
        int spacing = 3;
        int marginSpaceLeft = 1;
        int argTypeLength = 10;
        String emptySpace = StringUtils.rightPad("", spacing);

        String argumentType = ((PayloadFactoryArgument) object).getArgumentType().toString();
        String argumentValue = StringUtils.rightPad(((PayloadFactoryArgument) object).getArgumentValue(), maxLength);
        String argumentExpression = StringUtils
                .rightPad(((PayloadFactoryArgument) object).getArgumentExpression().getPropertyValue(), maxLength);

        String formattedString = null;
        if (((PayloadFactoryArgument) object).getArgumentValue() == null
                || ((PayloadFactoryArgument) object).getArgumentValue().isEmpty()) {
            argumentValue = StringUtils.rightPad("", maxLength);
        }
        if (((PayloadFactoryArgument) object).getArgumentExpression().getPropertyValue() == null
                || ((PayloadFactoryArgument) object).getArgumentExpression().getPropertyValue().isEmpty()) {
            argumentExpression = StringUtils.rightPad("", maxLength);
        }
        if (PayloadFactoryArgumentType.VALUE.getName().equalsIgnoreCase(argumentType)) {
            formattedString = StringUtils.rightPad("", marginSpaceLeft)
                    + StringUtils.abbreviate(StringUtils.rightPad(argumentType, argTypeLength), argTypeLength)
                    + emptySpace + StringUtils.abbreviate(argumentValue, maxLength);
        } else {
            formattedString = StringUtils.rightPad("", marginSpaceLeft)
                    + StringUtils.abbreviate(StringUtils.rightPad(argumentType, argTypeLength), argTypeLength)
                    + emptySpace + StringUtils.abbreviate(argumentExpression, maxLength);
        }
        return formattedString;
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

        switch (notification.getFeatureID(PayloadFactoryArgument.class)) {
            case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE:
            case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE:
            case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__EVALUATOR:
            case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__LITERAL:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case EsbPackage.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION:
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
                (EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION,
                 EsbFactory.eINSTANCE.createNamespacedProperty()));
    }

}
