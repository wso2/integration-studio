package org.wso2.developerstudio.esb.form.editors.article.providers;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMText;
import org.apache.axiom.om.util.AXIOMUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

public class ConfigureEndpointsWizard extends Wizard implements IExportWizard {
    
    private ConfigureEndpointDialog endpointDialog;
    private EndpointTableEntry endpointTableEntry;
    private boolean initError = true;
    private boolean isFinish = false;
    private boolean isEdit = false;

    public ConfigureEndpointsWizard(Shell shell) {
        
    }
    
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        if (!isEdit) {
            endpointDialog = new ConfigureEndpointDialog("XXXXXX1");
        } else {
            endpointDialog = new ConfigureEndpointDialog("XXXXXX1", this.endpointTableEntry);
            isEdit = false;
        }
        initError = false;
    }

    @Override
    public boolean performFinish() {
        
        String endpointType = endpointDialog.getEndpointType();
        
        if (endpointType.equals("INLINE")) {
            String endpointConfig = endpointDialog.getInlineEndpoint();
            OMElement element = null;
            try {
                element = AXIOMUtil.stringToOM(endpointConfig);
                removeIndentations(element);
              //TODO Add validation for inline endpoint 
                
            } catch (XMLStreamException e) {
                //TODO open error popup
            }
            endpointTableEntry = new EndpointTableEntry(true, element.toString());
        } else {
            String endpointName = endpointDialog.getStaticEndpoint();
            endpointTableEntry = new EndpointTableEntry(false, endpointName);
        }
        isFinish = true;
        return true;
    }
    
    public void addPages() {
        if (!initError) {
            addPage(endpointDialog);
            super.addPages();
        }
    }
    
    public ConfigureEndpointDialog getEndpointDialog() {
        return endpointDialog;
    }
    
    public boolean isFinish() {
       return this.isFinish;
    }
    
    public EndpointTableEntry getEndpointTableEntry() {
        return this.endpointTableEntry;
    }
    
    public void setEndpointTableEntry(EndpointTableEntry tableEntry) {
        this.endpointTableEntry = tableEntry;
    }
    
    public void setIsEdit() {
        this.isEdit = true;
    }
    
    /**
     * Helper function to remove indentations.
     * @param element
     */
    public static void removeIndentations(OMElement element) {
        List<OMText> removables = new ArrayList<OMText>();
        removeIndentations(element, removables);
        for (OMText node : removables) {
            node.detach();
        }
    }

    /**
     * Helper function to remove indentations.
     * @param element
     * @param removables
     */
    private static void removeIndentations(OMElement element, List<OMText> removables) {
        
        Iterator children = element.getChildren();
        while (children.hasNext()) {
            Object next = children.next();
            if (next instanceof OMText) {
                OMText text = (OMText) next;
                if (text.getText().trim().equals("")) {
                    removables.add(text);
                }
            } else if (next instanceof OMElement) {
                removeIndentations((OMElement) next, removables);
            }
        }
       
    }
}
