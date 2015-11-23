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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.DataType;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class CodeManipulator {
	private IType type;
	private ICompilationUnit unit;
	
	private static List<String> primaryTypes = new ArrayList<String>();
	
	static{
		primaryTypes.add("void");
		primaryTypes.add("java.lang.String");
		primaryTypes.add("String");
		primaryTypes.add("byte");
		primaryTypes.add("short");
		primaryTypes.add("int");
		primaryTypes.add("long");
		primaryTypes.add("float");
		primaryTypes.add("double");
		primaryTypes.add("char");
		primaryTypes.add("String");
		primaryTypes.add("boolean");
	}

	public CodeManipulator(IType type) throws JavaModelException {
		unit = type.getCompilationUnit();
		unit.becomeWorkingCopy(null);
		this.type = unit.getType(type.getTypeQualifiedName());
	}
	
	public void commit() throws JavaModelException{
		unit.commitWorkingCopy(false, null);
	}
	
	public String getImport(String type) throws JavaModelException{
		String name = null;
		IImportDeclaration createImport = unit.getImport(type);
		if(primaryTypes.contains(type)){
			name = getUnqualifiedName(type);
		} else{
		if(!createImport.exists()){
			createImport = unit.createImport(type,null,null);
		}
		    name = getUnqualifiedName(createImport.getElementName());
		}
		return name;
	}
	
	public IMethod addHandlerMethod(String method, String returnType) throws JavaModelException{
		String methodSig = "public %s%s %s(%s requestContext) throws %s{\n";
		methodSig += "\t//TODO Auto-generated method stub \n";
		methodSig += ("void".equals(returnType))?"\t":"\treturn "; 
		methodSig += "super.%s(requestContext);\n}";
		methodSig = String.format(methodSig,
		                          getImport(returnType.replaceAll("\\[\\]$","")),
		                          (returnType.endsWith("[]")?"[]":""),
		                          method,
		                          getImport("org.wso2.carbon.registry.core.jdbc.handlers.RequestContext"),
		                          getImport("org.wso2.carbon.registry.core.exceptions.RegistryException"),
		                          method);
		return createMethod(methodSig);
	}
	
	public IMethod getHandlerMethod(String methodName) throws JavaModelException{
		IMethod method = type.getMethod(methodName,new String[]{"QRequestContext;"});
		if(method.exists()){
			return method;
		}
		return null;
	}
	
	public void removeHandlerMethod(String method) throws JavaModelException{
		removeMethod(method,"QRequestContext;");
	}
	
	public IMethod addHandlerProperty(String property, DataType dataType) throws JavaModelException{
		String parameterType = (dataType == DataType.STRING) ? "String": "org.apache.axiom.om.OMElement";
		String parameter =(property.matches("^\\d+") ? ("var" + property) : property ) + "Value";
		String methodSig = "public void  %s(%s %s){\n";
		methodSig += "//TODO add property set code \n";
		methodSig += "}";
		methodSig = String.format(methodSig,
		                          JavaUtils.getSetMethod(property),
		                          getImport(parameterType),
		                          parameter);
		return createMethod(methodSig);
	}
	
	public IMethod getHandlerProperty(String property, DataType dataType) throws JavaModelException{
		String parameterSig = (dataType == DataType.STRING) ? "QString;": "QOMElement;";
		IMethod method = type.getMethod(JavaUtils.getSetMethod(property),new String[]{parameterSig});
		if(method.exists()){
			return method;
		}
		return null;
	}
	
	public void removeHandlerProperty(String property, DataType dataType) throws JavaModelException{
		String parameterSig = (dataType == DataType.STRING) ? "QString;": "QOMElement;";
		removeMethod(JavaUtils.getSetMethod(property),parameterSig);
	}
	
	private IMethod createMethod(String content) throws JavaModelException{
		return type.createMethod(content, null, true, null);
	}
	
	private void removeMethod(String name, String... sig) throws JavaModelException{
		IMethod method = type.getMethod(name,sig);
		if(method.exists()){
			method.delete(true,null);
		}
	}
	
	private String getUnqualifiedName(String name){
		if (name.lastIndexOf('.') > 0) {
		    name = name.substring(name.lastIndexOf('.')+1);
		    name = name.replace('$', '.');
		}
		return name;
	}
	
	public IType getType(){
		return type;
	}
	

}
