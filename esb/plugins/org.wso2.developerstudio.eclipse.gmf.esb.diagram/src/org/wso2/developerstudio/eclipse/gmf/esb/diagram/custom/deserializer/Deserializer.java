/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;

import javax.xml.stream.XMLStreamException;

import org.apache.synapse.config.Entry;
import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.config.SynapseConfigurationBuilder;
import org.apache.synapse.core.axis2.ProxyService;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.Template;
import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.apache.synapse.rest.API;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbServerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UnrecogizedArtifactTypeException;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.collections.IteratorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.apache.synapse.config.xml.ProxyServiceFactory;
import org.apache.synapse.config.xml.rest.APIFactory;
import org.apache.synapse.config.xml.MessageProcessorFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.config.xml.endpoints.TemplateEndpointFactory;
import org.apache.synapse.config.xml.endpoints.TemplateFactory;
import org.apache.synapse.config.xml.endpoints.WSDLEndpointFactory;
import org.apache.synapse.config.xml.inbound.InboundEndpointFactory;
import org.apache.synapse.task.TaskDescription;
import org.apache.synapse.task.TaskDescriptionFactory;
import org.apache.synapse.config.xml.MessageStoreFactory;
import org.apache.synapse.message.processor.MessageProcessor;
import org.apache.synapse.message.store.MessageStore;

/**
 * Synapse model de-serialize base class
 */
public class Deserializer {
	/**
	 * Singleton instance.
	 */
	private static Deserializer singleton;
	
	/**
	 * DeveloperStudio logger
	 * */
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String synapseNS = "http://ws.apache.org/ns/synapse";
	
	private Deserializer(){
		
	}
	
	/**
	 * 
	 */
	private List<IGraphicalEditPart> mediatorFlowContainerList;
	
	/**
	 * @return singleton instance.
	 */
	public static Deserializer getInstance() {
		if (null == singleton) {
			singleton = new Deserializer();
		}
		return singleton;
	}
	
