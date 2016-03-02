package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.actions.global;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

public class ESBClipboard {

	private static List<IGraphicalEditPart> editParts = new ArrayList<IGraphicalEditPart>();
	private static boolean cut=false;

	public static boolean isCut() {
		return cut;
	}

	public static void setCut(boolean cut) {
		ESBClipboard.cut = cut;
	}

	public static boolean hasThingsToCopy() {
		return editParts != null && !editParts.isEmpty();
	}
	
	public static void setToCopyEditParts(List<IGraphicalEditPart> toCopyElements) {
		editParts = toCopyElements;
	}
	
	public static List<IGraphicalEditPart> getToCopyEditParts() {
		return editParts;
	}	
}
