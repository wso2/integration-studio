package org.wso2.developerstudio.datamapper.diagram.custom.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractConfigureOperatorDialog extends TitleAreaDialog{

	GridData dataPropertyConfigText;
	
	public AbstractConfigureOperatorDialog(Shell parentShell) {
		super(parentShell);
		init();
	}
	
	protected void init(){
		dataPropertyConfigText = new GridData();
		dataPropertyConfigText.grabExcessHorizontalSpace = true;
		dataPropertyConfigText.horizontalAlignment = GridData.FILL;
	}

}
