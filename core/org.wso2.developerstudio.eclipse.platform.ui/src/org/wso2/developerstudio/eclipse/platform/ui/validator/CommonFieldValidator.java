/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.validator;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.apache.commons.validator.routines.UrlValidator;

public class CommonFieldValidator {

public static void validateJavaClassNameField(Object value) throws FieldValidationException{
	String className = value.toString();
	if ("".equals(className)) {
		throw new FieldValidationException("Class name cannot be empty");
	} else {
		if (!isJavaClassName(className)){
			throw new FieldValidationException("Class name is invalid");
		}
	}	
}

public static void validateJavaFQN(Object value) throws FieldValidationException{
	String className = value.toString();
	if ("".equals(className)) {
		throw new FieldValidationException("Class name cannot be empty");
	} else {
		if (!isJavaFQN(className)){
			throw new FieldValidationException("Class name is invalid");
		}
	}	
}

public static boolean isJavaClassName(String name){
	return name.matches("^[a-zA-Z_$][a-zA-Z\\d_$]*");
}

public static boolean isJavaFQN(String name){
	return name.matches("^([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*");
}

public static boolean isJavaPackageName(String name){
	return name.matches("([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*");
}

public static void validateJavaPackageNameField(Object value) throws FieldValidationException{
	String packageName = value.toString();
	if ("".equals(packageName)) {
		throw new FieldValidationException("Package name cannot be empty");
	}
	else {
		if (!isJavaPackageName(packageName)){
			throw new FieldValidationException("Package name is invalid");
		}
	}
}

public static void validateProjectField(Object value) throws FieldValidationException{
	if (value == null) {
		throw new FieldValidationException("Project name cannot be empty");
	}
	String projectName = value.toString();
	if (projectName.trim().equals("")) {
		throw new FieldValidationException("Project name cannot be empty");
	} else{
		if(projectName.indexOf(0x20)!=-1){
			throw new FieldValidationException("Project name cannot contain spaces");
		} else{
		    if(!isValidArtifactName(projectName)){
		    	throw new FieldValidationException("Project name cannot contain invalid characters(^/ : ; * # $ ? \" <> + $)");	
		    }
		}
	}
	IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

	if (project.exists()) {
		throw new FieldValidationException("Project with the name '" + projectName +
		                                   "' already exists");
	}
}

public static void isValidUrl(String url,String field) throws FieldValidationException{
	if(url.contains(":") && !url.startsWith(":") ){
		if(url.startsWith("http:") || url.startsWith("https:") || url.startsWith("ftp:")){
			UrlValidator urlValidator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
			if(!urlValidator.isValid(url)){
				if(!isParameter(url,true)){
					throw new FieldValidationException( field + ": Invalid URL provided");
				}
				
			}
		}
	} else{
		if(url.startsWith(":")){
			throw new FieldValidationException( field + ": Invalid URL provided");
		} else{
			if(!isParameter(url,false)){
				throw new FieldValidationException( field + ": Invalid URL provided");
			}
		}
	}
}

private static boolean isParameter(String field,boolean partial){
	Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
	Matcher matcher = pattern.matcher(field);
	boolean find=false;
	if(partial){
		while(matcher.find())
		{
			find=true;
			if(!isValidArtifactName(matcher.group(1).trim())){
				return false;
			}
		}
	} else{
		if( matcher.matches()){
			find= !matcher.group(1).trim().isEmpty();
		} else{
			int seq=0;
			matcher.reset();
			while(matcher.find())
			{
				find=true;
				String parameter = matcher.group(1).trim();
				if(!isValidArtifactName(parameter)){
					return false;
				}
				if(++seq==1){
					if(!field.startsWith("${" + parameter + "}")){
						return false;
					}
				}
				
			}
		}
		
	}
	return find;
}

	public static boolean isValidArtifactName(String name){
		Pattern pattern = Pattern.compile("^[^/\\ \\\\:@%\\^+;,=\\[\\{\\]\\}*#\\$?\"<>|\\(\\)]+$");
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}	
	
	public static void validateArtifactName(Object value) throws FieldValidationException{
		if (value == null) {
			throw new FieldValidationException("Artifact name cannot be empty");
		}
		String name = value.toString();
		if (name.trim().equals("")) {
			throw new FieldValidationException("Artifact name cannot be empty");
		} else{
			 if(!isValidArtifactName(name)){
				 throw new FieldValidationException("Artifact name cannot contain invalid characters (/:@%\\^+;,=*#[{]}$?\"<> +)");	 
			 }
		}
	}
	
	public static void validateRequiredField(Object value,String msg) throws FieldValidationException{
		if (value == null) {
			throw new FieldValidationException(msg);
		}
		String name = value.toString();
		if (name.trim().equals("")) {
			throw new FieldValidationException(msg);
		} 
	}
	
	public static void validateImportFile(Object value) throws FieldValidationException{
		if (value == null) {
			throw new FieldValidationException("Specified configuration file location is invalid");
		}
		String name = value.toString();
		if (name.trim().equals("")) {
			throw new FieldValidationException("Specified configuration file location is invalid");
		} else{
			File proxyFile = (File) value;
			if (!proxyFile.exists()) {
				throw new FieldValidationException("Specified configuration file doesn't exist");
			}	
		}
		 
	}
	
}
