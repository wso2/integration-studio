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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class ForEachMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public ForEachMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject forEachMediator, String editing_mode) {
		super(editingContext, forEachMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ForEachMediator.class;
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
			
			final ForEachMediator forEachMediator = (ForEachMediator)elt;
			final ForEachMediatorPropertiesEditionPart basePart = (ForEachMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ForEachMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, forEachMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.ForEachMediator.Properties.commentsList))
				basePart.setCommentsList(forEachMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.ForEachMediator.Properties.reverse)) {
				basePart.setReverse(forEachMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.ForEachMediator.Properties.forEachID))
				basePart.setForEachID(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, forEachMediator.getForEachID()));
			
			if (isAccessible(EsbViewsRepository.ForEachMediator.Sequence.sequenceType)) {
				basePart.initSequenceType(EEFUtils.choiceOfValues(forEachMediator, EsbPackage.eINSTANCE.getForEachMediator_SequenceType()), forEachMediator.getSequenceType());
			}
			if (isAccessible(EsbViewsRepository.ForEachMediator.Sequence.sequenceName))
				basePart.setSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, forEachMediator.getSequenceName()));
			
			// Start of user code  for forEachExpression command update
            if (isAccessible(EsbViewsRepository.ForEachMediator.Properties.forEachExpression)) {
                basePart.setForEachExpression(forEachMediator.getForEachExpression());
            }
			// End of user code
			
			// Start of user code  for sequenceKey command update
            if (isAccessible(EsbViewsRepository.ForEachMediator.Sequence.sequenceKey)) {
                basePart.setSequenceKey(forEachMediator.getSequenceKey());
            }
			// End of user code
			
			// init filters
			
			
			
			
			
			
			// Start of user code  for forEachExpression filter update
			// End of user code
			
			// Start of user code  for sequenceKey filter update
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
		if (editorKey == EsbViewsRepository.ForEachMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.ForEachMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.ForEachMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.ForEachMediator.Properties.forEachID) {
			return EsbPackage.eINSTANCE.getForEachMediator_ForEachID();
		}
		if (editorKey == EsbViewsRepository.ForEachMediator.Sequence.sequenceType) {
			return EsbPackage.eINSTANCE.getForEachMediator_SequenceType();
		}
		if (editorKey == EsbViewsRepository.ForEachMediator.Sequence.sequenceName) {
			return EsbPackage.eINSTANCE.getForEachMediator_SequenceName();
		}
		if (editorKey == EsbViewsRepository.ForEachMediator.Properties.forEachExpression) {
			return EsbPackage.eINSTANCE.getForEachMediator_ForEachExpression();
		}
		if (editorKey == EsbViewsRepository.ForEachMediator.Sequence.sequenceKey) {
			return EsbPackage.eINSTANCE.getForEachMediator_SequenceKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ForEachMediator forEachMediator = (ForEachMediator)semanticObject;
		if (EsbViewsRepository.ForEachMediator.Properties.description == event.getAffectedEditor()) {
			forEachMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ForEachMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				forEachMediator.getCommentsList().clear();
				forEachMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.ForEachMediator.Properties.reverse == event.getAffectedEditor()) {
			forEachMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ForEachMediator.Properties.forEachID == event.getAffectedEditor()) {
			forEachMediator.setForEachID((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ForEachMediator.Sequence.sequenceType == event.getAffectedEditor()) {
			forEachMediator.setSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.ForEachMediator.Sequence.sequenceName == event.getAffectedEditor()) {
			forEachMediator.setSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ForEachMediator.Properties.forEachExpression == event.getAffectedEditor()) {
			// Start of user code for updateForEachExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                forEachMediator.setForEachExpression(nsp);
            } else {
                forEachMediator.setForEachExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.ForEachMediator.Sequence.sequenceKey == event.getAffectedEditor()) {
			// Start of user code for updateSequenceKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                forEachMediator.setSequenceKey(rkp);
            } else {
                forEachMediator.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			ForEachMediatorPropertiesEditionPart basePart = (ForEachMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getForEachMediator_ForEachID().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachMediator.Properties.forEachID)) {
				if (msg.getNewValue() != null) {
					basePart.setForEachID(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setForEachID("");
				}
			}
			if (EsbPackage.eINSTANCE.getForEachMediator_SequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ForEachMediator.Sequence.sequenceType))
				basePart.setSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getForEachMediator_SequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachMediator.Sequence.sequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSequenceName("");
				}
			}
					// Start of user code for forEachExpression live update
	           if (EsbPackage.eINSTANCE.getForEachMediator_ForEachExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachMediator.Properties.forEachExpression)) {
	               if (msg.getNewValue() != null) {
	                   basePart.setForEachExpression((NamespacedProperty)msg.getNewValue());
	               } else {
	                   basePart.setForEachExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
	               }
	           }    	
					// End of user code
			
					// Start of user code for sequenceKey live update
	           if (EsbPackage.eINSTANCE.getForEachMediator_SequenceKey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachMediator.Sequence.sequenceKey)) {
	               if (msg.getNewValue() != null) {
	                   basePart.setSequenceKey((RegistryKeyProperty)msg.getNewValue());
	               } else {
	                   basePart.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getForEachMediator_ForEachID(),
			EsbPackage.eINSTANCE.getForEachMediator_SequenceType(),
			EsbPackage.eINSTANCE.getForEachMediator_SequenceName(),
			EsbPackage.eINSTANCE.getForEachMediator_ForEachExpression(),
			EsbPackage.eINSTANCE.getForEachMediator_SequenceKey()		);
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
				if (EsbViewsRepository.ForEachMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ForEachMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.ForEachMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ForEachMediator.Properties.forEachID == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getForEachMediator_ForEachID().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getForEachMediator_ForEachID().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ForEachMediator.Sequence.sequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getForEachMediator_SequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getForEachMediator_SequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ForEachMediator.Sequence.sequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getForEachMediator_SequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getForEachMediator_SequenceName().getEAttributeType(), newValue);
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
