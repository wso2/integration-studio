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
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResult;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultValueType;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleResultPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class RuleResultPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public RuleResultPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject ruleResult, String editing_mode) {
		super(editingContext, ruleResult, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.RuleResult.class;
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
			
			final RuleResult ruleResult = (RuleResult)elt;
			final RuleResultPropertiesEditionPart basePart = (RuleResultPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.RuleResult.Properties.resultType)) {
				basePart.initResultType(EEFUtils.choiceOfValues(ruleResult, EsbPackage.eINSTANCE.getRuleResult_ResultType()), ruleResult.getResultType());
			}
			if (isAccessible(EsbViewsRepository.RuleResult.Properties.resultCustomType))
				basePart.setResultCustomType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleResult.getResultCustomType()));
			
			if (isAccessible(EsbViewsRepository.RuleResult.Properties.resultName))
				basePart.setResultName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleResult.getResultName()));
			
			if (isAccessible(EsbViewsRepository.RuleResult.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(ruleResult, EsbPackage.eINSTANCE.getRuleResult_ValueType()), ruleResult.getValueType());
			}
			if (isAccessible(EsbViewsRepository.RuleResult.Properties.valueLiteral))
				basePart.setValueLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ruleResult.getValueLiteral()));
			
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
		if (editorKey == EsbViewsRepository.RuleResult.Properties.resultType) {
			return EsbPackage.eINSTANCE.getRuleResult_ResultType();
		}
		if (editorKey == EsbViewsRepository.RuleResult.Properties.resultCustomType) {
			return EsbPackage.eINSTANCE.getRuleResult_ResultCustomType();
		}
		if (editorKey == EsbViewsRepository.RuleResult.Properties.resultName) {
			return EsbPackage.eINSTANCE.getRuleResult_ResultName();
		}
		if (editorKey == EsbViewsRepository.RuleResult.Properties.valueType) {
			return EsbPackage.eINSTANCE.getRuleResult_ValueType();
		}
		if (editorKey == EsbViewsRepository.RuleResult.Properties.valueLiteral) {
			return EsbPackage.eINSTANCE.getRuleResult_ValueLiteral();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		RuleResult ruleResult = (RuleResult)semanticObject;
		if (EsbViewsRepository.RuleResult.Properties.resultType == event.getAffectedEditor()) {
			ruleResult.setResultType((RuleResultType)event.getNewValue());
		}
		if (EsbViewsRepository.RuleResult.Properties.resultCustomType == event.getAffectedEditor()) {
			ruleResult.setResultCustomType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleResult.Properties.resultName == event.getAffectedEditor()) {
			ruleResult.setResultName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RuleResult.Properties.valueType == event.getAffectedEditor()) {
			ruleResult.setValueType((RuleResultValueType)event.getNewValue());
		}
		if (EsbViewsRepository.RuleResult.Properties.valueLiteral == event.getAffectedEditor()) {
			ruleResult.setValueLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RuleResultPropertiesEditionPart basePart = (RuleResultPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getRuleResult_ResultType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleResult.Properties.resultType))
				basePart.setResultType((RuleResultType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleResult_ResultCustomType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleResult.Properties.resultCustomType)) {
				if (msg.getNewValue() != null) {
					basePart.setResultCustomType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResultCustomType("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleResult_ResultName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleResult.Properties.resultName)) {
				if (msg.getNewValue() != null) {
					basePart.setResultName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResultName("");
				}
			}
			if (EsbPackage.eINSTANCE.getRuleResult_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.RuleResult.Properties.valueType))
				basePart.setValueType((RuleResultValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRuleResult_ValueLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RuleResult.Properties.valueLiteral)) {
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
			EsbPackage.eINSTANCE.getRuleResult_ResultType(),
			EsbPackage.eINSTANCE.getRuleResult_ResultCustomType(),
			EsbPackage.eINSTANCE.getRuleResult_ResultName(),
			EsbPackage.eINSTANCE.getRuleResult_ValueType(),
			EsbPackage.eINSTANCE.getRuleResult_ValueLiteral()		);
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
				if (EsbViewsRepository.RuleResult.Properties.resultType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleResult_ResultType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleResult_ResultType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleResult.Properties.resultCustomType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleResult_ResultCustomType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleResult_ResultCustomType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleResult.Properties.resultName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleResult_ResultName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleResult_ResultName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleResult.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleResult_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleResult_ValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RuleResult.Properties.valueLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRuleResult_ValueLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRuleResult_ValueLiteral().getEAttributeType(), newValue);
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
