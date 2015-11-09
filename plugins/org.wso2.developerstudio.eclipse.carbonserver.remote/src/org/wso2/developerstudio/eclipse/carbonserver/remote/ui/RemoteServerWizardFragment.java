package org.wso2.developerstudio.eclipse.carbonserver.remote.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.TaskModel;
import org.eclipse.wst.server.ui.wizard.IWizardHandle;
import org.eclipse.wst.server.ui.wizard.WizardFragment;
import org.wso2.developerstudio.eclipse.carbonserver.remote.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RemoteServerWizardFragment extends WizardFragment {

	private RemoteWizardFragmentCompositie comp;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * Create a new fragment.
	 */
	public RemoteServerWizardFragment() {
		// do nothing
	}

	/**
	 * @see WizardFragment#hasComposite()
	 */
	public boolean hasComposite() {
		return true;
	}

	/**
	 * @see WizardFragment#createComposite(Composite, IWizardHandle)
	 */
	public Composite createComposite(Composite parent, IWizardHandle wizard) {
		comp = new RemoteWizardFragmentCompositie(parent, SWT.FILL, wizard);
		wizard.setDescription("Carbon remote server details");
		wizard.setTitle("Remote Carbon Server");
		return comp;
	}

	/**
	 * @see WizardFragment#isComplete()
	 */
	public boolean isComplete() {
		return comp.isContentValid();
	}

	/**
	 * @see WizardFragment#enter()
	 */
	public void enter() {
		if (comp != null) {
			comp.setRuntime(getTaskModel().getObject(TaskModel.TASK_SERVER));
		}
	}

	public void performFinish(IProgressMonitor monitor) throws CoreException {
		/*
		 * Focus Server view after clicking the Finish button.
		 */
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench().getWorkbenchWindows();
					if (workbenchWindows.length > 0) {
						IWorkbenchPage[] pages = workbenchWindows[0].getPages();
						if (pages.length > 0) {
							pages[0].showView("org.eclipse.wst.server.ui.ServersView");
						}
					}
				} catch (PartInitException e) {
					log.error("Error while opening Server view", e);
				}
			}
		});
		super.performFinish(monitor);
	}
}
