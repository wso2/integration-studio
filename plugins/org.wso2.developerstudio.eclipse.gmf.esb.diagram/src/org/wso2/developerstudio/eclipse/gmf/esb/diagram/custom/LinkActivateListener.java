/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;

public class LinkActivateListener extends MouseMotionListener.Stub {

	private PaletteViewer paletteViewer;
	private static final int LINKS_GROUP_INDEX=4; /* index of links group */
	private static final int LINKS_ESBLINK_INDEX = 0; /* index of ESB link */

	public LinkActivateListener(EditDomain editDomain) {
		this.paletteViewer = editDomain.getPaletteViewer();
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		try {
			ToolEntry esbLink = (ToolEntry) (((PaletteContainer) paletteViewer.getPaletteRoot()
					.getChildren().get(LINKS_GROUP_INDEX)).getChildren().get(LINKS_ESBLINK_INDEX));
			paletteViewer.setActiveTool(esbLink);
		} catch (Exception e) {
			// cannot set active tool to ESB link
		}
	}

}
