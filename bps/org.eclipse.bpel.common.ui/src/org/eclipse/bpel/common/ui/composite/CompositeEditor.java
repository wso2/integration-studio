/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.composite;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.bpel.common.ui.Policy;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;


/**
 * The CompositeEditor contains a collection of embedded editors.
 * Each embedded editor provides its own contributions. The contributions
 * are available for the user when the embedded editor is activated.
 * Embedded editors have to be registered through the embeddedEditors
 * extension point like the example bellow:
 * 
 * <extension point="org.eclipse.bpel.common.ui.embeddedEditors">
 *    <editor
 *       id="com.examples.MyEmbeddedEditor"
 *       class="com.examples.MyEmbeddedEditor"
 *       contributorClass="com.examples.MyEmbeddedEditorActionBarContributor"/>
 * </extension>
 * 
 * Notes:
 * Embedded editors can never be the workbench active part. The
 * active part is aways the CompositeEditor.
 */
public abstract class CompositeEditor extends EditorPart {

	protected EmbeddedEditorsCollection embeddedEditors;
	protected IPropertyListener propertyListener;
	protected CompositeEditorManager editorManager;
	protected IEditorPart mainEditor;

	/**
	 * Since subclasses might implement their own part listeners
	 * we make this attribute private so that there are no name
	 * conflicts and subclasses do not overwrite this listener by accident.
	 */
	private IPartListener partListener;

	/**
	 * Represents the collection of embedded editors
	 * and the active editor index. It also helps to
	 * maintain the collection and the index in sync.   
	 */
	class EmbeddedEditorsCollection {
		private List<IEditorPart> editors;
		private IEditorPart[] editorsArrayCache;
		private int activeEditorIndex;

		EmbeddedEditorsCollection() {
			editors = new ArrayList<IEditorPart>(10);
			editorsArrayCache = null;
			activeEditorIndex = -1; // -1 means there are no active editors
		}

		void add(IEditorPart editor) {
			editors.add(editor);
			editorsArrayCache = null;
		}

		/**
		 * We should never be able to remove the active editor.
		 */
		void remove(IEditorPart editor) {
			IEditorPart currentActiveEditor = getActiveEditor();
			if (currentActiveEditor == editor) {
				throw new IllegalArgumentException(Messages.CompositeEditor_0); 
			}
			editors.remove(editor);
			editorsArrayCache = null;
			// we need to keep the index updated after removing an editor
			setActiveEditor(currentActiveEditor);
		}

		IEditorPart[] getEmbeddedEditors() {
			if (editorsArrayCache == null) {
				editorsArrayCache = (IEditorPart[]) editors.toArray(new IEditorPart[editors.size()]);
			}
			return editorsArrayCache;
		}

		IEditorPart getActiveEditor() {
			// there are no active editors yet
			if (activeEditorIndex == -1) {
				return null;
			}
			IEditorPart[] editors = getEmbeddedEditors();
			return editors[activeEditorIndex];
		}

		boolean contains(IEditorPart editor) {
			return editors.contains(editor);
		}

		void setActiveEditor(IEditorPart editor) {
			if (editor == null) {
				activeEditorIndex = -1;
				return;
			}
			IEditorPart[] editors = getEmbeddedEditors();
			for (int i = 0; i < editors.length; i++) {
				if (editor == editors[i]) {
					activeEditorIndex = i;
					return;
				}
			}
		}
		
		void clearEditors() {
			setActiveEditor(null);
			editors.clear();
			editorsArrayCache = null;
		}
	}

	public CompositeEditor() {
		embeddedEditors = new EmbeddedEditorsCollection();
	}

	/**
	 * Creates an embedded editor corresponding to the given editorId and
	 * connects it to the CompositeEditor.
	 * <p>
	 * It is important to notice that the returned editor will never be
	 * the workbench active part.
	 * <p>
	 * For each composite editor one of its embedded editors should be
	 * designated as the main editor. In order to do that you have to
	 * call <code>CompositeEditor#setMainEditor</code>.
	 * 
	 * @param editor the embedded editor
	 * @param editorComposite the editor's parent composite
	 * @return IEditorPart the embedded editor instance
	 * 
	 * @see CompositeEditor#setMainEditor
	 */
	public IEditorPart connectEditor(String editorId, IEditorInput input, Composite editorComposite) throws CoreException {
		final IEditorPart editor = editorManager.createEditor(editorId, input);
		embeddedEditors.add(editor);

		Composite composite = new Composite(editorComposite, SWT.NONE);
		composite.setLayout(new FillLayout());
		editor.createPartControl(composite);
		editor.addPropertyListener(getPropertyListener());

		// This is the fundamental part of our implementation.
		// Editors are activated when we get an Activate
		// event from the editor's composite.
		associate(editor, composite);

		return editor;
	}

