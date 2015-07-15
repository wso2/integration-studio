package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.saxon.s9api.ItemType;
import net.sf.saxon.s9api.XdmNodeKind;

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.xquery.MediatorBaseVariable;
import org.apache.synapse.mediators.xquery.MediatorCustomVariable;
import org.apache.synapse.mediators.xquery.MediatorVariable;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableType;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class XQueryMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, XQueryMediator>{

	@Override
    public XQueryMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
	   
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.xquery.XQueryMediator,
		              "Unsupported mediator passed in for deserialization at " + this.getClass());
		
		org.apache.synapse.mediators.xquery.XQueryMediator xqueryMediator = (org.apache.synapse.mediators.xquery.XQueryMediator)mediator;
		
		org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator VisualXqueryMediator = (org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator) DeserializerUtils.createNode(part, EsbElementTypes.XQueryMediator_3510);
		setElementToEdit(VisualXqueryMediator);
		setCommonProperties(xqueryMediator, VisualXqueryMediator);
		//XQueryMediator vishualXquery = EsbFactory.eINSTANCE.createXQueryMediator();
		
		if(xqueryMediator.getTarget() != null){
			
			SynapseXPath targetXpath = xqueryMediator.getTarget();
			
			NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();

			nsp.setPropertyValue(targetXpath.toString());

			if (targetXpath.getNamespaces() != null) {

				@SuppressWarnings("unchecked")
				Map<String, String> map = targetXpath.getNamespaces();

				nsp.setNamespaces(map);
			}
			
			//vishualXquery.setTargetXPath(nsp);
			executeSetValueCommand(XQUERY_MEDIATOR__TARGET_XPATH, nsp);
		}
		
		if(xqueryMediator.getQueryKey() != null){
			
			Value queryKeyValue = xqueryMediator.getQueryKey();
			
			if(queryKeyValue.getKeyValue() != null){
				
				//vishualXquery.setScriptKeyType(KeyType.STATIC);
				executeSetValueCommand(XQUERY_MEDIATOR__SCRIPT_KEY_TYPE, KeyType.STATIC);
				
				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				
				regkey.setKeyValue(queryKeyValue.getKeyValue());
				
				executeSetValueCommand(XQUERY_MEDIATOR__STATIC_SCRIPT_KEY, regkey);
			}
			else if(queryKeyValue.getExpression() != null){
				
				//vishualXquery.setScriptKeyType(KeyType.DYNAMIC);
				executeSetValueCommand(XQUERY_MEDIATOR__SCRIPT_KEY_TYPE, KeyType.DYNAMIC);
				
				SynapsePath xpath  = queryKeyValue.getExpression();
				
				NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();

				nsp.setPropertyValue(xpath.toString());

				if (xpath.getNamespaces() != null) {

					@SuppressWarnings("unchecked")
					Map<String, String> map = xpath.getNamespaces();

					nsp.setNamespaces(map);
				}
				
				//vishualXquery.setDynamicScriptKey(nsp);
				executeSetValueCommand(XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY, nsp);
			}
		}
		
		
		if(xqueryMediator.getVariables() != null && !xqueryMediator.getVariables().isEmpty()){
			
			List<XQueryVariable> varList  = new ArrayList<XQueryVariable>();
				
			for(MediatorVariable mediatorVariable : xqueryMediator.getVariables()){
				
				XQueryVariable vishualVariable = EsbFactory.eINSTANCE.createXQueryVariable();
				
				if(mediatorVariable instanceof MediatorBaseVariable){
					
					vishualVariable.setValueType(XQueryVariableValueType.LITERAL);
					
					MediatorBaseVariable varBase = (MediatorBaseVariable)mediatorVariable;
					
					if(varBase.getName() != null){
						
						vishualVariable.setVariableName(varBase.getName().toString());
					}
					
					if(varBase.getValue() != null){
						
						vishualVariable.setValueLiteral(varBase.getValue().toString());
					}
					
					ItemType typeNum = varBase.getType();
					
					if(typeNum.equals(ItemType.INT)){
						vishualVariable.setVariableType(XQueryVariableType.INT);
					}else if(typeNum.equals(ItemType.INTEGER)){
						vishualVariable.setVariableType(XQueryVariableType.INTEGER);
					}else if(typeNum.equals(ItemType.BOOLEAN)){
						vishualVariable.setVariableType(XQueryVariableType.BOOLEAN);
					}else if(typeNum.equals(ItemType.BYTE)){
						vishualVariable.setVariableType(XQueryVariableType.BYTE);
					}else if(typeNum.equals(ItemType.DOUBLE)){
						vishualVariable.setVariableType(XQueryVariableType.DOUBLE);
					}else if(typeNum.equals(ItemType.SHORT)){
						vishualVariable.setVariableType(XQueryVariableType.SHORT);
					}else if(typeNum.equals(ItemType.LONG)){
						vishualVariable.setVariableType(XQueryVariableType.LONG);
					}else if(typeNum.equals(ItemType.FLOAT)){
						vishualVariable.setVariableType(XQueryVariableType.FLOAT);
					}else if(typeNum.equals(ItemType.STRING)){
						vishualVariable.setVariableType(XQueryVariableType.STRING);
					}else if(typeNum.equals(XdmNodeKind.DOCUMENT)){
						vishualVariable.setVariableType(XQueryVariableType.DOCUMENT);
					}else if(typeNum.equals(XdmNodeKind.ELEMENT)){
						vishualVariable.setVariableType(XQueryVariableType.ELEMENT);
					}
					
				} else if(mediatorVariable instanceof MediatorCustomVariable){
					
					vishualVariable.setValueType(XQueryVariableValueType.EXPRESSION);
					
					MediatorCustomVariable customVar = (MediatorCustomVariable)mediatorVariable;
					
					if(customVar.getName() != null){
						
						vishualVariable.setVariableName(customVar.getName().toString());
					}
					
					if(customVar.getExpression() != null){
						
						SynapseXPath xpath = customVar.getExpression();

						NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();

						nsp.setPropertyValue(xpath.toString());

						if (xpath.getNamespaces() != null) {

							@SuppressWarnings("unchecked")
							Map<String, String> map = xpath.getNamespaces();

							nsp.setNamespaces(map);
						}
						
						vishualVariable.setValueExpression(nsp);

					}
					
					if(customVar.getRegKey() != null && !customVar.getRegKey().equals("")){
						
						RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
						regKey.setKeyValue(customVar.getRegKey());
						
						vishualVariable.setValueKey(regKey);
					}
					
					ItemType typeNum = customVar.getType();
					
					if(typeNum.equals(ItemType.INT)){
						vishualVariable.setVariableType(XQueryVariableType.INT);
					}else if(typeNum.equals(ItemType.INTEGER)){
						vishualVariable.setVariableType(XQueryVariableType.INTEGER);
					}else if(typeNum.equals(ItemType.BOOLEAN)){
						vishualVariable.setVariableType(XQueryVariableType.BOOLEAN);
					}else if(typeNum.equals(ItemType.BYTE)){
						vishualVariable.setVariableType(XQueryVariableType.BYTE);
					}else if(typeNum.equals(ItemType.DOUBLE)){
						vishualVariable.setVariableType(XQueryVariableType.DOUBLE);
					}else if(typeNum.equals(ItemType.SHORT)){
						vishualVariable.setVariableType(XQueryVariableType.SHORT);
					}else if(typeNum.equals(ItemType.LONG)){
						vishualVariable.setVariableType(XQueryVariableType.LONG);
					}else if(typeNum.equals(ItemType.FLOAT)){
						vishualVariable.setVariableType(XQueryVariableType.FLOAT);
					}else if(typeNum.equals(ItemType.STRING)){
						vishualVariable.setVariableType(XQueryVariableType.STRING);
					}else if(typeNum.equals(XdmNodeKind.DOCUMENT)){
						vishualVariable.setVariableType(XQueryVariableType.DOCUMENT);
					}else if(typeNum.equals(XdmNodeKind.ELEMENT)){
						vishualVariable.setVariableType(XQueryVariableType.ELEMENT);
					}					
				}
				
				varList.add(vishualVariable);			
			}
			
			executeSetValueCommand(XQUERY_MEDIATOR__VARIABLES, varList);
		}

	    return VisualXqueryMediator;
    }

}
