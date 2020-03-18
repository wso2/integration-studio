package org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator;

import java.util.Iterator;
import java.util.Properties;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.OMNamespaceImpl;
import org.apache.axiom.om.impl.llom.OMElementImpl;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.AggregateMediatorFactory;
import org.apache.synapse.config.xml.CallMediatorFactory;
import org.apache.synapse.config.xml.CalloutMediatorFactory;
import org.apache.synapse.config.xml.CloneMediatorFactory;
import org.apache.synapse.config.xml.ConditionalRouterMediatorFactory;
import org.apache.synapse.config.xml.DBLookupMediatorFactory;
import org.apache.synapse.config.xml.DBReportMediatorFactory;
import org.apache.synapse.config.xml.DropMediatorFactory;
import org.apache.synapse.config.xml.EnqueueMediatorFactory;
import org.apache.synapse.config.xml.EnrichMediatorFactory;
import org.apache.synapse.config.xml.FaultMediatorFactory;
import org.apache.synapse.config.xml.FilterMediatorFactory;
import org.apache.synapse.config.xml.ForEachMediatorFactory;
import org.apache.synapse.config.xml.HeaderMediatorFactory;
import org.apache.synapse.config.xml.InvokeMediatorFactory;
import org.apache.synapse.config.xml.IterateMediatorFactory;
import org.apache.synapse.config.xml.JSONTransformMediatorFactory;
import org.apache.synapse.config.xml.LogMediatorFactory;
import org.apache.synapse.config.xml.LoopBackMediatorFactory;
import org.apache.synapse.config.xml.MessageStoreMediatorFactory;
import org.apache.synapse.config.xml.PayloadFactoryMediatorFactory;
import org.apache.synapse.config.xml.PropertyGroupMediatorFactory;
import org.apache.synapse.config.xml.PropertyMediatorFactory;
import org.apache.synapse.config.xml.RespondMediatorFactory;
import org.apache.synapse.config.xml.SendMediatorFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.SwitchMediatorFactory;
import org.apache.synapse.config.xml.TransactionMediatorFactory;
import org.apache.synapse.config.xml.URLRewriteMediatorFactory;
import org.apache.synapse.config.xml.ValidateMediatorFactory;
import org.apache.synapse.config.xml.XSLTMediatorFactory;
import org.apache.synapse.mediators.spring.SpringMediatorFactory;
import org.apache.synapse.mediators.throttle.ThrottleMediatorFactory;
import org.apache.synapse.mediators.xquery.XQueryMediatorFactory;
import org.wso2.carbon.identity.entitlement.mediator.config.xml.EntitlementMediatorFactory;
import org.wso2.carbon.identity.oauth.mediator.config.xml.OAuthMediatorFactory;
import org.wso2.carbon.mediator.cache.CacheMediatorFactory;
import org.wso2.carbon.mediator.datamapper.config.xml.DataMapperMediatorFactory;
import org.wso2.carbon.mediator.event.xml.EventMediatorFactory;
import org.wso2.carbon.mediator.fastXSLT.config.xml.FastXSLTMediatorFactory;
import org.wso2.carbon.mediator.publishevent.PublishEventMediatorFactory;
import org.wso2.carbon.mediator.service.MediatorException;
import org.wso2.carbon.mediator.transform.xml.SmooksMediatorFactory;
import org.wso2.carbon.rule.mediator.RuleMediatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.BamMediatorExtFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.BeanMediatorExtFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.BuilderMediatorExtFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.ClassMediatorExtFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyPOJOCommandMediatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyScriptMediatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.EJBMediatorExtFactory;

public class MediatorValidationUtil {
    
    private static final String SYNAPSE_NAMESPACE = "http://ws.apache.org/ns/synapse";
    
