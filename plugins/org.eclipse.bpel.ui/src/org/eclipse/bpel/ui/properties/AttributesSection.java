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

import org.eclipse.bpel.common.ui.details.DelegateIValue;
import org.eclipse.bpel.common.ui.details.FocusContext;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.IValue;
import org.eclipse.bpel.common.ui.details.ViewerIValue;
import org.eclipse.bpel.common.ui.details.viewers.ComboViewer;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.details.providers.ExpressionEditorDescriptorContentProvider;
import org.eclipse.bpel.ui.details.providers.ExpressionEditorDescriptorLabelProvider;
import org.eclipse.bpel.ui.details.providers.ModelViewerSorter;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.extensions.ExpressionEditorDescriptor;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for attributes of a Process
 */
public class AttributesSection extends BPELPropertySection {
	
	protected Combo fExpressionLanguageCombo;
	protected Combo fQueryLanguageCombo;
	
	protected ComboViewer fExpressionLanguageViewer;
	protected ComboViewer fQueryLanguageViewer;
	
	protected EditController fExpressionLanguageController;
	protected EditController fQueryLanguageController;
	
	protected IValue fContext;
	
	 
	@Override
	protected void basicSetInput(EObject input) {
		saveUserContextToInput() ;
		super.basicSetInput(input);
		restoreUserContextFromInput() ;
		
		/** We assume it is Process */
		fQueryLanguageController.setInput(input);
		fExpressionLanguageController.setInput(input);	
	}
	
	class ExpressionEditorDescriptorIValue extends DelegateIValue {
		ExpressionEditorDescriptorIValue ( IValue arg ) {
			super (arg);
		}		
		/**
		 * @see org.eclipse.bpel.common.ui.details.DelegateIValue#get()
		 */
		@Override
		public Object get() {
			String result = (String) fDelegate.get();
			return result != null ? BPELUIRegistry.getInstance().getExpressionEditorDescriptor( result ) : null;
		}

		/**
		 * @see org.eclipse.bpel.common.ui.details.DelegateIValue#set(java.lang.Object)
		 */
		@Override
		public void set (Object object) {
			ExpressionEditorDescriptor eed = (ExpressionEditorDescriptor) object;
			fDelegate.set( eed != null ? eed.getExpressionLanguage() : null );
		}		
	}
	protected void createChangeTrackers() {
		fExpressionLanguageController = createEditController();
		fExpressionLanguageController.setFeature(BPELPackage.eINSTANCE.getProcess_ExpressionLanguage());
		fExpressionLanguageController.setViewIValue(new ViewerIValue ( fExpressionLanguageViewer ) );
		fExpressionLanguageController.setModeIValue(new ExpressionEditorDescriptorIValue ( 
				fExpressionLanguageController.getModelIValue() ));
		
		fExpressionLanguageController.startListeningTo(fExpressionLanguageCombo) ;

		fQueryLanguageController = createEditController();
		fQueryLanguageController.setFeature(BPELPackage.eINSTANCE.getProcess_QueryLanguage() );
		fQueryLanguageController.setViewIValue(new ViewerIValue ( fQueryLanguageViewer ));
		fQueryLanguageController.setModeIValue(new ExpressionEditorDescriptorIValue ( 
				fQueryLanguageController.getModelIValue() ));
		fQueryLanguageController.startListeningTo(fQueryLanguageCombo) ;
	}

	@SuppressWarnings("nls")
	protected void createAttributesWidgets(Composite composite) {
		FlatFormData data;

		Label expressionLanguageLabel = fWidgetFactory.createLabel(composite, Messages.AttributesDetails_Expression_Language__2);
		fExpressionLanguageCombo = new Combo(composite,SWT.FLAT | SWT.READ_ONLY );
		fWidgetFactory.adapt(fExpressionLanguageCombo);		
		fExpressionLanguageCombo.setData(FocusContext.NAME,"expressionLanguage");
		
		// Expression language combo layout
		fExpressionLanguageViewer = new ComboViewer(fExpressionLanguageCombo);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(expressionLanguageLabel, STANDARD_LABEL_WIDTH_LRG));
		data.right = new FlatFormAttachment(100, (-2) * IDetailsAreaConstants.HSPACE );
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		fExpressionLanguageCombo.setLayoutData(data);

		fExpressionLanguageViewer.setContentProvider(new ExpressionEditorDescriptorContentProvider());
		fExpressionLanguageViewer.setLabelProvider(new ExpressionEditorDescriptorLabelProvider());
		fExpressionLanguageViewer.setSorter(ModelViewerSorter.getInstance());

		// Expression language label layout
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(fExpressionLanguageCombo, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(fExpressionLanguageCombo, 0, SWT.CENTER);
		expressionLanguageLabel.setLayoutData(data);

		fExpressionLanguageViewer.setInput(new Object());
		
		Label queryLanguageLabel = fWidgetFactory.createLabel(composite, Messages.AttributesDetails_Query_Language__2);
		fQueryLanguageCombo = new Combo(composite,SWT.FLAT | SWT.READ_ONLY );
		fWidgetFactory.adapt( fQueryLanguageCombo );		
		fQueryLanguageCombo.setData(FocusContext.NAME,"queryLanguage");
		
		// Query language combo layout
		fQueryLanguageViewer = new ComboViewer(fQueryLanguageCombo);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(queryLanguageLabel, STANDARD_LABEL_WIDTH_LRG));
		data.right = new FlatFormAttachment(100, (-2) * IDetailsAreaConstants.HSPACE );
		data.top = new FlatFormAttachment(fExpressionLanguageCombo, IDetailsAreaConstants.VSPACE);
		fQueryLanguageCombo.setLayoutData(data);

		fQueryLanguageViewer.setLabelProvider(new ExpressionEditorDescriptorLabelProvider());
		fQueryLanguageViewer.setContentProvider(new ExpressionEditorDescriptorContentProvider());
		fQueryLanguageViewer.setSorter(ModelViewerSorter.getInstance());
//		queryLanguageViewer.addFilter(new ExpressionLanguageFilter(new String[0]));

		// Query language label layout
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(fQueryLanguageCombo, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(fQueryLanguageCombo, 0, SWT.CENTER);
		queryLanguageLabel.setLayoutData(data);

		fQueryLanguageViewer.setInput(new Object());
		
		
		fContext = new FocusContext( fExpressionLanguageCombo, fQueryLanguageCombo );
	}

	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		createAttributesWidgets(composite);
		createChangeTrackers();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			composite, IHelpContextIds.PROPERTY_PAGE_ATTRIBUTES);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return fContext.get();
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		fContext.set(userContext);
	}
}
