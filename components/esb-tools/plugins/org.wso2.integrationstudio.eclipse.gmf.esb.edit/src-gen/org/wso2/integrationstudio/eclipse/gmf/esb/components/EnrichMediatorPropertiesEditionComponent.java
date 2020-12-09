/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

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

import org.wso2.integrationstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.EnrichSourceInlineType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EnrichSourceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EnrichTargetAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.EnrichTargetType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

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
			if (isAccessible(EsbViewsRepository.EnrichMediator.Misc.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enrichMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Misc.commentsList))
				basePart.setCommentsList(enrichMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Misc.reverse)) {
				basePart.setReverse(enrichMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Source.cloneSource)) {
				basePart.setCloneSource(enrichMediator.isCloneSource());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Source.sourceType)) {
				basePart.initSourceType(EEFUtils.choiceOfValues(enrichMediator, EsbPackage.eINSTANCE.getEnrichMediator_SourceType()), enrichMediator.getSourceType());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Source.sourceProperty))
				basePart.setSourceProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enrichMediator.getSourceProperty()));
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Source.sourceXML))
				basePart.setSourceXML(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enrichMediator.getSourceXML()));
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Target.targetAction)) {
				basePart.initTargetAction(EEFUtils.choiceOfValues(enrichMediator, EsbPackage.eINSTANCE.getEnrichMediator_TargetAction()), enrichMediator.getTargetAction());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Target.targetType)) {
				basePart.initTargetType(EEFUtils.choiceOfValues(enrichMediator, EsbPackage.eINSTANCE.getEnrichMediator_TargetType()), enrichMediator.getTargetType());
			}
			if (isAccessible(EsbViewsRepository.EnrichMediator.Target.targetProperty))
				basePart.setTargetProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enrichMediator.getTargetProperty()));
			
			if (isAccessible(EsbViewsRepository.EnrichMediator.Source.inlineType)) {
				basePart.initInlineType(EEFUtils.choiceOfValues(enrichMediator, EsbPackage.eINSTANCE.getEnrichMediator_InlineType()), enrichMediator.getInlineType());
			}
			// Start of user code for sourceXPath command update
            if (isAccessible(EsbViewsRepository.EnrichMediator.Source.sourceXPath)) {
                basePart.setSourceXPath(enrichMediator.getSourceXpath());
            }
            // End of user code
			
			// Start of user code for targetXPath command update
            if (isAccessible(EsbViewsRepository.EnrichMediator.Target.targetXPath)) {
                basePart.setTargetXPath(enrichMediator.getTargetXpath());
            }
            // End of user code
			
			// Start of user code for inlineRegistryKey command update
            if (isAccessible(EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey)) {
                basePart.setInlineRegistryKey(enrichMediator.getInlineRegistryKey());
            }
            // End of user code
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			// Start of user code for sourceXPath filter update
            // End of user code
			
			// Start of user code for targetXPath filter update
            // End of user code
			
			// Start of user code for inlineRegistryKey filter update
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
		if (editorKey == EsbViewsRepository.EnrichMediator.Misc.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Misc.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Misc.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Source.cloneSource) {
			return EsbPackage.eINSTANCE.getEnrichMediator_CloneSource();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Source.sourceType) {
			return EsbPackage.eINSTANCE.getEnrichMediator_SourceType();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Source.sourceProperty) {
			return EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Source.sourceXML) {
			return EsbPackage.eINSTANCE.getEnrichMediator_SourceXML();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Target.targetAction) {
			return EsbPackage.eINSTANCE.getEnrichMediator_TargetAction();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Target.targetType) {
			return EsbPackage.eINSTANCE.getEnrichMediator_TargetType();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Target.targetProperty) {
			return EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Source.inlineType) {
			return EsbPackage.eINSTANCE.getEnrichMediator_InlineType();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Source.sourceXPath) {
			return EsbPackage.eINSTANCE.getEnrichMediator_SourceXpath();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Target.targetXPath) {
			return EsbPackage.eINSTANCE.getEnrichMediator_TargetXpath();
		}
		if (editorKey == EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey) {
			return EsbPackage.eINSTANCE.getEnrichMediator_InlineRegistryKey();
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
		if (EsbViewsRepository.EnrichMediator.Misc.description == event.getAffectedEditor()) {
			enrichMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnrichMediator.Misc.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				enrichMediator.getCommentsList().clear();
				enrichMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.EnrichMediator.Misc.reverse == event.getAffectedEditor()) {
			enrichMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Source.cloneSource == event.getAffectedEditor()) {
			enrichMediator.setCloneSource((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Source.sourceType == event.getAffectedEditor()) {
			enrichMediator.setSourceType((EnrichSourceType)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Source.sourceProperty == event.getAffectedEditor()) {
			enrichMediator.setSourceProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnrichMediator.Source.sourceXML == event.getAffectedEditor()) {
			enrichMediator.setSourceXML((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnrichMediator.Target.targetAction == event.getAffectedEditor()) {
			enrichMediator.setTargetAction((EnrichTargetAction)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Target.targetType == event.getAffectedEditor()) {
			enrichMediator.setTargetType((EnrichTargetType)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Target.targetProperty == event.getAffectedEditor()) {
			enrichMediator.setTargetProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnrichMediator.Source.inlineType == event.getAffectedEditor()) {
			enrichMediator.setInlineType((EnrichSourceInlineType)event.getNewValue());
		}
		if (EsbViewsRepository.EnrichMediator.Source.sourceXPath == event.getAffectedEditor()) {
			// Start of user code for updateSourceXPath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                enrichMediator.setSourceXpath(nsp);
            } else {
                enrichMediator.setSourceXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
            // End of user code
			
		}
		if (EsbViewsRepository.EnrichMediator.Target.targetXPath == event.getAffectedEditor()) {
			// Start of user code for updateTargetXPath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                enrichMediator.setTargetXpath(nsp);
            } else {
                enrichMediator.setTargetXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
            // End of user code
			
		}
		if (EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey == event.getAffectedEditor()) {
			// Start of user code for updateInlineRegistryKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                enrichMediator.setInlineRegistryKey(rkp);
            } else {
                enrichMediator.setInlineRegistryKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EnrichMediatorPropertiesEditionPart basePart = (EnrichMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Misc.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Misc.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Misc.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_CloneSource().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Source.cloneSource))
				basePart.setCloneSource((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_SourceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EnrichMediator.Source.sourceType))
				basePart.setSourceType((EnrichSourceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Source.sourceProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setSourceProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSourceProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getEnrichMediator_SourceXML().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Source.sourceXML)) {
				if (msg.getNewValue() != null) {
					basePart.setSourceXML(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSourceXML("");
				}
			}
			if (EsbPackage.eINSTANCE.getEnrichMediator_TargetAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EnrichMediator.Target.targetAction))
				basePart.setTargetAction((EnrichTargetAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_TargetType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EnrichMediator.Target.targetType))
				basePart.setTargetType((EnrichTargetType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnrichMediator.Target.targetProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getEnrichMediator_InlineType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EnrichMediator.Source.inlineType))
				basePart.setInlineType((EnrichSourceInlineType)msg.getNewValue());
			
					// Start of user code for sourceXPath live update
            if (EsbPackage.eINSTANCE.getEnrichMediator_SourceXpath().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EnrichMediator.Source.sourceXPath)) {
                if (msg.getNewValue() != null) {
                    basePart.setSourceXPath((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setSourceXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code
			
					// Start of user code for targetXPath live update
            if (EsbPackage.eINSTANCE.getEnrichMediator_TargetXpath().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EnrichMediator.Target.targetXPath)) {
                if (msg.getNewValue() != null) {
                    basePart.setTargetXPath((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setTargetXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code
			
					// Start of user code for inlineRegistryKey live update
            if (EsbPackage.eINSTANCE.getEnrichMediator_InlineRegistryKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setInlineRegistryKey((RegistryKeyProperty)msg.getNewValue());
                } else {
                    basePart.setInlineRegistryKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getEnrichMediator_InlineType(),
			EsbPackage.eINSTANCE.getEnrichMediator_SourceXpath(),
			EsbPackage.eINSTANCE.getEnrichMediator_TargetXpath(),
			EsbPackage.eINSTANCE.getEnrichMediator_InlineRegistryKey()		);
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
				if (EsbViewsRepository.EnrichMediator.Misc.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Misc.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.EnrichMediator.Misc.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Source.cloneSource == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_CloneSource().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_CloneSource().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Source.sourceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_SourceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_SourceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Source.sourceProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_SourceProperty().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Source.sourceXML == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_SourceXML().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_SourceXML().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Target.targetAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_TargetAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_TargetAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Target.targetType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_TargetType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_TargetType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Target.targetProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnrichMediator_TargetProperty().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnrichMediator.Source.inlineType == event.getAffectedEditor()) {
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

    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }
	

	

}
