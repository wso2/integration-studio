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

package org.wso2.developerstudio.eclipse.registry.search;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.text.FileTextSearchScope;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class RegistrySearch extends DialogPage implements ISearchPage {
	private String selected;
	private Text idText;
	private CCombo mediaTypeCombo;
	private Text descriptionText;
	private Text commentText;
	private Text propertyNameText;
	private Text propertyValueText;
	private Text tagsText;
	private SearchQueryData searchQueryData;
	private boolean blankDataModifying = false;
	private FocusListener focusListener;
	private ModifyListener modifyListener;
	private Button regTree;
	private Button allRegTrees;
	private Combo registryCombo;
	private Button browseRegistryButton;

	public RegistrySearch() {
		super();
		searchQueryData = new SearchQueryData();
	}

	public RegistrySearch(String title) {
		super(title);
	}

	public boolean performAction() {
		try {
			RegistrySearchQuery testSearchQuery = new RegistrySearchQuery(
					idText.getText(), false, false, FileTextSearchScope
							.newWorkspaceScope(new String[] {}, true));
			testSearchQuery.setSearchQueryData(searchQueryData);
			NewSearchUI.runQueryInBackground(testSearchQuery);

		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	public void setContainer(ISearchPageContainer container) {
		if (container.getSelection() instanceof TextSelection) {
			selected = ((TextSelection) container.getSelection()).getText();
		}
	}

	public void createControl(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		layout.horizontalSpacing = 5;
		layout.verticalSpacing = 5;
		parent.setLayout(layout);
		Label lbl = new Label(parent, 0);
		lbl.setText("Resource name:");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		lbl.setLayoutData(gd);

		idText = new Text(parent, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		idText.setLayoutData(gd);

		Group advancedSearchOptionsGroup = new Group(parent,
				SWT.SHADOW_ETCHED_IN);
		layout = new GridLayout(3, false);
		layout.horizontalSpacing = 5;
		layout.verticalSpacing = 5;
		advancedSearchOptionsGroup.setLayout(layout);
		advancedSearchOptionsGroup.setLayoutData(new GridData(
				GridData.FILL_BOTH));

		Composite mediaTypeComposite = new Composite(
				advancedSearchOptionsGroup, SWT.None);
		mediaTypeComposite
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 2;
		mediaTypeComposite.setLayout(layout);
		new Label(mediaTypeComposite, 0).setText("Media type");
		mediaTypeCombo = new CCombo(mediaTypeComposite, SWT.BORDER);
		mediaTypeCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite descriptionComposite = new Composite(
				advancedSearchOptionsGroup, SWT.None);
		descriptionComposite.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 2;
		descriptionComposite.setLayout(layout);
		new Label(descriptionComposite, 0).setText("Description");
		descriptionText = new Text(descriptionComposite, SWT.BORDER);
		descriptionText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite commentComposite = new Composite(advancedSearchOptionsGroup,
				SWT.None);
		commentComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 2;
		commentComposite.setLayout(layout);
		new Label(commentComposite, 0).setText("Comment");
		commentText = new Text(commentComposite, SWT.BORDER);
		commentText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label shadow_sep_h = new Label(advancedSearchOptionsGroup,
				SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		shadow_sep_h.setLayoutData(gd);

		Composite propertyComposite = new Composite(advancedSearchOptionsGroup,
				SWT.None);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		propertyComposite.setLayoutData(gd);
		layout = new GridLayout(4, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 2;
		propertyComposite.setLayout(layout);
		lbl = new Label(propertyComposite, 0);
		lbl.setText("Property");
		gd = new GridData();
		gd.horizontalSpan = 4;
		lbl.setLayoutData(gd);
		new Label(propertyComposite, 0).setText("     Name ");
		propertyNameText = new Text(propertyComposite, SWT.BORDER);
		propertyNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		new Label(propertyComposite, 0).setText("     Value ");
		propertyValueText = new Text(propertyComposite, SWT.BORDER);
		propertyValueText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite tagsComposite = new Composite(advancedSearchOptionsGroup,
				SWT.None);
		tagsComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 2;
		tagsComposite.setLayout(layout);
		new Label(tagsComposite, 0).setText("Tags");
		tagsText = new Text(tagsComposite, SWT.BORDER);
		tagsText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Group scopeGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
		layout = new GridLayout(3, false);
		layout.horizontalSpacing = 5;
		layout.verticalSpacing = 5;
		scopeGroup.setLayout(layout);
		scopeGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		scopeGroup.setText("Scope");

		allRegTrees = new Button(scopeGroup, SWT.RADIO);
		allRegTrees.setText("All registries");
		gd = new GridData();
		gd.horizontalSpan = 3;
		allRegTrees.setLayoutData(gd);

		regTree = new Button(scopeGroup, SWT.RADIO);
		regTree.setText("Selected registry");
		regTree.setLayoutData(new GridData());

		registryCombo = new Combo(scopeGroup, SWT.BORDER);
		registryCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		browseRegistryButton = new Button(scopeGroup, SWT.None);
		browseRegistryButton.setText("Browse");

		allRegTrees.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}

			public void widgetSelected(SelectionEvent evt) {
				searchQueryData.setAllRegistries(true);
				updateScopeControlState();
			}

		});

		regTree.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}

			public void widgetSelected(SelectionEvent evt) {
				searchQueryData.setAllRegistries(false);
				updateScopeControlState();
			}

		});

		createListeners();
		idText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				searchQueryData.setResourceName(idText.getText());

			}

		});
		mediaTypeCombo.addFocusListener(focusListener);
		descriptionText.addFocusListener(focusListener);
		commentText.addFocusListener(focusListener);
		tagsText.addFocusListener(focusListener);
		propertyNameText.addFocusListener(focusListener);
		propertyValueText.addFocusListener(focusListener);
		registryCombo.addFocusListener(focusListener);
		mediaTypeCombo.addModifyListener(modifyListener);
		descriptionText.addModifyListener(modifyListener);
		commentText.addModifyListener(modifyListener);
		tagsText.addModifyListener(modifyListener);
		propertyNameText.addModifyListener(modifyListener);
		propertyValueText.addModifyListener(modifyListener);
		registryCombo.addModifyListener(modifyListener);
		allRegTrees.setSelection(true);
		searchQueryData.setAllRegistries(true);
		updateScopeControlState();

		mediaTypeCombo.setFocus();
		descriptionText.setFocus();
		commentText.setFocus();
		tagsText.setFocus();
		propertyNameText.setFocus();
		propertyValueText.setFocus();
		if (selected != null) {
			idText.setText(selected);
			idText.setSelection(0, selected.length());
		} else {
		}
		idText.setFocus();
		fillMediaTypes();
		fillRegistries();
		advancedSearchOptionsGroup.setVisible(false);
		setControl(parent);
	}

	private void fillMediaTypes() {
		mediaTypeCombo.removeAll();
		mediaTypeCombo.add("abc/xyz");
	}

	private void fillRegistries() {
	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);
		idText.setFocus();
	}

	private void createListeners() {
		modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				if (!blankDataModifying) {
					if (evt.getSource() == mediaTypeCombo)
						searchQueryData.setMediaType(mediaTypeCombo.getText());
					if (evt.getSource() == descriptionText)
						searchQueryData.setDescription(descriptionText
								.getText());
					if (evt.getSource() == tagsText)
						searchQueryData.setTags(tagsText.getText());
					if (evt.getSource() == commentText)
						searchQueryData.setComment(commentText.getText());
					if (evt.getSource() == propertyNameText)
						searchQueryData.setPropertyName(propertyNameText
								.getText());
					if (evt.getSource() == propertyValueText)
						searchQueryData.setPropertyValue(propertyValueText
								.getText());
					if (evt.getSource() == registryCombo)
						searchQueryData
								.setSearchLocation(getValidLocation(registryCombo
										.getText()));
				}
			}

		};
		focusListener = new FocusListener() {

			public void focusGained(FocusEvent evt) {
				blankDataModifying = true;
				if (evt.getSource() == mediaTypeCombo
						&& !Utils.isProvided(searchQueryData.getMediaType())) {
					mediaTypeCombo.setText("");
					mediaTypeCombo.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_BLACK));
				}
				if (evt.getSource() == descriptionText
						&& !Utils.isProvided(searchQueryData.getDescription())) {
					descriptionText.setText("");
					descriptionText.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_BLACK));
				}
				if (evt.getSource() == tagsText
						&& !Utils.isProvided(searchQueryData.getTags())) {
					tagsText.setText("");
					tagsText.setForeground(Display.getDefault().getSystemColor(
							SWT.COLOR_BLACK));
				}
				if (evt.getSource() == commentText
						&& !Utils.isProvided(searchQueryData.getComment())) {
					commentText.setText("");
					commentText.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_BLACK));
				}
				if (evt.getSource() == propertyNameText
						&& !Utils.isProvided(searchQueryData.getPropertyName())) {
					propertyNameText.setText("");
					propertyNameText.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_BLACK));
				}
				if (evt.getSource() == propertyValueText
						&& !Utils
								.isProvided(searchQueryData.getPropertyValue())) {
					propertyValueText.setText("");
					propertyValueText.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_BLACK));
				}
				if (evt.getSource() == registryCombo
						&& !Utils.isProvided(searchQueryData
								.getSearchLocation())) {
					registryCombo.setText("");
					registryCombo.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_BLACK));
				}
				blankDataModifying = false;
			}

			public void focusLost(FocusEvent evt) {
				blankDataModifying = true;
				if (evt.getSource() == mediaTypeCombo
						&& !Utils.isProvided(searchQueryData.getMediaType())) {
					mediaTypeCombo.setText(mediaTypeBlankString);
					mediaTypeCombo.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_GRAY));
				}
				if (evt.getSource() == descriptionText
						&& !Utils.isProvided(searchQueryData.getDescription())) {
					descriptionText.setText(descriptionBlankString);
					descriptionText.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_GRAY));
				}
				if (evt.getSource() == tagsText
						&& !Utils.isProvided(searchQueryData.getTags())) {
					tagsText.setText(tagBlankString);
					tagsText.setForeground(Display.getDefault().getSystemColor(
							SWT.COLOR_GRAY));
				}
				if (evt.getSource() == commentText
						&& !Utils.isProvided(searchQueryData.getComment())) {
					commentText.setText(commentBlankString);
					commentText.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_GRAY));
				}
				if (evt.getSource() == propertyNameText
						&& !Utils.isProvided(searchQueryData.getPropertyName())) {
					propertyNameText.setText(propertyNameBlankString);
					propertyNameText.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_GRAY));
				}
				if (evt.getSource() == propertyValueText
						&& !Utils
								.isProvided(searchQueryData.getPropertyValue())) {
					propertyValueText.setText(propertyValueBlankString);
					propertyValueText.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_GRAY));
				}
				if (evt.getSource() == registryCombo
						&& !Utils.isProvided(searchQueryData
								.getSearchLocation())) {
					registryCombo.setText(registryUrlBlankString);
					registryCombo.setForeground(Display.getDefault()
							.getSystemColor(SWT.COLOR_GRAY));
				}
				blankDataModifying = false;
			}

		};
	}

	private String getValidLocation(String s) {
		String[] split = s.split("@");
		if (split.length != 2)
			return "";
		try {
			new URL(split[1]);
		} catch (MalformedURLException e) {
			return "";
		}
		return s;
	}

	private void updateScopeControlState() {
		registryCombo.setEnabled(!searchQueryData.isAllRegistries());
		browseRegistryButton.setEnabled(!searchQueryData.isAllRegistries());
	}

	String mediaTypeBlankString = "[Type or select the media type]";
	String descriptionBlankString = "[Type part of the description]";
	String propertyNameBlankString = "[Type the name of the property]";
	String propertyValueBlankString = "[Type the value of the property]";
	String tagBlankString = "[Type tag values separated by a comma]";
	String commentBlankString = "[Type part of the comment]";
	String registryUrlBlankString = "[registry_url]/[path_to_search]             eg: https://myhost.com/registry/carbon/modules";

}
