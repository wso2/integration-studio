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

import org.wso2.integrationstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.CallTemplateParameterPropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class CallTemplateParameterPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public CallTemplateParameterPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject callTemplateParameter, String editing_mode) {
		super(editingContext, callTemplateParameter, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CallTemplateParameter.class;
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
			
			final CallTemplateParameter callTemplateParameter = (CallTemplateParameter)elt;
			final CallTemplateParameterPropertiesEditionPart basePart = (CallTemplateParameterPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CallTemplateParameter.Properties.parameterName))
				basePart.setParameterName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, callTemplateParameter.getParameterName()));
			
			if (isAccessible(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType)) {
				basePart.initTemplateParameterType(EEFUtils.choiceOfValues(callTemplateParameter, EsbPackage.eINSTANCE.getCallTemplateParameter_TemplateParameterType()), callTemplateParameter.getTemplateParameterType());
			}
			if (isAccessible(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue))
				basePart.setParameterValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, callTemplateParameter.getParameterValue()));
			
			// Start of user code  for parameterExpression command update
            if (isAccessible(EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression)) {
                basePart.setParameterExpression(callTemplateParameter.getParameterExpression());
            }
			// End of user code
			
			// init filters
			
			
			
			// Start of user code  for parameterExpression filter update
            ((CallTemplateParameterPropertiesEditionPartImpl)editingPart).validate();
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
		if (editorKey == EsbViewsRepository.CallTemplateParameter.Properties.parameterName) {
			return EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterName();
		}
		if (editorKey == EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType) {
			return EsbPackage.eINSTANCE.getCallTemplateParameter_TemplateParameterType();
		}
		if (editorKey == EsbViewsRepository.CallTemplateParameter.Properties.parameterValue) {
			return EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterValue();
		}
		if (editorKey == EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression) {
			return EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CallTemplateParameter callTemplateParameter = (CallTemplateParameter)semanticObject;
		if (EsbViewsRepository.CallTemplateParameter.Properties.parameterName == event.getAffectedEditor()) {
			callTemplateParameter.setParameterName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType == event.getAffectedEditor()) {
			callTemplateParameter.setTemplateParameterType((RuleOptionType)event.getNewValue());
		}
		if (EsbViewsRepository.CallTemplateParameter.Properties.parameterValue == event.getAffectedEditor()) {
			callTemplateParameter.setParameterValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression == event.getAffectedEditor()) {
			// Start of user code for updateParameterExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                callTemplateParameter.setParameterExpression(nsp);
            } else {
                callTemplateParameter.setParameterExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			CallTemplateParameterPropertiesEditionPart basePart = (CallTemplateParameterPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallTemplateParameter.Properties.parameterName)) {
				if (msg.getNewValue() != null) {
					basePart.setParameterName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setParameterName("");
				}
			}
			if (EsbPackage.eINSTANCE.getCallTemplateParameter_TemplateParameterType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType))
				basePart.setTemplateParameterType((RuleOptionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue)) {
				if (msg.getNewValue() != null) {
					basePart.setParameterValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setParameterValue("");
				}
			}
					// Start of user code for parameterExpression live update
			if (EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue)) {
                if (msg.getNewValue() != null) {
                    basePart.setParameterExpression((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setParameterExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterName(),
			EsbPackage.eINSTANCE.getCallTemplateParameter_TemplateParameterType(),
			EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterValue(),
			EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterExpression()		);
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
				if (EsbViewsRepository.CallTemplateParameter.Properties.parameterName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCallTemplateParameter_TemplateParameterType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCallTemplateParameter_TemplateParameterType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CallTemplateParameter.Properties.parameterValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCallTemplateParameter_ParameterValue().getEAttributeType(), newValue);
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
