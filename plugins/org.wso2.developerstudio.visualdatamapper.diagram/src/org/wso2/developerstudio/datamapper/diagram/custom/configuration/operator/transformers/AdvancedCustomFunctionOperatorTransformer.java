package org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.DifferentLevelArrayMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

public class AdvancedCustomFunctionOperatorTransformer extends AbstractDMOperatorTransformer {

	@Override
	public String generateScriptForOperation(Class<?> generatorClass, List<DMVariable> inputVariables,
			List<DMVariable> outputVariables, Map<String, List<SchemaDataType>> variableTypeMap,
			Stack<ForLoopBean> parentForLoopBeanStack, DMOperation operator, List<ForLoopBean> forLoopBeanList,
			Map<String, Integer> outputArrayVariableForLoop,
			Map<String, Integer> outputArrayRootVariableForLoop, List<String> unNamedVariables)
			throws DataMapperException {
		StringBuilder operationBuilder = new StringBuilder();
		operationBuilder.append(appendOutputVariable(operator, outputVariables, variableTypeMap, parentForLoopBeanStack,
				forLoopBeanList, outputArrayVariableForLoop, outputArrayRootVariableForLoop,
				unNamedVariables));
		List<String> variableList = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Stack<ForLoopBean> tempParentForLoopBeanStack = (Stack<ForLoopBean>) parentForLoopBeanStack.clone();
		for (DMVariable inputVariable : inputVariables) {
			variableList.add(ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariable, variableTypeMap,
					tempParentForLoopBeanStack, true, forLoopBeanList, outputArrayVariableForLoop, 
					outputArrayRootVariableForLoop, unNamedVariables));
		}
		if (DifferentLevelArrayMappingConfigGenerator.class.equals(generatorClass)) {
			operationBuilder.append(operator.getProperty(TransformerConstants.CUSTOM_FUNCTION_NAME) + "(");
			for (int i = 0; i < variableList.size(); i++) {
				operationBuilder.append(variableList.get(i));
				if (i < variableList.size() - 1) {
					operationBuilder.append(",");
				}
			}
			operationBuilder.append(");");
		} else {
			throw new IllegalArgumentException("Unknown MappingConfigGenerator type found : " + generatorClass);
		}
		return operationBuilder.toString();
	}
	
}
