package org.wso2.developerstudio.datamapper.diagram.custom.action;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class RenamingDialog extends Dialog {
	  private static final String RENAME = "Rename";
	private Text newNameTxt;
	  private String newName = "";

	  public RenamingDialog(Shell parentShell) {
	    super(parentShell);
	  }

	  @Override
	  protected Control createDialogArea(Composite parent) {
	    Composite container = (Composite) super.createDialogArea(parent);
	    GridLayout layout = new GridLayout(2, false);
	    layout.marginRight = 5;
	    layout.marginLeft = 10;
	    container.setLayout(layout);

	    Label lblUser = new Label(container, SWT.NONE);
	    lblUser.setText("New Name :");

	    newNameTxt = new Text(container, SWT.BORDER);
	    newNameTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
	        1, 1));
	    newNameTxt.setText(newName);
	    newNameTxt.addModifyListener(new ModifyListener() {

	      @Override
	      public void modifyText(ModifyEvent e) {
	        Text textWidget = (Text) e.getSource();
	        String userText = textWidget.getText();
	        newName = userText;
	      }
	    });
	    return container;
	  }

	  // override method to use "Login" as label for the OK button
	  @Override
	  protected void createButtonsForButtonBar(Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, RENAME, true);
	    createButton(parent, IDialogConstants.CANCEL_ID,
	        IDialogConstants.CANCEL_LABEL, false);
	  }

	  @Override
	  protected Point getInitialSize() {
	    return new Point(450, 150);
	  }

	  @Override
	  protected void okPressed() {
	    newName = newNameTxt.getText();
	    super.okPressed();
	  }
	  
	  @Override
	  protected void cancelPressed() {
	    newName = "";
	    super.cancelPressed();
	  }

	  public String getnewName() {
	    return newName;
	  }

	  public void setNewName(String newName) {
	    this.newName = newName;
	  }
	  
	  public Point getCenterPoint() {
			Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			Rectangle shellBounds = parentShell.getBounds();
			return new Point(shellBounds.x + shellBounds.width / 2, (shellBounds.y + shellBounds.height) / 2);
		}

		@Override
		protected Point getInitialLocation(Point initialSize) {
			Point shellCenter = getCenterPoint();
			return new Point(shellCenter.x - initialSize.x / 2, shellCenter.y - initialSize.y / 2);
		}



	} 