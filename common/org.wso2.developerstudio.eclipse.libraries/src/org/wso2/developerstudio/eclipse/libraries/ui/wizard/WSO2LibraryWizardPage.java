package org.wso2.developerstudio.eclipse.libraries.ui.wizard;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPageExtension;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPageExtension2;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.libraries.utils.LibImageUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryArtifact;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryArtifactHandler;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryCategory;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class WSO2LibraryWizardPage extends WizardPage implements
		IClasspathContainerPage, IClasspathContainerPageExtension,
		IClasspathContainerPageExtension2 {
	private IClasspathEntry[] classPathEntries;
	private List<IClasspathEntry> newClassPathEntries = new ArrayList<IClasspathEntry>();
	private boolean isFirstTimeStatusUpdating = true;
	private TabFolder tabFolder;
	private List<CheckboxTableViewer> viewerList = new ArrayList<CheckboxTableViewer>();
	private boolean isStillControlsBeingCreated = true;

	public WSO2LibraryWizardPage() {
		super("WSO2 Classpath Libraries");
		setTitle("WSO2 Classpath Libraries");
		setDescription("Select the libraries which you want to add to the classpath");
	}

	private LibraryArtifact[] getSelectedLibraryArtifacts() {
		List<LibraryArtifact> artifacts = new ArrayList<LibraryArtifact>();
		for (CheckboxTableViewer checkboxTableViewer : viewerList) {
			Object[] checkedElements = checkboxTableViewer.getCheckedElements();
			for (Object element : checkedElements) {
				if (!artifacts.contains(element)) {
					artifacts.add((LibraryArtifact) element);
				}
			}
		}
		return artifacts.toArray(new LibraryArtifact[] {});
	}

	public boolean finish() {
		LibraryArtifact[] checkedElements = getSelectedLibraryArtifacts();
		if (checkedElements.length > 0) {
			for (LibraryArtifact element : checkedElements) {
				URL resourceURL = element.getLibraryUrl();
				if (resourceURL == null) {
					setErrorMessage("Could not locate library "
							+ element.getLibraryFileName() + " in bundle "
							+ element.getLibraryBundle().getSymbolicName()
							+ ".");
					return false;
				}
				File dependencyPath = LibraryUtils
						.getDependencyPath(resourceURL);
				IClasspathEntry classPathEntry = JavaUtils
						.createClassPathEntry(dependencyPath);
				newClassPathEntries.add(classPathEntry);
			}
			return true;
		} else {
			return false;
		}
	}

	public void createControl(Composite parent) {
		isStillControlsBeingCreated = true;
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setSelection(0);
		GridData gd_tabFolder = new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1);
		gd_tabFolder.heightHint = 350;
		tabFolder.setLayoutData(gd_tabFolder);
		Map<String, LibraryCategory> libraryArtifactCategories = LibraryArtifactHandler
				.getLibraryArtifactCategories();
		addTabPage(libraryArtifactCategories
				.get(LibraryArtifactHandler.ALL_LIB_CATEGORY_ID));
		for (String key : libraryArtifactCategories.keySet()) {
			if (!key.equals(LibraryArtifactHandler.ALL_LIB_CATEGORY_ID)) {
				LibraryCategory category = libraryArtifactCategories.get(key);
				if (category.getLibraryArtifacts().size() > 0) {
					addTabPage(category);
				}
			}
		}
		isStillControlsBeingCreated = false;
		setControl(composite);
	}

	private void addTabPage(LibraryCategory category) {
		TabItem tabPageLibrary = new TabItem(tabFolder, SWT.NONE);
		tabPageLibrary.setText(category.getName());
		ImageDescriptor icon = category.getIcon();
		if (icon != null) {
			tabPageLibrary.setImage(icon.createImage());
		}

		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tabPageLibrary.setControl(composite_1);
		composite_1.setLayout(new GridLayout(1, false));

		Label lblDescription = new Label(composite_1, SWT.NONE);
		lblDescription.setText(category.getDescription());

		final CheckboxTableViewer checkboxTableViewer = CheckboxTableViewer
				.newCheckList(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = checkboxTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

//		TableColumn tblclmnLibraryName = new TableColumn(table, SWT.NONE);
//		tblclmnLibraryName.setWidth(200);
//		tblclmnLibraryName.setText("Library Name");

		// TableColumn tblclmnLibraryDescription = new TableColumn(table,
		// SWT.NONE);
		// tblclmnLibraryDescription.setWidth(400);
		// tblclmnLibraryDescription.setText("Description");

		Composite composite_2 = new Composite(composite_1, SWT.NONE);
		composite_2.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnSelectAll = new Button(composite_2, SWT.NONE);
		final Button btnDeselectAll = new Button(composite_2, SWT.NONE);

		btnSelectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				checkboxTableViewer.setAllChecked(true);
				updateButtonStatus(btnSelectAll, btnDeselectAll,
						checkboxTableViewer, table);
			}
		});
		btnSelectAll.setLayoutData(new RowData(100, SWT.DEFAULT));
		btnSelectAll.setText("Select All");

		btnDeselectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				checkboxTableViewer.setAllChecked(false);
				updateButtonStatus(btnSelectAll, btnDeselectAll,
						checkboxTableViewer, table);
			}
		});
		btnDeselectAll.setLayoutData(new RowData(100, SWT.DEFAULT));
		btnDeselectAll.setText("Deselect All");

		checkboxTableViewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent arg0) {
				updateButtonStatus(btnSelectAll, btnDeselectAll,
						checkboxTableViewer, table);
			}

		});
		loadLibraries(category, table);
		if (checkboxTableViewer.getTable().getItemCount() > 0) {
			viewerList.add(checkboxTableViewer);
			updateButtonStatus(btnSelectAll, btnDeselectAll,
					checkboxTableViewer, table);
		} else {
			tabPageLibrary.dispose();
		}
	}

	private void loadLibraries(LibraryCategory category, Table table) {
		List<LibraryArtifact> libraryArtifacts = category.getLibraryArtifacts();
		for (LibraryArtifact libraryArtifact : libraryArtifacts) {
			if (!isLibraryExists(libraryArtifact.getFileName())) {
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setImage(LibImageUtils.getInstance().getImageDescriptor("jar_obj.gif")
						.createImage());
				tableItem.setText(new String[] { libraryArtifact.getName(),
						libraryArtifact.getDescription() });
				tableItem.setData(libraryArtifact);
			}
		}
	}

	private void updateButtonStatus(Button btnSelectAll, Button btnDeselectAll,
			CheckboxTableViewer checkboxTableViewer, Table table) {
		int checkedItemCount = checkboxTableViewer.getCheckedElements().length;
		btnDeselectAll.setEnabled(checkedItemCount != 0);
		btnSelectAll.setEnabled(checkedItemCount != table.getItemCount());
		if (getSelectedLibraryArtifacts().length == 0) {
			updateStatus("Please check/tick the libraries you want to add to the classpath of the project");
		} else {
			updateStatus(null);
		}
	}

	private void updateStatus(String message) {
		if (!isStillControlsBeingCreated) {
			if (!isFirstTimeStatusUpdating) {
				setErrorMessage(message);
			} else {
				isFirstTimeStatusUpdating = false;
			}
		}
		setPageComplete(message == null);
	}

	public IClasspathEntry getSelection() {
		return null;
	}

	public void setSelection(IClasspathEntry arg0) {

	}

	public void initialize(IJavaProject project,
			IClasspathEntry[] classPathEntries) {
		this.classPathEntries = classPathEntries;
	}

	public List<String> getExistingLibraryPaths() {
		List<String> paths = new ArrayList<String>();
		for (IClasspathEntry classpath : classPathEntries) {
			if (classpath.getEntryKind() == IClasspathEntry.CPE_LIBRARY || classpath.getEntryKind() == IClasspathEntry.CPE_VARIABLE) {
				paths.add(classpath.getPath().toFile().getName());
			}
		}
		return paths;
	}

	private boolean isLibraryExists(String libraryName) {
		return getExistingLibraryPaths().contains(libraryName);
	}

	public IClasspathEntry[] getNewContainers() {
		return newClassPathEntries.toArray(new IClasspathEntry[] {});
	}
}
