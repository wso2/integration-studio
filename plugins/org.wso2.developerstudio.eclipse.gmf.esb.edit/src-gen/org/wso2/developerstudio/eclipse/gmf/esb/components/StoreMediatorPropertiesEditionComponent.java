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
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediatorSpecifyType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class StoreMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public StoreMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject storeMediator, String editing_mode) {
		super(editingContext, storeMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.StoreMediator.class;
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
			
			final StoreMediator storeMediator = (StoreMediator)elt;
			final StoreMediatorPropertiesEditionPart basePart = (StoreMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.StoreMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, storeMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.StoreMediator.Properties.commentsList))
				basePart.setCommentsList(storeMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.StoreMediator.Properties.reverse)) {
				basePart.setReverse(storeMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.StoreMediator.Properties.messageStore))
				basePart.setMessageStore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, storeMediator.getMessageStore()));
			
			if (isAccessible(EsbViewsRepository.StoreMediator.Properties.availableMessageStores))
				basePart.setAvailableMessageStores(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, storeMediator.getAvailableMessageStores()));
			
			if (isAccessible(EsbViewsRepository.StoreMediator.Properties.specifyAs)) {
				basePart.initSpecifyAs(EEFUtils.choiceOfValues(storeMediator, EsbPackage.eINSTANCE.getStoreMediator_SpecifyAs()), storeMediator.getSpecifyAs());
			}
			// Start of user code  for onStoreSequence command update
			if (isAccessible(EsbViewsRepository.StoreMediator.Properties.onStoreSequence)) {
                basePart.setOnStoreSequence(storeMediator.getOnStoreSequence());
            }
			// End of user code
			
			// Start of user code  for expression command update
			if (isAccessible(EsbViewsRepository.StoreMediator.Properties.expression)) {
                basePart.setExpression(storeMediator.getExpression());
            }
			// End of user code
			
			// init filters
			
			
			
			
			
			
			// Start of user code  for onStoreSequence filter update
			// End of user code
			
			// Start of user code  for expression filter update
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
		if (editorKey == EsbViewsRepository.StoreMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.StoreMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.StoreMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.StoreMediator.Properties.messageStore) {
			return EsbPackage.eINSTANCE.getStoreMediator_MessageStore();
		}
		if (editorKey == EsbViewsRepository.StoreMediator.Properties.availableMessageStores) {
			return EsbPackage.eINSTANCE.getStoreMediator_AvailableMessageStores();
		}
		if (editorKey == EsbViewsRepository.StoreMediator.Properties.specifyAs) {
			return EsbPackage.eINSTANCE.getStoreMediator_SpecifyAs();
		}
		if (editorKey == EsbViewsRepository.StoreMediator.Properties.onStoreSequence) {
			return EsbPackage.eINSTANCE.getStoreMediator_OnStoreSequence();
		}
		if (editorKey == EsbViewsRepository.StoreMediator.Properties.expression) {
			return EsbPackage.eINSTANCE.getStoreMediator_Expression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		StoreMediator storeMediator = (StoreMediator)semanticObject;
		if (EsbViewsRepository.StoreMediator.Properties.description == event.getAffectedEditor()) {
			storeMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.StoreMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				storeMediator.getCommentsList().clear();
				storeMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.StoreMediator.Properties.reverse == event.getAffectedEditor()) {
			storeMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.StoreMediator.Properties.messageStore == event.getAffectedEditor()) {
			storeMediator.setMessageStore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.StoreMediator.Properties.availableMessageStores == event.getAffectedEditor()) {
			storeMediator.setAvailableMessageStores((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.StoreMediator.Properties.specifyAs == event.getAffectedEditor()) {
			storeMediator.setSpecifyAs((StoreMediatorSpecifyType)event.getNewValue());
		}
		if (EsbViewsRepository.StoreMediator.Properties.onStoreSequence == event.getAffectedEditor()) {
			// Start of user code for updateOnStoreSequence method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                storeMediator.setOnStoreSequence(rkp);
            } else {
                storeMediator.setOnStoreSequence(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.StoreMediator.Properties.expression == event.getAffectedEditor()) {
			// Start of user code for updateExpression method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                storeMediator.setExpression(nsp);
            } else {
                storeMediator.setExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			StoreMediatorPropertiesEditionPart basePart = (StoreMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.StoreMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.StoreMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.StoreMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getStoreMediator_MessageStore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.StoreMediator.Properties.messageStore)) {
				if (msg.getNewValue() != null) {
					basePart.setMessageStore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setMessageStore("");
				}
			}
			if (EsbPackage.eINSTANCE.getStoreMediator_AvailableMessageStores().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.StoreMediator.Properties.availableMessageStores)) {
				if (msg.getNewValue() != null) {
					basePart.setAvailableMessageStores(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAvailableMessageStores("");
				}
			}
			if (EsbPackage.eINSTANCE.getStoreMediator_SpecifyAs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.StoreMediator.Properties.specifyAs))
				basePart.setSpecifyAs((StoreMediatorSpecifyType)msg.getNewValue());

            // Start of user code for onStoreSequence live update
            if (EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.StoreMediator.Properties.onStoreSequence)) {
                if (msg.getNewValue() != null) {
                    basePart.setOnStoreSequence((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setOnStoreSequence(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }

            // End of user code

            // Start of user code for expression live update
            if (EsbPackage.eINSTANCE.getStoreMediator_Expression().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.StoreMediator.Properties.expression)) {
                if (msg.getNewValue() != null) {
                    basePart.setExpression((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getStoreMediator_MessageStore(),
			EsbPackage.eINSTANCE.getStoreMediator_AvailableMessageStores(),
			EsbPackage.eINSTANCE.getStoreMediator_SpecifyAs(),
			EsbPackage.eINSTANCE.getStoreMediator_OnStoreSequence(),
			EsbPackage.eINSTANCE.getStoreMediator_Expression()		);
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
				if (EsbViewsRepository.StoreMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.StoreMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.StoreMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.StoreMediator.Properties.messageStore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getStoreMediator_MessageStore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getStoreMediator_MessageStore().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.StoreMediator.Properties.availableMessageStores == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getStoreMediator_AvailableMessageStores().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getStoreMediator_AvailableMessageStores().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.StoreMediator.Properties.specifyAs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getStoreMediator_SpecifyAs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getStoreMediator_SpecifyAs().getEAttributeType(), newValue);
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
