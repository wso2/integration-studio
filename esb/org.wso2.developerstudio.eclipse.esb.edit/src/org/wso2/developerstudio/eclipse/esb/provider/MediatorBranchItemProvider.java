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
package org.wso2.developerstudio.eclipse.esb.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.MediatorBranch;
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsFactory;

/**
 * This is the item provider adapter for a
 * {@link org.wso2.developerstudio.eclipse.esb.MediatorBranch} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MediatorBranchItemProvider extends ModelObjectItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MediatorBranchItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures != null) {
			childrenFeatures.clear();
		}
		super.getChildrenFeatures(object);

		childrenFeatures.add(EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN);

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
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 */
	
	public String getText(Object object) {
		return getString("_UI_MediatorBranch_type");
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

		switch (notification.getFeatureID(MediatorBranch.class)) {
			case EsbPackage.MEDIATOR_BRANCH__CHILDREN:
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

		MediatorBranch mediatorBranch = (MediatorBranch) object;
		switch (mediatorBranch.getCurrentEsbVersion()) {
		case ESB400:
			
			newChildDescriptors.add(createChildParameter(
			       EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
			       MediatorsFactory.eINSTANCE.createPayloadFactoryMediator()));
			
			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE
							.createCallTemplateMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE
							.createConditionalRouterMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createStoreMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createURLRewriteMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createInMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createOutMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createDropMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSendMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createLogMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createFilterMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSwitchMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createEntitlementMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createEnqueueMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createClassMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSpringMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createValidateMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createScriptMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSmooksMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createEnrichMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createFaultMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createAggregateMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createRouterMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createCloneMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createIterateMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createCacheMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createXSLTMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createXQueryMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createCalloutMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createRMSequenceMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createTransactionMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createPropertyMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createOAuthMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createAutoscaleInMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createAutoscaleOutMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createHeaderMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createThrottleMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createCommandMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createEventMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createDBLookupMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createDBReportMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createRuleMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSequenceMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createBuilderMediator()));
			break;
			
		case ESB301:
			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createInMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createOutMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createDropMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSendMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createLogMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createFilterMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSwitchMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createEntitlementMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createEnqueueMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createClassMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSpringMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createValidateMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createScriptMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSmooksMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createEnrichMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createFaultMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createAggregateMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createRouterMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createCloneMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createIterateMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createCacheMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createXSLTMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createXQueryMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createCalloutMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createRMSequenceMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createTransactionMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createPropertyMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createOAuthMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createAutoscaleInMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createAutoscaleOutMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createHeaderMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createThrottleMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createCommandMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createEventMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createDBLookupMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createDBReportMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createRuleMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createSequenceMediator()));

			newChildDescriptors.add(createChildParameter(
					EsbPackage.Literals.MEDIATOR_BRANCH__CHILDREN,
					MediatorsFactory.eINSTANCE.createBuilderMediator()));
			break;
		}
	}

}
