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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.bpel.common.ui.Utils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.internal.EditorActionBuilder;
import org.eclipse.ui.internal.EditorSite;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.registry.EditorDescriptor;


/**
 * Handles embedded editor's contributions activation and deactivation.
 */
public class CompositeEditorManager {

	protected WorkbenchPage page;
	protected IEditorSite mainEditorSite;
	protected Map idToDescriptor;

	private static final String EXTPT_EMBEDDED_EDITORS = "embeddedEditors"; //$NON-NLS-1$
	private static final String CHILD_EDITOR = "editor"; //$NON-NLS-1$
	private static final String ATT_EDITOR_ID = "id"; //$NON-NLS-1$
	private static final String ATT_EDITOR_CLASS = "class"; //$NON-NLS-1$

	public CompositeEditorManager(IEditorSite mainEditorSite) {
		this.mainEditorSite = mainEditorSite;
		idToDescriptor = new HashMap(10);
		page = (WorkbenchPage) mainEditorSite.getPage();
	}

	/**
	 * Creates and initializes an IEditorPart given its id and input. 
	 */
	public IEditorPart createEditor(String editorId, IEditorInput input) throws CoreException {
		IEditorPart editor = instantiateEditor(editorId);
		EditorSite site = createEditorSite(editorId, editor);
		editor.init(site, input);

		// Force menus to be created.
		IMenuManager menuManager = mainEditorSite.getActionBars().getMenuManager();
		menuManager.setVisible(false);
		menuManager.setVisible(true);

		return editor;
	}

	/**
	 * Instantiates an editor given its id. The editor id has to be declared
	 * through the <code>embeddedEditors</code> extension point.
	 * 
	 * @throws CoreException if the editorId is not found
	 */
	protected IEditorPart instantiateEditor(String editorId) throws CoreException {
		EditorDescriptor descriptor = (EditorDescriptor) idToDescriptor.get(editorId);
		if (descriptor == null) {
			descriptor = readDescriptor(editorId);
			if (descriptor == null) {
				IStatus status = new Status(IStatus.ERROR, CommonUIPlugin.PLUGIN_ID, ICompositeEditorConstants.COULD_NOT_INSTANTIATE_EDITOR, NLS.bind(Messages.CompositeEditorManager_Could_not_find_editor, (new Object[] { editorId })), null); 
				throw new CoreException(status);
			}
		}
		return (IEditorPart) descriptor.getConfigurationElement().createExecutableExtension(ATT_EDITOR_CLASS);
	}

