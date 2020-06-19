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

import org.wso2.developerstudio.eclipse.gmf.esb.EnableDisableState;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorType;
import org.wso2.developerstudio.eclipse.gmf.esb.ProcessorState;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class MessageProcessorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for parameters ReferencesTable
	 */
	protected ReferencesTableSettings parametersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public MessageProcessorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject messageProcessor, String editing_mode) {
		super(editingContext, messageProcessor, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.MessageProcessor.class;
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
			
			final MessageProcessor messageProcessor = (MessageProcessor)elt;
			final MessageProcessorPropertiesEditionPart basePart = (MessageProcessorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getDescription()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.commentsList))
				basePart.setCommentsList(messageProcessor.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.processorName))
				basePart.setProcessorName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getProcessorName()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.processorType)) {
				basePart.initProcessorType(EEFUtils.choiceOfValues(messageProcessor, EsbPackage.eINSTANCE.getMessageProcessor_ProcessorType()), messageProcessor.getProcessorType());
			}
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider))
				basePart.setMessageProcessorProvider(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getMessageProcessorProvider()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.messageStore))
				basePart.setMessageStore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getMessageStore()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore))
				basePart.setSourceMessageStore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getSourceMessageStore()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.targetMessageStore))
				basePart.setTargetMessageStore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getTargetMessageStore()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.processorState)) {
				basePart.initProcessorState(EEFUtils.choiceOfValues(messageProcessor, EsbPackage.eINSTANCE.getMessageProcessor_ProcessorState()), messageProcessor.getProcessorState());
			}
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.retryInterval)) {
				basePart.setRetryInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, messageProcessor.getRetryInterval()));
			}
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.forwardingInterval)) {
				basePart.setForwardingInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, messageProcessor.getForwardingInterval()));
			}
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.samplingInterval)) {
				basePart.setSamplingInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, messageProcessor.getSamplingInterval()));
			}
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency)) {
				basePart.setSamplingConcurrency(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, messageProcessor.getSamplingConcurrency()));
			}
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts)) {
				basePart.setMaxDeliveryAttempts(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, messageProcessor.getMaxDeliveryAttempts()));
			}
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts)) {
				basePart.initDropMessageAfterMaximumDeliveryAttempts(EEFUtils.choiceOfValues(messageProcessor, EsbPackage.eINSTANCE.getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts()), messageProcessor.getDropMessageAfterMaximumDeliveryAttempts());
			}
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository))
				basePart.setAxis2ClientRepository(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getAxis2ClientRepository()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.axis2Configuration))
				basePart.setAxis2Configuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getAxis2Configuration()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath))
				basePart.setQuartzConfigFilePath(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getQuartzConfigFilePath()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.cronExpression))
				basePart.setCronExpression(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getCronExpression()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes))
				basePart.setNonRetryHttpStatusCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getNonRetryHttpStatusCodes()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.parameters)) {
				parametersSettings = new ReferencesTableSettings(messageProcessor, EsbPackage.eINSTANCE.getMessageProcessor_Parameters());
				basePart.initParameters(parametersSettings);
			}
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.taskCount))
				basePart.setTaskCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getTaskCount()));
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts)) {
				basePart.setMaxStoreConnectionAttempts(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, messageProcessor.getMaxStoreConnectionAttempts()));
			}
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval)) {
				basePart.setStoreConnectionInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, messageProcessor.getStoreConnectionInterval()));
			}
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.failMessagesStore))
				basePart.setFailMessagesStore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageProcessor.getFailMessagesStore()));
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.MessageProcessor.Properties.parameters)) {
				basePart.addFilterToParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof MessageProcessorParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for parameters
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
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.processorName) {
			return EsbPackage.eINSTANCE.getMessageProcessor_ProcessorName();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.processorType) {
			return EsbPackage.eINSTANCE.getMessageProcessor_ProcessorType();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider) {
			return EsbPackage.eINSTANCE.getMessageProcessor_MessageProcessorProvider();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.messageStore) {
			return EsbPackage.eINSTANCE.getMessageProcessor_MessageStore();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore) {
			return EsbPackage.eINSTANCE.getMessageProcessor_SourceMessageStore();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.targetMessageStore) {
			return EsbPackage.eINSTANCE.getMessageProcessor_TargetMessageStore();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.processorState) {
			return EsbPackage.eINSTANCE.getMessageProcessor_ProcessorState();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.retryInterval) {
			return EsbPackage.eINSTANCE.getMessageProcessor_RetryInterval();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.forwardingInterval) {
			return EsbPackage.eINSTANCE.getMessageProcessor_ForwardingInterval();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.samplingInterval) {
			return EsbPackage.eINSTANCE.getMessageProcessor_SamplingInterval();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency) {
			return EsbPackage.eINSTANCE.getMessageProcessor_SamplingConcurrency();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts) {
			return EsbPackage.eINSTANCE.getMessageProcessor_MaxDeliveryAttempts();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts) {
			return EsbPackage.eINSTANCE.getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository) {
			return EsbPackage.eINSTANCE.getMessageProcessor_Axis2ClientRepository();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.axis2Configuration) {
			return EsbPackage.eINSTANCE.getMessageProcessor_Axis2Configuration();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath) {
			return EsbPackage.eINSTANCE.getMessageProcessor_QuartzConfigFilePath();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.cronExpression) {
			return EsbPackage.eINSTANCE.getMessageProcessor_CronExpression();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes) {
			return EsbPackage.eINSTANCE.getMessageProcessor_NonRetryHttpStatusCodes();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.parameters) {
			return EsbPackage.eINSTANCE.getMessageProcessor_Parameters();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.taskCount) {
			return EsbPackage.eINSTANCE.getMessageProcessor_TaskCount();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts) {
			return EsbPackage.eINSTANCE.getMessageProcessor_MaxStoreConnectionAttempts();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval) {
			return EsbPackage.eINSTANCE.getMessageProcessor_StoreConnectionInterval();
		}
		if (editorKey == EsbViewsRepository.MessageProcessor.Properties.failMessagesStore) {
			return EsbPackage.eINSTANCE.getMessageProcessor_FailMessagesStore();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		MessageProcessor messageProcessor = (MessageProcessor)semanticObject;
		if (EsbViewsRepository.MessageProcessor.Properties.description == event.getAffectedEditor()) {
			messageProcessor.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				messageProcessor.getCommentsList().clear();
				messageProcessor.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.MessageProcessor.Properties.processorName == event.getAffectedEditor()) {
			messageProcessor.setProcessorName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.processorType == event.getAffectedEditor()) {
			messageProcessor.setProcessorType((MessageProcessorType)event.getNewValue());
		}
		if (EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider == event.getAffectedEditor()) {
			messageProcessor.setMessageProcessorProvider((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.messageStore == event.getAffectedEditor()) {
			messageProcessor.setMessageStore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore == event.getAffectedEditor()) {
			messageProcessor.setSourceMessageStore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.targetMessageStore == event.getAffectedEditor()) {
			messageProcessor.setTargetMessageStore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.processorState == event.getAffectedEditor()) {
			messageProcessor.setProcessorState((ProcessorState)event.getNewValue());
		}
		if (EsbViewsRepository.MessageProcessor.Properties.retryInterval == event.getAffectedEditor()) {
			messageProcessor.setRetryInterval((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.forwardingInterval == event.getAffectedEditor()) {
			messageProcessor.setForwardingInterval((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.samplingInterval == event.getAffectedEditor()) {
			messageProcessor.setSamplingInterval((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency == event.getAffectedEditor()) {
			messageProcessor.setSamplingConcurrency((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts == event.getAffectedEditor()) {
			messageProcessor.setMaxDeliveryAttempts((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts == event.getAffectedEditor()) {
			messageProcessor.setDropMessageAfterMaximumDeliveryAttempts((EnableDisableState)event.getNewValue());
		}
		if (EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository == event.getAffectedEditor()) {
			messageProcessor.setAxis2ClientRepository((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.axis2Configuration == event.getAffectedEditor()) {
			messageProcessor.setAxis2Configuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath == event.getAffectedEditor()) {
			messageProcessor.setQuartzConfigFilePath((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.cronExpression == event.getAffectedEditor()) {
			messageProcessor.setCronExpression((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes == event.getAffectedEditor()) {
			messageProcessor.setNonRetryHttpStatusCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.parameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, parametersSettings, editingContext.getAdapterFactory());
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
				parametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				parametersSettings.move(event.getNewIndex(), (MessageProcessorParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.MessageProcessor.Properties.taskCount == event.getAffectedEditor()) {
			messageProcessor.setTaskCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts == event.getAffectedEditor()) {
			messageProcessor.setMaxStoreConnectionAttempts((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval == event.getAffectedEditor()) {
			messageProcessor.setStoreConnectionInterval((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.MessageProcessor.Properties.failMessagesStore == event.getAffectedEditor()) {
			messageProcessor.setFailMessagesStore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			MessageProcessorPropertiesEditionPart basePart = (MessageProcessorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMessageProcessor_ProcessorName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.processorName)) {
				if (msg.getNewValue() != null) {
					basePart.setProcessorName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setProcessorName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_ProcessorType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.MessageProcessor.Properties.processorType))
				basePart.setProcessorType((MessageProcessorType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageProcessor_MessageProcessorProvider().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider)) {
				if (msg.getNewValue() != null) {
					basePart.setMessageProcessorProvider(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setMessageProcessorProvider("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_MessageStore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.messageStore)) {
				if (msg.getNewValue() != null) {
					basePart.setMessageStore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setMessageStore("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_SourceMessageStore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore)) {
				if (msg.getNewValue() != null) {
					basePart.setSourceMessageStore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSourceMessageStore("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_TargetMessageStore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.targetMessageStore)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetMessageStore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetMessageStore("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_ProcessorState().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.MessageProcessor.Properties.processorState))
				basePart.setProcessorState((ProcessorState)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageProcessor_RetryInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.retryInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryInterval(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setRetryInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_ForwardingInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.forwardingInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setForwardingInterval(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setForwardingInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_SamplingInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.samplingInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setSamplingInterval(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSamplingInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_SamplingConcurrency().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency)) {
				if (msg.getNewValue() != null) {
					basePart.setSamplingConcurrency(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setSamplingConcurrency("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_MaxDeliveryAttempts().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts)) {
				if (msg.getNewValue() != null) {
					basePart.setMaxDeliveryAttempts(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setMaxDeliveryAttempts("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts))
				basePart.setDropMessageAfterMaximumDeliveryAttempts((EnableDisableState)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageProcessor_Axis2ClientRepository().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository)) {
				if (msg.getNewValue() != null) {
					basePart.setAxis2ClientRepository(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAxis2ClientRepository("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_Axis2Configuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.axis2Configuration)) {
				if (msg.getNewValue() != null) {
					basePart.setAxis2Configuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAxis2Configuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_QuartzConfigFilePath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath)) {
				if (msg.getNewValue() != null) {
					basePart.setQuartzConfigFilePath(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setQuartzConfigFilePath("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_CronExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.cronExpression)) {
				if (msg.getNewValue() != null) {
					basePart.setCronExpression(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setCronExpression("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_NonRetryHttpStatusCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setNonRetryHttpStatusCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNonRetryHttpStatusCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_Parameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.MessageProcessor.Properties.parameters))
				basePart.updateParameters();
			if (EsbPackage.eINSTANCE.getMessageProcessor_TaskCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.taskCount)) {
				if (msg.getNewValue() != null) {
					basePart.setTaskCount(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTaskCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_MaxStoreConnectionAttempts().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts)) {
				if (msg.getNewValue() != null) {
					basePart.setMaxStoreConnectionAttempts(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setMaxStoreConnectionAttempts("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_StoreConnectionInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setStoreConnectionInterval(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setStoreConnectionInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor_FailMessagesStore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageProcessor.Properties.failMessagesStore)) {
				if (msg.getNewValue() != null) {
					basePart.setFailMessagesStore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFailMessagesStore("");
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
			EsbPackage.eINSTANCE.getMessageProcessor_ProcessorName(),
			EsbPackage.eINSTANCE.getMessageProcessor_ProcessorType(),
			EsbPackage.eINSTANCE.getMessageProcessor_MessageProcessorProvider(),
			EsbPackage.eINSTANCE.getMessageProcessor_MessageStore(),
			EsbPackage.eINSTANCE.getMessageProcessor_SourceMessageStore(),
			EsbPackage.eINSTANCE.getMessageProcessor_TargetMessageStore(),
			EsbPackage.eINSTANCE.getMessageProcessor_ProcessorState(),
			EsbPackage.eINSTANCE.getMessageProcessor_RetryInterval(),
			EsbPackage.eINSTANCE.getMessageProcessor_ForwardingInterval(),
			EsbPackage.eINSTANCE.getMessageProcessor_SamplingInterval(),
			EsbPackage.eINSTANCE.getMessageProcessor_SamplingConcurrency(),
			EsbPackage.eINSTANCE.getMessageProcessor_MaxDeliveryAttempts(),
			EsbPackage.eINSTANCE.getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts(),
			EsbPackage.eINSTANCE.getMessageProcessor_Axis2ClientRepository(),
			EsbPackage.eINSTANCE.getMessageProcessor_Axis2Configuration(),
			EsbPackage.eINSTANCE.getMessageProcessor_QuartzConfigFilePath(),
			EsbPackage.eINSTANCE.getMessageProcessor_CronExpression(),
			EsbPackage.eINSTANCE.getMessageProcessor_NonRetryHttpStatusCodes(),
			EsbPackage.eINSTANCE.getMessageProcessor_Parameters(),
			EsbPackage.eINSTANCE.getMessageProcessor_TaskCount(),
			EsbPackage.eINSTANCE.getMessageProcessor_MaxStoreConnectionAttempts(),
			EsbPackage.eINSTANCE.getMessageProcessor_StoreConnectionInterval(),
			EsbPackage.eINSTANCE.getMessageProcessor_FailMessagesStore()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EsbViewsRepository.MessageProcessor.Properties.processorType)
			return "Message Processor Type"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageProcessor.Properties.retryInterval)
			return "Message Retry Interval"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts)
			return "Maximum Re Delivery Attempts"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository)
			return "Axis2 Client Repository Path"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageProcessor.Properties.axis2Configuration)
			return "Axis2 Configuration"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath)
			return "Quartz Configuration File Path"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageProcessor.Properties.cronExpression)
			return "Cron Expression"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageProcessor.Properties.parameters)
			return "Message Processor Parameters"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
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
				if (EsbViewsRepository.MessageProcessor.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.MessageProcessor.Properties.processorName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_ProcessorName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_ProcessorName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.processorType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_ProcessorType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_ProcessorType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_MessageProcessorProvider().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_MessageProcessorProvider().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.messageStore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_MessageStore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_MessageStore().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_SourceMessageStore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_SourceMessageStore().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.targetMessageStore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_TargetMessageStore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_TargetMessageStore().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.processorState == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_ProcessorState().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_ProcessorState().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.retryInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_RetryInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_RetryInterval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.forwardingInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_ForwardingInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_ForwardingInterval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.samplingInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_SamplingInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_SamplingInterval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_SamplingConcurrency().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_SamplingConcurrency().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_MaxDeliveryAttempts().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_MaxDeliveryAttempts().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_Axis2ClientRepository().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_Axis2ClientRepository().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.axis2Configuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_Axis2Configuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_Axis2Configuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_QuartzConfigFilePath().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_QuartzConfigFilePath().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.cronExpression == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_CronExpression().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_CronExpression().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_NonRetryHttpStatusCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_NonRetryHttpStatusCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.taskCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_TaskCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_TaskCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_MaxStoreConnectionAttempts().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_MaxStoreConnectionAttempts().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_StoreConnectionInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_StoreConnectionInterval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageProcessor.Properties.failMessagesStore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageProcessor_FailMessagesStore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageProcessor_FailMessagesStore().getEAttributeType(), newValue);
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
