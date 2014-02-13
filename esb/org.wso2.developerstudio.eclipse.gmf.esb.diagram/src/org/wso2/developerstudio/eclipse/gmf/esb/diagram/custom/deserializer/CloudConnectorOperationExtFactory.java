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

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.ui.IFileEditorInput;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CloudConnectorOperationExt;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CloudConnectorOperationExtFactory extends AbstractMediatorFactory{

	protected static final QName CONFIG_KEY  = new QName("configKey");
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String CONNECTOR_DIRECTORY = ".Connectors";
	
	@Override
	protected Mediator createSpecificMediator(OMElement elem, Properties properties) {		
		CloudConnectorOperationExt cloudConnectorOperationExt = new CloudConnectorOperationExt();			
		OMAttribute configRef = elem.getAttribute(CONFIG_KEY);
		if (configRef != null) {
			cloudConnectorOperationExt.setConfigRef(configRef.getAttributeValue());
		}
		String [] splittedRootElement=elem.getQName().getLocalPart().split("\\.");
		String cloudConnectorName="";
		for(int i=0;i<splittedRootElement.length-1;++i){
			if(i==(splittedRootElement.length-2)){
				cloudConnectorName=cloudConnectorName.concat(splittedRootElement[i]);
			}else {
				cloudConnectorName=cloudConnectorName.concat(splittedRootElement[i]+".");
			}
		}
		String operationName=splittedRootElement[splittedRootElement.length-1];		
		cloudConnectorOperationExt.setConnectorComponentName(cloudConnectorName);
		cloudConnectorOperationExt.setOperation(operationName);
		
		cloudConnectorOperationExt.setCloudConnectorName(splittedRootElement[0]);
		
		//TODO expression values for params yet to handle.
		Iterator<OMElement> parameters=elem.getChildElements();
		while(parameters.hasNext()) {
			OMElement parameter=(OMElement)parameters.next();
			String paramName=parameter.getQName().getLocalPart();			
			String paramValue=parameter.getText();
			if(paramValue.startsWith("{") && paramValue.endsWith("}")){
				paramValue = paramValue.substring(1, paramValue.length() - 1);
				SynapseXPath synapseXpath=null;
				try {
					synapseXpath=new SynapseXPath(parameter,paramValue);
				} catch (JaxenException e) {
					log.error("Error while deserializing connector operation", e);
				}					
				cloudConnectorOperationExt.getpName2ExpressionMap().put(paramName, new Value(synapseXpath));
			}else{
				cloudConnectorOperationExt.getpName2ExpressionMap().put(paramName, new Value(paramValue));
			}
		}
		
		return cloudConnectorOperationExt;
	}
	
	public List<QName> getTagQNameList() throws Exception {
		ArrayList<QName> tagQNameList = new ArrayList<QName>();
/*		IContainer cloudConnectorsRoot = EditorUtils.getActiveProject()
				.getFolder("cloudConnectors");*/
		//IContainer cloudConnectorsRoot = ((IFileEditorInput)EsbMultiPageEditor.currentEditor.getEditorInput()).getFile().getProject()
		//		.getFolder("cloudConnectors");
		/*String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
				+ File.separator + ".tmp";
		IContainer tmp = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(new Path(path));

		if (tmp != null && tmp.exists()) {
			IContainer cloudConnectorsRoot = tmp.getFolder(new Path("Connectors"));
			if(cloudConnectorsRoot != null && cloudConnectorsRoot.exists()){
				IResource[] directories = cloudConnectorsRoot.members();
				for (int i = 0; i < directories.length; ++i) {
					CloudConnectorDirectoryTraverser directoryTraverser = CloudConnectorDirectoryTraverser
							.getInstance(directories[i].getLocation().toOSString());
					Map<String, String> map = directoryTraverser.getOperationsConnectorComponentNameMap();
					Iterator<String> iterator = map.keySet().iterator();
					while (iterator.hasNext()) {
						String key = iterator.next();
						tagQNameList.add(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, map.get(key) + "."
								+ key));
					}
				}
			}
		}*/

		String connectorRootPath = ((IFileEditorInput) EsbMultiPageEditor.currentEditor
				.getEditorInput()).getFile().getProject().getWorkspace().getRoot().getLocation()
				.toString()
				+ File.separator + CloudConnectorDirectoryTraverser.connectorPathFromWorkspace;
		File directory = new File(connectorRootPath);

		if (directory != null && directory.isDirectory()) {
			String[] directories = directory.list();
			for (int i = 0; i < directories.length; ++i) {
				CloudConnectorDirectoryTraverser directoryTraverser = CloudConnectorDirectoryTraverser
						.getInstance(connectorRootPath + File.separator + directories[i]);
				Map<String, String> map = directoryTraverser
						.getOperationsConnectorComponentNameMap();
				Iterator<String> iterator = map.keySet().iterator();
				while (iterator.hasNext()) {
					String key = iterator.next();
					tagQNameList.add(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, map.get(key)
							+ "." + key));
				}
			}
		}
		
		return tagQNameList;
	}

	@Override
	public QName getTagQName() {
		return null;
	}

}
