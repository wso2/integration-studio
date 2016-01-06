package org.wso2.developerstudio.datamapper.diagram.edit.parts.custom;

//import java.awt.List;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;

public class CustomNonResizableEditPolicyEx  extends NonResizableEditPolicyEx  {

	
	@Override
	protected List createSelectionHandles() {
	List list = new ArrayList();
	//createMoveHandle(list); //no need to add this, even without this it supports moving, this adds a border therefore dnt add
	return list;
	} 
//	@Override
//	public void activate() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deactivate() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void eraseSourceFeedback(Request request) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void eraseTargetFeedback(Request request) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Command getCommand(Request request) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public EditPart getHost() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public EditPart getTargetEditPart(Request request) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setHost(EditPart editpart) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void showSourceFeedback(Request request) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void showTargetFeedback(Request request) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public boolean understandsRequest(Request request) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
