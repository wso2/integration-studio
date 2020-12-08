/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.MediaManager;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryFormEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.managers.RemoteContentManager;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IGARImportDependency;
import org.wso2.developerstudio.eclipse.registry.core.utils.GARUtils;

public class ResourceEditorPage extends FormPage implements
		IResourceChangeListener, IRegistryFormEditorPage {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private FormToolkit toolkit;
	private ScrolledForm form;
	private String selectedMethod;
	private RegistryResourceNode regResourcePathData;
	private Text nameText;
	private Combo mediaTypeText;
	private Text descText;
	private Text contentAreaText;
	private Registry registry;
	private Label createdDateLabel;
	private Label lastModifedDateLabel;
	private Label currentVersionLabel;
	private Label myRatingLabel;
	private Label averageRatingLabel;
	private Combo myRatingCombo;
	private Label lifeCycle;
	private Label lifeCycleState;
	
	private String currentResourceName ="";
	private String currentDescription = "";
	private String currentMediaType = "";
	private boolean createGovernanceArchive = false;
	private Date createdDate;
	private String createdUser;
	private Date lastModifiedDate;
	private String lastModifiedUser;
	private String currentVersion;
	private int myRating;
	private float averageRating;
	private int currentMyRating;
	private String currentlifeCycle;
	private String currentlifeCycleState;

	private Shell containerShell;
	private RegistryResourceEditor editor;

	private String resourceName = "";
	private String filePath = "";
	private String description = "";
	private String mediaType = "";
	private boolean pageDirty;
	private String content = "";

	private Composite sectionContainer;

	private String[] addResourceMethods = { "Upload Content From file",
			"Create custom content", "Import Content from URL" };
	private ResourceEditorInput editorInput;
	private String parentPath;

	private Combo methodCombo;
	private Label lbl;
	private Button openButton;

	private String resourceUrl = "";
	private Section section;

	private Text urlText;

	private Text filePathText;

	private Button btnGovernanceArchive;
	
	private Button btnOk;
	
	private boolean isNewResource;

	public ResourceEditorPage(RegistryResourceEditor editor, String id,
			String title) {
		super(editor, id, title);
		this.editor = editor;
		editorInput = (ResourceEditorInput) editor.getEditorInput();
		loadData();
	}

	public void resourceChanged(IResourceChangeEvent arg0) {

	}

	public void updateFormName() {
		String name = getResourceName().equalsIgnoreCase("") ? "<Resource>"
				: getResourceName();
		name = getParentPath().endsWith("/") ? name : "/" + name;
		name = getParentPath() + name;
		name = name.replaceAll(Pattern.quote("//"), "/");
		if (form != null && !form.isDisposed()) {
			form.setText(name);
		}
	}

	public String getParentPath() {
		if (editorInput.getParentResource() != null
				&& editorInput.getParentResource().getRegistryResourcePath() == null) {
			parentPath = "/";
		} else if (editorInput.getParentResource() == null) {
			parentPath = editorInput
					.getResource()
					.getRegistryResourcePath()
					.substring(
							0,
							editorInput.getResource().getRegistryResourcePath()
									.length()
									- editorInput.getResource()
											.getLastSegmentInPath().length());
		} else
			parentPath = editorInput.getParentResource()
					.getRegistryResourcePath();
		return parentPath;
	}

	protected void createFormContent(IManagedForm managedForm) {

		registry = new Registry();
		toolkit = managedForm.getToolkit();
		form = managedForm.getForm();
		toolkit.decorateFormHeading(form.getForm());
		form.getForm();
		form.getBody().setLayout(new GridLayout());

		Composite columnComp = toolkit.createComposite(form.getBody());
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.horizontalSpacing = 75;
		columnComp.setLayout(layout);
		GridData gd = new GridData();
		columnComp.setLayoutData(gd);

		// Fixing TOOLS-542
		try {
			if (((ResourceEditorPage) managedForm.getContainer()).currentMediaType != null) {
				mediaType = ((ResourceEditorPage) managedForm.getContainer()).currentMediaType;
			}
			if (((ResourceEditorPage) managedForm.getContainer()).currentDescription != null) {
				description = ((ResourceEditorPage) managedForm.getContainer()).currentDescription;
			}
		} catch (ClassCastException e1) {
			log.error("Cannot determine media type of description for the current resource");
		}

		if (editorInput.getResource() == null) {
			isNewResource = true;
			
			lbl = toolkit.createLabel(columnComp, "Method");
			lbl.setLayoutData(new GridData());

			methodCombo = new Combo(columnComp, SWT.VERTICAL | SWT.DROP_DOWN
					| SWT.BORDER | SWT.READ_ONLY);
			toolkit.adapt(methodCombo);
			toolkit.paintBordersFor(columnComp);
			methodCombo.add(addResourceMethods[0], 0);

			for (int i = 1; i < addResourceMethods.length; i++) {
				methodCombo.add(addResourceMethods[i]);
			}
			if (methodCombo.getSelectionIndex() == -1) {
				methodCombo.select(0);
			}

			Composite sectionComp = toolkit.createComposite(form.getBody());
			GridLayout sLayout = new GridLayout();
			layout.numColumns = 2;
			sectionComp.setLayout(sLayout);
			GridData sectionGd = new GridData();
			sectionComp.setLayoutData(sectionGd);

			sectionContainer = toolkit.createComposite(sectionComp);
			// sectionContainer = toolkit.createComposite(columnComp);
			GridLayout sectionLayout = new GridLayout();
			sectionLayout.numColumns = 1;
			sectionContainer.setLayout(sectionLayout);
			sectionContainer.setLayoutData(new GridData(
					GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));

			section = toolkit.createSection(sectionContainer, SWT.NONE);
			section1Data("Upload Content From file", section);
			methodCombo.addSelectionListener(new SelectionAdapter() {
				int currentSelection = 0;

				public void widgetSelected(SelectionEvent e) {
					selectedMethod = methodCombo.getText();
					if (selectedMethod.equals("Upload Content From file")) {
						if (currentSelection != 0) {
							section.dispose();
							section = toolkit.createSection(sectionContainer,
									SWT.NONE);
							section1Data(selectedMethod, section);
						}
						currentSelection = 0;
					} else if (selectedMethod.equals("Import Content from URL")) {
						if (currentSelection != 1) {
							section.dispose();
							section = toolkit.createSection(sectionContainer,
									SWT.NONE);
							section2Data(selectedMethod, section);
						}
						currentSelection = 1;
					} else if (selectedMethod.equals("Create custom content")) {
						if (currentSelection != 2) {
							section.dispose();
							section = toolkit.createSection(sectionContainer,
									SWT.NONE);
							section3Data(selectedMethod, section);
						}
						currentSelection = 2;
					} else {

					}
					resetFormDataValues();
					updateDirtyState();
				}
			});

		} else {
			fillResourceInfo(columnComp);
			updateFormName();
			refresh();
		}
		
		form.reflow(true);
	}

	private void renderSaveButton(Composite columnComp) {
	    Label lblEmpty=toolkit.createLabel(columnComp, "");
		btnOk=toolkit.createButton(columnComp, " Save ", SWT.BUTTON1 | SWT.BORDER);
		btnOk.setVisible(true);
		btnOk.addListener(SWT.Selection, new Listener() {
			
			public void handleEvent(Event arg0) {
				try {
					if (selectedMethod != null
							&& selectedMethod.equals("Create custom content")) {
						createContent(getResourceName(), getMediaType());
					}
	                doFinish();
//	                refreshPage();
                } catch (Exception e) {
                	log.error("An unexpected error has occurred", e);
                }
			}
		});
		
		btnOk.setEnabled(false);
    }

	public void loadData(Section section, Composite container) {
		section.setClient(container);
	}

	public FormColors setFormColour() {
		FormColors formColor = new FormColors(Display.getCurrent());
		formColor.createColor(FormColors.BORDER, 0, 0, 255);
		formColor.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		return formColor;
	}

	public void section1Data(String method, Section section) {
		Button pathButton;
		Label fileLabel;

		section.redraw();
		section.setVisible(true);
		section.setText(method);
		Composite container = toolkit.createComposite(section);
		GridLayout updatelayout = new GridLayout();
		updatelayout.numColumns = 4;
		updatelayout.horizontalSpacing = 10;
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL);
		container.setLayoutData(gd);
		container.setLayout(updatelayout);

		containerShell = section.getShell();

		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileLabel = toolkit.createLabel(container, "File: ");
		fileLabel.setLayoutData(gd);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label fileRequired = toolkit.createLabel(container, "*",
				SWT.COLOR_DARK_RED);
		fileRequired.setForeground(Display.getDefault().getSystemColor(
				SWT.COLOR_RED));
		fileLabel.setLayoutData(gd);

		filePathText = toolkit.createText(container, "", SWT.BORDER
				| SWT.COLOR_WIDGET_BACKGROUND);
		filePathText.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_GRAY));
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		filePathText.setLayoutData(gd);

		gd = new GridData();
		gd.heightHint = 27;
		gd.widthHint = 70;
		pathButton = toolkit.createButton(container, "Browse", SWT.PUSH);
		pathButton.setLayoutData(gd);

		pathButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handlePathBrowseButton(filePathText);
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label nameLabel = toolkit.createLabel(container, "Name:");
		nameLabel.setLayoutData(gd);

		Label reqNameLabel = toolkit.createLabel(container, "*",
				SWT.COLOR_DARK_RED);
		reqNameLabel.setForeground(Display.getDefault().getSystemColor(
				SWT.COLOR_RED));

		nameText = toolkit.createText(container, "", SWT.BORDER);
		nameText.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_GRAY));
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 250;
		nameText.setLayoutData(gd);

		openButton = toolkit.createButton(container, "Open", SWT.None);
		openButton.setVisible(false);
		openButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent arg0) {
				RegistryResourceNode resource = editorInput.getResource();
				registry = resource.getConnectionInfo().getRegistry();
				File tempFile;
				tempFile = resource.getFile();
				IEditorPart editor = RemoteContentManager.openFile(tempFile);
				resource.setFileEditor(editor);
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);
			}
		});
		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				nameText.setBackground(Display.getDefault().getSystemColor(
						SWT.COLOR_WHITE));
				setResourceName(nameText.getText());
				updateDirtyState();
			}
		});

		gd = new GridData(GridData.FILL_HORIZONTAL);
		createMediaTypeCombo(container);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label hiddenLabel2 = toolkit.createLabel(container, "", SWT.NULL);
		hiddenLabel2.setLayoutData(gd);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label descriptionLabel = toolkit.createLabel(container, "", SWT.NULL);
		descriptionLabel.setText("Description: ");
		descriptionLabel.setLayoutData(gd);

		Label hidLab3 = toolkit.createLabel(container, "");

		gd = new GridData();
		gd.heightHint = 50;
		gd.widthHint = 350;
		descText = toolkit.createText(container, "", SWT.MULTI | SWT.BORDER
				| SWT.V_SCROLL | SWT.WRAP);
		descText.setLayoutData(gd);
		descText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				setDescription(descText.getText());
				updateDirtyState();

			}
		});

		filePathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				filePathText.setBackground(Display.getDefault().getSystemColor(
						SWT.COLOR_WHITE));
				Text name = (Text) event.widget;
				resourceName = name.getText();
				setFilePath(resourceName);

				nameText.setText(getfileName(getFilePath()));

				File file = new File(getFilePath());
				String mediaType;
				mediaType = MediaManager.getMediaType(file);
				if (mediaType == null) {
					mediaTypeText.setText("plain/text");
					setMediaType(null);
				} else {
					mediaTypeText.setText(mediaType);
					setMediaType(mediaType);
				}
				updateDirtyState();
			}
		});

		toolkit.createLabel(container, "", SWT.NULL);
		
		toolkit.createLabel(container, "");
		renderSaveButton(container);
		
		section.setClient(container);

		updateFormName();
		refresh();
	}

	private void createMediaTypeCombo(Composite container) {
		GridData gd;
		toolkit.createLabel(container, "Media Type: ");
		
		if (selectedMethod != null
				&& selectedMethod.equals("Create custom content")) {
			Label reqMediaTypeLabel = toolkit.createLabel(container, "*",
					SWT.COLOR_DARK_RED);
			reqMediaTypeLabel.setForeground(Display.getDefault()
					.getSystemColor(SWT.COLOR_RED));
		} else {
			toolkit.createLabel(container, "");
		}

		ArrayList<String> mediaTypeskeySet = registry.getAllMediaTypes();
		mediaTypeText = new Combo(container, SWT.BORDER);
		loadMediaTypes(mediaTypeskeySet);

		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 250;
		mediaTypeText.setLayoutData(gd);
		mediaTypeText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				setMediaType(mediaTypeText.getText());
				updateDirtyState();
			}
		});

		gd = new GridData();
		gd.horizontalSpan = 3;

		btnGovernanceArchive = toolkit.createButton(container,
				"Create governance archive", SWT.CHECK);
		btnGovernanceArchive.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setCreateGovernanceArchive(btnGovernanceArchive.getSelection());
			}
		});
		btnGovernanceArchive.setSelection(false);
		btnGovernanceArchive.setVisible(false);
		btnGovernanceArchive.setLayoutData(gd);
	}

	public void section2Data(String method, Section section) {
		section.setVisible(true);
		section.setText(method);
		Composite container = toolkit.createComposite(section);
		GridLayout updatelayout = new GridLayout();
		updatelayout.numColumns = 3;
		updatelayout.horizontalSpacing = 10;
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL);
		container.setLayoutData(gd);
		container.setLayout(updatelayout);

		containerShell = section.getShell();

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label urlLabel = toolkit.createLabel(container, "URL: ");
		urlLabel.setLayoutData(gd);

		Label reqURLLabel = toolkit.createLabel(container, "*",
				SWT.COLOR_DARK_RED);
		reqURLLabel.setForeground(Display.getDefault().getSystemColor(
				SWT.COLOR_RED));

		urlText = toolkit.createText(container, "", SWT.BORDER);
		urlText.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_GRAY));
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		urlText.setLayoutData(gd);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label nameLabel = toolkit.createLabel(container, "Name: ");
		nameLabel.setLayoutData(gd);

		Label reqNameLabel = toolkit.createLabel(container, "*",
				SWT.COLOR_DARK_RED);
		reqNameLabel.setForeground(Display.getDefault().getSystemColor(
				SWT.COLOR_RED));

		nameText = toolkit.createText(container, "", SWT.BORDER);
		nameText.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_GRAY));
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 250;
		nameText.setLayoutData(gd);

		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				setResourceName(nameText.getText());
				nameText.setBackground(Display.getDefault().getSystemColor(
						SWT.COLOR_WHITE));
				updateDirtyState();
			}
		});

		gd = new GridData(GridData.FILL_HORIZONTAL);
		createMediaTypeCombo(container);

		urlText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text name = (Text) event.widget;
				String url = name.getText();
				setResourceUrl(url);
				urlText.setBackground(Display.getDefault().getSystemColor(
						SWT.COLOR_WHITE));
				updateDirtyState();
				try {
					if (validateUrl(url)) {
						fillOtherInfo(mediaTypeText, nameText);
					}
				} catch (URISyntaxException e) {
					log.error(e);
				} catch (IOException e) {
					log.error(e);
				}

			}
		});

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label descriptionLabel = toolkit.createLabel(container, "", SWT.NULL);
		descriptionLabel.setText("Description: ");
		descriptionLabel.setLayoutData(gd);

		toolkit.createLabel(container, "");

		gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 50;
		descText = toolkit.createText(container, "", SWT.MULTI | SWT.BORDER
				| SWT.V_SCROLL | SWT.WRAP);
		descText.setLayoutData(gd);
		descText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				setDescription(descText.getText());
				updateDirtyState();

			}
		});
		
		toolkit.createLabel(container, "");
		
		renderSaveButton(container);
		
		section.setClient(container);
		updateFormName();
		refresh();

	}

	public void section3Data(String method, Section section) {
		section.redraw();
		section.setVisible(true);
		section.setText(method);
		Composite container = toolkit.createComposite(section);
		GridLayout updatelayout = new GridLayout();
		updatelayout.numColumns = 3;
		updatelayout.horizontalSpacing = 10;
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL);
		container.setLayoutData(gd);
		container.setLayout(updatelayout);

		containerShell = section.getShell();
		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label nameLable = toolkit.createLabel(container, "Name: ");
		nameLable.setLayoutData(gd);

		Label reqNameLabel = toolkit.createLabel(container, "*",
				SWT.COLOR_DARK_RED);
		reqNameLabel.setForeground(Display.getDefault().getSystemColor(
				SWT.COLOR_RED));

		nameText = toolkit.createText(container, "", SWT.BORDER);
		nameText.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_GRAY));
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 250;
		nameText.setLayoutData(gd);

		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text name = (Text) event.widget;
				String resName = name.getText();
				setResourceName(resName);
				nameText.setBackground(Display.getDefault().getSystemColor(
						SWT.COLOR_WHITE));
				updateDirtyState();
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		createMediaTypeCombo(container);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label descriptionLabel = toolkit.createLabel(container, "", SWT.NULL);
		descriptionLabel.setText("Description: ");
		descriptionLabel.setLayoutData(gd);

		toolkit.createLabel(container, "");

		gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 50;
		descText = toolkit.createText(container, "", SWT.MULTI | SWT.BORDER
				| SWT.V_SCROLL | SWT.WRAP);
		descText.setLayoutData(gd);
		descText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				setDescription(descText.getText());

				updateDirtyState();

			}
		});

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label contentLabel = toolkit.createLabel(container, "", SWT.NULL);
		contentLabel.setText("Content: ");
		contentLabel.setLayoutData(gd);

		toolkit.createLabel(container, "");

		gd = new GridData();
		gd.heightHint = 150;
		gd.widthHint = 500;
		contentAreaText = toolkit.createText(container, "", SWT.MULTI
				| SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
		contentAreaText.setLayoutData(gd);
		contentAreaText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				setContent(contentAreaText.getText());
				updateDirtyState();

			}
		});
		
		toolkit.createLabel(container, "");
		renderSaveButton(container);

		section.setClient(container);
		updateFormName();
		refresh();

	}

	private void loadMediaTypes(ArrayList<String> mediaTypeskeySet) {
		mediaTypeText.removeAll();
		for (String keys : mediaTypeskeySet) {
			mediaTypeText.add(keys);
		}
	}

	private void createContent(String fileName, String mediaType)
			throws IOException {

		if (selectedMethod.equals("Create custom content")) {
			String fileExt = registry.getMediaTypeFileExtension(mediaType);

			if (fileExt != null) {
				String name = fileName + "." + fileExt;
				File tempDir = File.createTempFile("test", "test");
				tempDir.delete();
				tempDir.mkdirs();

				File tempFile = File.createTempFile(fileName, "", tempDir);
				BufferedWriter out = new BufferedWriter(
						new FileWriter(tempFile));
				out.write(getContent());
				out.close();
				tempFile.deleteOnExit();
				// IEditorPart editor = RemoteContentManager.openFile(tempFile);
				//editorInput.getParentResource().setFileEditor(editor);
				setFilePath(tempFile.getAbsolutePath());

			}
		}
	}

	private boolean validateUrl(String url) throws URISyntaxException,
			IOException {
		// url = url.toLowerCase();
		url = removeSpaces(url);
		URI pathUri = new URI(url);
		String p2 = pathUri.toURL().toString();
		URI uri2 = new URI(p2);
		String p3 = uri2.toASCIIString();
		URL path = new URL(p3);
		// URL path = pathUri.toURL();
		if (((HttpURLConnection) path.openConnection()).getResponseCode() > 0) {
			setResourceUrl(p3);
			return true;

		}
		return false;

	}

	private String removeSpaces(String url) {
		Pattern pattern = Pattern.compile("\\s+");
		Matcher matcher = pattern.matcher(url);
		boolean check = matcher.find();
		String str = matcher.replaceAll("");
		return str;
	}

	private void fillOtherInfo(Combo mediatypeText, Text nameText)
			throws URISyntaxException, IOException {
		String extention = "";
		String mediaType = "";
		URI pathUri = new URI(getResourceUrl());
		URL path = pathUri.toURL();
		URLConnection uc = path.openConnection();
		mediaType = MediaManager.getMediaType(path);
		mediaType = (mediaType == null ? uc.getContentType() : mediaType);

		String[] info = path.getPath().split("/");
		String name = "";
		if (path.getQuery() != null) {
			name = info[info.length - 1] + "." + path.getQuery();
		} else {
			name = info[info.length - 1];
		}

		nameText.setText(name);

		if (mediaType == null) {
			mediatypeText.setText("not specified");
			setMediaType(null);
		} else {
			mediatypeText.setText(mediaType);
			setMediaType(mediaType);
		}
		File tempDir = File.createTempFile("test", "test");
		tempDir.delete();
		tempDir.mkdirs();

		// File tempFile = new File(tempDir, name);
		File tempFile = File.createTempFile("temp", name, tempDir);
		tempFile.deleteOnExit();
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		InputStream is = path.openStream();
		OutputStream out = new FileOutputStream(tempFile);
		byte buf[] = new byte[1024];
		int len;
		while ((len = is.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		out.close();
		is.close();

		setFilePath(tempFile.getAbsolutePath());

	}

	private void refresh() {
		if (editorInput.getResource() != null) {
			if (lbl != null && !lbl.isDisposed())
				lbl.setVisible(false);
			if (methodCombo != null && !methodCombo.isDisposed())
				methodCombo.setVisible(false);
		}
	}
	
	private void refreshPage(){
		loadData();
		if (!isNewResource) {
			reloadData();
		}
	}

	private void loadData() {
		RegistryResourceNode resource = editorInput.getResource();
		if (resource != null) {
			setCurrentResourceName(resource.getLastSegmentInPath());
			setResourceName(getCurrentResourceName());
			try {
				Registry registryConnection = resource.getConnectionInfo()
						.getRegistry();
				Resource regResource = registryConnection.get(resource.getRegistryResourcePath());
				String selectedPath = resource.getRegistryResourcePath();
				if(regResource.getMediaType() != null){
					setCurrentMediaType(regResource.getMediaType());
					setMediaType(getCurrentMediaType());
				}
				if(regResource.getDescription() != null){
					setCurrentDescription(regResource.getDescription());
					setDescription(getCurrentDescription());
				}
				
				setCreatedDate(regResource.getCreatedTime());
				setCreatedUser(regResource.getAuthorUserName());
				setLastModifiedDate(regResource.getLastModified());
				setLastModifiedUser(regResource.getLastUpdaterUserName());
				String version = null;

				try {
					// Format of a version result is
					// "/_system/registry-info.xml;version:72". Hence decoded in
					// the following manner.
					version = registryConnection
							.getVersions(selectedPath)[0]
							.split(";")[1].split(":")[1];
				} catch (Exception e) {
					//This is an expected situation where the versions are not available. Hence disabled the error log.
//					log.error(e);
				}

				if (version == null) {
					setCurrentVersion("No Versions available for this resource");
				} else {
					setCurrentVersion(version);
				}
				
				setCurrentLifeCycle(registryConnection.getLifeCycleName(regResource));
				setCurrentLifeCycleState(registryConnection.getLifeCycleState(regResource));
				
				setCurrentMyRating(registryConnection.getRating(selectedPath, registryConnection.getUserName()));
                setMyRating(getCurrentMyRating());
                setAverageRating(registryConnection.getAverageRating(selectedPath));
			} catch (Exception e) {
				log.error(e);
			}
		}
	}
	
	private void reloadData(){
//		txtDescription.setText(getResourceDescription());
		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy H:mm:ss");
		lastModifedDateLabel.setText("By "+getLastModifiedUser()+" "+formatter.format(getLastModifiedDate()));
		currentVersionLabel.setText(getCurrentVersion());
		myRatingCombo.select(getMyRating());
		averageRatingLabel.setText(""+getAverageRating());
	}

	private void updateDirtyState() {
		if (selectedMethod != null
				&& selectedMethod.equals("Create custom content")
				&& (getResourceName().trim().isEmpty() || getMediaType().trim()
						.isEmpty())) {
			setPageDirty(false);
			btnOk.setEnabled(false);
			return;
		} else if (selectedMethod != null
				&& selectedMethod.equals("Import Content from URL")
				&& (getResourceName().trim().isEmpty() || getResourceUrl().trim()
						.isEmpty())) {
			setPageDirty(false);
			btnOk.setEnabled(false);
			return;
		} else if (getResourceName().trim().isEmpty()) {
			setPageDirty(false);
			btnOk.setEnabled(false);
			return;
		}

		boolean dirtyState = ((getCurrentResourceName() != null) && !getCurrentResourceName()
				.equals(getResourceName()))

				|| ((getCurrentMediaType() != null) && !getCurrentMediaType()
						.equals(getMediaType()))

				|| ((getCurrentDescription() != null)
						&& !getCurrentDescription().equals(getDescription())

				|| getCurrentMyRating() != getMyRating());

		setPageDirty(dirtyState);

		// Enabling Save button if delta exists
		if (btnOk != null) {
			btnOk.setEnabled(dirtyState);
		}

	}

	public void syncToCurrentValues() {
		setCurrentResourceName(getResourceName());
		setCurrentMediaType(getMediaType());
		setCurrentDescription(getDescription());
		updateDirtyState();
	}

	public String getfileName(String filePath) {
		String fileName;
		String[] filepathInfo = filePath.split(Pattern.quote(File.separator));
		fileName = filepathInfo[filepathInfo.length - 1];
		return fileName;
	}

	public String getFileExtension(String filePath) {
		String fileExt = null;
		String fileName = getfileName(filePath);
		String[] fileNameInfo = fileName.split("\\.");
		fileExt = fileNameInfo[fileNameInfo.length - 1];
		return fileExt;
	}

	public RegistryResourceNode getRegResourcePathData() {
		return regResourcePathData;
	}

	public void setRegResourcePathData(RegistryResourceNode regResourcePathData) {
		this.regResourcePathData = regResourcePathData;
	}

	public String getCurrentResourceName() {
		return currentResourceName;
	}

	public void setCurrentResourceName(String userGivenName) {
		this.currentResourceName = userGivenName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		boolean isWSDLMediaType =
		                          PlatformMediaTypeConstants.MEDIA_TYPE_WSDL.equalsIgnoreCase(mediaType);
		boolean wasWSDLMediaType =
		                           PlatformMediaTypeConstants.MEDIA_TYPE_WSDL.equalsIgnoreCase(this.mediaType);
		this.mediaType = mediaType;
		if (btnGovernanceArchive != null) {
			btnGovernanceArchive.setVisible(isWSDLMediaType);
			btnGovernanceArchive.setSelection(btnGovernanceArchive.getSelection() ||
			                                  (isWSDLMediaType && !wasWSDLMediaType));
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void handlePathBrowseButton(Text filePathText) {
		String fileName = getSavePath();
		if (fileName != null)
			filePathText.setText(fileName);
			//fixing TOOLS-116
			editorInput.setResource(null);
	}

	private String getSavePath() {
		String fileName = null;
		// FileDialog
		FileDialog fld = new FileDialog(containerShell, SWT.OPEN);
		boolean done = false;

		while (!done) {
			// Open the File Dialog
			fileName = fld.open();
			if (fileName == null) {
				// User has cancelled, so quit and return
				done = true;
			} else {
				// User has selected a file; see if it already exists
				File file = new File(fileName);
				if (file.exists()) {
					// If they click Yes, we're done and we drop out. If
					// they click No, we redisplay the File Dialog
					done = true;
				} else {
					// File does not exist, so drop out
					done = false;
				}
			}
		}
		return fileName;
	}

	public void validate() throws Exception {

		// file name, file path should be valid

		if (editorInput.getResource() == null) {
			if (getFilePath() != null) {
				if (getFilePath().trim().equals("")) {
					try {
						createContent(getResourceName(), getMediaType());
					} catch (IOException e1) {
						log.error("An IO exception has occurred", e1);
						throw new Exception("File cannot be empty");
					}
					//
				} else {
					String filepath = getFilePath();
					File file = new File(filepath);
					if (!file.exists()) {
						file.createNewFile();
					}
				}
			}
			regResourcePathData = editorInput.getParentResource();
			boolean found = false;
			for (RegistryResourceNode child : regResourcePathData
					.getResourceNodeList()) {
				if (child.getCaption().equals(getCurrentResourceName())) {
					found = true;
					break;
				}
			}
			if (found)
				throw new Exception("The Resource name '"
						+ getCurrentResourceName()
						+ "' already exists in the given path");
		}
		if (getResourceName() == null || getResourceName().equals("")) {
			throw new Exception("Resource name cannot be empty");
		}
	}

	public void doFinish() throws InvalidRegistryURLException,
			UnknownRegistryException {
		regResourcePathData = editorInput.getResource();
		String mediaType = getMediaType();
		if (regResourcePathData == null) {
			if (PlatformMediaTypeConstants.MEDIA_TYPE_WSDL.equalsIgnoreCase(mediaType)) {
				try {
					if (isCreateGovernanceArchive()) {
						selectedMethod = methodCombo.getText();
						URL url = null;
						if (selectedMethod.equals("Upload Content From file")) {
							url = new File(getFilePath()).toURI().toURL();
						} else if (selectedMethod
								.equals("Import Content from URL")) {
							url = new URL(getResourceUrl());
						}
						if (url != null) {
							IGARImportDependency garImportDependencyImpl = GARUtils
									.getGARDependencyModel(url);
							if (!garImportDependencyImpl.isExclude()) {
								try {
									mediaType = PlatformMediaTypeConstants.MEDIA_TYPE_GAR;
									setFilePath(GARUtils.createGAR(
											garImportDependencyImpl).toString());
								} catch (Exception e) {
									throw new UnknownRegistryException(
											"Error occured while creatiing the governance archive: "
													+ e.getMessage(), e);
								}
							}
						}
					}
				} catch (MalformedURLException e) {
					log.error("MalformedURL", e);
				} catch (IOException e) {
					log.error("An IO exception has occurred", e);
				}
			}
			regResourcePathData = editorInput.getParentResource();
			registry = regResourcePathData.getConnectionInfo().getRegistry();
			String selectedPath = regResourcePathData.getRegistryResourcePath();
			selectedPath = selectedPath.endsWith("/") ? selectedPath
					: selectedPath + "/";
			Resource resource = registry.newResource();
			resource.setDescription(getDescription());
			try {
				resource.setContentStream(getFileContent(getFilePath()));
				resource.setMediaType(mediaType);
				String resourceName = selectedPath + getResourceName();
				String newPath = registry.put(resourceName, resource);
				if (!newPath.equals(resourceName)) {
					String[] pathInfo = newPath.split("/");
					if (newPath.equals("/")) {
						editorInput.getParentResource()
								.setResourceName(newPath);
					} else {
						StringBuffer sb=new StringBuffer();
						for (int i = 1; i < pathInfo.length - 1; i++) {
							if (pathInfo[i] != null && !pathInfo[i].equals("")) {
								sb.append("/").append(pathInfo[i]);
							}
						}
						RegistryResourceNode registryResourceNode = editorInput
								.getParentResource().getConnectionInfo()
								.getRegistryContainer()
								.getRegistryResourceNode(sb.toString());
						if (registryResourceNode != null) {
							editorInput.setParentResource(registryResourceNode);
							updateFormName();
						}
					}
				}
				editorInput.getParentResource().setIterativeRefresh(true);

				regResourcePathData.refreshChildren();
				regResourcePathData.getConnectionInfo().getRegUrlData()
						.refreshViewer(false);
				ArrayList<RegistryResourceNode> resourcePathList = regResourcePathData
						.getResourceNodeList();
				for (RegistryResourceNode registryResourcePathData : resourcePathList) {
					if (registryResourcePathData.getRegistryResourcePath()
							.equals(resourceName)) {
						editorInput.setResource(registryResourcePathData);
						registryResourcePathData.getVersionContent(
								registryResourcePathData.getLatestVersion(),
								getFilePath());
					}

				}
			} catch (FileNotFoundException e) {
				throw new UnknownRegistryException(
						"Error occured while trying to retrieve file content for the registry resource: "
								+ e.getMessage(), e);
			} catch (RegistryException e) {
				throw new UnknownRegistryException(
						"Error occured while trying to set registry content from file: "
								+ e.getMessage(), e);
			}
		} else {
			registry = regResourcePathData.getConnectionInfo().getRegistry();
			Resource resource = registry.get(regResourcePathData
					.getRegistryResourcePath());
			resource.setMediaType(mediaType);
			resource.setDescription(getDescription());
			registry.put(regResourcePathData.getRegistryResourcePath(),
					resource);
			regResourcePathData.getVersionContent(
					regResourcePathData.getLatestVersion(), getFilePath());
			registry.setRating(regResourcePathData.getRegistryResourcePath(), getMyRating());
		}

		syncToCurrentValues();
		refresh();
		refreshPage();
		updateDirtyState();
		if (filePathText != null && !filePathText.isDisposed()) {
			filePathText.setEnabled(false);
		}
		if (urlText != null && !urlText.isDisposed()) {
			urlText.setEnabled(false);
		}
	}

	public InputStream getFileContent(String filePath)
			throws FileNotFoundException {
		File file = new File(filePath);
		InputStream inStr = new FileInputStream(file);
		return inStr;
	}

	public String getCurrentDescription() {
		return currentDescription;
	}

	public void setCurrentDescription(String currentDescription) {
		this.currentDescription = currentDescription;
	}

	public String getCurrentMediaType() {
		return currentMediaType;
	}

	public void setCurrentMediaType(String currentMediaType) {
		this.currentMediaType = currentMediaType;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
		updateFormName();
	}

	public void fillResourceInfo(Composite container) {
		GridData gd;
		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label nameLabel = toolkit.createLabel(container, "Name: ");
		nameLabel.setLayoutData(gd);

		Label name = toolkit.createLabel(container, getResourceName());
		gd = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(gd);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label mediaTypeLabel = toolkit.createLabel(container, "Media Type: ");

		if (mediaTypeText == null) {

			ArrayList<String> mediaTypeskeySet = registry.getAllMediaTypes();

			mediaTypeText = new Combo(container, SWT.BORDER);
			loadMediaTypes(mediaTypeskeySet);

			gd = new GridData();
			gd.heightHint = 18;
			gd.widthHint = 250;
			mediaTypeText.setLayoutData(gd);
			if(getMediaType()!=null){
				mediaTypeText.setText(getMediaType());
			}
			// mediaTypeText.setLayoutData(gd);
		}

		mediaTypeText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				setMediaType(mediaTypeText.getText());
				updateDirtyState();
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label descriptionLabel = toolkit.createLabel(container, "", SWT.NULL);
		descriptionLabel.setText("Description: ");
		descriptionLabel.setLayoutData(gd);

		if (descText == null) {
			gd = new GridData();
			gd.widthHint = 250;
			gd.heightHint = 50;
			descText = toolkit.createText(container, "", SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL | SWT.WRAP);
			descText.setLayoutData(gd);
		}
		if(null!=getDescription()){
			descText.setText(getDescription());
		}

		descText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				setDescription(descText.getText());
				updateDirtyState();

			}
		});

		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy H:mm:ss");

		Label lblCreated = toolkit.createLabel(container, "Created Date: ",
				SWT.NULL);
		createdDateLabel = toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		createdDateLabel.setText("By " + getCreatedUser() + " "
				+ formatter.format(getCreatedDate()));
		createdDateLabel.setLayoutData(gd);

		Label lblLastModified = toolkit.createLabel(container,
				"Last Modified Date: ", SWT.NULL);
		lastModifedDateLabel = toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		lastModifedDateLabel.setText("By " + getLastModifiedUser() + " "
				+ formatter.format(getLastModifiedDate()));
		lastModifedDateLabel.setLayoutData(gd);

		Label lblVersion = toolkit.createLabel(container, "Current Version:",
				SWT.NULL);
		currentVersionLabel = toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		currentVersionLabel.setText(getCurrentVersion());
		currentVersionLabel.setLayoutData(gd);
		
		Label lblLifeCycle=toolkit.createLabel(container, "Current Life Cycle:",SWT.NULL);
		lifeCycle=toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		lifeCycle.setText(getCurrentLifeCycle());
		lifeCycle.setLayoutData(gd);
		
		Label lblLifeCycleState=toolkit.createLabel(container, "Life Cycle State:",SWT.NULL);
		lifeCycleState=toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		lifeCycleState.setText(getCurrentLifeCycleState());
		lifeCycleState.setLayoutData(gd);
		

//		Label lblMyRating = toolkit.createLabel(container, "My Rating:", SWT.NULL);
//		myRatingLabel = toolkit.createLabel(container, "", SWT.NULL);
//		gd = new GridData();
//		gd.heightHint = 18;
//		gd.widthHint = 350;
//		myRatingLabel.setText("" + getMyRating());
//		myRatingLabel.setLayoutData(gd);
		
		Label lblMyRatingCmb=toolkit.createLabel(container, "My Rating:",SWT.NULL);
		myRatingCombo= new Combo(container, SWT.READ_ONLY);  //toolkit.cre(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = -1;
		gd.widthHint = 310;
		myRatingCombo.setLayoutData(gd);
		String[] items={"0","1","2","3","4","5"};
		myRatingCombo.setItems(items);
		myRatingCombo.select(getMyRating());
		
		myRatingCombo.addListener(SWT.Selection, new Listener() {
			
			public void handleEvent(Event arg0) {
				setMyRating(Integer.parseInt(myRatingCombo.getText()));
//				setPageDirty(true);
				updateDirtyState();
			}
		});

		Label lblAverageRating = toolkit.createLabel(container, "Average Rating:", SWT.NULL);
		averageRatingLabel = toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		averageRatingLabel.setText("" + getAverageRating());
		averageRatingLabel.setLayoutData(gd);

		renderSaveButton(container);
	}

	public String getCurrentLifeCycle() {
		return this.currentlifeCycle;
	}
	
	public void setCurrentLifeCycle(String currentLifeCycle ){
		this.currentlifeCycle = currentLifeCycle;
	}
	
	
	public String getCurrentLifeCycleState() {
		return this.currentlifeCycleState;
	}
	
	public void setCurrentLifeCycleState(String currentLifeCycleState ){
		this.currentlifeCycleState = currentLifeCycleState;
	}

	public void executeAction(int actionID, Object object) {
		switch (actionID) {
		case IRegistryFormEditorPage.ACTION_VIEW_INFORMATION:
			setFocusToEditor();
			break;
		}
	}

	public void setFocusToEditor() {
		this.setFocus();
	}

	public int getPageType() {
		return IRegistryFormEditorPage.PAGE_RESOURCE;
	}

	public void setPageDirty(boolean pageDirty) {
		this.pageDirty = pageDirty;
		editor.updateDirtyState();
	}

	public boolean isPageDirty() {
		return pageDirty;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateGovernanceArchive(boolean createGovernanceArchive) {
		this.createGovernanceArchive = createGovernanceArchive;
	}

	public boolean isCreateGovernanceArchive() {
		return createGovernanceArchive;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param lastModifiedDate
	 *            the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param createdUser
	 *            the createdUser to set
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * @return the createdUser
	 */
	public String getCreatedUser() {
		return createdUser;
	}

	/**
	 * @param lastModifiedUser
	 *            the lastModifiedUser to set
	 */
	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	/**
	 * @return the lastModifiedUser
	 */
	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	/**
	 * @param currentVersion
	 *            the currentVersion to set
	 */
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

	/**
	 * @return the currentVersion
	 */
	public String getCurrentVersion() {
		return currentVersion;
	}

	/**
     * @param myRating the myRating to set
     */
    public void setMyRating(int myRating) {
	    this.myRating = myRating;
    }

	/**
     * @return the myRating
     */
    public int getMyRating() {
	    return myRating;
    }

	/**
     * @param averageRating the averageRating to set
     */
    public void setAverageRating(float averageRating) {
	    this.averageRating = averageRating;
    }

	/**
     * @return the averageRating
     */
    public float getAverageRating() {
	    return averageRating;
    }

	/**
     * @param myRatingCombo the myRatingCombo to set
     */
    public void setMyRatingCombo(Combo myRatingCombo) {
	    this.myRatingCombo = myRatingCombo;
    }

	/**
     * @return the myRatingCombo
     */
    public Combo getMyRatingCombo() {
	    return myRatingCombo;
    }

	/**
     * @param currentMyRating the currentMyRating to set
     */
    public void setCurrentMyRating(int currentMyRating) {
	    this.currentMyRating = currentMyRating;
    }

	/**
     * @return the currentMyRating
     */
    public int getCurrentMyRating() {
	    return currentMyRating;
    }
    
    /**
     * Resetting variable values.
     */
    private void resetFormDataValues(){
    	resourceName = "";
    	mediaType = "";
    	description = "";
    	myRating = 0;
    }
}
