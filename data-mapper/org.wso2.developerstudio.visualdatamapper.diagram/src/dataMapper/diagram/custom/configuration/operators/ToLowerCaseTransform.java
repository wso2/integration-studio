package dataMapper.diagram.custom.configuration.operators;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import dataMapper.Element;
import dataMapper.Operator;
import dataMapper.OperatorLeftConnector;
import dataMapper.OperatorRightConnector;
import dataMapper.SchemaDataType;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.AssignmentStatement;

public class ToLowerCaseTransform implements OperatorsTransformer{

	private static final String INDEX = "[i]"; 

	@Override
	public AssignmentStatement transform(Operator operator) {
		EObject lowerCaseInput = getInputObject(operator);
		
		
		if(lowerCaseInput instanceof Element){
			Element inputElement = (Element) lowerCaseInput;
			if(inputElement.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY)){
				String index = INDEX;
				return getSimpleOperatorMapping(operator, inputElement, index);
			}
			
			return getSimpleOperatorMapping(operator, inputElement);
			
		}
		else if(lowerCaseInput instanceof OperatorRightConnector){
			//FIXME implementation of operator chaining 
		}
		

		return null;
	}
	
	private Element getOutputElement( Operator operator) {
		return operator.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
	}
	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		return getOutputElement(operator).getFieldParent();
	}
	
	private EObject getInputObject(Operator operator) {
		EList<OperatorLeftConnector> leftConnectors = operator.getBasicContainer().getLeftContainer().getLeftConnectors();
		EObject inputObject = leftConnectors.get(0).getInNode().getIncomingLink().get(0).getOutNode().eContainer();
		return inputObject;
	}
	
	private Operator getInputOperator(EObject in){
		return (Operator)in.eContainer().eContainer().eContainer();
	}
	
	private AssignmentStatement getSimpleOperatorMapping(Operator operator, Element inputElement, String index){
		String assign = getOutputElementParent(operator).getName()+index+"."+getOutputElement(operator).getName()+" = "+inputElement.getFieldParent().getName()+index+"."+inputElement.getName()+".toLowerCase();";
		AssignmentStatement statement = new AssignmentStatement();
		statement.setStatement(assign);
		return statement;
	}
	
	private AssignmentStatement getSimpleOperatorMapping(Operator operator, Element inputElement){
		String assign = getOutputElementParent(operator).getName()+"."+getOutputElement(operator).getName()+" = "+inputElement.getFieldParent().getName()+"."+inputElement.getName()+".toLowerCase();";
		AssignmentStatement statement = new AssignmentStatement();
		statement.setStatement(assign);
		return statement;
	}
}
