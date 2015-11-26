/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.ResultMapping;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.ds.ResultMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultMappingItemProvider extends ItemProviderAdapter implements
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
	public ResultMappingItemProvider(AdapterFactory adapterFactory) {
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

            addDefaultNamespacePropertyDescriptor(object);
            addElementNamePropertyDescriptor(object);
            addRowNamePropertyDescriptor(object);
            addUseColumnNumbersPropertyDescriptor(object);
            addEscapeNonPrintableCharPropertyDescriptor(object);
            addXsltPathPropertyDescriptor(object);
            addOutputTypePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

	/**
     * This adds a property descriptor for the Default Namespace feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addDefaultNamespacePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ResultMapping_defaultNamespace_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ResultMapping_defaultNamespace_feature", "_UI_ResultMapping_type"),
                 DsPackage.Literals.RESULT_MAPPING__DEFAULT_NAMESPACE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

	/**
     * This adds a property descriptor for the Element Name feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addElementNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ResultMapping_elementName_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ResultMapping_elementName_feature", "_UI_ResultMapping_type"),
                 DsPackage.Literals.RESULT_MAPPING__ELEMENT_NAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

	/**
     * This adds a property descriptor for the Row Name feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addRowNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ResultMapping_rowName_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ResultMapping_rowName_feature", "_UI_ResultMapping_type"),
                 DsPackage.Literals.RESULT_MAPPING__ROW_NAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

	/**
     * This adds a property descriptor for the Use Column Numbers feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addUseColumnNumbersPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ResultMapping_useColumnNumbers_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ResultMapping_useColumnNumbers_feature", "_UI_ResultMapping_type"),
                 DsPackage.Literals.RESULT_MAPPING__USE_COLUMN_NUMBERS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

	/**
     * This adds a property descriptor for the Escape Non Printable Char feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addEscapeNonPrintableCharPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ResultMapping_escapeNonPrintableChar_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ResultMapping_escapeNonPrintableChar_feature", "_UI_ResultMapping_type"),
                 DsPackage.Literals.RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

	/**
     * This adds a property descriptor for the Xslt Path feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addXsltPathPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ResultMapping_xsltPath_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ResultMapping_xsltPath_feature", "_UI_ResultMapping_type"),
                 DsPackage.Literals.RESULT_MAPPING__XSLT_PATH,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

	/**
     * This adds a property descriptor for the Output Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOutputTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ResultMapping_outputType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ResultMapping_outputType_feature", "_UI_ResultMapping_type"),
                 DsPackage.Literals.RESULT_MAPPING__OUTPUT_TYPE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			// childrenFeatures.add(DsPackage.Literals.RESULT_MAPPING__MIXED);
			childrenFeatures.add(DsPackage.Literals.RESULT_MAPPING__ELEMENT);
			childrenFeatures.add(DsPackage.Literals.RESULT_MAPPING__ATTRIBUTE);
			childrenFeatures.add(DsPackage.Literals.RESULT_MAPPING__CALL_QUERY);
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
	 * This returns ResultMapping.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("wso2/result"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public String getText(Object object) {
		String label = ((ResultMapping) object).getElementName();
		String type = " (" + getString("_UI_ResultMapping_type") + ")";
		return label != null ? label.toString() + type : type;

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

        switch (notification.getFeatureID(ResultMapping.class)) {
            case DsPackage.RESULT_MAPPING__DEFAULT_NAMESPACE:
            case DsPackage.RESULT_MAPPING__ELEMENT_NAME:
            case DsPackage.RESULT_MAPPING__ROW_NAME:
            case DsPackage.RESULT_MAPPING__USE_COLUMN_NUMBERS:
            case DsPackage.RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR:
            case DsPackage.RESULT_MAPPING__XSLT_PATH:
            case DsPackage.RESULT_MAPPING__OUTPUT_TYPE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case DsPackage.RESULT_MAPPING__MIXED:
            case DsPackage.RESULT_MAPPING__ELEMENT:
            case DsPackage.RESULT_MAPPING__ATTRIBUTE:
            case DsPackage.RESULT_MAPPING__CALL_QUERY:
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
                (DsPackage.Literals.RESULT_MAPPING__MIXED,
                 FeatureMapUtil.createEntry
                    (XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
                     "")));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__MIXED,
                 FeatureMapUtil.createEntry
                    (XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
                     "")));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__MIXED,
                 FeatureMapUtil.createEntry
                    (XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
                     XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__MIXED,
                 FeatureMapUtil.createEntry
                    (XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA,
                     "")));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__MIXED,
                 FeatureMapUtil.createEntry
                    (DsPackage.Literals.RESULT_MAPPING__ELEMENT,
                     DsFactory.eINSTANCE.createElementMapping())));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__MIXED,
                 FeatureMapUtil.createEntry
                    (DsPackage.Literals.RESULT_MAPPING__ATTRIBUTE,
                     DsFactory.eINSTANCE.createAttributeMapping())));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__MIXED,
                 FeatureMapUtil.createEntry
                    (DsPackage.Literals.RESULT_MAPPING__CALL_QUERY,
                     DsFactory.eINSTANCE.createCallQuery())));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__ELEMENT,
                 DsFactory.eINSTANCE.createElementMapping()));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__ATTRIBUTE,
                 DsFactory.eINSTANCE.createAttributeMapping()));

        newChildDescriptors.add
            (createChildParameter
                (DsPackage.Literals.RESULT_MAPPING__CALL_QUERY,
                 DsFactory.eINSTANCE.createCallQuery()));
    }

	/**
     * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child,
	                                 Collection<?> selection) {
        Object childFeature = feature;
        Object childObject = child;

        if (childFeature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)childFeature)) {
            FeatureMap.Entry entry = (FeatureMap.Entry)childObject;
            childFeature = entry.getEStructuralFeature();
            childObject = entry.getValue();
        }

        boolean qualify =
            childFeature == DsPackage.Literals.RESULT_MAPPING__ELEMENT ||
            childFeature == DsPackage.Literals.RESULT_MAPPING__ATTRIBUTE ||
            childFeature == DsPackage.Literals.RESULT_MAPPING__CALL_QUERY;

        if (qualify) {
            return getString
                ("_UI_CreateChild_text2",
                 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

	/**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */

	@Override
	public ResourceLocator getResourceLocator() {
        return DsEditPlugin.INSTANCE;
    }

}
