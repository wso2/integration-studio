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

import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class AggregateMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public AggregateMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject aggregateMediator, String editing_mode) {
		super(editingContext, aggregateMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.AggregateMediator.class;
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
			
			final AggregateMediator aggregateMediator = (AggregateMediator)elt;
			final AggregateMediatorPropertiesEditionPart basePart = (AggregateMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aggregateMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.commentsList))
				basePart.setCommentsList(aggregateMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.reverse)) {
				basePart.setReverse(aggregateMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.aggregateID))
				basePart.setAggregateID(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aggregateMediator.getAggregateID()));
			
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionTimeout)) {
				basePart.setCompletionTimeout(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, aggregateMediator.getCompletionTimeout()));
			}
			
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType)) {
				basePart.initCompletionMinMessagesType(EEFUtils.choiceOfValues(aggregateMediator, EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesType()), aggregateMediator.getCompletionMinMessagesType());
			}
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType)) {
				basePart.initCompletionMaxMessagesType(EEFUtils.choiceOfValues(aggregateMediator, EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesType()), aggregateMediator.getCompletionMaxMessagesType());
			}
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue)) {
				basePart.setCompletionMinMessagesValue(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, aggregateMediator.getCompletionMinMessagesValue()));
			}
			
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue)) {
				basePart.setCompletionMaxMessagesValue(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, aggregateMediator.getCompletionMaxMessagesValue()));
			}
			
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.sequenceType)) {
				basePart.initSequenceType(EEFUtils.choiceOfValues(aggregateMediator, EsbPackage.eINSTANCE.getAggregateMediator_SequenceType()), aggregateMediator.getSequenceType());
			}
			if (isAccessible(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty))
				basePart.setEnclosingElementProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aggregateMediator.getEnclosingElementProperty()));
			
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
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.aggregateID) {
			return EsbPackage.eINSTANCE.getAggregateMediator_AggregateID();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.completionTimeout) {
			return EsbPackage.eINSTANCE.getAggregateMediator_CompletionTimeout();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType) {
			return EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesType();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType) {
			return EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesType();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue) {
			return EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesValue();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue) {
			return EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesValue();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.sequenceType) {
			return EsbPackage.eINSTANCE.getAggregateMediator_SequenceType();
		}
		if (editorKey == EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty) {
			return EsbPackage.eINSTANCE.getAggregateMediator_EnclosingElementProperty();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		AggregateMediator aggregateMediator = (AggregateMediator)semanticObject;
		if (EsbViewsRepository.AggregateMediator.Properties.description == event.getAffectedEditor()) {
			aggregateMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AggregateMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				aggregateMediator.getCommentsList().clear();
				aggregateMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.AggregateMediator.Properties.reverse == event.getAffectedEditor()) {
			aggregateMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AggregateMediator.Properties.aggregateID == event.getAffectedEditor()) {
			aggregateMediator.setAggregateID((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AggregateMediator.Properties.completionTimeout == event.getAffectedEditor()) {
			aggregateMediator.setCompletionTimeout((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType == event.getAffectedEditor()) {
			aggregateMediator.setCompletionMinMessagesType((CompletionMessagesType)event.getNewValue());
		}
		if (EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType == event.getAffectedEditor()) {
			aggregateMediator.setCompletionMaxMessagesType((CompletionMessagesType)event.getNewValue());
		}
		if (EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue == event.getAffectedEditor()) {
			aggregateMediator.setCompletionMinMessagesValue((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue == event.getAffectedEditor()) {
			aggregateMediator.setCompletionMaxMessagesValue((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.AggregateMediator.Properties.sequenceType == event.getAffectedEditor()) {
			aggregateMediator.setSequenceType((AggregateSequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty == event.getAffectedEditor()) {
			aggregateMediator.setEnclosingElementProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			AggregateMediatorPropertiesEditionPart basePart = (AggregateMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AggregateMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AggregateMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AggregateMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAggregateMediator_AggregateID().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AggregateMediator.Properties.aggregateID)) {
				if (msg.getNewValue() != null) {
					basePart.setAggregateID(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAggregateID("");
				}
			}
			if (EsbPackage.eINSTANCE.getAggregateMediator_CompletionTimeout().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionTimeout)) {
				if (msg.getNewValue() != null) {
					basePart.setCompletionTimeout(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setCompletionTimeout("");
				}
			}
			if (EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType))
				basePart.setCompletionMinMessagesType((CompletionMessagesType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType))
				basePart.setCompletionMaxMessagesType((CompletionMessagesType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue)) {
				if (msg.getNewValue() != null) {
					basePart.setCompletionMinMessagesValue(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setCompletionMinMessagesValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue)) {
				if (msg.getNewValue() != null) {
					basePart.setCompletionMaxMessagesValue(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setCompletionMaxMessagesValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getAggregateMediator_SequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AggregateMediator.Properties.sequenceType))
				basePart.setSequenceType((AggregateSequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAggregateMediator_EnclosingElementProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setEnclosingElementProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEnclosingElementProperty("");
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
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getMediator_Reverse(),
			EsbPackage.eINSTANCE.getAggregateMediator_AggregateID(),
			EsbPackage.eINSTANCE.getAggregateMediator_CompletionTimeout(),
			EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesType(),
			EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesType(),
			EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesValue(),
			EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesValue(),
			EsbPackage.eINSTANCE.getAggregateMediator_SequenceType(),
			EsbPackage.eINSTANCE.getAggregateMediator_EnclosingElementProperty()		);
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
				if (EsbViewsRepository.AggregateMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.AggregateMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.aggregateID == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAggregateMediator_AggregateID().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAggregateMediator_AggregateID().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.completionTimeout == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAggregateMediator_CompletionTimeout().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAggregateMediator_CompletionTimeout().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAggregateMediator_CompletionMinMessagesValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAggregateMediator_CompletionMaxMessagesValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.sequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAggregateMediator_SequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAggregateMediator_SequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAggregateMediator_EnclosingElementProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAggregateMediator_EnclosingElementProperty().getEAttributeType(), newValue);
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
