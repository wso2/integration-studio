/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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
import java.util.Map.Entry;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.resolver.ResourceMap;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ValidateMediatorTransformer  extends AbstractEsbNodeTransformer {
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		try {
			information.getParentSequence().addChild(createValidateMediator(subject, information));
			doTransform(information, ((ValidateMediator)subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		
		try {
			sequence.addChild(createValidateMediator(subject,information));
			doTransformWithinSequence(information,((ValidateMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
	
	
	private org.apache.synapse.mediators.builtin.ValidateMediator createValidateMediator
									(EsbNode subject,TransformationInfo information) throws TransformerException, JaxenException{
		
		/*
		 * Check subject.
		 */
		Assert.isTrue(subject instanceof ValidateMediator, "Invalid subject.");
		ValidateMediator visualValidateMediator = (ValidateMediator) subject;
		/*
		 * Configure Validate mediator.
		 */

		org.apache.synapse.mediators.builtin.ValidateMediator validateMediator = new org.apache.synapse.mediators.builtin.ValidateMediator();
		setCommonProperties(validateMediator, visualValidateMediator);
		
		NamespacedProperty sourceXPath = visualValidateMediator
				.getSourceXpath();
		if (sourceXPath.getPropertyValue() != null
				&& !sourceXPath.getPropertyValue().equals("")) {
			SynapseXPath synapseXPath = new SynapseXPath(sourceXPath
							.getPropertyValue());
			for (Entry<String, String> entry : sourceXPath.getNamespaces().entrySet()) {
				synapseXPath.addNamespace(entry.getKey(), entry.getValue());
			}
			validateMediator.setSource(synapseXPath);
		}

		List<Value> valueList = new ArrayList<Value>();
		for (ValidateSchema schema : visualValidateMediator.getSchemas()) {

			if (schema.getValidateSchemaKeyType().getLiteral()
					.equals(KeyType.STATIC.getLiteral())) {

				if (schema.getValidateStaticSchemaKey() != null
						&& schema.getValidateStaticSchemaKey().getKeyValue() != null) {
					Value val = new Value(schema.getValidateStaticSchemaKey()
							.getKeyValue());
					valueList.add(val);
				}

			} else {

				NamespacedProperty dynamicSchemaKey = schema
						.getValidateDynamicSchemaKey();
				if (dynamicSchemaKey != null
						&& dynamicSchemaKey
								.getPropertyValue() != null) {
					SynapseXPath xpath = new SynapseXPath(dynamicSchemaKey.getPropertyValue());
					for (Entry<String, String> entry : dynamicSchemaKey.getNamespaces().entrySet()) {
						xpath.addNamespace(entry.getKey(), entry.getValue());
					}
					Value val = new Value(xpath);
					valueList.add(val);
				}

			}
		}
		validateMediator.setSchemaKeys(valueList);		
		
		//ListMediator onFailMediatorList = new AnonymousListMediator();
		SequenceMediator onFailMediatorList=new SequenceMediator();
		TransformationInfo newOnFailInfo = new TransformationInfo();
		newOnFailInfo.setTraversalDirection(information.getTraversalDirection());
		newOnFailInfo.setSynapseConfiguration(information.getSynapseConfiguration());
		newOnFailInfo.setOriginInSequence(information.getOriginInSequence());
		newOnFailInfo.setOriginOutSequence(information.getOriginOutSequence());
		newOnFailInfo.setCurrentProxy(information.getCurrentProxy());
		newOnFailInfo.setParentSequence(onFailMediatorList);
		doTransform(newOnFailInfo, visualValidateMediator.getOnFailOutputConnector());
		validateMediator.addAll(onFailMediatorList.getList());
	
		
		
		for(ValidateFeature feature : visualValidateMediator.getFeatures()){
			try{
	        validateMediator.addFeature(feature.getFeatureName(), feature.isFeatureEnabled());
			}
			catch (Exception e) {
			log.error(e);
			}
			
		}
		
		if(!visualValidateMediator.getResources().isEmpty()){
			
			ResourceMap rMap = new ResourceMap();
			
			for(ValidateResource resource : visualValidateMediator.getResources()){
				
				if(resource.getLocation() != null && resource.getKey() != null){
					
				rMap.addResource(resource.getLocation(), resource.getKey().getKeyValue());
				
				}
			}
			
			validateMediator.setResourceMap(rMap);
		}
		
		
		return validateMediator;
	}
}
