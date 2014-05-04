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

package org.wso2.developerstudio.datamapper.diagram.custom.configuration.operators;

import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.AssignmentStatement;

public interface OperatorsTransformer {
	/**
	 * depend on operator, the config build logic must implement
	 * @param operator the operator 
	 * @return	config assignment which can execute 
	 */
	public AssignmentStatement transform(Operator operator); 
	
	/**
	 * output parent would be change due to complexity of map.
	 * its needs to identify the correct parent tree node for build the config function
	 * @param operator	the operator used to map
	 * @return parent tree node of output schema which consider for build config function
	 */
	public TreeNode getOutputElementParent(Operator operator);
	
	/**
	 * input parent would be change due to complexity of map.
	 * its needs to identify the correct parent tree node for build the config function
	 * @param operator	the operator used to map
	 * @return parent tree node of input schema which consider for build config function
	 */ 
	public TreeNode getInputElementParent(Operator operator);

	/**
	 * transform of an operator in chaining needs to be handle with already created config assignment
	 * @param statement already created config for chain
	 * @param operator	the operator which created statement
	 * @param nextOperator	the next operator 
	 * @return  configuration which have been created
	 */
	public String trasnform(String statement, Operator operator, Operator nextOperator);
}
