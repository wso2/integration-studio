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
import org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class MessageBuilderPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public MessageBuilderPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject messageBuilder, String editing_mode) {
		super(editingContext, messageBuilder, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.MessageBuilder.class;
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
			
			final MessageBuilder messageBuilder = (MessageBuilder)elt;
			final MessageBuilderPropertiesEditionPart basePart = (MessageBuilderPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.MessageBuilder.Properties.contentType))
				basePart.setContentType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageBuilder.getContentType()));
			
			if (isAccessible(EsbViewsRepository.MessageBuilder.Properties.builderClass))
				basePart.setBuilderClass(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageBuilder.getBuilderClass()));
			
			if (isAccessible(EsbViewsRepository.MessageBuilder.Properties.formatterClass))
				basePart.setFormatterClass(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageBuilder.getFormatterClass()));
			
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
		if (editorKey == EsbViewsRepository.MessageBuilder.Properties.contentType) {
			return EsbPackage.eINSTANCE.getMessageBuilder_ContentType();
		}
		if (editorKey == EsbViewsRepository.MessageBuilder.Properties.builderClass) {
			return EsbPackage.eINSTANCE.getMessageBuilder_BuilderClass();
		}
		if (editorKey == EsbViewsRepository.MessageBuilder.Properties.formatterClass) {
			return EsbPackage.eINSTANCE.getMessageBuilder_FormatterClass();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		MessageBuilder messageBuilder = (MessageBuilder)semanticObject;
		if (EsbViewsRepository.MessageBuilder.Properties.contentType == event.getAffectedEditor()) {
			messageBuilder.setContentType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageBuilder.Properties.builderClass == event.getAffectedEditor()) {
			messageBuilder.setBuilderClass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageBuilder.Properties.formatterClass == event.getAffectedEditor()) {
			messageBuilder.setFormatterClass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			MessageBuilderPropertiesEditionPart basePart = (MessageBuilderPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getMessageBuilder_ContentType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageBuilder.Properties.contentType)) {
				if (msg.getNewValue() != null) {
					basePart.setContentType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setContentType("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageBuilder_BuilderClass().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageBuilder.Properties.builderClass)) {
				if (msg.getNewValue() != null) {
					basePart.setBuilderClass(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setBuilderClass("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageBuilder_FormatterClass().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageBuilder.Properties.formatterClass)) {
				if (msg.getNewValue() != null) {
					basePart.setFormatterClass(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFormatterClass("");
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
			EsbPackage.eINSTANCE.getMessageBuilder_ContentType(),
			EsbPackage.eINSTANCE.getMessageBuilder_BuilderClass(),
			EsbPackage.eINSTANCE.getMessageBuilder_FormatterClass()		);
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
				if (EsbViewsRepository.MessageBuilder.Properties.contentType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageBuilder_ContentType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageBuilder_ContentType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageBuilder.Properties.builderClass == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageBuilder_BuilderClass().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageBuilder_BuilderClass().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageBuilder.Properties.formatterClass == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageBuilder_FormatterClass().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageBuilder_FormatterClass().getEAttributeType(), newValue);
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