    private static SequenceMediatorFactory sequenceMediatorFactory;
    private static LogMediatorFactory logMediatorFactory;
    private static EnqueueMediatorFactory enqueueMediatorFactory;
    private static SendMediatorFactory sendMediatorFactory;
    private static LoopBackMediatorFactory loopBackMediatorFactory;
    private static CallMediatorFactory callMediatorFactory;
    private static RespondMediatorFactory respondMediatorFactory;
    private static EventMediatorFactory eventMediatorFactory;
    private static DropMediatorFactory dropMediatorFactory;
    private static EnrichMediatorFactory enrichMediatorFactory;
    private static PropertyMediatorFactory propertyMediatorFactory;
    private static PropertyGroupMediatorFactory propertyGroupMediatorFactory;
    private static FilterMediatorFactory filterMediatorFactory;
    private static InvokeMediatorFactory invokeMediatorFactory;
    private static MessageStoreMediatorFactory messageStoreMediatorFactory;
    private static SwitchMediatorFactory switchMediatorFactory;
    private static ValidateMediatorFactory validateMediatorFactory;
    private static ConditionalRouterMediatorFactory conditionalRouterMediatorFactory;
    private static DummyScriptMediatorFactory scriptMediatorFactory;
    private static SpringMediatorFactory springMediatorFactory;
    private static FaultMediatorFactory faultMediatorFactory;
    private static HeaderMediatorFactory headerMediatorFactory;
    private static PayloadFactoryMediatorFactory payloadFactoryMediatorFactory;
    private static SmooksMediatorFactory smooksMediatorFactory;
    private static URLRewriteMediatorFactory urlRewriteMediatorFactory;
    private static XQueryMediatorFactory xQueryMediatorFactory;
    private static XSLTMediatorFactory xsltMediatorFactory;
    private static DataMapperMediatorFactory dataMapperMediatorFactory;
    private static FastXSLTMediatorFactory fastXSLTMediatorFactory;
    private static CacheMediatorFactory cacheMediatorFactory;
    private static DBReportMediatorFactory dbReportMediatorFactory;
    private static DBLookupMediatorFactory dbLookupMediatorFactory;
    private static ThrottleMediatorFactory throttleMediatorFactory;
    private static TransactionMediatorFactory transactionMediatorFactory;
    private static AggregateMediatorFactory aggregateMediatorFactory;
    private static CalloutMediatorFactory calloutMediatorFactory;
    private static CloneMediatorFactory cloneMediatorFactory;
    private static IterateMediatorFactory iterateMediatorFactory;
    private static ForEachMediatorFactory forEachMediatorFactory;
    private static EntitlementMediatorFactory entitlementMediatorFactory;
    private static OAuthMediatorFactory oAuthMediatorFactory;
    private static RuleMediatorFactory ruleMediatorFactory;
    private static PublishEventMediatorFactory publishEventMediatorFactory;
    private static ClassMediatorExtFactory classMediatorExtFactory;
    private static BeanMediatorExtFactory beanMediatorExtFactory;
    private static DummyPOJOCommandMediatorFactory pojoCommandMediatorFactory;
    private static EJBMediatorExtFactory ejbMediatorExtFactory;
    private static BuilderMediatorExtFactory builderMediatorExtFactory;
    private static BamMediatorExtFactory bamMediatorExtFactory;
    private static JSONTransformMediatorFactory jsonTransformMediatorFactory;

    /**
     * Validate esb mediators such as log, send, call, etc.
     * 
     * @param mediator
     *            Mediator content
     * @param qTag
     *            QName of the mediator
     * @return Error description
     */
    static String validateMediatorsFromString(String mediator, String qTag) {

        try {
            OMElement omElement = AXIOMUtil.stringToOM(mediator);
            return validateMediatorsFromOEMElement(omElement, qTag);
        } catch (Exception e) {
            // ignore
        }
        return "";

    }

