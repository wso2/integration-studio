/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.eclipse.esb.cloud.util;

import java.util.List;

import org.wso2.integrationstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.integrationstudio.eclipse.esb.cloud.exceptions.CloudDeploymentException;
import org.wso2.integrationstudio.eclipse.esb.cloud.exceptions.HttpClientException;
import org.wso2.integrationstudio.eclipse.esb.cloud.exceptions.InvalidTokenException;
import org.wso2.integrationstudio.eclipse.esb.cloud.exceptions.NetworkUnavailableException;
import org.wso2.integrationstudio.eclipse.esb.cloud.resources.CloudServiceConstants;
import org.wso2.integrationstudio.eclipse.esb.cloud.wizard.AppDetailsWizardPage;

/**
 * Utilities used buy Cloud Deployment wizards
 * 
 */
public class CloudDeploymentWizardUtils {

    /**
     * Retrieves runtime data and sets it in the AppDetailsWizardPage combo
     * 
     * @param client
     * @throws HttpClientException
     * @throws NetworkUnavailableException
     * @throws CloudDeploymentException
     * @throws InvalidTokenException
     * 
     */
    public static void fetchRuntimeData(IntegrationCloudServiceClient client, AppDetailsWizardPage appPage)
            throws InvalidTokenException, CloudDeploymentException, NetworkUnavailableException, HttpClientException {

        appPage.runtimeList = client.getApplicationRuntimes(CloudServiceConstants.AppConfigs.ESB);
        appPage.setRuntimes(getRuntimeNames(appPage.runtimeList));
    }

    /**
     * Retrieve the runtime names from a list of Runtime objects
     * 
     * @param runtimes
     * @return
     */
    public static String[] getRuntimeNames(List<org.wso2.integrationstudio.eclipse.esb.cloud.model.Runtime> runtimes) {
        String[] runtimeNames = new String[runtimes.size()];
        for (int i = 0; i < runtimes.size(); i++) {
            runtimeNames[i] = runtimes.get(i).getRuntimeName();
        }
        return runtimeNames;
    }
}
