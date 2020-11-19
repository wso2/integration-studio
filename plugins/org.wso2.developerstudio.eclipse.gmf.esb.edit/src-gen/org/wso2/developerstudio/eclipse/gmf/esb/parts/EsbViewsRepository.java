/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

/**
 * 
 * 
 */
public class EsbViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * EsbDiagram view descriptor
	 * 
	 */
	public static class EsbDiagram {
		public static class Properties {
	
			
			public static String test = "esb::EsbDiagram::properties::Test";
			
	
		}
	
	}

	/**
	 * EsbServer view descriptor
	 * 
	 */
	public static class EsbServer {
		public static class Properties {
	
			
			public static String children = "esb::EsbServer::properties::children";
			
			
			public static String type = "esb::EsbServer::properties::type";
			
	
		}
	
	}

	/**
	 * EsbLink view descriptor
	 * 
	 */
	public static class EsbLink {
		public static class Properties {
	
			
			public static String source = "esb::EsbLink::properties::source";
			
			
			public static String target = "esb::EsbLink::properties::target";
			
	
		}
	
	}

	/**
	 * CallMediator view descriptor
	 * 
	 */
	public static class CallMediator {
		public static class Properties {
	
			
			public static String description = "esb::CallMediator::properties::description";
			
			
			public static String commentsList = "esb::CallMediator::properties::commentsList";
			
			
			public static String reverse = "esb::CallMediator::properties::Reverse";
			
			
			public static String endpoint = "esb::CallMediator::properties::endpoint";
			
			
			public static String endpointType = "esb::CallMediator::properties::endpointType";
			
			
			public static String enableBlockingCalls = "esb::CallMediator::properties::enableBlockingCalls";
			
			// Start of user code for endpointXpath ElementEditor key
			public static String endpointXpath = "esb::CallMediator::properties::endpointXpath";
			// End of user code
			
			// Start of user code for endpointRegistryKey ElementEditor key
			public static String endpointRegistryKey = "esb::CloneTarget::properties::endpointRegistryKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * CallMediatorInputConnector view descriptor
	 * 
	 */
	public static class CallMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::CallMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CallMediatorOutputConnector view descriptor
	 * 
	 */
	public static class CallMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CallMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * CallMediatorEndpointOutputConnector view descriptor
	 * 
	 */
	public static class CallMediatorEndpointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CallMediatorEndpointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EndPointProperty view descriptor
	 * 
	 */
	public static class EndPointProperty {
		public static class Properties {
	
			
			public static String name = "esb::EndPointProperty::properties::name";
			
			
			public static String value = "esb::EndPointProperty::properties::value";
			
			
			public static String scope = "esb::EndPointProperty::properties::scope";
			
			
			public static String valueType = "esb::EndPointProperty::properties::valueType";
			
			// Start of user code for valueExpression ElementEditor key
			public static String valueExpression = "esb::SqlParameterDefinition::properties::valueExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * ProxyService view descriptor
	 * 
	 */
	public static class ProxyService {
		public static class Basic {
	
			
			public static String name = "esb::ProxyService::basic::name";
			
			
			public static String pinnedServers = "esb::ProxyService::basic::pinnedServers";
			
			
			public static String serviceGroup = "esb::ProxyService::basic::serviceGroup";
			
			
			public static String traceEnabled = "esb::ProxyService::basic::traceEnabled";
			
			
			public static String statisticsEnabled = "esb::ProxyService::basic::statisticsEnabled";
			
			
			public static String startOnLoad = "esb::ProxyService::basic::startOnLoad";
			
			
			public static String transports = "esb::ProxyService::basic::transports";
			
			// Start of user code for onError ElementEditor key
			public static String onError = "esb::Sequences::properties::onError";
			// End of user code
			
	
		}
	
		public static class Endpoint {
	
			
			public static String endpointType = "esb::ProxyService::endpoint::endpointType";
			
			
			public static String endpointName = "esb::ProxyService::endpoint::endpointName";
			
			// Start of user code for endpointKey ElementEditor key
			public static String endpointKey = "esb::ProxyService::endpoint::endpointKey";
			// End of user code
			
	
		}
	
		public static class FaultSequence {
	
			
			public static String faultSequenceType = "esb::ProxyService::faultSequence::faultSequenceType";
			
			
			public static String faultSequenceName = "esb::ProxyService::faultSequence::faultSequenceName";
			
			// Start of user code for faultSequenceKey ElementEditor key
			public static String faultSequenceKey = "esb::APIResource::faultSequence::faultSequenceKey";
			// End of user code
			
			// Start of user code for faultSequenceOnError ElementEditor key
			public static String faultSequenceOnError = "esb::ProxyService::faultSequence::faultSequenceOnError";
			// End of user code
			
	
		}
	
		public static class InSequence {
	
			
			public static String inSequenceType = "esb::ProxyService::inSequence::inSequenceType";
			
			
			public static String inSequenceName = "esb::ProxyService::inSequence::inSequenceName";
			
			// Start of user code for inSequenceKey ElementEditor key
			public static String inSequenceKey = "esb::APIResource::inSequence::inSequenceKey";
			// End of user code
			
			// Start of user code for inSequenceOnError ElementEditor key
			public static String inSequenceOnError = "esb::ProxyService::inSequence::inSequenceOnError";
			// End of user code
			
	
		}
	
		public static class OutSequence {
	
			
			public static String outSequenceType = "esb::ProxyService::outSequence::outSequenceType";
			
			
			public static String outSequenceName = "esb::ProxyService::outSequence::outSequenceName";
			
			// Start of user code for outSequenceKey ElementEditor key
			public static String outSequenceKey = "esb::APIResource::outSequence::outSequenceKey";
			// End of user code
			
			// Start of user code for outSequenceOnError ElementEditor key
			public static String outSequenceOnError = "esb::ProxyService::outSequence::outSequenceOnError";
			// End of user code
			
	
		}
	
		public static class Parameters {
	
			
			public static String serviceParameters = "esb::ProxyService::parameters::serviceParameters";
			
	
		}
	
		public static class ReliableMessaging {
	
			
			public static String reliableMessagingEnabled = "esb::ProxyService::reliableMessaging::reliableMessagingEnabled";
			
	
		}
	
		public static class Security {
	
			
			public static String securityEnabled = "esb::ProxyService::security::securityEnabled";
			
			
			public static String servicePolicies = "esb::ProxyService::security::servicePolicies";
			
	
		}
	
		public static class Wsdl {
	
			
			public static String wsdlType = "esb::ProxyService::wsdl::wsdlType";
			
			
			public static String wsdlXML = "esb::ProxyService::wsdl::wsdlXML";
			
			
			public static String wsdlURL = "esb::ProxyService::wsdl::wsdlURL";
			
			
			public static String wsdlResources = "esb::ProxyService::wsdl::wsdlResources";
			
			
			public static String preservePolicy = "esb::ProxyService::wsdl::preservePolicy";
			
			// Start of user code for wsdlKey ElementEditor key
			public static String wsdlKey = "esb::ProxyService::wsdl::wsdlKey";
			// End of user code
			
			// Start of user code for wsdlEndpoint ElementEditor key
			public static String wsdlEndpoint = "esb::ProxyService::wsdl::wsdlEndpoint";
			// End of user code
			
	
		}
	
		public static class Properties {
	
			
			public static String description = "esb::ProxyService::properties::description";
			
			
			public static String commentsList = "esb::ProxyService::properties::commentsList";
			
			
			public static String inSequenceInputConnectors = "esb::ProxyService::properties::inSequenceInputConnectors";
			
			
			public static String mainSequence = "esb::ProxyService::properties::mainSequence";
			
	
		}
	
	}

	/**
	 * ProxyOutputConnector view descriptor
	 * 
	 */
	public static class ProxyOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ProxyOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ProxyInputConnector view descriptor
	 * 
	 */
	public static class ProxyInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ProxyInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ProxyOutSequenceOutputConnector view descriptor
	 * 
	 */
	public static class ProxyOutSequenceOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ProxyOutSequenceOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ProxyInSequenceInputConnector view descriptor
	 * 
	 */
	public static class ProxyInSequenceInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ProxyInSequenceInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ProxyWSDLResource view descriptor
	 * 
	 */
	public static class ProxyWSDLResource {
		public static class Properties {
	
			
			public static String location = "esb::ProxyWSDLResource::properties::location";
			
			// Start of user code for key ElementEditor key
			public static String key = "esb::ProxyWSDLResource::properties::key";
			// End of user code
			
	
		}
	
	}

	/**
	 * ProxyFaultInputConnector view descriptor
	 * 
	 */
	public static class ProxyFaultInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ProxyFaultInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ProxyServiceParameter view descriptor
	 * 
	 */
	public static class ProxyServiceParameter {
		public static class Properties {
	
			
			public static String name = "esb::ProxyServiceParameter::properties::name";
			
			
			public static String value = "esb::ProxyServiceParameter::properties::value";
			
	
		}
	
	}

	/**
	 * ProxyServicePolicy view descriptor
	 * 
	 */
	public static class ProxyServicePolicy {
		public static class Properties {
	
			// Start of user code for policyKey ElementEditor key
			public static String policyKey = "esb::ThrottleMediator::throttlePolicy::policyKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * ProxyServiceSequenceAndEndpointContainer view descriptor
	 * 
	 */
	public static class ProxyServiceSequenceAndEndpointContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * ProxyServiceFaultContainer view descriptor
	 * 
	 */
	public static class ProxyServiceFaultContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * ProxyServiceContainer view descriptor
	 * 
	 */
	public static class ProxyServiceContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * MediatorFlow view descriptor
	 * 
	 */
	public static class MediatorFlow {
		public static class Properties {
	
			
			public static String children = "esb::MediatorFlow::properties::children";
			
	
		}
	
	}

	/**
	 * EndpointFlow view descriptor
	 * 
	 */
	public static class EndpointFlow {
		public static class Properties {
	
			
			public static String children = "esb::EndpointFlow::properties::children";
			
	
		}
	
	}

	/**
	 * MessageMediator view descriptor
	 * 
	 */
	public static class MessageMediator {
		public static class Properties {
	
			
			public static String description = "esb::MessageMediator::properties::description";
			
			
			public static String commentsList = "esb::MessageMediator::properties::commentsList";
			
	
		}
	
	}

	/**
	 * MessageInputConnector view descriptor
	 * 
	 */
	public static class MessageInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::MessageInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * MessageOutputConnector view descriptor
	 * 
	 */
	public static class MessageOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::MessageOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * DefaultEndPoint view descriptor
	 * 
	 */
	public static class DefaultEndPoint {
		public static class Basic {
	
			
			public static String commentsList = "esb::DefaultEndPoint::Basic::commentsList";
			
			
			public static String endPointName = "esb::DefaultEndPoint::Basic::endPointName";
			
			
			public static String anonymous = "esb::DefaultEndPoint::Basic::anonymous";
			
			
			public static String inLine = "esb::DefaultEndPoint::Basic::InLine";
			
			
			public static String duplicate = "esb::DefaultEndPoint::Basic::duplicate";
			
			
			public static String reversed = "esb::DefaultEndPoint::Basic::reversed";
			
			
			public static String format = "esb::DefaultEndPoint::Basic::format";
			
			
			public static String templateParameters = "esb::DefaultEndPoint::Basic::templateParameters";
			
			
			public static String statisticsEnabled = "esb::DefaultEndPoint::Basic::statisticsEnabled";
			
			
			public static String traceEnabled = "esb::DefaultEndPoint::Basic::traceEnabled";
			
	
		}
	
		public static class EndpointSuspendState {
	
			
			public static String suspendErrorCodes = "esb::DefaultEndPoint::Endpoint Suspend State::suspendErrorCodes";
			
			
			public static String suspendInitialDuration = "esb::DefaultEndPoint::Endpoint Suspend State::suspendInitialDuration";
			
			
			public static String suspendMaximumDuration = "esb::DefaultEndPoint::Endpoint Suspend State::suspendMaximumDuration";
			
			
			public static String suspendProgressionFactor = "esb::DefaultEndPoint::Endpoint Suspend State::suspendProgressionFactor";
			
	
		}
	
		public static class EndpointTimeoutState {
	
			
			public static String retryErrorCodes = "esb::DefaultEndPoint::Endpoint Timeout State::retryErrorCodes";
			
			
			public static String retryCount = "esb::DefaultEndPoint::Endpoint Timeout State::retryCount";
			
			
			public static String retryDelay = "esb::DefaultEndPoint::Endpoint Timeout State::retryDelay";
			
	
		}
	
		public static class Misc {
	
			
			public static String properties = "esb::DefaultEndPoint::Misc::properties";
			
			
			public static String optimize = "esb::DefaultEndPoint::Misc::optimize";
			
			
			public static String description = "esb::DefaultEndPoint::Misc::description";
			
	
		}
	
		public static class QoS {
	
			
			public static String reliableMessagingEnabled = "esb::DefaultEndPoint::QoS::reliableMessagingEnabled";
			
			
			public static String securityEnabled = "esb::DefaultEndPoint::QoS::securityEnabled";
			
			
			public static String addressingEnabled = "esb::DefaultEndPoint::QoS::addressingEnabled";
			
			
			public static String addressingSeparateListener = "esb::DefaultEndPoint::QoS::addressingSeparateListener";
			
			
			public static String addressingVersion = "esb::DefaultEndPoint::QoS::addressingVersion";
			
			// Start of user code for Reliable Messaging Policy ElementEditor key
			public static String reliableMessagingPolicy = "esb::AddressEndPoint::QoS::Reliable Messaging Policy";
			// End of user code
			
			// Start of user code for Security Policy ElementEditor key
			public static String securityPolicy = "esb::AddressEndPoint::QoS::Security Policy";
			// End of user code
			
			// Start of user code for Inbound Policy ElementEditor key
			public static String inboundPolicy = "esb::AddressEndPoint::QoS::Inbound Policy";
			// End of user code
			
			// Start of user code for Outbound Policy ElementEditor key
			public static String outboundPolicy = "esb::AddressEndPoint::QoS::Outbound Policy";
			// End of user code
			
	
		}
	
		public static class Timeout {
	
			
			public static String timeOutDuration = "esb::DefaultEndPoint::Timeout::timeOutDuration";
			
			
			public static String timeOutAction = "esb::DefaultEndPoint::Timeout::timeOutAction";
			
	
		}
	
		public static class FailoverErrorCodes {
	
			
			public static String failoverNonRetryErrorCodes = "esb::DefaultEndPoint::Failover Error Codes::failoverNonRetryErrorCodes";
			
	
		}
	
	}

	/**
	 * DefaultEndPointInputConnector view descriptor
	 * 
	 */
	public static class DefaultEndPointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::DefaultEndPointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * DefaultEndPointOutputConnector view descriptor
	 * 
	 */
	public static class DefaultEndPointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::DefaultEndPointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * AddressEndPoint view descriptor
	 * 
	 */
	public static class AddressEndPoint {
		public static class Basic {
	
			
			public static String commentsList = "esb::AddressEndPoint::Basic::commentsList";
			
			
			public static String endPointName = "esb::AddressEndPoint::Basic::endPointName";
			
			
			public static String anonymous = "esb::AddressEndPoint::Basic::anonymous";
			
			
			public static String inLine = "esb::AddressEndPoint::Basic::InLine";
			
			
			public static String duplicate = "esb::AddressEndPoint::Basic::duplicate";
			
			
			public static String reversed = "esb::AddressEndPoint::Basic::reversed";
			
			
			public static String format = "esb::AddressEndPoint::Basic::format";
			
			
			public static String templateParameters = "esb::AddressEndPoint::Basic::templateParameters";
			
			
			public static String statisticsEnabled = "esb::AddressEndPoint::Basic::statisticsEnabled";
			
			
			public static String traceEnabled = "esb::AddressEndPoint::Basic::traceEnabled";
			
			
			public static String uRI = "esb::AddressEndPoint::Basic::URI";
			
	
		}
	
		public static class EndpointSuspendState {
	
			
			public static String suspendErrorCodes = "esb::AddressEndPoint::Endpoint Suspend State::suspendErrorCodes";
			
			
			public static String suspendInitialDuration = "esb::AddressEndPoint::Endpoint Suspend State::suspendInitialDuration";
			
			
			public static String suspendMaximumDuration = "esb::AddressEndPoint::Endpoint Suspend State::suspendMaximumDuration";
			
			
			public static String suspendProgressionFactor = "esb::AddressEndPoint::Endpoint Suspend State::suspendProgressionFactor";
			
	
		}
	
		public static class EndpointTimeoutState {
	
			
			public static String retryErrorCodes = "esb::AddressEndPoint::Endpoint Timeout State::retryErrorCodes";
			
			
			public static String retryCount = "esb::AddressEndPoint::Endpoint Timeout State::retryCount";
			
			
			public static String retryDelay = "esb::AddressEndPoint::Endpoint Timeout State::retryDelay";
			
	
		}
	
		public static class Misc {
	
			
			public static String properties = "esb::AddressEndPoint::Misc::properties";
			
			
			public static String optimize = "esb::AddressEndPoint::Misc::optimize";
			
			
			public static String description = "esb::AddressEndPoint::Misc::description";
			
	
		}
	
		public static class QoS {
	
			
			public static String reliableMessagingEnabled = "esb::AddressEndPoint::QoS::reliableMessagingEnabled";
			
			
			public static String securityEnabled = "esb::AddressEndPoint::QoS::securityEnabled";
			
			
			public static String addressingEnabled = "esb::AddressEndPoint::QoS::addressingEnabled";
			
			
			public static String addressingVersion = "esb::AddressEndPoint::QoS::addressingVersion";
			
			
			public static String addressingSeparateListener = "esb::AddressEndPoint::QoS::addressingSeparateListener";
			
			// Start of user code for Reliable Messaging Policy ElementEditor key
			public static String reliableMessagingPolicy = "esb::AddressEndPoint::QoS::Reliable Messaging Policy";
			// End of user code
			
			// Start of user code for Inbound Policy ElementEditor key
			public static String inboundPolicy = "esb::AddressEndPoint::QoS::Inbound Policy";
			// End of user code
			
			// Start of user code for Outbound Policy ElementEditor key
			public static String outboundPolicy = "esb::AddressEndPoint::QoS::Outbound Policy";
			// End of user code
			
			// Start of user code for Security Policy ElementEditor key
			public static String securityPolicy = "esb::AddressEndPoint::QoS::Security Policy";
			// End of user code
			
	
		}
	
		public static class Timeout {
	
			
			public static String timeOutDuration = "esb::AddressEndPoint::Timeout::timeOutDuration";
			
			
			public static String timeOutAction = "esb::AddressEndPoint::Timeout::timeOutAction";
			
	
		}
	
		public static class FailoverErrorCodes {
	
			
			public static String failoverType = "esb::AddressEndPoint::Failover Error Codes::failoverType";
			
			
			public static String failoverRetryErrorCodes = "esb::AddressEndPoint::Failover Error Codes::failoverRetryErrorCodes";
			
			
			public static String failoverNonRetryErrorCodes = "esb::AddressEndPoint::Failover Error Codes::failoverNonRetryErrorCodes";
			
	
		}
	
	}

	/**
	 * AddressEndPointInputConnector view descriptor
	 * 
	 */
	public static class AddressEndPointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::AddressEndPointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * AddressEndPointOutputConnector view descriptor
	 * 
	 */
	public static class AddressEndPointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::AddressEndPointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * TemplateEndpoint view descriptor
	 * 
	 */
	public static class TemplateEndpoint {
		public static class Properties {
	
			
			public static String description = "esb::TemplateEndpoint::properties::description";
			
			
			public static String commentsList = "esb::TemplateEndpoint::properties::commentsList";
			
			
			public static String endPointName = "esb::TemplateEndpoint::properties::endPointName";
			
			
			public static String anonymous = "esb::TemplateEndpoint::properties::anonymous";
			
			
			public static String inLine = "esb::TemplateEndpoint::properties::InLine";
			
			
			public static String duplicate = "esb::TemplateEndpoint::properties::duplicate";
			
			
			public static String properties_ = "esb::TemplateEndpoint::properties::properties_";
			
			
			public static String reversed = "esb::TemplateEndpoint::properties::reversed";
			
			
			public static String reliableMessagingEnabled = "esb::TemplateEndpoint::properties::reliableMessagingEnabled";
			
			
			public static String securityEnabled = "esb::TemplateEndpoint::properties::securityEnabled";
			
			
			public static String addressingEnabled = "esb::TemplateEndpoint::properties::addressingEnabled";
			
			
			public static String addressingVersion = "esb::TemplateEndpoint::properties::addressingVersion";
			
			
			public static String addressingSeparateListener = "esb::TemplateEndpoint::properties::addressingSeparateListener";
			
			
			public static String timeOutDuration = "esb::TemplateEndpoint::properties::timeOutDuration";
			
			
			public static String timeOutAction = "esb::TemplateEndpoint::properties::timeOutAction";
			
			
			public static String retryErrorCodes = "esb::TemplateEndpoint::properties::retryErrorCodes";
			
			
			public static String retryCount = "esb::TemplateEndpoint::properties::retryCount";
			
			
			public static String retryDelay = "esb::TemplateEndpoint::properties::retryDelay";
			
			
			public static String suspendErrorCodes = "esb::TemplateEndpoint::properties::suspendErrorCodes";
			
			
			public static String suspendInitialDuration = "esb::TemplateEndpoint::properties::suspendInitialDuration";
			
			
			public static String suspendMaximumDuration = "esb::TemplateEndpoint::properties::suspendMaximumDuration";
			
			
			public static String suspendProgressionFactor = "esb::TemplateEndpoint::properties::suspendProgressionFactor";
			
			
			public static String format = "esb::TemplateEndpoint::properties::format";
			
			
			public static String optimize = "esb::TemplateEndpoint::properties::optimize";
			
			
			public static String templateParameters = "esb::TemplateEndpoint::properties::templateParameters";
			
			
			public static String statisticsEnabled = "esb::TemplateEndpoint::properties::statisticsEnabled";
			
			
			public static String traceEnabled = "esb::TemplateEndpoint::properties::traceEnabled";
			
			
			public static String address = "esb::TemplateEndpoint::properties::address";
			
			
			public static String targetTemplate = "esb::TemplateEndpoint::properties::targetTemplate";
			
			
			public static String parameters = "esb::TemplateEndpoint::properties::parameters";
			
			
			public static String availableTemplates = "esb::TemplateEndpoint::properties::availableTemplates";
			
	
		}
	
	}

	/**
	 * TemplateEndpointInputConnector view descriptor
	 * 
	 */
	public static class TemplateEndpointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::TemplateEndpointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * TemplateEndpointOutputConnector view descriptor
	 * 
	 */
	public static class TemplateEndpointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::TemplateEndpointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * TemplateEndpointParameter view descriptor
	 * 
	 */
	public static class TemplateEndpointParameter {
		public static class Properties {
	
			
			public static String parameterName = "esb::TemplateEndpointParameter::properties::parameterName";
			
			
			public static String parameterValue = "esb::TemplateEndpointParameter::properties::parameterValue";
			
	
		}
	
	}

	/**
	 * HTTPEndpoint view descriptor
	 * 
	 */
	public static class HTTPEndpoint {
		public static class Properties {
	
			
			public static String commentsList = "esb::HTTPEndpoint::properties::commentsList";
			
			
			public static String endPointName = "esb::HTTPEndpoint::properties::endPointName";
			
			
			public static String anonymous = "esb::HTTPEndpoint::properties::anonymous";
			
			
			public static String inLine = "esb::HTTPEndpoint::properties::InLine";
			
			
			public static String duplicate = "esb::HTTPEndpoint::properties::duplicate";
			
			
			public static String reversed = "esb::HTTPEndpoint::properties::reversed";
			
			
			public static String reliableMessagingEnabled = "esb::HTTPEndpoint::properties::reliableMessagingEnabled";
			
			
			public static String securityEnabled = "esb::HTTPEndpoint::properties::securityEnabled";
			
			
			public static String addressingEnabled = "esb::HTTPEndpoint::properties::addressingEnabled";
			
			
			public static String addressingVersion = "esb::HTTPEndpoint::properties::addressingVersion";
			
			
			public static String addressingSeparateListener = "esb::HTTPEndpoint::properties::addressingSeparateListener";
			
			
			public static String format = "esb::HTTPEndpoint::properties::format";
			
			
			public static String optimize = "esb::HTTPEndpoint::properties::optimize";
			
			
			public static String templateParameters = "esb::HTTPEndpoint::properties::templateParameters";
			
	
		}
	
		public static class Basic {
	
			
			public static String statisticsEnabled = "esb::HTTPEndpoint::basic::statisticsEnabled";
			
			
			public static String traceEnabled = "esb::HTTPEndpoint::basic::traceEnabled";
			
			
			public static String uRITemplate = "esb::HTTPEndpoint::basic::URITemplate";
			
			
			public static String httpMethod = "esb::HTTPEndpoint::basic::HttpMethod";
			
	
		}
	
		public static class EndpointDescription {
	
			
			public static String description = "esb::HTTPEndpoint::endpointDescription::description";
			
	
		}
	
		public static class EndpointProperties {
	
			
			public static String properties = "esb::HTTPEndpoint::endpointProperties::properties";
			
	
		}
	
		public static class EndpointSuspendState {
	
			
			public static String suspendErrorCodes = "esb::HTTPEndpoint::endpointSuspendState::suspendErrorCodes";
			
			
			public static String suspendInitialDuration = "esb::HTTPEndpoint::endpointSuspendState::suspendInitialDuration";
			
			
			public static String suspendMaximumDuration = "esb::HTTPEndpoint::endpointSuspendState::suspendMaximumDuration";
			
			
			public static String suspendProgressionFactor = "esb::HTTPEndpoint::endpointSuspendState::suspendProgressionFactor";
			
	
		}
	
		public static class EndpointTimeoutState {
	
			
			public static String retryErrorCodes = "esb::HTTPEndpoint::endpointTimeoutState::retryErrorCodes";
			
			
			public static String retryCount = "esb::HTTPEndpoint::endpointTimeoutState::retryCount";
			
			
			public static String retryDelay = "esb::HTTPEndpoint::endpointTimeoutState::retryDelay";
			
	
		}
	
		public static class Timeout {
	
			
			public static String timeOutDuration = "esb::HTTPEndpoint::timeout::timeOutDuration";
			
			
			public static String timeOutAction = "esb::HTTPEndpoint::timeout::timeOutAction";
			
	
		}
	
		public static class FailoverErrorCodes {
	
			
			public static String failoverNonRetryErrorCodes = "esb::HTTPEndpoint::Failover Error Codes::failoverNonRetryErrorCodes";
			
	
		}
	
	}

	/**
	 * HTTPEndPointInputConnector view descriptor
	 * 
	 */
	public static class HTTPEndPointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::HTTPEndPointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * HTTPEndPointOutputConnector view descriptor
	 * 
	 */
	public static class HTTPEndPointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::HTTPEndPointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * DropMediator view descriptor
	 * 
	 */
	public static class DropMediator {
		public static class Properties {
	
			
			public static String description = "esb::DropMediator::properties::description";
			
			
			public static String commentsList = "esb::DropMediator::properties::commentsList";
			
			
			public static String reverse = "esb::DropMediator::properties::Reverse";
			
	
		}
	
	}

	/**
	 * DropMediatorInputConnector view descriptor
	 * 
	 */
	public static class DropMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::DropMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * FilterMediator view descriptor
	 * 
	 */
	public static class FilterMediator {
		public static class Properties {
	
			
			public static String description = "esb::FilterMediator::properties::description";
			
			
			public static String commentsList = "esb::FilterMediator::properties::commentsList";
			
			
			public static String reverse = "esb::FilterMediator::properties::Reverse";
			
			
			public static String conditionType = "esb::FilterMediator::properties::conditionType";
			
			
			public static String regex = "esb::FilterMediator::properties::regex";
			
			// Start of user code for XPath ElementEditor key
			public static String xPath = "esb::FilterMediator::properties::XPath";
			// End of user code
			
			// Start of user code for Source ElementEditor key
			public static String source = "esb::FilterMediator::properties::Source";
			// End of user code
			
	
		}
	
	}

	/**
	 * FilterContainer view descriptor
	 * 
	 */
	public static class FilterContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * FilterPassContainer view descriptor
	 * 
	 */
	public static class FilterPassContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * FilterFailContainer view descriptor
	 * 
	 */
	public static class FilterFailContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * FilterMediatorInputConnector view descriptor
	 * 
	 */
	public static class FilterMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::FilterMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * FilterMediatorOutputConnector view descriptor
	 * 
	 */
	public static class FilterMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::FilterMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * FilterMediatorPassOutputConnector view descriptor
	 * 
	 */
	public static class FilterMediatorPassOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::FilterMediatorPassOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * FilterMediatorFailOutputConnector view descriptor
	 * 
	 */
	public static class FilterMediatorFailOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::FilterMediatorFailOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * MergeNode view descriptor
	 * 
	 */
	public static class MergeNode {
		public static class Properties {
	
			
			public static String description = "esb::MergeNode::properties::description";
			
			
			public static String commentsList = "esb::MergeNode::properties::commentsList";
			
			
			public static String reverse = "esb::MergeNode::properties::Reverse";
			
	
		}
	
	}

	/**
	 * MergeNodeFirstInputConnector view descriptor
	 * 
	 */
	public static class MergeNodeFirstInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::MergeNodeFirstInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * MergeNodeSecondInputConnector view descriptor
	 * 
	 */
	public static class MergeNodeSecondInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::MergeNodeSecondInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * MergeNodeOutputConnector view descriptor
	 * 
	 */
	public static class MergeNodeOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::MergeNodeOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * LogMediator view descriptor
	 * 
	 */
	public static class LogMediator {
		public static class Properties {
	
			
			public static String logCategory = "esb::LogMediator::properties::logCategory";
			
			
			public static String logLevel = "esb::LogMediator::properties::logLevel";
			
			
			public static String logSeparator = "esb::LogMediator::properties::logSeparator";
			
			
			public static String properties_ = "esb::LogMediator::properties::properties_";
			
			
			public static String description = "esb::LogMediator::properties::description";
			
	
		}
	
	}

	/**
	 * LogMediatorInputConnector view descriptor
	 * 
	 */
	public static class LogMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::LogMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * LogMediatorOutputConnector view descriptor
	 * 
	 */
	public static class LogMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::LogMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * LogProperty view descriptor
	 * 
	 */
	public static class LogProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::LogProperty::properties::propertyName";
			
			
			public static String propertyValueType = "esb::LogProperty::properties::propertyValueType";
			
			
			public static String propertyValue = "esb::LogProperty::properties::propertyValue";
			
			// Start of user code for propertyExpression ElementEditor key
			public static String propertyExpression = "esb::LogProperty::properties::propertyExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * PublishEventMediator view descriptor
	 * 
	 */
	public static class PublishEventMediator {
		public static class Properties {
	
			
			public static String description = "esb::PublishEventMediator::properties::description";
			
			
			public static String commentsList = "esb::PublishEventMediator::properties::commentsList";
			
			
			public static String reverse = "esb::PublishEventMediator::properties::Reverse";
			
			
			public static String streamName = "esb::PublishEventMediator::properties::streamName";
			
			
			public static String streamVersion = "esb::PublishEventMediator::properties::streamVersion";
			
			
			public static String eventSink = "esb::PublishEventMediator::properties::eventSink";
			
			
			public static String metaAttributes = "esb::PublishEventMediator::properties::metaAttributes";
			
			
			public static String correlationAttributes = "esb::PublishEventMediator::properties::correlationAttributes";
			
			
			public static String payloadAttributes = "esb::PublishEventMediator::properties::payloadAttributes";
			
			
			public static String arbitraryAttributes = "esb::PublishEventMediator::properties::arbitraryAttributes";
			
			
			public static String async = "esb::PublishEventMediator::properties::Async";
			
			
			public static String asyncTimeout = "esb::PublishEventMediator::properties::AsyncTimeout";
			
	
		}
	
	}

	/**
	 * PublishEventMediatorInputConnector view descriptor
	 * 
	 */
	public static class PublishEventMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::PublishEventMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * PublishEventMediatorOutputConnector view descriptor
	 * 
	 */
	public static class PublishEventMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::PublishEventMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * PublishEventMediatorAttribute view descriptor
	 * 
	 */
	public static class PublishEventMediatorAttribute {
		public static class Properties {
	
			
			public static String attributeName = "esb::PublishEventMediatorAttribute::properties::attributeName";
			
			
			public static String attributeValueType = "esb::PublishEventMediatorAttribute::properties::attributeValueType";
			
			
			public static String attributeValue = "esb::PublishEventMediatorAttribute::properties::attributeValue";
			
			
			public static String attributeType = "esb::PublishEventMediatorAttribute::properties::attributeType";
			
			
			public static String defaultValue = "esb::PublishEventMediatorAttribute::properties::defaultValue";
			
			// Start of user code for attributeExpression ElementEditor key
			public static String attributeExpression = "esb::PublishEventMediatorAttribute::properties::attributeExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * BAMMediator view descriptor
	 * 
	 */
	public static class BAMMediator {
		public static class Properties {
	
			
			public static String description = "esb::BAMMediator::properties::description";
			
			
			public static String commentsList = "esb::BAMMediator::properties::commentsList";
			
			
			public static String reverse = "esb::BAMMediator::properties::Reverse";
			
			
			public static String serverProfile = "esb::BAMMediator::properties::serverProfile";
			
			
			public static String streamName = "esb::BAMMediator::properties::streamName";
			
			
			public static String streamVersion = "esb::BAMMediator::properties::streamVersion";
			
	
		}
	
	}

	/**
	 * BAMMediatorInputConnector view descriptor
	 * 
	 */
	public static class BAMMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::BAMMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * BAMMediatorOutputConnector view descriptor
	 * 
	 */
	public static class BAMMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::BAMMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * BeanMediator view descriptor
	 * 
	 */
	public static class BeanMediator {
		public static class Properties {
	
			
			public static String description = "esb::BeanMediator::properties::description";
			
			
			public static String commentsList = "esb::BeanMediator::properties::commentsList";
			
			
			public static String reverse = "esb::BeanMediator::properties::Reverse";
			
			
			public static String class_ = "esb::BeanMediator::properties::class";
			
			
			public static String action = "esb::BeanMediator::properties::action";
			
			
			public static String var = "esb::BeanMediator::properties::var";
			
			
			public static String property = "esb::BeanMediator::properties::property";
			
			
			public static String valueType = "esb::BeanMediator::properties::valueType";
			
			
			public static String valueLiteral = "esb::BeanMediator::properties::valueLiteral";
			
			
			public static String targetType = "esb::BeanMediator::properties::targetType";
			
			
			public static String targetLiteral = "esb::BeanMediator::properties::targetLiteral";
			
			// Start of user code for targetExpression ElementEditor key
			public static String targetExpression = "esb::BeanMediator::properties::targetExpression";
			// End of user code
			
			// Start of user code for valueExpression ElementEditor key
			public static String valueExpression = "esb::BeanMediator::properties::valueExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * BeanMediatorInputConnector view descriptor
	 * 
	 */
	public static class BeanMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::BeanMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * BeanMediatorOutputConnector view descriptor
	 * 
	 */
	public static class BeanMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::BeanMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EJBMediator view descriptor
	 * 
	 */
	public static class EJBMediator {
		public static class Properties {
	
			
			public static String description = "esb::EJBMediator::properties::description";
			
			
			public static String commentsList = "esb::EJBMediator::properties::commentsList";
			
			
			public static String reverse = "esb::EJBMediator::properties::Reverse";
			
			
			public static String beanstalk = "esb::EJBMediator::properties::beanstalk";
			
			
			public static String class_ = "esb::EJBMediator::properties::class";
			
			
			public static String method = "esb::EJBMediator::properties::method";
			
			
			public static String sessionIdType = "esb::EJBMediator::properties::sessionIdType";
			
			
			public static String sessionIdLiteral = "esb::EJBMediator::properties::sessionIdLiteral";
			
			
			public static String remove = "esb::EJBMediator::properties::remove";
			
			
			public static String target = "esb::EJBMediator::properties::target";
			
			
			public static String jNDIName = "esb::EJBMediator::properties::JNDIName";
			
			
			public static String methodArguments = "esb::EJBMediator::properties::methodArguments";
			
			// Start of user code for sessionIdExpression ElementEditor key
			public static String sessionIdExpression = "esb::EJBMediator::properties::sessionIdExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * EJBMediatorInputConnector view descriptor
	 * 
	 */
	public static class EJBMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::EJBMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * EJBMediatorOutputConnector view descriptor
	 * 
	 */
	public static class EJBMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EJBMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * MethodArgument view descriptor
	 * 
	 */
	public static class MethodArgument {
		public static class Properties {
	
			
			public static String propertyName = "esb::MethodArgument::properties::propertyName";
			
			
			public static String propertyValueType = "esb::MethodArgument::properties::propertyValueType";
			
			
			public static String propertyValue = "esb::MethodArgument::properties::propertyValue";
			
			// Start of user code for propertyExpression ElementEditor key
			public static String propertyExpression = "esb::MethodArgument::properties::propertyExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * RegistryKeyProperty view descriptor
	 * 
	 */
	public static class RegistryKeyProperty {
		public static class Properties {
	
			
			public static String prettyName = "esb::RegistryKeyProperty::properties::prettyName";
			
			
			public static String keyName = "esb::RegistryKeyProperty::properties::keyName";
			
			
			public static String keyValue = "esb::RegistryKeyProperty::properties::keyValue";
			
			
			public static String filters = "esb::RegistryKeyProperty::properties::filters";
			
	
		}
	
	}

	/**
	 * PropertyMediator view descriptor
	 * 
	 */
	public static class PropertyMediator {
		public static class Properties {
	
			
			public static String propertyName = "esb::PropertyMediator::properties::propertyName";
			
			
			public static String propertyDataType = "esb::PropertyMediator::properties::propertyDataType";
			
			
			public static String propertyAction = "esb::PropertyMediator::properties::propertyAction";
			
			
			public static String propertyScope = "esb::PropertyMediator::properties::propertyScope";
			
			
			public static String valueType = "esb::PropertyMediator::properties::valueType";
			
			
			public static String value = "esb::PropertyMediator::properties::value";
			
			
			public static String expression = "esb::PropertyMediator::properties::expression";
			
			
			public static String namespacePrefix = "esb::PropertyMediator::properties::namespacePrefix";
			
			
			public static String namespace = "esb::PropertyMediator::properties::namespace";
			
			
			public static String boolean_ = "esb::PropertyMediator::properties::boolean";
			
			
			public static String oM = "esb::PropertyMediator::properties::OM";
			
			
			public static String valueStringPattern = "esb::PropertyMediator::properties::valueStringPattern";
			
			
			public static String valueStringCapturingGroup = "esb::PropertyMediator::properties::valueStringCapturingGroup";
			
			
			public static String newPropertyName = "esb::PropertyMediator::properties::newPropertyName";
			
			// Start of user code for valueExpression ElementEditor key
			public static String valueExpression = "esb::PropertyMediator::properties::valueExpression";
			// End of user code
			
			
			public static String description = "esb::PropertyMediator::properties::description";
			
	
		}
	
	}

	/**
	 * PropertyMediatorInputConnector view descriptor
	 * 
	 */
	public static class PropertyMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::PropertyMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * PropertyMediatorOutputConnector view descriptor
	 * 
	 */
	public static class PropertyMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::PropertyMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * PropertyGroupMediator view descriptor
	 * 
	 */
	public static class PropertyGroupMediator {
		public static class Properties {
	
			
			public static String description = "esb::PropertyGroupMediator::properties::description";
			
			
			public static String commentsList = "esb::PropertyGroupMediator::properties::commentsList";
			
			
			public static String reverse = "esb::PropertyGroupMediator::properties::Reverse";
			
			
			public static String properties_ = "esb::PropertyGroupMediator::properties::properties_";
			
	
		}
	
	}

	/**
	 * PropertyGroupMediatorInputConnector view descriptor
	 * 
	 */
	public static class PropertyGroupMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::PropertyGroupMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * PropertyGroupMediatorOutputConnector view descriptor
	 * 
	 */
	public static class PropertyGroupMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::PropertyGroupMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * NamespacedProperty view descriptor
	 * 
	 */
	public static class NamespacedProperty {
		public static class Properties {
	
			
			public static String prettyName = "esb::NamespacedProperty::properties::prettyName";
			
			
			public static String propertyName = "esb::NamespacedProperty::properties::propertyName";
			
			
			public static String propertyValue = "esb::NamespacedProperty::properties::propertyValue";
			
			
			public static String namespaces = "esb::NamespacedProperty::properties::namespaces";
			
			
			public static String supportsDynamicXPaths = "esb::NamespacedProperty::properties::supportsDynamicXPaths";
			
			
			public static String dynamic = "esb::NamespacedProperty::properties::dynamic";
			
	
		}
	
	}

	/**
	 * EnrichMediator view descriptor
	 * 
	 */
	public static class EnrichMediator {
		public static class Misc {
	
			
			public static String description = "esb::EnrichMediator::Misc::description";
			
			
			public static String commentsList = "esb::EnrichMediator::Misc::commentsList";
			
			
			public static String reverse = "esb::EnrichMediator::Misc::Reverse";
			
	
		}
	
		public static class Source {
	
			
			public static String cloneSource = "esb::EnrichMediator::Source::cloneSource";
			
			
			public static String sourceType = "esb::EnrichMediator::Source::sourceType";
			
			
			public static String inlineType = "esb::EnrichMediator::Source::inlineType";
			
			
			public static String sourceXML = "esb::EnrichMediator::Source::sourceXML";
			
			
			public static String sourceProperty = "esb::EnrichMediator::Source::sourceProperty";
			
			// Start of user code for sourceXPath ElementEditor key
			public static String sourceXPath = "esb::RuleMediator::source::sourceXPath";
			// End of user code
			
			// Start of user code for inlineRegistryKey ElementEditor key
			public static String inlineRegistryKey = "esb::EnrichMediator::Source::inlineRegistryKey";
			// End of user code
			
	
		}
	
		public static class Target {
	
			
			public static String targetAction = "esb::EnrichMediator::Target::targetAction";
			
			
			public static String targetType = "esb::EnrichMediator::Target::targetType";
			
			
			public static String targetProperty = "esb::EnrichMediator::Target::targetProperty";
			
			// Start of user code for targetXPath ElementEditor key
			public static String targetXPath = "esb::RuleMediator::target::targetXPath";
			// End of user code
			
	
		}
	
	}

	/**
	 * EnrichMediatorInputConnector view descriptor
	 * 
	 */
	public static class EnrichMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::EnrichMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * EnrichMediatorOutputConnector view descriptor
	 * 
	 */
	public static class EnrichMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EnrichMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * XSLTMediator view descriptor
	 * 
	 */
	public static class XSLTMediator {
		public static class Properties {
	
			
			public static String description = "esb::XSLTMediator::properties::description";
			
			
			public static String commentsList = "esb::XSLTMediator::properties::commentsList";
			
			
			public static String reverse = "esb::XSLTMediator::properties::Reverse";
			
			
			public static String xsltSchemaKeyType = "esb::XSLTMediator::properties::xsltSchemaKeyType";
			
			
			public static String properties_ = "esb::XSLTMediator::properties::properties_";
			
			
			public static String features = "esb::XSLTMediator::properties::features";
			
			
			public static String resources = "esb::XSLTMediator::properties::resources";
			
			// Start of user code for sourceXpath ElementEditor key
			public static String sourceXpath = "esb::XSLTMediator::properties::sourceXpath";
			// End of user code
			
			// Start of user code for XSLTStaticSchemaKey ElementEditor key
			public static String xSLTStaticSchemaKey = "esb::XSLTMediator::properties::XSLTStaticSchemaKey";
			// End of user code
			
			// Start of user code for XSLTDynamicSchemaKey ElementEditor key
			public static String xSLTDynamicSchemaKey = "esb::XSLTMediator::properties::XSLTDynamicSchemaKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * XSLTProperty view descriptor
	 * 
	 */
	public static class XSLTProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::XSLTProperty::properties::propertyName";
			
			
			public static String propertyValueType = "esb::XSLTProperty::properties::propertyValueType";
			
			
			public static String propertyValue = "esb::XSLTProperty::properties::propertyValue";
			
			// Start of user code for propertyExpression ElementEditor key
			public static String propertyExpression = "esb::XSLTProperty::properties::propertyExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * XSLTFeature view descriptor
	 * 
	 */
	public static class XSLTFeature {
		public static class Properties {
	
			
			public static String featureName = "esb::XSLTFeature::properties::featureName";
			
			
			public static String featureEnabled = "esb::XSLTFeature::properties::featureEnabled";
			
	
		}
	
	}

	/**
	 * XSLTResource view descriptor
	 * 
	 */
	public static class XSLTResource {
		public static class Properties {
	
			
			public static String location = "esb::XSLTResource::properties::location";
			
			// Start of user code for resourceRegistryKey ElementEditor key
			public static String resourceRegistryKey = "esb::XSLTResource::properties::resourceRegistryKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * XSLTMediatorInputConnector view descriptor
	 * 
	 */
	public static class XSLTMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::XSLTMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * XSLTMediatorOutputConnector view descriptor
	 * 
	 */
	public static class XSLTMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::XSLTMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * SwitchMediator view descriptor
	 * 
	 */
	public static class SwitchMediator {
		public static class Properties {
	
			
			public static String description = "esb::SwitchMediator::properties::description";
			
			
			public static String commentsList = "esb::SwitchMediator::properties::commentsList";
			
			
			public static String reverse = "esb::SwitchMediator::properties::Reverse";
			
			
			public static String source = "esb::SwitchMediator::properties::source";
			
			
			public static String namespace = "esb::SwitchMediator::properties::namespace";
			
			
			public static String namespacePrefix = "esb::SwitchMediator::properties::namespacePrefix";
			
			
			public static String caseBranches = "esb::SwitchMediator::properties::caseBranches";
			
			// Start of user code for sourceXPath ElementEditor key
			public static String sourceXPath = "esb::SwitchMediator::properties::sourceXPath";
			// End of user code
			
	
		}
	
	}

	/**
	 * SwitchCaseBranchOutputConnector view descriptor
	 * 
	 */
	public static class SwitchCaseBranchOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SwitchCaseBranchOutputConnector::properties::commentMediators";
			
			
			public static String caseRegex = "esb::SwitchCaseBranchOutputConnector::properties::caseRegex";
			
	
		}
	
	}

	/**
	 * SwitchDefaultBranchOutputConnector view descriptor
	 * 
	 */
	public static class SwitchDefaultBranchOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SwitchDefaultBranchOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * SwitchMediatorInputConnector view descriptor
	 * 
	 */
	public static class SwitchMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::SwitchMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * SwitchMediatorOutputConnector view descriptor
	 * 
	 */
	public static class SwitchMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SwitchMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * SwitchMediatorContainer view descriptor
	 * 
	 */
	public static class SwitchMediatorContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * SwitchCaseParentContainer view descriptor
	 * 
	 */
	public static class SwitchCaseParentContainer {
		public static class Properties {
	
			
			public static String switchCaseContainer = "esb::SwitchCaseParentContainer::properties::switchCaseContainer";
			
	
		}
	
	}

	/**
	 * SwitchDefaultParentContainer view descriptor
	 * 
	 */
	public static class SwitchDefaultParentContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * SwitchCaseContainer view descriptor
	 * 
	 */
	public static class SwitchCaseContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * SwitchDefaultContainer view descriptor
	 * 
	 */
	public static class SwitchDefaultContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * SequenceDiagram view descriptor
	 * 
	 */
	public static class SequenceDiagram {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * EsbSequence view descriptor
	 * 
	 */
	public static class EsbSequence {
		public static class Properties {
	
			
			public static String name = "esb::EsbSequence::properties::name";
			
			
			public static String childMediators = "esb::EsbSequence::properties::childMediators";
			
	
		}
	
	}

	/**
	 * EsbSequenceInput view descriptor
	 * 
	 */
	public static class EsbSequenceInput {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * EsbSequenceOutput view descriptor
	 * 
	 */
	public static class EsbSequenceOutput {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * EsbSequenceInputConnector view descriptor
	 * 
	 */
	public static class EsbSequenceInputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EsbSequenceInputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EsbSequenceOutputConnector view descriptor
	 * 
	 */
	public static class EsbSequenceOutputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::EsbSequenceOutputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * Sequence view descriptor
	 * 
	 */
	public static class Sequence {
		public static class Properties {
	
			
			public static String description = "esb::Sequence::properties::description";
			
			
			public static String commentsList = "esb::Sequence::properties::commentsList";
			
			
			public static String reverse = "esb::Sequence::properties::Reverse";
			
			
			public static String name = "esb::Sequence::properties::name";
			
			
			public static String key = "esb::Sequence::properties::key";
			
			
			public static String outputConnector = "esb::Sequence::properties::outputConnector";
			
			
			public static String includedMediators = "esb::Sequence::properties::includedMediators";
			
			
			public static String receiveSequence = "esb::Sequence::properties::receiveSequence";
			
			
			public static String duplicate = "esb::Sequence::properties::duplicate";
			
			
			public static String referringSequenceType = "esb::Sequence::properties::referringSequenceType";
			
			// Start of user code for staticReferenceKey ElementEditor key
			public static String staticReferenceKey = "esb::NamedEndpoint::properties::staticReferenceKey";
			// End of user code
			
			// Start of user code for dynamicReferenceKey ElementEditor key
			public static String dynamicReferenceKey = "esb::NamedEndpoint::properties::dynamicReferenceKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * SequenceInputConnector view descriptor
	 * 
	 */
	public static class SequenceInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::SequenceInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * SequenceOutputConnector view descriptor
	 * 
	 */
	public static class SequenceOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SequenceOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EventMediator view descriptor
	 * 
	 */
	public static class EventMediator {
		public static class Properties {
	
			
			public static String description = "esb::EventMediator::properties::description";
			
			
			public static String commentsList = "esb::EventMediator::properties::commentsList";
			
			
			public static String reverse = "esb::EventMediator::properties::Reverse";
			
			
			public static String topicType = "esb::EventMediator::properties::topicType";
			
			
			public static String staticTopic = "esb::EventMediator::properties::staticTopic";
			
	
		}
	
	}

	/**
	 * EventMediatorInputConnector view descriptor
	 * 
	 */
	public static class EventMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::EventMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * EventMediatorOutputConnector view descriptor
	 * 
	 */
	public static class EventMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EventMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EntitlementMediator view descriptor
	 * 
	 */
	public static class EntitlementMediator {
		public static class Properties {
	
			
			public static String commentsList = "esb::EntitlementMediator::properties::commentsList";
			
			
			public static String reverse = "esb::EntitlementMediator::properties::Reverse";
			
			
			public static String entitlementServerURL = "esb::EntitlementMediator::properties::entitlementServerURL";
			
			
			public static String username = "esb::EntitlementMediator::properties::username";
			
			
			public static String password = "esb::EntitlementMediator::properties::password";
			
			
			public static String callbackHandler = "esb::EntitlementMediator::properties::callbackHandler";
			
			
			public static String callbackClassName = "esb::EntitlementMediator::properties::callbackClassName";
			
			
			public static String thriftHost = "esb::EntitlementMediator::properties::thriftHost";
			
			
			public static String thriftPort = "esb::EntitlementMediator::properties::thriftPort";
			
			
			public static String entitlementClientType = "esb::EntitlementMediator::properties::entitlementClientType";
			
			
			public static String onRejectSequenceType = "esb::EntitlementMediator::properties::onRejectSequenceType";
			
			// Start of user code for onRejectSequenceKey ElementEditor key
			public static String onRejectSequenceKey = "esb::EntitlementMediator::properties::onRejectSequenceKey";
			// End of user code
			
			
			public static String onAcceptSequenceType = "esb::EntitlementMediator::properties::onAcceptSequenceType";
			
			// Start of user code for onAcceptSequenceKey ElementEditor key
			public static String onAcceptSequenceKey = "esb::EntitlementMediator::properties::onAcceptSequenceKey";
			// End of user code
			
			
			public static String adviceSequenceType = "esb::EntitlementMediator::properties::adviceSequenceType";
			
			// Start of user code for adviceSequenceKey ElementEditor key
			public static String adviceSequenceKey = "esb::EntitlementMediator::properties::adviceSequenceKey";
			// End of user code
			
			
			public static String obligationsSequenceType = "esb::EntitlementMediator::properties::obligationsSequenceType";
			
			// Start of user code for obligationsSequenceKey ElementEditor key
			public static String obligationsSequenceKey = "esb::EntitlementMediator::properties::obligationsSequenceKey";
			// End of user code
			
			
			public static String description = "esb::EntitlementMediator::properties::description";
			
	
		}
	
	}

	/**
	 * EntitlementMediatorInputConnector view descriptor
	 * 
	 */
	public static class EntitlementMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::EntitlementMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * EntitlementMediatorOutputConnector view descriptor
	 * 
	 */
	public static class EntitlementMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EntitlementMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EntitlementMediatorOnRejectOutputConnector view descriptor
	 * 
	 */
	public static class EntitlementMediatorOnRejectOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EntitlementMediatorOnRejectOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EntitlementMediatorOnAcceptOutputConnector view descriptor
	 * 
	 */
	public static class EntitlementMediatorOnAcceptOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EntitlementMediatorOnAcceptOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EntitlementMediatorAdviceOutputConnector view descriptor
	 * 
	 */
	public static class EntitlementMediatorAdviceOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EntitlementMediatorAdviceOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EntitlementMediatorObligationsOutputConnector view descriptor
	 * 
	 */
	public static class EntitlementMediatorObligationsOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EntitlementMediatorObligationsOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EntitlementContainer view descriptor
	 * 
	 */
	public static class EntitlementContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * EntitlementOnRejectContainer view descriptor
	 * 
	 */
	public static class EntitlementOnRejectContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * EntitlementOnAcceptContainer view descriptor
	 * 
	 */
	public static class EntitlementOnAcceptContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * EntitlementAdviceContainer view descriptor
	 * 
	 */
	public static class EntitlementAdviceContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * EntitlementObligationsContainer view descriptor
	 * 
	 */
	public static class EntitlementObligationsContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * EnqueueMediator view descriptor
	 * 
	 */
	public static class EnqueueMediator {
		public static class Properties {
	
			
			public static String description = "esb::EnqueueMediator::properties::description";
			
			
			public static String commentsList = "esb::EnqueueMediator::properties::commentsList";
			
			
			public static String reverse = "esb::EnqueueMediator::properties::Reverse";
			
			
			public static String executor = "esb::EnqueueMediator::properties::executor";
			
			
			public static String priority = "esb::EnqueueMediator::properties::priority";
			
			// Start of user code for sequenceKey ElementEditor key
			public static String sequenceKey = "esb::CacheMediator::OnCacheHit::sequenceKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * EnqueueMediatorInputConnector view descriptor
	 * 
	 */
	public static class EnqueueMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::EnqueueMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * EnqueueMediatorOutputConnector view descriptor
	 * 
	 */
	public static class EnqueueMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::EnqueueMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ClassMediator view descriptor
	 * 
	 */
	public static class ClassMediator {
		public static class Properties {
	
			
			public static String description = "esb::ClassMediator::properties::description";
			
			
			public static String commentsList = "esb::ClassMediator::properties::commentsList";
			
			
			public static String reverse = "esb::ClassMediator::properties::Reverse";
			
			
			public static String className = "esb::ClassMediator::properties::className";
			
			
			public static String properties_ = "esb::ClassMediator::properties::properties_";
			
	
		}
	
	}

	/**
	 * ClassMediatorInputConnector view descriptor
	 * 
	 */
	public static class ClassMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ClassMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ClassMediatorOutputConnector view descriptor
	 * 
	 */
	public static class ClassMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ClassMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ClassProperty view descriptor
	 * 
	 */
	public static class ClassProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::ClassProperty::properties::propertyName";
			
			
			public static String propertyValueType = "esb::ClassProperty::properties::propertyValueType";
			
			
			public static String propertyValue = "esb::ClassProperty::properties::propertyValue";
			
			// Start of user code for propertyExpression ElementEditor key
			public static String propertyExpression = "esb::ClassProperty::properties::propertyExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * SpringMediator view descriptor
	 * 
	 */
	public static class SpringMediator {
		public static class Properties {
	
			
			public static String description = "esb::SpringMediator::properties::description";
			
			
			public static String commentsList = "esb::SpringMediator::properties::commentsList";
			
			
			public static String reverse = "esb::SpringMediator::properties::Reverse";
			
			
			public static String beanName = "esb::SpringMediator::properties::beanName";
			
			// Start of user code for configurationKey ElementEditor key
			public static String configurationKey = "esb::SmooksMediator::key::configurationKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * SpringMediatorInputConnector view descriptor
	 * 
	 */
	public static class SpringMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::SpringMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * SpringMediatorOutputConnector view descriptor
	 * 
	 */
	public static class SpringMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SpringMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ScriptMediator view descriptor
	 * 
	 */
	public static class ScriptMediator {
		public static class Properties {
	
			
			public static String description = "esb::ScriptMediator::properties::description";
			
			
			public static String commentsList = "esb::ScriptMediator::properties::commentsList";
			
			
			public static String reverse = "esb::ScriptMediator::properties::Reverse";
			
			
			public static String scriptType = "esb::ScriptMediator::properties::scriptType";
			
			
			public static String scriptLanguage = "esb::ScriptMediator::properties::scriptLanguage";
			
			
			public static String mediateFunction = "esb::ScriptMediator::properties::mediateFunction";
			
			
			public static String scriptBody = "esb::ScriptMediator::properties::scriptBody";
			
			
			public static String keyType = "esb::ScriptMediator::properties::keyType";
			
			
			public static String scriptKeys = "esb::ScriptMediator::properties::scriptKeys";
			
			// Start of user code for Script Static Key ElementEditor key
			public static String scriptStaticKey = "esb::ScriptMediator::properties::Script Static Key";
			// End of user code
			
			// Start of user code for Script Dynamic Key ElementEditor key
			public static String scriptDynamicKey = "esb::ScriptMediator::properties::Script Dynamic Key";
			// End of user code
			
	
		}
	
	}

	/**
	 * ScriptMediatorInputConnector view descriptor
	 * 
	 */
	public static class ScriptMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ScriptMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ScriptMediatorOutputConnector view descriptor
	 * 
	 */
	public static class ScriptMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ScriptMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * FaultMediator view descriptor
	 * 
	 */
	public static class FaultMediator {
		public static class Properties {
	
			
			public static String description = "esb::FaultMediator::properties::description";
			
			
			public static String commentsList = "esb::FaultMediator::properties::commentsList";
			
			
			public static String reverse = "esb::FaultMediator::properties::Reverse";
			
			
			public static String soapVersion = "esb::FaultMediator::properties::soapVersion";
			
			
			public static String serializeResponse = "esb::FaultMediator::properties::serializeResponse";
			
			
			public static String markAsResponse = "esb::FaultMediator::properties::markAsResponse";
			
			
			public static String faultCodeSoap11 = "esb::FaultMediator::properties::faultCodeSoap11";
			
			
			public static String faultCodeType = "esb::FaultMediator::properties::faultCodeType";
			
			
			public static String faultStringType = "esb::FaultMediator::properties::faultStringType";
			
			
			public static String faultStringValue = "esb::FaultMediator::properties::faultStringValue";
			
			
			public static String faultActor = "esb::FaultMediator::properties::faultActor";
			
			
			public static String faultCodeSoap12 = "esb::FaultMediator::properties::faultCodeSoap12";
			
			
			public static String faultReasonType = "esb::FaultMediator::properties::faultReasonType";
			
			
			public static String faultReasonValue = "esb::FaultMediator::properties::faultReasonValue";
			
			
			public static String roleName = "esb::FaultMediator::properties::roleName";
			
			
			public static String nodeName = "esb::FaultMediator::properties::nodeName";
			
			
			public static String faultDetailType = "esb::FaultMediator::properties::faultDetailType";
			
			
			public static String faultDetailValue = "esb::FaultMediator::properties::faultDetailValue";
			
			// Start of user code for faultStringExpression ElementEditor key
			public static String faultStringExpression = "esb::FaultMediator::properties::faultStringExpression";
			// End of user code
			
			// Start of user code for faultCodeExpression ElementEditor key
			public static String faultCodeExpression = "esb::FaultMediator::properties::faultCodeExpression";
			// End of user code
			
			// Start of user code for faultDetailExpression ElementEditor key
			public static String faultDetailExpression = "esb::FaultMediator::properties::faultDetailExpression";
			// End of user code
			
			// Start of user code for faultReasonExpression ElementEditor key
			public static String faultReasonExpression = "esb::FaultMediator::properties::faultReasonExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * FaultMediatorInputConnector view descriptor
	 * 
	 */
	public static class FaultMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::FaultMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * FaultMediatorOutputConnector view descriptor
	 * 
	 */
	public static class FaultMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::FaultMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * AggregateMediator view descriptor
	 * 
	 */
	public static class AggregateMediator {
		public static class Properties {
	
			
			public static String description = "esb::AggregateMediator::properties::description";
			
			
			public static String commentsList = "esb::AggregateMediator::properties::commentsList";
			
			
			public static String reverse = "esb::AggregateMediator::properties::Reverse";
			
			
			public static String aggregateID = "esb::AggregateMediator::properties::aggregateID";
			
			
			public static String completionTimeout = "esb::AggregateMediator::properties::completionTimeout";
			
			
			public static String completionMinMessagesType = "esb::AggregateMediator::properties::completionMinMessagesType";
			
			
			public static String completionMaxMessagesType = "esb::AggregateMediator::properties::completionMaxMessagesType";
			
			
			public static String completionMinMessagesValue = "esb::AggregateMediator::properties::completionMinMessagesValue";
			
			
			public static String completionMaxMessagesValue = "esb::AggregateMediator::properties::completionMaxMessagesValue";
			
			
			public static String enclosingElementProperty = "esb::AggregateMediator::properties::enclosingElementProperty";
			
			// Start of user code for correlationExpression ElementEditor key
			public static String correlationExpression = "esb::AggregateMediator::properties::correlationExpression";
			// End of user code
			
			// Start of user code for completionMinMessages ElementEditor key
			public static String completionMinMessages = "esb::AggregateMediator::properties::completionMinMessages";
			// End of user code
			
			// Start of user code for completionMaxMessages ElementEditor key
			public static String completionMaxMessages = "esb::AggregateMediator::properties::completionMaxMessages";
			// End of user code

			// Start of user code for completionMaxMessages ElementEditor key
			public static String aggregateElementType = "esb::AggregateMediator::properties::aggregateElementType";
			// End of user code
	
		}
	
		public static class OnComplete {
	
			// Start of user code for aggregationExpression ElementEditor key
			public static String aggregationExpression = "esb::AggregateMediator::properties::aggregationExpression";
			// End of user code
			
			
			public static String sequenceType = "esb::AggregateMediator::onComplete::sequenceType";
			
			// Start of user code for sequenceKey ElementEditor key
			public static String sequenceKey = "esb::AggregateMediator::onComplete::sequenceKey";
			// End of user code
	
		}
	
	}

	/**
	 * AggregateMediatorInputConnector view descriptor
	 * 
	 */
	public static class AggregateMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::AggregateMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * AggregateMediatorOutputConnector view descriptor
	 * 
	 */
	public static class AggregateMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::AggregateMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * AggregateMediatorOnCompleteOutputConnector view descriptor
	 * 
	 */
	public static class AggregateMediatorOnCompleteOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::AggregateMediatorOnCompleteOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RouterMediator view descriptor
	 * 
	 */
	public static class RouterMediator {
		public static class Properties {
	
			
			public static String description = "esb::RouterMediator::properties::description";
			
			
			public static String commentsList = "esb::RouterMediator::properties::commentsList";
			
			
			public static String reverse = "esb::RouterMediator::properties::Reverse";
			
			
			public static String continueAfterRouting = "esb::RouterMediator::properties::continueAfterRouting";
			
			
			public static String targetOutputConnector = "esb::RouterMediator::properties::targetOutputConnector";
			
	
		}
	
	}

	/**
	 * RouterRoute view descriptor
	 * 
	 */
	public static class RouterRoute {
		public static class Properties {
	
			
			public static String breakAfterRoute = "esb::RouterRoute::properties::breakAfterRoute";
			
			
			public static String routeExpression = "esb::RouterRoute::properties::routeExpression";
			
			
			public static String routePattern = "esb::RouterRoute::properties::routePattern";
			
	
		}
	
	}

	/**
	 * RouterTarget view descriptor
	 * 
	 */
	public static class RouterTarget {
		public static class Properties {
	
			
			public static String sequenceType = "esb::RouterTarget::properties::sequenceType";
			
			
			public static String sequence = "esb::RouterTarget::properties::sequence";
			
			
			public static String endpointType = "esb::RouterTarget::properties::endpointType";
			
	
		}
	
	}

	/**
	 * RouterMediatorInputConnector view descriptor
	 * 
	 */
	public static class RouterMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::RouterMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * RouterMediatorOutputConnector view descriptor
	 * 
	 */
	public static class RouterMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::RouterMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RouterMediatorTargetOutputConnector view descriptor
	 * 
	 */
	public static class RouterMediatorTargetOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::RouterMediatorTargetOutputConnector::properties::commentMediators";
			
			
			public static String soapAction = "esb::RouterMediatorTargetOutputConnector::properties::soapAction";
			
			
			public static String toAddress = "esb::RouterMediatorTargetOutputConnector::properties::toAddress";
			
	
		}
	
	}

	/**
	 * RouterMediatorContainer view descriptor
	 * 
	 */
	public static class RouterMediatorContainer {
		public static class Properties {
	
			
			public static String routerTargetContainer = "esb::RouterMediatorContainer::properties::routerTargetContainer";
			
	
		}
	
	}

	/**
	 * RouterTargetContainer view descriptor
	 * 
	 */
	public static class RouterTargetContainer {
		public static class Properties {
	
			
			public static String breakAfterRoute = "esb::RouterTargetContainer::properties::breakAfterRoute";
			
			
			public static String routePattern = "esb::RouterTargetContainer::properties::routePattern";
			
	
		}
	
	}

	/**
	 * CloneMediator view descriptor
	 * 
	 */
	public static class CloneMediator {
		public static class Properties {
	
			
			public static String description = "esb::CloneMediator::properties::description";
			
			
			public static String commentsList = "esb::CloneMediator::properties::commentsList";
			
			
			public static String reverse = "esb::CloneMediator::properties::Reverse";
			
			
			public static String cloneID = "esb::CloneMediator::properties::cloneID";
			
			
			public static String sequentialMediation = "esb::CloneMediator::properties::sequentialMediation";
			
			
			public static String continueParent = "esb::CloneMediator::properties::continueParent";
			
			
			public static String targets = "esb::CloneMediator::properties::targets";
			
			
			public static String targetsOutputConnector = "esb::CloneMediator::properties::targetsOutputConnector";
			
	
		}
	
	}

	/**
	 * CloneTarget view descriptor
	 * 
	 */
	public static class CloneTarget {
		public static class Properties {
	
			
			public static String sequenceType = "esb::CloneTarget::properties::sequenceType";
			
			
			public static String sequence = "esb::CloneTarget::properties::sequence";
			
			
			public static String endpointType = "esb::CloneTarget::properties::endpointType";
			
			
			public static String soapAction = "esb::CloneTarget::properties::soapAction";
			
			
			public static String toAddress = "esb::CloneTarget::properties::toAddress";
			
			// Start of user code for endpointRegistryKey ElementEditor key
			public static String endpointRegistryKey = "esb::CloneTarget::properties::endpointRegistryKey";
			// End of user code
			
			// Start of user code for sequenceRegistryKey ElementEditor key
			public static String sequenceRegistryKey = "esb::CloneTarget::properties::sequenceRegistryKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * CloneMediatorInputConnector view descriptor
	 * 
	 */
	public static class CloneMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::CloneMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CloneMediatorOutputConnector view descriptor
	 * 
	 */
	public static class CloneMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CloneMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * CloneMediatorTargetOutputConnector view descriptor
	 * 
	 */
	public static class CloneMediatorTargetOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CloneMediatorTargetOutputConnector::properties::commentMediators";
			
			
			public static String soapAction = "esb::CloneMediatorTargetOutputConnector::properties::soapAction";
			
			
			public static String toAddress = "esb::CloneMediatorTargetOutputConnector::properties::toAddress";
			
	
		}
	
	}

	/**
	 * CloneMediatorContainer view descriptor
	 * 
	 */
	public static class CloneMediatorContainer {
		public static class Properties {
	
			
			public static String cloneTargetContainer = "esb::CloneMediatorContainer::properties::cloneTargetContainer";
			
	
		}
	
	}

	/**
	 * CloneTargetContainer view descriptor
	 * 
	 */
	public static class CloneTargetContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * ForEachMediator view descriptor
	 * 
	 */
	public static class ForEachMediator {
		public static class Properties {
	
			
			public static String description = "esb::ForEachMediator::properties::description";
			
			
			public static String commentsList = "esb::ForEachMediator::properties::commentsList";
			
			
			public static String reverse = "esb::ForEachMediator::properties::Reverse";
			
			
			public static String forEachID = "esb::ForEachMediator::properties::forEachID";
			
			// Start of user code for forEachExpression ElementEditor key
			public static String forEachExpression = "esb::ForEachMediator::properties::forEachExpression";
			// End of user code
			
	
		}
	
		public static class Sequence {
	
			
			public static String sequenceType = "esb::ForEachMediator::Sequence::sequenceType";
			
			
			public static String sequenceName = "esb::ForEachMediator::Sequence::sequenceName";
			
			// Start of user code for sequenceKey ElementEditor key
			public static String sequenceKey = "esb::ForEachMediator::Sequence::sequenceKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * ForEachMediatorInputConnector view descriptor
	 * 
	 */
	public static class ForEachMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ForEachMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ForEachMediatorOutputConnector view descriptor
	 * 
	 */
	public static class ForEachMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ForEachMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ForEachMediatorTargetOutputConnector view descriptor
	 * 
	 */
	public static class ForEachMediatorTargetOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ForEachMediatorTargetOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ForEachTarget view descriptor
	 * 
	 */
	public static class ForEachTarget {
		public static class Properties {
	
			
			public static String sequenceType = "esb::ForEachTarget::properties::sequenceType";
			
			
			public static String sequence = "esb::ForEachTarget::properties::sequence";
			
			
			public static String endpointType = "esb::ForEachTarget::properties::endpointType";
			
			
			public static String soapAction = "esb::ForEachTarget::properties::soapAction";
			
			
			public static String toAddress = "esb::ForEachTarget::properties::toAddress";
			
	
		}
	
	}

	/**
	 * IterateMediator view descriptor
	 * 
	 */
	public static class IterateMediator {
		public static class Properties {
	
			
			public static String description = "esb::IterateMediator::properties::description";
			
			
			public static String commentsList = "esb::IterateMediator::properties::commentsList";
			
			
			public static String reverse = "esb::IterateMediator::properties::Reverse";
			
			
			public static String iterateID = "esb::IterateMediator::properties::iterateID";
			
			
			public static String sequentialMediation = "esb::IterateMediator::properties::sequentialMediation";
			
			
			public static String continueParent = "esb::IterateMediator::properties::continueParent";
			
			
			public static String preservePayload = "esb::IterateMediator::properties::preservePayload";
			
			
			public static String sequenceType = "esb::IterateMediator::properties::sequenceType";
			
			
			public static String sequenceName = "esb::IterateMediator::properties::sequenceName";
			
			// Start of user code for iterateExpression ElementEditor key
			public static String iterateExpression = "esb::IterateMediator::properties::iterateExpression";
			// End of user code
			
			// Start of user code for sequenceKey ElementEditor key
			public static String sequenceKey = "esb::IterateMediator::properties::sequenceKey";
			// End of user code
			
			// Start of user code for attachPath ElementEditor key
			public static String attachPath = "esb::IterateMediator::properties::attachPath";
			// End of user code
			
	
		}
	
	}

	/**
	 * IterateMediatorInputConnector view descriptor
	 * 
	 */
	public static class IterateMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::IterateMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * IterateMediatorOutputConnector view descriptor
	 * 
	 */
	public static class IterateMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::IterateMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * IterateMediatorTargetOutputConnector view descriptor
	 * 
	 */
	public static class IterateMediatorTargetOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::IterateMediatorTargetOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * IterateTarget view descriptor
	 * 
	 */
	public static class IterateTarget {
		public static class Properties {
	
			
			public static String sequenceType = "esb::IterateTarget::properties::sequenceType";
			
			
			public static String sequence = "esb::IterateTarget::properties::sequence";
			
			
			public static String endpointType = "esb::IterateTarget::properties::endpointType";
			
			
			public static String soapAction = "esb::IterateTarget::properties::soapAction";
			
			
			public static String toAddress = "esb::IterateTarget::properties::toAddress";
			
	
		}
	
	}

	/**
	 * AbstractCommonTarget view descriptor
	 * 
	 */
	public static class AbstractCommonTarget {
		public static class Properties {
	
			
			public static String sequenceType = "esb::AbstractCommonTarget::properties::sequenceType";
			
			
			public static String sequence = "esb::AbstractCommonTarget::properties::sequence";
			
			
			public static String endpointType = "esb::AbstractCommonTarget::properties::endpointType";
			
	
		}
	
	}

	/**
	 * MediatorSequence view descriptor
	 * 
	 */
	public static class MediatorSequence {
		public static class Properties {
	
			
			public static String anonymous = "esb::MediatorSequence::properties::anonymous";
			
			
			public static String sequenceName = "esb::MediatorSequence::properties::sequenceName";
			
			
			public static String mediators = "esb::MediatorSequence::properties::mediators";
			
			
			public static String onError = "esb::MediatorSequence::properties::onError";
			
			
			public static String description = "esb::MediatorSequence::properties::description";
			
	
		}
	
	}

	/**
	 * CacheMediator view descriptor
	 * 
	 */
	public static class CacheMediator {
		public static class Type {
	
			
			public static String cacheMediatorImplementation = "esb::CacheMediator::Type::cacheMediatorImplementation";
			
	
		}
	
		public static class Properties {
	
			
			public static String id = "esb::CacheMediator::properties::id";
			
			
			public static String cacheType = "esb::CacheMediator::properties::cacheType";
			
			
			public static String scope = "esb::CacheMediator::properties::scope";
			
			
			public static String hashGeneratorAttribute = "esb::CacheMediator::properties::hashGeneratorAttribute";
			
			
			public static String cacheTimeout = "esb::CacheMediator::properties::cacheTimeout";
			
			
			public static String maxMessageSize = "esb::CacheMediator::properties::maxMessageSize";
			
			
			public static String commentsList = "esb::CacheMediator::properties::commentsList";
			
			
			public static String reverse = "esb::CacheMediator::properties::Reverse";
			
	
		}
	
		public static class Implementation {
	
			
			public static String maxEntryCount = "esb::CacheMediator::Implementation::maxEntryCount";
			
			
			public static String implementationType = "esb::CacheMediator::Implementation::implementationType";
			
	
		}
	
		public static class OnCacheHit {
	
			
			public static String sequenceType = "esb::CacheMediator::OnCacheHit::sequenceType";
			
			// Start of user code for sequenceKey ElementEditor key
			public static String sequenceKey = "esb::CacheMediator::OnCacheHit::sequenceKey";
			// End of user code
			
	
		}
	
		public static class Protocol {
	
			
			public static String cacheProtocolType = "esb::CacheMediator::Protocol::cacheProtocolType";
			
			
			public static String cacheProtocolMethods = "esb::CacheMediator::Protocol::cacheProtocolMethods";
			
			
			public static String headersToExcludeInHash = "esb::CacheMediator::Protocol::headersToExcludeInHash";
			
			
			public static String responseCodes = "esb::CacheMediator::Protocol::responseCodes";
			
			
			public static String enableCacheControl = "esb::CacheMediator::Protocol::enableCacheControl";
			
			
			public static String includeAgeHeader = "esb::CacheMediator::Protocol::includeAgeHeader";
			
			
			public static String hashGenerator = "esb::CacheMediator::Protocol::hashGenerator";
			
	
		}
	
		public static class Misc {
	
			
			public static String description = "esb::CacheMediator::Misc::description";
			
	
		}
	
	}

	/**
	 * CacheMediatorInputConnector view descriptor
	 * 
	 */
	public static class CacheMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::CacheMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CacheMediatorOutputConnector view descriptor
	 * 
	 */
	public static class CacheMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CacheMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * CacheMediatorOnHitOutputConnector view descriptor
	 * 
	 */
	public static class CacheMediatorOnHitOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CacheMediatorOnHitOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * CacheOnHitBranch view descriptor
	 * 
	 */
	public static class CacheOnHitBranch {
	}

	/**
	 * XQueryMediator view descriptor
	 * 
	 */
	public static class XQueryMediator {
		public static class Properties {
	
			
			public static String commentsList = "esb::XQueryMediator::properties::commentsList";
			
			
			public static String reverse = "esb::XQueryMediator::properties::Reverse";
			
			
			public static String variables = "esb::XQueryMediator::properties::variables";
			
			
			public static String scriptKeyType = "esb::XQueryMediator::properties::scriptKeyType";
			
			// Start of user code for staticScriptKey ElementEditor key
			public static String staticScriptKey = "esb::XQueryMediator::properties::staticScriptKey";
			// End of user code
			
			// Start of user code for targetXPath ElementEditor key
			public static String targetXPath = "esb::XQueryMediator::properties::targetXPath";
			// End of user code
			
			// Start of user code for dynamicScriptKey ElementEditor key
			public static String dynamicScriptKey = "esb::XQueryMediator::properties::dynamicScriptKey";
			// End of user code
			
			
			public static String description = "esb::XQueryMediator::properties::description";
			
	
		}
	
	}

	/**
	 * XQueryMediatorInputConnector view descriptor
	 * 
	 */
	public static class XQueryMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::XQueryMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * XQueryMediatorOutputConnector view descriptor
	 * 
	 */
	public static class XQueryMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::XQueryMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * XQueryVariable view descriptor
	 * 
	 */
	public static class XQueryVariable {
		public static class Properties {
	
			
			public static String variableName = "esb::XQueryVariable::properties::variableName";
			
			
			public static String variableType = "esb::XQueryVariable::properties::variableType";
			
			
			public static String valueType = "esb::XQueryVariable::properties::valueType";
			
			
			public static String valueLiteral = "esb::XQueryVariable::properties::valueLiteral";
			
			// Start of user code for valueExpression ElementEditor key
			public static String valueExpression = "esb::XQueryVariable::properties::valueExpression";
			// End of user code
			
			// Start of user code for valueKey ElementEditor key
			public static String valueKey = "esb::XQueryVariable::properties::valueKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * CalloutMediator view descriptor
	 * 
	 */
	public static class CalloutMediator {
		public static class Misc {
	
			
			public static String description = "esb::CalloutMediator::Misc::description";
			
			
			public static String commentsList = "esb::CalloutMediator::Misc::commentsList";
			
			
			public static String reverse = "esb::CalloutMediator::Misc::Reverse";
			
			
			public static String passHeaders = "esb::CalloutMediator::Misc::passHeaders";
			
	
		}
	
		public static class Service {
	
			
			public static String endpointType = "esb::CalloutMediator::Service::EndpointType";
			
			
			public static String soapAction = "esb::CalloutMediator::Service::soapAction";
			
			
			public static String pathToAxis2Repository = "esb::CalloutMediator::Service::pathToAxis2Repository";
			
			
			public static String pathToAxis2xml = "esb::CalloutMediator::Service::pathToAxis2xml";
			
			
			public static String initAxis2ClientOptions = "esb::CalloutMediator::Service::initAxis2ClientOptions";
			
			
			public static String serviceURL = "esb::CalloutMediator::Service::serviceURL";
			
			// Start of user code for Address Endpoint ElementEditor key
			public static String addressEndpoint = "esb::CalloutMediator::Service::AddressEndpoint";
			// End of user code
			
	
		}
	
		public static class Source {
	
			
			public static String payloadType = "esb::CalloutMediator::Source::payloadType";
			
			
			public static String payloadProperty = "esb::CalloutMediator::Source::payloadProperty";
			
			// Start of user code for Payload Message Xpath ElementEditor key
			public static String payloadMessageXpath = "esb::CalloutMediator::Source::PayloadMessageXpath";
			// End of user code
			
	
		}
	
		public static class Target {
	
			
			public static String resultType = "esb::CalloutMediator::Target::resultType";
			
			
			public static String resultContextProperty = "esb::CalloutMediator::Target::resultContextProperty";
			
			// Start of user code for Result Message Xpath ElementEditor key
			public static String resultMessageXpath = "esb::CalloutMediator::Target::ResultMessageXpath";
			// End of user code
			
	
		}
	
		public static class WS {
	
			
			public static String policies = "esb::CalloutMediator::WS::policies";
			
			
			public static String securityType = "esb::CalloutMediator::WS::securityType";
			
			// Start of user code for Policy Key ElementEditor key
			public static String policyKey = "esb::CalloutMediator::WS::PolicyKey";
			// End of user code
			
			// Start of user code for Outbound Policy Key ElementEditor key
			public static String outboundPolicyKey = "esb::CalloutMediator::WS::OutboundPolicyKey";
			// End of user code
			
			// Start of user code for Inbound Policy Key ElementEditor key
			public static String inboundPolicyKey = "esb::CalloutMediator::WS::InboundPolicyKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * CalloutMediatorInputConnector view descriptor
	 * 
	 */
	public static class CalloutMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::CalloutMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CalloutMediatorOutputConnector view descriptor
	 * 
	 */
	public static class CalloutMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CalloutMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RMSequenceMediator view descriptor
	 * 
	 */
	public static class RMSequenceMediator {
		public static class Properties {
	
			
			public static String description = "esb::RMSequenceMediator::properties::description";
			
			
			public static String commentsList = "esb::RMSequenceMediator::properties::commentsList";
			
			
			public static String reverse = "esb::RMSequenceMediator::properties::Reverse";
			
			
			public static String rmSpecVersion = "esb::RMSequenceMediator::properties::rmSpecVersion";
			
			
			public static String sequenceType = "esb::RMSequenceMediator::properties::sequenceType";
			
	
		}
	
	}

	/**
	 * RMSequenceMediatorInputConnector view descriptor
	 * 
	 */
	public static class RMSequenceMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::RMSequenceMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * RMSequenceMediatorOutputConnector view descriptor
	 * 
	 */
	public static class RMSequenceMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::RMSequenceMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * TransactionMediator view descriptor
	 * 
	 */
	public static class TransactionMediator {
		public static class Properties {
	
			
			public static String description = "esb::TransactionMediator::properties::description";
			
			
			public static String commentsList = "esb::TransactionMediator::properties::commentsList";
			
			
			public static String reverse = "esb::TransactionMediator::properties::Reverse";
			
			
			public static String action = "esb::TransactionMediator::properties::action";
			
	
		}
	
	}

	/**
	 * TransactionMediatorInputConnector view descriptor
	 * 
	 */
	public static class TransactionMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::TransactionMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * TransactionMediatorOutputConnector view descriptor
	 * 
	 */
	public static class TransactionMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::TransactionMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * OAuthMediator view descriptor
	 * 
	 */
	public static class OAuthMediator {
		public static class Properties {
	
			
			public static String description = "esb::OAuthMediator::properties::description";
			
			
			public static String commentsList = "esb::OAuthMediator::properties::commentsList";
			
			
			public static String reverse = "esb::OAuthMediator::properties::Reverse";
			
			
			public static String remoteServiceUrl = "esb::OAuthMediator::properties::remoteServiceUrl";
			
			
			public static String username = "esb::OAuthMediator::properties::username";
			
			
			public static String password = "esb::OAuthMediator::properties::password";
			
	
		}
	
	}

	/**
	 * OAuthMediatorInputConnector view descriptor
	 * 
	 */
	public static class OAuthMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::OAuthMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * OAuthMediatorOutputConnector view descriptor
	 * 
	 */
	public static class OAuthMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::OAuthMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * AutoscaleInMediator view descriptor
	 * 
	 */
	public static class AutoscaleInMediator {
		public static class Properties {
	
			
			public static String description = "esb::AutoscaleInMediator::properties::description";
			
			
			public static String commentsList = "esb::AutoscaleInMediator::properties::commentsList";
			
			
			public static String reverse = "esb::AutoscaleInMediator::properties::Reverse";
			
	
		}
	
	}

	/**
	 * AutoscaleOutMediator view descriptor
	 * 
	 */
	public static class AutoscaleOutMediator {
		public static class Properties {
	
			
			public static String description = "esb::AutoscaleOutMediator::properties::description";
			
			
			public static String commentsList = "esb::AutoscaleOutMediator::properties::commentsList";
			
			
			public static String reverse = "esb::AutoscaleOutMediator::properties::Reverse";
			
	
		}
	
	}

	/**
	 * HeaderMediator view descriptor
	 * 
	 */
	public static class HeaderMediator {
		public static class Properties {
	
			
			public static String headerAction = "esb::HeaderMediator::properties::headerAction";
			
			
			public static String valueType = "esb::HeaderMediator::properties::valueType";
			
			
			public static String scope = "esb::HeaderMediator::properties::scope";
			
			
			public static String valueLiteral = "esb::HeaderMediator::properties::valueLiteral";
			
			
			public static String valueInline = "esb::HeaderMediator::properties::value Inline";
			
			// Start of user code for header Name ElementEditor key
			public static String headerName = "esb::HeaderMediator::properties::headerName";
			// End of user code
			
			// Start of user code for value Expression ElementEditor key
			public static String valueExpression = "esb::HeaderMediator::properties::valueExpression";
			// End of user code
			
			
			public static String description = "esb::HeaderMediator::properties::description";
			
			
			public static String commentsList = "esb::HeaderMediator::properties::commentsList";
			
			
			public static String reverse = "esb::HeaderMediator::properties::Reverse";
			
	
		}
	
	}

	/**
	 * HeaderMediatorInputConnector view descriptor
	 * 
	 */
	public static class HeaderMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::HeaderMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * HeaderMediatorOutputConnector view descriptor
	 * 
	 */
	public static class HeaderMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::HeaderMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ThrottleMediator view descriptor
	 * 
	 */
	public static class ThrottleMediator {
		public static class General {
	
			
			public static String commentsList = "esb::ThrottleMediator::general::commentsList";
			
			
			public static String reverse = "esb::ThrottleMediator::general::Reverse";
			
			
			public static String groupId = "esb::ThrottleMediator::general::groupId";
			
	
		}
	
		public static class Misc {
	
			
			public static String description = "esb::ThrottleMediator::misc::description";
			
	
		}
	
		public static class OnAccept {
	
			
			public static String onAcceptBranchsequenceType = "esb::ThrottleMediator::onAccept::OnAcceptBranchsequenceType";
			
			// Start of user code for OnAcceptBranchSequenceKey ElementEditor key
			public static String onAcceptBranchSequenceKey = "esb::ThrottleMediator::onAccept::OnAcceptBranchSequenceKey";
			// End of user code
			
	
		}
	
		public static class OnReject {
	
			
			public static String onRejectBranchsequenceType = "esb::ThrottleMediator::onReject::OnRejectBranchsequenceType";
			
			// Start of user code for OnRejectBranchSequenceKey ElementEditor key
			public static String onRejectBranchSequenceKey = "esb::ThrottleMediator::onReject::OnRejectBranchSequenceKey";
			// End of user code
			
	
		}
	
		public static class ThrottlePolicy {
	
			
			public static String policyType = "esb::ThrottleMediator::throttlePolicy::policyType";
			
			
			public static String maxConcurrentAccessCount = "esb::ThrottleMediator::throttlePolicy::maxConcurrentAccessCount";
			
			
			public static String policyEntries = "esb::ThrottleMediator::throttlePolicy::policyEntries";
			
			// Start of user code for policyKey ElementEditor key
			public static String policyKey = "esb::ThrottleMediator::throttlePolicy::policyKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * ThrottleMediatorInputConnector view descriptor
	 * 
	 */
	public static class ThrottleMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ThrottleMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ThrottleMediatorOutputConnector view descriptor
	 * 
	 */
	public static class ThrottleMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ThrottleMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ThrottleMediatorOnAcceptOutputConnector view descriptor
	 * 
	 */
	public static class ThrottleMediatorOnAcceptOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ThrottleMediatorOnAcceptOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ThrottleMediatorOnRejectOutputConnector view descriptor
	 * 
	 */
	public static class ThrottleMediatorOnRejectOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ThrottleMediatorOnRejectOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ThrottlePolicyConfiguration view descriptor
	 * 
	 */
	public static class ThrottlePolicyConfiguration {
		public static class Properties {
	
			
			public static String policyType = "esb::ThrottlePolicyConfiguration::properties::policyType";
			
			
			public static String maxConcurrentAccessCount = "esb::ThrottlePolicyConfiguration::properties::maxConcurrentAccessCount";
			
			
			public static String policyEntries = "esb::ThrottlePolicyConfiguration::properties::policyEntries";
			
	
		}
	
	}

	/**
	 * ThrottlePolicyEntry view descriptor
	 * 
	 */
	public static class ThrottlePolicyEntry {
		public static class Properties {
	
			
			public static String throttleType = "esb::ThrottlePolicyEntry::properties::throttleType";
			
			
			public static String throttleRange = "esb::ThrottlePolicyEntry::properties::throttleRange";
			
			
			public static String accessType = "esb::ThrottlePolicyEntry::properties::accessType";
			
			
			public static String maxRequestCount = "esb::ThrottlePolicyEntry::properties::maxRequestCount";
			
			
			public static String unitTime = "esb::ThrottlePolicyEntry::properties::unitTime";
			
			
			public static String prohibitPeriod = "esb::ThrottlePolicyEntry::properties::prohibitPeriod";
			
	
		}
	
	}

	/**
	 * ThrottleOnAcceptBranch view descriptor
	 * 
	 */
	public static class ThrottleOnAcceptBranch {
		public static class Properties {
	
			
			public static String sequenceType = "esb::ThrottleOnAcceptBranch::properties::sequenceType";
			
	
		}
	
	}

	/**
	 * ThrottleOnRejectBranch view descriptor
	 * 
	 */
	public static class ThrottleOnRejectBranch {
		public static class Properties {
	
			
			public static String sequenceType = "esb::ThrottleOnRejectBranch::properties::sequenceType";
			
	
		}
	
	}

	/**
	 * ThrottleContainer view descriptor
	 * 
	 */
	public static class ThrottleContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * ThrottleOnAcceptContainer view descriptor
	 * 
	 */
	public static class ThrottleOnAcceptContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * ThrottleOnRejectContainer view descriptor
	 * 
	 */
	public static class ThrottleOnRejectContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * CommandMediator view descriptor
	 * 
	 */
	public static class CommandMediator {
		public static class Properties {
	
			
			public static String description = "esb::CommandMediator::properties::description";
			
			
			public static String commentsList = "esb::CommandMediator::properties::commentsList";
			
			
			public static String reverse = "esb::CommandMediator::properties::Reverse";
			
			
			public static String className = "esb::CommandMediator::properties::className";
			
			
			public static String properties_ = "esb::CommandMediator::properties::properties_";
			
	
		}
	
	}

	/**
	 * CommandMediatorInputConnector view descriptor
	 * 
	 */
	public static class CommandMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::CommandMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CommandMediatorOutputConnector view descriptor
	 * 
	 */
	public static class CommandMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CommandMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * CommandProperty view descriptor
	 * 
	 */
	public static class CommandProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::CommandProperty::properties::propertyName";
			
			
			public static String valueType = "esb::CommandProperty::properties::valueType";
			
			
			public static String valueLiteral = "esb::CommandProperty::properties::valueLiteral";
			
			
			public static String valueContextPropertyName = "esb::CommandProperty::properties::valueContextPropertyName";
			
			
			public static String contextAction = "esb::CommandProperty::properties::contextAction";
			
			
			public static String messageAction = "esb::CommandProperty::properties::messageAction";
			
			// Start of user code for valueMessageElementXpath ElementEditor key
			public static String valueMessageElementXpath = "esb::CommandProperty::properties::valueMessageElementXpath";
			// End of user code
	
		}
	
	}

	/**
	 * SqlStatement view descriptor
	 * 
	 */
	public static class SqlStatement {
		public static class Properties {
			
			public static String queryString = "esb::SqlStatement::properties::queryString";
			
			public static String parameters = "esb::SqlStatement::properties::parameters";
			
			public static String resultsEnabled = "esb::SqlStatement::properties::resultsEnabled";
			
			public static String results = "esb::SqlStatement::properties::results";
	
		}
	
	}

	/**
	 * SqlParameterDefinition view descriptor
	 * 
	 */
	public static class SqlParameterDefinition {
		public static class Properties {
	
			
			public static String dataType = "esb::SqlParameterDefinition::properties::dataType";
			
			
			public static String valueType = "esb::SqlParameterDefinition::properties::valueType";
			
			
			public static String valueLiteral = "esb::SqlParameterDefinition::properties::valueLiteral";
			
			// Start of user code for valueExpression ElementEditor key
			public static String valueExpression = "esb::SqlParameterDefinition::properties::valueExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * SqlResultMapping view descriptor
	 * 
	 */
	public static class SqlResultMapping {
		public static class Properties {
	
			
			public static String propertyName = "esb::SqlResultMapping::properties::propertyName";
			
			
			public static String columnId = "esb::SqlResultMapping::properties::columnId";
			
	
		}
	
	}

	/**
	 * DBLookupMediator view descriptor
	 * 
	 */
	public static class DBLookupMediator {
		public static class Properties {
	
			
			public static String commentsList = "esb::DBLookupMediator::properties::commentsList";
			
			
			public static String reverse = "esb::DBLookupMediator::properties::Reverse";
			
			
			public static String propertyAutocommit = "esb::DBLookupMediator::properties::propertyAutocommit";
			
			
			public static String propertyIsolation = "esb::DBLookupMediator::properties::propertyIsolation";
			
			
			public static String propertyMaxactive = "esb::DBLookupMediator::properties::propertyMaxactive";
			
			
			public static String propertyMaxidle = "esb::DBLookupMediator::properties::propertyMaxidle";
			
			
			public static String propertyMaxopenstatements = "esb::DBLookupMediator::properties::propertyMaxopenstatements";
			
			
			public static String propertyMaxwait = "esb::DBLookupMediator::properties::propertyMaxwait";
			
			
			public static String propertyMinidle = "esb::DBLookupMediator::properties::propertyMinidle";
			
			
			public static String propertyPoolstatements = "esb::DBLookupMediator::properties::propertyPoolstatements";
			
			
			public static String propertyTestonborrow = "esb::DBLookupMediator::properties::propertyTestonborrow";
			
			
			public static String propertyTestwhileidle = "esb::DBLookupMediator::properties::propertyTestwhileidle";
			
			
			public static String propertyValidationquery = "esb::DBLookupMediator::properties::propertyValidationquery";
			
			
			public static String propertyInitialsize = "esb::DBLookupMediator::properties::propertyInitialsize";
			
	
		}
	
		public static class Misc {
	
			
			public static String description = "esb::DBLookupMediator::misc::description";
			
	
		}
	
		public static class Connection {
	
			
			public static String connectionType = "esb::DBLookupMediator::connection::connectionType";
			
			
			public static String connectionDsType = "esb::DBLookupMediator::connection::connectionDsType";
			
			
			public static String connectionDsInitialContext = "esb::DBLookupMediator::connection::connectionDsInitialContext";
			
			
			public static String connectionDbType = "esb::DBLookupMediator::connection::connectionDbType";
			
			
			public static String connectionDbDriver = "esb::DBLookupMediator::connection::connectionDbDriver";
			
			
			public static String connectionDsName = "esb::DBLookupMediator::connection::connectionDsName";
			
			
			public static String connectionURL = "esb::DBLookupMediator::connection::connectionURL";
			
			
			public static String connectionUsername = "esb::DBLookupMediator::connection::connectionUsername";
			
			
			public static String connectionPassword = "esb::DBLookupMediator::connection::connectionPassword";
			
			// Start of user code for Database Configuration ElementEditor key
			public static String databaseConfiguration = "esb::DBLookupMediator::connection::Database Configuration";
			// End of user code
			
			
			public static String isRegistryBasedDriverConfig = "esb::DBLookupMediator::connection::isRegistryBasedDriverConfig";
			
			
			public static String isRegistryBasedUrlConfig = "esb::DBLookupMediator::connection::isRegistryBasedUrlConfig";
			
			
			public static String isRegistryBasedUserConfig = "esb::DBLookupMediator::connection::isRegistryBasedUserConfig";
			
			
			public static String isRegistryBasedPassConfig = "esb::DBLookupMediator::connection::isRegistryBasedPassConfig";
			
			// Start of user code for registryBasedDriverConfigKey ElementEditor key
			public static String registryBasedDriverConfigKey = "esb::DBLookupMediator::connection::registryBasedDriverConfigKey";
			// End of user code
			
			// Start of user code for registryBasedUrlConfigKey ElementEditor key
			public static String registryBasedUrlConfigKey = "esb::DBLookupMediator::connection::registryBasedUrlConfigKey";
			// End of user code
			
			// Start of user code for registryBasedUserConfigKey ElementEditor key
			public static String registryBasedUserConfigKey = "esb::DBLookupMediator::connection::registryBasedUserConfigKey";
			// End of user code
			
			// Start of user code for registryBasedPassConfigKey ElementEditor key
			public static String registryBasedPassConfigKey = "esb::DBLookupMediator::connection::registryBasedPassConfigKey";
			// End of user code
			
	
		}
	
		public static class Statements {
	
			
			public static String sqlStatements = "esb::DBLookupMediator::statements::sqlStatements";
			
	
		}
	
	}

	/**
	 * DBLookupMediatorInputConnector view descriptor
	 * 
	 */
	public static class DBLookupMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::DBLookupMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * DBLookupMediatorOutputConnector view descriptor
	 * 
	 */
	public static class DBLookupMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::DBLookupMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * DBReportMediator view descriptor
	 * 
	 */
	public static class DBReportMediator {
		public static class Connection {
	
			
			public static String connectionType = "esb::DBReportMediator::connection::connectionType";
			
			
			public static String connectionDsType = "esb::DBReportMediator::connection::connectionDsType";
			
			
			public static String connectionDbType = "esb::DBReportMediator::connection::connectionDbType";
			
			
			public static String connectionDbDriver = "esb::DBReportMediator::connection::connectionDbDriver";
			
			
			public static String connectionDsInitialContext = "esb::DBReportMediator::connection::connectionDsInitialContext";
			
			
			public static String connectionDsName = "esb::DBReportMediator::connection::connectionDsName";
			
			
			public static String connectionURL = "esb::DBReportMediator::connection::connectionURL";
			
			
			public static String connectionUsername = "esb::DBReportMediator::connection::connectionUsername";
			
			
			public static String connectionPassword = "esb::DBReportMediator::connection::connectionPassword";
			
			
			public static String connectionUseTransaction = "esb::DBReportMediator::connection::connectionUseTransaction";
			
			// Start of user code for Database Configuration ElementEditor key
			public static String databaseConfiguration = "esb::DBReportMediator::connection::Database Configuration";
			// End of user code
			
			
			public static String isRegistryBasedDriverConfig = "esb::DBReportMediator::connection::isRegistryBasedDriverConfig";
			
			
			public static String isRegistryBasedUrlConfig = "esb::DBReportMediator::connection::isRegistryBasedUrlConfig";
			
			
			public static String isRegistryBasedUserConfig = "esb::DBReportMediator::connection::isRegistryBasedUserConfig";
			
			
			public static String isRegistryBasedPassConfig = "esb::DBReportMediator::connection::isRegistryBasedPassConfig";
			
			// Start of user code for registryBasedDriverConfigKey ElementEditor key
			public static String registryBasedDriverConfigKey = "esb::DBReportMediator::connection::registryBasedDriverConfigKey";
			// End of user code
			
			// Start of user code for registryBasedUrlConfigKey ElementEditor key
			public static String registryBasedUrlConfigKey = "esb::DBReportMediator::connection::registryBasedUrlConfigKey";
			// End of user code
			
			// Start of user code for registryBasedUserConfigKey ElementEditor key
			public static String registryBasedUserConfigKey = "esb::DBReportMediator::connection::registryBasedUserConfigKey";
			// End of user code
			
			// Start of user code for registryBasedPassConfigKey ElementEditor key
			public static String registryBasedPassConfigKey = "esb::DBReportMediator::connection::registryBasedPassConfigKey";
			// End of user code
			
	
		}
	
		public static class Statements {
	
			
			public static String sqlStatements = "esb::DBReportMediator::statements::sqlStatements";
			
	
		}
	
		public static class Properties {
	
			
			public static String commentsList = "esb::DBReportMediator::properties::commentsList";
			
			
			public static String reverse = "esb::DBReportMediator::properties::Reverse";
			
			
			public static String propertyAutocommit = "esb::DBReportMediator::properties::propertyAutocommit";
			
			
			public static String propertyIsolation = "esb::DBReportMediator::properties::propertyIsolation";
			
			
			public static String propertyMaxactive = "esb::DBReportMediator::properties::propertyMaxactive";
			
			
			public static String propertyMaxidle = "esb::DBReportMediator::properties::propertyMaxidle";
			
			
			public static String propertyMaxopenstatements = "esb::DBReportMediator::properties::propertyMaxopenstatements";
			
			
			public static String propertyMaxwait = "esb::DBReportMediator::properties::propertyMaxwait";
			
			
			public static String propertyMinidle = "esb::DBReportMediator::properties::propertyMinidle";
			
			
			public static String propertyPoolstatements = "esb::DBReportMediator::properties::propertyPoolstatements";
			
			
			public static String propertyTestonborrow = "esb::DBReportMediator::properties::propertyTestonborrow";
			
			
			public static String propertyTestwhileidle = "esb::DBReportMediator::properties::propertyTestwhileidle";
			
			
			public static String propertyValidationquery = "esb::DBReportMediator::properties::propertyValidationquery";
			
			
			public static String propertyInitialsize = "esb::DBReportMediator::properties::propertyInitialsize";
			
	
		}
	
		public static class Misc {
	
			
			public static String description = "esb::DBReportMediator::misc::description";
			
	
		}
	
	}

	/**
	 * DBReportMediatorInputConnector view descriptor
	 * 
	 */
	public static class DBReportMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::DBReportMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * DBReportMediatorOutputConnector view descriptor
	 * 
	 */
	public static class DBReportMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::DBReportMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RuleMediator view descriptor
	 * 
	 */
	public static class RuleMediator {
		public static class Misc {
	
			
			public static String description = "esb::RuleMediator::misc::description";
			
			
			public static String commentsList = "esb::RuleMediator::misc::commentsList";
			
			
			public static String reverse = "esb::RuleMediator::misc::Reverse";
			
			
			public static String statefulSession = "esb::RuleMediator::misc::statefulSession";
			
			
			public static String ruleSessionProperties = "esb::RuleMediator::misc::RuleSessionProperties";
			
	
		}
	
		public static class InputFacts {
	
			
			public static String inputWrapperName = "esb::RuleMediator::inputFacts::InputWrapperName";
			
			
			public static String inputNameSpace = "esb::RuleMediator::inputFacts::InputNameSpace";
			
			
			public static String ruleFactsConfiguration = "esb::RuleMediator::inputFacts::ruleFactsConfiguration";
			
	
		}
	
		public static class OutputFacts {
	
			
			public static String outputWrapperName = "esb::RuleMediator::outputFacts::OutputWrapperName";
			
			
			public static String outputNameSpace = "esb::RuleMediator::outputFacts::OutputNameSpace";
			
			
			public static String ruleResultsConfiguration = "esb::RuleMediator::outputFacts::ruleResultsConfiguration";
			
	
		}
	
		public static class Source {
	
			
			public static String sourceValue = "esb::RuleMediator::source::sourceValue";
			
			// Start of user code for sourceXPath ElementEditor key
			public static String sourceXPath = "esb::RuleMediator::source::sourceXPath";
			// End of user code
			
	
		}
	
		public static class Target {
	
			
			public static String targetValue = "esb::RuleMediator::target::targetValue";
			
			
			public static String targetAction = "esb::RuleMediator::target::targetAction";
			
			// Start of user code for targetXPath ElementEditor key
			public static String targetXPath = "esb::RuleMediator::target::targetXPath";
			// End of user code
			
			// Start of user code for targetResultXPath ElementEditor key
			public static String targetResultXPath = "esb::RuleMediator::target::targetResultXPath";
			// End of user code
			
	
		}
	
		public static class RuleSet {
	
			
			public static String ruleSetType = "esb::RuleMediator::ruleSet::RuleSetType";
			
			
			public static String ruleSetURL = "esb::RuleMediator::ruleSet::RuleSetURL";
			
			
			public static String ruleSetSourceType = "esb::RuleMediator::ruleSet::ruleSetSourceType";
			
			
			public static String ruleSetSourceCode = "esb::RuleMediator::ruleSet::ruleSetSourceCode";
			
			// Start of user code for ruleSetSourceKey ElementEditor key
			public static String ruleSetSourceKey = "esb::RuleMediator::ruleSet::ruleSetSourceKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * RuleMediatorInputConnector view descriptor
	 * 
	 */
	public static class RuleMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::RuleMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * RuleMediatorOutputConnector view descriptor
	 * 
	 */
	public static class RuleMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::RuleMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RuleMediatorChildMediatorsOutputConnector view descriptor
	 * 
	 */
	public static class RuleMediatorChildMediatorsOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::RuleMediatorChildMediatorsOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RuleSetCreationProperty view descriptor
	 * 
	 */
	public static class RuleSetCreationProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::RuleSetCreationProperty::properties::propertyName";
			
			
			public static String propertyValue = "esb::RuleSetCreationProperty::properties::propertyValue";
			
	
		}
	
	}

	/**
	 * RuleSessionProperty view descriptor
	 * 
	 */
	public static class RuleSessionProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::RuleSessionProperty::properties::propertyName";
			
			
			public static String propertyValue = "esb::RuleSessionProperty::properties::propertyValue";
			
	
		}
	
	}

	/**
	 * RuleFactsConfiguration view descriptor
	 * 
	 */
	public static class RuleFactsConfiguration {
		public static class Properties {
	
			
			public static String facts = "esb::RuleFactsConfiguration::properties::facts";
			
	
		}
	
	}

	/**
	 * RuleFact view descriptor
	 * 
	 */
	public static class RuleFact {
		public static class Properties {
	
			
			public static String factType = "esb::RuleFact::properties::factType";
			
			
			public static String factCustomType = "esb::RuleFact::properties::factCustomType";
			
			
			public static String factName = "esb::RuleFact::properties::factName";
			
			
			public static String valueType = "esb::RuleFact::properties::valueType";
			
			
			public static String valueLiteral = "esb::RuleFact::properties::valueLiteral";
			
			// Start of user code for propertyExpression ElementEditor key
			public static String propertyExpression = "esb::RuleFact::properties::propertyExpression";
			// End of user code
			
			// Start of user code for valueReferenceKey ElementEditor key
			public static String valueReferenceKey = "esb::RuleFact::properties::valueReferenceKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * RuleResultsConfiguration view descriptor
	 * 
	 */
	public static class RuleResultsConfiguration {
		public static class Properties {
	
			
			public static String results = "esb::RuleResultsConfiguration::properties::results";
			
	
		}
	
	}

	/**
	 * RuleResult view descriptor
	 * 
	 */
	public static class RuleResult {
		public static class Properties {
	
			
			public static String resultType = "esb::RuleResult::properties::resultType";
			
			
			public static String resultCustomType = "esb::RuleResult::properties::resultCustomType";
			
			
			public static String resultName = "esb::RuleResult::properties::resultName";
			
			
			public static String valueType = "esb::RuleResult::properties::valueType";
			
			
			public static String valueLiteral = "esb::RuleResult::properties::valueLiteral";
			
	
		}
	
	}

	/**
	 * RuleChildMediatorsConfiguration view descriptor
	 * 
	 */
	public static class RuleChildMediatorsConfiguration {
	}

	/**
	 * CallTemplateParameter view descriptor
	 * 
	 */
	public static class CallTemplateParameter {
		public static class Properties {
	
			
			public static String parameterName = "esb::CallTemplateParameter::properties::parameterName";
			
			
			public static String templateParameterType = "esb::CallTemplateParameter::properties::templateParameterType";
			
			
			public static String parameterValue = "esb::CallTemplateParameter::properties::parameterValue";
			
			// Start of user code for parameterExpression ElementEditor key
			public static String parameterExpression = "esb::CallTemplateParameter::properties::parameterExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * CallTemplateMediator view descriptor
	 * 
	 */
	public static class CallTemplateMediator {
		public static class Properties {
	
			
			public static String description = "esb::CallTemplateMediator::properties::description";
			
			
			public static String commentsList = "esb::CallTemplateMediator::properties::commentsList";
			
			
			public static String reverse = "esb::CallTemplateMediator::properties::Reverse";
			
			
			public static String availableTemplates = "esb::CallTemplateMediator::properties::availableTemplates";
			
			
			public static String templateParameters = "esb::CallTemplateMediator::properties::templateParameters";
			
			
			public static String targetTemplate = "esb::CallTemplateMediator::properties::targetTemplate";
			
			// Start of user code for onError ElementEditor key
			public static String onError = "esb::CallTemplateMediator::properties::onError";
			// End of user code
			
	
		}
	
	}

	/**
	 * CallTemplateMediatorInputConnector view descriptor
	 * 
	 */
	public static class CallTemplateMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::CallTemplateMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CallTemplateMediatorOutputConnector view descriptor
	 * 
	 */
	public static class CallTemplateMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CallTemplateMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * LoopBackMediator view descriptor
	 * 
	 */
	public static class LoopBackMediator {
		public static class Properties {
	
			
			public static String description = "esb::LoopBackMediator::properties::description";
			
			
			public static String commentsList = "esb::LoopBackMediator::properties::commentsList";
			
			
			public static String reverse = "esb::LoopBackMediator::properties::Reverse";
			
	
		}
	
	}

	/**
	 * LoopBackMediatorInputConnector view descriptor
	 * 
	 */
	public static class LoopBackMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::LoopBackMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * LoopBackMediatorOutputConnector view descriptor
	 * 
	 */
	public static class LoopBackMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::LoopBackMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RespondMediator view descriptor
	 * 
	 */
	public static class RespondMediator {
		public static class Properties {
	
			
			public static String description = "esb::RespondMediator::properties::description";
			
			
			public static String reverse = "esb::RespondMediator::properties::Reverse";
			
			
			public static String commentsList = "esb::RespondMediator::properties::commentsList";
			
	
		}
	
	}

	/**
	 * RespondMediatorInputConnector view descriptor
	 * 
	 */
	public static class RespondMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::RespondMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * RespondMediatorOutputConnector view descriptor
	 * 
	 */
	public static class RespondMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::RespondMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * SmooksMediator view descriptor
	 * 
	 */
	public static class SmooksMediator {
		public static class Input {
	
			
			public static String inputType = "esb::SmooksMediator::input::inputType";
			
			// Start of user code for inputExpresssion ElementEditor key
			public static String inputExpresssion = "esb::SmooksMediator::input::inputExpresssion";
			// End of user code
			
	
		}
	
		public static class Output {
	
			
			public static String outputType = "esb::SmooksMediator::output::outputType";
			
			
			public static String outputProperty = "esb::SmooksMediator::output::outputProperty";
			
			
			public static String outputAction = "esb::SmooksMediator::output::outputAction";
			
			
			public static String outputMethod = "esb::SmooksMediator::output::outputMethod";
			
			// Start of user code for outputExpression ElementEditor key
			public static String outputExpression = "esb::SmooksMediator::output::outputExpression";
			// End of user code
			
	
		}
	
		public static class Properties {
	
			
			public static String commentsList = "esb::SmooksMediator::properties::commentsList";
			
			
			public static String reverse = "esb::SmooksMediator::properties::Reverse";
			
	
		}
	
		public static class Key {
	
			// Start of user code for configurationKey ElementEditor key
			public static String configurationKey = "esb::SmooksMediator::key::configurationKey";
			// End of user code
			
	
		}
	
		public static class Misc {
	
			
			public static String description = "esb::SmooksMediator::misc::description";
			
	
		}
	
	}

	/**
	 * SmooksMediatorInputConnector view descriptor
	 * 
	 */
	public static class SmooksMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::SmooksMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * SmooksMediatorOutputConnector view descriptor
	 * 
	 */
	public static class SmooksMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SmooksMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * StoreMediator view descriptor
	 * 
	 */
	public static class StoreMediator {
		public static class Properties {
	
			
			public static String description = "esb::StoreMediator::properties::description";
			
			
			public static String commentsList = "esb::StoreMediator::properties::commentsList";
			
			
			public static String reverse = "esb::StoreMediator::properties::Reverse";
			
			
			public static String messageStore = "esb::StoreMediator::properties::messageStore";
			
			
			public static String availableMessageStores = "esb::StoreMediator::properties::availableMessageStores";
			
			
			public static String specifyAs = "esb::StoreMediator::properties::SpecifyAs";
			
			// Start of user code for onStoreSequence ElementEditor key
			public static String onStoreSequence = "esb::StoreMediator::properties::onStoreSequence";
			// End of user code
			
			// Start of user code for expression ElementEditor key
			public static String expression = "esb::StoreMediator::properties::expression";
			// End of user code
			
	
		}
	
	}

	/**
	 * StoreMediatorInputConnector view descriptor
	 * 
	 */
	public static class StoreMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::StoreMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * StoreMediatorOutputConnector view descriptor
	 * 
	 */
	public static class StoreMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::StoreMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * BuilderMediator view descriptor
	 * 
	 */
	public static class BuilderMediator {
		public static class Properties {
	
			
			public static String description = "esb::BuilderMediator::properties::description";
			
			
			public static String commentsList = "esb::BuilderMediator::properties::commentsList";
			
			
			public static String reverse = "esb::BuilderMediator::properties::Reverse";
			
			
			public static String messageBuilders = "esb::BuilderMediator::properties::messageBuilders";
			
	
		}
	
	}

	/**
	 * BuilderMediatorInputConnector view descriptor
	 * 
	 */
	public static class BuilderMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::BuilderMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * BuilderMediatorOutputConector view descriptor
	 * 
	 */
	public static class BuilderMediatorOutputConector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::BuilderMediatorOutputConector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * MessageBuilder view descriptor
	 * 
	 */
	public static class MessageBuilder {
		public static class Properties {
	
			
			public static String contentType = "esb::MessageBuilder::properties::contentType";
			
			
			public static String builderClass = "esb::MessageBuilder::properties::builderClass";
			
			
			public static String formatterClass = "esb::MessageBuilder::properties::formatterClass";
			
	
		}
	
	}

	/**
	 * PayloadFactoryMediator view descriptor
	 * 
	 */
	public static class PayloadFactoryMediator {
		public static class Properties {
	
			
			public static String payloadFormat = "esb::PayloadFactoryMediator::properties::payloadFormat";
			
			// Start of user code for payloadKey ElementEditor key
			public static String payloadKey = "esb::PayloadFactoryMediator::properties::payloadKey";
			// End of user code
			
			
			public static String payload = "esb::PayloadFactoryMediator::properties::payload";
			
			
			public static String args = "esb::PayloadFactoryMediator::properties::args";
			
			
			public static String mediaType = "esb::PayloadFactoryMediator::properties::mediaType";
			
			
			public static String description = "esb::PayloadFactoryMediator::properties::description";
			
			
			public static String commentsList = "esb::PayloadFactoryMediator::properties::commentsList";
			
			
			public static String reverse = "esb::PayloadFactoryMediator::properties::Reverse";
			
	
		}
	
	}

	/**
	 * PayloadFactoryMediatorInputConnector view descriptor
	 * 
	 */
	public static class PayloadFactoryMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::PayloadFactoryMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * PayloadFactoryMediatorOutputConnector view descriptor
	 * 
	 */
	public static class PayloadFactoryMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::PayloadFactoryMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * PayloadFactoryArgument view descriptor
	 * 
	 */
	public static class PayloadFactoryArgument {
		public static class Properties {
	
			
			public static String argumentType = "esb::PayloadFactoryArgument::properties::argumentType";
			
			
			public static String argumentValue = "esb::PayloadFactoryArgument::properties::argumentValue";
			
			// Start of user code for argumentExpression ElementEditor key
			public static String argumentExpression = "esb::PayloadFactoryArgument::properties::argumentExpression";
			// End of user code
			
			
			public static String evaluator = "esb::PayloadFactoryArgument::properties::evaluator";
			
			
			public static String literal = "esb::PayloadFactoryArgument::properties::literal";
			
	
		}
	
	}

	/**
	 * ConditionalRouteBranch view descriptor
	 * 
	 */
	public static class ConditionalRouteBranch {
		public static class Properties {
	
			
			public static String breakAfterRoute = "esb::ConditionalRouteBranch::properties::breakAfterRoute";
			
			// Start of user code for targetSequence ElementEditor key
			public static String targetSequence = "esb::ConditionalRouteBranch::properties::targetSequence";
			// End of user code
			
	
		}
	
	// Start of user code for evaluatorExpression ElementEditor key
	public static String evaluatorExpression = "esb::ConditionalRouteBranch::evaluatorExpression";
	// End of user code
	
	}

	/**
	 * ConditionalRouterMediator view descriptor
	 * 
	 */
	public static class ConditionalRouterMediator {
		public static class Properties {
	
			
			public static String description = "esb::ConditionalRouterMediator::properties::description";
			
			
			public static String commentsList = "esb::ConditionalRouterMediator::properties::commentsList";
			
			
			public static String reverse = "esb::ConditionalRouterMediator::properties::Reverse";
			
			
			public static String continueAfterRoute = "esb::ConditionalRouterMediator::properties::continueAfterRoute";
			
			
			public static String conditionalRouteBranches = "esb::ConditionalRouterMediator::properties::conditionalRouteBranches";
			
	
		}
	
	}

	/**
	 * ConditionalRouterMediatorInputConnector view descriptor
	 * 
	 */
	public static class ConditionalRouterMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ConditionalRouterMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ConditionalRouterMediatorOutputConnector view descriptor
	 * 
	 */
	public static class ConditionalRouterMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ConditionalRouterMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ConditionalRouterMediatorAdditionalOutputConnector view descriptor
	 * 
	 */
	public static class ConditionalRouterMediatorAdditionalOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ConditionalRouterMediatorAdditionalOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * SendMediator view descriptor
	 * 
	 */
	public static class SendMediator {
		public static class Properties {
	
			
			public static String skipSerialization = "esb::SendMediator::properties::skipSerialization";
			
			
			public static String endPoint = "esb::SendMediator::properties::EndPoint";
			
			
			public static String receivingSequenceType = "esb::SendMediator::properties::receivingSequenceType";
			
			
			public static String buildMessageBeforeSending = "esb::SendMediator::properties::buildMessageBeforeSending";
			
			// Start of user code for StaticReceivingSequence ElementEditor key
			public static String staticReceivingSequence = "esb::SendMediator::properties::StaticReceivingSequence";
			// End of user code
			
			// Start of user code for DynamicReceivingSequence ElementEditor key
			public static String dynamicReceivingSequence = "esb::SendMediator::properties::DynamicReceivingSequence";
			// End of user code
			
			
			public static String description = "esb::SendMediator::properties::description";
			
			
			public static String commentsList = "esb::SendMediator::properties::commentsList";
			
			
			public static String reverse = "esb::SendMediator::properties::Reverse";
			
	
		}
	
	}

	/**
	 * SendContainer view descriptor
	 * 
	 */
	public static class SendContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * SendMediatorInputConnector view descriptor
	 * 
	 */
	public static class SendMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::SendMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * SendMediatorOutputConnector view descriptor
	 * 
	 */
	public static class SendMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SendMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * SendMediatorEndpointOutputConnector view descriptor
	 * 
	 */
	public static class SendMediatorEndpointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SendMediatorEndpointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * FailoverEndPoint view descriptor
	 * 
	 */
	public static class FailoverEndPoint {
		public static class Properties {
	
			
			public static String description = "esb::FailoverEndPoint::properties::description";
			
			
			public static String commentsList = "esb::FailoverEndPoint::properties::commentsList";
			
			
			public static String endPointName = "esb::FailoverEndPoint::properties::endPointName";
			
			
			public static String anonymous = "esb::FailoverEndPoint::properties::anonymous";
			
			
			public static String inLine = "esb::FailoverEndPoint::properties::InLine";
			
			
			public static String duplicate = "esb::FailoverEndPoint::properties::duplicate";
			
			
			public static String properties_ = "esb::FailoverEndPoint::properties::properties_";
			
			
			public static String reversed = "esb::FailoverEndPoint::properties::reversed";
			
			
			public static String children = "esb::FailoverEndPoint::properties::Children";
			
			
			public static String name = "esb::FailoverEndPoint::properties::name";
			
			
			public static String outputConnector = "esb::FailoverEndPoint::properties::OutputConnector";
			
			
			public static String buildMessage = "esb::FailoverEndPoint::properties::buildMessage";
			
	
		}
	
	}

	/**
	 * FailoverEndPointInputConnector view descriptor
	 * 
	 */
	public static class FailoverEndPointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::FailoverEndPointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * FailoverEndPointOutputConnector view descriptor
	 * 
	 */
	public static class FailoverEndPointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::FailoverEndPointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * FailoverEndPointWestOutputConnector view descriptor
	 * 
	 */
	public static class FailoverEndPointWestOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::FailoverEndPointWestOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ParentEndPoint view descriptor
	 * 
	 */
	public static class ParentEndPoint {
		public static class Properties {
	
			
			public static String description = "esb::ParentEndPoint::properties::description";
			
			
			public static String commentsList = "esb::ParentEndPoint::properties::commentsList";
			
			
			public static String endPointName = "esb::ParentEndPoint::properties::endPointName";
			
			
			public static String anonymous = "esb::ParentEndPoint::properties::anonymous";
			
			
			public static String inLine = "esb::ParentEndPoint::properties::InLine";
			
			
			public static String duplicate = "esb::ParentEndPoint::properties::duplicate";
			
			
			public static String properties_ = "esb::ParentEndPoint::properties::properties_";
			
			
			public static String reversed = "esb::ParentEndPoint::properties::reversed";
			
			
			public static String children = "esb::ParentEndPoint::properties::Children";
			
			
			public static String name = "esb::ParentEndPoint::properties::name";
			
	
		}
	
	}

	/**
	 * WSDLEndPoint view descriptor
	 * 
	 */
	public static class WSDLEndPoint {
		public static class Properties {
	
			
			public static String commentsList = "esb::WSDLEndPoint::properties::commentsList";
			
			
			public static String endPointName = "esb::WSDLEndPoint::properties::endPointName";
			
			
			public static String anonymous = "esb::WSDLEndPoint::properties::anonymous";
			
			
			public static String duplicate = "esb::WSDLEndPoint::properties::duplicate";
			
			
			public static String reversed = "esb::WSDLEndPoint::properties::reversed";
			
			
			public static String templateParameters = "esb::WSDLEndPoint::properties::templateParameters";
			
	
		}
	
		public static class Basic {
	
			
			public static String inLine = "esb::WSDLEndPoint::basic::InLine";
			
			
			public static String format = "esb::WSDLEndPoint::basic::format";
			
			
			public static String traceEnabled = "esb::WSDLEndPoint::basic::traceEnabled";
			
			
			public static String statisticsEnabled = "esb::WSDLEndPoint::basic::statisticsEnabled";
			
	
		}
	
		public static class EndpointSuspendState {
	
			
			public static String suspendErrorCodes = "esb::WSDLEndPoint::endpointSuspendState::suspendErrorCodes";
			
			
			public static String suspendInitialDuration = "esb::WSDLEndPoint::endpointSuspendState::suspendInitialDuration";
			
			
			public static String suspendMaximumDuration = "esb::WSDLEndPoint::endpointSuspendState::suspendMaximumDuration";
			
			
			public static String suspendProgressionFactor = "esb::WSDLEndPoint::endpointSuspendState::suspendProgressionFactor";
			
	
		}
	
		public static class EndpointTimeoutState {
	
			
			public static String retryErrorCodes = "esb::WSDLEndPoint::endpointTimeoutState::retryErrorCodes";
			
			
			public static String retryCount = "esb::WSDLEndPoint::endpointTimeoutState::retryCount";
			
			
			public static String retryDelay = "esb::WSDLEndPoint::endpointTimeoutState::retryDelay";
			
	
		}
	
		public static class Misc {
	
			
			public static String properties = "esb::WSDLEndPoint::misc::properties";
			
			
			public static String optimize = "esb::WSDLEndPoint::misc::optimize";
			
			
			public static String description = "esb::WSDLEndPoint::misc::description";
			
			
			public static String wsdlUri = "esb::WSDLEndPoint::misc::wsdlUri";
			
			
			public static String service = "esb::WSDLEndPoint::misc::service";
			
			
			public static String port = "esb::WSDLEndPoint::misc::port";
			
	
		}
	
		public static class Qos {
	
			
			public static String reliableMessagingEnabled = "esb::WSDLEndPoint::qos::reliableMessagingEnabled";
			
			
			public static String securityEnabled = "esb::WSDLEndPoint::qos::securityEnabled";
			
			
			public static String addressingEnabled = "esb::WSDLEndPoint::qos::addressingEnabled";
			
			// Start of user code for reliableMessagingPolicy ElementEditor key
			public static String reliableMessagingPolicy = "esb::WSDLEndPoint::qos::reliableMessagingPolicy";
			// End of user code
			
			// Start of user code for securityPolicy ElementEditor key
			public static String securityPolicy = "esb::WSDLEndPoint::qos::securityPolicy";
			// End of user code
			
			// Start of user code for inboundPolicy ElementEditor key
			public static String inboundPolicy = "esb::WSDLEndPoint::qos::inboundPolicy";
			// End of user code
			
			// Start of user code for outboundPolicy ElementEditor key
			public static String outboundPolicy = "esb::WSDLEndPoint::qos::outboundPolicy";
			// End of user code
			
			
			public static String addressingVersion = "esb::WSDLEndPoint::qos::addressingVersion";
			
			
			public static String addressingSeparateListener = "esb::WSDLEndPoint::qos::addressingSeparateListener";
			
	
		}
	
		public static class Timeout {
	
			
			public static String timeOutDuration = "esb::WSDLEndPoint::timeout::timeOutDuration";
			
			
			public static String timeOutAction = "esb::WSDLEndPoint::timeout::timeOutAction";
			
	
		}
	
		public static class FailoverErrorCodes {
	
			
			public static String failoverNonRetryErrorCodes = "esb::WSDLEndPoint::Failover Error Codes::failoverNonRetryErrorCodes";
			
	
		}
	
	}

	/**
	 * WSDLEndPointInputConnector view descriptor
	 * 
	 */
	public static class WSDLEndPointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::WSDLEndPointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * WSDLEndPointOutputConnector view descriptor
	 * 
	 */
	public static class WSDLEndPointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::WSDLEndPointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * LoadBalanceEndPoint view descriptor
	 * 
	 */
	public static class LoadBalanceEndPoint {
		public static class Properties {
	
			
			public static String description = "esb::LoadBalanceEndPoint::properties::description";
			
			
			public static String commentsList = "esb::LoadBalanceEndPoint::properties::commentsList";
			
			
			public static String endPointName = "esb::LoadBalanceEndPoint::properties::endPointName";
			
			
			public static String anonymous = "esb::LoadBalanceEndPoint::properties::anonymous";
			
			
			public static String inLine = "esb::LoadBalanceEndPoint::properties::InLine";
			
			
			public static String duplicate = "esb::LoadBalanceEndPoint::properties::duplicate";
			
			
			public static String properties_ = "esb::LoadBalanceEndPoint::properties::properties_";
			
			
			public static String reversed = "esb::LoadBalanceEndPoint::properties::reversed";
			
			
			public static String children = "esb::LoadBalanceEndPoint::properties::Children";
			
			
			public static String name = "esb::LoadBalanceEndPoint::properties::name";
			
			
			public static String failover = "esb::LoadBalanceEndPoint::properties::failover";
			
			
			public static String policy = "esb::LoadBalanceEndPoint::properties::policy";
			
			
			public static String outputConnector = "esb::LoadBalanceEndPoint::properties::outputConnector";
			
			
			public static String sessionType = "esb::LoadBalanceEndPoint::properties::sessionType";
			
			
			public static String algorithm = "esb::LoadBalanceEndPoint::properties::algorithm";
			
			
			public static String sessionTimeout = "esb::LoadBalanceEndPoint::properties::sessionTimeout";
			
			
			public static String buildMessage = "esb::LoadBalanceEndPoint::properties::buildMessage";
			
			
			public static String members = "esb::LoadBalanceEndPoint::properties::members";
			
	
		}
	
	}

	/**
	 * Member view descriptor
	 * 
	 */
	public static class Member {
		public static class Properties {
	
			
			public static String hostName = "esb::Member::properties::hostName";
			
			
			public static String httpPort = "esb::Member::properties::httpPort";
			
			
			public static String httpsPort = "esb::Member::properties::httpsPort";
			
	
		}
	
	}

	/**
	 * LoadBalanceEndPointInputConnector view descriptor
	 * 
	 */
	public static class LoadBalanceEndPointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::LoadBalanceEndPointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * LoadBalanceEndPointOutputConnector view descriptor
	 * 
	 */
	public static class LoadBalanceEndPointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::LoadBalanceEndPointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * LoadBalanceEndPointWestOutputConnector view descriptor
	 * 
	 */
	public static class LoadBalanceEndPointWestOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::LoadBalanceEndPointWestOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * LocalEntry view descriptor
	 * 
	 */
	public static class LocalEntry {
		public static class Properties {
	
			
			public static String description = "esb::LocalEntry::properties::description";
			
			
			public static String commentsList = "esb::LocalEntry::properties::commentsList";
			
			
			public static String entryName = "esb::LocalEntry::properties::entryName";
			
			
			public static String localEntryType = "esb::LocalEntry::properties::localEntryType";
			
			
			public static String valueLiteral = "esb::LocalEntry::properties::valueLiteral";
			
			
			public static String valueXML = "esb::LocalEntry::properties::valueXML";
			
			
			public static String valueURL = "esb::LocalEntry::properties::valueURL";
			
	
		}
	
	}

	/**
	 * Session view descriptor
	 * 
	 */
	public static class Session {
		public static class Properties {
	
			
			public static String type = "esb::Session::properties::type";
			
	
		}
	
	}

	/**
	 * Sequences view descriptor
	 * 
	 */
	public static class Sequences {
		public static class Properties {
	
			
			public static String description = "esb::Sequences::properties::description";
			
			
			public static String commentsList = "esb::Sequences::properties::commentsList";
			
			
			public static String name = "esb::Sequences::properties::name";
			
			
			public static String recieveSequence = "esb::Sequences::properties::recieveSequence";
			
			
			public static String associatedProxy = "esb::Sequences::properties::associatedProxy";
			
			
			public static String templateParameters = "esb::Sequences::properties::templateParameters";
			
			
			public static String traceEnabled = "esb::Sequences::properties::traceEnabled";
			
			
			public static String statisticsEnabled = "esb::Sequences::properties::statisticsEnabled";
			
			// Start of user code for onError ElementEditor key
			public static String onError = "esb::Sequences::properties::onError";
			// End of user code
			
	
		}
	
	}

	/**
	 * SequencesOutputConnector view descriptor
	 * 
	 */
	public static class SequencesOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::SequencesOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * SequencesInputConnector view descriptor
	 * 
	 */
	public static class SequencesInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::SequencesInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * URLRewriteRuleAction view descriptor
	 * 
	 */
	public static class URLRewriteRuleAction {
		public static class Properties {
	
			
			public static String ruleAction = "esb::URLRewriteRuleAction::properties::ruleAction";
			
			
			public static String ruleFragment = "esb::URLRewriteRuleAction::properties::ruleFragment";
			
			
			public static String ruleOption = "esb::URLRewriteRuleAction::properties::ruleOption";
			
			
			public static String actionValue = "esb::URLRewriteRuleAction::properties::actionValue";
			
			
			public static String actionRegex = "esb::URLRewriteRuleAction::properties::actionRegex";
			
			// Start of user code for actionExpression ElementEditor key
			public static String actionExpression = "esb::URLRewriteRuleAction::properties::actionExpression";
			// End of user code
			
	
		}
	
	}

	/**
	 * URLRewriteRule view descriptor
	 * 
	 */
	public static class URLRewriteRule {
		public static class Properties {
	
			
			public static String rewriteRuleAction = "esb::URLRewriteRule::properties::rewriteRuleAction";
			
			// Start of user code for urlRewriteRuleCondition ElementEditor key
			public static String urlRewriteRuleCondition = "esb::URLRewriteRule::properties::urlRewriteRuleCondition";
			// End of user code
			
	
		}
	
	}

	/**
	 * URLRewriteMediator view descriptor
	 * 
	 */
	public static class URLRewriteMediator {
		public static class Properties {
	
			
			public static String description = "esb::URLRewriteMediator::properties::description";
			
			
			public static String commentsList = "esb::URLRewriteMediator::properties::commentsList";
			
			
			public static String reverse = "esb::URLRewriteMediator::properties::Reverse";
			
			
			public static String urlRewriteRules = "esb::URLRewriteMediator::properties::urlRewriteRules";
			
			
			public static String inProperty = "esb::URLRewriteMediator::properties::InProperty";
			
			
			public static String outProperty = "esb::URLRewriteMediator::properties::outProperty";
			
	
		}
	
	}

	/**
	 * URLRewriteMediatorInputConnector view descriptor
	 * 
	 */
	public static class URLRewriteMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::URLRewriteMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * URLRewriteMediatorOutputConnector view descriptor
	 * 
	 */
	public static class URLRewriteMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::URLRewriteMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EvaluatorExpressionProperty view descriptor
	 * 
	 */
	public static class EvaluatorExpressionProperty {
		public static class Properties {
	
			
			public static String prettyName = "esb::EvaluatorExpressionProperty::properties::prettyName";
			
			
			public static String evaluatorName = "esb::EvaluatorExpressionProperty::properties::evaluatorName";
			
			
			public static String evaluatorValue = "esb::EvaluatorExpressionProperty::properties::evaluatorValue";
			
	
		}
	
	}

	/**
	 * ValidateMediator view descriptor
	 * 
	 */
	public static class ValidateMediator {
		public static class Properties {
	
			
			public static String description = "esb::ValidateMediator::properties::description";
			
			
			public static String commentsList = "esb::ValidateMediator::properties::commentsList";
			
			
			public static String reverse = "esb::ValidateMediator::properties::Reverse";
			
			
			public static String features = "esb::ValidateMediator::properties::features";
			
			
			public static String schemas = "esb::ValidateMediator::properties::schemas";
			
			
			public static String resources = "esb::ValidateMediator::properties::resources";
			
			
			public static String enableCacheSchema = "esb::ValidateMediator::properties::enableCacheSchema";
			
			// Start of user code for source ElementEditor key
			public static String source = "esb::ValidateMediator::properties::source";
			// End of user code
			
	
		}
	
	}

	/**
	 * ValidateResource view descriptor
	 * 
	 */
	public static class ValidateResource {
		public static class Properties {
	
			
			public static String location = "esb::ValidateResource::properties::location";
			
			// Start of user code for locationKey ElementEditor key
			public static String locationKey = "esb::ValidateResource::properties::locationKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * ValidateFeature view descriptor
	 * 
	 */
	public static class ValidateFeature {
		public static class Properties {
	
			
			public static String featureName = "esb::ValidateFeature::properties::featureName";
			
			
			public static String featureEnabled = "esb::ValidateFeature::properties::featureEnabled";
			
	
		}
	
	}

	/**
	 * ValidateSchema view descriptor
	 * 
	 */
	public static class ValidateSchema {
		public static class Properties {
	
			
			public static String validateSchemaKeyType = "esb::ValidateSchema::properties::validateSchemaKeyType";
			
			
			public static String schemaKey = "esb::ValidateSchema::properties::schemaKey";
			
			// Start of user code for staticSchemaKey ElementEditor key
			public static String staticSchemaKey = "esb::ValidateSchema::properties::staticSchemaKey";
			// End of user code
			
			// Start of user code for dynamicSchemaKey ElementEditor key
			public static String dynamicSchemaKey = "esb::ValidateSchema::properties::dynamicSchemaKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * ValidateMediatorInputConnector view descriptor
	 * 
	 */
	public static class ValidateMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::ValidateMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * ValidateMediatorOutputConnector view descriptor
	 * 
	 */
	public static class ValidateMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ValidateMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ValidateMediatorOnFailOutputConnector view descriptor
	 * 
	 */
	public static class ValidateMediatorOnFailOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ValidateMediatorOnFailOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * EndpointDiagram view descriptor
	 * 
	 */
	public static class EndpointDiagram {
		public static class Properties {
	
			
			public static String description = "esb::EndpointDiagram::properties::description";
			
			
			public static String commentsList = "esb::EndpointDiagram::properties::commentsList";
			
			
			public static String name = "esb::EndpointDiagram::properties::name";
			
	
		}
	
	}

	/**
	 * NamedEndpoint view descriptor
	 * 
	 */
	public static class NamedEndpoint {
		public static class Properties {
	
			
			public static String description = "esb::NamedEndpoint::properties::description";
			
			
			public static String commentsList = "esb::NamedEndpoint::properties::commentsList";
			
			
			public static String endPointName = "esb::NamedEndpoint::properties::endPointName";
			
			
			public static String anonymous = "esb::NamedEndpoint::properties::anonymous";
			
			
			public static String inLine = "esb::NamedEndpoint::properties::InLine";
			
			
			public static String duplicate = "esb::NamedEndpoint::properties::duplicate";
			
			
			public static String properties_ = "esb::NamedEndpoint::properties::properties_";
			
			
			public static String reversed = "esb::NamedEndpoint::properties::reversed";
			
			
			public static String reliableMessagingEnabled = "esb::NamedEndpoint::properties::reliableMessagingEnabled";
			
			
			public static String securityEnabled = "esb::NamedEndpoint::properties::securityEnabled";
			
			
			public static String addressingEnabled = "esb::NamedEndpoint::properties::addressingEnabled";
			
			
			public static String addressingVersion = "esb::NamedEndpoint::properties::addressingVersion";
			
			
			public static String addressingSeparateListener = "esb::NamedEndpoint::properties::addressingSeparateListener";
			
			
			public static String timeOutDuration = "esb::NamedEndpoint::properties::timeOutDuration";
			
			
			public static String timeOutAction = "esb::NamedEndpoint::properties::timeOutAction";
			
			
			public static String retryErrorCodes = "esb::NamedEndpoint::properties::retryErrorCodes";
			
			
			public static String retryCount = "esb::NamedEndpoint::properties::retryCount";
			
			
			public static String retryDelay = "esb::NamedEndpoint::properties::retryDelay";
			
			
			public static String suspendErrorCodes = "esb::NamedEndpoint::properties::suspendErrorCodes";
			
			
			public static String suspendInitialDuration = "esb::NamedEndpoint::properties::suspendInitialDuration";
			
			
			public static String suspendMaximumDuration = "esb::NamedEndpoint::properties::suspendMaximumDuration";
			
			
			public static String suspendProgressionFactor = "esb::NamedEndpoint::properties::suspendProgressionFactor";
			
			
			public static String format = "esb::NamedEndpoint::properties::format";
			
			
			public static String optimize = "esb::NamedEndpoint::properties::optimize";
			
			
			public static String templateParameters = "esb::NamedEndpoint::properties::templateParameters";
			
			
			public static String statisticsEnabled = "esb::NamedEndpoint::properties::statisticsEnabled";
			
			
			public static String traceEnabled = "esb::NamedEndpoint::properties::traceEnabled";
			
			
			public static String name = "esb::NamedEndpoint::properties::name";
			
			
			public static String referringEndpointType = "esb::NamedEndpoint::properties::referringEndpointType";
			
			// Start of user code for dynamicReferenceKey ElementEditor key
			public static String dynamicReferenceKey = "esb::NamedEndpoint::properties::dynamicReferenceKey";
			// End of user code
			
			// Start of user code for staticReferenceKey ElementEditor key
			public static String staticReferenceKey = "esb::NamedEndpoint::properties::staticReferenceKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * NamedEndpointInputConnector view descriptor
	 * 
	 */
	public static class NamedEndpointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::NamedEndpointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * NamedEndpointOutputConnector view descriptor
	 * 
	 */
	public static class NamedEndpointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::NamedEndpointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * Template view descriptor
	 * 
	 */
	public static class Template {
		public static class Properties {
	
			
			public static String description = "esb::Template::properties::description";
			
			
			public static String commentsList = "esb::Template::properties::commentsList";
			
			
			public static String name = "esb::Template::properties::name";
			
			
			public static String templateType = "esb::Template::properties::templateType";
			
			
			public static String parameters = "esb::Template::properties::parameters";
			
			// Start of user code for onError ElementEditor key
			public static String onError = "esb::Template::properties::onError";
			// End of user code
			
	
		}
	
	}

	/**
	 * TemplateParameter view descriptor
	 * 
	 */
	public static class TemplateParameter {
		public static class Properties {
	
			
			public static String name = "esb::TemplateParameter::properties::name";
			
			
			public static String isMandatory = "esb::TemplateParameter::properties::isMandatory";
			
			
			public static String defaultValue = "esb::TemplateParameter::properties::defaultValue";
			
	
		}
	
	}

	/**
	 * Task view descriptor
	 * 
	 */
	public static class Task {
		public static class Properties {
	
			
			public static String description = "esb::Task::properties::description";
			
			
			public static String commentsList = "esb::Task::properties::commentsList";
			
			
			public static String taskName = "esb::Task::properties::taskName";
			
			
			public static String taskGroup = "esb::Task::properties::taskGroup";
			
			
			public static String triggerType = "esb::Task::properties::triggerType";
			
			
			public static String count = "esb::Task::properties::count";
			
			
			public static String interval = "esb::Task::properties::interval";
			
			
			public static String cron = "esb::Task::properties::cron";
			
			
			public static String pinnedServers = "esb::Task::properties::pinnedServers";
			
			
			public static String taskImplementation = "esb::Task::properties::taskImplementation";
			
			
			public static String taskProperties = "esb::Task::properties::taskProperties";
			
	
		}
	
	}

	/**
	 * NameValueTypeProperty view descriptor
	 * 
	 */
	public static class NameValueTypeProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::NameValueTypeProperty::properties::propertyName";
			
			
			public static String propertyValue = "esb::NameValueTypeProperty::properties::propertyValue";
			
			
			public static String propertyType = "esb::NameValueTypeProperty::properties::propertyType";
			
	
		}
	
	}

	/**
	 * TaskProperty view descriptor
	 * 
	 */
	public static class TaskProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::TaskProperty::properties::propertyName";
			
			
			public static String propertyValue = "esb::TaskProperty::properties::propertyValue";
			
			
			public static String propertyType = "esb::TaskProperty::properties::propertyType";
			
	
		}
	
	}

	/**
	 * SynapseAPI view descriptor
	 * 
	 */
	public static class SynapseAPI {
		public static class Handler {
	
			
			public static String handlers = "esb::SynapseAPI::handler::handlers";
			
				public static class Properties {
			
					
					public static String commentsList = "esb::SynapseAPI::handler::properties::commentsList";
					
					
					public static String apiName = "esb::SynapseAPI::handler::properties::apiName";
					
					
					public static String context = "esb::SynapseAPI::handler::properties::context";
					
					
					public static String hostName = "esb::SynapseAPI::handler::properties::hostName";
					
					
					public static String port = "esb::SynapseAPI::handler::properties::port";
					
					
					public static String resources = "esb::SynapseAPI::handler::properties::resources";
					
					
					public static String versionType = "esb::SynapseAPI::handler::properties::versionType";
					
					
					public static String version = "esb::SynapseAPI::handler::properties::version";
					
					
					public static String traceEnabled = "esb::SynapseAPI::handler::properties::traceEnabled";
					
					
					public static String statisticsEnabled = "esb::SynapseAPI::handler::properties::statisticsEnabled";
					
					
					public static String description = "esb::SynapseAPI::handler::properties::description";
					
					// Start of user code for publishSwagger ElementEditor key
					public static String publishSwagger = "esb::SynapseAPI::handler::properties::publishSwagger";
					// End of user code
					
			
				}
			
	
		}
	
	}

	/**
	 * APIResource view descriptor
	 * 
	 */
	public static class APIResource {
		public static class Properties {
	
			
			public static String inSequenceInputConnectors = "esb::APIResource::properties::inSequenceInputConnectors";
			
	
		}
	
		public static class Basic {
	
			
			public static String urlStyle = "esb::APIResource::basic::urlStyle";
			
			
			public static String uriTemplate = "esb::APIResource::basic::uriTemplate";
			
			
			public static String urlMapping = "esb::APIResource::basic::urlMapping";
			
			
			public static String protocol = "esb::APIResource::basic::protocol";
			
	
		}
	
		public static class Methods {
	
			
			public static String allowGet = "esb::APIResource::methods::allowGet";
			
			
			public static String allowPost = "esb::APIResource::methods::allowPost";
			
			
			public static String allowPut = "esb::APIResource::methods::allowPut";
			
			
			public static String allowDelete = "esb::APIResource::methods::allowDelete";
			
			
			public static String allowOptions = "esb::APIResource::methods::allowOptions";
			
			
			public static String allowHead = "esb::APIResource::methods::allowHead";
			
			
			public static String allowPatch = "esb::APIResource::methods::allowPatch";
			
	
		}
	
		public static class InSequence {
	
			
			public static String inSequenceType = "esb::APIResource::inSequence::inSequenceType";
			
			
			public static String inSequenceName = "esb::APIResource::inSequence::inSequenceName";
			
			// Start of user code for inSequenceKey ElementEditor key
			public static String inSequenceKey = "esb::APIResource::inSequence::inSequenceKey";
			// End of user code
			
	
		}
	
		public static class OutSequence {
	
			
			public static String outSequenceType = "esb::APIResource::outSequence::outSequenceType";
			
			
			public static String outSequenceName = "esb::APIResource::outSequence::outSequenceName";
			
			// Start of user code for outSequenceKey ElementEditor key
			public static String outSequenceKey = "esb::APIResource::outSequence::outSequenceKey";
			// End of user code
			
	
		}
	
		public static class FaultSequence {
	
			
			public static String faultSequenceType = "esb::APIResource::faultSequence::faultSequenceType";
			
			
			public static String faultSequenceName = "esb::APIResource::faultSequence::faultSequenceName";
			
			// Start of user code for faultSequenceKey ElementEditor key
			public static String faultSequenceKey = "esb::APIResource::faultSequence::faultSequenceKey";
			// End of user code
			
	
		}
	
	}

	/**
	 * APIResourceInputConnector view descriptor
	 * 
	 */
	public static class APIResourceInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::APIResourceInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * APIResourceOutputConnector view descriptor
	 * 
	 */
	public static class APIResourceOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::APIResourceOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * APIResourceOutSequenceOutputConnector view descriptor
	 * 
	 */
	public static class APIResourceOutSequenceOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::APIResourceOutSequenceOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * APIResourceInSequenceInputConnector view descriptor
	 * 
	 */
	public static class APIResourceInSequenceInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::APIResourceInSequenceInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * APIResourceFaultInputConnector view descriptor
	 * 
	 */
	public static class APIResourceFaultInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::APIResourceFaultInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * APIResourceEndpoint view descriptor
	 * 
	 */
	public static class APIResourceEndpoint {
		public static class Properties {
	
			
			public static String description = "esb::APIResourceEndpoint::properties::description";
			
			
			public static String commentsList = "esb::APIResourceEndpoint::properties::commentsList";
			
			
			public static String endPointName = "esb::APIResourceEndpoint::properties::endPointName";
			
			
			public static String anonymous = "esb::APIResourceEndpoint::properties::anonymous";
			
			
			public static String inLine = "esb::APIResourceEndpoint::properties::InLine";
			
			
			public static String duplicate = "esb::APIResourceEndpoint::properties::duplicate";
			
			
			public static String properties_ = "esb::APIResourceEndpoint::properties::properties_";
			
			
			public static String reversed = "esb::APIResourceEndpoint::properties::reversed";
			
			
			public static String reliableMessagingEnabled = "esb::APIResourceEndpoint::properties::reliableMessagingEnabled";
			
			
			public static String securityEnabled = "esb::APIResourceEndpoint::properties::securityEnabled";
			
			
			public static String addressingEnabled = "esb::APIResourceEndpoint::properties::addressingEnabled";
			
			
			public static String addressingVersion = "esb::APIResourceEndpoint::properties::addressingVersion";
			
			
			public static String addressingSeparateListener = "esb::APIResourceEndpoint::properties::addressingSeparateListener";
			
			
			public static String timeOutDuration = "esb::APIResourceEndpoint::properties::timeOutDuration";
			
			
			public static String timeOutAction = "esb::APIResourceEndpoint::properties::timeOutAction";
			
			
			public static String retryErrorCodes = "esb::APIResourceEndpoint::properties::retryErrorCodes";
			
			
			public static String retryCount = "esb::APIResourceEndpoint::properties::retryCount";
			
			
			public static String retryDelay = "esb::APIResourceEndpoint::properties::retryDelay";
			
			
			public static String suspendErrorCodes = "esb::APIResourceEndpoint::properties::suspendErrorCodes";
			
			
			public static String suspendInitialDuration = "esb::APIResourceEndpoint::properties::suspendInitialDuration";
			
			
			public static String suspendMaximumDuration = "esb::APIResourceEndpoint::properties::suspendMaximumDuration";
			
			
			public static String suspendProgressionFactor = "esb::APIResourceEndpoint::properties::suspendProgressionFactor";
			
			
			public static String format = "esb::APIResourceEndpoint::properties::format";
			
			
			public static String optimize = "esb::APIResourceEndpoint::properties::optimize";
			
			
			public static String templateParameters = "esb::APIResourceEndpoint::properties::templateParameters";
			
			
			public static String statisticsEnabled = "esb::APIResourceEndpoint::properties::statisticsEnabled";
			
			
			public static String traceEnabled = "esb::APIResourceEndpoint::properties::traceEnabled";
			
	
		}
	
	}

	/**
	 * APIResourceEndpointInputConnector view descriptor
	 * 
	 */
	public static class APIResourceEndpointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::APIResourceEndpointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * APIResourceEndpointOutputConnector view descriptor
	 * 
	 */
	public static class APIResourceEndpointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::APIResourceEndpointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * ComplexEndpoints view descriptor
	 * 
	 */
	public static class ComplexEndpoints {
		public static class Properties {
	
			
			public static String description = "esb::ComplexEndpoints::properties::description";
			
			
			public static String commentsList = "esb::ComplexEndpoints::properties::commentsList";
			
			
			public static String outputConnector = "esb::ComplexEndpoints::properties::outputConnector";
			
			
			public static String name = "esb::ComplexEndpoints::properties::name";
			
	
		}
	
	}

	/**
	 * ComplexEndpointsOutputConnector view descriptor
	 * 
	 */
	public static class ComplexEndpointsOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::ComplexEndpointsOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * AddressingEndpoint view descriptor
	 * 
	 */
	public static class AddressingEndpoint {
		public static class Properties {
	
			
			public static String description = "esb::AddressingEndpoint::properties::description";
			
			
			public static String commentsList = "esb::AddressingEndpoint::properties::commentsList";
			
			
			public static String endPointName = "esb::AddressingEndpoint::properties::endPointName";
			
			
			public static String anonymous = "esb::AddressingEndpoint::properties::anonymous";
			
			
			public static String inLine = "esb::AddressingEndpoint::properties::InLine";
			
			
			public static String duplicate = "esb::AddressingEndpoint::properties::duplicate";
			
			
			public static String properties_ = "esb::AddressingEndpoint::properties::properties_";
			
			
			public static String reversed = "esb::AddressingEndpoint::properties::reversed";
			
			
			public static String reliableMessagingEnabled = "esb::AddressingEndpoint::properties::reliableMessagingEnabled";
			
			
			public static String securityEnabled = "esb::AddressingEndpoint::properties::securityEnabled";
			
			
			public static String addressingEnabled = "esb::AddressingEndpoint::properties::addressingEnabled";
			
			
			public static String addressingVersion = "esb::AddressingEndpoint::properties::addressingVersion";
			
			
			public static String addressingSeparateListener = "esb::AddressingEndpoint::properties::addressingSeparateListener";
			
			
			public static String timeOutDuration = "esb::AddressingEndpoint::properties::timeOutDuration";
			
			
			public static String timeOutAction = "esb::AddressingEndpoint::properties::timeOutAction";
			
			
			public static String retryErrorCodes = "esb::AddressingEndpoint::properties::retryErrorCodes";
			
			
			public static String retryCount = "esb::AddressingEndpoint::properties::retryCount";
			
			
			public static String retryDelay = "esb::AddressingEndpoint::properties::retryDelay";
			
			
			public static String suspendErrorCodes = "esb::AddressingEndpoint::properties::suspendErrorCodes";
			
			
			public static String suspendInitialDuration = "esb::AddressingEndpoint::properties::suspendInitialDuration";
			
			
			public static String suspendMaximumDuration = "esb::AddressingEndpoint::properties::suspendMaximumDuration";
			
			
			public static String suspendProgressionFactor = "esb::AddressingEndpoint::properties::suspendProgressionFactor";
			
			
			public static String format = "esb::AddressingEndpoint::properties::format";
			
			
			public static String optimize = "esb::AddressingEndpoint::properties::optimize";
			
			
			public static String templateParameters = "esb::AddressingEndpoint::properties::templateParameters";
			
			
			public static String statisticsEnabled = "esb::AddressingEndpoint::properties::statisticsEnabled";
			
			
			public static String traceEnabled = "esb::AddressingEndpoint::properties::traceEnabled";
			
	
		}
	
	}

	/**
	 * AddressingEndpointInputConnector view descriptor
	 * 
	 */
	public static class AddressingEndpointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::AddressingEndpointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * AddressingEndpointOutputConnector view descriptor
	 * 
	 */
	public static class AddressingEndpointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::AddressingEndpointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RecipientListEndPoint view descriptor
	 * 
	 */
	public static class RecipientListEndPoint {
		public static class Properties {
	
			
			public static String description = "esb::RecipientListEndPoint::properties::description";
			
			
			public static String commentsList = "esb::RecipientListEndPoint::properties::commentsList";
			
			
			public static String endPointName = "esb::RecipientListEndPoint::properties::endPointName";
			
			
			public static String anonymous = "esb::RecipientListEndPoint::properties::anonymous";
			
			
			public static String inLine = "esb::RecipientListEndPoint::properties::InLine";
			
			
			public static String duplicate = "esb::RecipientListEndPoint::properties::duplicate";
			
			
			public static String properties_ = "esb::RecipientListEndPoint::properties::properties_";
			
			
			public static String reversed = "esb::RecipientListEndPoint::properties::reversed";
			
			
			public static String children = "esb::RecipientListEndPoint::properties::Children";
			
			
			public static String name = "esb::RecipientListEndPoint::properties::name";
			
			
			public static String outputConnector = "esb::RecipientListEndPoint::properties::outputConnector";
			
			
			public static String endpointType = "esb::RecipientListEndPoint::properties::endpointType";
			
			
			public static String endpointsValue = "esb::RecipientListEndPoint::properties::endpointsValue";
			
			
			public static String maxCache = "esb::RecipientListEndPoint::properties::maxCache";
			
	
		}
	
	}

	/**
	 * RecipientListEndPointInputConnector view descriptor
	 * 
	 */
	public static class RecipientListEndPointInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::RecipientListEndPointInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * RecipientListEndPointOutputConnector view descriptor
	 * 
	 */
	public static class RecipientListEndPointOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::RecipientListEndPointOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * RecipientListEndPointWestOutputConnector view descriptor
	 * 
	 */
	public static class RecipientListEndPointWestOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::RecipientListEndPointWestOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * MessageStoreParameter view descriptor
	 * 
	 */
	public static class MessageStoreParameter {
		public static class Properties {
	
			
			public static String parameterName = "esb::MessageStoreParameter::properties::parameterName";
			
			
			public static String parameterValue = "esb::MessageStoreParameter::properties::parameterValue";
			
	
		}
	
	}

	/**
	 * MessageStore view descriptor
	 * 
	 */
	public static class MessageStore {
		public static class Properties {
	
			
			public static String description = "esb::MessageStore::properties::description";
			
			
			public static String commentsList = "esb::MessageStore::properties::commentsList";
			
			
			public static String storeName = "esb::MessageStore::properties::storeName";
			
			
			public static String storeType = "esb::MessageStore::properties::storeType";
			
			
			public static String initialContextFactory = "esb::MessageStore::properties::initialContextFactory";
			
			
			public static String providerURL = "esb::MessageStore::properties::providerURL";
			
			
			public static String jndiQueueName = "esb::MessageStore::properties::jndiQueueName";
			
			
			public static String connectionFactory = "esb::MessageStore::properties::connectionFactory";
			
			
			public static String userName = "esb::MessageStore::properties::userName";
			
			
			public static String password = "esb::MessageStore::properties::password";
			
			
			public static String cacheConnection = "esb::MessageStore::properties::cacheConnection";
			
			
			public static String jmsSpecVersion = "esb::MessageStore::properties::jmsSpecVersion";
			
			
			public static String enableCaching = "esb::MessageStore::properties::enableCaching";
			
			
			public static String providerClass = "esb::MessageStore::properties::providerClass";
			
			
			public static String rabbitMQServerHostName = "esb::MessageStore::properties::rabbitMQServerHostName";
			
			
			public static String rabbitMQServerHostPort = "esb::MessageStore::properties::rabbitMQServerHostPort";
			
			
			public static String rabbitMQQueueName = "esb::MessageStore::properties::rabbitMQQueueName";
			
			
			public static String rabbitMQExchangeName = "esb::MessageStore::properties::rabbitMQExchangeName";
			
			
			public static String routingKey = "esb::MessageStore::properties::routingKey";
			
			
			public static String rabbitMQUserName = "esb::MessageStore::properties::rabbitMQUserName";
			
			
			public static String rabbitMQPassword = "esb::MessageStore::properties::rabbitMQPassword";
			
			
			public static String virtualHost = "esb::MessageStore::properties::virtualHost";
			
			
			public static String jdbcDatabaseTable = "esb::MessageStore::properties::jdbcDatabaseTable";
			
			
			public static String jdbcConnectionInformation = "esb::MessageStore::properties::jdbcConnectionInformation";
			
			
			public static String jdbcDriver = "esb::MessageStore::properties::jdbcDriver";
			
			
			public static String jdbcURL = "esb::MessageStore::properties::jdbcURL";
			
			
			public static String jdbcUser = "esb::MessageStore::properties::jdbcUser";
			
			
			public static String jdbcPassword = "esb::MessageStore::properties::jdbcPassword";
			
			
			public static String jdbcDatasourceName = "esb::MessageStore::properties::jdbcDatasourceName";
			
			
			public static String parameters = "esb::MessageStore::properties::parameters";
			
			
			public static String enableProducerGuaranteedDelivery = "esb::MessageStore::properties::enableProducerGuaranteedDelivery";
			
			
			public static String failoverMessageStore = "esb::MessageStore::properties::failoverMessageStore";
			
			
			public static String resequencepolling = "esb::MessageStore::properties::resequencepolling";
			
			
			public static String resequenceDatabaseTable = "esb::MessageStore::properties::resequenceDatabaseTable";
			
			
			public static String resequenceConnectionInformation = "esb::MessageStore::properties::resequenceConnectionInformation";
			
			
			public static String resequenceDriver = "esb::MessageStore::properties::resequenceDriver";
			
			
			public static String resequenceURL = "esb::MessageStore::properties::resequenceURL";
			
			
			public static String resequenceUser = "esb::MessageStore::properties::resequenceUser";
			
			
			public static String resequencePassword = "esb::MessageStore::properties::resequencePassword";
			
			
			public static String resequenceDatasourceName = "esb::MessageStore::properties::resequenceDatasourceName";
			
			
			public static String resequenceXpath = "esb::MessageStore::properties::resequenceXpath";
			
			
			public static String resequenceXpathAttr = "esb::MessageStore::properties::resequenceXpathAttr";
			
	
		}
	
	}

	/**
	 * MessageProcessorParameter view descriptor
	 * 
	 */
	public static class MessageProcessorParameter {
		public static class Properties {
	
			
			public static String parameterName = "esb::MessageProcessorParameter::properties::parameterName";
			
			
			public static String parameterValue = "esb::MessageProcessorParameter::properties::parameterValue";
			
	
		}
	
	}

	/**
	 * MessageProcessor view descriptor
	 * 
	 */
	public static class MessageProcessor {
		public static class Properties {
	
			
			public static String description = "esb::MessageProcessor::properties::description";
			
			
			public static String commentsList = "esb::MessageProcessor::properties::commentsList";
			
			
			public static String processorName = "esb::MessageProcessor::properties::processorName";
			
			
			public static String processorType = "esb::MessageProcessor::properties::processorType";
			
			
			public static String messageProcessorProvider = "esb::MessageProcessor::properties::messageProcessorProvider";
			
			
			public static String messageStore = "esb::MessageProcessor::properties::messageStore";
			
			
			public static String sourceMessageStore = "esb::MessageProcessor::properties::sourceMessageStore";
			
			
			public static String targetMessageStore = "esb::MessageProcessor::properties::targetMessageStore";
			
			
			public static String processorState = "esb::MessageProcessor::properties::processorState";
			
			
			public static String retryInterval = "esb::MessageProcessor::properties::retryInterval";
			
			
			public static String forwardingInterval = "esb::MessageProcessor::properties::forwardingInterval";
			
			
			public static String samplingInterval = "esb::MessageProcessor::properties::samplingInterval";
			
			
			public static String samplingConcurrency = "esb::MessageProcessor::properties::samplingConcurrency";
			
			
			public static String maxDeliveryAttempts = "esb::MessageProcessor::properties::maxDeliveryAttempts";
			
			
			public static String dropMessageAfterMaximumDeliveryAttempts = "esb::MessageProcessor::properties::dropMessageAfterMaximumDeliveryAttempts";
			
			
			public static String axis2ClientRepository = "esb::MessageProcessor::properties::axis2ClientRepository";
			
			
			public static String axis2Configuration = "esb::MessageProcessor::properties::axis2Configuration";
			
			
			public static String quartzConfigFilePath = "esb::MessageProcessor::properties::quartzConfigFilePath";
			
			
			public static String cronExpression = "esb::MessageProcessor::properties::cronExpression";
			
			
			public static String nonRetryHttpStatusCodes = "esb::MessageProcessor::properties::nonRetryHttpStatusCodes";
			
			
			public static String parameters = "esb::MessageProcessor::properties::parameters";
			
			
			public static String taskCount = "esb::MessageProcessor::properties::taskCount";
			
			
			public static String maxStoreConnectionAttempts = "esb::MessageProcessor::properties::maxStoreConnectionAttempts";
			
			
			public static String storeConnectionInterval = "esb::MessageProcessor::properties::storeConnectionInterval";
			
			
			public static String failMessagesStore = "esb::MessageProcessor::properties::failMessagesStore";
			
	
		}
	
	}

	/**
	 * APIHandler view descriptor
	 * 
	 */
	public static class APIHandler {
		public static class Properties {
	
			
			public static String className = "esb::APIHandler::properties::className";
			
			
			public static String properties_ = "esb::APIHandler::properties::properties_";
			
	
		}
	
	}

	/**
	 * APIHandlerProperty view descriptor
	 * 
	 */
	public static class APIHandlerProperty {
		public static class Properties {
	
			
			public static String name = "esb::APIHandlerProperty::properties::name";
			
			
			public static String value = "esb::APIHandlerProperty::properties::value";
			
	
		}
	
	}

	/**
	 * CloudConnector view descriptor
	 * 
	 */
	public static class CloudConnector {
		public static class Properties {
	
			
			public static String description = "esb::CloudConnector::properties::description";
			
			
			public static String commentsList = "esb::CloudConnector::properties::commentsList";
			
			
			public static String connectorParameters = "esb::CloudConnector::properties::connectorParameters";
			
	
		}
	
	}

	/**
	 * CloudConnectorInputConnector view descriptor
	 * 
	 */
	public static class CloudConnectorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::CloudConnectorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CloudConnectorOutputConnector view descriptor
	 * 
	 */
	public static class CloudConnectorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CloudConnectorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * CloudConnectorOperation view descriptor
	 * 
	 */
	public static class CloudConnectorOperation {
		public static class Properties {
	
			
			public static String description = "esb::CloudConnectorOperation::properties::description";
			
			
			public static String commentsList = "esb::CloudConnectorOperation::properties::commentsList";
			
			
			public static String reverse = "esb::CloudConnectorOperation::properties::Reverse";
			
			
			public static String connectorParameters = "esb::CloudConnectorOperation::properties::connectorParameters";
			
			
			public static String configRef = "esb::CloudConnectorOperation::properties::configRef";
			
			
			public static String connectorName = "esb::CloudConnectorOperation::properties::connectorName";
			
			
			public static String operationName = "esb::CloudConnectorOperation::properties::operationName";
			
			
			public static String cloudConnectorName = "esb::CloudConnectorOperation::properties::cloudConnectorName";
			
			
			public static String availableConfigs = "esb::CloudConnectorOperation::properties::availableConfigs";
			
			
			public static String parameterEditorType = "esb::CloudConnectorOperation::properties::parameterEditorType";
			
	
		}
	
	}

	/**
	 * CloudConnectorOperationInputConnector view descriptor
	 * 
	 */
	public static class CloudConnectorOperationInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::CloudConnectorOperationInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CloudConnectorOperationOutputConnector view descriptor
	 * 
	 */
	public static class CloudConnectorOperationOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::CloudConnectorOperationOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * DataMapperMediator view descriptor
	 * 
	 */
	public static class DataMapperMediator {
		public static class Properties {
	
			
			public static String description = "esb::DataMapperMediator::properties::description";
			
			
			public static String commentsList = "esb::DataMapperMediator::properties::commentsList";
			
			
			public static String reverse = "esb::DataMapperMediator::properties::Reverse";
			
			
			public static String inputType = "esb::DataMapperMediator::properties::inputType";
			
			
			public static String configurationLocalPath = "esb::DataMapperMediator::properties::configurationLocalPath";
			
			
			public static String inputSchemaLocalPath = "esb::DataMapperMediator::properties::inputSchemaLocalPath";
			
			
			public static String outputSchemaLocalPath = "esb::DataMapperMediator::properties::outputSchemaLocalPath";
			
			
			public static String outputType = "esb::DataMapperMediator::properties::outputType";
			
	
		}
	
	}

	/**
	 * DataMapperMediatorInputConnector view descriptor
	 * 
	 */
	public static class DataMapperMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::DataMapperMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * DataMapperMediatorOutputConnector view descriptor
	 * 
	 */
	public static class DataMapperMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::DataMapperMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * FastXSLTMediator view descriptor
	 * 
	 */
	public static class FastXSLTMediator {
		public static class Properties {
	
			
			public static String commentsList = "esb::FastXSLTMediator::properties::commentsList";
			
			
			public static String reverse = "esb::FastXSLTMediator::properties::Reverse";
			
	
		}
	
		public static class Basic {
	
			// Start of user code for fastXsltStaticSchemaKey ElementEditor key
			public static String fastXsltStaticSchemaKey = "esb::FastXSLTMediator::Basic::fastXsltStaticSchemaKey";
			// End of user code
			
			// Start of user code for fastXsltDynamicSchemaKey ElementEditor key
			public static String fastXsltDynamicSchemaKey = "esb::FastXSLTMediator::Basic::fastXsltDynamicSchemaKey";
			// End of user code
			
	
		}
	
		public static class Misc {
	
			
			public static String fastXsltSchemaKeyType = "esb::FastXSLTMediator::Misc::fastXsltSchemaKeyType";
			
			
			public static String description = "esb::FastXSLTMediator::Misc::description";
			
	
		}
	
	}

	/**
	 * FastXSLTMediatorInputConnector view descriptor
	 * 
	 */
	public static class FastXSLTMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::FastXSLTMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * FastXSLTMediatorOutputConnector view descriptor
	 * 
	 */
	public static class FastXSLTMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::FastXSLTMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * InboundEndpoint view descriptor
	 * 
	 */
	public static class InboundEndpoint {
		public static class Properties {
	
			
			public static String description = "esb::InboundEndpoint::properties::description";
			
			
			public static String commentsList = "esb::InboundEndpoint::properties::commentsList";
			
			
			public static String name = "esb::InboundEndpoint::properties::name";
			
			
			public static String type = "esb::InboundEndpoint::properties::type";
			
			
			public static String class_ = "esb::InboundEndpoint::properties::class";
			
			
			public static String protocol = "esb::InboundEndpoint::properties::protocol";
			
			
			public static String inboundEndpointBehaviour = "esb::InboundEndpoint::properties::inboundEndpointBehaviour";
			
			
			public static String inboundHttpPort = "esb::InboundEndpoint::properties::inboundHttpPort";
			
			
			public static String inboundWorkerPoolSizeCore = "esb::InboundEndpoint::properties::inboundWorkerPoolSizeCore";
			
			
			public static String inboundWorkerPoolSizeMax = "esb::InboundEndpoint::properties::inboundWorkerPoolSizeMax";
			
			
			public static String inboundWorkerThreadKeepAliveSec = "esb::InboundEndpoint::properties::inboundWorkerThreadKeepAliveSec";
			
			
			public static String inboundWorkerPoolQueueLength = "esb::InboundEndpoint::properties::inboundWorkerPoolQueueLength";
			
			
			public static String inboundThreadGroupId = "esb::InboundEndpoint::properties::inboundThreadGroupId";
			
			
			public static String inboundThreadId = "esb::InboundEndpoint::properties::inboundThreadId";
			
			
			public static String dispatchFilterPattern = "esb::InboundEndpoint::properties::dispatchFilterPattern";
			
			
			public static String interval = "esb::InboundEndpoint::properties::interval";
			
			
			public static String sequential = "esb::InboundEndpoint::properties::sequential";
			
			
			public static String coordination = "esb::InboundEndpoint::properties::coordination";
			
			
			public static String transportVFSFileURI = "esb::InboundEndpoint::properties::transportVFSFileURI";
			
			
			public static String wso2mbConnectionUrl = "esb::InboundEndpoint::properties::wso2mbConnectionUrl";
			
			
			public static String transportVFSContentType = "esb::InboundEndpoint::properties::transportVFSContentType";
			
			
			public static String transportVFSFileNamePattern = "esb::InboundEndpoint::properties::transportVFSFileNamePattern";
			
			
			public static String transportVFSFileProcessInterval = "esb::InboundEndpoint::properties::transportVFSFileProcessInterval";
			
			
			public static String transportVFSFileProcessCount = "esb::InboundEndpoint::properties::transportVFSFileProcessCount";
			
			
			public static String transportVFSLocking = "esb::InboundEndpoint::properties::transportVFSLocking";
			
			
			public static String transportVFSMaxRetryCount = "esb::InboundEndpoint::properties::transportVFSMaxRetryCount";
			
			
			public static String transportVFSMoveAfterFailedMove = "esb::InboundEndpoint::properties::transportVFSMoveAfterFailedMove";
			
			
			public static String transportVFSReconnectTimeout = "esb::InboundEndpoint::properties::transportVFSReconnectTimeout";
			
			
			public static String transportJMSSharedSubscription = "esb::InboundEndpoint::properties::transportJMSSharedSubscription";
			
			
			public static String transportJMSSubscriptionName = "esb::InboundEndpoint::properties::transportJMSSubscriptionName";
			
			
			public static String transportJMSPinnedServers = "esb::InboundEndpoint::properties::transportJMSPinnedServers";
			
			
			public static String transportVFSActionAfterProcess = "esb::InboundEndpoint::properties::transportVFSActionAfterProcess";
			
			
			public static String transportVFSMoveAfterProcess = "esb::InboundEndpoint::properties::transportVFSMoveAfterProcess";
			
			
			public static String transportVFSActionAfterErrors = "esb::InboundEndpoint::properties::transportVFSActionAfterErrors";
			
			
			public static String transportVFSMoveAfterErrors = "esb::InboundEndpoint::properties::transportVFSMoveAfterErrors";
			
			
			public static String transportVFSFailedRecordsFileName = "esb::InboundEndpoint::properties::transportVFSFailedRecordsFileName";
			
			
			public static String transportVFSFailedRecordsFileDestination = "esb::InboundEndpoint::properties::transportVFSFailedRecordsFileDestination";
			
			
			public static String transportVFSMoveFailedRecordTimestampFormat = "esb::InboundEndpoint::properties::transportVFSMoveFailedRecordTimestampFormat";
			
			
			public static String transportVFSFailedRecordNextRetryDuration = "esb::InboundEndpoint::properties::transportVFSFailedRecordNextRetryDuration";
			
			
			public static String transportVFSActionAfterFailure = "esb::InboundEndpoint::properties::transportVFSActionAfterFailure";
			
			
			public static String transportVFSMoveAfterFailure = "esb::InboundEndpoint::properties::transportVFSMoveAfterFailure";
			
			
			public static String transportVFSReplyFileURI = "esb::InboundEndpoint::properties::transportVFSReplyFileURI";
			
			
			public static String transportVFSReplyFileName = "esb::InboundEndpoint::properties::transportVFSReplyFileName";
			
			
			public static String transportVFSAutoLockRelease = "esb::InboundEndpoint::properties::transportVFSAutoLockRelease";
			
			
			public static String transportVFSAutoLockReleaseInterval = "esb::InboundEndpoint::properties::transportVFSAutoLockReleaseInterval";
			
			
			public static String transportVFSLockReleaseSameNode = "esb::InboundEndpoint::properties::transportVFSLockReleaseSameNode";
			
			
			public static String transportVFSDistributedLock = "esb::InboundEndpoint::properties::transportVFSDistributedLock";
			
			
			public static String transportVFSStreaming = "esb::InboundEndpoint::properties::transportVFSStreaming";
			
			
			public static String transportVFSBuild = "esb::InboundEndpoint::properties::transportVFSBuild";
			
			
			public static String transportVFSDistributedTimeout = "esb::InboundEndpoint::properties::transportVFSDistributedTimeout";
			
			
			public static String transportVFSSFTPIdentities = "esb::InboundEndpoint::properties::transportVFSSFTPIdentities";
			
			
			public static String transportVFSSFTPIdentityPassPhrase = "esb::InboundEndpoint::properties::transportVFSSFTPIdentityPassPhrase";
			
			
			public static String transportVFSSFTPUserDirIsRoot = "esb::InboundEndpoint::properties::transportVFSSFTPUserDirIsRoot";
			
			
			public static String javaNamingFactoryInitial = "esb::InboundEndpoint::properties::javaNamingFactoryInitial";
			
			
			public static String javaNamingProviderUrl = "esb::InboundEndpoint::properties::javaNamingProviderUrl";
			
			
			public static String transportJMSConnectionFactoryJNDIName = "esb::InboundEndpoint::properties::transportJMSConnectionFactoryJNDIName";
			
			
			public static String transportJMSConnectionFactoryType = "esb::InboundEndpoint::properties::transportJMSConnectionFactoryType";
			
			
			public static String transportJMSConcurrentConsumers = "esb::InboundEndpoint::properties::transportJMSConcurrentConsumers";
			
			
			public static String transportJMSDestination = "esb::InboundEndpoint::properties::transportJMSDestination";
			
			
			public static String transportJMSSessionTransacted = "esb::InboundEndpoint::properties::transportJMSSessionTransacted";
			
			
			public static String transportJMSSessionAcknowledgement = "esb::InboundEndpoint::properties::transportJMSSessionAcknowledgement";
			
			
			public static String transportJMSCacheLevel = "esb::InboundEndpoint::properties::transportJMSCacheLevel";
			
			
			public static String transportJMSUserName = "esb::InboundEndpoint::properties::transportJMSUserName";
			
			
			public static String transportJMSPassword = "esb::InboundEndpoint::properties::transportJMSPassword";
			
			
			public static String transportJMSJMSSpecVersion = "esb::InboundEndpoint::properties::transportJMSJMSSpecVersion";
			
			
			public static String transportJMSSubscriptionDurable = "esb::InboundEndpoint::properties::transportJMSSubscriptionDurable";
			
			
			public static String transportJMSDurableSubscriberClientID = "esb::InboundEndpoint::properties::transportJMSDurableSubscriberClientID";
			
			
			public static String transportJMSMessageSelector = "esb::InboundEndpoint::properties::transportJMSMessageSelector";
			
			
			public static String transportJMSRetryDuration = "esb::InboundEndpoint::properties::transportJMSRetryDuration";
			
			
			public static String transportVFSMoveTimestampFormat = "esb::InboundEndpoint::properties::transportVFSMoveTimestampFormat";
			
			
			public static String transportVFSFileSortAttribute = "esb::InboundEndpoint::properties::transportVFSFileSortAttribute";
			
			
			public static String transportVFSFileSortAscending = "esb::InboundEndpoint::properties::transportVFSFileSortAscending";
			
			
			public static String transportVFSSubFolderTimestampFormat = "esb::InboundEndpoint::properties::transportVFSSubFolderTimestampFormat";
			
			
			public static String transportVFSCreateFolder = "esb::InboundEndpoint::properties::transportVFSCreateFolder";
			
			
			public static String transportJMSReceiveTimeout = "esb::InboundEndpoint::properties::transportJMSReceiveTimeout";
			
			
			public static String transportJMSContentType = "esb::InboundEndpoint::properties::transportJMSContentType";
			
			
			public static String transportJMSContentTypeProperty = "esb::InboundEndpoint::properties::transportJMSContentTypeProperty";
			
			
			public static String transportJMSReplyDestination = "esb::InboundEndpoint::properties::transportJMSReplyDestination";
			
			
			public static String transportJMSPubSubNoLocal = "esb::InboundEndpoint::properties::transportJMSPubSubNoLocal";
			
			
			public static String transportJMSDurableSubscriberName = "esb::InboundEndpoint::properties::transportJMSDurableSubscriberName";
			
			
			public static String transportJMSBrokerType = "esb::InboundEndpoint::properties::transportJMSBrokerType";
			
			
			public static String transportMQTTConnectionFactory = "esb::InboundEndpoint::properties::transportMQTTConnectionFactory";
			
			
			public static String transportMQTTServerHostName = "esb::InboundEndpoint::properties::transportMQTTServerHostName";
			
			
			public static String transportMQTTServerPort = "esb::InboundEndpoint::properties::transportMQTTServerPort";
			
			
			public static String transportMQTTTopicName = "esb::InboundEndpoint::properties::transportMQTTTopicName";
			
			
			public static String transportMQTTSubscriptionQOS = "esb::InboundEndpoint::properties::transportMQTTSubscriptionQOS";
			
			
			public static String transportMQTTSessionClean = "esb::InboundEndpoint::properties::transportMQTTSessionClean";
			
			
			public static String transportMQTTSslEnable = "esb::InboundEndpoint::properties::transportMQTTSslEnable";
			
			
			public static String transportMQTTTemporaryStoreDirectory = "esb::InboundEndpoint::properties::transportMQTTTemporaryStoreDirectory";
			
			
			public static String transportMQTTSubscriptionUsername = "esb::InboundEndpoint::properties::transportMQTTSubscriptionUsername";
			
			
			public static String transportMQTTSubscriptionPassword = "esb::InboundEndpoint::properties::transportMQTTSubscriptionPassword";
			
			
			public static String transportMQTTClientId = "esb::InboundEndpoint::properties::transportMQTTClientId";
			
			
			public static String truststore = "esb::InboundEndpoint::properties::truststore";
			
			
			public static String keystore = "esb::InboundEndpoint::properties::keystore";
			
			
			public static String sslVerifyClient = "esb::InboundEndpoint::properties::sslVerifyClient";
			
			
			public static String sslProtocol = "esb::InboundEndpoint::properties::sslProtocol";
			
			
			public static String httpsProtocols = "esb::InboundEndpoint::properties::httpsProtocols";
			
			
			public static String certificateRevocationVerifier = "esb::InboundEndpoint::properties::certificateRevocationVerifier";
			
			
			public static String inboundHL7Port = "esb::InboundEndpoint::properties::inboundHL7Port";
			
			
			public static String inboundHL7AutoAck = "esb::InboundEndpoint::properties::inboundHL7AutoAck";
			
			
			public static String inboundHL7MessagePreProcessor = "esb::InboundEndpoint::properties::inboundHL7MessagePreProcessor";
			
			
			public static String inboundHL7CharSet = "esb::InboundEndpoint::properties::inboundHL7CharSet";
			
			
			public static String inboundHL7TimeOut = "esb::InboundEndpoint::properties::inboundHL7TimeOut";
			
			
			public static String inboundHL7ValidateMessage = "esb::InboundEndpoint::properties::inboundHL7ValidateMessage";
			
			
			public static String inboundHL7BuildInvalidMessages = "esb::InboundEndpoint::properties::inboundHL7BuildInvalidMessages";
			
			
			public static String inboundHL7PassThroughInvalidMessages = "esb::InboundEndpoint::properties::inboundHL7PassThroughInvalidMessages";
			
			
			public static String zookeeperConnect = "esb::InboundEndpoint::properties::zookeeperConnect";
			
			
			public static String groupId = "esb::InboundEndpoint::properties::groupId";
			
			
			public static String contentType = "esb::InboundEndpoint::properties::contentType";
			
			
			public static String consumerType = "esb::InboundEndpoint::properties::consumerType";
			
			
			public static String topicsOrTopicFilter = "esb::InboundEndpoint::properties::topicsOrTopicFilter";
			
			
			public static String topicsName = "esb::InboundEndpoint::properties::topicsName";
			
			
			public static String topicFilterFrom = "esb::InboundEndpoint::properties::topicFilterFrom";
			
			
			public static String topicFilterName = "esb::InboundEndpoint::properties::topicFilterName";
			
			
			public static String simpleConsumerTopic = "esb::InboundEndpoint::properties::simpleConsumerTopic";
			
			
			public static String simpleConsumerBrokers = "esb::InboundEndpoint::properties::simpleConsumerBrokers";
			
			
			public static String simpleConsumerPort = "esb::InboundEndpoint::properties::simpleConsumerPort";
			
			
			public static String simpleConsumerPartition = "esb::InboundEndpoint::properties::simpleConsumerPartition";
			
			
			public static String simpleConsumerMaxMessagesToRead = "esb::InboundEndpoint::properties::simpleConsumerMaxMessagesToRead";
			
			
			public static String threadCount = "esb::InboundEndpoint::properties::threadCount";
			
			
			public static String consumerId = "esb::InboundEndpoint::properties::consumerId";
			
			
			public static String socketTimeoutMs = "esb::InboundEndpoint::properties::socketTimeoutMs";
			
			
			public static String socketReceiveBufferBytes = "esb::InboundEndpoint::properties::socketReceiveBufferBytes";
			
			
			public static String fetchMessageMaxBytes = "esb::InboundEndpoint::properties::fetchMessageMaxBytes";
			
			
			public static String numConsumerFetches = "esb::InboundEndpoint::properties::numConsumerFetches";
			
			
			public static String autoCommitEnable = "esb::InboundEndpoint::properties::autoCommitEnable";
			
			
			public static String autoCommitIntervalMs = "esb::InboundEndpoint::properties::autoCommitIntervalMs";
			
			
			public static String queuedMaxMessageChunks = "esb::InboundEndpoint::properties::queuedMaxMessageChunks";
			
			
			public static String rebalanceMaxRetries = "esb::InboundEndpoint::properties::rebalanceMaxRetries";
			
			
			public static String fetchMinBytes = "esb::InboundEndpoint::properties::fetchMinBytes";
			
			
			public static String fetchWaitMaxMs = "esb::InboundEndpoint::properties::fetchWaitMaxMs";
			
			
			public static String rebalanceBackoffMs = "esb::InboundEndpoint::properties::rebalanceBackoffMs";
			
			
			public static String refreshLeaderBackoffMs = "esb::InboundEndpoint::properties::refreshLeaderBackoffMs";
			
			
			public static String autoOffsetReset = "esb::InboundEndpoint::properties::autoOffsetReset";
			
			
			public static String consumerTimeoutMs = "esb::InboundEndpoint::properties::consumerTimeoutMs";
			
			
			public static String excludeInternalTopics = "esb::InboundEndpoint::properties::excludeInternalTopics";
			
			
			public static String partitionAssignmentStrategy = "esb::InboundEndpoint::properties::partitionAssignmentStrategy";
			
			
			public static String clientId = "esb::InboundEndpoint::properties::clientId";
			
			
			public static String zookeeperSessionTimeoutMs = "esb::InboundEndpoint::properties::zookeeperSessionTimeoutMs";
			
			
			public static String zookeeperConnectionTimeoutMs = "esb::InboundEndpoint::properties::zookeeperConnectionTimeoutMs";
			
			
			public static String zookeeperSyncTimeMs = "esb::InboundEndpoint::properties::zookeeperSyncTimeMs";
			
			
			public static String offsetsStorage = "esb::InboundEndpoint::properties::offsetsStorage";
			
			
			public static String offsetsChannelBackoffMs = "esb::InboundEndpoint::properties::offsetsChannelBackoffMs";
			
			
			public static String offsetsChannelSocketTimeoutMs = "esb::InboundEndpoint::properties::offsetsChannelSocketTimeoutMs";
			
			
			public static String offsetsCommitMaxRetries = "esb::InboundEndpoint::properties::offsetsCommitMaxRetries";
			
			
			public static String dualCommitEnabled = "esb::InboundEndpoint::properties::dualCommitEnabled";
			
			
			public static String inboundCxfRmHost = "esb::InboundEndpoint::properties::inboundCxfRmHost";
			
			
			public static String inboundCxfRmPort = "esb::InboundEndpoint::properties::inboundCxfRmPort";
			
			
			public static String inboundCxfRmConfigFile = "esb::InboundEndpoint::properties::inboundCxfRmConfigFile";
			
			
			public static String enableSSL = "esb::InboundEndpoint::properties::enableSSL";
			
			
			public static String serviceParameters = "esb::InboundEndpoint::properties::serviceParameters";
			
			
			public static String suspend = "esb::InboundEndpoint::properties::suspend";
			
			
			public static String transportRabbitMqConnectionFactory = "esb::InboundEndpoint::properties::transportRabbitMqConnectionFactory";
			
			
			public static String transportRabbitMqServerHostName = "esb::InboundEndpoint::properties::transportRabbitMqServerHostName";
			
			
			public static String transportRabbitMqServerPort = "esb::InboundEndpoint::properties::transportRabbitMqServerPort";
			
			
			public static String transportRabbitMqServerUserName = "esb::InboundEndpoint::properties::transportRabbitMqServerUserName";
			
			
			public static String transportRabbitMqServerPassword = "esb::InboundEndpoint::properties::transportRabbitMqServerPassword";
			
			
			public static String transportRabbitMqQueueName = "esb::InboundEndpoint::properties::transportRabbitMqQueueName";
			
			
			public static String transportRabbitMqExchangeName = "esb::InboundEndpoint::properties::transportRabbitMqExchangeName";
			
			
			public static String transportRabbitMqQueueDurable = "esb::InboundEndpoint::properties::transportRabbitMqQueueDurable";
			
			
			public static String transportRabbitMqQueueExclusive = "esb::InboundEndpoint::properties::transportRabbitMqQueueExclusive";
			
			
			public static String transportRabbitMqQueueAutoDelete = "esb::InboundEndpoint::properties::transportRabbitMqQueueAutoDelete";
			
			
			public static String transportRabbitMqQueueAutoAck = "esb::InboundEndpoint::properties::transportRabbitMqQueueAutoAck";
			
			
			public static String transportRabbitMqQueueRoutingKey = "esb::InboundEndpoint::properties::transportRabbitMqQueueRoutingKey";
			
			
			public static String transportRabbitMqQueueDeliveryMode = "esb::InboundEndpoint::properties::transportRabbitMqQueueDeliveryMode";
			
			
			public static String transportRabbitMqExchangeType = "esb::InboundEndpoint::properties::transportRabbitMqExchangeType";
			
			
			public static String transportRabbitMqExchangeDurable = "esb::InboundEndpoint::properties::transportRabbitMqExchangeDurable";
			
			
			public static String transportRabbitMqExchangeAutoDelete = "esb::InboundEndpoint::properties::transportRabbitMqExchangeAutoDelete";
			
			
			public static String transportRabbitMqServerVirtualHost = "esb::InboundEndpoint::properties::transportRabbitMqServerVirtualHost";
			
			
			public static String transportRabbitMqFactoryHeartbeat = "esb::InboundEndpoint::properties::transportRabbitMqFactoryHeartbeat";
			
			
			public static String transportRabbitMqConnectionSslEnabled = "esb::InboundEndpoint::properties::transportRabbitMqConnectionSslEnabled";
			
			
			public static String transportRabbitMqConnectionSslKeystoreLocation = "esb::InboundEndpoint::properties::transportRabbitMqConnectionSslKeystoreLocation";
			
			
			public static String transportRabbitMqConnectionSslKeystoreType = "esb::InboundEndpoint::properties::transportRabbitMqConnectionSslKeystoreType";
			
			
			public static String transportRabbitMqConnectionSslKeystorePassword = "esb::InboundEndpoint::properties::transportRabbitMqConnectionSslKeystorePassword";
			
			
			public static String transportRabbitMqConnectionSslTruststoreLocation = "esb::InboundEndpoint::properties::transportRabbitMqConnectionSslTruststoreLocation";
			
			
			public static String transportRabbitMqConnectionSslTruststoreType = "esb::InboundEndpoint::properties::transportRabbitMqConnectionSslTruststoreType";
			
			
			public static String transportRabbitMqConnectionSslTruststorePassword = "esb::InboundEndpoint::properties::transportRabbitMqConnectionSslTruststorePassword";
			
			
			public static String transportRabbitMqConnectionSslVersion = "esb::InboundEndpoint::properties::transportRabbitMqConnectionSslVersion";
			
			
			public static String transportRabbitMqMessageContentType = "esb::InboundEndpoint::properties::transportRabbitMqMessageContentType";
			
			
			public static String transportRabbitMqConnectionRetryCount = "esb::InboundEndpoint::properties::transportRabbitMqConnectionRetryCount";
			
			
			public static String transportRabbitMqConnectionRetryInterval = "esb::InboundEndpoint::properties::transportRabbitMqConnectionRetryInterval";
			
			
			public static String transportRabbitMqServerRetryInterval = "esb::InboundEndpoint::properties::transportRabbitMqServerRetryInterval";
			
			
			public static String wsInboundPort = "esb::InboundEndpoint::properties::wsInboundPort";
			
			
			public static String wsClientSideBroadcastLevel = "esb::InboundEndpoint::properties::wsClientSideBroadcastLevel";
			
			
			public static String wsOutflowDispatchSequence = "esb::InboundEndpoint::properties::wsOutflowDispatchSequence";
			
			
			public static String wsOutflowDispatchFaultSequence = "esb::InboundEndpoint::properties::wsOutflowDispatchFaultSequence";
			
			
			public static String wsBossThreadPoolSize = "esb::InboundEndpoint::properties::wsBossThreadPoolSize";
			
			
			public static String wsWorkerThreadPoolSize = "esb::InboundEndpoint::properties::wsWorkerThreadPoolSize";
			
			
			public static String wsSubprotocolHandlerClass = "esb::InboundEndpoint::properties::wsSubprotocolHandlerClass";
			
			
			public static String wsPipelineHandlerClass = "esb::InboundEndpoint::properties::wsPipelineHandlerClass";
			
			
			public static String transportFeedURL = "esb::InboundEndpoint::properties::transportFeedURL";
			
			
			public static String transportFeedType = "esb::InboundEndpoint::properties::transportFeedType";
			
			
			public static String traceEnabled = "esb::InboundEndpoint::properties::traceEnabled";
			
			
			public static String statisticsEnabled = "esb::InboundEndpoint::properties::statisticsEnabled";
			
			
			public static String transportJMSRetriesBeforeSuspension = "esb::InboundEndpoint::properties::transportJMSRetriesBeforeSuspension";
			
			
			public static String transportJMSResetConnectionOnPollingSuspension = "esb::InboundEndpoint::properties::transportJMSResetConnectionOnPollingSuspension";
			
			
			public static String transportJMSPollingSuspensionPeriod = "esb::InboundEndpoint::properties::transportJMSPollingSuspensionPeriod";
			
			
			public static String transportMQTTSslKeystoreLocation = "esb::InboundEndpoint::properties::transportMQTTSslKeystoreLocation";
			
			
			public static String transportMQTTSslKeystoreType = "esb::InboundEndpoint::properties::transportMQTTSslKeystoreType";
			
			
			public static String transportMQTTSslKeystorePassword = "esb::InboundEndpoint::properties::transportMQTTSslKeystorePassword";
			
			
			public static String transportMQTTSslTruststoreLocation = "esb::InboundEndpoint::properties::transportMQTTSslTruststoreLocation";
			
			
			public static String transportMQTTSslTruststoreType = "esb::InboundEndpoint::properties::transportMQTTSslTruststoreType";
			
			
			public static String transportMQTTSslTruststorePassword = "esb::InboundEndpoint::properties::transportMQTTSslTruststorePassword";
			
			
			public static String transportMQTTSslVersion = "esb::InboundEndpoint::properties::transportMQTTSslVersion";
			
			
			public static String wssSslKeyStoreFile = "esb::InboundEndpoint::properties::wssSslKeyStoreFile";
			
			
			public static String wssSslKeyStorePass = "esb::InboundEndpoint::properties::wssSslKeyStorePass";
			
			
			public static String wssSslTrustStoreFile = "esb::InboundEndpoint::properties::wssSslTrustStoreFile";
			
			
			public static String wssSslTrustStorePass = "esb::InboundEndpoint::properties::wssSslTrustStorePass";
			
			
			public static String wssSslCertPass = "esb::InboundEndpoint::properties::wssSslCertPass";
			
			
			public static String wsDefaultContentType = "esb::InboundEndpoint::properties::wsDefaultContentType";
			
			
			public static String wsShutdownStatusCode = "esb::InboundEndpoint::properties::wsShutdownStatusCode";
			
			
			public static String wsShutdownStatusMessage = "esb::InboundEndpoint::properties::wsShutdownStatusMessage";
			
			
			public static String wsUsePortOffset = "esb::InboundEndpoint::properties::wsUsePortOffset";
			
			
			public static String wssSslProtocols = "esb::InboundEndpoint::properties::wssSslProtocols";
			
			
			public static String wssSslCipherSuites = "esb::InboundEndpoint::properties::wssSslCipherSuites";
			
			
			public static String transportRabbitMqConsumerQos = "esb::InboundEndpoint::properties::transportRabbitMqConsumerQos";
			
			// Start of user code for transportRabbitMqConsumerQosKey ElementEditor key
			public static String transportRabbitMqConsumerQosKey = "esb::InboundEndpoint::properties::transportRabbitMqConsumerQosKey";
			// End of user code
			
			
			public static String transportRabbitMqConsumerQosType = "esb::InboundEndpoint::properties::transportRabbitMqConsumerQosType";
			
			
			public static String transportJMSDBUrl = "esb::InboundEndpoint::properties::transportJMSDBUrl";
			
			
			public static String transportRabbitMqAutoDeclare = "esb::InboundEndpoint::properties::transportRabbitMqAutoDeclare";
			
			public static String transportRabbitMqMaxDeadLetteredCount = "esb::InboundEndpoint::properties::transportRabbitMqMaxDeadLetteredCount";
			
			public static String transportRabbitMqRequeueDelay = "esb::InboundEndpoint::properties::transportRabbitMqRequeueDelay";
			
			public static String transportRabbitMqExchangeAutoDeclare = "esb::InboundEndpoint::properties::transportRabbitMqExchangeAutoDeclare";
			                      
			public static String transportRabbitMqConsumerTag = "esb::InboundEndpoint::properties::transportRabbitMqConsumerTag";
			                       
			public static String transportRabbitMqErrorQueueRoutingKey = "esb::InboundEndpoint::properties::transportRabbitMqErrorQueueRoutingKey";
			                       
			public static String transportRabbitMqErrorExchangeName = "esb::InboundEndpoint::properties::transportRabbitMqErrorExchangeName";
			                       
			public static String transportRabbitMqFactoryConnectionTimeout = "esb::InboundEndpoint::properties::transportRabbitMqFactoryConnectionTimeout";
			                       
			public static String transportRabbitMqFactoryNetworkRecoveryInterval = "esb::InboundEndpoint::properties::transportRabbitMqFactoryNetworkRecoveryInterval";
	
		}
	
	}

	/**
	 * InboundEndpointParameter view descriptor
	 * 
	 */
	public static class InboundEndpointParameter {
		public static class Properties {
	
			
			public static String name = "esb::InboundEndpointParameter::properties::name";
			
			
			public static String value = "esb::InboundEndpointParameter::properties::value";
			
	
		}
	
	}

	/**
	 * InboundEndpointContainer view descriptor
	 * 
	 */
	public static class InboundEndpointContainer {
		public static class Properties {
	
			
			public static String description = "esb::InboundEndpointContainer::properties::description";
			
			
			public static String commentsList = "esb::InboundEndpointContainer::properties::commentsList";
			
	
		}
	
	}

	/**
	 * InboundEndpointSequenceContainer view descriptor
	 * 
	 */
	public static class InboundEndpointSequenceContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * InboundEndpointOnErrorSequenceContainer view descriptor
	 * 
	 */
	public static class InboundEndpointOnErrorSequenceContainer {
		public static class Properties {
	
	
		}
	
	}

	/**
	 * InboundEndpointSequenceInputConnector view descriptor
	 * 
	 */
	public static class InboundEndpointSequenceInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::InboundEndpointSequenceInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * InboundEndpointSequenceOutputConnector view descriptor
	 * 
	 */
	public static class InboundEndpointSequenceOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::InboundEndpointSequenceOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * InboundEndpointOnErrorSequenceOutputConnector view descriptor
	 * 
	 */
	public static class InboundEndpointOnErrorSequenceOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::InboundEndpointOnErrorSequenceOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * InboundEndpointOnErrorSequenceInputConnector view descriptor
	 * 
	 */
	public static class InboundEndpointOnErrorSequenceInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::InboundEndpointOnErrorSequenceInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * CommentMediator view descriptor
	 * 
	 */
	public static class CommentMediator {
		public static class Properties {
	
			
			public static String description = "esb::CommentMediator::properties::description";
			
			
			public static String commentsList = "esb::CommentMediator::properties::commentsList";
			
			
			public static String reverse = "esb::CommentMediator::properties::Reverse";
			
			
			public static String commentText = "esb::CommentMediator::properties::commentText";
			
	
		}
	
	}

	/**
	 * JsonTransformMediator view descriptor
	 * 
	 */
	public static class JsonTransformMediator {
		public static class Properties {
	
			
			public static String commentsList = "esb::JsonTransformMediator::properties::commentsList";
			
			
			public static String reverse = "esb::JsonTransformMediator::properties::Reverse";
			
			
			public static String jsonTransformProperties = "esb::JsonTransformMediator::properties::jsonTransformProperties";
			
			
			public static String description = "esb::JsonTransformMediator::properties::description";
			
			// Start of user code for schema ElementEditor key
			public static String schema = "esb::JsonTransformMediator::properties::schema";
			// End of user code
			
	
		}
	
	}

	/**
	 * JsonTransformMediatorOutputConnector view descriptor
	 * 
	 */
	public static class JsonTransformMediatorOutputConnector {
		public static class Properties {
	
			
			public static String commentMediators = "esb::JsonTransformMediatorOutputConnector::properties::commentMediators";
			
	
		}
	
	}

	/**
	 * JsonTransformMediatorInputConnector view descriptor
	 * 
	 */
	public static class JsonTransformMediatorInputConnector {
		public static class Properties {
	
			
			public static String incomingLinks = "esb::JsonTransformMediatorInputConnector::properties::incomingLinks";
			
	
		}
	
	}

	/**
	 * JsonTransformMediatorProperty view descriptor
	 * 
	 */
	public static class JsonTransformMediatorProperty {
		public static class Properties {
	
			
			public static String propertyName = "esb::JsonTransformMediatorProperty::properties::propertyName";
			
			
			public static String propertyValue = "esb::JsonTransformMediatorProperty::properties::propertyValue";
			
	
		}
	
	}

}