	/**
	 * Associates the control with the given editor. When the control
	 * is activated all the editor contributions will be activated
	 * as well. This is useful when the CompositeEditor is not only
	 * composed by embedded editor but also by other controls. If no editor
	 * is associated with these controls the available contributions
	 * (menus, toolbars, status line, etc...) will be the contributions
	 * for the last active editor and might cause confusion to the user. 
	 */
	public void associate(final IEditorPart editor, Control control) {
		control.addListener(SWT.Activate, new Listener() {
			public void handleEvent(Event event) {
				activateEditor(editor);
			}
		});
	}

	/**
	 * Activates contributions from the given editor and
	 * deactivates contributions from the current editor.
	 */
	protected void activateEditor(IEditorPart newEditor) {
		IEditorPart oldEditor = embeddedEditors.getActiveEditor();
		// It can only be null when the first editor is activated.
		// If that is the case just go ahead and activate newEditor
		if (oldEditor != null) {
			if (oldEditor == newEditor) {
				return;
			}
			editorManager.deactivate(oldEditor);
		}
		editorManager.activate(newEditor);
		embeddedEditors.setActiveEditor(newEditor);
	}

	/**
	 * Removes the given editor from this composite editor. If the given
	 * editor is the current active editor the main editor will be activated
	 * instead. The main editor cannot be disconnected by calling this
	 * method.
	 * 
	 * @exception CoreException if the editor cannot be disconnected. Reasons include:
	 * <ul>
	 * <li> The editor is the main editor.</li>
	 * <li> The editor is the current active editor and the main editor was not defined.</li>
	 * </ul>
	 */
	public void disconnectEditor(IEditorPart editor) throws CoreException {
		if (editor == embeddedEditors.getActiveEditor()) {
			if (mainEditor != null && editor != mainEditor) {
				activateEditor(mainEditor);
			} else {
				IStatus status = new Status(IStatus.ERROR, CommonUIPlugin.PLUGIN_ID, ICompositeEditorConstants.COULD_NOT_DISCONNECT_EDITOR, NLS.bind(Messages.CompositeEditor_Cannot_disconnect_active_editor, (new Object[] { editor.getTitle() })), null); 
				throw new CoreException(status);
			}
		}
		embeddedEditors.remove(editor);
		editor.removePropertyListener(getPropertyListener());
		CompositeEditorSite site = (CompositeEditorSite) editor.getSite();
		CompositeEditorActionBars actionBars = (CompositeEditorActionBars) site.getActionBars();
		actionBars.dispose();
		site.dispose();
		editor.dispose();
	}

	/**
	 * Listens and propagates all property changes from embedded editors.
	 * This is the default implementation. Subclasses may overwrite
	 * and specialize the behaviour.  
	 */
	protected IPropertyListener getPropertyListener() {
		if (propertyListener == null) {
			propertyListener = new IPropertyListener() {
				public void propertyChanged(Object source, int propId) {
					firePropertyChange(propId);
				}
			};
		}
		return propertyListener;
	}

	/**
	 * Disconects all of the embedded editors. Subclasses should implement
	 * internalDispose() instead of dispose();
	 */
	@Override
	public final void dispose() {
		embeddedEditors.setActiveEditor(null);
		internalDispose();
		IEditorPart[] editors = embeddedEditors.getEmbeddedEditors();
		for (int i = 0; i < editors.length; i++) {
			try {
				disconnectEditor(editors[i]);
			} catch (CoreException e) {
				// should never hapen because there should
				// be no active editors at this point
			}
		}
		getEditorSite().getPage().removePartListener(getPartlistener());
		super.dispose();
		getEditorSite().setSelectionProvider(null);
		// discard our references to editors (to help reduce memory leakage)
		embeddedEditors.clearEditors();
		embeddedEditors = null;
	}

	/**
	 * Should be implemented by clients. 
	 */
	protected void internalDispose() {
	}

