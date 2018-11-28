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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceInlineType;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class EnrichMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public EnrichMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject enrichMediator, String editing_mode) {
		super(editingContext, enrichMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.EnrichMediator.class;
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
			
			final EnrichMediator enrichMediator = (EnrichMediator)elt;
			final EnrichMediatorPropertiesEditionPart basePart = (EnrichMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enrichMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.commentsList))
				basePart.setCommentsList(enrichMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.reverse)) {
				basePart.setReverse(enrichMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.cloneSource)) {
				basePart.setCloneSource(enrichMediator.isCloneSource());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.sourceType)) {
				basePart.initSourceType(EEFUtils.choiceOfValues(enrichMediator, EsbPackage.eINSTANCE.getEnrichMediator_SourceType()), enrichMediator.getSourceType());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.sourceProperty))
				basePart.setSourceProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enrichMediator.getSourceProperty()));
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.sourceXML))
				basePart.setSourceXML(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enrichMediator.getSourceXML()));
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.targetAction)) {
				basePart.initTargetAction(EEFUtils.choiceOfValues(enrichMediator, EsbPackage.eINSTANCE.getEnrichMediator_TargetAction()), enrichMediator.getTargetAction());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.targetType)) {
				basePart.initTargetType(EEFUtils.choiceOfValues(enrichMediator, EsbPackage.eINSTANCE.getEnrichMediator_TargetType()), enrichMediator.getTargetType());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.targetProperty))
				basePart.setTargetProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enrichMediator.getTargetProperty()));
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Properties.inlineType)) {
				basePart.initInlineType(EEFUtils.choiceOfValues(enrichMediator, EsbPackage.eINSTANCE.getEnrichMediator_InlineType()), enrichMediator.getInlineType());
			}
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
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.cloneSource) {
			return EsbPackage.eINSTANCE.getEnrichMediator_CloneSource();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.sourceType) {
			return EsbPackage.eINSTANCE.getEnrichMediator_SourceType();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.sourceProperty) {
			return EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.sourceXML) {
			return EsbPackage.eINSTANCE.getEnrichMediator_SourceXML();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.targetAction) {
			return EsbPackage.eINSTANCE.getEnrichMediator_TargetAction();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.targetType) {
			return EsbPackage.eINSTANCE.getEnrichMediator_TargetType();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.targetProperty) {
			return EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Properties.inlineType) {
			return EsbPackage.eINSTANCE.getEnrichMediator_InlineType();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EnrichMediator enrichMediator = (EnrichMediator)semanticObject;
		if (EsbViewsRepository.EnrichMediator.Properties.description == event.getAffectedEditor()) {
			enrichMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnrichMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				enrichMediator.getCommentsList().clear();
				enrichMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.EnrichMediator.Properties.reverse == event.getAffectedEditor()) {
			enrichMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Properties.cloneSource == event.getAffectedEditor()) {
			enrichMediator.setCloneSource((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Properties.sourceType == event.getAffectedEditor()) {
			enrichMediator.setSourceType((EnrichSourceType)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Properties.sourceProperty == event.getAffectedEditor()) {
			enrichMediator.setSourceProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnrichMediator.Properties.sourceXML == event.getAffectedEditor()) {
			enrichMediator.setSourceXML((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnrichMediator.Properties.targetAction == event.getAffectedEditor()) {
			enrichMediator.setTargetAction((EnrichTargetAction)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Properties.targetType == event.getAffectedEditor()) {
			enrichMediator.setTargetType((EnrichTargetType)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Properties.targetProperty == event.getAffectedEditor()) {
			enrichMediator.setTargetProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnrichMediator.Properties.inlineType == event.getAffectedEditor()) {
			enrichMediator.setInlineType((EnrichSourceInlineType)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			EnrichMediatorPropertiesEditionPart basePart = (EnrichMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_CloneSource().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Properties.cloneSource))
				basePart.setCloneSource((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_SourceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EnrichMediator.Properties.sourceType))
				basePart.setSourceType((EnrichSourceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Properties.sourceProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setSourceProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSourceProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getEnrichMediator_SourceXML().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Properties.sourceXML)) {
				if (msg.getNewValue() != null) {
					basePart.setSourceXML(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSourceXML("");
				}
			}
			if (EsbPackage.eINSTANCE.getEnrichMediator_TargetAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EnrichMediator.Properties.targetAction))
				basePart.setTargetAction((EnrichTargetAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_TargetType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EnrichMediator.Properties.targetType))
				basePart.setTargetType((EnrichTargetType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Properties.targetProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getEnrichMediator_InlineType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EnrichMediator.Properties.inlineType))
				basePart.setInlineType((EnrichSourceInlineType)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getEnrichMediator_CloneSource(),
			EsbPackage.eINSTANCE.getEnrichMediator_SourceType(),
			EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty(),
			EsbPackage.eINSTANCE.getEnrichMediator_SourceXML(),
			EsbPackage.eINSTANCE.getEnrichMediator_TargetAction(),
			EsbPackage.eINSTANCE.getEnrichMediator_TargetType(),
			EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty(),
			EsbPackage.eINSTANCE.getEnrichMediator_InlineType()		);
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
				if (EsbViewsRepository.EnrichMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.EnrichMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.cloneSource == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_CloneSource().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_CloneSource().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.sourceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_SourceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_SourceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.sourceProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.sourceXML == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_SourceXML().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_SourceXML().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.targetAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_TargetAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_TargetAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.targetType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_TargetType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_TargetType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.targetProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Properties.inlineType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_InlineType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_InlineType().getEAttributeType(), newValue);
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
