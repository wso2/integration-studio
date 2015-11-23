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
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;


/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.ds.DataService} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataServiceItemProvider extends ItemProviderAdapter implements
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
	public DataServiceItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addServiceGroupPropertyDescriptor(object);
			addServiceNamespacePropertyDescriptor(object);
			addTransportsPropertyDescriptor(object);
			addBaseURIPropertyDescriptor(object);
			addEnableBatchRequestsPropertyDescriptor(object);
			addEnableBoxcarringPropertyDescriptor(object);
			addEnableDTPPropertyDescriptor(object);
			addDisableStreamingPropertyDescriptor(object);
			addServiceStatusPropertyDescriptor(object);
			addEnableSecPropertyDescriptor(object);
			//addParameterAllowRolesPropertyDescriptor(object);
			addPolicyPropertyDescriptor(object);
		    
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBaseURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_baseURI_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_baseURI_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__BASE_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}


	/**
	 * This adds a property descriptor for the Enable Batch Requests feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableBatchRequestsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_enableBatchRequests_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_enableBatchRequests_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__ENABLE_BATCH_REQUESTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Boxcarring feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableBoxcarringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_enableBoxcarring_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_enableBoxcarring_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__ENABLE_BOXCARRING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable DTP feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableDTPPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_enableDTP_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_enableDTP_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__ENABLE_DTP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_DataService_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_name_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Service Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addServiceGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_serviceGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_serviceGroup_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__SERVICE_GROUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Service Namespace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addServiceNamespacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_serviceNamespace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_serviceNamespace_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__SERVICE_NAMESPACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Service Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addServiceStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_serviceStatus_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_serviceStatus_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__SERVICE_STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Disable Streaming feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisableStreamingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_disableStreaming_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_disableStreaming_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__DISABLE_STREAMING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Sec feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableSecPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_enableSec_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_enableSec_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__ENABLE_SEC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Policy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_policy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_policy_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__POLICY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transports feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransportsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_transports_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_transports_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__TRANSPORTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	

	/**
	 * This adds a property descriptor for the Parameter Allow Roles feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addParameterAllowRolesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataService_parameterAllowRoles_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataService_parameterAllowRoles_feature", "_UI_DataService_type"),
				 DsPackage.Literals.DATA_SERVICE__FEATURE_ALLOW_ROLES,
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
			// Fixing TOOLS-1008.
			//childrenFeatures.add(DsPackage.Literals.DATA_SERVICE__DESCRIPTION);
			childrenFeatures.add(DsPackage.Literals.DATA_SERVICE__CONFIG);
			childrenFeatures.add(DsPackage.Literals.DATA_SERVICE__QUERY);
			childrenFeatures.add(DsPackage.Literals.DATA_SERVICE__EVENT_TRIGGER);
			childrenFeatures.add(DsPackage.Literals.DATA_SERVICE__OPERATION);
			childrenFeatures.add(DsPackage.Literals.DATA_SERVICE__RESOURCE);
			//childrenFeatures.add(DsPackage.Literals.DATA_SERVICE__POLICY);
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
	 * This returns DataService.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("wso2/data"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public String getText(Object object) {
		String label = ((DataService) object).getName();
		String type = " (" + getString("_UI_DataService_type") + ")";
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

		switch (notification.getFeatureID(DataService.class)) {
			case DsPackage.DATA_SERVICE__BASE_URI:
			case DsPackage.DATA_SERVICE__ENABLE_BATCH_REQUESTS:
			case DsPackage.DATA_SERVICE__ENABLE_BOXCARRING:
			case DsPackage.DATA_SERVICE__ENABLE_DTP:
			case DsPackage.DATA_SERVICE__NAME:
			case DsPackage.DATA_SERVICE__SERVICE_GROUP:
			case DsPackage.DATA_SERVICE__SERVICE_NAMESPACE:
			case DsPackage.DATA_SERVICE__SERVICE_STATUS:
			case DsPackage.DATA_SERVICE__DISABLE_STREAMING:
			case DsPackage.DATA_SERVICE__ENABLE_SEC:
			case DsPackage.DATA_SERVICE__TRANSPORTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DsPackage.DATA_SERVICE__MIXED:
			case DsPackage.DATA_SERVICE__DESCRIPTION:
			case DsPackage.DATA_SERVICE__CONFIG:
			case DsPackage.DATA_SERVICE__QUERY:
			case DsPackage.DATA_SERVICE__EVENT_TRIGGER:
			case DsPackage.DATA_SERVICE__OPERATION:
			case DsPackage.DATA_SERVICE__RESOURCE:
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
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.DATA_SERVICE__DESCRIPTION,
					 DsFactory.eINSTANCE.createDescription())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.DATA_SERVICE__CONFIG,
					 DsFactory.eINSTANCE.createDataSourceConfiguration())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.DATA_SERVICE__QUERY,
					 DsFactory.eINSTANCE.createQuery())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.DATA_SERVICE__EVENT_TRIGGER,
					 DsFactory.eINSTANCE.createEventTrigger())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.DATA_SERVICE__OPERATION,
					 DsFactory.eINSTANCE.createOperation())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.DATA_SERVICE__RESOURCE,
					 DsFactory.eINSTANCE.createResource())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.DATA_SERVICE__POLICY,
					 DsFactory.eINSTANCE.createRegistryKeyProperty())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.DATA_SERVICE__FEATURE_ALLOW_ROLES,
					 DsFactory.eINSTANCE.createDataServiceParameter())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__DESCRIPTION,
				 DsFactory.eINSTANCE.createDescription()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__CONFIG,
				 DsFactory.eINSTANCE.createDataSourceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__QUERY,
				 DsFactory.eINSTANCE.createQuery()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__EVENT_TRIGGER,
				 DsFactory.eINSTANCE.createEventTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__OPERATION,
				 DsFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.DATA_SERVICE__RESOURCE,
				 DsFactory.eINSTANCE.createResource()));
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
			childFeature == DsPackage.Literals.DATA_SERVICE__DESCRIPTION ||
			childFeature == DsPackage.Literals.DATA_SERVICE__CONFIG ||
			childFeature == DsPackage.Literals.DATA_SERVICE__QUERY ||
			childFeature == DsPackage.Literals.DATA_SERVICE__EVENT_TRIGGER ||
			childFeature == DsPackage.Literals.DATA_SERVICE__OPERATION ||
			childFeature == DsPackage.Literals.DATA_SERVICE__RESOURCE;

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
