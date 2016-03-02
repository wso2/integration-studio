/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;

import net.sf.saxon.s9api.ItemType;
import net.sf.saxon.s9api.XdmNodeKind;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.xquery.MediatorBaseVariable;
import org.apache.synapse.mediators.xquery.MediatorCustomVariable;
import org.apache.synapse.mediators.xquery.MediatorVariable;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableType;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class XQueryMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {		
		try {
			information.getParentSequence().addChild(createXQueryMediator(subject));
			// Transform the XQuery mediator output data flow path.
			doTransform(information,
					((XQueryMediator)subject).getOutputConnector());
		} catch (JaxenException e) {
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
			sequence.addChild(createXQueryMediator(subject));
			doTransformWithinSequence(information,((XQueryMediator)subject).getOutputConnector().getOutgoingLink(),sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
	
	private org.apache.synapse.mediators.xquery.XQueryMediator createXQueryMediator(EsbNode subject) throws JaxenException{
		Assert.isTrue(subject instanceof XQueryMediator, "Invalid subject.");
		XQueryMediator visualXQuery = (XQueryMediator)subject;
		org.apache.synapse.mediators.xquery.XQueryMediator xqueryMediator=new org.apache.synapse.mediators.xquery.XQueryMediator();		
		setCommonProperties(xqueryMediator, visualXQuery);
		{
			if (visualXQuery.getTargetXPath().getPropertyValue() != null && !visualXQuery.getTargetXPath()
					.getPropertyValue().isEmpty()) {
				SynapseXPath xPathExpression = new SynapseXPath(visualXQuery.getTargetXPath().getPropertyValue());
				Map<String, String> namespaces = visualXQuery.getTargetXPath().getNamespaces();
				for (Map.Entry<String, String> namespace : namespaces.entrySet()) {
					xPathExpression.addNamespace(namespace.getKey(), namespace.getValue());
				}
				xqueryMediator.setTarget(xPathExpression);
			}
			Value key;			
			if(visualXQuery.getScriptKeyType().compareTo(KeyType.STATIC)==0){
				key=new Value(visualXQuery.getStaticScriptKey().getKeyValue());
			}
			else{
				SynapseXPath expression=new SynapseXPath(visualXQuery.getDynamicScriptKey().getPropertyValue());	
				key=new Value(expression);
			}
			xqueryMediator.setQueryKey(key);
					
			
			List<MediatorVariable> varlist = new ArrayList<MediatorVariable>();
			
			for(XQueryVariable vishualVariable : visualXQuery.getVariables()){
				
				XQueryVariableValueType valueType = vishualVariable.getValueType();
				
				if(valueType.equals(XQueryVariableValueType.LITERAL)){
					
					MediatorBaseVariable varBase= new MediatorBaseVariable(new QName("test"));
			           
			           varBase.setName(new QName(vishualVariable.getVariableName()));
			           
			           varBase.setValue(vishualVariable.getValueLiteral());
			           
			           XQueryVariableType  varType = vishualVariable.getVariableType();
			   
			           if(varType.equals(XQueryVariableType.INT)){
			        	   
			        	   varBase.setType(ItemType.INT);
			        	   
			           }else if(varType.equals(XQueryVariableType.INTEGER)){
			        	   
			        	   varBase.setType(ItemType.INTEGER);
			        	   
			           }else if(varType.equals(XQueryVariableType.BOOLEAN)){
			        	   
			        	   varBase.setType(ItemType.BOOLEAN);
			        	   
			           }else if(varType.equals(XQueryVariableType.BYTE)){
			        	   
			        	   varBase.setType(ItemType.BYTE);
			        	   
			           }else if(varType.equals(XQueryVariableType.DOUBLE)){
			        	   
			        	   varBase.setType(ItemType.DOUBLE);
			        	   
			           }else if(varType.equals(XQueryVariableType.SHORT)){
			        	   
			        	   varBase.setType(ItemType.SHORT);
			        	   
			           }else if(varType.equals(XQueryVariableType.LONG)){
			        	   
			        	   varBase.setType(ItemType.LONG);
			        	   
			           }else if(varType.equals(XQueryVariableType.FLOAT)){
			        	   
			        	   varBase.setType(ItemType.FLOAT);
			        	   
			           }else if(varType.equals(XQueryVariableType.STRING)){
			        	   
			        	   varBase.setType(ItemType.STRING);
			        	   
			           }else if(varType.equals(XQueryVariableType.DOCUMENT)){
			        	   
			        	   varBase.setNodeKind(XdmNodeKind.DOCUMENT);
			        	   
			           }else if(varType.equals(XQueryVariableType.ELEMENT)){
			        	   
			        	   varBase.setNodeKind(XdmNodeKind.ELEMENT);
			        	   
			           }
			                      
			           varlist.add(varBase);
					
				}else if(valueType.equals(XQueryVariableValueType.EXPRESSION)){
		
					MediatorCustomVariable varCustom = new MediatorCustomVariable(new QName("test"));
					
					varCustom.setName(new QName(vishualVariable.getVariableName()));
						
					NamespacedProperty valueExpression = vishualVariable.getValueExpression();
					if (valueExpression != null) {
						SynapseXPath propertyExpression = new SynapseXPath(vishualVariable
								.getValueExpression().getPropertyValue());
						if (valueExpression.getNamespaces() != null) {
							for (Entry<String, String> entry : valueExpression.getNamespaces()
									.entrySet()) {
								propertyExpression.addNamespace(entry.getKey(), entry.getValue());
							}
						}
						varCustom.setExpression(propertyExpression);
					}

					if (vishualVariable.getValueKey() != null
							&& StringUtils.isNotBlank(vishualVariable.getValueKey().getKeyValue())) {
						varCustom.setRegKey(vishualVariable.getValueKey().getKeyValue());
					}
										
						XQueryVariableType  varType = vishualVariable.getVariableType();
						
						 if(varType.equals(XQueryVariableType.INT)){
				        	   
							 varCustom.setType(ItemType.INT);
				        	   
				           }else if(varType.equals(XQueryVariableType.INTEGER)){
				        	   
				        	   varCustom.setType(ItemType.INTEGER);
				        	   
				           }else if(varType.equals(XQueryVariableType.BOOLEAN)){
				        	   
				        	   varCustom.setType(ItemType.BOOLEAN);
				        	   
				           }else if(varType.equals(XQueryVariableType.BYTE)){
				        	   
				        	   varCustom.setType(ItemType.BYTE);
				        	   
				           }else if(varType.equals(XQueryVariableType.DOUBLE)){
				        	   
				        	   varCustom.setType(ItemType.DOUBLE);
				        	   
				           }else if(varType.equals(XQueryVariableType.SHORT)){
				        	   
				        	   varCustom.setType(ItemType.SHORT);
				        	   
				           }else if(varType.equals(XQueryVariableType.LONG)){
				        	   
				        	   varCustom.setType(ItemType.LONG);
				        	   
				           }else if(varType.equals(XQueryVariableType.FLOAT)){
				        	   
				        	   varCustom.setType(ItemType.FLOAT);
				        	   
				           }else if(varType.equals(XQueryVariableType.STRING)){
				        	   
				        	   varCustom.setType(ItemType.STRING);
				        	   
				           }else if(varType.equals(XQueryVariableType.DOCUMENT)){
				        	   
				        	   varCustom.setNodeKind(XdmNodeKind.DOCUMENT);
				        	   
				           }else if(varType.equals(XQueryVariableType.ELEMENT)){
				        	   
				        	   varCustom.setNodeKind(XdmNodeKind.ELEMENT);
				        	   
				           }
						 
						 varlist.add(varCustom);	
				}
			   
			}
			
			xqueryMediator.addAllVariables(varlist);
		}
		return xqueryMediator;
	}

}
