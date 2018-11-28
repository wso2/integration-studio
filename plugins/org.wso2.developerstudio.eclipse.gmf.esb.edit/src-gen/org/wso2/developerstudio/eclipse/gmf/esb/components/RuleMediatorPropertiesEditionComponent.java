/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleActions;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSessionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleType;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart;


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
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.commentsList))
				basePart.setCommentsList(ruleMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.reverse)) {
				basePart.setReverse(ruleMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSetURL))
				basePart.setRuleSetURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getRuleSetURL()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType)) {
				basePart.initRuleSetSourceType(EEFUtils.choiceOfValues(ruleMediator, EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType()), ruleMediator.getRuleSetSourceType());
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode))
				basePart.setRuleSetSourceCode(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getRuleSetSourceCode()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.statefulSession)) {
				basePart.setStatefulSession(ruleMediator.isStatefulSession());
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties)) {
				ruleSessionPropertiesSettings = new ReferencesTableSettings(ruleMediator, EsbPackage.eINSTANCE.getRuleMediator_RuleSessionProperties());
				basePart.initRuleSessionProperties(ruleSessionPropertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.sourceValue))
				basePart.setSourceValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getSourceValue()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.targetValue))
				basePart.setTargetValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getTargetValue()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.targetAction)) {
				basePart.initTargetAction(EEFUtils.choiceOfValues(ruleMediator, EsbPackage.eINSTANCE.getRuleMediator_TargetAction()), ruleMediator.getTargetAction());
			}
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.inputWrapperName))
				basePart.setInputWrapperName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getInputWrapperName()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.inputNameSpace))
				basePart.setInputNameSpace(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getInputNameSpace()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.outputWrapperName))
				basePart.setOutputWrapperName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getOutputWrapperName()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.outputNameSpace))
				basePart.setOutputNameSpace(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleMediator.getOutputNameSpace()));
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSetType)) {
				basePart.initRuleSetType(EEFUtils.choiceOfValues(ruleMediator, EsbPackage.eINSTANCE.getRuleMediator_RuleSetType()), ruleMediator.getRuleSetType());
			}
			// init filters
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties)) {
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
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.ruleSetURL) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.statefulSession) {
			return EsbPackage.eINSTANCE.getRuleMediator_StatefulSession();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSessionProperties();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.sourceValue) {
			return EsbPackage.eINSTANCE.getRuleMediator_SourceValue();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.targetValue) {
			return EsbPackage.eINSTANCE.getRuleMediator_TargetValue();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.targetAction) {
			return EsbPackage.eINSTANCE.getRuleMediator_TargetAction();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.inputWrapperName) {
			return EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.inputNameSpace) {
			return EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.outputWrapperName) {
			return EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.outputNameSpace) {
			return EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace();
		}
		if (editorKey == EsbViewsRepository.RuleMediator.Properties.ruleSetType) {
			return EsbPackage.eINSTANCE.getRuleMediator_RuleSetType();
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
		if (EsbViewsRepository.RuleMediator.Properties.description == event.getAffectedEditor()) {
			ruleMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				ruleMediator.getCommentsList().clear();
				ruleMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.RuleMediator.Properties.reverse == event.getAffectedEditor()) {
			ruleMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.Properties.ruleSetURL == event.getAffectedEditor()) {
			ruleMediator.setRuleSetURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType == event.getAffectedEditor()) {
			ruleMediator.setRuleSetSourceType((RuleSourceType)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode == event.getAffectedEditor()) {
			ruleMediator.setRuleSetSourceCode((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.statefulSession == event.getAffectedEditor()) {
			ruleMediator.setStatefulSession((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.RuleMediator.Properties.sourceValue == event.getAffectedEditor()) {
			ruleMediator.setSourceValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.targetValue == event.getAffectedEditor()) {
			ruleMediator.setTargetValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.targetAction == event.getAffectedEditor()) {
			ruleMediator.setTargetAction((RuleActions)event.getNewValue());
		}
		if (EsbViewsRepository.RuleMediator.Properties.inputWrapperName == event.getAffectedEditor()) {
			ruleMediator.setInputWrapperName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.inputNameSpace == event.getAffectedEditor()) {
			ruleMediator.setInputNameSpace((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.outputWrapperName == event.getAffectedEditor()) {
			ruleMediator.setOutputWrapperName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.outputNameSpace == event.getAffectedEditor()) {
			ruleMediator.setOutputNameSpace((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleMediator.Properties.ruleSetType == event.getAffectedEditor()) {
			ruleMediator.setRuleSetType((RuleType)event.getNewValue());
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
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSetURL)) {
				if (msg.getNewValue() != null) {
					basePart.setRuleSetURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRuleSetURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType))
				basePart.setRuleSetSourceType((RuleSourceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode)) {
				if (msg.getNewValue() != null) {
					basePart.setRuleSetSourceCode(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRuleSetSourceCode("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_StatefulSession().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.statefulSession))
				basePart.setStatefulSession((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSessionProperties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties))
				basePart.updateRuleSessionProperties();
			if (EsbPackage.eINSTANCE.getRuleMediator_SourceValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.sourceValue)) {
				if (msg.getNewValue() != null) {
					basePart.setSourceValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSourceValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_TargetValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.targetValue)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_TargetAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleMediator.Properties.targetAction))
				basePart.setTargetAction((RuleActions)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.inputWrapperName)) {
				if (msg.getNewValue() != null) {
					basePart.setInputWrapperName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInputWrapperName("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.inputNameSpace)) {
				if (msg.getNewValue() != null) {
					basePart.setInputNameSpace(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInputNameSpace("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.outputWrapperName)) {
				if (msg.getNewValue() != null) {
					basePart.setOutputWrapperName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutputWrapperName("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleMediator.Properties.outputNameSpace)) {
				if (msg.getNewValue() != null) {
					basePart.setOutputNameSpace(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutputNameSpace("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleMediator_RuleSetType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleMediator.Properties.ruleSetType))
				basePart.setRuleSetType((RuleType)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getRuleMediator_RuleSetType()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType)
			return ""; //$NON-NLS-1$
		if (key == EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties)
			return ""; //$NON-NLS-1$
		if (key == EsbViewsRepository.RuleMediator.Properties.targetValue)
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
				if (EsbViewsRepository.RuleMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.RuleMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.ruleSetURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_RuleSetURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_RuleSetSourceCode().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.statefulSession == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_StatefulSession().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_StatefulSession().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.sourceValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_SourceValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_SourceValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.targetValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_TargetValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_TargetValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.targetAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_TargetAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_TargetAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.inputWrapperName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_InputWrapperName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.inputNameSpace == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_InputNameSpace().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.outputWrapperName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_OutputWrapperName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.outputNameSpace == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleMediator_OutputNameSpace().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleMediator.Properties.ruleSetType == event.getAffectedEditor()) {
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
