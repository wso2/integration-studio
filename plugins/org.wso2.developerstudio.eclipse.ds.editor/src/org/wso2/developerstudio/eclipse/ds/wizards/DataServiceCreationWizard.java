package org.wso2.developerstudio.eclipse.ds.wizards;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.datatools.connectivity.internal.ui.wizards.CPWizardSelectionPage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditorPlugin;

public class DataServiceCreationWizard extends Wizard implements INewWizard {

	public static final List<String> FILE_EXTENSIONS =
	                                                   Collections.unmodifiableList(Arrays.asList(DsEditorPlugin.INSTANCE.getString("_UI_DsEditorFilenameExtensions")
	                                                                                                                     .split("\\s*,\\s*")));

	public static final String FORMATTED_FILE_EXTENSIONS =
	                                                       DsEditorPlugin.INSTANCE.getString("_UI_DsEditorFilenameExtensions")
	                                                                              .replaceAll("\\s*,\\s*",
	                                                                                          ", ");

	protected DsPackage dsPackage = DsPackage.eINSTANCE;

	protected DsFactory dsFactory = dsPackage.getDsFactory();

	protected IStructuredSelection selection;

	protected IWorkbench workbench;

	DataServiceCreationWizadPage mainPage;

	CPWizardSelectionPage cpwizpage;

	CSVWizardPage csvPage;

	ExelWizardPage xlsPage;

	GSpreadWizardPage gspPage;

	DBDetailWizarPage dbdPage;

	DriverConnDetailPage driveConPage;

	ServiceGenModeWizardPage serviceGenModePage;

	protected DsModelWizardNewFileCreationPage newFileCreationPage;

	protected boolean dbFlag = false;

	protected boolean serviceGenPageCompleted = false;

	protected List<String> initialObjectNames;

	public DataServiceCreationWizard() {

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {

		this.workbench = workbench;
		this.selection = selection;

	}

	public void addPages() {

		mainPage = new DataServiceCreationWizadPage();
		addPage(mainPage);
		driveConPage = new DriverConnDetailPage();
		addPage(driveConPage);
		dbdPage = new DBDetailWizarPage();
		addPage(dbdPage);
		serviceGenModePage = new ServiceGenModeWizardPage(selection);
		addPage(serviceGenModePage);
		csvPage = new CSVWizardPage();
		addPage(csvPage);
		xlsPage = new ExelWizardPage();
		addPage(xlsPage);
		gspPage = new GSpreadWizardPage();
		addPage(gspPage);
		newFileCreationPage = new DsModelWizardNewFileCreationPage("file location", selection);
		addPage(newFileCreationPage);

		if (selection != null && !selection.isEmpty()) {
			// Get the resource...

			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.

				IResource selectedResource = (IResource) selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...

				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.

					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.

					String defaultModelBaseFilename =
					                                  DsEditorPlugin.INSTANCE.getString("_UI_DsEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename =
					                       defaultModelBaseFilename + "." +
					                               defaultModelFilenameExtension;
					for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename =
						                defaultModelBaseFilename + i + "." +
						                        defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}

	}

	protected EObject createInitialModel() {
		EClass eClass = ExtendedMetaData.INSTANCE.getDocumentRoot(dsPackage);
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("data");
		EObject rootObject = dsFactory.create(eClass);
		rootObject.eSet(eStructuralFeature,
		                EcoreUtil.create((EClass) eStructuralFeature.getEType()));
		return rootObject;
	}

	public boolean performCancel() {

		this.getContainer().getCurrentPage().dispose();
		return true;

	}

	public boolean canFinish() {

		if (this.getContainer().getCurrentPage() == mainPage)
			return false;

		if (dbFlag)
			return serviceGenPageCompleted;

		return false;

	}

	public boolean performFinish() {
		try {
			// Remember the file.

			final IFile modelFile = getModelFile();

			// Do the work within an operation.

			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

				protected void execute(IProgressMonitor progressMonitor) {
					try {
						// Create a resource set

						ResourceSet resourceSet = new ResourceSetImpl();

						// Get the URI of the model file.

						URI fileURI =
						              URI.createPlatformResourceURI(modelFile.getFullPath()
						                                                     .toString(), true);

						// Create a resource for this file.

						Resource resource = resourceSet.createResource(fileURI);

						// Add the initial model object to the contents.

						EObject rootObject = createInitialModel();
						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.

						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_ENCODING, "UTF-8");
						resource.save(options);
					} catch (Exception exception) {
						DsEditorPlugin.INSTANCE.log(exception);
					} finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.

			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget) activePart).selectReveal(targetSelection);
					}
				});
			}

			// Open an editor on the new file.

			try {
				page.openEditor(new FileEditorInput(modelFile),
				                workbench.getEditorRegistry()
				                         .getDefaultEditor(modelFile.getFullPath().toString())
				                         .getId());
			} catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(),
				                        DsEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"),
				                        exception.getMessage());
				return false;
			}

			return true;
		} catch (Exception exception) {
			DsEditorPlugin.INSTANCE.log(exception);
			return false;
		}

	}

	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}

}
