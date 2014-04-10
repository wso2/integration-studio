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

package dataMapper.diagram.custom.persistence;

import dataMapper.DataMapperRoot;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.Function;

public class MappingModelTraverser {

	private static MappingModelTraverser instance;

	private MappingModelTraverser() {

	}

	public static MappingModelTraverser getInstance() {
		if (instance == null) {
			instance = new MappingModelTraverser();
		}

		return instance;
	}

	public void traverse(DataMapperRoot rootDiagram, DataMapperConfiguration mappingConfig) {
		Function mainFunction = createMainFunction(rootDiagram.getInput().getTreeNode().get(0),
				rootDiagram.getOutput().getTreeNode().get(0));

		if (mainFunction != null) {
			mappingConfig.getFunctionList().add(mainFunction);
		} else {
			return;
		}
	}

	private Function createMainFunction(TreeNode inputTreeNode, TreeNode outputTreeNode) {
		Function mainFunction = null;
		if (OperatorConfigurationUtil.isChildrenMaped(inputTreeNode)) {
			mainFunction = new Function();

			mainFunction.setInputParameter(inputTreeNode);
			mainFunction.setOutputParameter(outputTreeNode);
			
			

		}
		
		return mainFunction;
	}
}
