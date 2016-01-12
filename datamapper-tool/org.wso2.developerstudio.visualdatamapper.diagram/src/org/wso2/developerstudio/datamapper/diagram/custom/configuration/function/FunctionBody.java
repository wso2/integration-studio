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

package org.wso2.developerstudio.datamapper.diagram.custom.configuration.function;

import java.util.ArrayList;
import java.util.List;

public class FunctionBody {
	private List<AssignmentStatement> assignmentStatements;
	private List<ForLoop> forLoop;
	private List<String> functionCallStatements;

	public FunctionBody() {
		this.assignmentStatements = new ArrayList<AssignmentStatement>();
		this.forLoop = new ArrayList<ForLoop>();
		this.functionCallStatements = new ArrayList<String>();
	}

	public List<AssignmentStatement> getAssignmentStatements() {
		return assignmentStatements;
	}

	public void setAssignmentStatements(ArrayList<AssignmentStatement> assignmentStatements) {
		this.assignmentStatements = assignmentStatements;
	}

	public List<ForLoop> getForLoop() {
		return forLoop;
	}

	public void setForLoop(ArrayList<ForLoop> forLoop) {
		this.forLoop = forLoop;
	}

	public List<String> getFunctionCallStatements() {
		return functionCallStatements;
	}

	public void setFunctionCallStatements(List<String> functionCall) {
		this.functionCallStatements = functionCall;
	}

	@Override
	public String toString() {
		StringBuilder functionBody = new StringBuilder();
		
		for (AssignmentStatement assignment : getAssignmentStatements()) {
			functionBody.append("\t");
			functionBody.append(assignment.getStatement());
			functionBody.append(System.lineSeparator());
		}
		
		for(String callStatement : getFunctionCallStatements()) {
			functionBody.append("\t");
			functionBody.append(callStatement);
			functionBody.append(System.lineSeparator());
		}
		
		for (ForLoop loop : getForLoop()) {
			functionBody.append(loop.toString());
			functionBody.append("\n");
		}
		
		return functionBody.toString();
	}

}
