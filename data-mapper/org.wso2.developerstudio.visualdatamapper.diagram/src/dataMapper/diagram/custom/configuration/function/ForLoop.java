/*
 * Copyright 2014 WSO2, Inc. (http://wso2.com)
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

package dataMapper.diagram.custom.configuration.function;

import java.util.ArrayList;

public class ForLoop {
	private String arguments;
	private ArrayList<String> functionCall;
	private ForLoop forLoop;
	
	public String getArguments() {
		return arguments;
	}
	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
	public ArrayList<String> getFunctionCall() {
		return functionCall;
	}
	public void setFunctionCall(ArrayList<String> functionCall) {
		this.functionCall = functionCall;
	}
	public ForLoop getForLoop() {
		return forLoop;
	}
	public void setForLoop(ForLoop forLoop) {
		this.forLoop = forLoop;
	}
	
}
