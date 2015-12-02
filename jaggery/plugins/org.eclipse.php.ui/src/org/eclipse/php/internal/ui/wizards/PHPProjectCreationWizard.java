/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Zend Technologies
 *******************************************************************************/
package org.eclipse.php.internal.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.*;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.dltk.ui.wizards.NewElementWizard;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.php.internal.core.PHPCorePlugin;
import org.eclipse.php.internal.core.PHPVersion;
import org.eclipse.php.internal.core.facet.PHPFacets;
import org.eclipse.php.internal.core.project.JaggeryNature;
import org.eclipse.php.internal.core.project.ProjectOptions;
import org.eclipse.php.internal.ui.PHPUIMessages;
import org.eclipse.php.internal.ui.util.PHPPluginImages;
import org.eclipse.ui.INewWizard;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public class PHPProjectCreationWizard extends NewElementWizard implements
		INewWizard, IExecutableExtension {

	public static final String SELECTED_PROJECT = "SelectedProject"; //$NON-NLS-1$

	public static final String WIZARD_ID = "org.eclipse.php.wizards.newproject"; //$NON-NLS-1$

	protected PHPProjectWizardFirstPage fFirstPage;
	protected PHPProjectWizardSecondPage fSecondPage;
	protected PHPProjectWizardThirdPage fThirdPage;
	protected PHPProjectWizardSecondPage fLastPage = fThirdPage;
	protected IConfigurationElement fConfigElement;
	protected IProgressMonitor progressMonitor;

	protected int fLastPageIndex = -1;

	private PHPProjectWizardFacetsPage fFacetsPage;

	public PHPProjectCreationWizard() {
		setDefaultPageImageDescriptor(PHPPluginImages.DESC_WIZBAN_ADD_PHP_PROJECT);
		setDialogSettings(DLTKUIPlugin.getDefault().getDialogSettings());
		setWindowTitle(PHPUIMessages.PHPProjectCreationWizard_WizardTitle);
	}

	public void addPages() {
		super.addPages();
		fFirstPage = new PHPProjectWizardFirstPage();

		// First page
		fFirstPage.setTitle(PHPUIMessages.PHPProjectCreationWizard_Page1Title);
		fFirstPage
				.setDescription(PHPUIMessages.PHPProjectCreationWizard_Page1Description);
		addPage(fFirstPage);

		fFacetsPage = new PHPProjectWizardFacetsPage(fFirstPage);
		fFacetsPage
				.setTitle(PHPUIMessages.PHPProjectCreationWizard_PageFacetsTitle);
		fFacetsPage
				.setDescription(PHPUIMessages.PHPProjectCreationWizard_PageFacetsDescription);
		// addPage(fFacetsPage);

		// Second page (Include Path)
		fSecondPage = new PHPProjectWizardSecondPage(fFirstPage);
		fSecondPage.setTitle(PHPUIMessages.PHPProjectCreationWizard_Page2Title);
		fSecondPage
				.setDescription(PHPUIMessages.PHPProjectCreationWizard_Page2Description);
		addPage(fSecondPage);

		// Third page (Include Path)
		fThirdPage = new PHPProjectWizardThirdPage(fFirstPage);
		fThirdPage.setTitle(PHPUIMessages.PHPProjectCreationWizard_Page3Title);
		fThirdPage
				.setDescription(PHPUIMessages.PHPProjectCreationWizard_Page3Description);
		addPage(fThirdPage);

		fLastPage = fSecondPage;
	}

	protected void finishPage(IProgressMonitor monitor)
			throws InterruptedException, CoreException {
		if (fFirstPage != null) {
			fFirstPage.performFinish(monitor); // use the full progress
			progressMonitor = monitor;
			// System.out.println("***********************" + progressMonitor);
		}
		if (fSecondPage != null)
			fSecondPage.performFinish(monitor); // use the full progress monitor
		if (fThirdPage != null)
			fThirdPage.performFinish(monitor); // use the full progress monitor
	}

	public boolean performFinish() {
		boolean res = super.performFinish();
		if (res) {
			// if (updatePerspective()) {
			// BasicNewProjectResourceWizard.updatePerspective(fConfigElement);
			// }
			selectAndReveal(fLastPage.getScriptProject().getProject());

			IProject project = fLastPage.getScriptProject().getProject();
			PHPVersion version = fFirstPage.getPHPVersionValue();
			if (version == null) {
				version = ProjectOptions.getDefaultPhpVersion();
			}
			try {
				PHPFacets.createFacetedProject(project, version,
						new NullProgressMonitor());
			} catch (CoreException ex) {
				PHPCorePlugin.log(ex);
			}

			WizardModel model = fFirstPage.getWizardData();

			Object eanblement = null;
			if (model != null) {
				eanblement = model
						.getObject("REMOTE_GROUP_REMOTE_PROJECT_ENABLED"); //$NON-NLS-1$
			}

			if (model != null && eanblement != null && (Boolean) eanblement) {

				model.putObject(SELECTED_PROJECT, fLastPage.getScriptProject()
						.getProject());

				IRunnableWithProgress run = (IRunnableWithProgress) Platform
						.getAdapterManager().getAdapter(model,
								IRunnableWithProgress.class);

				if (run != null) {
					try {
						getContainer().run(true, false, run);
					} catch (InvocationTargetException e) {
						handleFinishException(getShell(), e);
						return false;
					} catch (InterruptedException e) {
						return false;
					}
				}
			}
			IContainer container = (IContainer) project;

			if (!fFirstPage.isExistingLocation()) {
				try {
					addFileToProject(container, new Path("index.jag"),
							PHPFileCreationWizard.openContentStream(project
									.getName()), null);
					InputStream resourceStream = this.getClass()
							.getResourceAsStream(
									"templates/jag-conf-template.resource");
					addFileToProject(container, new Path("jaggery.conf"),
							resourceStream, null);
					resourceStream = this.getClass().getResourceAsStream(
							"templates/pom-template.resource");

					addFileToProject(container, new Path("pom.xml"),
							resourceStream, null);
					resourceStream = this.getClass().getResourceAsStream(
							"templates/zip-descriptor-template.resource");

					addFileToProject(container, new Path("zip-descriptor.xml"),
							resourceStream, null);
					updatePom(project);

					resourceStream.close();
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				addNatureToProject(project, false, JaggeryNature.ID);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// progressMonitor.done();
		}

		return res;
	}

	public static void updatePom(IProject project) {
		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation()
				.toFile();
		try {
			MavenProject mavenProject = MavenUtils
					.getMavenProject(mavenProjectPomLocation);

			mavenProject.setName(project.getName());
			mavenProject.setArtifactId(project.getName());
			mavenProject.setDescription(project.getName());
			MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addNatureToProject(IProject project, boolean addToEnd,
			String... natureId) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		ArrayList<String> arrayList = new ArrayList<String>();
		if (addToEnd) {
			arrayList.addAll(Arrays.asList(natures));
			arrayList.addAll(Arrays.asList(natureId));
		} else {
			arrayList.addAll(Arrays.asList(natureId));
			arrayList.addAll(Arrays.asList(natures));
		}
		String[] list = new String[arrayList.size()];
		list = arrayList.toArray(list);
		description.setNatureIds(list);
		project.setDescription(description, null);
	}

	private void addFileToProject(IContainer container, Path path,
			InputStream contentStream, IProgressMonitor monitor)
			throws CoreException {
		final IFile file = container.getFile(path);

		if (file.exists()) {
			file.setContents(contentStream, true, true, monitor);
		} else {
			file.create(contentStream, true, monitor);
		}
	}

	/*
	 * Stores the configuration element for the wizard. The config element will
	 * be used in <code>performFinish</code> to set the result perspective.
	 */
	public void setInitializationData(IConfigurationElement cfig,
			String propertyName, Object data) {
		fConfigElement = cfig;
	}

	public boolean performCancel() {
		if (!fFirstPage.isExistingLocation())
			fFirstPage.performCancel();
		return super.performCancel();
	}

	public IModelElement getCreatedElement() {
		return DLTKCore.create(fFirstPage.getProjectHandle());
	}

	public int getLastPageIndex() {
		return fLastPageIndex;
	}

	public void setLastPageIndex(int current) {
		fLastPageIndex = current;
	}

	protected boolean updatePerspective() {
		return true;
	}
}