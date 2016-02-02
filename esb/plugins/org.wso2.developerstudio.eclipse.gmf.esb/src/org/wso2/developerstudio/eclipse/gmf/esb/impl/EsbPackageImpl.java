/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.APIHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.APIHandlerProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceEndpointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceFaultInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceOutSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractBooleanFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractCommonTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractLocationKeyResource;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractSqlExecutorMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AdditionalOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediatorOnCompleteOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeType;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.AutoOffsetResetType;
import org.wso2.developerstudio.eclipse.gmf.esb.AutoscaleInMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AutoscaleOutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediatorOutputConector;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheImplementationType;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediatorOnHitOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheOnHitBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheScope;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyContextAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyMessageAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.CommentMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpoints;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpointsOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediatorAdditionalOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType;
import org.wso2.developerstudio.eclipse.gmf.esb.ContentType;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Enable;
import org.wso2.developerstudio.eclipse.gmf.esb.EnableDisableState;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceInlineType;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetType;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementAdviceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorAdviceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorObligationsOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorOnAcceptOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorOnRejectOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementObligationsContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementOnAcceptContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementOnRejectContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceOutput;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EventTopicType;
import org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointDefaultBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap11;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap12;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultDetailType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultReasonType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultSoapVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultStringType;
import org.wso2.developerstudio.eclipse.gmf.esb.FeedType;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterFailContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorFailOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorPassOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterPassContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderAction;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.HttpMethodType;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointBehaviourType;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.JDBCConnectionInformationType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSpecVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceAlgorithm;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntryValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.LogCategory;
import org.wso2.developerstudio.eclipse.gmf.esb.LogLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS;
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.Member;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNode;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNodeFirstInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNodeOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNodeSecondInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessorType;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStore;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreType;
import org.wso2.developerstudio.eclipse.gmf.esb.MethodArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.NameValueTypeProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.OffsetsStorageType;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod;
import org.wso2.developerstudio.eclipse.gmf.esb.ParentEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.PartitionAssignmentStrategyType;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType;
import org.wso2.developerstudio.eclipse.gmf.esb.ProcessorState;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyDataType;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyName;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.Protocol;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyFaultInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyOutSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceFaultContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceInSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceOutSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServicePolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceAndEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSpecVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.ReceivingSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RespondMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RespondMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RespondMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouteTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleActionType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleActions;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleChildMediatorsConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactsConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFragmentType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediatorChildMediatorsOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResult;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultsConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSessionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSetCreationProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleType;
import org.wso2.developerstudio.eclipse.gmf.esb.ScopeType;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptLanguage;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptType;
import org.wso2.developerstudio.eclipse.gmf.esb.SendContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediatorEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.SequencesInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SequencesOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Session;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksInConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutputDataType;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.SomeXML;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorBooleanValue;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorIsolationLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDataType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDefinition;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlResultMapping;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseParentContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultParentContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediatorContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateType;
import org.wso2.developerstudio.eclipse.gmf.esb.Task;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskImplementation;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskPropertyType;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskTriggerType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleAccessType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediatorOnAcceptOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediatorOnRejectOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnAcceptBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnAcceptContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnRejectBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnRejectContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.TopicFilterFromType;
import org.wso2.developerstudio.eclipse.gmf.esb.TopicsType;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionAction;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Trigger;
import org.wso2.developerstudio.eclipse.gmf.esb.Type;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSAction;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediatorOnFailOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateOnFailBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLDefinition;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLDescription;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableType;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTResource;
import org.wso2.developerstudio.eclipse.gmf.esb.scriptKeyTypeEnum;
import org.wso2.developerstudio.eclipse.gmf.esb.propertyTaskString;
import org.wso2.developerstudio.eclipse.gmf.esb.propertyTaskXML;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EsbPackageImpl extends EPackageImpl implements EsbPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additionalOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callMediatorEndpointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endPointPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyOutSequenceOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyInSequenceInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyWSDLResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyFaultInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyServiceParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyServicePolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyServiceSequenceAndEndpointContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyServiceFaultContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyServiceContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediatorFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass endpointFlowEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultEndPointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultEndPointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressEndPointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressEndPointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateEndpointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateEndpointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateEndpointParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpEndPointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpEndPointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dropMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dropMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass filterContainerEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass filterPassContainerEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass filterFailContainerEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass filterMediatorOutputConnectorEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterMediatorPassOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterMediatorFailOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeNodeFirstInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeNodeSecondInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeNodeOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publishEventMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publishEventMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publishEventMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publishEventMediatorAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNameValueExpressionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bamMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bamMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bamMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beanMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beanMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beanMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ejbMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ejbMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ejbMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registryKeyPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespacedPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enrichMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enrichMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enrichMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNameValueExpressionPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractBooleanFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLocationKeyResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchCaseBranchOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchDefaultBranchOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchMediatorContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchCaseParentContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchDefaultParentContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchCaseContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchDefaultContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbSequenceInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbSequenceOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbSequenceInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esbSequenceOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNameValuePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorOnRejectOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorOnAcceptOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorAdviceOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorObligationsOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementOnRejectContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementOnAcceptContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementAdviceContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementObligationsContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enqueueMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enqueueMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enqueueMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass springMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass springMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass springMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateMediatorOnFailOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endpointDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedEndpointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedEndpointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameValueTypePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synapseAPIEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceOutSequenceOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceInSequenceInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceFaultInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceEndpointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceEndpointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexEndpointsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexEndpointsOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressingEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressingEndpointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressingEndpointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recipientListEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recipientListEndPointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recipientListEndPointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recipientListEndPointWestOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageStoreParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageProcessorParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageProcessorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiHandlerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiHandlerPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloudConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloudConnectorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloudConnectorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloudConnectorOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloudConnectorOperationInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloudConnectorOperationOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMapperMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMapperMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMapperMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fastXSLTMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fastXSLTMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fastXSLTMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointSequenceContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointOnErrorSequenceContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointSequenceInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointSequenceOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointOnErrorSequenceOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inboundEndpointOnErrorSequenceInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum artifactTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum callMediatorEndpointTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum endPointPropertyScopeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregateMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregateMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregateMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregateMediatorOnCompleteOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerRouteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerMediatorTargetOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerMediatorContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerTargetContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneMediatorTargetOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneMediatorContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneTargetContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachMediatorTargetOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateMediatorTargetOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractCommonTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediatorSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheMediatorOnHitOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheOnHitBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xQueryMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xQueryMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xQueryMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xQueryVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calloutMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calloutMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calloutMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rmSequenceMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rmSequenceMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rmSequenceMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oAuthMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oAuthMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oAuthMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autoscaleInMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autoscaleOutMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headerMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headerMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headerMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttleMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttleMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttleMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass throttleMediatorOnAcceptOutputConnectorEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass throttleMediatorOnRejectOutputConnectorEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttlePolicyConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttlePolicyEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttleOnAcceptBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttleOnRejectBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass throttleContainerEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass throttleOnAcceptContainerEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass throttleOnRejectContainerEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractSqlExecutorMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlParameterDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlResultMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbLookupMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbLookupMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbLookupMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbReportMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbReportMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbReportMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleMediatorChildMediatorsOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleSetCreationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleSessionPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleFactsConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleFactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleResultsConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleChildMediatorsConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callTemplateParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callTemplateMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callTemplateMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callTemplateMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopBackMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopBackMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopBackMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass respondMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass respondMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass respondMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smooksMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smooksMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smooksMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storeMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storeMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storeMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderMediatorOutputConectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageBuilderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass payloadFactoryMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass payloadFactoryMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass payloadFactoryMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass payloadFactoryArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalRouteBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalRouterMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalRouterMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalRouterMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalRouterMediatorAdditionalOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass sendContainerEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass sendMediatorEndpointOutputConnectorEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failoverEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failoverEndPointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failoverEndPointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failoverEndPointWestOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsdlEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsdlEndPointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsdlEndPointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadBalanceEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadBalanceEndPointInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadBalanceEndPointOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadBalanceEndPointWestOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequencesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequencesOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequencesInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlRewriteRuleActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlRewriteRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlRewriteMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlRewriteMediatorInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlRewriteMediatorOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluatorExpressionPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum proxyWsdlTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum httpMethodTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum filterMediatorConditionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum attributeValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum attributeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum beanMediatorActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum endPointAddressingVersionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum endPointTimeOutActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum endPointMessageFormatEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum endPointAttachmentOptimizationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyDataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyScopeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyNameEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enrichSourceInlineTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enrichSourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enrichTargetActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enrichTargetTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eventTopicTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum entitlementCallbackHandlerEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum entitlementClientTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum entitlementSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scriptKeyTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scriptTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scriptLanguageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultSoapVersionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultCodeSoap11EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultCodeSoap12EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultCodeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultStringTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultReasonTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultDetailTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum completionMessagesTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aggregateSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum targetSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum targetEndpointTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cacheSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cacheImplementationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cacheActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cacheScopeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum xQueryVariableTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum xQueryVariableValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum calloutEndpointTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum calloutPayloadTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum calloutSecurityPoliciesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum calloutSecurityTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum calloutResultTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rmSpecVersionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rmSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transactionActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum headerActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum headerValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scopeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum throttlePolicyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum throttleConditionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum throttleAccessTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum throttleSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commandPropertyValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commandPropertyMessageActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commandPropertyContextActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlExecutorConnectionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlExecutorDatasourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlExecutorBooleanValueEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlExecutorIsolationLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlParameterValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlParameterDataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleActionsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleSourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleFactTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleFactValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleResultTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleResultValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleOptionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum smooksIODataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum smooksOutputDataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum expressionActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum outputMethodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum receivingSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum keyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mediaTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum payloadFactoryArgumentTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum payloadFormatTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum loadBalanceSessionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum localEntryValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleActionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleFragmentTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum templateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum taskPropertyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum taskTriggerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum apiResourceUrlStyleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum recipientListEndpointTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum messageStoreTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jmsSpecVersionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jdbcConnectionInformationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum messageProcessorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum processorStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cloudConnectorOperationParamEditorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataMapperMediatorDataTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum protocolEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum inboundEndpointTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum inboundEndpointBehaviourTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contentTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum topicsTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum topicFilterFromTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum consumerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum autoOffsetResetTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum partitionAssignmentStrategyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum offsetsStorageTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enableEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum vfsActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum vfsFileSortEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jmsConnectionFactoryTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jmsSessionAcknowledgementEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jmsCacheLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mqttSubscriptionQOSEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum feedTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enableDisableStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mapEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EsbPackageImpl() {
		super(eNS_URI, EsbFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EsbPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EsbPackage init() {
		if (isInited) return (EsbPackage)EPackage.Registry.INSTANCE.getEPackage(EsbPackage.eNS_URI);

		// Obtain or create and register package
		EsbPackageImpl theEsbPackage = (EsbPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EsbPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EsbPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEsbPackage.createPackageContents();

		// Initialize created meta-data
		theEsbPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEsbPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EsbPackage.eNS_URI, theEsbPackage);
		return theEsbPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbDiagram() {
		return esbDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbDiagram_Server() {
		return (EReference)esbDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEsbDiagram_Test() {
		return (EAttribute)esbDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbNode() {
		return esbNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbElement() {
		return esbElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEsbElement_Description() {
		return (EAttribute)esbElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEsbElement_CommentsList() {
		return (EAttribute)esbElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbServer() {
		return esbServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbServer_Children() {
		return (EReference)esbServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbServer_MessageMediator() {
		return (EReference)esbServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEsbServer_Type() {
		return (EAttribute)esbServerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediator() {
		return mediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediator_Reverse() {
		return (EAttribute)mediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbConnector() {
		return esbConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputConnector() {
		return inputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputConnector_IncomingLinks() {
		return (EReference)inputConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputConnector() {
		return outputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputConnector_OutgoingLink() {
		return (EReference)outputConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputConnector_CommentMediators() {
		return (EReference)outputConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditionalOutputConnector() {
		return additionalOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdditionalOutputConnector_AdditionalOutgoingLink() {
		return (EReference)additionalOutputConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbLink() {
		return esbLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbLink_Source() {
		return (EReference)esbLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbLink_Target() {
		return (EReference)esbLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndPoint() {
		return endPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPoint_EndPointName() {
		return (EAttribute)endPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPoint_Anonymous() {
		return (EAttribute)endPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPoint_InLine() {
		return (EAttribute)endPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPoint_Duplicate() {
		return (EAttribute)endPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndPoint_Properties() {
		return (EReference)endPointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPoint_Reversed() {
		return (EAttribute)endPointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallMediator() {
		return callMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallMediator_InputConnector() {
		return (EReference)callMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallMediator_OutputConnector() {
		return (EReference)callMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallMediator_Endpoint() {
		return (EReference)callMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallMediator_EndpointOutputConnector() {
		return (EReference)callMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallMediator_MediatorFlow() {
		return (EReference)callMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallMediator_EndpointType() {
		return (EAttribute)callMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallMediator_EnableBlockingCalls() {
		return (EAttribute)callMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallMediator_EndpointRegistrykey() {
		return (EReference)callMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallMediator_EndpointXpath() {
		return (EReference)callMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallMediatorInputConnector() {
		return callMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallMediatorOutputConnector() {
		return callMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallMediatorEndpointOutputConnector() {
		return callMediatorEndpointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndPointProperty() {
		return endPointPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPointProperty_Name() {
		return (EAttribute)endPointPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPointProperty_Value() {
		return (EAttribute)endPointPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPointProperty_Scope() {
		return (EAttribute)endPointPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPointProperty_ValueType() {
		return (EAttribute)endPointPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndPointProperty_ValueExpression() {
		return (EReference)endPointPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyService() {
		return proxyServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_OutputConnector() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_InputConnector() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_FaultInputConnector() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_OutSequenceOutputConnector() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_InSequenceInputConnectors() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_Name() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_PinnedServers() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_ServiceGroup() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_TraceEnabled() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_StatisticsEnabled() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_StartOnLoad() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_Transports() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_ReliableMessagingEnabled() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_SecurityEnabled() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_ServiceParameters() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_ServicePolicies() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_Container() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_InSequenceType() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_InSequenceKey() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_InSequenceName() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_InSequenceOnError() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_OutSequenceType() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_OutSequenceKey() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_OutSequenceName() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_OutSequenceOnError() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_FaultSequenceType() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_FaultSequenceKey() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_FaultSequenceName() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_FaultSequenceOnError() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_EndpointType() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_EndpointKey() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_EndpointName() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_MainSequence() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_WsdlType() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_WsdlXML() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_WsdlURL() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_WsdlKey() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_WsdlEndpoint() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_WsdlResources() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_OnError() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyOutputConnector() {
		return proxyOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyInputConnector() {
		return proxyInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyOutSequenceOutputConnector() {
		return proxyOutSequenceOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyInSequenceInputConnector() {
		return proxyInSequenceInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyWSDLResource() {
		return proxyWSDLResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyFaultInputConnector() {
		return proxyFaultInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyServiceParameter() {
		return proxyServiceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyServiceParameter_Name() {
		return (EAttribute)proxyServiceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyServiceParameter_Value() {
		return (EAttribute)proxyServiceParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyServicePolicy() {
		return proxyServicePolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyServicePolicy_PolicyKey() {
		return (EReference)proxyServicePolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyServiceSequenceAndEndpointContainer() {
		return proxyServiceSequenceAndEndpointContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyServiceSequenceAndEndpointContainer_MediatorFlow() {
		return (EReference)proxyServiceSequenceAndEndpointContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyServiceFaultContainer() {
		return proxyServiceFaultContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyServiceFaultContainer_MediatorFlow() {
		return (EReference)proxyServiceFaultContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyServiceContainer() {
		return proxyServiceContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyServiceContainer_SequenceAndEndpointContainer() {
		return (EReference)proxyServiceContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyServiceContainer_FaultContainer() {
		return (EReference)proxyServiceContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediatorFlow() {
		return mediatorFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediatorFlow_Children() {
		return (EReference)mediatorFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getEndpointFlow() {
		return endpointFlowEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getEndpointFlow_Children() {
		return (EReference)endpointFlowEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractEndPoint() {
		return abstractEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_ReliableMessagingEnabled() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_SecurityEnabled() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_AddressingEnabled() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_AddressingVersion() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_AddressingSeparateListener() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_TimeOutDuration() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_TimeOutAction() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_RetryErrorCodes() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_RetryCount() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_RetryDelay() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_SuspendErrorCodes() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_SuspendInitialDuration() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_SuspendMaximumDuration() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_SuspendProgressionFactor() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractEndPoint_ReliableMessagingPolicy() {
		return (EReference)abstractEndPointEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractEndPoint_SecurityPolicy() {
		return (EReference)abstractEndPointEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_Format() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_Optimize() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractEndPoint_TemplateParameters() {
		return (EReference)abstractEndPointEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_StatisticsEnabled() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEndPoint_TraceEnabled() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractEndPoint_InboundPolicy() {
		return (EReference)abstractEndPointEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractEndPoint_OutboundPolicy() {
		return (EReference)abstractEndPointEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageMediator() {
		return messageMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageMediator_InputConnector() {
		return (EReference)messageMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageMediator_OutputConnector() {
		return (EReference)messageMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageInputConnector() {
		return messageInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageOutputConnector() {
		return messageOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultEndPoint() {
		return defaultEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultEndPoint_InputConnector() {
		return (EReference)defaultEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultEndPoint_OutputConnector() {
		return (EReference)defaultEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultEndPointInputConnector() {
		return defaultEndPointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultEndPointOutputConnector() {
		return defaultEndPointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressEndPoint() {
		return addressEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressEndPoint_InputConnector() {
		return (EReference)addressEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressEndPoint_OutputConnector() {
		return (EReference)addressEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressEndPoint_URI() {
		return (EAttribute)addressEndPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressEndPointInputConnector() {
		return addressEndPointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressEndPointOutputConnector() {
		return addressEndPointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateEndpoint() {
		return templateEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateEndpoint_InputConnector() {
		return (EReference)templateEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateEndpoint_OutputConnector() {
		return (EReference)templateEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateEndpoint_Address() {
		return (EAttribute)templateEndpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateEndpoint_TargetTemplate() {
		return (EAttribute)templateEndpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateEndpoint_Parameters() {
		return (EReference)templateEndpointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateEndpoint_AvailableTemplates() {
		return (EAttribute)templateEndpointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateEndpointInputConnector() {
		return templateEndpointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateEndpointOutputConnector() {
		return templateEndpointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateEndpointParameter() {
		return templateEndpointParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateEndpointParameter_ParameterName() {
		return (EAttribute)templateEndpointParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateEndpointParameter_ParameterValue() {
		return (EAttribute)templateEndpointParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHTTPEndpoint() {
		return httpEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPEndpoint_InputConnector() {
		return (EReference)httpEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHTTPEndpoint_OutputConnector() {
		return (EReference)httpEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHTTPEndpoint_URITemplate() {
		return (EAttribute)httpEndpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHTTPEndpoint_HttpMethod() {
		return (EAttribute)httpEndpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHTTPEndPointInputConnector() {
		return httpEndPointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHTTPEndPointOutputConnector() {
		return httpEndPointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDropMediator() {
		return dropMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDropMediator_InputConnector() {
		return (EReference)dropMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDropMediatorInputConnector() {
		return dropMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterMediator() {
		return filterMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterMediator_ConditionType() {
		return (EAttribute)filterMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterMediator_Regex() {
		return (EAttribute)filterMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_InputConnector() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getFilterMediator_OutputConnector() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_PassOutputConnector() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_FailOutputConnector() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_Xpath() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_Source() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getFilterMediator_FilterContainer() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(8);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getFilterContainer() {
		return filterContainerEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getFilterContainer_PassContainer() {
		return (EReference)filterContainerEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getFilterContainer_FailContainer() {
		return (EReference)filterContainerEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getFilterPassContainer() {
		return filterPassContainerEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getFilterPassContainer_MediatorFlow() {
		return (EReference)filterPassContainerEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getFilterFailContainer() {
		return filterFailContainerEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getFilterFailContainer_MediatorFlow() {
		return (EReference)filterFailContainerEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterMediatorInputConnector() {
		return filterMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getFilterMediatorOutputConnector() {
		return filterMediatorOutputConnectorEClass;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterMediatorPassOutputConnector() {
		return filterMediatorPassOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterMediatorFailOutputConnector() {
		return filterMediatorFailOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeNode() {
		return mergeNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeNode_FirstInputConnector() {
		return (EReference)mergeNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeNode_SecondInputConnector() {
		return (EReference)mergeNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeNode_OutputConnector() {
		return (EReference)mergeNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeNodeFirstInputConnector() {
		return mergeNodeFirstInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeNodeSecondInputConnector() {
		return mergeNodeSecondInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeNodeOutputConnector() {
		return mergeNodeOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogMediator() {
		return logMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMediator_LogCategory() {
		return (EAttribute)logMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMediator_LogLevel() {
		return (EAttribute)logMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMediator_LogSeparator() {
		return (EAttribute)logMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogMediator_InputConnector() {
		return (EReference)logMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogMediator_OutputConnector() {
		return (EReference)logMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogMediator_Properties() {
		return (EReference)logMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogMediatorInputConnector() {
		return logMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogMediatorOutputConnector() {
		return logMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogProperty() {
		return logPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublishEventMediator() {
		return publishEventMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublishEventMediator_InputConnector() {
		return (EReference)publishEventMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublishEventMediator_Outputconnector() {
		return (EReference)publishEventMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublishEventMediator_StreamName() {
		return (EAttribute)publishEventMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublishEventMediator_StreamVersion() {
		return (EAttribute)publishEventMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublishEventMediator_EventSink() {
		return (EAttribute)publishEventMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublishEventMediator_MetaAttributes() {
		return (EReference)publishEventMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublishEventMediator_CorrelationAttributes() {
		return (EReference)publishEventMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublishEventMediator_PayloadAttributes() {
		return (EReference)publishEventMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublishEventMediator_ArbitraryAttributes() {
		return (EReference)publishEventMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublishEventMediatorInputConnector() {
		return publishEventMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublishEventMediatorOutputConnector() {
		return publishEventMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublishEventMediatorAttribute() {
		return publishEventMediatorAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublishEventMediatorAttribute_DefaultValue() {
		return (EAttribute)publishEventMediatorAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNameValueExpressionAttribute() {
		return abstractNameValueExpressionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionAttribute_AttributeName() {
		return (EAttribute)abstractNameValueExpressionAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionAttribute_AttributeValueType() {
		return (EAttribute)abstractNameValueExpressionAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionAttribute_AttributeValue() {
		return (EAttribute)abstractNameValueExpressionAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionAttribute_AttributeType() {
		return (EAttribute)abstractNameValueExpressionAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameValueExpressionAttribute_AttributeExpression() {
		return (EReference)abstractNameValueExpressionAttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBAMMediator() {
		return bamMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBAMMediator_InputConnector() {
		return (EReference)bamMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBAMMediator_OutputConnector() {
		return (EReference)bamMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBAMMediator_ServerProfile() {
		return (EAttribute)bamMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBAMMediator_StreamName() {
		return (EAttribute)bamMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBAMMediator_StreamVersion() {
		return (EAttribute)bamMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBAMMediatorInputConnector() {
		return bamMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBAMMediatorOutputConnector() {
		return bamMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeanMediator() {
		return beanMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeanMediator_InputConnector() {
		return (EReference)beanMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeanMediator_OutputConnector() {
		return (EReference)beanMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanMediator_Class() {
		return (EAttribute)beanMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanMediator_Action() {
		return (EAttribute)beanMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanMediator_Var() {
		return (EAttribute)beanMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanMediator_Property() {
		return (EAttribute)beanMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanMediator_ValueType() {
		return (EAttribute)beanMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanMediator_ValueLiteral() {
		return (EAttribute)beanMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeanMediator_ValueExpression() {
		return (EReference)beanMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanMediator_TargetType() {
		return (EAttribute)beanMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanMediator_TargetLiteral() {
		return (EAttribute)beanMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeanMediator_TargetExpression() {
		return (EReference)beanMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeanMediatorInputConnector() {
		return beanMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeanMediatorOutputConnector() {
		return beanMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEJBMediator() {
		return ejbMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEJBMediator_InputConnector() {
		return (EReference)ejbMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEJBMediator_OutputConnector() {
		return (EReference)ejbMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBMediator_Beanstalk() {
		return (EAttribute)ejbMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBMediator_Class() {
		return (EAttribute)ejbMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBMediator_Method() {
		return (EAttribute)ejbMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBMediator_SessionIdType() {
		return (EAttribute)ejbMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBMediator_SessionIdLiteral() {
		return (EAttribute)ejbMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEJBMediator_SessionIdExpression() {
		return (EReference)ejbMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBMediator_Remove() {
		return (EAttribute)ejbMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBMediator_Target() {
		return (EAttribute)ejbMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEJBMediator_JNDIName() {
		return (EAttribute)ejbMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEJBMediator_MethodArguments() {
		return (EReference)ejbMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEJBMediatorInputConnector() {
		return ejbMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEJBMediatorOutputConnector() {
		return ejbMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodArgument() {
		return methodArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistryKeyProperty() {
		return registryKeyPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryKeyProperty_PrettyName() {
		return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryKeyProperty_KeyName() {
		return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryKeyProperty_KeyValue() {
		return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryKeyProperty_Filters() {
		return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyMediator() {
		return propertyMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyMediator_InputConnector() {
		return (EReference)propertyMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyMediator_OutputConnector() {
		return (EReference)propertyMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_PropertyName() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_PropertyDataType() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_PropertyAction() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_PropertyScope() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_ValueType() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_Value() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_Expression() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_NamespacePrefix() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_Namespace() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyMediator_ValueExpression() {
		return (EReference)propertyMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_Boolean() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_OM() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_ValueStringPattern() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_ValueStringCapturingGroup() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_NewPropertyName() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyMediatorInputConnector() {
		return propertyMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyMediatorOutputConnector() {
		return propertyMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespacedProperty() {
		return namespacedPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_PrettyName() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_PropertyName() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_PropertyValue() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_Namespaces() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_SupportsDynamicXPaths() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_Dynamic() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnrichMediator() {
		return enrichMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_CloneSource() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_SourceType() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnrichMediator_SourceXpath() {
		return (EReference)enrichMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_SourceProperty() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_SourceXML() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_TargetAction() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_TargetType() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnrichMediator_TargetXpath() {
		return (EReference)enrichMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_TargetProperty() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_InlineType() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnrichMediator_InlineRegistryKey() {
		return (EReference)enrichMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnrichMediator_InputConnector() {
		return (EReference)enrichMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnrichMediator_OutputConnector() {
		return (EReference)enrichMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnrichMediatorInputConnector() {
		return enrichMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnrichMediatorOutputConnector() {
		return enrichMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNameValueExpressionProperty() {
		return abstractNameValueExpressionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionProperty_PropertyName() {
		return (EAttribute)abstractNameValueExpressionPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionProperty_PropertyValueType() {
		return (EAttribute)abstractNameValueExpressionPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionProperty_PropertyValue() {
		return (EAttribute)abstractNameValueExpressionPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameValueExpressionProperty_PropertyExpression() {
		return (EReference)abstractNameValueExpressionPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractBooleanFeature() {
		return abstractBooleanFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractBooleanFeature_FeatureName() {
		return (EAttribute)abstractBooleanFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractBooleanFeature_FeatureEnabled() {
		return (EAttribute)abstractBooleanFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractLocationKeyResource() {
		return abstractLocationKeyResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLocationKeyResource_Location() {
		return (EAttribute)abstractLocationKeyResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLocationKeyResource_Key() {
		return (EReference)abstractLocationKeyResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTMediator() {
		return xsltMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_InputConnector() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_OutputConnector() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXSLTMediator_XsltSchemaKeyType() {
		return (EAttribute)xsltMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_XsltStaticSchemaKey() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_XsltDynamicSchemaKey() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_XsltKey() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_SourceXPath() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_Properties() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_Features() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_Resources() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTProperty() {
		return xsltPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTFeature() {
		return xsltFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTResource() {
		return xsltResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTMediatorInputConnector() {
		return xsltMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTMediatorOutputConnector() {
		return xsltMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchMediator() {
		return switchMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_SourceXpath() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchMediator_Source() {
		return (EAttribute)switchMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchMediator_Namespace() {
		return (EAttribute)switchMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchMediator_NamespacePrefix() {
		return (EAttribute)switchMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_CaseBranches() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_DefaultBranch() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_InputConnector() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_OutputConnector() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_SwitchContainer() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchCaseBranchOutputConnector() {
		return switchCaseBranchOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchCaseBranchOutputConnector_CaseRegex() {
		return (EAttribute)switchCaseBranchOutputConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchDefaultBranchOutputConnector() {
		return switchDefaultBranchOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchMediatorInputConnector() {
		return switchMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchMediatorOutputConnector() {
		return switchMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchMediatorContainer() {
		return switchMediatorContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediatorContainer_SwitchCaseParentContainer() {
		return (EReference)switchMediatorContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediatorContainer_SwitchDefaultParentContainer() {
		return (EReference)switchMediatorContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchCaseParentContainer() {
		return switchCaseParentContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchCaseParentContainer_SwitchCaseContainer() {
		return (EReference)switchCaseParentContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchDefaultParentContainer() {
		return switchDefaultParentContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchDefaultParentContainer_SwitchDefaultContainer() {
		return (EReference)switchDefaultParentContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchCaseContainer() {
		return switchCaseContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchCaseContainer_MediatorFlow() {
		return (EReference)switchCaseContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchDefaultContainer() {
		return switchDefaultContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchDefaultContainer_MediatorFlow() {
		return (EReference)switchDefaultContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceDiagram() {
		return sequenceDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceDiagram_Sequence() {
		return (EReference)sequenceDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbSequence() {
		return esbSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEsbSequence_Name() {
		return (EAttribute)esbSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbSequence_Input() {
		return (EReference)esbSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbSequence_Output() {
		return (EReference)esbSequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbSequence_ChildMediators() {
		return (EReference)esbSequenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbSequenceInput() {
		return esbSequenceInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbSequenceInput_Connector() {
		return (EReference)esbSequenceInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbSequenceOutput() {
		return esbSequenceOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEsbSequenceOutput_Connector() {
		return (EReference)esbSequenceOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbSequenceInputConnector() {
		return esbSequenceInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEsbSequenceOutputConnector() {
		return esbSequenceOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequence() {
		return sequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_Name() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_Key() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_InputConnector() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_OutputConnector() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_IncludedMediators() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_ReceiveSequence() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_Duplicate() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_ReferringSequenceType() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_DynamicReferenceKey() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_StaticReferenceKey() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceInputConnector() {
		return sequenceInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceOutputConnector() {
		return sequenceOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventMediator() {
		return eventMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventMediator_TopicType() {
		return (EAttribute)eventMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventMediator_StaticTopic() {
		return (EAttribute)eventMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventMediator_DynamicTopic() {
		return (EReference)eventMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventMediator_EventExpression() {
		return (EReference)eventMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventMediator_InputConnector() {
		return (EReference)eventMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventMediator_OutputConnector() {
		return (EReference)eventMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventMediatorInputConnector() {
		return eventMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventMediatorOutputConnector() {
		return eventMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNameValueProperty() {
		return abstractNameValuePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueProperty_PropertyName() {
		return (EAttribute)abstractNameValuePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueProperty_PropertyValue() {
		return (EAttribute)abstractNameValuePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediator() {
		return entitlementMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_EntitlementServerURL() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_Username() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_Password() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_CallbackClassName() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_ThriftHost() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_ThriftPort() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_EntitlementClientType() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_OnRejectSequenceType() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_OnAcceptSequenceType() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_AdviceSequenceType() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_ObligationsSequenceType() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_OnRejectSequenceKey() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_OnAcceptSequenceKey() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_AdviceSequenceKey() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_ObligationsSequenceKey() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_EntitlementContainer() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_InputConnector() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_OutputConnector() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_OnRejectOutputConnector() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_OnAcceptOutputConnector() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_AdviceOutputConnector() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_ObligationsOutputConnector() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_CallbackHandler() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediatorInputConnector() {
		return entitlementMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediatorOutputConnector() {
		return entitlementMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediatorOnRejectOutputConnector() {
		return entitlementMediatorOnRejectOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediatorOnAcceptOutputConnector() {
		return entitlementMediatorOnAcceptOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediatorAdviceOutputConnector() {
		return entitlementMediatorAdviceOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediatorObligationsOutputConnector() {
		return entitlementMediatorObligationsOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementContainer() {
		return entitlementContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementContainer_OnRejectContainer() {
		return (EReference)entitlementContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementContainer_OnAcceptContainer() {
		return (EReference)entitlementContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementContainer_AdviceContainer() {
		return (EReference)entitlementContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementContainer_ObligationsContainer() {
		return (EReference)entitlementContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementOnRejectContainer() {
		return entitlementOnRejectContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementOnRejectContainer_MediatorFlow() {
		return (EReference)entitlementOnRejectContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementOnAcceptContainer() {
		return entitlementOnAcceptContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementOnAcceptContainer_MediatorFlow() {
		return (EReference)entitlementOnAcceptContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementAdviceContainer() {
		return entitlementAdviceContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementAdviceContainer_MediatorFlow() {
		return (EReference)entitlementAdviceContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementObligationsContainer() {
		return entitlementObligationsContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementObligationsContainer_MediatorFlow() {
		return (EReference)entitlementObligationsContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnqueueMediator() {
		return enqueueMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnqueueMediator_Executor() {
		return (EAttribute)enqueueMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnqueueMediator_Priority() {
		return (EAttribute)enqueueMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnqueueMediator_SequenceKey() {
		return (EReference)enqueueMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnqueueMediator_InputConnector() {
		return (EReference)enqueueMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnqueueMediator_OutputConnector() {
		return (EReference)enqueueMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnqueueMediatorInputConnector() {
		return enqueueMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnqueueMediatorOutputConnector() {
		return enqueueMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassMediator() {
		return classMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassMediator_ClassName() {
		return (EAttribute)classMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassMediator_Properties() {
		return (EReference)classMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassMediator_InputConnector() {
		return (EReference)classMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassMediator_OutputConnector() {
		return (EReference)classMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassMediatorInputConnector() {
		return classMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassMediatorOutputConnector() {
		return classMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassProperty() {
		return classPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpringMediator() {
		return springMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpringMediator_BeanName() {
		return (EAttribute)springMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpringMediator_ConfigurationKey() {
		return (EReference)springMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpringMediator_InputConnector() {
		return (EReference)springMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpringMediator_OutputConnector() {
		return (EReference)springMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpringMediatorInputConnector() {
		return springMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpringMediatorOutputConnector() {
		return springMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateMediator() {
		return validateMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_SourceXpath() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_Features() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_Schemas() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_InputConnector() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_OutputConnector() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_OnFailOutputConnector() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_MediatorFlow() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_Resources() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateResource() {
		return validateResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateFeature() {
		return validateFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateSchema() {
		return validateSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateSchema_ValidateStaticSchemaKey() {
		return (EReference)validateSchemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateSchema_ValidateDynamicSchemaKey() {
		return (EReference)validateSchemaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidateSchema_ValidateSchemaKeyType() {
		return (EAttribute)validateSchemaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateSchema_SchemaKey() {
		return (EReference)validateSchemaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateMediatorInputConnector() {
		return validateMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateMediatorOutputConnector() {
		return validateMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateMediatorOnFailOutputConnector() {
		return validateMediatorOnFailOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndpointDiagram() {
		return endpointDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndpointDiagram_Child() {
		return (EReference)endpointDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndpointDiagram_Name() {
		return (EAttribute)endpointDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedEndpoint() {
		return namedEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedEndpoint_InputConnector() {
		return (EReference)namedEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedEndpoint_OutputConnector() {
		return (EReference)namedEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedEndpoint_Name() {
		return (EAttribute)namedEndpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedEndpoint_ReferringEndpointType() {
		return (EAttribute)namedEndpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedEndpoint_DynamicReferenceKey() {
		return (EReference)namedEndpointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedEndpoint_StaticReferenceKey() {
		return (EReference)namedEndpointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedEndpointInputConnector() {
		return namedEndpointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedEndpointOutputConnector() {
		return namedEndpointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplate() {
		return templateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplate_Name() {
		return (EAttribute)templateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplate_TemplateType() {
		return (EAttribute)templateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplate_Child() {
		return (EReference)templateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplate_Parameters() {
		return (EReference)templateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameter() {
		return templateParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateParameter_Name() {
		return (EAttribute)templateParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_TaskName() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_TaskGroup() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_TriggerType() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Count() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Interval() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Cron() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_PinnedServers() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_TaskImplementation() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_TaskProperties() {
		return (EReference)taskEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameValueTypeProperty() {
		return nameValueTypePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameValueTypeProperty_PropertyName() {
		return (EAttribute)nameValueTypePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameValueTypeProperty_PropertyValue() {
		return (EAttribute)nameValueTypePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameValueTypeProperty_PropertyType() {
		return (EAttribute)nameValueTypePropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskProperty() {
		return taskPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynapseAPI() {
		return synapseAPIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseAPI_ApiName() {
		return (EAttribute)synapseAPIEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseAPI_Context() {
		return (EAttribute)synapseAPIEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseAPI_HostName() {
		return (EAttribute)synapseAPIEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseAPI_Port() {
		return (EAttribute)synapseAPIEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynapseAPI_Resources() {
		return (EReference)synapseAPIEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynapseAPI_Handlers() {
		return (EReference)synapseAPIEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResource() {
		return apiResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_InputConnector() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_OutputConnector() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_OutSequenceOutputConnector() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_InSequenceInputConnectors() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_FaultInputConnector() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_UrlStyle() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_UriTemplate() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_UrlMapping() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_AllowGet() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_AllowPost() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_AllowPut() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_AllowDelete() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_AllowOptions() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_AllowHead() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_AllowPatch() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_Container() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_InSequenceType() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_InSequenceKey() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_InSequenceName() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_OutSequenceType() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_OutSequenceKey() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_OutSequenceName() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_FaultSequenceType() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResource_FaultSequenceKey() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_FaultSequenceName() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIResource_Protocol() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResourceInputConnector() {
		return apiResourceInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResourceOutputConnector() {
		return apiResourceOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResourceOutSequenceOutputConnector() {
		return apiResourceOutSequenceOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResourceInSequenceInputConnector() {
		return apiResourceInSequenceInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResourceFaultInputConnector() {
		return apiResourceFaultInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResourceEndpoint() {
		return apiResourceEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResourceEndpoint_InputConnector() {
		return (EReference)apiResourceEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIResourceEndpoint_OutputConnector() {
		return (EReference)apiResourceEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResourceEndpointInputConnector() {
		return apiResourceEndpointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIResourceEndpointOutputConnector() {
		return apiResourceEndpointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexEndpoints() {
		return complexEndpointsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexEndpoints_OutputConnector() {
		return (EReference)complexEndpointsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexEndpoints_MediatorFlow() {
		return (EReference)complexEndpointsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComplexEndpoints_Name() {
		return (EAttribute)complexEndpointsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexEndpointsOutputConnector() {
		return complexEndpointsOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressingEndpoint() {
		return addressingEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressingEndpoint_InputConnector() {
		return (EReference)addressingEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressingEndpoint_OutputConnector() {
		return (EReference)addressingEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressingEndpointInputConnector() {
		return addressingEndpointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressingEndpointOutputConnector() {
		return addressingEndpointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecipientListEndPoint() {
		return recipientListEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecipientListEndPoint_InputConnector() {
		return (EReference)recipientListEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecipientListEndPoint_OutputConnector() {
		return (EReference)recipientListEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecipientListEndPoint_WestOutputConnector() {
		return (EReference)recipientListEndPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecipientListEndPoint_EndpointType() {
		return (EAttribute)recipientListEndPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecipientListEndPoint_EndpointsValue() {
		return (EAttribute)recipientListEndPointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecipientListEndPoint_EndpointsExpression() {
		return (EReference)recipientListEndPointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecipientListEndPoint_MaxCache() {
		return (EAttribute)recipientListEndPointEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecipientListEndPoint_MediatorFlow() {
		return (EReference)recipientListEndPointEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecipientListEndPointInputConnector() {
		return recipientListEndPointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecipientListEndPointOutputConnector() {
		return recipientListEndPointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecipientListEndPointWestOutputConnector() {
		return recipientListEndPointWestOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageStoreParameter() {
		return messageStoreParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStoreParameter_ParameterName() {
		return (EAttribute)messageStoreParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStoreParameter_ParameterValue() {
		return (EAttribute)messageStoreParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageStore() {
		return messageStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_StoreName() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_StoreType() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_InitialContextFactory() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_ProviderURL() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JndiQueueName() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_ConnectionFactory() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_UserName() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_Password() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JmsSpecVersion() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_EnableCaching() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_ProviderClass() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_RabbitMQServerHostName() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_RabbitMQServerHostPort() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_RabbitMQQueueName() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_RabbitMQExchangeName() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_RoutingKey() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_RabbitMQUserName() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_RabbitMQPassword() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_VirtualHost() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JdbcDatabaseTable() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JdbcConnectionInformation() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JdbcDriver() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JdbcURL() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JdbcUser() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JdbcPassword() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_JdbcDatasourceName() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageStore_Parameters() {
		return (EReference)messageStoreEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_EnableProducerGuaranteedDelivery() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageStore_FailoverMessageStore() {
		return (EAttribute)messageStoreEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageProcessorParameter() {
		return messageProcessorParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessorParameter_ParameterName() {
		return (EAttribute)messageProcessorParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessorParameter_ParameterValue() {
		return (EAttribute)messageProcessorParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageProcessor() {
		return messageProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_ProcessorName() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_ProcessorType() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_MessageProcessorProvider() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_MessageStore() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_SourceMessageStore() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_TargetMessageStore() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_ProcessorState() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageProcessor_EndpointName() {
		return (EReference)messageProcessorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageProcessor_Sequence() {
		return (EReference)messageProcessorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_RetryInterval() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_ForwardingInterval() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_SamplingInterval() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_SamplingConcurrency() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_MaxDeliveryAttempts() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_Axis2ClientRepository() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_Axis2Configuration() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageProcessor_ReplySequenceName() {
		return (EReference)messageProcessorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageProcessor_FaultSequenceName() {
		return (EReference)messageProcessorEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageProcessor_DeactivateSequenceName() {
		return (EReference)messageProcessorEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_QuartzConfigFilePath() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_CronExpression() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_NonRetryHttpStatusCodes() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageProcessor_Parameters() {
		return (EReference)messageProcessorEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageProcessor_TaskCount() {
		return (EAttribute)messageProcessorEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIHandler() {
		return apiHandlerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIHandler_ClassName() {
		return (EAttribute)apiHandlerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPIHandler_Properties() {
		return (EReference)apiHandlerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPIHandlerProperty() {
		return apiHandlerPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIHandlerProperty_Name() {
		return (EAttribute)apiHandlerPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPIHandlerProperty_Value() {
		return (EAttribute)apiHandlerPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloudConnector() {
		return cloudConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloudConnector_InputConnector() {
		return (EReference)cloudConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloudConnector_OutputConnector() {
		return (EReference)cloudConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloudConnector_ConnectorParameters() {
		return (EReference)cloudConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloudConnectorInputConnector() {
		return cloudConnectorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloudConnectorOutputConnector() {
		return cloudConnectorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloudConnectorOperation() {
		return cloudConnectorOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloudConnectorOperation_InputConnector() {
		return (EReference)cloudConnectorOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloudConnectorOperation_OutputConnector() {
		return (EReference)cloudConnectorOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloudConnectorOperation_ConnectorParameters() {
		return (EReference)cloudConnectorOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloudConnectorOperation_ConfigRef() {
		return (EAttribute)cloudConnectorOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloudConnectorOperation_ConnectorName() {
		return (EAttribute)cloudConnectorOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloudConnectorOperation_OperationName() {
		return (EAttribute)cloudConnectorOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloudConnectorOperation_CloudConnectorName() {
		return (EAttribute)cloudConnectorOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloudConnectorOperation_NewConfig() {
		return (EReference)cloudConnectorOperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloudConnectorOperation_AvailableConfigs() {
		return (EAttribute)cloudConnectorOperationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloudConnectorOperation_ParameterEditorType() {
		return (EAttribute)cloudConnectorOperationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloudConnectorOperationInputConnector() {
		return cloudConnectorOperationInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloudConnectorOperationOutputConnector() {
		return cloudConnectorOperationOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMapperMediator() {
		return dataMapperMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperMediator_InputConnector() {
		return (EReference)dataMapperMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataMapperMediator_InputType() {
		return (EAttribute)dataMapperMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperMediator_OutputConnector() {
		return (EReference)dataMapperMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperMediator_Configuration() {
		return (EReference)dataMapperMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperMediator_InputSchema() {
		return (EReference)dataMapperMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperMediator_OutputSchema() {
		return (EReference)dataMapperMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataMapperMediator_ConfigurationLocalPath() {
		return (EAttribute)dataMapperMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataMapperMediator_InputSchemaLocalPath() {
		return (EAttribute)dataMapperMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataMapperMediator_OutputSchemaLocalPath() {
		return (EAttribute)dataMapperMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataMapperMediator_OutputType() {
		return (EAttribute)dataMapperMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMapperMediatorInputConnector() {
		return dataMapperMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMapperMediatorOutputConnector() {
		return dataMapperMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFastXSLTMediator() {
		return fastXSLTMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFastXSLTMediator_FastXsltSchemaKeyType() {
		return (EAttribute)fastXSLTMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFastXSLTMediator_FastXsltStaticSchemaKey() {
		return (EReference)fastXSLTMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFastXSLTMediator_FastXsltDynamicSchemaKey() {
		return (EReference)fastXSLTMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFastXSLTMediator_InputConnector() {
		return (EReference)fastXSLTMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFastXSLTMediator_OutputConnector() {
		return (EReference)fastXSLTMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFastXSLTMediatorInputConnector() {
		return fastXSLTMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFastXSLTMediatorOutputConnector() {
		return fastXSLTMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpoint() {
		return inboundEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpoint_SequenceInputConnector() {
		return (EReference)inboundEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpoint_SequenceOutputConnector() {
		return (EReference)inboundEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpoint_OnErrorSequenceInputConnector() {
		return (EReference)inboundEndpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpoint_OnErrorSequenceOutputConnector() {
		return (EReference)inboundEndpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpoint_Container() {
		return (EReference)inboundEndpointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Name() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Type() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHL7Port() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHL7AutoAck() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHL7MessagePreProcessor() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHL7CharSet() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHL7TimeOut() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHL7ValidateMessage() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHL7BuildInvalidMessages() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(90);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHL7PassThroughInvalidMessages() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(91);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ZookeeperConnect() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(92);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_GroupId() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(93);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ConsumerType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(95);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TopicsOrTopicFilter() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(96);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TopicsName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(97);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TopicFilterFrom() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(98);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TopicFilterName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(99);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SimpleConsumerTopic() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(100);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SimpleConsumerBrokers() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(101);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SimpleConsumerPort() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(102);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SimpleConsumerPartition() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(103);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SimpleConsumerMaxMessagesToRead() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(104);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ContentType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(94);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ThreadCount() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(105);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ConsumerId() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(106);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SocketTimeoutMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(107);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SocketReceiveBufferBytes() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(108);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_FetchMessageMaxBytes() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(109);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_NumConsumerFetches() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(110);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_AutoCommitEnable() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(111);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ZookeeperSessionTimeoutMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(124);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ZookeeperConnectionTimeoutMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(125);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ZookeeperSyncTimeMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(126);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_OffsetsStorage() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(127);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_OffsetsChannelBackoffMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(128);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_OffsetsChannelSocketTimeoutMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(129);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_OffsetsCommitMaxRetries() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(130);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_DualCommitEnabled() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(131);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_AutoCommitIntervalMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(112);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_QueuedMaxMessageChunks() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(113);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_RebalanceMaxRetries() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(114);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_FetchMinBytes() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(115);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_FetchWaitMaxMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(116);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_RebalanceBackoffMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(117);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_RefreshLeaderBackoffMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(118);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_AutoOffsetReset() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(119);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ConsumerTimeoutMs() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(120);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ExcludeInternalTopics() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(121);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_PartitionAssignmentStrategy() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(122);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_ClientId() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(123);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundCxfRmHost() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(132);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundCxfRmPort() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(133);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundCxfRmConfigFile() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(134);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_EnableSSL() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(135);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpoint_ServiceParameters() {
		return (EReference)inboundEndpointEClass.getEStructuralFeatures().get(136);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Suspend() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(137);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionFactory() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(138);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqServerHostName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(139);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqServerPort() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(140);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqServerUserName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(141);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqServerPassword() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(142);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqQueueName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(143);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqExchangeName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(144);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqQueueDurable() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(145);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqQueueExclusive() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(146);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqQueueAutoDelete() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(147);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqQueueAutoAck() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(148);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqQueueRoutingKey() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(149);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqQueueDeliveryMode() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(150);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqExchangeType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(151);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqExchangeDurable() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(152);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqExchangeAutoDelete() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(153);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqServerVirtualHost() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(154);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqFactoryHeartbeat() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(155);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionSslEnabled() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(156);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreLocation() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(157);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(158);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionSslKeystorePassword() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(159);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreLocation() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(160);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(161);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionSslTruststorePassword() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(162);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportRabbitMqConnectionSslVersion() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(163);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportFeedURL() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(164);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportFeedType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(165);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpointParameter() {
		return inboundEndpointParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpointParameter_Name() {
		return (EAttribute)inboundEndpointParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpointParameter_Value() {
		return (EAttribute)inboundEndpointParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Class() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Protocol() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundEndpointBehaviour() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundHttpPort() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundWorkerPoolSizeCore() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundWorkerPoolSizeMax() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundWorkerThreadKeepAliveSec() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundWorkerPoolQueueLength() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundThreadGroupId() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_InboundThreadId() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_DispatchFilterPattern() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Interval() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Sequential() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Coordination() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSFileURI() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSContentType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSFileNamePattern() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSFileProcessInterval() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSFileProcessCount() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSLocking() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSMaxRetryCount() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSReconnectTimeout() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSActionAfterProcess() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSMoveAfterProcess() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSActionAfterErrors() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSMoveAfterErrors() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSActionAfterFailure() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSMoveAfterFailure() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSAutoLockRelease() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSAutoLockReleaseInterval() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSLockReleaseSameNode() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSDistributedLock() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSStreaming() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSBuild() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSDistributedTimeout() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_JavaNamingFactoryInitial() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_JavaNamingProviderUrl() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSConnectionFactoryJNDIName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSConnectionFactoryType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSDestination() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSSessionTransacted() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSSessionAcknowledgement() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSCacheLevel() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSUserName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSPassword() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSJMSSpecVersion() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSSubscriptionDurable() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSDurableSubscriberClientID() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSMessageSelector() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSMoveTimestampFormat() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSFileSortAttribute() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSFileSortAscending() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSSubFolderTimestampFormat() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportVFSCreateFolder() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSReceiveTimeout() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSContentType() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSContentTypeProperty() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSReplyDestination() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSPubSubNoLocal() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportJMSDurableSubscriberName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTConnectionFactory() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTServerHostName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTServerPort() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTTopicName() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTSubscriptionQOS() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTSessionClean() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTSslEnable() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTTemporaryStoreDirectory() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTSubscriptionUsername() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTSubscriptionPassword() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_TransportMQTTClientId() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Truststore() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_Keystore() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SslVerifyClient() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_SslProtocol() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_HttpsProtocols() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInboundEndpoint_CertificateRevocationVerifier() {
		return (EAttribute)inboundEndpointEClass.getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpointContainer() {
		return inboundEndpointContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpointContainer_SequenceContainer() {
		return (EReference)inboundEndpointContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpointContainer_OnErrorSequenceContainer() {
		return (EReference)inboundEndpointContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpointSequenceContainer() {
		return inboundEndpointSequenceContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpointSequenceContainer_MediatorFlow() {
		return (EReference)inboundEndpointSequenceContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpointOnErrorSequenceContainer() {
		return inboundEndpointOnErrorSequenceContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInboundEndpointOnErrorSequenceContainer_MediatorFlow() {
		return (EReference)inboundEndpointOnErrorSequenceContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpointSequenceInputConnector() {
		return inboundEndpointSequenceInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpointSequenceOutputConnector() {
		return inboundEndpointSequenceOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpointOnErrorSequenceOutputConnector() {
		return inboundEndpointOnErrorSequenceOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInboundEndpointOnErrorSequenceInputConnector() {
		return inboundEndpointOnErrorSequenceInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommentMediator() {
		return commentMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommentMediator_CommentText() {
		return (EAttribute)commentMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getArtifactType() {
		return artifactTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCallMediatorEndpointType() {
		return callMediatorEndpointTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEndPointPropertyScope() {
		return endPointPropertyScopeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSequenceType() {
		return sequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptMediator() {
		return scriptMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_ScriptType() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_ScriptLanguage() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_MediateFunction() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptMediator_ScriptDynamicKey() {
		return (EReference)scriptMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_ScriptBody() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptMediator_InputConnector() {
		return (EReference)scriptMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptMediator_OutputConnector() {
		return (EReference)scriptMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_KeyType() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptMediator_ScriptStaticKey() {
		return (EReference)scriptMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptMediator_ScriptKeys() {
		return (EReference)scriptMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptMediatorInputConnector() {
		return scriptMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptMediatorOutputConnector() {
		return scriptMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultMediator() {
		return faultMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_SoapVersion() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_SerializeResponse() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_MarkAsResponse() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultCodeSoap11() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultCodeType() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_FaultCodeExpression() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultStringType() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultStringValue() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_FaultStringExpression() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultActor() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultCodeSoap12() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultReasonType() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultReasonValue() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_FaultReasonExpression() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_RoleName() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_NodeName() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultDetailType() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultDetailValue() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_FaultDetailExpression() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_InputConnector() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_OutputConnector() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultMediatorInputConnector() {
		return faultMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultMediatorOutputConnector() {
		return faultMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregateMediator() {
		return aggregateMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_AggregateID() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_CorrelationExpression() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_CompletionTimeout() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_CompletionMinMessagesType() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_CompletionMaxMessagesType() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_CompletionMinMessagesValue() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_CompletionMinMessagesExpression() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_CompletionMaxMessagesValue() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_CompletionMaxMessagesExpression() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_InputConnector() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_OutputConnector() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_OnCompleteOutputConnector() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_MediatorFlow() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_AggregationExpression() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_SequenceType() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_SequenceKey() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_EnclosingElementProperty() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregateMediatorInputConnector() {
		return aggregateMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregateMediatorOutputConnector() {
		return aggregateMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregateMediatorOnCompleteOutputConnector() {
		return aggregateMediatorOnCompleteOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterMediator() {
		return routerMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterMediator_ContinueAfterRouting() {
		return (EAttribute)routerMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterMediator_TargetOutputConnector() {
		return (EReference)routerMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterMediator_InputConnector() {
		return (EReference)routerMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterMediator_OutputConnector() {
		return (EReference)routerMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterMediator_RouterContainer() {
		return (EReference)routerMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterRoute() {
		return routerRouteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterRoute_BreakAfterRoute() {
		return (EAttribute)routerRouteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterRoute_RouteExpression() {
		return (EReference)routerRouteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterRoute_RoutePattern() {
		return (EAttribute)routerRouteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterTarget() {
		return routerTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterMediatorInputConnector() {
		return routerMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterMediatorOutputConnector() {
		return routerMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterMediatorTargetOutputConnector() {
		return routerMediatorTargetOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterMediatorTargetOutputConnector_SoapAction() {
		return (EAttribute)routerMediatorTargetOutputConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterMediatorTargetOutputConnector_ToAddress() {
		return (EAttribute)routerMediatorTargetOutputConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterMediatorContainer() {
		return routerMediatorContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterMediatorContainer_RouterTargetContainer() {
		return (EReference)routerMediatorContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterTargetContainer() {
		return routerTargetContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterTargetContainer_MediatorFlow() {
		return (EReference)routerTargetContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterTargetContainer_BreakAfterRoute() {
		return (EAttribute)routerTargetContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterTargetContainer_RouteExpression() {
		return (EReference)routerTargetContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterTargetContainer_RoutePattern() {
		return (EAttribute)routerTargetContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterTargetContainer_Target() {
		return (EReference)routerTargetContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneMediator() {
		return cloneMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneMediator_CloneID() {
		return (EAttribute)cloneMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneMediator_SequentialMediation() {
		return (EAttribute)cloneMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneMediator_ContinueParent() {
		return (EAttribute)cloneMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneMediator_Targets() {
		return (EReference)cloneMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneMediator_TargetsOutputConnector() {
		return (EReference)cloneMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneMediator_InputConnector() {
		return (EReference)cloneMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneMediator_OutputConnector() {
		return (EReference)cloneMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneMediator_CloneContainer() {
		return (EReference)cloneMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneTarget() {
		return cloneTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneTarget_SoapAction() {
		return (EAttribute)cloneTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneTarget_ToAddress() {
		return (EAttribute)cloneTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneMediatorInputConnector() {
		return cloneMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneMediatorOutputConnector() {
		return cloneMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneMediatorTargetOutputConnector() {
		return cloneMediatorTargetOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneMediatorTargetOutputConnector_SoapAction() {
		return (EAttribute)cloneMediatorTargetOutputConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneMediatorTargetOutputConnector_ToAddress() {
		return (EAttribute)cloneMediatorTargetOutputConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneMediatorContainer() {
		return cloneMediatorContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneMediatorContainer_CloneTargetContainer() {
		return (EReference)cloneMediatorContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneTargetContainer() {
		return cloneTargetContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneTargetContainer_MediatorFlow() {
		return (EReference)cloneTargetContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEachMediator() {
		return forEachMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForEachMediator_ForEachID() {
		return (EAttribute)forEachMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachMediator_ForEachExpression() {
		return (EReference)forEachMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachMediator_AttachPath() {
		return (EReference)forEachMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachMediator_Target() {
		return (EReference)forEachMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachMediator_InputConnector() {
		return (EReference)forEachMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachMediator_OutputConnector() {
		return (EReference)forEachMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachMediator_TargetOutputConnector() {
		return (EReference)forEachMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachMediator_MediatorFlow() {
		return (EReference)forEachMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForEachMediator_SequenceType() {
		return (EAttribute)forEachMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachMediator_SequenceKey() {
		return (EReference)forEachMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForEachMediator_SequenceName() {
		return (EAttribute)forEachMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEachMediatorInputConnector() {
		return forEachMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEachMediatorOutputConnector() {
		return forEachMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEachMediatorTargetOutputConnector() {
		return forEachMediatorTargetOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEachTarget() {
		return forEachTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForEachTarget_SoapAction() {
		return (EAttribute)forEachTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForEachTarget_ToAddress() {
		return (EAttribute)forEachTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateMediator() {
		return iterateMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_IterateID() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_SequentialMediation() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_ContinueParent() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_PreservePayload() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_IterateExpression() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_AttachPath() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_Target() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_InputConnector() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_OutputConnector() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_TargetOutputConnector() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_MediatorFlow() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_SequenceType() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_SequenceKey() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_SequenceName() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateMediatorInputConnector() {
		return iterateMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateMediatorOutputConnector() {
		return iterateMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateMediatorTargetOutputConnector() {
		return iterateMediatorTargetOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateTarget() {
		return iterateTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateTarget_SoapAction() {
		return (EAttribute)iterateTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateTarget_ToAddress() {
		return (EAttribute)iterateTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractCommonTarget() {
		return abstractCommonTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractCommonTarget_SequenceType() {
		return (EAttribute)abstractCommonTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCommonTarget_Sequence() {
		return (EReference)abstractCommonTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCommonTarget_SequenceKey() {
		return (EReference)abstractCommonTargetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractCommonTarget_EndpointType() {
		return (EAttribute)abstractCommonTargetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCommonTarget_Endpoint() {
		return (EReference)abstractCommonTargetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCommonTarget_EndpointKey() {
		return (EReference)abstractCommonTargetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediatorSequence() {
		return mediatorSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediatorSequence_Anonymous() {
		return (EAttribute)mediatorSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediatorSequence_SequenceName() {
		return (EAttribute)mediatorSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediatorSequence_Mediators() {
		return (EReference)mediatorSequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediatorSequence_OnError() {
		return (EReference)mediatorSequenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediatorSequence_Description() {
		return (EAttribute)mediatorSequenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheMediator() {
		return cacheMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_CacheId() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_CacheScope() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_CacheAction() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_HashGenerator() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_CacheTimeout() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_MaxMessageSize() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_ImplementationType() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_MaxEntryCount() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_SequenceType() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheMediator_SequenceKey() {
		return (EReference)cacheMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheMediator_InputConnector() {
		return (EReference)cacheMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheMediator_OutputConnector() {
		return (EReference)cacheMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheMediator_OnHitOutputConnector() {
		return (EReference)cacheMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheMediator_MediatorFlow() {
		return (EReference)cacheMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheMediatorInputConnector() {
		return cacheMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheMediatorOutputConnector() {
		return cacheMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheMediatorOnHitOutputConnector() {
		return cacheMediatorOnHitOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheOnHitBranch() {
		return cacheOnHitBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXQueryMediator() {
		return xQueryMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_Variables() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_TargetXPath() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryMediator_ScriptKeyType() {
		return (EAttribute)xQueryMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_StaticScriptKey() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_DynamicScriptKey() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_QueryKey() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_InputConnector() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_OutputConnector() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXQueryMediatorInputConnector() {
		return xQueryMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXQueryMediatorOutputConnector() {
		return xQueryMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXQueryVariable() {
		return xQueryVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryVariable_VariableName() {
		return (EAttribute)xQueryVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryVariable_VariableType() {
		return (EAttribute)xQueryVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryVariable_ValueType() {
		return (EAttribute)xQueryVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryVariable_ValueLiteral() {
		return (EAttribute)xQueryVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryVariable_ValueExpression() {
		return (EReference)xQueryVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryVariable_ValueKey() {
		return (EReference)xQueryVariableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalloutMediator() {
		return calloutMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_ServiceURL() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_SoapAction() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PathToAxis2xml() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PathToAxis2Repository() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PayloadType() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_PayloadMessageXpath() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_ResultType() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_ResultMessageXpath() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_ResultContextProperty() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PassHeaders() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_InputConnector() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_OutputConnector() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_AddressEndpoint() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_EndpointType() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PayloadProperty() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_SecurityType() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_OutboundPolicyKey() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_InboundPolicyKey() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_Policies() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_PolicyKey() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_InitAxis2ClientOptions() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalloutMediatorInputConnector() {
		return calloutMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalloutMediatorOutputConnector() {
		return calloutMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRMSequenceMediator() {
		return rmSequenceMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRMSequenceMediator_RmSpecVersion() {
		return (EAttribute)rmSequenceMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRMSequenceMediator_SequenceType() {
		return (EAttribute)rmSequenceMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRMSequenceMediator_CorrelationXpath() {
		return (EReference)rmSequenceMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRMSequenceMediator_LastMessageXpath() {
		return (EReference)rmSequenceMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRMSequenceMediator_InputConnector() {
		return (EReference)rmSequenceMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRMSequenceMediator_OutputConnector() {
		return (EReference)rmSequenceMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRMSequenceMediatorInputConnector() {
		return rmSequenceMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRMSequenceMediatorOutputConnector() {
		return rmSequenceMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionMediator() {
		return transactionMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransactionMediator_Action() {
		return (EAttribute)transactionMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransactionMediator_InputConnector() {
		return (EReference)transactionMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransactionMediator_OutputConnector() {
		return (EReference)transactionMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionMediatorInputConnector() {
		return transactionMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionMediatorOutputConnector() {
		return transactionMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOAuthMediator() {
		return oAuthMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOAuthMediator_RemoteServiceUrl() {
		return (EAttribute)oAuthMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOAuthMediator_Username() {
		return (EAttribute)oAuthMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOAuthMediator_Password() {
		return (EAttribute)oAuthMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOAuthMediator_InputConnector() {
		return (EReference)oAuthMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOAuthMediator_OutputConnector() {
		return (EReference)oAuthMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOAuthMediatorInputConnector() {
		return oAuthMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOAuthMediatorOutputConnector() {
		return oAuthMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutoscaleInMediator() {
		return autoscaleInMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutoscaleOutMediator() {
		return autoscaleOutMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeaderMediator() {
		return headerMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeaderMediator_HeaderName() {
		return (EReference)headerMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderMediator_HeaderAction() {
		return (EAttribute)headerMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderMediator_ValueType() {
		return (EAttribute)headerMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderMediator_Scope() {
		return (EAttribute)headerMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderMediator_ValueLiteral() {
		return (EAttribute)headerMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeaderMediator_ValueExpression() {
		return (EReference)headerMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeaderMediator_InputConnector() {
		return (EReference)headerMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeaderMediator_OutputConnector() {
		return (EReference)headerMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderMediator_ValueInline() {
		return (EAttribute)headerMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeaderMediatorInputConnector() {
		return headerMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeaderMediatorOutputConnector() {
		return headerMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottleMediator() {
		return throttleMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleMediator_GroupId() {
		return (EAttribute)throttleMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleMediator_PolicyType() {
		return (EAttribute)throttleMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_PolicyKey() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleMediator_MaxConcurrentAccessCount() {
		return (EAttribute)throttleMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_PolicyEntries() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_PolicyConfiguration() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_OnAcceptBranch() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_OnRejectBranch() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_InputConnector() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_OutputConnector() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getThrottleMediator_OnAcceptOutputConnector() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(10);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getThrottleMediator_OnRejectOutputConnector() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(11);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getThrottleMediator_ThrottleContainer() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(12);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleMediator_OnAcceptBranchsequenceType() {
		return (EAttribute)throttleMediatorEClass.getEStructuralFeatures().get(13);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_OnAcceptBranchsequenceKey() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(14);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleMediator_OnRejectBranchsequenceType() {
		return (EAttribute)throttleMediatorEClass.getEStructuralFeatures().get(15);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_OnRejectBranchsequenceKey() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(16);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottleMediatorInputConnector() {
		return throttleMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottleMediatorOutputConnector() {
		return throttleMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getThrottleMediatorOnAcceptOutputConnector() {
		return throttleMediatorOnAcceptOutputConnectorEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getThrottleMediatorOnRejectOutputConnector() {
		return throttleMediatorOnRejectOutputConnectorEClass;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottlePolicyConfiguration() {
		return throttlePolicyConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyConfiguration_PolicyType() {
		return (EAttribute)throttlePolicyConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottlePolicyConfiguration_PolicyKey() {
		return (EReference)throttlePolicyConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyConfiguration_MaxConcurrentAccessCount() {
		return (EAttribute)throttlePolicyConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottlePolicyConfiguration_PolicyEntries() {
		return (EReference)throttlePolicyConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottlePolicyEntry() {
		return throttlePolicyEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_ThrottleType() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_ThrottleRange() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_AccessType() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_MaxRequestCount() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_UnitTime() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_ProhibitPeriod() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottleOnAcceptBranch() {
		return throttleOnAcceptBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleOnAcceptBranch_SequenceType() {
		return (EAttribute)throttleOnAcceptBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleOnAcceptBranch_SequenceKey() {
		return (EReference)throttleOnAcceptBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottleOnRejectBranch() {
		return throttleOnRejectBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleOnRejectBranch_SequenceType() {
		return (EAttribute)throttleOnRejectBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleOnRejectBranch_SequenceKey() {
		return (EReference)throttleOnRejectBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getThrottleContainer() {
		return throttleContainerEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getThrottleContainer_OnAcceptContainer() {
		return (EReference)throttleContainerEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getThrottleContainer_OnRejectContainer() {
		return (EReference)throttleContainerEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getThrottleOnAcceptContainer() {
		return throttleOnAcceptContainerEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getThrottleOnAcceptContainer_MediatorFlow() {
		return (EReference)throttleOnAcceptContainerEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getThrottleOnRejectContainer() {
		return throttleOnRejectContainerEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getThrottleOnRejectContainer_MediatorFlow() {
		return (EReference)throttleOnRejectContainerEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandMediator() {
		return commandMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandMediator_ClassName() {
		return (EAttribute)commandMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandMediator_Properties() {
		return (EReference)commandMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandMediator_InputConnector() {
		return (EReference)commandMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandMediator_OutputConnector() {
		return (EReference)commandMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandMediatorInputConnector() {
		return commandMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandMediatorOutputConnector() {
		return commandMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandProperty() {
		return commandPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_PropertyName() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_ValueType() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_ValueLiteral() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_ValueContextPropertyName() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandProperty_ValueMessageElementXpath() {
		return (EReference)commandPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_ContextAction() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_MessageAction() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractSqlExecutorMediator() {
		return abstractSqlExecutorMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionType() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionDsType() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionDbDriver() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionDsInitialContext() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionDsName() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionURL() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionUsername() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionPassword() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyAutocommit() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyIsolation() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMaxactive() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMaxidle() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMaxopenstatements() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMaxwait() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMinidle() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyPoolstatements() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyTestonborrow() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyTestwhileidle() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyValidationquery() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyInitialsize() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSqlExecutorMediator_SqlStatements() {
		return (EReference)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlStatement() {
		return sqlStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlStatement_QueryString() {
		return (EAttribute)sqlStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSqlStatement_Parameters() {
		return (EReference)sqlStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlStatement_ResultsEnabled() {
		return (EAttribute)sqlStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSqlStatement_Results() {
		return (EReference)sqlStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlParameterDefinition() {
		return sqlParameterDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlParameterDefinition_DataType() {
		return (EAttribute)sqlParameterDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlParameterDefinition_ValueType() {
		return (EAttribute)sqlParameterDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlParameterDefinition_ValueLiteral() {
		return (EAttribute)sqlParameterDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSqlParameterDefinition_ValueExpression() {
		return (EReference)sqlParameterDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlResultMapping() {
		return sqlResultMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlResultMapping_PropertyName() {
		return (EAttribute)sqlResultMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlResultMapping_ColumnId() {
		return (EAttribute)sqlResultMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBLookupMediator() {
		return dbLookupMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBLookupMediator_InputConnector() {
		return (EReference)dbLookupMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBLookupMediator_OutputConnector() {
		return (EReference)dbLookupMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBLookupMediatorInputConnector() {
		return dbLookupMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBLookupMediatorOutputConnector() {
		return dbLookupMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBReportMediator() {
		return dbReportMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDBReportMediator_ConnectionUseTransaction() {
		return (EAttribute)dbReportMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBReportMediator_InputConnector() {
		return (EReference)dbReportMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBReportMediator_OutputConnector() {
		return (EReference)dbReportMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBReportMediatorInputConnector() {
		return dbReportMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBReportMediatorOutputConnector() {
		return dbReportMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleMediator() {
		return ruleMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_RuleSetURL() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_RuleSetSourceType() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_RuleSetSourceCode() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_RuleSetSourceKey() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_StatefulSession() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_RuleSessionProperties() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_FactsConfiguration() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_ResultsConfiguration() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_ChildMediatorsConfiguration() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_InputConnector() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_OutputConnector() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_ChildMediatorsOutputConnector() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_MediatorFlow() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_SourceValue() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_SourceXpath() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_TargetValue() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_TargetResultXpath() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_TargetXpath() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_TargetAction() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_InputWrapperName() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_InputNameSpace() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_OutputWrapperName() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_OutputNameSpace() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleMediator_RuleSetType() {
		return (EAttribute)ruleMediatorEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleMediatorInputConnector() {
		return ruleMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleMediatorOutputConnector() {
		return ruleMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleMediatorChildMediatorsOutputConnector() {
		return ruleMediatorChildMediatorsOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleSetCreationProperty() {
		return ruleSetCreationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleSessionProperty() {
		return ruleSessionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleFactsConfiguration() {
		return ruleFactsConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleFactsConfiguration_Facts() {
		return (EReference)ruleFactsConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleFact() {
		return ruleFactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_FactType() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_FactCustomType() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_FactName() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_ValueType() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_ValueLiteral() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleFact_ValueExpression() {
		return (EReference)ruleFactEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleFact_ValueKey() {
		return (EReference)ruleFactEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleResultsConfiguration() {
		return ruleResultsConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleResultsConfiguration_Results() {
		return (EReference)ruleResultsConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleResult() {
		return ruleResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ResultType() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ResultCustomType() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ResultName() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ValueType() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ValueLiteral() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleResult_ValueExpression() {
		return (EReference)ruleResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleResult_ValueKey() {
		return (EReference)ruleResultEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleChildMediatorsConfiguration() {
		return ruleChildMediatorsConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallTemplateParameter() {
		return callTemplateParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateParameter_ParameterName() {
		return (EAttribute)callTemplateParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateParameter_TemplateParameterType() {
		return (EAttribute)callTemplateParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateParameter_ParameterValue() {
		return (EAttribute)callTemplateParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallTemplateParameter_ParameterExpression() {
		return (EReference)callTemplateParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallTemplateMediator() {
		return callTemplateMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateMediator_AvailableTemplates() {
		return (EAttribute)callTemplateMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallTemplateMediator_TemplateParameters() {
		return (EReference)callTemplateMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallTemplateMediator_InputConnector() {
		return (EReference)callTemplateMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallTemplateMediator_OutputConnector() {
		return (EReference)callTemplateMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateMediator_TargetTemplate() {
		return (EAttribute)callTemplateMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallTemplateMediatorInputConnector() {
		return callTemplateMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallTemplateMediatorOutputConnector() {
		return callTemplateMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopBackMediator() {
		return loopBackMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopBackMediator_InputConnector() {
		return (EReference)loopBackMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopBackMediator_OutputConnector() {
		return (EReference)loopBackMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopBackMediatorInputConnector() {
		return loopBackMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopBackMediatorOutputConnector() {
		return loopBackMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRespondMediator() {
		return respondMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRespondMediator_InputConnector() {
		return (EReference)respondMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRespondMediator_OutputConnector() {
		return (EReference)respondMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRespondMediatorInputConnector() {
		return respondMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRespondMediatorOutputConnector() {
		return respondMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmooksMediator() {
		return smooksMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksMediator_ConfigurationKey() {
		return (EReference)smooksMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksMediator_InputType() {
		return (EAttribute)smooksMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksMediator_InputExpression() {
		return (EReference)smooksMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksMediator_OutputType() {
		return (EAttribute)smooksMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksMediator_OutputExpression() {
		return (EReference)smooksMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksMediator_OutputProperty() {
		return (EAttribute)smooksMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksMediator_OutputAction() {
		return (EAttribute)smooksMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksMediator_OutputMethod() {
		return (EAttribute)smooksMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksMediator_InputConnector() {
		return (EReference)smooksMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksMediator_OutputConnector() {
		return (EReference)smooksMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmooksMediatorInputConnector() {
		return smooksMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmooksMediatorOutputConnector() {
		return smooksMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoreMediator() {
		return storeMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStoreMediator_MessageStore() {
		return (EAttribute)storeMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoreMediator_OnStoreSequence() {
		return (EReference)storeMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoreMediator_InputConnector() {
		return (EReference)storeMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoreMediator_OutputConnector() {
		return (EReference)storeMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStoreMediator_AvailableMessageStores() {
		return (EAttribute)storeMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoreMediatorInputConnector() {
		return storeMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoreMediatorOutputConnector() {
		return storeMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilderMediator() {
		return builderMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderMediator_MessageBuilders() {
		return (EReference)builderMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderMediator_InputConnector() {
		return (EReference)builderMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderMediator_OutputConnector() {
		return (EReference)builderMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilderMediatorInputConnector() {
		return builderMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilderMediatorOutputConector() {
		return builderMediatorOutputConectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageBuilder() {
		return messageBuilderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageBuilder_ContentType() {
		return (EAttribute)messageBuilderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageBuilder_BuilderClass() {
		return (EAttribute)messageBuilderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageBuilder_FormatterClass() {
		return (EAttribute)messageBuilderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPayloadFactoryMediator() {
		return payloadFactoryMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPayloadFactoryMediator_Payload() {
		return (EAttribute)payloadFactoryMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPayloadFactoryMediator_PayloadKey() {
		return (EReference)payloadFactoryMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPayloadFactoryMediator_Args() {
		return (EReference)payloadFactoryMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPayloadFactoryMediator_InputConnector() {
		return (EReference)payloadFactoryMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPayloadFactoryMediator_OutputConnector() {
		return (EReference)payloadFactoryMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPayloadFactoryMediator_MediaType() {
		return (EAttribute)payloadFactoryMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPayloadFactoryMediator_PayloadFormat() {
		return (EAttribute)payloadFactoryMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPayloadFactoryMediatorInputConnector() {
		return payloadFactoryMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPayloadFactoryMediatorOutputConnector() {
		return payloadFactoryMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPayloadFactoryArgument() {
		return payloadFactoryArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPayloadFactoryArgument_ArgumentType() {
		return (EAttribute)payloadFactoryArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPayloadFactoryArgument_ArgumentValue() {
		return (EAttribute)payloadFactoryArgumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPayloadFactoryArgument_ArgumentExpression() {
		return (EReference)payloadFactoryArgumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPayloadFactoryArgument_Evaluator() {
		return (EAttribute)payloadFactoryArgumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalRouteBranch() {
		return conditionalRouteBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalRouteBranch_BreakAfterRoute() {
		return (EAttribute)conditionalRouteBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouteBranch_EvaluatorExpression() {
		return (EReference)conditionalRouteBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouteBranch_TargetSequence() {
		return (EReference)conditionalRouteBranchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalRouterMediator() {
		return conditionalRouterMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalRouterMediator_ContinueAfterRoute() {
		return (EAttribute)conditionalRouterMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouterMediator_ConditionalRouteBranches() {
		return (EReference)conditionalRouterMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouterMediator_InputConnector() {
		return (EReference)conditionalRouterMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouterMediator_OutputConnector() {
		return (EReference)conditionalRouterMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouterMediator_AdditionalOutputConnector() {
		return (EReference)conditionalRouterMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouterMediator_MediatorFlow() {
		return (EReference)conditionalRouterMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalRouterMediatorInputConnector() {
		return conditionalRouterMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalRouterMediatorOutputConnector() {
		return conditionalRouterMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalRouterMediatorAdditionalOutputConnector() {
		return conditionalRouterMediatorAdditionalOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSendMediator() {
		return sendMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_EndPoint() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_InputConnector() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_OutputConnector() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSendMediator_ReceivingSequenceType() {
		return (EAttribute)sendMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_StaticReceivingSequence() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_DynamicReceivingSequence() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSendMediator_EndpointOutputConnector() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_MediatorFlow() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(7);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSendMediator_SkipSerialization() {
		return (EAttribute)sendMediatorEClass.getEStructuralFeatures().get(8);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSendMediator_BuildMessageBeforeSending() {
		return (EAttribute)sendMediatorEClass.getEStructuralFeatures().get(9);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSendContainer() {
		return sendContainerEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getSendContainer_EndpointFlow() {
		return (EReference)sendContainerEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSendMediatorInputConnector() {
		return sendMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSendMediatorOutputConnector() {
		return sendMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getSendMediatorEndpointOutputConnector() {
		return sendMediatorEndpointOutputConnectorEClass;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailoverEndPoint() {
		return failoverEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailoverEndPoint_InputConnector() {
		return (EReference)failoverEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailoverEndPoint_OutputConnector() {
		return (EReference)failoverEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailoverEndPoint_WestOutputConnector() {
		return (EReference)failoverEndPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailoverEndPoint_MediatorFlow() {
		return (EReference)failoverEndPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailoverEndPointInputConnector() {
		return failoverEndPointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailoverEndPointOutputConnector() {
		return failoverEndPointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailoverEndPointWestOutputConnector() {
		return failoverEndPointWestOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParentEndPoint() {
		return parentEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParentEndPoint_Children() {
		return (EReference)parentEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParentEndPoint_Name() {
		return (EAttribute)parentEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSDLEndPoint() {
		return wsdlEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSDLEndPoint_InputConnector() {
		return (EReference)wsdlEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSDLEndPoint_OutputConnector() {
		return (EReference)wsdlEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSDLEndPoint_WsdlUri() {
		return (EAttribute)wsdlEndPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSDLEndPoint_Service() {
		return (EAttribute)wsdlEndPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSDLEndPoint_Port() {
		return (EAttribute)wsdlEndPointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSDLEndPointInputConnector() {
		return wsdlEndPointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSDLEndPointOutputConnector() {
		return wsdlEndPointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadBalanceEndPoint() {
		return loadBalanceEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalanceEndPoint_Failover() {
		return (EAttribute)loadBalanceEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalanceEndPoint_Policy() {
		return (EAttribute)loadBalanceEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadBalanceEndPoint_InputConnector() {
		return (EReference)loadBalanceEndPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadBalanceEndPoint_OutputConnector() {
		return (EReference)loadBalanceEndPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadBalanceEndPoint_WestOutputConnector() {
		return (EReference)loadBalanceEndPointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadBalanceEndPoint_Member() {
		return (EReference)loadBalanceEndPointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalanceEndPoint_SessionType() {
		return (EAttribute)loadBalanceEndPointEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalanceEndPoint_Algorithm() {
		return (EAttribute)loadBalanceEndPointEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadBalanceEndPoint_SessionTimeout() {
		return (EAttribute)loadBalanceEndPointEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadBalanceEndPoint_MediatorFlow() {
		return (EReference)loadBalanceEndPointEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMember() {
		return memberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMember_HostName() {
		return (EAttribute)memberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMember_HttpPort() {
		return (EAttribute)memberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMember_HttpsPort() {
		return (EAttribute)memberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadBalanceEndPointInputConnector() {
		return loadBalanceEndPointInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadBalanceEndPointOutputConnector() {
		return loadBalanceEndPointOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadBalanceEndPointWestOutputConnector() {
		return loadBalanceEndPointWestOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalEntry() {
		return localEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_EntryName() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_LocalEntryType() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_ValueLiteral() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_ValueXML() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_ValueURL() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSession() {
		return sessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSession_Type() {
		return (EAttribute)sessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequences() {
		return sequencesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequences_MediatorFlow() {
		return (EReference)sequencesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequences_Name() {
		return (EAttribute)sequencesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequences_RecieveSequence() {
		return (EAttribute)sequencesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequences_AssociatedProxy() {
		return (EAttribute)sequencesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequences_OnError() {
		return (EReference)sequencesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequences_TemplateParameters() {
		return (EReference)sequencesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequences_TraceEnabled() {
		return (EAttribute)sequencesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequences_StatisticsEnabled() {
		return (EAttribute)sequencesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequences_OutputConnector() {
		return (EReference)sequencesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequences_InputConnector() {
		return (EReference)sequencesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequencesOutputConnector() {
		return sequencesOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequencesInputConnector() {
		return sequencesInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLRewriteRuleAction() {
		return urlRewriteRuleActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_RuleAction() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_RuleFragment() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_RuleOption() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteRuleAction_ActionExpression() {
		return (EReference)urlRewriteRuleActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_ActionValue() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_ActionRegex() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLRewriteRule() {
		return urlRewriteRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteRule_UrlRewriteRuleCondition() {
		return (EReference)urlRewriteRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteRule_RewriteRuleAction() {
		return (EReference)urlRewriteRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLRewriteMediator() {
		return urlRewriteMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteMediator_UrlRewriteRules() {
		return (EReference)urlRewriteMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteMediator_InProperty() {
		return (EAttribute)urlRewriteMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteMediator_OutProperty() {
		return (EAttribute)urlRewriteMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteMediator_InputConnector() {
		return (EReference)urlRewriteMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteMediator_OutputConnector() {
		return (EReference)urlRewriteMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLRewriteMediatorInputConnector() {
		return urlRewriteMediatorInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLRewriteMediatorOutputConnector() {
		return urlRewriteMediatorOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluatorExpressionProperty() {
		return evaluatorExpressionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluatorExpressionProperty_PrettyName() {
		return (EAttribute)evaluatorExpressionPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluatorExpressionProperty_EvaluatorName() {
		return (EAttribute)evaluatorExpressionPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluatorExpressionProperty_EvaluatorValue() {
		return (EAttribute)evaluatorExpressionPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProxyWsdlType() {
		return proxyWsdlTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHttpMethodType() {
		return httpMethodTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFilterMediatorConditionType() {
		return filterMediatorConditionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogCategory() {
		return logCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogLevel() {
		return logLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAttributeValueType() {
		return attributeValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAttributeType() {
		return attributeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBeanMediatorAction() {
		return beanMediatorActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEndPointAddressingVersion() {
		return endPointAddressingVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEndPointTimeOutAction() {
		return endPointTimeOutActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEndPointMessageFormat() {
		return endPointMessageFormatEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEndPointAttachmentOptimization() {
		return endPointAttachmentOptimizationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyDataType() {
		return propertyDataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyAction() {
		return propertyActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyScope() {
		return propertyScopeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyValueType() {
		return propertyValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyName() {
		return propertyNameEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnrichSourceInlineType() {
		return enrichSourceInlineTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnrichSourceType() {
		return enrichSourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnrichTargetAction() {
		return enrichTargetActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnrichTargetType() {
		return enrichTargetTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEventTopicType() {
		return eventTopicTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEntitlementCallbackHandler() {
		return entitlementCallbackHandlerEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEntitlementClientType() {
		return entitlementClientTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEntitlementSequenceType() {
		return entitlementSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getscriptKeyTypeEnum() {
		return scriptKeyTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScriptType() {
		return scriptTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScriptLanguage() {
		return scriptLanguageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultSoapVersion() {
		return faultSoapVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultCodeSoap11() {
		return faultCodeSoap11EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultCodeSoap12() {
		return faultCodeSoap12EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultCodeType() {
		return faultCodeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultStringType() {
		return faultStringTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultReasonType() {
		return faultReasonTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultDetailType() {
		return faultDetailTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompletionMessagesType() {
		return completionMessagesTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAggregateSequenceType() {
		return aggregateSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTargetSequenceType() {
		return targetSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTargetEndpointType() {
		return targetEndpointTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCacheSequenceType() {
		return cacheSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCacheImplementationType() {
		return cacheImplementationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCacheAction() {
		return cacheActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCacheScope() {
		return cacheScopeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getXQueryVariableType() {
		return xQueryVariableTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getXQueryVariableValueType() {
		return xQueryVariableValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCalloutEndpointType() {
		return calloutEndpointTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCalloutPayloadType() {
		return calloutPayloadTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCalloutSecurityPolicies() {
		return calloutSecurityPoliciesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCalloutSecurityType() {
		return calloutSecurityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCalloutResultType() {
		return calloutResultTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRMSpecVersion() {
		return rmSpecVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRMSequenceType() {
		return rmSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransactionAction() {
		return transactionActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHeaderAction() {
		return headerActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHeaderValueType() {
		return headerValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScopeType() {
		return scopeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThrottlePolicyType() {
		return throttlePolicyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThrottleConditionType() {
		return throttleConditionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThrottleAccessType() {
		return throttleAccessTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThrottleSequenceType() {
		return throttleSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCommandPropertyValueType() {
		return commandPropertyValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCommandPropertyMessageAction() {
		return commandPropertyMessageActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCommandPropertyContextAction() {
		return commandPropertyContextActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlExecutorConnectionType() {
		return sqlExecutorConnectionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlExecutorDatasourceType() {
		return sqlExecutorDatasourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlExecutorBooleanValue() {
		return sqlExecutorBooleanValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlExecutorIsolationLevel() {
		return sqlExecutorIsolationLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlParameterValueType() {
		return sqlParameterValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlParameterDataType() {
		return sqlParameterDataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleActions() {
		return ruleActionsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleType() {
		return ruleTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleSourceType() {
		return ruleSourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleFactType() {
		return ruleFactTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleFactValueType() {
		return ruleFactValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleResultType() {
		return ruleResultTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleResultValueType() {
		return ruleResultValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleOptionType() {
		return ruleOptionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSmooksIODataType() {
		return smooksIODataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSmooksOutputDataType() {
		return smooksOutputDataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExpressionAction() {
		return expressionActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOutputMethod() {
		return outputMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReceivingSequenceType() {
		return receivingSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKeyType() {
		return keyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMediaType() {
		return mediaTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPayloadFactoryArgumentType() {
		return payloadFactoryArgumentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPayloadFormatType() {
		return payloadFormatTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getType() {
		return typeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLoadBalanceSessionType() {
		return loadBalanceSessionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLocalEntryValueType() {
		return localEntryValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleActionType() {
		return ruleActionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleFragmentType() {
		return ruleFragmentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTemplateType() {
		return templateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTaskPropertyType() {
		return taskPropertyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTaskTriggerType() {
		return taskTriggerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getApiResourceUrlStyle() {
		return apiResourceUrlStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRecipientListEndpointType() {
		return recipientListEndpointTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMessageStoreType() {
		return messageStoreTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJMSSpecVersion() {
		return jmsSpecVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJDBCConnectionInformationType() {
		return jdbcConnectionInformationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMessageProcessorType() {
		return messageProcessorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProcessorState() {
		return processorStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCloudConnectorOperationParamEditorType() {
		return cloudConnectorOperationParamEditorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataMapperMediatorDataTypes() {
		return dataMapperMediatorDataTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProtocol() {
		return protocolEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInboundEndpointType() {
		return inboundEndpointTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInboundEndpointBehaviourType() {
		return inboundEndpointBehaviourTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContentType() {
		return contentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTopicsType() {
		return topicsTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTopicFilterFromType() {
		return topicFilterFromTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConsumerType() {
		return consumerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAutoOffsetResetType() {
		return autoOffsetResetTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPartitionAssignmentStrategyType() {
		return partitionAssignmentStrategyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOffsetsStorageType() {
		return offsetsStorageTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnable() {
		return enableEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVFSAction() {
		return vfsActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVFSFileSort() {
		return vfsFileSortEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJMSConnectionFactoryType() {
		return jmsConnectionFactoryTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJMSSessionAcknowledgement() {
		return jmsSessionAcknowledgementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJMSCacheLevel() {
		return jmsCacheLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMQTTSubscriptionQOS() {
		return mqttSubscriptionQOSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeedType() {
		return feedTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnableDisableState() {
		return enableDisableStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMap() {
		return mapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbFactory getEsbFactory() {
		return (EsbFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		esbDiagramEClass = createEClass(ESB_DIAGRAM);
		createEReference(esbDiagramEClass, ESB_DIAGRAM__SERVER);
		createEAttribute(esbDiagramEClass, ESB_DIAGRAM__TEST);

		esbNodeEClass = createEClass(ESB_NODE);

		esbElementEClass = createEClass(ESB_ELEMENT);
		createEAttribute(esbElementEClass, ESB_ELEMENT__DESCRIPTION);
		createEAttribute(esbElementEClass, ESB_ELEMENT__COMMENTS_LIST);

		esbServerEClass = createEClass(ESB_SERVER);
		createEReference(esbServerEClass, ESB_SERVER__CHILDREN);
		createEReference(esbServerEClass, ESB_SERVER__MESSAGE_MEDIATOR);
		createEAttribute(esbServerEClass, ESB_SERVER__TYPE);

		mediatorEClass = createEClass(MEDIATOR);
		createEAttribute(mediatorEClass, MEDIATOR__REVERSE);

		esbConnectorEClass = createEClass(ESB_CONNECTOR);

		inputConnectorEClass = createEClass(INPUT_CONNECTOR);
		createEReference(inputConnectorEClass, INPUT_CONNECTOR__INCOMING_LINKS);

		outputConnectorEClass = createEClass(OUTPUT_CONNECTOR);
		createEReference(outputConnectorEClass, OUTPUT_CONNECTOR__OUTGOING_LINK);
		createEReference(outputConnectorEClass, OUTPUT_CONNECTOR__COMMENT_MEDIATORS);

		additionalOutputConnectorEClass = createEClass(ADDITIONAL_OUTPUT_CONNECTOR);
		createEReference(additionalOutputConnectorEClass, ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK);

		esbLinkEClass = createEClass(ESB_LINK);
		createEReference(esbLinkEClass, ESB_LINK__SOURCE);
		createEReference(esbLinkEClass, ESB_LINK__TARGET);

		endPointEClass = createEClass(END_POINT);
		createEAttribute(endPointEClass, END_POINT__END_POINT_NAME);
		createEAttribute(endPointEClass, END_POINT__ANONYMOUS);
		createEAttribute(endPointEClass, END_POINT__IN_LINE);
		createEAttribute(endPointEClass, END_POINT__DUPLICATE);
		createEReference(endPointEClass, END_POINT__PROPERTIES);
		createEAttribute(endPointEClass, END_POINT__REVERSED);

		callMediatorEClass = createEClass(CALL_MEDIATOR);
		createEReference(callMediatorEClass, CALL_MEDIATOR__INPUT_CONNECTOR);
		createEReference(callMediatorEClass, CALL_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(callMediatorEClass, CALL_MEDIATOR__ENDPOINT);
		createEReference(callMediatorEClass, CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR);
		createEReference(callMediatorEClass, CALL_MEDIATOR__MEDIATOR_FLOW);
		createEAttribute(callMediatorEClass, CALL_MEDIATOR__ENDPOINT_TYPE);
		createEAttribute(callMediatorEClass, CALL_MEDIATOR__ENABLE_BLOCKING_CALLS);
		createEReference(callMediatorEClass, CALL_MEDIATOR__ENDPOINT_REGISTRYKEY);
		createEReference(callMediatorEClass, CALL_MEDIATOR__ENDPOINT_XPATH);

		callMediatorInputConnectorEClass = createEClass(CALL_MEDIATOR_INPUT_CONNECTOR);

		callMediatorOutputConnectorEClass = createEClass(CALL_MEDIATOR_OUTPUT_CONNECTOR);

		callMediatorEndpointOutputConnectorEClass = createEClass(CALL_MEDIATOR_ENDPOINT_OUTPUT_CONNECTOR);

		endPointPropertyEClass = createEClass(END_POINT_PROPERTY);
		createEAttribute(endPointPropertyEClass, END_POINT_PROPERTY__NAME);
		createEAttribute(endPointPropertyEClass, END_POINT_PROPERTY__VALUE);
		createEAttribute(endPointPropertyEClass, END_POINT_PROPERTY__SCOPE);
		createEAttribute(endPointPropertyEClass, END_POINT_PROPERTY__VALUE_TYPE);
		createEReference(endPointPropertyEClass, END_POINT_PROPERTY__VALUE_EXPRESSION);

		proxyServiceEClass = createEClass(PROXY_SERVICE);
		createEReference(proxyServiceEClass, PROXY_SERVICE__OUTPUT_CONNECTOR);
		createEReference(proxyServiceEClass, PROXY_SERVICE__INPUT_CONNECTOR);
		createEReference(proxyServiceEClass, PROXY_SERVICE__FAULT_INPUT_CONNECTOR);
		createEReference(proxyServiceEClass, PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR);
		createEReference(proxyServiceEClass, PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__NAME);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__PINNED_SERVERS);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__SERVICE_GROUP);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__TRACE_ENABLED);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__STATISTICS_ENABLED);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__START_ON_LOAD);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__TRANSPORTS);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__SECURITY_ENABLED);
		createEReference(proxyServiceEClass, PROXY_SERVICE__SERVICE_PARAMETERS);
		createEReference(proxyServiceEClass, PROXY_SERVICE__SERVICE_POLICIES);
		createEReference(proxyServiceEClass, PROXY_SERVICE__CONTAINER);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__IN_SEQUENCE_TYPE);
		createEReference(proxyServiceEClass, PROXY_SERVICE__IN_SEQUENCE_KEY);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__IN_SEQUENCE_NAME);
		createEReference(proxyServiceEClass, PROXY_SERVICE__IN_SEQUENCE_ON_ERROR);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__OUT_SEQUENCE_TYPE);
		createEReference(proxyServiceEClass, PROXY_SERVICE__OUT_SEQUENCE_KEY);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__OUT_SEQUENCE_NAME);
		createEReference(proxyServiceEClass, PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__FAULT_SEQUENCE_TYPE);
		createEReference(proxyServiceEClass, PROXY_SERVICE__FAULT_SEQUENCE_KEY);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__FAULT_SEQUENCE_NAME);
		createEReference(proxyServiceEClass, PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__ENDPOINT_TYPE);
		createEReference(proxyServiceEClass, PROXY_SERVICE__ENDPOINT_KEY);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__ENDPOINT_NAME);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__MAIN_SEQUENCE);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__WSDL_TYPE);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__WSDL_XML);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__WSDL_URL);
		createEReference(proxyServiceEClass, PROXY_SERVICE__WSDL_KEY);
		createEReference(proxyServiceEClass, PROXY_SERVICE__WSDL_ENDPOINT);
		createEReference(proxyServiceEClass, PROXY_SERVICE__WSDL_RESOURCES);
		createEReference(proxyServiceEClass, PROXY_SERVICE__ON_ERROR);

		proxyOutputConnectorEClass = createEClass(PROXY_OUTPUT_CONNECTOR);

		proxyInputConnectorEClass = createEClass(PROXY_INPUT_CONNECTOR);

		proxyOutSequenceOutputConnectorEClass = createEClass(PROXY_OUT_SEQUENCE_OUTPUT_CONNECTOR);

		proxyInSequenceInputConnectorEClass = createEClass(PROXY_IN_SEQUENCE_INPUT_CONNECTOR);

		proxyWSDLResourceEClass = createEClass(PROXY_WSDL_RESOURCE);

		proxyFaultInputConnectorEClass = createEClass(PROXY_FAULT_INPUT_CONNECTOR);

		proxyServiceParameterEClass = createEClass(PROXY_SERVICE_PARAMETER);
		createEAttribute(proxyServiceParameterEClass, PROXY_SERVICE_PARAMETER__NAME);
		createEAttribute(proxyServiceParameterEClass, PROXY_SERVICE_PARAMETER__VALUE);

		proxyServicePolicyEClass = createEClass(PROXY_SERVICE_POLICY);
		createEReference(proxyServicePolicyEClass, PROXY_SERVICE_POLICY__POLICY_KEY);

		proxyServiceSequenceAndEndpointContainerEClass = createEClass(PROXY_SERVICE_SEQUENCE_AND_ENDPOINT_CONTAINER);
		createEReference(proxyServiceSequenceAndEndpointContainerEClass, PROXY_SERVICE_SEQUENCE_AND_ENDPOINT_CONTAINER__MEDIATOR_FLOW);

		proxyServiceFaultContainerEClass = createEClass(PROXY_SERVICE_FAULT_CONTAINER);
		createEReference(proxyServiceFaultContainerEClass, PROXY_SERVICE_FAULT_CONTAINER__MEDIATOR_FLOW);

		proxyServiceContainerEClass = createEClass(PROXY_SERVICE_CONTAINER);
		createEReference(proxyServiceContainerEClass, PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER);
		createEReference(proxyServiceContainerEClass, PROXY_SERVICE_CONTAINER__FAULT_CONTAINER);

		mediatorFlowEClass = createEClass(MEDIATOR_FLOW);
		createEReference(mediatorFlowEClass, MEDIATOR_FLOW__CHILDREN);

		endpointFlowEClass = createEClass(ENDPOINT_FLOW);
		createEReference(endpointFlowEClass, ENDPOINT_FLOW__CHILDREN);

		abstractEndPointEClass = createEClass(ABSTRACT_END_POINT);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SECURITY_ENABLED);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__ADDRESSING_ENABLED);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__ADDRESSING_VERSION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__TIME_OUT_DURATION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__TIME_OUT_ACTION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__RETRY_ERROR_CODES);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__RETRY_COUNT);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__RETRY_DELAY);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SUSPEND_ERROR_CODES);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR);
		createEReference(abstractEndPointEClass, ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY);
		createEReference(abstractEndPointEClass, ABSTRACT_END_POINT__SECURITY_POLICY);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__FORMAT);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__OPTIMIZE);
		createEReference(abstractEndPointEClass, ABSTRACT_END_POINT__TEMPLATE_PARAMETERS);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__STATISTICS_ENABLED);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__TRACE_ENABLED);
		createEReference(abstractEndPointEClass, ABSTRACT_END_POINT__INBOUND_POLICY);
		createEReference(abstractEndPointEClass, ABSTRACT_END_POINT__OUTBOUND_POLICY);

		messageMediatorEClass = createEClass(MESSAGE_MEDIATOR);
		createEReference(messageMediatorEClass, MESSAGE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(messageMediatorEClass, MESSAGE_MEDIATOR__OUTPUT_CONNECTOR);

		messageInputConnectorEClass = createEClass(MESSAGE_INPUT_CONNECTOR);

		messageOutputConnectorEClass = createEClass(MESSAGE_OUTPUT_CONNECTOR);

		defaultEndPointEClass = createEClass(DEFAULT_END_POINT);
		createEReference(defaultEndPointEClass, DEFAULT_END_POINT__INPUT_CONNECTOR);
		createEReference(defaultEndPointEClass, DEFAULT_END_POINT__OUTPUT_CONNECTOR);

		defaultEndPointInputConnectorEClass = createEClass(DEFAULT_END_POINT_INPUT_CONNECTOR);

		defaultEndPointOutputConnectorEClass = createEClass(DEFAULT_END_POINT_OUTPUT_CONNECTOR);

		addressEndPointEClass = createEClass(ADDRESS_END_POINT);
		createEReference(addressEndPointEClass, ADDRESS_END_POINT__INPUT_CONNECTOR);
		createEReference(addressEndPointEClass, ADDRESS_END_POINT__OUTPUT_CONNECTOR);
		createEAttribute(addressEndPointEClass, ADDRESS_END_POINT__URI);

		addressEndPointInputConnectorEClass = createEClass(ADDRESS_END_POINT_INPUT_CONNECTOR);

		addressEndPointOutputConnectorEClass = createEClass(ADDRESS_END_POINT_OUTPUT_CONNECTOR);

		templateEndpointEClass = createEClass(TEMPLATE_ENDPOINT);
		createEReference(templateEndpointEClass, TEMPLATE_ENDPOINT__INPUT_CONNECTOR);
		createEReference(templateEndpointEClass, TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR);
		createEAttribute(templateEndpointEClass, TEMPLATE_ENDPOINT__ADDRESS);
		createEAttribute(templateEndpointEClass, TEMPLATE_ENDPOINT__TARGET_TEMPLATE);
		createEReference(templateEndpointEClass, TEMPLATE_ENDPOINT__PARAMETERS);
		createEAttribute(templateEndpointEClass, TEMPLATE_ENDPOINT__AVAILABLE_TEMPLATES);

		templateEndpointInputConnectorEClass = createEClass(TEMPLATE_ENDPOINT_INPUT_CONNECTOR);

		templateEndpointOutputConnectorEClass = createEClass(TEMPLATE_ENDPOINT_OUTPUT_CONNECTOR);

		templateEndpointParameterEClass = createEClass(TEMPLATE_ENDPOINT_PARAMETER);
		createEAttribute(templateEndpointParameterEClass, TEMPLATE_ENDPOINT_PARAMETER__PARAMETER_NAME);
		createEAttribute(templateEndpointParameterEClass, TEMPLATE_ENDPOINT_PARAMETER__PARAMETER_VALUE);

		httpEndpointEClass = createEClass(HTTP_ENDPOINT);
		createEReference(httpEndpointEClass, HTTP_ENDPOINT__INPUT_CONNECTOR);
		createEReference(httpEndpointEClass, HTTP_ENDPOINT__OUTPUT_CONNECTOR);
		createEAttribute(httpEndpointEClass, HTTP_ENDPOINT__URI_TEMPLATE);
		createEAttribute(httpEndpointEClass, HTTP_ENDPOINT__HTTP_METHOD);

		httpEndPointInputConnectorEClass = createEClass(HTTP_END_POINT_INPUT_CONNECTOR);

		httpEndPointOutputConnectorEClass = createEClass(HTTP_END_POINT_OUTPUT_CONNECTOR);

		dropMediatorEClass = createEClass(DROP_MEDIATOR);
		createEReference(dropMediatorEClass, DROP_MEDIATOR__INPUT_CONNECTOR);

		dropMediatorInputConnectorEClass = createEClass(DROP_MEDIATOR_INPUT_CONNECTOR);

		filterMediatorEClass = createEClass(FILTER_MEDIATOR);
		createEAttribute(filterMediatorEClass, FILTER_MEDIATOR__CONDITION_TYPE);
		createEAttribute(filterMediatorEClass, FILTER_MEDIATOR__REGEX);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__INPUT_CONNECTOR);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__XPATH);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__SOURCE);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__FILTER_CONTAINER);

		filterContainerEClass = createEClass(FILTER_CONTAINER);
		createEReference(filterContainerEClass, FILTER_CONTAINER__PASS_CONTAINER);
		createEReference(filterContainerEClass, FILTER_CONTAINER__FAIL_CONTAINER);

		filterPassContainerEClass = createEClass(FILTER_PASS_CONTAINER);
		createEReference(filterPassContainerEClass, FILTER_PASS_CONTAINER__MEDIATOR_FLOW);

		filterFailContainerEClass = createEClass(FILTER_FAIL_CONTAINER);
		createEReference(filterFailContainerEClass, FILTER_FAIL_CONTAINER__MEDIATOR_FLOW);

		filterMediatorInputConnectorEClass = createEClass(FILTER_MEDIATOR_INPUT_CONNECTOR);

		filterMediatorOutputConnectorEClass = createEClass(FILTER_MEDIATOR_OUTPUT_CONNECTOR);

		filterMediatorPassOutputConnectorEClass = createEClass(FILTER_MEDIATOR_PASS_OUTPUT_CONNECTOR);

		filterMediatorFailOutputConnectorEClass = createEClass(FILTER_MEDIATOR_FAIL_OUTPUT_CONNECTOR);

		mergeNodeEClass = createEClass(MERGE_NODE);
		createEReference(mergeNodeEClass, MERGE_NODE__FIRST_INPUT_CONNECTOR);
		createEReference(mergeNodeEClass, MERGE_NODE__SECOND_INPUT_CONNECTOR);
		createEReference(mergeNodeEClass, MERGE_NODE__OUTPUT_CONNECTOR);

		mergeNodeFirstInputConnectorEClass = createEClass(MERGE_NODE_FIRST_INPUT_CONNECTOR);

		mergeNodeSecondInputConnectorEClass = createEClass(MERGE_NODE_SECOND_INPUT_CONNECTOR);

		mergeNodeOutputConnectorEClass = createEClass(MERGE_NODE_OUTPUT_CONNECTOR);

		logMediatorEClass = createEClass(LOG_MEDIATOR);
		createEAttribute(logMediatorEClass, LOG_MEDIATOR__LOG_CATEGORY);
		createEAttribute(logMediatorEClass, LOG_MEDIATOR__LOG_LEVEL);
		createEAttribute(logMediatorEClass, LOG_MEDIATOR__LOG_SEPARATOR);
		createEReference(logMediatorEClass, LOG_MEDIATOR__INPUT_CONNECTOR);
		createEReference(logMediatorEClass, LOG_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(logMediatorEClass, LOG_MEDIATOR__PROPERTIES);

		logMediatorInputConnectorEClass = createEClass(LOG_MEDIATOR_INPUT_CONNECTOR);

		logMediatorOutputConnectorEClass = createEClass(LOG_MEDIATOR_OUTPUT_CONNECTOR);

		logPropertyEClass = createEClass(LOG_PROPERTY);

		publishEventMediatorEClass = createEClass(PUBLISH_EVENT_MEDIATOR);
		createEReference(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__OUTPUTCONNECTOR);
		createEAttribute(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__STREAM_NAME);
		createEAttribute(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__STREAM_VERSION);
		createEAttribute(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__EVENT_SINK);
		createEReference(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES);
		createEReference(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES);
		createEReference(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES);
		createEReference(publishEventMediatorEClass, PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES);

		publishEventMediatorInputConnectorEClass = createEClass(PUBLISH_EVENT_MEDIATOR_INPUT_CONNECTOR);

		publishEventMediatorOutputConnectorEClass = createEClass(PUBLISH_EVENT_MEDIATOR_OUTPUT_CONNECTOR);

		publishEventMediatorAttributeEClass = createEClass(PUBLISH_EVENT_MEDIATOR_ATTRIBUTE);
		createEAttribute(publishEventMediatorAttributeEClass, PUBLISH_EVENT_MEDIATOR_ATTRIBUTE__DEFAULT_VALUE);

		abstractNameValueExpressionAttributeEClass = createEClass(ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE);
		createEAttribute(abstractNameValueExpressionAttributeEClass, ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_NAME);
		createEAttribute(abstractNameValueExpressionAttributeEClass, ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE_TYPE);
		createEAttribute(abstractNameValueExpressionAttributeEClass, ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE);
		createEAttribute(abstractNameValueExpressionAttributeEClass, ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE);
		createEReference(abstractNameValueExpressionAttributeEClass, ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION);

		bamMediatorEClass = createEClass(BAM_MEDIATOR);
		createEReference(bamMediatorEClass, BAM_MEDIATOR__INPUT_CONNECTOR);
		createEReference(bamMediatorEClass, BAM_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(bamMediatorEClass, BAM_MEDIATOR__SERVER_PROFILE);
		createEAttribute(bamMediatorEClass, BAM_MEDIATOR__STREAM_NAME);
		createEAttribute(bamMediatorEClass, BAM_MEDIATOR__STREAM_VERSION);

		bamMediatorInputConnectorEClass = createEClass(BAM_MEDIATOR_INPUT_CONNECTOR);

		bamMediatorOutputConnectorEClass = createEClass(BAM_MEDIATOR_OUTPUT_CONNECTOR);

		beanMediatorEClass = createEClass(BEAN_MEDIATOR);
		createEReference(beanMediatorEClass, BEAN_MEDIATOR__INPUT_CONNECTOR);
		createEReference(beanMediatorEClass, BEAN_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(beanMediatorEClass, BEAN_MEDIATOR__CLASS);
		createEAttribute(beanMediatorEClass, BEAN_MEDIATOR__ACTION);
		createEAttribute(beanMediatorEClass, BEAN_MEDIATOR__VAR);
		createEAttribute(beanMediatorEClass, BEAN_MEDIATOR__PROPERTY);
		createEAttribute(beanMediatorEClass, BEAN_MEDIATOR__VALUE_TYPE);
		createEAttribute(beanMediatorEClass, BEAN_MEDIATOR__VALUE_LITERAL);
		createEReference(beanMediatorEClass, BEAN_MEDIATOR__VALUE_EXPRESSION);
		createEAttribute(beanMediatorEClass, BEAN_MEDIATOR__TARGET_TYPE);
		createEAttribute(beanMediatorEClass, BEAN_MEDIATOR__TARGET_LITERAL);
		createEReference(beanMediatorEClass, BEAN_MEDIATOR__TARGET_EXPRESSION);

		beanMediatorInputConnectorEClass = createEClass(BEAN_MEDIATOR_INPUT_CONNECTOR);

		beanMediatorOutputConnectorEClass = createEClass(BEAN_MEDIATOR_OUTPUT_CONNECTOR);

		ejbMediatorEClass = createEClass(EJB_MEDIATOR);
		createEReference(ejbMediatorEClass, EJB_MEDIATOR__INPUT_CONNECTOR);
		createEReference(ejbMediatorEClass, EJB_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(ejbMediatorEClass, EJB_MEDIATOR__BEANSTALK);
		createEAttribute(ejbMediatorEClass, EJB_MEDIATOR__CLASS);
		createEAttribute(ejbMediatorEClass, EJB_MEDIATOR__METHOD);
		createEAttribute(ejbMediatorEClass, EJB_MEDIATOR__SESSION_ID_TYPE);
		createEAttribute(ejbMediatorEClass, EJB_MEDIATOR__SESSION_ID_LITERAL);
		createEReference(ejbMediatorEClass, EJB_MEDIATOR__SESSION_ID_EXPRESSION);
		createEAttribute(ejbMediatorEClass, EJB_MEDIATOR__REMOVE);
		createEAttribute(ejbMediatorEClass, EJB_MEDIATOR__TARGET);
		createEAttribute(ejbMediatorEClass, EJB_MEDIATOR__JNDI_NAME);
		createEReference(ejbMediatorEClass, EJB_MEDIATOR__METHOD_ARGUMENTS);

		ejbMediatorInputConnectorEClass = createEClass(EJB_MEDIATOR_INPUT_CONNECTOR);

		ejbMediatorOutputConnectorEClass = createEClass(EJB_MEDIATOR_OUTPUT_CONNECTOR);

		methodArgumentEClass = createEClass(METHOD_ARGUMENT);

		registryKeyPropertyEClass = createEClass(REGISTRY_KEY_PROPERTY);
		createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__PRETTY_NAME);
		createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__KEY_NAME);
		createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__KEY_VALUE);
		createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__FILTERS);

		propertyMediatorEClass = createEClass(PROPERTY_MEDIATOR);
		createEReference(propertyMediatorEClass, PROPERTY_MEDIATOR__INPUT_CONNECTOR);
		createEReference(propertyMediatorEClass, PROPERTY_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__PROPERTY_NAME);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__PROPERTY_ACTION);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__PROPERTY_SCOPE);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_TYPE);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__EXPRESSION);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__NAMESPACE_PREFIX);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__NAMESPACE);
		createEReference(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_EXPRESSION);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__BOOLEAN);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__OM);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_STRING_PATTERN);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__NEW_PROPERTY_NAME);

		propertyMediatorInputConnectorEClass = createEClass(PROPERTY_MEDIATOR_INPUT_CONNECTOR);

		propertyMediatorOutputConnectorEClass = createEClass(PROPERTY_MEDIATOR_OUTPUT_CONNECTOR);

		namespacedPropertyEClass = createEClass(NAMESPACED_PROPERTY);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__PRETTY_NAME);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__PROPERTY_NAME);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__PROPERTY_VALUE);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__NAMESPACES);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__SUPPORTS_DYNAMIC_XPATHS);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__DYNAMIC);

		enrichMediatorEClass = createEClass(ENRICH_MEDIATOR);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__CLONE_SOURCE);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__SOURCE_TYPE);
		createEReference(enrichMediatorEClass, ENRICH_MEDIATOR__SOURCE_XPATH);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__SOURCE_PROPERTY);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__SOURCE_XML);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__TARGET_ACTION);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__TARGET_TYPE);
		createEReference(enrichMediatorEClass, ENRICH_MEDIATOR__TARGET_XPATH);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__TARGET_PROPERTY);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__INLINE_TYPE);
		createEReference(enrichMediatorEClass, ENRICH_MEDIATOR__INLINE_REGISTRY_KEY);
		createEReference(enrichMediatorEClass, ENRICH_MEDIATOR__INPUT_CONNECTOR);
		createEReference(enrichMediatorEClass, ENRICH_MEDIATOR__OUTPUT_CONNECTOR);

		enrichMediatorInputConnectorEClass = createEClass(ENRICH_MEDIATOR_INPUT_CONNECTOR);

		enrichMediatorOutputConnectorEClass = createEClass(ENRICH_MEDIATOR_OUTPUT_CONNECTOR);

		abstractNameValueExpressionPropertyEClass = createEClass(ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY);
		createEAttribute(abstractNameValueExpressionPropertyEClass, ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME);
		createEAttribute(abstractNameValueExpressionPropertyEClass, ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE);
		createEAttribute(abstractNameValueExpressionPropertyEClass, ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE);
		createEReference(abstractNameValueExpressionPropertyEClass, ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION);

		abstractBooleanFeatureEClass = createEClass(ABSTRACT_BOOLEAN_FEATURE);
		createEAttribute(abstractBooleanFeatureEClass, ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME);
		createEAttribute(abstractBooleanFeatureEClass, ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED);

		abstractLocationKeyResourceEClass = createEClass(ABSTRACT_LOCATION_KEY_RESOURCE);
		createEAttribute(abstractLocationKeyResourceEClass, ABSTRACT_LOCATION_KEY_RESOURCE__LOCATION);
		createEReference(abstractLocationKeyResourceEClass, ABSTRACT_LOCATION_KEY_RESOURCE__KEY);

		xsltMediatorEClass = createEClass(XSLT_MEDIATOR);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(xsltMediatorEClass, XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__XSLT_KEY);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__SOURCE_XPATH);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__PROPERTIES);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__FEATURES);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__RESOURCES);

		xsltPropertyEClass = createEClass(XSLT_PROPERTY);

		xsltFeatureEClass = createEClass(XSLT_FEATURE);

		xsltResourceEClass = createEClass(XSLT_RESOURCE);

		xsltMediatorInputConnectorEClass = createEClass(XSLT_MEDIATOR_INPUT_CONNECTOR);

		xsltMediatorOutputConnectorEClass = createEClass(XSLT_MEDIATOR_OUTPUT_CONNECTOR);

		switchMediatorEClass = createEClass(SWITCH_MEDIATOR);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__SOURCE_XPATH);
		createEAttribute(switchMediatorEClass, SWITCH_MEDIATOR__SOURCE);
		createEAttribute(switchMediatorEClass, SWITCH_MEDIATOR__NAMESPACE);
		createEAttribute(switchMediatorEClass, SWITCH_MEDIATOR__NAMESPACE_PREFIX);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__CASE_BRANCHES);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__DEFAULT_BRANCH);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__INPUT_CONNECTOR);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__SWITCH_CONTAINER);

		switchCaseBranchOutputConnectorEClass = createEClass(SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR);
		createEAttribute(switchCaseBranchOutputConnectorEClass, SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR__CASE_REGEX);

		switchDefaultBranchOutputConnectorEClass = createEClass(SWITCH_DEFAULT_BRANCH_OUTPUT_CONNECTOR);

		switchMediatorInputConnectorEClass = createEClass(SWITCH_MEDIATOR_INPUT_CONNECTOR);

		switchMediatorOutputConnectorEClass = createEClass(SWITCH_MEDIATOR_OUTPUT_CONNECTOR);

		switchMediatorContainerEClass = createEClass(SWITCH_MEDIATOR_CONTAINER);
		createEReference(switchMediatorContainerEClass, SWITCH_MEDIATOR_CONTAINER__SWITCH_CASE_PARENT_CONTAINER);
		createEReference(switchMediatorContainerEClass, SWITCH_MEDIATOR_CONTAINER__SWITCH_DEFAULT_PARENT_CONTAINER);

		switchCaseParentContainerEClass = createEClass(SWITCH_CASE_PARENT_CONTAINER);
		createEReference(switchCaseParentContainerEClass, SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER);

		switchDefaultParentContainerEClass = createEClass(SWITCH_DEFAULT_PARENT_CONTAINER);
		createEReference(switchDefaultParentContainerEClass, SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER);

		switchCaseContainerEClass = createEClass(SWITCH_CASE_CONTAINER);
		createEReference(switchCaseContainerEClass, SWITCH_CASE_CONTAINER__MEDIATOR_FLOW);

		switchDefaultContainerEClass = createEClass(SWITCH_DEFAULT_CONTAINER);
		createEReference(switchDefaultContainerEClass, SWITCH_DEFAULT_CONTAINER__MEDIATOR_FLOW);

		sequenceDiagramEClass = createEClass(SEQUENCE_DIAGRAM);
		createEReference(sequenceDiagramEClass, SEQUENCE_DIAGRAM__SEQUENCE);

		esbSequenceEClass = createEClass(ESB_SEQUENCE);
		createEAttribute(esbSequenceEClass, ESB_SEQUENCE__NAME);
		createEReference(esbSequenceEClass, ESB_SEQUENCE__INPUT);
		createEReference(esbSequenceEClass, ESB_SEQUENCE__OUTPUT);
		createEReference(esbSequenceEClass, ESB_SEQUENCE__CHILD_MEDIATORS);

		esbSequenceInputEClass = createEClass(ESB_SEQUENCE_INPUT);
		createEReference(esbSequenceInputEClass, ESB_SEQUENCE_INPUT__CONNECTOR);

		esbSequenceOutputEClass = createEClass(ESB_SEQUENCE_OUTPUT);
		createEReference(esbSequenceOutputEClass, ESB_SEQUENCE_OUTPUT__CONNECTOR);

		esbSequenceInputConnectorEClass = createEClass(ESB_SEQUENCE_INPUT_CONNECTOR);

		esbSequenceOutputConnectorEClass = createEClass(ESB_SEQUENCE_OUTPUT_CONNECTOR);

		sequenceEClass = createEClass(SEQUENCE);
		createEAttribute(sequenceEClass, SEQUENCE__NAME);
		createEAttribute(sequenceEClass, SEQUENCE__KEY);
		createEReference(sequenceEClass, SEQUENCE__INPUT_CONNECTOR);
		createEReference(sequenceEClass, SEQUENCE__OUTPUT_CONNECTOR);
		createEReference(sequenceEClass, SEQUENCE__INCLUDED_MEDIATORS);
		createEAttribute(sequenceEClass, SEQUENCE__RECEIVE_SEQUENCE);
		createEAttribute(sequenceEClass, SEQUENCE__DUPLICATE);
		createEAttribute(sequenceEClass, SEQUENCE__REFERRING_SEQUENCE_TYPE);
		createEReference(sequenceEClass, SEQUENCE__DYNAMIC_REFERENCE_KEY);
		createEReference(sequenceEClass, SEQUENCE__STATIC_REFERENCE_KEY);

		sequenceInputConnectorEClass = createEClass(SEQUENCE_INPUT_CONNECTOR);

		sequenceOutputConnectorEClass = createEClass(SEQUENCE_OUTPUT_CONNECTOR);

		eventMediatorEClass = createEClass(EVENT_MEDIATOR);
		createEAttribute(eventMediatorEClass, EVENT_MEDIATOR__TOPIC_TYPE);
		createEAttribute(eventMediatorEClass, EVENT_MEDIATOR__STATIC_TOPIC);
		createEReference(eventMediatorEClass, EVENT_MEDIATOR__DYNAMIC_TOPIC);
		createEReference(eventMediatorEClass, EVENT_MEDIATOR__EVENT_EXPRESSION);
		createEReference(eventMediatorEClass, EVENT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(eventMediatorEClass, EVENT_MEDIATOR__OUTPUT_CONNECTOR);

		eventMediatorInputConnectorEClass = createEClass(EVENT_MEDIATOR_INPUT_CONNECTOR);

		eventMediatorOutputConnectorEClass = createEClass(EVENT_MEDIATOR_OUTPUT_CONNECTOR);

		abstractNameValuePropertyEClass = createEClass(ABSTRACT_NAME_VALUE_PROPERTY);
		createEAttribute(abstractNameValuePropertyEClass, ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_NAME);
		createEAttribute(abstractNameValuePropertyEClass, ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_VALUE);

		entitlementMediatorEClass = createEClass(ENTITLEMENT_MEDIATOR);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__USERNAME);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__PASSWORD);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__THRIFT_HOST);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__THRIFT_PORT);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER);

		entitlementMediatorInputConnectorEClass = createEClass(ENTITLEMENT_MEDIATOR_INPUT_CONNECTOR);

		entitlementMediatorOutputConnectorEClass = createEClass(ENTITLEMENT_MEDIATOR_OUTPUT_CONNECTOR);

		entitlementMediatorOnRejectOutputConnectorEClass = createEClass(ENTITLEMENT_MEDIATOR_ON_REJECT_OUTPUT_CONNECTOR);

		entitlementMediatorOnAcceptOutputConnectorEClass = createEClass(ENTITLEMENT_MEDIATOR_ON_ACCEPT_OUTPUT_CONNECTOR);

		entitlementMediatorAdviceOutputConnectorEClass = createEClass(ENTITLEMENT_MEDIATOR_ADVICE_OUTPUT_CONNECTOR);

		entitlementMediatorObligationsOutputConnectorEClass = createEClass(ENTITLEMENT_MEDIATOR_OBLIGATIONS_OUTPUT_CONNECTOR);

		entitlementContainerEClass = createEClass(ENTITLEMENT_CONTAINER);
		createEReference(entitlementContainerEClass, ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER);
		createEReference(entitlementContainerEClass, ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER);
		createEReference(entitlementContainerEClass, ENTITLEMENT_CONTAINER__ADVICE_CONTAINER);
		createEReference(entitlementContainerEClass, ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER);

		entitlementOnRejectContainerEClass = createEClass(ENTITLEMENT_ON_REJECT_CONTAINER);
		createEReference(entitlementOnRejectContainerEClass, ENTITLEMENT_ON_REJECT_CONTAINER__MEDIATOR_FLOW);

		entitlementOnAcceptContainerEClass = createEClass(ENTITLEMENT_ON_ACCEPT_CONTAINER);
		createEReference(entitlementOnAcceptContainerEClass, ENTITLEMENT_ON_ACCEPT_CONTAINER__MEDIATOR_FLOW);

		entitlementAdviceContainerEClass = createEClass(ENTITLEMENT_ADVICE_CONTAINER);
		createEReference(entitlementAdviceContainerEClass, ENTITLEMENT_ADVICE_CONTAINER__MEDIATOR_FLOW);

		entitlementObligationsContainerEClass = createEClass(ENTITLEMENT_OBLIGATIONS_CONTAINER);
		createEReference(entitlementObligationsContainerEClass, ENTITLEMENT_OBLIGATIONS_CONTAINER__MEDIATOR_FLOW);

		enqueueMediatorEClass = createEClass(ENQUEUE_MEDIATOR);
		createEAttribute(enqueueMediatorEClass, ENQUEUE_MEDIATOR__EXECUTOR);
		createEAttribute(enqueueMediatorEClass, ENQUEUE_MEDIATOR__PRIORITY);
		createEReference(enqueueMediatorEClass, ENQUEUE_MEDIATOR__SEQUENCE_KEY);
		createEReference(enqueueMediatorEClass, ENQUEUE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(enqueueMediatorEClass, ENQUEUE_MEDIATOR__OUTPUT_CONNECTOR);

		enqueueMediatorInputConnectorEClass = createEClass(ENQUEUE_MEDIATOR_INPUT_CONNECTOR);

		enqueueMediatorOutputConnectorEClass = createEClass(ENQUEUE_MEDIATOR_OUTPUT_CONNECTOR);

		classMediatorEClass = createEClass(CLASS_MEDIATOR);
		createEAttribute(classMediatorEClass, CLASS_MEDIATOR__CLASS_NAME);
		createEReference(classMediatorEClass, CLASS_MEDIATOR__PROPERTIES);
		createEReference(classMediatorEClass, CLASS_MEDIATOR__INPUT_CONNECTOR);
		createEReference(classMediatorEClass, CLASS_MEDIATOR__OUTPUT_CONNECTOR);

		classMediatorInputConnectorEClass = createEClass(CLASS_MEDIATOR_INPUT_CONNECTOR);

		classMediatorOutputConnectorEClass = createEClass(CLASS_MEDIATOR_OUTPUT_CONNECTOR);

		classPropertyEClass = createEClass(CLASS_PROPERTY);

		springMediatorEClass = createEClass(SPRING_MEDIATOR);
		createEAttribute(springMediatorEClass, SPRING_MEDIATOR__BEAN_NAME);
		createEReference(springMediatorEClass, SPRING_MEDIATOR__CONFIGURATION_KEY);
		createEReference(springMediatorEClass, SPRING_MEDIATOR__INPUT_CONNECTOR);
		createEReference(springMediatorEClass, SPRING_MEDIATOR__OUTPUT_CONNECTOR);

		springMediatorInputConnectorEClass = createEClass(SPRING_MEDIATOR_INPUT_CONNECTOR);

		springMediatorOutputConnectorEClass = createEClass(SPRING_MEDIATOR_OUTPUT_CONNECTOR);

		scriptMediatorEClass = createEClass(SCRIPT_MEDIATOR);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_TYPE);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_LANGUAGE);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__MEDIATE_FUNCTION);
		createEReference(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_BODY);
		createEReference(scriptMediatorEClass, SCRIPT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(scriptMediatorEClass, SCRIPT_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__KEY_TYPE);
		createEReference(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY);
		createEReference(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_KEYS);

		scriptMediatorInputConnectorEClass = createEClass(SCRIPT_MEDIATOR_INPUT_CONNECTOR);

		scriptMediatorOutputConnectorEClass = createEClass(SCRIPT_MEDIATOR_OUTPUT_CONNECTOR);

		faultMediatorEClass = createEClass(FAULT_MEDIATOR);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__SOAP_VERSION);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__SERIALIZE_RESPONSE);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__MARK_AS_RESPONSE);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_CODE_SOAP11);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_CODE_TYPE);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__FAULT_CODE_EXPRESSION);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_STRING_TYPE);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_STRING_VALUE);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__FAULT_STRING_EXPRESSION);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_ACTOR);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_CODE_SOAP12);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_REASON_TYPE);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_REASON_VALUE);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__FAULT_REASON_EXPRESSION);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__ROLE_NAME);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__NODE_NAME);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_DETAIL_TYPE);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_DETAIL_VALUE);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__OUTPUT_CONNECTOR);

		faultMediatorInputConnectorEClass = createEClass(FAULT_MEDIATOR_INPUT_CONNECTOR);

		faultMediatorOutputConnectorEClass = createEClass(FAULT_MEDIATOR_OUTPUT_CONNECTOR);

		aggregateMediatorEClass = createEClass(AGGREGATE_MEDIATOR);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__AGGREGATE_ID);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_TYPE);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_TYPE);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_VALUE);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_VALUE);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_EXPRESSION);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__ON_COMPLETE_OUTPUT_CONNECTOR);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__MEDIATOR_FLOW);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__SEQUENCE_TYPE);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__SEQUENCE_KEY);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__ENCLOSING_ELEMENT_PROPERTY);

		aggregateMediatorInputConnectorEClass = createEClass(AGGREGATE_MEDIATOR_INPUT_CONNECTOR);

		aggregateMediatorOutputConnectorEClass = createEClass(AGGREGATE_MEDIATOR_OUTPUT_CONNECTOR);

		aggregateMediatorOnCompleteOutputConnectorEClass = createEClass(AGGREGATE_MEDIATOR_ON_COMPLETE_OUTPUT_CONNECTOR);

		routerMediatorEClass = createEClass(ROUTER_MEDIATOR);
		createEAttribute(routerMediatorEClass, ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING);
		createEReference(routerMediatorEClass, ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR);
		createEReference(routerMediatorEClass, ROUTER_MEDIATOR__INPUT_CONNECTOR);
		createEReference(routerMediatorEClass, ROUTER_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(routerMediatorEClass, ROUTER_MEDIATOR__ROUTER_CONTAINER);

		routerRouteEClass = createEClass(ROUTER_ROUTE);
		createEAttribute(routerRouteEClass, ROUTER_ROUTE__BREAK_AFTER_ROUTE);
		createEReference(routerRouteEClass, ROUTER_ROUTE__ROUTE_EXPRESSION);
		createEAttribute(routerRouteEClass, ROUTER_ROUTE__ROUTE_PATTERN);

		routerTargetEClass = createEClass(ROUTER_TARGET);

		routerMediatorInputConnectorEClass = createEClass(ROUTER_MEDIATOR_INPUT_CONNECTOR);

		routerMediatorOutputConnectorEClass = createEClass(ROUTER_MEDIATOR_OUTPUT_CONNECTOR);

		routerMediatorTargetOutputConnectorEClass = createEClass(ROUTER_MEDIATOR_TARGET_OUTPUT_CONNECTOR);
		createEAttribute(routerMediatorTargetOutputConnectorEClass, ROUTER_MEDIATOR_TARGET_OUTPUT_CONNECTOR__SOAP_ACTION);
		createEAttribute(routerMediatorTargetOutputConnectorEClass, ROUTER_MEDIATOR_TARGET_OUTPUT_CONNECTOR__TO_ADDRESS);

		routerMediatorContainerEClass = createEClass(ROUTER_MEDIATOR_CONTAINER);
		createEReference(routerMediatorContainerEClass, ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER);

		routerTargetContainerEClass = createEClass(ROUTER_TARGET_CONTAINER);
		createEReference(routerTargetContainerEClass, ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW);
		createEAttribute(routerTargetContainerEClass, ROUTER_TARGET_CONTAINER__BREAK_AFTER_ROUTE);
		createEReference(routerTargetContainerEClass, ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION);
		createEAttribute(routerTargetContainerEClass, ROUTER_TARGET_CONTAINER__ROUTE_PATTERN);
		createEReference(routerTargetContainerEClass, ROUTER_TARGET_CONTAINER__TARGET);

		cloneMediatorEClass = createEClass(CLONE_MEDIATOR);
		createEAttribute(cloneMediatorEClass, CLONE_MEDIATOR__CLONE_ID);
		createEAttribute(cloneMediatorEClass, CLONE_MEDIATOR__SEQUENTIAL_MEDIATION);
		createEAttribute(cloneMediatorEClass, CLONE_MEDIATOR__CONTINUE_PARENT);
		createEReference(cloneMediatorEClass, CLONE_MEDIATOR__TARGETS);
		createEReference(cloneMediatorEClass, CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR);
		createEReference(cloneMediatorEClass, CLONE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(cloneMediatorEClass, CLONE_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(cloneMediatorEClass, CLONE_MEDIATOR__CLONE_CONTAINER);

		cloneTargetEClass = createEClass(CLONE_TARGET);
		createEAttribute(cloneTargetEClass, CLONE_TARGET__SOAP_ACTION);
		createEAttribute(cloneTargetEClass, CLONE_TARGET__TO_ADDRESS);

		cloneMediatorInputConnectorEClass = createEClass(CLONE_MEDIATOR_INPUT_CONNECTOR);

		cloneMediatorOutputConnectorEClass = createEClass(CLONE_MEDIATOR_OUTPUT_CONNECTOR);

		cloneMediatorTargetOutputConnectorEClass = createEClass(CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR);
		createEAttribute(cloneMediatorTargetOutputConnectorEClass, CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__SOAP_ACTION);
		createEAttribute(cloneMediatorTargetOutputConnectorEClass, CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__TO_ADDRESS);

		cloneMediatorContainerEClass = createEClass(CLONE_MEDIATOR_CONTAINER);
		createEReference(cloneMediatorContainerEClass, CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER);

		cloneTargetContainerEClass = createEClass(CLONE_TARGET_CONTAINER);
		createEReference(cloneTargetContainerEClass, CLONE_TARGET_CONTAINER__MEDIATOR_FLOW);

		forEachMediatorEClass = createEClass(FOR_EACH_MEDIATOR);
		createEAttribute(forEachMediatorEClass, FOR_EACH_MEDIATOR__FOR_EACH_ID);
		createEReference(forEachMediatorEClass, FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION);
		createEReference(forEachMediatorEClass, FOR_EACH_MEDIATOR__ATTACH_PATH);
		createEReference(forEachMediatorEClass, FOR_EACH_MEDIATOR__TARGET);
		createEReference(forEachMediatorEClass, FOR_EACH_MEDIATOR__INPUT_CONNECTOR);
		createEReference(forEachMediatorEClass, FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(forEachMediatorEClass, FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR);
		createEReference(forEachMediatorEClass, FOR_EACH_MEDIATOR__MEDIATOR_FLOW);
		createEAttribute(forEachMediatorEClass, FOR_EACH_MEDIATOR__SEQUENCE_TYPE);
		createEReference(forEachMediatorEClass, FOR_EACH_MEDIATOR__SEQUENCE_KEY);
		createEAttribute(forEachMediatorEClass, FOR_EACH_MEDIATOR__SEQUENCE_NAME);

		forEachMediatorInputConnectorEClass = createEClass(FOR_EACH_MEDIATOR_INPUT_CONNECTOR);

		forEachMediatorOutputConnectorEClass = createEClass(FOR_EACH_MEDIATOR_OUTPUT_CONNECTOR);

		forEachMediatorTargetOutputConnectorEClass = createEClass(FOR_EACH_MEDIATOR_TARGET_OUTPUT_CONNECTOR);

		forEachTargetEClass = createEClass(FOR_EACH_TARGET);
		createEAttribute(forEachTargetEClass, FOR_EACH_TARGET__SOAP_ACTION);
		createEAttribute(forEachTargetEClass, FOR_EACH_TARGET__TO_ADDRESS);

		iterateMediatorEClass = createEClass(ITERATE_MEDIATOR);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__ITERATE_ID);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__CONTINUE_PARENT);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__PRESERVE_PAYLOAD);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__ITERATE_EXPRESSION);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__ATTACH_PATH);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__TARGET);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__MEDIATOR_FLOW);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__SEQUENCE_TYPE);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__SEQUENCE_KEY);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__SEQUENCE_NAME);

		iterateMediatorInputConnectorEClass = createEClass(ITERATE_MEDIATOR_INPUT_CONNECTOR);

		iterateMediatorOutputConnectorEClass = createEClass(ITERATE_MEDIATOR_OUTPUT_CONNECTOR);

		iterateMediatorTargetOutputConnectorEClass = createEClass(ITERATE_MEDIATOR_TARGET_OUTPUT_CONNECTOR);

		iterateTargetEClass = createEClass(ITERATE_TARGET);
		createEAttribute(iterateTargetEClass, ITERATE_TARGET__SOAP_ACTION);
		createEAttribute(iterateTargetEClass, ITERATE_TARGET__TO_ADDRESS);

		abstractCommonTargetEClass = createEClass(ABSTRACT_COMMON_TARGET);
		createEAttribute(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE);
		createEReference(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__SEQUENCE);
		createEReference(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__SEQUENCE_KEY);
		createEAttribute(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE);
		createEReference(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__ENDPOINT);
		createEReference(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__ENDPOINT_KEY);

		mediatorSequenceEClass = createEClass(MEDIATOR_SEQUENCE);
		createEAttribute(mediatorSequenceEClass, MEDIATOR_SEQUENCE__ANONYMOUS);
		createEAttribute(mediatorSequenceEClass, MEDIATOR_SEQUENCE__SEQUENCE_NAME);
		createEReference(mediatorSequenceEClass, MEDIATOR_SEQUENCE__MEDIATORS);
		createEReference(mediatorSequenceEClass, MEDIATOR_SEQUENCE__ON_ERROR);
		createEAttribute(mediatorSequenceEClass, MEDIATOR_SEQUENCE__DESCRIPTION);

		cacheMediatorEClass = createEClass(CACHE_MEDIATOR);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__CACHE_ID);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__CACHE_SCOPE);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__CACHE_ACTION);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__HASH_GENERATOR);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__CACHE_TIMEOUT);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__MAX_MESSAGE_SIZE);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__IMPLEMENTATION_TYPE);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__MAX_ENTRY_COUNT);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__SEQUENCE_TYPE);
		createEReference(cacheMediatorEClass, CACHE_MEDIATOR__SEQUENCE_KEY);
		createEReference(cacheMediatorEClass, CACHE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(cacheMediatorEClass, CACHE_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(cacheMediatorEClass, CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR);
		createEReference(cacheMediatorEClass, CACHE_MEDIATOR__MEDIATOR_FLOW);

		cacheMediatorInputConnectorEClass = createEClass(CACHE_MEDIATOR_INPUT_CONNECTOR);

		cacheMediatorOutputConnectorEClass = createEClass(CACHE_MEDIATOR_OUTPUT_CONNECTOR);

		cacheMediatorOnHitOutputConnectorEClass = createEClass(CACHE_MEDIATOR_ON_HIT_OUTPUT_CONNECTOR);

		cacheOnHitBranchEClass = createEClass(CACHE_ON_HIT_BRANCH);

		xQueryMediatorEClass = createEClass(XQUERY_MEDIATOR);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__VARIABLES);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__TARGET_XPATH);
		createEAttribute(xQueryMediatorEClass, XQUERY_MEDIATOR__SCRIPT_KEY_TYPE);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__STATIC_SCRIPT_KEY);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__QUERY_KEY);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__INPUT_CONNECTOR);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__OUTPUT_CONNECTOR);

		xQueryMediatorInputConnectorEClass = createEClass(XQUERY_MEDIATOR_INPUT_CONNECTOR);

		xQueryMediatorOutputConnectorEClass = createEClass(XQUERY_MEDIATOR_OUTPUT_CONNECTOR);

		xQueryVariableEClass = createEClass(XQUERY_VARIABLE);
		createEAttribute(xQueryVariableEClass, XQUERY_VARIABLE__VARIABLE_NAME);
		createEAttribute(xQueryVariableEClass, XQUERY_VARIABLE__VARIABLE_TYPE);
		createEAttribute(xQueryVariableEClass, XQUERY_VARIABLE__VALUE_TYPE);
		createEAttribute(xQueryVariableEClass, XQUERY_VARIABLE__VALUE_LITERAL);
		createEReference(xQueryVariableEClass, XQUERY_VARIABLE__VALUE_EXPRESSION);
		createEReference(xQueryVariableEClass, XQUERY_VARIABLE__VALUE_KEY);

		calloutMediatorEClass = createEClass(CALLOUT_MEDIATOR);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__SERVICE_URL);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__SOAP_ACTION);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PATH_TO_AXIS2XML);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PAYLOAD_TYPE);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__RESULT_TYPE);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PASS_HEADERS);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__ADDRESS_ENDPOINT);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__ENDPOINT_TYPE);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PAYLOAD_PROPERTY);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__SECURITY_TYPE);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__INBOUND_POLICY_KEY);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__POLICIES);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__POLICY_KEY);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS);

		calloutMediatorInputConnectorEClass = createEClass(CALLOUT_MEDIATOR_INPUT_CONNECTOR);

		calloutMediatorOutputConnectorEClass = createEClass(CALLOUT_MEDIATOR_OUTPUT_CONNECTOR);

		rmSequenceMediatorEClass = createEClass(RM_SEQUENCE_MEDIATOR);
		createEAttribute(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION);
		createEAttribute(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE);
		createEReference(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH);
		createEReference(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH);
		createEReference(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__OUTPUT_CONNECTOR);

		rmSequenceMediatorInputConnectorEClass = createEClass(RM_SEQUENCE_MEDIATOR_INPUT_CONNECTOR);

		rmSequenceMediatorOutputConnectorEClass = createEClass(RM_SEQUENCE_MEDIATOR_OUTPUT_CONNECTOR);

		transactionMediatorEClass = createEClass(TRANSACTION_MEDIATOR);
		createEAttribute(transactionMediatorEClass, TRANSACTION_MEDIATOR__ACTION);
		createEReference(transactionMediatorEClass, TRANSACTION_MEDIATOR__INPUT_CONNECTOR);
		createEReference(transactionMediatorEClass, TRANSACTION_MEDIATOR__OUTPUT_CONNECTOR);

		transactionMediatorInputConnectorEClass = createEClass(TRANSACTION_MEDIATOR_INPUT_CONNECTOR);

		transactionMediatorOutputConnectorEClass = createEClass(TRANSACTION_MEDIATOR_OUTPUT_CONNECTOR);

		oAuthMediatorEClass = createEClass(OAUTH_MEDIATOR);
		createEAttribute(oAuthMediatorEClass, OAUTH_MEDIATOR__REMOTE_SERVICE_URL);
		createEAttribute(oAuthMediatorEClass, OAUTH_MEDIATOR__USERNAME);
		createEAttribute(oAuthMediatorEClass, OAUTH_MEDIATOR__PASSWORD);
		createEReference(oAuthMediatorEClass, OAUTH_MEDIATOR__INPUT_CONNECTOR);
		createEReference(oAuthMediatorEClass, OAUTH_MEDIATOR__OUTPUT_CONNECTOR);

		oAuthMediatorInputConnectorEClass = createEClass(OAUTH_MEDIATOR_INPUT_CONNECTOR);

		oAuthMediatorOutputConnectorEClass = createEClass(OAUTH_MEDIATOR_OUTPUT_CONNECTOR);

		autoscaleInMediatorEClass = createEClass(AUTOSCALE_IN_MEDIATOR);

		autoscaleOutMediatorEClass = createEClass(AUTOSCALE_OUT_MEDIATOR);

		headerMediatorEClass = createEClass(HEADER_MEDIATOR);
		createEReference(headerMediatorEClass, HEADER_MEDIATOR__HEADER_NAME);
		createEAttribute(headerMediatorEClass, HEADER_MEDIATOR__HEADER_ACTION);
		createEAttribute(headerMediatorEClass, HEADER_MEDIATOR__VALUE_TYPE);
		createEAttribute(headerMediatorEClass, HEADER_MEDIATOR__SCOPE);
		createEAttribute(headerMediatorEClass, HEADER_MEDIATOR__VALUE_LITERAL);
		createEReference(headerMediatorEClass, HEADER_MEDIATOR__VALUE_EXPRESSION);
		createEReference(headerMediatorEClass, HEADER_MEDIATOR__INPUT_CONNECTOR);
		createEReference(headerMediatorEClass, HEADER_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(headerMediatorEClass, HEADER_MEDIATOR__VALUE_INLINE);

		headerMediatorInputConnectorEClass = createEClass(HEADER_MEDIATOR_INPUT_CONNECTOR);

		headerMediatorOutputConnectorEClass = createEClass(HEADER_MEDIATOR_OUTPUT_CONNECTOR);

		throttleMediatorEClass = createEClass(THROTTLE_MEDIATOR);
		createEAttribute(throttleMediatorEClass, THROTTLE_MEDIATOR__GROUP_ID);
		createEAttribute(throttleMediatorEClass, THROTTLE_MEDIATOR__POLICY_TYPE);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__POLICY_KEY);
		createEAttribute(throttleMediatorEClass, THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__POLICY_ENTRIES);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__POLICY_CONFIGURATION);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_REJECT_BRANCH);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__THROTTLE_CONTAINER);
		createEAttribute(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY);
		createEAttribute(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY);

		throttleMediatorInputConnectorEClass = createEClass(THROTTLE_MEDIATOR_INPUT_CONNECTOR);

		throttleMediatorOutputConnectorEClass = createEClass(THROTTLE_MEDIATOR_OUTPUT_CONNECTOR);

		throttleMediatorOnAcceptOutputConnectorEClass = createEClass(THROTTLE_MEDIATOR_ON_ACCEPT_OUTPUT_CONNECTOR);

		throttleMediatorOnRejectOutputConnectorEClass = createEClass(THROTTLE_MEDIATOR_ON_REJECT_OUTPUT_CONNECTOR);

		throttlePolicyConfigurationEClass = createEClass(THROTTLE_POLICY_CONFIGURATION);
		createEAttribute(throttlePolicyConfigurationEClass, THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE);
		createEReference(throttlePolicyConfigurationEClass, THROTTLE_POLICY_CONFIGURATION__POLICY_KEY);
		createEAttribute(throttlePolicyConfigurationEClass, THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT);
		createEReference(throttlePolicyConfigurationEClass, THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES);

		throttlePolicyEntryEClass = createEClass(THROTTLE_POLICY_ENTRY);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__THROTTLE_TYPE);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__THROTTLE_RANGE);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__ACCESS_TYPE);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__UNIT_TIME);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD);

		throttleOnAcceptBranchEClass = createEClass(THROTTLE_ON_ACCEPT_BRANCH);
		createEAttribute(throttleOnAcceptBranchEClass, THROTTLE_ON_ACCEPT_BRANCH__SEQUENCE_TYPE);
		createEReference(throttleOnAcceptBranchEClass, THROTTLE_ON_ACCEPT_BRANCH__SEQUENCE_KEY);

		throttleOnRejectBranchEClass = createEClass(THROTTLE_ON_REJECT_BRANCH);
		createEAttribute(throttleOnRejectBranchEClass, THROTTLE_ON_REJECT_BRANCH__SEQUENCE_TYPE);
		createEReference(throttleOnRejectBranchEClass, THROTTLE_ON_REJECT_BRANCH__SEQUENCE_KEY);

		throttleContainerEClass = createEClass(THROTTLE_CONTAINER);
		createEReference(throttleContainerEClass, THROTTLE_CONTAINER__ON_ACCEPT_CONTAINER);
		createEReference(throttleContainerEClass, THROTTLE_CONTAINER__ON_REJECT_CONTAINER);

		throttleOnAcceptContainerEClass = createEClass(THROTTLE_ON_ACCEPT_CONTAINER);
		createEReference(throttleOnAcceptContainerEClass, THROTTLE_ON_ACCEPT_CONTAINER__MEDIATOR_FLOW);

		throttleOnRejectContainerEClass = createEClass(THROTTLE_ON_REJECT_CONTAINER);
		createEReference(throttleOnRejectContainerEClass, THROTTLE_ON_REJECT_CONTAINER__MEDIATOR_FLOW);

		commandMediatorEClass = createEClass(COMMAND_MEDIATOR);
		createEAttribute(commandMediatorEClass, COMMAND_MEDIATOR__CLASS_NAME);
		createEReference(commandMediatorEClass, COMMAND_MEDIATOR__PROPERTIES);
		createEReference(commandMediatorEClass, COMMAND_MEDIATOR__INPUT_CONNECTOR);
		createEReference(commandMediatorEClass, COMMAND_MEDIATOR__OUTPUT_CONNECTOR);

		commandMediatorInputConnectorEClass = createEClass(COMMAND_MEDIATOR_INPUT_CONNECTOR);

		commandMediatorOutputConnectorEClass = createEClass(COMMAND_MEDIATOR_OUTPUT_CONNECTOR);

		commandPropertyEClass = createEClass(COMMAND_PROPERTY);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__PROPERTY_NAME);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__VALUE_TYPE);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__VALUE_LITERAL);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME);
		createEReference(commandPropertyEClass, COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__CONTEXT_ACTION);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__MESSAGE_ACTION);

		abstractSqlExecutorMediatorEClass = createEClass(ABSTRACT_SQL_EXECUTOR_MEDIATOR);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE);
		createEReference(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS);

		sqlStatementEClass = createEClass(SQL_STATEMENT);
		createEAttribute(sqlStatementEClass, SQL_STATEMENT__QUERY_STRING);
		createEReference(sqlStatementEClass, SQL_STATEMENT__PARAMETERS);
		createEAttribute(sqlStatementEClass, SQL_STATEMENT__RESULTS_ENABLED);
		createEReference(sqlStatementEClass, SQL_STATEMENT__RESULTS);

		sqlParameterDefinitionEClass = createEClass(SQL_PARAMETER_DEFINITION);
		createEAttribute(sqlParameterDefinitionEClass, SQL_PARAMETER_DEFINITION__DATA_TYPE);
		createEAttribute(sqlParameterDefinitionEClass, SQL_PARAMETER_DEFINITION__VALUE_TYPE);
		createEAttribute(sqlParameterDefinitionEClass, SQL_PARAMETER_DEFINITION__VALUE_LITERAL);
		createEReference(sqlParameterDefinitionEClass, SQL_PARAMETER_DEFINITION__VALUE_EXPRESSION);

		sqlResultMappingEClass = createEClass(SQL_RESULT_MAPPING);
		createEAttribute(sqlResultMappingEClass, SQL_RESULT_MAPPING__PROPERTY_NAME);
		createEAttribute(sqlResultMappingEClass, SQL_RESULT_MAPPING__COLUMN_ID);

		dbLookupMediatorEClass = createEClass(DB_LOOKUP_MEDIATOR);
		createEReference(dbLookupMediatorEClass, DB_LOOKUP_MEDIATOR__INPUT_CONNECTOR);
		createEReference(dbLookupMediatorEClass, DB_LOOKUP_MEDIATOR__OUTPUT_CONNECTOR);

		dbLookupMediatorInputConnectorEClass = createEClass(DB_LOOKUP_MEDIATOR_INPUT_CONNECTOR);

		dbLookupMediatorOutputConnectorEClass = createEClass(DB_LOOKUP_MEDIATOR_OUTPUT_CONNECTOR);

		dbReportMediatorEClass = createEClass(DB_REPORT_MEDIATOR);
		createEAttribute(dbReportMediatorEClass, DB_REPORT_MEDIATOR__CONNECTION_USE_TRANSACTION);
		createEReference(dbReportMediatorEClass, DB_REPORT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(dbReportMediatorEClass, DB_REPORT_MEDIATOR__OUTPUT_CONNECTOR);

		dbReportMediatorInputConnectorEClass = createEClass(DB_REPORT_MEDIATOR_INPUT_CONNECTOR);

		dbReportMediatorOutputConnectorEClass = createEClass(DB_REPORT_MEDIATOR_OUTPUT_CONNECTOR);

		ruleMediatorEClass = createEClass(RULE_MEDIATOR);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__RULE_SET_URL);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__RULE_SET_SOURCE_TYPE);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__RULE_SET_SOURCE_CODE);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__RULE_SET_SOURCE_KEY);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__STATEFUL_SESSION);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__RULE_SESSION_PROPERTIES);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__FACTS_CONFIGURATION);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__RESULTS_CONFIGURATION);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__CHILD_MEDIATORS_OUTPUT_CONNECTOR);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__MEDIATOR_FLOW);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__SOURCE_VALUE);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__SOURCE_XPATH);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__TARGET_VALUE);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__TARGET_RESULT_XPATH);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__TARGET_XPATH);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__TARGET_ACTION);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__INPUT_WRAPPER_NAME);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__INPUT_NAME_SPACE);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__OUTPUT_WRAPPER_NAME);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__OUTPUT_NAME_SPACE);
		createEAttribute(ruleMediatorEClass, RULE_MEDIATOR__RULE_SET_TYPE);

		ruleMediatorInputConnectorEClass = createEClass(RULE_MEDIATOR_INPUT_CONNECTOR);

		ruleMediatorOutputConnectorEClass = createEClass(RULE_MEDIATOR_OUTPUT_CONNECTOR);

		ruleMediatorChildMediatorsOutputConnectorEClass = createEClass(RULE_MEDIATOR_CHILD_MEDIATORS_OUTPUT_CONNECTOR);

		ruleSetCreationPropertyEClass = createEClass(RULE_SET_CREATION_PROPERTY);

		ruleSessionPropertyEClass = createEClass(RULE_SESSION_PROPERTY);

		ruleFactsConfigurationEClass = createEClass(RULE_FACTS_CONFIGURATION);
		createEReference(ruleFactsConfigurationEClass, RULE_FACTS_CONFIGURATION__FACTS);

		ruleFactEClass = createEClass(RULE_FACT);
		createEAttribute(ruleFactEClass, RULE_FACT__FACT_TYPE);
		createEAttribute(ruleFactEClass, RULE_FACT__FACT_CUSTOM_TYPE);
		createEAttribute(ruleFactEClass, RULE_FACT__FACT_NAME);
		createEAttribute(ruleFactEClass, RULE_FACT__VALUE_TYPE);
		createEAttribute(ruleFactEClass, RULE_FACT__VALUE_LITERAL);
		createEReference(ruleFactEClass, RULE_FACT__VALUE_EXPRESSION);
		createEReference(ruleFactEClass, RULE_FACT__VALUE_KEY);

		ruleResultsConfigurationEClass = createEClass(RULE_RESULTS_CONFIGURATION);
		createEReference(ruleResultsConfigurationEClass, RULE_RESULTS_CONFIGURATION__RESULTS);

		ruleResultEClass = createEClass(RULE_RESULT);
		createEAttribute(ruleResultEClass, RULE_RESULT__RESULT_TYPE);
		createEAttribute(ruleResultEClass, RULE_RESULT__RESULT_CUSTOM_TYPE);
		createEAttribute(ruleResultEClass, RULE_RESULT__RESULT_NAME);
		createEAttribute(ruleResultEClass, RULE_RESULT__VALUE_TYPE);
		createEAttribute(ruleResultEClass, RULE_RESULT__VALUE_LITERAL);
		createEReference(ruleResultEClass, RULE_RESULT__VALUE_EXPRESSION);
		createEReference(ruleResultEClass, RULE_RESULT__VALUE_KEY);

		ruleChildMediatorsConfigurationEClass = createEClass(RULE_CHILD_MEDIATORS_CONFIGURATION);

		callTemplateParameterEClass = createEClass(CALL_TEMPLATE_PARAMETER);
		createEAttribute(callTemplateParameterEClass, CALL_TEMPLATE_PARAMETER__PARAMETER_NAME);
		createEAttribute(callTemplateParameterEClass, CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE);
		createEAttribute(callTemplateParameterEClass, CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE);
		createEReference(callTemplateParameterEClass, CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION);

		callTemplateMediatorEClass = createEClass(CALL_TEMPLATE_MEDIATOR);
		createEAttribute(callTemplateMediatorEClass, CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES);
		createEReference(callTemplateMediatorEClass, CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS);
		createEReference(callTemplateMediatorEClass, CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(callTemplateMediatorEClass, CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(callTemplateMediatorEClass, CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE);

		callTemplateMediatorInputConnectorEClass = createEClass(CALL_TEMPLATE_MEDIATOR_INPUT_CONNECTOR);

		callTemplateMediatorOutputConnectorEClass = createEClass(CALL_TEMPLATE_MEDIATOR_OUTPUT_CONNECTOR);

		loopBackMediatorEClass = createEClass(LOOP_BACK_MEDIATOR);
		createEReference(loopBackMediatorEClass, LOOP_BACK_MEDIATOR__INPUT_CONNECTOR);
		createEReference(loopBackMediatorEClass, LOOP_BACK_MEDIATOR__OUTPUT_CONNECTOR);

		loopBackMediatorInputConnectorEClass = createEClass(LOOP_BACK_MEDIATOR_INPUT_CONNECTOR);

		loopBackMediatorOutputConnectorEClass = createEClass(LOOP_BACK_MEDIATOR_OUTPUT_CONNECTOR);

		respondMediatorEClass = createEClass(RESPOND_MEDIATOR);
		createEReference(respondMediatorEClass, RESPOND_MEDIATOR__INPUT_CONNECTOR);
		createEReference(respondMediatorEClass, RESPOND_MEDIATOR__OUTPUT_CONNECTOR);

		respondMediatorInputConnectorEClass = createEClass(RESPOND_MEDIATOR_INPUT_CONNECTOR);

		respondMediatorOutputConnectorEClass = createEClass(RESPOND_MEDIATOR_OUTPUT_CONNECTOR);

		smooksMediatorEClass = createEClass(SMOOKS_MEDIATOR);
		createEReference(smooksMediatorEClass, SMOOKS_MEDIATOR__CONFIGURATION_KEY);
		createEAttribute(smooksMediatorEClass, SMOOKS_MEDIATOR__INPUT_TYPE);
		createEReference(smooksMediatorEClass, SMOOKS_MEDIATOR__INPUT_EXPRESSION);
		createEAttribute(smooksMediatorEClass, SMOOKS_MEDIATOR__OUTPUT_TYPE);
		createEReference(smooksMediatorEClass, SMOOKS_MEDIATOR__OUTPUT_EXPRESSION);
		createEAttribute(smooksMediatorEClass, SMOOKS_MEDIATOR__OUTPUT_PROPERTY);
		createEAttribute(smooksMediatorEClass, SMOOKS_MEDIATOR__OUTPUT_ACTION);
		createEAttribute(smooksMediatorEClass, SMOOKS_MEDIATOR__OUTPUT_METHOD);
		createEReference(smooksMediatorEClass, SMOOKS_MEDIATOR__INPUT_CONNECTOR);
		createEReference(smooksMediatorEClass, SMOOKS_MEDIATOR__OUTPUT_CONNECTOR);

		smooksMediatorInputConnectorEClass = createEClass(SMOOKS_MEDIATOR_INPUT_CONNECTOR);

		smooksMediatorOutputConnectorEClass = createEClass(SMOOKS_MEDIATOR_OUTPUT_CONNECTOR);

		storeMediatorEClass = createEClass(STORE_MEDIATOR);
		createEAttribute(storeMediatorEClass, STORE_MEDIATOR__MESSAGE_STORE);
		createEReference(storeMediatorEClass, STORE_MEDIATOR__ON_STORE_SEQUENCE);
		createEReference(storeMediatorEClass, STORE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(storeMediatorEClass, STORE_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(storeMediatorEClass, STORE_MEDIATOR__AVAILABLE_MESSAGE_STORES);

		storeMediatorInputConnectorEClass = createEClass(STORE_MEDIATOR_INPUT_CONNECTOR);

		storeMediatorOutputConnectorEClass = createEClass(STORE_MEDIATOR_OUTPUT_CONNECTOR);

		builderMediatorEClass = createEClass(BUILDER_MEDIATOR);
		createEReference(builderMediatorEClass, BUILDER_MEDIATOR__MESSAGE_BUILDERS);
		createEReference(builderMediatorEClass, BUILDER_MEDIATOR__INPUT_CONNECTOR);
		createEReference(builderMediatorEClass, BUILDER_MEDIATOR__OUTPUT_CONNECTOR);

		builderMediatorInputConnectorEClass = createEClass(BUILDER_MEDIATOR_INPUT_CONNECTOR);

		builderMediatorOutputConectorEClass = createEClass(BUILDER_MEDIATOR_OUTPUT_CONECTOR);

		messageBuilderEClass = createEClass(MESSAGE_BUILDER);
		createEAttribute(messageBuilderEClass, MESSAGE_BUILDER__CONTENT_TYPE);
		createEAttribute(messageBuilderEClass, MESSAGE_BUILDER__BUILDER_CLASS);
		createEAttribute(messageBuilderEClass, MESSAGE_BUILDER__FORMATTER_CLASS);

		payloadFactoryMediatorEClass = createEClass(PAYLOAD_FACTORY_MEDIATOR);
		createEAttribute(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__PAYLOAD);
		createEReference(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_KEY);
		createEReference(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__ARGS);
		createEReference(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR);
		createEReference(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__MEDIA_TYPE);
		createEAttribute(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_FORMAT);

		payloadFactoryMediatorInputConnectorEClass = createEClass(PAYLOAD_FACTORY_MEDIATOR_INPUT_CONNECTOR);

		payloadFactoryMediatorOutputConnectorEClass = createEClass(PAYLOAD_FACTORY_MEDIATOR_OUTPUT_CONNECTOR);

		payloadFactoryArgumentEClass = createEClass(PAYLOAD_FACTORY_ARGUMENT);
		createEAttribute(payloadFactoryArgumentEClass, PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE);
		createEAttribute(payloadFactoryArgumentEClass, PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE);
		createEReference(payloadFactoryArgumentEClass, PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION);
		createEAttribute(payloadFactoryArgumentEClass, PAYLOAD_FACTORY_ARGUMENT__EVALUATOR);

		conditionalRouteBranchEClass = createEClass(CONDITIONAL_ROUTE_BRANCH);
		createEAttribute(conditionalRouteBranchEClass, CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE);
		createEReference(conditionalRouteBranchEClass, CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION);
		createEReference(conditionalRouteBranchEClass, CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE);

		conditionalRouterMediatorEClass = createEClass(CONDITIONAL_ROUTER_MEDIATOR);
		createEAttribute(conditionalRouterMediatorEClass, CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE);
		createEReference(conditionalRouterMediatorEClass, CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES);
		createEReference(conditionalRouterMediatorEClass, CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR);
		createEReference(conditionalRouterMediatorEClass, CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(conditionalRouterMediatorEClass, CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR);
		createEReference(conditionalRouterMediatorEClass, CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW);

		conditionalRouterMediatorInputConnectorEClass = createEClass(CONDITIONAL_ROUTER_MEDIATOR_INPUT_CONNECTOR);

		conditionalRouterMediatorOutputConnectorEClass = createEClass(CONDITIONAL_ROUTER_MEDIATOR_OUTPUT_CONNECTOR);

		conditionalRouterMediatorAdditionalOutputConnectorEClass = createEClass(CONDITIONAL_ROUTER_MEDIATOR_ADDITIONAL_OUTPUT_CONNECTOR);

		sendMediatorEClass = createEClass(SEND_MEDIATOR);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__END_POINT);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__INPUT_CONNECTOR);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__OUTPUT_CONNECTOR);
		createEAttribute(sendMediatorEClass, SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__MEDIATOR_FLOW);
		createEAttribute(sendMediatorEClass, SEND_MEDIATOR__SKIP_SERIALIZATION);
		createEAttribute(sendMediatorEClass, SEND_MEDIATOR__BUILD_MESSAGE_BEFORE_SENDING);

		sendContainerEClass = createEClass(SEND_CONTAINER);
		createEReference(sendContainerEClass, SEND_CONTAINER__ENDPOINT_FLOW);

		sendMediatorInputConnectorEClass = createEClass(SEND_MEDIATOR_INPUT_CONNECTOR);

		sendMediatorOutputConnectorEClass = createEClass(SEND_MEDIATOR_OUTPUT_CONNECTOR);

		sendMediatorEndpointOutputConnectorEClass = createEClass(SEND_MEDIATOR_ENDPOINT_OUTPUT_CONNECTOR);

		failoverEndPointEClass = createEClass(FAILOVER_END_POINT);
		createEReference(failoverEndPointEClass, FAILOVER_END_POINT__INPUT_CONNECTOR);
		createEReference(failoverEndPointEClass, FAILOVER_END_POINT__OUTPUT_CONNECTOR);
		createEReference(failoverEndPointEClass, FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR);
		createEReference(failoverEndPointEClass, FAILOVER_END_POINT__MEDIATOR_FLOW);

		failoverEndPointInputConnectorEClass = createEClass(FAILOVER_END_POINT_INPUT_CONNECTOR);

		failoverEndPointOutputConnectorEClass = createEClass(FAILOVER_END_POINT_OUTPUT_CONNECTOR);

		failoverEndPointWestOutputConnectorEClass = createEClass(FAILOVER_END_POINT_WEST_OUTPUT_CONNECTOR);

		parentEndPointEClass = createEClass(PARENT_END_POINT);
		createEReference(parentEndPointEClass, PARENT_END_POINT__CHILDREN);
		createEAttribute(parentEndPointEClass, PARENT_END_POINT__NAME);

		wsdlEndPointEClass = createEClass(WSDL_END_POINT);
		createEReference(wsdlEndPointEClass, WSDL_END_POINT__INPUT_CONNECTOR);
		createEReference(wsdlEndPointEClass, WSDL_END_POINT__OUTPUT_CONNECTOR);
		createEAttribute(wsdlEndPointEClass, WSDL_END_POINT__WSDL_URI);
		createEAttribute(wsdlEndPointEClass, WSDL_END_POINT__SERVICE);
		createEAttribute(wsdlEndPointEClass, WSDL_END_POINT__PORT);

		wsdlEndPointInputConnectorEClass = createEClass(WSDL_END_POINT_INPUT_CONNECTOR);

		wsdlEndPointOutputConnectorEClass = createEClass(WSDL_END_POINT_OUTPUT_CONNECTOR);

		loadBalanceEndPointEClass = createEClass(LOAD_BALANCE_END_POINT);
		createEAttribute(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__FAILOVER);
		createEAttribute(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__POLICY);
		createEReference(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__INPUT_CONNECTOR);
		createEReference(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR);
		createEReference(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR);
		createEReference(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__MEMBER);
		createEAttribute(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__SESSION_TYPE);
		createEAttribute(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__ALGORITHM);
		createEAttribute(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__SESSION_TIMEOUT);
		createEReference(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__MEDIATOR_FLOW);

		memberEClass = createEClass(MEMBER);
		createEAttribute(memberEClass, MEMBER__HOST_NAME);
		createEAttribute(memberEClass, MEMBER__HTTP_PORT);
		createEAttribute(memberEClass, MEMBER__HTTPS_PORT);

		loadBalanceEndPointInputConnectorEClass = createEClass(LOAD_BALANCE_END_POINT_INPUT_CONNECTOR);

		loadBalanceEndPointOutputConnectorEClass = createEClass(LOAD_BALANCE_END_POINT_OUTPUT_CONNECTOR);

		loadBalanceEndPointWestOutputConnectorEClass = createEClass(LOAD_BALANCE_END_POINT_WEST_OUTPUT_CONNECTOR);

		localEntryEClass = createEClass(LOCAL_ENTRY);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__ENTRY_NAME);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__LOCAL_ENTRY_TYPE);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__VALUE_LITERAL);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__VALUE_XML);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__VALUE_URL);

		sessionEClass = createEClass(SESSION);
		createEAttribute(sessionEClass, SESSION__TYPE);

		sequencesEClass = createEClass(SEQUENCES);
		createEReference(sequencesEClass, SEQUENCES__OUTPUT_CONNECTOR);
		createEReference(sequencesEClass, SEQUENCES__INPUT_CONNECTOR);
		createEReference(sequencesEClass, SEQUENCES__MEDIATOR_FLOW);
		createEAttribute(sequencesEClass, SEQUENCES__NAME);
		createEAttribute(sequencesEClass, SEQUENCES__RECIEVE_SEQUENCE);
		createEAttribute(sequencesEClass, SEQUENCES__ASSOCIATED_PROXY);
		createEReference(sequencesEClass, SEQUENCES__ON_ERROR);
		createEReference(sequencesEClass, SEQUENCES__TEMPLATE_PARAMETERS);
		createEAttribute(sequencesEClass, SEQUENCES__TRACE_ENABLED);
		createEAttribute(sequencesEClass, SEQUENCES__STATISTICS_ENABLED);

		sequencesOutputConnectorEClass = createEClass(SEQUENCES_OUTPUT_CONNECTOR);

		sequencesInputConnectorEClass = createEClass(SEQUENCES_INPUT_CONNECTOR);

		urlRewriteRuleActionEClass = createEClass(URL_REWRITE_RULE_ACTION);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__RULE_ACTION);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__RULE_FRAGMENT);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__RULE_OPTION);
		createEReference(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__ACTION_VALUE);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__ACTION_REGEX);

		urlRewriteRuleEClass = createEClass(URL_REWRITE_RULE);
		createEReference(urlRewriteRuleEClass, URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION);
		createEReference(urlRewriteRuleEClass, URL_REWRITE_RULE__REWRITE_RULE_ACTION);

		urlRewriteMediatorEClass = createEClass(URL_REWRITE_MEDIATOR);
		createEReference(urlRewriteMediatorEClass, URL_REWRITE_MEDIATOR__URL_REWRITE_RULES);
		createEAttribute(urlRewriteMediatorEClass, URL_REWRITE_MEDIATOR__IN_PROPERTY);
		createEAttribute(urlRewriteMediatorEClass, URL_REWRITE_MEDIATOR__OUT_PROPERTY);
		createEReference(urlRewriteMediatorEClass, URL_REWRITE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(urlRewriteMediatorEClass, URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR);

		urlRewriteMediatorInputConnectorEClass = createEClass(URL_REWRITE_MEDIATOR_INPUT_CONNECTOR);

		urlRewriteMediatorOutputConnectorEClass = createEClass(URL_REWRITE_MEDIATOR_OUTPUT_CONNECTOR);

		evaluatorExpressionPropertyEClass = createEClass(EVALUATOR_EXPRESSION_PROPERTY);
		createEAttribute(evaluatorExpressionPropertyEClass, EVALUATOR_EXPRESSION_PROPERTY__PRETTY_NAME);
		createEAttribute(evaluatorExpressionPropertyEClass, EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_NAME);
		createEAttribute(evaluatorExpressionPropertyEClass, EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_VALUE);

		validateMediatorEClass = createEClass(VALIDATE_MEDIATOR);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__SOURCE_XPATH);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__FEATURES);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__SCHEMAS);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__INPUT_CONNECTOR);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__MEDIATOR_FLOW);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__RESOURCES);

		validateResourceEClass = createEClass(VALIDATE_RESOURCE);

		validateFeatureEClass = createEClass(VALIDATE_FEATURE);

		validateSchemaEClass = createEClass(VALIDATE_SCHEMA);
		createEReference(validateSchemaEClass, VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY);
		createEReference(validateSchemaEClass, VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY);
		createEAttribute(validateSchemaEClass, VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE);
		createEReference(validateSchemaEClass, VALIDATE_SCHEMA__SCHEMA_KEY);

		validateMediatorInputConnectorEClass = createEClass(VALIDATE_MEDIATOR_INPUT_CONNECTOR);

		validateMediatorOutputConnectorEClass = createEClass(VALIDATE_MEDIATOR_OUTPUT_CONNECTOR);

		validateMediatorOnFailOutputConnectorEClass = createEClass(VALIDATE_MEDIATOR_ON_FAIL_OUTPUT_CONNECTOR);

		endpointDiagramEClass = createEClass(ENDPOINT_DIAGRAM);
		createEReference(endpointDiagramEClass, ENDPOINT_DIAGRAM__CHILD);
		createEAttribute(endpointDiagramEClass, ENDPOINT_DIAGRAM__NAME);

		namedEndpointEClass = createEClass(NAMED_ENDPOINT);
		createEReference(namedEndpointEClass, NAMED_ENDPOINT__INPUT_CONNECTOR);
		createEReference(namedEndpointEClass, NAMED_ENDPOINT__OUTPUT_CONNECTOR);
		createEAttribute(namedEndpointEClass, NAMED_ENDPOINT__NAME);
		createEAttribute(namedEndpointEClass, NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE);
		createEReference(namedEndpointEClass, NAMED_ENDPOINT__DYNAMIC_REFERENCE_KEY);
		createEReference(namedEndpointEClass, NAMED_ENDPOINT__STATIC_REFERENCE_KEY);

		namedEndpointInputConnectorEClass = createEClass(NAMED_ENDPOINT_INPUT_CONNECTOR);

		namedEndpointOutputConnectorEClass = createEClass(NAMED_ENDPOINT_OUTPUT_CONNECTOR);

		templateEClass = createEClass(TEMPLATE);
		createEAttribute(templateEClass, TEMPLATE__NAME);
		createEAttribute(templateEClass, TEMPLATE__TEMPLATE_TYPE);
		createEReference(templateEClass, TEMPLATE__CHILD);
		createEReference(templateEClass, TEMPLATE__PARAMETERS);

		templateParameterEClass = createEClass(TEMPLATE_PARAMETER);
		createEAttribute(templateParameterEClass, TEMPLATE_PARAMETER__NAME);

		taskEClass = createEClass(TASK);
		createEAttribute(taskEClass, TASK__TASK_NAME);
		createEAttribute(taskEClass, TASK__TASK_GROUP);
		createEAttribute(taskEClass, TASK__TRIGGER_TYPE);
		createEAttribute(taskEClass, TASK__COUNT);
		createEAttribute(taskEClass, TASK__INTERVAL);
		createEAttribute(taskEClass, TASK__CRON);
		createEAttribute(taskEClass, TASK__PINNED_SERVERS);
		createEAttribute(taskEClass, TASK__TASK_IMPLEMENTATION);
		createEReference(taskEClass, TASK__TASK_PROPERTIES);

		nameValueTypePropertyEClass = createEClass(NAME_VALUE_TYPE_PROPERTY);
		createEAttribute(nameValueTypePropertyEClass, NAME_VALUE_TYPE_PROPERTY__PROPERTY_NAME);
		createEAttribute(nameValueTypePropertyEClass, NAME_VALUE_TYPE_PROPERTY__PROPERTY_VALUE);
		createEAttribute(nameValueTypePropertyEClass, NAME_VALUE_TYPE_PROPERTY__PROPERTY_TYPE);

		taskPropertyEClass = createEClass(TASK_PROPERTY);

		synapseAPIEClass = createEClass(SYNAPSE_API);
		createEAttribute(synapseAPIEClass, SYNAPSE_API__API_NAME);
		createEAttribute(synapseAPIEClass, SYNAPSE_API__CONTEXT);
		createEAttribute(synapseAPIEClass, SYNAPSE_API__HOST_NAME);
		createEAttribute(synapseAPIEClass, SYNAPSE_API__PORT);
		createEReference(synapseAPIEClass, SYNAPSE_API__RESOURCES);
		createEReference(synapseAPIEClass, SYNAPSE_API__HANDLERS);

		apiResourceEClass = createEClass(API_RESOURCE);
		createEReference(apiResourceEClass, API_RESOURCE__INPUT_CONNECTOR);
		createEReference(apiResourceEClass, API_RESOURCE__OUTPUT_CONNECTOR);
		createEReference(apiResourceEClass, API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR);
		createEReference(apiResourceEClass, API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS);
		createEReference(apiResourceEClass, API_RESOURCE__FAULT_INPUT_CONNECTOR);
		createEAttribute(apiResourceEClass, API_RESOURCE__URL_STYLE);
		createEAttribute(apiResourceEClass, API_RESOURCE__URI_TEMPLATE);
		createEAttribute(apiResourceEClass, API_RESOURCE__URL_MAPPING);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_GET);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_POST);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_PUT);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_DELETE);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_OPTIONS);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_HEAD);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_PATCH);
		createEReference(apiResourceEClass, API_RESOURCE__CONTAINER);
		createEAttribute(apiResourceEClass, API_RESOURCE__IN_SEQUENCE_TYPE);
		createEReference(apiResourceEClass, API_RESOURCE__IN_SEQUENCE_KEY);
		createEAttribute(apiResourceEClass, API_RESOURCE__IN_SEQUENCE_NAME);
		createEAttribute(apiResourceEClass, API_RESOURCE__OUT_SEQUENCE_TYPE);
		createEReference(apiResourceEClass, API_RESOURCE__OUT_SEQUENCE_KEY);
		createEAttribute(apiResourceEClass, API_RESOURCE__OUT_SEQUENCE_NAME);
		createEAttribute(apiResourceEClass, API_RESOURCE__FAULT_SEQUENCE_TYPE);
		createEReference(apiResourceEClass, API_RESOURCE__FAULT_SEQUENCE_KEY);
		createEAttribute(apiResourceEClass, API_RESOURCE__FAULT_SEQUENCE_NAME);
		createEAttribute(apiResourceEClass, API_RESOURCE__PROTOCOL);

		apiResourceInputConnectorEClass = createEClass(API_RESOURCE_INPUT_CONNECTOR);

		apiResourceOutputConnectorEClass = createEClass(API_RESOURCE_OUTPUT_CONNECTOR);

		apiResourceOutSequenceOutputConnectorEClass = createEClass(API_RESOURCE_OUT_SEQUENCE_OUTPUT_CONNECTOR);

		apiResourceInSequenceInputConnectorEClass = createEClass(API_RESOURCE_IN_SEQUENCE_INPUT_CONNECTOR);

		apiResourceFaultInputConnectorEClass = createEClass(API_RESOURCE_FAULT_INPUT_CONNECTOR);

		apiResourceEndpointEClass = createEClass(API_RESOURCE_ENDPOINT);
		createEReference(apiResourceEndpointEClass, API_RESOURCE_ENDPOINT__INPUT_CONNECTOR);
		createEReference(apiResourceEndpointEClass, API_RESOURCE_ENDPOINT__OUTPUT_CONNECTOR);

		apiResourceEndpointInputConnectorEClass = createEClass(API_RESOURCE_ENDPOINT_INPUT_CONNECTOR);

		apiResourceEndpointOutputConnectorEClass = createEClass(API_RESOURCE_ENDPOINT_OUTPUT_CONNECTOR);

		complexEndpointsEClass = createEClass(COMPLEX_ENDPOINTS);
		createEReference(complexEndpointsEClass, COMPLEX_ENDPOINTS__OUTPUT_CONNECTOR);
		createEReference(complexEndpointsEClass, COMPLEX_ENDPOINTS__MEDIATOR_FLOW);
		createEAttribute(complexEndpointsEClass, COMPLEX_ENDPOINTS__NAME);

		complexEndpointsOutputConnectorEClass = createEClass(COMPLEX_ENDPOINTS_OUTPUT_CONNECTOR);

		addressingEndpointEClass = createEClass(ADDRESSING_ENDPOINT);
		createEReference(addressingEndpointEClass, ADDRESSING_ENDPOINT__INPUT_CONNECTOR);
		createEReference(addressingEndpointEClass, ADDRESSING_ENDPOINT__OUTPUT_CONNECTOR);

		addressingEndpointInputConnectorEClass = createEClass(ADDRESSING_ENDPOINT_INPUT_CONNECTOR);

		addressingEndpointOutputConnectorEClass = createEClass(ADDRESSING_ENDPOINT_OUTPUT_CONNECTOR);

		recipientListEndPointEClass = createEClass(RECIPIENT_LIST_END_POINT);
		createEReference(recipientListEndPointEClass, RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR);
		createEReference(recipientListEndPointEClass, RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR);
		createEReference(recipientListEndPointEClass, RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR);
		createEAttribute(recipientListEndPointEClass, RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE);
		createEAttribute(recipientListEndPointEClass, RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE);
		createEReference(recipientListEndPointEClass, RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION);
		createEAttribute(recipientListEndPointEClass, RECIPIENT_LIST_END_POINT__MAX_CACHE);
		createEReference(recipientListEndPointEClass, RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW);

		recipientListEndPointInputConnectorEClass = createEClass(RECIPIENT_LIST_END_POINT_INPUT_CONNECTOR);

		recipientListEndPointOutputConnectorEClass = createEClass(RECIPIENT_LIST_END_POINT_OUTPUT_CONNECTOR);

		recipientListEndPointWestOutputConnectorEClass = createEClass(RECIPIENT_LIST_END_POINT_WEST_OUTPUT_CONNECTOR);

		messageStoreParameterEClass = createEClass(MESSAGE_STORE_PARAMETER);
		createEAttribute(messageStoreParameterEClass, MESSAGE_STORE_PARAMETER__PARAMETER_NAME);
		createEAttribute(messageStoreParameterEClass, MESSAGE_STORE_PARAMETER__PARAMETER_VALUE);

		messageStoreEClass = createEClass(MESSAGE_STORE);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__STORE_NAME);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__STORE_TYPE);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__INITIAL_CONTEXT_FACTORY);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__PROVIDER_URL);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JNDI_QUEUE_NAME);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__CONNECTION_FACTORY);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__USER_NAME);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__PASSWORD);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JMS_SPEC_VERSION);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__ENABLE_CACHING);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__PROVIDER_CLASS);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_NAME);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__RABBIT_MQ_SERVER_HOST_PORT);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__RABBIT_MQ_QUEUE_NAME);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__RABBIT_MQ_EXCHANGE_NAME);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__ROUTING_KEY);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__RABBIT_MQ_USER_NAME);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__RABBIT_MQ_PASSWORD);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__VIRTUAL_HOST);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JDBC_DATABASE_TABLE);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JDBC_CONNECTION_INFORMATION);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JDBC_DRIVER);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JDBC_URL);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JDBC_USER);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JDBC_PASSWORD);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__JDBC_DATASOURCE_NAME);
		createEReference(messageStoreEClass, MESSAGE_STORE__PARAMETERS);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__ENABLE_PRODUCER_GUARANTEED_DELIVERY);
		createEAttribute(messageStoreEClass, MESSAGE_STORE__FAILOVER_MESSAGE_STORE);

		messageProcessorParameterEClass = createEClass(MESSAGE_PROCESSOR_PARAMETER);
		createEAttribute(messageProcessorParameterEClass, MESSAGE_PROCESSOR_PARAMETER__PARAMETER_NAME);
		createEAttribute(messageProcessorParameterEClass, MESSAGE_PROCESSOR_PARAMETER__PARAMETER_VALUE);

		messageProcessorEClass = createEClass(MESSAGE_PROCESSOR);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__PROCESSOR_NAME);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__PROCESSOR_TYPE);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__MESSAGE_STORE);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__SOURCE_MESSAGE_STORE);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__TARGET_MESSAGE_STORE);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__PROCESSOR_STATE);
		createEReference(messageProcessorEClass, MESSAGE_PROCESSOR__ENDPOINT_NAME);
		createEReference(messageProcessorEClass, MESSAGE_PROCESSOR__SEQUENCE);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__RETRY_INTERVAL);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__FORWARDING_INTERVAL);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__SAMPLING_INTERVAL);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__SAMPLING_CONCURRENCY);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__DROP_MESSAGE_AFTER_MAXIMUM_DELIVERY_ATTEMPTS);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__AXIS2_CONFIGURATION);
		createEReference(messageProcessorEClass, MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME);
		createEReference(messageProcessorEClass, MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME);
		createEReference(messageProcessorEClass, MESSAGE_PROCESSOR__DEACTIVATE_SEQUENCE_NAME);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__CRON_EXPRESSION);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__NON_RETRY_HTTP_STATUS_CODES);
		createEReference(messageProcessorEClass, MESSAGE_PROCESSOR__PARAMETERS);
		createEAttribute(messageProcessorEClass, MESSAGE_PROCESSOR__TASK_COUNT);

		apiHandlerEClass = createEClass(API_HANDLER);
		createEAttribute(apiHandlerEClass, API_HANDLER__CLASS_NAME);
		createEReference(apiHandlerEClass, API_HANDLER__PROPERTIES);

		apiHandlerPropertyEClass = createEClass(API_HANDLER_PROPERTY);
		createEAttribute(apiHandlerPropertyEClass, API_HANDLER_PROPERTY__NAME);
		createEAttribute(apiHandlerPropertyEClass, API_HANDLER_PROPERTY__VALUE);

		cloudConnectorEClass = createEClass(CLOUD_CONNECTOR);
		createEReference(cloudConnectorEClass, CLOUD_CONNECTOR__INPUT_CONNECTOR);
		createEReference(cloudConnectorEClass, CLOUD_CONNECTOR__OUTPUT_CONNECTOR);
		createEReference(cloudConnectorEClass, CLOUD_CONNECTOR__CONNECTOR_PARAMETERS);

		cloudConnectorInputConnectorEClass = createEClass(CLOUD_CONNECTOR_INPUT_CONNECTOR);

		cloudConnectorOutputConnectorEClass = createEClass(CLOUD_CONNECTOR_OUTPUT_CONNECTOR);

		cloudConnectorOperationEClass = createEClass(CLOUD_CONNECTOR_OPERATION);
		createEReference(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR);
		createEReference(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR);
		createEReference(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS);
		createEAttribute(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__CONFIG_REF);
		createEAttribute(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME);
		createEAttribute(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__OPERATION_NAME);
		createEAttribute(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME);
		createEReference(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__NEW_CONFIG);
		createEAttribute(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__AVAILABLE_CONFIGS);
		createEAttribute(cloudConnectorOperationEClass, CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE);

		cloudConnectorOperationInputConnectorEClass = createEClass(CLOUD_CONNECTOR_OPERATION_INPUT_CONNECTOR);

		cloudConnectorOperationOutputConnectorEClass = createEClass(CLOUD_CONNECTOR_OPERATION_OUTPUT_CONNECTOR);

		dataMapperMediatorEClass = createEClass(DATA_MAPPER_MEDIATOR);
		createEReference(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR);
		createEAttribute(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__INPUT_TYPE);
		createEReference(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR);
		createEReference(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__CONFIGURATION);
		createEReference(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__INPUT_SCHEMA);
		createEReference(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA);
		createEAttribute(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH);
		createEAttribute(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH);
		createEAttribute(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH);
		createEAttribute(dataMapperMediatorEClass, DATA_MAPPER_MEDIATOR__OUTPUT_TYPE);

		dataMapperMediatorInputConnectorEClass = createEClass(DATA_MAPPER_MEDIATOR_INPUT_CONNECTOR);

		dataMapperMediatorOutputConnectorEClass = createEClass(DATA_MAPPER_MEDIATOR_OUTPUT_CONNECTOR);

		fastXSLTMediatorEClass = createEClass(FAST_XSLT_MEDIATOR);
		createEAttribute(fastXSLTMediatorEClass, FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE);
		createEReference(fastXSLTMediatorEClass, FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY);
		createEReference(fastXSLTMediatorEClass, FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY);
		createEReference(fastXSLTMediatorEClass, FAST_XSLT_MEDIATOR__INPUT_CONNECTOR);
		createEReference(fastXSLTMediatorEClass, FAST_XSLT_MEDIATOR__OUTPUT_CONNECTOR);

		fastXSLTMediatorInputConnectorEClass = createEClass(FAST_XSLT_MEDIATOR_INPUT_CONNECTOR);

		fastXSLTMediatorOutputConnectorEClass = createEClass(FAST_XSLT_MEDIATOR_OUTPUT_CONNECTOR);

		inboundEndpointEClass = createEClass(INBOUND_ENDPOINT);
		createEReference(inboundEndpointEClass, INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR);
		createEReference(inboundEndpointEClass, INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR);
		createEReference(inboundEndpointEClass, INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR);
		createEReference(inboundEndpointEClass, INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR);
		createEReference(inboundEndpointEClass, INBOUND_ENDPOINT__CONTAINER);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__CLASS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__PROTOCOL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_ENDPOINT_BEHAVIOUR);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HTTP_PORT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_THREAD_ID);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INTERVAL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SEQUENTIAL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__COORDINATION);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_TOPIC_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_SESSION_CLEAN);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRUSTSTORE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__KEYSTORE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SSL_VERIFY_CLIENT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SSL_PROTOCOL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__HTTPS_PROTOCOLS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HL7_PORT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__ZOOKEEPER_CONNECT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__GROUP_ID);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__CONTENT_TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__CONSUMER_TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TOPICS_OR_TOPIC_FILTER);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TOPICS_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TOPIC_FILTER_FROM);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TOPIC_FILTER_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SIMPLE_CONSUMER_TOPIC);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SIMPLE_CONSUMER_BROKERS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SIMPLE_CONSUMER_PORT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SIMPLE_CONSUMER_PARTITION);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SIMPLE_CONSUMER_MAX_MESSAGES_TO_READ);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__THREAD_COUNT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__CONSUMER_ID);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SOCKET_TIMEOUT_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SOCKET_RECEIVE_BUFFER_BYTES);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__FETCH_MESSAGE_MAX_BYTES);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__NUM_CONSUMER_FETCHES);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__AUTO_COMMIT_ENABLE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__QUEUED_MAX_MESSAGE_CHUNKS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__REBALANCE_MAX_RETRIES);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__FETCH_MIN_BYTES);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__FETCH_WAIT_MAX_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__REBALANCE_BACKOFF_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__REFRESH_LEADER_BACKOFF_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__AUTO_OFFSET_RESET);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__CONSUMER_TIMEOUT_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__EXCLUDE_INTERNAL_TOPICS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__PARTITION_ASSIGNMENT_STRATEGY);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__CLIENT_ID);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__ZOOKEEPER_CONNECTION_TIMEOUT_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__OFFSETS_STORAGE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__OFFSETS_CHANNEL_BACKOFF_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__OFFSETS_COMMIT_MAX_RETRIES);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__DUAL_COMMIT_ENABLED);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__ENABLE_SSL);
		createEReference(inboundEndpointEClass, INBOUND_ENDPOINT__SERVICE_PARAMETERS);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__SUSPEND);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_FACTORY);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_HOST_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_PORT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_USER_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_PASSWORD);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_NAME);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_DURABLE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_EXCLUSIVE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_AUTO_DELETE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_AUTO_ACK);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_ROUTING_KEY);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_DELIVERY_MODE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_DURABLE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_AUTO_DELETE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_VIRTUAL_HOST);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_FACTORY_HEARTBEAT);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_ENABLED);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_LOCATION);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_PASSWORD);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_LOCATION);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_TYPE);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_VERSION);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_FEED_URL);
		createEAttribute(inboundEndpointEClass, INBOUND_ENDPOINT__TRANSPORT_FEED_TYPE);

		inboundEndpointParameterEClass = createEClass(INBOUND_ENDPOINT_PARAMETER);
		createEAttribute(inboundEndpointParameterEClass, INBOUND_ENDPOINT_PARAMETER__NAME);
		createEAttribute(inboundEndpointParameterEClass, INBOUND_ENDPOINT_PARAMETER__VALUE);

		inboundEndpointContainerEClass = createEClass(INBOUND_ENDPOINT_CONTAINER);
		createEReference(inboundEndpointContainerEClass, INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER);
		createEReference(inboundEndpointContainerEClass, INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER);

		inboundEndpointSequenceContainerEClass = createEClass(INBOUND_ENDPOINT_SEQUENCE_CONTAINER);
		createEReference(inboundEndpointSequenceContainerEClass, INBOUND_ENDPOINT_SEQUENCE_CONTAINER__MEDIATOR_FLOW);

		inboundEndpointOnErrorSequenceContainerEClass = createEClass(INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_CONTAINER);
		createEReference(inboundEndpointOnErrorSequenceContainerEClass, INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_CONTAINER__MEDIATOR_FLOW);

		inboundEndpointSequenceInputConnectorEClass = createEClass(INBOUND_ENDPOINT_SEQUENCE_INPUT_CONNECTOR);

		inboundEndpointSequenceOutputConnectorEClass = createEClass(INBOUND_ENDPOINT_SEQUENCE_OUTPUT_CONNECTOR);

		inboundEndpointOnErrorSequenceOutputConnectorEClass = createEClass(INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR);

		inboundEndpointOnErrorSequenceInputConnectorEClass = createEClass(INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_INPUT_CONNECTOR);

		commentMediatorEClass = createEClass(COMMENT_MEDIATOR);
		createEAttribute(commentMediatorEClass, COMMENT_MEDIATOR__COMMENT_TEXT);

		// Create enums
		artifactTypeEEnum = createEEnum(ARTIFACT_TYPE);
		callMediatorEndpointTypeEEnum = createEEnum(CALL_MEDIATOR_ENDPOINT_TYPE);
		endPointPropertyScopeEEnum = createEEnum(END_POINT_PROPERTY_SCOPE);
		sequenceTypeEEnum = createEEnum(SEQUENCE_TYPE);
		proxyWsdlTypeEEnum = createEEnum(PROXY_WSDL_TYPE);
		httpMethodTypeEEnum = createEEnum(HTTP_METHOD_TYPE);
		filterMediatorConditionTypeEEnum = createEEnum(FILTER_MEDIATOR_CONDITION_TYPE);
		logCategoryEEnum = createEEnum(LOG_CATEGORY);
		logLevelEEnum = createEEnum(LOG_LEVEL);
		attributeValueTypeEEnum = createEEnum(ATTRIBUTE_VALUE_TYPE);
		attributeTypeEEnum = createEEnum(ATTRIBUTE_TYPE);
		beanMediatorActionEEnum = createEEnum(BEAN_MEDIATOR_ACTION);
		endPointAddressingVersionEEnum = createEEnum(END_POINT_ADDRESSING_VERSION);
		endPointTimeOutActionEEnum = createEEnum(END_POINT_TIME_OUT_ACTION);
		endPointMessageFormatEEnum = createEEnum(END_POINT_MESSAGE_FORMAT);
		endPointAttachmentOptimizationEEnum = createEEnum(END_POINT_ATTACHMENT_OPTIMIZATION);
		propertyDataTypeEEnum = createEEnum(PROPERTY_DATA_TYPE);
		propertyActionEEnum = createEEnum(PROPERTY_ACTION);
		propertyScopeEEnum = createEEnum(PROPERTY_SCOPE);
		propertyValueTypeEEnum = createEEnum(PROPERTY_VALUE_TYPE);
		propertyNameEEnum = createEEnum(PROPERTY_NAME);
		enrichSourceInlineTypeEEnum = createEEnum(ENRICH_SOURCE_INLINE_TYPE);
		enrichSourceTypeEEnum = createEEnum(ENRICH_SOURCE_TYPE);
		enrichTargetActionEEnum = createEEnum(ENRICH_TARGET_ACTION);
		enrichTargetTypeEEnum = createEEnum(ENRICH_TARGET_TYPE);
		eventTopicTypeEEnum = createEEnum(EVENT_TOPIC_TYPE);
		entitlementCallbackHandlerEEnum = createEEnum(ENTITLEMENT_CALLBACK_HANDLER);
		entitlementClientTypeEEnum = createEEnum(ENTITLEMENT_CLIENT_TYPE);
		entitlementSequenceTypeEEnum = createEEnum(ENTITLEMENT_SEQUENCE_TYPE);
		scriptKeyTypeEnumEEnum = createEEnum(SCRIPT_KEY_TYPE_ENUM);
		scriptTypeEEnum = createEEnum(SCRIPT_TYPE);
		scriptLanguageEEnum = createEEnum(SCRIPT_LANGUAGE);
		faultSoapVersionEEnum = createEEnum(FAULT_SOAP_VERSION);
		faultCodeSoap11EEnum = createEEnum(FAULT_CODE_SOAP11);
		faultCodeSoap12EEnum = createEEnum(FAULT_CODE_SOAP12);
		faultCodeTypeEEnum = createEEnum(FAULT_CODE_TYPE);
		faultStringTypeEEnum = createEEnum(FAULT_STRING_TYPE);
		faultReasonTypeEEnum = createEEnum(FAULT_REASON_TYPE);
		faultDetailTypeEEnum = createEEnum(FAULT_DETAIL_TYPE);
		completionMessagesTypeEEnum = createEEnum(COMPLETION_MESSAGES_TYPE);
		aggregateSequenceTypeEEnum = createEEnum(AGGREGATE_SEQUENCE_TYPE);
		targetSequenceTypeEEnum = createEEnum(TARGET_SEQUENCE_TYPE);
		targetEndpointTypeEEnum = createEEnum(TARGET_ENDPOINT_TYPE);
		cacheSequenceTypeEEnum = createEEnum(CACHE_SEQUENCE_TYPE);
		cacheImplementationTypeEEnum = createEEnum(CACHE_IMPLEMENTATION_TYPE);
		cacheActionEEnum = createEEnum(CACHE_ACTION);
		cacheScopeEEnum = createEEnum(CACHE_SCOPE);
		xQueryVariableTypeEEnum = createEEnum(XQUERY_VARIABLE_TYPE);
		xQueryVariableValueTypeEEnum = createEEnum(XQUERY_VARIABLE_VALUE_TYPE);
		calloutEndpointTypeEEnum = createEEnum(CALLOUT_ENDPOINT_TYPE);
		calloutPayloadTypeEEnum = createEEnum(CALLOUT_PAYLOAD_TYPE);
		calloutSecurityPoliciesEEnum = createEEnum(CALLOUT_SECURITY_POLICIES);
		calloutSecurityTypeEEnum = createEEnum(CALLOUT_SECURITY_TYPE);
		calloutResultTypeEEnum = createEEnum(CALLOUT_RESULT_TYPE);
		rmSpecVersionEEnum = createEEnum(RM_SPEC_VERSION);
		rmSequenceTypeEEnum = createEEnum(RM_SEQUENCE_TYPE);
		transactionActionEEnum = createEEnum(TRANSACTION_ACTION);
		headerActionEEnum = createEEnum(HEADER_ACTION);
		headerValueTypeEEnum = createEEnum(HEADER_VALUE_TYPE);
		scopeTypeEEnum = createEEnum(SCOPE_TYPE);
		throttlePolicyTypeEEnum = createEEnum(THROTTLE_POLICY_TYPE);
		throttleConditionTypeEEnum = createEEnum(THROTTLE_CONDITION_TYPE);
		throttleAccessTypeEEnum = createEEnum(THROTTLE_ACCESS_TYPE);
		throttleSequenceTypeEEnum = createEEnum(THROTTLE_SEQUENCE_TYPE);
		commandPropertyValueTypeEEnum = createEEnum(COMMAND_PROPERTY_VALUE_TYPE);
		commandPropertyMessageActionEEnum = createEEnum(COMMAND_PROPERTY_MESSAGE_ACTION);
		commandPropertyContextActionEEnum = createEEnum(COMMAND_PROPERTY_CONTEXT_ACTION);
		sqlExecutorConnectionTypeEEnum = createEEnum(SQL_EXECUTOR_CONNECTION_TYPE);
		sqlExecutorDatasourceTypeEEnum = createEEnum(SQL_EXECUTOR_DATASOURCE_TYPE);
		sqlExecutorBooleanValueEEnum = createEEnum(SQL_EXECUTOR_BOOLEAN_VALUE);
		sqlExecutorIsolationLevelEEnum = createEEnum(SQL_EXECUTOR_ISOLATION_LEVEL);
		sqlParameterValueTypeEEnum = createEEnum(SQL_PARAMETER_VALUE_TYPE);
		sqlParameterDataTypeEEnum = createEEnum(SQL_PARAMETER_DATA_TYPE);
		ruleActionsEEnum = createEEnum(RULE_ACTIONS);
		ruleTypeEEnum = createEEnum(RULE_TYPE);
		ruleSourceTypeEEnum = createEEnum(RULE_SOURCE_TYPE);
		ruleFactTypeEEnum = createEEnum(RULE_FACT_TYPE);
		ruleFactValueTypeEEnum = createEEnum(RULE_FACT_VALUE_TYPE);
		ruleResultTypeEEnum = createEEnum(RULE_RESULT_TYPE);
		ruleResultValueTypeEEnum = createEEnum(RULE_RESULT_VALUE_TYPE);
		ruleOptionTypeEEnum = createEEnum(RULE_OPTION_TYPE);
		smooksIODataTypeEEnum = createEEnum(SMOOKS_IO_DATA_TYPE);
		smooksOutputDataTypeEEnum = createEEnum(SMOOKS_OUTPUT_DATA_TYPE);
		expressionActionEEnum = createEEnum(EXPRESSION_ACTION);
		outputMethodEEnum = createEEnum(OUTPUT_METHOD);
		receivingSequenceTypeEEnum = createEEnum(RECEIVING_SEQUENCE_TYPE);
		keyTypeEEnum = createEEnum(KEY_TYPE);
		mediaTypeEEnum = createEEnum(MEDIA_TYPE);
		payloadFactoryArgumentTypeEEnum = createEEnum(PAYLOAD_FACTORY_ARGUMENT_TYPE);
		payloadFormatTypeEEnum = createEEnum(PAYLOAD_FORMAT_TYPE);
		typeEEnum = createEEnum(TYPE);
		loadBalanceSessionTypeEEnum = createEEnum(LOAD_BALANCE_SESSION_TYPE);
		localEntryValueTypeEEnum = createEEnum(LOCAL_ENTRY_VALUE_TYPE);
		ruleActionTypeEEnum = createEEnum(RULE_ACTION_TYPE);
		ruleFragmentTypeEEnum = createEEnum(RULE_FRAGMENT_TYPE);
		templateTypeEEnum = createEEnum(TEMPLATE_TYPE);
		taskPropertyTypeEEnum = createEEnum(TASK_PROPERTY_TYPE);
		taskTriggerTypeEEnum = createEEnum(TASK_TRIGGER_TYPE);
		apiResourceUrlStyleEEnum = createEEnum(API_RESOURCE_URL_STYLE);
		recipientListEndpointTypeEEnum = createEEnum(RECIPIENT_LIST_ENDPOINT_TYPE);
		messageStoreTypeEEnum = createEEnum(MESSAGE_STORE_TYPE);
		jmsSpecVersionEEnum = createEEnum(JMS_SPEC_VERSION);
		jdbcConnectionInformationTypeEEnum = createEEnum(JDBC_CONNECTION_INFORMATION_TYPE);
		messageProcessorTypeEEnum = createEEnum(MESSAGE_PROCESSOR_TYPE);
		processorStateEEnum = createEEnum(PROCESSOR_STATE);
		cloudConnectorOperationParamEditorTypeEEnum = createEEnum(CLOUD_CONNECTOR_OPERATION_PARAM_EDITOR_TYPE);
		dataMapperMediatorDataTypesEEnum = createEEnum(DATA_MAPPER_MEDIATOR_DATA_TYPES);
		protocolEEnum = createEEnum(PROTOCOL);
		inboundEndpointTypeEEnum = createEEnum(INBOUND_ENDPOINT_TYPE);
		inboundEndpointBehaviourTypeEEnum = createEEnum(INBOUND_ENDPOINT_BEHAVIOUR_TYPE);
		contentTypeEEnum = createEEnum(CONTENT_TYPE);
		topicsTypeEEnum = createEEnum(TOPICS_TYPE);
		topicFilterFromTypeEEnum = createEEnum(TOPIC_FILTER_FROM_TYPE);
		consumerTypeEEnum = createEEnum(CONSUMER_TYPE);
		autoOffsetResetTypeEEnum = createEEnum(AUTO_OFFSET_RESET_TYPE);
		partitionAssignmentStrategyTypeEEnum = createEEnum(PARTITION_ASSIGNMENT_STRATEGY_TYPE);
		offsetsStorageTypeEEnum = createEEnum(OFFSETS_STORAGE_TYPE);
		enableEEnum = createEEnum(ENABLE);
		vfsActionEEnum = createEEnum(VFS_ACTION);
		vfsFileSortEEnum = createEEnum(VFS_FILE_SORT);
		jmsConnectionFactoryTypeEEnum = createEEnum(JMS_CONNECTION_FACTORY_TYPE);
		jmsSessionAcknowledgementEEnum = createEEnum(JMS_SESSION_ACKNOWLEDGEMENT);
		jmsCacheLevelEEnum = createEEnum(JMS_CACHE_LEVEL);
		mqttSubscriptionQOSEEnum = createEEnum(MQTT_SUBSCRIPTION_QOS);
		feedTypeEEnum = createEEnum(FEED_TYPE);
		enableDisableStateEEnum = createEEnum(ENABLE_DISABLE_STATE);

		// Create data types
		mapEDataType = createEDataType(MAP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		addETypeParameter(mapEDataType, "K");
		addETypeParameter(mapEDataType, "V");

		// Set bounds for type parameters

		// Add supertypes to classes
		esbElementEClass.getESuperTypes().add(this.getEsbNode());
		esbServerEClass.getESuperTypes().add(this.getEsbNode());
		mediatorEClass.getESuperTypes().add(this.getEsbElement());
		inputConnectorEClass.getESuperTypes().add(this.getEsbConnector());
		outputConnectorEClass.getESuperTypes().add(this.getEsbConnector());
		additionalOutputConnectorEClass.getESuperTypes().add(this.getEsbConnector());
		endPointEClass.getESuperTypes().add(this.getEsbElement());
		callMediatorEClass.getESuperTypes().add(this.getMediator());
		callMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		callMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		callMediatorEndpointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		proxyServiceEClass.getESuperTypes().add(this.getEsbElement());
		proxyOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		proxyInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		proxyOutSequenceOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		proxyInSequenceInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		proxyWSDLResourceEClass.getESuperTypes().add(this.getAbstractLocationKeyResource());
		proxyFaultInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		proxyServiceSequenceAndEndpointContainerEClass.getESuperTypes().add(this.getEsbNode());
		proxyServiceFaultContainerEClass.getESuperTypes().add(this.getEsbNode());
		proxyServiceContainerEClass.getESuperTypes().add(this.getEsbNode());
		mediatorFlowEClass.getESuperTypes().add(this.getEsbNode());
		endpointFlowEClass.getESuperTypes().add(this.getEsbNode());
		abstractEndPointEClass.getESuperTypes().add(this.getEndPoint());
		messageMediatorEClass.getESuperTypes().add(this.getEsbElement());
		messageInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		messageOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		defaultEndPointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		defaultEndPointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		defaultEndPointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		addressEndPointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		addressEndPointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		addressEndPointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		templateEndpointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		templateEndpointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		templateEndpointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		templateEndpointParameterEClass.getESuperTypes().add(this.getEsbNode());
		httpEndpointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		httpEndPointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		httpEndPointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		dropMediatorEClass.getESuperTypes().add(this.getMediator());
		dropMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		filterMediatorEClass.getESuperTypes().add(this.getMediator());
		filterContainerEClass.getESuperTypes().add(this.getEsbNode());
		filterPassContainerEClass.getESuperTypes().add(this.getEsbNode());
		filterFailContainerEClass.getESuperTypes().add(this.getEsbNode());
		filterMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		filterMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		filterMediatorPassOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		filterMediatorFailOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		mergeNodeEClass.getESuperTypes().add(this.getMediator());
		mergeNodeFirstInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		mergeNodeSecondInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		mergeNodeOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		logMediatorEClass.getESuperTypes().add(this.getMediator());
		logMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		logMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		logPropertyEClass.getESuperTypes().add(this.getAbstractNameValueExpressionProperty());
		publishEventMediatorEClass.getESuperTypes().add(this.getMediator());
		publishEventMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		publishEventMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		publishEventMediatorAttributeEClass.getESuperTypes().add(this.getAbstractNameValueExpressionAttribute());
		abstractNameValueExpressionAttributeEClass.getESuperTypes().add(this.getEsbNode());
		bamMediatorEClass.getESuperTypes().add(this.getMediator());
		bamMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		bamMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		beanMediatorEClass.getESuperTypes().add(this.getMediator());
		beanMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		beanMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		ejbMediatorEClass.getESuperTypes().add(this.getMediator());
		ejbMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		ejbMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		methodArgumentEClass.getESuperTypes().add(this.getAbstractNameValueExpressionProperty());
		propertyMediatorEClass.getESuperTypes().add(this.getMediator());
		propertyMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		propertyMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		namespacedPropertyEClass.getESuperTypes().add(this.getEsbNode());
		enrichMediatorEClass.getESuperTypes().add(this.getMediator());
		enrichMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		enrichMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		abstractNameValueExpressionPropertyEClass.getESuperTypes().add(this.getEsbNode());
		abstractBooleanFeatureEClass.getESuperTypes().add(this.getEsbNode());
		abstractLocationKeyResourceEClass.getESuperTypes().add(this.getEsbNode());
		xsltMediatorEClass.getESuperTypes().add(this.getMediator());
		xsltPropertyEClass.getESuperTypes().add(this.getAbstractNameValueExpressionProperty());
		xsltFeatureEClass.getESuperTypes().add(this.getAbstractBooleanFeature());
		xsltResourceEClass.getESuperTypes().add(this.getAbstractLocationKeyResource());
		xsltMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		xsltMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		switchMediatorEClass.getESuperTypes().add(this.getMediator());
		switchCaseBranchOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		switchDefaultBranchOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		switchMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		switchMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		switchMediatorContainerEClass.getESuperTypes().add(this.getEsbNode());
		switchCaseParentContainerEClass.getESuperTypes().add(this.getEsbNode());
		switchDefaultParentContainerEClass.getESuperTypes().add(this.getEsbNode());
		switchCaseContainerEClass.getESuperTypes().add(this.getEsbNode());
		switchDefaultContainerEClass.getESuperTypes().add(this.getEsbNode());
		esbSequenceEClass.getESuperTypes().add(this.getEsbNode());
		esbSequenceInputEClass.getESuperTypes().add(this.getEsbNode());
		esbSequenceOutputEClass.getESuperTypes().add(this.getEsbNode());
		esbSequenceInputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		esbSequenceOutputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		sequenceEClass.getESuperTypes().add(this.getMediator());
		sequenceInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		sequenceOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		eventMediatorEClass.getESuperTypes().add(this.getMediator());
		eventMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		eventMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		entitlementMediatorEClass.getESuperTypes().add(this.getMediator());
		entitlementMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		entitlementMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		entitlementMediatorOnRejectOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		entitlementMediatorOnAcceptOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		entitlementMediatorAdviceOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		entitlementMediatorObligationsOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		entitlementContainerEClass.getESuperTypes().add(this.getEsbNode());
		entitlementOnRejectContainerEClass.getESuperTypes().add(this.getEsbNode());
		entitlementOnAcceptContainerEClass.getESuperTypes().add(this.getEsbNode());
		entitlementAdviceContainerEClass.getESuperTypes().add(this.getEsbNode());
		entitlementObligationsContainerEClass.getESuperTypes().add(this.getEsbNode());
		enqueueMediatorEClass.getESuperTypes().add(this.getMediator());
		enqueueMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		enqueueMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		classMediatorEClass.getESuperTypes().add(this.getMediator());
		classMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		classMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		classPropertyEClass.getESuperTypes().add(this.getAbstractNameValueProperty());
		springMediatorEClass.getESuperTypes().add(this.getMediator());
		springMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		springMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		scriptMediatorEClass.getESuperTypes().add(this.getMediator());
		scriptMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		scriptMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		faultMediatorEClass.getESuperTypes().add(this.getMediator());
		faultMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		faultMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		aggregateMediatorEClass.getESuperTypes().add(this.getMediator());
		aggregateMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		aggregateMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		aggregateMediatorOnCompleteOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		routerMediatorEClass.getESuperTypes().add(this.getMediator());
		routerRouteEClass.getESuperTypes().add(this.getEsbNode());
		routerTargetEClass.getESuperTypes().add(this.getAbstractCommonTarget());
		routerMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		routerMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		routerMediatorTargetOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		routerMediatorContainerEClass.getESuperTypes().add(this.getEsbNode());
		routerTargetContainerEClass.getESuperTypes().add(this.getEsbNode());
		cloneMediatorEClass.getESuperTypes().add(this.getMediator());
		cloneTargetEClass.getESuperTypes().add(this.getAbstractCommonTarget());
		cloneMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		cloneMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		cloneMediatorTargetOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		cloneMediatorContainerEClass.getESuperTypes().add(this.getEsbNode());
		cloneTargetContainerEClass.getESuperTypes().add(this.getEsbNode());
		forEachMediatorEClass.getESuperTypes().add(this.getMediator());
		forEachMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		forEachMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		forEachMediatorTargetOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		forEachTargetEClass.getESuperTypes().add(this.getAbstractCommonTarget());
		iterateMediatorEClass.getESuperTypes().add(this.getMediator());
		iterateMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		iterateMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		iterateMediatorTargetOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		iterateTargetEClass.getESuperTypes().add(this.getAbstractCommonTarget());
		abstractCommonTargetEClass.getESuperTypes().add(this.getEsbNode());
		mediatorSequenceEClass.getESuperTypes().add(this.getEsbNode());
		cacheMediatorEClass.getESuperTypes().add(this.getMediator());
		cacheMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		cacheMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		cacheMediatorOnHitOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		xQueryMediatorEClass.getESuperTypes().add(this.getMediator());
		xQueryMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		xQueryMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		calloutMediatorEClass.getESuperTypes().add(this.getMediator());
		calloutMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		calloutMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		rmSequenceMediatorEClass.getESuperTypes().add(this.getMediator());
		rmSequenceMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		rmSequenceMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		transactionMediatorEClass.getESuperTypes().add(this.getMediator());
		transactionMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		transactionMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		oAuthMediatorEClass.getESuperTypes().add(this.getMediator());
		oAuthMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		oAuthMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		autoscaleInMediatorEClass.getESuperTypes().add(this.getMediator());
		autoscaleOutMediatorEClass.getESuperTypes().add(this.getMediator());
		headerMediatorEClass.getESuperTypes().add(this.getMediator());
		headerMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		headerMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		throttleMediatorEClass.getESuperTypes().add(this.getMediator());
		throttleMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		throttleMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		throttleMediatorOnAcceptOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		throttleMediatorOnRejectOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		throttleContainerEClass.getESuperTypes().add(this.getEsbNode());
		throttleOnAcceptContainerEClass.getESuperTypes().add(this.getEsbNode());
		throttleOnRejectContainerEClass.getESuperTypes().add(this.getEsbNode());
		commandMediatorEClass.getESuperTypes().add(this.getMediator());
		commandMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		commandMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		abstractSqlExecutorMediatorEClass.getESuperTypes().add(this.getMediator());
		dbLookupMediatorEClass.getESuperTypes().add(this.getAbstractSqlExecutorMediator());
		dbLookupMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		dbLookupMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		dbReportMediatorEClass.getESuperTypes().add(this.getAbstractSqlExecutorMediator());
		dbReportMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		dbReportMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		ruleMediatorEClass.getESuperTypes().add(this.getMediator());
		ruleMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		ruleMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		ruleMediatorChildMediatorsOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		ruleSetCreationPropertyEClass.getESuperTypes().add(this.getAbstractNameValueProperty());
		ruleSessionPropertyEClass.getESuperTypes().add(this.getAbstractNameValueProperty());
		callTemplateParameterEClass.getESuperTypes().add(this.getEsbNode());
		callTemplateMediatorEClass.getESuperTypes().add(this.getMediator());
		callTemplateMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		callTemplateMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		loopBackMediatorEClass.getESuperTypes().add(this.getMediator());
		loopBackMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		loopBackMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		respondMediatorEClass.getESuperTypes().add(this.getMediator());
		respondMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		respondMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		smooksMediatorEClass.getESuperTypes().add(this.getMediator());
		smooksMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		smooksMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		storeMediatorEClass.getESuperTypes().add(this.getMediator());
		storeMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		storeMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		builderMediatorEClass.getESuperTypes().add(this.getMediator());
		builderMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		builderMediatorOutputConectorEClass.getESuperTypes().add(this.getOutputConnector());
		messageBuilderEClass.getESuperTypes().add(this.getEsbNode());
		payloadFactoryMediatorEClass.getESuperTypes().add(this.getMediator());
		payloadFactoryMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		payloadFactoryMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		payloadFactoryArgumentEClass.getESuperTypes().add(this.getEsbNode());
		conditionalRouteBranchEClass.getESuperTypes().add(this.getEsbNode());
		conditionalRouterMediatorEClass.getESuperTypes().add(this.getMediator());
		conditionalRouterMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		conditionalRouterMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		conditionalRouterMediatorAdditionalOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		sendMediatorEClass.getESuperTypes().add(this.getMediator());
		sendContainerEClass.getESuperTypes().add(this.getEsbNode());
		sendMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		sendMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		sendMediatorEndpointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		failoverEndPointEClass.getESuperTypes().add(this.getParentEndPoint());
		failoverEndPointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		failoverEndPointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		failoverEndPointWestOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		parentEndPointEClass.getESuperTypes().add(this.getEndPoint());
		wsdlEndPointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		wsdlEndPointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		wsdlEndPointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		loadBalanceEndPointEClass.getESuperTypes().add(this.getParentEndPoint());
		loadBalanceEndPointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		loadBalanceEndPointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		loadBalanceEndPointWestOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		localEntryEClass.getESuperTypes().add(this.getEsbElement());
		sequencesEClass.getESuperTypes().add(this.getEsbElement());
		sequencesOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		sequencesInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		urlRewriteRuleActionEClass.getESuperTypes().add(this.getEsbNode());
		urlRewriteRuleEClass.getESuperTypes().add(this.getEsbNode());
		urlRewriteMediatorEClass.getESuperTypes().add(this.getMediator());
		urlRewriteMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		urlRewriteMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		evaluatorExpressionPropertyEClass.getESuperTypes().add(this.getEsbNode());
		validateMediatorEClass.getESuperTypes().add(this.getMediator());
		validateResourceEClass.getESuperTypes().add(this.getAbstractLocationKeyResource());
		validateFeatureEClass.getESuperTypes().add(this.getAbstractBooleanFeature());
		validateSchemaEClass.getESuperTypes().add(this.getEsbNode());
		validateMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		validateMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		validateMediatorOnFailOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		endpointDiagramEClass.getESuperTypes().add(this.getEsbElement());
		namedEndpointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		namedEndpointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		namedEndpointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		templateEClass.getESuperTypes().add(this.getEsbElement());
		taskEClass.getESuperTypes().add(this.getEsbElement());
		nameValueTypePropertyEClass.getESuperTypes().add(this.getEsbNode());
		taskPropertyEClass.getESuperTypes().add(this.getNameValueTypeProperty());
		synapseAPIEClass.getESuperTypes().add(this.getEsbElement());
		apiResourceEClass.getESuperTypes().add(this.getEsbNode());
		apiResourceInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		apiResourceOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		apiResourceOutSequenceOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		apiResourceInSequenceInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		apiResourceFaultInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		apiResourceEndpointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		apiResourceEndpointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		apiResourceEndpointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		complexEndpointsEClass.getESuperTypes().add(this.getEsbElement());
		complexEndpointsOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		addressingEndpointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		addressingEndpointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		addressingEndpointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		recipientListEndPointEClass.getESuperTypes().add(this.getParentEndPoint());
		recipientListEndPointInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		recipientListEndPointOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		recipientListEndPointWestOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		messageStoreParameterEClass.getESuperTypes().add(this.getEsbNode());
		messageStoreEClass.getESuperTypes().add(this.getEsbElement());
		messageProcessorParameterEClass.getESuperTypes().add(this.getEsbNode());
		messageProcessorEClass.getESuperTypes().add(this.getEsbElement());
		apiHandlerEClass.getESuperTypes().add(this.getEsbNode());
		apiHandlerPropertyEClass.getESuperTypes().add(this.getEsbNode());
		cloudConnectorEClass.getESuperTypes().add(this.getEsbElement());
		cloudConnectorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		cloudConnectorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		cloudConnectorOperationEClass.getESuperTypes().add(this.getMediator());
		cloudConnectorOperationInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		cloudConnectorOperationOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		dataMapperMediatorEClass.getESuperTypes().add(this.getMediator());
		dataMapperMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		dataMapperMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		fastXSLTMediatorEClass.getESuperTypes().add(this.getMediator());
		fastXSLTMediatorInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		fastXSLTMediatorOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		inboundEndpointEClass.getESuperTypes().add(this.getEsbElement());
		inboundEndpointContainerEClass.getESuperTypes().add(this.getEsbElement());
		inboundEndpointSequenceContainerEClass.getESuperTypes().add(this.getEsbNode());
		inboundEndpointOnErrorSequenceContainerEClass.getESuperTypes().add(this.getEsbNode());
		inboundEndpointSequenceInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		inboundEndpointSequenceOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		inboundEndpointOnErrorSequenceOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		inboundEndpointOnErrorSequenceInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		commentMediatorEClass.getESuperTypes().add(this.getMediator());

		// Initialize classes and features; add operations and parameters
		initEClass(esbDiagramEClass, EsbDiagram.class, "EsbDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEsbDiagram_Server(), this.getEsbServer(), null, "server", null, 0, 1, EsbDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEsbDiagram_Test(), ecorePackage.getEIntegerObject(), "Test", null, 0, 1, EsbDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esbNodeEClass, EsbNode.class, "EsbNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(esbElementEClass, EsbElement.class, "EsbElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEsbElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, EsbElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEsbElement_CommentsList(), ecorePackage.getEString(), "commentsList", null, 0, -1, EsbElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esbServerEClass, EsbServer.class, "EsbServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEsbServer_Children(), this.getEsbElement(), null, "children", null, 0, -1, EsbServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEsbServer_MessageMediator(), this.getMessageMediator(), null, "messageMediator", null, 0, 1, EsbServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEsbServer_Type(), this.getArtifactType(), "type", null, 0, 1, EsbServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediatorEClass, Mediator.class, "Mediator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediator_Reverse(), ecorePackage.getEBoolean(), "Reverse", "false", 0, 1, Mediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esbConnectorEClass, EsbConnector.class, "EsbConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputConnectorEClass, InputConnector.class, "InputConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputConnector_IncomingLinks(), this.getEsbLink(), this.getEsbLink_Target(), "incomingLinks", null, 0, -1, InputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(inputConnectorEClass, ecorePackage.getEBoolean(), "shouldConnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOutputConnector(), "sourceEnd", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(outputConnectorEClass, OutputConnector.class, "OutputConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputConnector_OutgoingLink(), this.getEsbLink(), this.getEsbLink_Source(), "outgoingLink", null, 0, 1, OutputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputConnector_CommentMediators(), this.getCommentMediator(), null, "commentMediators", null, 0, -1, OutputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(outputConnectorEClass, ecorePackage.getEBoolean(), "shouldConnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInputConnector(), "targetEnd", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(additionalOutputConnectorEClass, AdditionalOutputConnector.class, "AdditionalOutputConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdditionalOutputConnector_AdditionalOutgoingLink(), this.getEsbLink(), null, "additionalOutgoingLink", null, 0, 1, AdditionalOutputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(additionalOutputConnectorEClass, ecorePackage.getEBoolean(), "shouldConnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInputConnector(), "targetEnd", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(esbLinkEClass, EsbLink.class, "EsbLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEsbLink_Source(), this.getOutputConnector(), this.getOutputConnector_OutgoingLink(), "source", null, 0, 1, EsbLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEsbLink_Target(), this.getInputConnector(), this.getInputConnector_IncomingLinks(), "target", null, 0, 1, EsbLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endPointEClass, EndPoint.class, "EndPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEndPoint_EndPointName(), ecorePackage.getEString(), "endPointName", null, 0, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndPoint_Anonymous(), ecorePackage.getEBoolean(), "anonymous", "false", 0, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndPoint_InLine(), ecorePackage.getEBoolean(), "InLine", "false", 0, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndPoint_Duplicate(), ecorePackage.getEBoolean(), "duplicate", null, 0, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_Properties(), this.getEndPointProperty(), null, "properties", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndPoint_Reversed(), ecorePackage.getEBoolean(), "reversed", "false", 0, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callMediatorEClass, CallMediator.class, "CallMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallMediator_InputConnector(), this.getCallMediatorInputConnector(), null, "inputConnector", null, 0, 1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallMediator_OutputConnector(), this.getCallMediatorOutputConnector(), null, "outputConnector", null, 0, 1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallMediator_Endpoint(), this.getEndPoint(), null, "endpoint", null, 0, -1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallMediator_EndpointOutputConnector(), this.getCallMediatorEndpointOutputConnector(), null, "endpointOutputConnector", null, 0, 1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCallMediator_EndpointType(), this.getCallMediatorEndpointType(), "endpointType", null, 0, 1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCallMediator_EnableBlockingCalls(), ecorePackage.getEBoolean(), "enableBlockingCalls", "false", 0, 1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallMediator_EndpointRegistrykey(), this.getRegistryKeyProperty(), null, "endpointRegistrykey", null, 0, 1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallMediator_EndpointXpath(), this.getNamespacedProperty(), null, "endpointXpath", null, 0, 1, CallMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callMediatorInputConnectorEClass, CallMediatorInputConnector.class, "CallMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callMediatorOutputConnectorEClass, CallMediatorOutputConnector.class, "CallMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callMediatorEndpointOutputConnectorEClass, CallMediatorEndpointOutputConnector.class, "CallMediatorEndpointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endPointPropertyEClass, EndPointProperty.class, "EndPointProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEndPointProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, EndPointProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndPointProperty_Value(), ecorePackage.getEString(), "value", null, 1, 1, EndPointProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndPointProperty_Scope(), this.getEndPointPropertyScope(), "scope", null, 1, 1, EndPointProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndPointProperty_ValueType(), this.getPropertyValueType(), "valueType", null, 0, 1, EndPointProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPointProperty_ValueExpression(), this.getNamespacedProperty(), null, "valueExpression", null, 0, 1, EndPointProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyServiceEClass, ProxyService.class, "ProxyService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProxyService_OutputConnector(), this.getProxyOutputConnector(), null, "outputConnector", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_InputConnector(), this.getProxyInputConnector(), null, "inputConnector", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_FaultInputConnector(), this.getProxyFaultInputConnector(), null, "faultInputConnector", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_OutSequenceOutputConnector(), this.getProxyOutSequenceOutputConnector(), null, "outSequenceOutputConnector", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_InSequenceInputConnectors(), this.getProxyInSequenceInputConnector(), null, "inSequenceInputConnectors", null, 0, -1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_Name(), ecorePackage.getEString(), "name", "proxy1", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_PinnedServers(), ecorePackage.getEString(), "pinnedServers", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_ServiceGroup(), ecorePackage.getEString(), "serviceGroup", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_TraceEnabled(), ecorePackage.getEBoolean(), "traceEnabled", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_StatisticsEnabled(), ecorePackage.getEBoolean(), "statisticsEnabled", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_StartOnLoad(), ecorePackage.getEBoolean(), "startOnLoad", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_Transports(), ecorePackage.getEString(), "transports", "https,http", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_ReliableMessagingEnabled(), ecorePackage.getEBoolean(), "reliableMessagingEnabled", "false", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_SecurityEnabled(), ecorePackage.getEBoolean(), "securityEnabled", "false", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_ServiceParameters(), this.getProxyServiceParameter(), null, "serviceParameters", null, 0, -1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_ServicePolicies(), this.getProxyServicePolicy(), null, "servicePolicies", null, 0, -1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_Container(), this.getProxyServiceContainer(), null, "container", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_InSequenceType(), this.getSequenceType(), "inSequenceType", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_InSequenceKey(), this.getRegistryKeyProperty(), null, "inSequenceKey", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_InSequenceName(), ecorePackage.getEString(), "inSequenceName", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_InSequenceOnError(), this.getRegistryKeyProperty(), null, "inSequenceOnError", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_OutSequenceType(), this.getSequenceType(), "outSequenceType", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_OutSequenceKey(), this.getRegistryKeyProperty(), null, "outSequenceKey", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_OutSequenceName(), ecorePackage.getEString(), "outSequenceName", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_OutSequenceOnError(), this.getRegistryKeyProperty(), null, "outSequenceOnError", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_FaultSequenceType(), this.getSequenceType(), "faultSequenceType", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_FaultSequenceKey(), this.getRegistryKeyProperty(), null, "faultSequenceKey", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_FaultSequenceName(), ecorePackage.getEString(), "faultSequenceName", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_FaultSequenceOnError(), this.getRegistryKeyProperty(), null, "faultSequenceOnError", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_EndpointType(), this.getSequenceType(), "endpointType", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_EndpointKey(), this.getRegistryKeyProperty(), null, "endpointKey", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_EndpointName(), ecorePackage.getEString(), "endpointName", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_MainSequence(), ecorePackage.getEBoolean(), "mainSequence", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_WsdlType(), this.getProxyWsdlType(), "wsdlType", "NONE", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_WsdlXML(), ecorePackage.getEString(), "wsdlXML", "<definitions/>", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_WsdlURL(), ecorePackage.getEString(), "wsdlURL", "http://default/wsdl/url", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_WsdlKey(), this.getRegistryKeyProperty(), null, "wsdlKey", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_WsdlEndpoint(), this.getRegistryKeyProperty(), null, "wsdlEndpoint", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_WsdlResources(), this.getProxyWSDLResource(), null, "wsdlResources", null, 0, -1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_OnError(), this.getRegistryKeyProperty(), null, "OnError", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyOutputConnectorEClass, ProxyOutputConnector.class, "ProxyOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyInputConnectorEClass, ProxyInputConnector.class, "ProxyInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyOutSequenceOutputConnectorEClass, ProxyOutSequenceOutputConnector.class, "ProxyOutSequenceOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyInSequenceInputConnectorEClass, ProxyInSequenceInputConnector.class, "ProxyInSequenceInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyWSDLResourceEClass, ProxyWSDLResource.class, "ProxyWSDLResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyFaultInputConnectorEClass, ProxyFaultInputConnector.class, "ProxyFaultInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyServiceParameterEClass, ProxyServiceParameter.class, "ProxyServiceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProxyServiceParameter_Name(), ecorePackage.getEString(), "name", "parameter_name", 0, 1, ProxyServiceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyServiceParameter_Value(), ecorePackage.getEString(), "value", "parameter_value", 0, 1, ProxyServiceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyServicePolicyEClass, ProxyServicePolicy.class, "ProxyServicePolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProxyServicePolicy_PolicyKey(), this.getRegistryKeyProperty(), null, "policyKey", null, 0, 1, ProxyServicePolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyServiceSequenceAndEndpointContainerEClass, ProxyServiceSequenceAndEndpointContainer.class, "ProxyServiceSequenceAndEndpointContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProxyServiceSequenceAndEndpointContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, ProxyServiceSequenceAndEndpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyServiceFaultContainerEClass, ProxyServiceFaultContainer.class, "ProxyServiceFaultContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProxyServiceFaultContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, ProxyServiceFaultContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyServiceContainerEClass, ProxyServiceContainer.class, "ProxyServiceContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProxyServiceContainer_SequenceAndEndpointContainer(), this.getProxyServiceSequenceAndEndpointContainer(), null, "sequenceAndEndpointContainer", null, 0, 1, ProxyServiceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyServiceContainer_FaultContainer(), this.getProxyServiceFaultContainer(), null, "faultContainer", null, 0, 1, ProxyServiceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediatorFlowEClass, MediatorFlow.class, "MediatorFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMediatorFlow_Children(), this.getEsbElement(), null, "children", null, 0, -1, MediatorFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endpointFlowEClass, EndpointFlow.class, "EndpointFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndpointFlow_Children(), this.getEsbElement(), null, "children", null, 0, -1, EndpointFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractEndPointEClass, AbstractEndPoint.class, "AbstractEndPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractEndPoint_ReliableMessagingEnabled(), ecorePackage.getEBoolean(), "reliableMessagingEnabled", "false", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SecurityEnabled(), ecorePackage.getEBoolean(), "securityEnabled", "false", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_AddressingEnabled(), ecorePackage.getEBoolean(), "addressingEnabled", "false", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_AddressingVersion(), this.getEndPointAddressingVersion(), "addressingVersion", "final", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_AddressingSeparateListener(), ecorePackage.getEBoolean(), "addressingSeparateListener", "false", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_TimeOutDuration(), ecorePackage.getELong(), "timeOutDuration", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_TimeOutAction(), this.getEndPointTimeOutAction(), "timeOutAction", "never", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_RetryErrorCodes(), ecorePackage.getEString(), "retryErrorCodes", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_RetryCount(), ecorePackage.getEInt(), "retryCount", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_RetryDelay(), ecorePackage.getELong(), "retryDelay", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SuspendErrorCodes(), ecorePackage.getEString(), "suspendErrorCodes", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SuspendInitialDuration(), ecorePackage.getELong(), "suspendInitialDuration", "-1", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SuspendMaximumDuration(), ecorePackage.getELong(), "suspendMaximumDuration", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SuspendProgressionFactor(), ecorePackage.getEFloat(), "suspendProgressionFactor", "-1", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractEndPoint_ReliableMessagingPolicy(), this.getRegistryKeyProperty(), null, "reliableMessagingPolicy", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractEndPoint_SecurityPolicy(), this.getRegistryKeyProperty(), null, "securityPolicy", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_Format(), this.getEndPointMessageFormat(), "format", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_Optimize(), this.getEndPointAttachmentOptimization(), "optimize", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractEndPoint_TemplateParameters(), this.getTemplateParameter(), null, "templateParameters", null, 0, -1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_StatisticsEnabled(), ecorePackage.getEBoolean(), "statisticsEnabled", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_TraceEnabled(), ecorePackage.getEBoolean(), "traceEnabled", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractEndPoint_InboundPolicy(), this.getRegistryKeyProperty(), null, "inboundPolicy", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractEndPoint_OutboundPolicy(), this.getRegistryKeyProperty(), null, "outboundPolicy", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageMediatorEClass, MessageMediator.class, "MessageMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageMediator_InputConnector(), this.getMessageInputConnector(), null, "inputConnector", null, 0, 1, MessageMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageMediator_OutputConnector(), this.getMessageOutputConnector(), null, "outputConnector", null, 0, 1, MessageMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageInputConnectorEClass, MessageInputConnector.class, "MessageInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(messageOutputConnectorEClass, MessageOutputConnector.class, "MessageOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultEndPointEClass, DefaultEndPoint.class, "DefaultEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefaultEndPoint_InputConnector(), this.getDefaultEndPointInputConnector(), null, "inputConnector", null, 0, 1, DefaultEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultEndPoint_OutputConnector(), this.getDefaultEndPointOutputConnector(), null, "outputConnector", null, 0, 1, DefaultEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultEndPointInputConnectorEClass, DefaultEndPointInputConnector.class, "DefaultEndPointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultEndPointOutputConnectorEClass, DefaultEndPointOutputConnector.class, "DefaultEndPointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressEndPointEClass, AddressEndPoint.class, "AddressEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddressEndPoint_InputConnector(), this.getAddressEndPointInputConnector(), null, "inputConnector", null, 0, 1, AddressEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddressEndPoint_OutputConnector(), this.getAddressEndPointOutputConnector(), null, "outputConnector", null, 0, 1, AddressEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddressEndPoint_URI(), ecorePackage.getEString(), "URI", "http://www.example.org/service", 0, 1, AddressEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addressEndPointInputConnectorEClass, AddressEndPointInputConnector.class, "AddressEndPointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressEndPointOutputConnectorEClass, AddressEndPointOutputConnector.class, "AddressEndPointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateEndpointEClass, TemplateEndpoint.class, "TemplateEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateEndpoint_InputConnector(), this.getTemplateEndpointInputConnector(), null, "inputConnector", null, 0, 1, TemplateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplateEndpoint_OutputConnector(), this.getTemplateEndpointOutputConnector(), null, "outputConnector", null, 0, 1, TemplateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplateEndpoint_Address(), ecorePackage.getEString(), "address", null, 0, 1, TemplateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplateEndpoint_TargetTemplate(), ecorePackage.getEString(), "targetTemplate", null, 0, 1, TemplateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplateEndpoint_Parameters(), this.getTemplateEndpointParameter(), null, "parameters", null, 0, -1, TemplateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplateEndpoint_AvailableTemplates(), ecorePackage.getEString(), "availableTemplates", null, 0, 1, TemplateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateEndpointInputConnectorEClass, TemplateEndpointInputConnector.class, "TemplateEndpointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateEndpointOutputConnectorEClass, TemplateEndpointOutputConnector.class, "TemplateEndpointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateEndpointParameterEClass, TemplateEndpointParameter.class, "TemplateEndpointParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemplateEndpointParameter_ParameterName(), ecorePackage.getEString(), "parameterName", null, 0, 1, TemplateEndpointParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplateEndpointParameter_ParameterValue(), ecorePackage.getEString(), "parameterValue", null, 0, 1, TemplateEndpointParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(httpEndpointEClass, HTTPEndpoint.class, "HTTPEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHTTPEndpoint_InputConnector(), this.getHTTPEndPointInputConnector(), null, "inputConnector", null, 0, 1, HTTPEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHTTPEndpoint_OutputConnector(), this.getHTTPEndPointOutputConnector(), null, "outputConnector", null, 0, 1, HTTPEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHTTPEndpoint_URITemplate(), ecorePackage.getEString(), "URITemplate", null, 0, 1, HTTPEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHTTPEndpoint_HttpMethod(), this.getHttpMethodType(), "HttpMethod", null, 0, 1, HTTPEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(httpEndPointInputConnectorEClass, HTTPEndPointInputConnector.class, "HTTPEndPointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(httpEndPointOutputConnectorEClass, HTTPEndPointOutputConnector.class, "HTTPEndPointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dropMediatorEClass, DropMediator.class, "DropMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDropMediator_InputConnector(), this.getDropMediatorInputConnector(), null, "inputConnector", null, 0, 1, DropMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dropMediatorInputConnectorEClass, DropMediatorInputConnector.class, "DropMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterMediatorEClass, FilterMediator.class, "FilterMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFilterMediator_ConditionType(), this.getFilterMediatorConditionType(), "conditionType", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterMediator_Regex(), ecorePackage.getEString(), "regex", "default_regex", 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_InputConnector(), this.getFilterMediatorInputConnector(), null, "inputConnector", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_OutputConnector(), this.getFilterMediatorOutputConnector(), null, "outputConnector", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_PassOutputConnector(), this.getFilterMediatorPassOutputConnector(), null, "passOutputConnector", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_FailOutputConnector(), this.getFilterMediatorFailOutputConnector(), null, "failOutputConnector", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_Xpath(), this.getNamespacedProperty(), null, "xpath", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_Source(), this.getNamespacedProperty(), null, "source", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_FilterContainer(), this.getFilterContainer(), null, "filterContainer", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterContainerEClass, FilterContainer.class, "FilterContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilterContainer_PassContainer(), this.getFilterPassContainer(), null, "passContainer", null, 0, 1, FilterContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterContainer_FailContainer(), this.getFilterFailContainer(), null, "failContainer", null, 0, 1, FilterContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterPassContainerEClass, FilterPassContainer.class, "FilterPassContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilterPassContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, FilterPassContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterFailContainerEClass, FilterFailContainer.class, "FilterFailContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilterFailContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, FilterFailContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterMediatorInputConnectorEClass, FilterMediatorInputConnector.class, "FilterMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterMediatorOutputConnectorEClass, FilterMediatorOutputConnector.class, "FilterMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterMediatorPassOutputConnectorEClass, FilterMediatorPassOutputConnector.class, "FilterMediatorPassOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterMediatorFailOutputConnectorEClass, FilterMediatorFailOutputConnector.class, "FilterMediatorFailOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mergeNodeEClass, MergeNode.class, "MergeNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMergeNode_FirstInputConnector(), this.getMergeNodeFirstInputConnector(), null, "firstInputConnector", null, 0, 1, MergeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMergeNode_SecondInputConnector(), this.getMergeNodeSecondInputConnector(), null, "secondInputConnector", null, 0, 1, MergeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMergeNode_OutputConnector(), this.getMergeNodeOutputConnector(), null, "outputConnector", null, 0, 1, MergeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mergeNodeFirstInputConnectorEClass, MergeNodeFirstInputConnector.class, "MergeNodeFirstInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mergeNodeSecondInputConnectorEClass, MergeNodeSecondInputConnector.class, "MergeNodeSecondInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mergeNodeOutputConnectorEClass, MergeNodeOutputConnector.class, "MergeNodeOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logMediatorEClass, LogMediator.class, "LogMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogMediator_LogCategory(), this.getLogCategory(), "logCategory", "INFO", 0, 1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMediator_LogLevel(), this.getLogLevel(), "logLevel", null, 0, 1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMediator_LogSeparator(), ecorePackage.getEString(), "logSeparator", null, 0, 1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogMediator_InputConnector(), this.getLogMediatorInputConnector(), null, "inputConnector", null, 0, 1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogMediator_OutputConnector(), this.getLogMediatorOutputConnector(), null, "outputConnector", null, 0, 1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogMediator_Properties(), this.getLogProperty(), null, "properties", null, 0, -1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logMediatorInputConnectorEClass, LogMediatorInputConnector.class, "LogMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logMediatorOutputConnectorEClass, LogMediatorOutputConnector.class, "LogMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logPropertyEClass, LogProperty.class, "LogProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(publishEventMediatorEClass, PublishEventMediator.class, "PublishEventMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPublishEventMediator_InputConnector(), this.getPublishEventMediatorInputConnector(), null, "inputConnector", null, 0, 1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPublishEventMediator_Outputconnector(), this.getPublishEventMediatorOutputConnector(), null, "outputconnector", null, 0, 1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPublishEventMediator_StreamName(), ecorePackage.getEString(), "streamName", null, 0, 1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPublishEventMediator_StreamVersion(), ecorePackage.getEString(), "streamVersion", null, 0, 1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPublishEventMediator_EventSink(), ecorePackage.getEString(), "eventSink", null, 0, 1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPublishEventMediator_MetaAttributes(), this.getPublishEventMediatorAttribute(), null, "metaAttributes", null, 0, -1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPublishEventMediator_CorrelationAttributes(), this.getPublishEventMediatorAttribute(), null, "correlationAttributes", null, 0, -1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPublishEventMediator_PayloadAttributes(), this.getPublishEventMediatorAttribute(), null, "payloadAttributes", null, 0, -1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPublishEventMediator_ArbitraryAttributes(), this.getPublishEventMediatorAttribute(), null, "arbitraryAttributes", null, 0, -1, PublishEventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(publishEventMediatorInputConnectorEClass, PublishEventMediatorInputConnector.class, "PublishEventMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(publishEventMediatorOutputConnectorEClass, PublishEventMediatorOutputConnector.class, "PublishEventMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(publishEventMediatorAttributeEClass, PublishEventMediatorAttribute.class, "PublishEventMediatorAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPublishEventMediatorAttribute_DefaultValue(), ecorePackage.getEString(), "defaultValue", "", 0, 1, PublishEventMediatorAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractNameValueExpressionAttributeEClass, AbstractNameValueExpressionAttribute.class, "AbstractNameValueExpressionAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractNameValueExpressionAttribute_AttributeName(), ecorePackage.getEString(), "attributeName", "attribute_name", 0, 1, AbstractNameValueExpressionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueExpressionAttribute_AttributeValueType(), this.getAttributeValueType(), "attributeValueType", null, 0, 1, AbstractNameValueExpressionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueExpressionAttribute_AttributeValue(), ecorePackage.getEString(), "attributeValue", "attribute_value", 0, 1, AbstractNameValueExpressionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueExpressionAttribute_AttributeType(), this.getAttributeType(), "attributeType", null, 0, 1, AbstractNameValueExpressionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractNameValueExpressionAttribute_AttributeExpression(), this.getNamespacedProperty(), null, "attributeExpression", null, 0, 1, AbstractNameValueExpressionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bamMediatorEClass, BAMMediator.class, "BAMMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBAMMediator_InputConnector(), this.getBAMMediatorInputConnector(), null, "inputConnector", null, 0, 1, BAMMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBAMMediator_OutputConnector(), this.getBAMMediatorOutputConnector(), null, "outputConnector", null, 0, 1, BAMMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBAMMediator_ServerProfile(), ecorePackage.getEString(), "serverProfile", null, 0, 1, BAMMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBAMMediator_StreamName(), ecorePackage.getEString(), "streamName", null, 0, 1, BAMMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBAMMediator_StreamVersion(), ecorePackage.getEString(), "streamVersion", null, 0, 1, BAMMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bamMediatorInputConnectorEClass, BAMMediatorInputConnector.class, "BAMMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bamMediatorOutputConnectorEClass, BAMMediatorOutputConnector.class, "BAMMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beanMediatorEClass, BeanMediator.class, "BeanMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBeanMediator_InputConnector(), this.getBeanMediatorInputConnector(), null, "inputConnector", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBeanMediator_OutputConnector(), this.getBeanMediatorOutputConnector(), null, "outputConnector", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanMediator_Class(), ecorePackage.getEString(), "class", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanMediator_Action(), this.getBeanMediatorAction(), "action", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanMediator_Var(), ecorePackage.getEString(), "var", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanMediator_Property(), ecorePackage.getEString(), "property", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanMediator_ValueType(), this.getPropertyValueType(), "valueType", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanMediator_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBeanMediator_ValueExpression(), this.getNamespacedProperty(), null, "valueExpression", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanMediator_TargetType(), this.getPropertyValueType(), "targetType", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanMediator_TargetLiteral(), ecorePackage.getEString(), "targetLiteral", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBeanMediator_TargetExpression(), this.getNamespacedProperty(), null, "targetExpression", null, 0, 1, BeanMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(beanMediatorInputConnectorEClass, BeanMediatorInputConnector.class, "BeanMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beanMediatorOutputConnectorEClass, BeanMediatorOutputConnector.class, "BeanMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ejbMediatorEClass, EJBMediator.class, "EJBMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEJBMediator_InputConnector(), this.getEJBMediatorInputConnector(), null, "inputConnector", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEJBMediator_OutputConnector(), this.getEJBMediatorOutputConnector(), null, "outputConnector", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEJBMediator_Beanstalk(), ecorePackage.getEString(), "beanstalk", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEJBMediator_Class(), ecorePackage.getEString(), "class", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEJBMediator_Method(), ecorePackage.getEString(), "method", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEJBMediator_SessionIdType(), this.getPropertyValueType(), "sessionIdType", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEJBMediator_SessionIdLiteral(), ecorePackage.getEString(), "sessionIdLiteral", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEJBMediator_SessionIdExpression(), this.getNamespacedProperty(), null, "sessionIdExpression", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEJBMediator_Remove(), ecorePackage.getEBoolean(), "remove", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEJBMediator_Target(), ecorePackage.getEString(), "target", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEJBMediator_JNDIName(), ecorePackage.getEString(), "JNDIName", null, 0, 1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEJBMediator_MethodArguments(), this.getMethodArgument(), null, "methodArguments", null, 0, -1, EJBMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ejbMediatorInputConnectorEClass, EJBMediatorInputConnector.class, "EJBMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ejbMediatorOutputConnectorEClass, EJBMediatorOutputConnector.class, "EJBMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(methodArgumentEClass, MethodArgument.class, "MethodArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(registryKeyPropertyEClass, RegistryKeyProperty.class, "RegistryKeyProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegistryKeyProperty_PrettyName(), ecorePackage.getEString(), "prettyName", "Registry Key", 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegistryKeyProperty_KeyName(), ecorePackage.getEString(), "keyName", "keyName", 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegistryKeyProperty_KeyValue(), ecorePackage.getEString(), "keyValue", null, 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getMap());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getRegistryKeyProperty_Filters(), g1, "filters", null, 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyMediatorEClass, PropertyMediator.class, "PropertyMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyMediator_InputConnector(), this.getPropertyMediatorInputConnector(), null, "inputConnector", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyMediator_OutputConnector(), this.getPropertyMediatorOutputConnector(), null, "outputConnector", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_PropertyName(), this.getPropertyName(), "propertyName", "New Property...", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_PropertyDataType(), this.getPropertyDataType(), "propertyDataType", "STRING", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_PropertyAction(), this.getPropertyAction(), "propertyAction", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_PropertyScope(), this.getPropertyScope(), "propertyScope", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_ValueType(), this.getPropertyValueType(), "valueType", "LITERAL", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_Value(), ecorePackage.getEString(), "value", "value", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_NamespacePrefix(), ecorePackage.getEString(), "namespacePrefix", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyMediator_ValueExpression(), this.getNamespacedProperty(), null, "valueExpression", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_Boolean(), ecorePackage.getEBoolean(), "boolean", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_OM(), ecorePackage.getEString(), "OM", "<value/>", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_ValueStringPattern(), ecorePackage.getEString(), "valueStringPattern", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_ValueStringCapturingGroup(), ecorePackage.getEInt(), "valueStringCapturingGroup", "0", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_NewPropertyName(), ecorePackage.getEString(), "newPropertyName", "", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyMediatorInputConnectorEClass, PropertyMediatorInputConnector.class, "PropertyMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyMediatorOutputConnectorEClass, PropertyMediatorOutputConnector.class, "PropertyMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namespacedPropertyEClass, NamespacedProperty.class, "NamespacedProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamespacedProperty_PrettyName(), ecorePackage.getEString(), "prettyName", "Namespaced Property", 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamespacedProperty_PropertyName(), ecorePackage.getEString(), "propertyName", "propertyName", 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamespacedProperty_PropertyValue(), ecorePackage.getEString(), "propertyValue", null, 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getNamespacedProperty_Namespaces(), g1, "namespaces", null, 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamespacedProperty_SupportsDynamicXPaths(), ecorePackage.getEBoolean(), "supportsDynamicXPaths", null, 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamespacedProperty_Dynamic(), ecorePackage.getEBoolean(), "dynamic", null, 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enrichMediatorEClass, EnrichMediator.class, "EnrichMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnrichMediator_CloneSource(), ecorePackage.getEBoolean(), "cloneSource", "false", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_SourceType(), this.getEnrichSourceType(), "sourceType", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnrichMediator_SourceXpath(), this.getNamespacedProperty(), null, "sourceXpath", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_SourceProperty(), ecorePackage.getEString(), "sourceProperty", "source_property", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_SourceXML(), ecorePackage.getEString(), "sourceXML", "<inline/>", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_TargetAction(), this.getEnrichTargetAction(), "targetAction", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_TargetType(), this.getEnrichTargetType(), "targetType", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnrichMediator_TargetXpath(), this.getNamespacedProperty(), null, "targetXpath", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_TargetProperty(), ecorePackage.getEString(), "targetProperty", "target_property", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_InlineType(), this.getEnrichSourceInlineType(), "inlineType", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnrichMediator_InlineRegistryKey(), this.getRegistryKeyProperty(), null, "inlineRegistryKey", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnrichMediator_InputConnector(), this.getEnrichMediatorInputConnector(), null, "inputConnector", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnrichMediator_OutputConnector(), this.getEnrichMediatorOutputConnector(), null, "outputConnector", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enrichMediatorInputConnectorEClass, EnrichMediatorInputConnector.class, "EnrichMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enrichMediatorOutputConnectorEClass, EnrichMediatorOutputConnector.class, "EnrichMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractNameValueExpressionPropertyEClass, AbstractNameValueExpressionProperty.class, "AbstractNameValueExpressionProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractNameValueExpressionProperty_PropertyName(), ecorePackage.getEString(), "propertyName", "property_name", 0, 1, AbstractNameValueExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueExpressionProperty_PropertyValueType(), this.getPropertyValueType(), "propertyValueType", null, 0, 1, AbstractNameValueExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueExpressionProperty_PropertyValue(), ecorePackage.getEString(), "propertyValue", "property_value", 0, 1, AbstractNameValueExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractNameValueExpressionProperty_PropertyExpression(), this.getNamespacedProperty(), null, "propertyExpression", null, 0, 1, AbstractNameValueExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractBooleanFeatureEClass, AbstractBooleanFeature.class, "AbstractBooleanFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractBooleanFeature_FeatureName(), ecorePackage.getEString(), "featureName", "feature_name", 0, 1, AbstractBooleanFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractBooleanFeature_FeatureEnabled(), ecorePackage.getEBoolean(), "featureEnabled", "true", 0, 1, AbstractBooleanFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractLocationKeyResourceEClass, AbstractLocationKeyResource.class, "AbstractLocationKeyResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractLocationKeyResource_Location(), ecorePackage.getEString(), "location", "default_location", 0, 1, AbstractLocationKeyResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractLocationKeyResource_Key(), this.getRegistryKeyProperty(), null, "key", null, 0, 1, AbstractLocationKeyResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xsltMediatorEClass, XSLTMediator.class, "XSLTMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXSLTMediator_InputConnector(), this.getXSLTMediatorInputConnector(), null, "inputConnector", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_OutputConnector(), this.getXSLTMediatorOutputConnector(), null, "outputConnector", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXSLTMediator_XsltSchemaKeyType(), this.getKeyType(), "xsltSchemaKeyType", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_XsltStaticSchemaKey(), this.getRegistryKeyProperty(), null, "xsltStaticSchemaKey", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_XsltDynamicSchemaKey(), this.getNamespacedProperty(), null, "xsltDynamicSchemaKey", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_XsltKey(), this.getRegistryKeyProperty(), null, "xsltKey", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_SourceXPath(), this.getNamespacedProperty(), null, "sourceXPath", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_Properties(), this.getXSLTProperty(), null, "properties", null, 0, -1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_Features(), this.getXSLTFeature(), null, "features", null, 0, -1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_Resources(), this.getXSLTResource(), null, "resources", null, 0, -1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xsltPropertyEClass, XSLTProperty.class, "XSLTProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xsltFeatureEClass, XSLTFeature.class, "XSLTFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xsltResourceEClass, XSLTResource.class, "XSLTResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xsltMediatorInputConnectorEClass, XSLTMediatorInputConnector.class, "XSLTMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xsltMediatorOutputConnectorEClass, XSLTMediatorOutputConnector.class, "XSLTMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(switchMediatorEClass, SwitchMediator.class, "SwitchMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchMediator_SourceXpath(), this.getNamespacedProperty(), null, "sourceXpath", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwitchMediator_Source(), ecorePackage.getEString(), "source", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwitchMediator_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwitchMediator_NamespacePrefix(), ecorePackage.getEString(), "namespacePrefix", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchMediator_CaseBranches(), this.getSwitchCaseBranchOutputConnector(), null, "caseBranches", null, 0, -1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchMediator_DefaultBranch(), this.getSwitchDefaultBranchOutputConnector(), null, "defaultBranch", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchMediator_InputConnector(), this.getSwitchMediatorInputConnector(), null, "inputConnector", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchMediator_OutputConnector(), this.getSwitchMediatorOutputConnector(), null, "outputConnector", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchMediator_SwitchContainer(), this.getSwitchMediatorContainer(), null, "switchContainer", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchCaseBranchOutputConnectorEClass, SwitchCaseBranchOutputConnector.class, "SwitchCaseBranchOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwitchCaseBranchOutputConnector_CaseRegex(), ecorePackage.getEString(), "caseRegex", ".*+", 0, 1, SwitchCaseBranchOutputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchDefaultBranchOutputConnectorEClass, SwitchDefaultBranchOutputConnector.class, "SwitchDefaultBranchOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(switchMediatorInputConnectorEClass, SwitchMediatorInputConnector.class, "SwitchMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(switchMediatorOutputConnectorEClass, SwitchMediatorOutputConnector.class, "SwitchMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(switchMediatorContainerEClass, SwitchMediatorContainer.class, "SwitchMediatorContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchMediatorContainer_SwitchCaseParentContainer(), this.getSwitchCaseParentContainer(), null, "switchCaseParentContainer", null, 0, 1, SwitchMediatorContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchMediatorContainer_SwitchDefaultParentContainer(), this.getSwitchDefaultParentContainer(), null, "switchDefaultParentContainer", null, 0, 1, SwitchMediatorContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchCaseParentContainerEClass, SwitchCaseParentContainer.class, "SwitchCaseParentContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchCaseParentContainer_SwitchCaseContainer(), this.getSwitchCaseContainer(), null, "switchCaseContainer", null, 1, -1, SwitchCaseParentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchDefaultParentContainerEClass, SwitchDefaultParentContainer.class, "SwitchDefaultParentContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchDefaultParentContainer_SwitchDefaultContainer(), this.getSwitchDefaultContainer(), null, "switchDefaultContainer", null, 0, 1, SwitchDefaultParentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchCaseContainerEClass, SwitchCaseContainer.class, "SwitchCaseContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchCaseContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, SwitchCaseContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchDefaultContainerEClass, SwitchDefaultContainer.class, "SwitchDefaultContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchDefaultContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, SwitchDefaultContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceDiagramEClass, SequenceDiagram.class, "SequenceDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceDiagram_Sequence(), this.getEsbSequence(), null, "sequence", null, 0, 1, SequenceDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esbSequenceEClass, EsbSequence.class, "EsbSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEsbSequence_Name(), ecorePackage.getEString(), "name", ",", 0, 1, EsbSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEsbSequence_Input(), this.getEsbSequenceInputConnector(), null, "input", null, 0, 1, EsbSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEsbSequence_Output(), this.getEsbSequenceOutputConnector(), null, "output", null, 0, 1, EsbSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEsbSequence_ChildMediators(), this.getMediator(), null, "childMediators", null, 0, -1, EsbSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esbSequenceInputEClass, EsbSequenceInput.class, "EsbSequenceInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEsbSequenceInput_Connector(), this.getEsbSequenceInputConnector(), null, "connector", null, 0, 1, EsbSequenceInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esbSequenceOutputEClass, EsbSequenceOutput.class, "EsbSequenceOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEsbSequenceOutput_Connector(), this.getEsbSequenceOutputConnector(), null, "connector", null, 0, 1, EsbSequenceOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esbSequenceInputConnectorEClass, EsbSequenceInputConnector.class, "EsbSequenceInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(esbSequenceOutputConnectorEClass, EsbSequenceOutputConnector.class, "EsbSequenceOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSequence_Name(), ecorePackage.getEString(), "name", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_Key(), ecorePackage.getEString(), "key", "<inline/>", 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequence_InputConnector(), this.getSequenceInputConnector(), null, "inputConnector", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequence_OutputConnector(), this.getSequenceOutputConnector(), null, "outputConnector", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequence_IncludedMediators(), this.getMediator(), null, "includedMediators", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_ReceiveSequence(), ecorePackage.getEBoolean(), "receiveSequence", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_Duplicate(), ecorePackage.getEBoolean(), "duplicate", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_ReferringSequenceType(), this.getKeyType(), "referringSequenceType", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequence_DynamicReferenceKey(), this.getNamespacedProperty(), null, "dynamicReferenceKey", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequence_StaticReferenceKey(), this.getRegistryKeyProperty(), null, "staticReferenceKey", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceInputConnectorEClass, SequenceInputConnector.class, "SequenceInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceOutputConnectorEClass, SequenceOutputConnector.class, "SequenceOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventMediatorEClass, EventMediator.class, "EventMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventMediator_TopicType(), this.getEventTopicType(), "topicType", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventMediator_StaticTopic(), ecorePackage.getEString(), "staticTopic", "source_property", 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventMediator_DynamicTopic(), this.getNamespacedProperty(), null, "dynamicTopic", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventMediator_EventExpression(), this.getNamespacedProperty(), null, "eventExpression", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventMediator_InputConnector(), this.getEventMediatorInputConnector(), null, "inputConnector", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventMediator_OutputConnector(), this.getEventMediatorOutputConnector(), null, "outputConnector", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventMediatorInputConnectorEClass, EventMediatorInputConnector.class, "EventMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventMediatorOutputConnectorEClass, EventMediatorOutputConnector.class, "EventMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractNameValuePropertyEClass, AbstractNameValueProperty.class, "AbstractNameValueProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractNameValueProperty_PropertyName(), ecorePackage.getEString(), "propertyName", "property_name", 0, 1, AbstractNameValueProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueProperty_PropertyValue(), ecorePackage.getEString(), "propertyValue", "property_value", 0, 1, AbstractNameValueProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementMediatorEClass, EntitlementMediator.class, "EntitlementMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntitlementMediator_EntitlementServerURL(), ecorePackage.getEString(), "entitlementServerURL", "server_url", 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_Username(), ecorePackage.getEString(), "username", "username", 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_Password(), ecorePackage.getEString(), "password", "password", 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_CallbackClassName(), ecorePackage.getEString(), "callbackClassName", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_ThriftHost(), ecorePackage.getEString(), "thriftHost", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_ThriftPort(), ecorePackage.getEString(), "thriftPort", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_EntitlementClientType(), this.getEntitlementClientType(), "entitlementClientType", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_OnRejectSequenceType(), this.getEntitlementSequenceType(), "onRejectSequenceType", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_OnAcceptSequenceType(), this.getEntitlementSequenceType(), "onAcceptSequenceType", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_AdviceSequenceType(), this.getEntitlementSequenceType(), "adviceSequenceType", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_ObligationsSequenceType(), this.getEntitlementSequenceType(), "obligationsSequenceType", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_OnRejectSequenceKey(), this.getRegistryKeyProperty(), null, "onRejectSequenceKey", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_OnAcceptSequenceKey(), this.getRegistryKeyProperty(), null, "onAcceptSequenceKey", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_AdviceSequenceKey(), this.getRegistryKeyProperty(), null, "adviceSequenceKey", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_ObligationsSequenceKey(), this.getRegistryKeyProperty(), null, "obligationsSequenceKey", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_EntitlementContainer(), this.getEntitlementContainer(), null, "entitlementContainer", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_InputConnector(), this.getEntitlementMediatorInputConnector(), null, "inputConnector", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_OutputConnector(), this.getEntitlementMediatorOutputConnector(), null, "outputConnector", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_OnRejectOutputConnector(), this.getEntitlementMediatorOnRejectOutputConnector(), null, "onRejectOutputConnector", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_OnAcceptOutputConnector(), this.getEntitlementMediatorOnAcceptOutputConnector(), null, "onAcceptOutputConnector", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_AdviceOutputConnector(), this.getEntitlementMediatorAdviceOutputConnector(), null, "adviceOutputConnector", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_ObligationsOutputConnector(), this.getEntitlementMediatorObligationsOutputConnector(), null, "obligationsOutputConnector", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_CallbackHandler(), this.getEntitlementCallbackHandler(), "callbackHandler", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementMediatorInputConnectorEClass, EntitlementMediatorInputConnector.class, "EntitlementMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entitlementMediatorOutputConnectorEClass, EntitlementMediatorOutputConnector.class, "EntitlementMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entitlementMediatorOnRejectOutputConnectorEClass, EntitlementMediatorOnRejectOutputConnector.class, "EntitlementMediatorOnRejectOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entitlementMediatorOnAcceptOutputConnectorEClass, EntitlementMediatorOnAcceptOutputConnector.class, "EntitlementMediatorOnAcceptOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entitlementMediatorAdviceOutputConnectorEClass, EntitlementMediatorAdviceOutputConnector.class, "EntitlementMediatorAdviceOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entitlementMediatorObligationsOutputConnectorEClass, EntitlementMediatorObligationsOutputConnector.class, "EntitlementMediatorObligationsOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entitlementContainerEClass, EntitlementContainer.class, "EntitlementContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntitlementContainer_OnRejectContainer(), this.getEntitlementOnRejectContainer(), null, "onRejectContainer", null, 0, 1, EntitlementContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementContainer_OnAcceptContainer(), this.getEntitlementOnAcceptContainer(), null, "onAcceptContainer", null, 0, 1, EntitlementContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementContainer_AdviceContainer(), this.getEntitlementAdviceContainer(), null, "adviceContainer", null, 0, 1, EntitlementContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementContainer_ObligationsContainer(), this.getEntitlementObligationsContainer(), null, "obligationsContainer", null, 0, 1, EntitlementContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementOnRejectContainerEClass, EntitlementOnRejectContainer.class, "EntitlementOnRejectContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntitlementOnRejectContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, EntitlementOnRejectContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementOnAcceptContainerEClass, EntitlementOnAcceptContainer.class, "EntitlementOnAcceptContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntitlementOnAcceptContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, EntitlementOnAcceptContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementAdviceContainerEClass, EntitlementAdviceContainer.class, "EntitlementAdviceContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntitlementAdviceContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, EntitlementAdviceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementObligationsContainerEClass, EntitlementObligationsContainer.class, "EntitlementObligationsContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntitlementObligationsContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, EntitlementObligationsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enqueueMediatorEClass, EnqueueMediator.class, "EnqueueMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnqueueMediator_Executor(), ecorePackage.getEString(), "executor", "executor_name", 0, 1, EnqueueMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnqueueMediator_Priority(), ecorePackage.getEInt(), "priority", "0", 0, 1, EnqueueMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnqueueMediator_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, EnqueueMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnqueueMediator_InputConnector(), this.getEnqueueMediatorInputConnector(), null, "inputConnector", null, 0, 1, EnqueueMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnqueueMediator_OutputConnector(), this.getEnqueueMediatorOutputConnector(), null, "outputConnector", null, 0, 1, EnqueueMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enqueueMediatorInputConnectorEClass, EnqueueMediatorInputConnector.class, "EnqueueMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enqueueMediatorOutputConnectorEClass, EnqueueMediatorOutputConnector.class, "EnqueueMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classMediatorEClass, ClassMediator.class, "ClassMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassMediator_ClassName(), ecorePackage.getEString(), "className", "class_name", 0, 1, ClassMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassMediator_Properties(), this.getClassProperty(), null, "properties", null, 0, -1, ClassMediator.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassMediator_InputConnector(), this.getClassMediatorInputConnector(), null, "inputConnector", null, 0, 1, ClassMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassMediator_OutputConnector(), this.getClassMediatorOutputConnector(), null, "outputConnector", null, 0, 1, ClassMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classMediatorInputConnectorEClass, ClassMediatorInputConnector.class, "ClassMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classMediatorOutputConnectorEClass, ClassMediatorOutputConnector.class, "ClassMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classPropertyEClass, ClassProperty.class, "ClassProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(springMediatorEClass, SpringMediator.class, "SpringMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpringMediator_BeanName(), ecorePackage.getEString(), "beanName", "bean_name", 0, 1, SpringMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpringMediator_ConfigurationKey(), this.getRegistryKeyProperty(), null, "configurationKey", null, 0, 1, SpringMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpringMediator_InputConnector(), this.getSpringMediatorInputConnector(), null, "inputConnector", null, 0, 1, SpringMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpringMediator_OutputConnector(), this.getSpringMediatorOutputConnector(), null, "outputConnector", null, 0, 1, SpringMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(springMediatorInputConnectorEClass, SpringMediatorInputConnector.class, "SpringMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(springMediatorOutputConnectorEClass, SpringMediatorOutputConnector.class, "SpringMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptMediatorEClass, ScriptMediator.class, "ScriptMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptMediator_ScriptType(), this.getScriptType(), "scriptType", "REGISTRY_REFERENCE", 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptMediator_ScriptLanguage(), this.getScriptLanguage(), "scriptLanguage", null, 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptMediator_MediateFunction(), ecorePackage.getEString(), "mediateFunction", "", 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptMediator_ScriptDynamicKey(), this.getNamespacedProperty(), null, "scriptDynamicKey", null, 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptMediator_ScriptBody(), ecorePackage.getEString(), "scriptBody", "script_code", 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptMediator_InputConnector(), this.getScriptMediatorInputConnector(), null, "inputConnector", null, 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptMediator_OutputConnector(), this.getScriptMediatorOutputConnector(), null, "outputConnector", null, 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptMediator_KeyType(), this.getscriptKeyTypeEnum(), "keyType", null, 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptMediator_ScriptStaticKey(), this.getRegistryKeyProperty(), null, "scriptStaticKey", null, 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptMediator_ScriptKeys(), this.getRegistryKeyProperty(), null, "scriptKeys", null, 0, -1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptMediatorInputConnectorEClass, ScriptMediatorInputConnector.class, "ScriptMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptMediatorOutputConnectorEClass, ScriptMediatorOutputConnector.class, "ScriptMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(faultMediatorEClass, FaultMediator.class, "FaultMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFaultMediator_SoapVersion(), this.getFaultSoapVersion(), "soapVersion", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_SerializeResponse(), ecorePackage.getEBoolean(), "serializeResponse", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_MarkAsResponse(), ecorePackage.getEBoolean(), "markAsResponse", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultCodeSoap11(), this.getFaultCodeSoap11(), "faultCodeSoap11", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultCodeType(), this.getFaultCodeType(), "faultCodeType", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_FaultCodeExpression(), this.getNamespacedProperty(), null, "faultCodeExpression", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultStringType(), this.getFaultStringType(), "faultStringType", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultStringValue(), ecorePackage.getEString(), "faultStringValue", "fault_string", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_FaultStringExpression(), this.getNamespacedProperty(), null, "faultStringExpression", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultActor(), ecorePackage.getEString(), "faultActor", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultCodeSoap12(), this.getFaultCodeSoap12(), "faultCodeSoap12", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultReasonType(), this.getFaultReasonType(), "faultReasonType", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultReasonValue(), ecorePackage.getEString(), "faultReasonValue", "fault_reason", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_FaultReasonExpression(), this.getNamespacedProperty(), null, "faultReasonExpression", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_RoleName(), ecorePackage.getEString(), "roleName", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_NodeName(), ecorePackage.getEString(), "nodeName", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultDetailType(), this.getFaultDetailType(), "faultDetailType", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultDetailValue(), ecorePackage.getEString(), "faultDetailValue", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_FaultDetailExpression(), this.getNamespacedProperty(), null, "faultDetailExpression", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_InputConnector(), this.getFaultMediatorInputConnector(), null, "inputConnector", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_OutputConnector(), this.getFaultMediatorOutputConnector(), null, "outputConnector", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faultMediatorInputConnectorEClass, FaultMediatorInputConnector.class, "FaultMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(faultMediatorOutputConnectorEClass, FaultMediatorOutputConnector.class, "FaultMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(aggregateMediatorEClass, AggregateMediator.class, "AggregateMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAggregateMediator_AggregateID(), ecorePackage.getEString(), "aggregateID", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_CorrelationExpression(), this.getNamespacedProperty(), null, "correlationExpression", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_CompletionTimeout(), ecorePackage.getELong(), "completionTimeout", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_CompletionMinMessagesType(), this.getCompletionMessagesType(), "completionMinMessagesType", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_CompletionMaxMessagesType(), this.getCompletionMessagesType(), "completionMaxMessagesType", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_CompletionMinMessagesValue(), ecorePackage.getEInt(), "completionMinMessagesValue", "-1", 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_CompletionMinMessagesExpression(), this.getNamespacedProperty(), null, "completionMinMessagesExpression", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_CompletionMaxMessagesValue(), ecorePackage.getEInt(), "completionMaxMessagesValue", "-1", 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_CompletionMaxMessagesExpression(), this.getNamespacedProperty(), null, "completionMaxMessagesExpression", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_InputConnector(), this.getAggregateMediatorInputConnector(), null, "inputConnector", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_OutputConnector(), this.getAggregateMediatorOutputConnector(), null, "outputConnector", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_OnCompleteOutputConnector(), this.getAggregateMediatorOnCompleteOutputConnector(), null, "onCompleteOutputConnector", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_AggregationExpression(), this.getNamespacedProperty(), null, "aggregationExpression", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_SequenceType(), this.getAggregateSequenceType(), "sequenceType", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_EnclosingElementProperty(), ecorePackage.getEString(), "enclosingElementProperty", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregateMediatorInputConnectorEClass, AggregateMediatorInputConnector.class, "AggregateMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(aggregateMediatorOutputConnectorEClass, AggregateMediatorOutputConnector.class, "AggregateMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(aggregateMediatorOnCompleteOutputConnectorEClass, AggregateMediatorOnCompleteOutputConnector.class, "AggregateMediatorOnCompleteOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(routerMediatorEClass, RouterMediator.class, "RouterMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRouterMediator_ContinueAfterRouting(), ecorePackage.getEBoolean(), "continueAfterRouting", null, 0, 1, RouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterMediator_TargetOutputConnector(), this.getRouterMediatorTargetOutputConnector(), null, "targetOutputConnector", null, 0, -1, RouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterMediator_InputConnector(), this.getRouterMediatorInputConnector(), null, "inputConnector", null, 0, 1, RouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterMediator_OutputConnector(), this.getRouterMediatorOutputConnector(), null, "outputConnector", null, 0, 1, RouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterMediator_RouterContainer(), this.getRouterMediatorContainer(), null, "routerContainer", null, 0, 1, RouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routerRouteEClass, RouterRoute.class, "RouterRoute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRouterRoute_BreakAfterRoute(), ecorePackage.getEBoolean(), "breakAfterRoute", null, 0, 1, RouterRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterRoute_RouteExpression(), this.getNamespacedProperty(), null, "routeExpression", null, 0, 1, RouterRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouterRoute_RoutePattern(), ecorePackage.getEString(), "routePattern", null, 0, 1, RouterRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routerTargetEClass, RouterTarget.class, "RouterTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(routerMediatorInputConnectorEClass, RouterMediatorInputConnector.class, "RouterMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(routerMediatorOutputConnectorEClass, RouterMediatorOutputConnector.class, "RouterMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(routerMediatorTargetOutputConnectorEClass, RouterMediatorTargetOutputConnector.class, "RouterMediatorTargetOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRouterMediatorTargetOutputConnector_SoapAction(), ecorePackage.getEString(), "soapAction", "soapAction", 0, 1, RouterMediatorTargetOutputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouterMediatorTargetOutputConnector_ToAddress(), ecorePackage.getEString(), "toAddress", "toAddress", 0, 1, RouterMediatorTargetOutputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routerMediatorContainerEClass, RouterMediatorContainer.class, "RouterMediatorContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRouterMediatorContainer_RouterTargetContainer(), this.getRouterTargetContainer(), null, "routerTargetContainer", null, 0, -1, RouterMediatorContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routerTargetContainerEClass, RouterTargetContainer.class, "RouterTargetContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRouterTargetContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, RouterTargetContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouterTargetContainer_BreakAfterRoute(), ecorePackage.getEBoolean(), "breakAfterRoute", null, 0, 1, RouterTargetContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterTargetContainer_RouteExpression(), this.getNamespacedProperty(), null, "routeExpression", null, 0, 1, RouterTargetContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouterTargetContainer_RoutePattern(), ecorePackage.getEString(), "routePattern", null, 0, 1, RouterTargetContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterTargetContainer_Target(), this.getRouterTarget(), null, "Target", null, 0, 1, RouterTargetContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloneMediatorEClass, CloneMediator.class, "CloneMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloneMediator_CloneID(), ecorePackage.getEString(), "cloneID", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloneMediator_SequentialMediation(), ecorePackage.getEBoolean(), "sequentialMediation", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloneMediator_ContinueParent(), ecorePackage.getEBoolean(), "continueParent", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneMediator_Targets(), this.getCloneTarget(), null, "targets", null, 0, -1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneMediator_TargetsOutputConnector(), this.getCloneMediatorTargetOutputConnector(), null, "targetsOutputConnector", null, 0, -1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneMediator_InputConnector(), this.getCloneMediatorInputConnector(), null, "inputConnector", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneMediator_OutputConnector(), this.getCloneMediatorOutputConnector(), null, "outputConnector", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneMediator_CloneContainer(), this.getCloneMediatorContainer(), null, "cloneContainer", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloneTargetEClass, CloneTarget.class, "CloneTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloneTarget_SoapAction(), ecorePackage.getEString(), "soapAction", "soap_action", 0, 1, CloneTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloneTarget_ToAddress(), ecorePackage.getEString(), "toAddress", "to_address", 0, 1, CloneTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloneMediatorInputConnectorEClass, CloneMediatorInputConnector.class, "CloneMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cloneMediatorOutputConnectorEClass, CloneMediatorOutputConnector.class, "CloneMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cloneMediatorTargetOutputConnectorEClass, CloneMediatorTargetOutputConnector.class, "CloneMediatorTargetOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloneMediatorTargetOutputConnector_SoapAction(), ecorePackage.getEString(), "soapAction", "soapAction", 0, 1, CloneMediatorTargetOutputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloneMediatorTargetOutputConnector_ToAddress(), ecorePackage.getEString(), "toAddress", "toAddress", 0, 1, CloneMediatorTargetOutputConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloneMediatorContainerEClass, CloneMediatorContainer.class, "CloneMediatorContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCloneMediatorContainer_CloneTargetContainer(), this.getCloneTargetContainer(), null, "cloneTargetContainer", null, 0, -1, CloneMediatorContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloneTargetContainerEClass, CloneTargetContainer.class, "CloneTargetContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCloneTargetContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, CloneTargetContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forEachMediatorEClass, ForEachMediator.class, "ForEachMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForEachMediator_ForEachID(), ecorePackage.getEString(), "forEachID", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachMediator_ForEachExpression(), this.getNamespacedProperty(), null, "forEachExpression", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachMediator_AttachPath(), this.getNamespacedProperty(), null, "attachPath", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachMediator_Target(), this.getForEachTarget(), null, "target", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachMediator_InputConnector(), this.getForEachMediatorInputConnector(), null, "inputConnector", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachMediator_OutputConnector(), this.getForEachMediatorOutputConnector(), null, "outputConnector", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachMediator_TargetOutputConnector(), this.getForEachMediatorTargetOutputConnector(), null, "targetOutputConnector", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForEachMediator_SequenceType(), this.getSequenceType(), "sequenceType", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachMediator_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForEachMediator_SequenceName(), ecorePackage.getEString(), "sequenceName", null, 0, 1, ForEachMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forEachMediatorInputConnectorEClass, ForEachMediatorInputConnector.class, "ForEachMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forEachMediatorOutputConnectorEClass, ForEachMediatorOutputConnector.class, "ForEachMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forEachMediatorTargetOutputConnectorEClass, ForEachMediatorTargetOutputConnector.class, "ForEachMediatorTargetOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forEachTargetEClass, ForEachTarget.class, "ForEachTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForEachTarget_SoapAction(), ecorePackage.getEString(), "soapAction", null, 0, 1, ForEachTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForEachTarget_ToAddress(), ecorePackage.getEString(), "toAddress", null, 0, 1, ForEachTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterateMediatorEClass, IterateMediator.class, "IterateMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIterateMediator_IterateID(), ecorePackage.getEString(), "iterateID", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateMediator_SequentialMediation(), ecorePackage.getEBoolean(), "sequentialMediation", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateMediator_ContinueParent(), ecorePackage.getEBoolean(), "continueParent", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateMediator_PreservePayload(), ecorePackage.getEBoolean(), "preservePayload", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_IterateExpression(), this.getNamespacedProperty(), null, "iterateExpression", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_AttachPath(), this.getNamespacedProperty(), null, "attachPath", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_Target(), this.getIterateTarget(), null, "target", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_InputConnector(), this.getIterateMediatorInputConnector(), null, "inputConnector", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_OutputConnector(), this.getIterateMediatorOutputConnector(), null, "outputConnector", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_TargetOutputConnector(), this.getIterateMediatorTargetOutputConnector(), null, "targetOutputConnector", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateMediator_SequenceType(), this.getSequenceType(), "sequenceType", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateMediator_SequenceName(), ecorePackage.getEString(), "sequenceName", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterateMediatorInputConnectorEClass, IterateMediatorInputConnector.class, "IterateMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iterateMediatorOutputConnectorEClass, IterateMediatorOutputConnector.class, "IterateMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iterateMediatorTargetOutputConnectorEClass, IterateMediatorTargetOutputConnector.class, "IterateMediatorTargetOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iterateTargetEClass, IterateTarget.class, "IterateTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIterateTarget_SoapAction(), ecorePackage.getEString(), "soapAction", null, 0, 1, IterateTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateTarget_ToAddress(), ecorePackage.getEString(), "toAddress", null, 0, 1, IterateTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractCommonTargetEClass, AbstractCommonTarget.class, "AbstractCommonTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractCommonTarget_SequenceType(), this.getTargetSequenceType(), "sequenceType", "NONE", 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCommonTarget_Sequence(), this.getMediatorSequence(), null, "sequence", null, 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCommonTarget_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractCommonTarget_EndpointType(), this.getTargetEndpointType(), "endpointType", "NONE", 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCommonTarget_Endpoint(), this.getEndPoint(), null, "endpoint", null, 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCommonTarget_EndpointKey(), this.getRegistryKeyProperty(), null, "endpointKey", null, 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediatorSequenceEClass, MediatorSequence.class, "MediatorSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediatorSequence_Anonymous(), ecorePackage.getEBoolean(), "anonymous", "false", 0, 1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediatorSequence_SequenceName(), ecorePackage.getEString(), "sequenceName", "sequence_name", 0, 1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMediatorSequence_Mediators(), this.getMediator(), null, "mediators", null, 0, -1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMediatorSequence_OnError(), this.getRegistryKeyProperty(), null, "onError", null, 0, 1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediatorSequence_Description(), ecorePackage.getEString(), "description", null, 0, 1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cacheMediatorEClass, CacheMediator.class, "CacheMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCacheMediator_CacheId(), ecorePackage.getEString(), "cacheId", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_CacheScope(), this.getCacheScope(), "cacheScope", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_CacheAction(), this.getCacheAction(), "cacheAction", "FINDER", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_HashGenerator(), ecorePackage.getEString(), "hashGenerator", "org.wso2.caching.digest.DOMHashGenerator", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_CacheTimeout(), ecorePackage.getEInt(), "cacheTimeout", "120", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_MaxMessageSize(), ecorePackage.getEInt(), "maxMessageSize", "2000", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_ImplementationType(), this.getCacheImplementationType(), "implementationType", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_MaxEntryCount(), ecorePackage.getEInt(), "maxEntryCount", "1000", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_SequenceType(), this.getCacheSequenceType(), "sequenceType", "REGISTRY_REFERENCE", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCacheMediator_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCacheMediator_InputConnector(), this.getCacheMediatorInputConnector(), null, "inputConnector", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCacheMediator_OutputConnector(), this.getCacheMediatorOutputConnector(), null, "outputConnector", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCacheMediator_OnHitOutputConnector(), this.getCacheMediatorOnHitOutputConnector(), null, "onHitOutputConnector", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCacheMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cacheMediatorInputConnectorEClass, CacheMediatorInputConnector.class, "CacheMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cacheMediatorOutputConnectorEClass, CacheMediatorOutputConnector.class, "CacheMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cacheMediatorOnHitOutputConnectorEClass, CacheMediatorOnHitOutputConnector.class, "CacheMediatorOnHitOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cacheOnHitBranchEClass, CacheOnHitBranch.class, "CacheOnHitBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xQueryMediatorEClass, XQueryMediator.class, "XQueryMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXQueryMediator_Variables(), this.getXQueryVariable(), null, "variables", null, 0, -1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_TargetXPath(), this.getNamespacedProperty(), null, "targetXPath", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXQueryMediator_ScriptKeyType(), this.getKeyType(), "scriptKeyType", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_StaticScriptKey(), this.getRegistryKeyProperty(), null, "staticScriptKey", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_DynamicScriptKey(), this.getNamespacedProperty(), null, "dynamicScriptKey", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_QueryKey(), this.getRegistryKeyProperty(), null, "queryKey", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_InputConnector(), this.getXQueryMediatorInputConnector(), null, "inputConnector", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_OutputConnector(), this.getXQueryMediatorOutputConnector(), null, "outputConnector", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xQueryMediatorInputConnectorEClass, XQueryMediatorInputConnector.class, "XQueryMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xQueryMediatorOutputConnectorEClass, XQueryMediatorOutputConnector.class, "XQueryMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xQueryVariableEClass, XQueryVariable.class, "XQueryVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXQueryVariable_VariableName(), ecorePackage.getEString(), "variableName", "variable_name", 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXQueryVariable_VariableType(), this.getXQueryVariableType(), "variableType", "STRING", 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXQueryVariable_ValueType(), this.getXQueryVariableValueType(), "valueType", "LITERAL", 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXQueryVariable_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "literal_value", 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryVariable_ValueExpression(), this.getNamespacedProperty(), null, "valueExpression", null, 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryVariable_ValueKey(), this.getRegistryKeyProperty(), null, "valueKey", null, 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(calloutMediatorEClass, CalloutMediator.class, "CalloutMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCalloutMediator_ServiceURL(), ecorePackage.getEString(), "serviceURL", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_SoapAction(), ecorePackage.getEString(), "soapAction", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PathToAxis2xml(), ecorePackage.getEString(), "pathToAxis2xml", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PathToAxis2Repository(), ecorePackage.getEString(), "pathToAxis2Repository", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PayloadType(), this.getCalloutPayloadType(), "payloadType", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_PayloadMessageXpath(), this.getNamespacedProperty(), null, "payloadMessageXpath", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_ResultType(), this.getCalloutResultType(), "resultType", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_ResultMessageXpath(), this.getNamespacedProperty(), null, "resultMessageXpath", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_ResultContextProperty(), ecorePackage.getEString(), "resultContextProperty", "context_property_name", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PassHeaders(), ecorePackage.getEBoolean(), "passHeaders", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_InputConnector(), this.getCalloutMediatorInputConnector(), null, "inputConnector", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_OutputConnector(), this.getCalloutMediatorOutputConnector(), null, "outputConnector", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_AddressEndpoint(), this.getRegistryKeyProperty(), null, "AddressEndpoint", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_EndpointType(), this.getCalloutEndpointType(), "EndpointType", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PayloadProperty(), ecorePackage.getEString(), "payloadProperty", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_SecurityType(), this.getCalloutSecurityType(), "securityType", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_OutboundPolicyKey(), this.getRegistryKeyProperty(), null, "outboundPolicyKey", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_InboundPolicyKey(), this.getRegistryKeyProperty(), null, "inboundPolicyKey", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_Policies(), this.getCalloutSecurityPolicies(), "policies", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_PolicyKey(), this.getRegistryKeyProperty(), null, "policyKey", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_InitAxis2ClientOptions(), ecorePackage.getEBoolean(), "initAxis2ClientOptions", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(calloutMediatorInputConnectorEClass, CalloutMediatorInputConnector.class, "CalloutMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(calloutMediatorOutputConnectorEClass, CalloutMediatorOutputConnector.class, "CalloutMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rmSequenceMediatorEClass, RMSequenceMediator.class, "RMSequenceMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRMSequenceMediator_RmSpecVersion(), this.getRMSpecVersion(), "rmSpecVersion", null, 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRMSequenceMediator_SequenceType(), this.getRMSequenceType(), "sequenceType", "SINGLE_MESSAGE", 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRMSequenceMediator_CorrelationXpath(), this.getNamespacedProperty(), null, "correlationXpath", null, 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRMSequenceMediator_LastMessageXpath(), this.getNamespacedProperty(), null, "lastMessageXpath", null, 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRMSequenceMediator_InputConnector(), this.getRMSequenceMediatorInputConnector(), null, "inputConnector", null, 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRMSequenceMediator_OutputConnector(), this.getRMSequenceMediatorOutputConnector(), null, "outputConnector", null, 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rmSequenceMediatorInputConnectorEClass, RMSequenceMediatorInputConnector.class, "RMSequenceMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rmSequenceMediatorOutputConnectorEClass, RMSequenceMediatorOutputConnector.class, "RMSequenceMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionMediatorEClass, TransactionMediator.class, "TransactionMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransactionMediator_Action(), this.getTransactionAction(), "action", null, 0, 1, TransactionMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransactionMediator_InputConnector(), this.getTransactionMediatorInputConnector(), null, "inputConnector", null, 0, 1, TransactionMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransactionMediator_OutputConnector(), this.getTransactionMediatorOutputConnector(), null, "outputConnector", null, 0, 1, TransactionMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transactionMediatorInputConnectorEClass, TransactionMediatorInputConnector.class, "TransactionMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transactionMediatorOutputConnectorEClass, TransactionMediatorOutputConnector.class, "TransactionMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oAuthMediatorEClass, OAuthMediator.class, "OAuthMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOAuthMediator_RemoteServiceUrl(), ecorePackage.getEString(), "remoteServiceUrl", "service_url", 0, 1, OAuthMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOAuthMediator_Username(), ecorePackage.getEString(), "username", null, 0, 1, OAuthMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOAuthMediator_Password(), ecorePackage.getEString(), "password", null, 0, 1, OAuthMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOAuthMediator_InputConnector(), this.getOAuthMediatorInputConnector(), null, "inputConnector", null, 0, 1, OAuthMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOAuthMediator_OutputConnector(), this.getOAuthMediatorOutputConnector(), null, "outputConnector", null, 0, 1, OAuthMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oAuthMediatorInputConnectorEClass, OAuthMediatorInputConnector.class, "OAuthMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oAuthMediatorOutputConnectorEClass, OAuthMediatorOutputConnector.class, "OAuthMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(autoscaleInMediatorEClass, AutoscaleInMediator.class, "AutoscaleInMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(autoscaleOutMediatorEClass, AutoscaleOutMediator.class, "AutoscaleOutMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(headerMediatorEClass, HeaderMediator.class, "HeaderMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHeaderMediator_HeaderName(), this.getNamespacedProperty(), null, "headerName", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeaderMediator_HeaderAction(), this.getHeaderAction(), "headerAction", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeaderMediator_ValueType(), this.getHeaderValueType(), "valueType", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeaderMediator_Scope(), this.getScopeType(), "scope", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeaderMediator_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "header_value", 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHeaderMediator_ValueExpression(), this.getNamespacedProperty(), null, "valueExpression", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHeaderMediator_InputConnector(), this.getHeaderMediatorInputConnector(), null, "inputConnector", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHeaderMediator_OutputConnector(), this.getHeaderMediatorOutputConnector(), null, "outputConnector", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeaderMediator_ValueInline(), ecorePackage.getEString(), "valueInline", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(headerMediatorInputConnectorEClass, HeaderMediatorInputConnector.class, "HeaderMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(headerMediatorOutputConnectorEClass, HeaderMediatorOutputConnector.class, "HeaderMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(throttleMediatorEClass, ThrottleMediator.class, "ThrottleMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottleMediator_GroupId(), ecorePackage.getEString(), "groupId", "group_id", 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottleMediator_PolicyType(), this.getThrottlePolicyType(), "policyType", "INLINE", 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_PolicyKey(), this.getRegistryKeyProperty(), null, "policyKey", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottleMediator_MaxConcurrentAccessCount(), ecorePackage.getEInt(), "maxConcurrentAccessCount", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_PolicyEntries(), this.getThrottlePolicyEntry(), null, "policyEntries", null, 0, -1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_PolicyConfiguration(), this.getThrottlePolicyConfiguration(), null, "policyConfiguration", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OnAcceptBranch(), this.getThrottleOnAcceptBranch(), null, "onAcceptBranch", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OnRejectBranch(), this.getThrottleOnRejectBranch(), null, "onRejectBranch", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_InputConnector(), this.getThrottleMediatorInputConnector(), null, "inputConnector", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OutputConnector(), this.getThrottleMediatorOutputConnector(), null, "outputConnector", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OnAcceptOutputConnector(), this.getThrottleMediatorOnAcceptOutputConnector(), null, "onAcceptOutputConnector", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OnRejectOutputConnector(), this.getThrottleMediatorOnRejectOutputConnector(), null, "onRejectOutputConnector", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_ThrottleContainer(), this.getThrottleContainer(), null, "throttleContainer", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottleMediator_OnAcceptBranchsequenceType(), this.getThrottleSequenceType(), "OnAcceptBranchsequenceType", "ANONYMOUS", 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OnAcceptBranchsequenceKey(), this.getRegistryKeyProperty(), null, "OnAcceptBranchsequenceKey", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottleMediator_OnRejectBranchsequenceType(), this.getThrottleSequenceType(), "OnRejectBranchsequenceType", "ANONYMOUS", 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OnRejectBranchsequenceKey(), this.getRegistryKeyProperty(), null, "OnRejectBranchsequenceKey", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleMediatorInputConnectorEClass, ThrottleMediatorInputConnector.class, "ThrottleMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(throttleMediatorOutputConnectorEClass, ThrottleMediatorOutputConnector.class, "ThrottleMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(throttleMediatorOnAcceptOutputConnectorEClass, ThrottleMediatorOnAcceptOutputConnector.class, "ThrottleMediatorOnAcceptOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(throttleMediatorOnRejectOutputConnectorEClass, ThrottleMediatorOnRejectOutputConnector.class, "ThrottleMediatorOnRejectOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(throttlePolicyConfigurationEClass, ThrottlePolicyConfiguration.class, "ThrottlePolicyConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottlePolicyConfiguration_PolicyType(), this.getThrottlePolicyType(), "policyType", "INLINE", 0, 1, ThrottlePolicyConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottlePolicyConfiguration_PolicyKey(), this.getRegistryKeyProperty(), null, "policyKey", null, 0, 1, ThrottlePolicyConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyConfiguration_MaxConcurrentAccessCount(), ecorePackage.getEInt(), "maxConcurrentAccessCount", null, 0, 1, ThrottlePolicyConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottlePolicyConfiguration_PolicyEntries(), this.getThrottlePolicyEntry(), null, "policyEntries", null, 0, -1, ThrottlePolicyConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttlePolicyEntryEClass, ThrottlePolicyEntry.class, "ThrottlePolicyEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottlePolicyEntry_ThrottleType(), this.getThrottleConditionType(), "throttleType", "IP", 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_ThrottleRange(), ecorePackage.getEString(), "throttleRange", "other", 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_AccessType(), this.getThrottleAccessType(), "accessType", null, 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_MaxRequestCount(), ecorePackage.getEInt(), "maxRequestCount", null, 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_UnitTime(), ecorePackage.getEInt(), "unitTime", null, 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_ProhibitPeriod(), ecorePackage.getEInt(), "prohibitPeriod", null, 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleOnAcceptBranchEClass, ThrottleOnAcceptBranch.class, "ThrottleOnAcceptBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottleOnAcceptBranch_SequenceType(), this.getThrottleSequenceType(), "sequenceType", "ANONYMOUS", 0, 1, ThrottleOnAcceptBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleOnAcceptBranch_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, ThrottleOnAcceptBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleOnRejectBranchEClass, ThrottleOnRejectBranch.class, "ThrottleOnRejectBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottleOnRejectBranch_SequenceType(), this.getThrottleSequenceType(), "sequenceType", "ANONYMOUS", 0, 1, ThrottleOnRejectBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleOnRejectBranch_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, ThrottleOnRejectBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleContainerEClass, ThrottleContainer.class, "ThrottleContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThrottleContainer_OnAcceptContainer(), this.getThrottleOnAcceptContainer(), null, "onAcceptContainer", null, 0, 1, ThrottleContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleContainer_OnRejectContainer(), this.getThrottleOnRejectContainer(), null, "onRejectContainer", null, 0, 1, ThrottleContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleOnAcceptContainerEClass, ThrottleOnAcceptContainer.class, "ThrottleOnAcceptContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThrottleOnAcceptContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, ThrottleOnAcceptContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleOnRejectContainerEClass, ThrottleOnRejectContainer.class, "ThrottleOnRejectContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThrottleOnRejectContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, ThrottleOnRejectContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandMediatorEClass, CommandMediator.class, "CommandMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommandMediator_ClassName(), ecorePackage.getEString(), "className", "class_name", 0, 1, CommandMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandMediator_Properties(), this.getCommandProperty(), null, "properties", null, 0, -1, CommandMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandMediator_InputConnector(), this.getCommandMediatorInputConnector(), null, "inputConnector", null, 0, 1, CommandMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandMediator_OutputConnector(), this.getCommandMediatorOutputConnector(), null, "outputConnector", null, 0, 1, CommandMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandMediatorInputConnectorEClass, CommandMediatorInputConnector.class, "CommandMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commandMediatorOutputConnectorEClass, CommandMediatorOutputConnector.class, "CommandMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commandPropertyEClass, CommandProperty.class, "CommandProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommandProperty_PropertyName(), ecorePackage.getEString(), "propertyName", "property_name", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_ValueType(), this.getCommandPropertyValueType(), "valueType", "LITERAL", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "literal_value", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_ValueContextPropertyName(), ecorePackage.getEString(), "valueContextPropertyName", "context_property_name", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandProperty_ValueMessageElementXpath(), this.getNamespacedProperty(), null, "valueMessageElementXpath", null, 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_ContextAction(), this.getCommandPropertyContextAction(), "contextAction", null, 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_MessageAction(), this.getCommandPropertyMessageAction(), "messageAction", null, 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractSqlExecutorMediatorEClass, AbstractSqlExecutorMediator.class, "AbstractSqlExecutorMediator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionType(), this.getSqlExecutorConnectionType(), "connectionType", "DB_CONNECTION", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionDsType(), this.getSqlExecutorDatasourceType(), "connectionDsType", "EXTERNAL", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionDbDriver(), ecorePackage.getEString(), "connectionDbDriver", "driver_class", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionDsInitialContext(), ecorePackage.getEString(), "connectionDsInitialContext", "initial_context", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionDsName(), ecorePackage.getEString(), "connectionDsName", "datasource_name", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionURL(), ecorePackage.getEString(), "connectionURL", "connection_url", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionUsername(), ecorePackage.getEString(), "connectionUsername", "username", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionPassword(), ecorePackage.getEString(), "connectionPassword", "password", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyAutocommit(), this.getSqlExecutorBooleanValue(), "propertyAutocommit", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyIsolation(), this.getSqlExecutorIsolationLevel(), "propertyIsolation", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMaxactive(), ecorePackage.getEInt(), "propertyMaxactive", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMaxidle(), ecorePackage.getEInt(), "propertyMaxidle", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMaxopenstatements(), ecorePackage.getEInt(), "propertyMaxopenstatements", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMaxwait(), ecorePackage.getEInt(), "propertyMaxwait", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMinidle(), ecorePackage.getEInt(), "propertyMinidle", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyPoolstatements(), this.getSqlExecutorBooleanValue(), "propertyPoolstatements", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyTestonborrow(), this.getSqlExecutorBooleanValue(), "propertyTestonborrow", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyTestwhileidle(), this.getSqlExecutorBooleanValue(), "propertyTestwhileidle", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyValidationquery(), ecorePackage.getEString(), "propertyValidationquery", null, 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyInitialsize(), ecorePackage.getEInt(), "propertyInitialsize", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractSqlExecutorMediator_SqlStatements(), this.getSqlStatement(), null, "sqlStatements", null, 0, -1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlStatementEClass, SqlStatement.class, "SqlStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSqlStatement_QueryString(), ecorePackage.getEString(), "queryString", "sql_query", 0, 1, SqlStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSqlStatement_Parameters(), this.getSqlParameterDefinition(), null, "parameters", null, 0, -1, SqlStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlStatement_ResultsEnabled(), ecorePackage.getEBoolean(), "resultsEnabled", "false", 0, 1, SqlStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSqlStatement_Results(), this.getSqlResultMapping(), null, "results", null, 0, -1, SqlStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlParameterDefinitionEClass, SqlParameterDefinition.class, "SqlParameterDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSqlParameterDefinition_DataType(), this.getSqlParameterDataType(), "dataType", "CHAR", 0, 1, SqlParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlParameterDefinition_ValueType(), this.getSqlParameterValueType(), "valueType", "LITERAL", 0, 1, SqlParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlParameterDefinition_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "value", 0, 1, SqlParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSqlParameterDefinition_ValueExpression(), this.getNamespacedProperty(), null, "valueExpression", null, 0, 1, SqlParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlResultMappingEClass, SqlResultMapping.class, "SqlResultMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSqlResultMapping_PropertyName(), ecorePackage.getEString(), "propertyName", "message_context_property_name", 0, 1, SqlResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlResultMapping_ColumnId(), ecorePackage.getEString(), "columnId", "column_name_or_index", 0, 1, SqlResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dbLookupMediatorEClass, DBLookupMediator.class, "DBLookupMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDBLookupMediator_InputConnector(), this.getDBLookupMediatorInputConnector(), null, "inputConnector", null, 0, 1, DBLookupMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBLookupMediator_OutputConnector(), this.getDBLookupMediatorOutputConnector(), null, "outputConnector", null, 0, 1, DBLookupMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dbLookupMediatorInputConnectorEClass, DBLookupMediatorInputConnector.class, "DBLookupMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dbLookupMediatorOutputConnectorEClass, DBLookupMediatorOutputConnector.class, "DBLookupMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dbReportMediatorEClass, DBReportMediator.class, "DBReportMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBReportMediator_ConnectionUseTransaction(), ecorePackage.getEBoolean(), "connectionUseTransaction", "false", 0, 1, DBReportMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBReportMediator_InputConnector(), this.getDBReportMediatorInputConnector(), null, "inputConnector", null, 0, 1, DBReportMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBReportMediator_OutputConnector(), this.getDBReportMediatorOutputConnector(), null, "outputConnector", null, 0, 1, DBReportMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dbReportMediatorInputConnectorEClass, DBReportMediatorInputConnector.class, "DBReportMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dbReportMediatorOutputConnectorEClass, DBReportMediatorOutputConnector.class, "DBReportMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleMediatorEClass, RuleMediator.class, "RuleMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleMediator_RuleSetURL(), ecorePackage.getEString(), "RuleSetURL", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_RuleSetSourceType(), this.getRuleSourceType(), "ruleSetSourceType", "INLINE", 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_RuleSetSourceCode(), ecorePackage.getEString(), "ruleSetSourceCode", "<code/>", 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_RuleSetSourceKey(), this.getRegistryKeyProperty(), null, "ruleSetSourceKey", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_StatefulSession(), ecorePackage.getEBoolean(), "statefulSession", "true", 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_RuleSessionProperties(), this.getRuleSessionProperty(), null, "RuleSessionProperties", null, 0, -1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_FactsConfiguration(), this.getRuleFactsConfiguration(), null, "factsConfiguration", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_ResultsConfiguration(), this.getRuleResultsConfiguration(), null, "resultsConfiguration", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_ChildMediatorsConfiguration(), this.getRuleChildMediatorsConfiguration(), null, "childMediatorsConfiguration", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_InputConnector(), this.getRuleMediatorInputConnector(), null, "inputConnector", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_OutputConnector(), this.getRuleMediatorOutputConnector(), null, "outputConnector", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_ChildMediatorsOutputConnector(), this.getRuleMediatorChildMediatorsOutputConnector(), null, "childMediatorsOutputConnector", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_SourceValue(), ecorePackage.getEString(), "sourceValue", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_SourceXpath(), this.getNamespacedProperty(), null, "sourceXpath", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_TargetValue(), ecorePackage.getEString(), "targetValue", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_TargetResultXpath(), this.getNamespacedProperty(), null, "targetResultXpath", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_TargetXpath(), this.getNamespacedProperty(), null, "targetXpath", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_TargetAction(), this.getRuleActions(), "targetAction", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_InputWrapperName(), ecorePackage.getEString(), "InputWrapperName", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_InputNameSpace(), ecorePackage.getEString(), "InputNameSpace", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_OutputWrapperName(), ecorePackage.getEString(), "OutputWrapperName", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_OutputNameSpace(), ecorePackage.getEString(), "OutputNameSpace", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleMediator_RuleSetType(), this.getRuleType(), "RuleSetType", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleMediatorInputConnectorEClass, RuleMediatorInputConnector.class, "RuleMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleMediatorOutputConnectorEClass, RuleMediatorOutputConnector.class, "RuleMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleMediatorChildMediatorsOutputConnectorEClass, RuleMediatorChildMediatorsOutputConnector.class, "RuleMediatorChildMediatorsOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleSetCreationPropertyEClass, RuleSetCreationProperty.class, "RuleSetCreationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleSessionPropertyEClass, RuleSessionProperty.class, "RuleSessionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleFactsConfigurationEClass, RuleFactsConfiguration.class, "RuleFactsConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleFactsConfiguration_Facts(), this.getRuleFact(), null, "facts", null, 0, -1, RuleFactsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleFactEClass, RuleFact.class, "RuleFact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleFact_FactType(), this.getRuleFactType(), "factType", "CUSTOM", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleFact_FactCustomType(), ecorePackage.getEString(), "factCustomType", "custom_type", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleFact_FactName(), ecorePackage.getEString(), "factName", "fact_name", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleFact_ValueType(), this.getRuleFactValueType(), "valueType", "LITERAL", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleFact_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "value", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleFact_ValueExpression(), this.getNamespacedProperty(), null, "valueExpression", null, 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleFact_ValueKey(), this.getRegistryKeyProperty(), null, "valueKey", null, 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleResultsConfigurationEClass, RuleResultsConfiguration.class, "RuleResultsConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleResultsConfiguration_Results(), this.getRuleResult(), null, "results", null, 0, -1, RuleResultsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleResultEClass, RuleResult.class, "RuleResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleResult_ResultType(), this.getRuleResultType(), "resultType", "CUSTOM", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleResult_ResultCustomType(), ecorePackage.getEString(), "resultCustomType", "custom_type", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleResult_ResultName(), ecorePackage.getEString(), "resultName", "result_name", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleResult_ValueType(), this.getRuleResultValueType(), "valueType", "LITERAL", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleResult_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "value", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleResult_ValueExpression(), this.getNamespacedProperty(), null, "valueExpression", null, 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleResult_ValueKey(), this.getRegistryKeyProperty(), null, "valueKey", null, 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleChildMediatorsConfigurationEClass, RuleChildMediatorsConfiguration.class, "RuleChildMediatorsConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callTemplateParameterEClass, CallTemplateParameter.class, "CallTemplateParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCallTemplateParameter_ParameterName(), ecorePackage.getEString(), "parameterName", null, 0, 1, CallTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCallTemplateParameter_TemplateParameterType(), this.getRuleOptionType(), "templateParameterType", null, 0, 1, CallTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCallTemplateParameter_ParameterValue(), ecorePackage.getEString(), "parameterValue", null, 0, 1, CallTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallTemplateParameter_ParameterExpression(), this.getNamespacedProperty(), null, "parameterExpression", null, 0, 1, CallTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callTemplateMediatorEClass, CallTemplateMediator.class, "CallTemplateMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCallTemplateMediator_AvailableTemplates(), ecorePackage.getEString(), "availableTemplates", null, 0, 1, CallTemplateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallTemplateMediator_TemplateParameters(), this.getCallTemplateParameter(), null, "templateParameters", null, 0, -1, CallTemplateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallTemplateMediator_InputConnector(), this.getCallTemplateMediatorInputConnector(), null, "inputConnector", null, 0, 1, CallTemplateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallTemplateMediator_OutputConnector(), this.getCallTemplateMediatorOutputConnector(), null, "outputConnector", null, 0, 1, CallTemplateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCallTemplateMediator_TargetTemplate(), ecorePackage.getEString(), "targetTemplate", null, 0, 1, CallTemplateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callTemplateMediatorInputConnectorEClass, CallTemplateMediatorInputConnector.class, "CallTemplateMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callTemplateMediatorOutputConnectorEClass, CallTemplateMediatorOutputConnector.class, "CallTemplateMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopBackMediatorEClass, LoopBackMediator.class, "LoopBackMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopBackMediator_InputConnector(), this.getLoopBackMediatorInputConnector(), null, "inputConnector", null, 0, 1, LoopBackMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopBackMediator_OutputConnector(), this.getLoopBackMediatorOutputConnector(), null, "outputConnector", null, 0, 1, LoopBackMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopBackMediatorInputConnectorEClass, LoopBackMediatorInputConnector.class, "LoopBackMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopBackMediatorOutputConnectorEClass, LoopBackMediatorOutputConnector.class, "LoopBackMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(respondMediatorEClass, RespondMediator.class, "RespondMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRespondMediator_InputConnector(), this.getRespondMediatorInputConnector(), null, "inputConnector", null, 0, 1, RespondMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRespondMediator_OutputConnector(), this.getRespondMediatorOutputConnector(), null, "outputConnector", null, 0, 1, RespondMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(respondMediatorInputConnectorEClass, RespondMediatorInputConnector.class, "RespondMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(respondMediatorOutputConnectorEClass, RespondMediatorOutputConnector.class, "RespondMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(smooksMediatorEClass, SmooksMediator.class, "SmooksMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSmooksMediator_ConfigurationKey(), this.getRegistryKeyProperty(), null, "configurationKey", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmooksMediator_InputType(), this.getSmooksIODataType(), "inputType", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmooksMediator_InputExpression(), this.getNamespacedProperty(), null, "inputExpression", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmooksMediator_OutputType(), this.getSmooksOutputDataType(), "outputType", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmooksMediator_OutputExpression(), this.getNamespacedProperty(), null, "outputExpression", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmooksMediator_OutputProperty(), ecorePackage.getEString(), "outputProperty", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmooksMediator_OutputAction(), this.getExpressionAction(), "outputAction", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmooksMediator_OutputMethod(), this.getOutputMethod(), "outputMethod", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmooksMediator_InputConnector(), this.getSmooksMediatorInputConnector(), null, "inputConnector", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmooksMediator_OutputConnector(), this.getSmooksMediatorOutputConnector(), null, "outputConnector", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(smooksMediatorInputConnectorEClass, SmooksMediatorInputConnector.class, "SmooksMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(smooksMediatorOutputConnectorEClass, SmooksMediatorOutputConnector.class, "SmooksMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(storeMediatorEClass, StoreMediator.class, "StoreMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStoreMediator_MessageStore(), ecorePackage.getEString(), "messageStore", null, 0, 1, StoreMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStoreMediator_OnStoreSequence(), this.getRegistryKeyProperty(), null, "onStoreSequence", null, 0, 1, StoreMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStoreMediator_InputConnector(), this.getStoreMediatorInputConnector(), null, "inputConnector", null, 0, 1, StoreMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStoreMediator_OutputConnector(), this.getStoreMediatorOutputConnector(), null, "outputConnector", null, 0, 1, StoreMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStoreMediator_AvailableMessageStores(), ecorePackage.getEString(), "availableMessageStores", null, 0, 1, StoreMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storeMediatorInputConnectorEClass, StoreMediatorInputConnector.class, "StoreMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(storeMediatorOutputConnectorEClass, StoreMediatorOutputConnector.class, "StoreMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(builderMediatorEClass, BuilderMediator.class, "BuilderMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilderMediator_MessageBuilders(), this.getMessageBuilder(), null, "messageBuilders", null, 0, -1, BuilderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderMediator_InputConnector(), this.getBuilderMediatorInputConnector(), null, "inputConnector", null, 0, 1, BuilderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderMediator_OutputConnector(), this.getBuilderMediatorOutputConector(), null, "outputConnector", null, 0, 1, BuilderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builderMediatorInputConnectorEClass, BuilderMediatorInputConnector.class, "BuilderMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(builderMediatorOutputConectorEClass, BuilderMediatorOutputConector.class, "BuilderMediatorOutputConector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(messageBuilderEClass, MessageBuilder.class, "MessageBuilder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageBuilder_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, MessageBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageBuilder_BuilderClass(), ecorePackage.getEString(), "builderClass", null, 0, 1, MessageBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageBuilder_FormatterClass(), ecorePackage.getEString(), "formatterClass", null, 0, 1, MessageBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(payloadFactoryMediatorEClass, PayloadFactoryMediator.class, "PayloadFactoryMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPayloadFactoryMediator_Payload(), ecorePackage.getEString(), "payload", null, 0, 1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPayloadFactoryMediator_PayloadKey(), this.getRegistryKeyProperty(), null, "payloadKey", null, 0, 1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPayloadFactoryMediator_Args(), this.getPayloadFactoryArgument(), null, "args", null, 0, -1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPayloadFactoryMediator_InputConnector(), this.getPayloadFactoryMediatorInputConnector(), null, "inputConnector", null, 0, 1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPayloadFactoryMediator_OutputConnector(), this.getPayloadFactoryMediatorOutputConnector(), null, "outputConnector", null, 0, 1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPayloadFactoryMediator_MediaType(), this.getMediaType(), "mediaType", "xml", 0, 1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPayloadFactoryMediator_PayloadFormat(), this.getPayloadFormatType(), "payloadFormat", null, 0, 1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(payloadFactoryMediatorInputConnectorEClass, PayloadFactoryMediatorInputConnector.class, "PayloadFactoryMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(payloadFactoryMediatorOutputConnectorEClass, PayloadFactoryMediatorOutputConnector.class, "PayloadFactoryMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(payloadFactoryArgumentEClass, PayloadFactoryArgument.class, "PayloadFactoryArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPayloadFactoryArgument_ArgumentType(), this.getPayloadFactoryArgumentType(), "argumentType", null, 0, 1, PayloadFactoryArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPayloadFactoryArgument_ArgumentValue(), ecorePackage.getEString(), "argumentValue", null, 0, 1, PayloadFactoryArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPayloadFactoryArgument_ArgumentExpression(), this.getNamespacedProperty(), null, "argumentExpression", null, 0, 1, PayloadFactoryArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPayloadFactoryArgument_Evaluator(), this.getMediaType(), "evaluator", "xml", 0, 1, PayloadFactoryArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalRouteBranchEClass, ConditionalRouteBranch.class, "ConditionalRouteBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionalRouteBranch_BreakAfterRoute(), ecorePackage.getEBoolean(), "breakAfterRoute", null, 0, 1, ConditionalRouteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouteBranch_EvaluatorExpression(), this.getEvaluatorExpressionProperty(), null, "evaluatorExpression", null, 0, 1, ConditionalRouteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouteBranch_TargetSequence(), this.getRegistryKeyProperty(), null, "targetSequence", null, 0, 1, ConditionalRouteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalRouterMediatorEClass, ConditionalRouterMediator.class, "ConditionalRouterMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionalRouterMediator_ContinueAfterRoute(), ecorePackage.getEBoolean(), "continueAfterRoute", null, 0, 1, ConditionalRouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouterMediator_ConditionalRouteBranches(), this.getConditionalRouteBranch(), null, "conditionalRouteBranches", null, 0, -1, ConditionalRouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouterMediator_InputConnector(), this.getConditionalRouterMediatorInputConnector(), null, "inputConnector", null, 0, 1, ConditionalRouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouterMediator_OutputConnector(), this.getConditionalRouterMediatorOutputConnector(), null, "outputConnector", null, 0, 1, ConditionalRouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouterMediator_AdditionalOutputConnector(), this.getConditionalRouterMediatorAdditionalOutputConnector(), null, "additionalOutputConnector", null, 0, 1, ConditionalRouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouterMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, ConditionalRouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalRouterMediatorInputConnectorEClass, ConditionalRouterMediatorInputConnector.class, "ConditionalRouterMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionalRouterMediatorOutputConnectorEClass, ConditionalRouterMediatorOutputConnector.class, "ConditionalRouterMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionalRouterMediatorAdditionalOutputConnectorEClass, ConditionalRouterMediatorAdditionalOutputConnector.class, "ConditionalRouterMediatorAdditionalOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sendMediatorEClass, SendMediator.class, "SendMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSendMediator_EndPoint(), this.getEndPoint(), null, "EndPoint", null, 0, -1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_InputConnector(), this.getSendMediatorInputConnector(), null, "InputConnector", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_OutputConnector(), this.getSendMediatorOutputConnector(), null, "OutputConnector", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSendMediator_ReceivingSequenceType(), this.getReceivingSequenceType(), "receivingSequenceType", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_StaticReceivingSequence(), this.getRegistryKeyProperty(), null, "StaticReceivingSequence", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_DynamicReceivingSequence(), this.getNamespacedProperty(), null, "DynamicReceivingSequence", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_EndpointOutputConnector(), this.getSendMediatorEndpointOutputConnector(), null, "endpointOutputConnector", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSendMediator_SkipSerialization(), ecorePackage.getEBoolean(), "skipSerialization", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSendMediator_BuildMessageBeforeSending(), ecorePackage.getEBoolean(), "buildMessageBeforeSending", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sendContainerEClass, SendContainer.class, "SendContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSendContainer_EndpointFlow(), this.getEndpointFlow(), null, "endpointFlow", null, 0, 1, SendContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sendMediatorInputConnectorEClass, SendMediatorInputConnector.class, "SendMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sendMediatorOutputConnectorEClass, SendMediatorOutputConnector.class, "SendMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sendMediatorEndpointOutputConnectorEClass, SendMediatorEndpointOutputConnector.class, "SendMediatorEndpointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(failoverEndPointEClass, FailoverEndPoint.class, "FailoverEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFailoverEndPoint_InputConnector(), this.getFailoverEndPointInputConnector(), null, "inputConnector", null, 0, 1, FailoverEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFailoverEndPoint_OutputConnector(), this.getFailoverEndPointOutputConnector(), null, "OutputConnector", null, 0, -1, FailoverEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFailoverEndPoint_WestOutputConnector(), this.getFailoverEndPointWestOutputConnector(), null, "westOutputConnector", null, 0, 1, FailoverEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFailoverEndPoint_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, FailoverEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(failoverEndPointInputConnectorEClass, FailoverEndPointInputConnector.class, "FailoverEndPointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(failoverEndPointOutputConnectorEClass, FailoverEndPointOutputConnector.class, "FailoverEndPointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(failoverEndPointWestOutputConnectorEClass, FailoverEndPointWestOutputConnector.class, "FailoverEndPointWestOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parentEndPointEClass, ParentEndPoint.class, "ParentEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParentEndPoint_Children(), this.getEndPoint(), null, "Children", null, 0, -1, ParentEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParentEndPoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, ParentEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsdlEndPointEClass, WSDLEndPoint.class, "WSDLEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWSDLEndPoint_InputConnector(), this.getWSDLEndPointInputConnector(), null, "inputConnector", null, 0, 1, WSDLEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSDLEndPoint_OutputConnector(), this.getWSDLEndPointOutputConnector(), null, "outputConnector", null, 0, 1, WSDLEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWSDLEndPoint_WsdlUri(), ecorePackage.getEString(), "wsdlUri", null, 0, 1, WSDLEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWSDLEndPoint_Service(), ecorePackage.getEString(), "service", null, 0, 1, WSDLEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWSDLEndPoint_Port(), ecorePackage.getEString(), "port", null, 0, 1, WSDLEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsdlEndPointInputConnectorEClass, WSDLEndPointInputConnector.class, "WSDLEndPointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wsdlEndPointOutputConnectorEClass, WSDLEndPointOutputConnector.class, "WSDLEndPointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadBalanceEndPointEClass, LoadBalanceEndPoint.class, "LoadBalanceEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoadBalanceEndPoint_Failover(), ecorePackage.getEBoolean(), "failover", null, 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadBalanceEndPoint_Policy(), ecorePackage.getEString(), "policy", null, 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadBalanceEndPoint_InputConnector(), this.getLoadBalanceEndPointInputConnector(), null, "inputConnector", null, 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadBalanceEndPoint_OutputConnector(), this.getLoadBalanceEndPointOutputConnector(), null, "outputConnector", null, 0, -1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadBalanceEndPoint_WestOutputConnector(), this.getLoadBalanceEndPointWestOutputConnector(), null, "westOutputConnector", null, 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadBalanceEndPoint_Member(), this.getMember(), null, "member", null, 0, -1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadBalanceEndPoint_SessionType(), this.getLoadBalanceSessionType(), "sessionType", "NONE", 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadBalanceEndPoint_Algorithm(), ecorePackage.getEString(), "algorithm", "org.apache.synapse.endpoints.algorithms.RoundRobin", 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadBalanceEndPoint_SessionTimeout(), ecorePackage.getELong(), "sessionTimeout", "0", 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadBalanceEndPoint_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memberEClass, Member.class, "Member", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMember_HostName(), ecorePackage.getEString(), "hostName", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMember_HttpPort(), ecorePackage.getEString(), "httpPort", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMember_HttpsPort(), ecorePackage.getEString(), "httpsPort", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadBalanceEndPointInputConnectorEClass, LoadBalanceEndPointInputConnector.class, "LoadBalanceEndPointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadBalanceEndPointOutputConnectorEClass, LoadBalanceEndPointOutputConnector.class, "LoadBalanceEndPointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadBalanceEndPointWestOutputConnectorEClass, LoadBalanceEndPointWestOutputConnector.class, "LoadBalanceEndPointWestOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localEntryEClass, LocalEntry.class, "LocalEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalEntry_EntryName(), ecorePackage.getEString(), "entryName", "entry_name", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalEntry_LocalEntryType(), this.getLocalEntryValueType(), "localEntryType", "In-lined Text Entry", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalEntry_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "entry_value", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalEntry_ValueXML(), ecorePackage.getEString(), "valueXML", "<value/>", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalEntry_ValueURL(), ecorePackage.getEString(), "valueURL", "file:/path/to/resource.ext", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sessionEClass, Session.class, "Session", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSession_Type(), this.getType(), "type", null, 0, 1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequencesEClass, Sequences.class, "Sequences", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequences_OutputConnector(), this.getSequencesOutputConnector(), null, "outputConnector", null, 0, 1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequences_InputConnector(), this.getSequencesInputConnector(), null, "inputConnector", null, 0, 1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequences_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequences_Name(), ecorePackage.getEString(), "name", null, 0, 1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequences_RecieveSequence(), ecorePackage.getEBoolean(), "recieveSequence", null, 0, 1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequences_AssociatedProxy(), ecorePackage.getEString(), "associatedProxy", null, 0, -1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequences_OnError(), this.getRegistryKeyProperty(), null, "onError", null, 0, 1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequences_TemplateParameters(), this.getTemplateParameter(), null, "templateParameters", null, 0, -1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequences_TraceEnabled(), ecorePackage.getEBoolean(), "traceEnabled", null, 0, 1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequences_StatisticsEnabled(), ecorePackage.getEBoolean(), "statisticsEnabled", null, 0, 1, Sequences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequencesOutputConnectorEClass, SequencesOutputConnector.class, "SequencesOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequencesInputConnectorEClass, SequencesInputConnector.class, "SequencesInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(urlRewriteRuleActionEClass, URLRewriteRuleAction.class, "URLRewriteRuleAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getURLRewriteRuleAction_RuleAction(), this.getRuleActionType(), "ruleAction", null, 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteRuleAction_RuleFragment(), this.getRuleFragmentType(), "ruleFragment", null, 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteRuleAction_RuleOption(), this.getRuleOptionType(), "ruleOption", null, 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURLRewriteRuleAction_ActionExpression(), this.getNamespacedProperty(), null, "actionExpression", null, 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteRuleAction_ActionValue(), ecorePackage.getEString(), "actionValue", null, 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteRuleAction_ActionRegex(), ecorePackage.getEString(), "actionRegex", null, 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(urlRewriteRuleEClass, URLRewriteRule.class, "URLRewriteRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getURLRewriteRule_UrlRewriteRuleCondition(), this.getEvaluatorExpressionProperty(), null, "urlRewriteRuleCondition", null, 0, 1, URLRewriteRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURLRewriteRule_RewriteRuleAction(), this.getURLRewriteRuleAction(), null, "rewriteRuleAction", null, 0, -1, URLRewriteRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(urlRewriteMediatorEClass, URLRewriteMediator.class, "URLRewriteMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getURLRewriteMediator_UrlRewriteRules(), this.getURLRewriteRule(), null, "urlRewriteRules", null, 0, -1, URLRewriteMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteMediator_InProperty(), ecorePackage.getEString(), "InProperty", null, 0, 1, URLRewriteMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteMediator_OutProperty(), ecorePackage.getEString(), "outProperty", null, 0, 1, URLRewriteMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURLRewriteMediator_InputConnector(), this.getURLRewriteMediatorInputConnector(), null, "inputConnector", null, 0, 1, URLRewriteMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURLRewriteMediator_OutputConnector(), this.getURLRewriteMediatorOutputConnector(), null, "outputConnector", null, 0, 1, URLRewriteMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(urlRewriteMediatorInputConnectorEClass, URLRewriteMediatorInputConnector.class, "URLRewriteMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(urlRewriteMediatorOutputConnectorEClass, URLRewriteMediatorOutputConnector.class, "URLRewriteMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(evaluatorExpressionPropertyEClass, EvaluatorExpressionProperty.class, "EvaluatorExpressionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvaluatorExpressionProperty_PrettyName(), ecorePackage.getEString(), "prettyName", null, 0, 1, EvaluatorExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvaluatorExpressionProperty_EvaluatorName(), ecorePackage.getEString(), "evaluatorName", null, 0, 1, EvaluatorExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvaluatorExpressionProperty_EvaluatorValue(), ecorePackage.getEString(), "evaluatorValue", null, 0, 1, EvaluatorExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validateMediatorEClass, ValidateMediator.class, "ValidateMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidateMediator_SourceXpath(), this.getNamespacedProperty(), null, "sourceXpath", null, 0, 1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_Features(), this.getValidateFeature(), null, "features", null, 0, -1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_Schemas(), this.getValidateSchema(), null, "schemas", null, 0, -1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_InputConnector(), this.getValidateMediatorInputConnector(), null, "inputConnector", null, 0, 1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_OutputConnector(), this.getValidateMediatorOutputConnector(), null, "outputConnector", null, 0, 1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_OnFailOutputConnector(), this.getValidateMediatorOnFailOutputConnector(), null, "onFailOutputConnector", null, 0, 1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_Resources(), this.getValidateResource(), null, "resources", null, 0, -1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validateResourceEClass, ValidateResource.class, "ValidateResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(validateFeatureEClass, ValidateFeature.class, "ValidateFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(validateSchemaEClass, ValidateSchema.class, "ValidateSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidateSchema_ValidateStaticSchemaKey(), this.getRegistryKeyProperty(), null, "validateStaticSchemaKey", null, 0, 1, ValidateSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateSchema_ValidateDynamicSchemaKey(), this.getNamespacedProperty(), null, "validateDynamicSchemaKey", null, 0, 1, ValidateSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidateSchema_ValidateSchemaKeyType(), this.getKeyType(), "validateSchemaKeyType", null, 0, 1, ValidateSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateSchema_SchemaKey(), this.getRegistryKeyProperty(), null, "schemaKey", null, 0, 1, ValidateSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validateMediatorInputConnectorEClass, ValidateMediatorInputConnector.class, "ValidateMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(validateMediatorOutputConnectorEClass, ValidateMediatorOutputConnector.class, "ValidateMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(validateMediatorOnFailOutputConnectorEClass, ValidateMediatorOnFailOutputConnector.class, "ValidateMediatorOnFailOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endpointDiagramEClass, EndpointDiagram.class, "EndpointDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndpointDiagram_Child(), this.getEndPoint(), null, "child", null, 0, 1, EndpointDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndpointDiagram_Name(), ecorePackage.getEString(), "name", null, 0, 1, EndpointDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedEndpointEClass, NamedEndpoint.class, "NamedEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedEndpoint_InputConnector(), this.getNamedEndpointInputConnector(), null, "inputConnector", null, 0, 1, NamedEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedEndpoint_OutputConnector(), this.getNamedEndpointOutputConnector(), null, "outputConnector", null, 0, 1, NamedEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedEndpoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedEndpoint_ReferringEndpointType(), this.getKeyType(), "referringEndpointType", null, 0, 1, NamedEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedEndpoint_DynamicReferenceKey(), this.getNamespacedProperty(), null, "dynamicReferenceKey", null, 0, 1, NamedEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedEndpoint_StaticReferenceKey(), this.getRegistryKeyProperty(), null, "staticReferenceKey", null, 0, 1, NamedEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedEndpointInputConnectorEClass, NamedEndpointInputConnector.class, "NamedEndpointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedEndpointOutputConnectorEClass, NamedEndpointOutputConnector.class, "NamedEndpointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateEClass, Template.class, "Template", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemplate_Name(), ecorePackage.getEString(), "name", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplate_TemplateType(), this.getTemplateType(), "templateType", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplate_Child(), this.getEsbElement(), null, "child", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplate_Parameters(), this.getTemplateParameter(), null, "parameters", null, 0, -1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateParameterEClass, TemplateParameter.class, "TemplateParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemplateParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, TemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTask_TaskName(), ecorePackage.getEString(), "taskName", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_TaskGroup(), ecorePackage.getEString(), "taskGroup", "synapse.simple.quartz", 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_TriggerType(), this.getTaskTriggerType(), "triggerType", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Count(), ecorePackage.getELong(), "count", "-1", 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Interval(), ecorePackage.getELong(), "interval", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Cron(), ecorePackage.getEString(), "cron", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_PinnedServers(), ecorePackage.getEString(), "pinnedServers", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_TaskImplementation(), ecorePackage.getEString(), "taskImplementation", "org.apache.synapse.startup.tasks.MessageInjector", 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTask_TaskProperties(), this.getTaskProperty(), null, "taskProperties", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameValueTypePropertyEClass, NameValueTypeProperty.class, "NameValueTypeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameValueTypeProperty_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, NameValueTypeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNameValueTypeProperty_PropertyValue(), ecorePackage.getEString(), "propertyValue", null, 0, 1, NameValueTypeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNameValueTypeProperty_PropertyType(), this.getTaskPropertyType(), "propertyType", null, 0, 1, NameValueTypeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskPropertyEClass, TaskProperty.class, "TaskProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(synapseAPIEClass, SynapseAPI.class, "SynapseAPI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSynapseAPI_ApiName(), ecorePackage.getEString(), "apiName", "api_name", 1, 1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynapseAPI_Context(), ecorePackage.getEString(), "context", "/context", 1, 1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynapseAPI_HostName(), ecorePackage.getEString(), "hostName", null, 0, 1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynapseAPI_Port(), ecorePackage.getEInt(), "port", null, 0, 1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynapseAPI_Resources(), this.getAPIResource(), null, "resources", null, 0, -1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynapseAPI_Handlers(), this.getAPIHandler(), null, "handlers", null, 0, -1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(apiResourceEClass, APIResource.class, "APIResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAPIResource_InputConnector(), this.getAPIResourceInputConnector(), null, "inputConnector", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResource_OutputConnector(), this.getAPIResourceOutputConnector(), null, "outputConnector", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResource_OutSequenceOutputConnector(), this.getAPIResourceOutSequenceOutputConnector(), null, "outSequenceOutputConnector", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResource_InSequenceInputConnectors(), this.getAPIResourceInSequenceInputConnector(), null, "inSequenceInputConnectors", null, 0, -1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResource_FaultInputConnector(), this.getAPIResourceFaultInputConnector(), null, "faultInputConnector", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_UrlStyle(), this.getApiResourceUrlStyle(), "urlStyle", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_UriTemplate(), ecorePackage.getEString(), "uriTemplate", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_UrlMapping(), ecorePackage.getEString(), "urlMapping", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_AllowGet(), ecorePackage.getEBoolean(), "allowGet", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_AllowPost(), ecorePackage.getEBoolean(), "allowPost", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_AllowPut(), ecorePackage.getEBoolean(), "allowPut", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_AllowDelete(), ecorePackage.getEBoolean(), "allowDelete", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_AllowOptions(), ecorePackage.getEBoolean(), "allowOptions", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_AllowHead(), ecorePackage.getEBoolean(), "allowHead", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_AllowPatch(), ecorePackage.getEBoolean(), "allowPatch", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResource_Container(), this.getProxyServiceContainer(), null, "container", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_InSequenceType(), this.getSequenceType(), "inSequenceType", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResource_InSequenceKey(), this.getRegistryKeyProperty(), null, "inSequenceKey", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_InSequenceName(), ecorePackage.getEString(), "inSequenceName", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_OutSequenceType(), this.getSequenceType(), "outSequenceType", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResource_OutSequenceKey(), this.getRegistryKeyProperty(), null, "outSequenceKey", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_OutSequenceName(), ecorePackage.getEString(), "outSequenceName", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_FaultSequenceType(), this.getSequenceType(), "faultSequenceType", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResource_FaultSequenceKey(), this.getRegistryKeyProperty(), null, "faultSequenceKey", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_FaultSequenceName(), ecorePackage.getEString(), "faultSequenceName", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIResource_Protocol(), this.getProtocol(), "protocol", null, 0, 1, APIResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(apiResourceInputConnectorEClass, APIResourceInputConnector.class, "APIResourceInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiResourceOutputConnectorEClass, APIResourceOutputConnector.class, "APIResourceOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiResourceOutSequenceOutputConnectorEClass, APIResourceOutSequenceOutputConnector.class, "APIResourceOutSequenceOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiResourceInSequenceInputConnectorEClass, APIResourceInSequenceInputConnector.class, "APIResourceInSequenceInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiResourceFaultInputConnectorEClass, APIResourceFaultInputConnector.class, "APIResourceFaultInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiResourceEndpointEClass, APIResourceEndpoint.class, "APIResourceEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAPIResourceEndpoint_InputConnector(), this.getAPIResourceEndpointInputConnector(), null, "inputConnector", null, 0, 1, APIResourceEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIResourceEndpoint_OutputConnector(), this.getAPIResourceEndpointOutputConnector(), null, "outputConnector", null, 0, 1, APIResourceEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(apiResourceEndpointInputConnectorEClass, APIResourceEndpointInputConnector.class, "APIResourceEndpointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiResourceEndpointOutputConnectorEClass, APIResourceEndpointOutputConnector.class, "APIResourceEndpointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexEndpointsEClass, ComplexEndpoints.class, "ComplexEndpoints", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexEndpoints_OutputConnector(), this.getComplexEndpointsOutputConnector(), null, "outputConnector", null, 0, -1, ComplexEndpoints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexEndpoints_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, ComplexEndpoints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComplexEndpoints_Name(), ecorePackage.getEString(), "name", null, 0, 1, ComplexEndpoints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexEndpointsOutputConnectorEClass, ComplexEndpointsOutputConnector.class, "ComplexEndpointsOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressingEndpointEClass, AddressingEndpoint.class, "AddressingEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddressingEndpoint_InputConnector(), this.getAddressingEndpointInputConnector(), null, "inputConnector", null, 0, 1, AddressingEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddressingEndpoint_OutputConnector(), this.getAddressingEndpointOutputConnector(), null, "outputConnector", null, 0, 1, AddressingEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addressingEndpointInputConnectorEClass, AddressingEndpointInputConnector.class, "AddressingEndpointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressingEndpointOutputConnectorEClass, AddressingEndpointOutputConnector.class, "AddressingEndpointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recipientListEndPointEClass, RecipientListEndPoint.class, "RecipientListEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecipientListEndPoint_InputConnector(), this.getRecipientListEndPointInputConnector(), null, "inputConnector", null, 0, 1, RecipientListEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecipientListEndPoint_OutputConnector(), this.getRecipientListEndPointOutputConnector(), null, "outputConnector", null, 0, -1, RecipientListEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecipientListEndPoint_WestOutputConnector(), this.getRecipientListEndPointWestOutputConnector(), null, "westOutputConnector", null, 0, 1, RecipientListEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipientListEndPoint_EndpointType(), this.getRecipientListEndpointType(), "endpointType", null, 0, 1, RecipientListEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipientListEndPoint_EndpointsValue(), ecorePackage.getEString(), "endpointsValue", null, 0, 1, RecipientListEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecipientListEndPoint_EndpointsExpression(), this.getNamespacedProperty(), null, "endpointsExpression", null, 0, 1, RecipientListEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipientListEndPoint_MaxCache(), ecorePackage.getEInt(), "maxCache", "20", 0, 1, RecipientListEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecipientListEndPoint_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, RecipientListEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recipientListEndPointInputConnectorEClass, RecipientListEndPointInputConnector.class, "RecipientListEndPointInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recipientListEndPointOutputConnectorEClass, RecipientListEndPointOutputConnector.class, "RecipientListEndPointOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recipientListEndPointWestOutputConnectorEClass, RecipientListEndPointWestOutputConnector.class, "RecipientListEndPointWestOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(messageStoreParameterEClass, MessageStoreParameter.class, "MessageStoreParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageStoreParameter_ParameterName(), ecorePackage.getEString(), "parameterName", null, 0, 1, MessageStoreParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStoreParameter_ParameterValue(), ecorePackage.getEString(), "parameterValue", null, 0, 1, MessageStoreParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageStoreEClass, MessageStore.class, "MessageStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageStore_StoreName(), ecorePackage.getEString(), "storeName", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_StoreType(), this.getMessageStoreType(), "storeType", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_InitialContextFactory(), ecorePackage.getEString(), "initialContextFactory", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_ProviderURL(), ecorePackage.getEString(), "providerURL", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JndiQueueName(), ecorePackage.getEString(), "jndiQueueName", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_ConnectionFactory(), ecorePackage.getEString(), "connectionFactory", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_UserName(), ecorePackage.getEString(), "userName", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_Password(), ecorePackage.getEString(), "password", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JmsSpecVersion(), this.getJMSSpecVersion(), "jmsSpecVersion", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_EnableCaching(), ecorePackage.getEBoolean(), "enableCaching", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_ProviderClass(), ecorePackage.getEString(), "providerClass", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_RabbitMQServerHostName(), ecorePackage.getEString(), "rabbitMQServerHostName", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_RabbitMQServerHostPort(), ecorePackage.getEString(), "rabbitMQServerHostPort", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_RabbitMQQueueName(), ecorePackage.getEString(), "rabbitMQQueueName", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_RabbitMQExchangeName(), ecorePackage.getEString(), "rabbitMQExchangeName", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_RoutingKey(), ecorePackage.getEString(), "routingKey", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_RabbitMQUserName(), ecorePackage.getEString(), "rabbitMQUserName", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_RabbitMQPassword(), ecorePackage.getEString(), "rabbitMQPassword", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_VirtualHost(), ecorePackage.getEString(), "virtualHost", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JdbcDatabaseTable(), ecorePackage.getEString(), "jdbcDatabaseTable", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JdbcConnectionInformation(), this.getJDBCConnectionInformationType(), "jdbcConnectionInformation", "JDBC_POOL", 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JdbcDriver(), ecorePackage.getEString(), "jdbcDriver", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JdbcURL(), ecorePackage.getEString(), "jdbcURL", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JdbcUser(), ecorePackage.getEString(), "jdbcUser", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JdbcPassword(), ecorePackage.getEString(), "jdbcPassword", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_JdbcDatasourceName(), ecorePackage.getEString(), "jdbcDatasourceName", null, 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageStore_Parameters(), this.getMessageStoreParameter(), null, "parameters", null, 0, -1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_EnableProducerGuaranteedDelivery(), ecorePackage.getEBoolean(), "enableProducerGuaranteedDelivery", "false", 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageStore_FailoverMessageStore(), ecorePackage.getEString(), "failoverMessageStore", "", 0, 1, MessageStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageProcessorParameterEClass, MessageProcessorParameter.class, "MessageProcessorParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageProcessorParameter_ParameterName(), ecorePackage.getEString(), "parameterName", null, 0, 1, MessageProcessorParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessorParameter_ParameterValue(), ecorePackage.getEString(), "parameterValue", null, 0, 1, MessageProcessorParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageProcessorEClass, MessageProcessor.class, "MessageProcessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageProcessor_ProcessorName(), ecorePackage.getEString(), "processorName", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_ProcessorType(), this.getMessageProcessorType(), "processorType", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_MessageProcessorProvider(), ecorePackage.getEString(), "messageProcessorProvider", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_MessageStore(), ecorePackage.getEString(), "messageStore", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_SourceMessageStore(), ecorePackage.getEString(), "sourceMessageStore", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_TargetMessageStore(), ecorePackage.getEString(), "targetMessageStore", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_ProcessorState(), this.getProcessorState(), "processorState", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageProcessor_EndpointName(), this.getRegistryKeyProperty(), null, "endpointName", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageProcessor_Sequence(), this.getRegistryKeyProperty(), null, "sequence", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_RetryInterval(), ecorePackage.getELong(), "retryInterval", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_ForwardingInterval(), ecorePackage.getELong(), "forwardingInterval", "1000", 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_SamplingInterval(), ecorePackage.getELong(), "samplingInterval", "1000", 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_SamplingConcurrency(), ecorePackage.getEInt(), "samplingConcurrency", "1", 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_MaxDeliveryAttempts(), ecorePackage.getEInt(), "maxDeliveryAttempts", "4", 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_DropMessageAfterMaximumDeliveryAttempts(), this.getEnableDisableState(), "dropMessageAfterMaximumDeliveryAttempts", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_Axis2ClientRepository(), ecorePackage.getEString(), "axis2ClientRepository", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_Axis2Configuration(), ecorePackage.getEString(), "axis2Configuration", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageProcessor_ReplySequenceName(), this.getRegistryKeyProperty(), null, "replySequenceName", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageProcessor_FaultSequenceName(), this.getRegistryKeyProperty(), null, "faultSequenceName", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageProcessor_DeactivateSequenceName(), this.getRegistryKeyProperty(), null, "deactivateSequenceName", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_QuartzConfigFilePath(), ecorePackage.getEString(), "quartzConfigFilePath", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_CronExpression(), ecorePackage.getEString(), "cronExpression", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_NonRetryHttpStatusCodes(), ecorePackage.getEString(), "nonRetryHttpStatusCodes", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageProcessor_Parameters(), this.getMessageProcessorParameter(), null, "parameters", null, 0, -1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageProcessor_TaskCount(), ecorePackage.getEString(), "taskCount", null, 0, 1, MessageProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(apiHandlerEClass, APIHandler.class, "APIHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAPIHandler_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, APIHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAPIHandler_Properties(), this.getAPIHandlerProperty(), null, "properties", null, 0, -1, APIHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(apiHandlerPropertyEClass, APIHandlerProperty.class, "APIHandlerProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAPIHandlerProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, APIHandlerProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPIHandlerProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, APIHandlerProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloudConnectorEClass, CloudConnector.class, "CloudConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCloudConnector_InputConnector(), this.getCloudConnectorInputConnector(), null, "inputConnector", null, 0, 1, CloudConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloudConnector_OutputConnector(), this.getCloudConnectorOutputConnector(), null, "outputConnector", null, 0, 1, CloudConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloudConnector_ConnectorParameters(), this.getCallTemplateParameter(), null, "connectorParameters", null, 0, -1, CloudConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloudConnectorInputConnectorEClass, CloudConnectorInputConnector.class, "CloudConnectorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cloudConnectorOutputConnectorEClass, CloudConnectorOutputConnector.class, "CloudConnectorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cloudConnectorOperationEClass, CloudConnectorOperation.class, "CloudConnectorOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCloudConnectorOperation_InputConnector(), this.getCloudConnectorOperationInputConnector(), null, "inputConnector", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloudConnectorOperation_OutputConnector(), this.getCloudConnectorOperationOutputConnector(), null, "outputConnector", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloudConnectorOperation_ConnectorParameters(), this.getCallTemplateParameter(), null, "connectorParameters", null, 0, -1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloudConnectorOperation_ConfigRef(), ecorePackage.getEString(), "configRef", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloudConnectorOperation_ConnectorName(), ecorePackage.getEString(), "connectorName", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloudConnectorOperation_OperationName(), ecorePackage.getEString(), "operationName", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloudConnectorOperation_CloudConnectorName(), ecorePackage.getEString(), "cloudConnectorName", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloudConnectorOperation_NewConfig(), this.getRegistryKeyProperty(), null, "newConfig", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloudConnectorOperation_AvailableConfigs(), ecorePackage.getEString(), "availableConfigs", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloudConnectorOperation_ParameterEditorType(), this.getCloudConnectorOperationParamEditorType(), "parameterEditorType", null, 0, 1, CloudConnectorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloudConnectorOperationInputConnectorEClass, CloudConnectorOperationInputConnector.class, "CloudConnectorOperationInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cloudConnectorOperationOutputConnectorEClass, CloudConnectorOperationOutputConnector.class, "CloudConnectorOperationOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataMapperMediatorEClass, DataMapperMediator.class, "DataMapperMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataMapperMediator_InputConnector(), this.getDataMapperMediatorInputConnector(), null, "inputConnector", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataMapperMediator_InputType(), this.getDataMapperMediatorDataTypes(), "inputType", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMapperMediator_OutputConnector(), this.getDataMapperMediatorOutputConnector(), null, "outputConnector", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMapperMediator_Configuration(), this.getRegistryKeyProperty(), null, "configuration", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMapperMediator_InputSchema(), this.getRegistryKeyProperty(), null, "InputSchema", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMapperMediator_OutputSchema(), this.getRegistryKeyProperty(), null, "outputSchema", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataMapperMediator_ConfigurationLocalPath(), ecorePackage.getEString(), "configurationLocalPath", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataMapperMediator_InputSchemaLocalPath(), ecorePackage.getEString(), "inputSchemaLocalPath", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataMapperMediator_OutputSchemaLocalPath(), ecorePackage.getEString(), "outputSchemaLocalPath", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataMapperMediator_OutputType(), this.getDataMapperMediatorDataTypes(), "outputType", null, 0, 1, DataMapperMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataMapperMediatorInputConnectorEClass, DataMapperMediatorInputConnector.class, "DataMapperMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataMapperMediatorOutputConnectorEClass, DataMapperMediatorOutputConnector.class, "DataMapperMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fastXSLTMediatorEClass, FastXSLTMediator.class, "FastXSLTMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFastXSLTMediator_FastXsltSchemaKeyType(), this.getKeyType(), "fastXsltSchemaKeyType", null, 0, 1, FastXSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFastXSLTMediator_FastXsltStaticSchemaKey(), this.getRegistryKeyProperty(), null, "fastXsltStaticSchemaKey", null, 0, 1, FastXSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFastXSLTMediator_FastXsltDynamicSchemaKey(), this.getNamespacedProperty(), null, "fastXsltDynamicSchemaKey", null, 0, 1, FastXSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFastXSLTMediator_InputConnector(), this.getFastXSLTMediatorInputConnector(), null, "inputConnector", null, 0, 1, FastXSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFastXSLTMediator_OutputConnector(), this.getFastXSLTMediatorOutputConnector(), null, "outputConnector", null, 0, 1, FastXSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fastXSLTMediatorInputConnectorEClass, FastXSLTMediatorInputConnector.class, "FastXSLTMediatorInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fastXSLTMediatorOutputConnectorEClass, FastXSLTMediatorOutputConnector.class, "FastXSLTMediatorOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inboundEndpointEClass, InboundEndpoint.class, "InboundEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInboundEndpoint_SequenceInputConnector(), this.getInboundEndpointSequenceInputConnector(), null, "sequenceInputConnector", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInboundEndpoint_SequenceOutputConnector(), this.getInboundEndpointSequenceOutputConnector(), null, "sequenceOutputConnector", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInboundEndpoint_OnErrorSequenceInputConnector(), this.getInboundEndpointOnErrorSequenceInputConnector(), null, "onErrorSequenceInputConnector", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInboundEndpoint_OnErrorSequenceOutputConnector(), this.getInboundEndpointOnErrorSequenceOutputConnector(), null, "onErrorSequenceOutputConnector", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInboundEndpoint_Container(), this.getInboundEndpointContainer(), null, "container", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Type(), this.getInboundEndpointType(), "type", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Class(), ecorePackage.getEString(), "class", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Protocol(), ecorePackage.getEString(), "protocol", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundEndpointBehaviour(), this.getInboundEndpointBehaviourType(), "inboundEndpointBehaviour", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHttpPort(), ecorePackage.getEString(), "inboundHttpPort", "8000", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundWorkerPoolSizeCore(), ecorePackage.getEString(), "inboundWorkerPoolSizeCore", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundWorkerPoolSizeMax(), ecorePackage.getEString(), "inboundWorkerPoolSizeMax", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundWorkerThreadKeepAliveSec(), ecorePackage.getEString(), "inboundWorkerThreadKeepAliveSec", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundWorkerPoolQueueLength(), ecorePackage.getEString(), "inboundWorkerPoolQueueLength", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundThreadGroupId(), ecorePackage.getEString(), "inboundThreadGroupId", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundThreadId(), ecorePackage.getEString(), "inboundThreadId", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_DispatchFilterPattern(), ecorePackage.getEString(), "dispatchFilterPattern", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Interval(), ecorePackage.getEString(), "interval", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Sequential(), ecorePackage.getEBoolean(), "sequential", "true", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Coordination(), ecorePackage.getEBoolean(), "coordination", "true", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSFileURI(), ecorePackage.getEString(), "transportVFSFileURI", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSContentType(), ecorePackage.getEString(), "transportVFSContentType", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSFileNamePattern(), ecorePackage.getEString(), "transportVFSFileNamePattern", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSFileProcessInterval(), ecorePackage.getEString(), "transportVFSFileProcessInterval", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSFileProcessCount(), ecorePackage.getEString(), "transportVFSFileProcessCount", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSLocking(), this.getEnable(), "transportVFSLocking", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSMaxRetryCount(), ecorePackage.getEString(), "transportVFSMaxRetryCount", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSReconnectTimeout(), ecorePackage.getEString(), "transportVFSReconnectTimeout", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSActionAfterProcess(), this.getVFSAction(), "transportVFSActionAfterProcess", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSMoveAfterProcess(), ecorePackage.getEString(), "transportVFSMoveAfterProcess", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSActionAfterErrors(), this.getVFSAction(), "transportVFSActionAfterErrors", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSMoveAfterErrors(), ecorePackage.getEString(), "transportVFSMoveAfterErrors", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSActionAfterFailure(), this.getVFSAction(), "transportVFSActionAfterFailure", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSMoveAfterFailure(), ecorePackage.getEString(), "transportVFSMoveAfterFailure", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSAutoLockRelease(), ecorePackage.getEBoolean(), "transportVFSAutoLockRelease", "false", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSAutoLockReleaseInterval(), ecorePackage.getEString(), "transportVFSAutoLockReleaseInterval", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSLockReleaseSameNode(), ecorePackage.getEBoolean(), "transportVFSLockReleaseSameNode", "false", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSDistributedLock(), ecorePackage.getEBoolean(), "transportVFSDistributedLock", "false", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSStreaming(), ecorePackage.getEBoolean(), "transportVFSStreaming", "false", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSBuild(), ecorePackage.getEBoolean(), "transportVFSBuild", "false", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSDistributedTimeout(), ecorePackage.getEString(), "transportVFSDistributedTimeout", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_JavaNamingFactoryInitial(), ecorePackage.getEString(), "javaNamingFactoryInitial", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_JavaNamingProviderUrl(), ecorePackage.getEString(), "javaNamingProviderUrl", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSConnectionFactoryJNDIName(), ecorePackage.getEString(), "transportJMSConnectionFactoryJNDIName", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSConnectionFactoryType(), this.getJMSConnectionFactoryType(), "transportJMSConnectionFactoryType", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSDestination(), ecorePackage.getEString(), "transportJMSDestination", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSSessionTransacted(), ecorePackage.getEBoolean(), "transportJMSSessionTransacted", "false", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSSessionAcknowledgement(), this.getJMSSessionAcknowledgement(), "transportJMSSessionAcknowledgement", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSCacheLevel(), this.getJMSCacheLevel(), "transportJMSCacheLevel", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSUserName(), ecorePackage.getEString(), "transportJMSUserName", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSPassword(), ecorePackage.getEString(), "transportJMSPassword", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSJMSSpecVersion(), ecorePackage.getEString(), "transportJMSJMSSpecVersion", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSSubscriptionDurable(), ecorePackage.getEString(), "transportJMSSubscriptionDurable", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSDurableSubscriberClientID(), ecorePackage.getEString(), "transportJMSDurableSubscriberClientID", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSMessageSelector(), ecorePackage.getEString(), "transportJMSMessageSelector", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSMoveTimestampFormat(), ecorePackage.getEString(), "transportVFSMoveTimestampFormat", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSFileSortAttribute(), this.getVFSFileSort(), "transportVFSFileSortAttribute", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSFileSortAscending(), ecorePackage.getEBoolean(), "transportVFSFileSortAscending", "true", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSSubFolderTimestampFormat(), ecorePackage.getEString(), "transportVFSSubFolderTimestampFormat", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportVFSCreateFolder(), ecorePackage.getEBoolean(), "transportVFSCreateFolder", "true", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSReceiveTimeout(), ecorePackage.getEString(), "transportJMSReceiveTimeout", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSContentType(), ecorePackage.getEString(), "transportJMSContentType", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSContentTypeProperty(), ecorePackage.getEString(), "transportJMSContentTypeProperty", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSReplyDestination(), ecorePackage.getEString(), "transportJMSReplyDestination", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSPubSubNoLocal(), ecorePackage.getEString(), "transportJMSPubSubNoLocal", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportJMSDurableSubscriberName(), ecorePackage.getEString(), "transportJMSDurableSubscriberName", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTConnectionFactory(), ecorePackage.getEString(), "transportMQTTConnectionFactory", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTServerHostName(), ecorePackage.getEString(), "transportMQTTServerHostName", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTServerPort(), ecorePackage.getEString(), "transportMQTTServerPort", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTTopicName(), ecorePackage.getEString(), "transportMQTTTopicName", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTSubscriptionQOS(), this.getMQTTSubscriptionQOS(), "transportMQTTSubscriptionQOS", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTSessionClean(), ecorePackage.getEBoolean(), "transportMQTTSessionClean", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTSslEnable(), ecorePackage.getEString(), "transportMQTTSslEnable", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTTemporaryStoreDirectory(), ecorePackage.getEString(), "transportMQTTTemporaryStoreDirectory", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTSubscriptionUsername(), ecorePackage.getEString(), "transportMQTTSubscriptionUsername", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTSubscriptionPassword(), ecorePackage.getEString(), "transportMQTTSubscriptionPassword", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportMQTTClientId(), ecorePackage.getEString(), "transportMQTTClientId", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Truststore(), ecorePackage.getEString(), "truststore", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Keystore(), ecorePackage.getEString(), "keystore", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SslVerifyClient(), ecorePackage.getEString(), "sslVerifyClient", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SslProtocol(), ecorePackage.getEString(), "sslProtocol", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_HttpsProtocols(), ecorePackage.getEString(), "httpsProtocols", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_CertificateRevocationVerifier(), ecorePackage.getEString(), "certificateRevocationVerifier", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHL7Port(), ecorePackage.getEString(), "inboundHL7Port", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHL7AutoAck(), ecorePackage.getEBoolean(), "inboundHL7AutoAck", "true", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHL7MessagePreProcessor(), ecorePackage.getEString(), "inboundHL7MessagePreProcessor", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHL7CharSet(), ecorePackage.getEString(), "inboundHL7CharSet", "UTF-8", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHL7TimeOut(), ecorePackage.getEString(), "inboundHL7TimeOut", "10000", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHL7ValidateMessage(), ecorePackage.getEBoolean(), "inboundHL7ValidateMessage", "true", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHL7BuildInvalidMessages(), ecorePackage.getEBoolean(), "inboundHL7BuildInvalidMessages", "true", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundHL7PassThroughInvalidMessages(), ecorePackage.getEBoolean(), "inboundHL7PassThroughInvalidMessages", "true", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ZookeeperConnect(), ecorePackage.getEString(), "zookeeperConnect", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_GroupId(), ecorePackage.getEString(), "groupId", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ContentType(), this.getContentType(), "contentType", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ConsumerType(), this.getConsumerType(), "consumerType", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TopicsOrTopicFilter(), this.getTopicsType(), "topicsOrTopicFilter", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TopicsName(), ecorePackage.getEString(), "topicsName", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TopicFilterFrom(), this.getTopicFilterFromType(), "topicFilterFrom", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TopicFilterName(), ecorePackage.getEString(), "topicFilterName", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SimpleConsumerTopic(), ecorePackage.getEString(), "simpleConsumerTopic", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SimpleConsumerBrokers(), ecorePackage.getEString(), "simpleConsumerBrokers", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SimpleConsumerPort(), ecorePackage.getEString(), "simpleConsumerPort", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SimpleConsumerPartition(), ecorePackage.getEString(), "simpleConsumerPartition", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SimpleConsumerMaxMessagesToRead(), ecorePackage.getEString(), "simpleConsumerMaxMessagesToRead", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ThreadCount(), ecorePackage.getEString(), "threadCount", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ConsumerId(), ecorePackage.getEString(), "consumerId", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SocketTimeoutMs(), ecorePackage.getEInt(), "socketTimeoutMs", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_SocketReceiveBufferBytes(), ecorePackage.getEString(), "socketReceiveBufferBytes", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_FetchMessageMaxBytes(), ecorePackage.getEString(), "fetchMessageMaxBytes", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_NumConsumerFetches(), ecorePackage.getEString(), "numConsumerFetches", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_AutoCommitEnable(), ecorePackage.getEBoolean(), "autoCommitEnable", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_AutoCommitIntervalMs(), ecorePackage.getEString(), "autoCommitIntervalMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_QueuedMaxMessageChunks(), ecorePackage.getEString(), "queuedMaxMessageChunks", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_RebalanceMaxRetries(), ecorePackage.getEString(), "rebalanceMaxRetries", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_FetchMinBytes(), ecorePackage.getEString(), "fetchMinBytes", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_FetchWaitMaxMs(), ecorePackage.getEString(), "fetchWaitMaxMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_RebalanceBackoffMs(), ecorePackage.getEString(), "rebalanceBackoffMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_RefreshLeaderBackoffMs(), ecorePackage.getEString(), "refreshLeaderBackoffMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_AutoOffsetReset(), this.getAutoOffsetResetType(), "autoOffsetReset", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ConsumerTimeoutMs(), ecorePackage.getEString(), "consumerTimeoutMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ExcludeInternalTopics(), ecorePackage.getEBoolean(), "excludeInternalTopics", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_PartitionAssignmentStrategy(), this.getPartitionAssignmentStrategyType(), "partitionAssignmentStrategy", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ClientId(), ecorePackage.getEString(), "clientId", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ZookeeperSessionTimeoutMs(), ecorePackage.getEString(), "zookeeperSessionTimeoutMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ZookeeperConnectionTimeoutMs(), ecorePackage.getEString(), "zookeeperConnectionTimeoutMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_ZookeeperSyncTimeMs(), ecorePackage.getEString(), "zookeeperSyncTimeMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_OffsetsStorage(), this.getOffsetsStorageType(), "offsetsStorage", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_OffsetsChannelBackoffMs(), ecorePackage.getEString(), "offsetsChannelBackoffMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_OffsetsChannelSocketTimeoutMs(), ecorePackage.getEString(), "offsetsChannelSocketTimeoutMs", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_OffsetsCommitMaxRetries(), ecorePackage.getEString(), "offsetsCommitMaxRetries", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_DualCommitEnabled(), ecorePackage.getEBoolean(), "dualCommitEnabled", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundCxfRmHost(), ecorePackage.getEString(), "inboundCxfRmHost", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundCxfRmPort(), ecorePackage.getEString(), "inboundCxfRmPort", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_InboundCxfRmConfigFile(), ecorePackage.getEString(), "inboundCxfRmConfigFile", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_EnableSSL(), ecorePackage.getEBoolean(), "enableSSL", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInboundEndpoint_ServiceParameters(), this.getInboundEndpointParameter(), null, "serviceParameters", null, 0, -1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_Suspend(), ecorePackage.getEBoolean(), "suspend", "false", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionFactory(), ecorePackage.getEString(), "transportRabbitMqConnectionFactory", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqServerHostName(), ecorePackage.getEString(), "transportRabbitMqServerHostName", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqServerPort(), ecorePackage.getEString(), "transportRabbitMqServerPort", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqServerUserName(), ecorePackage.getEString(), "transportRabbitMqServerUserName", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqServerPassword(), ecorePackage.getEString(), "transportRabbitMqServerPassword", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqQueueName(), ecorePackage.getEString(), "transportRabbitMqQueueName", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqExchangeName(), ecorePackage.getEString(), "transportRabbitMqExchangeName", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqQueueDurable(), ecorePackage.getEString(), "transportRabbitMqQueueDurable", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqQueueExclusive(), ecorePackage.getEString(), "transportRabbitMqQueueExclusive", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqQueueAutoDelete(), ecorePackage.getEString(), "transportRabbitMqQueueAutoDelete", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqQueueAutoAck(), ecorePackage.getEString(), "transportRabbitMqQueueAutoAck", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqQueueRoutingKey(), ecorePackage.getEString(), "transportRabbitMqQueueRoutingKey", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqQueueDeliveryMode(), ecorePackage.getEString(), "transportRabbitMqQueueDeliveryMode", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqExchangeType(), ecorePackage.getEString(), "transportRabbitMqExchangeType", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqExchangeDurable(), ecorePackage.getEString(), "transportRabbitMqExchangeDurable", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqExchangeAutoDelete(), ecorePackage.getEString(), "transportRabbitMqExchangeAutoDelete", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqServerVirtualHost(), ecorePackage.getEString(), "transportRabbitMqServerVirtualHost", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqFactoryHeartbeat(), ecorePackage.getEString(), "transportRabbitMqFactoryHeartbeat", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionSslEnabled(), ecorePackage.getEString(), "transportRabbitMqConnectionSslEnabled", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreLocation(), ecorePackage.getEString(), "transportRabbitMqConnectionSslKeystoreLocation", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionSslKeystoreType(), ecorePackage.getEString(), "transportRabbitMqConnectionSslKeystoreType", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionSslKeystorePassword(), ecorePackage.getEString(), "transportRabbitMqConnectionSslKeystorePassword", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreLocation(), ecorePackage.getEString(), "transportRabbitMqConnectionSslTruststoreLocation", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionSslTruststoreType(), ecorePackage.getEString(), "transportRabbitMqConnectionSslTruststoreType", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionSslTruststorePassword(), ecorePackage.getEString(), "transportRabbitMqConnectionSslTruststorePassword", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportRabbitMqConnectionSslVersion(), ecorePackage.getEString(), "transportRabbitMqConnectionSslVersion", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportFeedURL(), ecorePackage.getEString(), "transportFeedURL", "", 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpoint_TransportFeedType(), this.getFeedType(), "transportFeedType", null, 0, 1, InboundEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inboundEndpointParameterEClass, InboundEndpointParameter.class, "InboundEndpointParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInboundEndpointParameter_Name(), ecorePackage.getEString(), "name", "parameter_name", 0, 1, InboundEndpointParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInboundEndpointParameter_Value(), ecorePackage.getEString(), "value", "parameter_value", 0, 1, InboundEndpointParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inboundEndpointContainerEClass, InboundEndpointContainer.class, "InboundEndpointContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInboundEndpointContainer_SequenceContainer(), this.getInboundEndpointSequenceContainer(), null, "sequenceContainer", null, 0, 1, InboundEndpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInboundEndpointContainer_OnErrorSequenceContainer(), this.getInboundEndpointOnErrorSequenceContainer(), null, "onErrorSequenceContainer", null, 0, 1, InboundEndpointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inboundEndpointSequenceContainerEClass, InboundEndpointSequenceContainer.class, "InboundEndpointSequenceContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInboundEndpointSequenceContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, InboundEndpointSequenceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inboundEndpointOnErrorSequenceContainerEClass, InboundEndpointOnErrorSequenceContainer.class, "InboundEndpointOnErrorSequenceContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInboundEndpointOnErrorSequenceContainer_MediatorFlow(), this.getMediatorFlow(), null, "mediatorFlow", null, 0, 1, InboundEndpointOnErrorSequenceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inboundEndpointSequenceInputConnectorEClass, InboundEndpointSequenceInputConnector.class, "InboundEndpointSequenceInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inboundEndpointSequenceOutputConnectorEClass, InboundEndpointSequenceOutputConnector.class, "InboundEndpointSequenceOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inboundEndpointOnErrorSequenceOutputConnectorEClass, InboundEndpointOnErrorSequenceOutputConnector.class, "InboundEndpointOnErrorSequenceOutputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inboundEndpointOnErrorSequenceInputConnectorEClass, InboundEndpointOnErrorSequenceInputConnector.class, "InboundEndpointOnErrorSequenceInputConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commentMediatorEClass, CommentMediator.class, "CommentMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommentMediator_CommentText(), ecorePackage.getEString(), "commentText", "class_name", 0, 1, CommentMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(artifactTypeEEnum, ArtifactType.class, "ArtifactType");
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.SYNAPSE_CONFIG);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.PROXY);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.SEQUENCE);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.ENDPOINT);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.LOCAL_ENTRY);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.TASK);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.TEMPLATE);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.API);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.MAIN_SEQUENCE);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.COMPLEX_ENDPOINT);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.MESSAGE_STORE);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.MESSAGE_PROCESSOR);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.INBOUND_ENDPOINT);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.TEMPLATE_ENDPOINT);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.TEMPLATE_ENDPOINT_ADDRESS);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.TEMPLATE_ENDPOINT_WSDL);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.TEMPLATE_ENDPOINT_DEFAULT);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.TEMPLATE_ENDPOINT_HTTP);
		addEEnumLiteral(artifactTypeEEnum, ArtifactType.TEMPLATE_SEQUENCE);

		initEEnum(callMediatorEndpointTypeEEnum, CallMediatorEndpointType.class, "CallMediatorEndpointType");
		addEEnumLiteral(callMediatorEndpointTypeEEnum, CallMediatorEndpointType.INLINE);
		addEEnumLiteral(callMediatorEndpointTypeEEnum, CallMediatorEndpointType.NONE);
		addEEnumLiteral(callMediatorEndpointTypeEEnum, CallMediatorEndpointType.REGISRTYKEY);
		addEEnumLiteral(callMediatorEndpointTypeEEnum, CallMediatorEndpointType.XPATH);

		initEEnum(endPointPropertyScopeEEnum, EndPointPropertyScope.class, "EndPointPropertyScope");
		addEEnumLiteral(endPointPropertyScopeEEnum, EndPointPropertyScope.SYNAPSE);
		addEEnumLiteral(endPointPropertyScopeEEnum, EndPointPropertyScope.TRANSPORT);
		addEEnumLiteral(endPointPropertyScopeEEnum, EndPointPropertyScope.AXIS2);
		addEEnumLiteral(endPointPropertyScopeEEnum, EndPointPropertyScope.AXIS2_CLIENT);

		initEEnum(sequenceTypeEEnum, SequenceType.class, "SequenceType");
		addEEnumLiteral(sequenceTypeEEnum, SequenceType.ANONYMOUS);
		addEEnumLiteral(sequenceTypeEEnum, SequenceType.REGISTRY_REFERENCE);
		addEEnumLiteral(sequenceTypeEEnum, SequenceType.NAMED_REFERENCE);

		initEEnum(proxyWsdlTypeEEnum, ProxyWsdlType.class, "ProxyWsdlType");
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.NONE);
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.INLINE);
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.SOURCE_URL);
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.REGISTRY_KEY);
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.ENDPOINT);

		initEEnum(httpMethodTypeEEnum, HttpMethodType.class, "HttpMethodType");
		addEEnumLiteral(httpMethodTypeEEnum, HttpMethodType.GET);
		addEEnumLiteral(httpMethodTypeEEnum, HttpMethodType.POST);
		addEEnumLiteral(httpMethodTypeEEnum, HttpMethodType.PUT);
		addEEnumLiteral(httpMethodTypeEEnum, HttpMethodType.DELETE);
		addEEnumLiteral(httpMethodTypeEEnum, HttpMethodType.HEAD);
		addEEnumLiteral(httpMethodTypeEEnum, HttpMethodType.OPTIONS);
		addEEnumLiteral(httpMethodTypeEEnum, HttpMethodType.PATCH);
		addEEnumLiteral(httpMethodTypeEEnum, HttpMethodType.LEAVE_AS_IS);

		initEEnum(filterMediatorConditionTypeEEnum, FilterMediatorConditionType.class, "FilterMediatorConditionType");
		addEEnumLiteral(filterMediatorConditionTypeEEnum, FilterMediatorConditionType.SOURCE_REGEX);
		addEEnumLiteral(filterMediatorConditionTypeEEnum, FilterMediatorConditionType.XPATH);

		initEEnum(logCategoryEEnum, LogCategory.class, "LogCategory");
		addEEnumLiteral(logCategoryEEnum, LogCategory.TRACE);
		addEEnumLiteral(logCategoryEEnum, LogCategory.DEBUG);
		addEEnumLiteral(logCategoryEEnum, LogCategory.INFO);
		addEEnumLiteral(logCategoryEEnum, LogCategory.WARN);
		addEEnumLiteral(logCategoryEEnum, LogCategory.ERROR);
		addEEnumLiteral(logCategoryEEnum, LogCategory.FATAL);

		initEEnum(logLevelEEnum, LogLevel.class, "LogLevel");
		addEEnumLiteral(logLevelEEnum, LogLevel.SIMPLE);
		addEEnumLiteral(logLevelEEnum, LogLevel.HEADERS);
		addEEnumLiteral(logLevelEEnum, LogLevel.FULL);
		addEEnumLiteral(logLevelEEnum, LogLevel.CUSTOM);

		initEEnum(attributeValueTypeEEnum, AttributeValueType.class, "AttributeValueType");
		addEEnumLiteral(attributeValueTypeEEnum, AttributeValueType.VALUE);
		addEEnumLiteral(attributeValueTypeEEnum, AttributeValueType.EXPRESSION);

		initEEnum(attributeTypeEEnum, AttributeType.class, "AttributeType");
		addEEnumLiteral(attributeTypeEEnum, AttributeType.STRING);
		addEEnumLiteral(attributeTypeEEnum, AttributeType.INTEGER);
		addEEnumLiteral(attributeTypeEEnum, AttributeType.BOOLEAN);
		addEEnumLiteral(attributeTypeEEnum, AttributeType.DOUBLE);
		addEEnumLiteral(attributeTypeEEnum, AttributeType.FLOAT);
		addEEnumLiteral(attributeTypeEEnum, AttributeType.LONG);

		initEEnum(beanMediatorActionEEnum, BeanMediatorAction.class, "BeanMediatorAction");
		addEEnumLiteral(beanMediatorActionEEnum, BeanMediatorAction.CREATE);
		addEEnumLiteral(beanMediatorActionEEnum, BeanMediatorAction.REMOVE);
		addEEnumLiteral(beanMediatorActionEEnum, BeanMediatorAction.SET_PROPERTY);
		addEEnumLiteral(beanMediatorActionEEnum, BeanMediatorAction.GET_PROPERTY);

		initEEnum(endPointAddressingVersionEEnum, EndPointAddressingVersion.class, "EndPointAddressingVersion");
		addEEnumLiteral(endPointAddressingVersionEEnum, EndPointAddressingVersion.FINAL);
		addEEnumLiteral(endPointAddressingVersionEEnum, EndPointAddressingVersion.SUBMISSION);

		initEEnum(endPointTimeOutActionEEnum, EndPointTimeOutAction.class, "EndPointTimeOutAction");
		addEEnumLiteral(endPointTimeOutActionEEnum, EndPointTimeOutAction.NEVER);
		addEEnumLiteral(endPointTimeOutActionEEnum, EndPointTimeOutAction.DISCARD);
		addEEnumLiteral(endPointTimeOutActionEEnum, EndPointTimeOutAction.FAULT);

		initEEnum(endPointMessageFormatEEnum, EndPointMessageFormat.class, "EndPointMessageFormat");
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.LEAVE_AS_IS);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.SOAP_11);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.SOAP_12);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.POX);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.GET);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.REST);

		initEEnum(endPointAttachmentOptimizationEEnum, EndPointAttachmentOptimization.class, "EndPointAttachmentOptimization");
		addEEnumLiteral(endPointAttachmentOptimizationEEnum, EndPointAttachmentOptimization.LEAVE_AS_IS);
		addEEnumLiteral(endPointAttachmentOptimizationEEnum, EndPointAttachmentOptimization.MTOM);
		addEEnumLiteral(endPointAttachmentOptimizationEEnum, EndPointAttachmentOptimization.SWA);

		initEEnum(propertyDataTypeEEnum, PropertyDataType.class, "PropertyDataType");
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.STRING);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.INTEGER);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.BOOLEAN);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.DOUBLE);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.FLOAT);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.LONG);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.SHORT);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.OM);

		initEEnum(propertyActionEEnum, PropertyAction.class, "PropertyAction");
		addEEnumLiteral(propertyActionEEnum, PropertyAction.SET);
		addEEnumLiteral(propertyActionEEnum, PropertyAction.REMOVE);

		initEEnum(propertyScopeEEnum, PropertyScope.class, "PropertyScope");
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.SYNAPSE);
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.TRANSPORT);
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.AXIS2);
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.AXIS2_CLIENT);
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.OPERATION);

		initEEnum(propertyValueTypeEEnum, PropertyValueType.class, "PropertyValueType");
		addEEnumLiteral(propertyValueTypeEEnum, PropertyValueType.LITERAL);
		addEEnumLiteral(propertyValueTypeEEnum, PropertyValueType.EXPRESSION);

		initEEnum(propertyNameEEnum, PropertyName.class, "PropertyName");
		addEEnumLiteral(propertyNameEEnum, PropertyName.NEW_PROPERTY_NAME);
		addEEnumLiteral(propertyNameEEnum, PropertyName.PRESERVE_WS_ADDRESSING);
		addEEnumLiteral(propertyNameEEnum, PropertyName.RESPONSE);
		addEEnumLiteral(propertyNameEEnum, PropertyName.OUT_ONLY);
		addEEnumLiteral(propertyNameEEnum, PropertyName.ERROR_CODE);
		addEEnumLiteral(propertyNameEEnum, PropertyName.ERROR_MESSAGE);
		addEEnumLiteral(propertyNameEEnum, PropertyName.ERROR_DETAIL);
		addEEnumLiteral(propertyNameEEnum, PropertyName.ERROR_EXCEPTION);
		addEEnumLiteral(propertyNameEEnum, PropertyName.TRANSPORT_HEADERS);
		addEEnumLiteral(propertyNameEEnum, PropertyName.MESSAGE_TYPE);
		addEEnumLiteral(propertyNameEEnum, PropertyName.CONTENT_TYPE);
		addEEnumLiteral(propertyNameEEnum, PropertyName.DISABLE_ADDRESSING_FOR_OUT_MESSAGES);
		addEEnumLiteral(propertyNameEEnum, PropertyName.DISABLE_SMOOKS_RESULT_PAYLOAD);
		addEEnumLiteral(propertyNameEEnum, PropertyName.CLIENT_API_NON_BLOCKING);
		addEEnumLiteral(propertyNameEEnum, PropertyName.TRANSPORT_NON_BLOCKING);
		addEEnumLiteral(propertyNameEEnum, PropertyName.TRANSPORT_IN_NAME);
		addEEnumLiteral(propertyNameEEnum, PropertyName.PRESERVE_PROCESSED_HEADERS);
		addEEnumLiteral(propertyNameEEnum, PropertyName.SERVER_IP);
		addEEnumLiteral(propertyNameEEnum, PropertyName.FORCE_ERROR_ON_SOAP_FAULT);
		addEEnumLiteral(propertyNameEEnum, PropertyName.POST_TO_URI);
		addEEnumLiteral(propertyNameEEnum, PropertyName.FORCE_SC_ACCEPTED);
		addEEnumLiteral(propertyNameEEnum, PropertyName.DISABLE_CHUNKING);
		addEEnumLiteral(propertyNameEEnum, PropertyName.NO_ENTITY_BODY);
		addEEnumLiteral(propertyNameEEnum, PropertyName.FORCE_HTTP_10);
		addEEnumLiteral(propertyNameEEnum, PropertyName.HTTP_SC);
		addEEnumLiteral(propertyNameEEnum, PropertyName.FAULTS_AS_HTTP_200);
		addEEnumLiteral(propertyNameEEnum, PropertyName.NO_KEEPALIVE);
		addEEnumLiteral(propertyNameEEnum, PropertyName.REST_URL_POSTFIX);
		addEEnumLiteral(propertyNameEEnum, PropertyName.REQUEST_HOST_HEADER);
		addEEnumLiteral(propertyNameEEnum, PropertyName.FORCE_POST_PUT_NOBODY);
		addEEnumLiteral(propertyNameEEnum, PropertyName.FORCE_HTTP_CONTENT_LENGTH);
		addEEnumLiteral(propertyNameEEnum, PropertyName.COPY_CONTENT_LENGTH_FROM_INCOMING);
		addEEnumLiteral(propertyNameEEnum, PropertyName.TO);
		addEEnumLiteral(propertyNameEEnum, PropertyName.FROM);
		addEEnumLiteral(propertyNameEEnum, PropertyName.ACTION);
		addEEnumLiteral(propertyNameEEnum, PropertyName.REPLY_TO);
		addEEnumLiteral(propertyNameEEnum, PropertyName.MESSAGE_ID);
		addEEnumLiteral(propertyNameEEnum, PropertyName.RELATES_TO);
		addEEnumLiteral(propertyNameEEnum, PropertyName.FAULT_TO);
		addEEnumLiteral(propertyNameEEnum, PropertyName.CACHE_LEVEL);
		addEEnumLiteral(propertyNameEEnum, PropertyName.CONCURRENT_CONSUMERS);
		addEEnumLiteral(propertyNameEEnum, PropertyName.HTTP_ETAG);
		addEEnumLiteral(propertyNameEEnum, PropertyName.JMS_COORELATION_ID);
		addEEnumLiteral(propertyNameEEnum, PropertyName.MAX_CONCURRENT_CONSUMERS);
		addEEnumLiteral(propertyNameEEnum, PropertyName.MERCURY_SEQUENCE_KEY);
		addEEnumLiteral(propertyNameEEnum, PropertyName.MERCURY_LAST_MESSAGE);
		addEEnumLiteral(propertyNameEEnum, PropertyName.SYSTEM_DATE);
		addEEnumLiteral(propertyNameEEnum, PropertyName.SYSTEM_TIME);
		addEEnumLiteral(propertyNameEEnum, PropertyName.MESSAGE_FORMAT);
		addEEnumLiteral(propertyNameEEnum, PropertyName.OPERATION_NAME);

		initEEnum(enrichSourceInlineTypeEEnum, EnrichSourceInlineType.class, "EnrichSourceInlineType");
		addEEnumLiteral(enrichSourceInlineTypeEEnum, EnrichSourceInlineType.CONTENT);
		addEEnumLiteral(enrichSourceInlineTypeEEnum, EnrichSourceInlineType.KEY);

		initEEnum(enrichSourceTypeEEnum, EnrichSourceType.class, "EnrichSourceType");
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.CUSTOM);
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.ENVELOPE);
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.BODY);
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.PROPERTY);
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.INLINE);

		initEEnum(enrichTargetActionEEnum, EnrichTargetAction.class, "EnrichTargetAction");
		addEEnumLiteral(enrichTargetActionEEnum, EnrichTargetAction.REPLACE);
		addEEnumLiteral(enrichTargetActionEEnum, EnrichTargetAction.CHILD);
		addEEnumLiteral(enrichTargetActionEEnum, EnrichTargetAction.SIBLING);

		initEEnum(enrichTargetTypeEEnum, EnrichTargetType.class, "EnrichTargetType");
		addEEnumLiteral(enrichTargetTypeEEnum, EnrichTargetType.CUSTOM);
		addEEnumLiteral(enrichTargetTypeEEnum, EnrichTargetType.ENVELOPE);
		addEEnumLiteral(enrichTargetTypeEEnum, EnrichTargetType.BODY);
		addEEnumLiteral(enrichTargetTypeEEnum, EnrichTargetType.PROPERTY);

		initEEnum(eventTopicTypeEEnum, EventTopicType.class, "EventTopicType");
		addEEnumLiteral(eventTopicTypeEEnum, EventTopicType.STATIC);
		addEEnumLiteral(eventTopicTypeEEnum, EventTopicType.DYNAMIC);

		initEEnum(entitlementCallbackHandlerEEnum, EntitlementCallbackHandler.class, "EntitlementCallbackHandler");
		addEEnumLiteral(entitlementCallbackHandlerEEnum, EntitlementCallbackHandler.UT);
		addEEnumLiteral(entitlementCallbackHandlerEEnum, EntitlementCallbackHandler.X509);
		addEEnumLiteral(entitlementCallbackHandlerEEnum, EntitlementCallbackHandler.SAML);
		addEEnumLiteral(entitlementCallbackHandlerEEnum, EntitlementCallbackHandler.KERBEROS);
		addEEnumLiteral(entitlementCallbackHandlerEEnum, EntitlementCallbackHandler.CUSTOM);

		initEEnum(entitlementClientTypeEEnum, EntitlementClientType.class, "EntitlementClientType");
		addEEnumLiteral(entitlementClientTypeEEnum, EntitlementClientType.BASIC_AUTH);
		addEEnumLiteral(entitlementClientTypeEEnum, EntitlementClientType.THRIFT);
		addEEnumLiteral(entitlementClientTypeEEnum, EntitlementClientType.SOAP);
		addEEnumLiteral(entitlementClientTypeEEnum, EntitlementClientType.WSXACML);

		initEEnum(entitlementSequenceTypeEEnum, EntitlementSequenceType.class, "EntitlementSequenceType");
		addEEnumLiteral(entitlementSequenceTypeEEnum, EntitlementSequenceType.ANONYMOUS);
		addEEnumLiteral(entitlementSequenceTypeEEnum, EntitlementSequenceType.REGISTRY_REFERENCE);

		initEEnum(scriptKeyTypeEnumEEnum, scriptKeyTypeEnum.class, "scriptKeyTypeEnum");
		addEEnumLiteral(scriptKeyTypeEnumEEnum, scriptKeyTypeEnum.STATIC_KEY);
		addEEnumLiteral(scriptKeyTypeEnumEEnum, scriptKeyTypeEnum.DYNAMIC_KEY);

		initEEnum(scriptTypeEEnum, ScriptType.class, "ScriptType");
		addEEnumLiteral(scriptTypeEEnum, ScriptType.INLINE);
		addEEnumLiteral(scriptTypeEEnum, ScriptType.REGISTRY_REFERENCE);

		initEEnum(scriptLanguageEEnum, ScriptLanguage.class, "ScriptLanguage");
		addEEnumLiteral(scriptLanguageEEnum, ScriptLanguage.JAVASCRIPT);
		addEEnumLiteral(scriptLanguageEEnum, ScriptLanguage.RUBY);
		addEEnumLiteral(scriptLanguageEEnum, ScriptLanguage.GROOVY);

		initEEnum(faultSoapVersionEEnum, FaultSoapVersion.class, "FaultSoapVersion");
		addEEnumLiteral(faultSoapVersionEEnum, FaultSoapVersion.SOAP_11);
		addEEnumLiteral(faultSoapVersionEEnum, FaultSoapVersion.SOAP_12);
		addEEnumLiteral(faultSoapVersionEEnum, FaultSoapVersion.POX);

		initEEnum(faultCodeSoap11EEnum, FaultCodeSoap11.class, "FaultCodeSoap11");
		addEEnumLiteral(faultCodeSoap11EEnum, FaultCodeSoap11.VERSION_MISSMATCH);
		addEEnumLiteral(faultCodeSoap11EEnum, FaultCodeSoap11.MUST_UNDERSTAND);
		addEEnumLiteral(faultCodeSoap11EEnum, FaultCodeSoap11.CLIENT);
		addEEnumLiteral(faultCodeSoap11EEnum, FaultCodeSoap11.SERVER);

		initEEnum(faultCodeSoap12EEnum, FaultCodeSoap12.class, "FaultCodeSoap12");
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.VERSION_MISSMATCH);
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.MUST_UNDERSTAND);
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.DATA_ENCODING_UNKNOWN);
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.SENDER);
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.RECEIVER);

		initEEnum(faultCodeTypeEEnum, FaultCodeType.class, "FaultCodeType");
		addEEnumLiteral(faultCodeTypeEEnum, FaultCodeType.VALUE);
		addEEnumLiteral(faultCodeTypeEEnum, FaultCodeType.EXPRESSION);

		initEEnum(faultStringTypeEEnum, FaultStringType.class, "FaultStringType");
		addEEnumLiteral(faultStringTypeEEnum, FaultStringType.VALUE);
		addEEnumLiteral(faultStringTypeEEnum, FaultStringType.EXPRESSION);

		initEEnum(faultReasonTypeEEnum, FaultReasonType.class, "FaultReasonType");
		addEEnumLiteral(faultReasonTypeEEnum, FaultReasonType.VALUE);
		addEEnumLiteral(faultReasonTypeEEnum, FaultReasonType.EXPRESSION);

		initEEnum(faultDetailTypeEEnum, FaultDetailType.class, "FaultDetailType");
		addEEnumLiteral(faultDetailTypeEEnum, FaultDetailType.VALUE);
		addEEnumLiteral(faultDetailTypeEEnum, FaultDetailType.EXPRESSION);

		initEEnum(completionMessagesTypeEEnum, CompletionMessagesType.class, "CompletionMessagesType");
		addEEnumLiteral(completionMessagesTypeEEnum, CompletionMessagesType.VALUE);
		addEEnumLiteral(completionMessagesTypeEEnum, CompletionMessagesType.EXPRESSION);

		initEEnum(aggregateSequenceTypeEEnum, AggregateSequenceType.class, "AggregateSequenceType");
		addEEnumLiteral(aggregateSequenceTypeEEnum, AggregateSequenceType.ANONYMOUS);
		addEEnumLiteral(aggregateSequenceTypeEEnum, AggregateSequenceType.REGISTRY_REFERENCE);

		initEEnum(targetSequenceTypeEEnum, TargetSequenceType.class, "TargetSequenceType");
		addEEnumLiteral(targetSequenceTypeEEnum, TargetSequenceType.NONE);
		addEEnumLiteral(targetSequenceTypeEEnum, TargetSequenceType.ANONYMOUS);
		addEEnumLiteral(targetSequenceTypeEEnum, TargetSequenceType.REGISTRY_REFERENCE);

		initEEnum(targetEndpointTypeEEnum, TargetEndpointType.class, "TargetEndpointType");
		addEEnumLiteral(targetEndpointTypeEEnum, TargetEndpointType.NONE);
		addEEnumLiteral(targetEndpointTypeEEnum, TargetEndpointType.ANONYMOUS);
		addEEnumLiteral(targetEndpointTypeEEnum, TargetEndpointType.REGISTRY_REFERENCE);

		initEEnum(cacheSequenceTypeEEnum, CacheSequenceType.class, "CacheSequenceType");
		addEEnumLiteral(cacheSequenceTypeEEnum, CacheSequenceType.ANONYMOUS);
		addEEnumLiteral(cacheSequenceTypeEEnum, CacheSequenceType.REGISTRY_REFERENCE);

		initEEnum(cacheImplementationTypeEEnum, CacheImplementationType.class, "CacheImplementationType");
		addEEnumLiteral(cacheImplementationTypeEEnum, CacheImplementationType.IN_MEMORY);

		initEEnum(cacheActionEEnum, CacheAction.class, "CacheAction");
		addEEnumLiteral(cacheActionEEnum, CacheAction.FINDER);
		addEEnumLiteral(cacheActionEEnum, CacheAction.COLLECTOR);

		initEEnum(cacheScopeEEnum, CacheScope.class, "CacheScope");
		addEEnumLiteral(cacheScopeEEnum, CacheScope.PER_MEDIATOR);
		addEEnumLiteral(cacheScopeEEnum, CacheScope.PER_HOST);

		initEEnum(xQueryVariableTypeEEnum, XQueryVariableType.class, "XQueryVariableType");
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.DOCUMENT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.DOCUMENT_ELEMENT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.ELEMENT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.INT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.INTEGER);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.BOOLEAN);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.BYTE);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.DOUBLE);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.SHORT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.LONG);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.FLOAT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.STRING);

		initEEnum(xQueryVariableValueTypeEEnum, XQueryVariableValueType.class, "XQueryVariableValueType");
		addEEnumLiteral(xQueryVariableValueTypeEEnum, XQueryVariableValueType.LITERAL);
		addEEnumLiteral(xQueryVariableValueTypeEEnum, XQueryVariableValueType.EXPRESSION);

		initEEnum(calloutEndpointTypeEEnum, CalloutEndpointType.class, "CalloutEndpointType");
		addEEnumLiteral(calloutEndpointTypeEEnum, CalloutEndpointType.URL);
		addEEnumLiteral(calloutEndpointTypeEEnum, CalloutEndpointType.ADDRESS_ENDPOINT);

		initEEnum(calloutPayloadTypeEEnum, CalloutPayloadType.class, "CalloutPayloadType");
		addEEnumLiteral(calloutPayloadTypeEEnum, CalloutPayloadType.XPATH);
		addEEnumLiteral(calloutPayloadTypeEEnum, CalloutPayloadType.PROPERTY);
		addEEnumLiteral(calloutPayloadTypeEEnum, CalloutPayloadType.ENVELOPE);

		initEEnum(calloutSecurityPoliciesEEnum, CalloutSecurityPolicies.class, "CalloutSecurityPolicies");
		addEEnumLiteral(calloutSecurityPoliciesEEnum, CalloutSecurityPolicies.FALSE);
		addEEnumLiteral(calloutSecurityPoliciesEEnum, CalloutSecurityPolicies.TRUE);

		initEEnum(calloutSecurityTypeEEnum, CalloutSecurityType.class, "CalloutSecurityType");
		addEEnumLiteral(calloutSecurityTypeEEnum, CalloutSecurityType.FALSE);
		addEEnumLiteral(calloutSecurityTypeEEnum, CalloutSecurityType.TRUE);

		initEEnum(calloutResultTypeEEnum, CalloutResultType.class, "CalloutResultType");
		addEEnumLiteral(calloutResultTypeEEnum, CalloutResultType.XPATH);
		addEEnumLiteral(calloutResultTypeEEnum, CalloutResultType.PROPERTY);

		initEEnum(rmSpecVersionEEnum, RMSpecVersion.class, "RMSpecVersion");
		addEEnumLiteral(rmSpecVersionEEnum, RMSpecVersion.VERSION_10);
		addEEnumLiteral(rmSpecVersionEEnum, RMSpecVersion.VERSION_11);

		initEEnum(rmSequenceTypeEEnum, RMSequenceType.class, "RMSequenceType");
		addEEnumLiteral(rmSequenceTypeEEnum, RMSequenceType.SINGLE_MESSAGE);
		addEEnumLiteral(rmSequenceTypeEEnum, RMSequenceType.CORRELATED_SEQUENCE);

		initEEnum(transactionActionEEnum, TransactionAction.class, "TransactionAction");
		addEEnumLiteral(transactionActionEEnum, TransactionAction.COMMIT);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.FAULT_IF_NO_TRANSACTION);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.INITIATE_NEW);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.RESUME);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.SUSPEND);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.ROLLBACK);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.USE_EXISTING_OR_NEW);

		initEEnum(headerActionEEnum, HeaderAction.class, "HeaderAction");
		addEEnumLiteral(headerActionEEnum, HeaderAction.SET);
		addEEnumLiteral(headerActionEEnum, HeaderAction.REMOVE);

		initEEnum(headerValueTypeEEnum, HeaderValueType.class, "HeaderValueType");
		addEEnumLiteral(headerValueTypeEEnum, HeaderValueType.LITERAL);
		addEEnumLiteral(headerValueTypeEEnum, HeaderValueType.EXPRESSION);
		addEEnumLiteral(headerValueTypeEEnum, HeaderValueType.INLINE);

		initEEnum(scopeTypeEEnum, ScopeType.class, "ScopeType");
		addEEnumLiteral(scopeTypeEEnum, ScopeType.DEFAULT);
		addEEnumLiteral(scopeTypeEEnum, ScopeType.TRANSPORT);

		initEEnum(throttlePolicyTypeEEnum, ThrottlePolicyType.class, "ThrottlePolicyType");
		addEEnumLiteral(throttlePolicyTypeEEnum, ThrottlePolicyType.INLINE);
		addEEnumLiteral(throttlePolicyTypeEEnum, ThrottlePolicyType.REGISTRY_REFERENCE);

		initEEnum(throttleConditionTypeEEnum, ThrottleConditionType.class, "ThrottleConditionType");
		addEEnumLiteral(throttleConditionTypeEEnum, ThrottleConditionType.IP);
		addEEnumLiteral(throttleConditionTypeEEnum, ThrottleConditionType.DOMAIN);

		initEEnum(throttleAccessTypeEEnum, ThrottleAccessType.class, "ThrottleAccessType");
		addEEnumLiteral(throttleAccessTypeEEnum, ThrottleAccessType.ALLOW);
		addEEnumLiteral(throttleAccessTypeEEnum, ThrottleAccessType.DENY);
		addEEnumLiteral(throttleAccessTypeEEnum, ThrottleAccessType.CONTROL);

		initEEnum(throttleSequenceTypeEEnum, ThrottleSequenceType.class, "ThrottleSequenceType");
		addEEnumLiteral(throttleSequenceTypeEEnum, ThrottleSequenceType.ANONYMOUS);
		addEEnumLiteral(throttleSequenceTypeEEnum, ThrottleSequenceType.REGISTRY_REFERENCE);

		initEEnum(commandPropertyValueTypeEEnum, CommandPropertyValueType.class, "CommandPropertyValueType");
		addEEnumLiteral(commandPropertyValueTypeEEnum, CommandPropertyValueType.LITERAL);
		addEEnumLiteral(commandPropertyValueTypeEEnum, CommandPropertyValueType.MESSAGE_ELEMENT);
		addEEnumLiteral(commandPropertyValueTypeEEnum, CommandPropertyValueType.CONTEXT_PROPERTY);

		initEEnum(commandPropertyMessageActionEEnum, CommandPropertyMessageAction.class, "CommandPropertyMessageAction");
		addEEnumLiteral(commandPropertyMessageActionEEnum, CommandPropertyMessageAction.READ_MESSAGE);
		addEEnumLiteral(commandPropertyMessageActionEEnum, CommandPropertyMessageAction.UPDATE_MESSAGE);
		addEEnumLiteral(commandPropertyMessageActionEEnum, CommandPropertyMessageAction.READ_AND_UPDATE_MESSAGE);

		initEEnum(commandPropertyContextActionEEnum, CommandPropertyContextAction.class, "CommandPropertyContextAction");
		addEEnumLiteral(commandPropertyContextActionEEnum, CommandPropertyContextAction.READ_CONTEXT);
		addEEnumLiteral(commandPropertyContextActionEEnum, CommandPropertyContextAction.UPDATE_CONTEXT);
		addEEnumLiteral(commandPropertyContextActionEEnum, CommandPropertyContextAction.READ_AND_UPDATE_CONTEXT);

		initEEnum(sqlExecutorConnectionTypeEEnum, SqlExecutorConnectionType.class, "SqlExecutorConnectionType");
		addEEnumLiteral(sqlExecutorConnectionTypeEEnum, SqlExecutorConnectionType.DB_CONNECTION);
		addEEnumLiteral(sqlExecutorConnectionTypeEEnum, SqlExecutorConnectionType.DATA_SOURCE);

		initEEnum(sqlExecutorDatasourceTypeEEnum, SqlExecutorDatasourceType.class, "SqlExecutorDatasourceType");
		addEEnumLiteral(sqlExecutorDatasourceTypeEEnum, SqlExecutorDatasourceType.EXTERNAL);
		addEEnumLiteral(sqlExecutorDatasourceTypeEEnum, SqlExecutorDatasourceType.CARBON);

		initEEnum(sqlExecutorBooleanValueEEnum, SqlExecutorBooleanValue.class, "SqlExecutorBooleanValue");
		addEEnumLiteral(sqlExecutorBooleanValueEEnum, SqlExecutorBooleanValue.FALSE);
		addEEnumLiteral(sqlExecutorBooleanValueEEnum, SqlExecutorBooleanValue.TRUE);
		addEEnumLiteral(sqlExecutorBooleanValueEEnum, SqlExecutorBooleanValue.DEFAULT);

		initEEnum(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.class, "SqlExecutorIsolationLevel");
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_NONE);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_READ_COMMITTED);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_READ_UNCOMMITTED);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_REPEATABLE_READ);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_SERIALIZABLE);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.DEFAULT);

		initEEnum(sqlParameterValueTypeEEnum, SqlParameterValueType.class, "SqlParameterValueType");
		addEEnumLiteral(sqlParameterValueTypeEEnum, SqlParameterValueType.LITERAL);
		addEEnumLiteral(sqlParameterValueTypeEEnum, SqlParameterValueType.EXPRESSION);

		initEEnum(sqlParameterDataTypeEEnum, SqlParameterDataType.class, "SqlParameterDataType");
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.CHAR);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.VARCHAR);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.LONGVARCHAR);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.NUMERIC);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.DECIMAL);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.BIT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.TINYINT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.SMALLINT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.INTEGER);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.BIGINT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.REAL);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.FLOAT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.DOUBLE);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.DATE);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.TIME);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.TIMESTAMP);

		initEEnum(ruleActionsEEnum, RuleActions.class, "RuleActions");
		addEEnumLiteral(ruleActionsEEnum, RuleActions.REPLACE);
		addEEnumLiteral(ruleActionsEEnum, RuleActions.CHILD);
		addEEnumLiteral(ruleActionsEEnum, RuleActions.SIBLING);

		initEEnum(ruleTypeEEnum, RuleType.class, "RuleType");
		addEEnumLiteral(ruleTypeEEnum, RuleType.REGULAR);
		addEEnumLiteral(ruleTypeEEnum, RuleType.DTABLE);

		initEEnum(ruleSourceTypeEEnum, RuleSourceType.class, "RuleSourceType");
		addEEnumLiteral(ruleSourceTypeEEnum, RuleSourceType.INLINE);
		addEEnumLiteral(ruleSourceTypeEEnum, RuleSourceType.REGISTRY);
		addEEnumLiteral(ruleSourceTypeEEnum, RuleSourceType.URL);

		initEEnum(ruleFactTypeEEnum, RuleFactType.class, "RuleFactType");
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.CUSTOM);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.DOM);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.MESSAGE);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.CONTEXT);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.OMELEMENT);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.MEDIATOR);

		initEEnum(ruleFactValueTypeEEnum, RuleFactValueType.class, "RuleFactValueType");
		addEEnumLiteral(ruleFactValueTypeEEnum, RuleFactValueType.NONE);
		addEEnumLiteral(ruleFactValueTypeEEnum, RuleFactValueType.LITERAL);
		addEEnumLiteral(ruleFactValueTypeEEnum, RuleFactValueType.EXPRESSION);
		addEEnumLiteral(ruleFactValueTypeEEnum, RuleFactValueType.REGISTRY_REFERENCE);

		initEEnum(ruleResultTypeEEnum, RuleResultType.class, "RuleResultType");
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.CUSTOM);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.DOM);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.MESSAGE);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.CONTEXT);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.OMELEMENT);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.MEDIATOR);

		initEEnum(ruleResultValueTypeEEnum, RuleResultValueType.class, "RuleResultValueType");
		addEEnumLiteral(ruleResultValueTypeEEnum, RuleResultValueType.LITERAL);
		addEEnumLiteral(ruleResultValueTypeEEnum, RuleResultValueType.EXPRESSION);
		addEEnumLiteral(ruleResultValueTypeEEnum, RuleResultValueType.REGISTRY_REFERENCE);

		initEEnum(ruleOptionTypeEEnum, RuleOptionType.class, "RuleOptionType");
		addEEnumLiteral(ruleOptionTypeEEnum, RuleOptionType.VALUE);
		addEEnumLiteral(ruleOptionTypeEEnum, RuleOptionType.EXPRESSION);

		initEEnum(smooksIODataTypeEEnum, SmooksIODataType.class, "SmooksIODataType");
		addEEnumLiteral(smooksIODataTypeEEnum, SmooksIODataType.XML);
		addEEnumLiteral(smooksIODataTypeEEnum, SmooksIODataType.TEXT);

		initEEnum(smooksOutputDataTypeEEnum, SmooksOutputDataType.class, "SmooksOutputDataType");
		addEEnumLiteral(smooksOutputDataTypeEEnum, SmooksOutputDataType.XML);
		addEEnumLiteral(smooksOutputDataTypeEEnum, SmooksOutputDataType.TEXT);
		addEEnumLiteral(smooksOutputDataTypeEEnum, SmooksOutputDataType.JAVA);

		initEEnum(expressionActionEEnum, ExpressionAction.class, "ExpressionAction");
		addEEnumLiteral(expressionActionEEnum, ExpressionAction.ADD);
		addEEnumLiteral(expressionActionEEnum, ExpressionAction.REPLACE);
		addEEnumLiteral(expressionActionEEnum, ExpressionAction.SIBLING);

		initEEnum(outputMethodEEnum, OutputMethod.class, "OutputMethod");
		addEEnumLiteral(outputMethodEEnum, OutputMethod.DEFAULT);
		addEEnumLiteral(outputMethodEEnum, OutputMethod.PROPERTY);
		addEEnumLiteral(outputMethodEEnum, OutputMethod.EXPRESSION);

		initEEnum(receivingSequenceTypeEEnum, ReceivingSequenceType.class, "ReceivingSequenceType");
		addEEnumLiteral(receivingSequenceTypeEEnum, ReceivingSequenceType.DEFAULT);
		addEEnumLiteral(receivingSequenceTypeEEnum, ReceivingSequenceType.STATIC);
		addEEnumLiteral(receivingSequenceTypeEEnum, ReceivingSequenceType.DYNAMIC);

		initEEnum(keyTypeEEnum, KeyType.class, "KeyType");
		addEEnumLiteral(keyTypeEEnum, KeyType.STATIC);
		addEEnumLiteral(keyTypeEEnum, KeyType.DYNAMIC);

		initEEnum(mediaTypeEEnum, MediaType.class, "MediaType");
		addEEnumLiteral(mediaTypeEEnum, MediaType.XML);
		addEEnumLiteral(mediaTypeEEnum, MediaType.JSON);

		initEEnum(payloadFactoryArgumentTypeEEnum, PayloadFactoryArgumentType.class, "PayloadFactoryArgumentType");
		addEEnumLiteral(payloadFactoryArgumentTypeEEnum, PayloadFactoryArgumentType.VALUE);
		addEEnumLiteral(payloadFactoryArgumentTypeEEnum, PayloadFactoryArgumentType.EXPRESSION);

		initEEnum(payloadFormatTypeEEnum, PayloadFormatType.class, "PayloadFormatType");
		addEEnumLiteral(payloadFormatTypeEEnum, PayloadFormatType.INLINE);
		addEEnumLiteral(payloadFormatTypeEEnum, PayloadFormatType.REGISTRY_REFERENCE);

		initEEnum(typeEEnum, Type.class, "Type");
		addEEnumLiteral(typeEEnum, Type.HTTP);
		addEEnumLiteral(typeEEnum, Type.SIMPLE_CLIENT_SESSION);

		initEEnum(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.class, "LoadBalanceSessionType");
		addEEnumLiteral(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.NONE);
		addEEnumLiteral(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.TRANSPORT);
		addEEnumLiteral(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.SOAP);
		addEEnumLiteral(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.CLIENT_ID);

		initEEnum(localEntryValueTypeEEnum, LocalEntryValueType.class, "LocalEntryValueType");
		addEEnumLiteral(localEntryValueTypeEEnum, LocalEntryValueType.LITERAL);
		addEEnumLiteral(localEntryValueTypeEEnum, LocalEntryValueType.XML);
		addEEnumLiteral(localEntryValueTypeEEnum, LocalEntryValueType.URL);

		initEEnum(ruleActionTypeEEnum, RuleActionType.class, "RuleActionType");
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.REPLACE);
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.REMOVE);
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.APPEND);
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.PREPEND);
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.SET);

		initEEnum(ruleFragmentTypeEEnum, RuleFragmentType.class, "RuleFragmentType");
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.PROTOCOL);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.HOST);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.PORT);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.PATH);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.QUERY);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.REF);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.USER);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.FULL);

		initEEnum(templateTypeEEnum, TemplateType.class, "TemplateType");
		addEEnumLiteral(templateTypeEEnum, TemplateType.SEQUENCE);
		addEEnumLiteral(templateTypeEEnum, TemplateType.ENDPOINT);

		initEEnum(taskPropertyTypeEEnum, TaskPropertyType.class, "TaskPropertyType");
		addEEnumLiteral(taskPropertyTypeEEnum, TaskPropertyType.LITERAL);
		addEEnumLiteral(taskPropertyTypeEEnum, TaskPropertyType.XML);

		initEEnum(taskTriggerTypeEEnum, TaskTriggerType.class, "TaskTriggerType");
		addEEnumLiteral(taskTriggerTypeEEnum, TaskTriggerType.SIMPLE);
		addEEnumLiteral(taskTriggerTypeEEnum, TaskTriggerType.CRON);

		initEEnum(apiResourceUrlStyleEEnum, ApiResourceUrlStyle.class, "ApiResourceUrlStyle");
		addEEnumLiteral(apiResourceUrlStyleEEnum, ApiResourceUrlStyle.NONE);
		addEEnumLiteral(apiResourceUrlStyleEEnum, ApiResourceUrlStyle.URI_TEMPLATE);
		addEEnumLiteral(apiResourceUrlStyleEEnum, ApiResourceUrlStyle.URL_MAPPING);

		initEEnum(recipientListEndpointTypeEEnum, RecipientListEndpointType.class, "RecipientListEndpointType");
		addEEnumLiteral(recipientListEndpointTypeEEnum, RecipientListEndpointType.INLINE);
		addEEnumLiteral(recipientListEndpointTypeEEnum, RecipientListEndpointType.VALUE);
		addEEnumLiteral(recipientListEndpointTypeEEnum, RecipientListEndpointType.XPATH);

		initEEnum(messageStoreTypeEEnum, MessageStoreType.class, "MessageStoreType");
		addEEnumLiteral(messageStoreTypeEEnum, MessageStoreType.IN_MEMORY);
		addEEnumLiteral(messageStoreTypeEEnum, MessageStoreType.JMS);
		addEEnumLiteral(messageStoreTypeEEnum, MessageStoreType.CUSTOM);
		addEEnumLiteral(messageStoreTypeEEnum, MessageStoreType.RABBITMQ);
		addEEnumLiteral(messageStoreTypeEEnum, MessageStoreType.JDBC);

		initEEnum(jmsSpecVersionEEnum, JMSSpecVersion.class, "JMSSpecVersion");
		addEEnumLiteral(jmsSpecVersionEEnum, JMSSpecVersion.JMS_11);
		addEEnumLiteral(jmsSpecVersionEEnum, JMSSpecVersion.JMS_10);

		initEEnum(jdbcConnectionInformationTypeEEnum, JDBCConnectionInformationType.class, "JDBCConnectionInformationType");
		addEEnumLiteral(jdbcConnectionInformationTypeEEnum, JDBCConnectionInformationType.JDBC_POOL);
		addEEnumLiteral(jdbcConnectionInformationTypeEEnum, JDBCConnectionInformationType.JDBC_CARBON_DATASOURCE);

		initEEnum(messageProcessorTypeEEnum, MessageProcessorType.class, "MessageProcessorType");
		addEEnumLiteral(messageProcessorTypeEEnum, MessageProcessorType.SCHEDULED_MSG_FORWARDING);
		addEEnumLiteral(messageProcessorTypeEEnum, MessageProcessorType.SCHEDULED_FAILOVER_MSG_FORWARDING);
		addEEnumLiteral(messageProcessorTypeEEnum, MessageProcessorType.MSG_SAMPLING);
		addEEnumLiteral(messageProcessorTypeEEnum, MessageProcessorType.CUSTOM);

		initEEnum(processorStateEEnum, ProcessorState.class, "ProcessorState");
		addEEnumLiteral(processorStateEEnum, ProcessorState.ACTIVATE);
		addEEnumLiteral(processorStateEEnum, ProcessorState.DEACTIVATE);

		initEEnum(cloudConnectorOperationParamEditorTypeEEnum, CloudConnectorOperationParamEditorType.class, "CloudConnectorOperationParamEditorType");
		addEEnumLiteral(cloudConnectorOperationParamEditorTypeEEnum, CloudConnectorOperationParamEditorType.INLINE);
		addEEnumLiteral(cloudConnectorOperationParamEditorTypeEEnum, CloudConnectorOperationParamEditorType.NAMESPACED_PROPERTY_EDITOR);

		initEEnum(dataMapperMediatorDataTypesEEnum, DataMapperMediatorDataTypes.class, "DataMapperMediatorDataTypes");
		addEEnumLiteral(dataMapperMediatorDataTypesEEnum, DataMapperMediatorDataTypes.XML);
		addEEnumLiteral(dataMapperMediatorDataTypesEEnum, DataMapperMediatorDataTypes.CSV);
		addEEnumLiteral(dataMapperMediatorDataTypesEEnum, DataMapperMediatorDataTypes.JSON);

		initEEnum(protocolEEnum, Protocol.class, "Protocol");
		addEEnumLiteral(protocolEEnum, Protocol.HTTP);
		addEEnumLiteral(protocolEEnum, Protocol.HTTPS);

		initEEnum(inboundEndpointTypeEEnum, InboundEndpointType.class, "InboundEndpointType");
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.HTTP);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.FILE);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.JMS);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.CUSTOM);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.HTTPS);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.HL7);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.KAFKA);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.CXF_WS_RM);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.MQTT);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.RABBITMQ);
		addEEnumLiteral(inboundEndpointTypeEEnum, InboundEndpointType.FEED);

		initEEnum(inboundEndpointBehaviourTypeEEnum, InboundEndpointBehaviourType.class, "InboundEndpointBehaviourType");
		addEEnumLiteral(inboundEndpointBehaviourTypeEEnum, InboundEndpointBehaviourType.POLLING_INBOUND_ENDPOINT);
		addEEnumLiteral(inboundEndpointBehaviourTypeEEnum, InboundEndpointBehaviourType.LISTENING_INBOUND_ENDPOINT);

		initEEnum(contentTypeEEnum, ContentType.class, "ContentType");
		addEEnumLiteral(contentTypeEEnum, ContentType.XML);
		addEEnumLiteral(contentTypeEEnum, ContentType.JSON);

		initEEnum(topicsTypeEEnum, TopicsType.class, "TopicsType");
		addEEnumLiteral(topicsTypeEEnum, TopicsType.TOPICS);
		addEEnumLiteral(topicsTypeEEnum, TopicsType.TOPIC_FILTER);

		initEEnum(topicFilterFromTypeEEnum, TopicFilterFromType.class, "TopicFilterFromType");
		addEEnumLiteral(topicFilterFromTypeEEnum, TopicFilterFromType.FILTER_FROM_WHITELIST);
		addEEnumLiteral(topicFilterFromTypeEEnum, TopicFilterFromType.FILTER_FROM_BLACKLIST);

		initEEnum(consumerTypeEEnum, ConsumerType.class, "ConsumerType");
		addEEnumLiteral(consumerTypeEEnum, ConsumerType.HIGHLEVEL);
		addEEnumLiteral(consumerTypeEEnum, ConsumerType.SIMPLE);

		initEEnum(autoOffsetResetTypeEEnum, AutoOffsetResetType.class, "AutoOffsetResetType");
		addEEnumLiteral(autoOffsetResetTypeEEnum, AutoOffsetResetType.SMALLEST);
		addEEnumLiteral(autoOffsetResetTypeEEnum, AutoOffsetResetType.LARGEST);

		initEEnum(partitionAssignmentStrategyTypeEEnum, PartitionAssignmentStrategyType.class, "PartitionAssignmentStrategyType");
		addEEnumLiteral(partitionAssignmentStrategyTypeEEnum, PartitionAssignmentStrategyType.ROUNDROBIN);
		addEEnumLiteral(partitionAssignmentStrategyTypeEEnum, PartitionAssignmentStrategyType.RANGE);

		initEEnum(offsetsStorageTypeEEnum, OffsetsStorageType.class, "OffsetsStorageType");
		addEEnumLiteral(offsetsStorageTypeEEnum, OffsetsStorageType.ZOOKEEPER);
		addEEnumLiteral(offsetsStorageTypeEEnum, OffsetsStorageType.KAFKA);

		initEEnum(enableEEnum, Enable.class, "Enable");
		addEEnumLiteral(enableEEnum, Enable.ENABLE);
		addEEnumLiteral(enableEEnum, Enable.DISABLE);

		initEEnum(vfsActionEEnum, VFSAction.class, "VFSAction");
		addEEnumLiteral(vfsActionEEnum, VFSAction.DELETE);
		addEEnumLiteral(vfsActionEEnum, VFSAction.MOVE);

		initEEnum(vfsFileSortEEnum, VFSFileSort.class, "VFSFileSort");
		addEEnumLiteral(vfsFileSortEEnum, VFSFileSort.NONE);
		addEEnumLiteral(vfsFileSortEEnum, VFSFileSort.NAME);
		addEEnumLiteral(vfsFileSortEEnum, VFSFileSort.SIZE);
		addEEnumLiteral(vfsFileSortEEnum, VFSFileSort.LASTMODIFIEDTIMESTAMP);

		initEEnum(jmsConnectionFactoryTypeEEnum, JMSConnectionFactoryType.class, "JMSConnectionFactoryType");
		addEEnumLiteral(jmsConnectionFactoryTypeEEnum, JMSConnectionFactoryType.TOPIC);
		addEEnumLiteral(jmsConnectionFactoryTypeEEnum, JMSConnectionFactoryType.QUEUE);

		initEEnum(jmsSessionAcknowledgementEEnum, JMSSessionAcknowledgement.class, "JMSSessionAcknowledgement");
		addEEnumLiteral(jmsSessionAcknowledgementEEnum, JMSSessionAcknowledgement.AUTO_ACKNOWLEDGE);
		addEEnumLiteral(jmsSessionAcknowledgementEEnum, JMSSessionAcknowledgement.CLIENT_ACKNOWLEDGE);
		addEEnumLiteral(jmsSessionAcknowledgementEEnum, JMSSessionAcknowledgement.DUPS_OK_ACKNOWLEDGE);
		addEEnumLiteral(jmsSessionAcknowledgementEEnum, JMSSessionAcknowledgement.SESSION_TRANSACTED);

		initEEnum(jmsCacheLevelEEnum, JMSCacheLevel.class, "JMSCacheLevel");
		addEEnumLiteral(jmsCacheLevelEEnum, JMSCacheLevel.THREE);
		addEEnumLiteral(jmsCacheLevelEEnum, JMSCacheLevel.TWO);
		addEEnumLiteral(jmsCacheLevelEEnum, JMSCacheLevel.ONE);

		initEEnum(mqttSubscriptionQOSEEnum, MQTTSubscriptionQOS.class, "MQTTSubscriptionQOS");
		addEEnumLiteral(mqttSubscriptionQOSEEnum, MQTTSubscriptionQOS.ZERO);
		addEEnumLiteral(mqttSubscriptionQOSEEnum, MQTTSubscriptionQOS.ONE);
		addEEnumLiteral(mqttSubscriptionQOSEEnum, MQTTSubscriptionQOS.TWO);

		initEEnum(feedTypeEEnum, FeedType.class, "FeedType");
		addEEnumLiteral(feedTypeEEnum, FeedType.ATOM);
		addEEnumLiteral(feedTypeEEnum, FeedType.RSS);

		initEEnum(enableDisableStateEEnum, EnableDisableState.class, "EnableDisableState");
		addEEnumLiteral(enableDisableStateEEnum, EnableDisableState.DISABLED);
		addEEnumLiteral(enableDisableStateEEnum, EnableDisableState.ENABLED);

		// Initialize data types
		initEDataType(mapEDataType, Map.class, "Map", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EsbPackageImpl
