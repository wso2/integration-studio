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

import java.util.Set;

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptLanguage;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptType;
import org.wso2.developerstudio.eclipse.gmf.esb.scriptKeyTypeEnum;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class ScriptMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, ScriptMediator>{
	
	public ScriptMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.bsf.ScriptMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());		
		org.apache.synapse.mediators.bsf.ScriptMediator scriptMediator = (org.apache.synapse.mediators.bsf.ScriptMediator)mediator;		
		ScriptMediator visualScriptMediator = (ScriptMediator) DeserializerUtils.createNode(part, EsbElementTypes.ScriptMediator_3508);
		setElementToEdit(visualScriptMediator);
		setCommonProperties(scriptMediator, visualScriptMediator);
		String type = scriptMediator.getScriptSrc();		
		
		if("js".equals(scriptMediator.getLanguage())){
			executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE, ScriptLanguage.JAVASCRIPT);
		}else if("rb".equals(scriptMediator.getLanguage())){
			executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE, ScriptLanguage.RUBY);
		}else if("groovy".equals(scriptMediator.getLanguage())){
			executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_LANGUAGE, ScriptLanguage.GROOVY);
		}
		
		if(type!=null){
		   executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_TYPE, ScriptType.INLINE);
		   executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_BODY, scriptMediator.getScriptSrc());
		}else{
		   executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_TYPE, ScriptType.REGISTRY_REFERENCE);
		  Set<Value> keySet = scriptMediator.getIncludeMap().keySet();
		  for (Value value : keySet) {
			  RegistryKeyProperty keyProperty=EsbFactory.eINSTANCE.createRegistryKeyProperty();
			  keyProperty.setKeyValue(value.getKeyValue());
			  executeAddValueCommand(visualScriptMediator.getScriptKeys(),keyProperty);
		  }
		  Value key = scriptMediator.getKey();
		  SynapsePath expression = key.getExpression();
		  String keyValue = key.getKeyValue();
		  if(expression!=null){
			  NamespacedProperty namespacedProperty = createNamespacedProperty(expression);
			  executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__KEY_TYPE, scriptKeyTypeEnum.DYNAMIC_KEY);
			  executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_DYNAMIC_KEY, namespacedProperty);
		  }else if(keyValue!=null){
			  RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			  registryKeyProperty.setKeyValue(keyValue);
			  executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__KEY_TYPE, scriptKeyTypeEnum.STATIC_KEY);
			  executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_STATIC_KEY, registryKeyProperty);
		  }
		  executeSetValueCommand(EsbPackage.Literals.SCRIPT_MEDIATOR__MEDIATE_FUNCTION, scriptMediator.getFunction());
		}
		return visualScriptMediator;
	}
}
