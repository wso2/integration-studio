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

import org.eclipse.bpel.common.ui.command.ICommandFramework;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.viewers.CComboViewer;
import org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand;
import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.adapters.IProperty;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELTabbedPropertySheetPage;
import org.eclipse.bpel.ui.actions.ShowPropertiesViewAction;
import org.eclipse.bpel.ui.adapters.AdapterNotification;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.proposal.providers.ModelContentProposalProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyViewer;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabContents;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * An abstract implementation which provides some adapter support and useful stuff.
 * This was based on the common implementation characteristics of bpel.ui properties
 * pages.
 *
 * Implementors may subclass this class, or they could extend AbstractPropertySection directly.
 */
@SuppressWarnings("nls")
public abstract class BPELPropertySection extends AbstractPropertySection
{
	protected static final String EMPTY_STRING = ""; //$NON-NLS-1$

	protected static final IMarker EMPTY_MARKERS[] = new IMarker[] {};

	protected static final MultiObjectAdapter[] EMPTY_MULTI_OBJECT_ARRAY = new MultiObjectAdapter[0];

	/** Standard label width */
	public static final int STANDARD_LABEL_WIDTH_SM = 105;

	/** Standard label width - applying the 25% fudge factor */
	public static final int STANDARD_LABEL_WIDTH_AVG = STANDARD_LABEL_WIDTH_SM * 5/4;

	/** Standard label width - applying the 50% fudge factor */
	public static final int STANDARD_LABEL_WIDTH_LRG = STANDARD_LABEL_WIDTH_SM * 3/2;

	/** Standard button width */
	public static final int STANDARD_BUTTON_WIDTH = 60;

	/** Short button width */
	public static final int SHORT_BUTTON_WIDTH = 45;

	protected MultiObjectAdapter[] fAdapters;
	protected boolean isCreated;
	protected boolean isHidden;
	protected EObject fModelObject;

	protected TabbedPropertySheetWidgetFactory fWidgetFactory;


	protected BPELTabbedPropertySheetPage fTabbedPropertySheetPage;



	final protected ModelContentProposalProvider.ValueProvider inputValueProvider =  new ModelContentProposalProvider.ValueProvider () {
		@Override
		public Object value() {
			return getModel();
		}
	};


	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#getWidgetFactory()
	 */
	@Override
	public TabbedPropertySheetWidgetFactory getWidgetFactory() {
		TabbedPropertySheetWidgetFactory wf = super.getWidgetFactory();
		wf.setBorderStyle(SWT.BORDER);
		return wf;
	}

	/**
	 * Brand new shiny BPELPropertySection
	 */

	public BPELPropertySection() {
		super();
		this.fAdapters = createAdapters();
	}

	/**
	 * Subclasses must override this to return DetailsAdapters.
	 * The default implementation returns an empty array.
	 */
	protected MultiObjectAdapter[] createAdapters() {
		return EMPTY_MULTI_OBJECT_ARRAY;
	}

	/**
	 * Removes all adapters from whatever they are attached to.
	 * Subclasses may override.
	 */
	protected void removeAllAdapters() {
		for (MultiObjectAdapter a : this.fAdapters) {
			a.removeFromAll();
		}
	}

	/**
	 * This implementation just hooks the first adapter on the input object.
	 * Subclasses may override.
	 */
	protected void addAllAdapters() {
		assert this.isCreated : "Not yet created!" ;

		if (this.fAdapters.length > 0) {
			if (getModel() != null) {
				this.fAdapters[0].addToObject(getModel());
			}
		}
	}

	/**
	 * Convenience method for removing and re-adding adapters.  This is a simple and general
	 * way to react to model changes that grow or shrink the set of model objects we want our
	 * adapters to be on.
	 */
	protected void refreshAdapters() {
		removeAllAdapters();
		addAllAdapters();
	}

	/**
	 * This method is intended to set the input object.  Subclasses may override this
	 * method to perform necessary cleanup before changing the input object, and/or
	 * perform initialization after changing the input object.
	 *
	 * Subclasses may also override to change the policy of which object is used as
	 * the input for a particular properties section.
	 *
	 * For example: a section for a custom activity, may wish to override this method
	 * to use the custom activity ExtensibilityElement as the "main" input object.
	 */
	protected void basicSetInput(EObject newInput) {
		this.fModelObject = newInput;
	}

