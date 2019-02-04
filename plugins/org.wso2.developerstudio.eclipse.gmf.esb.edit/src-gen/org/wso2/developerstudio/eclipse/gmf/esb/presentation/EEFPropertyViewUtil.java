package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class EEFPropertyViewUtil {

    Composite view;

    public EEFPropertyViewUtil(Composite view) {
        this.view = view;
    }

    public void clearElements(Composite[] propertiesGroups) {
        for (Composite propertiesGroup : propertiesGroups) {
        	hideEntry(propertiesGroup.getChildren(), false);
        }
    }
    
    public void clearElement(Control control) {
    	 if (control.getLayoutData() != null && control.getLayoutData() instanceof GridData) {
             ((GridData) control.getLayoutData()).exclude = true;
             control.setVisible(false);
         }
    }

    public void hideEntry(Control controls[], boolean layout) {
        // view.getChildren();
        for (Control control : controls) {
            // null check and type check
            control.setEnabled(true);
            if (control.getLayoutData() != null && control.getLayoutData() instanceof GridData) {
                ((GridData) control.getLayoutData()).exclude = true;
                control.setVisible(false);
            } else if (control.getLayoutData() != null && control.getLayoutData() instanceof FormData) {
               // ((FormData) control.getLayoutData()). = true;
                control.setVisible(false);
            } else {
                control.setVisible(false);
            }
        }
        if (layout) {
            view.layout(true, true);
            view.pack();
        }
    }

    public void showEntry(Control controls[], boolean layout) {
        for (Control control : controls) {
            // null check and type check
            control.setEnabled(true);
            if (control.getLayoutData() != null && control.getLayoutData() instanceof GridData) {
               ((GridData) control.getLayoutData()).exclude = false;
                control.setVisible(true);
            } else if (control.getLayoutData() != null && control.getLayoutData() instanceof FormData) {
                control.setVisible(true);
            } else {
                control.setVisible(true);
            }
        }
        if (layout) {
            view.layout(true, true);
            view.pack();
        }
    }
    
    public static Control[] getTableElements(Control[] previousControls, Control[] newControls) {
        Control [] tableElements = new Control[newControls.length - previousControls.length];
        for (int i = previousControls.length; i < newControls.length; i++) {
            tableElements[i - previousControls.length] = newControls[i];
        }
        return tableElements;
    }
}
