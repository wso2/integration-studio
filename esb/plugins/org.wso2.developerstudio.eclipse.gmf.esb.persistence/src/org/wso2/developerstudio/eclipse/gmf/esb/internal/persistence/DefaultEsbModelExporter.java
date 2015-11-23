/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.util.XMLPrettyPrinter;
import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.config.xml.EntrySerializer;
import org.apache.synapse.config.xml.MediatorSerializerFinder;
import org.apache.synapse.config.xml.ProxyServiceSerializer;
import org.apache.synapse.config.xml.SequenceMediatorSerializer;
import org.apache.synapse.config.xml.SynapseXMLConfigurationSerializer;
import org.apache.synapse.config.xml.endpoints.EndpointSerializer;
import org.apache.synapse.config.xml.endpoints.TemplateSerializer;
import org.apache.synapse.config.xml.inbound.InboundEndpointSerializer;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.apache.synapse.rest.API;
import org.apache.synapse.task.TaskDescriptionSerializer;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStore;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.gmf.esb.Task;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomAPISerializer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbModelTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Default implementation of {@link EsbModelTransformer}.
 */
public class DefaultEsbModelExporter implements EsbModelTransformer {
	static String sourceXML= new String();
	/**
	 * {@inheritDoc}
	 */
	public void export(Resource resource, File destination) throws Exception {
		Assert.isTrue(resource.getContents().size() == 1,
				"Resource should have exactly one root object.");
		EObject rootObj = resource.getContents().get(0);
		Assert.isTrue(rootObj instanceof EsbDiagram, "Unknown diagram object.");
		EsbDiagram esbDiagram = (EsbDiagram) rootObj;
		EsbServer server = esbDiagram.getServer();
		Assert.isTrue(null != server,
				"Unable to locate esb server visual model object.");
		export(server, destination);
	}

	/**
	 * Exports the given {@link EsbServer} visual model into specified
	 * destination.
	 * 
	 * @param serverModel
	 *            {@link EsbServer} visual model instance.
	 * @param destination
	 *            target file.
	 * @throws Exception
	 *             if an error occurs during export operation.
	 */
	private void export(EsbServer serverModel, File destination)
			throws Exception {
		SynapseXMLConfigurationSerializer serializer = new SynapseXMLConfigurationSerializer();
		OMElement configOM = serializer
				.serializeConfiguration(transform(serverModel));
		OutputStream os = new FileOutputStream(destination);
		XMLPrettyPrinter.prettify(configOM, os);
	}

	/**
	 * Transforms the given {@link EsbServer} visual model into a
	 * {@link SynapseConfiguration} object.
	 * 
	 * @param serverModel
	 *            {@link EsbServer} visual model.
	 * @return configured {@link SynapseConfiguration} object.
	 * @throws Exception
	 *             if an error occurs during transformation.
	 */
	private SynapseConfiguration transform(EsbServer serverModel)
			throws Exception {
		SynapseConfiguration configuration = new SynapseConfiguration();
		TransformationInfo info = new TransformationInfo();
		info.getTransformedMediators().clear();
		info.setSynapseConfiguration(configuration);
		
		//message  mediation
		MessageMediator messageMed = serverModel.getMessageMediator();
		if (messageMed!=null) {
			MessageMediatorTransformer transformer = new MessageMediatorTransformer();
			info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
			transformer.transform(info, messageMed);
		}
		
		List<EsbElement> childNodes = serverModel.getChildren();
		int startupCount=-1;
		for (EsbElement childNode : childNodes) {
			
			// service mediation.
			if (childNode instanceof ProxyService) {
				ProxyService visualService = (ProxyService) childNode;
				ProxyServiceTransformer transformer = new ProxyServiceTransformer();
				info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
				transformer.transform(info, visualService);
			}
			
			
			if(childNode instanceof Task){
				++startupCount;
				Task task=(Task) childNode;		
				TaskTransformer transformer=new TaskTransformer();
				transformer.transform(info,task,startupCount);
			}
			
			
		}
		return configuration;
	}
	
	private SequenceMediator transformSequence(EsbServer serverModel)
			throws Exception {
		List<EsbElement> childNodes = serverModel.getChildren();
		SequenceMediator sequence = new SequenceMediator();		
		TransformationInfo info = new TransformationInfo();
		info.getTransformedMediators().clear();
		for (EsbElement childNode : childNodes) {
			if (childNode instanceof Sequences) {
				Sequences visualSequence = (Sequences) childNode;
				sequence.setName(visualSequence.getName());
				SequenceTransformer transformer = new SequenceTransformer();
				transformer.transformWithinSequence(info, visualSequence,
						sequence);
			}
		}
		return sequence;
	}
	
