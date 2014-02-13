/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb.presentation;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IModelStateListener;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;

/**
 * Wraps a {@link StructuredTextEditor} which handles actual source editing.   
 */
@SuppressWarnings("restriction")
public class EsbObjectSourceEditor {
	
	/**
	 * Default input.
	 */
	public static final String EDITOR_DEFAULT_INPUT = "<note>Source not available.</note>";
	
	/**
	 * Used to execute commands.
	 */
	private EsbAdapterFactoryEditingDomain editingDomain;
	
	/**
	 * Internal {@link StructuredTextEditor} instance.
	 */
	private StructuredTextEditor editor;
	
	/**
	 * A custom {@link IEditorInput} used for editing in-memory resources.
	 */
	private IEditorInput input;
	
	/**
	 * Used by the client to listen for editor changes.
	 */
	private IModelStateListener listener;
	
	/**
	 * Currently edited object.
	 */
	private ModelObject modelObject;	
	
	/**
	 * Creates a new {@link EsbObjectSourceEditor} using the specified {@link IFile} as a dummy input.
	 * 
	 * @param dummyFile temporary {@link IFile} to be used as {@link IEditorInput}.
	 * @param editingDomain used to execute commands.
	 */
	public EsbObjectSourceEditor(IFile dummyFile, EsbAdapterFactoryEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
		this.editor = new StructuredTextEditor();
		this.input = new FileEditorInput(dummyFile);
		this.listener = new ModelStateListenerAdapter() {
            public void modelChanged(IStructuredModel model) {
            	handleSourceEditedEvent();
            }			
		};
	}
	
	/**
	 * Method invoked when the user edits the source.	
	 */
	private void handleSourceEditedEvent() {
		if (null != modelObject) {
			if (!modelObject.getObjectState().equals(ModelObjectState.WORKING)) {
				Command setObjectStateCommand = new SetCommand(editingDomain, modelObject, EsbPackage.eINSTANCE
						.getModelObject_ObjectState(), ModelObjectState.WORKING);
				editingDomain.getCommandStack().execute(setObjectStateCommand);
			}
			modelObject.setSourceText(getSource());
		}
	}
	
	/**
	 * @return current source content of the editor.
	 */
	private String getSource() {
		return editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
	}
	
	/**
	 * Updates this source editor to represent the specified {@link ModelObject}.
	 * 
	 * @param object {@link ModelObject} to be edited.
	 */
	public void update(ModelObject object) {
		String newSource = null;		
		try {
			newSource = EsbFactory.eINSTANCE.serializeToString(object);
		} catch (Exception ex) {
			// TODO: Get rid of this.
			ex.printStackTrace();
		}	
		
		IStructuredModel model = getStructuredModel();

		// Remove the listener so that no events are fired during update.
		if (null != model) {
			model.removeModelStateListener(listener);
		}

		// Save model object.
		this.modelObject = object;

		if (null == newSource) {
			// Reset source editor input.
			getDocument().set(EDITOR_DEFAULT_INPUT);
		} else {
			// Avoid un-necessay refreshing.
			if (!getSource().equals(newSource)) {
				// Change source editor input.
				getDocument().set(newSource);
			}

			// Add back source listner.
			model = getStructuredModel();
			if (null != model) {
				model.addModelStateListener(listener);
			}
		}
	}
	
	/**
	 * Utility method for obtaining the current {@link IDocument} instance.
	 * 
	 * @return {@link IDocument} corresponding to current {@link IEditorInput}.
	 */
	private IDocument getDocument() {
		return editor.getDocumentProvider().getDocument(editor.getEditorInput());
	}
	
	/**
	 * Attempts to retrieve the {@link IStructuredModel} used by the internal {@link StructuredTextEditor}.
	 * 
	 * @return {@link IStructuredModel} used by the source editor or null. 
	 */
	private IStructuredModel getStructuredModel() {
		IDocument document = getDocument();
		IStructuredModel model = StructuredModelManager.getModelManager().getExistingModelForEdit(document);					
		if (null == model && (document instanceof IStructuredDocument)) {
			model = StructuredModelManager.getModelManager().getModelForEdit((IStructuredDocument) document);
		}
		return model;
	}	
	
	/**
	 * @return internal {@link IEditorPart} instance.
	 */
	public IEditorPart getEditor() {
		return editor;
	}
	
	/**
	 * @return internal {@link IEditorInput} instance.
	 */
	public IEditorInput getInput() {
		return input;
	}

	/**
	 * @return internal document being edited.
	 */
	public ModelObject getObject() {
		return modelObject;
	}
}
