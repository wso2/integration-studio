package org.wso2.developerstudio.datamapper.diagram.part;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class DataMapperCreationWizardPage extends WizardNewFileCreationPage {
	/*
	 * GENERATED NOT
	 */
	public static String avroFilePathIn;
	public static String avroFilePathOut;

	/**
	 * @generated
	 */
	private final String fileExtension;

	/**
	 * @generated
	 */
	public DataMapperCreationWizardPage(String pageName, IStructuredSelection selection,
			String fileExtension) {
		super(pageName, selection);
		this.fileExtension = fileExtension;
	}

	/*	@generated NOT
	 * selection .avro from Create New Datamapper wizard
	 * import .avro file
	 * 
	 * Override createAdvancedControle.
	 *  
	 */
	@Override
	protected void createAdvancedControls(Composite parent) {

		super.createAdvancedControls(parent);
		createContent(parent);
	}

	/* @generated NOT
	 * create Lable, text and button
	 * 
	 */
	private void createContent(Composite parent) {
		Composite linkTargetGroup = new Composite(parent, SWT.NONE); //goups new set as a  sub Composite group

		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		layout.marginHeight = 0;
		layout.marginWidth = 0;

		linkTargetGroup.setLayout(layout);

		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		//		data.horizontalAlignment = GridData.FILL;
		//		GridData data = setButtonLayoutData(avroFileButton);

		Label avroSourceLable = new Label(linkTargetGroup, SWT.NONE);
		avroSourceLable.setText("Avro File In:");
		avroSourceLable.setLayoutData(data);

		final Text linkTargetField = new Text(linkTargetGroup, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		data.horizontalSpan = 2;
		linkTargetField.setLayoutData(data);

		Button avroFileButton = new Button(linkTargetGroup, SWT.PUSH);
		avroFileButton.setText("Browse");
		avroFileButton.setLayoutData(data);
		avroFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				linkTargetField.setText(selectAvroFileIn());
			}
		});
		setButtonLayoutData(avroFileButton);

		/*
		 * 
		 */

		GridLayout layout2 = new GridLayout();
		layout2.numColumns = 4;
		layout2.marginHeight = 0;
		layout2.marginWidth = 0;

		linkTargetGroup.setLayout(layout2);

		GridData data2 = new GridData(GridData.FILL_HORIZONTAL);
		//		data.horizontalAlignment = GridData.FILL;
		//		GridData data = setButtonLayoutData(avroFileButton);

		Label avroSourceLable2 = new Label(linkTargetGroup, SWT.NONE);
		avroSourceLable2.setText("Avro File Out:");
		avroSourceLable2.setLayoutData(data2);

		final Text linkTargetField2 = new Text(linkTargetGroup, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		data.horizontalSpan = 2;
		linkTargetField2.setLayoutData(data);

		Button avroFileButton2 = new Button(linkTargetGroup, SWT.PUSH);
		avroFileButton2.setText("Browse");
		avroFileButton2.setLayoutData(data);
		avroFileButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				linkTargetField2.setText(selectAvroFileOut());
			}
		});
		setButtonLayoutData(avroFileButton2);

	}

	/* @generated NOT
	 * handle when "browse" button click.
	 * Only allow to import .avro files
	 * return file path.
	 */
	private String selectAvroFileIn() {
		FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
		//		dialog.setFilterExtensions(new String[]{"*.avro"});
		// dialog.setFilterPath("c:\\temp");
		String result = dialog.open();
		avroFilePathIn = result;
		return result;
	}

	private String selectAvroFileOut() {
		FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
		//		dialog.setFilterExtensions(new String[]{"*.avro"});
		// dialog.setFilterPath("c:\\temp");
		String result = dialog.open();
		avroFilePathOut = result;
		return result;
	}

	/**
	 * Override to create files with this extension.
	 * 
	 * @generated
	 */
	protected String getExtension() {
		return fileExtension;
	}

	/**
	 * @generated
	 */
	public URI getURI() {
		return URI.createPlatformResourceURI(getFilePath().toString(), false);
	}

	/**
	 * @generated
	 */
	protected IPath getFilePath() {
		IPath path = getContainerFullPath();
		if (path == null) {
			path = new Path(""); //$NON-NLS-1$
		}
		String fileName = getFileName();
		if (fileName != null) {
			path = path.append(fileName);
		}
		return path;
	}

	/**
	 * @generated  
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
		setFileName(DataMapperDiagramEditorUtil.getUniqueFileName(getContainerFullPath(),
				getFileName(), getExtension()));
		setPageComplete(validatePage());
	}

	/**
	 * @generated
	 */
	protected boolean validatePage() {
		if (!super.validatePage()) {
			return false;
		}
		String extension = getExtension();
		if (extension != null && !getFilePath().toString().endsWith("." + extension)) {
			setErrorMessage(NLS
					.bind(Messages.DataMapperCreationWizardPageExtensionError, extension));
			return false;
		}
		return true;
	}

	//	public String getAvroFilePath() {
	//		return avroFilePath;
	//	}
	//
	//	public void setAvroFilePath(String avroFilePath) {
	//		this.avroFilePath = avroFilePath;
	//	}

}
