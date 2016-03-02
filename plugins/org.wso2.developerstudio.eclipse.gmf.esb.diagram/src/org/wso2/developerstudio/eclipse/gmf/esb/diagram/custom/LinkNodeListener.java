/*
 * Copyright 2011 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class LinkNodeListener implements MouseMotionListener {
	private EditDomain domain;
	private static ToolEntry esbLink;

	static{
	if(esbLink==null){
	esbLink = getEsbLinkCreationTool(); 
	}
	}
	
	public LinkNodeListener(EditDomain domain){
		this.domain = domain;
		
	}
	
	public void mouseDragged(MouseEvent evt) {
	}

	public void mouseEntered(MouseEvent evt) {
		domain.getPaletteViewer().setActiveTool(esbLink);
	}

	public void mouseExited(MouseEvent evt) {
	}

	public void mouseHover(MouseEvent evt) {
	}


	public void mouseMoved(MouseEvent evt) {
	}
	
	private static ToolEntry getEsbLinkCreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.EsbLink1CreationTool_title,
				Messages.EsbLink1CreationTool_desc,
				Collections.singletonList(EsbElementTypes.EsbLink_4001));
		entry.setId("createEsbLink1CreationTool");
		entry.setSmallIcon(EsbElementTypes
				.getImageDescriptor(EsbElementTypes.EsbLink_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		entry.setLabel("ESBLink");
		
		return entry;
	}
	
	private static class LinkToolEntry extends ToolEntry {
		private final List<IElementType> relationshipTypes;

		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);			
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

}
