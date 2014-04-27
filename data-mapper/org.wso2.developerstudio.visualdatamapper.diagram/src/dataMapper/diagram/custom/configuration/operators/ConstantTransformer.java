package dataMapper.diagram.custom.configuration.operators;

import dataMapper.Constant;
import dataMapper.Element;
import dataMapper.Operator;
import dataMapper.OutNode;
import dataMapper.SchemaDataType;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.AssignmentStatement;

public class ConstantTransformer implements OperatorsTransformer {

	private static final String INDEX = "[i]";
	
	@Override
	public AssignmentStatement transform(Operator operator) {
		StringBuilder assign = new StringBuilder();
		Constant constant = (Constant) operator;
		assign.append(getTreeHierarchy(getOutputElementParent(operator), getOutputRoot(operator))).append(".").append(getOutpuElement(operator).getName()).append(" = \"").append(constant.getConstantValue()).append("\";\n");                                           
		AssignmentStatement statment = new AssignmentStatement();
		statment.setStatement(assign.toString());
		return statment;
	}

	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		if(getOutpuElement(operator) != null){
			return getOutpuElement(operator).getFieldParent();
		}
		
		return null;
	}
	
	private Element getOutpuElement(Operator operator) {
		if(operator.getBasicContainer().getRightContainer().getRightConnectors().size() !=0){
			return operator.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
		}
		return null;
	}

	@Override
	public TreeNode getInputElementParent(Operator operator) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getTreeHierarchy(TreeNode tree, TreeNode parent) {
		StringBuilder hierarchy = new StringBuilder();

		while (!(tree.equals(parent))) {
			if(tree.getSchemaDataType().equals(SchemaDataType.ARRAY)){
				hierarchy.insert(0, (tree.getName()+INDEX));
			}else{
				
				hierarchy.insert(0, tree.getName());
			}
			hierarchy.insert(0, ".");
			tree = tree.getFieldParent();
		}
		
		if(tree.getSchemaDataType().equals(SchemaDataType.ARRAY)){
			hierarchy.insert(0, (tree.getName()+INDEX));
		}
		else {
			hierarchy.insert(0, tree.getName());
		}

		return hierarchy.toString();

	}
	
	private TreeNode getOutputRoot(Operator operator){
		TreeNode tree = getOutputElementParent(operator);
		while(tree.getFieldParent() != null){
			tree = tree.getFieldParent();
			System.out.println();
		}
		
		return tree;
	}

}
