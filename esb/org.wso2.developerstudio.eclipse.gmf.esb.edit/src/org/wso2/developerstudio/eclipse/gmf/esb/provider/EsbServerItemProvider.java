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
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.EsbServer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EsbServerItemProvider
	extends EsbNodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbServerItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_EsbServer_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EsbServer_type_feature", "_UI_EsbServer_type"),
				 EsbPackage.Literals.ESB_SERVER__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(EsbPackage.Literals.ESB_SERVER__CHILDREN);
			childrenFeatures.add(EsbPackage.Literals.ESB_SERVER__MESSAGE_MEDIATOR);
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
	 * This returns EsbServer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EsbServer"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		ArtifactType labelValue = ((EsbServer)object).getType();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_EsbServer_type") :
			getString("_UI_EsbServer_type") + " " + label;
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

		switch (notification.getFeatureID(EsbServer.class)) {
			case EsbPackage.ESB_SERVER__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ESB_SERVER__CHILDREN:
			case EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR:
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
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCallMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createProxyService()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createMessageMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createDefaultEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createAddressEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createTemplateEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createHTTPEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createDropMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createFilterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createMergeNode()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createLogMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createPublishEventMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createBAMMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createBeanMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createEJBMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createPropertyMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createEnrichMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createXSLTMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createSwitchMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createEventMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createEntitlementMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createEnqueueMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createClassMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createSpringMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createScriptMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createFaultMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createAggregateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createRouterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCloneMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createForEachMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createIterateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCacheMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createXQueryMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCalloutMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createRMSequenceMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createTransactionMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createOAuthMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createAutoscaleInMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createAutoscaleOutMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createHeaderMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createThrottleMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCommandMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createDBLookupMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createDBReportMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createRuleMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCallTemplateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createLoopBackMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createRespondMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createSmooksMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createStoreMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createBuilderMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createPayloadFactoryMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createConditionalRouterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createSendMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createParentEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createFailoverEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createWSDLEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createLoadBalanceEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createLocalEntry()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createSequences()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createURLRewriteMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createValidateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createEndpointDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createNamedEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createTemplate()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createTask()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createSynapseAPI()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createAPIResourceEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createComplexEndpoints()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createAddressingEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createRecipientListEndPoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createMessageStore()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createMessageProcessor()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCloudConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCloudConnectorOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createDataMapperMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createFastXSLTMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createInboundEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createInboundEndpointContainer()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__CHILDREN,
				 EsbFactory.eINSTANCE.createCommentMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SERVER__MESSAGE_MEDIATOR,
				 EsbFactory.eINSTANCE.createMessageMediator()));
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
			childFeature == EsbPackage.Literals.ESB_SERVER__CHILDREN ||
			childFeature == EsbPackage.Literals.ESB_SERVER__MESSAGE_MEDIATOR;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
