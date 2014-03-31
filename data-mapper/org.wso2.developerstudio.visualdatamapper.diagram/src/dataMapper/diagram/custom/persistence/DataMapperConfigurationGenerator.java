package dataMapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import dataMapper.Attribute;
import dataMapper.Concat;
import dataMapper.DataMapperLink;
import dataMapper.DataMapperRoot;
import dataMapper.Element;
import dataMapper.Equal;
import dataMapper.InNode;
import dataMapper.OperatorLeftConnector;
import dataMapper.OutNode;
import dataMapper.Output;
import dataMapper.TreeNode;
import dataMapper.diagram.part.DataMapperMultiPageEditor;
import dataMapper.diagram.tree.generator.TreeFromAVSC;
import dataMapper.diagram.tree.generator.TreeFromAvro;

public class DataMapperConfigurationGenerator {
	
	private static ArrayList<Integer> OPERATION_LIST = new ArrayList<Integer>();
	/*
	 * 
	 * generated NOT go through each tree ,element, attribute of InPut and find
	 * for link if link exist, find connected Output element, attribute for it
	 * get the tree list of OutPut element hirachy
	 */
	// FIXME if link connected to operator, aware of that and build relavent
	// configuration script
    /*
     * function generator
     */
    

    public static String generateFunction(){
    	DataMapperRoot rootDiagram =  (DataMapperRoot) DataMapperMultiPageEditor.getGraphicalEditor().getDiagram().getElement();
		String input = rootDiagram.getInput().getTreeNode().get(0).getName().split(",")[1];
		String output = rootDiagram.getOutput().getTreeNode().get(0).getName().split(",")[1];
		OPERATION_LIST.clear();
		ArrayList<String> actionList = new ArrayList<String>();
		actionList = findForAction(rootDiagram.getInput().getTreeNode());

		String allActions = "";
		
		ListIterator<String> actionitarator = actionList.listIterator();
		while(actionitarator.hasNext()){
			allActions = allActions+ actionitarator.next()+"\n";
		}
		
		String flagLSInput = "S"; // @param for set List or Single flag in configuration
		if(TreeFromAvro.multipleData)
			flagLSInput = "L";
		
		String function = "function map_"+flagLSInput+"_"+input.toLowerCase()+"_"+flagLSInput+"_"+output.toLowerCase()+"( "+"input" +" , "+"output"+" ){ \n \t"+ allActions.toLowerCase()+" \n \t return output;"+" \n}";
		return function;
    }
    
