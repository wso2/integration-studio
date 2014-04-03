package org.wso2.developerstudio.eclipse.platform.ui.startup;

import java.io.File;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class DataMapperEditor {
	private static Openable openable;

	public static void setOpenable(Openable openable) {
		DataMapperEditor.openable = openable;
	}

	public static Openable getOpenable() {
		return openable;
	}
	
	public static void open(IFile selection) {
		IFile fileTobeOpen = null;
		//String synFilePath = selection.getFullPath().toOSString();
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		Path path = new Path(getGraphicalResource(selection));
		try {
			if (selection.getWorkspace().getRoot().getFile(path).exists()) {
				fileTobeOpen = selection.getWorkspace().getRoot().getFile(path);
				IDE.openEditor(page, fileTobeOpen);
			} else {
				String location = selection.getLocation().toOSString();
				String source = FileUtils.getContentAsString(new File(location));
				String name = selection.getName().split("\\.")[0];
				String fullPath = selection.getFullPath().removeLastSegments(1).toOSString()
						+ "/";
				Openable openable = DataMapperEditor.getOpenable();
				openable.editorOpen(name, null, fullPath, source);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getGraphicalResource(IFile selection) {
		String synFilePath = selection.getFullPath().toOSString();
		synFilePath = synFilePath.replaceAll(Pattern.quote("\\"), "/");
		String graphicalResource = synFilePath.replaceAll(".dmc$", ".datamapper_diagram");
		return graphicalResource;
	}
}
