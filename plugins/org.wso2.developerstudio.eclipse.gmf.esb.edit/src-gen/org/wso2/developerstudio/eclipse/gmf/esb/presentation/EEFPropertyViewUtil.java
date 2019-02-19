package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.awt.GridLayout;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
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
            // control.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
            control.setEnabled(true);
            if (control.getLayoutData() != null && control.getLayoutData() instanceof GridData) {
                ((GridData) control.getLayoutData()).exclude = true;
                control.setVisible(false);
            } else if (control.getLayoutData() != null && control.getLayoutData() instanceof FormData) {
                // ((FormData) control.getLayoutData()). = true;
                control.setVisible(false);
            } else {
                control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
                ((GridData) control.getLayoutData()).exclude = true;
                control.setVisible(false);
            }
        }
        if (layout) {
            view.layout(true, true);
        }
    }

    public void showEntry(Control controls[], boolean layout) {
        for (Control control : controls) {
            // null check and type check
            // control.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
            control.setEnabled(true);
            if (control.getLayoutData() != null && control.getLayoutData() instanceof GridData) {
                ((GridData) control.getLayoutData()).exclude = false;
                control.setVisible(true);
            } else if (control.getLayoutData() != null && control.getLayoutData() instanceof FormData) {
                control.setVisible(true);
            } else {
                control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
                ((GridData) control.getLayoutData()).exclude = false;
                control.setVisible(true);
            }
        }
        if (layout) {
            view.layout(true, true);
        }
    }
    
    public void showEntry(ArrayList<Control> controls, boolean layout) {
        for (Control control : controls) {
            // null check and type check
            // control.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
            control.setEnabled(true);
            if (control.getLayoutData() != null && control.getLayoutData() instanceof GridData) {
                ((GridData) control.getLayoutData()).exclude = false;
                control.setVisible(true);
            } else if (control.getLayoutData() != null && control.getLayoutData() instanceof FormData) {
                control.setVisible(true);
            } else {
                control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
                ((GridData) control.getLayoutData()).exclude = false;
                control.setVisible(true);
            }
        }
        if (layout) {
            view.layout(true, true);
        }
    }

    public static Control[] getTableElements(Control[] previousControls, Control[] newControls) {
        Control[] tableElements = new Control[newControls.length - previousControls.length];
        for (int i = previousControls.length; i < newControls.length; i++) {
            tableElements[i - previousControls.length] = newControls[i];
        }
        return tableElements;
    }
    
    public static void addTableElementsAsList(ArrayList<Control> arrayList, Control[] previousControls, Control[] newControls) {
/*        Control [] controlArray = getTableElements(previousControls, newControls);
        for(Control control : controlArray) {
            arrayList.add(control);
        }*/
        
        //Control[] tableElements = new Control[newControls.length - previousControls.length];
        for (int i = previousControls.length; i < newControls.length; i++) {
            //tableElements[i - previousControls.length] = newControls[i];
            arrayList.add(newControls[i]);
        }
    }
    
    /**
     * This method will check if a specific key combination matches a defined
     * set of key combinations.
     * 
     * @param e KeyEvent instance.
     * @return 'True' if matches, 'False' otherwise.
     */
    public static boolean isReservedKeyCombination(KeyEvent e) {
        
        if (e.keyCode == SWT.CR) {
            return true;
        } else if (e.keyCode == SWT.COMMAND) {
            return true;
        } else if (e.keyCode == SWT.CTRL) {
            return true;
        } else if (e.keyCode == SWT.ALT) {
            return true;
        } else if (e.keyCode == SWT.SHIFT) {
            return true;
        } else if (e.stateMask == SWT.COMMAND && e.character == 's') {
            return true;
        } else if (e.stateMask == SWT.CTRL && (e.character == 's' || e.keyCode == 115)) {
            return true;
        }
        
        return false;
    }
}
