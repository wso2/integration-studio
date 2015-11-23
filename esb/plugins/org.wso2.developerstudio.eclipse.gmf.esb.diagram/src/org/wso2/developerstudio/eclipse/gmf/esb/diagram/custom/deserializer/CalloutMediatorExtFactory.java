package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorFactory;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.builtin.CalloutMediator;
import org.jaxen.JaxenException;

import javax.xml.namespace.QName;
import java.io.File;
import java.util.Properties;

/**
 * Factory for {@link CalloutMediator} instances.
 * 
 * <pre>
 * &lt;callout serviceURL="string" | endpointKey="string" [action="string"]&gt;
 *      &lt;configuration [axis2xml="string"] [repository="string"]/&gt;?
 *      &lt;source xpath="expression" | key="string" | type="envelope"&gt;
 *      &lt;target xpath="expression" | key="string"/&gt;
 *      &lt;enableSec policy="string" | outboundPolicy="String" | inboundPolicy="String" /&gt;?
 * &lt;/callout&gt;
 * </pre>
 */
public class CalloutMediatorExtFactory extends AbstractMediatorFactory{

    private static final QName TAG_NAME
        = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "callout");
    private static final QName ATT_URL = new QName("serviceURL");
    private static final QName ATT_ENDPOINT = new QName("endpointKey");
    private static final QName ATT_ACTION = new QName("action");
    private static final QName ATT_AXIS2XML = new QName("axis2xml");
    private static final QName ATT_USESERVERCONFIG = new QName("useServerConfig");
    private static final QName ATT_REPOSITORY = new QName("repository");
    private static final QName ATT_INIT_AXI2_CLIENT_OPTIONS = new QName("initAxis2ClientOptions");
    private static final QName Q_CONFIG
            = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "configuration");
    private static final QName Q_SOURCE
            = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "source");
    private static final QName Q_TARGET
            = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "target");
    private static final QName ATT_SOURCE_TYPE
            = new QName(XMLConfigConstants.NULL_NAMESPACE, "type");
    private static final QName Q_SEC
            = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "enableSec");
    private static final QName ATT_POLICY
            = new QName(XMLConfigConstants.NULL_NAMESPACE, "policy");
    private static final QName ATT_OUTBOUND_SEC_POLICY
                = new QName(XMLConfigConstants.NULL_NAMESPACE, "outboundPolicy");
    private static final QName ATT_INBOUND_SEC_POLICY
                = new QName(XMLConfigConstants.NULL_NAMESPACE, "inboundPolicy");

    public Mediator createSpecificMediator(OMElement elem, Properties properties) {

        CalloutMediator callout = new CalloutMediator();

        OMAttribute attServiceURL = elem.getAttribute(ATT_URL);
        OMAttribute attEndpoint = elem.getAttribute(ATT_ENDPOINT);
        OMAttribute attAction     = elem.getAttribute(ATT_ACTION);
        OMAttribute attUseServerConfig = elem.getAttribute(ATT_USESERVERCONFIG);
        OMAttribute initAxis2ClientOptions = elem.getAttribute(ATT_INIT_AXI2_CLIENT_OPTIONS);
        OMElement   configElt     = elem.getFirstChildWithName(Q_CONFIG);
        OMElement   sourceElt     = elem.getFirstChildWithName(Q_SOURCE);
        OMElement   targetElt     = elem.getFirstChildWithName(Q_TARGET);
        OMElement wsSec = elem.getFirstChildWithName(Q_SEC);

        if (attServiceURL != null) {
            callout.setServiceURL(attServiceURL.getAttributeValue());
        } else if (attEndpoint != null) {
            callout.setEndpointKey(attEndpoint.getAttributeValue());
        }

        if (attAction != null) {
            callout.setAction(attAction.getAttributeValue());
        }
        
        if (attUseServerConfig != null) {
        	callout.setUseServerConfig(attUseServerConfig.getAttributeValue());
        }

        if (initAxis2ClientOptions != null) {
            if("true".equals(initAxis2ClientOptions.getAttributeValue().toLowerCase())){
                callout.setInitClientOptions(true);
            } else if ("false".equals(initAxis2ClientOptions.getAttributeValue().toLowerCase())){
                callout.setInitClientOptions(false);
            }
        }

        if (configElt != null) {

            OMAttribute axis2xmlAttr = configElt.getAttribute(ATT_AXIS2XML);
            OMAttribute repoAttr = configElt.getAttribute(ATT_REPOSITORY);

            if (axis2xmlAttr != null && axis2xmlAttr.getAttributeValue() != null) {
            	callout.setAxis2xml(axis2xmlAttr.getAttributeValue());
            }

            if (repoAttr != null && repoAttr.getAttributeValue() != null) {
            	  callout.setClientRepository(repoAttr.getAttributeValue());
               
            }
        }

        if (sourceElt != null) {
            OMAttribute sourceType = sourceElt.getAttribute(ATT_SOURCE_TYPE);

            if (sourceType != null && sourceType.getAttributeValue().equals("envelope")) {
                callout.setUseEnvelopeAsSource(true);
            } else if (sourceElt.getAttribute(ATT_XPATH) != null) {
                try {
                    callout.setRequestXPath(
                            SynapseXPathFactory.getSynapseXPath(sourceElt, ATT_XPATH));
                } catch (JaxenException e) {
                    handleException("Invalid source XPath : "
                                    + sourceElt.getAttributeValue(ATT_XPATH));
                }
            } else if (sourceElt.getAttribute(ATT_KEY) != null) {
                callout.setRequestKey(sourceElt.getAttributeValue(ATT_KEY));
            } else {
                handleException("A 'xpath' or 'key' attribute " +
                                "is required for the Callout 'source'");
            }
        } else {
            handleException("The message 'source' must be specified for a Callout mediator");
        }

        if (targetElt != null) {
            if (targetElt.getAttribute(ATT_XPATH) != null) {
                try {
                    callout.setTargetXPath(
                        SynapseXPathFactory.getSynapseXPath(targetElt, ATT_XPATH));
                } catch (JaxenException e) {
                    handleException("Invalid target XPath : "
                        + targetElt.getAttributeValue(ATT_XPATH));
                }
            } else if (targetElt.getAttribute(ATT_KEY) != null) {
                callout.setTargetKey(targetElt.getAttributeValue(ATT_KEY));
            } else {
                handleException("A 'xpath' or 'key' attribute " +
                    "is required for the Callout 'target'");
            }
        } else {
            handleException("The message 'target' must be specified for a Callout mediator");
        }

        if (wsSec != null) {
            callout.setSecurityOn(true);
            OMAttribute policyKey = wsSec.getAttribute(ATT_POLICY);
            OMAttribute outboundPolicyKey = wsSec.getAttribute(ATT_OUTBOUND_SEC_POLICY);
            OMAttribute inboundPolicyKey = wsSec.getAttribute(ATT_INBOUND_SEC_POLICY);
            if (policyKey != null) {
                callout.setWsSecPolicyKey(policyKey.getAttributeValue());
            } else if (outboundPolicyKey != null || inboundPolicyKey != null){
                if (outboundPolicyKey != null) {
                    callout.setOutboundWsSecPolicyKey(outboundPolicyKey.getAttributeValue());
                }
                if (inboundPolicyKey != null) {
                    callout.setInboundWsSecPolicyKey(inboundPolicyKey.getAttributeValue());
                }
            } else {
                callout.setSecurityOn(false);
                handleException("A policy key is required to enable security");
            }
        }

        return callout;
    }

    public QName getTagQName() {
        return TAG_NAME;
    }
}
