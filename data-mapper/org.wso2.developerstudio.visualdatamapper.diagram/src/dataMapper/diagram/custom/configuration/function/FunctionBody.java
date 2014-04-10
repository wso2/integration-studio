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

public class FunctionBody {
	private ArrayList<AssignmentStatement> assignmentStatements;
	private ArrayList<ForLoop> forLoop;
	
	
	public ArrayList<AssignmentStatement> getAssignmentStatements() {
		return assignmentStatements;
	}
	public void setAssignmentStatements(
			ArrayList<AssignmentStatement> assignmentStatements) {
		this.assignmentStatements = assignmentStatements;
	}
	public ArrayList<ForLoop> getForLoop() {
		return forLoop;
	}
	public void setForLoop(ArrayList<ForLoop> forLoop) {
		this.forLoop = forLoop;
	}
	
	
}
