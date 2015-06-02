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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.VALIDATE_MEDIATOR__FEATURES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.VALIDATE_MEDIATOR__RESOURCES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.VALIDATE_MEDIATOR__SCHEMAS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.VALIDATE_MEDIATOR__SOURCE_XPATH;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.resolver.ResourceMap;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class ValidateMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, ValidateMediator>{


	public ValidateMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.ValidateMediator,"Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.builtin.ValidateMediator validateMediator = (org.apache.synapse.mediators.builtin.ValidateMediator)mediator;
		
		org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator VisualValidateMediator = (org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator) DeserializerUtils.createNode(part, EsbElementTypes.ValidateMediator_3623);
		setElementToEdit(VisualValidateMediator);
		setCommonProperties(validateMediator, VisualValidateMediator);
		//ValidateMediator vishualValidator = EsbFactory.eINSTANCE.createValidateMediator();
		
		refreshEditPartMap();
		EditPart mediatorFlow=getEditpart(VisualValidateMediator.getMediatorFlow());
		
		if(validateMediator.getSource() != null){
			
			SynapseXPath xpath  = validateMediator.getSource();
			
			NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
			
			nsp.setPropertyValue(xpath.toString());
			
			if (xpath.getNamespaces() != null) {

				@SuppressWarnings("unchecked")
				Map<String, String> map = xpath.getNamespaces();

				nsp.setNamespaces(map);
			}
			
			//vishualValidator.setSourceXpath(nsp);
			executeSetValueCommand(VALIDATE_MEDIATOR__SOURCE_XPATH, nsp);
		}
		
		if(validateMediator.getSchemaKeys() != null && !validateMediator.getSchemaKeys().isEmpty()){
			
			EList<ValidateSchema> validateSchemaList = new BasicEList<ValidateSchema>();
			
			for(Value schema : validateMediator.getSchemaKeys()){
				
				ValidateSchema validateSchema = EsbFactory.eINSTANCE.createValidateSchema();
				
				if(schema.getKeyValue() != null){
					
					validateSchema.setValidateSchemaKeyType(KeyType.STATIC);
					
					RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
					regkey.setKeyValue(schema.getKeyValue());
					
					validateSchema.setValidateStaticSchemaKey(regkey);
				}
				else if(schema.getExpression() != null){
					
					NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
					
					validateSchema.setValidateSchemaKeyType(KeyType.DYNAMIC);
					
					SynapsePath xpath = schema.getExpression();
					
					nsp.setPropertyValue(xpath.toString());
					
					if (xpath.getNamespaces() != null) {

						@SuppressWarnings("unchecked")
						Map<String, String> map = xpath.getNamespaces();

						nsp.setNamespaces(map);
					}
					
					validateSchema.setValidateDynamicSchemaKey(nsp);
					
				}
				
				validateSchemaList.add(validateSchema);
			}
			
			//vishualValidator.getSchemas().addAll(validateSchemaList);
			executeSetValueCommand(VALIDATE_MEDIATOR__SCHEMAS, validateSchemaList);
		}
		
		EList<ValidateFeature> validateFeatureList = new BasicEList<ValidateFeature>();
		
		for (MediatorProperty featureProperty : validateMediator.getFeatures()){
			
			ValidateFeature feature =  EsbFactory.eINSTANCE.createValidateFeature();
			
			if(featureProperty.getName() != null && !featureProperty.getName().equals("")){
				
				feature.setFeatureName(featureProperty.getName());
			}
			
			//if(Boolean.parseBoolean(featureProperty.getValue())){
				
				feature.setFeatureEnabled(Boolean.parseBoolean(featureProperty.getValue()));
			//}
			
			validateFeatureList.add(feature);
		}
		
		executeSetValueCommand(VALIDATE_MEDIATOR__FEATURES, validateFeatureList);
		
		EList<ValidateResource> validateResourceList = new BasicEList<ValidateResource>();

		if (validateMediator.getResourceMap() != null) {

			ResourceMap rMap = validateMediator.getResourceMap();

			for (Entry<String, String> entry : rMap.getResources().entrySet()) {

				ValidateResource resource = EsbFactory.eINSTANCE
						.createValidateResource();

				resource.setLocation(entry.getKey());

				RegistryKeyProperty regkey = EsbFactory.eINSTANCE
						.createRegistryKeyProperty();
				regkey.setKeyValue(entry.getValue());

				resource.setKey(regkey);

				validateResourceList.add(resource);
			}
		}

		executeSetValueCommand(VALIDATE_MEDIATOR__RESOURCES,validateResourceList);

		if(validateMediator.getList().size()>0){
			SequenceMediator sequence = new SequenceMediator();
			sequence.addAll(validateMediator.getList());
			deserializeSequence((IGraphicalEditPart) mediatorFlow.getChildren().get(0), sequence, VisualValidateMediator.getOnFailOutputConnector());
		}
		
		return VisualValidateMediator;
	}

}
