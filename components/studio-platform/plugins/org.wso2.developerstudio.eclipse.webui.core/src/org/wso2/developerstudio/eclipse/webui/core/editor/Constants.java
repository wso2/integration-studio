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
package org.wso2.developerstudio.eclipse.webui.core.editor;

public class Constants {
	
	/////////////////////////////////////////////////////////////\\\\
	//Handlers that should be implemented by web app developer.\\\\\\
	///////////////////////////////////////////////////////////////\\\

	/**
	 * Scope:Required
	 * 
	 * Signature : function loadFileContent(){...}
	 * 
	 * This function will be called by the framework when the Editor is opened 
	 * for the first time or need to be refreshed from the file.
	 * 
	 *  Due to a limitation in SWT Browser framework, passing file content to editor or 
	 *  getting file content from editor is not directly possible for Web Editor framework.
	 *  Its only possible via callback methods offered by framework.
	 *  
	 *  Therefore you will have to use IDEGetFileContent callback function to get content.
	 * 
	 * eg: function loadFileContent(){
	 * 		  ...
	 * 		  var fileContent = IDEGetFileContent();
	 * 		  ...
	 * 		  ...// logic to generate editor view from content
	 * 	   }
	 * 
	*/
	public static final String APP_LOAD_FILE_CONTENT_FUNCTION = "loadFileContent";
	
	/**
	 * Scope:Required
	 * 
	 * Signature: function saveFile(){...}
	 * 
	 * This function will be called by framework each time save command is executed 
	 * in IDE. Implement any finalizing logic for content and finally execute 
	 * IDESaveContent callback function provided by the framework to save the content back
	 * to file.
	 * 
	 *  eg:	function saveFile(){
	 *  		...
	 *  		var updatedContent = ...;
	 *  		...//logic to finalize content
	 *  		IDESaveContent(updatedContent);
	 *  	}
	 */
	public static final String APP_SAVE_FILE_FUNCTION = "saveFile";
	
	/**
	 * Scope:Required
	 * 
	 * Signature: function saveFileWithExtention(){...}
	 * 
	 * This function will be called by framework each time when try to save a file 
	 * with a specific extension 
	 * Implement any finalizing logic for content and finally execute 
	 * IDESaveContentWithExtention callback function provided by the framework to save the content back
	 * to file.
	 * 
	 *  eg:	function saveTempFile(){
	 *  		...
	 *  		var updatedContent = ...;
	 *  		...//logic to finalize content
	 *  		IDESaveContentWithExtention(updatedContent,"mappinConfig","config","dmc");
	 *  	}
	 */
	public static final String APP_SAVE_FILE_WITH_EXTNTION_FUNCTION = "saveFileWithExtention";
	
