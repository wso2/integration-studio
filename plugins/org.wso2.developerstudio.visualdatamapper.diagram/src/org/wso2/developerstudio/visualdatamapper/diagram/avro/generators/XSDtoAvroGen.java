/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.visualdatamapper.diagram.avro.generators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.security.Permission;

import com.sun.tools.xjc.Driver;

public class XSDtoAvroGen {
	private static final String TEMP_AVRO_GEN_LOCATION = "tempAvroGenLocation";
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
	/**
	 * The root directory to output generated files.
	 *
	 * @parameter
	 * @required
	 * @since 0.1
	 */
	private static File outputDirectory;
	/**
	 * A list of schema files to process.
	 *
	 * @parameter
	 * @required
	 * @since 0.1
	 */
	private static String schemaFiles;
	private static String packageName;
	private static String outputDirectoryString = System.getProperty(JAVA_IO_TMPDIR) + File.separator + TEMP_AVRO_GEN_LOCATION;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public String generateAVRO(String xsdFileLoc) {
		packageName = "generated.avro";
		schemaFiles = xsdFileLoc;
		outputDirectory = new File(outputDirectoryString);
		if (!outputDirectory.exists()) {
			outputDirectory.mkdir();
		}

		String args[] = buildArguments();
		try {
			// XJC blindly calls System.exit when it is finished.
			// This creates a work-around.
			SecurityManager oldSecurityManager = System.getSecurityManager();
			//System.setSecurityManager(new DelegatingNoExitSecurityManager(
				//	oldSecurityManager));
			 forbidSystemExitCall() ;
			try {
				Driver.main(args);
			} catch (DelegatingNoExitSecurityManager.NormalExitException ex) {
				log.error("Preventing the Driver executing system exit on finish" + ex);
				
			} finally {
				System.setSecurityManager(oldSecurityManager);
			}

		} catch (Exception ex) {
			log.error("Error in generating the JAXB java classes from the given XSD file, please recheck the generated XSD, "
					+ ex);
		}
		String changedOutput = AvroSchemagenPlugin.replaceNamespace(args[1], args[5]);

		// now consume the generated schemas
		File avroSchemaOutput = AvroSchemagenPlugin.getSchemaDirectory(outputDirectory);
		if (!avroSchemaOutput.exists()) {
		}

		File outputDir = new File(outputDirectoryString);
		try {
			FileUtils.deleteDirectory(outputDir);
		} catch (IOException e) {
			log.equals("could not delete the directory with JAXB java and Generated Avro content at : "
					+ outputDirectoryString + e);
		}

		return changedOutput;
	}

	private void forbidSystemExitCall() {
		ExitTrappedException.forbidSystemExitCall();
	}

	private static String[] buildArguments() {
		List<String> args = new ArrayList<String>();

		// package name
		if (packageName != null && !packageName.trim().isEmpty()) {
			args.add("-p");
			args.add(packageName);
		}

		// use our plugin
		args.add("-" + AvroSchemagenPlugin.PLUGIN_NAME);

		// output directory
		args.add("-d");
		args.add(outputDirectoryString);

		// schema files
		File schemaFile = new File(schemaFiles);
		args.add(makeRelativePath(schemaFile));

		// info output
		StringBuilder command = new StringBuilder();
		for (String arg : args) {
			command.append(arg).append(" ");
		}

		return args.toArray(new String[args.size()]);
	}

	private static String makeRelativePath(File file) {
		File cur = new File("");
		String curPath = cur.getAbsolutePath();
		String filePath = file.getAbsolutePath();

		if (filePath.startsWith(curPath)) {
			return filePath.substring(curPath.length() + 1);
		} else {
			return filePath;
		}
	}
	
	
	private static class ExitTrappedException extends SecurityException {

		private static final String EXIT_VM_COMMAND = "exitVM";
		private static final String SYSTEM_EXIT_COMMAND = "exitVM.-1";

		private static void forbidSystemExitCall() {
		  final SecurityManager securityManager = new SecurityManager() {
		    public void checkPermission( Permission permission ) {
		      if( SYSTEM_EXIT_COMMAND.equals( permission.getName()) || permission.getName().contains(EXIT_VM_COMMAND)) {
		        throw new ExitTrappedException() ;
		      } 
		    }
		  } ;
		  System.setSecurityManager( securityManager ) ;
		}

		private static void enableSystemExitCall() {
		  System.setSecurityManager( null ) ;
		}
	}

}
