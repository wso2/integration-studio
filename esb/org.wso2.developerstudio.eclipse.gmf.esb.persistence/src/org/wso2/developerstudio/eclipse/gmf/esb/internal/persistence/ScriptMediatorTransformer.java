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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptType;
import org.wso2.developerstudio.eclipse.gmf.esb.scriptKeyTypeEnum;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class ScriptMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		try {
			information.getParentSequence().addChild(createScriptMediator(subject));
			// Transform the Script mediator output data flow path.
			doTransform(information, ((ScriptMediator)subject).getOutputConnector());
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
			sequence.addChild(createScriptMediator(subject));
			doTransformWithinSequence(information,((ScriptMediator)subject).getOutputConnector().getOutgoingLink(),sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}
	
	private org.apache.synapse.mediators.bsf.ScriptMediator createScriptMediator(EsbNode subject) throws JaxenException, TransformerException{
		Assert.isTrue(subject instanceof ScriptMediator, "Invalid subject.");
		ScriptMediator visualScript = (ScriptMediator)subject;
		ScriptType scriptType = visualScript.getScriptType();
		int scriptTypeValue = scriptType.getValue();
		String language=visualScript.getScriptLanguage().getLiteral();
		String function = visualScript.getMediateFunction();
		if(scriptTypeValue == 1 && StringUtils.isBlank(function)){
			throw new TransformerException("Function cannot be empty in Script mediator. Please specify a function");
		}
		org.apache.synapse.mediators.bsf.ScriptMediator scriptMediator =null;
		if(scriptTypeValue==0){
		String scriptSourceCode=visualScript.getScriptBody();
	    scriptMediator = new org.apache.synapse.mediators.bsf.ScriptMediator(language,scriptSourceCode,null);	    
		}else{
			Map<Value, Object> includeMap = new HashMap<Value, Object>();
			EList<RegistryKeyProperty> scriptKeys = visualScript.getScriptKeys();
			for (RegistryKeyProperty registryKeyProperty : scriptKeys) {
				Value value = new Value(registryKeyProperty.getKeyValue());
				includeMap.put(value, null);
			}
			scriptKeyTypeEnum keyType = visualScript.getKeyType();
			Value value=null;
		    if(keyType.getValue()==keyType.STATIC_KEY_VALUE){	
		    	value = new Value(visualScript.getScriptStaticKey().getKeyValue());
		    	 
		    }else{
		    	NamespacedProperty scriptDynamicKey = visualScript.getScriptDynamicKey();
				SynapseXPath synapseXPath = new SynapseXPath(scriptDynamicKey.getPropertyValue());
				for (Entry<String, String> entry : scriptDynamicKey
						.getNamespaces().entrySet()) {
					synapseXPath.addNamespace(entry.getKey(), entry.getValue());
				}
		        value = new Value(synapseXPath);
		    }
			scriptMediator = new org.apache.synapse.mediators.bsf.ScriptMediator(language,includeMap,value,function,null);
		}
		setCommonProperties(scriptMediator, visualScript);
 
		return scriptMediator;
	}

}
