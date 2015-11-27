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

import org.eclipse.emf.common.notify.Adapter;
import org.wso2.developerstudio.bpel.humantask.model.util.ModelAdapterFactory;
import org.wso2.developerstudio.bpel.humantask.ui.adapters.PeopleActivityRTAdapter;
import org.wso2.developerstudio.bpel.humantask.ui.adapters.RemoteTaskAdapter;

public class HTUIAdapterFactory extends ModelAdapterFactory{

	private static HTUIAdapterFactory instance;
	private PeopleActivityRTAdapter peopleActivityRTAdapte;
	private RemoteTaskAdapter remottaskAdapte;
	private PeopleActivityRTAdapter peopleActivityRNAdapte;
	private RemoteTaskAdapter remotNotificationAdapte;
	
	public HTUIAdapterFactory() {
		super();
	}
	
	public static HTUIAdapterFactory getInstance(){
		if (instance == null) {
			instance = new HTUIAdapterFactory();
		}
		return instance;
		
	}
	
	
	public Adapter createPeopleActivityRTAdapter(){
		if (this.peopleActivityRTAdapte == null) {
			this.peopleActivityRTAdapte = new PeopleActivityRTAdapter();
		}
		return peopleActivityRTAdapte;
	}
	
	
	public Adapter createRemoteTaskAdapter(){
		if (this.remottaskAdapte == null) {
			this.remottaskAdapte = new RemoteTaskAdapter();
		}
		return remottaskAdapte;
	}
	
	
	public Adapter createPeopleActivityRNAdapter() {
		if (this.peopleActivityRNAdapte == null) {
			this.peopleActivityRNAdapte = new PeopleActivityRTAdapter();
		}
		return peopleActivityRNAdapte;
	}
	
	
	public Adapter createRemoteNotificationAdapter() {
		if (this.remotNotificationAdapte == null) {
			this.remotNotificationAdapte = new RemoteTaskAdapter();
		}
		return remotNotificationAdapte;
	}
}
