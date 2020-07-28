/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.updater.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.DeveloperPreferencePage;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.job.UpdateMetaFileReaderJob;
import org.wso2.developerstudio.eclipse.updater.model.EnhancedFeature;

public class UpdaterDialog extends Dialog {

	private static final String CANCEL_BTN_TXT = Messages.UpdaterDialog_0;
	private static final String VERSION_LABEL = Messages.UpdaterDialog_1;
	private static final String INSTALL_BTN_TXT = Messages.UpdaterDialog_2;
	private static final String FILE_PROTOCOL = "file:"; //$NON-NLS-1$
	private static final String TITLE = Messages.UpdaterDialog_4;
	private static final String UPDATES_TAB_TITLE = Messages.UpdaterDialog_5;
	private static final String ALL_FEATURES_TAB_TITLE = Messages.UpdaterDialog_6;

	private UpdateManager updateManager;
	private ActiveTab activeTab;
	protected List<EnhancedFeature> selectedFeatures;
	protected List<EnhancedFeature> selectedUpdates;
	private Button installBtn;
	private Dialog dialog;
	private TabFolder tabFolder;
	private ArrayList<SelectableFeatureButton> featureButtons = new ArrayList<SelectableFeatureButton>();

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	public enum ActiveTab {
		ALL_FEATURES, UPDATE_FEATURES
	}

