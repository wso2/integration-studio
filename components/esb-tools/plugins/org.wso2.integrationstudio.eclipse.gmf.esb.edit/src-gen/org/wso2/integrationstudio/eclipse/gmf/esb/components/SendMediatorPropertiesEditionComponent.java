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

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.ReceivingSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

// End of user code

/**
 * 
 * 
 */
public class SendMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for EndPoint ReferencesTable
	 */
	private ReferencesTableSettings endPointSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SendMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject sendMediator, String editing_mode) {
		super(editingContext, sendMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.SendMediator.class;
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
			
			final SendMediator sendMediator = (SendMediator)elt;
			final SendMediatorPropertiesEditionPart basePart = (SendMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.skipSerialization)) {
				basePart.setSkipSerialization(sendMediator.isSkipSerialization());
			}
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.endPoint)) {
				endPointSettings = new ReferencesTableSettings(sendMediator, EsbPackage.eINSTANCE.getSendMediator_EndPoint());
				basePart.initEndPoint(endPointSettings);
			}
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.receivingSequenceType)) {
				basePart.initReceivingSequenceType(EEFUtils.choiceOfValues(sendMediator, EsbPackage.eINSTANCE.getSendMediator_ReceivingSequenceType()), sendMediator.getReceivingSequenceType());
			}
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending)) {
				basePart.setBuildMessageBeforeSending(sendMediator.isBuildMessageBeforeSending());
			}
			// Start of user code for StaticReceivingSequence command update
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.staticReceivingSequence)) {
				basePart.setStaticReceivingSequence(sendMediator.getStaticReceivingSequence());
			}
			// End of user code
			
			// Start of user code for DynamicReceivingSequence command update
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.receivingSequenceType)) {
				basePart.setDynamicReceivingSequence(sendMediator.getDynamicReceivingSequence());
			}
			// End of user code
			
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sendMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.commentsList))
				basePart.setCommentsList(sendMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.reverse)) {
				basePart.setReverse(sendMediator.isReverse());
			}
			// init filters
			
			if (isAccessible(EsbViewsRepository.SendMediator.Properties.endPoint)) {
				basePart.addFilterToEndPoint(new EObjectFilter(EsbPackage.Literals.END_POINT));
				// Start of user code for additional businessfilters for EndPoint
				// End of user code
			}
			
			
			// Start of user code for StaticReceivingSequence filter update
			// End of user code
			
			// Start of user code for DynamicReceivingSequence filter update
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
		if (editorKey == EsbViewsRepository.SendMediator.Properties.skipSerialization) {
			return EsbPackage.eINSTANCE.getSendMediator_SkipSerialization();
		}
		if (editorKey == EsbViewsRepository.SendMediator.Properties.endPoint) {
			return EsbPackage.eINSTANCE.getSendMediator_EndPoint();
		}
		if (editorKey == EsbViewsRepository.SendMediator.Properties.receivingSequenceType) {
			return EsbPackage.eINSTANCE.getSendMediator_ReceivingSequenceType();
		}
		if (editorKey == EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending) {
			return EsbPackage.eINSTANCE.getSendMediator_BuildMessageBeforeSending();
		}
		if (editorKey == EsbViewsRepository.SendMediator.Properties.staticReceivingSequence) {
			return EsbPackage.eINSTANCE.getSendMediator_StaticReceivingSequence();
		}
		if (editorKey == EsbViewsRepository.SendMediator.Properties.dynamicReceivingSequence) {
			return EsbPackage.eINSTANCE.getSendMediator_DynamicReceivingSequence();
		}
		if (editorKey == EsbViewsRepository.SendMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.SendMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.SendMediator.Properties.reverse) {
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
		SendMediator sendMediator = (SendMediator)semanticObject;
		if (EsbViewsRepository.SendMediator.Properties.skipSerialization == event.getAffectedEditor()) {
			sendMediator.setSkipSerialization((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.SendMediator.Properties.endPoint == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof EndPoint) {
					endPointSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				endPointSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				endPointSettings.move(event.getNewIndex(), (EndPoint) event.getNewValue());
			}
		}
		if (EsbViewsRepository.SendMediator.Properties.receivingSequenceType == event.getAffectedEditor()) {
			sendMediator.setReceivingSequenceType((ReceivingSequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending == event.getAffectedEditor()) {
			sendMediator.setBuildMessageBeforeSending((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.SendMediator.Properties.staticReceivingSequence == event.getAffectedEditor()) {
			// Start of user code for updateStaticReceivingSequence method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				sendMediator.setStaticReceivingSequence(rkp);
			} else {
				sendMediator.setStaticReceivingSequence(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.SendMediator.Properties.dynamicReceivingSequence == event.getAffectedEditor()) {
			// Start of user code for updateDynamicReceivingSequence method body
			if (event.getNewValue() != null) {
				NamespacedProperty nspHeaderName = (NamespacedProperty) event.getNewValue();
				sendMediator.setDynamicReceivingSequence(nspHeaderName);
			} else {
				sendMediator.setDynamicReceivingSequence(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.SendMediator.Properties.description == event.getAffectedEditor()) {
			sendMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SendMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sendMediator.getCommentsList().clear();
				sendMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.SendMediator.Properties.reverse == event.getAffectedEditor()) {
			sendMediator.setReverse((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			SendMediatorPropertiesEditionPart basePart = (SendMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getSendMediator_SkipSerialization().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SendMediator.Properties.skipSerialization))
				basePart.setSkipSerialization((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSendMediator_EndPoint().equals(msg.getFeature())  && isAccessible(EsbViewsRepository.SendMediator.Properties.endPoint))
				basePart.updateEndPoint();
			if (EsbPackage.eINSTANCE.getSendMediator_ReceivingSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.SendMediator.Properties.receivingSequenceType))
				basePart.setReceivingSequenceType((ReceivingSequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSendMediator_BuildMessageBeforeSending().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending))
				basePart.setBuildMessageBeforeSending((Boolean)msg.getNewValue());
			
					// Start of user code for StaticReceivingSequence live update
			if (EsbPackage.eINSTANCE.getSendMediator_StaticReceivingSequence().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject)
					&& isAccessible(EsbViewsRepository.SendMediator.Properties.staticReceivingSequence)) {
				if (msg.getNewValue() != null) {
					basePart.setStaticReceivingSequence((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setStaticReceivingSequence(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}

			// End of user code
			
					// Start of user code for DynamicReceivingSequence live update
			if (EsbPackage.eINSTANCE.getSendMediator_DynamicReceivingSequence().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.SendMediator.Properties.dynamicReceivingSequence)) {
				if (msg.getNewValue() != null) {
					basePart.setDynamicReceivingSequence((NamespacedProperty) msg.getNewValue());
				} else {
					basePart.setDynamicReceivingSequence(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
				}
			}
			// End of user code
			
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SendMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SendMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SendMediator.Properties.reverse))
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
			EsbPackage.eINSTANCE.getSendMediator_SkipSerialization(),
			EsbPackage.eINSTANCE.getSendMediator_EndPoint(),
			EsbPackage.eINSTANCE.getSendMediator_ReceivingSequenceType(),
			EsbPackage.eINSTANCE.getSendMediator_BuildMessageBeforeSending(),
			EsbPackage.eINSTANCE.getSendMediator_StaticReceivingSequence(),
			EsbPackage.eINSTANCE.getSendMediator_DynamicReceivingSequence(),
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getMediator_Reverse()		);
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
				if (EsbViewsRepository.SendMediator.Properties.skipSerialization == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSendMediator_SkipSerialization().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSendMediator_SkipSerialization().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SendMediator.Properties.receivingSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSendMediator_ReceivingSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSendMediator_ReceivingSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSendMediator_BuildMessageBeforeSending().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSendMediator_BuildMessageBeforeSending().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SendMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SendMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.SendMediator.Properties.reverse == event.getAffectedEditor()) {
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

    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }
	

	

}
