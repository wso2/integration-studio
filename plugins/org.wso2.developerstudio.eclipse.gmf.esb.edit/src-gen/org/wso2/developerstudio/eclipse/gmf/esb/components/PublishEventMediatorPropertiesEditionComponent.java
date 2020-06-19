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

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class PublishEventMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for metaAttributes ReferencesTable
	 */
	protected ReferencesTableSettings metaAttributesSettings;
	
	/**
	 * Settings for correlationAttributes ReferencesTable
	 */
	protected ReferencesTableSettings correlationAttributesSettings;
	
	/**
	 * Settings for payloadAttributes ReferencesTable
	 */
	protected ReferencesTableSettings payloadAttributesSettings;
	
	/**
	 * Settings for arbitraryAttributes ReferencesTable
	 */
	protected ReferencesTableSettings arbitraryAttributesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public PublishEventMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject publishEventMediator, String editing_mode) {
		super(editingContext, publishEventMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.PublishEventMediator.class;
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
			
			final PublishEventMediator publishEventMediator = (PublishEventMediator)elt;
			final PublishEventMediatorPropertiesEditionPart basePart = (PublishEventMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, publishEventMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.commentsList))
				basePart.setCommentsList(publishEventMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.reverse)) {
				basePart.setReverse(publishEventMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.streamName))
				basePart.setStreamName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, publishEventMediator.getStreamName()));
			
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.streamVersion))
				basePart.setStreamVersion(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, publishEventMediator.getStreamVersion()));
			
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.eventSink))
				basePart.setEventSink(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, publishEventMediator.getEventSink()));
			
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.metaAttributes)) {
				metaAttributesSettings = new ReferencesTableSettings(publishEventMediator, EsbPackage.eINSTANCE.getPublishEventMediator_MetaAttributes());
				basePart.initMetaAttributes(metaAttributesSettings);
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes)) {
				correlationAttributesSettings = new ReferencesTableSettings(publishEventMediator, EsbPackage.eINSTANCE.getPublishEventMediator_CorrelationAttributes());
				basePart.initCorrelationAttributes(correlationAttributesSettings);
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes)) {
				payloadAttributesSettings = new ReferencesTableSettings(publishEventMediator, EsbPackage.eINSTANCE.getPublishEventMediator_PayloadAttributes());
				basePart.initPayloadAttributes(payloadAttributesSettings);
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes)) {
				arbitraryAttributesSettings = new ReferencesTableSettings(publishEventMediator, EsbPackage.eINSTANCE.getPublishEventMediator_ArbitraryAttributes());
				basePart.initArbitraryAttributes(arbitraryAttributesSettings);
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.async)) {
				basePart.setAsync(publishEventMediator.isAsync());
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout))
				basePart.setAsyncTimeout(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, publishEventMediator.getAsyncTimeout()));
			
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.metaAttributes)) {
				basePart.addFilterToMetaAttributes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof PublishEventMediatorAttribute); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for metaAttributes
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes)) {
				basePart.addFilterToCorrelationAttributes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof PublishEventMediatorAttribute); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for correlationAttributes
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes)) {
				basePart.addFilterToPayloadAttributes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof PublishEventMediatorAttribute); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for payloadAttributes
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes)) {
				basePart.addFilterToArbitraryAttributes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof PublishEventMediatorAttribute); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for arbitraryAttributes
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
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.streamName) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_StreamName();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.streamVersion) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_StreamVersion();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.eventSink) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_EventSink();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.metaAttributes) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_MetaAttributes();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_CorrelationAttributes();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_PayloadAttributes();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_ArbitraryAttributes();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.async) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_Async();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout) {
			return EsbPackage.eINSTANCE.getPublishEventMediator_AsyncTimeout();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		PublishEventMediator publishEventMediator = (PublishEventMediator)semanticObject;
		if (EsbViewsRepository.PublishEventMediator.Properties.description == event.getAffectedEditor()) {
			publishEventMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				publishEventMediator.getCommentsList().clear();
				publishEventMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.reverse == event.getAffectedEditor()) {
			publishEventMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.streamName == event.getAffectedEditor()) {
			publishEventMediator.setStreamName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.streamVersion == event.getAffectedEditor()) {
			publishEventMediator.setStreamVersion((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.eventSink == event.getAffectedEditor()) {
			publishEventMediator.setEventSink((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.metaAttributes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, metaAttributesSettings, editingContext.getAdapterFactory());
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
				metaAttributesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				metaAttributesSettings.move(event.getNewIndex(), (PublishEventMediatorAttribute) event.getNewValue());
			}
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, correlationAttributesSettings, editingContext.getAdapterFactory());
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
				correlationAttributesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				correlationAttributesSettings.move(event.getNewIndex(), (PublishEventMediatorAttribute) event.getNewValue());
			}
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, payloadAttributesSettings, editingContext.getAdapterFactory());
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
				payloadAttributesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				payloadAttributesSettings.move(event.getNewIndex(), (PublishEventMediatorAttribute) event.getNewValue());
			}
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, arbitraryAttributesSettings, editingContext.getAdapterFactory());
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
				arbitraryAttributesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				arbitraryAttributesSettings.move(event.getNewIndex(), (PublishEventMediatorAttribute) event.getNewValue());
			}
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.async == event.getAffectedEditor()) {
			publishEventMediator.setAsync((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout == event.getAffectedEditor()) {
			publishEventMediator.setAsyncTimeout((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			PublishEventMediatorPropertiesEditionPart basePart = (PublishEventMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPublishEventMediator_StreamName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.streamName)) {
				if (msg.getNewValue() != null) {
					basePart.setStreamName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setStreamName("");
				}
			}
			if (EsbPackage.eINSTANCE.getPublishEventMediator_StreamVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.streamVersion)) {
				if (msg.getNewValue() != null) {
					basePart.setStreamVersion(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setStreamVersion("");
				}
			}
			if (EsbPackage.eINSTANCE.getPublishEventMediator_EventSink().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.eventSink)) {
				if (msg.getNewValue() != null) {
					basePart.setEventSink(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEventSink("");
				}
			}
			if (EsbPackage.eINSTANCE.getPublishEventMediator_MetaAttributes().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.metaAttributes))
				basePart.updateMetaAttributes();
			if (EsbPackage.eINSTANCE.getPublishEventMediator_CorrelationAttributes().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes))
				basePart.updateCorrelationAttributes();
			if (EsbPackage.eINSTANCE.getPublishEventMediator_PayloadAttributes().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes))
				basePart.updatePayloadAttributes();
			if (EsbPackage.eINSTANCE.getPublishEventMediator_ArbitraryAttributes().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes))
				basePart.updateArbitraryAttributes();
			if (EsbPackage.eINSTANCE.getPublishEventMediator_Async().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.async))
				basePart.setAsync((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPublishEventMediator_AsyncTimeout().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout)) {
				if (msg.getNewValue() != null) {
					basePart.setAsyncTimeout(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAsyncTimeout("");
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
			EsbPackage.eINSTANCE.getPublishEventMediator_StreamName(),
			EsbPackage.eINSTANCE.getPublishEventMediator_StreamVersion(),
			EsbPackage.eINSTANCE.getPublishEventMediator_EventSink(),
			EsbPackage.eINSTANCE.getPublishEventMediator_MetaAttributes(),
			EsbPackage.eINSTANCE.getPublishEventMediator_CorrelationAttributes(),
			EsbPackage.eINSTANCE.getPublishEventMediator_PayloadAttributes(),
			EsbPackage.eINSTANCE.getPublishEventMediator_ArbitraryAttributes(),
			EsbPackage.eINSTANCE.getPublishEventMediator_Async(),
			EsbPackage.eINSTANCE.getPublishEventMediator_AsyncTimeout()		);
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
				if (EsbViewsRepository.PublishEventMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.PublishEventMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediator.Properties.streamName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPublishEventMediator_StreamName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPublishEventMediator_StreamName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediator.Properties.streamVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPublishEventMediator_StreamVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPublishEventMediator_StreamVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediator.Properties.eventSink == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPublishEventMediator_EventSink().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPublishEventMediator_EventSink().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediator.Properties.async == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPublishEventMediator_Async().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPublishEventMediator_Async().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPublishEventMediator_AsyncTimeout().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPublishEventMediator_AsyncTimeout().getEAttributeType(), newValue);
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
