package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbServerContentsCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment10EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment3EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment4EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment6EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment7EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment8EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment9EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartmentEditPart;

public class CustomDragDropEditPolicy extends DragDropEditPolicy{
	
	protected Command getDropCommand(ChangeBoundsRequest request) {
		/* Avoiding drag and drop nodes between compartments. If you want default behavior call super(request) */		 
		Command cmd=null;
		return cmd;
	}	
	
	public void showTargetFeedback(Request request) {		
	    super.showTargetFeedback(request);
	    if(request instanceof CreateUnspecifiedTypeRequest){
	    getFeedback((CreateUnspecifiedTypeRequest)request);		
	    }	    
	}

	
	private void getFeedback(CreateUnspecifiedTypeRequest request){
	    String mediator=request.getElementTypes().get(0).toString();
	    Pattern p = Pattern.compile("[\\[,\\]]");
	    String[]result=p.split(mediator);
	    
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartmentEditPart){
	    	if(isAllowable("MediatorFlow",result[1])){
	    		setGreenColor();
	    	}
	    	else{
	    		setRedColor();
	    	}
	    }
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment2EditPart){
	    	if(isAllowable("MediatorFlow2",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }
	    
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment3EditPart){
	    	if(isAllowable("MediatorFlow3",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }
	    
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment4EditPart){
	    	if(isAllowable("MediatorFlow4",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}	
	    }
	    
/*	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment5EditPart){
	    	if(isAllowable("MediatorFlow5",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }*/
	    
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment6EditPart){
	    	if(isAllowable("MediatorFlow6",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }
	    
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment7EditPart){
	    	if(isAllowable("MediatorFlow7",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }
	    
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment8EditPart){
	    	if(isAllowable("MediatorFlow8",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }
	    
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment9EditPart){
	    	if(isAllowable("MediatorFlow9",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }
	    
	    if(getHost() instanceof MediatorFlowMediatorFlowCompartment10EditPart){
	    	if(isAllowable("MediatorFlow10",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }
	    
	    if(getHost() instanceof EsbServerContentsCompartmentEditPart){
	    	if(isAllowable("ESBServer",result[1])){
	    		setGreenColor();	    		
    		}
    		else{
    			setRedColor();
    		}
	    		
	    }
	    
/*	    if(getHost() instanceof EndpointFlowEndpointCompartment2EditPart){
	    	if(isAllowable("EndpointFlow2",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }*/
	    
/*	    if(getHost() instanceof EndpointFlowEndpointCompartmentEditPart){
	    	if(isAllowable("EndpointFlow",result[1])){
	    		setGreenColor();
    		}
    		else{
    			setRedColor();
    		}
	    }*/
	}
	
	
	private boolean isAllowable(String compartment,String element){
		
		List<String> mediators= new ArrayList<String>();	
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LogMediator_3495");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DropMediator_3491");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PropertyMediator_3492");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EnrichMediator_3496");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EventMediator_3504");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SendMediator_3515");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterMediator_3494");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchMediator_3498");		
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.XSLTMediator_3497");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.XQueryMediator_3510");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FaultMediator_3509");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HeaderMediator_3516");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DBLookupMediator_3512");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DBReportMediator_3513");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementMediator_3505");		
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloneMediator_3517");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.IterateMediator_3519");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CacheMediator_3518");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AggregateMediator_3525");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CalloutMediator_3520");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TransactionMediator_3521");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleMediator_3493");		
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RMSequenceMediator_3522");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.OAuthMediator_3524");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RuleMediator_3523");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ClassMediator_3506");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SpringMediator_3507");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ScriptMediator_3508");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SmooksMediator_3514");
		mediators.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CommandMediator_3511");
		
		
		List<String> endPoint=new ArrayList<String>();
		endPoint.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DefaultEndPoint_3563");
		endPoint.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressEndPoint_3564");
		endPoint.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPoint_3565");
		endPoint.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.WSDLEndPoint_3566");
		endPoint.add("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPoint_3567");

		
		if(compartment.equals("MediatorFlow")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow2")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow3")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow4")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow5")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow6")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow7")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow8")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow9")){
			return mediators.contains(element);
		}
		if(compartment.equals("MediatorFlow10")){
			return mediators.contains(element);
		}
		if(compartment.equals("ESBServer")){
			return element.equals("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyService_3001");
		}
		if(compartment.equals("EndpointFlow")){
			return endPoint.contains(element);
		}
		if(compartment.equals("EndpointFlow2")){
			return endPoint.contains(element);
		}
		
		return false;
	}
	
	private void setGreenColor(){
		/*revertColor = getHostFigure().getBackgroundColor();
		getHostFigure().setBackgroundColor(
			FigureUtilities.mixColors(new Color(null, 142, 215, 91), revertColor));
		getHostFigure().setOpaque(true);*/
	}
	
	private void setRedColor(){
		/*revertColor = getHostFigure().getBackgroundColor();
		getHostFigure().setBackgroundColor(
			FigureUtilities.mixColors(new Color(null, 168, 41, 24), revertColor));
		getHostFigure().setOpaque(true);*/
	}
	
}
