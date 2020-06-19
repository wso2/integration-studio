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

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class PayloadFactoryMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for args ReferencesTable
	 */
	protected ReferencesTableSettings argsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public PayloadFactoryMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject payloadFactoryMediator, String editing_mode) {
		super(editingContext, payloadFactoryMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.PayloadFactoryMediator.class;
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
			
			final PayloadFactoryMediator payloadFactoryMediator = (PayloadFactoryMediator)elt;
			final PayloadFactoryMediatorPropertiesEditionPart basePart = (PayloadFactoryMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat)) {
				basePart.initPayloadFormat(EEFUtils.choiceOfValues(payloadFactoryMediator, EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadFormat()), payloadFactoryMediator.getPayloadFormat());
			}
			// Start of user code  for payloadKey command update
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey)) {
				basePart.setPayloadKey(payloadFactoryMediator.getPayloadKey());
			}
			// End of user code
			
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.payload))
				basePart.setPayload(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, payloadFactoryMediator.getPayload()));
			
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.args)) {
				argsSettings = new ReferencesTableSettings(payloadFactoryMediator, EsbPackage.eINSTANCE.getPayloadFactoryMediator_Args());
				basePart.initArgs(argsSettings);
			}
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType)) {
				basePart.initMediaType(EEFUtils.choiceOfValues(payloadFactoryMediator, EsbPackage.eINSTANCE.getPayloadFactoryMediator_MediaType()), payloadFactoryMediator.getMediaType());
			}
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, payloadFactoryMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList))
				basePart.setCommentsList(payloadFactoryMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse)) {
				basePart.setReverse(payloadFactoryMediator.isReverse());
			}
			// init filters
			
			// Start of user code  for payloadKey filter update
			// End of user code
			
			
			if (isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.args)) {
				basePart.addFilterToArgs(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof PayloadFactoryArgument); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for args
				// End of user code
			}
			
			
			
			
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
		if (editorKey == EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat) {
			return EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadFormat();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey) {
			return EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadKey();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryMediator.Properties.payload) {
			return EsbPackage.eINSTANCE.getPayloadFactoryMediator_Payload();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryMediator.Properties.args) {
			return EsbPackage.eINSTANCE.getPayloadFactoryMediator_Args();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType) {
			return EsbPackage.eINSTANCE.getPayloadFactoryMediator_MediaType();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.PayloadFactoryMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		PayloadFactoryMediator payloadFactoryMediator = (PayloadFactoryMediator)semanticObject;
		if (EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat == event.getAffectedEditor()) {
			payloadFactoryMediator.setPayloadFormat((PayloadFormatType)event.getNewValue());
		}
		if (EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey == event.getAffectedEditor()) {
			// Start of user code for updatePayloadKey method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				payloadFactoryMediator.setPayloadKey(rkp);
			} else {
				payloadFactoryMediator.setPayloadKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.PayloadFactoryMediator.Properties.payload == event.getAffectedEditor()) {
			payloadFactoryMediator.setPayload((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PayloadFactoryMediator.Properties.args == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, argsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				argsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				argsSettings.move(event.getNewIndex(), (PayloadFactoryArgument) event.getNewValue());
			}
		}
		if (EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType == event.getAffectedEditor()) {
			payloadFactoryMediator.setMediaType((MediaType)event.getNewValue());
		}
		if (EsbViewsRepository.PayloadFactoryMediator.Properties.description == event.getAffectedEditor()) {
			payloadFactoryMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				payloadFactoryMediator.getCommentsList().clear();
				payloadFactoryMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.PayloadFactoryMediator.Properties.reverse == event.getAffectedEditor()) {
			payloadFactoryMediator.setReverse((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			PayloadFactoryMediatorPropertiesEditionPart basePart = (PayloadFactoryMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadFormat().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat))
				basePart.setPayloadFormat((PayloadFormatType)msg.getNewValue());
			
					// Start of user code for payloadKey live update
			if (EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadKey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey)) {
				if (msg.getNewValue() != null) {
					basePart.setPayloadKey((RegistryKeyProperty)msg.getNewValue());
				} else {
					basePart.setPayloadKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
			if (EsbPackage.eINSTANCE.getPayloadFactoryMediator_Payload().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.payload)) {
				if (msg.getNewValue() != null) {
					basePart.setPayload(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPayload("");
				}
			}
			if (EsbPackage.eINSTANCE.getPayloadFactoryMediator_Args().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.args))
				basePart.updateArgs();
			if (EsbPackage.eINSTANCE.getPayloadFactoryMediator_MediaType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType))
				basePart.setMediaType((MediaType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadFormat(),
			EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadKey(),
			EsbPackage.eINSTANCE.getPayloadFactoryMediator_Payload(),
			EsbPackage.eINSTANCE.getPayloadFactoryMediator_Args(),
			EsbPackage.eINSTANCE.getPayloadFactoryMediator_MediaType(),
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getMediator_Reverse()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
//		if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.args)
//			return "Arguments"; //$NON-NLS-1$
//		return super.getHelpContent(key, kind);
		return EEFPropertyViewUtil.getHelpContent(key);
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
				if (EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadFormat().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPayloadFactoryMediator_PayloadFormat().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PayloadFactoryMediator.Properties.payload == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPayloadFactoryMediator_Payload().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPayloadFactoryMediator_Payload().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPayloadFactoryMediator_MediaType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPayloadFactoryMediator_MediaType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PayloadFactoryMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.PayloadFactoryMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
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
