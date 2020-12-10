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
import org.wso2.integrationstudio.eclipse.gmf.esb.MediaType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PayloadFactoryArgument;
import org.wso2.integrationstudio.eclipse.gmf.esb.PayloadFactoryArgumentType;
import org.wso2.integrationstudio.eclipse.gmf.esb.PayloadFactoryEvaluatorType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.PayloadFactoryArgumentPropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class PayloadFactoryArgumentPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public PayloadFactoryArgumentPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject payloadFactoryArgument, String editing_mode) {
		super(editingContext, payloadFactoryArgument, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.PayloadFactoryArgument.class;
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
			
			final PayloadFactoryArgument payloadFactoryArgument = (PayloadFactoryArgument)elt;
			final PayloadFactoryArgumentPropertiesEditionPart basePart = (PayloadFactoryArgumentPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType)) {
				basePart.initArgumentType(EEFUtils.choiceOfValues(payloadFactoryArgument, EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentType()), payloadFactoryArgument.getArgumentType());
			}
			if (isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue))
				basePart.setArgumentValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, payloadFactoryArgument.getArgumentValue()));
			
			if (isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator)) {
				basePart.initEvaluator(EEFUtils.choiceOfValues(payloadFactoryArgument, EsbPackage.eINSTANCE.getPayloadFactoryArgument_Evaluator()), payloadFactoryArgument.getEvaluator());
			}
			if (isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.literal)) {
				basePart.setLiteral(payloadFactoryArgument.isLiteral());
			}
			// Start of user code  for argumentExpression command update
			if (isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentExpression)) {
				basePart.setArgumentExpression( payloadFactoryArgument.getArgumentExpression());
			}
			// End of user code
			
			// init filters
			
			
			
			
			// Start of user code  for argumentExpression filter update
			((PayloadFactoryArgumentPropertiesEditionPartImpl)editingPart).validate();
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
		if (editorKey == EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType) {
			return EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentType();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue) {
			return EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentValue();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator) {
			return EsbPackage.eINSTANCE.getPayloadFactoryArgument_Evaluator();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryArgument.Properties.literal) {
			return EsbPackage.eINSTANCE.getPayloadFactoryArgument_Literal();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryArgument.Properties.argumentExpression) {
			return EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		PayloadFactoryArgument payloadFactoryArgument = (PayloadFactoryArgument)semanticObject;
		if (EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType == event.getAffectedEditor()) {
			payloadFactoryArgument.setArgumentType((PayloadFactoryArgumentType)event.getNewValue());
		}
		if (EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue == event.getAffectedEditor()) {
			payloadFactoryArgument.setArgumentValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator == event.getAffectedEditor()) {
			payloadFactoryArgument.setEvaluator((PayloadFactoryEvaluatorType)event.getNewValue());
		}
		if (EsbViewsRepository.PayloadFactoryArgument.Properties.literal == event.getAffectedEditor()) {
			payloadFactoryArgument.setLiteral((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.PayloadFactoryArgument.Properties.argumentExpression == event.getAffectedEditor()) {
			// Start of user code for updateArgumentExpression method body
			if (event.getNewValue() != null) {
				NamespacedProperty nspHeaderName = (NamespacedProperty)event.getNewValue();
				payloadFactoryArgument.setArgumentExpression(nspHeaderName);
			} else {
				payloadFactoryArgument.setArgumentExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			PayloadFactoryArgumentPropertiesEditionPart basePart = (PayloadFactoryArgumentPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType))
				basePart.setArgumentType((PayloadFactoryArgumentType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue)) {
				if (msg.getNewValue() != null) {
					basePart.setArgumentValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setArgumentValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getPayloadFactoryArgument_Evaluator().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator))
				basePart.setEvaluator((MediaType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPayloadFactoryArgument_Literal().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.literal))
				basePart.setLiteral((Boolean)msg.getNewValue());
			
					// Start of user code for argumentExpression live update
			if (EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentExpression)) {
				if (msg.getNewValue() != null) {
					basePart.setArgumentExpression((NamespacedProperty)msg.getNewValue());
				} else {
					basePart.setArgumentExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentType(),
			EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentValue(),
			EsbPackage.eINSTANCE.getPayloadFactoryArgument_Evaluator(),
			EsbPackage.eINSTANCE.getPayloadFactoryArgument_Literal(),
			EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentExpression()		);
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
				if (EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPayloadFactoryArgument_ArgumentValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPayloadFactoryArgument_Evaluator().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPayloadFactoryArgument_Evaluator().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PayloadFactoryArgument.Properties.literal == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPayloadFactoryArgument_Literal().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPayloadFactoryArgument_Literal().getEAttributeType(), newValue);
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
