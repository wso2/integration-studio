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
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptType;
import org.wso2.developerstudio.eclipse.gmf.esb.scriptKeyTypeEnum;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptMediatorItemProvider(AdapterFactory adapterFactory) {
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
		ScriptMediator script = (ScriptMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);
		addScriptLanguagePropertyDescriptor(object);
		addScriptTypePropertyDescriptor(object);
		if (script.getScriptType().equals(ScriptType.REGISTRY_REFERENCE)) {
			addKeyTypePropertyDescriptor(object);
			if (script.getKeyType().equals(scriptKeyTypeEnum.DYNAMIC_KEY)) {
				addScriptDynamicKeyPropertyDescriptor(object);
			} else {
				addScriptStaticKeyPropertyDescriptor(object);
			}
			addMediateFunctionPropertyDescriptor(object);
			addScriptKeysPropertyDescriptor(object);
		} else {
			addScriptBodyPropertyDescriptor(object);
		}
		addDescriptionPropertyDescriptor(object);
		
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Script Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScriptTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScriptMediator_scriptType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScriptMediator_scriptType_feature", "_UI_ScriptMediator_type"),
				 EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Script Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScriptLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScriptMediator_scriptLanguage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScriptMediator_scriptLanguage_feature", "_UI_ScriptMediator_type"),
				 EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mediate Function feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMediateFunctionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScriptMediator_mediateFunction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScriptMediator_mediateFunction_feature", "_UI_ScriptMediator_type"),
				 EsbPackage.Literals.SCRIPT_MEDIATOR__MEDIATE_FUNCTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Script Dynamic Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScriptDynamicKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScriptMediator_scriptDynamicKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScriptMediator_scriptDynamicKey_feature", "_UI_ScriptMediator_type"),
				 EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Script Body feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addScriptBodyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScriptMediator_scriptBody_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScriptMediator_scriptBody_feature", "_UI_ScriptMediator_type"),
				 EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_BODY,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	
	/**
	 * This adds a property descriptor for the Key Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKeyTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScriptMediator_keyType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScriptMediator_keyType_feature", "_UI_ScriptMediator_type"),
				 EsbPackage.Literals.SCRIPT_MEDIATOR__KEY_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}


	/**
	 * This adds a property descriptor for the Script Static Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScriptStaticKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScriptMediator_scriptStaticKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScriptMediator_scriptStaticKey_feature", "_UI_ScriptMediator_type"),
				 EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Script Keys feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScriptKeysPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScriptMediator_scriptKeys_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScriptMediator_scriptKeys_feature", "_UI_ScriptMediator_type"),
				 EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_KEYS,
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
			childrenFeatures.add(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY);
			childrenFeatures.add(EsbPackage.Literals.SCRIPT_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY);
			childrenFeatures.add(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_KEYS);
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
	 * This returns ScriptMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ScriptMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((ScriptMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_ScriptMediator_type") :
			getString("_UI_ScriptMediator_type") + " " + label;
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

		switch (notification.getFeatureID(ScriptMediator.class)) {
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_TYPE:
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE:
			case EsbPackage.SCRIPT_MEDIATOR__MEDIATE_FUNCTION:
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_BODY:
			case EsbPackage.SCRIPT_MEDIATOR__KEY_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY:
			case EsbPackage.SCRIPT_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY:
			case EsbPackage.SCRIPT_MEDIATOR__SCRIPT_KEYS:
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
				(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SCRIPT_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createScriptMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SCRIPT_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createScriptMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_KEYS,
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
			childFeature == EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY ||
			childFeature == EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_KEYS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
