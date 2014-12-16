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


import java.util.Iterator;
import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleAccessType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class ThrottleMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator,ThrottleMediator> {

	@Override
	public ThrottleMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.throttle.ThrottleMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.throttle.ThrottleMediator throttleMediator = (org.apache.synapse.mediators.throttle.ThrottleMediator)mediator;
		
		ThrottleMediator visualThrottle = (ThrottleMediator)DeserializerUtils.createNode(part, EsbElementTypes.ThrottleMediator_3493);
		
		setElementToEdit(visualThrottle);
		setCommonProperties(throttleMediator, visualThrottle);
		refreshEditPartMap();
		
		if(throttleMediator.getId() != null){
			
			executeSetValueCommand(THROTTLE_MEDIATOR__GROUP_ID, throttleMediator.getId());
		}
		
		if (throttleMediator.getPolicyKey() != null) {
			executeSetValueCommand(THROTTLE_MEDIATOR__POLICY_TYPE, ThrottlePolicyType.REGISTRY_REFERENCE);
			RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			keyProperty.setKeyValue(throttleMediator.getPolicyKey());
			executeSetValueCommand(THROTTLE_MEDIATOR__POLICY_KEY, keyProperty);
		} else {
			
			executeSetValueCommand(THROTTLE_MEDIATOR__POLICY_TYPE, ThrottlePolicyType.INLINE);
			
			OMElement throttlePolicy = throttleMediator.getInLinePolicy();
			
			if (throttlePolicy != null) {
				
				
				OMElement mediatorThrottleAssertion = throttlePolicy.getFirstElement();

				if (mediatorThrottleAssertion != null) {
					
					@SuppressWarnings("unchecked")
					Iterator<OMElement> maximumConcAccIterator = mediatorThrottleAssertion.getChildrenWithLocalName("MaximumConcurrentAccess");
					OMElement maximumConcurrentAccess = maximumConcAccIterator.next();
					
					
					if(maximumConcurrentAccess != null && maximumConcurrentAccess.getText() != null && DeserializerUtils.isInteger(maximumConcurrentAccess.getText())){
						
					         int mca = Integer.parseInt(maximumConcurrentAccess.getText());
					         
					         executeSetValueCommand(THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT, mca);
					}
					
					
					//Setting throttle policy entries.
					for(@SuppressWarnings("unchecked")
					Iterator<OMElement> it = mediatorThrottleAssertion.getChildrenWithLocalName("Policy"); it.hasNext();){
							
							OMElement outerPolicy = it.next();
							
							if(outerPolicy != null){
								
							     ThrottlePolicyEntry throttlePolicyEntry = createVisualPolicyEntry(outerPolicy);
							    
							     executeAddValueCommand(visualThrottle.getPolicyEntries(), throttlePolicyEntry);
							 
							}
						}
					
				}
			}
			
		}
		
		if(throttleMediator.getOnAcceptMediator()!=null){
			if(throttleMediator.getOnAcceptMediator() instanceof SequenceMediator){
				MediatorFlow mediatorFlow = visualThrottle.getThrottleContainer().getOnAcceptContainer().getMediatorFlow();
				GraphicalEditPart compartment = (GraphicalEditPart)((getEditpart(mediatorFlow)).getChildren().get(0));
				deserializeSequence(compartment, (SequenceMediator)throttleMediator.getOnAcceptMediator(), visualThrottle.getOnAcceptOutputConnector());
			} else{
				getLog().warn("Ignoring configuration : throttle OnAcceptMediator is not an instanceof SequenceMediator");
			}
			executeSetValueCommand(THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE, ThrottleSequenceType.ANONYMOUS);
		} else {
			String onAcceptSeqKey = throttleMediator.getOnAcceptSeqKey();
			if(StringUtils.isNotBlank(onAcceptSeqKey)){
					executeSetValueCommand(THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE, ThrottleSequenceType.REGISTRY_REFERENCE);
					RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
					keyProperty.setKeyValue(onAcceptSeqKey);
					executeSetValueCommand(THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY, keyProperty);
			}
		}
		
		if(throttleMediator.getOnRejectMediator()!=null){
			if(throttleMediator.getOnRejectMediator() instanceof SequenceMediator){
				MediatorFlow mediatorFlow = visualThrottle.getThrottleContainer().getOnRejectContainer().getMediatorFlow();
				GraphicalEditPart compartment = (GraphicalEditPart)((getEditpart(mediatorFlow)).getChildren().get(0));
				deserializeSequence(compartment, (SequenceMediator)throttleMediator.getOnRejectMediator(), visualThrottle.getOnRejectOutputConnector());
			} else{
				getLog().warn("Ignoring configuration : throttle OnRejectMediator is not an instanceof SequenceMediator");
			}
			executeSetValueCommand(THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE, ThrottleSequenceType.ANONYMOUS);
		} else {
			String onRejectSeqKey = throttleMediator.getOnRejectSeqKey();
			if(StringUtils.isNotBlank(onRejectSeqKey)){
				executeSetValueCommand(THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE, ThrottleSequenceType.REGISTRY_REFERENCE);
				RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				keyProperty.setKeyValue(onRejectSeqKey);
				executeSetValueCommand(THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY, keyProperty);
			}
		}
	
		return visualThrottle;
	}
	
	
	private ThrottlePolicyEntry createVisualPolicyEntry(OMElement outerPolicy){
		
		ThrottlePolicyEntry visualPolicyEntry = EsbFactory.eINSTANCE.createThrottlePolicyEntry();
		
		@SuppressWarnings("unchecked")
		Iterator<OMElement> policyIdElemItr = outerPolicy.getChildrenWithLocalName("ID");
		OMElement policyIdElem = policyIdElemItr.next();
		
		if(policyIdElem != null){
			
			//get type  attribute
			OMAttribute typeAttribute = policyIdElem.getAttribute(new QName("http://www.wso2.org/products/wso2commons/throttle","type"));

			if (typeAttribute != null
					&& typeAttribute.getAttributeValue() != null) {
				String type = typeAttribute.getAttributeValue();

				if (type != null && !StringUtils.isBlank(type.trim())) {

					if (type.equals("IP")) {

						visualPolicyEntry
								.setThrottleType(ThrottleConditionType.IP);

					} else if (type.equals("DOMAIN")) {

						visualPolicyEntry
								.setThrottleType(ThrottleConditionType.DOMAIN);

					}
				}
			}
			//Setting range text
			if(policyIdElem.getText() != null && !StringUtils.isBlank(policyIdElem.getText().trim())){
				
				 visualPolicyEntry.setThrottleRange(policyIdElem.getText());
			}
		}
		@SuppressWarnings("unchecked")
		Iterator<OMElement> innerPolicyItr = outerPolicy.getChildrenWithLocalName("Policy");
		OMElement innerPolicy = innerPolicyItr.next();
		
		if(innerPolicy != null){
			
			OMElement accessTypeElem  =  innerPolicy.getFirstElement();
			
			if(accessTypeElem != null && accessTypeElem.getLocalName() != null){
				
				if(accessTypeElem.getLocalName().equals("Allow")){
					
					visualPolicyEntry.setAccessType(ThrottleAccessType.ALLOW);
					
				}else if(accessTypeElem.getLocalName().equals("Deny")){
					
					visualPolicyEntry.setAccessType(ThrottleAccessType.DENY);
					
				}else if(accessTypeElem.getLocalName().equals("Control")){
					
					visualPolicyEntry.setAccessType(ThrottleAccessType.CONTROL);
					
					configureAccessControlParams(visualPolicyEntry,accessTypeElem);
					
				}
			}
		}
			
		return visualPolicyEntry;
		
	}
	
	private void configureAccessControlParams(ThrottlePolicyEntry visualPolicyEntry, OMElement accessTypeElem){
		
		@SuppressWarnings("unchecked")
		Iterator<OMElement> accessPolicyElemItr = accessTypeElem.getChildrenWithLocalName("Policy");
		OMElement accessPolicyElem = accessPolicyElemItr.next();
		
		@SuppressWarnings("unchecked")
		Iterator<OMElement> maximumCountElemItr = accessPolicyElem.getChildrenWithLocalName("MaximumCount");
		OMElement maximumCountElem = maximumCountElemItr.next(); 
		
		if(maximumCountElem != null && maximumCountElem.getText() != null && DeserializerUtils.isInteger(maximumCountElem.getText().trim())){
			
			visualPolicyEntry.setMaxRequestCount(Integer.parseInt(maximumCountElem.getText()));
		}
		
		@SuppressWarnings("unchecked")
		Iterator<OMElement> unitTimeElemItr = accessPolicyElem.getChildrenWithLocalName("UnitTime");
		OMElement unitTimeElem = unitTimeElemItr.next();
		
		if(unitTimeElem != null && unitTimeElem.getText() != null && DeserializerUtils.isInteger(unitTimeElem.getText())){
			
			visualPolicyEntry.setUnitTime(Integer.parseInt(unitTimeElem.getText()));
		}
		
		@SuppressWarnings("unchecked")
		Iterator<OMElement> prohibitTimePeriodElemItr = accessPolicyElem.getChildrenWithLocalName("ProhibitTimePeriod");
		OMElement prohibitTimePeriodElem = prohibitTimePeriodElemItr.next();
		
		if(prohibitTimePeriodElem != null && prohibitTimePeriodElem.getText() != null && DeserializerUtils.isInteger(prohibitTimePeriodElem.getText())){
			
			visualPolicyEntry.setProhibitPeriod(Integer.parseInt(prohibitTimePeriodElem.getText()));
		}
	}

}
