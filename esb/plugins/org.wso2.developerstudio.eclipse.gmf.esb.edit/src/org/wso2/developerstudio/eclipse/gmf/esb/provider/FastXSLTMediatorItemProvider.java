/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FastXSLTMediatorItemProvider extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FastXSLTMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		FastXSLTMediator fastXsltMediator = (FastXSLTMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);
			addFastXsltSchemaKeyTypePropertyDescriptor(object);
			switch (fastXsltMediator.getFastXsltSchemaKeyType()){
			case STATIC:
				addFastXsltStaticSchemaKeyTypePropertyDescriptor(object);
				break;
			case DYNAMIC:
				addFastDynamicXsltSchemaKeyTypePropertyDescriptor(object);
				break;
			}			
			addDescriptionPropertyDescriptor(object);
		
		return itemPropertyDescriptors;
	}
	

	private void addFastDynamicXsltSchemaKeyTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
        (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
        	 getResourceLocator(),
  			 getString("_UI_FastXSLTMediator_fastXsltDynamicSchemaKey_feature"),
  			 getString("_UI_PropertyDescriptor_description", "_UI_FastXSLTMediator_fastXsltDynamicSchemaKey_feature", "_UI_FastXSLTMediator_type"),
  			 EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY,
             true,
             false,
             true,
             null,
             "Basic",
             null));
	}

	private void addFastXsltStaticSchemaKeyTypePropertyDescriptor(Object object) {
		 itemPropertyDescriptors.add
         (createItemPropertyDescriptor
             (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
    		  getResourceLocator(),
			  getString("_UI_FastXSLTMediator_fastXsltStaticSchemaKey_feature"),
			  getString("_UI_PropertyDescriptor_description", "_UI_FastXSLTMediator_fastXsltStaticSchemaKey_feature", "_UI_FastXSLTMediator_type"),
			  EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY,
              true,
              false,
              true,
              null,
              "Basic",
              null));
	}
	
	/**
	 * This adds a property descriptor for the Fast Xslt Schema Key Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFastXsltSchemaKeyTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FastXSLTMediator_fastXsltSchemaKeyType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FastXSLTMediator_fastXsltSchemaKeyType_feature", "_UI_FastXSLTMediator_type"),
				 EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}	

	/**
	 * This adds a property descriptor for the Fast Xslt Static Schema Key feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addFastXsltStaticSchemaKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FastXSLTMediator_fastXsltStaticSchemaKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FastXSLTMediator_fastXsltStaticSchemaKey_feature", "_UI_FastXSLTMediator_type"),
				 EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Fast Xslt Dynamic Schema Key feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addFastXsltDynamicSchemaKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FastXSLTMediator_fastXsltDynamicSchemaKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FastXSLTMediator_fastXsltDynamicSchemaKey_feature", "_UI_FastXSLTMediator_type"),
				 EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY,
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
			childrenFeatures.add(EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY);
			childrenFeatures.add(EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY);
			childrenFeatures.add(EsbPackage.Literals.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR);
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
	 * This returns FastXSLTMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FastXSLTMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FastXSLTMediator)object).getDescription();
		return label == null || label.length() == 0 ?
			getString("_UI_FastXSLTMediator_type") :
			getString("_UI_FastXSLTMediator_type") + " " + label;
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

		switch (notification.getFeatureID(FastXSLTMediator.class)) {
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY:
			case EsbPackage.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY:
			case EsbPackage.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR:
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
				(EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAST_XSLT_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createFastXSLTMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createFastXSLTMediatorOutputConnector()));
	}
	
	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY ||
			childFeature == EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY ;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
			                                      getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}


}
