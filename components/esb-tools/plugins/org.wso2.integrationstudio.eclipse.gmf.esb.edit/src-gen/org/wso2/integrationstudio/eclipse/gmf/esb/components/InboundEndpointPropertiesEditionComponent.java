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

import org.wso2.integrationstudio.eclipse.gmf.esb.AutoOffsetResetType;
import org.wso2.integrationstudio.eclipse.gmf.esb.ConsumerType;
import org.wso2.integrationstudio.eclipse.gmf.esb.Enable;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.FeedType;
import org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpointBehaviourType;
import org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpointParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.InboundEndpointType;
import org.wso2.integrationstudio.eclipse.gmf.esb.JMSBrokerType;
import org.wso2.integrationstudio.eclipse.gmf.esb.JMSCacheLevel;
import org.wso2.integrationstudio.eclipse.gmf.esb.JMSConnectionFactoryType;
import org.wso2.integrationstudio.eclipse.gmf.esb.JMSSessionAcknowledgement;
import org.wso2.integrationstudio.eclipse.gmf.esb.MQTTSubscriptionQOS;
import org.wso2.integrationstudio.eclipse.gmf.esb.OffsetsStorageType;
import org.wso2.integrationstudio.eclipse.gmf.esb.PartitionAssignmentStrategyType;
import org.wso2.integrationstudio.eclipse.gmf.esb.PayloadFormatType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TopicFilterFromType;
import org.wso2.integrationstudio.eclipse.gmf.esb.TopicsType;
import org.wso2.integrationstudio.eclipse.gmf.esb.VFSAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.VFSFileSort;
import org.wso2.integrationstudio.eclipse.gmf.esb.WSClientSideBroadcastLevel;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.InboundEndpointPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

// End of user code

/**
 * 
 * 
 */