	@Override
	public boolean isDirty() {
		IEditorPart[] editors = embeddedEditors.getEmbeddedEditors();
		for (int i = 0; i < editors.length; i++) {
			if (editors[i].isDirty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Default implementation saves all of the embedded editors but
	 * it can be overwritten by subclasses.
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		monitor = Policy.monitorFor(monitor);
		try {
			IEditorPart[] editors = getEmbeddedEditorsSaveOrder(embeddedEditors.getEmbeddedEditors());
			String message = Messages.CompositeEditor_2; 
			monitor.beginTask(message, Math.max(1, editors.length));
			for (int i = 0; i < editors.length; i++) {
				final IProgressMonitor subMonitor = Policy.subMonitorFor(monitor, 1);
				final IEditorPart editor = editors[i];
				ISafeRunnable runnable = new ISafeRunnable() {
					public void run() throws Exception {
						editor.doSave(subMonitor);
					}
					public void handleException(Throwable exception) {
					}
				};
				SafeRunnable.run(runnable);				
			}
		} finally {
			monitor.done();
		}
	}

	/**
	 * Defines the order the embedded editors should be saved.
	 * 
	 * @param editors the embedded editors that will be saved
	 * @return the same editors in the order they should be saved 
	 */
	protected IEditorPart[] getEmbeddedEditorsSaveOrder(IEditorPart[] editors) {
		return editors;
	}

	/**
	 * Default implementation. It can be overwritten by subclasses.
	 */
	@Override
	public void setFocus() {
		IEditorPart active = embeddedEditors.getActiveEditor();
		if (active != null) {
			active.setFocus();
		}
	}

	/**
	 * Designate the given editor to be the main editor. 
	 * The editor will be activated.
	 * 
	 * @param editor the main editor
	 * @exception CoreException if the editor cannot be set as the main editor. Reasons include:
	 * <ul>
	 * <li> The editor is not connected to this composite editor.</li>
	 * </ul>
	 */
	public void setMainEditor(IEditorPart editor) throws CoreException {
		if (!embeddedEditors.contains(editor)) {
			IStatus status = new Status(IStatus.ERROR, CommonUIPlugin.PLUGIN_ID, ICompositeEditorConstants.EDITOR_NOT_CONNECTED, Messages.CompositeEditor_3 + editor.getTitle(), null); 
			throw new CoreException(status);
		}
		mainEditor = editor;
		activateEditor(editor);
	}

	/**
	 * Returns the main editor or null if none has been defined. 
	 */
	public IEditorPart getMainEditor() {
		return mainEditor;
	}

	/**
	 * Returns the current active editor.
	 */
	public IEditorPart getActiveEditor() {
		return embeddedEditors.getActiveEditor();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
		editorManager = new CompositeEditorManager(site);
		getEditorSite().getPage().addPartListener(getPartlistener());
		getEditorSite().setSelectionProvider(new CompositeEditorSelectionProvider(this));
	}

	/**
	 * The workbench caches IActionBars according to the editor type (editor id),
	 * so editors of the same type share the same IActionBars instance.
	 * The CompositeEditor controls embedded editors' contributions by deactivating
	 * the previous active embedded editor and activating the new active embedded editor.
	 * If the actions are not deactivated they remain visible for the IActionBars.
	 * When switching between two CompositeEditor instances of the same type (id)
	 * the origin CompositeEditor does not know it has to deactivate its current active
	 * embedded editor and it causes incorrect or duplicate contributions to appear.
	 * The solution is to coordinate the current embedded editor activation and deactivation
	 * with the CompositeEditor (IWorkbenchPart) activation and deactivation.
	 */
	private IPartListener getPartlistener() {
		if (partListener == null) {
			partListener = new IPartListener() {
				public void partActivated(IWorkbenchPart part) {
					if (part == CompositeEditor.this) {
						IEditorPart lastActiveEditor = embeddedEditors.getActiveEditor();
						if (lastActiveEditor != null) {
							editorManager.activate(lastActiveEditor);
						}
					}
				}

				public void partBroughtToTop(IWorkbenchPart part) {
				}

				public void partClosed(IWorkbenchPart part) {
				}

				public void partDeactivated(IWorkbenchPart part) {
					if (part == CompositeEditor.this) {
						editorManager.deactivate(embeddedEditors.getActiveEditor());
					}
				}

				public void partOpened(IWorkbenchPart part) {
				}
			};
		}
		return partListener;
	}

}