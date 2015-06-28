/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.internal.ui.palette.editparts.DrawerEditPart;
import org.eclipse.gef.internal.ui.palette.editparts.SliderPaletteEditPart;
import org.eclipse.gef.internal.ui.palette.editparts.ToolEntryEditPart;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.parts.PaletteViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;

public class CustomPaletteViewerKeyHandler extends PaletteViewerKeyHandler {

	private PaletteViewer paletteViewer;
	private String searchString;
	private String previousLabel;
	Map<String, List<PaletteToolEntry>> paletteEntries;

	public CustomPaletteViewerKeyHandler(PaletteViewer viewer) {
		super(viewer);
		this.paletteViewer = viewer;
		this.searchString = "";
		this.previousLabel = "";
		paletteEntries = new HashMap<String, List<PaletteToolEntry>>();
	}

	/**
	 * Initialize palette viewer key handler.
	 */
	public void initializeKeyHandler() {
		PaletteContainer paletteContainer = paletteViewer.getPaletteRoot();
		List children = paletteContainer.getChildren();

		for (Object child : children) {
			if (child instanceof PaletteDrawer && ((PaletteDrawer) child).isVisible()) {
				PaletteDrawer paletteDrawer = (PaletteDrawer) child;
				List<PaletteToolEntry> toolEntries = new ArrayList<PaletteToolEntry>();
				toolEntries.addAll(paletteDrawer.getChildren());
				paletteEntries.put(paletteDrawer.getLabel(), toolEntries);
			}
		}

		paletteViewer.getControl().addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				populateToolEntries();
			}

			@Override
			public void mouseDown(MouseEvent e) {
				populateToolEntries();
			}

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		if (event.character != 0 && event.keyCode != SWT.SPACE) {
			filterMatchingEntries(event);
		} else if (event.keyCode == SWT.SPACE) {
			populateToolEntries();
		}

		return super.keyPressed(event);
	}

	/**
	 * Filter tool entries whose name starts with typed characters.
	 * 
	 * @param event
	 */
	private void filterMatchingEntries(KeyEvent event) {
		List<PaletteToolEntry> paletteEntryList = null;
		String modelLabel = "";
		EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) EditorUtils.getActiveEditor();                                                     
		EsbServer server = ((EsbDiagram) ((EsbDiagramEditor) esbMultiPageEditor.getGraphicalEditor()).getDiagramEditPart().getDiagramView()
		                 .getElement()).getServer();

		if (getFocusEditPart() instanceof DrawerEditPart
				&& ((DrawerEditPart) getFocusEditPart()).isExpanded()) {
			modelLabel = ((PaletteDrawer) getFocusEditPart().getModel()).getLabel();
			paletteEntryList = paletteEntries.get(modelLabel);
		} else if (getFocusEditPart() instanceof ToolEntryEditPart) {
			modelLabel = ((PaletteDrawer) getFocusEditPart().getParent().getModel()).getLabel();
			paletteEntryList = paletteEntries.get(modelLabel);
		} else if (getFocusEditPart() instanceof SliderPaletteEditPart) {
			List children = ((SliderPaletteEditPart)getFocusEditPart()).getChildren();
			paletteEntryList = new ArrayList<PaletteToolEntry>();
			for (Object child : children) {
				if (child instanceof DrawerEditPart
						&& ((PaletteDrawer) ((DrawerEditPart) child).getModel()).isVisible()
						&& ((DrawerEditPart) child).isExpanded()) {
					PaletteDrawer paletteDrawer = (PaletteDrawer) ((DrawerEditPart) child)
							.getModel();
					if (!paletteDrawer.getLabel().equals("Links") && paletteEntries.get(paletteDrawer.getLabel()) != null) {
						paletteEntryList.addAll(paletteEntries.get(paletteDrawer.getLabel()));
						modelLabel = previousLabel;
					}
				}
			}
		} else {
			return;
		}

		// Links and API palette drawer has only one element.
		if (modelLabel.equals("Links") || modelLabel.equals("API")) {
			return;
		}

		if (!modelLabel.equals(previousLabel)) {
			previousLabel = modelLabel;
			searchString = "";
		}

		if (event.keyCode != SWT.BS) {
			// Concatenate the pressed character to the search string.
			searchString += event.character;
		} else if (event.keyCode == SWT.BS && null != searchString && !searchString.equals("")) {
			// Remove last character from search string on back space press.
			searchString = searchString.substring(0, searchString.length() - 1);
		}

		if (paletteEntryList != null && paletteEntryList.size() > 0) {
			// Hide un-matching tool entries.
			for (int i = 0; i < paletteEntryList.size(); i++) {
				if (paletteEntryList.get(i) instanceof PaletteToolEntry) {
					PaletteToolEntry toolEntry = paletteEntryList.get(i);
					String label = toolEntry.getLabel().toUpperCase();
					if (!(ArtifactType.INBOUND_ENDPOINT.equals(server.getType()) && "Mediators".equals(toolEntry
							.getParent().getLabel()))) {
						if (label.startsWith(searchString.toUpperCase())) {
							toolEntry.setVisible(true);
						} else if (toolEntry.isVisible()) {
							toolEntry.setVisible(false);
						}
					}
				}
			}
			/*for (PaletteToolEntry toolEntry : paletteEntryList) {
				String label = toolEntry.getLabel().toUpperCase();
				if (label.startsWith(searchString.toUpperCase())) {
					toolEntry.setVisible(true);
				} else if (toolEntry.isVisible()) {
					toolEntry.setVisible(false);
				}
			}*/
		}
	}

	/**
	 * Re-populate hidden tool entries on click of the palette drawer.
	 */
	private void populateToolEntries() {
		String modelLabel = "";
		if (getFocusEditPart() instanceof DrawerEditPart) {
	         EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) EditorUtils.getActiveEditor();                                                     
	         EsbServer server = ((EsbDiagram) ((EsbDiagramEditor) esbMultiPageEditor.getGraphicalEditor()).getDiagramEditPart().getDiagramView()
	                         .getElement()).getServer();
			modelLabel = ((PaletteDrawer) getFocusEditPart().getModel()).getLabel();
			if (modelLabel.equals("Links") || modelLabel.equals("API")) {
				return;
			}
			List<PaletteToolEntry> paletteEntryList = paletteEntries.get(modelLabel);

			if (paletteEntryList != null && paletteEntryList.size() > 0) {
				for (int i = 0; i < paletteEntryList.size(); i++) {
					if (paletteEntryList.get(i) instanceof PaletteToolEntry) {
						PaletteToolEntry toolEntry = paletteEntryList.get(i);
						if (!(ArtifactType.INBOUND_ENDPOINT.equals(server.getType()) && "Mediators".equals(toolEntry
								.getParent().getLabel()))) {
							if (!toolEntry.isVisible()) {
								toolEntry.setVisible(true);
							}
						}
					}
				}
				
				/*for (PaletteToolEntry toolEntry : paletteEntryList) {
					if (!toolEntry.isVisible()) {
						toolEntry.setVisible(true);
					}
				}*/

				searchString = "";
			}
		}
	}
	
	public void resetSerchString() {
		searchString = "";
	}

}