	@SuppressWarnings("unchecked")
	protected void restoreUserContextFromInput () {
		IProperty<String,Object> prop = BPELUtil.adapt(this.fModelObject, IProperty.class);
		if (prop != null) {
			restoreUserContext( prop.getProperty( getClass().getName() ) );
		}
	}

	@SuppressWarnings("unchecked")
	protected void saveUserContextToInput () {
		IProperty<String,Object> prop = BPELUtil.adapt(this.fModelObject, IProperty.class);
		if (prop != null) {
			prop.setProperty(getClass().getName(), getUserContext() );
		}
	}


	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public final void setInput(IWorkbenchPart part, ISelection selection) {

		super.setInput(part, selection);

		if ((selection instanceof IStructuredSelection) == false) {
			return ;
		}

		Object model = ((IStructuredSelection)selection).getFirstElement();
		if (model == this.fModelObject) {
			return;
		}

		removeAllAdapters();

		super.setInput(part, selection);

	    basicSetInput((EObject)model);

		// Careful: don't assume input == newInput.
		// There are basicSetInput() hacks that violate that assumption  =)
		// TODO: is this comment related to the custom activities?
		addAllAdapters();
	}


	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		this.isHidden = true;
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeShown()
	 */
	@Override
	public void aboutToBeShown() {
		this.isHidden = false;
	}

	@SuppressWarnings("unchecked")
	protected <T extends EObject> T getModel() {
		return (T) this.fModelObject;
	}

	public final <T extends EObject> T getInput() {
		return getModel();
	}


	/**
	 * Refresh the given CComboViewer, and also make sure selectedObject is selected in it.
	 */
	protected void refreshCCombo(CComboViewer viewer, Object selectedObject) {
		viewer.refresh();

		if (selectedObject == null) {
			viewer.setSelectionNoNotify ( StructuredSelection.EMPTY ,false );
		} else {
			viewer.setSelectionNoNotify (new StructuredSelection(selectedObject), false);
		}
	}

	/**
	 * Create the controls.
	 *
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */

