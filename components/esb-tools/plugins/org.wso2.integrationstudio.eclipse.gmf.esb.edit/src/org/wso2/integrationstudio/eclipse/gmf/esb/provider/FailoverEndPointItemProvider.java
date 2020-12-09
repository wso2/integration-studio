/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.provider;

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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint;

/**
 * This is the item provider adapter for a {@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FailoverEndPointItemProvider extends ParentEndPointItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FailoverEndPointItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * 
     * @param object FailoverEndpoint instance
     * @generated NOT
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors != null) {
            itemPropertyDescriptors.clear();
        }

        super.getPropertyDescriptors(object);
        addPropertiesPropertyDescriptor(object);
        addBuildMessagePropertyDescriptor(object);

        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Build Message feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addBuildMessagePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_FailoverEndPoint_buildMessage_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_FailoverEndPoint_buildMessage_feature",
                                "_UI_FailoverEndPoint_type"),
                        EsbPackage.Literals.FAILOVER_END_POINT__BUILD_MESSAGE, true, false, false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, "Basic", null));
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
            childrenFeatures.add(EsbPackage.Literals.FAILOVER_END_POINT__INPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.FAILOVER_END_POINT__OUTPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.FAILOVER_END_POINT__MEDIATOR_FLOW);
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
     * This returns FailoverEndPoint.png.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/FailoverEndPoint.png"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((FailoverEndPoint)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_FailoverEndPoint_type") :
            getString("_UI_FailoverEndPoint_type") + " " + label;
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

        switch (notification.getFeatureID(FailoverEndPoint.class)) {
            case EsbPackage.FAILOVER_END_POINT__BUILD_MESSAGE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR:
            case EsbPackage.FAILOVER_END_POINT__OUTPUT_CONNECTOR:
            case EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR:
            case EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW:
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
                (EsbPackage.Literals.FAILOVER_END_POINT__INPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createFailoverEndPointInputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.FAILOVER_END_POINT__OUTPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createFailoverEndPointOutputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createFailoverEndPointWestOutputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.FAILOVER_END_POINT__MEDIATOR_FLOW,
                 EsbFactory.eINSTANCE.createMediatorFlow()));
    }

}
