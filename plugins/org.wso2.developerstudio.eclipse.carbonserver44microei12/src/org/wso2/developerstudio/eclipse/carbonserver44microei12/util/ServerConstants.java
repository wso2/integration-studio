/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver44microei12.util;

import java.io.File;

public class ServerConstants {
    private ServerConstants() {
        
    }
    
    public static final String MICRO_INTEGRATOR_RUNTIME = "Micro Integrator Runtime";
    
    public static final String MICRO_INTEGRATOR_SERVER = "Micro Integrator Server";
    
    public static final String VERSION = "1.2.0";
    
    //relative path to where microesb is packaged
    public static final String MICRO_ESB_PATH = "runtime" + File.separator + "microesb";
    
    public static final String INTEGRATION_STUDIO_HOME_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    
    //runtimes
    public static final String WSO2_MI_120_RUNTIME = "org.wso2.developerstudio.eclipse.carbon.runtime44microei12";
    public static final String WSO2_MI_110_RUNTIME = "org.wso2.developerstudio.eclipse.carbon.runtime44microei11";
    public static final String WSO2_MI_100_RUNTIME = "org.wso2.developerstudio.eclipse.carbon.runtime44microei";
    
    //server types
    public static final String WSO2_MI_120_SERVER_TYPE = "org.wso2.developerstudio.eclipse.carbon.server44microei12";
    public static final String WSO2_MI_110_SERVER_TYPE = "org.wso2.developerstudio.eclipse.carbon.server44microei11";
    public static final String WSO2_MI_100_SERVER_TYPE = "org.wso2.developerstudio.eclipse.carbon.server44microei";
    
    //debug
    public static final String ESB_DEBUG_ATTRIBUTE = "esb.debug";
}
