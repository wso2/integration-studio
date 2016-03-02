package org.wso2.developerstudio.datamapper.diagram.custom.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditor;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UnrecogizedArtifactTypeException;


public class DataMapperEditorStartupUtils implements Openable{

	@Override
	public IEditorPart editorOpen(String name, String type, String location, String source)
			throws Exception {
		
		Resource diagram = org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorUtil
				.createDiagram(URI.createPlatformResourceURI(location+name+EditorUtils.DIAGRAM_FILE_EXTENSION,false),
						URI.createPlatformResourceURI(location+name+EditorUtils.DOMAIN_FILE_EXTENSION,false), new NullProgressMonitor());
		
		String path = diagram.getURI().toPlatformString(true);
		IFile diagramFile = (IFile) ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(path));
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		IEditorPart openEditor = activePage.openEditor(new FileEditorInput(
				diagramFile), DataMapperDiagramEditor.ID);	
		return openEditor;
	}


	@Override
	public IEditorPart editorOpen(String type, String source, IFile file)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumerator artifactTypeResolver(String source)
			throws UnrecogizedArtifactTypeException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
