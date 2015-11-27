/* Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.core.jag.api;

public class JagApiProperties {
	
	
	
	/*URLS*/  
	private static  String domain= "https://apps.cloud.wso2.com";
	
	private static final String APP_INFO_URL_SFX = "/appmgt/site/blocks/application/get/ajax/list.jag";
	private static final String LOGIN_URL_SFX  = "/appmgt/site/blocks/user/login/ajax/login.jag";
	private static final String BUILD_NUMBER_URL_SFX  = "/appmgt/site/blocks/build/list/ajax/list.jag";
	private static final String BUILD_INFO_URL_SFX  = "/appmgt/site/blocks/build/get/ajax/get.jag";
	private static final String LAST_BUILD_URL_SFX  = "/appmgt/site/blocks/reposBuilds/list/ajax/list.jag";
	private static final String CREATE_DEPLOY_URL_SFX  = "/appmgt/site/blocks/reposBuilds/add/ajax/add.jag";
	private static final String Build_APPLICATION_URL_SFX = "/appmgt/site/blocks/lifecycle/add/ajax/add.jag";
	private static final String APP_USER_ROLES_URL_SFX = "/appmgt/site/blocks/application/user/get/ajax/list.jag";
	private static final String APP_DB_INFO_URL ="/appmgt/site/blocks/rssmanager/add/ajax/add.jag";
	private static final String APP_DS_INFO_URL ="/appmgt/site/blocks/resources/datasource/get/ajax/list.jag";
	private static final String FORKED_VERSION_INFO_URL = "/appmgt/site/blocks/reposBuilds/list/ajax/list.jag"; 
	private static final String BUILD_LOGS_URL_SFX = "/appmgt/site/blocks/reposBuilds/get/ajax/get.jag";
	                                             
	/*Actions*/
	public static  final String USER_APP_LIST__ACTION = "getApplicationsOfUser";
	public static final String App_NIFO_ACTION = "getAppVersionsInStage";
	public static final String App_BUILD_NUMBER_ACTION = "getBuildAndRepoDataForVersion";
	public static final String App_BUILD_URL_ACTIONL = "getBuildLogsUrl";
	public static final String App_BUILD_INFO_ACTION ="getbuildandrepodata";
	public static final String FORKED_REPO_INFO_ACTION = "getbuildandrepodataforkedrepo";
	public static final String App_BUILD_ACTION ="createArtifact";
	public static final String App_DEPLOY_ACTION ="deployArtifact";
	public static final String App_USERS_ROLES_ACTION ="getUsersOfApplication";
	public static final String App_DB_INFO_ACTION = "getDbUserTemplateInfoForStages";
	public static final String App_DS_INFO_ACTION = "getDatasources";
	public static final String PRINT_BUILD_LOGS = "printBuildLogs";
	
	public static String getDomain() {
		return domain;
	}
	public static void setDomain(String domain) {
		JagApiProperties.domain = domain;
	}
	public static String getAppInfoUrl(){
		return domain + APP_INFO_URL_SFX;
	}
	public static String getBuildLogsUrl(){
		return domain + BUILD_LOGS_URL_SFX;
	}
	public static String getForkedAppInfoUrl(){
		return domain + FORKED_VERSION_INFO_URL;
	}
	public static String getLoginUrl(){
		return domain + LOGIN_URL_SFX;
	}
	public static String getBuildNumberUrl(){
		return domain + BUILD_NUMBER_URL_SFX;
	}
	public static String getBuildInfoUrl(){
		return domain + BUILD_INFO_URL_SFX;
	}
	public static String getBuildLastSucessfullBuildUrl(){
		return domain + LAST_BUILD_URL_SFX;
	}
	public static String getBuildApplication() {
		return domain +Build_APPLICATION_URL_SFX;
	}
	public static String getAppUserRolesUrlS() {
		return domain + APP_USER_ROLES_URL_SFX;
	}
	public static String getAppUserDbInfoUrl() {
		return domain+APP_DB_INFO_URL;
	}
	public static String getAppDsInfoUrl() {
		return domain +APP_DS_INFO_URL;
	}
    public static String getDeployArtifactUrl() {
        return domain + CREATE_DEPLOY_URL_SFX;
    }
    public static String getCreateArtifactUrl() {
        return domain + CREATE_DEPLOY_URL_SFX;
    }
}

