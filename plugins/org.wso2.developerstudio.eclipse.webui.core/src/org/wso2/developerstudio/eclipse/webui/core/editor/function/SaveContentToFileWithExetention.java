package org.wso2.developerstudio.eclipse.webui.core.editor.function;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractWebBasedEditor;
import org.wso2.developerstudio.eclipse.webui.core.editor.Constants;

public class SaveContentToFileWithExetention extends AbstractWebEditorFunction {

	public SaveContentToFileWithExetention(AbstractWebBasedEditor editor) {
		super(editor, Constants.IDE_SAVE_FILE_CONTENT_FUNCTION_WITH_EXTNTION);
	}

	@Override
	public Object function(Object[] arguments) {
		
		String content = (String) arguments[0];
		String dirpath = (String) arguments[1];
		String fileName = (String) arguments[2];
		String fileExtention = (String) arguments[3];		
		String projectLocation = editorInput.getFile().getProject().getLocation().toString();
		String parentProjectPath = null;
		
		if(dirpath != null || !("").equals(dirpath)){
			parentProjectPath = projectLocation+File.separator+dirpath;
		}else {
			parentProjectPath = projectLocation;
		}
		
		File dir = new File(parentProjectPath);
		dir.mkdirs();	
		BufferedWriter writer = null;
		
		File file = new File(parentProjectPath+File.separator+fileName+"."+fileExtention);
		try {
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			log.error(e);
		}finally{
			try {
				writer.close();
				editorInput.getFile().getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (IOException e) {
				log.error(e);
			} catch (CoreException e) {
				log.error(e);
			}
		}
		return Boolean.TRUE.toString();
	}

}
