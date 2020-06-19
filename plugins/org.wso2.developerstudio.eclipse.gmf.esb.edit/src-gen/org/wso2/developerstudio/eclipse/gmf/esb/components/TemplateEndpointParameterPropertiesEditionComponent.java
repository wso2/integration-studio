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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateEndpointParameterPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class TemplateEndpointParameterPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public TemplateEndpointParameterPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject templateEndpointParameter, String editing_mode) {
		super(editingContext, templateEndpointParameter, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.TemplateEndpointParameter.class;
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
			
			final TemplateEndpointParameter templateEndpointParameter = (TemplateEndpointParameter)elt;
			final TemplateEndpointParameterPropertiesEditionPart basePart = (TemplateEndpointParameterPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName))
				basePart.setParameterName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpointParameter.getParameterName()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue))
				basePart.setParameterValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpointParameter.getParameterValue()));
			
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
		if (editorKey == EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName) {
			return EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterName();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue) {
			return EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterValue();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		TemplateEndpointParameter templateEndpointParameter = (TemplateEndpointParameter)semanticObject;
		if (EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName == event.getAffectedEditor()) {
			templateEndpointParameter.setParameterName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue == event.getAffectedEditor()) {
			templateEndpointParameter.setParameterValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			TemplateEndpointParameterPropertiesEditionPart basePart = (TemplateEndpointParameterPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName)) {
				if (msg.getNewValue() != null) {
					basePart.setParameterName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setParameterName("");
				}
			}
			if (EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue)) {
				if (msg.getNewValue() != null) {
					basePart.setParameterValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setParameterValue("");
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
			EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterName(),
			EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterValue()		);
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
				if (EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTemplateEndpointParameter_ParameterValue().getEAttributeType(), newValue);
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
