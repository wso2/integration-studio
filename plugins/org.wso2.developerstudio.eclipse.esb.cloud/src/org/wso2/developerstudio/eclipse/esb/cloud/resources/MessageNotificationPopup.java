package org.wso2.developerstudio.eclipse.esb.cloud.resources;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

public class MessageNotificationPopup extends PopupDialog {

    private FormToolkit toolkit;

    private Form form;

    private Composite sectionClient;

    private IWorkbenchWindow window;

    private String title;

    private String message;
    
    private ArrayList<String> links;

    public MessageNotificationPopup(IWorkbenchWindow window, Shell parent) {
        super(parent, PopupDialog.INFOPOPUP_SHELLSTYLE | SWT.ON_TOP, false, false, false, false, false, null, null);
        this.window = window;
        links = new ArrayList<String>();
    }

    public boolean close() {
        toolkit.dispose();
        return super.close();
    }

    public void setContent(String title, String message, ArrayList<String> links) {
        this.title = title;
        this.message = message;
        this.links = links;
    }

    protected Control createContents(Composite parent) {
        getShell().setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_GRAY));
        toolkit = new FormToolkit(parent.getDisplay());
        form = toolkit.createForm(parent);
        form.getBody().setLayout(new FillLayout());

        Section section = toolkit.createSection(form.getBody(), ExpandableComposite.TITLE_BAR);
        section.setText(title);
        section.setLayout(new FillLayout());

        sectionClient = toolkit.createComposite(section);
        sectionClient.setLayout(new GridLayout());
        
        Label lbl = toolkit.createLabel(parent, this.message);
        
        for (String endpoint : this.links) {
            Hyperlink link = toolkit.createHyperlink(sectionClient, endpoint, SWT.NONE);
            link.addHyperlinkListener(new HyperlinkAdapter() {
                public void linkActivated(HyperlinkEvent e) {
//                    try {
////                        MessagesView view = (MessagesView) window.getActivePage().showView(MessagesView.VIEW_ID);
////                        view.selectTab(null, null, null, userID, userName);
//                    } catch (CoreException ce) {
//                        ce.printStackTrace();
//                    }
                }
            });
        }
        

        section.setClient(sectionClient);

        ImageHyperlink hyperlink = toolkit.createImageHyperlink(section, SWT.NONE);
        hyperlink.setBackground(null);
        hyperlink.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
        hyperlink.addHyperlinkListener(new HyperlinkAdapter() {
            public void linkActivated(HyperlinkEvent e) {
                close();
            }
        });

        section.setTextClient(hyperlink);

        form.pack();
        return parent;
    }

    /**
     * Initialize the shell's bounds.
     */
    public void initializeBounds() {
        getShell().setBounds(restoreBounds());
    }

    private Rectangle restoreBounds() {
        Rectangle bounds = form.getBounds();
        Rectangle maxBounds = window.getShell().getMonitor().getClientArea();

        if (bounds.width > -1 && bounds.height > -1) {
            if (maxBounds != null) {
                bounds.width = Math.min(bounds.width, maxBounds.width);
                bounds.height = Math.min(bounds.height, maxBounds.height);
            }
            // Enforce an absolute minimal size
            bounds.width = Math.max(bounds.width, 30);
            bounds.height = Math.max(bounds.height, 30);
        }

        if (bounds.x > -1 && bounds.y > -1 && maxBounds != null) {
            if (bounds.width > -1 && bounds.height > -1) {
                bounds.x = maxBounds.x + maxBounds.width - bounds.width;
                bounds.y = maxBounds.y + maxBounds.height - bounds.height;
            }
        }

        return bounds;
    }
}