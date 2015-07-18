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

import java.util.List;
import java.util.Map.Entry;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CloudConnectorOperationExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class CloudConnectorOperationTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		Assert.isTrue(subject instanceof CloudConnectorOperation, "Invalid subject.");
		CloudConnectorOperation visuaCloudConnectorOperation = (CloudConnectorOperation) subject;
		try {
			information.getParentSequence().addChild(
					createCloudConnectorOperation(information, visuaCloudConnectorOperation));
			doTransform(information, visuaCloudConnectorOperation.getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		Assert.isTrue(subject instanceof CloudConnectorOperation, "Invalid subject.");
		CloudConnectorOperation visuaCloudConnectorOperation = (CloudConnectorOperation) subject;
		try {
			sequence.addChild(createCloudConnectorOperation(information, visuaCloudConnectorOperation));
			doTransformWithinSequence(information, visuaCloudConnectorOperation.getOutputConnector()
					.getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
	
	private CloudConnectorOperationExt createCloudConnectorOperation(
			TransformationInfo information, CloudConnectorOperation visuaCloudConnectorOperation) throws JaxenException {
		
		CloudConnectorOperationExt cloudConnectorOperation=new CloudConnectorOperationExt();
		
		cloudConnectorOperation.setConnectorComponentName(visuaCloudConnectorOperation.getConnectorName());
		cloudConnectorOperation.setOperation(visuaCloudConnectorOperation.getOperationName());
		cloudConnectorOperation.setConfigRef(visuaCloudConnectorOperation.getConfigRef());
		
		for (CallTemplateParameter param : visuaCloudConnectorOperation.getConnectorParameters()) {
			if (param.getParameterName() != null && !param.getParameterName().isEmpty()) {
				if (visuaCloudConnectorOperation.getParameterEditorType().equals(CloudConnectorOperationParamEditorType.NAMESPACED_PROPERTY_EDITOR)) {
					NamespacedProperty namespacedExpression = param.getParameterExpression();
					String xpathValue = namespacedExpression.getPropertyValue();

					if (xpathValue.startsWith("{") && xpathValue.endsWith("}")) {
						xpathValue = xpathValue.substring(1, xpathValue.length() - 1);
						SynapseXPath paramExpression = new SynapseXPath(xpathValue);
						for (Entry<String, String> entry : namespacedExpression.getNamespaces().entrySet()) {;
							paramExpression.addNamespace(entry.getKey(), entry.getValue());
						}
						cloudConnectorOperation.getpName2ExpressionMap().put(param.getParameterName(), new Value(paramExpression));
					} else {
						cloudConnectorOperation.getpName2ExpressionMap().put(param.getParameterName(), new Value(xpathValue));
					}
				} else {
					String paramValue = param.getParameterValue();
					if (paramValue != null && paramValue.startsWith("{") && paramValue.endsWith("}")) {
						paramValue = paramValue.substring(1, paramValue.length() - 1);
						SynapseXPath paramExpression = new SynapseXPath(paramValue);
						cloudConnectorOperation.getpName2ExpressionMap().put(param.getParameterName(), new Value(paramExpression));
					} else {
						cloudConnectorOperation.getpName2ExpressionMap().put(param.getParameterName(), new Value(paramValue));
					}
				}
			}
		}
		return cloudConnectorOperation;
	}

}
