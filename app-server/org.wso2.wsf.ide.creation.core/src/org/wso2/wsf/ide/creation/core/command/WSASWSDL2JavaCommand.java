/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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
package org.wso2.wsf.ide.creation.core.command;

import java.io.File;
import java.util.Map;

import javax.wsdl.Definition;

import org.apache.axis2.description.AxisService;
import org.apache.axis2.util.URLProcessor;
import org.apache.axis2.wsdl.codegen.CodeGenConfiguration;
import org.apache.axis2.wsdl.codegen.CodeGenerationEngine;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.command.internal.env.core.common.StatusUtils;
import org.eclipse.wst.common.environment.IEnvironment;
import org.eclipse.wst.common.environment.IStatusHandler;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.wsf.ide.consumption.core.utils.ContentCopyUtils;
import org.wso2.wsf.ide.consumption.core.utils.WSDL2JavaGenerator;
import org.wso2.wsf.ide.consumption.core.utils.WSDLPropertyReader;
import org.wso2.wsf.ide.creation.core.data.DataModel;
import org.wso2.wsf.ide.creation.core.messages.WSASCreationUIMessages;
import org.wso2.wsf.ide.creation.core.utils.PathLoadingUtil;

public class WSASWSDL2JavaCommand extends AbstractDataModelOperation {
	
	  private DataModel model;
		
	  public WSASWSDL2JavaCommand( DataModel model ){
	    this.model = model;  
	  }


	public IStatus execute(IProgressMonitor monitor, IAdaptable info)
													 throws ExecutionException {
		
		IStatus status = Status.OK_STATUS;  
		IEnvironment environment = getEnvironment();
		IStatusHandler statusHandler = environment.getStatusHandler();	
		
		PathLoadingUtil.init(model);
		String tempCodegenOutputLocation =PathLoadingUtil.getTempCodegenOutputLocation();
		String currentDynamicWebProjectDir = model.getWebProject().getLocation().toOSString();
		
		File tempCodegenLocationFile = new File(tempCodegenOutputLocation);
		if (tempCodegenLocationFile.exists())FileUtils.deleteDirectories(tempCodegenOutputLocation);
		FileUtils.createDirectorys(tempCodegenOutputLocation);
        WSDL2JavaGenerator generator = new WSDL2JavaGenerator(); 
        IPath[] javaSourceDirectories = null;
		try {
			javaSourceDirectories = JavaUtils.getJavaSourceDirectories(model.getWebProject());

			//AxisService service;
	        AxisService axisServiceInstance;
	        
			//service = generator.getAxisService(model.getWsdlURI());
	//		ClassLoadingUtil.init();
			axisServiceInstance = generator.getAxisService(model.getWsdlURI(),model.getPortName());
	        Map optionsMap = generator.fillOptionMap(	
	        	false,  //async always false
	            false,	//sync always false
	            true,   //is serverside true
	            model.isServerXMLCheck(),
	            model.isTestCaseCheck(),
	            model.isGenerateAllCheck(),
	            (model.getServiceName()!=null)?model.getServiceName():null,
	            (model.getPortName()!=null)?model.getPortName():null,
	            (model.getDatabindingType().toLowerCase()!=null)?
	            		model.getDatabindingType().toLowerCase():
	            		null,
	            (model.getWsdlURI()!=null)?model.getWsdlURI():null,
	            (model.getPackageText()!=null)?model.getPackageText():null,
	            "java",
	            tempCodegenOutputLocation,
	            javaSourceDirectories[0].removeFirstSegments(1).toOSString(),
	            model.getNamespaseToPackageMapping(),
	            model.isGenerateServerSideInterface(),
	            model.isUnpackDatabindingClasses(),
	            model.isSwitchOnUnwrapping(),
	            model.isNoBuildXml(),
	            model.isNoWSDL(),
	            model.isNoMessageReceiver()
	          );
			
			CodeGenConfiguration codeGenConfiguration=new CodeGenConfiguration(optionsMap);
			codeGenConfiguration.addAxisService(axisServiceInstance);
			
	        //set the wsdl definision for codegen config for skeleton generarion.
	        WSDLPropertyReader reader = new WSDLPropertyReader();
	        reader.readWSDL(model.getWebProjectName(),model.getWsdlURI());
	        Definition wsdlDefinitionInstance = reader.getWsdlDefinitionInstance();
			codeGenConfiguration.setWsdlDefinition(wsdlDefinitionInstance);
			
			codeGenConfiguration.setBaseURI(model.getWsdlURI());
			
			
			String packageName = null;
			if (model.getPackageText()!=null) {
				packageName = model.getPackageText();
			}else{
				String targetNamespace = axisServiceInstance.getTargetNamespace();
				packageName=URLProcessor.makePackageName(targetNamespace);
				model.setPackageText(packageName);
			}
			codeGenConfiguration.setPackageName(packageName.toString());
			
			CodeGenerationEngine codeGenerationEngine=new CodeGenerationEngine(codeGenConfiguration);
			codeGenerationEngine.generate();
	        
			//Copy the existing codegen results to the current project
	        ContentCopyUtils contentCopyUtils = new ContentCopyUtils();
		    status = contentCopyUtils.copyDirectoryRecursivelyIntoWorkspace(
		    							tempCodegenOutputLocation, 
		    							currentDynamicWebProjectDir, 
		    							monitor, 
		    							statusHandler);
	
	        
		} catch (Exception e) {
			status = StatusUtils.errorStatus(NLS.bind(
												WSASCreationUIMessages.ERROR_CODEGEN_EXCEPTION,
												new String[]{" : "+e.getCause().getMessage()}),
											e);
			environment.getStatusHandler().reportError(status); 
		}
		
		return status;
	}

}
