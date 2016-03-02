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
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RuleMediatorItemProvider
	extends MediatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMediatorItemProvider(AdapterFactory adapterFactory) {
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
		RuleMediator ruleMediator = (RuleMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addRuleSetSourceTypePropertyDescriptor(object);
		if (ruleMediator.getRuleSetSourceType() == RuleSourceType.REGISTRY) {
			addRuleSetSourceKeyPropertyDescriptor(object);
		} else if (ruleMediator.getRuleSetSourceType() == RuleSourceType.URL) {
			addRuleSetURLPropertyDescriptor(object);
		} else {
			addRuleSetSourceCodePropertyDescriptor(object);
		}
		// addRuleSetPropertiesPropertyDescriptor(object);
		// addStatefulSessionPropertyDescriptor(object);
		// addRuleSessionPropertiesPropertyDescriptor(object);
		addFactsConfigurationPropertyDescriptor(object);
		addResultsConfigurationPropertyDescriptor(object);
		addSourceValuePropertyDescriptor(object);
		addSourceXpathPropertyDescriptor(object);
		addTargetValuePropertyDescriptor(object);
		addTargetResultXpathPropertyDescriptor(object);
		addTargetXpathPropertyDescriptor(object);
		addTargetActionPropertyDescriptor(object);
		addInputWrapperNamePropertyDescriptor(object);
		addInputNameSpacePropertyDescriptor(object);
		addOutputWrapperNamePropertyDescriptor(object);
		addOutputNameSpacePropertyDescriptor(object);
		addRuleSetTypePropertyDescriptor(object);
		addDescriptionPropertyDescriptor(object);
		
		return itemPropertyDescriptors;
	}	 

	
	/*@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		RuleMediator ruleMediator = (RuleMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		super.getPropertyDescriptors(object);

		addRuleSetURIPropertyDescriptor(object);
		addRuleSetSourceTypePropertyDescriptor(object);
		if (ruleMediator.getRuleSetSourceType() == RuleSourceType.REGISTRY_REFERENCE) {
			addRuleSetSourceKeyPropertyDescriptor(object);
		} else {
			addRuleSetSourceCodePropertyDescriptor(object);
		}
			addRuleSetPropertiesPropertyDescriptor(object);
			//addStatefulSessionPropertyDescriptor(object);
			//addRuleSessionPropertiesPropertyDescriptor(object);
			addFactsConfigurationPropertyDescriptor(object);
			addResultsConfigurationPropertyDescriptor(object);
			addSourceValuePropertyDescriptor(object);
			addSourceXpathPropertyDescriptor(object);
			addTargetValuePropertyDescriptor(object);
			addTargetResultXpathPropertyDescriptor(object);
			addTargetXpathPropertyDescriptor(object);
			addTargetActionPropertyDescriptor(object);
			addInputWrapperNamePropertyDescriptor(object);
			addInputNameSpacePropertyDescriptor(object);
			addOutputWrapperNamePropertyDescriptor(object);
			addOutputNameSpacePropertyDescriptor(object);
	 
		return itemPropertyDescriptors;
	}	 
	*/
	

	/**
	 * This adds a property descriptor for the Rule Set URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuleSetURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_RuleSetURL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_RuleSetURL_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_RuleSetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rule Set Source Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuleSetSourceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_ruleSetSourceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_ruleSetSourceType_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_SOURCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_RuleSetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rule Set Source Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuleSetSourceCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_ruleSetSourceCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_ruleSetSourceCode_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_SOURCE_CODE,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_RuleSetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rule Set Source Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuleSetSourceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_ruleSetSourceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_ruleSetSourceKey_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_SOURCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_RuleSetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Stateful Session feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatefulSessionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_statefulSession_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_statefulSession_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__STATEFUL_SESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_RuleSessionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rule Session Properties feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuleSessionPropertiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_RuleSessionProperties_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_RuleSessionProperties_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__RULE_SESSION_PROPERTIES,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_RuleSessionPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Facts Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFactsConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_factsConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_factsConfiguration_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__FACTS_CONFIGURATION,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_InputFactsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Results Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultsConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_resultsConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_resultsConfiguration_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__RESULTS_CONFIGURATION,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_OutputFactsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_sourceValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_sourceValue_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__SOURCE_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_SourcePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Xpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_sourceXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_sourceXpath_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__SOURCE_XPATH,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_SourcePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_targetValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_targetValue_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__TARGET_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_TargetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Result Xpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetResultXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_targetResultXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_targetResultXpath_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__TARGET_RESULT_XPATH,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_TargetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Xpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetXpathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_targetXpath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_targetXpath_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__TARGET_XPATH,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_TargetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_targetAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_targetAction_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__TARGET_ACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_TargetPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Input Wrapper Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputWrapperNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_InputWrapperName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_InputWrapperName_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__INPUT_WRAPPER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_InputFactsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Input Name Space feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputNameSpacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_InputNameSpace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_InputNameSpace_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__INPUT_NAME_SPACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_InputFactsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Wrapper Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputWrapperNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_OutputWrapperName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_OutputWrapperName_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__OUTPUT_WRAPPER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_OutputFactsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Name Space feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputNameSpacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_OutputNameSpace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_OutputNameSpace_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__OUTPUT_NAME_SPACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_OutputFactsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rule Set Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuleSetTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RuleMediator_RuleSetType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RuleMediator_RuleSetType_feature", "_UI_RuleMediator_type"),
				 EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_RuleSetPropertyCategory"),
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
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_SOURCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__RULE_SESSION_PROPERTIES);
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__FACTS_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__RESULTS_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION);
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__CHILD_MEDIATORS_OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.RULE_MEDIATOR__MEDIATOR_FLOW);
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
	 * This returns RuleMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RuleMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((RuleMediator)object).getInputWrapperName();
		return label == null || label.length() == 0 ?
			getString("_UI_RuleMediator_type") :
			getString("_UI_RuleMediator_type") + " " + label;
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

		switch (notification.getFeatureID(RuleMediator.class)) {
			case EsbPackage.RULE_MEDIATOR__RULE_SET_URL:
			case EsbPackage.RULE_MEDIATOR__RULE_SET_SOURCE_TYPE:
			case EsbPackage.RULE_MEDIATOR__RULE_SET_SOURCE_CODE:
			case EsbPackage.RULE_MEDIATOR__STATEFUL_SESSION:
			case EsbPackage.RULE_MEDIATOR__SOURCE_VALUE:
			case EsbPackage.RULE_MEDIATOR__TARGET_VALUE:
			case EsbPackage.RULE_MEDIATOR__TARGET_ACTION:
			case EsbPackage.RULE_MEDIATOR__INPUT_WRAPPER_NAME:
			case EsbPackage.RULE_MEDIATOR__INPUT_NAME_SPACE:
			case EsbPackage.RULE_MEDIATOR__OUTPUT_WRAPPER_NAME:
			case EsbPackage.RULE_MEDIATOR__OUTPUT_NAME_SPACE:
			case EsbPackage.RULE_MEDIATOR__RULE_SET_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.RULE_MEDIATOR__RULE_SET_SOURCE_KEY:
			case EsbPackage.RULE_MEDIATOR__RULE_SESSION_PROPERTIES:
			case EsbPackage.RULE_MEDIATOR__FACTS_CONFIGURATION:
			case EsbPackage.RULE_MEDIATOR__RESULTS_CONFIGURATION:
			case EsbPackage.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION:
			case EsbPackage.RULE_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.RULE_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.RULE_MEDIATOR__CHILD_MEDIATORS_OUTPUT_CONNECTOR:
			case EsbPackage.RULE_MEDIATOR__MEDIATOR_FLOW:
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
				(EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_SOURCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RULE_MEDIATOR__RULE_SESSION_PROPERTIES,
				 EsbFactory.eINSTANCE.createRuleSessionProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RULE_MEDIATOR__FACTS_CONFIGURATION,
				 EsbFactory.eINSTANCE.createRuleFactsConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RULE_MEDIATOR__RESULTS_CONFIGURATION,
				 EsbFactory.eINSTANCE.createRuleResultsConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION,
				 EsbFactory.eINSTANCE.createRuleChildMediatorsConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RULE_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRuleMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RULE_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRuleMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RULE_MEDIATOR__CHILD_MEDIATORS_OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createRuleMediatorChildMediatorsOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.RULE_MEDIATOR__MEDIATOR_FLOW,
				 EsbFactory.eINSTANCE.createMediatorFlow()));
	}

}
