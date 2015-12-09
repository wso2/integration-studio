/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.platform.core.intro.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.wizards.IWizardCategory;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.eclipse.ui.wizards.IWizardRegistry;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.samples.contributor.IDeveloperStudioSampleContributor;
import org.wso2.developerstudio.eclipse.samples.utils.ExtensionPointHandler;
import org.wso2.developerstudio.eclipse.samples.wizards.ProjectCreationWizard;

/**
 * Developer studio main dash-board page
 *
 */
public class DashboardPage extends FormPage {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static Map<String, String[]> wizardCategoryMap = new LinkedHashMap<String, String[]>();
	private Map<String, IWizardDescriptor> wizardDescriptor;
	private Map<String, Action> customActions = new LinkedHashMap<String, Action>();
	private static final String PROJECT_EXPLORER_PARTID =
	                                                      "org.eclipse.ui.navigator.ProjectExplorer";
	private static final String PACKAGE_EXPLORER_PARTID = "org.eclipse.jdt.ui.PackageExplorer";
	private ISelectionListener selectionListener = null;
	private ISelection selection = null;
	private static List<DashboardCategory> categories;
	private DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
	static {

		categories = DashboardContributionsHandler.getCategories();
		for (DashboardCategory category : categories) {
			List<String> wizardIds = new ArrayList<String>();
			List<DashboardLink> wizards = category.getWizards();
			for (DashboardLink dashboardLink : wizards) {
				wizardIds.add(dashboardLink.getName());
			}
			wizardCategoryMap.put(category.getName(), wizardIds.toArray(new String[] {}));
		}

		/*
		 * Dashboard items for core features not handle by
		 * DashboardContributionsHandler
		 */
		wizardCategoryMap.put("Distribution",
		                      new String[] { "org.wso2.developerstudio.eclipse.distribution.project", });
		wizardCategoryMap.put("Maven",
		                      new String[] { "org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard.MvnMultiModuleWizard", });
		wizardCategoryMap.put("AddServer", new String[] { "org.eclipse.wst.server.ui.new.server", });
	}

