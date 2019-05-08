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

package org.wso2.developerstudio.eclipse.platform.ui.utils;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractComposite;
import org.wso2.developerstudio.eclipse.platform.core.model.ICompositeProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.IFieldControlData;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.IOnAction;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.UIControl;
import org.wso2.developerstudio.eclipse.platform.ui.startup.RegisterUIControl;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WSO2UIToolkit {

	public static Button createOption(Composite container, String label, int columns, Integer verticalIndent,
	                                  Integer horizontalIndent) {
		Button optButton = new Button(container, SWT.RADIO);
		optButton.setText(label);
		if (columns != -1) {
			GridData gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			optButton.setLayoutData(gridData);
		}
		return optButton;
	}

	public static Button createChoice(Composite container, String label, int columns, Integer verticalIndent,
	                                  Integer horizontalIndent) {
		Button chkButton = new Button(container, SWT.CHECK);
		chkButton.setText(label);
		if (columns != -1) {
			GridData gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			chkButton.setLayoutData(gridData);
		}
		return chkButton;
	}

	public static Combo createCombo(Composite container, String label, int columns, boolean isEditable,
	                                Integer verticalIndent, Integer horizontalIndent) {
		final Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		final Combo cmbValue = new Combo(container, isEditable ? SWT.BORDER : SWT.BORDER | SWT.READ_ONLY);
		propagateControlStatus(cmbValue, lblCaption);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 1;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			cmbValue.setLayoutData(gridData);
		}
		return cmbValue;
	}

	public static CheckboxTableViewer createList(Composite container, String label, int columns,
	                                             Integer verticalIndent, Integer horizontalIndent,
	                                             boolean isSelectAllbtn, final ProjectOptionsDataPage dataPage,
	                                             final ProjectOptionData optionData) {
		final Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		if (columns != -1) {
			GridData gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			// gridData.heightHint = 30;
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			lblCaption.setLayoutData(gridData);
		}

		final CheckboxTableViewer cmbValue =
		                                     CheckboxTableViewer.newCheckList(container, SWT.BORDER |
		                                                                                 SWT.FULL_SELECTION);

		if (columns != -1) {
			GridData gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.verticalSpan = 5;
			gridData.horizontalIndent = 10;
			gridData.heightHint = 50;
			if (horizontalIndent != null) {
				gridData.horizontalIndent += horizontalIndent;
			}
			gridData.grabExcessHorizontalSpace = true;
			gridData.grabExcessVerticalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			gridData.verticalAlignment = SWT.FILL;
			cmbValue.getTable().setLayoutData(gridData);
		}

		if (isSelectAllbtn) {

			Label splabel = new Label(container, SWT.NONE);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = columns - 3;
			splabel.setLayoutData(gd);
			splabel.setText("");

			Button selectAllButton = new Button(container, SWT.NONE);
			GridData gdb = new GridData(GridData.END);
			gdb.horizontalSpan = 1;
			selectAllButton.setLayoutData(gdb);
			selectAllButton.setText("Select All");
			selectAllButton.addListener(SWT.MouseDown, new Listener() {
				public void handleEvent(Event evt) {
					cmbValue.setAllChecked(true);
					dataPage.updateListCheckBox(optionData, cmbValue.getCheckedElements());
				}
			});
			Button unSelectAllButton = new Button(container, SWT.NONE);
			unSelectAllButton.setText("Deselect All");
			unSelectAllButton.addListener(SWT.MouseDown, new Listener() {
				public void handleEvent(Event evt) {
					cmbValue.setAllChecked(false);
					dataPage.updateListCheckBox(optionData, cmbValue.getCheckedElements());
				}
			});
			if (columns != -1) {

				GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
				gridData.horizontalSpan = 2;
				gridData.grabExcessHorizontalSpace = false;
				gridData.horizontalAlignment = SWT.RIGHT;
				// gridData.verticalAlignment = SWT.columns
				if (verticalIndent != null) {
					gridData.verticalIndent = verticalIndent;
				}
				if (horizontalIndent != null) {
					gridData.horizontalIndent = horizontalIndent;
				}
				selectAllButton.setLayoutData(gridData);

				gridData = new GridData();
				gridData.horizontalSpan = columns;
				gridData.grabExcessHorizontalSpace = false;
				gridData.horizontalAlignment = SWT.FILL;
				// gridData.verticalAlignment = SWT.columns
				if (verticalIndent != null) {
					gridData.verticalIndent = verticalIndent;
				}
				if (horizontalIndent != null) {
					gridData.horizontalIndent = horizontalIndent;
				}
				unSelectAllButton.setLayoutData(gdb);
			}
			propagateControlStatus(cmbValue.getTable(), lblCaption, selectAllButton, unSelectAllButton);
		} else {

			propagateControlStatus(cmbValue.getTable(), lblCaption);
		}
		return cmbValue;
	}

	public static Link createLink(Composite container, String label, int columns, int horizontalAlignment,
	                              Integer verticalIndent, Integer horizontalIndent) {
		Link linkButton = new Link(container, SWT.CHECK);
		linkButton.setText(label);
		if (columns != -1) {
			GridData gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = horizontalAlignment; // SWT.FILL;
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			linkButton.setLayoutData(gridData);
		}
		return linkButton;
	}

	public static Label createLabel(Composite container, String label, int columns, int horizontalAlignment,
	                                Integer verticalIndent, Integer horizontalIndent) {
		Label lbl = new Label(container, SWT.CHECK);
		lbl.setText(label);
		if (columns != -1) {
			GridData gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = horizontalAlignment; // SWT.FILL;
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			lbl.setLayoutData(gridData);
		}
		return lbl;
	}

	public static Label createTitleLabel(Composite container, String label, int columns, int horizontalAlignment,
	                                     Integer verticalIndent, Integer horizontalIndent) {
		Label lblCaption = new Label(container, SWT.CHECK);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		Label lbl = new Label(container, SWT.CHECK);
		lbl.setText(label);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 1;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = horizontalAlignment; // SWT.FILL;
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			lbl.setLayoutData(gridData);
		}
		propagateControlStatus(lbl, lblCaption);
		return lbl;
	}

	public static IFieldControlData createRegistryBrowserControl(String id, Composite container, int columns,
	                                                             Integer verticalIndent, Integer horizontalIndent,
	                                                             boolean isTextReadonly, final Shell shell,
	                                                             final String label, String fileButtonCaption,
	                                                             int selectedOption, ProjectDataModel model,
	                                                             String pathBindingProperty) {
		IFieldControlData fieldControl = null;
		Map<String, UIControl> uiControlList = RegisterUIControl.getUiControlList();
		for (Entry<String, UIControl> entry1 : uiControlList.entrySet()) {

			UIControl uiControl = entry1.getValue();
			String uiID = entry1.getKey();
			if (id.equals("registry.browser") && uiID.equals("RegistryBrowserUIControl")) {
				fieldControl =
				               uiControl.createUIField(id, container, columns, verticalIndent, horizontalIndent,
				                                       isTextReadonly, shell, label, fileButtonCaption, selectedOption,
				                                       model, pathBindingProperty);
				break;
			}
		}
		return fieldControl;
	}

	public static IFieldControlData createResourceBrowserControl(String id, Composite container, int columns,
	                                                             Integer verticalIndent, Integer horizontalIndent,
	                                                             boolean isTextReadonly, final Shell shell,
	                                                             final String label, String fileButtonCaption,
	                                                             int selectedOption, ProjectDataModel model,
	                                                             String pathBindingProperty) {
		IFieldControlData fieldControl = null;
		Map<String, UIControl> uiControlList = RegisterUIControl.getUiControlList();
		for (Entry<String, UIControl> entry1 : uiControlList.entrySet()) {

			UIControl uiControl = entry1.getValue();
			String uiID = entry1.getKey();
			if (id.equals("resource.browser") && uiID.equals("ResourceBrowserUIStrip")) {
				fieldControl =
				               uiControl.createUIField(id, container, columns, verticalIndent, horizontalIndent,
				                                       isTextReadonly, shell, label, fileButtonCaption, selectedOption,
				                                       model, pathBindingProperty);
				break;
			}
		}
		return fieldControl;
	}

	public static IFieldControlData createComposite(Composite container, int columns,
	                                                final ICompositeProvider iCompositeProvider,
	                                                ProjectDataModel model, ProjectOptionData optionData,
	                                                WizardPage wizardPage) {

		AbstractComposite composite = iCompositeProvider.createComposite(container, model, optionData, wizardPage);

		GridData gridData = new GridData();
		if (null != optionData.getVerticalIndent()) {
			gridData.verticalIndent = optionData.getVerticalIndent();
		}
		if (null != optionData.getHorizontalIndent()) {
			gridData.horizontalIndent = optionData.getHorizontalIndent();
		}
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			gridData.heightHint = -1;
			gridData.grabExcessVerticalSpace = true;

		}
		composite.setLayoutData(gridData);

		FieldControlDataImpl fieldControl = new FieldControlDataImpl(composite) {

			public Composite getControl() {
				return (Composite) super.getControl();
			}

			public void setData(Object data) {
				getControl().setData(data);
			}

			public Object getData() {
				return getControl().getData();
			}

		};
		propagateControlStatus(composite);
		return fieldControl;
	}

	public static IFieldControlData createText(Composite container, String label, int columns, boolean isTextReadonly,
	                                           Integer verticalIndent, Integer horizontalIndent, boolean multiline,
	                                           boolean addlistner, final AbstractWSO2ProjectCreationWizard wizard,
	                                           String toolTip, int height) {
		int flags = (multiline) ? (SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL) : SWT.BORDER;
		Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		Text txtValue = new Text(container, flags);;
		txtValue.setEditable(!isTextReadonly);
		propagateControlStatus(txtValue, lblCaption);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 1;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			if (multiline) {
				height = (height > 0) ? height : 65;
				gridData.heightHint = height;
				gridData.grabExcessVerticalSpace = true;
			}
			txtValue.setLayoutData(gridData);
		}
		if (toolTip != null) {
			txtValue.setToolTipText(toolTip);
		}
		if (addlistner) {
			wizard.setMap(label.trim(), txtValue);
		}
		FieldControlDataImpl feildControl = createFieldControlForString(txtValue);
		return feildControl;
	}

	private static FieldControlDataImpl createFieldControlForString(Text txtValue) {
		FieldControlDataImpl feildControl = new FieldControlDataImpl(txtValue) {

			public Text getControl() {
				return (Text) super.getControl();
			}

			public Object getData() {
				return getControl().getText();
			}

			public void setData(Object data) {
				if (data == null) {
					data = "";
				}
				getControl().setText(data.toString());
			}

			public void setOnAction(IOnAction action) {
				super.setOnAction(action);
				getControl().addModifyListener(new ModifyListener() {

					public void modifyText(ModifyEvent arg0) {
						getOnAction().onModifyAction();

					}

				});
			}

		};
		return feildControl;
	}

	public static void createLine(Composite container, int columns, Integer verticalIndent, Integer horizontalIndent) {
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		if (columns != -1) {
			GridData gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			label.setLayoutData(gridData);
		}
	}

	public static Composite createContainer(final Composite container, String label, int columns,
	                                        boolean isCollapsible, boolean isExpanded, Integer verticalIndent,
	                                        Integer horizontalIndent) {
		Composite composite;
		if (label == null) {
			createLine(container, columns, verticalIndent, horizontalIndent);
			verticalIndent = null;
			composite = new Composite(container, SWT.NONE);
		} else {
			if (isCollapsible) {
				ExpandableComposite expandableComposite = new ExpandableComposite(container, SWT.BOLD);
				expandableComposite.setText(label);
				expandableComposite.setFont(new Font(container.getDisplay(), "Sans", 8, SWT.BOLD));
				expandableComposite.setExpanded(isExpanded);
				GridData gridData = new GridData();
				gridData.horizontalSpan = columns;
				gridData.grabExcessHorizontalSpace = true;
				if (verticalIndent != null) {
					gridData.verticalIndent = verticalIndent;
					verticalIndent = null;
				}
				gridData.horizontalAlignment = SWT.FILL;
				expandableComposite.setLayoutData(gridData);
				composite = new Composite(expandableComposite, SWT.NONE);
				expandableComposite.setClient(composite);
				expandableComposite.addExpansionListener(new ExpansionAdapter() {

					public void expansionStateChanged(ExpansionEvent e) {
						layout(container);
					}
				});
			} else {
				composite = new Group(container, SWT.NONE);
				((Group) composite).setText(label);
			}
		}
		if (columns != -1) {
			GridData gridData = new GridData();
			gridData.horizontalSpan = columns;
			gridData.grabExcessHorizontalSpace = true;
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			gridData.horizontalAlignment = SWT.FILL;
			gridData.verticalIndent = 10;
			composite.setLayoutData(gridData);
		}
		return composite;
	}

	public static IFieldControlData createFileDirectoryBrowser(Composite container, final Shell shell,
	                                                           final String label, final String filter,
	                                                           boolean isTextReadonly, String fileButtonCaption,
	                                                           String dirButtonCaption, int columns,
	                                                           Integer verticalIndent, Integer horizontalIndent) {
		Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		final Text txtValue = new Text(container, SWT.BORDER);
		txtValue.setEditable(!isTextReadonly);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 3;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			txtValue.setLayoutData(gridData);
		}
		Button btnFileBrowse = addFileBrowseButton(container, shell, label, filter, fileButtonCaption, txtValue);
		Button btnDirBrowse = addDirBrowseButton(container, shell, label, dirButtonCaption, txtValue);
		propagateControlStatus(txtValue, lblCaption, btnFileBrowse, btnDirBrowse);
		FileldControlTextDataImple feildControl = createFileBrowserFieldController(txtValue);
		return feildControl;
	}

	private static FileldControlTextDataImple createFileBrowserFieldController(final Text txtValue) {
		FileldControlTextDataImple feildControl = new FileldControlTextDataImple(txtValue) {

			//
			// public Text getControl() {
			// return (Text)super.getControl();
			// }

			public void setData(Object data) {
				if (data == null) {
					data = "";
				}
				getControl().setText(data.toString());

			}

			public Object getData() {
				return new File(getControl().getText());
			}
		};
		return feildControl;
	}

	public static Text createWorkspaceFileBrowser(Composite container, final Shell shell, final String label,
	                                              boolean isTextReadonly, String buttonCaption, int columns,
	                                              final ViewerFilter viewerFilter, Integer verticalIndent,
	                                              Integer horizontalIndent) {
		Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		final Text txtValue = new Text(container, SWT.BORDER);
		txtValue.setEditable(!isTextReadonly);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 2;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			txtValue.setLayoutData(gridData);
		}
		Button btnFileBrowse = new Button(container, SWT.None);
		btnFileBrowse.setText(buttonCaption);
		btnFileBrowse.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent event) {
				List<ViewerFilter> viewerFilters = null;
				if (viewerFilter == null) {
					viewerFilters = new ArrayList<ViewerFilter>();
				} else {
					viewerFilters = Arrays.asList(new ViewerFilter[] { viewerFilter });
				}
				IFile[] openFileSelection =
				                            WorkspaceResourceDialog.openFileSelection(shell, "Select file...", label,
				                                                                      false, new Object[] {},
				                                                                      viewerFilters);
				if (openFileSelection != null) {
					txtValue.setText(openFileSelection[0].getFullPath().toPortableString().substring(1));
				}
			}

			public void widgetSelected(SelectionEvent event) {
				widgetDefaultSelected(event);
			}
		});
		propagateControlStatus(txtValue, lblCaption, btnFileBrowse);
		return txtValue;
	}

	public static Text createWorkspaceFolderBrowser(Composite container, final Shell shell, final String label,
	                                                boolean isTextReadonly, String buttonCaption, int columns,
	                                                final ViewerFilter viewerFilter, Integer verticalIndent,
	                                                Integer horizontalIndent) {
		Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		final Text txtValue = new Text(container, SWT.BORDER);
		txtValue.setEditable(!isTextReadonly);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 2;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			txtValue.setLayoutData(gridData);
		}
		Button btnFileBrowse = new Button(container, SWT.None);
		btnFileBrowse.setText(buttonCaption);
		btnFileBrowse.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent event) {
				List<ViewerFilter> viewerFilters = null;
				if (viewerFilter == null) {
					viewerFilters = new ArrayList<ViewerFilter>();
				} else {
					viewerFilters = Arrays.asList(new ViewerFilter[] { viewerFilter });
				}
				IContainer[] openFolderSelection =
				        WorkspaceResourceDialogExtended.openFolderSelection(shell,
				                                                                               "Select folder...",
				                                                                               label, false,
				                                                                               new Object[] {},
				                                                                               viewerFilters);
				if (openFolderSelection != null && openFolderSelection.length != 0) {
					txtValue.setText(openFolderSelection[0].getFullPath().toPortableString().substring(1));
				}
			}

			public void widgetSelected(SelectionEvent event) {
				widgetDefaultSelected(event);
			}
		});
		propagateControlStatus(txtValue, lblCaption, btnFileBrowse);
		return txtValue;
	}

	public static Text createWorkspaceBrowser(Composite container, final Shell shell, final String label,
	                                          boolean isTextReadonly, String buttonCaption, int columns,
	                                          final ViewerFilter viewerFilter, Integer verticalIndent,
	                                          Integer horizontalIndent) {
		Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		final Text txtValue = new Text(container, SWT.BORDER);
		txtValue.setEditable(!isTextReadonly);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 2;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			txtValue.setLayoutData(gridData);
		}
		Button btnFileBrowse = new Button(container, SWT.None);
		btnFileBrowse.setText(buttonCaption);
		btnFileBrowse.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent event) {
				// TODO
			}

			public void widgetSelected(SelectionEvent event) {
				widgetDefaultSelected(event);
			}
		});
		propagateControlStatus(txtValue, lblCaption, btnFileBrowse);
		return txtValue;
	}
	
	public static Text createWorkspacePathBrowser(Composite container, final Shell shell,
	        final String label, boolean isTextReadonly, String buttonCaption, int columns,
	        final ViewerFilter viewerFilter, Integer verticalIndent, Integer horizontalIndent) {
		
		Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		final Text txtValue = new Text(container, SWT.BORDER);
		txtValue.setEditable(!isTextReadonly);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 2;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			txtValue.setLayoutData(gridData);
		}
		Button btnFileBrowse = new Button(container, SWT.None);
		btnFileBrowse.setText(buttonCaption);
		btnFileBrowse.addSelectionListener(new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent event) {
				List<ViewerFilter> viewerFilters = null;
				if (viewerFilter == null) {
					viewerFilters = new ArrayList<ViewerFilter>();
				} else {
					viewerFilters = Arrays.asList(new ViewerFilter[] { viewerFilter });
				}
			
				Map<String,List<String>> filters = new HashMap<String,List<String>>();
				DeveloperStudioRegistryResourceProviderDialog dialog = new DeveloperStudioRegistryResourceProviderDialog(shell, new Class[]{IDeveloperStudioElement.class},filters);
				dialog.create();
				dialog.getShell().setText("Copy deploy path from existing resource");
				dialog.open();
				String selectedPath = dialog.getSelectedPath();
              	if (selectedPath != null && !selectedPath.isEmpty()) {
              		int lastIndexOfSlash = selectedPath.lastIndexOf("/");
              		selectedPath = selectedPath.substring(0, lastIndexOfSlash);
              		if(selectedPath.startsWith("/_system/governance/")) {
              			selectedPath = selectedPath.substring("/_system/governance/".length());
              		}
              		else if(selectedPath.startsWith("/_system/config/")) {
              			selectedPath = selectedPath.substring("/_system/config/".length());
              		}
					txtValue.setText(selectedPath);
				}
			}
			
			public void widgetSelected(SelectionEvent event) {
				widgetDefaultSelected(event);
			}
		});
		propagateControlStatus(txtValue, lblCaption, btnFileBrowse);
		return txtValue;
	}

	public static IFieldControlData createFileBrowser(Composite container, final Shell shell, final String label,
	                                                  final String filter, boolean isTextReadonly,
	                                                  String buttonCaption, int columns, Integer verticalIndent,
	                                                  Integer horizontalIndent) {
		Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		final Text txtValue = new Text(container, SWT.BORDER);
		txtValue.setEditable(!isTextReadonly);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 2;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			txtValue.setLayoutData(gridData);
		}
		Button btnFileBrowse = addFileBrowseButton(container, shell, label, filter, buttonCaption, txtValue);
		propagateControlStatus(txtValue, lblCaption, btnFileBrowse);
		FieldControlDataImpl feildControl = createFileBrowserFieldController(txtValue);
		return feildControl;
	}

	private static Button addFileBrowseButton(Composite container, final Shell shell, final String label,
	                                          final String filter, String buttonCaption, final Text txtValue) {
		Button btnFileBrowse = new Button(container, SWT.None);
		btnFileBrowse.setText(buttonCaption);
		btnFileBrowse.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent event) {
				FileDialog fileDialog = new FileDialog(shell);
				fileDialog.setFilterExtensions(filter.split(","));
				// fileDialog.setFilterPath(txtValue.getText());
				fileDialog.setText(label);
				if (fileDialog.open() != null) {
					String fileName = new File(fileDialog.getFilterPath(), fileDialog.getFileName()).toString();
					txtValue.setText(fileName);
				}
			}

			public void widgetSelected(SelectionEvent event) {
				widgetDefaultSelected(event);
			}
		});
		return btnFileBrowse;
	}

	public static IFieldControlData createDirectoryBrowser(Composite container, final Shell shell, final String label,
	                                                       boolean isTextReadonly, String buttonCaption, int columns,
	                                                       Integer verticalIndent, Integer horizontalIndent) {
		Label lblCaption = new Label(container, SWT.None);
		lblCaption.setText(label);
		GridData gridData = new GridData();
		if (verticalIndent != null) {
			gridData.verticalIndent = verticalIndent;
		}
		if (horizontalIndent != null) {
			gridData.horizontalIndent = horizontalIndent;
		}
		lblCaption.setLayoutData(gridData);
		final Text txtValue = new Text(container, SWT.BORDER);
		txtValue.setEditable(!isTextReadonly);
		if (columns != -1) {
			gridData = new GridData();
			gridData.horizontalSpan = columns - 2;
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = SWT.FILL;
			txtValue.setLayoutData(gridData);
		}
		Button btnDirBrowse = addDirBrowseButton(container, shell, label, buttonCaption, txtValue);
		propagateControlStatus(txtValue, lblCaption, btnDirBrowse);
		FieldControlDataImpl feildControl = createFileBrowserFieldController(txtValue);
		return feildControl;
	}

	private static Button addDirBrowseButton(Composite container, final Shell shell, final String label,
	                                         String buttonCaption, final Text txtValue) {
		Button btnDirBrowse = new Button(container, SWT.None);
		btnDirBrowse.setText(buttonCaption);
		btnDirBrowse.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent event) {
				DirectoryDialog dirDialog = new DirectoryDialog(shell);
				// dirDialog.setFilterPath(txtValue.getText());
				dirDialog.setText(label);
				String path = dirDialog.open();
				if (path != null) {
					// String fileName = new File(dirDialog.getFilterPath(),
					// path).toString();
					txtValue.setText(path);
				}
			}

			public void widgetSelected(SelectionEvent event) {
				widgetDefaultSelected(event);
			}
		});
		return btnDirBrowse;
	}

	public static void propagateControlStatus(Control watchControl, Control... controls) {
		propagateEnability(watchControl, controls);
		propagateVisibility(watchControl, controls);
	}

	private static void propagateEnability(final Control watchControl, final Control... controls) {
		watchControl.addPaintListener(new PaintListener() {

			public void paintControl(PaintEvent event) {
				for (Control control : controls) {
					control.setEnabled(watchControl.getEnabled());
				}
			}
		});
	}

	private static Map<Control, Control[]> visibilityControls = new HashMap<Control, Control[]>();

	public static void updateControlVisibilityStatus(Control watchControl) {
		if (visibilityControls.containsKey(watchControl)) {
			Control[] controls = visibilityControls.get(watchControl);
			if (watchControl.isDisposed()) {
				visibilityControls.remove(watchControl);
			} else {
				boolean visibleField = watchControl.getVisible();
				for (Control control : controls) {
					Object layoutData = control.getLayoutData();
					if (layoutData == null) {
						layoutData = new GridData();
					}
					if (layoutData instanceof GridData) {
						((GridData) layoutData).exclude = !visibleField;
						control.setLayoutData(layoutData);
					}
					control.setVisible(visibleField);
				}
				layout(watchControl.getParent());
			}
		}
	}

	private static void propagateVisibility(final Control watchControl, final Control... controls) {
		visibilityControls.put(watchControl, controls);
		watchControl.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent arg0) {
				visibilityControls.remove(watchControl);
			}
		});
	}

	public static void layout(final Composite container) {
		Composite parentLayout = container;
		while (parentLayout != null) {
			parentLayout.layout();
			parentLayout = parentLayout.getParent();
		}
	}

	private static abstract class FileldControlTextDataImple extends FieldControlDataImpl {

		public FileldControlTextDataImple(Control control) {
			super(control);
		}

		public Text getControl() {
			return (Text) super.getControl();
		}

		public void setOnAction(IOnAction action) {
			super.setOnAction(action);
			getControl().addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent arg0) {
					getOnAction().onModifyAction();

				}

			});
		}

	}

	private static abstract class FieldControlDataImpl implements IFieldControlData {
		private Control control = null;
		private IOnAction onAction;

		public void setOnAction(IOnAction action) {
			this.onAction = action;
		}

		public IOnAction getOnAction() {
			return onAction;
		}

		public FieldControlDataImpl(Control control) {
			this.setControl(control);
		}

		public Control getControl() {
			return control;
		}

		public void setControl(Control control) {
			this.control = control;
		}

	}
}
