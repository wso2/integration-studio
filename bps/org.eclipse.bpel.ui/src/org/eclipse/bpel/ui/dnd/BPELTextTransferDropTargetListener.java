/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.dnd;

import java.util.List;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.util.TransferBuffer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;

/**
 *
 * A drop handler that is used to transfer text representations of BPEL into the graphical
 * editor.
 *
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 20, 2007
 *
 */
public class BPELTextTransferDropTargetListener extends AbstractTransferDropTargetListener  {

	@SuppressWarnings("nls")

	/** The reader which we use as a conversion */
	org.eclipse.bpel.model.resource.BPELReader fReader = null;

	/** The create request that we generate from the content of the clipboard. */
	Request fTargetRequest = null;

	/** The target resource */
	protected Resource fTargetResource;

	protected BPELEditor fEditor;


	/** The from source factory */
	class FromSourceFactory implements CreationFactory {

		EObject fNewObject = null;

		FromSourceFactory ( EObject newObject) {
			this.fNewObject = newObject;
		}


		/**
		 * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
		 */
		@Override
		public Object getNewObject() {
			return this.fNewObject;
		}

		/**
		 * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
		 */

		@Override
		public Object getObjectType() {
			EObject eObj = (EObject) getNewObject();
			if (eObj != null) {
				return eObj.eClass();
			}
			return null;
		}
	}


	@Override
	protected void unload() {
		super.unload();
		this.fTargetRequest = null;
	}


	/**
	 * Constructs a listener on the specified viewer.
	 * @param viewer the EditPartViewer
	 * @param editor
	 */

	public BPELTextTransferDropTargetListener (EditPartViewer viewer, BPELEditor editor ) {
		super(viewer, TextTransfer.getInstance() );

		this.fReader = new org.eclipse.bpel.model.resource.BPELReader();
		this.fEditor = editor;
	}

	/**
	 * We create the target request once from the content of the clipboard.
	 * We attempt to parse the clipboard and then push the result in the creation
	 * factory so that the usual editor mechanics apply.
	 *
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#createTargetRequest()
	 */
	@SuppressWarnings("nls")
	@Override
	protected Request createTargetRequest() {

		CreateRequest request = new CreateRequest();
		String data = (String) TextTransfer.getInstance().nativeToJava(getCurrentEvent().currentDataType);

		try {
			List<EObject> list = this.fReader.fromXML(TransferBuffer.adjustXMLSource(data), "Drag-Session", this.fEditor.getResource() );			 //$NON-NLS-1$
			if (list.size() > 0) {
				request.setFactory(new FromSourceFactory(list.get(0)) );
				return request;
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}

		// Mickael Istria:
		// In case nothing to DND or error occurred
		// Command cannot be executed because not CreationFactory was provided. Then dropListener.isEnabled will return false.
		// Vincent Zurczak:
		// Yes, but, in fact, the command may not be created (illegal argument exception because the factory is null)
		// Fixed below by surrounding the isEnabled by a try/catch
		setEnablementDeterminedByCommand( true );
		return request;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener
	 * #isEnabled(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public boolean isEnabled( DropTargetEvent event ) {
		boolean result = false;
		try {
			result = super.isEnabled( event );
		} catch( Exception e ) {
			// nothing
		}

		return result;
	}


	/**
	 * A helper method that casts the target Request to a CreateRequest.
	 * @return CreateRequest
	 */
	protected final CreateRequest getCreateRequest() {
		return (CreateRequest) getTargetRequest();
	}


	/**
	 *
	 * @see AbstractTransferDropTargetListener#handleDragOperationChanged()
	 */
	@Override
	protected void handleDragOperationChanged() {
		if (getCreateRequest().getNewObject() == null ) {
			getCurrentEvent().detail = DND.DROP_NONE;
		} else {
			getCurrentEvent().detail = DND.DROP_COPY;
		}
		super.handleDragOperationChanged();
	}

	/**
	 * The purpose of a template is to be copied. Therefore, the Drop operation is set to
	 * <code>DND.DROP_COPY</code> by default.
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#handleDragOver()
	 */
	@Override
	protected void handleDragOver() {
		if ( getCreateRequest().getNewObject() == null ) {
			getCurrentEvent().detail = DND.DROP_NONE;
			getCurrentEvent().detail = DND.FEEDBACK_NONE;
		} else {
			getCurrentEvent().detail = DND.DROP_COPY;
			getCurrentEvent().feedback = DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
		}
		super.handleDragOver();
	}

	/**
	 * Overridden to select the created object.
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#handleDrop()
	 */
	@Override
	protected void handleDrop() {
		CreateRequest cr = getCreateRequest();
		super.handleDrop();

		selectAddedObject( cr );
	}

	private void selectAddedObject ( CreateRequest cr ) {
		Object model = cr.getNewObject();
		if (model == null) {
			return ;
		}

		EditPartViewer viewer = getViewer();
		viewer.getControl().forceFocus();
		Object editpart = viewer.getEditPartRegistry().get(model);
		if (editpart instanceof EditPart) {
			//Force a layout first.
			getViewer().flush();
			viewer.select((EditPart)editpart);
		}
	}



	/**
	 *
	 */
	@Override
	protected Request getTargetRequest() {
		if (this.fTargetRequest == null) {
			this.fTargetRequest = createTargetRequest();
		}
		return this.fTargetRequest;
	}


	/**
	 * Assumes that the target request is a {@link CreateRequest}.
	 */
	@Override
	protected void updateTargetRequest() {
		CreateRequest request = getCreateRequest();
		request.setLocation(getDropLocation());
	}

}
