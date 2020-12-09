package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;

public class DevStudioFormEditor extends EditorPart {

    public static final String ID = "com.vogella.rcp.editor.example.editor.taskeditor";
    private EsbEditorInput input;

    // Will be called before createPartControl
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof DevStudioFormEditorInput)) {
            throw new RuntimeException("Wrong input");
        } else if (input instanceof EsbEditorInput) {
            this.input = (EsbEditorInput) input;
        }

        setSite(site);
        setInput(input);
        setPartName("Todo ID: " + 1);
    }

    @Override
    public void createPartControl(Composite parent) {
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        parent.setLayout(layout);
        new Label(parent, SWT.NONE).setText("Summary");
        Text text = new Text(parent, SWT.BORDER);
        text.setText("my summary");
        text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

        new Label(parent, SWT.NONE).setText("Description");
        Text lastName = new Text(parent, SWT.BORDER);
        lastName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        lastName.setText("my description");

        new Label(parent, SWT.NONE).setText("Done");
        Button doneBtn = new Button(parent, SWT.CHECK);
        doneBtn.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        doneBtn.setSelection(true);

        new Label(parent, SWT.NONE).setText("Due Date");
        DateTime dueDate = new DateTime(parent, SWT.CHECK);
        dueDate.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        Date date = new Date();
        date.setTime(123123123);
        dueDate.setDate(date.getYear(), date.getMonth(), date.getDay());
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void setFocus() {
    }

}
