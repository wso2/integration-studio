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
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadBalanceEndPointItemProvider
	extends ParentEndPointItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceEndPointItemProvider(AdapterFactory adapterFactory) {
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
		LoadBalanceEndPoint balanceEndPoint = (LoadBalanceEndPoint)object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);
		addInLinePropertyDescriptor(object);
		addPropertiesPropertyDescriptor(object);
		addSessionTypePropertyDescriptor(object);
		LoadBalanceSessionType sessionType = balanceEndPoint.getSessionType();
		if(!"NONE".equals(sessionType.getLiteral())){
			addSessionTimeoutPropertyDescriptor(object);
		}
		
		addAlgorithmPropertyDescriptor(object);
		addDescriptionPropertyDescriptor(object);
 		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Failover feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFailoverPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_failover_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_failover_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__FAILOVER,
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
	 * @generated
	 */
	protected void addPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_policy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_policy_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__POLICY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_member_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_member_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__MEMBER,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Session Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSessionTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_sessionType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_sessionType_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__SESSION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Algorithm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addAlgorithmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_algorithm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_algorithm_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__ALGORITHM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Session Timeout feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSessionTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LoadBalanceEndPoint_sessionTimeout_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LoadBalanceEndPoint_sessionTimeout_feature", "_UI_LoadBalanceEndPoint_type"),
				 EsbPackage.Literals.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 "Basic",
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
			childrenFeatures.add(EsbPackage.Literals.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.LOAD_BALANCE_END_POINT__MEMBER);
			childrenFeatures.add(EsbPackage.Literals.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW);
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
	 * This returns LoadBalanceEndPoint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LoadBalanceEndPoint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LoadBalanceEndPoint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LoadBalanceEndPoint_type") :
			getString("_UI_LoadBalanceEndPoint_type") + " " + label;
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

		switch (notification.getFeatureID(LoadBalanceEndPoint.class)) {
			case EsbPackage.LOAD_BALANCE_END_POINT__FAILOVER:
			case EsbPackage.LOAD_BALANCE_END_POINT__POLICY:
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR:
			case EsbPackage.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR:
			case EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR:
			case EsbPackage.LOAD_BALANCE_END_POINT__MEMBER:
			case EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW:
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
				(EsbPackage.Literals.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createLoadBalanceEndPointInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createLoadBalanceEndPointOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createLoadBalanceEndPointWestOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.LOAD_BALANCE_END_POINT__MEMBER,
				 EsbFactory.eINSTANCE.createMember()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW,
				 EsbFactory.eINSTANCE.createMediatorFlow()));
	}

}
