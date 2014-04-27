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
import org.wso2.developerstudio.eclipse.ds.Query;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.ds.Query} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class QueryItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
                                                          IStructuredItemContentProvider,
                                                          ITreeItemContentProvider,
                                                          IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIdPropertyDescriptor(object);
			addUseConfigPropertyDescriptor(object);
			addInputEventTriggerPropertyDescriptor(object);
			addOutputEventTriggerPropertyDescriptor(object);
			addReturnGeneratedKeysPropertyDescriptor(object);
			addKeyColumnsPropertyDescriptor(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Query_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Query_id_feature", "_UI_Query_type"),
				 DsPackage.Literals.QUERY__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Input Event Trigger feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputEventTriggerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Query_inputEventTrigger_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Query_inputEventTrigger_feature", "_UI_Query_type"),
				 DsPackage.Literals.QUERY__INPUT_EVENT_TRIGGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Event Trigger feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputEventTriggerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Query_outputEventTrigger_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Query_outputEventTrigger_feature", "_UI_Query_type"),
				 DsPackage.Literals.QUERY__OUTPUT_EVENT_TRIGGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Return Generated Keys feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReturnGeneratedKeysPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Query_returnGeneratedKeys_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Query_returnGeneratedKeys_feature", "_UI_Query_type"),
				 DsPackage.Literals.QUERY__RETURN_GENERATED_KEYS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Config feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseConfigPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Query_useConfig_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Query_useConfig_feature", "_UI_Query_type"),
				 DsPackage.Literals.QUERY__USE_CONFIG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Key Columns feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKeyColumnsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Query_keyColumns_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Query_keyColumns_feature", "_UI_Query_type"),
				 DsPackage.Literals.QUERY__KEY_COLUMNS,
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
			// childrenFeatures.add(DsPackage.Literals.QUERY__MIXED);
			childrenFeatures.add(DsPackage.Literals.QUERY__SQL);
			childrenFeatures.add(DsPackage.Literals.QUERY__SPARQL);
			childrenFeatures.add(DsPackage.Literals.QUERY__EXPRESSION);
			childrenFeatures.add(DsPackage.Literals.QUERY__PROPERTIES);
			childrenFeatures.add(DsPackage.Literals.QUERY__RESULT);
			childrenFeatures.add(DsPackage.Literals.QUERY__EXCEL);
			childrenFeatures.add(DsPackage.Literals.QUERY__GSPREAD);
			childrenFeatures.add(DsPackage.Literals.QUERY__PARAM);
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
	 * This returns Query.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("wso2/query"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public String getText(Object object) {
		String label = ((Query) object).getId();
		String type = " (" + getString("_UI_Query_type") + ")";
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

		switch (notification.getFeatureID(Query.class)) {
			case DsPackage.QUERY__ID:
			case DsPackage.QUERY__INPUT_EVENT_TRIGGER:
			case DsPackage.QUERY__OUTPUT_EVENT_TRIGGER:
			case DsPackage.QUERY__RETURN_GENERATED_KEYS:
			case DsPackage.QUERY__USE_CONFIG:
			case DsPackage.QUERY__KEY_COLUMNS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DsPackage.QUERY__MIXED:
			case DsPackage.QUERY__EXPRESSION:
			case DsPackage.QUERY__SQL:
			case DsPackage.QUERY__SPARQL:
			case DsPackage.QUERY__PROPERTIES:
			case DsPackage.QUERY__RESULT:
			case DsPackage.QUERY__EXCEL:
			case DsPackage.QUERY__GSPREAD:
			case DsPackage.QUERY__PARAM:
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
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY__SQL,
					 DsFactory.eINSTANCE.createSql())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY__SPARQL,
					 DsFactory.eINSTANCE.createSparql())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY__PROPERTIES,
					 DsFactory.eINSTANCE.createQueryPropertyList())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY__RESULT,
					 DsFactory.eINSTANCE.createResultMapping())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY__EXCEL,
					 DsFactory.eINSTANCE.createExcelQuery())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY__GSPREAD,
					 DsFactory.eINSTANCE.createGSpreadQuery())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.QUERY__PARAM,
					 DsFactory.eINSTANCE.createQueryParameter())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__EXPRESSION,
				 DsFactory.eINSTANCE.createQueryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__SQL,
				 DsFactory.eINSTANCE.createSql()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__SPARQL,
				 DsFactory.eINSTANCE.createSparql()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__PROPERTIES,
				 DsFactory.eINSTANCE.createQueryPropertyList()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__RESULT,
				 DsFactory.eINSTANCE.createResultMapping()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__EXCEL,
				 DsFactory.eINSTANCE.createExcelQuery()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__GSPREAD,
				 DsFactory.eINSTANCE.createGSpreadQuery()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.QUERY__PARAM,
				 DsFactory.eINSTANCE.createQueryParameter()));
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
			childFeature == DsPackage.Literals.QUERY__SQL ||
			childFeature == DsPackage.Literals.QUERY__SPARQL ||
			childFeature == DsPackage.Literals.QUERY__PROPERTIES ||
			childFeature == DsPackage.Literals.QUERY__RESULT ||
			childFeature == DsPackage.Literals.QUERY__EXCEL ||
			childFeature == DsPackage.Literals.QUERY__GSPREAD ||
			childFeature == DsPackage.Literals.QUERY__PARAM;

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
