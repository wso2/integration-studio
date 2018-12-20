package org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator;

import java.util.Iterator;
import java.util.Properties;

import javax.xml.stream.XMLStreamException;

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
import org.apache.synapse.config.xml.LogMediatorFactory;
import org.apache.synapse.config.xml.LoopBackMediatorFactory;
import org.apache.synapse.config.xml.MessageStoreMediatorFactory;
import org.apache.synapse.config.xml.PayloadFactoryMediatorFactory;
import org.apache.synapse.config.xml.PropertyMediatorFactory;
import org.apache.synapse.config.xml.RespondMediatorFactory;
import org.apache.synapse.config.xml.SendMediatorFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.SwitchMediatorFactory;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.config.xml.TransactionMediatorFactory;
import org.apache.synapse.config.xml.URLRewriteMediatorFactory;
import org.apache.synapse.config.xml.ValidateMediatorFactory;
import org.apache.synapse.config.xml.XSLTMediatorFactory;
import org.apache.synapse.mediators.bsf.ScriptMediatorFactory;
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
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.EJBMediatorExtFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.POJOCommandMediatorExtFactory;

public class MediatorValidationUtil {
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
    private static FilterMediatorFactory filterMediatorFactory;
    private static InvokeMediatorFactory invokeMediatorFactory;
    private static MessageStoreMediatorFactory messageStoreMediatorFactory;
    private static SwitchMediatorFactory switchMediatorFactory;
    private static ValidateMediatorFactory validateMediatorFactory;
    private static ConditionalRouterMediatorFactory conditionalRouterMediatorFactory;
    private static ScriptMediatorFactory scriptMediatorFactory;
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
    private static POJOCommandMediatorExtFactory pojoCommandMediatorExtFactory;
    private static EJBMediatorExtFactory ejbMediatorExtFactory;
    private static BuilderMediatorExtFactory builderMediatorExtFactory;
    private static BamMediatorExtFactory bamMediatorExtFactory;

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
        } catch (XMLStreamException e) {
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
            if (qTag.equals("log")) {
                if (logMediatorFactory == null) {
                    logMediatorFactory = new LogMediatorFactory();
                }
                logMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("enqueue")) {
                if (enqueueMediatorFactory == null) {
                    enqueueMediatorFactory = new EnqueueMediatorFactory();
                }
                enqueueMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("send")) {
                if (sendMediatorFactory == null) {
                    sendMediatorFactory = new SendMediatorFactory();
                }
                sendMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("loopback")) {
                if (loopBackMediatorFactory == null) {
                    loopBackMediatorFactory = new LoopBackMediatorFactory();
                }
                loopBackMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("call")) {
                if (callMediatorFactory == null) {
                    callMediatorFactory = new CallMediatorFactory();
                }
                callMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("respond")) {
                if (respondMediatorFactory == null) {
                    respondMediatorFactory = new RespondMediatorFactory();
                }
                respondMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("event")) {
                if (eventMediatorFactory == null) {
                    eventMediatorFactory = new EventMediatorFactory();
                }
                eventMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("drop")) {
                if (dropMediatorFactory == null) {
                    dropMediatorFactory = new DropMediatorFactory();
                }
                dropMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("enrich")) {
                if (enrichMediatorFactory == null) {
                    enrichMediatorFactory = new EnrichMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));

                Iterator iterator = omElement.getChildrenWithLocalName("source");
                if (iterator.hasNext()) {
                    OMElement source = (OMElement) iterator.next();
                    source.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                }

                iterator = omElement.getChildrenWithLocalName("target");
                if (iterator.hasNext()) {
                    OMElement target = (OMElement) iterator.next();
                    target.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                }
                enrichMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("property")) {
                if (propertyMediatorFactory == null) {
                    propertyMediatorFactory = new PropertyMediatorFactory();
                }
                propertyMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("filter")) {
                if (filterMediatorFactory == null) {
                    filterMediatorFactory = new FilterMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                filterMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("call-template")) {
                if (invokeMediatorFactory == null) {
                    invokeMediatorFactory = new InvokeMediatorFactory();
                }
                invokeMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("sequence")) {
                if (sequenceMediatorFactory == null) {
                    sequenceMediatorFactory = new SequenceMediatorFactory();
                }
                sequenceMediatorFactory.createAnonymousSequence(omElement, null);

            } else if (qTag.equals("store")) {
                if (messageStoreMediatorFactory == null) {
                    messageStoreMediatorFactory = new MessageStoreMediatorFactory();
                }
                messageStoreMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("switch")) {
                if (switchMediatorFactory == null) {
                    switchMediatorFactory = new SwitchMediatorFactory();
                }
                switchMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("validate")) {
                if (validateMediatorFactory == null) {
                    validateMediatorFactory = new ValidateMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                validateMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("conditionalRouter")) {
                if (conditionalRouterMediatorFactory == null) {
                    conditionalRouterMediatorFactory = new ConditionalRouterMediatorFactory();
                }
                conditionalRouterMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("bean")) {
                if (beanMediatorExtFactory == null) {
                    beanMediatorExtFactory = new BeanMediatorExtFactory();
                }
                beanMediatorExtFactory.createSpecificMediatorForValidation(omElement, null);

            } else if (qTag.equals("class")) {
                if (classMediatorExtFactory == null) {
                    classMediatorExtFactory = new ClassMediatorExtFactory();
                }
                classMediatorExtFactory.createMediator(omElement, null);

            } else if (qTag.equals("pojoCommand")) {
                if (pojoCommandMediatorExtFactory == null) {
                    pojoCommandMediatorExtFactory = new POJOCommandMediatorExtFactory();
                }
                pojoCommandMediatorExtFactory.createMediator(omElement, null);

            } else if (qTag.equals("ejb")) {
                if (ejbMediatorExtFactory == null) {
                    ejbMediatorExtFactory = new EJBMediatorExtFactory();
                }
                ejbMediatorExtFactory.createSpecificMediatorForValidation(omElement, null);

            } else if (qTag.equals("script")) {
                Properties properties = new Properties();
                if (scriptMediatorFactory == null) {
                    scriptMediatorFactory = new ScriptMediatorFactory();
                }
                scriptMediatorFactory.createMediator(omElement, properties);

            } else if (qTag.equals("spring")) {
                if (springMediatorFactory == null) {
                    springMediatorFactory = new SpringMediatorFactory();
                }
                Iterator children = omElement.getChildrenWithLocalName("spring");
                if (children.hasNext()) {
                    OMElement codeElement = (OMElement) children.next();
                    codeElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", "spring"));
                }
                springMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("makefault")) {
                if (faultMediatorFactory == null) {
                    faultMediatorFactory = new FaultMediatorFactory();
                }
                Iterator children = omElement.getChildrenWithLocalName("code");
                if (children.hasNext()) {
                    OMElement codeElement = (OMElement) children.next();
                    codeElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                }

                children = omElement.getChildrenWithLocalName("reason");
                if (children.hasNext()) {
                    OMElement reasonElement = (OMElement) children.next();
                    reasonElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                }

                faultMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("header")) {
                if (headerMediatorFactory == null) {
                    headerMediatorFactory = new HeaderMediatorFactory();
                }
                headerMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("payloadFactory")) {
                if (payloadFactoryMediatorFactory == null) {
                    payloadFactoryMediatorFactory = new PayloadFactoryMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                Iterator children = omElement.getChildrenWithLocalName("format");
                if (children.hasNext()) {
                    OMElement formatElement = (OMElement) children.next();
                    formatElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                }

                payloadFactoryMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("smooks")) {
                if (smooksMediatorFactory == null) {
                    smooksMediatorFactory = new SmooksMediatorFactory();
                }
                smooksMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("rewrite")) {
                if (urlRewriteMediatorFactory == null) {
                    urlRewriteMediatorFactory = new URLRewriteMediatorFactory();
                }
                urlRewriteMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("xquery")) {
                if (xQueryMediatorFactory == null) {
                    xQueryMediatorFactory = new XQueryMediatorFactory();
                }
                xQueryMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("xslt")) {
                if (xsltMediatorFactory == null) {
                    xsltMediatorFactory = new XSLTMediatorFactory();
                }
                xsltMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("datamapper")) {
                if (dataMapperMediatorFactory == null) {
                    dataMapperMediatorFactory = new DataMapperMediatorFactory();
                }
                dataMapperMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("fastXSLT")) {
                if (fastXSLTMediatorFactory == null) {
                    fastXSLTMediatorFactory = new FastXSLTMediatorFactory();
                }
                fastXSLTMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("cache")) {
                if (cacheMediatorFactory == null) {
                    cacheMediatorFactory = new CacheMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                cacheMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("dbreport")) {
                if (dbReportMediatorFactory == null) {
                    dbReportMediatorFactory = new DBReportMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                dbReportMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("dblookup")) {
                if (dbLookupMediatorFactory == null) {
                    dbLookupMediatorFactory = new DBLookupMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                dbLookupMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("throttle")) {
                if (throttleMediatorFactory == null) {
                    throttleMediatorFactory = new ThrottleMediatorFactory();
                }
                throttleMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("transaction")) {
                if (transactionMediatorFactory == null) {
                    transactionMediatorFactory = new TransactionMediatorFactory();
                }
                transactionMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("aggregate")) {
                if (aggregateMediatorFactory == null) {
                    aggregateMediatorFactory = new AggregateMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                aggregateMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("callout")) {
                if (calloutMediatorFactory == null) {
                    calloutMediatorFactory = new CalloutMediatorFactory();
                }
                calloutMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("clone")) {
                if (cloneMediatorFactory == null) {
                    cloneMediatorFactory = new CloneMediatorFactory();
                }
                cloneMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("iterate")) {
                if (iterateMediatorFactory == null) {
                    iterateMediatorFactory = new IterateMediatorFactory();
                }
                Iterator iterator = omElement.getChildrenWithLocalName("target");
                if (iterator.hasNext()) {
                    OMElement source = (OMElement) iterator.next();
                    source.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                }
                iterateMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("foreach")) {
                if (forEachMediatorFactory == null) {
                    forEachMediatorFactory = new ForEachMediatorFactory();
                }
                forEachMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("entitlementService")) {
                if (entitlementMediatorFactory == null) {
                    entitlementMediatorFactory = new EntitlementMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                entitlementMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("oauthService")) {
                if (oAuthMediatorFactory == null) {
                    oAuthMediatorFactory = new OAuthMediatorFactory();
                }
                omElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                oAuthMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("builder")) {
                if (builderMediatorExtFactory == null) {
                    builderMediatorExtFactory = new BuilderMediatorExtFactory();
                }
                builderMediatorExtFactory.createMediator(omElement, null);

            } else if (qTag.equals("rule")) {
                if (ruleMediatorFactory == null) {
                    ruleMediatorFactory = new RuleMediatorFactory();
                }
                ruleMediatorFactory.createMediator(omElement, null);

            } else if (qTag.equals("bam")) {
                if (bamMediatorExtFactory == null) {
                    bamMediatorExtFactory = new BamMediatorExtFactory();
                }
                bamMediatorExtFactory.createMediator(omElement, null);

            } else if (qTag.equals("publishEvent")) {
                if (publishEventMediatorFactory == null) {
                    publishEventMediatorFactory = new PublishEventMediatorFactory();
                }
                setNamespaceForChildren(omElement);
                publishEventMediatorFactory.createMediator(omElement, null);

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
                currentElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                if (currentElement.getChildren().hasNext()) {
                    setNamespaceForChildren(currentElement);
                }

            }
        }
    }

}