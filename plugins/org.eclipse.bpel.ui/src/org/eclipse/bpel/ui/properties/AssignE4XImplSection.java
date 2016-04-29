/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 * 
 */
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.ButtonIValue;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.AssignE4X;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Extension;
import org.eclipse.bpel.model.ExtensionAssignOperation;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.Snippet;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineBackgroundEvent;
import org.eclipse.swt.custom.LineBackgroundListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;



/**
 * This allows viewing and editing of the AssignE4X element. 
 * 
 * 
 * Editor panel of the AssignE4X activity.
 * 
 * 
 * @author WSO2 Inc. 	
 * @author Hasitha Aravinda (hasitha@wso2.com)
 * 
 */

@SuppressWarnings("nls")
public class AssignE4XImplSection extends BPELPropertySection {

//	Text				fSnippetText;
	StyledText 			fSnippetText;
	
	Composite			snippetTextComposite;
	Button				fIsValidateCheckbox;
	Composite			isValidateComposite;
	
	EditController fValidateController ;
	
	private int index = 0;
	

	/**
	 * Add body to target ExtensionAssignOperation's Snippet
	 * 
	 * @param body Text 
	 * @param target target ExtensionAssign Operation;
	 * @return 
	 */
	protected boolean addToSnippetCommand  (Object body,int target) {
		
		//if there is no text in the fSnippetText 
		if(body==null){
			 body = "";
		}	
		
		// if content changed	
		if(!((String) body).equals(getTxtContent(target))){
			if(getEAOFromModel(target).getSnippet()!=null){
				getCommandFramework().execute( wrapInShowContextCommand((
						new SetCommand( getEAOFromModel(target).getSnippet(), body , 
								BPELPackage.eINSTANCE.getSnippet_Body()))));
			
				refreshAdapters();
				return true;
			}else
			{
				System.err.println("E4X Extension: Error, No snnipet object found");
				return false;
			}
		}else{
			// Text wasn't Changed;
			return false;
		}

	}
	
	
	@Override
	protected void basicSetInput(EObject newInput) {
		if(newInput instanceof AssignE4X){
			super.basicSetInput(newInput);
			updateJSWidgets();
			fValidateController.setInput(newInput);
			addExtensionTag();
		}
	}
	
