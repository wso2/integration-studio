/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateViewAndOptionallyElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Node;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowCompartmentEditPart;

public class DeserializerUtils {

	public static boolean isInteger(String numberString) {

		try {
			Integer.parseInt(numberString);
		} catch (NumberFormatException e) {

			return false;
		}

		return true;
	}

	public static boolean isValidRegex(String regex) {

		try {
			Pattern.compile(regex);
		} catch (PatternSyntaxException exception) {

			return false;
		}

		return true;
	}
	
	protected static String join(Iterable<? extends CharSequence> s, String delimiter) {
	    @SuppressWarnings("unchecked")
		Iterator<String> iter = (Iterator<String>) s.iterator();
	    StringBuffer buffer = new StringBuffer(iter.next());
	    while (iter.hasNext()) buffer.append(delimiter).append(iter.next());
	    return buffer.toString();
	}
	
	public static EObject createNode(IGraphicalEditPart editPart , IElementType elementType) {
		CreationTool tool = new CreationTool(elementType);

		CreateViewAndElementRequest req = (CreateViewAndElementRequest) 
		tool.createCreateRequest();	
		
		CreateViewAndOptionallyElementCommand createCmd = new 
		CreateViewAndOptionallyElementCommand(	
		req.getViewAndElementDescriptor().getElementAdapter(),
		editPart,
		null,
		req.getViewAndElementDescriptor().getPreferencesHint());
		
		
		org.eclipse.gef.commands.CompoundCommand cc = new org.eclipse.gef.commands.CompoundCommand("Create Node");

		
		cc.add(new ICommandProxy(createCmd));
		if(cc.canExecute()){
			editPart.getDiagramEditDomain().getDiagramCommandStack()
				.execute(cc);
			return ((Node)((IAdaptable)createCmd.getResult()).getAdapter(EObject.class)).getElement();
		}
		return null;
	}
	
	public static Dimension getPreferredSize(IGraphicalEditPart editPart){
		AbstractMediatorFlowCompartmentEditPart compartment = getMediatorFlowCompartment(editPart);
		if(compartment!=null){
			return compartment.getContentPane().getBounds().getSize().getCopy();
		}
		return editPart.getFigure().getPreferredSize();
	}

	/**
	 * @param editPart
	 */
	public static AbstractMediatorFlowCompartmentEditPart getMediatorFlowCompartment(
			IGraphicalEditPart editPart) {
		List<?> children = editPart.getChildren();
		for (Iterator<?> i = children.iterator(); i.hasNext();) {
			Object child = i.next();
			if (!(child instanceof AbstractConnectorEditPart)) {
				if (child instanceof AbstractMediatorFlowCompartmentEditPart) {
					return (AbstractMediatorFlowCompartmentEditPart) child;
				} else if (child instanceof IGraphicalEditPart) {
					AbstractMediatorFlowCompartmentEditPart compartment = getMediatorFlowCompartment((IGraphicalEditPart) child);
					if (compartment != null) {
						return compartment;
					}
				}
			}
		}
		return null;
	}

}
