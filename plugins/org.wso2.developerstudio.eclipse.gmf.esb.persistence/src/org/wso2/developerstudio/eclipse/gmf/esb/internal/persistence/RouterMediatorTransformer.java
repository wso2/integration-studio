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
import java.util.regex.Pattern;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.eip.Target;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.carbon.mediators.router.impl.Route;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * Router mediator transformer 
 *
 */
public class RouterMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		try {
			information.getParentSequence().addChild(createRouterMediator(information, subject));
			doTransform(information, ((RouterMediator) subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		try {
			sequence.addChild(createRouterMediator(information, subject));
			doTransformWithinSequence(information, ((RouterMediator) subject)
					.getOutputConnector().getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
	
	private org.wso2.carbon.mediators.router.impl.RouterMediator createRouterMediator(
			TransformationInfo information, EsbNode subject) throws JaxenException, TransformerException{
		
		Assert.isTrue(subject instanceof RouterMediator, "Unsupported mediator passed in for serialization");
		RouterMediator routerModel = (RouterMediator) subject;
		
		org.wso2.carbon.mediators.router.impl.RouterMediator router = new org.wso2.carbon.mediators.router.impl.RouterMediator();
		router.setContinueAfter(routerModel.isContinueAfterRouting());
		
		EList<RouterTargetContainer> routerTargets = routerModel.getRouterContainer().getRouterTargetContainer();
		for(int i=0;i<routerTargets.size();i++){
			Route route = new Route();
			Pattern match = Pattern.compile(routerTargets.get(i).getRoutePattern());
			route.setMatch(match);
			NamespacedProperty routeExpressionModel = routerTargets.get(i).getRouteExpression();
			SynapseXPath routeExpression = new SynapseXPath(routeExpressionModel.getPropertyValue());
			for(Entry<String, String> entry : routeExpressionModel.getNamespaces().entrySet() ){
				routeExpression.addNamespace(entry.getKey(), entry.getValue());
			}
			route.setExpression(routeExpression);
			route.setBreakRouter(routerTargets.get(i).isBreakAfterRoute());
			Target target = new Target();
			
			if(routerTargets.get(i).getTarget().getSequenceType()==TargetSequenceType.REGISTRY_REFERENCE){
				target.setSequenceRef(routerTargets.get(i).getTarget().getSequenceKey().getKeyValue());
			} else{
				SequenceMediator targetSequence = new SequenceMediator();

				TransformationInfo newOnCompleteInfo = new TransformationInfo();
				newOnCompleteInfo.setTraversalDirection(information.getTraversalDirection());
				newOnCompleteInfo.setSynapseConfiguration(information.getSynapseConfiguration());
				newOnCompleteInfo.setOriginInSequence(information.getOriginInSequence());
				newOnCompleteInfo.setOriginOutSequence(information.getOriginOutSequence());
				newOnCompleteInfo.setCurrentProxy(information.getCurrentProxy());
				newOnCompleteInfo.setParentSequence(targetSequence);
				doTransform(newOnCompleteInfo, routerModel.getTargetOutputConnector().get(i));
				target.setSequence(targetSequence);
			}
			/*
			 * TODO: add target endpoint serialization, note : current implementation of the GMF
			 * RouterMediator model does not support the creation of target endpoints
			 */			
			route.setTarget(target);
			router.addRoute(route);
		}
		
		return router;
	}

}
