package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.RegistryKeyPropertyImpl;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;
import org.wso2.developerstudio.esb.form.editors.article.providers.RegistryKeyPropertyEditorDialog;

/**
 * A SWT based editor dialog to be used for editing registry key properties.
 */
public class EEFRegistryKeyPropertyEditorDialog extends RegistryKeyPropertyEditorDialog {

    /**
     * Default registry url.
     */
    private static final String DEFAULT_REGISTRY_URL = "https://localhost:9443/registry";

    /**
     * Creates a new {@link RegistryKeyPropertyEditorDialog} instance.
     * 
     * @param parent
     *            parent shell.
     * @param style
     *            style.
     * @param property
     *            {@link RegistryKeyProperty} to be edited.
     * @param localNamedEntities
     *            named entities currently defined on the local configuration.
     */
    public EEFRegistryKeyPropertyEditorDialog(Shell parent, int style, RegistryKeyProperty property,
            java.util.List<NamedEntityDescriptor> localNamedEntities) {
        super(parent, style, property, localNamedEntities);
    }
    
    @Override
    protected void saveConfiguration() {
        super.saveConfigurationWithTransaction();
    }

}

