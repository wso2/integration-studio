package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IPlaceholderFolderLayout;

/**
 * Responsible for generating the "WSO2 ESB Graphical" perspective.
 */
public class EsbGraphicalEditorPerspective implements IPerspectiveFactory {

	// private static final String PROPERTIES_VIEW_ID =
	// "org.eclipse.ui.views.PropertySheet";

	public void createInitialLayout(IPageLayout perspectiveLayout) {
		defineAction(perspectiveLayout);
		defineLayout(perspectiveLayout);
	}

	public void defineAction(IPageLayout layout) {
		// layout.addShowViewShortcut(PROPERTIES_VIEW_ID);
		// layout.setFixed(true);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
	}

	public void defineLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();

		// Top left: Project Explorer
		IFolderLayout topLeft = layout.createFolder("topLeft",
				IPageLayout.LEFT, 0.15f, editorArea);
		topLeft.addView(IPageLayout.ID_PROJECT_EXPLORER);
		// topLeft.addPlaceholder(IPageLayout.ID_BOOKMARKS);

		// Bottom left: Outline view and Property Sheet view
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft",
				IPageLayout.BOTTOM, 0.65f, "topLeft");
		bottomLeft.addView(IPageLayout.ID_OUTLINE);
		// bottomLeft.addView(IPageLayout.ID_PROP_SHEET);

		IFolderLayout rightArea = layout.createFolder("bottom",
				IPageLayout.BOTTOM, 0.65f, editorArea);
		rightArea.addView(IPageLayout.ID_PROP_SHEET);
	}
}
