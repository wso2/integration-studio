package org.wso2.integrationstudio.gmf.esb.diagram.part;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class EsbPaletteUtil {

    private static final String DIR_DOT_METADATA = ".metadata";
    public static final String connectorPathFromWorkspace = DIR_DOT_METADATA + File.separator + ".Connectors";

    public static void loadConnectorFile() throws Exception {
        String file;
        String[] checkedConnectors = null;
        String connectorPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + File.separator
                + connectorPathFromWorkspace;
        File directory = new File(connectorPath);
        String[] names = directory.list();
        Boolean exist = Files.exists(Paths.get(connectorPath + File.separator + "checkedConnectors.txt"),
                LinkOption.NOFOLLOW_LINKS);

        if (exist) {
            file = new String(Files.readAllBytes(Paths.get(connectorPath + File.separator + "checkedConnectors.txt")));
            checkedConnectors = file.split(", ");
        }

        if (checkedConnectors != null) {
            updateConnectorVisibility(Arrays.asList(checkedConnectors));
        }
    }

    /**
     * Change the visibility of Connector palette group(s) based on the opened
     * artifact
     * 
     * @param paletteContainer
     * @param visible
     */

    public static void updateConnectorVisibility(List<String> connectorNames) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.getActiveEditor();
				if (editorPart instanceof EsbMultiPageEditor) {
					EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					esbMultiPageEditor.getDiagramEditDomain();
					PaletteViewer paletteViewer = ((DiagramEditDomain) esbMultiPageEditor.getDiagramEditDomain())
							.getPaletteViewer();
					List children = paletteViewer.getPaletteRoot().getChildren();

					for (Object child : children) {
						if (((PaletteContainer) child).getId().contains("CloudConnector")) {
							String connectorId = ((PaletteContainer) child).getId().replaceAll("CloudConnector-", "");
							connectorId = connectorId.substring(0, 1).toUpperCase() + connectorId.substring(1)
									+ " Connector";
							if (connectorNames.contains(connectorId)) {
								((PaletteContainer) child).setVisible(true);
							} else {
								((PaletteContainer) child).setVisible(false);
							}
						}

					}
				}
			}
		});
    }

}