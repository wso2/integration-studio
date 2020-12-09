/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.bpel.common.ui.details.ButtonIValue;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddCopyCommand;
import org.eclipse.bpel.ui.commands.RemoveCopyCommand;
import org.eclipse.bpel.ui.commands.SwapCopyCommand;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

/**
 * AssignImplDetails allows viewing and editing of the copy elements in an
 * Assign.
 * 
 * The input of this section is the Assign activity.
 * 
 * 
 * @author IBM Original Contribution
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 7, 2007
 * 
 */

@SuppressWarnings("nls")
public class AssignImplSection extends BPELPropertySection {

	static String CURRENT_INDEX_PROPERTY = "currentIndex";

	/** The to section */
	CategorySection fToSection = new CategorySection(this);

	/** The from section */
	CategorySection fFromSection = new CategorySection(this);

	/** The current copy rule being edited. */
	Copy fCurrentCopy;

	org.eclipse.swt.widgets.List fCopyList;

	Composite copySelectComposite;

	protected ListViewer fCopyListViewer;

	Button fDeleteCopy;
	Button fMoveUp;
	Button fMoveDown;

	Button fKeepSrcElement;
	Button fIgnoreMissingSourceData;

	EditController fKeepSrcElementController;
	EditController fIgnoreMissingSourceDataController;

	/**
	 * 
	 */

	public AssignImplSection() {
		super();

		List<IAssignCategory> fToAllowed = defaultToCategories();
		fToAllowed.addAll(BPELUIRegistry.getInstance()
				.getAdditionalAssignCategories());
		List<IAssignCategory> fFromAllowed = defaultFromCategories();
		fFromAllowed.addAll(BPELUIRegistry.getInstance()
				.getAdditionalAssignCategories());

		fToSection.fAllowed = fToAllowed.toArray(fToSection.fAllowed);
		fFromSection.fAllowed = fFromAllowed.toArray(fFromSection.fAllowed);
	}

	protected ArrayList<IAssignCategory> defaultToCategories() {
		return new ArrayList<IAssignCategory>(
				Arrays.asList(new IAssignCategory[] {
						new VariablePartAssignCategory(this),
						new ExpressionAssignCategory(this),
						new VariablePropertyAssignCategory(this),
						new PartnerRoleAssignCategory(this, false) }));
	}