	@Override
	public void createControls (final Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {

		super.createControls(parent, aTabbedPropertySheetPage);

		this.fTabbedPropertySheetPage = (BPELTabbedPropertySheetPage)aTabbedPropertySheetPage;
		this.fWidgetFactory = getWidgetFactory();

		assert !this.isCreated : "Not yet created!";

		Composite marginComposite = this.fWidgetFactory.createComposite(parent);
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginWidth = IDetailsAreaConstants.HMARGIN;
		fillLayout.marginHeight = IDetailsAreaConstants.VMARGIN/2;
		marginComposite.setLayout(fillLayout);
		createClient(marginComposite);
		this.isHidden = true;
		this.isCreated = true;

		parent.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}

		});

	}

	/**
	 * Subclasses should override this to create the child controls of the section.
	 */
	protected abstract void createClient(Composite parent);

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		if (this.isCreated) {
			// TODO HACK: this shouldn't really be here!  But where should it be??
			getCommandFramework().applyCurrentChange();
			removeAllAdapters();
		}
		this.isCreated = false;
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		updateStatusLabels();
	}

	/**
	 * Subclasses must override this method in order to refresh the status labels
	 */
	protected void updateStatusLabels() {
	}

	/**
	 * Gets all IMarker according to the passed input model.
	 * @see IMarkerHolder.getMarkers
	 */

	protected IMarker[] getMarkers (Object input) {

		IMarkerHolder markerHolder = BPELUtil.adapt(input, IMarkerHolder.class);
		if (markerHolder != null) {
			ArrayList<IMarker> filteredMarkers = new ArrayList<IMarker>(4);
			for(IMarker m : markerHolder.getMarkers(input)) {
				if (isValidMarker(m)) {
					filteredMarkers.add(m);
				}
			}
			if (filteredMarkers.size() > 0) {
				return filteredMarkers.toArray(EMPTY_MARKERS);
			}
		}
		return EMPTY_MARKERS;
	}


	protected boolean markersHaveChanged  ( Notification n ) {
		int eventGroup = n.getEventType() / 100;
		return eventGroup == AdapterNotification.NOTIFICATION_MARKERS_CHANGED_GROUP ;
	}


	protected void updateMarkers ( ) {

	}

	protected CompoundCommand makeCompound ( Command command ) {

		if (command == null) {
			return null;
		}
		if (command instanceof CompoundCommand) {
			return (CompoundCommand) command;
		}
		CompoundCommand cc = new CompoundCommand ();
		cc.add(command);
		return cc;
	}


	protected void runCommand ( Command command ) {
		getCommandFramework().execute( wrapInShowContextCommand(command) );
	}

	protected ICommandFramework getCommandFramework() {
		BPELEditor editor = getBPELEditor();
		if (editor != null) {
			return editor.getCommandFramework();
		}
		return null;
	}

	/**
	 * @return the BPELEditor
	 */

	public BPELEditor getBPELEditor() {
		if (this.fTabbedPropertySheetPage != null) {
			return this.fTabbedPropertySheetPage.getEditor();
		}
		return null;
	}

	/**
	 * @return the BPEL process
	 */
	public Process getProcess()  {
		return getBPELEditor().getProcess();
	}

	protected EditController createEditController ( ) {
		return new EditController ( getCommandFramework() ) {
			@Override
			public Command createApplyCommand() {
				return wrapInShowContextCommand( super.createApplyCommand() );
			}
		};
	}


	/**
	 * Convenience accessor with default policy (this is overridden in certain subclasses).
	 */
	protected Command wrapInShowContextCommand(final Command inner) {
		return wrapInShowContextCommand(inner, this);
	}

	/**
	 * Create a command that wraps the command passed in the show/restore context commands.
	 *
	 * @param inner the inner command to be run.
	 * @param section the BPEL property section
	 * @return the command new wrapped command.
	 */

	protected Command wrapInShowContextCommand(final Command inner, BPELPropertySection section) {

		/**
		 * Sometimes we have property sections inside property sections.
		 *
		 * The owners section's input needs to be saved, because it is used to restore
		 * the selection later on in the "wrapping" command. The "inner" section's input
		 * may not be visibly selectable. For example, consider "Variable" property sheet.
		 * A separate section is used for the "From" part of Variable.
		 */

		final Object previousInput = section.getInput();

		final TabbedPropertyViewer viewer = getTabbedPropertySheetPage().getTabbedPropertyViewer();
		final int tabIndex = viewer.getSelectionIndex();
		// Bug 120110 - found this problem while building the extension activity examples
		// it's possible that a property section can update the model while the property
		// section tab itself has already been disposed (getCurrentTab() will be null).
		final int sectionIndex = getTabbedPropertySheetPage().getCurrentTab()==null
				? -1
				: getTabbedPropertySheetPage().getCurrentTab().getSectionIndex(section);

		if (!inner.canExecute()) {
			System.out.println("WARNING: unexecutable command passed to wrapInShowContextCommand():"); //$NON-NLS-1$
			System.out.println("    "+inner.getDebugLabel()); //$NON-NLS-1$
		}

		return new AbstractEditModelCommand() {
			Object beforeContext, afterContext;

			@Override
			public String getLabel() {
				return inner.getLabel();
			}

			@Override
			public void setLabel(String label) {
				inner.setLabel(label);
			}

			@Override
			public String getDebugLabel() {
				return "ShowContext wrapper:[" + inner.getDebugLabel() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
			}

			@Override
			public boolean canExecute() {
				return inner.canExecute();
			}

			@Override
			public void execute() {
				BPELPropertySection aSection = getSection(sectionIndex);
				this.beforeContext = (aSection==null)? null : aSection.getUserContext();
				inner.execute();
				this.afterContext = (aSection==null)? null : aSection.getUserContext();
			}

			@Override
			public boolean canUndo() {
				return inner.canUndo();
			}

			@Override
			public void undo() {
				inner.undo();
				showPropertiesTab();
				BPELPropertySection aSection = getSection(sectionIndex);
				if (aSection != null) {
					aSection.restoreUserContext(this.beforeContext);
				}
			}

			@Override
			public void redo() {
				inner.redo();
				showPropertiesTab();
				BPELPropertySection aSection = getSection(sectionIndex);
				if (aSection != null) {
					aSection.restoreUserContext(this.afterContext);
				}
			}

			@Override
			public void dispose() {
				inner.dispose();
			}

			protected BPELPropertySection getSection (int index) {
				 TabContents tab = getTabbedPropertySheetPage().getCurrentTab();
				 if (tab != null) {
					 return (BPELPropertySection) tab.getSectionAtIndex(sectionIndex);
				 }
				 return null;
			}

			protected void showPropertiesTab() {
				// TODO: Try to avoid selecting the model object all
				// the time, as it could cause unnecessary flashing.
				getBPELEditor().selectModelObject(previousInput);

				if (tabIndex != viewer.getSelectionIndex()) {
					Object selectedTab = viewer.getElementAt(tabIndex);
					if (selectedTab != null) {
						viewer.setSelection(new StructuredSelection(selectedTab));
					}
				}
			}

			// TODO: THIS IS A HACK.. these helpers might belong somewhere else.
			@Override
			public Resource[] getResources() {
				return EditModelCommandStack.getResources(inner);
			}

			@Override
			public Resource[] getModifiedResources() {
				return EditModelCommandStack.getModifiedResources(inner);
			}

		};
	}

	/**
	 * Creates a composite with a flat border around it.
	 */
	protected Composite createBorderComposite(Composite parent) {
	    return BPELUtil.createBorderComposite(parent, this.fWidgetFactory);
	}

	/**
	 * NOTE: use this method, NOT the method in TabbedPropertySheetWidgetFactory,
	 * whose semantics were inexplicably changed.
	 *
	 * 	TODO: We need a new/better story for layouts and borders ??
	 */
	protected Composite createFlatFormComposite(Composite parent) {
		Composite result = this.fWidgetFactory.createFlatFormComposite(parent);
		FlatFormLayout formLayout = new FlatFormLayout();
		formLayout.marginWidth = formLayout.marginHeight = 0;
		result.setLayout(formLayout);
		return result;
	}

	/**
	 * @return the BPEL Tabbed Property Sheet page.
	 */

	public BPELTabbedPropertySheetPage getTabbedPropertySheetPage() {
		return this.fTabbedPropertySheetPage;
	}


	/**
	 * @return the IFile that the editor is editing.
	 */

	public IFile getBPELFile() {
		return ((IFileEditorInput) getBPELEditor().getEditorInput()).getFile();
	}

	/**
	 * Returns a token indicating which widget should have focus.  Note that the token can't
	 * be tied to this particular instance of the section; after the section is destroyed
	 * and re-created, the token must still be valid.
	 * @return the user context
	 */
	public Object getUserContext() {
		return null;
	}

	/**
	 * Accepts a token created by getUserContext() and gives focus to the widget represented
	 * by the token.
	 * @param userContext the user context to restore.
	 */
	public void restoreUserContext(Object userContext) {
	}

	/**
	 * Shows the given marker.
	 * @param marker
	 */
	public void gotoMarker (IMarker marker) {

	}

	/**
	 * Returns true if this section knows how to show the given marker.
	 *
	 * @param marker the marker to be checked.
	 * @return true if so, false otherwise ...
	 */

	public boolean isValidMarker (IMarker marker) {
		return true;
	}


	/**
	 * Return the Context names that allows us to point markers correctly at this
	 * section.
	 *
	 * @return an array of context names
	 */

	public String[] getContextNames () {
		return new String[] {};
	}


	/**
	 * Given a model object, selects it in the BPEL Editor and makes sure the
	 * properties pages are also shown for it.
	 */
	protected void selectModelObject(final EObject target) {
		Runnable runnable = new Runnable() {
			public void run() {
				getBPELEditor().selectModelObject(target);
                new ShowPropertiesViewAction().run();
			}
		};
		Display.getDefault().asyncExec(runnable);
	}
}