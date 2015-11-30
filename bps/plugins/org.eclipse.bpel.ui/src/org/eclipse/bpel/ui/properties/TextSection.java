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

import org.eclipse.bpel.common.ui.details.IOngoingChange;
import org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Policy;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.expressions.IExpressionEditor;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.widgets.Composite;


/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Nov 15, 2006
 *
 */
@SuppressWarnings("nls")

public abstract class TextSection extends BPELPropertySection implements IGetExpressionEditor {

	static protected final String NL = "\n";
	
	protected IExpressionEditor fEditor;
	// protected boolean isExecutingStoreCommand = false;
	protected boolean updating = false;
	protected IOngoingChange change;
	
	protected void disposeEditor() {
		if (fEditor != null) {
			fEditor.dispose();
			fEditor = null;
		}
	}
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		
		MultiObjectAdapter adapter = new BatchedMultiObjectAdapter() {
			
			boolean needRefresh = false;
			
			@Override
			public void notify (Notification n) {
				
				if (markersHaveChanged(n)) {
					updateMarkers();
					return ;
				}				
				needRefresh = needRefresh || isBodyAffected(n);
				refreshAdapters();
			}
			
			@Override
			public void finish() {
				if (needRefresh) {
					updateWidgets();
				}
				needRefresh = false;
			}
		};
		
		return new MultiObjectAdapter[] { adapter };
	}

	
	
	protected String getCommandLabel() {
		return IBPELUIConstants.CMD_EDIT_EXPRESSION;
	}
	
	protected void createChangeHelper() {
		change = new IOngoingChange() {
			public String getLabel() {
				return getCommandLabel();
			}
			public Command createApplyCommand() {
				if (fEditor == null) {
					return null;
				}
							
				CompoundCommand result = makeCompound ( newStoreToModelCommand( fEditor.getEditorContent()  )) ;
				if (result == null) {
					return null;
				}
				
				// refresh the editor
				result.add(new AbstractEditModelCommand() {
					@Override
					public void execute() { 
						if (fEditor != null) {
							fEditor.markAsClean(); 
						}
						}
					// TODO: is this correct?
					@Override
					public Resource[] getResources() { 
						return EMPTY_RESOURCE_ARRAY; 
					}
					@Override
					public Resource[] getModifiedResources() { 
						return EMPTY_RESOURCE_ARRAY; 
					}
				});
				
				return wrapInShowContextCommand(result);				
			}
			
			public void restoreOldState() {
				updateWidgets();
			}
		};
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
		createEditor(parent);
		createChangeHelper();
	}

	
	protected abstract void createEditor(Composite parent);
	
	protected void notifyEditorChanged() {
		// TODO: why is this method being called before createClient() has finished
		// when a BuiltInExpressionEditor was selected in the model?
		if (change != null) {
			getCommandFramework().notifyChangeInProgress(change);
		}
	}
	
	protected abstract void updateEditor();

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		if (Policy.DEBUG) System.out.println("exprdetails.aboutToBeHidden() - "+this); //$NON-NLS-1$
		super.aboutToBeHidden();
		if (change != null) {
			getCommandFramework().notifyChangeDone(change);
		}
		if (fEditor != null) fEditor.aboutToBeHidden();
	}

	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeShown()
	 */
	@Override
	public void aboutToBeShown() {
		if (Policy.DEBUG) {
			System.out.println("exprdetails.aboutToBeShown() - "+this); //$NON-NLS-1$
		}
		
		// TODO: can't remove the following line because we rely on this event
		// in some places.
		// updateEditor();
		
		super.aboutToBeShown();
		if (fEditor != null) {
			fEditor.aboutToBeShown();
		}
		
//		if (Platform.getWS().equals(Platform.WS_GTK)) {
//			((DetailsArea)detailsArea).getDetailsAreaComposite().getScrolledComposite().pack(true);
//			((DetailsArea)detailsArea).getDetailsAreaComposite().getScrolledComposite().pack(true);
//		}
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#dispose()
	 */
	
	@Override
	public void dispose() {
		super.dispose();
	    disposeEditor();
	}

	
	protected void updateWidgets() {		
		
		assert getInput() != null;
		
		if (!updating) {
			updating = true;
			try {
				updateEditor();
			} finally {
				updating = false;
			}
		}
	}
    

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {		
    	return (fEditor==null)? null : fEditor.getUserContext();
    }

    /**
     * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
     */
    @Override
	public void restoreUserContext(Object userContext) {
    	if (fEditor != null) {
    		fEditor.restoreUserContext(userContext);
    	}
    }
    
	/**
	 * @see org.eclipse.bpel.ui.properties.IGetExpressionEditor#getExpressionEditor()
	 */
	public IExpressionEditor getExpressionEditor() {
		return fEditor;
	}
	
	protected abstract Command newStoreToModelCommand(Object body);
	protected abstract boolean isBodyAffected(Notification n);

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#gotoMarker(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void gotoMarker(IMarker marker) {
		// TODO: Look up the use type.
		String useType = null;
		IExpressionEditor editor = getExpressionEditor();
		// may have not been created yet
		if (editor == null) {
			return ;
		}
		editor.gotoTextMarker(marker, useType, fModelObject);
	}
}