	protected ArrayList<IAssignCategory> defaultFromCategories() {
		return new ArrayList<IAssignCategory>(
				Arrays.asList(new IAssignCategory[] {
						new VariablePartAssignCategory(this),
						new ExpressionAssignCategory(this),
						new LiteralAssignCategory(this),
						new VariablePropertyAssignCategory(this),
						new PartnerRoleAssignCategory(this, true),
						new EndpointReferenceAssignCategory(this),
						new OpaqueAssignCategory(this) }));
	}

	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
		/* model object */
		new MultiObjectAdapter() {

			@Override
			public void notify(Notification n) {

				adjustCopyRulesList();
				if (n.getFeature() == BPELPackage.eINSTANCE.getAssign_Copy()) {
					Copy copy = (Copy) n.getNewValue();
					Assign assign = getModel();
					if (copy != null) {
						selectCopyInList(assign.getCopy().indexOf(copy));
					}

				}

			}
		}, };
	}

	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		EList<Copy> list = ((Assign) getInput()).getCopy();
		for (Copy copy : list) {
			fAdapters[0].addToObject(copy);
			if (copy.getFrom() != null)
				fAdapters[0].addToObject(copy.getFrom());
			if (copy.getTo() != null)
				fAdapters[0].addToObject(copy.getTo());
		}
	}

	protected void createCopySelectWidgets(Composite parent) {

		FlatFormData data;

		Composite c = copySelectComposite = createFlatFormComposite(parent);

		Button insertCopy = fWidgetFactory.createButton(c,
				Messages.AssignImplDetails_New__5, SWT.PUSH);
		fDeleteCopy = fWidgetFactory.createButton(c,
				Messages.AssignImplDetails_Delete__6, SWT.PUSH);
		fMoveUp = fWidgetFactory.createButton(c, "Move Up", SWT.PUSH);
		fMoveDown = fWidgetFactory.createButton(c, "Move Down", SWT.PUSH);

		fCopyList = fWidgetFactory.createList(c, SWT.BORDER | SWT.V_SCROLL
				| SWT.SINGLE);

		int preferredWidth = 200;

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(0, preferredWidth);
		data.top = new FlatFormAttachment(0, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		c.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.bottom = new FlatFormAttachment(insertCopy,
				-IDetailsAreaConstants.VSPACE);
		fCopyList.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(50, 0);
		data.bottom = new FlatFormAttachment(fMoveUp, 0);
		insertCopy.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(insertCopy, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(fMoveDown, 0);
		fDeleteCopy.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(50, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		fMoveUp.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(fMoveUp, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		fMoveDown.setLayoutData(data);

		insertCopy.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {

				Copy copy = BPELFactory.eINSTANCE.createCopy();

				getCommandFramework().execute(
						wrapInShowContextCommand(new AddCopyCommand(
								(Assign) getInput(), copy)));
				refreshAdapters();

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		fDeleteCopy.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Assign assign = getModel();
				int index = fCopyList.getSelectionIndex();
				index = (index == assign.getCopy().size() - 1) ? index - 1
						: index;

				getCommandFramework().execute(
						wrapInShowContextCommand(new RemoveCopyCommand(
								(Assign) getInput(), fCurrentCopy)));
				selectCopyInList(index);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		fCopyList.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int index = fCopyList.getSelectionIndex();
				selectCopyInList(index);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		fMoveUp.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Assign assign = getModel();
				int index = fCopyList.getSelectionIndex();
				getCommandFramework().execute(
						wrapInShowContextCommand(new SwapCopyCommand(assign,
								index, index - 1)));
				selectCopyInList(index - 1);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		fMoveDown.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Assign assign = getModel();
				int index = fCopyList.getSelectionIndex();
				getCommandFramework().execute(
						wrapInShowContextCommand(new SwapCopyCommand(assign,
								index, index + 1)));
				selectCopyInList(index + 1);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

	}

	protected void createCategorySectionWidgets(Composite composite,
			final CategorySection section, boolean isFrom) {

		FlatFormData data;

		section.fLabel = fWidgetFactory.createLabel(composite,
				isFrom ? Messages.AssignImplDetails_From__1
						: Messages.AssignImplDetails_To__2);
		section.fCombo = new Combo(composite, SWT.FLAT | SWT.BORDER
				| SWT.READ_ONLY);
		data = new FlatFormData();

		if (isFrom) {
			data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
					section.fLabel, STANDARD_LABEL_WIDTH_SM));
			data.right = new FlatFormAttachment(50,
					-IDetailsAreaConstants.CENTER_SPACE);
		} else {
			data.left = new FlatFormAttachment(50,
					IDetailsAreaConstants.CENTER_SPACE
							+ BPELUtil.calculateLabelWidth(section.fLabel,
									STANDARD_LABEL_WIDTH_SM));
			data.right = new FlatFormAttachment(100, 0);
		}

		data.top = new FlatFormAttachment(0, 0);
		section.fCombo.setLayoutData(data);

		data = new FlatFormData();
		if (isFrom) {
			data.left = new FlatFormAttachment(0, 0);
		} else {
			data.left = new FlatFormAttachment(50,
					IDetailsAreaConstants.CENTER_SPACE);
		}
		data.right = new FlatFormAttachment(section.fCombo,
				-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(section.fCombo, 0, SWT.CENTER);
		section.fLabel.setLayoutData(data);

		for (IAssignCategory category : section.fAllowed) {
			if (category.getName() != null) {
				section.fCombo.add(category.getName());
			}
		}

		section.fCombo.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int index = section.fCombo.getSelectionIndex();

				updateCategorySelection(section, index, true);

			}

			// TODO: is this correct?
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		section.fOuterComposite = createFlatFormComposite(composite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(section.fLabel, 0, SWT.LEFT);
		data.right = new FlatFormAttachment(section.fCombo, 0, SWT.RIGHT);
		data.top = new FlatFormAttachment(section.fCombo,
				IDetailsAreaConstants.VSPACE);
		data.bottom = new FlatFormAttachment(100, -25);
		section.fOuterComposite.setLayoutData(data);

		// Create the keepSrcElement check box button
		if (isFrom) {
			fIgnoreMissingSourceData = fWidgetFactory.createButton(composite,
					Messages.AssignImplDetails_IgnoreMissingSourceData,
					SWT.CHECK);
			data = new FlatFormData();
			data.right = new FlatFormAttachment(50,
					-IDetailsAreaConstants.HSPACE);
			data.bottom = new FlatFormAttachment(100, 0);
			fIgnoreMissingSourceData.setLayoutData(data);

			fIgnoreMissingSourceDataController = createEditController();
			fIgnoreMissingSourceDataController.setFeature(BPELPackage.eINSTANCE
					.getCopy_IgnoreMissingFromData());
			fIgnoreMissingSourceDataController.setViewIValue(new ButtonIValue(
					fIgnoreMissingSourceData));
			fIgnoreMissingSourceDataController
					.startListeningTo(fIgnoreMissingSourceData);

		} else {

			fKeepSrcElement = fWidgetFactory.createButton(composite,
					Messages.AssignImplDetails_KeepSrcElementName, SWT.CHECK);
			data = new FlatFormData();
			data.right = new FlatFormAttachment(100,
					-IDetailsAreaConstants.HSPACE);
			data.bottom = new FlatFormAttachment(100, 0);
			fKeepSrcElement.setLayoutData(data);

			fKeepSrcElementController = createEditController();
			fKeepSrcElementController.setFeature(BPELPackage.eINSTANCE
					.getCopy_KeepSrcElementName());
			fKeepSrcElementController.setViewIValue(new ButtonIValue(
					fKeepSrcElement));
			fKeepSrcElementController.startListeningTo(fKeepSrcElement);

		}

	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	@Override
	protected void createClient(Composite parent) {

		Composite composite = createFlatFormComposite(parent);
		createCopySelectWidgets(composite);
		Composite mainComposite = createFlatFormComposite(composite);
		FlatFormData data = new FlatFormData();
		data.left = new FlatFormAttachment(copySelectComposite,
				IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		mainComposite.setLayoutData(data);

		createCategorySectionWidgets(mainComposite, fFromSection, true);
		createCategorySectionWidgets(mainComposite, fToSection, false);
    PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IHelpContextIds.PROPERTY_PAGE_ASSIGN);
	}

	// Total Hack until we have Copy objects in graphical editor
	@Override
	protected void basicSetInput(EObject newInput) {

		saveUserContextToInput();

		super.basicSetInput(newInput);
		adjustCopyRulesList();

		restoreUserContextFromInput();

		if (fToSection.fCurrent != null) {
			fToSection.fCurrent.refresh();
		}
		if (fFromSection.fCurrent != null) {
			fFromSection.fCurrent.refresh();
		}

	}

	/**
	 * Called when the copy rule changes or is created.
	 * 
	 */
	@SuppressWarnings("boxing")
	protected void selectCategoriesForInput() {

		fKeepSrcElementController.setInput(fCurrentCopy);
		fIgnoreMissingSourceDataController.setInput(fCurrentCopy);

		if (fCurrentCopy == null) {
			fToSection.hideCurrent();
			fFromSection.hideCurrent();
			fKeepSrcElement.setEnabled(false);
			fIgnoreMissingSourceData.setEnabled(false);
			return;
		}

		fKeepSrcElement.setEnabled(true);
		fIgnoreMissingSourceData.setEnabled(true);

		// Find the proper copy-from category
		boolean bFound = false;
		for (IAssignCategory category : fFromSection.fAllowed) {
			if (category.isCategoryForModel(fCurrentCopy.getFrom())) {
				updateCategorySelection(fFromSection, category, false);
				bFound = true;
				break;
			}
		}

		/** In case we can't find the appropriate one, just display the first one */
		if (bFound == false || fFromSection.fCurrent == null) {
			updateCategorySelection(fFromSection, 0, false);
		}

		// Find the proper copy-to category
		bFound = false;
		for (IAssignCategory category : fToSection.fAllowed) {
			if (category.isCategoryForModel(fCurrentCopy.getTo())) {
				updateCategorySelection(fToSection, category, false);
				bFound = true;
				break;
			}
		}

		/** In case we can't find the appropriate one, just display the first one */
		if (bFound == false || fToSection.fCurrent == null) {
			updateCategorySelection(fToSection, 0, false);
		}
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();

		if (fToSection.fCurrent != null) {
			fToSection.fCurrent.aboutToBeHidden();
		}
		if (fFromSection.fCurrent != null) {
			fFromSection.fCurrent.aboutToBeHidden();
		}

	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeShown()
	 */
	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		if (fToSection.fCurrent != null) {
			fToSection.fCurrent.aboutToBeShown();
		}
		if (fFromSection.fCurrent != null) {
			fFromSection.fCurrent.aboutToBeShown();
		}
	}

	protected void adjustCopyRulesList() {
		Assign assign = getModel();
		EList<Copy> copyList = assign.getCopy();
		int sz = copyList.size();
		int idx = fCopyList.getSelectionIndex();
		String[] items = new String[sz];
		for (int i = 0; i < sz; i++) {
			Copy copy = copyList.get(i);
			items[i] = asText(copy.getFrom()) + " to " + asText(copy.getTo());
		}
		fCopyList.setItems(items);
		if (idx != -1) {
			fCopyList.setSelection(idx);
		}
		fDeleteCopy.setEnabled(sz > 0);
		fToSection.fCombo.setEnabled(sz > 0);
		fFromSection.fCombo.setEnabled(sz > 0);
	}

	private String asText(From from) {
		for (IAssignCategory category : fFromSection.fAllowed) {
			if (category.isCategoryForModel(from)) {
				return category.getName();
			}
		}
		return "?";
	}

	private String asText(To to) {
		for (IAssignCategory category : fToSection.fAllowed) {
			if (category.isCategoryForModel(to)) {
				return category.getName();
			}
		}
		return "?";
	}

	void updateCategorySelection(CategorySection section, int index,
			boolean bVisual) {
		updateCategorySelection(section, section.fAllowed[index], bVisual);
	}

	void updateCategorySelection(CategorySection section,
			IAssignCategory newCurrent, boolean bVisual) {

		/** Hide current */
		section.hideCurrent();

		/** Update current to the one that picked from */
		section.fCurrent = newCurrent;
		section.ensureCategoryCompositeCreated();

		if (bVisual == false) {
			section.updateCombo();
		}

		if (section == fToSection) {
			if (bVisual || fCurrentCopy.getTo() == null) {
				fCurrentCopy.setTo(BPELFactory.eINSTANCE.createTo());
			}
			section.fCurrent.setInput(fCurrentCopy.getTo());

		} else {

			if (bVisual || fCurrentCopy.getFrom() == null) {
				fCurrentCopy.setFrom(BPELFactory.eINSTANCE.createFrom());
			}
			section.fCurrent.setInput(fCurrentCopy.getFrom());
	        // https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7351
			// construct an initializer if From is empty
			if (section.fCurrent instanceof LiteralAssignCategory)
				VariableInitializationSection.createDefaultInitializer(getBPELEditor(), fCurrentCopy.getFrom(), fCurrentCopy.getTo());
		}

		section.showCurrent();
		section.fCurrent.refresh();
		refreshAdapters();

		// TODO: should the categories only store when a widget change is
		// committed?
		// Cons of that idea:
		// - Changing the category in the combo, but *not* changing anything
		// else,
		// then clicking elsewhere and back, would cause the combo to revert.
		// - The OpaqueAssignCategory doesn't have any widgets..
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@SuppressWarnings("boxing")
	@Override
	public Object getUserContext() {
		Assign assign = getModel();
		if (assign == null) {
			return -1;
		}
		return assign.getCopy().indexOf(fCurrentCopy);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@SuppressWarnings("boxing")
	@Override
	public void restoreUserContext(Object userContext) {

		int idx = 0;
		if (userContext instanceof Number) {
			Number num = (Number) userContext;
			idx = num.intValue();
		}

		selectCopyInList(idx);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#gotoMarker(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void gotoMarker(IMarker marker) {
		// TODO: This code do nothing and sometime causes NPE (from==null), so
		// temporary disabled (Oleg)
		// String uriFragment =
		// marker.getAttribute(IBPELUIConstants.MARKER_ATT_FROM, EMPTY_STRING);
		// EObject from = fModelObject.eResource().getEObject(uriFragment);
		// EObject copy = from.eContainer();
		// currentCopyIndex = ((Assign)getModel()).getCopy().indexOf(copy);
		refresh();
	}

	/*
	 * Select copy, refresh buttons & categories
	 */
	private void selectCopyInList(int index) {
		EList<Copy> list = ((Assign) getModel()).getCopy();
		if (index < 0 || index >= list.size()) {
			fCurrentCopy = null;
			fMoveUp.setEnabled(false);
			fMoveDown.setEnabled(false);
		} else {
			fCurrentCopy = list.get(index);
			fCopyList.select(index);
			fMoveUp.setEnabled(index > 0);
			fMoveDown.setEnabled(index < fCopyList.getItemCount() - 1);
		}
		selectCategoriesForInput();
	}
}
