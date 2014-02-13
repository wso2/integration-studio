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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsFactory;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorItemProvider;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractSqlExecutorMediatorItemProvider
	extends MediatorItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSqlExecutorMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		AbstractSqlExecutorMediator sqlExecutor = (AbstractSqlExecutorMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addConnectionTypePropertyDescriptor(object);
		if (sqlExecutor.getConnectionType().equals(SqlExecutorConnectionType.DATA_SOURCE)) {
			addConnectionDsTypePropertyDescriptor(object);
			if (sqlExecutor.getConnectionDsType().equals(SqlExecutorDatasourceType.EXTERNAL)) {
				addConnectionDsInitialContextPropertyDescriptor(object);
			}
			addConnectionDsNamePropertyDescriptor(object);
		} else {
			addConnectionDbDriverPropertyDescriptor(object);
		}

		if (!sqlExecutor.getConnectionDsType().equals(SqlExecutorDatasourceType.CARBON)) {
			addConnectionURLPropertyDescriptor(object);
			addConnectionUsernamePropertyDescriptor(object);
			addConnectionPasswordPropertyDescriptor(object);
			
			addPropertyAutocommitPropertyDescriptor(object);
			addPropertyIsolationPropertyDescriptor(object);
			addPropertyMaxactivePropertyDescriptor(object);
			addPropertyMaxidlePropertyDescriptor(object);
			addPropertyMaxopenstatementsPropertyDescriptor(object);
			addPropertyMaxwaitPropertyDescriptor(object);
			addPropertyMinidlePropertyDescriptor(object);
			addPropertyPoolstatementsPropertyDescriptor(object);
			addPropertyTestonborrowPropertyDescriptor(object);
			addPropertyTestwhileidlePropertyDescriptor(object);
			addPropertyValidationqueryPropertyDescriptor(object);
			addPropertyInitialsizePropertyDescriptor(object);
		}
		
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Connection Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_connectionType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_connectionType_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ConnectionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Ds Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionDsTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_connectionDsType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_connectionDsType_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ConnectionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Db Driver feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionDbDriverPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_connectionDbDriver_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_connectionDbDriver_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ConnectionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Ds Initial Context feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionDsInitialContextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_connectionDsInitialContext_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_connectionDsInitialContext_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ConnectionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Ds Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionDsNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_connectionDsName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_connectionDsName_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ConnectionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_connectionURL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_connectionURL_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ConnectionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Username feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionUsernamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_connectionUsername_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_connectionUsername_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ConnectionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_connectionPassword_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_connectionPassword_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ConnectionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Autocommit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyAutocommitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyAutocommit_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyAutocommit_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Isolation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyIsolationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyIsolation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyIsolation_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Maxactive feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyMaxactivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyMaxactive_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyMaxactive_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Maxidle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyMaxidlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyMaxidle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyMaxidle_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Maxopenstatements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyMaxopenstatementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyMaxopenstatements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyMaxopenstatements_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Maxwait feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyMaxwaitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyMaxwait_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyMaxwait_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Minidle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyMinidlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyMinidle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyMinidle_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Poolstatements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyPoolstatementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyPoolstatements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyPoolstatements_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Testonborrow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyTestonborrowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyTestonborrow_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyTestonborrow_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Testwhileidle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyTestwhileidlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyTestwhileidle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyTestwhileidle_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Validationquery feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyValidationqueryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyValidationquery_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyValidationquery_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Initialsize feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyInitialsizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractSqlExecutorMediator_propertyInitialsize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractSqlExecutorMediator_propertyInitialsize_feature", "_UI_AbstractSqlExecutorMediator_type"),
				 MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_PropertiesPropertyCategory"),
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
			childrenFeatures.add(MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((AbstractSqlExecutorMediator)object).getConnectionDsName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractSqlExecutorMediator_type") :
			getString("_UI_AbstractSqlExecutorMediator_type") + " " + label;
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

		switch (notification.getFeatureID(AbstractSqlExecutorMediator.class)) {
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY:
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS:
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
				(MediatorsPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS,
				 MediatorsFactory.eINSTANCE.createSqlStatement()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public ResourceLocator getResourceLocator() {
		return EsbEditPlugin.INSTANCE;
	}

}