public class InboundEndpointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for serviceParameters ReferencesTable
	 */
	protected ReferencesTableSettings serviceParametersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public InboundEndpointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject inboundEndpoint, String editing_mode) {
		super(editingContext, inboundEndpoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.InboundEndpoint.class;
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
			
			final InboundEndpoint inboundEndpoint = (InboundEndpoint)elt;
			final InboundEndpointPropertiesEditionPart basePart = (InboundEndpointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.commentsList))
				basePart.setCommentsList(inboundEndpoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.type)) {
				basePart.initType(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_Type()), inboundEndpoint.getType());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.class_))
				basePart.setClass_(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getClass_()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.protocol))
				basePart.setProtocol(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getProtocol()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundEndpointBehaviour)) {
				basePart.initInboundEndpointBehaviour(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_InboundEndpointBehaviour()), inboundEndpoint.getInboundEndpointBehaviour());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHttpPort))
				basePart.setInboundHttpPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundHttpPort()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeCore))
				basePart.setInboundWorkerPoolSizeCore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundWorkerPoolSizeCore()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeMax))
				basePart.setInboundWorkerPoolSizeMax(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundWorkerPoolSizeMax()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerThreadKeepAliveSec))
				basePart.setInboundWorkerThreadKeepAliveSec(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundWorkerThreadKeepAliveSec()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolQueueLength))
				basePart.setInboundWorkerPoolQueueLength(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundWorkerPoolQueueLength()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundThreadGroupId))
				basePart.setInboundThreadGroupId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundThreadGroupId()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundThreadId))
				basePart.setInboundThreadId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundThreadId()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.dispatchFilterPattern))
				basePart.setDispatchFilterPattern(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getDispatchFilterPattern()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.interval))
				basePart.setInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInterval()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.sequential)) {
				basePart.setSequential(inboundEndpoint.isSequential());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.coordination)) {
				basePart.setCoordination(inboundEndpoint.isCoordination());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileURI))
				basePart.setTransportVFSFileURI(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSFileURI()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wso2mbConnectionUrl))
				basePart.setWso2mbConnectionUrl(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWso2mbConnectionUrl()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSContentType))
				basePart.setTransportVFSContentType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSContentType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileNamePattern))
				basePart.setTransportVFSFileNamePattern(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSFileNamePattern()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessInterval))
				basePart.setTransportVFSFileProcessInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSFileProcessInterval()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessCount))
				basePart.setTransportVFSFileProcessCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSFileProcessCount()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSLocking)) {
				basePart.initTransportVFSLocking(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLocking()), inboundEndpoint.getTransportVFSLocking());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMaxRetryCount))
				basePart.setTransportVFSMaxRetryCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSMaxRetryCount()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailedMove))
				basePart.setTransportVFSMoveAfterFailedMove(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSMoveAfterFailedMove()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSReconnectTimeout))
				basePart.setTransportVFSReconnectTimeout(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSReconnectTimeout()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSharedSubscription)) {
				basePart.setTransportJMSSharedSubscription(inboundEndpoint.isTransportJMSSharedSubscription());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionName))
				basePart.setTransportJMSSubscriptionName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSSubscriptionName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSPinnedServers))
				basePart.setTransportJMSPinnedServers(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSPinnedServers()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterProcess)) {
				basePart.initTransportVFSActionAfterProcess(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterProcess()), inboundEndpoint.getTransportVFSActionAfterProcess());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterProcess))
				basePart.setTransportVFSMoveAfterProcess(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSMoveAfterProcess()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterErrors)) {
				basePart.initTransportVFSActionAfterErrors(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterErrors()), inboundEndpoint.getTransportVFSActionAfterErrors());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterErrors))
				basePart.setTransportVFSMoveAfterErrors(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSMoveAfterErrors()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileName))
				basePart.setTransportVFSFailedRecordsFileName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSFailedRecordsFileName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileDestination))
				basePart.setTransportVFSFailedRecordsFileDestination(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSFailedRecordsFileDestination()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveFailedRecordTimestampFormat))
				basePart.setTransportVFSMoveFailedRecordTimestampFormat(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSMoveFailedRecordTimestampFormat()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordNextRetryDuration))
				basePart.setTransportVFSFailedRecordNextRetryDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSFailedRecordNextRetryDuration()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterFailure)) {
				basePart.initTransportVFSActionAfterFailure(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterFailure()), inboundEndpoint.getTransportVFSActionAfterFailure());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailure))
				basePart.setTransportVFSMoveAfterFailure(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSMoveAfterFailure()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileURI))
				basePart.setTransportVFSReplyFileURI(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSReplyFileURI()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileName))
				basePart.setTransportVFSReplyFileName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSReplyFileName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockRelease)) {
				basePart.setTransportVFSAutoLockRelease(inboundEndpoint.isTransportVFSAutoLockRelease());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockReleaseInterval))
				basePart.setTransportVFSAutoLockReleaseInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSAutoLockReleaseInterval()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSLockReleaseSameNode)) {
				basePart.setTransportVFSLockReleaseSameNode(inboundEndpoint.isTransportVFSLockReleaseSameNode());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedLock)) {
				basePart.setTransportVFSDistributedLock(inboundEndpoint.isTransportVFSDistributedLock());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSStreaming)) {
				basePart.setTransportVFSStreaming(inboundEndpoint.isTransportVFSStreaming());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSBuild)) {
				basePart.setTransportVFSBuild(inboundEndpoint.isTransportVFSBuild());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedTimeout))
				basePart.setTransportVFSDistributedTimeout(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSDistributedTimeout()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentities))
				basePart.setTransportVFSSFTPIdentities(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSSFTPIdentities()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentityPassPhrase))
				basePart.setTransportVFSSFTPIdentityPassPhrase(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSSFTPIdentityPassPhrase()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPUserDirIsRoot)) {
				basePart.setTransportVFSSFTPUserDirIsRoot(inboundEndpoint.isTransportVFSSFTPUserDirIsRoot());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.javaNamingFactoryInitial))
				basePart.setJavaNamingFactoryInitial(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getJavaNamingFactoryInitial()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.javaNamingProviderUrl))
				basePart.setJavaNamingProviderUrl(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getJavaNamingProviderUrl()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryJNDIName))
				basePart.setTransportJMSConnectionFactoryJNDIName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSConnectionFactoryJNDIName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryType)) {
				basePart.initTransportJMSConnectionFactoryType(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryType()), inboundEndpoint.getTransportJMSConnectionFactoryType());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSConcurrentConsumers))
				basePart.setTransportJMSConcurrentConsumers(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSConcurrentConsumers()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSDestination))
				basePart.setTransportJMSDestination(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSDestination()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionTransacted)) {
				basePart.setTransportJMSSessionTransacted(inboundEndpoint.isTransportJMSSessionTransacted());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionAcknowledgement)) {
				basePart.initTransportJMSSessionAcknowledgement(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionAcknowledgement()), inboundEndpoint.getTransportJMSSessionAcknowledgement());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSCacheLevel)) {
				basePart.initTransportJMSCacheLevel(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSCacheLevel()), inboundEndpoint.getTransportJMSCacheLevel());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSUserName))
				basePart.setTransportJMSUserName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSUserName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSPassword))
				basePart.setTransportJMSPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSPassword()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSJMSSpecVersion))
				basePart.setTransportJMSJMSSpecVersion(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSJMSSpecVersion()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionDurable))
				basePart.setTransportJMSSubscriptionDurable(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSSubscriptionDurable()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberClientID))
				basePart.setTransportJMSDurableSubscriberClientID(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSDurableSubscriberClientID()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSMessageSelector))
				basePart.setTransportJMSMessageSelector(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSMessageSelector()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetryDuration))
				basePart.setTransportJMSRetryDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSRetryDuration()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveTimestampFormat))
				basePart.setTransportVFSMoveTimestampFormat(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSMoveTimestampFormat()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAttribute)) {
				basePart.initTransportVFSFileSortAttribute(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAttribute()), inboundEndpoint.getTransportVFSFileSortAttribute());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAscending)) {
				basePart.setTransportVFSFileSortAscending(inboundEndpoint.isTransportVFSFileSortAscending());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSSubFolderTimestampFormat))
				basePart.setTransportVFSSubFolderTimestampFormat(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportVFSSubFolderTimestampFormat()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSCreateFolder)) {
				basePart.setTransportVFSCreateFolder(inboundEndpoint.isTransportVFSCreateFolder());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSReceiveTimeout))
				basePart.setTransportJMSReceiveTimeout(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSReceiveTimeout()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentType))
				basePart.setTransportJMSContentType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSContentType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentTypeProperty))
				basePart.setTransportJMSContentTypeProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSContentTypeProperty()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSReplyDestination))
				basePart.setTransportJMSReplyDestination(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSReplyDestination()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSPubSubNoLocal))
				basePart.setTransportJMSPubSubNoLocal(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSPubSubNoLocal()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberName))
				basePart.setTransportJMSDurableSubscriberName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSDurableSubscriberName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSBrokerType)) {
				basePart.initTransportJMSBrokerType(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSBrokerType()), inboundEndpoint.getTransportJMSBrokerType());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTConnectionFactory))
				basePart.setTransportMQTTConnectionFactory(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTConnectionFactory()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerHostName))
				basePart.setTransportMQTTServerHostName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTServerHostName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerPort))
				basePart.setTransportMQTTServerPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTServerPort()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTopicName))
				basePart.setTransportMQTTTopicName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTTopicName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionQOS)) {
				basePart.initTransportMQTTSubscriptionQOS(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionQOS()), inboundEndpoint.getTransportMQTTSubscriptionQOS());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSessionClean)) {
				basePart.setTransportMQTTSessionClean(inboundEndpoint.isTransportMQTTSessionClean());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslEnable))
				basePart.setTransportMQTTSslEnable(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSslEnable()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTemporaryStoreDirectory))
				basePart.setTransportMQTTTemporaryStoreDirectory(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTTemporaryStoreDirectory()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionUsername))
				basePart.setTransportMQTTSubscriptionUsername(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSubscriptionUsername()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionPassword))
				basePart.setTransportMQTTSubscriptionPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSubscriptionPassword()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTClientId))
				basePart.setTransportMQTTClientId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTClientId()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.truststore))
				basePart.setTruststore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTruststore()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.keystore))
				basePart.setKeystore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getKeystore()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.sslVerifyClient))
				basePart.setSslVerifyClient(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSslVerifyClient()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.sslProtocol))
				basePart.setSslProtocol(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSslProtocol()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.httpsProtocols))
				basePart.setHttpsProtocols(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getHttpsProtocols()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.certificateRevocationVerifier))
				basePart.setCertificateRevocationVerifier(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getCertificateRevocationVerifier()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7Port))
				basePart.setInboundHL7Port(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundHL7Port()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7AutoAck)) {
				basePart.setInboundHL7AutoAck(inboundEndpoint.isInboundHL7AutoAck());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7MessagePreProcessor))
				basePart.setInboundHL7MessagePreProcessor(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundHL7MessagePreProcessor()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7CharSet))
				basePart.setInboundHL7CharSet(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundHL7CharSet()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7TimeOut))
				basePart.setInboundHL7TimeOut(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundHL7TimeOut()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7ValidateMessage)) {
				basePart.setInboundHL7ValidateMessage(inboundEndpoint.isInboundHL7ValidateMessage());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7BuildInvalidMessages)) {
				basePart.setInboundHL7BuildInvalidMessages(inboundEndpoint.isInboundHL7BuildInvalidMessages());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7PassThroughInvalidMessages)) {
				basePart.setInboundHL7PassThroughInvalidMessages(inboundEndpoint.isInboundHL7PassThroughInvalidMessages());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnect))
				basePart.setZookeeperConnect(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getZookeeperConnect()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.groupId))
				basePart.setGroupId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getGroupId()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.contentType))
				basePart.setContentType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getContentType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.consumerType)) {
				basePart.initConsumerType(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerType()), inboundEndpoint.getConsumerType());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.topicsOrTopicFilter)) {
				basePart.initTopicsOrTopicFilter(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TopicsOrTopicFilter()), inboundEndpoint.getTopicsOrTopicFilter());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.topicsName))
				basePart.setTopicsName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTopicsName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.topicFilterFrom)) {
				basePart.initTopicFilterFrom(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterFrom()), inboundEndpoint.getTopicFilterFrom());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.topicFilterName))
				basePart.setTopicFilterName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTopicFilterName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerTopic))
				basePart.setSimpleConsumerTopic(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSimpleConsumerTopic()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerBrokers))
				basePart.setSimpleConsumerBrokers(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSimpleConsumerBrokers()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPort))
				basePart.setSimpleConsumerPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSimpleConsumerPort()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPartition))
				basePart.setSimpleConsumerPartition(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSimpleConsumerPartition()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerMaxMessagesToRead))
				basePart.setSimpleConsumerMaxMessagesToRead(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSimpleConsumerMaxMessagesToRead()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.threadCount))
				basePart.setThreadCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getThreadCount()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.consumerId))
				basePart.setConsumerId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getConsumerId()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.socketTimeoutMs))
				basePart.setSocketTimeoutMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSocketTimeoutMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.socketReceiveBufferBytes))
				basePart.setSocketReceiveBufferBytes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getSocketReceiveBufferBytes()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.fetchMessageMaxBytes))
				basePart.setFetchMessageMaxBytes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getFetchMessageMaxBytes()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.numConsumerFetches))
				basePart.setNumConsumerFetches(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getNumConsumerFetches()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.autoCommitEnable)) {
				basePart.setAutoCommitEnable(inboundEndpoint.isAutoCommitEnable());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.autoCommitIntervalMs))
				basePart.setAutoCommitIntervalMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getAutoCommitIntervalMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.queuedMaxMessageChunks))
				basePart.setQueuedMaxMessageChunks(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getQueuedMaxMessageChunks()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.rebalanceMaxRetries))
				basePart.setRebalanceMaxRetries(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getRebalanceMaxRetries()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.fetchMinBytes))
				basePart.setFetchMinBytes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getFetchMinBytes()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.fetchWaitMaxMs))
				basePart.setFetchWaitMaxMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getFetchWaitMaxMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.rebalanceBackoffMs))
				basePart.setRebalanceBackoffMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getRebalanceBackoffMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.refreshLeaderBackoffMs))
				basePart.setRefreshLeaderBackoffMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getRefreshLeaderBackoffMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.autoOffsetReset)) {
				basePart.initAutoOffsetReset(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_AutoOffsetReset()), inboundEndpoint.getAutoOffsetReset());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.consumerTimeoutMs))
				basePart.setConsumerTimeoutMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getConsumerTimeoutMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.excludeInternalTopics)) {
				basePart.setExcludeInternalTopics(inboundEndpoint.isExcludeInternalTopics());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.partitionAssignmentStrategy)) {
				basePart.initPartitionAssignmentStrategy(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_PartitionAssignmentStrategy()), inboundEndpoint.getPartitionAssignmentStrategy());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.clientId))
				basePart.setClientId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getClientId()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.zookeeperSessionTimeoutMs))
				basePart.setZookeeperSessionTimeoutMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getZookeeperSessionTimeoutMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnectionTimeoutMs))
				basePart.setZookeeperConnectionTimeoutMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getZookeeperConnectionTimeoutMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.zookeeperSyncTimeMs))
				basePart.setZookeeperSyncTimeMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getZookeeperSyncTimeMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.offsetsStorage)) {
				basePart.initOffsetsStorage(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsStorage()), inboundEndpoint.getOffsetsStorage());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelBackoffMs))
				basePart.setOffsetsChannelBackoffMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getOffsetsChannelBackoffMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelSocketTimeoutMs))
				basePart.setOffsetsChannelSocketTimeoutMs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getOffsetsChannelSocketTimeoutMs()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.offsetsCommitMaxRetries))
				basePart.setOffsetsCommitMaxRetries(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getOffsetsCommitMaxRetries()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.dualCommitEnabled)) {
				basePart.setDualCommitEnabled(inboundEndpoint.isDualCommitEnabled());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmHost))
				basePart.setInboundCxfRmHost(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundCxfRmHost()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmPort))
				basePart.setInboundCxfRmPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundCxfRmPort()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmConfigFile))
				basePart.setInboundCxfRmConfigFile(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getInboundCxfRmConfigFile()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.enableSSL)) {
				basePart.setEnableSSL(inboundEndpoint.isEnableSSL());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.serviceParameters)) {
				serviceParametersSettings = new ReferencesTableSettings(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_ServiceParameters());
				basePart.initServiceParameters(serviceParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.suspend)) {
				basePart.setSuspend(inboundEndpoint.isSuspend());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionFactory))
				basePart.setTransportRabbitMqConnectionFactory(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionFactory()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerHostName))
				basePart.setTransportRabbitMqServerHostName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqServerHostName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPort))
				basePart.setTransportRabbitMqServerPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqServerPort()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerUserName))
				basePart.setTransportRabbitMqServerUserName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqServerUserName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPassword))
				basePart.setTransportRabbitMqServerPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqServerPassword()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueName))
				basePart.setTransportRabbitMqQueueName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqQueueName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeName))
				basePart.setTransportRabbitMqExchangeName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqExchangeName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDurable))
				basePart.setTransportRabbitMqQueueDurable(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqQueueDurable()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueExclusive))
				basePart.setTransportRabbitMqQueueExclusive(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqQueueExclusive()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoDelete))
				basePart.setTransportRabbitMqQueueAutoDelete(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqQueueAutoDelete()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoAck))
				basePart.setTransportRabbitMqQueueAutoAck(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqQueueAutoAck()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueRoutingKey))
				basePart.setTransportRabbitMqQueueRoutingKey(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqQueueRoutingKey()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDeliveryMode))
				basePart.setTransportRabbitMqQueueDeliveryMode(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqQueueDeliveryMode()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeType))
				basePart.setTransportRabbitMqExchangeType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqExchangeType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeDurable))
				basePart.setTransportRabbitMqExchangeDurable(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqExchangeDurable()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDelete))
				basePart.setTransportRabbitMqExchangeAutoDelete(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqExchangeAutoDelete()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerVirtualHost))
				basePart.setTransportRabbitMqServerVirtualHost(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqServerVirtualHost()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryHeartbeat))
				basePart.setTransportRabbitMqFactoryHeartbeat(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqFactoryHeartbeat()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslEnabled))
				basePart.setTransportRabbitMqConnectionSslEnabled(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionSslEnabled()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreLocation))
				basePart.setTransportRabbitMqConnectionSslKeystoreLocation(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionSslKeystoreLocation()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreType))
				basePart.setTransportRabbitMqConnectionSslKeystoreType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionSslKeystoreType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystorePassword))
				basePart.setTransportRabbitMqConnectionSslKeystorePassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionSslKeystorePassword()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreLocation))
				basePart.setTransportRabbitMqConnectionSslTruststoreLocation(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionSslTruststoreLocation()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreType))
				basePart.setTransportRabbitMqConnectionSslTruststoreType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionSslTruststoreType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststorePassword))
				basePart.setTransportRabbitMqConnectionSslTruststorePassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionSslTruststorePassword()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslVersion))
				basePart.setTransportRabbitMqConnectionSslVersion(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionSslVersion()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMessageContentType))
				basePart.setTransportRabbitMqMessageContentType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqMessageContentType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryCount))
				basePart.setTransportRabbitMqConnectionRetryCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionRetryCount()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryInterval))
				basePart.setTransportRabbitMqConnectionRetryInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConnectionRetryInterval()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerRetryInterval))
				basePart.setTransportRabbitMqServerRetryInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqServerRetryInterval()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsInboundPort))
				basePart.setWsInboundPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsInboundPort()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsClientSideBroadcastLevel)) {
				basePart.initWsClientSideBroadcastLevel(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_WsClientSideBroadcastLevel()), inboundEndpoint.getWsClientSideBroadcastLevel());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchSequence))
				basePart.setWsOutflowDispatchSequence(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsOutflowDispatchSequence()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchFaultSequence))
				basePart.setWsOutflowDispatchFaultSequence(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsOutflowDispatchFaultSequence()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsBossThreadPoolSize))
				basePart.setWsBossThreadPoolSize(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsBossThreadPoolSize()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsWorkerThreadPoolSize))
				basePart.setWsWorkerThreadPoolSize(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsWorkerThreadPoolSize()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsSubprotocolHandlerClass))
				basePart.setWsSubprotocolHandlerClass(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsSubprotocolHandlerClass()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsPipelineHandlerClass))
				basePart.setWsPipelineHandlerClass(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsPipelineHandlerClass()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportFeedURL))
				basePart.setTransportFeedURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportFeedURL()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportFeedType)) {
				basePart.initTransportFeedType(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedType()), inboundEndpoint.getTransportFeedType());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.traceEnabled)) {
				basePart.setTraceEnabled(inboundEndpoint.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.statisticsEnabled)) {
				basePart.setStatisticsEnabled(inboundEndpoint.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetriesBeforeSuspension))
				basePart.setTransportJMSRetriesBeforeSuspension(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSRetriesBeforeSuspension()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSResetConnectionOnPollingSuspension)) {
				basePart.setTransportJMSResetConnectionOnPollingSuspension(inboundEndpoint.isTransportJMSResetConnectionOnPollingSuspension());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSPollingSuspensionPeriod))
				basePart.setTransportJMSPollingSuspensionPeriod(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSPollingSuspensionPeriod()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreLocation))
				basePart.setTransportMQTTSslKeystoreLocation(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSslKeystoreLocation()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreType))
				basePart.setTransportMQTTSslKeystoreType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSslKeystoreType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystorePassword))
				basePart.setTransportMQTTSslKeystorePassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSslKeystorePassword()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreLocation))
				basePart.setTransportMQTTSslTruststoreLocation(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSslTruststoreLocation()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreType))
				basePart.setTransportMQTTSslTruststoreType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSslTruststoreType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststorePassword))
				basePart.setTransportMQTTSslTruststorePassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSslTruststorePassword()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslVersion))
				basePart.setTransportMQTTSslVersion(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportMQTTSslVersion()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStoreFile))
				basePart.setWssSslKeyStoreFile(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWssSslKeyStoreFile()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStorePass))
				basePart.setWssSslKeyStorePass(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWssSslKeyStorePass()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStoreFile))
				basePart.setWssSslTrustStoreFile(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWssSslTrustStoreFile()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStorePass))
				basePart.setWssSslTrustStorePass(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWssSslTrustStorePass()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslCertPass))
				basePart.setWssSslCertPass(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWssSslCertPass()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsDefaultContentType))
				basePart.setWsDefaultContentType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsDefaultContentType()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusCode))
				basePart.setWsShutdownStatusCode(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsShutdownStatusCode()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusMessage))
				basePart.setWsShutdownStatusMessage(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWsShutdownStatusMessage()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsUsePortOffset)) {
				basePart.setWsUsePortOffset(inboundEndpoint.isWsUsePortOffset());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslProtocols))
				basePart.setWssSslProtocols(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWssSslProtocols()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslCipherSuites))
				basePart.setWssSslCipherSuites(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getWssSslCipherSuites()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQos))
				basePart.setTransportRabbitMqConsumerQos(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConsumerQos()));
			
			// Start of user code for transportRabbitMqConsumerQosKey command update
	         if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosKey))
	                basePart.setRabbitMqConsumerQosKey(inboundEndpoint.getTransportRabbitMqConsumerQosKey());

            // End of user code
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosType)) {
				basePart.initTransportRabbitMqConsumerQosType(EEFUtils.choiceOfValues(inboundEndpoint, EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosType()), inboundEndpoint.getTransportRabbitMqConsumerQosType());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSDBUrl))
				basePart.setTransportJMSDBUrl(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportJMSDBUrl()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqAutoDeclare)) {
				basePart.setTransportRabbitMqAutoDeclare(inboundEndpoint.isTransportRabbitMqAutoDeclare());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMaxDeadLetteredCount))
				basePart.setTransportRabbitMqMaxDeadLetteredCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqMaxDeadLetteredCount()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqRequeueDelay))
				basePart.setTransportRabbitMqRequeueDelay(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqRequeueDelay()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDeclare)) {
				basePart.setTransportRabbitMqExchangeAutoDeclare(inboundEndpoint.isTransportRabbitMqExchangeAutoDeclare());
			}
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerTag))
				basePart.setTransportRabbitMqConsumerTag(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqConsumerTag()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorQueueRoutingKey))
				basePart.setTransportRabbitMqErrorQueueRoutingKey(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqErrorQueueRoutingKey()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorExchangeName))
				basePart.setTransportRabbitMqErrorExchangeName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqErrorExchangeName()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryConnectionTimeout))
				basePart.setTransportRabbitMqFactoryConnectionTimeout(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqFactoryConnectionTimeout()));
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryNetworkRecoveryInterval))
				basePart.setTransportRabbitMqFactoryNetworkRecoveryInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getTransportRabbitMqFactoryNetworkRecoveryInterval()));
			
			// init filters
			
			if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.serviceParameters)) {
				basePart.addFilterToServiceParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof InboundEndpointParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for serviceParameters
	            if (isAccessible(EsbViewsRepository.InboundEndpoint.Properties.class_))
	                basePart.setClass_(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, inboundEndpoint.getClass_()));
                // End of user code
			}
			
			// Start of user code for transportRabbitMqConsumerQosKey filter update
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
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.name) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Name();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.type) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Type();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.class_) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Class();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.protocol) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Protocol();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundEndpointBehaviour) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundEndpointBehaviour();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHttpPort) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHttpPort();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeCore) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeCore();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeMax) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeMax();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerThreadKeepAliveSec) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerThreadKeepAliveSec();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolQueueLength) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolQueueLength();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundThreadGroupId) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadGroupId();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundThreadId) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadId();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.dispatchFilterPattern) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_DispatchFilterPattern();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.interval) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Interval();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.sequential) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Sequential();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.coordination) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Coordination();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileURI) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileURI();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wso2mbConnectionUrl) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Wso2mbConnectionUrl();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSContentType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSContentType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileNamePattern) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileNamePattern();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessInterval) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessInterval();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessCount) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessCount();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSLocking) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLocking();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSMaxRetryCount) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMaxRetryCount();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailedMove) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailedMove();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSReconnectTimeout) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReconnectTimeout();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSSharedSubscription) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSharedSubscription();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSPinnedServers) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPinnedServers();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterProcess) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterProcess();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterProcess) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterProcess();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterErrors) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterErrors();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterErrors) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterErrors();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileDestination) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileDestination();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveFailedRecordTimestampFormat) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveFailedRecordTimestampFormat();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordNextRetryDuration) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordNextRetryDuration();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterFailure) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterFailure();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailure) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailure();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileURI) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileURI();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockRelease) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockRelease();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockReleaseInterval) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockReleaseInterval();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSLockReleaseSameNode) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLockReleaseSameNode();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedLock) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedLock();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSStreaming) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSStreaming();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSBuild) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSBuild();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedTimeout) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedTimeout();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentities) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentities();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentityPassPhrase) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentityPassPhrase();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPUserDirIsRoot) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPUserDirIsRoot();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.javaNamingFactoryInitial) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingFactoryInitial();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.javaNamingProviderUrl) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingProviderUrl();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryJNDIName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryJNDIName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSConcurrentConsumers) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConcurrentConsumers();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSDestination) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDestination();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionTransacted) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionTransacted();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionAcknowledgement) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionAcknowledgement();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSCacheLevel) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSCacheLevel();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSUserName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSUserName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSPassword) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPassword();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSJMSSpecVersion) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSJMSSpecVersion();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionDurable) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionDurable();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberClientID) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberClientID();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSMessageSelector) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSMessageSelector();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetryDuration) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetryDuration();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveTimestampFormat) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveTimestampFormat();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAttribute) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAttribute();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAscending) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAscending();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSSubFolderTimestampFormat) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSubFolderTimestampFormat();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportVFSCreateFolder) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSCreateFolder();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSReceiveTimeout) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReceiveTimeout();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentTypeProperty) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentTypeProperty();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSReplyDestination) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReplyDestination();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSPubSubNoLocal) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPubSubNoLocal();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSBrokerType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSBrokerType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTConnectionFactory) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTConnectionFactory();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerHostName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerHostName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerPort) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerPort();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTopicName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTopicName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionQOS) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionQOS();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSessionClean) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSessionClean();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslEnable) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslEnable();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTemporaryStoreDirectory) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTemporaryStoreDirectory();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionUsername) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionUsername();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionPassword) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionPassword();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTClientId) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTClientId();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.truststore) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Truststore();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.keystore) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Keystore();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.sslVerifyClient) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SslVerifyClient();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.sslProtocol) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SslProtocol();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.httpsProtocols) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_HttpsProtocols();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.certificateRevocationVerifier) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_CertificateRevocationVerifier();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHL7Port) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7Port();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHL7AutoAck) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7AutoAck();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHL7MessagePreProcessor) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7MessagePreProcessor();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHL7CharSet) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7CharSet();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHL7TimeOut) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7TimeOut();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHL7ValidateMessage) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7ValidateMessage();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHL7BuildInvalidMessages) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7BuildInvalidMessages();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundHL7PassThroughInvalidMessages) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7PassThroughInvalidMessages();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnect) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnect();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.groupId) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_GroupId();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.contentType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ContentType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.consumerType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.topicsOrTopicFilter) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TopicsOrTopicFilter();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.topicsName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TopicsName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.topicFilterFrom) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterFrom();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.topicFilterName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerTopic) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerTopic();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerBrokers) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerBrokers();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPort) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPort();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPartition) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPartition();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerMaxMessagesToRead) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerMaxMessagesToRead();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.threadCount) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ThreadCount();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.consumerId) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerId();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.socketTimeoutMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SocketTimeoutMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.socketReceiveBufferBytes) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_SocketReceiveBufferBytes();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.fetchMessageMaxBytes) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_FetchMessageMaxBytes();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.numConsumerFetches) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_NumConsumerFetches();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.autoCommitEnable) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitEnable();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.autoCommitIntervalMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitIntervalMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.queuedMaxMessageChunks) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_QueuedMaxMessageChunks();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.rebalanceMaxRetries) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceMaxRetries();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.fetchMinBytes) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_FetchMinBytes();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.fetchWaitMaxMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_FetchWaitMaxMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.rebalanceBackoffMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceBackoffMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.refreshLeaderBackoffMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_RefreshLeaderBackoffMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.autoOffsetReset) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_AutoOffsetReset();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.consumerTimeoutMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerTimeoutMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.excludeInternalTopics) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ExcludeInternalTopics();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.partitionAssignmentStrategy) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_PartitionAssignmentStrategy();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.clientId) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ClientId();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.zookeeperSessionTimeoutMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSessionTimeoutMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnectionTimeoutMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnectionTimeoutMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.zookeeperSyncTimeMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSyncTimeMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.offsetsStorage) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsStorage();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelBackoffMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelBackoffMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelSocketTimeoutMs) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelSocketTimeoutMs();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.offsetsCommitMaxRetries) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsCommitMaxRetries();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.dualCommitEnabled) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_DualCommitEnabled();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmHost) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmHost();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmPort) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmPort();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmConfigFile) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmConfigFile();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.enableSSL) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_EnableSSL();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.serviceParameters) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_ServiceParameters();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.suspend) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_Suspend();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionFactory) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionFactory();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerHostName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerHostName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPort) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPort();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerUserName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerUserName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPassword) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPassword();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDurable) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDurable();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueExclusive) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueExclusive();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoDelete) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoDelete();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoAck) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoAck();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueRoutingKey) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueRoutingKey();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDeliveryMode) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDeliveryMode();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeDurable) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeDurable();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDelete) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDelete();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerVirtualHost) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerVirtualHost();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryHeartbeat) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryHeartbeat();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslEnabled) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslEnabled();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreLocation) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreLocation();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystorePassword) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystorePassword();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreLocation) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreLocation();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststorePassword) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststorePassword();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslVersion) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslVersion();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMessageContentType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMessageContentType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryCount) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryCount();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryInterval) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryInterval();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerRetryInterval) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerRetryInterval();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsInboundPort) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsInboundPort();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsClientSideBroadcastLevel) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsClientSideBroadcastLevel();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchSequence) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchSequence();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchFaultSequence) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchFaultSequence();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsBossThreadPoolSize) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsBossThreadPoolSize();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsWorkerThreadPoolSize) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsWorkerThreadPoolSize();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsSubprotocolHandlerClass) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsSubprotocolHandlerClass();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsPipelineHandlerClass) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsPipelineHandlerClass();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportFeedURL) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedURL();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportFeedType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.traceEnabled) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetriesBeforeSuspension) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetriesBeforeSuspension();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSResetConnectionOnPollingSuspension) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSResetConnectionOnPollingSuspension();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSPollingSuspensionPeriod) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPollingSuspensionPeriod();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreLocation) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreLocation();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystorePassword) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystorePassword();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreLocation) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreLocation();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststorePassword) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststorePassword();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslVersion) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslVersion();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStoreFile) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStoreFile();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStorePass) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStorePass();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStoreFile) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStoreFile();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStorePass) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStorePass();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wssSslCertPass) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCertPass();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsDefaultContentType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsDefaultContentType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusCode) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusCode();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusMessage) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusMessage();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wsUsePortOffset) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WsUsePortOffset();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wssSslProtocols) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WssSslProtocols();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.wssSslCipherSuites) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCipherSuites();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQos) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQos();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosKey) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosKey();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosType) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosType();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportJMSDBUrl) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDBUrl();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqAutoDeclare) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqAutoDeclare();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMaxDeadLetteredCount) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMaxDeadLetteredCount();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqRequeueDelay) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqRequeueDelay();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDeclare) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDeclare();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerTag) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerTag();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorQueueRoutingKey) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorQueueRoutingKey();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorExchangeName) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorExchangeName();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryConnectionTimeout) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryConnectionTimeout();
		}
		if (editorKey == EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryNetworkRecoveryInterval) {
			return EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryNetworkRecoveryInterval();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		InboundEndpoint inboundEndpoint = (InboundEndpoint)semanticObject;
		if (EsbViewsRepository.InboundEndpoint.Properties.description == event.getAffectedEditor()) {
			inboundEndpoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				inboundEndpoint.getCommentsList().clear();
				inboundEndpoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.name == event.getAffectedEditor()) {
			inboundEndpoint.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.type == event.getAffectedEditor()) {
			inboundEndpoint.setType((InboundEndpointType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.class_ == event.getAffectedEditor()) {
			inboundEndpoint.setClass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.protocol == event.getAffectedEditor()) {
			inboundEndpoint.setProtocol((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundEndpointBehaviour == event.getAffectedEditor()) {
			inboundEndpoint.setInboundEndpointBehaviour((InboundEndpointBehaviourType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHttpPort == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHttpPort((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeCore == event.getAffectedEditor()) {
			inboundEndpoint.setInboundWorkerPoolSizeCore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeMax == event.getAffectedEditor()) {
			inboundEndpoint.setInboundWorkerPoolSizeMax((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerThreadKeepAliveSec == event.getAffectedEditor()) {
			inboundEndpoint.setInboundWorkerThreadKeepAliveSec((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolQueueLength == event.getAffectedEditor()) {
			inboundEndpoint.setInboundWorkerPoolQueueLength((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundThreadGroupId == event.getAffectedEditor()) {
			inboundEndpoint.setInboundThreadGroupId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundThreadId == event.getAffectedEditor()) {
			inboundEndpoint.setInboundThreadId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.dispatchFilterPattern == event.getAffectedEditor()) {
			inboundEndpoint.setDispatchFilterPattern((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.interval == event.getAffectedEditor()) {
			inboundEndpoint.setInterval((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.sequential == event.getAffectedEditor()) {
			inboundEndpoint.setSequential((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.coordination == event.getAffectedEditor()) {
			inboundEndpoint.setCoordination((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileURI == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFileURI((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wso2mbConnectionUrl == event.getAffectedEditor()) {
			inboundEndpoint.setWso2mbConnectionUrl((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSContentType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSContentType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileNamePattern == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFileNamePattern((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessInterval == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFileProcessInterval((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessCount == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFileProcessCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSLocking == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSLocking((Enable)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMaxRetryCount == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSMaxRetryCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailedMove == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSMoveAfterFailedMove((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSReconnectTimeout == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSReconnectTimeout((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSharedSubscription == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSSharedSubscription((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSSubscriptionName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSPinnedServers == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSPinnedServers((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterProcess == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSActionAfterProcess((VFSAction)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterProcess == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSMoveAfterProcess((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterErrors == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSActionAfterErrors((VFSAction)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterErrors == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSMoveAfterErrors((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFailedRecordsFileName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileDestination == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFailedRecordsFileDestination((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveFailedRecordTimestampFormat == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSMoveFailedRecordTimestampFormat((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordNextRetryDuration == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFailedRecordNextRetryDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterFailure == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSActionAfterFailure((VFSAction)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailure == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSMoveAfterFailure((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileURI == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSReplyFileURI((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSReplyFileName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockRelease == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSAutoLockRelease((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockReleaseInterval == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSAutoLockReleaseInterval((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSLockReleaseSameNode == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSLockReleaseSameNode((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedLock == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSDistributedLock((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSStreaming == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSStreaming((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSBuild == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSBuild((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedTimeout == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSDistributedTimeout((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentities == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSSFTPIdentities((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentityPassPhrase == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSSFTPIdentityPassPhrase((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPUserDirIsRoot == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSSFTPUserDirIsRoot((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.javaNamingFactoryInitial == event.getAffectedEditor()) {
			inboundEndpoint.setJavaNamingFactoryInitial((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.javaNamingProviderUrl == event.getAffectedEditor()) {
			inboundEndpoint.setJavaNamingProviderUrl((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryJNDIName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSConnectionFactoryJNDIName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSConnectionFactoryType((JMSConnectionFactoryType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSConcurrentConsumers == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSConcurrentConsumers((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSDestination == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSDestination((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionTransacted == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSSessionTransacted((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionAcknowledgement == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSSessionAcknowledgement((JMSSessionAcknowledgement)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSCacheLevel == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSCacheLevel((JMSCacheLevel)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSUserName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSUserName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSPassword == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSJMSSpecVersion == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSJMSSpecVersion((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionDurable == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSSubscriptionDurable((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberClientID == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSDurableSubscriberClientID((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSMessageSelector == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSMessageSelector((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetryDuration == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSRetryDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveTimestampFormat == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSMoveTimestampFormat((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAttribute == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFileSortAttribute((VFSFileSort)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAscending == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSFileSortAscending((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSSubFolderTimestampFormat == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSSubFolderTimestampFormat((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSCreateFolder == event.getAffectedEditor()) {
			inboundEndpoint.setTransportVFSCreateFolder((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSReceiveTimeout == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSReceiveTimeout((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSContentType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentTypeProperty == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSContentTypeProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSReplyDestination == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSReplyDestination((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSPubSubNoLocal == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSPubSubNoLocal((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSDurableSubscriberName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSBrokerType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSBrokerType((JMSBrokerType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTConnectionFactory == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTConnectionFactory((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerHostName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTServerHostName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerPort == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTServerPort((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTopicName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTTopicName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionQOS == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSubscriptionQOS((MQTTSubscriptionQOS)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSessionClean == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSessionClean((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslEnable == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSslEnable((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTemporaryStoreDirectory == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTTemporaryStoreDirectory((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionUsername == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSubscriptionUsername((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionPassword == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSubscriptionPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTClientId == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTClientId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.truststore == event.getAffectedEditor()) {
			inboundEndpoint.setTruststore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.keystore == event.getAffectedEditor()) {
			inboundEndpoint.setKeystore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.sslVerifyClient == event.getAffectedEditor()) {
			inboundEndpoint.setSslVerifyClient((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.sslProtocol == event.getAffectedEditor()) {
			inboundEndpoint.setSslProtocol((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.httpsProtocols == event.getAffectedEditor()) {
			inboundEndpoint.setHttpsProtocols((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.certificateRevocationVerifier == event.getAffectedEditor()) {
			inboundEndpoint.setCertificateRevocationVerifier((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7Port == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHL7Port((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7AutoAck == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHL7AutoAck((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7MessagePreProcessor == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHL7MessagePreProcessor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7CharSet == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHL7CharSet((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7TimeOut == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHL7TimeOut((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7ValidateMessage == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHL7ValidateMessage((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7BuildInvalidMessages == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHL7BuildInvalidMessages((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7PassThroughInvalidMessages == event.getAffectedEditor()) {
			inboundEndpoint.setInboundHL7PassThroughInvalidMessages((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnect == event.getAffectedEditor()) {
			inboundEndpoint.setZookeeperConnect((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.groupId == event.getAffectedEditor()) {
			inboundEndpoint.setGroupId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.contentType == event.getAffectedEditor()) {
			inboundEndpoint.setContentType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.consumerType == event.getAffectedEditor()) {
			inboundEndpoint.setConsumerType((ConsumerType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.topicsOrTopicFilter == event.getAffectedEditor()) {
			inboundEndpoint.setTopicsOrTopicFilter((TopicsType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.topicsName == event.getAffectedEditor()) {
			inboundEndpoint.setTopicsName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.topicFilterFrom == event.getAffectedEditor()) {
			inboundEndpoint.setTopicFilterFrom((TopicFilterFromType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.topicFilterName == event.getAffectedEditor()) {
			inboundEndpoint.setTopicFilterName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerTopic == event.getAffectedEditor()) {
			inboundEndpoint.setSimpleConsumerTopic((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerBrokers == event.getAffectedEditor()) {
			inboundEndpoint.setSimpleConsumerBrokers((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPort == event.getAffectedEditor()) {
			inboundEndpoint.setSimpleConsumerPort((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPartition == event.getAffectedEditor()) {
			inboundEndpoint.setSimpleConsumerPartition((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerMaxMessagesToRead == event.getAffectedEditor()) {
			inboundEndpoint.setSimpleConsumerMaxMessagesToRead((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.threadCount == event.getAffectedEditor()) {
			inboundEndpoint.setThreadCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.consumerId == event.getAffectedEditor()) {
			inboundEndpoint.setConsumerId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.socketTimeoutMs == event.getAffectedEditor()) {
			inboundEndpoint.setSocketTimeoutMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.socketReceiveBufferBytes == event.getAffectedEditor()) {
			inboundEndpoint.setSocketReceiveBufferBytes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.fetchMessageMaxBytes == event.getAffectedEditor()) {
			inboundEndpoint.setFetchMessageMaxBytes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.numConsumerFetches == event.getAffectedEditor()) {
			inboundEndpoint.setNumConsumerFetches((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.autoCommitEnable == event.getAffectedEditor()) {
			inboundEndpoint.setAutoCommitEnable((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.autoCommitIntervalMs == event.getAffectedEditor()) {
			inboundEndpoint.setAutoCommitIntervalMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.queuedMaxMessageChunks == event.getAffectedEditor()) {
			inboundEndpoint.setQueuedMaxMessageChunks((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.rebalanceMaxRetries == event.getAffectedEditor()) {
			inboundEndpoint.setRebalanceMaxRetries((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.fetchMinBytes == event.getAffectedEditor()) {
			inboundEndpoint.setFetchMinBytes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.fetchWaitMaxMs == event.getAffectedEditor()) {
			inboundEndpoint.setFetchWaitMaxMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.rebalanceBackoffMs == event.getAffectedEditor()) {
			inboundEndpoint.setRebalanceBackoffMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.refreshLeaderBackoffMs == event.getAffectedEditor()) {
			inboundEndpoint.setRefreshLeaderBackoffMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.autoOffsetReset == event.getAffectedEditor()) {
			inboundEndpoint.setAutoOffsetReset((AutoOffsetResetType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.consumerTimeoutMs == event.getAffectedEditor()) {
			inboundEndpoint.setConsumerTimeoutMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.excludeInternalTopics == event.getAffectedEditor()) {
			inboundEndpoint.setExcludeInternalTopics((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.partitionAssignmentStrategy == event.getAffectedEditor()) {
			inboundEndpoint.setPartitionAssignmentStrategy((PartitionAssignmentStrategyType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.clientId == event.getAffectedEditor()) {
			inboundEndpoint.setClientId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.zookeeperSessionTimeoutMs == event.getAffectedEditor()) {
			inboundEndpoint.setZookeeperSessionTimeoutMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnectionTimeoutMs == event.getAffectedEditor()) {
			inboundEndpoint.setZookeeperConnectionTimeoutMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.zookeeperSyncTimeMs == event.getAffectedEditor()) {
			inboundEndpoint.setZookeeperSyncTimeMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.offsetsStorage == event.getAffectedEditor()) {
			inboundEndpoint.setOffsetsStorage((OffsetsStorageType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelBackoffMs == event.getAffectedEditor()) {
			inboundEndpoint.setOffsetsChannelBackoffMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelSocketTimeoutMs == event.getAffectedEditor()) {
			inboundEndpoint.setOffsetsChannelSocketTimeoutMs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.offsetsCommitMaxRetries == event.getAffectedEditor()) {
			inboundEndpoint.setOffsetsCommitMaxRetries((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.dualCommitEnabled == event.getAffectedEditor()) {
			inboundEndpoint.setDualCommitEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmHost == event.getAffectedEditor()) {
			inboundEndpoint.setInboundCxfRmHost((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmPort == event.getAffectedEditor()) {
			inboundEndpoint.setInboundCxfRmPort((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmConfigFile == event.getAffectedEditor()) {
			inboundEndpoint.setInboundCxfRmConfigFile((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.enableSSL == event.getAffectedEditor()) {
			inboundEndpoint.setEnableSSL((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.serviceParameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, serviceParametersSettings, editingContext.getAdapterFactory());
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
				serviceParametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				serviceParametersSettings.move(event.getNewIndex(), (InboundEndpointParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.suspend == event.getAffectedEditor()) {
			inboundEndpoint.setSuspend((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionFactory == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionFactory((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerHostName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqServerHostName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPort == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqServerPort((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerUserName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqServerUserName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPassword == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqServerPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqQueueName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqExchangeName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDurable == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqQueueDurable((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueExclusive == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqQueueExclusive((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoDelete == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqQueueAutoDelete((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoAck == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqQueueAutoAck((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueRoutingKey == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqQueueRoutingKey((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDeliveryMode == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqQueueDeliveryMode((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqExchangeType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeDurable == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqExchangeDurable((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDelete == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqExchangeAutoDelete((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerVirtualHost == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqServerVirtualHost((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryHeartbeat == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqFactoryHeartbeat((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslEnabled == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionSslEnabled((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreLocation == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionSslKeystoreLocation((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionSslKeystoreType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystorePassword == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionSslKeystorePassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreLocation == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionSslTruststoreLocation((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionSslTruststoreType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststorePassword == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionSslTruststorePassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslVersion == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionSslVersion((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMessageContentType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqMessageContentType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryCount == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionRetryCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryInterval == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConnectionRetryInterval((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerRetryInterval == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqServerRetryInterval((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsInboundPort == event.getAffectedEditor()) {
			inboundEndpoint.setWsInboundPort((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsClientSideBroadcastLevel == event.getAffectedEditor()) {
			inboundEndpoint.setWsClientSideBroadcastLevel((WSClientSideBroadcastLevel)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchSequence == event.getAffectedEditor()) {
			inboundEndpoint.setWsOutflowDispatchSequence((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchFaultSequence == event.getAffectedEditor()) {
			inboundEndpoint.setWsOutflowDispatchFaultSequence((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsBossThreadPoolSize == event.getAffectedEditor()) {
			inboundEndpoint.setWsBossThreadPoolSize((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsWorkerThreadPoolSize == event.getAffectedEditor()) {
			inboundEndpoint.setWsWorkerThreadPoolSize((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsSubprotocolHandlerClass == event.getAffectedEditor()) {
			inboundEndpoint.setWsSubprotocolHandlerClass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsPipelineHandlerClass == event.getAffectedEditor()) {
			inboundEndpoint.setWsPipelineHandlerClass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportFeedURL == event.getAffectedEditor()) {
			inboundEndpoint.setTransportFeedURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportFeedType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportFeedType((FeedType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.traceEnabled == event.getAffectedEditor()) {
			inboundEndpoint.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.statisticsEnabled == event.getAffectedEditor()) {
			inboundEndpoint.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetriesBeforeSuspension == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSRetriesBeforeSuspension((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSResetConnectionOnPollingSuspension == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSResetConnectionOnPollingSuspension((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSPollingSuspensionPeriod == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSPollingSuspensionPeriod((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreLocation == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSslKeystoreLocation((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSslKeystoreType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystorePassword == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSslKeystorePassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreLocation == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSslTruststoreLocation((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSslTruststoreType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststorePassword == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSslTruststorePassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslVersion == event.getAffectedEditor()) {
			inboundEndpoint.setTransportMQTTSslVersion((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStoreFile == event.getAffectedEditor()) {
			inboundEndpoint.setWssSslKeyStoreFile((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStorePass == event.getAffectedEditor()) {
			inboundEndpoint.setWssSslKeyStorePass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStoreFile == event.getAffectedEditor()) {
			inboundEndpoint.setWssSslTrustStoreFile((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStorePass == event.getAffectedEditor()) {
			inboundEndpoint.setWssSslTrustStorePass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wssSslCertPass == event.getAffectedEditor()) {
			inboundEndpoint.setWssSslCertPass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsDefaultContentType == event.getAffectedEditor()) {
			inboundEndpoint.setWsDefaultContentType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusCode == event.getAffectedEditor()) {
			inboundEndpoint.setWsShutdownStatusCode((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusMessage == event.getAffectedEditor()) {
			inboundEndpoint.setWsShutdownStatusMessage((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wsUsePortOffset == event.getAffectedEditor()) {
			inboundEndpoint.setWsUsePortOffset((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wssSslProtocols == event.getAffectedEditor()) {
			inboundEndpoint.setWssSslProtocols((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.wssSslCipherSuites == event.getAffectedEditor()) {
			inboundEndpoint.setWssSslCipherSuites((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQos == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConsumerQos((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosKey == event.getAffectedEditor()) {
			// Start of user code for updateTransportRabbitMqConsumerQosKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                inboundEndpoint.setTransportRabbitMqConsumerQosKey(rkp);
            } else {
                inboundEndpoint.setTransportRabbitMqConsumerQosKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
            // End of user code
			
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosType == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConsumerQosType((PayloadFormatType)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSDBUrl == event.getAffectedEditor()) {
			inboundEndpoint.setTransportJMSDBUrl((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqAutoDeclare == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqAutoDeclare((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMaxDeadLetteredCount == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqMaxDeadLetteredCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqRequeueDelay == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqRequeueDelay((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDeclare == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqExchangeAutoDeclare((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerTag == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqConsumerTag((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorQueueRoutingKey == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqErrorQueueRoutingKey((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorExchangeName == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqErrorExchangeName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryConnectionTimeout == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqFactoryConnectionTimeout((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryNetworkRecoveryInterval == event.getAffectedEditor()) {
			inboundEndpoint.setTransportRabbitMqFactoryNetworkRecoveryInterval((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			InboundEndpointPropertiesEditionPart basePart = (InboundEndpointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Type().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.type))
				basePart.setType((InboundEndpointType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Class().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.class_)) {
				if (msg.getNewValue() != null) {
					basePart.setClass_(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setClass_("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Protocol().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.protocol)) {
				if (msg.getNewValue() != null) {
					basePart.setProtocol(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setProtocol("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundEndpointBehaviour().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundEndpointBehaviour))
				basePart.setInboundEndpointBehaviour((InboundEndpointBehaviourType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHttpPort().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHttpPort)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundHttpPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundHttpPort("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeCore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeCore)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundWorkerPoolSizeCore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundWorkerPoolSizeCore("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeMax().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeMax)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundWorkerPoolSizeMax(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundWorkerPoolSizeMax("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerThreadKeepAliveSec().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerThreadKeepAliveSec)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundWorkerThreadKeepAliveSec(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundWorkerThreadKeepAliveSec("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolQueueLength().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolQueueLength)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundWorkerPoolQueueLength(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundWorkerPoolQueueLength("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadGroupId().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundThreadGroupId)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundThreadGroupId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundThreadGroupId("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadId().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundThreadId)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundThreadId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundThreadId("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_DispatchFilterPattern().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.dispatchFilterPattern)) {
				if (msg.getNewValue() != null) {
					basePart.setDispatchFilterPattern(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDispatchFilterPattern("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Interval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.interval)) {
				if (msg.getNewValue() != null) {
					basePart.setInterval(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Sequential().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.sequential))
				basePart.setSequential((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Coordination().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.coordination))
				basePart.setCoordination((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileURI().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileURI)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSFileURI(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSFileURI("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Wso2mbConnectionUrl().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wso2mbConnectionUrl)) {
				if (msg.getNewValue() != null) {
					basePart.setWso2mbConnectionUrl(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWso2mbConnectionUrl("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSContentType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSContentType)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSContentType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSContentType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileNamePattern().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileNamePattern)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSFileNamePattern(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSFileNamePattern("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSFileProcessInterval(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSFileProcessInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessCount)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSFileProcessCount(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSFileProcessCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLocking().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSLocking))
				basePart.setTransportVFSLocking((Enable)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMaxRetryCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMaxRetryCount)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSMaxRetryCount(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSMaxRetryCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailedMove().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailedMove)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSMoveAfterFailedMove(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSMoveAfterFailedMove("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReconnectTimeout().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSReconnectTimeout)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSReconnectTimeout(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSReconnectTimeout("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSharedSubscription().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSharedSubscription))
				basePart.setTransportJMSSharedSubscription((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSSubscriptionName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSSubscriptionName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPinnedServers().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSPinnedServers)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSPinnedServers(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSPinnedServers("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterProcess().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterProcess))
				basePart.setTransportVFSActionAfterProcess((VFSAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterProcess().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterProcess)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSMoveAfterProcess(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSMoveAfterProcess("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterErrors().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterErrors))
				basePart.setTransportVFSActionAfterErrors((VFSAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterErrors().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterErrors)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSMoveAfterErrors(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSMoveAfterErrors("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSFailedRecordsFileName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSFailedRecordsFileName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileDestination().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileDestination)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSFailedRecordsFileDestination(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSFailedRecordsFileDestination("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveFailedRecordTimestampFormat().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveFailedRecordTimestampFormat)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSMoveFailedRecordTimestampFormat(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSMoveFailedRecordTimestampFormat("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordNextRetryDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordNextRetryDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSFailedRecordNextRetryDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSFailedRecordNextRetryDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterFailure().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterFailure))
				basePart.setTransportVFSActionAfterFailure((VFSAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailure().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailure)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSMoveAfterFailure(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSMoveAfterFailure("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileURI().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileURI)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSReplyFileURI(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSReplyFileURI("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSReplyFileName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSReplyFileName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockRelease().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockRelease))
				basePart.setTransportVFSAutoLockRelease((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockReleaseInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockReleaseInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSAutoLockReleaseInterval(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSAutoLockReleaseInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLockReleaseSameNode().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSLockReleaseSameNode))
				basePart.setTransportVFSLockReleaseSameNode((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedLock().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedLock))
				basePart.setTransportVFSDistributedLock((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSStreaming().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSStreaming))
				basePart.setTransportVFSStreaming((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSBuild().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSBuild))
				basePart.setTransportVFSBuild((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedTimeout().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedTimeout)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSDistributedTimeout(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSDistributedTimeout("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentities().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentities)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSSFTPIdentities(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSSFTPIdentities("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentityPassPhrase().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentityPassPhrase)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSSFTPIdentityPassPhrase(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSSFTPIdentityPassPhrase("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPUserDirIsRoot().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPUserDirIsRoot))
				basePart.setTransportVFSSFTPUserDirIsRoot((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingFactoryInitial().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.javaNamingFactoryInitial)) {
				if (msg.getNewValue() != null) {
					basePart.setJavaNamingFactoryInitial(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJavaNamingFactoryInitial("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingProviderUrl().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.javaNamingProviderUrl)) {
				if (msg.getNewValue() != null) {
					basePart.setJavaNamingProviderUrl(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJavaNamingProviderUrl("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryJNDIName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryJNDIName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSConnectionFactoryJNDIName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSConnectionFactoryJNDIName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryType))
				basePart.setTransportJMSConnectionFactoryType((JMSConnectionFactoryType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConcurrentConsumers().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSConcurrentConsumers)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSConcurrentConsumers(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSConcurrentConsumers("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDestination().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSDestination)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSDestination(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSDestination("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionTransacted().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionTransacted))
				basePart.setTransportJMSSessionTransacted((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionAcknowledgement().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionAcknowledgement))
				basePart.setTransportJMSSessionAcknowledgement((JMSSessionAcknowledgement)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSCacheLevel().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSCacheLevel))
				basePart.setTransportJMSCacheLevel((JMSCacheLevel)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSUserName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSUserName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSUserName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSUserName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSPassword)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSJMSSpecVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSJMSSpecVersion)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSJMSSpecVersion(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSJMSSpecVersion("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionDurable().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionDurable)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSSubscriptionDurable(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSSubscriptionDurable("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberClientID().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberClientID)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSDurableSubscriberClientID(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSDurableSubscriberClientID("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSMessageSelector().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSMessageSelector)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSMessageSelector(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSMessageSelector("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetryDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetryDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSRetryDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSRetryDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveTimestampFormat().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveTimestampFormat)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSMoveTimestampFormat(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSMoveTimestampFormat("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAttribute().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAttribute))
				basePart.setTransportVFSFileSortAttribute((VFSFileSort)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAscending().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAscending))
				basePart.setTransportVFSFileSortAscending((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSubFolderTimestampFormat().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSSubFolderTimestampFormat)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportVFSSubFolderTimestampFormat(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportVFSSubFolderTimestampFormat("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSCreateFolder().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportVFSCreateFolder))
				basePart.setTransportVFSCreateFolder((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReceiveTimeout().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSReceiveTimeout)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSReceiveTimeout(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSReceiveTimeout("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentType)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSContentType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSContentType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentTypeProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentTypeProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSContentTypeProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSContentTypeProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReplyDestination().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSReplyDestination)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSReplyDestination(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSReplyDestination("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPubSubNoLocal().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSPubSubNoLocal)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSPubSubNoLocal(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSPubSubNoLocal("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSDurableSubscriberName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSDurableSubscriberName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSBrokerType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSBrokerType))
				basePart.setTransportJMSBrokerType((JMSBrokerType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTConnectionFactory().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTConnectionFactory)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTConnectionFactory(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTConnectionFactory("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerHostName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerHostName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTServerHostName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTServerHostName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerPort().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerPort)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTServerPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTServerPort("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTopicName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTopicName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTTopicName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTTopicName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionQOS().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionQOS))
				basePart.setTransportMQTTSubscriptionQOS((MQTTSubscriptionQOS)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSessionClean().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSessionClean))
				basePart.setTransportMQTTSessionClean((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslEnable().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslEnable)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSslEnable(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSslEnable("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTemporaryStoreDirectory().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTemporaryStoreDirectory)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTTemporaryStoreDirectory(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTTemporaryStoreDirectory("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionUsername().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionUsername)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSubscriptionUsername(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSubscriptionUsername("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionPassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionPassword)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSubscriptionPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSubscriptionPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTClientId().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTClientId)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTClientId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTClientId("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Truststore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.truststore)) {
				if (msg.getNewValue() != null) {
					basePart.setTruststore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTruststore("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Keystore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.keystore)) {
				if (msg.getNewValue() != null) {
					basePart.setKeystore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setKeystore("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SslVerifyClient().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.sslVerifyClient)) {
				if (msg.getNewValue() != null) {
					basePart.setSslVerifyClient(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSslVerifyClient("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SslProtocol().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.sslProtocol)) {
				if (msg.getNewValue() != null) {
					basePart.setSslProtocol(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSslProtocol("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_HttpsProtocols().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.httpsProtocols)) {
				if (msg.getNewValue() != null) {
					basePart.setHttpsProtocols(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setHttpsProtocols("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_CertificateRevocationVerifier().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.certificateRevocationVerifier)) {
				if (msg.getNewValue() != null) {
					basePart.setCertificateRevocationVerifier(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setCertificateRevocationVerifier("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7Port().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7Port)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundHL7Port(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundHL7Port("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7AutoAck().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7AutoAck))
				basePart.setInboundHL7AutoAck((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7MessagePreProcessor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7MessagePreProcessor)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundHL7MessagePreProcessor(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundHL7MessagePreProcessor("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7CharSet().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7CharSet)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundHL7CharSet(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundHL7CharSet("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7TimeOut().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7TimeOut)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundHL7TimeOut(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundHL7TimeOut("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7ValidateMessage().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7ValidateMessage))
				basePart.setInboundHL7ValidateMessage((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7BuildInvalidMessages().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7BuildInvalidMessages))
				basePart.setInboundHL7BuildInvalidMessages((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7PassThroughInvalidMessages().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundHL7PassThroughInvalidMessages))
				basePart.setInboundHL7PassThroughInvalidMessages((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnect().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnect)) {
				if (msg.getNewValue() != null) {
					basePart.setZookeeperConnect(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setZookeeperConnect("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_GroupId().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.groupId)) {
				if (msg.getNewValue() != null) {
					basePart.setGroupId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setGroupId("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ContentType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.contentType)) {
				if (msg.getNewValue() != null) {
					basePart.setContentType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setContentType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.consumerType))
				basePart.setConsumerType((ConsumerType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TopicsOrTopicFilter().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.topicsOrTopicFilter))
				basePart.setTopicsOrTopicFilter((TopicsType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TopicsName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.topicsName)) {
				if (msg.getNewValue() != null) {
					basePart.setTopicsName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTopicsName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterFrom().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.topicFilterFrom))
				basePart.setTopicFilterFrom((TopicFilterFromType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.topicFilterName)) {
				if (msg.getNewValue() != null) {
					basePart.setTopicFilterName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTopicFilterName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerTopic().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerTopic)) {
				if (msg.getNewValue() != null) {
					basePart.setSimpleConsumerTopic(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSimpleConsumerTopic("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerBrokers().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerBrokers)) {
				if (msg.getNewValue() != null) {
					basePart.setSimpleConsumerBrokers(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSimpleConsumerBrokers("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPort().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPort)) {
				if (msg.getNewValue() != null) {
					basePart.setSimpleConsumerPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSimpleConsumerPort("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPartition().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPartition)) {
				if (msg.getNewValue() != null) {
					basePart.setSimpleConsumerPartition(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSimpleConsumerPartition("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerMaxMessagesToRead().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerMaxMessagesToRead)) {
				if (msg.getNewValue() != null) {
					basePart.setSimpleConsumerMaxMessagesToRead(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSimpleConsumerMaxMessagesToRead("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ThreadCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.threadCount)) {
				if (msg.getNewValue() != null) {
					basePart.setThreadCount(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setThreadCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerId().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.consumerId)) {
				if (msg.getNewValue() != null) {
					basePart.setConsumerId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConsumerId("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SocketTimeoutMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.socketTimeoutMs)) {
				if (msg.getNewValue() != null) {
					basePart.setSocketTimeoutMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSocketTimeoutMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_SocketReceiveBufferBytes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.socketReceiveBufferBytes)) {
				if (msg.getNewValue() != null) {
					basePart.setSocketReceiveBufferBytes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSocketReceiveBufferBytes("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_FetchMessageMaxBytes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.fetchMessageMaxBytes)) {
				if (msg.getNewValue() != null) {
					basePart.setFetchMessageMaxBytes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFetchMessageMaxBytes("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_NumConsumerFetches().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.numConsumerFetches)) {
				if (msg.getNewValue() != null) {
					basePart.setNumConsumerFetches(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNumConsumerFetches("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitEnable().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.autoCommitEnable))
				basePart.setAutoCommitEnable((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitIntervalMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.autoCommitIntervalMs)) {
				if (msg.getNewValue() != null) {
					basePart.setAutoCommitIntervalMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAutoCommitIntervalMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_QueuedMaxMessageChunks().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.queuedMaxMessageChunks)) {
				if (msg.getNewValue() != null) {
					basePart.setQueuedMaxMessageChunks(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setQueuedMaxMessageChunks("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceMaxRetries().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.rebalanceMaxRetries)) {
				if (msg.getNewValue() != null) {
					basePart.setRebalanceMaxRetries(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRebalanceMaxRetries("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_FetchMinBytes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.fetchMinBytes)) {
				if (msg.getNewValue() != null) {
					basePart.setFetchMinBytes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFetchMinBytes("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_FetchWaitMaxMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.fetchWaitMaxMs)) {
				if (msg.getNewValue() != null) {
					basePart.setFetchWaitMaxMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFetchWaitMaxMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceBackoffMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.rebalanceBackoffMs)) {
				if (msg.getNewValue() != null) {
					basePart.setRebalanceBackoffMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRebalanceBackoffMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_RefreshLeaderBackoffMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.refreshLeaderBackoffMs)) {
				if (msg.getNewValue() != null) {
					basePart.setRefreshLeaderBackoffMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRefreshLeaderBackoffMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_AutoOffsetReset().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.autoOffsetReset))
				basePart.setAutoOffsetReset((AutoOffsetResetType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerTimeoutMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.consumerTimeoutMs)) {
				if (msg.getNewValue() != null) {
					basePart.setConsumerTimeoutMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConsumerTimeoutMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ExcludeInternalTopics().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.excludeInternalTopics))
				basePart.setExcludeInternalTopics((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_PartitionAssignmentStrategy().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.partitionAssignmentStrategy))
				basePart.setPartitionAssignmentStrategy((PartitionAssignmentStrategyType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ClientId().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.clientId)) {
				if (msg.getNewValue() != null) {
					basePart.setClientId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setClientId("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSessionTimeoutMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.zookeeperSessionTimeoutMs)) {
				if (msg.getNewValue() != null) {
					basePart.setZookeeperSessionTimeoutMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setZookeeperSessionTimeoutMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnectionTimeoutMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnectionTimeoutMs)) {
				if (msg.getNewValue() != null) {
					basePart.setZookeeperConnectionTimeoutMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setZookeeperConnectionTimeoutMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSyncTimeMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.zookeeperSyncTimeMs)) {
				if (msg.getNewValue() != null) {
					basePart.setZookeeperSyncTimeMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setZookeeperSyncTimeMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsStorage().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.offsetsStorage))
				basePart.setOffsetsStorage((OffsetsStorageType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelBackoffMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelBackoffMs)) {
				if (msg.getNewValue() != null) {
					basePart.setOffsetsChannelBackoffMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOffsetsChannelBackoffMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelSocketTimeoutMs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelSocketTimeoutMs)) {
				if (msg.getNewValue() != null) {
					basePart.setOffsetsChannelSocketTimeoutMs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOffsetsChannelSocketTimeoutMs("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsCommitMaxRetries().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.offsetsCommitMaxRetries)) {
				if (msg.getNewValue() != null) {
					basePart.setOffsetsCommitMaxRetries(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOffsetsCommitMaxRetries("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_DualCommitEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.dualCommitEnabled))
				basePart.setDualCommitEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmHost().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmHost)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundCxfRmHost(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundCxfRmHost("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmPort().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmPort)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundCxfRmPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundCxfRmPort("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmConfigFile().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmConfigFile)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundCxfRmConfigFile(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInboundCxfRmConfigFile("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_EnableSSL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.enableSSL))
				basePart.setEnableSSL((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_ServiceParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.serviceParameters))
				basePart.updateServiceParameters();
			if (EsbPackage.eINSTANCE.getInboundEndpoint_Suspend().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.suspend))
				basePart.setSuspend((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionFactory().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionFactory)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionFactory(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionFactory("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerHostName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerHostName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqServerHostName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqServerHostName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPort().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPort)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqServerPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqServerPort("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerUserName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerUserName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqServerUserName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqServerUserName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPassword)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqServerPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqServerPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqQueueName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqQueueName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqExchangeName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqExchangeName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDurable().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDurable)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqQueueDurable(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqQueueDurable("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueExclusive().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueExclusive)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqQueueExclusive(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqQueueExclusive("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoDelete().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoDelete)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqQueueAutoDelete(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqQueueAutoDelete("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoAck().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoAck)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqQueueAutoAck(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqQueueAutoAck("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueRoutingKey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueRoutingKey)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqQueueRoutingKey(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqQueueRoutingKey("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDeliveryMode().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDeliveryMode)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqQueueDeliveryMode(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqQueueDeliveryMode("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeType)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqExchangeType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqExchangeType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeDurable().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeDurable)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqExchangeDurable(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqExchangeDurable("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDelete().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDelete)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqExchangeAutoDelete(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqExchangeAutoDelete("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerVirtualHost().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerVirtualHost)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqServerVirtualHost(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqServerVirtualHost("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryHeartbeat().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryHeartbeat)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqFactoryHeartbeat(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqFactoryHeartbeat("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslEnabled)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionSslEnabled(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionSslEnabled("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreLocation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreLocation)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionSslKeystoreLocation(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionSslKeystoreLocation("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreType)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionSslKeystoreType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionSslKeystoreType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystorePassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystorePassword)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionSslKeystorePassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionSslKeystorePassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreLocation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreLocation)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionSslTruststoreLocation(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionSslTruststoreLocation("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreType)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionSslTruststoreType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionSslTruststoreType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststorePassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststorePassword)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionSslTruststorePassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionSslTruststorePassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslVersion)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionSslVersion(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionSslVersion("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMessageContentType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMessageContentType)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqMessageContentType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqMessageContentType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryCount)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionRetryCount(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionRetryCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConnectionRetryInterval(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConnectionRetryInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerRetryInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerRetryInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqServerRetryInterval(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqServerRetryInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsInboundPort().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsInboundPort)) {
				if (msg.getNewValue() != null) {
					basePart.setWsInboundPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsInboundPort("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsClientSideBroadcastLevel().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsClientSideBroadcastLevel))
				basePart.setWsClientSideBroadcastLevel((WSClientSideBroadcastLevel)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchSequence().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchSequence)) {
				if (msg.getNewValue() != null) {
					basePart.setWsOutflowDispatchSequence(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsOutflowDispatchSequence("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchFaultSequence().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchFaultSequence)) {
				if (msg.getNewValue() != null) {
					basePart.setWsOutflowDispatchFaultSequence(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsOutflowDispatchFaultSequence("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsBossThreadPoolSize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsBossThreadPoolSize)) {
				if (msg.getNewValue() != null) {
					basePart.setWsBossThreadPoolSize(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsBossThreadPoolSize("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsWorkerThreadPoolSize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsWorkerThreadPoolSize)) {
				if (msg.getNewValue() != null) {
					basePart.setWsWorkerThreadPoolSize(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsWorkerThreadPoolSize("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsSubprotocolHandlerClass().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsSubprotocolHandlerClass)) {
				if (msg.getNewValue() != null) {
					basePart.setWsSubprotocolHandlerClass(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsSubprotocolHandlerClass("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsPipelineHandlerClass().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsPipelineHandlerClass)) {
				if (msg.getNewValue() != null) {
					basePart.setWsPipelineHandlerClass(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsPipelineHandlerClass("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportFeedURL)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportFeedURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportFeedURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportFeedType))
				basePart.setTransportFeedType((FeedType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetriesBeforeSuspension().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetriesBeforeSuspension)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSRetriesBeforeSuspension(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSRetriesBeforeSuspension("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSResetConnectionOnPollingSuspension().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSResetConnectionOnPollingSuspension))
				basePart.setTransportJMSResetConnectionOnPollingSuspension((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPollingSuspensionPeriod().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSPollingSuspensionPeriod)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSPollingSuspensionPeriod(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSPollingSuspensionPeriod("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreLocation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreLocation)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSslKeystoreLocation(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSslKeystoreLocation("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreType)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSslKeystoreType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSslKeystoreType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystorePassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystorePassword)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSslKeystorePassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSslKeystorePassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreLocation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreLocation)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSslTruststoreLocation(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSslTruststoreLocation("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreType)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSslTruststoreType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSslTruststoreType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststorePassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststorePassword)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSslTruststorePassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSslTruststorePassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslVersion)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportMQTTSslVersion(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportMQTTSslVersion("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStoreFile().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStoreFile)) {
				if (msg.getNewValue() != null) {
					basePart.setWssSslKeyStoreFile(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWssSslKeyStoreFile("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStorePass().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStorePass)) {
				if (msg.getNewValue() != null) {
					basePart.setWssSslKeyStorePass(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWssSslKeyStorePass("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStoreFile().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStoreFile)) {
				if (msg.getNewValue() != null) {
					basePart.setWssSslTrustStoreFile(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWssSslTrustStoreFile("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStorePass().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStorePass)) {
				if (msg.getNewValue() != null) {
					basePart.setWssSslTrustStorePass(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWssSslTrustStorePass("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCertPass().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslCertPass)) {
				if (msg.getNewValue() != null) {
					basePart.setWssSslCertPass(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWssSslCertPass("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsDefaultContentType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsDefaultContentType)) {
				if (msg.getNewValue() != null) {
					basePart.setWsDefaultContentType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsDefaultContentType("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusCode().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusCode)) {
				if (msg.getNewValue() != null) {
					basePart.setWsShutdownStatusCode(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsShutdownStatusCode("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusMessage().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusMessage)) {
				if (msg.getNewValue() != null) {
					basePart.setWsShutdownStatusMessage(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsShutdownStatusMessage("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WsUsePortOffset().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wsUsePortOffset))
				basePart.setWsUsePortOffset((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WssSslProtocols().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslProtocols)) {
				if (msg.getNewValue() != null) {
					basePart.setWssSslProtocols(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWssSslProtocols("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCipherSuites().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.wssSslCipherSuites)) {
				if (msg.getNewValue() != null) {
					basePart.setWssSslCipherSuites(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWssSslCipherSuites("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQos().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQos)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConsumerQos(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConsumerQos("");
				}
			}
					// Start of user code for transportRabbitMqConsumerQosKey live update
            if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosKey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setRabbitMqConsumerQosKey((RegistryKeyProperty)msg.getNewValue());
                } else {
                    basePart.setRabbitMqConsumerQosKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
            // End of user code
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosType))
				basePart.setTransportRabbitMqConsumerQosType((PayloadFormatType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDBUrl().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportJMSDBUrl)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportJMSDBUrl(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportJMSDBUrl("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqAutoDeclare().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqAutoDeclare))
				basePart.setTransportRabbitMqAutoDeclare((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMaxDeadLetteredCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMaxDeadLetteredCount)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqMaxDeadLetteredCount(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqMaxDeadLetteredCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqRequeueDelay().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqRequeueDelay)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqRequeueDelay(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqRequeueDelay("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDeclare().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDeclare))
				basePart.setTransportRabbitMqExchangeAutoDeclare((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerTag().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerTag)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqConsumerTag(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqConsumerTag("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorQueueRoutingKey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorQueueRoutingKey)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqErrorQueueRoutingKey(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqErrorQueueRoutingKey("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorExchangeName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorExchangeName)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqErrorExchangeName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqErrorExchangeName("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryConnectionTimeout().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryConnectionTimeout)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqFactoryConnectionTimeout(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqFactoryConnectionTimeout("");
				}
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryNetworkRecoveryInterval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryNetworkRecoveryInterval)) {
				if (msg.getNewValue() != null) {
					basePart.setTransportRabbitMqFactoryNetworkRecoveryInterval(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransportRabbitMqFactoryNetworkRecoveryInterval("");
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
			EsbPackage.eINSTANCE.getInboundEndpoint_Name(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Type(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Class(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Protocol(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundEndpointBehaviour(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHttpPort(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeCore(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeMax(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerThreadKeepAliveSec(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolQueueLength(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadGroupId(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadId(),
			EsbPackage.eINSTANCE.getInboundEndpoint_DispatchFilterPattern(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Interval(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Sequential(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Coordination(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileURI(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Wso2mbConnectionUrl(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSContentType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileNamePattern(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessInterval(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessCount(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLocking(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMaxRetryCount(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailedMove(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReconnectTimeout(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSharedSubscription(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPinnedServers(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterProcess(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterProcess(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterErrors(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterErrors(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileDestination(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveFailedRecordTimestampFormat(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordNextRetryDuration(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterFailure(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailure(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileURI(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockRelease(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockReleaseInterval(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLockReleaseSameNode(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedLock(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSStreaming(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSBuild(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedTimeout(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentities(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentityPassPhrase(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPUserDirIsRoot(),
			EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingFactoryInitial(),
			EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingProviderUrl(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryJNDIName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConcurrentConsumers(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDestination(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionTransacted(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionAcknowledgement(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSCacheLevel(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSUserName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPassword(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSJMSSpecVersion(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionDurable(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberClientID(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSMessageSelector(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetryDuration(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveTimestampFormat(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAttribute(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAscending(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSubFolderTimestampFormat(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSCreateFolder(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReceiveTimeout(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentTypeProperty(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReplyDestination(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPubSubNoLocal(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSBrokerType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTConnectionFactory(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerHostName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerPort(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTopicName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionQOS(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSessionClean(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslEnable(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTemporaryStoreDirectory(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionUsername(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionPassword(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTClientId(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Truststore(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Keystore(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SslVerifyClient(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SslProtocol(),
			EsbPackage.eINSTANCE.getInboundEndpoint_HttpsProtocols(),
			EsbPackage.eINSTANCE.getInboundEndpoint_CertificateRevocationVerifier(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7Port(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7AutoAck(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7MessagePreProcessor(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7CharSet(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7TimeOut(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7ValidateMessage(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7BuildInvalidMessages(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7PassThroughInvalidMessages(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnect(),
			EsbPackage.eINSTANCE.getInboundEndpoint_GroupId(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ContentType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TopicsOrTopicFilter(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TopicsName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterFrom(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerTopic(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerBrokers(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPort(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPartition(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerMaxMessagesToRead(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ThreadCount(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerId(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SocketTimeoutMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_SocketReceiveBufferBytes(),
			EsbPackage.eINSTANCE.getInboundEndpoint_FetchMessageMaxBytes(),
			EsbPackage.eINSTANCE.getInboundEndpoint_NumConsumerFetches(),
			EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitEnable(),
			EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitIntervalMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_QueuedMaxMessageChunks(),
			EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceMaxRetries(),
			EsbPackage.eINSTANCE.getInboundEndpoint_FetchMinBytes(),
			EsbPackage.eINSTANCE.getInboundEndpoint_FetchWaitMaxMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceBackoffMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_RefreshLeaderBackoffMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_AutoOffsetReset(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerTimeoutMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ExcludeInternalTopics(),
			EsbPackage.eINSTANCE.getInboundEndpoint_PartitionAssignmentStrategy(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ClientId(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSessionTimeoutMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnectionTimeoutMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSyncTimeMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsStorage(),
			EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelBackoffMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelSocketTimeoutMs(),
			EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsCommitMaxRetries(),
			EsbPackage.eINSTANCE.getInboundEndpoint_DualCommitEnabled(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmHost(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmPort(),
			EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmConfigFile(),
			EsbPackage.eINSTANCE.getInboundEndpoint_EnableSSL(),
			EsbPackage.eINSTANCE.getInboundEndpoint_ServiceParameters(),
			EsbPackage.eINSTANCE.getInboundEndpoint_Suspend(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionFactory(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerHostName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPort(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerUserName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPassword(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDurable(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueExclusive(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoDelete(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoAck(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueRoutingKey(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDeliveryMode(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeDurable(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDelete(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerVirtualHost(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryHeartbeat(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslEnabled(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreLocation(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystorePassword(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreLocation(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststorePassword(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslVersion(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMessageContentType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryCount(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryInterval(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerRetryInterval(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsInboundPort(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsClientSideBroadcastLevel(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchSequence(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchFaultSequence(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsBossThreadPoolSize(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsWorkerThreadPoolSize(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsSubprotocolHandlerClass(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsPipelineHandlerClass(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedURL(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TraceEnabled(),
			EsbPackage.eINSTANCE.getInboundEndpoint_StatisticsEnabled(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetriesBeforeSuspension(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSResetConnectionOnPollingSuspension(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPollingSuspensionPeriod(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreLocation(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystorePassword(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreLocation(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststorePassword(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslVersion(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStoreFile(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStorePass(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStoreFile(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStorePass(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCertPass(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsDefaultContentType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusCode(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusMessage(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WsUsePortOffset(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WssSslProtocols(),
			EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCipherSuites(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQos(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosKey(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosType(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDBUrl(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqAutoDeclare(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMaxDeadLetteredCount(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqRequeueDelay(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDeclare(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerTag(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorQueueRoutingKey(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorExchangeName(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryConnectionTimeout(),
			EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryNetworkRecoveryInterval()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
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
				if (EsbViewsRepository.InboundEndpoint.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Name().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.type == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Type().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Type().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.class_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Class().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Class().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.protocol == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Protocol().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Protocol().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundEndpointBehaviour == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundEndpointBehaviour().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundEndpointBehaviour().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHttpPort == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHttpPort().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHttpPort().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeCore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeCore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeCore().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolSizeMax == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeMax().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolSizeMax().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerThreadKeepAliveSec == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerThreadKeepAliveSec().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerThreadKeepAliveSec().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundWorkerPoolQueueLength == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolQueueLength().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundWorkerPoolQueueLength().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundThreadGroupId == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadGroupId().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadGroupId().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundThreadId == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadId().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundThreadId().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.dispatchFilterPattern == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_DispatchFilterPattern().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_DispatchFilterPattern().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.interval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Interval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Interval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.sequential == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Sequential().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Sequential().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.coordination == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Coordination().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Coordination().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileURI == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileURI().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileURI().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wso2mbConnectionUrl == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Wso2mbConnectionUrl().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Wso2mbConnectionUrl().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSContentType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSContentType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSContentType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileNamePattern == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileNamePattern().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileNamePattern().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessInterval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileProcessCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileProcessCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSLocking == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLocking().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLocking().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMaxRetryCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMaxRetryCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMaxRetryCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailedMove == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailedMove().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailedMove().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSReconnectTimeout == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReconnectTimeout().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReconnectTimeout().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSharedSubscription == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSharedSubscription().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSharedSubscription().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSPinnedServers == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPinnedServers().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPinnedServers().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterProcess == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterProcess().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterProcess().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterProcess == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterProcess().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterProcess().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterErrors == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterErrors().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterErrors().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterErrors == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterErrors().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterErrors().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordsFileDestination == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileDestination().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordsFileDestination().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveFailedRecordTimestampFormat == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveFailedRecordTimestampFormat().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveFailedRecordTimestampFormat().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFailedRecordNextRetryDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordNextRetryDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFailedRecordNextRetryDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSActionAfterFailure == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterFailure().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSActionAfterFailure().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveAfterFailure == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailure().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveAfterFailure().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileURI == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileURI().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileURI().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSReplyFileName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSReplyFileName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockRelease == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockRelease().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockRelease().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSAutoLockReleaseInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockReleaseInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSAutoLockReleaseInterval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSLockReleaseSameNode == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLockReleaseSameNode().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSLockReleaseSameNode().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedLock == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedLock().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedLock().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSStreaming == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSStreaming().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSStreaming().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSBuild == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSBuild().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSBuild().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSDistributedTimeout == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedTimeout().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSDistributedTimeout().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentities == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentities().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentities().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPIdentityPassPhrase == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentityPassPhrase().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPIdentityPassPhrase().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSSFTPUserDirIsRoot == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPUserDirIsRoot().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSFTPUserDirIsRoot().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.javaNamingFactoryInitial == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingFactoryInitial().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingFactoryInitial().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.javaNamingProviderUrl == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingProviderUrl().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_JavaNamingProviderUrl().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryJNDIName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryJNDIName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryJNDIName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSConnectionFactoryType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConnectionFactoryType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSConcurrentConsumers == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConcurrentConsumers().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSConcurrentConsumers().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSDestination == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDestination().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDestination().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionTransacted == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionTransacted().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionTransacted().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSessionAcknowledgement == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionAcknowledgement().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSessionAcknowledgement().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSCacheLevel == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSCacheLevel().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSCacheLevel().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSUserName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSUserName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSUserName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSPassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSJMSSpecVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSJMSSpecVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSJMSSpecVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSSubscriptionDurable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionDurable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSSubscriptionDurable().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberClientID == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberClientID().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberClientID().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSMessageSelector == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSMessageSelector().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSMessageSelector().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetryDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetryDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetryDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSMoveTimestampFormat == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveTimestampFormat().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSMoveTimestampFormat().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAttribute == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAttribute().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAttribute().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSFileSortAscending == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAscending().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSFileSortAscending().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSSubFolderTimestampFormat == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSubFolderTimestampFormat().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSSubFolderTimestampFormat().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportVFSCreateFolder == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSCreateFolder().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportVFSCreateFolder().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSReceiveTimeout == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReceiveTimeout().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReceiveTimeout().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSContentTypeProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentTypeProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSContentTypeProperty().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSReplyDestination == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReplyDestination().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSReplyDestination().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSPubSubNoLocal == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPubSubNoLocal().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPubSubNoLocal().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSDurableSubscriberName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDurableSubscriberName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSBrokerType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSBrokerType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSBrokerType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTConnectionFactory == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTConnectionFactory().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTConnectionFactory().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerHostName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerHostName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerHostName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTServerPort == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerPort().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTServerPort().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTopicName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTopicName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTopicName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionQOS == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionQOS().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionQOS().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSessionClean == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSessionClean().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSessionClean().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslEnable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslEnable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslEnable().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTTemporaryStoreDirectory == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTemporaryStoreDirectory().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTTemporaryStoreDirectory().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionUsername == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionUsername().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionUsername().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSubscriptionPassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionPassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSubscriptionPassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTClientId == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTClientId().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTClientId().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.truststore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Truststore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Truststore().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.keystore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Keystore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Keystore().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.sslVerifyClient == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SslVerifyClient().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SslVerifyClient().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.sslProtocol == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SslProtocol().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SslProtocol().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.httpsProtocols == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_HttpsProtocols().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_HttpsProtocols().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.certificateRevocationVerifier == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_CertificateRevocationVerifier().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_CertificateRevocationVerifier().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7Port == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7Port().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7Port().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7AutoAck == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7AutoAck().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7AutoAck().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7MessagePreProcessor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7MessagePreProcessor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7MessagePreProcessor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7CharSet == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7CharSet().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7CharSet().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7TimeOut == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7TimeOut().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7TimeOut().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7ValidateMessage == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7ValidateMessage().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7ValidateMessage().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7BuildInvalidMessages == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7BuildInvalidMessages().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7BuildInvalidMessages().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundHL7PassThroughInvalidMessages == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7PassThroughInvalidMessages().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundHL7PassThroughInvalidMessages().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnect == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnect().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnect().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.groupId == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_GroupId().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_GroupId().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.contentType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ContentType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ContentType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.consumerType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.topicsOrTopicFilter == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TopicsOrTopicFilter().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TopicsOrTopicFilter().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.topicsName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TopicsName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TopicsName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.topicFilterFrom == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterFrom().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterFrom().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.topicFilterName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TopicFilterName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerTopic == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerTopic().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerTopic().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerBrokers == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerBrokers().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerBrokers().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPort == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPort().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPort().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerPartition == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPartition().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerPartition().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.simpleConsumerMaxMessagesToRead == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerMaxMessagesToRead().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SimpleConsumerMaxMessagesToRead().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.threadCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ThreadCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ThreadCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.consumerId == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerId().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerId().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.socketTimeoutMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SocketTimeoutMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SocketTimeoutMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.socketReceiveBufferBytes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_SocketReceiveBufferBytes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_SocketReceiveBufferBytes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.fetchMessageMaxBytes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_FetchMessageMaxBytes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_FetchMessageMaxBytes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.numConsumerFetches == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_NumConsumerFetches().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_NumConsumerFetches().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.autoCommitEnable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitEnable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitEnable().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.autoCommitIntervalMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitIntervalMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_AutoCommitIntervalMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.queuedMaxMessageChunks == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_QueuedMaxMessageChunks().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_QueuedMaxMessageChunks().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.rebalanceMaxRetries == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceMaxRetries().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceMaxRetries().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.fetchMinBytes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_FetchMinBytes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_FetchMinBytes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.fetchWaitMaxMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_FetchWaitMaxMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_FetchWaitMaxMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.rebalanceBackoffMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceBackoffMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_RebalanceBackoffMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.refreshLeaderBackoffMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_RefreshLeaderBackoffMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_RefreshLeaderBackoffMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.autoOffsetReset == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_AutoOffsetReset().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_AutoOffsetReset().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.consumerTimeoutMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerTimeoutMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ConsumerTimeoutMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.excludeInternalTopics == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ExcludeInternalTopics().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ExcludeInternalTopics().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.partitionAssignmentStrategy == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_PartitionAssignmentStrategy().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_PartitionAssignmentStrategy().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.clientId == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ClientId().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ClientId().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.zookeeperSessionTimeoutMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSessionTimeoutMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSessionTimeoutMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.zookeeperConnectionTimeoutMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnectionTimeoutMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperConnectionTimeoutMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.zookeeperSyncTimeMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSyncTimeMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_ZookeeperSyncTimeMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.offsetsStorage == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsStorage().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsStorage().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelBackoffMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelBackoffMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelBackoffMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.offsetsChannelSocketTimeoutMs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelSocketTimeoutMs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsChannelSocketTimeoutMs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.offsetsCommitMaxRetries == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsCommitMaxRetries().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_OffsetsCommitMaxRetries().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.dualCommitEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_DualCommitEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_DualCommitEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmHost == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmHost().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmHost().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmPort == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmPort().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmPort().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.inboundCxfRmConfigFile == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmConfigFile().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_InboundCxfRmConfigFile().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.enableSSL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_EnableSSL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_EnableSSL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.suspend == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_Suspend().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_Suspend().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionFactory == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionFactory().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionFactory().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerHostName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerHostName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerHostName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPort == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPort().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPort().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerUserName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerUserName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerUserName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerPassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerPassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDurable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDurable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDurable().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueExclusive == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueExclusive().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueExclusive().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoDelete == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoDelete().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoDelete().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueAutoAck == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoAck().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueAutoAck().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueRoutingKey == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueRoutingKey().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueRoutingKey().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqQueueDeliveryMode == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDeliveryMode().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqQueueDeliveryMode().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeDurable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeDurable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeDurable().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDelete == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDelete().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDelete().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerVirtualHost == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerVirtualHost().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerVirtualHost().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryHeartbeat == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryHeartbeat().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryHeartbeat().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreLocation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreLocation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreLocation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystoreType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslKeystorePassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystorePassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslKeystorePassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreLocation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreLocation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreLocation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststoreType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslTruststorePassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststorePassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslTruststorePassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionSslVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionSslVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMessageContentType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMessageContentType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMessageContentType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConnectionRetryInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConnectionRetryInterval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqServerRetryInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerRetryInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqServerRetryInterval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsInboundPort == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsInboundPort().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsInboundPort().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsClientSideBroadcastLevel == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsClientSideBroadcastLevel().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsClientSideBroadcastLevel().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchSequence == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchSequence().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchSequence().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsOutflowDispatchFaultSequence == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchFaultSequence().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsOutflowDispatchFaultSequence().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsBossThreadPoolSize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsBossThreadPoolSize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsBossThreadPoolSize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsWorkerThreadPoolSize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsWorkerThreadPoolSize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsWorkerThreadPoolSize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsSubprotocolHandlerClass == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsSubprotocolHandlerClass().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsSubprotocolHandlerClass().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsPipelineHandlerClass == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsPipelineHandlerClass().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsPipelineHandlerClass().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportFeedURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportFeedType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportFeedType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSRetriesBeforeSuspension == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetriesBeforeSuspension().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSRetriesBeforeSuspension().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSResetConnectionOnPollingSuspension == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSResetConnectionOnPollingSuspension().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSResetConnectionOnPollingSuspension().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSPollingSuspensionPeriod == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPollingSuspensionPeriod().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSPollingSuspensionPeriod().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreLocation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreLocation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreLocation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystoreType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystoreType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslKeystorePassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystorePassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslKeystorePassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreLocation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreLocation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreLocation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststoreType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststoreType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslTruststorePassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststorePassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslTruststorePassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportMQTTSslVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportMQTTSslVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStoreFile == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStoreFile().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStoreFile().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wssSslKeyStorePass == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStorePass().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslKeyStorePass().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStoreFile == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStoreFile().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStoreFile().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wssSslTrustStorePass == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStorePass().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslTrustStorePass().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wssSslCertPass == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCertPass().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCertPass().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsDefaultContentType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsDefaultContentType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsDefaultContentType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusCode == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusCode().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusCode().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsShutdownStatusMessage == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusMessage().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsShutdownStatusMessage().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wsUsePortOffset == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WsUsePortOffset().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WsUsePortOffset().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wssSslProtocols == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslProtocols().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslProtocols().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.wssSslCipherSuites == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCipherSuites().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_WssSslCipherSuites().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQos == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQos().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQos().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerQosType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerQosType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportJMSDBUrl == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDBUrl().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportJMSDBUrl().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqAutoDeclare == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqAutoDeclare().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqAutoDeclare().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqMaxDeadLetteredCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMaxDeadLetteredCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqMaxDeadLetteredCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqRequeueDelay == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqRequeueDelay().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqRequeueDelay().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqExchangeAutoDeclare == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDeclare().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqExchangeAutoDeclare().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqConsumerTag == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerTag().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqConsumerTag().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorQueueRoutingKey == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorQueueRoutingKey().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorQueueRoutingKey().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqErrorExchangeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorExchangeName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqErrorExchangeName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryConnectionTimeout == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryConnectionTimeout().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryConnectionTimeout().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.InboundEndpoint.Properties.transportRabbitMqFactoryNetworkRecoveryInterval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryNetworkRecoveryInterval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getInboundEndpoint_TransportRabbitMqFactoryNetworkRecoveryInterval().getEAttributeType(), newValue);
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