	/**
	 * Create the form page.
	 * 
	 * @param id
	 * @param title
	 */
	public DashboardPage(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public DashboardPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	protected void createFormContent(IManagedForm managedForm) {

		// setting initial selection
		ISelection initialSelection =
		                              getSite().getWorkbenchWindow().getSelectionService()
		                                       .getSelection(PROJECT_EXPLORER_PARTID);
		if (initialSelection != null) {
			selection = initialSelection;
		} else {
			initialSelection =
			                   getSite().getWorkbenchWindow().getSelectionService()
			                            .getSelection(PACKAGE_EXPLORER_PARTID);
			if (initialSelection != null) {
				selection = initialSelection;
			}
		}

		selectionListener = new ISelectionListener() {
			public void selectionChanged(IWorkbenchPart workbenchPart, ISelection sel) {
				selection = sel;
			}
		};
		getSite().getWorkbenchWindow().getSelectionService()
		         .addSelectionListener(PROJECT_EXPLORER_PARTID, selectionListener);
		getSite().getWorkbenchWindow().getSelectionService()
		         .addSelectionListener(PACKAGE_EXPLORER_PARTID, selectionListener);

		managedForm.getForm()
		           .setImage(DashboardUtil.resizeImage(SWTResourceManager.getImage(this.getClass(),
		                                                                           "/intro/css/graphics/cApp-wizard.png"),
		                                               32, 32));
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("WSO2 Developer Studio");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		Section sctnCreate =
		                     managedForm.getToolkit()
		                                .createSection(managedForm.getForm().getBody(),
		                                               Section.TWISTIE | Section.TITLE_BAR);
		sctnCreate.setBounds(10, 10, 650, 1200);
		managedForm.getToolkit().paintBordersFor(sctnCreate);
		sctnCreate.setText("Create");
		sctnCreate.setExpanded(true);

		Composite composite = managedForm.getToolkit().createComposite(sctnCreate, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnCreate.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		wizardDescriptor = getWizardDescriptors();

		customActions = DashboardContributionsHandler.getCustomActions();

		for (DashboardCategory category : categories) {
			createCategory(managedForm, composite, category.getName());
		}
		sctnCreate.setExpanded(true);
		int initialVerticalMargin = 10;
		int verticalSpaceConstant = 80;
		IConfigurationElement[] dashBoardSections =
		                                            devStudioUtils.getExtensionPointmembers("org.wso2.developerstudio.create.dashbaord.section");
		int itemNo = 0;
		for (IConfigurationElement dasBoardSectionItem : dashBoardSections) {
			int verticalSpace = initialVerticalMargin + itemNo * verticalSpaceConstant;
			createDashboardCategoryEntry(managedForm, dasBoardSectionItem.getAttribute("name"),
			                             verticalSpace, dasBoardSectionItem.getAttribute("icon"),
			                             dasBoardSectionItem.getAttribute("nametag"),
			                             dasBoardSectionItem.getAttribute("bundleID"));
			itemNo++;

		}
	}

	private void createDashboardCategoryEntry(IManagedForm managedForm, String txtHeader,
	                                          int verticalAlignment, String imageLoc, String title,
	                                          String bundleID) {
		Section addSection =
		                     managedForm.getToolkit()
		                                .createSection(managedForm.getForm().getBody(),
		                                               Section.TWISTIE | Section.TITLE_BAR);
		addSection.setBounds(700, verticalAlignment, 300, 75);
		managedForm.getToolkit().paintBordersFor(addSection);
		addSection.setText(txtHeader);

		Composite addComposite = managedForm.getToolkit().createComposite(addSection, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(addComposite);
		addSection.setClient(addComposite);
		addComposite.setLayout(new GridLayout(1, false));
		ImageDescriptor imageDescriptor =
		                                  ImageDescriptor.createFromURL(FileLocator.find(Platform.getBundle(bundleID),
		                                                                                 new Path(
		                                                                                          imageLoc),
		                                                                                 null));
		ImageDescriptor addServerImageDesc =
		                                     ImageDescriptor.createFromImage(DashboardUtil.resizeImage(imageDescriptor.createImage(),
		                                                                                               32,
		                                                                                               32));
		createTitlelessCategory(managedForm, addComposite, title, addServerImageDesc);
		addSection.setExpanded(true);
	}

	private Map<String, IWizardDescriptor> getWizardDescriptors() {
		Map<String, IWizardDescriptor> descriptorMap = new HashMap<String, IWizardDescriptor>();
		List<String> categoryContributions =
		                                     DashboardContributionsHandler.getCategoryContributions();
		IConfigurationElement[] dashBoardSectionIDs =
		                                              devStudioUtils.getExtensionPointmembers("org.wso2.developerstudio.create.dashbaord.section");
		for (IConfigurationElement dashBoardCatID : dashBoardSectionIDs) {
			categoryContributions.add(dashBoardCatID.getAttribute("id"));
		}
		List<IWizardDescriptor> descriptors =
		                                      getWizardDescriptor(categoryContributions.toArray(new String[] {}));
		for (IWizardDescriptor descriptor : descriptors) {
			descriptorMap.put(descriptor.getId(), descriptor);
		}
		return descriptorMap;
	}

	private List<IWizardDescriptor> getWizardDescriptor(String... categories) {
		List<IWizardDescriptor> descriptors = new ArrayList<IWizardDescriptor>();
		IWizardRegistry wizardRegistry = PlatformUI.getWorkbench().getNewWizardRegistry();
		for (String category : categories) {
			IWizardCategory wizardCategory = wizardRegistry.findCategory(category);
			if (wizardCategory != null) {
				IWizardDescriptor[] wizards = wizardCategory.getWizards();
				descriptors.addAll(Arrays.asList(wizards));
			}
		}
		return descriptors;
	}

	/**
	 * Create contents of category
	 * 
	 * @param managedForm
	 * @param composite
	 * @param category
	 */
	private void createCategory(IManagedForm managedForm, Composite composite, String category) {
		int itemCount = 0;
		Label lblcategory = managedForm.getToolkit().createLabel(composite, category, SWT.NONE);
		lblcategory.setFont(SWTResourceManager.getFont("Sans", 10, SWT.BOLD));
		GridData gd_category = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_category.verticalIndent = 10;
		lblcategory.setLayoutData(gd_category);

		for (String id : wizardCategoryMap.get(category)) {
			if (wizardDescriptor.containsKey(id)) {
				itemCount++;
				createWizardLink(managedForm, composite, wizardDescriptor.get(id));
			} else if (customActions.containsKey(id)) {
				itemCount++;
				createLink(managedForm, composite, customActions.get(id));
			}
		}
		if (itemCount % 2 == 1) {
			new Label(composite, SWT.NONE);
		}
	}

	/**
	 * Create contents of category with title
	 * 
	 * @param managedForm
	 * @param composite
	 * @param category
	 */
	private void createTitlelessCategory(IManagedForm managedForm, Composite composite,
	                                     String category, ImageDescriptor customImage) {
		int itemCount = 0;

		for (String id : wizardCategoryMap.get(category)) {
			if (wizardDescriptor.containsKey(id)) {
				itemCount++;
				createWizardLink(managedForm, composite, wizardDescriptor.get(id), customImage);
			}
		}
		if (itemCount % 2 == 1) {
			new Label(composite, SWT.NONE);
		}
	}

	/**
	 * Create contents of wizard link with custom image
	 * 
	 * @param managedForm
	 * @param composite
	 * @param wizard
	 * @param customImage
	 */
	private void createWizardLink(IManagedForm managedForm, Composite composite,
	                              IWizardDescriptor wizard, ImageDescriptor customImage) {
		final String wizardId = wizard.getId();
		ImageHyperlink wizardLink =
		                            managedForm.getToolkit().createImageHyperlink(composite,
		                                                                          SWT.NONE);
		ImageDescriptor descriptionImage =
		                                   (customImage != null) ? customImage
		                                                        : wizard.getImageDescriptor();
		if (descriptionImage != null) {
			wizardLink.setImage(descriptionImage.createImage());
		}
		managedForm.getToolkit().paintBordersFor(wizardLink);
		wizardLink.setText(wizard.getLabel());
		wizardLink.setToolTipText(wizard.getDescription());
		GridData gd_wizardLink = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		wizardLink.setLayoutData(gd_wizardLink);
		wizardLink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkActivated(HyperlinkEvent evt) {
				openWizard(wizardId);
			}

			public void linkEntered(HyperlinkEvent evt) {

			}

			public void linkExited(HyperlinkEvent evt) {

			}
		});
	}

	/**
	 * Create contents of link with custom action
	 * 
	 * @param managedForm
	 * @param composite
	 * @param action
	 */
	private void createLink(IManagedForm managedForm, Composite composite, final Action action) {
		ImageHyperlink wizardLink =
		                            managedForm.getToolkit().createImageHyperlink(composite,
		                                                                          SWT.NONE);
		ImageDescriptor descriptionImage = action.getImageDescriptor();
		if (descriptionImage != null) {
			wizardLink.setImage(descriptionImage.createImage());
		}
		managedForm.getToolkit().paintBordersFor(wizardLink);
		wizardLink.setText(action.getText());
		wizardLink.setToolTipText(action.getDescription());
		GridData gd_wizardLink = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		wizardLink.setLayoutData(gd_wizardLink);
		wizardLink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkActivated(HyperlinkEvent evt) {
				action.run();
			}

			public void linkEntered(HyperlinkEvent evt) {

			}

			public void linkExited(HyperlinkEvent evt) {

			}
		});
	}

	/**
	 * Create contents of wizard link
	 * 
	 * @param managedForm
	 * @param composite
	 * @param wizard
	 */
	private void createWizardLink(IManagedForm managedForm, Composite composite,
	                              IWizardDescriptor wizard) {
		createWizardLink(managedForm, composite, wizard, null);
	}

	private void createSamples(IManagedForm managedForm, Composite composite) {
		List<IDeveloperStudioSampleContributor> samples = ExtensionPointHandler.getSamples();
		for (IDeveloperStudioSampleContributor contributor : samples) {
			createSampleLink(managedForm, composite, contributor);
		}
	}

	private void createSampleLink(IManagedForm managedForm, Composite composite,
	                              final IDeveloperStudioSampleContributor contributor) {
		ImageHyperlink sampleLink =
		                            managedForm.getToolkit().createImageHyperlink(composite,
		                                                                          SWT.NONE);
		ImageDescriptor descriptionImage = contributor.getWizardPageImage();
		if (descriptionImage != null) {
			sampleLink.setImage(DashboardUtil.resizeImage(descriptionImage.createImage(), 32, 32));
		}
		managedForm.getToolkit().paintBordersFor(sampleLink);
		sampleLink.setText(contributor.getCaption());
		sampleLink.setToolTipText(contributor.getToolTip());
		GridData gd_sampleLink = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		sampleLink.setLayoutData(gd_sampleLink);
		sampleLink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkActivated(HyperlinkEvent evt) {
				createProject(contributor);
			}

			public void linkEntered(HyperlinkEvent evt) {

			}

			public void linkExited(HyperlinkEvent evt) {

			}
		});
	}

	private void createProject(IDeveloperStudioSampleContributor contributor) {
		Shell shell = Display.getCurrent().getActiveShell();
		String projectName = contributor.getProjectName();
		ImageDescriptor wizardImage = contributor.getWizardPageImage();
		String title = contributor.getCaption();

		ProjectCreationWizard wizard = new ProjectCreationWizard(projectName, title, wizardImage);
		wizard.setWindowTitle(contributor.getCaption());
		wizard.init(PlatformUI.getWorkbench(), null);
		WizardDialog wizardDialog = new WizardDialog(shell, wizard);

		wizardDialog.create();

		if (wizardDialog.open() == Dialog.OK) {
			IProject createdProject = wizard.getCreatedProject();
			try {
				if (!createdProject.exists()) {
					createdProject.create(null);
				}
				if (!createdProject.isOpen()) {
					createdProject.open(null);
				}
				contributor.addSampleTo(createdProject);
			} catch (Exception e) {
				log.error("Cannot open wizard", e);
			}
		}
	}

	/**
	 * Open a project wizard
	 * 
	 * @param id
	 */
	private void openWizard(String id) {
		IWizardDescriptor descriptor =
		                               PlatformUI.getWorkbench().getNewWizardRegistry()
		                                         .findWizard(id);
		try {
			if (null != descriptor) {
				IWorkbenchWizard wizard = descriptor.createWizard();
				wizard.init(PlatformUI.getWorkbench(), getCurrentSelection());
				WizardDialog wd =
				                  new WizardDialog(
				                                   PlatformUI.getWorkbench()
				                                             .getActiveWorkbenchWindow().getShell(),
				                                   wizard);
				wd.setTitle(wizard.getWindowTitle());
				wd.open();
			}
		} catch (CoreException e) {
			log.error("Cannot open wizard", e);
		}
	}

	/**
	 * Get current selection
	 * 
	 * @return
	 */
	private IStructuredSelection getCurrentSelection() {
		if (selection instanceof IStructuredSelection) {
			return (IStructuredSelection) selection;
		}
		return new StructuredSelection();
	}

	public void dispose() {
		ISelectionService selectionService = getSite().getWorkbenchWindow().getSelectionService();
		selectionService.removeSelectionListener(selectionListener);
		super.dispose();
	}

}