	public UpdaterDialog(UpdateManager updateManager, ActiveTab activeTab) {
		super(Display.getDefault().getActiveShell());
		this.dialog = this;
		this.activeTab = activeTab;
		this.updateManager = updateManager;
		this.selectedFeatures = new ArrayList<>();
		this.selectedUpdates = new ArrayList<>();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite topContainer = createTopContainer(parent);
		Composite leftContainer = createSubColumnContainer(topContainer);
		
		// Add select all button
		Button selectAllButton = new Button(topContainer, SWT.CHECK);
		selectAllButton.setText("Select All Updates");

		SelectionListener selectionListener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Button button = ((Button) event.widget);
				if (button.getSelection()) {
					for (SelectableFeatureButton tempButton : featureButtons) {
						tempButton.getCheckBox().setSelection(true);
						if (tabFolder.getSelection()[0].getText().equals(ALL_FEATURES_TAB_TITLE)) {
							selectedFeatures.add(tempButton.getFeature());
							installBtn.setEnabled(!selectedFeatures.isEmpty());
						} else {
							selectedUpdates.add(tempButton.getFeature());
							installBtn.setEnabled(!selectedUpdates.isEmpty());
						}
					}
				} else {
					for (SelectableFeatureButton tempButton : featureButtons) {
						tempButton.getCheckBox().setSelection(false);
						if (tabFolder.getSelection()[0].getText().equals(ALL_FEATURES_TAB_TITLE)) {
							selectedFeatures.remove(tempButton.getFeature());
							installBtn.setEnabled(!selectedFeatures.isEmpty());
						} else {
							selectedUpdates.remove(tempButton.getFeature());
							installBtn.setEnabled(!selectedUpdates.isEmpty());
						}
					}
				}
			};
		};
		selectAllButton.addSelectionListener(selectionListener);
		
		tabFolder = createLeftContainerTabFolder(leftContainer);
		createFeatureItemsInTabFolder(tabFolder);
		if (activeTab == ActiveTab.ALL_FEATURES) {
			tabFolder.setSelection(0);
		} else {
			tabFolder.setSelection(1);
		}
		return topContainer;
	}

	private void createFeatureItemsInTabFolder(TabFolder tabFolder) {
		createFeatureListTab(tabFolder, ActiveTab.ALL_FEATURES);
		createFeatureListTab(tabFolder, ActiveTab.UPDATE_FEATURES);
	}

	private void createFeatureListTab(TabFolder tabFolder, ActiveTab type) {
		TabItem tabItem = new TabItem(tabFolder, SWT.NULL);
		if (type == ActiveTab.ALL_FEATURES) {
			tabItem.setText(ALL_FEATURES_TAB_TITLE);
		} else {
			tabItem.setText(UPDATES_TAB_TITLE);
		}
		ScrolledComposite scroll = new ScrolledComposite(tabFolder, SWT.V_SCROLL | SWT.H_SCROLL);
		scroll.setLayout(new GridLayout());
		scroll.setLayoutData(new GridData());

		Group group = new Group(scroll, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData());
		listFeatures(group, type);
		scroll.setContent(group);
		scroll.setExpandHorizontal(true);
		scroll.setExpandVertical(true);
		scroll.setMinSize(group.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		tabItem.setControl(scroll);
	}

	private TabFolder createLeftContainerTabFolder(Composite leftContainer) {
		GridData tabGridData = new GridData();
		tabGridData.horizontalAlignment = GridData.FILL;
		tabGridData.verticalAlignment = GridData.FILL;
		tabGridData.horizontalSpan = 3;
		tabGridData.verticalSpan = 7;
		tabGridData.grabExcessVerticalSpace = true;
		tabGridData.heightHint = 600;
		tabGridData.widthHint = 700;

		final TabFolder tabFolder = new TabFolder(leftContainer, SWT.CHECK | SWT.BORDER | SWT.H_SCROLL);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				if (installBtn != null) {
					if (tabFolder.getSelection()[0].getText().equals(ALL_FEATURES_TAB_TITLE) && selectedFeatures != null) {
						installBtn.setEnabled(!selectedFeatures.isEmpty());
					} else if (tabFolder.getSelection()[0].getText().equals(UPDATES_TAB_TITLE) && selectedUpdates != null) {
						installBtn.setEnabled(!selectedUpdates.isEmpty());
					}
				}
			}
		});
		tabFolder.setLayoutData(tabGridData);
		tabFolder.setSize(400, 420);
		return tabFolder;
	}

	private Composite createSubColumnContainer(final Composite topContainer) {
		Composite leftContainer = new Composite(topContainer, SWT.NONE);
		leftContainer.setLayout(new GridLayout(1, false));
		GridData leftContainerGridData = new GridData(GridData.FILL_BOTH);
		leftContainer.setLayoutData(leftContainerGridData);
		return leftContainer;
	}

	private Composite createTopContainer(Composite parent) {
		final Composite topContainer = new Composite(parent, SWT.NONE);
		GridData topContainerGridData = new GridData(GridData.FILL_BOTH);
		topContainerGridData.heightHint = 600;
		topContainer.setLayoutData(topContainerGridData);
		GridLayout topContainerGridLayout = new GridLayout();
		topContainerGridLayout.numColumns = 1;
		topContainerGridLayout.makeColumnsEqualWidth = true;
		topContainer.setLayout(topContainerGridLayout);
		return topContainer;
	}

	private void listFeatures(Group group, ActiveTab tab) {
		IPreferenceStore prefPage = PlatformUI.getPreferenceStore();
		boolean showHiddenFeatures = prefPage.getBoolean(DeveloperPreferencePage.SHOW_HIDDEN_FEATURES);

		Iterator<Entry<String, EnhancedFeature>> featureList;
		if (tab == ActiveTab.ALL_FEATURES) {
			featureList = updateManager.getAvailableFeaturesMap().entrySet().iterator();
		} else {
			featureList = updateManager.getPossibleUpdatesMap().entrySet().iterator();
		}
		while (featureList.hasNext()) {
			EnhancedFeature feature = featureList.next().getValue();
			// set isKernelFeature=true or isHidden=true in update.properties
			// file in features to
			// ignore them in available Features tab
			if (tab == ActiveTab.ALL_FEATURES && !showHiddenFeatures) {
				if (feature.isKernelFeature() || feature.isHidden()) {
					continue;
				}
			}
			GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
			final Group featureGroup = createFeatureRepresentationGroup(group, gridData);
			createCheckBoxInFeatureGroup(feature, featureGroup, tab);

			Label featureImageLabel = new Label(featureGroup, SWT.NONE);
			try {
				Image image = new Image(Display.getDefault(), feature.getIconURL().replace(FILE_PROTOCOL, "")); //$NON-NLS-1$
				featureImageLabel.setImage(image);
			} catch (Exception ex) {
				log.warn(Messages.UpdaterDialog_8 + feature.getId(), ex);
			}
			final Group featureInfoGroup = createFeatureInfoRepresentationGroup(featureGroup);
			StyledText featureName = createFeatureNameText(feature, featureInfoGroup);
			FontData fontData = featureName.getFont().getFontData()[0];
			Font font = new Font(featureInfoGroup.getDisplay(),
					new FontData(fontData.getName(), fontData.getHeight() + 1, SWT.BOLD));
			featureName.setFont(font);
			createFeatureNewVersionText(feature, featureInfoGroup);
			if (feature.isUpdateFeature() && feature.getWhatIsNew() != null && !feature.getWhatIsNew().isEmpty()) {
				createFeatureDescr(feature.getWhatIsNew(), feature.getBugFixes(), featureInfoGroup);
			}
		}
	}

	private void createFeatureDescr(final String featureDescrpTxt, final String bugFixes, final Group featureInfoGroup) {
			StyledText featuredescription = new StyledText(featureInfoGroup, SWT.WRAP);
			featuredescription.setText(featureDescrpTxt);
			if (bugFixes != null && !bugFixes.isEmpty()) {
				StyledText featuredJira = new StyledText(featureInfoGroup, SWT.WRAP);
				String displayTxt = Messages.UpdaterDialog_9 + bugFixes;
				featuredJira.setText(displayTxt);
				StyleRange style = new StyleRange();
				style.underline = true;
				style.underlineStyle = SWT.UNDERLINE_LINK;

				int[] ranges = {displayTxt.indexOf(bugFixes), bugFixes.length()};
				StyleRange[] styles = {style};
				featuredJira.setStyleRanges(ranges, styles);
				featuredJira.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseUp(MouseEvent arg0) {
					}
					
					@Override
					public void mouseDown(MouseEvent arg0) {
						openLinkInDefaultBrowser(bugFixes);
					}

					@Override
					public void mouseDoubleClick(MouseEvent arg0) {
						openLinkInDefaultBrowser(bugFixes);
					}
					
					private void openLinkInDefaultBrowser(final String bugFixes) {
						try {
							PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(bugFixes.trim()));
						} catch (PartInitException e) {
							UpdateMetaFileReaderJob.promptUserError(e.getLocalizedMessage(), "Error opening " + bugFixes.trim());
						} catch (MalformedURLException e) {
							UpdateMetaFileReaderJob.promptUserError(bugFixes.trim() + "Cannot be opened in browser, Malformed URL", "Error opening " + bugFixes.trim());
						}
					}
				});
			}
	}

	private void createFeatureNewVersionText(EnhancedFeature feature, final Group featureInfoGroup) {
		StyledText featureNewVersion = new StyledText(featureInfoGroup, SWT.WRAP);
		String featureVersionString = VERSION_LABEL + feature.getVersion();
		featureNewVersion.setText(featureVersionString);
	}

	private StyledText createFeatureNameText(EnhancedFeature feature, final Group featureInfoGroup) {
		StyledText featureName = new StyledText(featureInfoGroup, SWT.WRAP);
		final String featureNameString = feature.getLabel();
		featureName.setText(featureNameString);
		return featureName;
	}

	private Group createFeatureInfoRepresentationGroup(final Group featureGroup) {
		GridData gridData;
		final Group featureInfoGroup = new Group(featureGroup, SWT.NONE);
		featureInfoGroup.setBackground(featureGroup.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan = 2;
		featureInfoGroup.setLayoutData(gridData);
		featureInfoGroup.setLayout(new GridLayout(1, false));
		return featureInfoGroup;
	}

	private void createCheckBoxInFeatureGroup(EnhancedFeature feature, final Group featureGroup, final ActiveTab type) {
		final SelectableFeatureButton btn = new SelectableFeatureButton(featureGroup, SWT.CHECK);
		btn.setFeature(feature);
		btn.getCheckBox().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btn.getCheckBox().getSelection()) {
					if (type == ActiveTab.ALL_FEATURES) {
						selectedFeatures.add(btn.getFeature());
					} else {
						selectedUpdates.add(btn.getFeature());
					}
				} else {
					if (type == ActiveTab.ALL_FEATURES) {
						selectedFeatures.remove(btn.getFeature());
					} else {
						selectedUpdates.remove(btn.getFeature());
					}
				}
				if (type == ActiveTab.ALL_FEATURES) {
					installBtn.setEnabled(!selectedFeatures.isEmpty());
				} else {
					installBtn.setEnabled(!selectedUpdates.isEmpty());
				}
			}
		});
		featureButtons.add(btn);
	}

	private Group createFeatureRepresentationGroup(Group group, GridData gridData) {
		final Group featureGroup = new Group(group, SWT.NONE);
		featureGroup.setBackground(featureGroup.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		gridData.horizontalSpan = 2;
		featureGroup.setLayout(new GridLayout(4, false));
		featureGroup.setLayoutData(gridData);
		return featureGroup;
	}

	protected void createButtonsForButtonBar(Composite parent) {
		// Change parent layout data to fill the whole bar
		parent.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		installBtn = createButton(parent, IDialogConstants.NO_ID, INSTALL_BTN_TXT, true);
		installBtn.setEnabled(false);
		installBtn.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					if (tabFolder.getSelection()[0].getText().equals(ALL_FEATURES_TAB_TITLE)) {
						updateManager.setSelectedFeaturesToInstall(selectedFeatures);
						updateManager.installSelectedFeatures(new NullProgressMonitor());
					} else if (tabFolder.getSelection()[0].getText().equals(UPDATES_TAB_TITLE)) {
						updateManager.setSelectedUpdates(selectedUpdates);
						updateManager.installSelectedUpdates(new NullProgressMonitor());
					}
					dialog.close();
					break;
				}
			}
		});

		// Create a spacer label
		Label spacer = new Label(parent, SWT.NONE);
		spacer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// Update layout of the parent composite to count the spacer
		GridLayout layout = (GridLayout) parent.getLayout();
		layout.numColumns++;
		layout.makeColumnsEqualWidth = false;
		createButton(parent, IDialogConstants.CANCEL_ID, CANCEL_BTN_TXT, false);
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(TITLE);
	}
}