	/**
	 * isValidate widget
	 * 
	 * @param parentComposite
	 */
	private Composite createIsValidateWidgets(Composite top,Composite parentComposite) {
		FlatFormData data;

		isValidateComposite = createFlatFormComposite(parentComposite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		if (top == null) {
			data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		} else {
			data.top = new FlatFormAttachment(top, IDetailsAreaConstants.VSPACE);
		}	
		data.right = new FlatFormAttachment(100, 0);
		isValidateComposite.setLayoutData(data);

		fIsValidateCheckbox = fWidgetFactory
				.createButton(
						isValidateComposite,
						"Is Validate",
						SWT.CHECK);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		fIsValidateCheckbox.setLayoutData(data);
		
		return isValidateComposite;
	}

	/**
	 * Change Tracker for Validate Controller;
	 */
	void createChangeTrackers() {
		
		/** Parallel execution setting/un-setting */
		fValidateController = createEditController();
		fValidateController.setFeature( BPELPackage.eINSTANCE.getAssignE4X_Validate());
		fValidateController.setViewIValue( new ButtonIValue( fIsValidateCheckbox ));
		fValidateController.startListeningTo( fIsValidateCheckbox );
		
	}
	
	/**
	 * JavaScript Editor Widget
	 * 
	 * @param parentComposite
	 */
	private Composite createJSWidgets(Composite top, Composite parentComposite) {
		FlatFormData data;

		snippetTextComposite = createFlatFormComposite(parentComposite);
		data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		} else {
			data.top = new FlatFormAttachment(top, IDetailsAreaConstants.VSPACE);
		}	
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		snippetTextComposite.setLayoutData(data);

		Label variableLabel = fWidgetFactory
				.createLabel(
						snippetTextComposite,
						"Java Script:");
		
//		fSnippetText = fWidgetFactory.createText(snippetTextComposite,EMPTY_STRING,SWT.MULTI );	
		fSnippetText = new StyledText(snippetTextComposite,  SWT.MULTI |SWT.H_SCROLL|SWT.V_SCROLL | SWT.BORDER);
		fSnippetText.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		fSnippetText.setLeftMargin(10);
		fSnippetText.setRightMargin(10);
		fSnippetText.setTopMargin(5);
		fSnippetText.setBottomMargin(5);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(fSnippetText,-IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0 );
		variableLabel.setLayoutData(data);

				
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, 0);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(	variableLabel, STANDARD_LABEL_WIDTH_AVG));
		data.width = 400;
		data.height = 100;
		fSnippetText.setLayoutData(data);

		fSnippetText.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// writing changes to the bpel file.
				addToSnippetCommand(fSnippetText.getText(),index);
				
			}

			@Override
			public void focusGained(FocusEvent e) {
				// Update JavaScript Widget
				updateJSWidgets();
			}
		});
		
		fSnippetText.addLineBackgroundListener(new LineBackgroundListener() {
			@Override
			public void lineGetBackground(LineBackgroundEvent event) {
				 if(fSnippetText.getLineAtOffset(event.lineOffset) % 2 == 0)
			          event.lineBackground = new Color(Display.getDefault(),204,204,255);
			      }
			}
		); 
		
		return snippetTextComposite;
	}
	
	/**
	 * Update JavaScript Widget
	 */
	private void updateJSWidgets(){
		int targetEAO = 0; // This UI implementation supports only for single EAO;
		
		if(getEAOFromModel(targetEAO)!=null)
		{	String st = null;
			fSnippetText.setText("");
			
			st= getTxtContent(targetEAO);
			if(st!=null)
			{
				fSnippetText.setText(st);
			}
		}	
	}
	
	/**
	 * E4X Model support for multiple ExtesionAssignOperations ,
	 * 
	 * Returns snippet body of given ExtensionAssignOperation
	 */
	protected String getTxtContent(int index) {
		EList<ExtensionAssignOperation> fEAOlist = ((AssignE4X)getInput()).getExtensionAssignOperation();
		ExtensionAssignOperation feao;
		Snippet fsnippt;
		String st= null;
		
			try {
				if(fEAOlist.size()>0){
					feao = fEAOlist.get(index);
					fsnippt= feao.getSnippet();
					st = (String) fsnippt.getBody();
				}
			}catch(Exception ex){
				System.err.println("Warning: Error while reading snippet body");
				ex.printStackTrace();
			}finally{
				if (st==null)
					st="";
			}
		return st;
	}
	
	
	
	/**
	 * Creating <Extensions /> & <extension /> tags
	 */
	protected void addExtensionTag() {
		Extensions exts;
		Extension ext;
		String ns= "http://ode.apache.org/extensions/e4x";
		boolean isExtensionExist=false;
		if(BPELUtils.getProcess(getInput())!=null){
			
			Process process = BPELUtils.getProcess(getInput());
			
			// check for <extenstions>
			exts = ((BPELUtils.getProcess(getInput())).getExtensions());
			if(exts!=null){
				isExtensionExist = false;
				//check for existing <extension> with ns;
				for(Extension extension: exts.getChildren())
				{
					if(ns.equalsIgnoreCase(extension.getNamespace())){
						//found <extension> with ns;
						isExtensionExist = true;
						break;
					}
				}
			}else {
				exts = BPELFactory.eINSTANCE.createExtensions();
				isExtensionExist = false;
			}
			// Create tags;
			if(!isExtensionExist){
				ext = BPELFactory.eINSTANCE.createExtension();
				ext.setMustUnderstand(true);
				ext.setNamespace(ns);
				exts.getChildren().add(ext);
				getCommandFramework().execute( wrapInShowContextCommand((
						new SetCommand( process, exts, BPELPackage.eINSTANCE.getProcess_Extensions()))));
			}
		}else{
			System.err.println("Error: Fail to add Extensions;");
		}
	}
	
	/**
	 * returns ExtensionAssignOperation,from given index number
	 * @param target
	 * @return
	 */
	
	protected ExtensionAssignOperation getEAOFromModel(int target) {
		
		EObject parrentAssign = getInput();		
		if (parrentAssign != null) {
			EObjectContainmentEList result =  (EObjectContainmentEList) parrentAssign.eGet( BPELPackage.eINSTANCE.getAssignE4X_ExtensionAssignOperation() );		
			if(result.data()!=null)
			if (result.get(target) instanceof ExtensionAssignOperation) {
				return (ExtensionAssignOperation) result.get(target);
			}
		}		
		return null;
	}



	
	@Override
	protected void createClient(Composite parent) {
		Composite parentComposite = createFlatFormComposite(parent);
		Composite ref =null;
		ref = createIsValidateWidgets(ref,parentComposite);
		ref = createJSWidgets(ref,parentComposite);

		createChangeTrackers();
		
	}
}
