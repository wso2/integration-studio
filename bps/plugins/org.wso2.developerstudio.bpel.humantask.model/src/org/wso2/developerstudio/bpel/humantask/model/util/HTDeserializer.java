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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;


import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.proxy.PartnerLinkProxy;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.smila.processing.designer.model.processor.util.DOMUtils;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.bpel.humantask.model.ModelFactory;
import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT;
import org.wso2.developerstudio.bpel.humantask.model.RemoteNotification;
import org.wso2.developerstudio.bpel.humantask.model.RemoteTask;

public class HTDeserializer implements BPELActivityDeserializer {


	
	
	public Activity unmarshall(QName elementType, Node node, Activity activity,
			Process process, Map nsMap, ExtensionRegistry extReg, URI uri,
			BPELReader bpelReader) {
		
		String childLocalName = "";

		if(HTConstants.ND_PEOPLE_ACTIVITY_RT.equals(elementType.getLocalPart())){

			if(node.hasChildNodes()){
				NodeList ndlist = node.getChildNodes();
				
				for(int j=0 ; j<ndlist.getLength();j++)	{
				
					childLocalName = ndlist.item(j).getLocalName();
					if (HTConstants.ND_REMOTE_TASK.equals(childLocalName)) {
					
						PeopleActivityRT peopelActivityRT;
						Element paElement = (Element)node;
						if (activity instanceof PeopleActivityRT) {
							peopelActivityRT = (PeopleActivityRT)activity;
						}
						else {
							peopelActivityRT = ModelFactory.eINSTANCE.createPeopleActivityRT();
							// attach the DOM node to our new activity
						}
						peopelActivityRT.setElement((Element) paElement.getParentNode());
						
						// Node remoteTask
						Element rtElement  = DOMUtils.getChildElement(paElement, ModelPackage.eINSTANCE.getNsURI(), HTConstants.ND_REMOTE_TASK);
						if(rtElement==null)
						{
							peopelActivityRT.setRemoteTask(null);
						}else
						{
							RemoteTask remoteTask = peopelActivityRT.getRemoteTask();
							if(remoteTask==null)
							{
								remoteTask = ModelFactory.eINSTANCE.createRemoteTask();
							}
							if(rtElement!= remoteTask.getElement())
							{
								remoteTask.setElement(rtElement);
							}
							//Attributes
							PartnerLink	targetPartnerLink = null;
							//PartnerLink
							String attName = ModelPackage.eINSTANCE.getRemoteTask_PartnerLink().getName();
							if(rtElement.hasAttribute(attName)){
								String partnerLinkName = rtElement.getAttribute(attName);
								targetPartnerLink = BPELUtils.getPartnerLink(activity, partnerLinkName);//new PartnerLinkProxy( bpelReader.getResource().getURI(), partnerLinkName);
								remoteTask.setPartnerLink(targetPartnerLink);
							}
							
							//Operation
							attName = ModelPackage.eINSTANCE.getRemoteTask_Operation().getName();
							if(rtElement.hasAttribute(attName)&&(targetPartnerLink!=null)){
								remoteTask.setOperation(getOperation(rtElement, attName , bpelReader, targetPartnerLink));
							}
							
							//Response Operation
							attName = ModelPackage.eINSTANCE.getRemoteTask_ResponseOperation().getName();
							if(rtElement.hasAttribute(attName)&&(targetPartnerLink!=null)){
							remoteTask.setResponseOperation(getResponseOperation(rtElement, attName , bpelReader,targetPartnerLink));
							}
							
							if(peopelActivityRT.getRemoteTask() != remoteTask)
							{
								peopelActivityRT.setRemoteTask(remoteTask);
							}

						}
						
						
						//inputVariable
						String attName = ModelPackage.eINSTANCE
								.getPeopleActivityRT_InputVariable().getName();
						String value = paElement.getAttribute(attName);
						if (paElement.hasAttribute(attName)) {
							Variable[] vars = ModelHelper.getVisibleVariables(peopelActivityRT); // peopelActivityRT == activity
							for (int i=vars.length-1; i>=0; --i) {
								if (value.equals(vars[i].getName())) {
									peopelActivityRT.eSet(ModelPackage.eINSTANCE.getPeopleActivityRT_InputVariable(), vars[i]);
									break;
								}
							}
						}
						//outputVariable
						attName = ModelPackage.eINSTANCE
								.getPeopleActivityRT_OutputVariable().getName();
						value = paElement.getAttribute(attName);
						if (paElement.hasAttribute(attName)) {
							Variable[] vars = ModelHelper.getVisibleVariables(peopelActivityRT); // peopelActivityRT == activity
							for (int i=vars.length-1; i>=0; --i) {
								if (value.equals(vars[i].getName())) {
									peopelActivityRT.eSet(ModelPackage.eINSTANCE.getPeopleActivityRT_OutputVariable(), vars[i]);
									break;
								}
							}
						}
						
						//isSkipable
						attName = ModelPackage.eINSTANCE
								.getPeopleActivityRT_IsSkipable().getName();
						if(paElement.hasAttribute(attName)){
							boolean val =(Boolean.valueOf(paElement.getAttribute(attName).trim().equalsIgnoreCase("yes")));
							peopelActivityRT.eSet(ModelPackage.eINSTANCE.getPeopleActivityRT_IsSkipable(), val);
						}
						//dontSharecomments
						attName =ModelPackage.eINSTANCE
								.getPeopleActivityRT_DontShareComments().getName();
						if(paElement.hasAttribute(attName)){
							//peopelActivity.setDontShareComments(
							boolean val= Boolean.valueOf(paElement.getAttribute(attName).trim().equalsIgnoreCase("yes"));
							peopelActivityRT.eSet(ModelPackage.eINSTANCE.getPeopleActivityRT_DontShareComments(),val);
							
						}
								
						return peopelActivityRT;

					}else if (HTConstants.ND_REMOTE_NOTIFICATION.equals(childLocalName)) {

						PeopleActivityRN peopelActivityRN;
						Element paElement = (Element)node;
						if (activity instanceof PeopleActivityRN) {
							peopelActivityRN = (PeopleActivityRN)activity;
						}
						else {
							peopelActivityRN = ModelFactory.eINSTANCE.createPeopleActivityRN();
							// attach the DOM node to our new activity
						}
						peopelActivityRN.setElement((Element) paElement.getParentNode());
						
						Element rnElement  = DOMUtils.getChildElement(paElement, ModelPackage.eINSTANCE.getNsURI(), HTConstants.ND_REMOTE_NOTIFICATION);
						if(rnElement==null)
						{
							peopelActivityRN.setRemoteNotification(null);
						}else
						{
							RemoteNotification remoteNotification = peopelActivityRN.getRemoteNotification();
							if(remoteNotification==null)
							{
								remoteNotification = ModelFactory.eINSTANCE.createRemoteNotification();
							}
							if(rnElement!= remoteNotification.getElement())
							{
								remoteNotification.setElement(rnElement);
							}
							//Attributes
							PartnerLink	targetPartnerLink = null;
							//PartnerLink
							String attName = ModelPackage.eINSTANCE.getRemoteNotification_PartnerLink().getName();
							if(rnElement.hasAttribute(attName)){
								String partnerLinkName = rnElement.getAttribute(attName);
								targetPartnerLink = BPELUtils.getPartnerLink(activity, partnerLinkName);//new PartnerLinkProxy( bpelReader.getResource().getURI(), partnerLinkName);
								remoteNotification.setPartnerLink(targetPartnerLink);
							}
							
							//Operation
							attName = ModelPackage.eINSTANCE.getRemoteNotification_Operation().getName();
							if(rnElement.hasAttribute(attName)&&(targetPartnerLink!=null)){
								remoteNotification.setOperation(getOperation(rnElement, attName , bpelReader, targetPartnerLink));
							}
												
							if(peopelActivityRN.getRemoteNotification() != remoteNotification)
							{
								peopelActivityRN.setRemoteNotification(remoteNotification);
							}
						}
						
						//inputVariable
						String attName = ModelPackage.eINSTANCE
								.getPeopleActivityRN_InputVariable().getName();
						String value = paElement.getAttribute(attName);
						if (paElement.hasAttribute(attName)) {
							Variable[] vars = ModelHelper.getVisibleVariables(peopelActivityRN);
							for (int i=vars.length-1; i>=0; --i) {
								if (value.equals(vars[i].getName())) {
									peopelActivityRN.eSet(ModelPackage.eINSTANCE.getPeopleActivityRN_InputVariable(), vars[i]);
									break;
								}
							}
						}
						
						return peopelActivityRN;
					
					}

				} // End of For loop
			}// end of Node has children
		}
		return null;
	}// end of unmarshall method
	
			
	protected Operation getResponseOperation(Element activityElement,String value, BPELReader bpelReader, PartnerLink ptlink)
	{
	 Operation operation = BPELUtils.getOperation(bpelReader.getResource().getURI(), 
			 getMyRolePortType(ptlink), activityElement, value);
	 return operation;
	}
	
	protected Operation getOperation(Element activityElement,String value, BPELReader bpelReader , PartnerLink ptlink )
	{
	 Operation operation = BPELUtils.getOperation(bpelReader.getResource().getURI(), 
			 getPartnerRolePortType(ptlink), activityElement, value);
	 return operation;
	}
	
	
	public PortType getMyRolePortType(PartnerLink ptlink) {
		PortType portType=null; 
			// portType is now optional. If the user hasn't set it, then
			// infer it from the partnerLink attribute and the 
			// direction of this activity.
		
			if (ptlink != null) {
				Role role = ptlink.getMyRole();
				if (role != null) {
					portType = (PortType) role.getPortType();
				}
			}	
	 return portType;
		
	}
	
	public PortType getPartnerRolePortType(PartnerLink ptlink) {
		PortType portType=null; 
			// portType is now optional. If the user hasn't set it, then
			// infer it from the partnerLink attribute and the 
			// direction of this activity.
		
			if (ptlink != null) {
				Role role = ptlink.getPartnerRole();
				if (role != null) {
					portType = (PortType) role.getPortType();
				}
			}
	 return portType;
		
	}
}
