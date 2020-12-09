package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class DevStudioFormEditorInput implements IEditorInput {

    private final long id;

    public DevStudioFormEditorInput(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return "Displays a task";
    }

    @Override
    public Object getAdapter(Class adapter) {
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DevStudioFormEditorInput other = (DevStudioFormEditorInput) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
/*
 * extends ViewPart {
 * private FormToolkit toolkit;
 * private ScrolledForm form;
 * 
 *//**
    * The constructor.
    */
/*
 * public DevStudioFormEditor() {
 * }
 * 
 *//**
    * This is a callback that will allow us to create the viewer and
    * initialize it.
    */
/*
 * public void createPartControl(Composite parent) {
 * toolkit = new FormToolkit(parent.getDisplay());
 * form = toolkit.createScrolledForm(parent);
 * form.setText("Developer Studio - Local Entry");
 * GridLayout layout = new GridLayout();
 * layout.numColumns = 2;
 * GridData gd = new GridData();
 * gd.horizontalSpan = 2;
 * Label label = new Label(form.getBody(), SWT.NULL);
 * label.setText("Text field label:");
 * Text text = new Text(form.getBody(), SWT.BORDER);
 * text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
 * Button button = new Button(form.getBody(), SWT.CHECK);
 * button.setText("An example of a checkbox in a form");
 * gd = new GridData();
 * gd.horizontalSpan = 2;
 * button.setLayoutData(gd);
 * 
 * }
 * 
 *//**
    * Passing the focus request to the form.
    */
/*
 * public void setFocus() {
 * form.setFocus();
 * }
 * 
 *//**
    * Disposes the toolkit
    *//*
       * public void dispose() {
       * toolkit.dispose();
       * super.dispose();
       * }
       * }
       */