package org.wso2.developerstudio.eclipse.artifact.registry.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
 

public class ResourceFormEditor extends FormEditor  {

	private  RegistryResourcePage resourcePage;
    private  boolean isDirty;
    
	public ResourceFormEditor() {
		 super();
	}

	protected void addPages() {
		resourcePage = new RegistryResourcePage(
				this,
				"org.wso2.developerstudio.eclipse.artifact.registry.editor.FormEditor",
				"Design");
		 try {
			 addPage(resourcePage);

		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void updateDirtyState() {
		isDirty = resourcePage.isDirty();
		firePropertyChange(PROP_DIRTY);
		editorDirtyStateChanged();	    
    }

	public boolean isDirty() {

		return isDirty;
	} 

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

	public void doSave(IProgressMonitor monitor) {
		
		resourcePage.doPageSave();
	 	}

	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public void setResourceEditor(RegistryResourcePage resourceEditor) {
		this.resourcePage = resourceEditor;
	}

	public RegistryResourcePage getResourceEditor() {
		return resourcePage;
	}

}
