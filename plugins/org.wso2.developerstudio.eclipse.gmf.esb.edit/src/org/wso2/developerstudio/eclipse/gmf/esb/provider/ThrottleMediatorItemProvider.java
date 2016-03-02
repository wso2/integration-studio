/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.provider;


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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ThrottleMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		ThrottleMediator mediator = (ThrottleMediator)object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		
		super.getPropertyDescriptors(object);
		
		addGroupIdPropertyDescriptor(object);
		addPolicyTypePropertyDescriptor(object);
		addOnAcceptBranchsequenceTypePropertyDescriptor(object);
		addOnRejectBranchsequenceTypePropertyDescriptor(object);
		
		if (mediator.getPolicyType().equals(ThrottlePolicyType.INLINE)) {
			//addMaxConcurrentAccessCountPropertyDescriptor(object);
			addPolicyEntriesPropertyDescriptor(object);
		} else {
			addPolicyKeyPropertyDescriptor(object);
		}
		
		if(mediator.getOnAcceptBranchsequenceType().equals(ThrottleSequenceType.REGISTRY_REFERENCE)){
			
			addOnAcceptBranchsequenceKeyPropertyDescriptor(object);
		}
		
		if(mediator.getOnRejectBranchsequenceType().equals(ThrottleSequenceType.REGISTRY_REFERENCE)){
			
			addOnRejectBranchsequenceKeyPropertyDescriptor(object);
		}
		addDescriptionPropertyDescriptor(object);
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Group Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addGroupIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottleMediator_groupId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottleMediator_groupId_feature", "_UI_ThrottleMediator_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__GROUP_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "General",
				 null));
	}
	
	
	/**
	 * This adds a property descriptor for the Policy Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPolicyTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottleMediator_policyType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottleMediator_policyType_feature", "_UI_ThrottleMediator_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Throttle Policy",
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Concurrent Access Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addMaxConcurrentAccessCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottleMediator_maxConcurrentAccessCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottleMediator_maxConcurrentAccessCount_feature", "_UI_ThrottleMediator_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}
	
	/**
	 * This adds a property descriptor for the Policy Entries feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPolicyEntriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottleMediator_policyEntries_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottleMediator_policyEntries_feature", "_UI_ThrottleMediator_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_ENTRIES,
				 true,
				 false,
				 false,
				 null,
				 "Throttle Policy",
				 null));
	}

	/**
	 * This adds a property descriptor for the On Accept Branchsequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOnAcceptBranchsequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottleMediator_OnAcceptBranchsequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottleMediator_OnAcceptBranchsequenceType_feature", "_UI_ThrottleMediator_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "On Acceptance",
				 null));
	}

	/**
	 * This adds a property descriptor for the On Accept Branchsequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOnAcceptBranchsequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottleMediator_OnAcceptBranchsequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottleMediator_OnAcceptBranchsequenceKey_feature", "_UI_ThrottleMediator_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 "On Acceptance",
				 null));
	}

	/**
	 * This adds a property descriptor for the On Reject Branchsequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOnRejectBranchsequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottleMediator_OnRejectBranchsequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottleMediator_OnRejectBranchsequenceType_feature", "_UI_ThrottleMediator_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "On Rejection",
				 null));
	}

	/**
	 * This adds a property descriptor for the On Reject Branchsequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOnRejectBranchsequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottleMediator_OnRejectBranchsequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottleMediator_OnRejectBranchsequenceKey_feature", "_UI_ThrottleMediator_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 "On Rejection",
				 null));
	}

	protected void addPolicyKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThrottlePolicyConfiguration_policyKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThrottlePolicyConfiguration_policyKey_feature", "_UI_ThrottlePolicyConfiguration_type"),
				 EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_KEY,
				 true,
				 false,
				 false,
				 null,
				 "Throttle Policy",
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
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_KEY);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_ENTRIES);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_BRANCH);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__THROTTLE_CONTAINER);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY);
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
	 * This returns ThrottleMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ThrottleMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((ThrottleMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_ThrottleMediator_type") :
			getString("_UI_ThrottleMediator_type") + " " + label;
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

		switch (notification.getFeatureID(ThrottleMediator.class)) {
			case EsbPackage.THROTTLE_MEDIATOR__GROUP_ID:
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_TYPE:
			case EsbPackage.THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT:
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE:
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY:
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_ENTRIES:
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
			case EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
			case EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER:
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY:
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY:
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
				(EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_ENTRIES,
				 EsbFactory.eINSTANCE.createThrottlePolicyEntry()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_CONFIGURATION,
				 EsbFactory.eINSTANCE.createThrottlePolicyConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH,
				 EsbFactory.eINSTANCE.createThrottleOnAcceptBranch()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_BRANCH,
				 EsbFactory.eINSTANCE.createThrottleOnRejectBranch()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createThrottleMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createThrottleMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createThrottleMediatorOnAcceptOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createThrottleMediatorOnRejectOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__THROTTLE_CONTAINER,
				 EsbFactory.eINSTANCE.createThrottleContainer()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));
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
			childFeature == EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_KEY ||
			childFeature == EsbPackage.Literals.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
