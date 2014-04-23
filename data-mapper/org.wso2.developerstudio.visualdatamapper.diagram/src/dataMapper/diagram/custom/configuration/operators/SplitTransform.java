package dataMapper.diagram.custom.configuration.operators;

import java.util.ArrayList;

import org.apache.commons.lang.WordUtils;
import org.eclipse.emf.common.util.EList;

import dataMapper.Element;
import dataMapper.Operator;
import dataMapper.OperatorRightConnector;
import dataMapper.SchemaDataType;
import dataMapper.Split;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.AssignmentStatement;

public class SplitTransform implements OperatorsTransformer {

	private static final String INDEX = "[i]"; 
	@Override
	public AssignmentStatement transform(Operator operator) {
		AssignmentStatement assign = new AssignmentStatement();
		StringBuilder statement = new StringBuilder();
		ArrayList<Element> splitOutputs = getOutputElements(operator);
		Element splitInput = getInputElement(operator);
		String index = "";
		if(splitInput.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY)){
			index = INDEX;
		}
		Split split = (Split) operator;
		int i=0;
		int splitArrayMapIndex = split.getArrayOutput() - 1;
		/**
		 * due to there can be different requirement with number of output connectors, it needs to iterate through all output connectors and build config assignments
		 */
		for(Element output : splitOutputs){
			
			//input parent name can be same as the output parent name. in that case we needs to append "output" string to output parent name.
			String outputParentName = "";
			String inputParentName = "";
			if(output != null ){
				
				outputParentName = output.getFieldParent().getName();
				inputParentName = splitInput.getFieldParent().getName();
			}
			
			/*
			 * If input parameter and output parameter names are identical,
			 * append term 'output' to the output parameter as a convention.
			 */
			if (outputParentName.equals(inputParentName)) {
				outputParentName = "output" + WordUtils.capitalize(outputParentName);
			}
			
			if (output != null && splitArrayMapIndex != i ) {
				if (split.getDelimiter() != null) {
					statement.append(outputParentName + index + "."
							+ output.getName() + " = " + inputParentName
							+ index + "." + splitInput.getName() + ".split(\""
							+ split.getDelimiter() + "\")" + "[" + i + "];");
					statement.append(System.lineSeparator());
					statement.append("\t\t");
				} 
				else {
					statement.append(outputParentName + index + "."
							+ output.getName() + " = " + inputParentName
							+ index + "." + splitInput.getName() + ".split(\"\")" + "[" + i
							+ "];");
					statement.append(System.lineSeparator());
					statement.append("\t\t");
				}
			}
			else if(output != null && splitArrayMapIndex == i){

				statement.append(outputParentName + index + "."+ output.getName() + " = new Array();");
				statement.append(System.lineSeparator());
				
				ArrayList<Integer> indexList = getUnmappedOutputNodes(operator);
				if (split.getDelimiter() != null) {
					for(Integer unmappedIndex : indexList){
						
						statement.append(outputParentName + index + "."
								+ output.getName() + ".push(" + inputParentName
								+ index + "." + splitInput.getName() + ".split(\""
								+ split.getDelimiter() + "\")" + "[" + unmappedIndex.intValue() + "]);");
						statement.append(System.lineSeparator());
						statement.append("\t\t");
					}
				} 
				else {
					for(Integer unmappedIndex : indexList){
						
						statement.append(outputParentName + index + "."
								+ output.getName() + " = " + inputParentName
								+ index + "." + splitInput.getName() + ".split(\"\")" + "[" + unmappedIndex.intValue()
								+ "];");
						statement.append(System.lineSeparator());
						statement.append("\t\t");
					}
				}
			}

			i++;
		}
		
		
		assign.setStatement(statement.toString());

		
		return assign;
	}
	
	/**
	 * mapped input element needs for create map statements
	 * @param operator split operator
	 * @return input element for split
	 */
	private Element getInputElement( Operator operator) {
		return operator.getBasicContainer().getLeftContainer().getLeftConnectors().get(0).getInNode().getIncomingLink().get(0).getOutNode().getElementParent();
	}
	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		return getOutputElements(operator).get(0).getFieldParent();
	}
	
	/**
	 * mapped output elements needs for create map statements
	 * @param operator split operator
	 * @return output elements which split results mapped
	 */
	private ArrayList<Element> getOutputElements(Operator operator) {
		EList<OperatorRightConnector> rightConnectors = operator.getBasicContainer().getRightContainer().getRightConnectors();
		ArrayList<Element> elementList = new ArrayList<Element>();
		for(OperatorRightConnector connector : rightConnectors){
			if(connector.getOutNode().getOutgoingLink().size() !=0){
				elementList.add(connector.getOutNode().getOutgoingLink().get(0).getInNode().getElementParent());
			}else {
				elementList.add(null);
			}
		}
		return elementList;
	}
	
//	private Operator getNextOperator(Operator currentOperator){
//		for (OperatorRightConnector connector : currentOperator.getBasicContainer().getRightContainer().getRightConnectors()){
//			if(connector.getOutNode().getOutgoingLink().size() != 0){
//				
//			}
//		}
//		return null;
//	}
	
	/**
	 * unmapped output nodes index needs when unmapped result array mapped to an element
	 * @param operator split operator
	 * @return unmapped output connector indexes of the operator
	 */
	private ArrayList<Integer> getUnmappedOutputNodes(Operator operator) {
		EList<OperatorRightConnector> rightConnectors = operator.getBasicContainer().getRightContainer().getRightConnectors();
		ArrayList<Integer> connectorList = new ArrayList<Integer>();
		int i=0;
		int j = ((Split) operator).getArrayOutput()-1;
		for(OperatorRightConnector connector : rightConnectors){
			if(connector.getOutNode().getOutgoingLink().size() ==0){
				connectorList.add(i);
			}
			else if(i == j){
				connectorList.add(i);
			}
			i++;
		}
		return connectorList;
	}

}
