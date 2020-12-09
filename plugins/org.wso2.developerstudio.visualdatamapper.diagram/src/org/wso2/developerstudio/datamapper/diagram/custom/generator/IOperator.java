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

import java.util.Map;

public interface IOperator {

	public void setName(OperatorName name);
	public OperatorName getName();
	public Map<Integer, Object> getInputMap();
	public Map<Integer, Object> getOutMap();
	public Map<Integer, IOperator>getPreviousOP();
	public  Map<Integer, IOperator> getNextOP();
	public void generateOutput();
	public String getDelimeter();
	public void setDelimeter(String delimeter);
}
