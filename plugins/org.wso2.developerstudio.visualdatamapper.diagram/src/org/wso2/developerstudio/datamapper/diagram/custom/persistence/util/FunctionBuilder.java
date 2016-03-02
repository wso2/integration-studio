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

package org.wso2.developerstudio.datamapper.diagram.custom.persistence.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.AssignmentStatement;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.ForLoop;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.Function;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.FunctionBody;

public class FunctionBuilder {
	
	private static FunctionBuilder instance;
	
	private FunctionBuilder() {
		
	}
	
	public static FunctionBuilder getInstance() {
		if (instance == null) {
			instance = new FunctionBuilder();
		}
		
		return instance;
	}
	
	public String buildFunction(Function function) {
		StringBuilder functionBuilder = new StringBuilder();
		
		functionBuilder.append(function.getDeclaration());
		functionBuilder.append(System.lineSeparator());
		functionBuilder.append(buildFunctionBody(function.getFunctionBody()));
		functionBuilder.append(System.lineSeparator());
		if(StringUtils.isNotBlank(function.getReturnStatement())) {
			functionBuilder.append(function.getReturnStatement());
			functionBuilder.append(System.lineSeparator());
		}
		functionBuilder.append("}");
		functionBuilder.append(System.lineSeparator());
		
		return functionBuilder.toString();
	}
	
	private String buildFunctionBody(FunctionBody functionBody) {
		StringBuilder functionBodyBuilder = new StringBuilder();
		for(AssignmentStatement statement : functionBody.getAssignmentStatements()) {
			functionBodyBuilder.append(statement);
			functionBodyBuilder.append(System.lineSeparator());
		}
		functionBodyBuilder.append(buildForLoops(functionBody.getForLoop()));
		
		return functionBodyBuilder.toString();
	}
	
	private String buildForLoops(List<ForLoop> forLoops) {
		StringBuilder forLoopsBuilder = new StringBuilder();
		for (ForLoop forLoop : forLoops) {
			forLoopsBuilder.append(buildForLoop(forLoop));
		}
		
		return forLoopsBuilder.toString();
	}
	
	private String buildForLoop(ForLoop forLoop) {
		StringBuilder forLoopBuilder = new StringBuilder();
		forLoopBuilder.append(forLoop.getArguments());
		forLoopBuilder.append(System.lineSeparator());
		for (String functionCall : forLoop.getFunctionCall()) {
			forLoopBuilder.append(functionCall);
			forLoopBuilder.append(System.lineSeparator());
		}
		if (forLoop.getForLoop() != null) {
			forLoopBuilder.append(forLoop.getForLoop());
		}
		forLoopBuilder.append(System.lineSeparator());
		forLoopBuilder.append("}");
		
		return forLoopBuilder.toString();
	}

}