	private org.apache.synapse.core.axis2.ProxyService transformProxyService(
			ProxyService visualService ) throws Exception {
		TransformationInfo info = new TransformationInfo();
		info.getTransformedMediators().clear();
		SynapseConfiguration configuration = new SynapseConfiguration();;
		info.setSynapseConfiguration(configuration);
		org.apache.synapse.core.axis2.ProxyService proxy = new org.apache.synapse.core.axis2.ProxyService(
				visualService.getName());
		ProxyServiceTransformer transformer = new ProxyServiceTransformer();
		info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
		transformer.transform(info, visualService );
		org.apache.synapse.core.axis2.ProxyService proxyService = configuration.getProxyService(visualService.getName());
		if(proxyService!=null){
			proxy = proxyService;
		}
		return proxy;
	}
	
	
	private org.apache.synapse.endpoints.Endpoint transformEndpoint(
			EndpointDiagram visualEndpoint ) throws Exception {		
		if(((EndpointDiagram) visualEndpoint).getChild() instanceof WSDLEndPoint){
			WSDLEndPointTransformer transformer= new WSDLEndPointTransformer();
			return transformer.create((WSDLEndPoint) ((EndpointDiagram) visualEndpoint).getChild(),visualEndpoint.getName());
		}else if(((EndpointDiagram) visualEndpoint).getChild() instanceof DefaultEndPoint){
			DefaultEndPointTransformer transformer= new DefaultEndPointTransformer();
			return transformer.create((DefaultEndPoint) ((EndpointDiagram) visualEndpoint).getChild(),visualEndpoint.getName());
		}else if(((EndpointDiagram) visualEndpoint).getChild() instanceof AddressEndPoint){
			AddressEndPointTransformer transformer= new AddressEndPointTransformer();
			return transformer.create((AddressEndPoint) ((EndpointDiagram) visualEndpoint).getChild(),visualEndpoint.getName());
		}else if(((EndpointDiagram) visualEndpoint).getChild() instanceof FailoverEndPoint){
			FailoverEndPointTransformer transformer= new FailoverEndPointTransformer();
			return transformer.create(new TransformationInfo(),(FailoverEndPoint) ((EndpointDiagram) visualEndpoint).getChild(),visualEndpoint.getName(),null);
		}else if(((EndpointDiagram) visualEndpoint).getChild() instanceof LoadBalanceEndPoint){
			LoadBalanceEndPointTransformer transformer= new LoadBalanceEndPointTransformer();
			return transformer.create(new TransformationInfo(),(LoadBalanceEndPoint) ((EndpointDiagram) visualEndpoint).getChild(),visualEndpoint.getName(),null);
		} else if (((EndpointDiagram) visualEndpoint).getChild() instanceof RecipientListEndPoint) {
			RecipientListEndPointTransformer transformer = new RecipientListEndPointTransformer();
			return transformer.create(new TransformationInfo(),
					(RecipientListEndPoint) ((EndpointDiagram) visualEndpoint).getChild(),
					visualEndpoint.getName(), null);
		}else if(((EndpointDiagram) visualEndpoint).getChild() instanceof TemplateEndpoint){
			TemplateEndPointTransformer transformer= new TemplateEndPointTransformer();
			return transformer.create((TemplateEndpoint) ((EndpointDiagram) visualEndpoint).getChild(),visualEndpoint.getName());
		}else if(((EndpointDiagram) visualEndpoint).getChild() instanceof HTTPEndpoint){
			HTTPEndPointTransformer transformer= new HTTPEndPointTransformer();
			return transformer.create((HTTPEndpoint) ((EndpointDiagram) visualEndpoint).getChild(),visualEndpoint.getName());
		}else{
			return null;
		}		
	}
	
	private org.apache.synapse.config.Entry transformLocalEntry(
			LocalEntry visualLocalEntry ) throws Exception {	
		LocalEntryTransformer transformer=new LocalEntryTransformer();
		return transformer.createEntry(visualLocalEntry);
	}	
	
	private org.apache.synapse.task.TaskDescription transformTask(Task visualTask){
		TaskTransformer transformer= new TaskTransformer();
		return transformer.create(visualTask);
	}
	
	private org.apache.synapse.rest.API transformAPI(SynapseAPI visualAPI) throws Exception{		
		TransformationInfo info = new TransformationInfo();
		info.getTransformedMediators().clear();
		SynapseConfiguration configuration = new SynapseConfiguration();;
		info.setSynapseConfiguration(configuration);
		API api=null;
		APITransformer transformer= new APITransformer();
		info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
		transformer.transform(info, visualAPI );
		api=configuration.getAPI(visualAPI.getApiName());
		if(api!=null){
			return api;
		}
		return new API(visualAPI.getApiName(), visualAPI.getContext());
	}
	
