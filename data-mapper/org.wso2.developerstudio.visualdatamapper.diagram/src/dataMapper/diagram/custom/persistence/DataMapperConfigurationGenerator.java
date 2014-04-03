package dataMapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import dataMapper.Concat;
import dataMapper.DataMapperLink;
import dataMapper.DataMapperRoot;
import dataMapper.Element;
import dataMapper.Equal;
import dataMapper.OperatorLeftConnector;
import dataMapper.TreeNode;
import dataMapper.diagram.part.DataMapperMultiPageEditor;

public class DataMapperConfigurationGenerator {
	

    public static String generateFunction(){
    	DataMapperRoot rootDiagram =  (DataMapperRoot) DataMapperMultiPageEditor.getGraphicalEditor().getDiagram().getElement();
    	TreeNode inputTreeNode = rootDiagram.getInput().getTreeNode().get(0);
    	TreeNode outputTreeNode = rootDiagram.getInput().getTreeNode().get(0);
    	
		String input = inputTreeNode.getName().split(",")[1];
		String output = outputTreeNode.getName().split(",")[1];
		
		String functionStart = "function map_S_"+input.toLowerCase()+"_S_"+output.toLowerCase()+"(input, output){\n";
		String functionReturn = "return output;\n";
		String functionEnd = "}\n";
		
		JsFunction dmcFunction = new JsFunction();
		dmcFunction.functionStart = functionStart;
		dmcFunction.functionReturn = functionReturn;
		dmcFunction.functionEnd = functionEnd;
		String dmcString = dmcFunction.getString();
		
		List<JsFunction> functions = getFunctionsForTheElements(rootDiagram.getInput().getTreeNode());
		dmcFunction.functions.addAll(functions);
		dmcString = dmcFunction.getString();
		
		return dmcString;
    }
    

    private static List<JsFunction> getFunctionsForTheElements(EList<TreeNode> eList){
    	
    	Iterator<TreeNode> treeNodeIterator =  eList.iterator();
    	List<JsFunction> functions = new ArrayList<JsFunction>() ;
		while(treeNodeIterator.hasNext()){
			TreeNode eListObject = treeNodeIterator.next();
			JsFunction func = getOnetoOneFunction(eListObject);
			if (func != null) {
				functions.add(func);
			}
			
			List<JsFunction> l2Functions = getFunctionsForTheElements(eListObject.getNode());
			functions.addAll(l2Functions);
    	} 	
    	return functions;
    }

	private static JsFunction getOnetoOneFunction(TreeNode treeNode) {
		
		JsFunction onetooneMappingFunc = new JsFunction();
		String collectionName = getInputSuperparentName(treeNode);
		String functionStart = "for (var x in " + collectionName+") { \n";
		onetooneMappingFunc.functionStart = functionStart;
		onetooneMappingFunc.functionEnd = "}\n";
		
		//for element
		Iterator<Element> elementIterator = treeNode.getElement().iterator();
		while(elementIterator.hasNext()){
			
			Element inputElement = elementIterator.next();
			EList<DataMapperLink> elementLinkList = inputElement.getOutNode().getOutgoingLink();
			
			Iterator<DataMapperLink> mapperLinkIterator = elementLinkList.iterator();
			while(mapperLinkIterator.hasNext()){
				DataMapperLink mapperLinkObject = mapperLinkIterator.next();
				if(mapperLinkObject.getInNode() != null){
					//element -----> element
					Element outputElement = mapperLinkObject.getInNode().getElementParent();
					if(outputElement != null){
						String mapStatement = getOnetoOneMappingStatement(inputElement, outputElement);
						onetooneMappingFunc.assignmentStatements.add(mapStatement);
					}	
				}
			}
			
		}
		return onetooneMappingFunc;
	}
	


	private static String getOnetoOneMappingStatement(Element inputElement, Element outputElement) {
		
		String outputParent = getOutputSuperparentName(outputElement.getFieldParent());
		String outputChild = outputElement.getName().split(",")[1];
		String inputParent = getInputSuperparentName(inputElement.getFieldParent());
		String inputChild = inputElement.getName().split(",")[1];
		String statement = outputParent +"[x]."+outputChild+"="+inputParent+"[x]."+inputChild +"\n";
		return statement;
	}
    
    private static String getInputSuperparentName(TreeNode node){
    	String temp = node.getName().split(",")[1];
    	while(node.getFieldParent() != null){
    		String name = node.getFieldParent().getName().split(",")[1];
    		temp = name + "." + temp;
    		node = node.getFieldParent();
    	}
    	temp = "input." + temp;
		return temp;
    }
    
    private static String getOutputSuperparentName(TreeNode node){
    	String temp = node.getName().split(",")[1];
    	while(node.getFieldParent() != null){
    		String name = node.getFieldParent().getName().split(",")[1];
    		temp = name + "." + temp;
    		node = node.getFieldParent();
    	}
    	temp = "output." + temp;
		return temp;
    }
    
    
    private static String getInputElementForLeft(OperatorLeftConnector leftConnector){
		return leftConnector.getInNode().getIncomingLink().get(0).getOutNode().getElementParent().getName().split(",")[1];
    	
    }
    private static String getOutputElementForRight(Equal equal) {
		return equal.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent().getName().split(",")[1];
	}
    
    private static String getOutputElementForRight(Concat concat) {
		return concat.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent().getName().split(",")[1];
	}
    
 
}