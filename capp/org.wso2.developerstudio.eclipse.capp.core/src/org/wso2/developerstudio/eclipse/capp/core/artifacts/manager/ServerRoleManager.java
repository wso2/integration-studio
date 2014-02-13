/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 */

package org.wso2.developerstudio.eclipse.capp.core.artifacts.manager;

public class ServerRoleManager {
	public static final IServerRole SR_APP_SERVER=CAppEnvironment.createServerRole("ApplicationServer","Application Server");
	public static final IServerRole SR_DS_SERVER=CAppEnvironment.createServerRole("DataServicesServer","Data Services Server");
	public static final IServerRole SR_ESB_SERVER=CAppEnvironment.createServerRole("EnterpriseServiceBus","Enterprise Service Bus");
	public static final IServerRole SR_BRS_SERVER=CAppEnvironment.createServerRole("BusinessRulesServer","Business Rules Server");
	public static final IServerRole SR_BPS_SERVER=CAppEnvironment.createServerRole("BusinessProcessServer","Business Process Server");
	public static final IServerRole SR_GREG_SERVER=CAppEnvironment.createServerRole("GovernanceRegistry","Governance Registry");
	public static final IServerRole SR_IS_SERVER=CAppEnvironment.createServerRole("IdentityServer","Identity Server");
	public static final IServerRole SR_BAM_SERVER=CAppEnvironment.createServerRole("BusinessActivityMonitor","Business Activity Monitor");
	public static final IServerRole SR_GS_SERVER=CAppEnvironment.createServerRole("GadgetServer","Gadget Server");
	public static final IServerRole SR_MS_SERVER=CAppEnvironment.createServerRole("MashupServer","Mashup Server");

}
