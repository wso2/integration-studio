package org.wso2.developerstudio.datamapper.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class DataMapperCreationWizard extends Wizard implements INewWizard {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected DataMapperCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected DataMapperCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.DataMapperCreationWizardTitle);
		setDefaultPageImageDescriptor(DataMapperDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewDataMapperWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated NOT
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	public void addPages() {
		diagramModelFilePage = new org.wso2.developerstudio.datamapper.diagram.part.DataMapperCreationWizardPage(
				"DiagramModelFile", getSelection(), "datamapper_diagram"); //$NON-NLS-1$ //$NON-NLS-2$

		diagramModelFilePage
				.setTitle(org.wso2.developerstudio.datamapper.diagram.part.Messages.DataMapperCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage
				.setDescription(org.wso2.developerstudio.datamapper.diagram.part.Messages.DataMapperCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new org.wso2.developerstudio.datamapper.diagram.part.DataMapperCreationWizardPage(
				"DomainModelFile", getSelection(), "datamapper") { //$NON-NLS-1$ //$NON-NLS-2$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0,
							fileName.length() - ".datamapper_diagram".length()); //$NON-NLS-1$
					setFileName(org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorUtil
							.getUniqueFileName(getContainerFullPath(), fileName, "datamapper")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};

		domainModelFilePage
				.setTitle(org.wso2.developerstudio.datamapper.diagram.part.Messages.DataMapperCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage
				.setDescription(org.wso2.developerstudio.datamapper.diagram.part.Messages.DataMapperCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException,
					InterruptedException {
				diagram = DataMapperDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(),
						domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						DataMapperDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(),
								Messages.DataMapperCreationWizardOpenEditorError, null,
								e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						Messages.DataMapperCreationWizardCreationError, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				DataMapperDiagramEditorPlugin.getInstance().logError(
						"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
