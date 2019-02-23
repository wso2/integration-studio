package org.wso2.developerstudio.eclipse.esb.cloud.job;

import java.util.Map;
import java.util.TimerTask;

import org.wso2.developerstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NotFoundException;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Application;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Version;

public class DeploymentStatusPoller implements Runnable{
    
    private IntegrationCloudServiceClient client;

    public DeploymentStatusPoller() {
        client = IntegrationCloudServiceClient.getInstance();
    }

    @Override
    public void run() {
        
        try {
            Application app = client.getApplication("TestAppCarbonApplication");
            System.out.println("Returned" + app.getVersions());
            
            Map<String, Version> versions = app.getVersions();
            
            for (Map.Entry<String, Version> version : versions.entrySet()) {
                String response = client.getApplicationEndpoints(app.getApplicationType(), version.getValue().getDeploymentURL(), version.getValue().getVersionId());
                if(null != response &&  !"null".equals(response)) {
//                    cancel();
                    Thread.currentThread().interrupt();
                }
            }
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
