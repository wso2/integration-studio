/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.distribution.project.ui.wizard;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.dialogs.WorkingSetGroup;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.StatusUtil;
import org.eclipse.ui.internal.wizards.datatransfer.ArchiveFileManipulations;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;
import org.eclipse.ui.internal.wizards.datatransfer.ILeveledImportStructureProvider;
import org.eclipse.ui.internal.wizards.datatransfer.TarEntry;
import org.eclipse.ui.internal.wizards.datatransfer.TarException;
import org.eclipse.ui.internal.wizards.datatransfer.TarFile;
import org.eclipse.ui.internal.wizards.datatransfer.TarLeveledStructureProvider;
import org.eclipse.ui.internal.wizards.datatransfer.ZipLeveledStructureProvider;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.rauschig.jarchivelib.ArchiveFormat;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.distribution.project.util.MavenMultiModuleImportUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ProjectsImportPage extends WizardPage implements IOverwriteQuery {

	private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static final String METADATA_FOLDER = ".metadata"; //$NON-NLS-1$

	private static final String MAVEN_MULTI_MODULE_NATURE = "org.wso2.developerstudio.eclipse.mavenmultimodule.project.nature";
	
	private static final String DIR_DOT_METADATA = ".metadata";
	
	private static final String DIR_CONNECTORS = ".Connectors";
	
	private static final String ZIP_FILE_EXTENSION = ".zip";

	private static final String IMPORT_ARCHIVE_LOCATION = File.separator + ".tmp" + File.separator
			+ "APIMArchiveImport";
	
	private static final String SLASH = "/";

	private ILeveledImportStructureProvider structureProvider;

	private final class ProjectLabelProvider extends LabelProvider implements IColorProvider {

		public String getText(Object element) {
			return ((ProjectRecord) element).getProjectLabel();
		}

		public Color getBackground(Object element) {
			return null;
		}

		public Color getForeground(Object element) {
			ProjectRecord projectRecord = (ProjectRecord) element;
			if (projectRecord.hasConflicts)
				return getShell().getDisplay().getSystemColor(SWT.COLOR_GRAY);
			return null;
		}
	}

	public List<IProject> getCreatedProjects() {
		return createdProjects;
	}

	/**
	 * Class declared public only for test suite.
	 * 
	 */
	public class ProjectRecord {
		File projectSystemFile;
		Object projectArchiveFile;
		String projectName;
		Object parent;
		int level;
		boolean hasConflicts;
		IProjectDescription description;

		/**
		 * Create a record for a project based on the info in the file.
		 * 
		 * @param file
		 */
		ProjectRecord(File file) {
			projectSystemFile = file;
			setProjectName();
		}

		/**
		 * @param file
		 *            The Object representing the .project file
		 * @param parent
		 *            The parent folder of the .project file
		 * @param level
		 *            The number of levels deep in the provider the file is
		 */
		ProjectRecord(Object file, Object parent, int level) {
			this.projectArchiveFile = file;
			this.parent = parent;
			this.level = level;
			setProjectName();
		}

		/**
		 * Set the name of the project based on the projectFile.
		 */
		private void setProjectName() {
			try {
				if (projectArchiveFile != null) {
					InputStream stream = structureProvider.getContents(projectArchiveFile);

					// If we can get a description pull the name from there
					if (stream == null) {
						if (projectArchiveFile instanceof ZipEntry) {
							IPath path = new Path(((ZipEntry) projectArchiveFile).getName());
							projectName = path.segment(path.segmentCount() - 2);
						} else if (projectArchiveFile instanceof TarEntry) {
							IPath path = new Path(((TarEntry) projectArchiveFile).getName());
							projectName = path.segment(path.segmentCount() - 2);
						}
					} else {
						description = IDEWorkbenchPlugin.getPluginWorkspace().loadProjectDescription(stream);
						stream.close();
						projectName = description.getName();
					}

				}

				// If we don't have the project name try again
				if (projectName == null) {
					IPath path = new Path(projectSystemFile.getPath());
					// if the file is in the default location, use the directory
					// name as the project name
					if (isDefaultLocation(path)) {
						projectName = path.segment(path.segmentCount() - 2);
						description = IDEWorkbenchPlugin.getPluginWorkspace().newProjectDescription(projectName);
					} else {
						description = IDEWorkbenchPlugin.getPluginWorkspace().loadProjectDescription(path);
						projectName = description.getName();
					}

				}
			} catch (CoreException e) {
				// no good couldn't get the name
			} catch (IOException e) {
				// no good couldn't get the name
			}
		}

		/**
		 * Returns whether the given project description file path is in the default
		 * location for a project
		 * 
		 * @param path
		 *            The path to examine
		 * @return Whether the given path is the default location for a project
		 */
		private boolean isDefaultLocation(IPath path) {
			// The project description file must at least be within the project,
			// which is within the workspace location
			if (path.segmentCount() < 2)
				return false;
			return path.removeLastSegments(2).toFile().equals(Platform.getLocation().toFile());
		}

		/**
		 * Get the name of the project
		 * 
		 * @return String
		 */
		public String getProjectName() {
			return projectName;
		}

		/**
		 * Gets the label to be used when rendering this project record in the UI.
		 * 
		 * @return String the label
		 * @since 3.4
		 */
		public String getProjectLabel() {
			if (description == null)
				return projectName;

			String path = projectSystemFile == null ? structureProvider.getLabel(parent)
					: projectSystemFile.getParent();

			return NLS.bind(DataTransferMessages.WizardProjectsImportPage_projectLabel, projectName, path);
		}

		/**
		 * @return Returns the hasConflicts.
		 */
		public boolean hasConflicts() {
			return hasConflicts;
		}
	}

	private ArrayList<String> paths = new ArrayList<String>();

	// dialog store id constants
	private final static String STORE_COPY_PROJECT_ID = "WizardProjectsImportPage.STORE_COPY_PROJECT_ID"; //$NON-NLS-1$
	private final static String STORE_ARCHIVE_SELECTED = "WizardProjectsImportPage.STORE_ARCHIVE_SELECTED"; //$NON-NLS-1$
	private Text directoryPathField;
	private CheckboxTreeViewer projectsList;
	private Button copyCheckbox;
	private boolean copyFiles = true;
	private ProjectRecord[] selectedProjects = new ProjectRecord[0];
	// Keep track of the directory that we browsed to last time
	// the wizard was invoked.
	private static String previouslyBrowsedDirectory = ""; //$NON-NLS-1$

	// Keep track of the archive that we browsed to last time
	// the wizard was invoked.
	private static String previouslyBrowsedArchive = ""; //$NON-NLS-1$

	private Button projectFromDirectoryRadio;

	private Button projectFromArchiveRadio;

	private Text archivePathField;

	private Button browseDirectoriesButton;

	private Button browseArchivesButton;

	private IProject[] wsProjects;

	// constant from WizardArchiveFileResourceImportPage1
	private static final String[] FILE_IMPORT_MASK = { "*.jar;*.zip;*.tar;*.tar.gz;*.tgz", "*.*" }; //$NON-NLS-1$ //$NON-NLS-2$

	// The initial path to set
	private String initialPath;

	// The last selected path to minimize searches
	private String lastPath;
	// The last time that the file or folder at the selected path was modified
	// to mimize searches
	private long lastModified;

	private WorkingSetGroup workingSetGroup;

	private IStructuredSelection currentSelection;

	private ZipFile sourceFile;
	
	private TarFile sourceTarFile;

	/**
	 * Creates a new project creation wizard page.
	 * 
	 */
	public ProjectsImportPage() {
		this("wizardExternalProjectsPage", null, null); //$NON-NLS-1$
	}

	/**
	 * Create a new instance of the receiver.
	 * 
	 * @param pageName
	 */
	public ProjectsImportPage(String pageName) {
		this(pageName, null, null);
	}

	/**
	 * More (many more) parameters.
	 * 
	 * @param pageName
	 * @param initialPath
	 * @param currentSelection
	 * @since 3.5
	 */
	public ProjectsImportPage(String pageName, String initialPath, IStructuredSelection currentSelection) {
		super(pageName);
		this.initialPath = initialPath;
		this.currentSelection = currentSelection;
		setPageComplete(false);
		setTitle(DataTransferMessages.WizardProjectsImportPage_ImportProjectsTitle);
		setDescription(DataTransferMessages.WizardProjectsImportPage_ImportProjectsDescription);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {

		initializeDialogUnits(parent);

		Composite workArea = new Composite(parent, SWT.NONE);
		setControl(workArea);

		workArea.setLayout(new GridLayout());
		workArea.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		createProjectsRoot(workArea);
		createProjectsList(workArea);
		createOptionsArea(workArea);
		createWorkingSetGroup(workArea);
		restoreWidgetValues();
		Dialog.applyDialogFont(workArea);

	}

	/**
	 * @param workArea
	 */
	private void createWorkingSetGroup(Composite workArea) {
		String[] workingSetIds = new String[] { "org.eclipse.ui.resourceWorkingSetPage", //$NON-NLS-1$
				"org.eclipse.jdt.ui.JavaWorkingSetPage" }; //$NON-NLS-1$
		workingSetGroup = new WorkingSetGroup(workArea, currentSelection, workingSetIds);
	}

	/**
	 * Create the area with the extra options.
	 * 
	 * @param workArea
	 */
	private void createOptionsArea(Composite workArea) {
		Composite optionsGroup = new Composite(workArea, SWT.NONE);
		optionsGroup.setLayout(new GridLayout());
		optionsGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		copyCheckbox = new Button(optionsGroup, SWT.CHECK);
		copyCheckbox.setText(DataTransferMessages.WizardProjectsImportPage_CopyProjectsIntoWorkspace);
		copyCheckbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//copyCheckbox.setSelection(true);
		//copyCheckbox.setEnabled(false);
		copyCheckbox.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				copyFiles = copyCheckbox.getSelection();
			}
		});
	}

	/**
	 * Create the checkbox list for the found projects.
	 * 
	 * @param workArea
	 */
	private void createProjectsList(Composite workArea) {

		Label title = new Label(workArea, SWT.NONE);
		title.setText(DataTransferMessages.WizardProjectsImportPage_ProjectsListTitle);

		Composite listComposite = new Composite(workArea, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.makeColumnsEqualWidth = false;
		listComposite.setLayout(layout);

		listComposite
				.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.FILL_BOTH));

		projectsList = new CheckboxTreeViewer(listComposite, SWT.BORDER);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = new PixelConverter(projectsList.getControl()).convertWidthInCharsToPixels(25);
		gridData.heightHint = new PixelConverter(projectsList.getControl()).convertHeightInCharsToPixels(10);
		projectsList.getControl().setLayoutData(gridData);
		projectsList.setContentProvider(new ITreeContentProvider() {

			public Object[] getChildren(Object parentElement) {
				return null;
			}

			public Object[] getElements(Object inputElement) {
				return getProjectRecords();
			}

			public boolean hasChildren(Object element) {
				return false;
			}

			public Object getParent(Object element) {
				return null;
			}

			public void dispose() {

			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

		});

		projectsList.setLabelProvider(new ProjectLabelProvider());

		projectsList.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				ProjectRecord element = (ProjectRecord) event.getElement();
				if (element.hasConflicts) {
					projectsList.setChecked(element, false);
				}
				setPageComplete(projectsList.getCheckedElements().length > 0);
			}
		});

		projectsList.setInput(this);
		projectsList.setComparator(new ViewerComparator());
		createSelectionButtons(listComposite);
	}

	/**
	 * Create the selection buttons in the listComposite.
	 * 
	 * @param listComposite
	 */
	private void createSelectionButtons(Composite listComposite) {
		Composite buttonsComposite = new Composite(listComposite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		buttonsComposite.setLayout(layout);

		buttonsComposite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		Button selectAll = new Button(buttonsComposite, SWT.PUSH);
		selectAll.setText(DataTransferMessages.DataTransfer_selectAll);
		selectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				for (int i = 0; i < selectedProjects.length; i++) {
					if (selectedProjects[i].hasConflicts)
						projectsList.setChecked(selectedProjects[i], false);
					else
						projectsList.setChecked(selectedProjects[i], true);
				}
				setPageComplete(projectsList.getCheckedElements().length > 0);
			}
		});
		Dialog.applyDialogFont(selectAll);
		setButtonLayoutData(selectAll);

		Button deselectAll = new Button(buttonsComposite, SWT.PUSH);
		deselectAll.setText(DataTransferMessages.DataTransfer_deselectAll);
		deselectAll.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				projectsList.setCheckedElements(new Object[0]);
				setPageComplete(false);
			}
		});
		Dialog.applyDialogFont(deselectAll);
		setButtonLayoutData(deselectAll);

		Button refresh = new Button(buttonsComposite, SWT.PUSH);
		refresh.setText(DataTransferMessages.DataTransfer_refresh);
		refresh.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				if (projectFromDirectoryRadio.getSelection()) {
					updateProjectsList(directoryPathField.getText().trim());
				} else {
					updateProjectsList(archivePathField.getText().trim());
				}
			}
		});
		Dialog.applyDialogFont(refresh);
		setButtonLayoutData(refresh);
	}

	/**
	 * Create the area where you select the root directory for the projects.
	 * 
	 * @param workArea
	 *            Composite
	 */
	private void createProjectsRoot(Composite workArea) {

		// project specification group
		Composite projectGroup = new Composite(workArea, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.makeColumnsEqualWidth = false;
		layout.marginWidth = 0;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// new project from directory radio button
		projectFromDirectoryRadio = new Button(projectGroup, SWT.RADIO);
		projectFromDirectoryRadio.setText(DataTransferMessages.WizardProjectsImportPage_RootSelectTitle);

		// project location entry field
		this.directoryPathField = new Text(projectGroup, SWT.BORDER);

		GridData directoryPathData = new GridData(SWT.FILL, SWT.NONE, true, false);
		directoryPathData.widthHint = new PixelConverter(directoryPathField).convertWidthInCharsToPixels(25);
		directoryPathField.setLayoutData(directoryPathData);

		// browse button
		browseDirectoriesButton = new Button(projectGroup, SWT.PUSH);
		browseDirectoriesButton.setText(DataTransferMessages.DataTransfer_browse);
		setButtonLayoutData(browseDirectoriesButton);

		// new project from archive radio button
		projectFromArchiveRadio = new Button(projectGroup, SWT.RADIO);
		projectFromArchiveRadio.setText(DataTransferMessages.WizardProjectsImportPage_ArchiveSelectTitle);

		// project location entry field
		archivePathField = new Text(projectGroup, SWT.BORDER);

		GridData archivePathData = new GridData(SWT.FILL, SWT.NONE, true, false);
		archivePathData.widthHint = new PixelConverter(archivePathField).convertWidthInCharsToPixels(25);
		archivePathField.setLayoutData(archivePathData); // browse button
		browseArchivesButton = new Button(projectGroup, SWT.PUSH);
		browseArchivesButton.setText(DataTransferMessages.DataTransfer_browse);
		setButtonLayoutData(browseArchivesButton);

		projectFromDirectoryRadio.setSelection(true);
		archivePathField.setEnabled(false);
		browseArchivesButton.setEnabled(false);

		browseDirectoriesButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				handleLocationDirectoryButtonPressed();
			}

		});

		browseArchivesButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				handleLocationArchiveButtonPressed();
			}

		});

		directoryPathField.addTraverseListener(new TraverseListener() {

			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					updateProjectsList(directoryPathField.getText().trim());
				}
			}

		});

		directoryPathField.addFocusListener(new FocusAdapter() {

			public void focusLost(org.eclipse.swt.events.FocusEvent e) {
				updateProjectsList(directoryPathField.getText().trim());
			}

		});

		archivePathField.addTraverseListener(new TraverseListener() {

			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					updateProjectsList(archivePathField.getText().trim());
				}
			}

		});

		archivePathField.addFocusListener(new FocusAdapter() {

			public void focusLost(org.eclipse.swt.events.FocusEvent e) {
				updateProjectsList(archivePathField.getText().trim());
			}
		});

		projectFromDirectoryRadio.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				directoryRadioSelected();
			}
		});

		projectFromArchiveRadio.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				archiveRadioSelected();
			}
		});
	}

	private void archiveRadioSelected() {
		if (projectFromArchiveRadio.getSelection()) {
			directoryPathField.setEnabled(false);
			browseDirectoriesButton.setEnabled(false);
			archivePathField.setEnabled(true);
			browseArchivesButton.setEnabled(true);
			updateProjectsList(archivePathField.getText());
			archivePathField.setFocus();
			copyCheckbox.setSelection(true);
			copyCheckbox.setEnabled(false);
		}
	}

	private void directoryRadioSelected() {
		if (projectFromDirectoryRadio.getSelection()) {
			directoryPathField.setEnabled(true);
			browseDirectoriesButton.setEnabled(true);
			archivePathField.setEnabled(false);
			browseArchivesButton.setEnabled(false);
			updateProjectsList(directoryPathField.getText());
			directoryPathField.setFocus();
			copyCheckbox.setEnabled(true);
			copyCheckbox.setSelection(copyFiles);
		}
	}

	/*
	 * (non-Javadoc) Method declared on IDialogPage. Set the focus on path fields
	 * when page becomes visible.
	 */
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible && this.projectFromDirectoryRadio.getSelection()) {
			this.directoryPathField.setFocus();
		}
		if (visible && this.projectFromArchiveRadio.getSelection()) {
			this.archivePathField.setFocus();
		}
	}

	/**
	 * Update the list of projects based on path. Method declared public only for
	 * test suite.
	 * 
	 * @param path
	 */
	public void updateProjectsList(final String path) {
		// on an empty path empty selectedProjects
		if (path == null || path.length() == 0) {
			setMessage(DataTransferMessages.WizardProjectsImportPage_ImportProjectsDescription);
			selectedProjects = new ProjectRecord[0];
			projectsList.refresh(true);
			projectsList.setCheckedElements(selectedProjects);
			setPageComplete(projectsList.getCheckedElements().length > 0);
			lastPath = path;
			return;
		}

		final File directory = new File(path);
		long modified = directory.lastModified();
		if (path.equals(lastPath) && lastModified == modified) {
			// since the file/folder was not modified and the path did not
			// change, no refreshing is required
			return;
		}

		lastPath = path;
		lastModified = modified;

		// We can't access the radio button from the inner class so get the
		// status beforehand
		final boolean dirSelected = this.projectFromDirectoryRadio.getSelection();
		try {
			getContainer().run(true, true, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) {

					monitor.beginTask(DataTransferMessages.WizardProjectsImportPage_SearchingMessage, 100);
					selectedProjects = new ProjectRecord[0];
					Collection files = new ArrayList();
					monitor.worked(10);
					if (!dirSelected && ArchiveFileManipulations.isTarFile(path)) {
						sourceTarFile = getSpecifiedTarSourceFile(path);
						if (sourceTarFile == null) {
							return;
						}

						structureProvider = new TarLeveledStructureProvider(sourceTarFile);
						Object child = structureProvider.getRoot();

						child = checkSelectedTarArchiveIsAPIMProject(child, sourceTarFile);
						if (!collectProjectFilesFromProvider(files, child, 0, monitor)) {
							return;
						}
						Iterator filesIterator = files.iterator();
						selectedProjects = new ProjectRecord[files.size()];
						int index = 0;
						monitor.worked(50);
						monitor.subTask(DataTransferMessages.WizardProjectsImportPage_ProcessingMessage);
						while (filesIterator.hasNext()) {
							selectedProjects[index++] = (ProjectRecord) filesIterator.next();
						}
					} else if (!dirSelected && ArchiveFileManipulations.isZipFile(path)) {
						sourceFile = getSpecifiedZipSourceFile(path);
						if (sourceFile == null) {
							return;
						}
						structureProvider = new ZipLeveledStructureProvider(sourceFile);
						Object child = structureProvider.getRoot();

						child = checkSelectedZipArchiveIsAPIMProject(child, sourceFile);
						if (!collectProjectFilesFromProvider(files, child, 0, monitor)) {
							return;
						}
						Iterator filesIterator = files.iterator();
						selectedProjects = new ProjectRecord[files.size()];
						int index = 0;
						monitor.worked(50);
						monitor.subTask(DataTransferMessages.WizardProjectsImportPage_ProcessingMessage);
						while (filesIterator.hasNext()) {
							selectedProjects[index++] = (ProjectRecord) filesIterator.next();
						}
					}

					else if (dirSelected && directory.isDirectory()) {

						if (!collectProjectFilesFromDirectory(files, directory, null, monitor)) {
							return;
						}
						Iterator filesIterator = files.iterator();
						selectedProjects = new ProjectRecord[files.size()];
						int index = 0;
						monitor.worked(50);
						monitor.subTask(DataTransferMessages.WizardProjectsImportPage_ProcessingMessage);
						while (filesIterator.hasNext()) {
							File file = (File) filesIterator.next();
							selectedProjects[index] = new ProjectRecord(file);
							index++;
						}
					} else {
						monitor.worked(60);
					}
					monitor.done();
				}

			});
		} catch (InvocationTargetException e) {
			IDEWorkbenchPlugin.log(e.getMessage(), e);
		} catch (InterruptedException e) {
			// Nothing to do if the user interrupts.
		}

		projectsList.refresh(true);
		ProjectRecord[] projects = getProjectRecords();
		boolean displayWarning = false;
		for (int i = 0; i < projects.length; i++) {
			if (projects[i].hasConflicts) {
				displayWarning = true;
				projectsList.setGrayed(projects[i], true);
			} else {
				projectsList.setChecked(projects[i], true);
			}
		}

		if (displayWarning) {
			setMessage(DataTransferMessages.WizardProjectsImportPage_projectsInWorkspace, WARNING);
		} else {
			setMessage(DataTransferMessages.WizardProjectsImportPage_ImportProjectsDescription);
		}
		setPageComplete(projectsList.getCheckedElements().length > 0);
		if (selectedProjects.length == 0) {
			setMessage(DataTransferMessages.WizardProjectsImportPage_noProjectsToImport, WARNING);
		}
	}
	
	/**
	 * Check selected Zip archive includes APIM project. If exists create .project
	 * file. This operation will execute by copying the zip file to the .tmp
	 * location in workspace After adding the .project file it recreates a zip
	 * archive and proceed the flow
	 * 
	 * @param child
	 *            current zip entries
	 * @param zipFile
	 *            selected zip file
	 * @return updated zip entries
	 */
	private Object checkSelectedZipArchiveIsAPIMProject(Object child, ZipFile zipFile) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String extractDestDirectory = workspace.getRoot().getLocation().toString() + IMPORT_ARCHIVE_LOCATION
				+ File.separator + "importProject";
		String compressDestDirectory = workspace.getRoot().getLocation().toString() + IMPORT_ARCHIVE_LOCATION;
		File archiveImportDestDir = new File(extractDestDirectory);
		if (!archiveImportDestDir.exists()) {
			archiveImportDestDir.mkdirs();
		}

		// Check the input archive file is a zip or tar.gz
		Archiver archiver;
		try {
			archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
			archiver.extract(new File(zipFile.getName()), new File(extractDestDirectory));

			resurseArchiveProjectToCheckAPIM(archiveImportDestDir);

			// create archive file
			String archiveName = "importProject";
			File destination = new File(compressDestDirectory);
			File source = new File(extractDestDirectory);

			File archive = archiver.create(archiveName, destination, source);
			ZipFile updatedZipFile = new ZipFile(archive.getAbsolutePath());

			structureProvider = new ZipLeveledStructureProvider(updatedZipFile);
			return structureProvider.getRoot();
		} catch (IOException e) {
			log.error("IOException exception while extracting the archived file to the destination or recreatee", e);
			return child;
		}
	}

	/**
	 * Check selected Tar archive includes APIM project. If exists create .project
	 * file. This operation will execute by copying the Tar file to the .tmp
	 * location in workspace After adding the .project file it recreates a Tar
	 * archive and proceed the flow
	 * 
	 * @param child
	 *            current Tar entries
	 * @param zipFile
	 *            selected Tar file
	 * @return updated Tar entries
	 */
	private Object checkSelectedTarArchiveIsAPIMProject(Object child, TarFile tarFile) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String extractDestDirectory = workspace.getRoot().getLocation().toString() + IMPORT_ARCHIVE_LOCATION
				+ File.separator + "importProject";
		String compressDestDirectory = workspace.getRoot().getLocation().toString() + IMPORT_ARCHIVE_LOCATION;
		File archiveImportDestDir = new File(extractDestDirectory);
		if (!archiveImportDestDir.exists()) {
			archiveImportDestDir.mkdirs();
		}

		// Check the input archive file is a zip or tar.gz
		Archiver archiver;
		try {
			archiver = ArchiverFactory.createArchiver("tar", "gz");
			archiver.extract(new File(tarFile.getName()), new File(extractDestDirectory));

			resurseArchiveProjectToCheckAPIM(archiveImportDestDir);

			// create archive file
			String archiveName = "importProject";
			File destination = new File(compressDestDirectory);
			File source = new File(extractDestDirectory);

			File archive = archiver.create(archiveName, destination, source);
			TarFile updatedTarFile = new TarFile(archive.getAbsolutePath());
			structureProvider = new TarLeveledStructureProvider(updatedTarFile);

			return structureProvider.getRoot();
		} catch (TarException e) {
			log.error("IOException exception while extracting the archived file to the destination or recreatee", e);
			return child;
		} catch (IOException e) {
			log.error("IOException exception while extracting the archived file to the destination or recreatee", e);
			return child;
		}
	}

	/**
	 * Checks content has APIM project and creates a .project file in it.
	 * 
	 * @param directory
	 *            directory to check
	 */
	private void resurseArchiveProjectToCheckAPIM(File directory) {
		if (checkSelectProjectIsAPIM(directory.listFiles())) {
			createDotProjectFileGivenLocation(directory);
		}

		// recursively check projects inside projects
		if (directory.listFiles() != null) {
			for (File file : directory.listFiles()) {
				resurseArchiveProjectToCheckAPIM(file);
			}
		}
	}

	/**
	 * Answer a handle to the zip file currently specified as being the source.
	 * Return null if this file does not exist or is not of valid format.
	 */
	private ZipFile getSpecifiedZipSourceFile(String fileName) {
		if (fileName.length() == 0) {
			return null;
		}

		try {
			return new ZipFile(fileName);
		} catch (ZipException e) {
			displayErrorDialog(DataTransferMessages.ZipImport_badFormat);
		} catch (IOException e) {
			displayErrorDialog(DataTransferMessages.ZipImport_couldNotRead);
		}

		archivePathField.setFocus();
		return null;
	}

	/**
	 * Answer a handle to the zip file currently specified as being the source.
	 * Return null if this file does not exist or is not of valid format.
	 */
	private TarFile getSpecifiedTarSourceFile(String fileName) {
		if (fileName.length() == 0) {
			return null;
		}

		try {
			return new TarFile(fileName);
		} catch (TarException e) {
			displayErrorDialog(DataTransferMessages.TarImport_badFormat);
		} catch (IOException e) {
			displayErrorDialog(DataTransferMessages.ZipImport_couldNotRead);
		}

		archivePathField.setFocus();
		return null;
	}

	/**
	 * Display an error dialog with the specified message.
	 * 
	 * @param message
	 *            the error message
	 */
	protected void displayErrorDialog(String message) {
		MessageDialog.open(MessageDialog.ERROR, getContainer().getShell(), getErrorDialogTitle(), message, SWT.SHEET);
	}

	/**
	 * Get the title for an error dialog. Subclasses should override.
	 */
	protected String getErrorDialogTitle() {
		return IDEWorkbenchMessages.WizardExportPage_internalErrorTitle;
	}

	/**
	 * Collect the list of .project files that are under directory into files.
	 * 
	 * @param files
	 * @param directory
	 * @param directoriesVisited
	 *            Set of canonical paths of directories, used as recursion guard
	 * @param monitor
	 *            The monitor to report to
	 * @return boolean <code>true</code> if the operation was completed.
	 */
	private boolean collectProjectFilesFromDirectory(Collection files, File directory, Set directoriesVisited,
			IProgressMonitor monitor) {

		if (monitor.isCanceled()) {
			return false;
		}
		monitor.subTask(NLS.bind(DataTransferMessages.WizardProjectsImportPage_CheckingMessage, directory.getPath()));
		File[] contents = directory.listFiles();
		if (contents == null)
			return false;

		// Initialize recursion guard for recursive symbolic links
		if (directoriesVisited == null) {
			directoriesVisited = new HashSet();
			try {
				directoriesVisited.add(directory.getCanonicalPath());
			} catch (IOException exception) {
				StatusManager.getManager()
						.handle(StatusUtil.newStatus(IStatus.ERROR, exception.getLocalizedMessage(), exception));
			}
		}
		
		// check selected project is a APIM project
		if (checkSelectProjectIsAPIM(contents)) {
			createDotProjectFileGivenLocation(directory);
			contents = directory.listFiles();
		}

		// first look for project description files
		final String dotProject = IProjectDescription.DESCRIPTION_FILE_NAME;
		for (int i = 0; i < contents.length; i++) {
			File file = contents[i];
			if (file.isFile() && file.getName().equals(dotProject)) {
				files.add(file);
				paths.add(file.getParentFile().getName());

				// don't search sub-directories since we can't have nested
				// projects
				// return true;
			}
		}
		
		// no project description found, so recurse into sub-directories
		for (int i = 0; i < contents.length; i++) {
			if (contents[i].isDirectory()) {
				if (!contents[i].getName().equals(METADATA_FOLDER)) {
					try {
						String canonicalPath = contents[i].getCanonicalPath();
						if (!directoriesVisited.add(canonicalPath)) {
							// already been here --> do not recurse
							continue;
						}
					} catch (IOException exception) {
						StatusManager.getManager().handle(
								StatusUtil.newStatus(IStatus.ERROR, exception.getLocalizedMessage(), exception));

					}
					collectProjectFilesFromDirectory(files, contents[i], directoriesVisited, monitor);
				}
			}
		}
		return true;
	}
	
	/**
	 * Create .project file with APIM project nature.
	 * 
	 * @param directory
	 *            directory location
	 */
	private void createDotProjectFileGivenLocation(File directory) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<projectDescription>\n" + "    <name>"
				+ directory.getName() + "</name>\n" + "    <comment></comment>\n" + "    <projects>\n"
				+ "    </projects>\n" + "    <buildSpec>\n" + "    </buildSpec>\n" + "    <natures>\n"
				+ "        <nature>org.wso2.developerstudio.eclipse.apim.project.nature</nature>\n" + "    </natures>\n"
				+ "</projectDescription>");

		try {
			// Parse the given input
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(stringBuilder.toString())));

			// Write the parsed document to an .project file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(
					new File(directory.getAbsoluteFile() + File.separator + IProjectDescription.DESCRIPTION_FILE_NAME));
			transformer.transform(source, result);
		} catch (SAXException e) {
			log.error("SAXException while creating .project file inside APIM project", e);
		} catch (ParserConfigurationException e) {
			log.error("ParserConfigurationException while creating .project file inside APIM project", e);
		} catch (TransformerException e) {
			log.error("TransformerException while creating .project file inside APIM project", e);
		} catch (IOException e) {
			log.error("IOException while creating .project file inside APIM project", e);
		}
	}

	/**
	 * Check selected imported directory is a APIM project.
	 * 
	 * @param contents
	 *            contents of the directory
	 * @return boolean result of the check
	 */
	private boolean checkSelectProjectIsAPIM(File[] contents) {
		boolean hasMetaInformationDirectory = false;
		boolean hasSequencesDirectory = false;
		boolean hasApiParamYAML = false;
		boolean hasNotDotProjectFile = true;

		if (contents == null) {
			return false;
		}

		for (File file : contents) {
			if (file.isDirectory() && file.getName().equals("Meta-information")) {
				hasMetaInformationDirectory = true;
			}

			if (file.isDirectory() && file.getName().equals("Sequences")) {
				hasSequencesDirectory = true;
			}

			if (file.isFile()
					&& (file.getName().equals("api_params.yaml") || file.getName().equals("api_params.yml"))) {
				hasApiParamYAML = true;
			}

			if (file.isFile() && (file.getName().equals(IProjectDescription.DESCRIPTION_FILE_NAME))) {
				hasNotDotProjectFile = false;
			}
		}

		return hasMetaInformationDirectory && hasSequencesDirectory && hasApiParamYAML && hasNotDotProjectFile;
	}

	/**
	 * Collect the list of .project files that are under directory into files.
	 * 
	 * @param files
	 * @param monitor
	 *            The monitor to report to
	 * @return boolean <code>true</code> if the operation was completed.
	 */
	private boolean collectProjectFilesFromProvider(Collection files, Object entry, int level,
			IProgressMonitor monitor) {

		if (monitor.isCanceled()) {
			return false;
		}
		monitor.subTask(NLS.bind(DataTransferMessages.WizardProjectsImportPage_CheckingMessage,
				structureProvider.getLabel(entry)));
		List children = structureProvider.getChildren(entry);
		if (children == null) {
			children = new ArrayList(1);
		}
		Iterator childrenEnum = children.iterator();
		while (childrenEnum.hasNext()) {
			Object child = childrenEnum.next();
			if (structureProvider.isFolder(child)) {
				collectProjectFilesFromProvider(files, child, level + 1, monitor);
			}
			String elementLabel = structureProvider.getLabel(child);
			if (elementLabel.equals(IProjectDescription.DESCRIPTION_FILE_NAME)) {
				files.add(new ProjectRecord(child, entry, level));
			}
		}
		return true;
	}

	/**
	 * The browse button has been selected. Select the location.
	 */
	protected void handleLocationDirectoryButtonPressed() {

		DirectoryDialog dialog = new DirectoryDialog(directoryPathField.getShell(), SWT.SHEET);
		dialog.setMessage(DataTransferMessages.WizardProjectsImportPage_SelectDialogTitle);

		String dirName = directoryPathField.getText().trim();
		if (dirName.length() == 0) {
			dirName = previouslyBrowsedDirectory;
		}

		if (dirName.length() == 0) {
			dialog.setFilterPath(IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getLocation().toOSString());
		} else {
			File path = new File(dirName);
			if (path.exists()) {
				dialog.setFilterPath(new Path(dirName).toOSString());
			}
		}

		String selectedDirectory = dialog.open();
		if (selectedDirectory != null) {
			previouslyBrowsedDirectory = selectedDirectory;
			directoryPathField.setText(previouslyBrowsedDirectory);
			updateProjectsList(selectedDirectory);
		}

	}

	/**
	 * The browse button has been selected. Select the location.
	 */
	protected void handleLocationArchiveButtonPressed() {

		FileDialog dialog = new FileDialog(archivePathField.getShell(), SWT.SHEET);
		dialog.setFilterExtensions(FILE_IMPORT_MASK);
		dialog.setText(DataTransferMessages.WizardProjectsImportPage_SelectArchiveDialogTitle);

		String fileName = archivePathField.getText().trim();
		if (fileName.length() == 0) {
			fileName = previouslyBrowsedArchive;
		}

		if (fileName.length() == 0) {
			dialog.setFilterPath(IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getLocation().toOSString());
		} else {
			File path = new File(fileName).getParentFile();
			if (path != null && path.exists()) {
				dialog.setFilterPath(path.toString());
			}
		}

		String selectedArchive = dialog.open();
		if (selectedArchive != null) {
			previouslyBrowsedArchive = selectedArchive;
			archivePathField.setText(previouslyBrowsedArchive);
			updateProjectsList(selectedArchive);
		}

	}

	/**
	 * Object[] selected = Project ProjectRecords[]
	 * 
	 * 
	 * 
	 */
	public boolean createProjects(final Object[] selected) {

		return true;
	}

	/**
	 * Create the selected projects
	 * 
	 * @return boolean <code>true</code> if all project creations were successful.
	 */
	public boolean createProjects() {
		saveWidgetValues();

		final Object[] selected = projectsList.getCheckedElements();
		createdProjects = new ArrayList();
		final ArrayList records = new ArrayList();
		return createProjectList(selected, records);
	}

	private boolean createProjectList(final Object[] selected, final ArrayList records) {
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				try {
					monitor.beginTask("", selected.length); //$NON-NLS-1$
					if (monitor.isCanceled()) {
						throw new OperationCanceledException();
					}

					for (int i = 0; i < selected.length; ++i) {
						records.add((ProjectRecord) selected[i]);
					}
					Collections.sort(records, new FilePathComparator());

					Map<String, String> mavenMultiModuleChildren = new HashMap<String, String>();
					Map<String, String> selectedProjectsWithoutMMM = new HashMap<String, String>();
					Map<String, String> selectedProjectsInArchiveWithoutMMM = new HashMap<String, String>();
					for (int j = 0; j < records.size(); j++) {
						ProjectRecord project = (ProjectRecord) records.get(j);
						String[] natureIds = project.description.getNatureIds();
						List<String> natures = Arrays.asList(natureIds);
						if (natures.contains(MAVEN_MULTI_MODULE_NATURE)) {
							if (project.description.getLocation() != null) {
								String projectPath = project.description.getLocation().toOSString();
								File mavenProject = new File(projectPath);
								File[] mavenProjectMembers = mavenProject.listFiles();
								for (File subFile : mavenProjectMembers) {
									if (subFile.isDirectory()) {
										mavenMultiModuleChildren.put(subFile.getAbsolutePath(), subFile.getName());
									}
								}
							}
						} else {
							//Archive project import this getLocation set as null
							if (project.description.getLocation() != null) {
								String projectPath = project.description.getLocation().toOSString();
								File otherProject = new File(projectPath);
								selectedProjectsWithoutMMM.put(otherProject.getAbsolutePath(), otherProject.getName());
							} else {
								if (sourceFile != null) {
									selectedProjectsInArchiveWithoutMMM.put(((ZipEntry) project.parent).getName(),
											project.description.getName());
								} else if (sourceTarFile != null) {
									selectedProjectsInArchiveWithoutMMM.put(((TarEntry) project.parent).getName(),
											project.description.getName());
								}
							}
						}
					}
					
					if (sourceFile != null || sourceTarFile != null) {
					    boolean isMMMArchived = convertMMMProjectArchivetoFileSystem(selectedProjectsInArchiveWithoutMMM, monitor);
					    if (isMMMArchived) {
					        return;
					    }
					}

					// for(int i=0;i<paths.size();++i){
					for (int j = 0; j < records.size(); ++j) {
						// if((paths.get(paths.size()-1-i)).equals(((ProjectRecord)records.get(j)).getProjectLabel())){
						if (((ProjectRecord) records.get(j)).description.getLocation() != null) {
							String projectPath = ((ProjectRecord) records.get(j)).description.getLocation()
									.toOSString();
							File project = new File(projectPath);
							if (!copyFiles) {
								createExistingProject(selectedProjectsWithoutMMM, (ProjectRecord) records.get(j),
										new SubProgressMonitor(monitor, 1));
							} else if (!mavenMultiModuleChildren.containsKey(project.getAbsolutePath())) {
								createExistingProject(selectedProjectsWithoutMMM, (ProjectRecord) records.get(j),
										new SubProgressMonitor(monitor, 1));
							}
						} else {
							createExistingProject(selectedProjectsWithoutMMM, (ProjectRecord) records.get(j), new SubProgressMonitor(monitor, 1));
						}

						// }
					}
					// }
				} finally {
					monitor.done();
				}
			}
		};
		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			// one of the steps resulted in a core exception
			Throwable t = e.getTargetException();
			String message = DataTransferMessages.WizardExternalProjectImportPage_errorMessage;
			IStatus status;
			if (t instanceof CoreException) {
				status = ((CoreException) t).getStatus();
			} else {
				status = new Status(IStatus.ERROR, IDEWorkbenchPlugin.IDE_WORKBENCH, 1, message, t);
			}
			ErrorDialog.openError(getShell(), message, null, status);
			return false;
		}
		ArchiveFileManipulations.closeStructureProvider(structureProvider, getShell());

		// Adds the projects to the working sets
		addToWorkingSets();
		
		// remove created archive directories in .tmp
		try {
			File apimImportDirectory = new File(
					ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + IMPORT_ARCHIVE_LOCATION);
			if (apimImportDirectory.exists()) {
				FileUtils.deleteDirectory(apimImportDirectory);
			}
		} catch (IOException e) {
			log.error("IOException exception while deleting APIM archived directory in {workspace/.temp}", e);
		}
		return true;
	}

	private boolean convertMMMProjectArchivetoFileSystem(Map<String, String> selectedProjectsWithoutMMM, IProgressMonitor monitor) {
		boolean isMMMArchive = false;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String destDirectory = workspace.getRoot().getLocation().toString() + File.separator + ".tmp" + File.separator
				+ "ArchiveImport";
		File archiveImportDestDir = new File(destDirectory);
		if (!archiveImportDestDir.exists()) {
			archiveImportDestDir.mkdir();
		}

		// Check the input archive file is a zip or tar.gz
		try {
			if (sourceFile != null) {
				Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
				archiver.extract(new File(sourceFile.getName()), new File(destDirectory));
			} else {
				Archiver archiver = ArchiverFactory.createArchiver("tar", "gz");
				archiver.extract(new File(sourceTarFile.getName()), new File(destDirectory));
			}
		} catch (IOException e) {
			log.error("IOException exception while extracting the archived file to the destination", e);
		}

		File[] extractedDirectories = archiveImportDestDir.listFiles(File::isDirectory);
		// Check extracted archive file contains MMM project
		for (File directory : extractedDirectories) {
			if (directory.getParentFile().getAbsolutePath().equals(archiveImportDestDir.getAbsolutePath())) {
				File projectFile = new File(directory.getAbsolutePath() + File.separator + ".project");
				if (projectFile.exists()) {
					String projectNature = MavenMultiModuleImportUtils.readProjectNatureFromProjectFile(projectFile);
					if (projectNature != null && projectNature.equals(MAVEN_MULTI_MODULE_NATURE)) {
						isMMMArchive = true;
						break;
					}
				}
			}
		}

		// Return the method if there is no any MMM project inside the archive
		if (!isMMMArchive) {
			// Deleting extracted archived file from the {workspace/.tmp} directory
			try {
				FileUtils.deleteDirectory(archiveImportDestDir);
			} catch (IOException e) {
				log.error("IOException exception while deleting archived directory in {workspace/.temp}", e);
			}
			return isMMMArchive;
		}

		// Loop the extracted archive directory and create IProject in workspace
		for (File directory : extractedDirectories) {
			if (directory.getParentFile().getAbsolutePath().equals(archiveImportDestDir.getAbsolutePath())) {
				// read nature of the directory
				File projectFile = new File(directory.getAbsolutePath() + File.separator + ".project");
				if (projectFile.exists()) {
					String projectNature = MavenMultiModuleImportUtils.readProjectNatureFromProjectFile(projectFile);
					IProject mainProject = workspace.getRoot().getProject(directory.getName());
					try {
						IProjectDescription newProjectDescription = workspace
								.newProjectDescription(directory.getName());
						String[] natureIds = { projectNature };
						newProjectDescription.setNatureIds(natureIds);
						String mmmProject = workspace.getRoot().getLocation().toOSString() + File.separator + directory.getName();
						File mmmProjectFile = new File(mmmProject);
						URI mmmProjectURI = mmmProjectFile.toURI();
						newProjectDescription.setLocationURI(mmmProjectURI);

						mainProject.create(newProjectDescription, new NullProgressMonitor());
						mainProject.open(IResource.BACKGROUND_REFRESH, new NullProgressMonitor());
						mainProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

						// If this is not a maven project, try to import connectors
						MavenMultiModuleImportUtils.importConnectorsFromConnectorExporterProject(mainProject);
						// create sub projects/directories under the created parent project
						createProjectsInWorkspaceReadingNature(selectedProjectsWithoutMMM, directory, mainProject, monitor);
					} catch (CoreException e) {
						log.error("CoreException exception while importing", e);
					}
				}
			}
		}

		// Deleting extracted archived file from the {workspace/.tmp} directory
		try {
			FileUtils.deleteDirectory(archiveImportDestDir);
		} catch (IOException e) {
			log.error("IOException exception while deleting archived directory in {workspace/.temp}", e);
		}

		return isMMMArchive;
	}

	private void createProjectsInWorkspaceReadingNature(Map<String, String> selectedAllProjects, File sourceDirectory, IProject projectWhichWantToCopy, 
			IProgressMonitor monitor) {
		try {
			List filesToImport = FileSystemStructureProvider.INSTANCE.getChildren(sourceDirectory);
			for (Object resource : filesToImport) {
				File resourceFile = (File) resource;

				if (resourceFile.isDirectory()) {
					if (sourceFile != null || sourceTarFile != null) {
						String resourcePathInArchive = resourceFile.getParentFile().getName() + SLASH
								+ resourceFile.getName() + SLASH;
						if (!selectedAllProjects.containsKey(resourcePathInArchive)) {
							continue;
						}
					} else if (!selectedAllProjects.containsKey(resourceFile.getAbsolutePath())) {
						continue;
					}
					
					IProjectDescription newSubProjectDescription = projectWhichWantToCopy.getWorkspace()
							.newProjectDescription(resourceFile.getName());
					String subProject = projectWhichWantToCopy.getLocation().toOSString() + File.separator + resourceFile.getName();
					File subProjectFile = new File(subProject);
					URI subProjectURI = subProjectFile.toURI();
					newSubProjectDescription.setLocationURI(subProjectURI);
					File[] subProjectList = resourceFile.listFiles();
					for (File file : subProjectList) {
						if (file.getName().equals(".project")) {
							String[] subNatureIds = { MavenMultiModuleImportUtils.readProjectNatureFromProjectFile(file) };
							newSubProjectDescription.setNatureIds(subNatureIds);
							break;
						}
					}
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IProject subIProject = root.getProject(resourceFile.getName());
					subIProject.create(newSubProjectDescription, new NullProgressMonitor());
					subIProject.open(new NullProgressMonitor());

					List subImportFiles = FileSystemStructureProvider.INSTANCE.getChildren(resourceFile);
					ImportOperation operation = new ImportOperation(subIProject.getFullPath(), resourceFile,
							FileSystemStructureProvider.INSTANCE, this, subImportFiles);
					operation.setContext(getShell());
					operation.setOverwriteResources(true);
					operation.setCreateContainerStructure(false);
					operation.run(monitor);
					
					// If this is a connector exporter project, import connectors.
					MavenMultiModuleImportUtils.importConnectorsFromConnectorExporterProject(subIProject);
				} else {
					Files.copy(
							resourceFile.toPath(), (new File(projectWhichWantToCopy.getLocation().toOSString()
									+ File.separator + resourceFile.getName())).toPath(),
							StandardCopyOption.REPLACE_EXISTING);
				}
			}
		} catch (InvocationTargetException e) {
			log.error("InvocationTargetException exception while importing", e);
		} catch (InterruptedException e) {
			log.error("InterruptedException exception while importing", e);
		} catch (CoreException e) {
			log.error("CoreException exception while importing", e);
		} catch (IOException e) {
			log.error("IOException exception while importing", e);
		}
	}
	
	

	class FilePathComparator implements Comparator {

		public int compare(Object projectRecord1, Object projectRecord2) {
			ProjectRecord pr1 = (ProjectRecord) projectRecord1;
			ProjectRecord pr2 = (ProjectRecord) projectRecord2;
			return (pr1.getProjectName()).compareTo(pr2.getProjectName());
		}
	}

	List createdProjects;

	private void addToWorkingSets() {

		IWorkingSet[] selectedWorkingSets = workingSetGroup.getSelectedWorkingSets();
		if (selectedWorkingSets == null || selectedWorkingSets.length == 0)
			return; // no Working set is selected
		IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
		for (Iterator i = createdProjects.iterator(); i.hasNext();) {
			IProject project = (IProject) i.next();
			workingSetManager.addToWorkingSets(project, selectedWorkingSets);
		}
	}

	/**
	 * Performs clean-up if the user cancels the wizard without doing anything
	 */
	public void performCancel() {
		ArchiveFileManipulations.closeStructureProvider(structureProvider, getShell());
	}

	/**
	 * Create the project described in record. If it is successful return true.
	 * 
	 * @param record
	 * @return boolean <code>true</code> if successful
	 * @throws InterruptedException
	 */
	private boolean createExistingProject(Map<String, String> selectedAllProjects, final ProjectRecord record, IProgressMonitor monitor)
			throws InvocationTargetException, InterruptedException {
		String projectName = record.getProjectName();
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProject project = workspace.getRoot().getProject(projectName);
		createdProjects.add(project);
		if (record.description == null) {
			// error case
			record.description = workspace.newProjectDescription(projectName);
			IPath locationPath = new Path(record.projectSystemFile.getAbsolutePath());

			// If it is under the root use the default location
			if (Platform.getLocation().isPrefixOf(locationPath)) {
				record.description.setLocation(null);
			} else {
				record.description.setLocation(locationPath);
			}
		} else {
			record.description.setName(projectName);
		}
		if (record.projectArchiveFile != null) {
			// import from archive
			List fileSystemObjects = structureProvider.getChildren(record.parent);
			structureProvider.setStrip(record.level);
			ImportOperation operation = new ImportOperation(project.getFullPath(), structureProvider.getRoot(),
					structureProvider, this, fileSystemObjects);
			operation.setContext(getShell());
			operation.run(monitor);
			// If this is a connector exporter project, import connectors.
			MavenMultiModuleImportUtils.importConnectorsFromConnectorExporterProject(project);
			return true;
		}
		// import from file system
		File importSource = null;
		if (copyFiles) {
			// import project from location copying files - use default project
			// location for this workspace
			URI locationURI = record.description.getLocationURI();
			// if location is null, project already exists in this location or
			// some error condition occured.
			if (locationURI != null) {
				importSource = new File(locationURI);
				IProjectDescription desc = workspace.newProjectDescription(projectName);
				desc.setBuildSpec(record.description.getBuildSpec());
				desc.setComment(record.description.getComment());
				desc.setDynamicReferences(record.description.getDynamicReferences());
				desc.setNatureIds(record.description.getNatureIds());
				desc.setReferencedProjects(record.description.getReferencedProjects());
				record.description = desc;
			}
		}

		try {
			monitor.beginTask(DataTransferMessages.WizardProjectsImportPage_CreateProjectsTask, 100);
			project.create(record.description, new SubProgressMonitor(monitor, 30));
			project.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(monitor, 70));
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		} catch (CoreException e) {
			throw new InvocationTargetException(e);
		} finally {
			monitor.done();
		}

		// import operation to import project files if copy checkbox is selected
		try {
			if (copyFiles && importSource != null && !project.hasNature(MAVEN_MULTI_MODULE_NATURE)) {
				List filesToImport = FileSystemStructureProvider.INSTANCE.getChildren(importSource);
				ImportOperation operation = new ImportOperation(project.getFullPath(), importSource,
						FileSystemStructureProvider.INSTANCE, this, filesToImport);
				operation.setContext(getShell());
				operation.setOverwriteResources(true);
				operation.setCreateContainerStructure(false);
				operation.run(monitor);
				// If this is a connector exporter project, import connectors.
				MavenMultiModuleImportUtils.importConnectorsFromConnectorExporterProject(project);
			} else if (copyFiles && importSource != null && project.hasNature(MAVEN_MULTI_MODULE_NATURE)) {
				createProjectsInWorkspaceReadingNature(selectedAllProjects, importSource, project, monitor);
			}
		} catch (CoreException e) {
			log.error("CoreException exception while importing", e);
		}

		return true;
	}

	/**
	 * The <code>WizardDataTransfer</code> implementation of this
	 * <code>IOverwriteQuery</code> method asks the user whether the existing
	 * resource at the given path should be overwritten.
	 * 
	 * @param pathString
	 * @return the user's reply: one of <code>"YES"</code>, <code>"NO"</code>,
	 *         <code>"ALL"</code>, or <code>"CANCEL"</code>
	 */
	public String queryOverwrite(String pathString) {

		Path path = new Path(pathString);

		String messageString;
		// Break the message up if there is a file name and a directory
		// and there are at least 2 segments.
		if (path.getFileExtension() == null || path.segmentCount() < 2) {
			messageString = NLS.bind(IDEWorkbenchMessages.WizardDataTransfer_existsQuestion, pathString);
		} else {
			messageString = NLS.bind(IDEWorkbenchMessages.WizardDataTransfer_overwriteNameAndPathQuestion,
					path.lastSegment(), path.removeLastSegments(1).toOSString());
		}

		final MessageDialog dialog = new MessageDialog(getContainer().getShell(), IDEWorkbenchMessages.Question, null,
				messageString, MessageDialog.QUESTION,
				new String[] { IDialogConstants.YES_LABEL, IDialogConstants.YES_TO_ALL_LABEL, IDialogConstants.NO_LABEL,
						IDialogConstants.NO_TO_ALL_LABEL, IDialogConstants.CANCEL_LABEL },
				0) {
			protected int getShellStyle() {
				return super.getShellStyle() | SWT.SHEET;
			}
		};
		String[] response = new String[] { YES, ALL, NO, NO_ALL, CANCEL };
		// run in syncExec because callback is from an operation,
		// which is probably not running in the UI thread.
		getControl().getDisplay().syncExec(new Runnable() {
			public void run() {
				dialog.open();
			}
		});
		return dialog.getReturnCode() < 0 ? CANCEL : response[dialog.getReturnCode()];
	}

	/**
	 * Method used for test suite.
	 * 
	 * @return Button the Import from Directory RadioButton
	 */
	public Button getProjectFromDirectoryRadio() {
		return projectFromDirectoryRadio;
	}

	/**
	 * Method used for test suite.
	 * 
	 * @return CheckboxTreeViewer the viewer containing all the projects found
	 */
	public CheckboxTreeViewer getProjectsList() {
		return projectsList;
	}

	/**
	 * Retrieve all the projects in the current workspace.
	 * 
	 * @return IProject[] array of IProject in the current workspace
	 */
	private IProject[] getProjectsInWorkspace() {
		if (wsProjects == null) {
			wsProjects = IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getProjects();
		}
		return wsProjects;
	}

	/**
	 * Get the array of project records that can be imported from the source
	 * workspace or archive, selected by the user. If a project with the same name
	 * exists in both the source workspace and the current workspace, then the
	 * hasConflicts flag would be set on that project record.
	 * 
	 * Method declared public for test suite.
	 * 
	 * @return ProjectRecord[] array of projects that can be imported into the
	 *         workspace
	 */
	public ProjectRecord[] getProjectRecords() {
		List projectRecords = new ArrayList();
		for (int i = 0; i < selectedProjects.length; i++) {
			if (isProjectInWorkspace(selectedProjects[i].getProjectName())) {
				selectedProjects[i].hasConflicts = true;
			}
			projectRecords.add(selectedProjects[i]);
		}
		return (ProjectRecord[]) projectRecords.toArray(new ProjectRecord[projectRecords.size()]);
	}

	/**
	 * Determine if the project with the given name is in the current workspace.
	 * 
	 * @param projectName
	 *            String the project name to check
	 * @return boolean true if the project with the given name is in this workspace
	 */
	private boolean isProjectInWorkspace(String projectName) {
		if (projectName == null) {
			return false;
		}
		IProject[] workspaceProjects = getProjectsInWorkspace();
		for (int i = 0; i < workspaceProjects.length; i++) {
			if (projectName.equals(workspaceProjects[i].getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Use the dialog store to restore widget values to the values that they held
	 * last time this wizard was used to completion, or alternatively, if an initial
	 * path is specified, use it to select values.
	 * 
	 * Method declared public only for use of tests.
	 */
	public void restoreWidgetValues() {

		// First, check to see if we have resore settings, and
		// take care of the checkbox
		IDialogSettings settings = getDialogSettings();
		if (settings != null) {
			// checkbox
			//copyFiles = settings.getBoolean(STORE_COPY_PROJECT_ID);
			copyCheckbox.setSelection(copyFiles);
		}

		// Second, check to see if we don't have an initial path,
		// and if we do have restore settings. If so, set the
		// radio selection properly to restore settings

		if (initialPath == null && settings != null) {
			// radio selection
			boolean archiveSelected = settings.getBoolean(STORE_ARCHIVE_SELECTED);
			projectFromDirectoryRadio.setSelection(!archiveSelected);
			projectFromArchiveRadio.setSelection(archiveSelected);
			if (archiveSelected) {
				archiveRadioSelected();
			} else {
				directoryRadioSelected();
			}
		}
		// Third, if we do have an initial path, set the proper
		// path and radio buttons to the initial value. Move
		// cursor to the end of the path so user can see the
		// most relevant part (directory / archive name)
		else if (initialPath != null) {
			boolean dir = new File(initialPath).isDirectory();

			projectFromDirectoryRadio.setSelection(dir);
			projectFromArchiveRadio.setSelection(!dir);

			if (dir) {
				directoryPathField.setText(initialPath);
				directoryPathField.setSelection(initialPath.length());
				directoryRadioSelected();
			} else {
				archivePathField.setText(initialPath);
				archivePathField.setSelection(initialPath.length());
				archiveRadioSelected();
			}
		}
	}

	/**
	 * Since Finish was pressed, write widget values to the dialog store so that
	 * they will persist into the next invocation of this wizard page.
	 * 
	 * Method declared public only for use of tests.
	 */
	public void saveWidgetValues() {
		IDialogSettings settings = getDialogSettings();
		if (settings != null) {
			settings.put(STORE_COPY_PROJECT_ID, copyCheckbox.getSelection());

			settings.put(STORE_ARCHIVE_SELECTED, projectFromArchiveRadio.getSelection());
		}
	}

	/**
	 * Method used for test suite.
	 * 
	 * @return Button copy checkbox
	 */
	public Button getCopyCheckbox() {
		return copyCheckbox;
	}

}
