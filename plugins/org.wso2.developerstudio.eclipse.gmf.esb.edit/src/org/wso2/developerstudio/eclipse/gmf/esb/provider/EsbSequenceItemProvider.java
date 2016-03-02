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
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequence;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.EsbSequence} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EsbSequenceItemProvider
	extends EsbNodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbSequenceItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
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
				 getString("_UI_EsbSequence_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EsbSequence_name_feature", "_UI_EsbSequence_type"),
				 EsbPackage.Literals.ESB_SEQUENCE__NAME,
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
			childrenFeatures.add(EsbPackage.Literals.ESB_SEQUENCE__INPUT);
			childrenFeatures.add(EsbPackage.Literals.ESB_SEQUENCE__OUTPUT);
			childrenFeatures.add(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS);
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
	 * This returns EsbSequence.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EsbSequence"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((EsbSequence)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_EsbSequence_type") :
			getString("_UI_EsbSequence_type") + " " + label;
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

		switch (notification.getFeatureID(EsbSequence.class)) {
			case EsbPackage.ESB_SEQUENCE__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ESB_SEQUENCE__INPUT:
			case EsbPackage.ESB_SEQUENCE__OUTPUT:
			case EsbPackage.ESB_SEQUENCE__CHILD_MEDIATORS:
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
				(EsbPackage.Literals.ESB_SEQUENCE__INPUT,
				 EsbFactory.eINSTANCE.createEsbSequenceInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__OUTPUT,
				 EsbFactory.eINSTANCE.createEsbSequenceOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createCallMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createDropMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createFilterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createMergeNode()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createLogMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createPublishEventMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createBAMMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createBeanMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createEJBMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createPropertyMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createEnrichMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createXSLTMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createSwitchMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createEventMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createEntitlementMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createEnqueueMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createClassMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createSpringMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createScriptMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createFaultMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createAggregateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createRouterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createCloneMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createForEachMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createIterateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createCacheMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createXQueryMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createCalloutMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createRMSequenceMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createTransactionMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createOAuthMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createAutoscaleInMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createAutoscaleOutMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createHeaderMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createThrottleMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createCommandMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createDBLookupMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createDBReportMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createRuleMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createCallTemplateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createLoopBackMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createRespondMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createSmooksMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createStoreMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createBuilderMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createPayloadFactoryMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createConditionalRouterMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createSendMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createURLRewriteMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createValidateMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createCloudConnectorOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createDataMapperMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createFastXSLTMediator()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ESB_SEQUENCE__CHILD_MEDIATORS,
				 EsbFactory.eINSTANCE.createCommentMediator()));
	}

}
