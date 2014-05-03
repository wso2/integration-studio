package org.wso2.developerstudio.datamapper.diagram.custom.configuration.operators;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.providers.LeftRightProvider;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.AssignmentStatement;

public class OneToOneTransformer implements OperatorsTransformer {

	private static final String INDEX = "[i]";

	

	@Override
	public AssignmentStatement transform(Operator operator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		EObject outputObject = getOutputObject(operator);
		EObject inputObject = getInputObject(operator);
		
		Element outputElement;
		TreeNode outputParent;
		Element inputElement ;
		
		if(inputObject instanceof Element && outputObject instanceof Element){
			outputElement = (Element)outputObject;
			outputParent = outputElement.getFieldParent();
			inputElement =  (Element) inputObject;
			
			outputParent = getOutputArrayParent(inputElement, outputParent);
			return outputParent;	
		}

		else if (inputObject instanceof Element && outputObject instanceof OperatorLeftConnector) {
			Operator nextOperator = (Operator)getOperator(outputObject);
			inputElement =  (Element) inputObject;
			OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(nextOperator);			
			outputParent = transformer.getOutputElementParent(nextOperator);
			outputParent = getOutputArrayParent(inputElement, outputParent);
			return outputParent;
		}
		else if (inputObject instanceof OperatorRightConnector && outputObject instanceof OperatorLeftConnector) {
			Operator nextOperator = (Operator)getOperator(outputObject);
			OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(nextOperator);			
			outputParent = transformer.getOutputElementParent(nextOperator);

			return outputParent;
		}
		
		else if (inputObject instanceof OperatorRightConnector && outputObject instanceof Element) {
			outputElement = (Element)outputObject;
			outputParent = outputElement.getFieldParent();
			return outputParent;
		}
		return null;
	}

	/**
	 * when input is an element of array treenode, the outputparent treenode also need to be an array
	 * @param inputElement input schema element
	 * @param outputParent 
	 * @return
	 */
	private TreeNode getOutputArrayParent(Element inputElement, TreeNode outputParent ){
		if (inputElement.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY) && !(outputParent.getSchemaDataType().equals(SchemaDataType.ARRAY))) {
			while (outputParent.getFieldParent() != null && !(outputParent.getSchemaDataType().equals(SchemaDataType.ARRAY))) {
				outputParent = outputParent.getFieldParent();
			}
		}
		
		return outputParent;
	}
	
	@Override
	public TreeNode getInputElementParent(Operator operator) {
		return getInputElement(operator).getFieldParent();
	}

	protected String getTreeHierarchy(TreeNode tree, TreeNode parent) {
		StringBuilder hierarchy = new StringBuilder();

		while (!(tree.equals(parent))) {
			hierarchy.insert(0, tree.getName());
			hierarchy.insert(0, ".");
			tree = tree.getFieldParent();
		}

		if (tree.getSchemaDataType().equals(SchemaDataType.ARRAY)) {
			hierarchy.insert(0, (tree.getName() + getIndex()));
		} else {
			hierarchy.insert(0, tree.getName());
		}

		return hierarchy.toString();

	}

	protected Element getOutputElement(Operator operator) {
		return operator.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
	}

	private Element getInputElement(Operator operator) {
		return operator.getBasicContainer().getLeftContainer().getLeftConnectors().get(0).getInNode().getIncomingLink().get(0).getOutNode().getElementParent();
	}

	protected EObject getInputObject(Operator operator) {
		EList<OperatorLeftConnector> leftConnectors = operator.getBasicContainer().getLeftContainer().getLeftConnectors();
		EObject inputObject = leftConnectors.get(0).getInNode().getIncomingLink().get(0).getOutNode().eContainer();
		return inputObject;
	}

	public EObject getOutputObject(Operator operator) {
		EList<OperatorRightConnector> rightConnectors = operator.getBasicContainer().getRightContainer().getRightConnectors();
		return rightConnectors.get(0).getOutNode().getOutgoingLink().get(0).getInNode().eContainer();
	}



	public static String getIndex() {
		return INDEX;
	}

	/**
	 * in three econtainers of a eobject would be an operator. it would be easy to declare it a class
	 * @param connector in or put node eobject
	 * @return operator which connected to in/out node
	 */
	public Operator getOperator(EObject connector) {
		return (Operator) connector.eContainer().eContainer().eContainer();
	}

	@Override
	public String trasnform(String statement, Operator operator, Operator nextOperator) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	


}
