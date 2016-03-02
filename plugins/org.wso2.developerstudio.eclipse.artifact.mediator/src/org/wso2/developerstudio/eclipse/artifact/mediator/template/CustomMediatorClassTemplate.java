/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.mediator.template;

import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.Activator;

public class CustomMediatorClassTemplate {

private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

public static String getClassTemplete(String packgeName,String className){
		   
	try{
				StringBuffer buffer = new StringBuffer();
				if(!"".equals(packgeName)){
					buffer.append("package ");
					buffer.append(packgeName);
					buffer.append(";");
					}
				buffer.append("\n\n");
				buffer.append("import org.apache.synapse.MessageContext; \n");
				buffer.append("import org.apache.synapse.mediators.AbstractMediator;\n\n");
				buffer.append("public class " + className +" extends AbstractMediator { \n\n\t" );
				//buffer.append(" \n\t");
				buffer.append("public boolean mediate(MessageContext context) { \n\t\t");
				buffer.append("// TODO Implement your mediation logic here \n\t\t");
				buffer.append("return true;\n\t");
				buffer.append("}\n}\n");
				return buffer.toString();
            }catch (Exception e){
              log.error(e);
              return"";
            }
	}
}
