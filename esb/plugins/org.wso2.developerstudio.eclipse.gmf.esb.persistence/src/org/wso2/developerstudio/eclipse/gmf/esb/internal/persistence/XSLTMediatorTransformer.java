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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.MediatorProperty;
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
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTResource;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class XSLTMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo info,
			EsbNode subject) throws TransformerException {		
		try {
			info.getParentSequence().addChild(createXSLTMediator(subject));
			doTransform(info, ((XSLTMediator)subject).getOutputConnector());
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
			sequence.addChild(createXSLTMediator(subject));
			doTransformWithinSequence(information,((XSLTMediator)subject).getOutputConnector().getOutgoingLink(),sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
	
	private org.apache.synapse.mediators.transform.XSLTMediator createXSLTMediator(EsbNode subject) throws JaxenException{
		Assert.isTrue(subject instanceof XSLTMediator, "Invalid subject.");
		XSLTMediator visualXSLT = (XSLTMediator)subject;
		
		org.apache.synapse.mediators.transform.XSLTMediator xsltMediator = new  org.apache.synapse.mediators.transform.XSLTMediator();
		setCommonProperties(xsltMediator, visualXSLT);
		
		NamespacedProperty sourceXPath = visualXSLT.getSourceXPath();
		if(sourceXPath.getPropertyValue()!=null && !sourceXPath.getPropertyValue().equals("")){
			SynapseXPath expression = new SynapseXPath(sourceXPath.getPropertyValue());
			for (Entry<String, String> entry : sourceXPath.getNamespaces().entrySet()) {
				expression.addNamespace(entry.getKey(), entry.getValue());
			}
			xsltMediator.setSource(expression);
		}
		
		Value xsltKey = null;
		
		if(visualXSLT.getXsltSchemaKeyType()==KeyType.STATIC){
			String key = visualXSLT.getXsltStaticSchemaKey().getKeyValue();
			if(key!=null && !key.equals("")){
				xsltKey = new Value(key);
			}
		} else{
			NamespacedProperty key = visualXSLT.getXsltDynamicSchemaKey();
			if(key.getPropertyValue()!=null && !key.getPropertyValue().equals("")){
				SynapseXPath expression = new SynapseXPath(key.getPropertyValue());
				for (Entry<String, String> entry : key.getNamespaces().entrySet()) {
					expression.addNamespace(entry.getKey(), entry.getValue());
				}
				xsltKey = new Value(expression);
			}
		}
		
		if(xsltKey!=null){
			xsltMediator.setXsltKey(xsltKey);
		}
		
		for (XSLTFeature feature: visualXSLT.getFeatures()){
			try {
				xsltMediator.addFeature(feature.getFeatureName(), feature.isFeatureEnabled());
			} catch (Exception e) {

			}
		}
		for (XSLTProperty property:visualXSLT.getProperties()){
			MediatorProperty mProperty = new MediatorProperty();
			mProperty.setName(property.getPropertyName());
			
			if(property.getPropertyValueType()==PropertyValueType.EXPRESSION){
				NamespacedProperty propertyExpression = property.getPropertyExpression();
				if(propertyExpression!=null && StringUtils.isNotBlank(propertyExpression.getPropertyValue())){
					SynapseXPath expression = new SynapseXPath(propertyExpression.getPropertyValue());
					for (Entry<String, String> entry : propertyExpression.getNamespaces().entrySet()) {
						expression.addNamespace(entry.getKey(), entry.getValue());
					}
					mProperty.setExpression(expression);
				}
			} else{
				mProperty.setValue(property.getPropertyValue());
			}
			
			xsltMediator.addProperty(mProperty);
		}
		ResourceMap rMap = new ResourceMap();
		for(XSLTResource resource:visualXSLT.getResources()){
			rMap.addResource(resource.getLocation(), resource.getKey().getKeyValue());
		}
		if(rMap.getResources().size()>0){
			xsltMediator.setResourceMap(rMap);
		}
		
		return xsltMediator;
	}




}
