/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.wso2.developerstudio.bpel.humantask.model.util;


import javax.xml.namespace.QName;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.wst.wsdl.Operation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT;
import org.wso2.developerstudio.bpel.humantask.model.RemoteNotification;
import org.wso2.developerstudio.bpel.humantask.model.RemoteTask;


public class HTSerializer implements BPELActivitySerializer {



	
	
	public void marshall(QName elementType, Activity activity, Node parentNode,
			Process process, BPELWriter bpelWriter) {
		
		Document document = parentNode.getOwnerDocument();

		/*
		 *  RemoteTask
		 */
		if (activity instanceof PeopleActivityRT)
		{

			PeopleActivityRT peopleActivity = (PeopleActivityRT) activity;
			
			//(1)create a new DOM element for our Activity
			Element peopleActivityElement = document.createElementNS(elementType.getNamespaceURI(),
					HTConstants.ND_PEOPLE_ACTIVITY_RT);
			peopleActivityElement.setPrefix(HTUtils.addNamespace(process));
			
			
			
			//(2)Adding Child node
			Element rtElement = document.createElementNS(elementType.getNamespaceURI(),
					HTConstants.ND_REMOTE_TASK);
			rtElement.setPrefix(HTUtils.addNamespace(process));
			
			RemoteTask remoteTask = peopleActivity.getRemoteTask();
			
			if(remoteTask!=null){
				//(3.a)Adding Child node's attributes
				if (remoteTask.getPartnerLink() != null) {
					String attName = ModelPackage.eINSTANCE
							.getRemoteTask_PartnerLink().getName();
					rtElement.setAttribute(attName, remoteTask.getPartnerLink().getName());	
				}
				if (remoteTask.getOperation() != null) {
					String attName = ModelPackage.eINSTANCE
							.getRemoteTask_Operation().getName();
					rtElement.setAttribute(attName, getOperationSignature(remoteTask.getOperation()));	
				}
				if (remoteTask.getResponseOperation() != null) {
					String attName = ModelPackage.eINSTANCE
							.getRemoteTask_ResponseOperation().getName();
					rtElement.setAttribute(attName, getOperationSignature(remoteTask.getResponseOperation()));	
				}
			}
			peopleActivityElement.appendChild(rtElement);
			
			//(3) Setting Attributes
			//(3.a)Input variable
			if (peopleActivity.getInputVariable() != null) {
				String attName = ModelPackage.eINSTANCE
						.getPeopleActivityRT_InputVariable().getName();
				peopleActivityElement.setAttribute(attName, peopleActivity.getInputVariable().getName());	
			}
			//(3.b)OutputVariable
			if (peopleActivity.getOutputVariable() != null) {
				String attName = ModelPackage.eINSTANCE
						.getPeopleActivityRT_OutputVariable().getName();
				peopleActivityElement.setAttribute(attName, peopleActivity.getOutputVariable().getName());
			}
			//(3.c)IsSkipable
			if (peopleActivity.isIsSkipable()) {
				String attName = ModelPackage.eINSTANCE
						.getPeopleActivityRT_IsSkipable().getName();
				peopleActivityElement.setAttribute(attName, HTUtils.boolean2XML(peopleActivity.isIsSkipable()));
			}
			//(3.d)DontShareComments()
			if (peopleActivity.isDontShareComments()) {
				String attName = ModelPackage.eINSTANCE
						.getPeopleActivityRT_DontShareComments().getName();
				peopleActivityElement.setAttribute(attName, HTUtils.boolean2XML(peopleActivity.isIsSkipable()));
			}
			
			// insert the DOM element into the DOM tree		
			parentNode.appendChild(peopleActivityElement);
		}
		
		if(activity instanceof PeopleActivityRN)
		{
			
			PeopleActivityRN peopleActivityRN = (PeopleActivityRN) activity;
			
			//(1)create a new DOM element for our Activity
			Element peopleActivityElement = document.createElementNS(elementType.getNamespaceURI(),
					HTConstants.ND_PEOPLE_ACTIVITY_RN);
			peopleActivityElement.setPrefix(HTUtils.addNamespace(process));
			
			
			//(2)Adding Child node
			Element rnElement = document.createElementNS(elementType.getNamespaceURI(),
					HTConstants.ND_REMOTE_NOTIFICATION);
			rnElement.setPrefix(HTUtils.addNamespace(process));
			
			RemoteNotification remoteNotification = peopleActivityRN.getRemoteNotification();
			
			if(remoteNotification!=null){
				//(3.a)Adding Child node's attributes
				if (remoteNotification.getPartnerLink() != null) {
					String attName = ModelPackage.eINSTANCE
							.getRemoteNotification_PartnerLink().getName();
					rnElement.setAttribute(attName, remoteNotification.getPartnerLink().getName());	
				}
				if (remoteNotification.getOperation() != null) {
					String attName = ModelPackage.eINSTANCE
							.getRemoteNotification_Operation().getName();
					rnElement.setAttribute(attName, getOperationSignature(remoteNotification.getOperation()));	
				}
				
			}
			peopleActivityElement.appendChild(rnElement);
			
			//(3) Setting Attributes
			//(3.a)Input variable
			if (peopleActivityRN.getInputVariable() != null) {
				String attName = ModelPackage.eINSTANCE
						.getPeopleActivityRN_InputVariable().getName();
				peopleActivityElement.setAttribute(attName, peopleActivityRN.getInputVariable().getName());	
			}
			
			// insert the DOM element into the DOM tree
			parentNode.appendChild(peopleActivityElement);
			
		}
		
	}
		
	
	protected String getOperationSignature(Operation op) {
		String signature = "";
		if (op != null) {
			signature = op.getName();
		}
		return signature;
	}
	
}