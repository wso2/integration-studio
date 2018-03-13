/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.webui.core.model;

public class BrowserScript {

	protected String script;
	protected String functionName;
	protected String[] args;
	private String scriptName;

	public BrowserScript(String scriptName, String script) {
		this.scriptName = scriptName;
		this.script = script;
	}

	public BrowserScript(String functionName, String[] args) {
		this.scriptName = "Function Call:" + functionName;
		this.functionName = functionName;
		this.args = args;
		generateFunctionCallScript();
	}

	public String getScript() {
		return script;
	}

	private void generateFunctionCallScript() {
		if (functionName != null) {
			StringBuilder scriptBuilder = new StringBuilder();
			if (args != null) {
				String[] argNames = new String[args.length];
				for (int argIndex = 0; argIndex < args.length; argIndex++) {
					String argName = "arg" + argIndex;
					argNames[argIndex] = argName;
					scriptBuilder.append("var " + argName + " = \""
							+ args[argIndex] + "\";");
				}
				scriptBuilder.append(functionName + "(");
				for (int argNameIndex = 0; argNameIndex < argNames.length; argNameIndex++) {
					scriptBuilder.append(argNames[argNameIndex]);
					if (argNameIndex != (argNames.length - 1)) {
						scriptBuilder.append(", ");
					}
				}
				scriptBuilder.append(");");
			} else {
				scriptBuilder.append(functionName + "();");
			}
			this.script = scriptBuilder.toString();
		}
	}
	
	@Override
	public String toString() {
		return this.script;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
}