    /**
     * Validate esb mediators such as log, send, call, etc.
     * 
     * @param mediator
     *            Mediator content
     * @param qTag
     *            QName of the mediator
     * @return Error description
     */
    public static String validateMediatorsFromOEMElement(OMElement omElement, String qTag) {
        try {
        	switch (qTag) {
			case "log":
				if (logMediatorFactory == null) {
                    logMediatorFactory = new LogMediatorFactory();
                }
                logMediatorFactory.createMediator(omElement, null);
				break;
			case "enqueue":
				if (enqueueMediatorFactory == null) {
                    enqueueMediatorFactory = new EnqueueMediatorFactory();
                }
                enqueueMediatorFactory.createMediator(omElement, null);
				break;
			case "send":
				if (sendMediatorFactory == null) {
                    sendMediatorFactory = new SendMediatorFactory();
                }
                sendMediatorFactory.createMediator(omElement, null);
				break;
			case "loopback":
				if (loopBackMediatorFactory == null) {
                    loopBackMediatorFactory = new LoopBackMediatorFactory();
                }
                loopBackMediatorFactory.createMediator(omElement, null);
				break;
			case "call":
				if (callMediatorFactory == null) {
                    callMediatorFactory = new CallMediatorFactory();
                }
                callMediatorFactory.createMediator(omElement, null);
				break;
			case "respond":
				if (respondMediatorFactory == null) {
                    respondMediatorFactory = new RespondMediatorFactory();
                }
                respondMediatorFactory.createMediator(omElement, null);
				break;
			case "event":
				if (eventMediatorFactory == null) {
                    eventMediatorFactory = new EventMediatorFactory();
                }
                eventMediatorFactory.createMediator(omElement, null);
				break;
			case "drop":
				if (dropMediatorFactory == null) {
                    dropMediatorFactory = new DropMediatorFactory();
                }
                dropMediatorFactory.createMediator(omElement, null);
				break;
			case "enrich":
				if (enrichMediatorFactory == null) {
                    enrichMediatorFactory = new EnrichMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));

                Iterator iterator = omElement.getChildrenWithLocalName("source");
                if (iterator.hasNext()) {
                    OMElement source = (OMElement) iterator.next();
                    source.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }

                iterator = omElement.getChildrenWithLocalName("target");
                if (iterator.hasNext()) {
                    OMElement target = (OMElement) iterator.next();
                    target.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }
                enrichMediatorFactory.createMediator(omElement, null);
				break;
			case "property":
				if (propertyMediatorFactory == null) {
                    propertyMediatorFactory = new PropertyMediatorFactory();
                }
                propertyMediatorFactory.createMediator(omElement, null);
				break;
			case "propertyGroup":
				if (propertyGroupMediatorFactory == null) {
                    propertyGroupMediatorFactory = new PropertyGroupMediatorFactory();
                }
				propertyGroupMediatorFactory.createMediator(omElement, null);
				break;
			case "filter":
				if (filterMediatorFactory == null) {
                    filterMediatorFactory = new FilterMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                filterMediatorFactory.createMediator(omElement, null);
				break;
			case "call-template":
				if (invokeMediatorFactory == null) {
                    invokeMediatorFactory = new InvokeMediatorFactory();
                }
                Iterator children = omElement.getChildrenWithLocalName("with-param");
                while (children.hasNext()) {
                    OMElement paramElement = (OMElement) children.next();
                    paramElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }
                invokeMediatorFactory.createMediator(omElement, null);
				break;
			case "sequence":
				if (sequenceMediatorFactory == null) {
                    sequenceMediatorFactory = new SequenceMediatorFactory();
                }
                sequenceMediatorFactory.createAnonymousSequence(omElement, null);
				break;
			case "store":
				if (messageStoreMediatorFactory == null) {
                    messageStoreMediatorFactory = new MessageStoreMediatorFactory();
                }
                messageStoreMediatorFactory.createMediator(omElement, null);
				break;
			case "switch":
				if (switchMediatorFactory == null) {
                    switchMediatorFactory = new SwitchMediatorFactory();
                }
                switchMediatorFactory.createMediator(omElement, null);
				break;
			case "validate":
				if (validateMediatorFactory == null) {
                    validateMediatorFactory = new ValidateMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                validateMediatorFactory.createMediator(omElement, null);
				break;
			case "conditionalRouter":
				if (conditionalRouterMediatorFactory == null) {
                    conditionalRouterMediatorFactory = new ConditionalRouterMediatorFactory();
                }
                conditionalRouterMediatorFactory.createMediator(omElement, null);
				break;
			case "bean":
				if (beanMediatorExtFactory == null) {
                    beanMediatorExtFactory = new BeanMediatorExtFactory();
                }
                beanMediatorExtFactory.createSpecificMediatorForValidation(omElement, null);
				break;
			case "class":
				if (classMediatorExtFactory == null) {
                    classMediatorExtFactory = new ClassMediatorExtFactory();
                }
                classMediatorExtFactory.createMediator(omElement, null);
				break;
			case "pojoCommand":
				if (pojoCommandMediatorFactory == null) {
                    pojoCommandMediatorFactory = new DummyPOJOCommandMediatorFactory();
                }
                Iterator pojoChildren = omElement.getChildrenWithLocalName("property");
                if (pojoChildren.hasNext()) {
                    OMElement codeElement = (OMElement) pojoChildren.next();
                    codeElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }
                pojoCommandMediatorFactory.createMediator(omElement, null);
                break;
			case "ejb":
				if (ejbMediatorExtFactory == null) {
                    ejbMediatorExtFactory = new EJBMediatorExtFactory();
                }
                ejbMediatorExtFactory.createSpecificMediatorForValidation(omElement, null);
				break;
			case "script":
				Properties properties = new Properties();
                if (scriptMediatorFactory == null) {
                    scriptMediatorFactory = new DummyScriptMediatorFactory();
                }
                scriptMediatorFactory.createMediator(omElement, properties);
				break;
			case "spring":
				if (springMediatorFactory == null) {
                    springMediatorFactory = new SpringMediatorFactory();
                }
                Iterator springChildren = omElement.getChildrenWithLocalName("spring");
                if (springChildren.hasNext()) {
                    OMElement codeElement = (OMElement) springChildren.next();
                    codeElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, "spring"));
                }
                springMediatorFactory.createMediator(omElement, null);
				break;
			case "makefault":
				if (faultMediatorFactory == null) {
                    faultMediatorFactory = new FaultMediatorFactory();
                }
                Iterator faultChildren = omElement.getChildrenWithLocalName("code");
                if (faultChildren.hasNext()) {
                    OMElement codeElement = (OMElement) faultChildren.next();
                    codeElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }
                faultChildren = omElement.getChildrenWithLocalName("reason");
                if (faultChildren.hasNext()) {
                    OMElement reasonElement = (OMElement) faultChildren.next();
                    reasonElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }
                faultMediatorFactory.createMediator(omElement, null);
				break;
			case "header":
				if (headerMediatorFactory == null) {
                    headerMediatorFactory = new HeaderMediatorFactory();
                }
                headerMediatorFactory.createMediator(omElement, null);
				break;
			case "payloadFactory":
				if (payloadFactoryMediatorFactory == null) {
                    payloadFactoryMediatorFactory = new PayloadFactoryMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                Iterator payloadChildren = omElement.getChildrenWithLocalName("format");
                if (payloadChildren.hasNext()) {
                    OMElement formatElement = (OMElement) payloadChildren.next();
                    formatElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }
                Iterator agrs = omElement.getChildrenWithLocalName("args");
                if (agrs.hasNext()) {
                    OMElement argElement = (OMElement) agrs.next();
                    argElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }
                payloadFactoryMediatorFactory.createMediator(omElement, null);
				break;
			case "smooks":
				if (smooksMediatorFactory == null) {
                    smooksMediatorFactory = new SmooksMediatorFactory();
                }
                smooksMediatorFactory.createMediator(omElement, null);
				break;
			case "rewrite":
				if (urlRewriteMediatorFactory == null) {
                    urlRewriteMediatorFactory = new URLRewriteMediatorFactory();
                }
                urlRewriteMediatorFactory.createMediator(omElement, null);
				break;
			case "xquery":
				if (xQueryMediatorFactory == null) {
                    xQueryMediatorFactory = new XQueryMediatorFactory();
                }
                xQueryMediatorFactory.createMediator(omElement, null);
				break;
			case "xslt":
				if (xsltMediatorFactory == null) {
                    xsltMediatorFactory = new XSLTMediatorFactory();
                }
                xsltMediatorFactory.createMediator(omElement, null);
				break;
			case "datamapper":
				if (dataMapperMediatorFactory == null) {
                    dataMapperMediatorFactory = new DataMapperMediatorFactory();
                }
                dataMapperMediatorFactory.createMediator(omElement, null);
				break;
			case "fastXSLT":
				if (fastXSLTMediatorFactory == null) {
                    fastXSLTMediatorFactory = new FastXSLTMediatorFactory();
                }
                fastXSLTMediatorFactory.createMediator(omElement, null);
				break;
			case "cache":
				if (cacheMediatorFactory == null) {
                    cacheMediatorFactory = new CacheMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                cacheMediatorFactory.createMediator(omElement, null);
				break;
			case "dbreport":
				if (dbReportMediatorFactory == null) {
                    dbReportMediatorFactory = new DBReportMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                dbReportMediatorFactory.createMediator(omElement, null);
				break;
			case "dblookup":
				if (dbLookupMediatorFactory == null) {
                    dbLookupMediatorFactory = new DBLookupMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                dbLookupMediatorFactory.createMediator(omElement, null);
				break;
			case "throttle":
				if (throttleMediatorFactory == null) {
                    throttleMediatorFactory = new ThrottleMediatorFactory();
                }
                throttleMediatorFactory.createMediator(omElement, null);
				break;
			case "transaction":
				if (transactionMediatorFactory == null) {
                    transactionMediatorFactory = new TransactionMediatorFactory();
                }
                transactionMediatorFactory.createMediator(omElement, null);
				break;
			case "aggregate":
				if (aggregateMediatorFactory == null) {
                    aggregateMediatorFactory = new AggregateMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                aggregateMediatorFactory.createMediator(omElement, null);
				break;
			case "callout":
				if (calloutMediatorFactory == null) {
                    calloutMediatorFactory = new CalloutMediatorFactory();
                }
                calloutMediatorFactory.createMediator(omElement, null);
				break;
			case "clone":
				if (cloneMediatorFactory == null) {
                    cloneMediatorFactory = new CloneMediatorFactory();
                }
                cloneMediatorFactory.createMediator(omElement, null);
				break;
			case "iterate":
				if (iterateMediatorFactory == null) {
                    iterateMediatorFactory = new IterateMediatorFactory();
                }
                Iterator iteratorChildren = omElement.getChildrenWithLocalName("target");
                if (iteratorChildren.hasNext()) {
                    OMElement source = (OMElement) iteratorChildren.next();
                    source.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                }
                iterateMediatorFactory.createMediator(omElement, null);
				break;
			case "foreach":
				if (forEachMediatorFactory == null) {
                    forEachMediatorFactory = new ForEachMediatorFactory();
                }
                forEachMediatorFactory.createMediator(omElement, null);
				break;
			case "entitlementService":
				if (entitlementMediatorFactory == null) {
                    entitlementMediatorFactory = new EntitlementMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                entitlementMediatorFactory.createMediator(omElement, null);
				break;
			case "oauthService":
				if (oAuthMediatorFactory == null) {
                    oAuthMediatorFactory = new OAuthMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                oAuthMediatorFactory.createMediator(omElement, null);
				break;
			case "builder":
				if (builderMediatorExtFactory == null) {
                    builderMediatorExtFactory = new BuilderMediatorExtFactory();
                }
                builderMediatorExtFactory.createMediator(omElement, null);
				break;
			case "rule":
				if (ruleMediatorFactory == null) {
                    ruleMediatorFactory = new RuleMediatorFactory();
                }
                ruleMediatorFactory.createMediator(omElement, null);
				break;
			case "bam":
				if (bamMediatorExtFactory == null) {
                    bamMediatorExtFactory = new BamMediatorExtFactory();
                }
                bamMediatorExtFactory.createMediator(omElement, null);
				break;
			case "publishEvent":
				if (publishEventMediatorFactory == null) {
                    publishEventMediatorFactory = new PublishEventMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                publishEventMediatorFactory.createMediator(omElement, null);
				break;
			case "jsontransform":
			    if (jsonTransformMediatorFactory == null) {
			        jsonTransformMediatorFactory = new JSONTransformMediatorFactory();
			    }
			    setNamespaceForChildren(omElement);
			    jsonTransformMediatorFactory.createMediator(omElement, null);
			    break;
			default:
				break;
			}

        } catch (SynapseException | MediatorException e) {
            return e.getMessage();
        }
        return "";
    }

    /**
     * Set the namespace for all the child elements
     * 
     * @param omElement
     *            Root element
     */
    private static void setNamespaceForChildren(OMElement omElement) {
        Iterator childern = omElement.getChildren();
        OMElement currentElement = null;
        while (childern.hasNext()) {
            Object child = childern.next();
            if (child instanceof OMElementImpl) {
                currentElement = (OMElement) child;
                currentElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                if (currentElement.getChildren().hasNext()) {
                    setNamespaceForChildren(currentElement);
                }

            }
        }
    }

}