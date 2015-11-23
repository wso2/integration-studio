/*
 * Copyright 2009-2015 WSO2, Inc. (http://wso2.com)
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

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.esb.core.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomSynapsePathFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator} model objects into
 * corresponding synapse artifact(s).
 */
public class PropertyMediatorTransformer extends AbstractEsbNodeTransformer {
	
	private final String NEW_PROPERTY = "New Property...";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject)
			throws TransformerException {	
		try {
			info.getParentSequence().addChild(createPropertyMediator(subject));
			// Transform the property mediator output data flow path.
			doTransform(info,
					((PropertyMediator) subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		} catch (XMLStreamException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}
	
	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		// TODO Auto-generated method stub		
		try {
			sequence.addChild(createPropertyMediator(subject));
			doTransformWithinSequence(information,((PropertyMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		} catch (XMLStreamException e) {
			throw new TransformerException(e);
		}		
	}
	
	private org.apache.synapse.mediators.builtin.PropertyMediator createPropertyMediator(EsbNode subject) throws XMLStreamException, JaxenException, TransformerException{
		// Check subject.
		Assert.isTrue(subject instanceof PropertyMediator, "Invalid subject.");
		PropertyMediator visualProp = (PropertyMediator) subject;

		// Configure property mediator.
		org.apache.synapse.mediators.builtin.PropertyMediator propMediator = new org.apache.synapse.mediators.builtin.PropertyMediator();
		setCommonProperties(propMediator, visualProp);
		{			
			String pName = visualProp.getPropertyName().getLiteral();
			if (pName != null && !pName.equals("")) {
				if(NEW_PROPERTY.equals(pName)){
					String newPropertyName = visualProp.getNewPropertyName();
					if(newPropertyName != null && !"".equals(newPropertyName)){						
						propMediator.setName(newPropertyName);
					}else{
						throw new TransformerException("Property name cannot be empty in Property mediator. Please specify a property name");
					}
				}else{
					propMediator.setName(visualProp.getPropertyName().getLiteral());
				}				
			}
			// Action.
			switch (visualProp.getPropertyAction()) {
			case SET:
				propMediator
						.setAction(org.apache.synapse.mediators.builtin.PropertyMediator.ACTION_SET);
				break;
			case REMOVE:
				propMediator
						.setAction(org.apache.synapse.mediators.builtin.PropertyMediator.ACTION_REMOVE);
				break;

			}
			if(visualProp.getPropertyAction().equals(PropertyAction.REMOVE)) {
				
				propMediator.setExpression(null);
				propMediator.setValue(null);
				
			} else {
				if (visualProp.getValueType().getName().equals("LITERAL")) {
					switch (visualProp.getPropertyDataType()) {
					case BOOLEAN:
						String value= null;
						if(visualProp.isBoolean()){
							value = "true";
						}	
						else {value ="false";}
						propMediator.setValue(value,
								XMLConfigConstants.DATA_TYPES.BOOLEAN.toString());
						break;
					case FLOAT:
						propMediator.setValue(visualProp.getValue(),
								XMLConfigConstants.DATA_TYPES.FLOAT.toString());
						break;
					case DOUBLE:
						propMediator.setValue(visualProp.getValue(),
								XMLConfigConstants.DATA_TYPES.DOUBLE.toString());
						break;
					case INTEGER:
						propMediator.setValue(visualProp.getValue(),
								XMLConfigConstants.DATA_TYPES.INTEGER.toString());
						break;
					case LONG:
						propMediator.setValue(visualProp.getValue(),
								XMLConfigConstants.DATA_TYPES.LONG.toString());
						break;
					case OM:
						propMediator.setValueElement(AXIOMUtil.stringToOM(visualProp.getOM()));
						break;
					case SHORT:
						propMediator.setValue(visualProp.getValue(),
								XMLConfigConstants.DATA_TYPES.SHORT.toString());
						break;
					case STRING:
						propMediator.setValue(visualProp.getValue(),
								XMLConfigConstants.DATA_TYPES.STRING.toString());
						break;
					}
				} else {
					if (visualProp.getValueExpression() != null) {
						SynapsePath xpath = CustomSynapsePathFactory.getSynapsePath(visualProp
								.getValueExpression().getPropertyValue());

						// SynapseJsonPath doesn't allow namespaces
						if (visualProp.getValueExpression().getNamespaces() != null && !(xpath instanceof SynapseJsonPath)) {
							Map<String, String> map = visualProp.getValueExpression()
									.getNamespaces();
							Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
							while (entries.hasNext()) {
								Map.Entry<String, String> entry = entries.next();
								xpath.addNamespace(entry.getKey(), entry.getValue());
							}
						}

						switch (visualProp.getPropertyDataType()) {
						case BOOLEAN:
							propMediator.setExpression(xpath,
									XMLConfigConstants.DATA_TYPES.BOOLEAN.toString());
							break;
						case FLOAT:
							propMediator.setExpression(xpath,
									XMLConfigConstants.DATA_TYPES.FLOAT.toString());
							break;
						case DOUBLE:
							propMediator.setExpression(xpath,
									XMLConfigConstants.DATA_TYPES.DOUBLE.toString());
							break;
						case INTEGER:
							propMediator.setExpression(xpath,
									XMLConfigConstants.DATA_TYPES.INTEGER.toString());
							break;
						case LONG:
							propMediator.setExpression(xpath,
									XMLConfigConstants.DATA_TYPES.LONG.toString());
							break;
						case OM:
							propMediator.setExpression(xpath,
									XMLConfigConstants.DATA_TYPES.OM.toString());
							break;
						case SHORT:
							propMediator.setExpression(xpath,
									XMLConfigConstants.DATA_TYPES.SHORT.toString());
							break;
						case STRING:
							propMediator.setExpression(xpath,
									XMLConfigConstants.DATA_TYPES.STRING.toString());
							break;
						}
					}
				}
			}
			switch (visualProp.getPropertyScope()) {
			case AXIS2:
				propMediator.setScope(XMLConfigConstants.SCOPE_AXIS2);
				break;
			case AXIS2_CLIENT:
				propMediator.setScope(XMLConfigConstants.SCOPE_CLIENT);
				break;
			case SYNAPSE:
				propMediator.setScope(XMLConfigConstants.SCOPE_DEFAULT);
				break;
			case TRANSPORT:
				propMediator.setScope(XMLConfigConstants.SCOPE_TRANSPORT);
				break;
			case OPERATION:
				propMediator.setScope(XMLConfigConstants.SCOPE_OPERATION);
				break;
			}
			
			if (visualProp.getValueStringPattern() != null && !visualProp.getValueStringPattern().equals("")) {
				try {

					Pattern pattern = Pattern.compile(visualProp
							.getValueStringPattern());
					propMediator.setPattern(pattern);
				} catch (PatternSyntaxException e) {

					log.error(e);
				}
			}
			
			propMediator.setGroup(visualProp.getValueStringCapturingGroup());

		}
		return propMediator;
	} 


}
