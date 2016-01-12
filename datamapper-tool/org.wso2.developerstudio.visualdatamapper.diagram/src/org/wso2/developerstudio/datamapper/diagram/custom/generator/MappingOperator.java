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

public class MappingOperator implements IOperator {
   
	private Map<Integer, Object> inputs;
	private OperatorName name;
	private Map<Integer, Object> output; 
	private  Map<Integer, IOperator> previos;
	private  Map<Integer, IOperator> next;
	private String delimeter;
	public MappingOperator(OperatorName concat) {
		setName(concat);
		inputs = new HashMap<Integer, Object>();
		output = new HashMap<Integer, Object>();
		previos =new HashMap<Integer, IOperator>();
		next = new HashMap<Integer, IOperator>();
	}

	public Map<Integer, Object> getInputMap() {
		// TODO Auto-generated method stub
		return inputs;
	}

	/**
	 * @return the name
	 */
	public OperatorName getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(OperatorName name) {
		this.name = name;
	}

	@Override
	public Map<Integer, Object> getOutMap() {
		// TODO Auto-generated method stub
		return output;
	}
	@Override
	public  Map<Integer, IOperator> getPreviousOP() {
		// TODO Auto-generated method stub
		return previos;
	}

	@Override
	public  Map<Integer, IOperator> getNextOP() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public void generateOutput() {
		// TODO Auto-generated method stub
		
	}

	public String getDelimeter() {
		return delimeter;
	}

	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}


}

