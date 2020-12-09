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
package org.wso2.developerstudio.bpel.humantask.ui.factories;


import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.bpel.humantask.model.ModelFactory;
import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT;
import org.wso2.developerstudio.bpel.humantask.model.RemoteNotification;
import org.wso2.developerstudio.bpel.humantask.model.RemoteTask;
import org.wso2.developerstudio.bpel.humantask.ui.Activator;
import org.wso2.developerstudio.bpel.humantask.ui.HTConstants;


public class HTUIObjectFactory extends AbstractUIObjectFactory implements IExtensionUIObjectFactory{

	private EClass modelType;
	private EClass[] classArray = { 
			
			ModelPackage.eINSTANCE.getPeopleActivityRT(), ModelPackage.eINSTANCE.getPeopleActivityRN() 
			
	}; // should be edited.
	
	public HTUIObjectFactory(EClass modelType) {
		super();
		this.modelType = modelType;
	}
	
	public HTUIObjectFactory() {
		super();
	}
	
	
	public Image getLargeImage() {
		return Activator.getDefault().getImageRegistry().get(HTConstants.DEFAULT_ICON_20);
	}

	
	public ImageDescriptor getLargeImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(HTConstants.DEFAULT_ICON_20);
	}

	
	public EClass getModelType() {
		return this.modelType;
	}

	
	public Image getSmallImage() {
		return Activator.getDefault().getImageRegistry().get(HTConstants.DEFAULT_ICON_16);
	}

	
	public ImageDescriptor getSmallImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(HTConstants.DEFAULT_ICON_16);
	}

	
	public String getTypeLabel() {
		if ("PeopleActivityRT".equals(getModelType().getName()))
		{	
			return HTConstants.NAME_REMOTE_TASK;
		}
		else if ("PeopleActivityRN".equals(getModelType().getName()))
		{	
			return HTConstants.NAME_REMOTE_NOTIFICATION;
		}
		return getModelType().getName();
	}

	
	public EClass[] getClassArray() {
		return this.classArray;
	}

	
	public void setModelType(EClass modelType) {
		this.modelType = modelType;
	}
	
	
	public EObject createInstance() {
		
		EObject result = super.createInstance();
		
		if (result instanceof PeopleActivityRT) {
			PeopleActivityRT peopleActivityRT = (PeopleActivityRT) result;
			RemoteTask rt = ModelFactory.eINSTANCE.createRemoteTask();
			//Set free RemoteTask
			peopleActivityRT.setRemoteTask(rt);
			
			peopleActivityRT.setIsSkipable(false);
			peopleActivityRT.setDontShareComments(false);
		} else if(result instanceof PeopleActivityRN)
		{
			PeopleActivityRN peopleActivityRN = (PeopleActivityRN) result;
			RemoteNotification rn = ModelFactory.eINSTANCE.createRemoteNotification();
			//Set free RemoteTask
			peopleActivityRN.setRemoteNotification(rn);
			
		}
		
		return result;}

}
