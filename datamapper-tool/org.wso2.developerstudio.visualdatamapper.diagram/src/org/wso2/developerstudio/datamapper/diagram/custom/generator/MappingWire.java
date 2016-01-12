/*
 * Copyright 2005,2014 WSO2, Inc. http://www.wso2.org
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

package org.wso2.developerstudio.datamapper.diagram.custom.generator;

import java.util.HashMap;
import java.util.Map;

public class MappingWire {

	private Map<Integer, String> inputs;
	private Map<Integer, String> outputs;
	//private String name;
	private OperatorName operatorName;
	private IOperator operator;
	private Map<Integer, String> operatorNames;

	public MappingWire(OperatorName operatorName) {
		this.operatorName = operatorName;
		inputs = new HashMap<Integer, String>();
		outputs = new HashMap<Integer, String>();
		operatorNames = new HashMap<Integer, String>();
		
	}

	/**
	 * @return the inputs
	 */
	public Map<Integer, String> getInputs() {
		return inputs;
	}

	/**
	 * @return the outputs
	 */
	public Map<Integer, String> getOutputs() {
		return outputs;
	}

	/**
	 * @return the operatorName
	 */
	public OperatorName getOperatorName() {
		return operatorName;
	}

	public Map<Integer, String> getOperatorNames() {
		return operatorNames;
	}

	/**
	 * @return the operator
	 */
	public IOperator getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(IOperator operator) {
		this.operator = operator;
	}

}
