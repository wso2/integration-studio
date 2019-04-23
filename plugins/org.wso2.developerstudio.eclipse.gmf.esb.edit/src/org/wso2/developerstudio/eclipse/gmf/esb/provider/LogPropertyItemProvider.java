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
import org.apache.commons.lang.WordUtils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.LogProperty} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LogPropertyItemProvider extends AbstractNameValueExpressionPropertyItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LogPropertyItemProvider(AdapterFactory adapterFactory) {
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

        }
        return itemPropertyDescriptors;
    }

    /**
     * This returns LogProperty.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/LogProperty"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */

    @Override
    public String getText(Object object) {
        String propertyName = StringUtils.rightPad(((LogProperty) object).getPropertyName(), 40);
        String propertyValueType = ((LogProperty) object).getPropertyValueType().toString();
        String propertyValue = StringUtils.rightPad(((LogProperty) object).getPropertyValue(), 40);
        String propertyExpression = StringUtils.rightPad((
                (LogProperty) object).getPropertyExpression().toString(), 20);

        String formattedString = null;
        if (((LogProperty) object).getPropertyName() == null || ((LogProperty) object).getPropertyName().isEmpty()) {
            propertyName = StringUtils.rightPad("", 40);
        }
        if (((LogProperty) object).getPropertyValue() == null || ((LogProperty) object).getPropertyValue().isEmpty()) {
            propertyValue = StringUtils.rightPad("", 40);
        }
        if (propertyValueType.equals(PropertyValueType.LITERAL.getName())) {
            formattedString = StringUtils.abbreviate((getString("_UI_LogProperty_type") + " - "), 15)
                    + StringUtils.abbreviate(propertyName, 40) + StringUtils.rightPad("", 8)
                    + StringUtils.abbreviate(StringUtils.rightPad(propertyValueType, 15), 15)
                    + StringUtils.abbreviate(propertyValue, 40);
        } else {
            formattedString = StringUtils.abbreviate((getString("_UI_LogProperty_type") + " - "), 15)
                    + StringUtils.abbreviate(propertyName, 40) + StringUtils.rightPad("", 8)
                    + StringUtils.abbreviate(StringUtils.rightPad(propertyValueType, 15), 15)
                    + StringUtils.abbreviate(propertyExpression, 40);
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
