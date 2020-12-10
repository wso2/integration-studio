/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleActions;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleFactsConfiguration;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleResultsConfiguration;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleSessionProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleSourceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class RuleMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for RuleSessionProperties ReferencesTable
	 */
	protected ReferencesTableSettings ruleSessionPropertiesSettings;
	
	/**
	 * Settings for ruleFactsConfiguration ReferencesTable
	 */
	protected ReferencesTableSettings ruleFactsConfigurationSettings;
	
	/**
	 * Settings for ruleResultsConfiguration ReferencesTable
	 */
	protected ReferencesTableSettings ruleResultsConfigurationSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public RuleMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject ruleMediator, String editing_mode) {
		super(editingContext, ruleMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.RuleMediator.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final RuleMediator ruleMediator = (RuleMediator)elt;
			final RuleMediatorPropertiesEditionPart basePart = (RuleMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.RuleMediator.Misc.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Misc.commentsList))
				basePart.setCommentsList(ruleMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Misc.reverse)) {
				basePart.setReverse(ruleMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL))
				basePart.setRuleSetURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getRuleSetURL()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType)) {
				basePart.initRuleSetSourceType(EEFUtils.choiceOfValues(ruleMediator, EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType()), ruleMediator.getRuleSetSourceType());
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode))
				basePart.setRuleSetSourceCode(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getRuleSetSourceCode()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Misc.statefulSession)) {
				basePart.setStatefulSession(ruleMediator.isStatefulSession());
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties)) {
				ruleSessionPropertiesSettings = new ReferencesTableSettings(ruleMediator, EsbPackage.eINSTANCE.getRuleMediator_RuleSessionProperties());
				basePart.initRuleSessionProperties(ruleSessionPropertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.Source.sourceValue))
				basePart.setSourceValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getSourceValue()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Target.targetValue))
				basePart.setTargetValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getTargetValue()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Target.targetAction)) {
				basePart.initTargetAction(EEFUtils.choiceOfValues(ruleMediator, EsbPackage.eINSTANCE.getRuleMediator_TargetAction()), ruleMediator.getTargetAction());
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName))
				basePart.setInputWrapperName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getInputWrapperName()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace))
				basePart.setInputNameSpace(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getInputNameSpace()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName))
				basePart.setOutputWrapperName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getOutputWrapperName()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace))
				basePart.setOutputNameSpace(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getOutputNameSpace()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType)) {
				basePart.initRuleSetType(EEFUtils.choiceOfValues(ruleMediator, EsbPackage.eINSTANCE.getRuleMediator_RuleSetType()), ruleMediator.getRuleSetType());
			}
            // Start of user code for ruleSetSourceKey command update
            if (isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceKey)) {
                basePart.setRuleSetSourceKey(ruleMediator.getRuleSetSourceKey());
            }
            // End of user code

            // Start of user code for targetResultXPath command update
            if (isAccessible(EsbViewsRepository.RuleMediator.Target.targetResultXPath)) {
                basePart.setTargetResultXPath(ruleMediator.getTargetResultXpath());
            }
            // End of user code

            // Start of user code for targetXPath command update
            if (isAccessible(EsbViewsRepository.RuleMediator.Target.targetXPath)) {
                basePart.setTargetXPath(ruleMediator.getTargetXpath());
            }
            // End of user code

            // Start of user code for sourceXPath command update
            if (isAccessible(EsbViewsRepository.RuleMediator.Source.sourceXPath)) {
                basePart.setSourceXPath(ruleMediator.getSourceXpath());
            }
            // End of user code

            if (isAccessible(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration)) {
                ruleFactsConfigurationSettings = new ReferencesTableSettings(ruleMediator,
                        EsbPackage.eINSTANCE.getRuleMediator_FactsConfiguration());
                basePart.initRuleFactsConfiguration(ruleFactsConfigurationSettings);
            }
            if (isAccessible(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration)) {
                ruleResultsConfigurationSettings = new ReferencesTableSettings(ruleMediator,
                        EsbPackage.eINSTANCE.getRuleMediator_ResultsConfiguration());
                basePart.initRuleResultsConfiguration(ruleResultsConfigurationSettings);
            }
            // init filters			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties)) {
				basePart.addFilterToRuleSessionProperties(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof RuleSessionProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for RuleSessionProperties
				// End of user code
			}
			
			
			
			
			
			
			
			
			// Start of user code  for ruleSetSourceKey filter update
			// End of user code
			
			// Start of user code  for targetResultXPath filter update
			// End of user code
			
			// Start of user code  for targetXPath filter update
			// End of user code
			
			// Start of user code  for sourceXPath filter update
			// End of user code
			
			if (isAccessible(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration)) {
				basePart.addFilterToRuleFactsConfiguration(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof RuleFactsConfiguration); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for ruleFactsConfiguration
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration)) {
				basePart.addFilterToRuleResultsConfiguration(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof RuleResultsConfiguration); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for ruleResultsConfiguration
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}

























	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.RuleMediator.Misc.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Misc.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Misc.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Misc.statefulSession) {
			return EsbPackage.eINSTANCE.getRuleMediator_StatefulSession();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSessionProperties();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Source.sourceValue) {
			return EsbPackage.eINSTANCE.getRuleMediator_SourceValue();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Target.targetValue) {
			return EsbPackage.eINSTANCE.getRuleMediator_TargetValue();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Target.targetAction) {
			return EsbPackage.eINSTANCE.getRuleMediator_TargetAction();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName) {
			return EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace) {
			return EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName) {
			return EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace) {
			return EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.RuleSet.ruleSetType) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetType();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceKey) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceKey();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Target.targetResultXPath) {
			return EsbPackage.eINSTANCE.getRuleMediator_TargetResultXpath();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Target.targetXPath) {
			return EsbPackage.eINSTANCE.getRuleMediator_TargetXpath();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Source.sourceXPath) {
			return EsbPackage.eINSTANCE.getRuleMediator_SourceXpath();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration) {
			return EsbPackage.eINSTANCE.getRuleMediator_FactsConfiguration();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration) {
			return EsbPackage.eINSTANCE.getRuleMediator_ResultsConfiguration();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		RuleMediator ruleMediator = (RuleMediator)semanticObject;
		if (EsbViewsRepository.RuleMediator.Misc.description == event.getAffectedEditor()) {
			ruleMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Misc.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				ruleMediator.getCommentsList().clear();
				ruleMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.RuleMediator.Misc.reverse == event.getAffectedEditor()) {
			ruleMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL == event.getAffectedEditor()) {
			ruleMediator.setRuleSetURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType == event.getAffectedEditor()) {
			ruleMediator.setRuleSetSourceType((RuleSourceType)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode == event.getAffectedEditor()) {
			ruleMediator.setRuleSetSourceCode((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Misc.statefulSession == event.getAffectedEditor()) {
			ruleMediator.setStatefulSession((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, ruleSessionPropertiesSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				ruleSessionPropertiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				ruleSessionPropertiesSettings.move(event.getNewIndex(), (RuleSessionProperty) event.getNewValue());
			}
		}
		if (EsbViewsRepository.RuleMediator.Source.sourceValue == event.getAffectedEditor()) {
			ruleMediator.setSourceValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Target.targetValue == event.getAffectedEditor()) {
			ruleMediator.setTargetValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Target.targetAction == event.getAffectedEditor()) {
			ruleMediator.setTargetAction((RuleActions)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName == event.getAffectedEditor()) {
			ruleMediator.setInputWrapperName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace == event.getAffectedEditor()) {
			ruleMediator.setInputNameSpace((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName == event.getAffectedEditor()) {
			ruleMediator.setOutputWrapperName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace == event.getAffectedEditor()) {
			ruleMediator.setOutputNameSpace((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetType == event.getAffectedEditor()) {
			ruleMediator.setRuleSetType((RuleType)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceKey == event.getAffectedEditor()) {
			// Start of user code for updateRuleSetSourceKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                ruleMediator.setRuleSetSourceKey(rkp);
            } else {
                ruleMediator.setRuleSetSourceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.RuleMediator.Target.targetResultXPath == event.getAffectedEditor()) {
			// Start of user code for updateTargetResultXPath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                ruleMediator.setTargetResultXpath(nsp);
            } else {
                ruleMediator.setTargetResultXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.RuleMediator.Target.targetXPath == event.getAffectedEditor()) {
			// Start of user code for updateTargetXPath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                ruleMediator.setTargetXpath(nsp);
            } else {
                ruleMediator.setTargetXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.RuleMediator.Source.sourceXPath == event.getAffectedEditor()) {
			// Start of user code for updateSourceXPath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                ruleMediator.setSourceXpath(nsp);
            } else {
                ruleMediator.setSourceXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, ruleFactsConfigurationSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				ruleFactsConfigurationSettings.removeFromReference((EObject) event.getNewValue());
			}
		}
		if (EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, ruleResultsConfigurationSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				ruleResultsConfigurationSettings.removeFromReference((EObject) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RuleMediatorPropertiesEditionPart basePart = (RuleMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Misc.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Misc.commentsList)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setCommentsList((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setCommentsList(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setCommentsList(newValueAsList);
				}
			}
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Misc.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL)) {
				if (msg.getNewValue() != null) {
					basePart.setRuleSetURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRuleSetURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType))
				basePart.setRuleSetSourceType((RuleSourceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode)) {
				if (msg.getNewValue() != null) {
					basePart.setRuleSetSourceCode(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRuleSetSourceCode("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_StatefulSession().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Misc.statefulSession))
				basePart.setStatefulSession((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSessionProperties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties))
				basePart.updateRuleSessionProperties();
			if (EsbPackage.eINSTANCE.getRuleMediator_SourceValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Source.sourceValue)) {
				if (msg.getNewValue() != null) {
					basePart.setSourceValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSourceValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_TargetValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Target.targetValue)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_TargetAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleMediator.Target.targetAction))
				basePart.setTargetAction((RuleActions)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName)) {
				if (msg.getNewValue() != null) {
					basePart.setInputWrapperName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInputWrapperName("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace)) {
				if (msg.getNewValue() != null) {
					basePart.setInputNameSpace(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInputNameSpace("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName)) {
				if (msg.getNewValue() != null) {
					basePart.setOutputWrapperName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutputWrapperName("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace)) {
				if (msg.getNewValue() != null) {
					basePart.setOutputNameSpace(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutputNameSpace("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType))
				basePart.setRuleSetType((RuleType)msg.getNewValue());
			
					// Start of user code for ruleSetSourceKey live update
           if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceKey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setRuleSetSourceKey((RegistryKeyProperty)msg.getNewValue());
                } else {
                    basePart.setRuleSetSourceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
					// Start of user code for targetResultXPath live update
           if (EsbPackage.eINSTANCE.getRuleMediator_TargetResultXpath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Target.targetResultXPath)) {
               if (msg.getNewValue() != null) {
                   basePart.setTargetResultXPath((NamespacedProperty)msg.getNewValue());
               } else {
                   basePart.setTargetResultXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
               }
           }		
					// End of user code
			
					// Start of user code for targetXPath live update
           if (EsbPackage.eINSTANCE.getRuleMediator_TargetXpath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Target.targetXPath)) {
               if (msg.getNewValue() != null) {
                   basePart.setTargetXPath((NamespacedProperty)msg.getNewValue());
               } else {
                   basePart.setTargetXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
               }
           }
					// End of user code
			
					// Start of user code for sourceXPath live update
           if (EsbPackage.eINSTANCE.getRuleMediator_SourceXpath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Source.sourceXPath)) {
               if (msg.getNewValue() != null) {
                   basePart.setSourceXPath((NamespacedProperty)msg.getNewValue());
               } else {
                   basePart.setSourceXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
               }
           }
					// End of user code
			
			if (EsbPackage.eINSTANCE.getRuleMediator_FactsConfiguration().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration))
				basePart.updateRuleFactsConfiguration();
			if (EsbPackage.eINSTANCE.getRuleMediator_ResultsConfiguration().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration))
				basePart.updateRuleResultsConfiguration();
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getMediator_Reverse(),
			EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL(),
			EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType(),
			EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode(),
			EsbPackage.eINSTANCE.getRuleMediator_StatefulSession(),
			EsbPackage.eINSTANCE.getRuleMediator_RuleSessionProperties(),
			EsbPackage.eINSTANCE.getRuleMediator_SourceValue(),
			EsbPackage.eINSTANCE.getRuleMediator_TargetValue(),
			EsbPackage.eINSTANCE.getRuleMediator_TargetAction(),
			EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName(),
			EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace(),
			EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName(),
			EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace(),
			EsbPackage.eINSTANCE.getRuleMediator_RuleSetType(),
			EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceKey(),
			EsbPackage.eINSTANCE.getRuleMediator_TargetResultXpath(),
			EsbPackage.eINSTANCE.getRuleMediator_TargetXpath(),
			EsbPackage.eINSTANCE.getRuleMediator_SourceXpath(),
			EsbPackage.eINSTANCE.getRuleMediator_FactsConfiguration(),
			EsbPackage.eINSTANCE.getRuleMediator_ResultsConfiguration()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType)
			return ""; //$NON-NLS-1$
		if (key == EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties)
			return ""; //$NON-NLS-1$
		if (key == EsbViewsRepository.RuleMediator.Target.targetValue)
			return ""; //$NON-NLS-1$
		if (key == EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration)
			return ""; //$NON-NLS-1$
		if (key == EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration)
			return ""; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EsbViewsRepository.RuleMediator.Misc.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Misc.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.RuleMediator.Misc.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Misc.statefulSession == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_StatefulSession().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_StatefulSession().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Source.sourceValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_SourceValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_SourceValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Target.targetValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_TargetValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_TargetValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Target.targetAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_TargetAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_TargetAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.RuleSet.ruleSetType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_RuleSetType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_RuleSetType().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