    /*
     *  
     * generated NOT
     * go through each tree ,element, attribute of InPut and find for link
     * if link exist, find connected Output element, attribute for it
     * get the tree list of OutPut element hirachy
     *  
     */
//    FIXME if link connected to operator, aware of that and build relavent configuration script 
    private static ArrayList<String> findForAction(EList<TreeNode> eList){
    	
    	Iterator<TreeNode> treeNodeIterator =  eList.iterator();
    	ArrayList<String> actionList = new ArrayList<String>();
		while(treeNodeIterator.hasNext()){
    		//for tree
    		TreeNode eListObject = treeNodeIterator.next();
    		ArrayList<String> tempList = findForAction(eListObject .getNode());

    		 actionList.addAll(tempList);
    		 ArrayList<String> forLoopActionList = new ArrayList<String>(); 
    		 /*
    		  * get A/E , gets its outnode., check for links connected to tht node, if connected gets links Innode, get Innode connected A/E, gets A/E parent tree, get hierachical tree of tht until get Output. 
    		  */
    		
    		//for atribute
    		Iterator<Attribute> attributeIterator = eListObject.getAttribute().iterator();   		
    		while(attributeIterator.hasNext()){
    			Attribute attributeIteratorObject = attributeIterator.next();
    			EList<DataMapperLink> attributeLinkList = attributeIteratorObject.getOutNode().getOutgoingLink();
    			
    			Iterator<DataMapperLink> mapperLinkIterator = attributeLinkList.iterator();    			
    			while(mapperLinkIterator.hasNext()){
    				DataMapperLink mapperLinkObject = mapperLinkIterator.next();
    				if(mapperLinkObject.getInNode() != null){

    					
    					//atribute -----> element
    					if(mapperLinkObject.getInNode().getElementParent() !=null){
	    					Element outputElement = mapperLinkObject.getInNode().getElementParent();
	    					
	    					//tree.attribute --------> tree.element
	    					String action = goUpOnOutputTree(outputElement.getFieldParent())+outputElement.getName().split(",")[1]+"="+ goUpOnInputTree(eListObject)+attributeIteratorObject.getName().split(",")[1];
	    					actionList.add(action);
    				
    					}
    					//atribute -----> attribute
    					else if(mapperLinkObject.getInNode().getAttributeParent() !=null){
	    					 Attribute outputAttribute = mapperLinkObject.getInNode().getAttributeParent();
	    					
	    					//tree.attribute --------> tree.attribute
	    					String action = goUpOnOutputTree(outputAttribute.getFieldParent())+outputAttribute.getName().split(",")[1]+"="+ goUpOnInputTree(eListObject)+attributeIteratorObject.getName().split(",")[1];
	    					actionList.add(action);;
    					}

    				}
    			}//end itrt links atribute
    		}//end iterat attribut
    		
    		//for element
    		Iterator<Element> elementIterator = eListObject.getElement().iterator();
    		while(elementIterator.hasNext()){
    			Element elementIteratorObject = elementIterator.next();
    			EList<DataMapperLink> elementLinkList = elementIteratorObject.getOutNode().getOutgoingLink();
    			Iterator<DataMapperLink> mapperLinkIterator = elementLinkList.iterator();
    			
    			while(mapperLinkIterator.hasNext()){
    				DataMapperLink mapperLinkObject = mapperLinkIterator.next();
    				if(mapperLinkObject.getInNode() != null){
    					//element -----> element
    					if(mapperLinkObject.getInNode().getElementParent() != null){
	    					Element outputElement = mapperLinkObject.getInNode().getElementParent();
	    					//tree.element --------> tree.element
	    					if(TreeFromAVSC.multipleChunk.contains(eListObject.getName().split(",")[1])){
	    						String action = goUpOnOutputTreeForLoop(outputElement.getFieldParent())+"[x]."+outputElement.getName().split(",")[1]+"="+goUpOnInputTreeForLoop(eListObject)+"[x]."+elementIteratorObject.getName().split(",")[1];
//	    						String action = goUpOnOutputTree(outputElement.getFieldParent())+outputElement.getName().split(",")[1]+" = "+ goUpOnInputTree(eListObject)+elementIteratorObject.getName().split(",")[1];
		    					forLoopActionList.add(action);
	    					}else{
	    					
		    					String action = goUpOnOutputTree(outputElement.getFieldParent())+outputElement.getName().split(",")[1]+" = "+ goUpOnInputTree(eListObject)+elementIteratorObject.getName().split(",")[1]+";";
		    					actionList.add(action);
	    					}
    					}
    					
    					//element -----> attribute
    					else if(mapperLinkObject.getInNode().getAttributeParent() != null){
	    					Attribute outputAttribute = mapperLinkObject.getInNode().getAttributeParent();
	    	 					
	    					//tree.element --------> tree.attribute
	    					String action = goUpOnOutputTree(outputAttribute.getFieldParent())+outputAttribute.getName().split(",")[1]+" = "+ goUpOnInputTree(eListObject)+elementIteratorObject.getName().split(",")[1];
	    					actionList.add(action);
    					}
    					
    					//FIXME Need to Change this logic ASAP.
    					
    					//if there is a equal operator
    					else if ((mapperLinkObject.getInNode().eContainer().eContainer().eContainer().eContainer().getClass().getName()).equalsIgnoreCase("dataMapper.impl.EqualImpl")) {
    						Equal equal = (Equal) mapperLinkObject.getInNode().eContainer().eContainer().eContainer().eContainer();
    						if(!OPERATION_LIST.contains(System.identityHashCode(equal))){
    							OPERATION_LIST.add(System.identityHashCode(equal));
        						EList<OperatorLeftConnector> leftConnectores = equal.getBasicContainer().getLeftContainer().getLeftConnectors();
        						//FIXME only works on one tree level. can fix by using 'goUpOnOutputTree' / 'goUpOnInputTree' methods
        						String action = "\toutput."+getOutputElementForRight(equal)+" = input."+getInputElementForLeft(leftConnectores.get(0))+".equal(input."+getInputElementForLeft(leftConnectores.get(1))+");";
        						System.out.println("ds");
        						actionList.add(action);

    						}

    					//to add more operators, add else-if and force to generate config
    						
						} else if ((mapperLinkObject.getInNode().eContainer().eContainer().eContainer().eContainer().getClass().getName()).equalsIgnoreCase("dataMapper.impl.ConcatImpl")) {
    						Concat concat = (Concat) mapperLinkObject.getInNode().eContainer().eContainer().eContainer().eContainer();
    						if(!OPERATION_LIST.contains(System.identityHashCode(concat))){
    							OPERATION_LIST.add(System.identityHashCode(concat));
        						EList<OperatorLeftConnector> leftConnectores = concat.getBasicContainer().getLeftContainer().getLeftConnectors();
        						//FIXME only works on one tree level. can fix by using 'goUpOnOutputTree' / 'goUpOnInputTree' methods
        						String action = "\toutput."+getOutputElementForRight(concat)+" = input."+getInputElementForLeft(leftConnectores.get(0))+".concat(input."+getInputElementForLeft(leftConnectores.get(1))+");";
        						System.out.println("ds");
        						actionList.add(action);

    						}

    					//to add more operators, add else-if and force to generate config
    						
						}
    					
    					
    					
    					
    				}// end if linkobject element
    			}//end itrt links element
    		}//end itrt element	
    		
    		if(!forLoopActionList.isEmpty()){
    			String actionForLoop = null;
    			String loopActionsAll = "";
    			for(String loopActions : forLoopActionList){
    				loopActionsAll = loopActionsAll + "\t"+loopActions+" ;\n" ;
    			}
    			
				actionForLoop = "for (var x in " + goUpOnInputTreeForLoop(eListObject)+") { \n"+loopActionsAll+" \n \t }";
    			actionList.add(actionForLoop);
    		}
    		
    	}//tree    	
    	return actionList;
    }//findForAction
    
    
    /* walk through tree structure and return each data field.
     * 
     */
    private static String goUpOnOutputTree(TreeNode node){
    	String temp="";
    	if(node.getOutputParent() == null){
    		temp = goUpOnOutputTree(node.getFieldParent())+node.getName().split(",")[1]+".";
    	}
    	else {
			return "output.";
		}
		return temp;
    }
    
    private static String goUpOnInputTree(TreeNode node){
    	String temp="";
    	
    	if(node.getInputParent() ==null){
    		temp = goUpOnInputTree(node.getFieldParent())+node.getName().split(",")[1]+".";
    	}
    	else {
    		return "input.";
		}
		return temp;
    }
    
    /*
     * for FOR LOOP
     */
    
    private static String goUpOnOutputTreeForLoop(TreeNode node){
    	String temp="";
    	if(node.getOutputParent() == null){
    		temp = goUpOnOutputTree(node.getFieldParent())+node.getName().split(",")[1];
    	}
    	else {
			return "output.";
		}
		return temp;
    }
    
    private static String goUpOnInputTreeForLoop(TreeNode node){
    	String temp="";
    	
    	if(node.getInputParent() ==null){
    		temp = goUpOnInputTree(node.getFieldParent())+node.getName().split(",")[1];
    	}
    	else {
    		return "input.";
		}
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