	private TemplateMediator transformSequenceTemplate(Template template ) throws Exception{
		TransformationInfo info = new TransformationInfo();
		info.getTransformedMediators().clear();
		SynapseConfiguration configuration = new SynapseConfiguration();
		info.setSynapseConfiguration(configuration);
		TemplateMediator templateMediator = new TemplateMediator();
		templateMediator.setName(template.getName());
		templateMediator.setParameters(new ArrayList<String>());
		TemplateTransformer transformer = new TemplateTransformer();
		info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
		transformer.transform(info, template);
		TemplateMediator mediator = configuration.getSequenceTemplate(template.getName());
		if (mediator != null) {
			templateMediator = mediator;
		}
		return templateMediator;
	}
	
	private org.apache.synapse.endpoints.Template transformEndpointTemplate(Template template) throws Exception{
		TransformationInfo info = new TransformationInfo();
		info.getTransformedMediators().clear();
		SynapseConfiguration configuration = new SynapseConfiguration();
		info.setSynapseConfiguration(configuration);
		org.apache.synapse.endpoints.Template epTemplate = new org.apache.synapse.endpoints.Template();
		epTemplate.setName(template.getName());

		TemplateTransformer transformer = new TemplateTransformer();
		info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
		transformer.transform(info, template);
		org.apache.synapse.endpoints.Template endpointTemplate = configuration
				.getEndpointTemplate(template.getName());
		if (endpointTemplate != null) {
			epTemplate = endpointTemplate;
		}
		return epTemplate;
	}
	
	private SequenceMediator transformMainSequence(ProxyService visualService) throws Exception{
		TransformationInfo info = new TransformationInfo();
		info.getTransformedMediators().clear();
		SynapseConfiguration configuration = new SynapseConfiguration();
		info.setSynapseConfiguration(configuration);
		ProxyServiceTransformer transformer = new ProxyServiceTransformer();
		info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
		transformer.transform(info, visualService );
		return info.getMainSequence();
	}
	
    private org.apache.synapse.inbound.InboundEndpoint transformInbundEndpoint(InboundEndpoint visualInboundEndpoint) throws Exception{
        TransformationInfo info = new TransformationInfo();
        info.getTransformedMediators().clear();
        SynapseConfiguration configuration = new SynapseConfiguration();
        info.setSynapseConfiguration(configuration);
        InboundEndpointTransformer transformer = new InboundEndpointTransformer();
        transformer.transform(info, visualInboundEndpoint);
        org.apache.synapse.inbound.InboundEndpoint inboundEndpoint = configuration.getInboundEndpoint(visualInboundEndpoint.getName());
        return inboundEndpoint;
    }

