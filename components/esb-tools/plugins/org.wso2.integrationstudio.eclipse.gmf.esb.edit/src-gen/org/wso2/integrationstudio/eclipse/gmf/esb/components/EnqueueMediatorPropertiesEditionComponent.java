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

import org.wso2.integrationstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

// End of user code

/**
 * 
 * 
 */
public class EnqueueMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public EnqueueMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject enqueueMediator, String editing_mode) {
		super(editingContext, enqueueMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.EnqueueMediator.class;
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
			
			final EnqueueMediator enqueueMediator = (EnqueueMediator)elt;
			final EnqueueMediatorPropertiesEditionPart basePart = (EnqueueMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.EnqueueMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enqueueMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.EnqueueMediator.Properties.commentsList))
				basePart.setCommentsList(enqueueMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.EnqueueMediator.Properties.reverse)) {
				basePart.setReverse(enqueueMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.EnqueueMediator.Properties.executor))
				basePart.setExecutor(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, enqueueMediator.getExecutor()));
			
			if (isAccessible(EsbViewsRepository.EnqueueMediator.Properties.priority)) {
				basePart.setPriority(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, enqueueMediator.getPriority()));
			}
			
			// Start of user code  for sequenceKey command update
			if (isAccessible(EsbViewsRepository.EnqueueMediator.Properties.sequenceKey)) {
                basePart.setSequenceKey(enqueueMediator.getSequenceKey());
            }
			// End of user code
			
			// init filters
			
			
			
			
			
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
		if (editorKey == EsbViewsRepository.EnqueueMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.EnqueueMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.EnqueueMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.EnqueueMediator.Properties.executor) {
			return EsbPackage.eINSTANCE.getEnqueueMediator_Executor();
		}
		if (editorKey == EsbViewsRepository.EnqueueMediator.Properties.priority) {
			return EsbPackage.eINSTANCE.getEnqueueMediator_Priority();
		}
		if (editorKey == EsbViewsRepository.EnqueueMediator.Properties.sequenceKey) {
			return EsbPackage.eINSTANCE.getEnqueueMediator_SequenceKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EnqueueMediator enqueueMediator = (EnqueueMediator)semanticObject;
		if (EsbViewsRepository.EnqueueMediator.Properties.description == event.getAffectedEditor()) {
			enqueueMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnqueueMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				enqueueMediator.getCommentsList().clear();
				enqueueMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.EnqueueMediator.Properties.reverse == event.getAffectedEditor()) {
			enqueueMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.EnqueueMediator.Properties.executor == event.getAffectedEditor()) {
			enqueueMediator.setExecutor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EnqueueMediator.Properties.priority == event.getAffectedEditor()) {
			enqueueMediator.setPriority((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.EnqueueMediator.Properties.sequenceKey == event.getAffectedEditor()) {
			// Start of user code for updateSequenceKey method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                enqueueMediator.setSequenceKey(rkp);
            } else {
                enqueueMediator.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EnqueueMediatorPropertiesEditionPart basePart = (EnqueueMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnqueueMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnqueueMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnqueueMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEnqueueMediator_Executor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnqueueMediator.Properties.executor)) {
				if (msg.getNewValue() != null) {
					basePart.setExecutor(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setExecutor("");
				}
			}
			if (EsbPackage.eINSTANCE.getEnqueueMediator_Priority().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EnqueueMediator.Properties.priority)) {
				if (msg.getNewValue() != null) {
					basePart.setPriority(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPriority("");
				}
			}
					// Start of user code for sequenceKey live update
			 if (EsbPackage.eINSTANCE.getEnqueueMediator_SequenceKey().equals(msg.getFeature())
	                    && msg.getNotifier().equals(semanticObject)
	                    && isAccessible(EsbViewsRepository.EnqueueMediator.Properties.sequenceKey)) {
	                if (msg.getNewValue() != null) {
	                    basePart.setSequenceKey((RegistryKeyProperty) msg.getNewValue());
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
			EsbPackage.eINSTANCE.getEnqueueMediator_Executor(),
			EsbPackage.eINSTANCE.getEnqueueMediator_Priority(),
			EsbPackage.eINSTANCE.getEnqueueMediator_SequenceKey()		);
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
				if (EsbViewsRepository.EnqueueMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnqueueMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.EnqueueMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnqueueMediator.Properties.executor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnqueueMediator_Executor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnqueueMediator_Executor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EnqueueMediator.Properties.priority == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEnqueueMediator_Priority().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEnqueueMediator_Priority().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

    // Start of user code for help compatibility

    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }

    // End of user code
	

	

}
