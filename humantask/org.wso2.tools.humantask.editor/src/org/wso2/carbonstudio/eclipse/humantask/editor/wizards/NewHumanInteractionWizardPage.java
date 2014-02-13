package org.wso2.developerstudio.eclipse.humantask.editor.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class NewHumanInteractionWizardPage extends WizardPage {
	private Text containerText;

	private Text fileText;

	private ISelection selection;

	/** which namespace to use to create the process */
	private Combo humanInteractionsNamespaceField;

	public static final String WSO2_BPS_NS = "http://wso2.org/bps";
	public static final String WSO2_BPS_SAMPLES_NS = "http://wso2.org/bps/samples";

	public static final String EMPTY = ""; //$NON-NLS-1$

	private Listener validateListner = new Listener() {
		public void handleEvent(Event event) {
			setPageComplete(validateDatePageFileds());
		}
	};

	/**
	 * Constructor for NewHumanInteractionWizardPage.
	 * 
	 * @param pageName
	 */
	public NewHumanInteractionWizardPage(ISelection selection) {
		super("HumanInteractionWizardPage");
		setTitle("Human Interactions File");
		setDescription("This wizard creates a new Human Interactions file (*.hi). Please specify the required fields.");
		this.selection = selection;
	}

	/**
	 * Create new human interactions file wizard UI.
	 * 
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText("&Container:");

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText("Namespace:");
		humanInteractionsNamespaceField = new Combo(container, SWT.DROP_DOWN
				| SWT.SIMPLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		humanInteractionsNamespaceField.setLayoutData(gd);
		humanInteractionsNamespaceField.setFont(parent.getFont());

		// Populate some known namespaces
		humanInteractionsNamespaceField.setItems(new String[] { WSO2_BPS_NS,
				WSO2_BPS_SAMPLES_NS });
		humanInteractionsNamespaceField.addListener(SWT.Modify, validateListner);
		label = new Label(container, SWT.NULL);

		// add the namespace values
		// processNamespaceField.setItems(
		// BPELUIPlugin.INSTANCE.getTemplates().getNamespaceNames() );
		// processNamespaceField.addListener(SWT.Modify, validateListner);

		label = new Label(container, SWT.NULL);
		label.setText("&File name:");

		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Returns the value of human interaction file's target namespace field.
	 * 
	 * @return namespace URI as String
	 */
	public String getHumanInteractionsFileTargetNamespace() {
		return getNamespaceFieldValue();
	}

	private String getNamespaceFieldValue() {
		if (humanInteractionsNamespaceField == null) {
			return EMPTY;
		}
		return humanInteractionsNamespaceField.getText().trim();
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	protected boolean validateDatePageFileds() {
		String namespace = humanInteractionsNamespaceField.getText().trim();
		if (namespace.length() < 1) {
			setErrorMessage("Human Ineractions file's target namespace cannot be empty.");
			return false;
		}
		return true;
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

	private void initialize() {
		if (selection != null && selection.isEmpty() == false
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IContainer container;
				if (obj instanceof IContainer)
					container = (IContainer) obj;
				else
					container = ((IResource) obj).getParent();
				containerText.setText(container.getFullPath().toString());
			}
		}
		fileText.setText("new_file.hi");
	}

	/**
	 * Uses the standard container selection dialog to choose the new value for
	 * the container field.
	 */

	private void handleBrowse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(
				getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
				"Select new file container");
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		IResource container = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(getContainerName()));
		String fileName = getFileName();

		if (getContainerName().length() == 0) {
			updateStatus("File container must be specified");
			return;
		}
		if (container == null
				|| (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
			updateStatus("File container must exist");
			return;
		}
		if (!container.isAccessible()) {
			updateStatus("Project must be writable");
			return;
		}
		if (fileName.length() == 0) {
			updateStatus("File name must be specified");
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("File name must be valid");
			return;
		}
		int dotLoc = fileName.lastIndexOf('.');
		if (dotLoc != -1) {
			String ext = fileName.substring(dotLoc + 1);
			if (ext.equalsIgnoreCase("hi") == false) {
				updateStatus("File extension must be \"hi\"");
				return;
			}
		}
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getContainerName() {
		return containerText.getText();
	}

	public String getFileName() {
		return fileText.getText();
	}
}