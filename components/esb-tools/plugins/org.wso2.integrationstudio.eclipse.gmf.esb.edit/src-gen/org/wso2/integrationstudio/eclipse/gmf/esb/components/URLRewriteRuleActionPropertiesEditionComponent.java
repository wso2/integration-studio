/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleActionType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleFragmentType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.integrationstudio.eclipse.gmf.esb.URLRewriteRuleAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.CloneTargetPropertiesEditionPartImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.URLRewriteRuleActionPropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class URLRewriteRuleActionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public URLRewriteRuleActionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject uRLRewriteRuleAction, String editing_mode) {
		super(editingContext, uRLRewriteRuleAction, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.URLRewriteRuleAction.class;
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
			
			final URLRewriteRuleAction uRLRewriteRuleAction = (URLRewriteRuleAction)elt;
			final URLRewriteRuleActionPropertiesEditionPart basePart = (URLRewriteRuleActionPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction)) {
				basePart.initRuleAction(EEFUtils.choiceOfValues(uRLRewriteRuleAction, EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleAction()), uRLRewriteRuleAction.getRuleAction());
			}
			if (isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment)) {
				basePart.initRuleFragment(EEFUtils.choiceOfValues(uRLRewriteRuleAction, EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleFragment()), uRLRewriteRuleAction.getRuleFragment());
			}
			if (isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption)) {
				basePart.initRuleOption(EEFUtils.choiceOfValues(uRLRewriteRuleAction, EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleOption()), uRLRewriteRuleAction.getRuleOption());
			}
			if (isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue))
				basePart.setActionValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, uRLRewriteRuleAction.getActionValue()));
			
			if (isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex))
				basePart.setActionRegex(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, uRLRewriteRuleAction.getActionRegex()));
			
			// Start of user code  for actionExpression command update
            if (isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression)) {
                basePart.setActionExpression(uRLRewriteRuleAction.getActionExpression());
            }
			// End of user code
			
			// init filters
			
			
			
			
			
			// Start of user code  for actionExpression filter update
            ((URLRewriteRuleActionPropertiesEditionPartImpl) editingPart).validate();
			// End of user code
			
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
		if (editorKey == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction) {
			return EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleAction();
		}
		if (editorKey == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment) {
			return EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleFragment();
		}
		if (editorKey == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption) {
			return EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleOption();
		}
		if (editorKey == EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue) {
			return EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionValue();
		}
		if (editorKey == EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex) {
			return EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionRegex();
		}
		if (editorKey == EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression) {
			return EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		URLRewriteRuleAction uRLRewriteRuleAction = (URLRewriteRuleAction)semanticObject;
		if (EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction == event.getAffectedEditor()) {
			uRLRewriteRuleAction.setRuleAction((RuleActionType)event.getNewValue());
		}
		if (EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment == event.getAffectedEditor()) {
			uRLRewriteRuleAction.setRuleFragment((RuleFragmentType)event.getNewValue());
		}
		if (EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption == event.getAffectedEditor()) {
			uRLRewriteRuleAction.setRuleOption((RuleOptionType)event.getNewValue());
		}
		if (EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue == event.getAffectedEditor()) {
			uRLRewriteRuleAction.setActionValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex == event.getAffectedEditor()) {
			uRLRewriteRuleAction.setActionRegex((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression == event.getAffectedEditor()) {
			// Start of user code for updateActionExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                uRLRewriteRuleAction.setActionExpression(nsp);
            } else {
                uRLRewriteRuleAction.setActionExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			URLRewriteRuleActionPropertiesEditionPart basePart = (URLRewriteRuleActionPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction))
				basePart.setRuleAction((RuleActionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleFragment().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment))
				basePart.setRuleFragment((RuleFragmentType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleOption().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption))
				basePart.setRuleOption((RuleOptionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue)) {
				if (msg.getNewValue() != null) {
					basePart.setActionValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setActionValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionRegex().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex)) {
				if (msg.getNewValue() != null) {
					basePart.setActionRegex(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setActionRegex("");
				}
			}
					// Start of user code for actionExpression live update
	         if (EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression)) {
	                 if (msg.getNewValue() != null) {
	                    basePart.setActionExpression((NamespacedProperty)msg.getNewValue());
	                } else {
	                    basePart.setActionExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
	                }
	            }		
					// End of user code
			
			
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
			EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleAction(),
			EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleFragment(),
			EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleOption(),
			EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionValue(),
			EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionRegex(),
			EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionExpression()		);
		return new NotificationFilter[] {filter,};
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
				if (EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleFragment().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleFragment().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleOption().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getURLRewriteRuleAction_RuleOption().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionRegex().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getURLRewriteRuleAction_ActionRegex().getEAttributeType(), newValue);
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
