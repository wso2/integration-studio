package dataMapper.diagram.custom.configuration.operators;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;

import dataMapper.Element;
import dataMapper.Operator;
import dataMapper.OperatorRightConnector;
import dataMapper.SchemaDataType;
import dataMapper.Split;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.AssignmentStatement;

public class SplitTransform implements OperatorsTransformer {

	@Override
	public AssignmentStatement transform(Operator operator) {
		AssignmentStatement assign = new AssignmentStatement();
		StringBuilder statement = new StringBuilder();
		ArrayList<Element> splitOutputs = getOutputElements(operator);
		Element splitInput = getInputElement(operator);
		String index = "";
		if(splitInput.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY)){
			index = "[i]";
		}
		Split split = (Split) operator;
		int i=0;
		for(Element output : splitOutputs){
			if(split.getDelimiter() != null){
				statement.append(output.getFieldParent().getName()+index+"."+output.getName()+ " = " + splitInput.getFieldParent().getName()+index+"."+splitInput.getName()+".split(\""+split.getDelimiter()+"\")"+"["+i+"];\n");				
			}
			else {
				statement.append(output.getFieldParent().getName()+index+"."+output.getName()+ " = " + splitInput.getFieldParent().getName()+index+"."+splitInput.getName()+".split(\"\")"+"["+i+"];\n");
			}
			i++;
		}
		
		assign.setStatement(statement.toString());
		return assign;
	}
	
	private Element getInputElement( Operator operator) {
		return operator.getBasicContainer().getLeftContainer().getLeftConnectors().get(0).getInNode().getIncomingLink().get(0).getOutNode().getElementParent();
	}
	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		return getOutputElements(operator).get(0).getFieldParent();
	}
	
	private ArrayList<Element> getOutputElements(Operator operator) {
		EList<OperatorRightConnector> rightConnectors = operator.getBasicContainer().getRightContainer().getRightConnectors();
		ArrayList<Element> elementList = new ArrayList<Element>();
		for(OperatorRightConnector connector : rightConnectors){
			if(connector.getOutNode().getOutgoingLink().size() !=0){
				elementList.add(connector.getOutNode().getOutgoingLink().get(0).getInNode().getElementParent());
			}
		}
		return elementList;
	}

}