	/**
	 * Scope:Optional:Only if you need Eclipse Undo/Redo support to your editor.
	 * 
	 * Signature: function undoOperation(uniqueOperationID){...}
	 * 			  function redoOperation(uniqueOperationID){...}
	 * 
	 * These handlers will be called by the framework each time undo/redo command is executed on editor.
	 * 
	 * IMPORTANT: Undo/Redo support in Framework.
	 * 
	 * If you are doing a reversible operation, use below steps to activate Eclipse undo/redo support.
	 * 
	 *   1. Maintain two stacks(for undo/redo) of objects (each object having a unique ID).
	 *   	Each of these objects will contain logic to redo/undo a task.
	 *   2. After doing a reversible operation, inform Eclipse about it using IDEExecUndoableOperation
	 *      callback provided by the framework.
	 *      eg:
	 *      IDEExecUndoableOperation(label, uniqueOperationID);
	 *      //label should contain a brief summary about operation and will be displayed
	 *      //in undo/redo menu item of eclipse.
	 *   3. After doing step 2, Eclipse undo stack will contain this operation and its label
	 *      will be displayed under undo menu in edit menu.
	 *   4. When user execute undo/redo command (via menu or shortcut) in Eclipse, undo/redo handlers 
	 *   	of your app - namely function undoOperation(uniqueOpID) and function redoOperation(uniqueOpID) -
	 *      will be called by the framework accordingly.
	 *   5. Once you are notified about undo/redo event as mentioned in above step, you can
	 *      fetch the operation object from the stack(step 1) using the unique ID returned to you
	 *      by framework and execute undo/redo logic from the operation object.
	 * 
	 *  eg:	function doAReversibleThing(){
	 *          var operation = new MoveObjectOperation(uniqueID);
	 *          ... //execute operation tasks
	 *          putToUndoStack(operation);
	 *          //finally inform Eclipse about this
	 *          IDEExecUndoableOperation(operation.getLabel(), operation.getID());
	 *      }
	 *		// Implement Undo Handler - This will be called by framework
	 *      function undoOperation(uniqueID){
	 *  		var operation = getFromUndoStack(uniqueID);
	 *          ...//execute undo logic
	 *  		putToRedoStack(operation);	
	 *  	}
	 *  
	 *     // Implement Redo Handler - This will be called by framework
	 *      function redoOperation(uniqueID){
	 *  		var operation = getFromRedoStack(uniqueID);
	 *          ...//execute redo logic
	 *  		putToUndoStack(operation);	
	 *  	}
	 */
	public static final String APP_UNDO_FUNCTION = "undoOperation";	
	public static final String APP_REDO_FUNCTION = "redoOperation";

	
	/** Scope:Optional:Only needed if you are implementing a Eclipse multi-page Editor 
	 * 
	 *  signature: function getDirtyContent(){...} or function setDirtyContent(){..}
	 *  
	 *  These functions will help to avoid loadFileContent/saveFile functions when you are switching
	 *  between different pages in multi-page editor and will provide an in-memory place holder
	 *  for content while switching pages.
	 *  
	 *  If you are switching pages, if current page is the web based editor, framework will
	 *  call getDirtyContent() to get dirty content of web editor so that it can be passed
	 *  to whatever the editor in next page without saving to original file.
	 *  
	 *  In the opposite case, framework will invoke setDirtyContent function so that web editor
	 *  can redraw the editor with the update content without having to save/load from original file.
	 *   
	 *  Due to a limitation in SWT Browser framework, passing file content to editor or 
	 *  getting file content from editor is not directly possible for Web Editor framework. Therefore
	 *  inside these two functions, you will always have to call back framework for proper action.
	 *  
	 *  eg: function getDirtyContent(){
	 *  		...//finalize data 
	 *  		var dirtyContent = ...;
				IDESetDirtyContent(dirtyContent)
	 *  	}  
	 *  
	 *  eg: function setDirtyContent(){
	 *  		var dirtyContent = IDEGetDirtyContent();
	 *          ...///redraw with dirty content
	 *  	}  
	 * */
	public static final String APP_SET_DIRTY_CONTENT_FUNCTION = "setDirtyContent";
	public static final String APP_GET_DIRTY_CONTENT_FUNCTION = "getDirtyContent";
	
	
	/////////////////////////////////////////////////////////////////////////////////////////\\\\\\\\\\
	// Functions which will be injected to web page and will be considered as framework functions////\\\
	//////////////////////////////////////////////////////////////////////////////////////\\\\\\\\\\\\\\

	public static final String IDE_EXEC_UNDOABLE_OPERATION_FUNCTION = "IDEExecUndoableOperation";
	public static final String IDE_GET_FILE_CONTENT_FUNCTION = "IDEGetFileContent";
	public static final String IDE_SAVE_CONTENT_FUNCTION = "IDESaveContent";
	public static final String IDE_SET_DIRTY_FUNCTION = "IDESetDirty";
	public static final String IDE_SET_FOCUS_TO_EDITOR_FUNCTION = "IDESetFocusToEditorPart";
	public static final String IDE_SAVE_FILE_CONTENT_FUNCTION_WITH_EXTNTION = "IDESaveContentWithExtention";
	
	/** Only needed if you are implementing a multi-page Editor */
	public static final String IDE_SET_DIRTY_CONTENT_FUNCTION = "IDESetDirtyContent";
	public static final String IDE_GET_DIRTY_CONTENT_FUNCTION = "IDEGetDirtyContent";

	public static final String IDE_GET_INFORMATION_FUNCTION = "IDEGetInformation";
	public static final String CUSTOM_EDITOR_FUNCTION = "ExecuteCustomFunction";
}