	public String designToSource(EsbServer serverModel) throws Exception {
		SynapseXMLConfigurationSerializer serializer = new SynapseXMLConfigurationSerializer();
		SequenceMediatorSerializer sequenceSerializer = new SequenceMediatorSerializer();
		OMElement configOM = null;

		if (serverModel.getChildren().size() == 1) {
			EsbElement child = serverModel.getChildren().get(0);
			switch (serverModel.getType()) {
			case SEQUENCE:
				if (child instanceof Sequences) {
					configOM = sequenceSerializer.serializeMediator(null,
							transformSequence(serverModel));
				}
				break;
			case PROXY:
				if (child instanceof ProxyService) {
					configOM = ProxyServiceSerializer.serializeProxy(null,
							transformProxyService((ProxyService) child));
				}
				break;
			case ENDPOINT:
				if (child instanceof EndpointDiagram) {
					Endpoint transformEndpoint = transformEndpoint((EndpointDiagram) child);
					if(transformEndpoint!=null){
						configOM = EndpointSerializer
						.getElementFromEndpoint(transformEndpoint);
					}
				}
				break;
			case LOCAL_ENTRY:
				if (child instanceof LocalEntry) {
					configOM = EntrySerializer.serializeEntry(
							transformLocalEntry((LocalEntry) child), null);
				}
				break;						
			case TEMPLATE_SEQUENCE:
				if (child instanceof Template) {
					TemplateMediator templateMediator = transformSequenceTemplate((Template) child);
					configOM = MediatorSerializerFinder.getInstance().getSerializer(templateMediator).serializeMediator(null, templateMediator);
				}
				break;				
			case TEMPLATE_ENDPOINT_ADDRESS:
				if (child instanceof Template) {
					TemplateSerializer templateSerializer = new TemplateSerializer();
					configOM = templateSerializer.serializeEndpointTemplate(transformEndpointTemplate((Template) child), null);

				}
				break;				
			case TEMPLATE_ENDPOINT_WSDL:
				if (child instanceof Template) {
					TemplateSerializer templateSerializer = new TemplateSerializer();
					configOM = templateSerializer.serializeEndpointTemplate(transformEndpointTemplate((Template) child), null);
				}
				break;
				
			case TEMPLATE_ENDPOINT_DEFAULT:
				if (child instanceof Template) {
					TemplateSerializer templateSerializer = new TemplateSerializer();
					configOM = templateSerializer.serializeEndpointTemplate(transformEndpointTemplate((Template) child), null);
				}
				break;				
			case TEMPLATE_ENDPOINT_HTTP:
				if (child instanceof Template) {
					TemplateSerializer templateSerializer = new TemplateSerializer();
					configOM = templateSerializer.serializeEndpointTemplate(transformEndpointTemplate((Template) child), null);
				}
				break;				
			case TASK:
				if (child instanceof Task) {
					String TASK_EXTENSION_NS = "http://ws.apache.org/ns/synapse";
				    OMNamespace TASK_OM_NAMESPACE = OMAbstractFactory.getOMFactory().createOMNamespace(TASK_EXTENSION_NS, "");
					configOM = TaskDescriptionSerializer.serializeTaskDescription(TASK_OM_NAMESPACE,transformTask((Task)child));
				}
				break;	
			case API:
				if (child instanceof SynapseAPI) {
					configOM = CustomAPISerializer.serializeAPI(transformAPI((SynapseAPI)child));
				}
				break;	
			case MAIN_SEQUENCE:
				if (child instanceof ProxyService) {
					configOM = sequenceSerializer.serializeMediator(null,
							transformMainSequence((ProxyService)child));
				}
				break;
			case MESSAGE_STORE:
				if(child instanceof MessageStore){
					configOM = MessageStoreTransformer.createMessageStore((MessageStore) child);
				}
				break;
			case MESSAGE_PROCESSOR:
				if(child instanceof MessageProcessor) {
					configOM = MessageProcessorTransformer.createMessageProcessor((MessageProcessor) child);
				}
				break;
            case INBOUND_ENDPOINT:
                if (child instanceof InboundEndpoint) {
                        configOM = InboundEndpointSerializer.serializeInboundEndpoint(transformInbundEndpoint((InboundEndpoint)child));
                }
                break;
			case SYNAPSE_CONFIG:
			default:
				configOM = serializer.serializeConfiguration(transform(serverModel));
				break;
			}
		} else {
			configOM = serializer.serializeConfiguration(transform(serverModel));
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		if (configOM != null) {
			DefaultEsbModelExporter.prettify(configOM, baos);
		}

		//sourceXML = baos.toString("UTF-8");
		sourceXML = format(configOM.toString());
		sourceXML = sourceXML.replaceAll("\\?><", "?>\n<");
		return sourceXML;
	}

	private static final String prettyPrintStylesheet = "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0' "
			+ " xmlns:xalan='http://xml.apache.org/xslt' "
			+ " exclude-result-prefixes='xalan'>"
			+ "  <xsl:output method='xml' indent='yes' xalan:indent-amount='4'/>"
			+ "  <xsl:strip-space elements='*'/>"
			+ "  <xsl:template match='/'>"
			+ "    <xsl:apply-templates/>"
			+ "  </xsl:template>"
			+ "  <xsl:template match='node() | @*'>"
			+ "        <xsl:copy>"
			+ "          <xsl:apply-templates select='node() | @*'/>"
			+ "        </xsl:copy>" + "  </xsl:template>" + "</xsl:stylesheet>";

	protected static void prettify(OMElement wsdlElement, OutputStream out)
			throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		wsdlElement.serialize(baos);

		Source stylesheetSource = new StreamSource(new ByteArrayInputStream(
				prettyPrintStylesheet.getBytes()));
		Source xmlSource = new StreamSource(new ByteArrayInputStream(
				baos.toByteArray()));

		TransformerFactory tf = TransformerFactory.newInstance();
		Templates templates = tf.newTemplates(stylesheetSource);
		Transformer transformer = templates.newTransformer();
		transformer.transform(xmlSource, new StreamResult(out));
	}

	@Deprecated
	public EsbServer sourceToDesign(String source, EsbServer esbServer) throws Exception {
		// TODO : remove this method
		return null;
	}
	
    public String format(String unformattedXml) {
        try {
            final Document document = parseXmlFile(unformattedXml);

            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);

            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }	
}