	/**
	 * Creates an editor descriptor based on the information defined in the <code>embeddedEditors</code>
	 * extension point for the given editorId.
	 * 
	 * @return the editor descriptor or <code>null</code> if there none for the given editorId  
	 */
	protected EditorDescriptor readDescriptor(String editorId) {
		IConfigurationElement[] elements = Utils.getConfigurationElements(EXTPT_EMBEDDED_EDITORS);
		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement element = elements[i];
			if (element.getName().equals(CHILD_EDITOR)) {
				String extensionId = element.getAttribute(ATT_EDITOR_ID);
				if (extensionId == null) {
					// the editor id is mandatory - log error
					String pluginId = element.getDeclaringExtension().getNamespace();
					IStatus status = new Status(IStatus.ERROR, pluginId, ICompositeEditorConstants.MISSING_ATTRIBUTE, Messages.CompositeEditorManager_5, null); 
					CommonUIPlugin.getDefault().getLog().log(status);
				} else if (editorId.equals(extensionId)) {
					// Use reflection to create and set state on an editor descriptor
					// This was done to avoid copying the class to this package
					try {
						Constructor constuctor = EditorDescriptor.class.getDeclaredConstructor(new Class[0]);
						constuctor.setAccessible(true);
						EditorDescriptor descriptor = (EditorDescriptor)constuctor.newInstance(new Object[0]);

						Method method = descriptor.getClass().getDeclaredMethod("setID", new Class[] {String.class});
						method.setAccessible(true);
						method.invoke(descriptor, new Object[]{editorId});

						method = descriptor.getClass().getDeclaredMethod("setConfigurationElement", new Class[] {IConfigurationElement.class});
						method.setAccessible(true);
						method.invoke(descriptor, new Object[]{element});

						idToDescriptor.put(editorId, descriptor);
						return descriptor;
					} catch (SecurityException e) {
						CommonUIPlugin.getDefault().createErrorStatus("Problem creating descriptor for " + editorId, e, true);
					} catch (IllegalArgumentException e) {
						CommonUIPlugin.getDefault().createErrorStatus("Problem creating descriptor for " + editorId, e, true);
					} catch (NoSuchMethodException e) {
						CommonUIPlugin.getDefault().createErrorStatus("Problem creating descriptor for " + editorId, e, true);
					} catch (InstantiationException e) {
						CommonUIPlugin.getDefault().createErrorStatus("Problem creating descriptor for " + editorId, e, true);
					} catch (IllegalAccessException e) {
						CommonUIPlugin.getDefault().createErrorStatus("Problem creating descriptor for " + editorId, e, true);
					} catch (InvocationTargetException e) {
						CommonUIPlugin.getDefault().createErrorStatus("Problem creating descriptor for " + editorId, e, true);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Creates and populates an editor site for the given editor.
	 */
	protected EditorSite createEditorSite(String editorId, IEditorPart editor) {
		EditorDescriptor descriptor = (EditorDescriptor) idToDescriptor.get(editorId);
		IEditorReference ref = new EditorReference();
		EditorSite site = new CompositeEditorSite(mainEditorSite, ref, editor, page, descriptor);
		IEditorActionBarContributor contributor = descriptor.createActionBarContributor();
		site.setActionBars(createEditorActionBars(descriptor, contributor, site));
		return site;
	}

	/**
	 * Creates the action bars for the given editor. It also searches for editor
	 * contribution extensions.
	 */
	protected CompositeEditorActionBars createEditorActionBars(EditorDescriptor descriptor, IEditorActionBarContributor contributor, EditorSite site) {
		String type = String.valueOf(System.currentTimeMillis());
//		IActionBars2 parentActionBars = (IActionBars2) mainEditorSite.getActionBars();
		CompositeEditorActionBars actionBars = new CompositeEditorActionBars(page, site, type);
		if (contributor != null) {
			actionBars.setEditorContributor(contributor);
			contributor.init(actionBars, page);
		}

		// Read action extensions.
		EditorActionBuilder builder = new EditorActionBuilder();
		IEditorActionBarContributor extension = builder.readActionExtensions(descriptor /*WDG , actionBars */);
		if (extension != null) {
			actionBars.setExtensionContributor(extension);
			extension.init(actionBars, page);
		}

		return actionBars;
	}

	/**
	 * Activate contributions.
	 */
	public void activate(IEditorPart editor) {
		editor.setFocus();
		IEditorSite site = editor.getEditorSite();
		CompositeEditorActionBars actionBars = (CompositeEditorActionBars) site.getActionBars();
		actionBars.partChanged(editor);
		actionBars.activate(true);
		((CompositeEditorSite) site).activate();
	}

	/**
	 * Deactivate contributions.
	 */
	public void deactivate(IEditorPart editor) {
		if (editor != null) {
			CompositeEditorActionBars actionBars = (CompositeEditorActionBars) editor.getEditorSite().getActionBars();
			actionBars.deactivate(true);
			IEditorSite site = editor.getEditorSite();
			((CompositeEditorSite) site).deactivate();
		}
	}

	/**
	 * Creates an embedded editor corresponding to the given editorId.
	 * <p>
	 * It is important to notice that the returned editor will never be
	 * the workbench active part.
	 * <p>
	 * @param editorId the embedded editor id
	 * @param editorComposite the editor's parent composite
	 * @return IEditorPart the embedded editor instance
	 * 
	 */
	public IEditorPart createEditor(String editorId, IEditorInput input, Composite editorComposite) throws CoreException {
		final IEditorPart editor = createEditor(editorId, input);

		Composite composite = new Composite(editorComposite, SWT.NONE);
		composite.setLayout(new FillLayout());
		editor.createPartControl(composite);

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
	protected void associate(final IEditorPart editor, Control control) {
		control.addListener(SWT.Activate, new Listener() {
			public void handleEvent(Event event) {
				activate(editor);
			}
		});
		control.addListener(SWT.Deactivate, new Listener() {
			public void handleEvent(Event event) {
				deactivate(editor);
			}
		});
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
	public void disposeEditor(IEditorPart editor) {
		CompositeEditorSite site = (CompositeEditorSite) editor.getSite();
		CompositeEditorActionBars actionBars = (CompositeEditorActionBars) site.getActionBars();
		actionBars.dispose();
		site.dispose();
		editor.dispose();
	}
}