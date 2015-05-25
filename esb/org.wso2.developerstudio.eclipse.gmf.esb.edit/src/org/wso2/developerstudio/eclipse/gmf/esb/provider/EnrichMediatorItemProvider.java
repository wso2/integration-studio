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

import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EnrichMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		EnrichMediator enrichMediator = (EnrichMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);
		
		addCloneSourcePropertyDescriptor(object);
		addSourceTypePropertyDescriptor(object);
		switch (enrichMediator.getSourceType()) {
			case CUSTOM: {
				addSourceXpathPropertyDescriptor(object);
				break;
			}
			
			case PROPERTY: {
				addSourcePropertyPropertyDescriptor(object);
				break;
			}
			
			case INLINE: {
				addInlineTypePropertyDescriptor(object);
				switch (enrichMediator.getInlineType()) {
				case CONTENT: {
					addSourceXMLPropertyDescriptor(object);
					break;
				}
				case KEY: {
					addInlineRegistryKeyPropertyDescriptor(object);
					break;
				}
				}
				break;
			}
		}
		
		addTargetActionPropertyDescriptor(object);
		addTargetTypePropertyDescriptor(object);
		switch (enrichMediator.getTargetType()) {
			case CUSTOM: {
				addTargetXpathPropertyDescriptor(object);
				break;
			}
			
			case PROPERTY: {
				addTargetPropertyPropertyDescriptor(object);
				break;
			}
		}
		addDescriptionPropertyDescriptor(object);
		
		return itemPropertyDescriptors;
	}
	
	protected void addSourceXpathPropertyDescriptor(Object object){
		itemPropertyDescriptors.add
		(createItemPropertyDescriptor
			(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
			 getResourceLocator(),
			 getString("_UI_EnrichMediator_sourceXpath_feature"),
			 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_sourceXpath_feature", "_UI_EnrichMediator_type"),
			 EsbPackage.Literals.ENRICH_MEDIATOR__SOURCE_XPATH,
			 true,
			 false,
			 false,
			 ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
			 "Source",
			 null));	
	}
	
	protected void addTargetXpathPropertyDescriptor(Object object){
		itemPropertyDescriptors.add
		(createItemPropertyDescriptor
			(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
			 getResourceLocator(),
			 getString("_UI_EnrichMediator_targetXpath_feature"),
			 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_targetXpath_feature", "_UI_EnrichMediator_type"),
			 EsbPackage.Literals.ENRICH_MEDIATOR__TARGET_XPATH,
			 true,
			 false,
			 false,
			 ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
			 "Target",
			 null));	
	}

	/**
	 * This adds a property descriptor for the Clone Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addCloneSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_cloneSource_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_cloneSource_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__CLONE_SOURCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Source",
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSourceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_sourceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_sourceType_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__SOURCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Source",
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSourcePropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_sourceProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_sourceProperty_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__SOURCE_PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Source",
				 null));
	}

	/**
	 * This adds a property descriptor for the Source XML feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSourceXMLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_sourceXML_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_sourceXML_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__SOURCE_XML,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Source",
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTargetActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_targetAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_targetAction_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__TARGET_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Target",
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTargetTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_targetType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_targetType_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__TARGET_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Target",
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTargetPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_targetProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_targetProperty_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__TARGET_PROPERTY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Target",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inline Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInlineTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_inlineType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_inlineType_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__INLINE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Source",
				 null));
	}

	/**
	 * This adds a property descriptor for the Inline Registry Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInlineRegistryKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EnrichMediator_inlineRegistryKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EnrichMediator_inlineRegistryKey_feature", "_UI_EnrichMediator_type"),
				 EsbPackage.Literals.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY,
				 true,
				 false,
				 false,
				 null,
				 "Source",
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
			childrenFeatures.add(EsbPackage.Literals.ENRICH_MEDIATOR__SOURCE_XPATH);
			childrenFeatures.add(EsbPackage.Literals.ENRICH_MEDIATOR__TARGET_XPATH);
			childrenFeatures.add(EsbPackage.Literals.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY);
			childrenFeatures.add(EsbPackage.Literals.ENRICH_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.ENRICH_MEDIATOR__OUTPUT_CONNECTOR);
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
	 * This returns EnrichMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EnrichMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((EnrichMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_EnrichMediator_type") :
			getString("_UI_EnrichMediator_type") + " " + label;
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

		switch (notification.getFeatureID(EnrichMediator.class)) {
			case EsbPackage.ENRICH_MEDIATOR__CLONE_SOURCE:
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_TYPE:
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_PROPERTY:
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XML:
			case EsbPackage.ENRICH_MEDIATOR__TARGET_ACTION:
			case EsbPackage.ENRICH_MEDIATOR__TARGET_TYPE:
			case EsbPackage.ENRICH_MEDIATOR__TARGET_PROPERTY:
			case EsbPackage.ENRICH_MEDIATOR__INLINE_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH:
			case EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH:
			case EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY:
			case EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR:
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
				(EsbPackage.Literals.ENRICH_MEDIATOR__SOURCE_XPATH,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENRICH_MEDIATOR__TARGET_XPATH,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENRICH_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createEnrichMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.ENRICH_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createEnrichMediatorOutputConnector()));
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
			childFeature == EsbPackage.Literals.ENRICH_MEDIATOR__SOURCE_XPATH ||
			childFeature == EsbPackage.Literals.ENRICH_MEDIATOR__TARGET_XPATH;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
