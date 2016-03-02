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

import org.eclipse.emf.ecore.EObject;
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

import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.Template} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplateItemProvider
	extends EsbElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateItemProvider(AdapterFactory adapterFactory) {
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
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			//addTemplateTypePropertyDescriptor(object);
			//addParametersPropertyDescriptor(object);
			
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_Template_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Template_name_feature", "_UI_Template_type"),
				 EsbPackage.Literals.TEMPLATE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Template Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemplateTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Template_templateType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Template_templateType_feature", "_UI_Template_type"),
				 EsbPackage.Literals.TEMPLATE__TEMPLATE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Template_parameters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Template_parameters_feature", "_UI_Template_type"),
				 EsbPackage.Literals.TEMPLATE__PARAMETERS,
				 true,
				 false,
				 false,
				 null,
				 null,
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
			childrenFeatures.add(EsbPackage.Literals.TEMPLATE__CHILD);
			childrenFeatures.add(EsbPackage.Literals.TEMPLATE__PARAMETERS);
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
	 * This returns Template.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Template"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Template)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Template_type") :
			getString("_UI_Template_type") + " " + label;
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

		switch (notification.getFeatureID(Template.class)) {
			case EsbPackage.TEMPLATE__NAME:
			case EsbPackage.TEMPLATE__TEMPLATE_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.TEMPLATE__CHILD:
			case EsbPackage.TEMPLATE__PARAMETERS:
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
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCallMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createProxyService()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createMessageMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createDefaultEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createAddressEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createTemplateEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createHTTPEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createDropMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createFilterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createMergeNode()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createLogMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createPublishEventMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createBAMMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createBeanMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createEJBMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createPropertyMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createEnrichMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createXSLTMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createSwitchMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createEventMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createEntitlementMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createEnqueueMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createClassMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createSpringMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createScriptMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createFaultMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createAggregateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createRouterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCloneMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createForEachMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createIterateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCacheMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createXQueryMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCalloutMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createRMSequenceMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createTransactionMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createOAuthMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createAutoscaleInMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createAutoscaleOutMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createHeaderMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createThrottleMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCommandMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createDBLookupMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createDBReportMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createRuleMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCallTemplateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createLoopBackMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createRespondMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createSmooksMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createStoreMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createBuilderMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createPayloadFactoryMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createConditionalRouterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createSendMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createParentEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createFailoverEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createWSDLEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createLoadBalanceEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createLocalEntry()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createSequences()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createURLRewriteMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createValidateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createEndpointDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createNamedEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createTemplate()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createTask()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createSynapseAPI()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createAPIResourceEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createComplexEndpoints()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createAddressingEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createRecipientListEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createMessageStore()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createMessageProcessor()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCloudConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCloudConnectorOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createDataMapperMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createFastXSLTMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createInboundEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createInboundEndpointContainer()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__CHILD,
				 EsbFactory.eINSTANCE.createCommentMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.TEMPLATE__PARAMETERS,
				 EsbFactory.eINSTANCE.createTemplateParameter()));
	}

}
