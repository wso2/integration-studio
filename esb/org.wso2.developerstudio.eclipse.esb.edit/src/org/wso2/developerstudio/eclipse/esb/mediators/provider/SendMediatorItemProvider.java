/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.EndPointReference;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;
import org.wso2.developerstudio.eclipse.esb.UnexecutableCreateChildCommand;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.SendMediator;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SendMediatorItemProvider extends MediatorItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SendMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		SendMediator sendMediator = (SendMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
	
		super.getPropertyDescriptors(object);
		switch (sendMediator.getCurrentEsbVersion()){
		
		case ESB400:
		addReceivingSequenceTypePropertyDescriptor(object);
		switch (sendMediator.getReceivingSequenceType()) {
		case DEFAULT:
			break;
		case STATIC:
			addStaticReceivingSequencePropertyDescriptor(object);
			break;
		case DYNAMIC:
			addDynamicReceivingSequencePropertyDescriptor(object);
			break;

		}
		break;
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Receiving Sequence Type feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReceivingSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SendMediator_receivingSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SendMediator_receivingSequenceType_feature", "_UI_SendMediator_type"),
				 MediatorsPackage.Literals.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Static Receiving Sequence feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStaticReceivingSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SendMediator_StaticReceivingSequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SendMediator_StaticReceivingSequence_feature", "_UI_SendMediator_type"),
				 MediatorsPackage.Literals.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dynamic Receiving Sequence feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDynamicReceivingSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SendMediator_DynamicReceivingSequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SendMediator_DynamicReceivingSequence_feature", "_UI_SendMediator_type"),
				 MediatorsPackage.Literals.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		SendMediator sendMediator = (SendMediator) object;
		if (childrenFeatures != null) {
			childrenFeatures.clear();
		}
		super.getChildrenFeatures(object);

		if (null != sendMediator.getEndPointReference()) {
			childrenFeatures
					.add(MediatorsPackage.Literals.SEND_MEDIATOR__END_POINT_REFERENCE);
		} else {
			childrenFeatures
					.add(MediatorsPackage.Literals.SEND_MEDIATOR__ANONYMOUS_END_POINT);
		}

		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SendMediator.gif. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SendMediator"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return getString("_UI_SendMediator_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SendMediator.class)) {
			case MediatorsPackage.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE:
			case MediatorsPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE:
			case MediatorsPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MediatorsPackage.SEND_MEDIATOR__ANONYMOUS_END_POINT:
			case MediatorsPackage.SEND_MEDIATOR__END_POINT_REFERENCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		EndPoint endpoint = EsbFactory.eINSTANCE.createDefaultEndPoint();
		endpoint.setAnonymous(true);
		newChildDescriptors.add(createChildParameter(
				MediatorsPackage.Literals.SEND_MEDIATOR__ANONYMOUS_END_POINT,
				endpoint));

		endpoint = EsbFactory.eINSTANCE.createAddressEndPoint();
		endpoint.setAnonymous(true);
		newChildDescriptors.add(createChildParameter(
				MediatorsPackage.Literals.SEND_MEDIATOR__ANONYMOUS_END_POINT,
				endpoint));

		endpoint = EsbFactory.eINSTANCE.createWsdlEndPoint();
		endpoint.setAnonymous(true);
		newChildDescriptors.add(createChildParameter(
				MediatorsPackage.Literals.SEND_MEDIATOR__ANONYMOUS_END_POINT,
				endpoint));

		endpoint = EsbFactory.eINSTANCE.createFailoverEndPoint();
		endpoint.setAnonymous(true);
		newChildDescriptors.add(createChildParameter(
				MediatorsPackage.Literals.SEND_MEDIATOR__ANONYMOUS_END_POINT,
				endpoint));

		endpoint = EsbFactory.eINSTANCE.createLoadBalanceEndPoint();
		endpoint.setAnonymous(true);
		newChildDescriptors.add(createChildParameter(
				MediatorsPackage.Literals.SEND_MEDIATOR__ANONYMOUS_END_POINT,
				endpoint));

		endpoint = EsbFactory.eINSTANCE.createDynamicLoadBalanceEndPoint();
		endpoint.setAnonymous(true);
		newChildDescriptors.add(createChildParameter(
				MediatorsPackage.Literals.SEND_MEDIATOR__ANONYMOUS_END_POINT,
				endpoint));

		newChildDescriptors.add(createChildParameter(
				MediatorsPackage.Literals.SEND_MEDIATOR__END_POINT_REFERENCE,
				EsbFactory.eINSTANCE.createXPathEndPointReference()));

		newChildDescriptors.add(createChildParameter(
				MediatorsPackage.Literals.SEND_MEDIATOR__END_POINT_REFERENCE,
				EsbFactory.eINSTANCE.createRegistryKeyEndPointReference()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	@Override
	public ResourceLocator getResourceLocator() {
		return EsbEditPlugin.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Command createCreateChildCommand(EditingDomain domain,
			EObject owner, EStructuralFeature feature, Object value, int index,
			Collection<?> collection) {
		SendMediator sendMediator = (SendMediator) owner;
		boolean unexecutable = (value instanceof EndPoint && (null != sendMediator
				.getEndPointReference()))
				|| (value instanceof EndPointReference && (null != sendMediator
						.getAnonymousEndPoint()));
		if (unexecutable) {
			return new UnexecutableCreateChildCommand(domain, owner, feature,
					value, index, collection, this);
		}
		return super.createCreateChildCommand(domain, owner, feature, value,
				index, collection);
	}
}
