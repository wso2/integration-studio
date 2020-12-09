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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class EvaluatorExpressionPropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public EvaluatorExpressionPropertyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject evaluatorExpressionProperty, String editing_mode) {
		super(editingContext, evaluatorExpressionProperty, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.EvaluatorExpressionProperty.class;
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
			
			final EvaluatorExpressionProperty evaluatorExpressionProperty = (EvaluatorExpressionProperty)elt;
			final EvaluatorExpressionPropertyPropertiesEditionPart basePart = (EvaluatorExpressionPropertyPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName))
				basePart.setPrettyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, evaluatorExpressionProperty.getPrettyName()));
			
			if (isAccessible(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName))
				basePart.setEvaluatorName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, evaluatorExpressionProperty.getEvaluatorName()));
			
			if (isAccessible(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue))
				basePart.setEvaluatorValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, evaluatorExpressionProperty.getEvaluatorValue()));
			
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
		if (editorKey == EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName) {
			return EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_PrettyName();
		}
		if (editorKey == EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName) {
			return EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorName();
		}
		if (editorKey == EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue) {
			return EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorValue();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EvaluatorExpressionProperty evaluatorExpressionProperty = (EvaluatorExpressionProperty)semanticObject;
		if (EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName == event.getAffectedEditor()) {
			evaluatorExpressionProperty.setPrettyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName == event.getAffectedEditor()) {
			evaluatorExpressionProperty.setEvaluatorName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue == event.getAffectedEditor()) {
			evaluatorExpressionProperty.setEvaluatorValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			EvaluatorExpressionPropertyPropertiesEditionPart basePart = (EvaluatorExpressionPropertyPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_PrettyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPrettyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPrettyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName)) {
				if (msg.getNewValue() != null) {
					basePart.setEvaluatorName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEvaluatorName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue)) {
				if (msg.getNewValue() != null) {
					basePart.setEvaluatorValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEvaluatorValue("");
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
			EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_PrettyName(),
			EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorName(),
			EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorValue()		);
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
				if (EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_PrettyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_PrettyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEvaluatorExpressionProperty_EvaluatorValue().getEAttributeType(), newValue);
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
