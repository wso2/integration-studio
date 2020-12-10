package org.wso2.integrationstudio.datamapper.diagram.custom.generator.lang;

import java.util.ArrayList;
import java.util.List;

import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.ConcatOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.generator.MappingConfigGenerator;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMVariableType;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;

public class FunctoinBasedMappingConfigGenerator implements MappingConfigGenerator {

    @Override
    public String generateMappingConfig(DataMapperDiagramModel model) {
       
    	printModel(model);
        assignInputsandOutputsToOperators(model);

        DMConfig dmc = new DMConfig();
        DMFunction main = new DMFunction("map", "input" + model.getInputRootName(), "output" + model.getOutputRootName());

	    for (DMVariable outputvariable : model.getVariablesArray()) {
	    	if (outputvariable.getType() == DMVariableType.OUTPUT) {
	    		String right = getRightHandSideExpression(model, outputvariable);
	    		if (!right.isEmpty()) {
	    			main.getLines().add(new AssignmentLine(outputvariable.getName(), right));
	    		}
	    	}
	    }

        dmc.getFunctionsList().add(main);
        System.out.println(dmc.toString());
        return dmc.toString();
    }
    
    
    private String getRightHandSideExpression(DataMapperDiagramModel model, DMVariable outputvariable) {
		String rhs = "";
		DMOperation sourceOperation = getSourceOperation(outputvariable.getIndex(), model);
		if (sourceOperation != null)  {
			if (sourceOperation.getOperatorType() == DataMapperOperatorType.DIRECT){
				int variableIndex = sourceOperation.getInputs().get(0);
				DMVariable inputVar = model.getVariablesArray().get(variableIndex);
				rhs =  inputVar.getName();
			} else if (sourceOperation.getOperatorType() == DataMapperOperatorType.CONCAT){
				List<Integer> operatorInputs = sourceOperation.getInputs();
				List<DMVariable> operatorInputVariables = new ArrayList<DMVariable>();
				for (Integer input : operatorInputs){
					operatorInputVariables.add(model.getVariablesArray().get(input.intValue()));
				}
				if (isAllVariblesAreInputVariables(operatorInputVariables)){
					rhs = operatorInputVariables.get(0).getName() + ".concat(" + operatorInputVariables.get(1).getName() + ")";
				} else {
					List<String> rhsValues = new ArrayList<String>();
					for (DMVariable var : operatorInputVariables) {
						if (var.getType() == DMVariableType.INPUT) {
							rhsValues.add(var.getName());
						} else if (var.getType() == DMVariableType.INTERMEDIATE) {
							String innerFunctionCallResult = getRightHandSideExpression(model, var);
							rhsValues.add(innerFunctionCallResult);
						}
					}
					rhs = rhsValues.get(0) + ".concat(" + rhsValues.get(1)  + ")";
				}
			} else if (sourceOperation.getOperatorType() == DataMapperOperatorType.UPPERCASE){
				int variableIndex = sourceOperation.getInputs().get(0);
				DMVariable inputVar = model.getVariablesArray().get(variableIndex);
				if (inputVar.getType() == DMVariableType.INPUT) {
					rhs =  inputVar.getName() + ".toUpperCase()";
				} else if (inputVar.getType() == DMVariableType.INTERMEDIATE) {
					String innerFunctionCallResult = getRightHandSideExpression(model, inputVar);
					return "("+ innerFunctionCallResult + ").toUpperCase()";
				}
			}
		}
		
		return rhs;
	}

	private boolean isAllVariblesAreInputVariables(List<DMVariable> operatorInputVariables) {
		for (DMVariable var : operatorInputVariables) {
			if (var.getType() != DMVariableType.INPUT) {
				return false;
			}
		}
		return true;
	}
    

    @Override
    public boolean validate(DataMapperDiagramModel model) {
        // TODO Auto-generated method stub
        return true;
    }

    private void printModel(DataMapperDiagramModel model) {
        System.out.println("model.getInputAdjList()");
        for (List<Integer> ilist : model.getInputAdjList()) {
            System.out.println(ilist);
        }

        System.out.println("model.getOperationsList()");
        for (DMOperation operation : model.getOperationsList()) {
            System.out.println(operation);
        }
        
        System.out.println("model.getOutputAdjList()");
        for (List<Integer> olist : model.getOutputAdjList()) {
            System.out.println(olist);
        }

        System.out.println("model.getVariablesArray()");
        for (DMVariable variable : model.getVariablesArray()) {
            System.out.println(variable);
        }

    }

    private DMOperation getSourceOperation(int varIndex, DataMapperDiagramModel model) {
        int outLinkIndex = 0;
        for (List<Integer> olist : model.getOutputAdjList()) {
            for (Integer outputAdjacency : olist) {
                if (varIndex == outputAdjacency.intValue()) {
                    return model.getOperationsList().get(outLinkIndex);
                }
            }
            outLinkIndex++;
        }
        return null;
    }
    
   	private void assignInputsandOutputsToOperators(DataMapperDiagramModel model) {
		int operatorIndex = 0;
    	for (DMOperation operation : model.getOperationsList()) {
    		operation.setInputs(model.getInputAdjList().get(operatorIndex));
    		operation.setOutputs(model.getOutputAdjList().get(operatorIndex));
    		operatorIndex++;
    	}
    }

}
