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
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class XQueryMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
	XQueryMediator xqueryMediator=(XQueryMediator)object;
		
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
			super.getPropertyDescriptors(object);

				//addQueryKeyPropertyDescriptor(object);
				//addTargetXPathPropertyDescriptor(object);				

				addScriptKeyTypePropertyDescriptor(object);
				switch(xqueryMediator.getScriptKeyType()){
				case STATIC:
					addStaticScriptKeyPropertyDescriptor(object);
					break;
				case DYNAMIC:
					addDynamicScriptKeyPropertyDescriptor(object);
					break;
				}
				addTargetXPathPropertyDescriptor(object);
				addVariablesPropertyDescriptor(object);
				addDescriptionPropertyDescriptor(object);
			
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Variables feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVariablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_XQueryMediator_variables_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_XQueryMediator_variables_feature", "_UI_XQueryMediator_type"),
				 EsbPackage.Literals.XQUERY_MEDIATOR__VARIABLES,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target XPath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetXPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_XQueryMediator_targetXPath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_XQueryMediator_targetXPath_feature", "_UI_XQueryMediator_type"),
				 EsbPackage.Literals.XQUERY_MEDIATOR__TARGET_XPATH,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Script Key Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScriptKeyTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_XQueryMediator_scriptKeyType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_XQueryMediator_scriptKeyType_feature", "_UI_XQueryMediator_type"),
				 EsbPackage.Literals.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Static Script Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStaticScriptKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_XQueryMediator_staticScriptKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_XQueryMediator_staticScriptKey_feature", "_UI_XQueryMediator_type"),
				 EsbPackage.Literals.XQUERY_MEDIATOR__STATIC_SCRIPT_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dynamic Script Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDynamicScriptKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_XQueryMediator_dynamicScriptKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_XQueryMediator_dynamicScriptKey_feature", "_UI_XQueryMediator_type"),
				 EsbPackage.Literals.XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}
	
	protected void addQueryKeyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_XQueryMediator_queryKey_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_XQueryMediator_queryKey_feature", "_UI_XQueryMediator_type"),
                 EsbPackage.Literals.XQUERY_MEDIATOR__QUERY_KEY,
                 true,
                 false,
                 true,
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
			childrenFeatures.add(EsbPackage.Literals.XQUERY_MEDIATOR__VARIABLES);
			childrenFeatures.add(EsbPackage.Literals.XQUERY_MEDIATOR__QUERY_KEY);
			childrenFeatures.add(EsbPackage.Literals.XQUERY_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.XQUERY_MEDIATOR__OUTPUT_CONNECTOR);
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
	 * This returns XQueryMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/XQueryMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((XQueryMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_XQueryMediator_type") :
			getString("_UI_XQueryMediator_type") + " " + label;
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

		switch (notification.getFeatureID(XQueryMediator.class)) {
			case EsbPackage.XQUERY_MEDIATOR__SCRIPT_KEY_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.XQUERY_MEDIATOR__VARIABLES:
			case EsbPackage.XQUERY_MEDIATOR__QUERY_KEY:
			case EsbPackage.XQUERY_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.XQUERY_MEDIATOR__OUTPUT_CONNECTOR:
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
				(EsbPackage.Literals.XQUERY_MEDIATOR__VARIABLES,
				 EsbFactory.eINSTANCE.createXQueryVariable()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.XQUERY_MEDIATOR__QUERY_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.XQUERY_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createXQueryMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.XQUERY_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createXQueryMediatorOutputConnector()));
	}

}