	/**
	 * Update graphical model
	 * @param source
	 * @param graphicalEditor
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void updateDesign(String source, EsbDiagramEditor graphicalEditor) throws Exception {
		
		EsbDeserializerRegistry.getInstance().init(graphicalEditor);
		Map<String, Object> artifacts = getArtifacts(source);		
		
		Diagram diagram = graphicalEditor.getDiagram();
		EsbDiagram esbDiagram = (EsbDiagram) diagram.getElement();
		EsbServer esbServer = esbDiagram.getServer();
		esbServer.setLockmode(true);
		CompoundCommand resultCommand = new CompoundCommand();

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(esbServer);
		// cleaning old diagram
		// TODO: should be replaced by better approach
		for (EsbElement child : esbServer.getChildren()) {
			RemoveCommand removeCmd = new RemoveCommand(domain, esbServer,
					EsbPackage.Literals.ESB_SERVER__CHILDREN, child);
			resultCommand.append(removeCmd);
		}

		if (resultCommand.canExecute()) {
			domain.getCommandStack().execute(resultCommand);
		}
		
		int locationY = 0;
		
		for (Map.Entry<String, Object> artifact : artifacts.entrySet()) {
			@SuppressWarnings("rawtypes")
			IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance()
					.getDeserializer(artifact.getValue());
			AbstractEsbNodeDeserializer.refreshEditPartMap();
			EditPart editpart = AbstractEsbNodeDeserializer.getEditpart(esbServer);
			IGraphicalEditPart gEditpart = (IGraphicalEditPart) ((EsbServerEditPart)editpart).getChildren().get(0);
			if (deserializer != null) {
				EsbNode node = deserializer.createNode(gEditpart,artifact.getValue());
				if (node!=null) {
					AbstractEsbNodeDeserializer.refreshEditPartMap();
					IGraphicalEditPart graphicalNode = (IGraphicalEditPart) AbstractEsbNodeDeserializer.getEditpart(node);
					if(graphicalNode!=null){
						Rectangle rect = new Rectangle(new Point(), graphicalNode.getFigure().getPreferredSize()).getCopy();
						rect.x = 0;
						rect.y = locationY;
						SetBoundsCommand sbc = new SetBoundsCommand(graphicalNode.getEditingDomain(),
								"change location", new EObjectAdapter((View) graphicalNode.getModel()), rect);
						graphicalNode.getDiagramEditDomain().getDiagramCommandStack()
								.execute(new ICommandProxy(sbc));
						locationY += rect.height; 
						locationY += 25;
						getMediatorFlowContainerList().add(graphicalNode);
					}
				} else{
					log.warn("Ignoring null output from deserializer for " + artifact.getValue().getClass());
				}
			} else{
				
			}
		}
		if(artifacts.size()>0){
			AbstractEsbNodeDeserializer.connectMediatorFlows();
		}
		/*
		 * Following code snippet is use to release the lock of automatic
		 * connecting logic. we are commenting following code since we have
		 * released the lock appropriately in our code.
		 * Please make sure to release the lock appropriately in your code.
		 */
		//esbServer.setLockmode(false); 

	}
	
	/**
	 * Return the relevant ArtifactType(Proxy service, Sequence, API etc.) for a given ESB configuration
	 * @param source
	 * @throws Exception
	 */
	public ArtifactType getArtifactType(String source) throws Exception{
		ArtifactType artifactType = null;
		OMElement element = AXIOMUtil.stringToOM(source);
		String localName = element.getLocalName();
		if("definitions".equals(localName)){
			artifactType=ArtifactType.SYNAPSE_CONFIG;
		} else if("proxy".equals(localName)){
			artifactType=ArtifactType.PROXY;
		} else if("sequence".equals(localName)){			
			if("main".equals(element.getAttributeValue(new javax.xml.namespace.QName("name")))){
				artifactType=ArtifactType.MAIN_SEQUENCE;
			}else{
				artifactType=ArtifactType.SEQUENCE;
			}			
		} else if("localEntry".equals(localName)){
			artifactType=ArtifactType.LOCAL_ENTRY;
		} else if("task".equals(localName)){
			artifactType=ArtifactType.TASK;
		} else if("api".equals(localName)){
			artifactType=ArtifactType.API;
		} else if("template".equals(localName)){
			Iterator children = element.getChildElements();
			while(children.hasNext()){
				OMElement child1 = (OMElement) children.next();
				String child1LocalName = child1.getLocalName();
				if(!"parameter".equals(child1LocalName)){
					if("sequence".equals(child1LocalName)){
						artifactType=ArtifactType.TEMPLATE_SEQUENCE;
					}else if("endpoint".equals(child1LocalName)){
						OMElement child2 = (OMElement) child1.getChildElements().next();
						String child2LocalName = child2.getLocalName();
						if("address".equals(child2LocalName)){
							artifactType=ArtifactType.TEMPLATE_ENDPOINT_ADDRESS;
						}else if("wsdl".equals(child2LocalName)){
							artifactType=ArtifactType.TEMPLATE_ENDPOINT_WSDL;
						}else if("default".equals(child2LocalName)){
							artifactType=ArtifactType.TEMPLATE_ENDPOINT_DEFAULT;
						}else if("http".equals(child2LocalName)){
							artifactType=ArtifactType.TEMPLATE_ENDPOINT_HTTP;
						}				
					}
				}
			}			
		} else if("endpoint".equals(localName)){
			artifactType=ArtifactType.ENDPOINT;
		} else if("messageStore".equals(localName)){
			artifactType=ArtifactType.MESSAGE_STORE;
		} else if("messageProcessor".equals(localName)){
			artifactType=ArtifactType.MESSAGE_PROCESSOR;
		} else if("inboundEndpoint".equals(localName)){
			artifactType=ArtifactType.INBOUND_ENDPOINT;
		} else{
			throw new UnrecogizedArtifactTypeException("Unrecognized source configuration section " + localName);
		}
		return artifactType;
	}
	
	private Map<String,Object> getArtifacts(String source) throws Exception{
		Map<String,Object> artifacts =new LinkedHashMap<String, Object>();
		
		ArtifactType artifactType = getArtifactType(source);
		OMElement element = AXIOMUtil.stringToOM(source);
		
		Properties properties = new Properties();
		properties.put(WSDLEndpointFactory.SKIP_WSDL_PARSING, "true");
		
		switch (artifactType) {
		case SYNAPSE_CONFIG:
			File tempfile = File.createTempFile("file", ".tmp");
			BufferedWriter outfile = new BufferedWriter(new FileWriter(tempfile));
			outfile.write(source);
			outfile.close();
			SynapseConfiguration synapseCofig = SynapseConfigurationBuilder.getConfiguration(
					tempfile.getAbsolutePath(), null);
			Collection<ProxyService> proxyServices = synapseCofig.getProxyServices();
			for (ProxyService proxy : proxyServices) {
				artifacts.put(proxy.getName(), proxy);
			}
			Collection<API> apis = synapseCofig.getAPIs();
			for (API api : apis) {
				artifacts.put(api.getName(), api);
			}
			Map<String, SequenceMediator> definedSequences = synapseCofig.getDefinedSequences();
			if(definedSequences.size()>0)
				artifacts.putAll(definedSequences);
			Map<String, Endpoint> definedEndpoints = synapseCofig.getDefinedEndpoints();
			if(definedEndpoints.size()>0)
				artifacts.putAll(definedEndpoints);
			Map<String, Entry> definedEntries = synapseCofig.getDefinedEntries();
			if(definedEntries.size()>0)
				artifacts.putAll(definedEntries);
			Map<String, TemplateMediator> sequenceTemplates = synapseCofig.getSequenceTemplates();
			if(sequenceTemplates.size()>0)
				artifacts.putAll(sequenceTemplates);
			Map<String, Template> endpointTemplates = synapseCofig.getEndpointTemplates();
			if(endpointTemplates.size()>0)
				artifacts.putAll(endpointTemplates);
			break;
		case PROXY:
			ProxyService proxy = ProxyServiceFactory.createProxy(element, properties);
			artifacts.put(proxy.getName(), proxy);
			break;
		case SEQUENCE:
			SequenceMediatorFactory sequenceMediatorFactory = new SequenceMediatorFactory();
			SequenceMediator sequence = (SequenceMediator) sequenceMediatorFactory.createSpecificMediator(element, properties);
			artifacts.put(sequence.getName(), sequence);
			break;
		case MAIN_SEQUENCE:
			SequenceMediatorFactory mainSequenceMediatorFactory = new SequenceMediatorFactory();
			SequenceMediator mainSequence = (SequenceMediator) mainSequenceMediatorFactory.createSpecificMediator(element, properties);
			artifacts.put(mainSequence.getName(), mainSequence);
			break;
		case API:
			//API api = APIFactory.createAPI(element);
			API api = DummyAPIFactory.createAPI(element);
			artifacts.put(api.getName(), api);
			break;
		case ENDPOINT:
			Endpoint endpoint = EndpointFactory.getEndpointFromElement(element, false, properties);
			EndpointWrapper wrapper = new EndpointWrapper(endpoint,endpoint.getName());
			artifacts.put(wrapper.getName(), wrapper);
			break;
		case LOCAL_ENTRY:
			Entry entry = EntryExtFactory.createEntry(element, properties);
			artifacts.put(entry.getKey(), entry);
			break;
		case TASK:
			//TaskDescription task = TaskDescriptionFactory.createTaskDescription(element, OMAbstractFactory.getOMFactory()
			//		.createOMNamespace(synapseNS, ""));
			TaskDescription task = DummyTaskDescriptionFactory.createTaskDescription(element, OMAbstractFactory.getOMFactory()
					.createOMNamespace(synapseNS, ""));
			artifacts.put(task.getName(), task);
			break;				
		case TEMPLATE_SEQUENCE:			
			TemplateMediatorFactory templateMediatorFactory = new TemplateMediatorFactory();
			TemplateMediator templateMediator = (TemplateMediator) templateMediatorFactory
					.createMediator(element, properties);
			artifacts.put(templateMediator.getName(), templateMediator);
			break;				
		case TEMPLATE_ENDPOINT_ADDRESS:
			createEndpointTemplate(element, properties, artifacts);
			break;			
		case TEMPLATE_ENDPOINT_WSDL:
			createEndpointTemplate(element, properties, artifacts);
			break;			
		case TEMPLATE_ENDPOINT_DEFAULT:
			createEndpointTemplate(element, properties, artifacts);
			break;			
		case TEMPLATE_ENDPOINT_HTTP:
			createEndpointTemplate(element, properties, artifacts);
			break;					
		case MESSAGE_STORE:
			MessageStore store = DummyMessageStoreFactory.createMessageStore(element, properties);
			artifacts.put(store.getName(), store);
			break;
		case MESSAGE_PROCESSOR:
			MessageProcessor messageProcessor = DummyMessageProcessorFactory.createMessageProcessor(element, properties);
			artifacts.put(messageProcessor.getName(), messageProcessor);
			break;
		case INBOUND_ENDPOINT:
			InboundEndpoint inboundEndpoint= InboundEndpointFactory.createInboundEndpoint(element,null);
			artifacts.put(inboundEndpoint.getName(), inboundEndpoint);
			break;
		default:
			break;
		}
	
		return artifacts;
	}
	
	private void createEndpointTemplate(OMElement element, Properties properties, Map<String,Object> artifacts){
		TemplateFactory templateFactory = new TemplateFactory();
		Template template = templateFactory.createEndpointTemplate(element, properties);
		TemplateEndpointFactory.getEndpointFromElement(template.getElement(), false, new Properties());
		artifacts.put(template.getName(), template);
	}


	public List<IGraphicalEditPart> getMediatorFlowContainerList() {
		if (mediatorFlowContainerList == null) {
			mediatorFlowContainerList = new ArrayList<IGraphicalEditPart>();
		}
		return mediatorFlowContainerList;
	}
	
	public DeserializeStatus isValidSynapseConfig(String source) {
		try {
			getArtifacts(source);
			return new DeserializeStatus(true, null,source);
		} catch (Exception e) {
			return new DeserializeStatus(false, e,source);
		}
	}
	
	public String validate(OMElement element, OMElement elementSub) {
		try {
			Iterator<OMElement> childElements = elementSub.getChildElements();
			List<OMElement> childElementsList = IteratorUtils.toList(childElements);

			for (OMElement omElement : childElementsList) {
				omElement.detach();
			}
			
			try {
				getArtifacts(element.toStringWithConsume());
			} catch (Exception e) {
				if (!(elementSub.getLocalName().equals("proxy") || elementSub.getLocalName().equals("target")
						|| elementSub.getLocalName().equals("template") || elementSub.getLocalName().equals("api"))) {
					String nameSpace = "xmlns=\"http://ws.apache.org/ns/synapse\"";
					String errorLine = elementSub.toStringWithConsume();
					String errorLineWithoutNS = errorLine.replaceAll(nameSpace, "");
					return "Unknown synapse configuration tag: \n\n" + "At Line " + elementSub.getLineNumber() + ", "
							+ errorLineWithoutNS + "\n";
				}
			}
			
			for (OMElement omElement : childElementsList) {
				if (omElement.getLocalName().equals("parameter")) {
					continue;
				}
				
				elementSub.addChild(omElement);
				try {
					getArtifacts(element.toStringWithConsume());
				} catch (Exception e) {
					List<OMElement> subChildElements = IteratorUtils.toList(omElement.getChildElements());
					if (subChildElements.size() > 0) {
						String returnMessage = validate(element, omElement);
						if (!returnMessage.equals("ErrorNotFound")) {
							return returnMessage;
						}
					} else {
						String nameSpace = "xmlns=\"http://ws.apache.org/ns/synapse\"";
						String errorLine = omElement.toStringWithConsume();
						String errorLineWithoutNS = errorLine.replaceAll(nameSpace, "");
						return "Unknown synapse configuration tag: \n\n" + "At Line " + omElement.getLineNumber()
								+ ", " + errorLineWithoutNS + "\n";
					}
				}
			}
		} catch (Exception e) {
			log.error("Error while validating the configuration", e);
		}
		return "ErrorNotFound";
	}

	public class DeserializeStatus {
		boolean isValid;
		Exception execption;
		String source;
		
		public String getsource(){
			return source;
		}
		public boolean isValid() {
			return isValid;
		}
		
		public Exception getExecption() {
			return execption;
		}
		
		public DeserializeStatus(boolean isValid, Exception execption,String source) {
			this.isValid = isValid;
			this.execption = execption;
			this.source = source;
		}
	}

}
