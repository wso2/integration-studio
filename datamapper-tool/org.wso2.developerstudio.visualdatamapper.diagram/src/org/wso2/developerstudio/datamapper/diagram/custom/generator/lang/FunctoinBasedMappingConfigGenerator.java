package org.wso2.developerstudio.datamapper.diagram.custom.generator.lang;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.ConcatOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.MappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperatorType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;

public class FunctoinBasedMappingConfigGenerator implements MappingConfigGenerator {

    @Override
    public String generateMappingConfig(DataMapperDiagramModel model) {
        printModel(model);

        int operatorIndex = 0;
        for (DMOperation operation : model.getOperationsList()) {
            operation.setInputs(model.getInputAdjList().get(operatorIndex));
            operation.setOutputs(model.getOutputAdjList().get(operatorIndex));
            operatorIndex++;
        }

        DMConfig dmc = new DMConfig();
        DMFunction main = new DMFunction("map", "input" + model.getInputRootName(), "output"
                + model.getOutputRootName());

        int varIndex = 0;
        for (DMVariable outputvariable : model.getVariablesArray()) {
            String outputVarName = outputvariable.getName();
            if (outputVarName.startsWith("output")) {
                DMOperation sourceOperation = getSourceOperation(varIndex, model);
                if (sourceOperation.getOperatorType() == DMOperatorType.DIRECT) {
                    int variableIndex = sourceOperation.getInputs().get(0);
                    DMVariable inputVar = model.getVariablesArray().get(variableIndex);
                    main.getLines().add(new AssignmentLine(outputVarName, inputVar.getName()));
                } else if (sourceOperation.getOperatorType() == DMOperatorType.CONCAT) {
                    List<Integer> operatorInputs = sourceOperation.getInputs();
                    List<DMVariable> operatorInputVariables = new ArrayList<DMVariable>();
                    for (Integer input : operatorInputs) {
                        operatorInputVariables.add(model.getVariablesArray().get(input.intValue()));
                    }
                    String right = new ConcatOperatorTransformer().generateScriptForOperation(
                            FunctoinBasedMappingConfigGenerator.class, operatorInputVariables);
                    main.getLines().add(new AssignmentLine(outputVarName, right));
                }
            }
            varIndex++;
        }

        dmc.getFunctionsList().add(main);
        System.out.println(dmc.toString());

        return dmc.toString();
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

        System.out.println("model.getOutputAdjList()");
        for (List<Integer> olist : model.getOutputAdjList()) {
            System.out.println(olist);
        }

        System.out.println("model.getVariablesArray()");
        for (DMVariable variable : model.getVariablesArray()) {
            System.out.println(variable);
        }

        System.out.println("model.getInputVariablesArray()");
        for (Integer variable : model.getInputVariablesArray()) {
            System.out.println(variable);
        }

        System.out.println("model.getOperationsList()");
        for (DMOperation operation : model.getOperationsList()) {
            System.out.println(operation);
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

}
