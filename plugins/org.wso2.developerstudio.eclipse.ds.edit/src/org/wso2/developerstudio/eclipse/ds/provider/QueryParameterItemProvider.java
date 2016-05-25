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
import org.wso2.developerstudio.eclipse.ds.QueryParameter;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.ds.QueryParameter} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class QueryParameterItemProvider extends ItemProviderAdapter implements
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
	public QueryParameterItemProvider(AdapterFactory adapterFactory) {
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
			addNamePropertyDescriptor(object);
			addOrdinalPropertyDescriptor(object);
			addParamTypePropertyDescriptor(object);
			addSqlTypePropertyDescriptor(object);
			addStructTypePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
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
				 getString("_UI_QueryParameter_defaultValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QueryParameter_defaultValue_feature", "_UI_QueryParameter_type"),
				 DsPackage.Literals.QUERY_PARAMETER__DEFAULT_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QueryParameter_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QueryParameter_name_feature", "_UI_QueryParameter_type"),
				 DsPackage.Literals.QUERY_PARAMETER__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ordinal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrdinalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QueryParameter_ordinal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QueryParameter_ordinal_feature", "_UI_QueryParameter_type"),
				 DsPackage.Literals.QUERY_PARAMETER__ORDINAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Param Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParamTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QueryParameter_paramType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QueryParameter_paramType_feature", "_UI_QueryParameter_type"),
				 DsPackage.Literals.QUERY_PARAMETER__PARAM_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sql Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSqlTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QueryParameter_sqlType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QueryParameter_sqlType_feature", "_UI_QueryParameter_type"),
				 DsPackage.Literals.QUERY_PARAMETER__SQL_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Struct Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStructTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QueryParameter_structType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QueryParameter_structType_feature", "_UI_QueryParameter_type"),
				 DsPackage.Literals.QUERY_PARAMETER__STRUCT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QueryParameter_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QueryParameter_type_feature", "_UI_QueryParameter_type"),
				 DsPackage.Literals.QUERY_PARAMETER__TYPE,
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
			// childrenFeatures.add(DsPackage.Literals.QUERY_PARAMETER__MIXED);
			childrenFeatures.add(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_LONG_RANGE);
			childrenFeatures.add(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_DOUBLE_RANGE);
			childrenFeatures.add(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_LENGTH);
			childrenFeatures.add(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_PATTERN);
			childrenFeatures.add(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_CUSTOM);
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
	 * This returns QueryParameter.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("wso2/param"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getText(Object object) {
		String label = ((QueryParameter)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_QueryParameter_type") :
			getString("_UI_QueryParameter_type") + " " + label;
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

		switch (notification.getFeatureID(QueryParameter.class)) {
			case DsPackage.QUERY_PARAMETER__DEFAULT_VALUE:
			case DsPackage.QUERY_PARAMETER__NAME:
			case DsPackage.QUERY_PARAMETER__ORDINAL:
			case DsPackage.QUERY_PARAMETER__PARAM_TYPE:
			case DsPackage.QUERY_PARAMETER__SQL_TYPE:
			case DsPackage.QUERY_PARAMETER__STRUCT_TYPE:
			case DsPackage.QUERY_PARAMETER__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DsPackage.QUERY_PARAMETER__MIXED:
			case DsPackage.QUERY_PARAMETER__VALIDATE_LONG_RANGE:
			case DsPackage.QUERY_PARAMETER__VALIDATE_DOUBLE_RANGE:
			case DsPackage.QUERY_PARAMETER__VALIDATE_LENGTH:
			case DsPackage.QUERY_PARAMETER__VALIDATE_PATTERN:
			case DsPackage.QUERY_PARAMETER__VALIDATE_CUSTOM:
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
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_LONG_RANGE,
					 DsFactory.eINSTANCE.createLongRangeValidator())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_DOUBLE_RANGE,
					 DsFactory.eINSTANCE.createDoubleRangeValidator())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_LENGTH,
					 DsFactory.eINSTANCE.createLengthValidator())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_PATTERN,
					 DsFactory.eINSTANCE.createPatternValidator())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_CUSTOM,
					 DsFactory.eINSTANCE.createCustomValidator())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_LONG_RANGE,
				 DsFactory.eINSTANCE.createLongRangeValidator()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_DOUBLE_RANGE,
				 DsFactory.eINSTANCE.createDoubleRangeValidator()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_LENGTH,
				 DsFactory.eINSTANCE.createLengthValidator()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_PATTERN,
				 DsFactory.eINSTANCE.createPatternValidator()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY_PARAMETER__VALIDATE_CUSTOM,
				 DsFactory.eINSTANCE.createCustomValidator()));
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
			childFeature == DsPackage.Literals.QUERY_PARAMETER__VALIDATE_LONG_RANGE ||
			childFeature == DsPackage.Literals.QUERY_PARAMETER__VALIDATE_DOUBLE_RANGE ||
			childFeature == DsPackage.Literals.QUERY_PARAMETER__VALIDATE_LENGTH ||
			childFeature == DsPackage.Literals.QUERY_PARAMETER__VALIDATE_PATTERN ||
			childFeature == DsPackage.Literals.QUERY_PARAMETER__VALIDATE_CUSTOM;

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
