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
package org.eclipse.bpel.common.ui.palette;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;


/**
 * Graphical editor to be integrated with a GEFDetailsEditor.
 */
@SuppressWarnings("nls")
public abstract class GraphicalEditorWithPalette extends GraphicalEditorWithFlyoutPalette {

	static final String EXTPT_PALETTE_ADDITIONS = "paletteAdditions";
	static final String ELEMENT_ADDITIONS = "additions";
	static final String ATT_PROVIDER = "provider"; 
	static final String ATT_IMPORTANCE = "importance";
	static final String ATT_CLASS = "class"; 
	static final String ATT_DEFAULT = "default";
	
	static final String ATT_CATEGORY = "category";
	static final String ATT_CATEGORY_ID = "categoryId";
	static final String ATT_CATEGORY_ORDER = "categoryOrder";
	
	static final String ATT_TARGET_EDITOR = "targetEditor";
		
	
	private PaletteRoot paletteRoot;

	
	/**
	 * 
	 */
	public GraphicalEditorWithPalette() {
		super();
	}

	
	/**
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		paletteRoot = null;
	}

	
	@Override
	protected CustomPalettePage createPalettePage() {
		return new CustomPalettePage(getPaletteViewerProvider()) {
			
			@Override
			public void init(IPageSite pageSite) {
				super.init(pageSite);
				
				IAction copy = getActionRegistry().getAction(ActionFactory.COPY.getId());
				pageSite.getActionBars().setGlobalActionHandler(
						ActionFactory.COPY.getId(), copy);
				
			}
		};
	}

	

	/**
	 * Get the action registry.
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#getActionRegistry()
	 */
	
	@Override
	protected ActionRegistry getActionRegistry() {		
		return super.getActionRegistry();
	}



	@Override
	protected PaletteViewerProvider createPaletteViewerProvider() {
		
		return new PaletteViewerProvider(getEditDomain()) {			
			@Override
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				// viewer.setCustomizer(new LogicPaletteCustomizer());
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
		};
	}
	
	/**
	 * The implementation in new versions of GraphicalEditor assumes that 'this' will be
	 * the top-level editor.  For us, the assumption is most likely wrong--a DetailsEditor
	 * is probably the top-level editor...  
	 */
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// Bugzilla 330526
		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				updateActions(getSelectionActions());
			}
		});
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		if (paletteRoot == null) {
			paletteRoot = new PaletteRoot();			
			createPalette ();
		}

		return paletteRoot;
	}

	
	
	HashMap<String,IOrderedPaletteEntry> paletteContainers () {
		
		// Create extension items
		HashMap<String,IOrderedPaletteEntry> map = new HashMap<String,IOrderedPaletteEntry>();		
		
		for(Object next : paletteRoot.getChildren()) {
			if (next instanceof IOrderedPaletteEntry) {
				IOrderedPaletteEntry entry = (IOrderedPaletteEntry)next;
				map.put(entry.getCategoryId(), entry);
			}
		}
		return map;
	}
	
	
	protected String getPaletteAdditionsContributorId() {
		return getEditorSite().getId();
	}
	
	
	
	
	protected void createPalette ( ) {
		
		// Get the id of this editor
		String id = getPaletteAdditionsContributorId();
				
		ArrayList<IConfigurationElement> listOfAdditions = new ArrayList<IConfigurationElement>();
		
		for( IConfigurationElement additions : getConfigurationElements(EXTPT_PALETTE_ADDITIONS) ) {	
			
			if (additions.getName().equals(ELEMENT_ADDITIONS) == false || 
					id.equals ( additions.getAttribute(ATT_TARGET_EDITOR)) == false ) {
				continue;
			}										
			listOfAdditions.add( additions );
		}
		
		
		// Sort the additions in order.
		Collections.sort(listOfAdditions, new Comparator<IConfigurationElement> () {			
			int getInt ( String n ) {
				try {
					return Integer.parseInt(n);
				} catch (Throwable t) {
					return 10;
				}
			}			
			public int compare(IConfigurationElement o1, IConfigurationElement o2) {
				return getInt ( o1.getAttribute(ATT_IMPORTANCE) ) - 
				       getInt ( o2.getAttribute(ATT_IMPORTANCE) );
			}			
		});
		
		
		HashMap<String,IOrderedPaletteEntry> containerMap = null;
		
		// Process the palette additions.
		for(IConfigurationElement additions : listOfAdditions ) {
				
			String provider = additions.getAttribute(ATT_PROVIDER);
			if (provider != null) {
				try {
					IPaletteProvider entry = (IPaletteProvider) additions.createExecutableExtension(ATT_PROVIDER);
					entry.contributeItems( paletteRoot );
					// Recompute the categories, added by this bulk-addition
					containerMap = null;
				} catch ( CoreException ce ) {
					CommonUIPlugin.getDefault().getLog().log(ce.getStatus());
				}
			}

			if (containerMap == null) {
				containerMap = paletteContainers();
			}
						
			// Now process individual additions.
			
			for (IConfigurationElement addition: additions.getChildren() ) {
								
				String def = addition.getAttribute(ATT_DEFAULT);
				String categoryName = addition.getAttribute(ATT_CATEGORY);
				String categoryId   = addition.getAttribute(ATT_CATEGORY_ID);
				
				int    categoryOrder = 100;
				
				try {
					categoryOrder = Math.abs( Integer.parseInt( addition.getAttribute(ATT_CATEGORY_ORDER) ) );
				} catch (Throwable t) {
					categoryOrder = 100;
				}
				
				if (categoryId == null) {
					categoryId = "bpel.user";
				}
				

				PaletteContainer container = null;				
				PaletteCategory category = null;
				
				IOrderedPaletteEntry orderedContainer = containerMap.get(categoryId);
				
				if (orderedContainer == null) {
					
					container = category = new PaletteCategory(categoryName); //$NON-NLS-1$					
					
					category.setOrder ( categoryOrder );
					category.setCategoryId ( categoryId );
					
					containerMap.put(categoryId, category);
					
					paletteRoot.add(container);		
					
				} else if (orderedContainer instanceof PaletteCategory) {
					container = category = (PaletteCategory) orderedContainer;
				} else if (orderedContainer instanceof PaletteContainer) {
					container = (PaletteContainer) orderedContainer;
				} 
								
				
				try {
					
					ToolEntry entry = (ToolEntry)addition.createExecutableExtension(ATT_CLASS);
					
					// The container may be null. This is most likely due to some error in configruation.
					if (container != null) {
						container.add(entry);
					}
					
					if (def != null && def.equals("true") && category != null) { //$NON-NLS-1$
						category.setDefaultTool(entry);
					}
					
				} catch (CoreException e) {
					CommonUIPlugin.getDefault().getLog().log(e.getStatus());
				}
			}
		}
		
		
		// Now sort the palette categories within the list
		
		Collections.sort(paletteRoot.getChildren(), new Comparator () {
			public int compare(Object o1, Object o2) {
				try {				
					IOrderedPaletteEntry e1 = (IOrderedPaletteEntry) o1;
					IOrderedPaletteEntry e2 = (IOrderedPaletteEntry) o2;
					return e1.getOrder() - e2.getOrder();
				} catch (Throwable t) {
					return 0;
				}				
			} 					
		});		
		
	}
	
	
	
	
	
	private IConfigurationElement[] getConfigurationElements(String extensionPointId) {
		
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(CommonUIPlugin.PLUGIN_ID, extensionPointId);
		if (extensionPoint == null) {
			return new IConfigurationElement[0];
		}
		return extensionPoint.getConfigurationElements();
	}
}
