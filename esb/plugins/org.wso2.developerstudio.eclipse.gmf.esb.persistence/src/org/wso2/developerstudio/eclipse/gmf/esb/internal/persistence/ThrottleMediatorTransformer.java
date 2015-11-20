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

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleAccessType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class ThrottleMediatorTransformer extends AbstractEsbNodeTransformer  {
	private OMFactory factory;
	private OMNamespace ns_wsp;
	private OMNamespace ns_throttle;
	private OMNamespace ns_wsu;
	
	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		information.getParentSequence().addChild(createThrottleMediator(subject,information));		
		/*
		 *  Transform the Throttle mediator output data flow path.
		 */
		doTransform(information,
				((ThrottleMediator) subject).getOutputConnector());
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		sequence.addChild(createThrottleMediator(subject,information));
		doTransformWithinSequence(information,((ThrottleMediator) subject).getOutputConnector().getOutgoingLink(),sequence);	
		
	}
	

	private org.apache.synapse.mediators.throttle.ThrottleMediator createThrottleMediator(EsbNode subject,TransformationInfo information) throws TransformerException{
		/*
		 *  Check subject.
		 */
		Assert.isTrue(subject instanceof ThrottleMediator, "Invalid subject.");
		ThrottleMediator visualThrottle = (ThrottleMediator) subject;
		/*
		 *  Configure  mediator.
		 */
		org.apache.synapse.mediators.throttle.ThrottleMediator throttleMediator = new org.apache.synapse.mediators.throttle.ThrottleMediator();
		setCommonProperties(throttleMediator, visualThrottle);
		{
			throttleMediator.setId(visualThrottle.getGroupId());
			
			if(visualThrottle.getPolicyType().equals(ThrottlePolicyType.INLINE)){
				
				
				if (visualThrottle.getPolicyEntries().size() > 0 || visualThrottle.getMaxConcurrentAccessCount() > 0) {
					OMElement policyConfig = createPolicyconfiguration(visualThrottle);
					if (policyConfig != null) {
						throttleMediator.setInLinePolicy(policyConfig);
					}
				}
				
				
			}else if(visualThrottle.getPolicyType().equals(ThrottlePolicyType.REGISTRY_REFERENCE) && 
					visualThrottle.getPolicyKey() != null){
					throttleMediator.setPolicyKey(visualThrottle.getPolicyKey().getKeyValue());
				
			}
			
			if(visualThrottle.getOnAcceptBranchsequenceType().equals(ThrottleSequenceType.REGISTRY_REFERENCE)
					&& visualThrottle.getOnAcceptBranchsequenceKey() != null){
				
					throttleMediator.setOnAcceptSeqKey(visualThrottle.getOnAcceptBranchsequenceKey().getKeyValue());
			}
			
			if(visualThrottle.getOnRejectBranchsequenceType().equals(ThrottleSequenceType.REGISTRY_REFERENCE)
					&& visualThrottle.getOnRejectBranchsequenceKey() != null){
				
					throttleMediator.setOnRejectSeqKey(visualThrottle.getOnRejectBranchsequenceKey().getKeyValue());
				
			}
			
		}		
		
		/*
		 *  Transform onAccept output data flow path.
		 */
		SequenceMediator onAccept = new SequenceMediator();
		throttleMediator.setOnAcceptMediator(onAccept);
		TransformationInfo newOnAcceptInfo = new TransformationInfo();
		newOnAcceptInfo.setTraversalDirection(information.getTraversalDirection());
		newOnAcceptInfo.setSynapseConfiguration(information.getSynapseConfiguration());
		newOnAcceptInfo.setOriginInSequence(information.getOriginInSequence());
		newOnAcceptInfo.setOriginOutSequence(information.getOriginOutSequence());
		newOnAcceptInfo.setCurrentProxy(information.getCurrentProxy());
		newOnAcceptInfo.setParentSequence(onAccept);	
		doTransform(newOnAcceptInfo, visualThrottle.getOnAcceptOutputConnector());
		
		/*
		 *  Transform onReject output data flow path.
		 */
		SequenceMediator onReject = new SequenceMediator();
		throttleMediator.setOnRejectMediator(onReject);
		TransformationInfo newOnRejectInfo = new TransformationInfo();
		newOnRejectInfo.setTraversalDirection(information.getTraversalDirection());
		newOnRejectInfo.setSynapseConfiguration(information.getSynapseConfiguration());
		newOnRejectInfo.setOriginInSequence(information.getOriginInSequence());
		newOnRejectInfo.setOriginOutSequence(information.getOriginOutSequence());
		newOnRejectInfo.setCurrentProxy(information.getCurrentProxy());
		newOnRejectInfo.setParentSequence(onReject);
		doTransform(newOnRejectInfo, visualThrottle.getOnRejectOutputConnector());
		
		return throttleMediator;
	}
	
	private OMElement createPolicyconfiguration(ThrottleMediator vishualThrottle){
		factory = OMAbstractFactory.getOMFactory();

		ns_wsp = factory.createOMNamespace(
				"http://schemas.xmlsoap.org/ws/2004/09/policy", "wsp");
		ns_throttle = factory
				.createOMNamespace(
						"http://www.wso2.org/products/wso2commons/throttle",
						"throttle");
		ns_wsu = factory
				.createOMNamespace(
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd",
						"wsu");

		OMAttribute id = factory.createOMAttribute("id", ns_wsu,
				"WSO2MediatorThrottlingPolicy");

		OMElement root = factory.createOMElement("Policy", ns_wsp);

		root.addAttribute(id);

		OMElement mtaElem = factory.createOMElement(
				"MediatorThrottleAssertion", ns_throttle);
		
		OMElement maxConAccElem = factory.createOMElement("MaximumConcurrentAccess", ns_throttle);
		maxConAccElem.setText(Integer.toString(vishualThrottle.getMaxConcurrentAccessCount()));
		mtaElem.addChild(maxConAccElem);
		
		for (ThrottlePolicyEntry policyEntry : vishualThrottle.getPolicyEntries()) {
			OMElement policyEntryElm = createpolicyEntryElment(policyEntry);
			if(policyEntryElm != null){
				mtaElem.addChild(policyEntryElm);
			}
			
		}
		root.addChild(mtaElem);
		return root;
	
	}
	
	private OMElement createpolicyEntryElment(ThrottlePolicyEntry vishualPolicyEntry){

		OMElement policyEntry = factory.createOMElement("Policy", ns_wsp);

		OMElement throttleId = factory.createOMElement("ID", ns_throttle);

		String policyType = vishualPolicyEntry.getThrottleType().getLiteral();
		String range = vishualPolicyEntry.getThrottleRange();
		OMAttribute type = factory.createOMAttribute("type", ns_throttle,
				policyType);
		throttleId.addAttribute(type);
		throttleId.setText(range);

		policyEntry.addChild(throttleId);

		String accessType = vishualPolicyEntry.getAccessType().getLiteral();

		OMElement policyEntryc = factory.createOMElement("Policy", ns_wsp);
		OMElement access = factory.createOMElement(accessType, ns_throttle);
		
		if(vishualPolicyEntry.getAccessType().equals(ThrottleAccessType.CONTROL)){
			
		OMElement accessPolicy = factory.createOMElement("Policy", ns_wsp);
		access.addChild(accessPolicy);
		
		String maxCount = Integer.toString(vishualPolicyEntry.getMaxRequestCount());
		
		OMElement maximumCount = factory.createOMElement("MaximumCount",ns_throttle);
		maximumCount.setText(maxCount);
		accessPolicy.addChild(maximumCount);
		
		String utime = Integer.toString(vishualPolicyEntry.getUnitTime());
		
		OMElement ut = factory.createOMElement("UnitTime", ns_throttle);
		ut.setText(utime);
		accessPolicy.addChild(ut);
		
		String prohibitTimePeriod = Integer.toString(vishualPolicyEntry.getProhibitPeriod());
		
		OMElement ptp = factory.createOMElement("ProhibitTimePeriod", ns_throttle);
		ptp.setText(prohibitTimePeriod);
		accessPolicy.addChild(ptp);
		
		}
		
		policyEntryc.addChild(access);

		policyEntry.addChild(policyEntryc);
		return policyEntry;

	}


}
