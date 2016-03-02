/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

/**
 * 
 * @author WSO2
 * Transforms the Fast XSLT mediator - from diagram view to the source view
 */
public class FastXSLTMediatorTransformer extends AbstractEsbNodeTransformer {
	private static final String INVALID_SUBJECT = "Invalid subject. not a Fast XSLT mediator";
	  
	public void transform(TransformationInfo info, EsbNode subject)  {
		try {
	        info.getParentSequence().addChild(createFastXSLTMediator(subject));
        } catch (Exception e1) {
        	log.error("An exception occured in transforming the FastXSLT mediator" + e1);
        }
		try {
	        doTransform(info, ((FastXSLTMediator) subject).getOutputConnector());
        } catch (Exception e) {
	       log.error("An exception occured in transforming the FastXSLT mediator" + e);
        }
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) {		
		try {
	        sequence.addChild(createFastXSLTMediator(subject));
        } catch (Exception e) {
        	log.error("An exception occured in transforming the FastXSLT mediator" + e);
        }
		try {
	        doTransformWithinSequence(information, ((FastXSLTMediator) subject)
	        		.getOutputConnector().getOutgoingLink(), sequence);
        } catch (Exception e) {
        	log.error("An exception occured in transforming the FastXSLT mediator" + e);
        }

	}

	private org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator createFastXSLTMediator(
			EsbNode subject) {
		Assert.isTrue(subject instanceof FastXSLTMediator, INVALID_SUBJECT);
		FastXSLTMediator visualFastXSLT = (FastXSLTMediator) subject;
		org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator fastXsltMediator = new org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator();
		setCommonProperties(fastXsltMediator, visualFastXSLT);
		Value fastXsltKey = null;

		if (visualFastXSLT.getFastXsltSchemaKeyType() == KeyType.STATIC) {
			String key = visualFastXSLT.getFastXsltStaticSchemaKey().getKeyValue();
			if (key != null && !key.equals("")) {
				fastXsltKey = new Value(key);
			}
		} else { //if not static key type is dynamic (i.e xpathExpression) by default
			NamespacedProperty key = visualFastXSLT.getFastXsltDynamicSchemaKey();
			if (key.getPropertyValue() != null && !key.getPropertyValue().equals("")) {
				SynapseXPath expression = null;
                try {
	                expression = new SynapseXPath(key.getPropertyValue());
                } catch (JaxenException e) {
                	log.error("A Jaxen exception occured in transforming the FastXSLT mediator" + e);
                }
				for (Entry<String, String> entry : key.getNamespaces().entrySet()) {
					try {
	                    expression.addNamespace(entry.getKey(), entry.getValue());
                    } catch (JaxenException e) {
                    	log.error("A Jaxen exception occured in transforming the FastXSLT mediator" + e);
                    }
				}
				fastXsltKey = new Value(expression);
			}
		}
		if (fastXsltKey != null) {
			fastXsltMediator.setXsltKey(fastXsltKey);
		}

		return fastXsltMediator;
	}

}
