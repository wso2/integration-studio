package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQItemType;


import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.xquery.MediatorBaseVariable;
import org.apache.synapse.mediators.xquery.MediatorCustomVariable;
import org.apache.synapse.mediators.xquery.MediatorVariable;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableType;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class XQueryMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws Exception {		
		information.getParentSequence().addChild(createXQueryMediator(subject));
		// Transform the XQuery mediator output data flow path.
		doTransform(information,
				((XQueryMediator)subject).getOutputConnector());
		
		
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}


	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		// TODO Auto-generated method stub
		sequence.addChild(createXQueryMediator(subject));
		doTransformWithinSequence(information,((XQueryMediator)subject).getOutputConnector().getOutgoingLink(),sequence);
		
		
	}
	
	private org.apache.synapse.mediators.xquery.XQueryMediator createXQueryMediator(EsbNode subject) throws Exception{
		Assert.isTrue(subject instanceof XQueryMediator, "Invalid subject.");
		XQueryMediator visualXQuery = (XQueryMediator)subject;
		org.apache.synapse.mediators.xquery.XQueryMediator xqueryMediator=new org.apache.synapse.mediators.xquery.XQueryMediator();		
		setCommonProperties(xqueryMediator, visualXQuery);
		{
			if(visualXQuery.getTargetXPath().getPropertyValue()!=null && !visualXQuery.getTargetXPath().getPropertyValue().equals("")){
			SynapseXPath expression=new SynapseXPath(visualXQuery.getTargetXPath().getPropertyValue());	
			xqueryMediator.setTarget(expression);
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
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_INT);
			        	   
			           }else if(varType.equals(XQueryVariableType.INTEGER)){
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_INTEGER);
			        	   
			           }else if(varType.equals(XQueryVariableType.BOOLEAN)){
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_BOOLEAN);
			        	   
			           }else if(varType.equals(XQueryVariableType.BYTE)){
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_BYTE);
			        	   
			           }else if(varType.equals(XQueryVariableType.DOUBLE)){
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_DOUBLE);
			        	   
			           }else if(varType.equals(XQueryVariableType.SHORT)){
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_SHORT);
			        	   
			           }else if(varType.equals(XQueryVariableType.LONG)){
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_LONG);
			        	   
			           }else if(varType.equals(XQueryVariableType.FLOAT)){
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_FLOAT);
			        	   
			           }else if(varType.equals(XQueryVariableType.STRING)){
			        	   
			        	   varBase.setType(XQItemType.XQBASETYPE_STRING);
			        	   
			           }else if(varType.equals(XQueryVariableType.DOCUMENT)){
			        	   
			        	   varBase.setType(XQItemType.XQITEMKIND_DOCUMENT);
			        	   
			           }else if(varType.equals(XQueryVariableType.DOCUMENT_ELEMENT)){
			        	   
			        	   varBase.setType(XQItemType.XQITEMKIND_DOCUMENT_ELEMENT);
			        	   
			           }else if(varType.equals(XQueryVariableType.ELEMENT)){
			        	   
			        	   varBase.setType(XQItemType.XQITEMKIND_ELEMENT);
			        	   
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
				        	   
							 varCustom.setType(XQItemType.XQBASETYPE_INT);
				        	   
				           }else if(varType.equals(XQueryVariableType.INTEGER)){
				        	   
				        	   varCustom.setType(XQItemType.XQBASETYPE_INTEGER);
				        	   
				           }else if(varType.equals(XQueryVariableType.BOOLEAN)){
				        	   
				        	   varCustom.setType(XQItemType.XQBASETYPE_BOOLEAN);
				        	   
				           }else if(varType.equals(XQueryVariableType.BYTE)){
				        	   
				        	   varCustom.setType(XQItemType.XQBASETYPE_BYTE);
				        	   
				           }else if(varType.equals(XQueryVariableType.DOUBLE)){
				        	   
				        	   varCustom.setType(XQItemType.XQBASETYPE_DOUBLE);
				        	   
				           }else if(varType.equals(XQueryVariableType.SHORT)){
				        	   
				        	   varCustom.setType(XQItemType.XQBASETYPE_SHORT);
				        	   
				           }else if(varType.equals(XQueryVariableType.LONG)){
				        	   
				        	   varCustom.setType(XQItemType.XQBASETYPE_LONG);
				        	   
				           }else if(varType.equals(XQueryVariableType.FLOAT)){
				        	   
				        	   varCustom.setType(XQItemType.XQBASETYPE_FLOAT);
				        	   
				           }else if(varType.equals(XQueryVariableType.STRING)){
				        	   
				        	   varCustom.setType(XQItemType.XQBASETYPE_STRING);
				        	   
				           }else if(varType.equals(XQueryVariableType.DOCUMENT)){
				        	   
				        	   varCustom.setType(XQItemType.XQITEMKIND_DOCUMENT);
				        	   
				           }else if(varType.equals(XQueryVariableType.DOCUMENT_ELEMENT)){
				        	   
				        	   varCustom.setType(XQItemType.XQITEMKIND_DOCUMENT_ELEMENT);
				        	   
				           }else if(varType.equals(XQueryVariableType.ELEMENT)){
				        	   
				        	   varCustom.setType(XQItemType.XQITEMKIND_ELEMENT);
				        	   
				           }
						 
						 varlist.add(varCustom);	
				}
			   
			}
			
			xqueryMediator.addAllVariables(varlist);
		}
		return xqueryMediator;
	}

}
