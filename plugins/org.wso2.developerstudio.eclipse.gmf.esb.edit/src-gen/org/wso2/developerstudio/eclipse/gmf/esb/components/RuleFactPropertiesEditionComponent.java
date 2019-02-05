/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactValueType;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class RuleFactPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public RuleFactPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject ruleFact, String editing_mode) {
		super(editingContext, ruleFact, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.RuleFact.class;
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
			
			final RuleFact ruleFact = (RuleFact)elt;
			final RuleFactPropertiesEditionPart basePart = (RuleFactPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.RuleFact.Properties.factType)) {
				basePart.initFactType(EEFUtils.choiceOfValues(ruleFact, EsbPackage.eINSTANCE.getRuleFact_FactType()), ruleFact.getFactType());
			}
			if (isAccessible(EsbViewsRepository.RuleFact.Properties.factCustomType))
				basePart.setFactCustomType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleFact.getFactCustomType()));
			
			if (isAccessible(EsbViewsRepository.RuleFact.Properties.factName))
				basePart.setFactName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleFact.getFactName()));
			
			if (isAccessible(EsbViewsRepository.RuleFact.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(ruleFact, EsbPackage.eINSTANCE.getRuleFact_ValueType()), ruleFact.getValueType());
			}
			if (isAccessible(EsbViewsRepository.RuleFact.Properties.valueLiteral))
				basePart.setValueLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleFact.getValueLiteral()));
			
			// init filters
			
			
			
			
			
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
		if (editorKey == EsbViewsRepository.RuleFact.Properties.factType) {
			return EsbPackage.eINSTANCE.getRuleFact_FactType();
		}
		if (editorKey == EsbViewsRepository.RuleFact.Properties.factCustomType) {
			return EsbPackage.eINSTANCE.getRuleFact_FactCustomType();
		}
		if (editorKey == EsbViewsRepository.RuleFact.Properties.factName) {
			return EsbPackage.eINSTANCE.getRuleFact_FactName();
		}
		if (editorKey == EsbViewsRepository.RuleFact.Properties.valueType) {
			return EsbPackage.eINSTANCE.getRuleFact_ValueType();
		}
		if (editorKey == EsbViewsRepository.RuleFact.Properties.valueLiteral) {
			return EsbPackage.eINSTANCE.getRuleFact_ValueLiteral();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		RuleFact ruleFact = (RuleFact)semanticObject;
		if (EsbViewsRepository.RuleFact.Properties.factType == event.getAffectedEditor()) {
			ruleFact.setFactType((RuleFactType)event.getNewValue());
		}
		if (EsbViewsRepository.RuleFact.Properties.factCustomType == event.getAffectedEditor()) {
			ruleFact.setFactCustomType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleFact.Properties.factName == event.getAffectedEditor()) {
			ruleFact.setFactName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleFact.Properties.valueType == event.getAffectedEditor()) {
			ruleFact.setValueType((RuleFactValueType)event.getNewValue());
		}
		if (EsbViewsRepository.RuleFact.Properties.valueLiteral == event.getAffectedEditor()) {
			ruleFact.setValueLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RuleFactPropertiesEditionPart basePart = (RuleFactPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getRuleFact_FactType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleFact.Properties.factType))
				basePart.setFactType((RuleFactType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleFact_FactCustomType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleFact.Properties.factCustomType)) {
				if (msg.getNewValue() != null) {
					basePart.setFactCustomType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFactCustomType("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleFact_FactName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleFact.Properties.factName)) {
				if (msg.getNewValue() != null) {
					basePart.setFactName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFactName("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleFact_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleFact.Properties.valueType))
				basePart.setValueType((RuleFactValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleFact_ValueLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleFact.Properties.valueLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setValueLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueLiteral("");
				}
			}
			
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
			EsbPackage.eINSTANCE.getRuleFact_FactType(),
			EsbPackage.eINSTANCE.getRuleFact_FactCustomType(),
			EsbPackage.eINSTANCE.getRuleFact_FactName(),
			EsbPackage.eINSTANCE.getRuleFact_ValueType(),
			EsbPackage.eINSTANCE.getRuleFact_ValueLiteral()		);
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
				if (EsbViewsRepository.RuleFact.Properties.factType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleFact_FactType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleFact_FactType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleFact.Properties.factCustomType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleFact_FactCustomType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleFact_FactCustomType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleFact.Properties.factName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleFact_FactName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleFact_FactName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleFact.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleFact_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleFact_ValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleFact.Properties.valueLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleFact_ValueLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleFact_ValueLiteral().getEAttributeType(), newValue);
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
