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

import java.util.Locale;

import org.eclipse.bpel.common.ui.details.DelegateIValue;
import org.eclipse.bpel.common.ui.details.FocusContext;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.IValue;
import org.eclipse.bpel.common.ui.details.TextIValue;
import org.eclipse.bpel.common.ui.details.ViewerIValue;
import org.eclipse.bpel.common.ui.details.widgets.DecoratedLabel;
import org.eclipse.bpel.common.ui.details.widgets.StatusLabel2;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Documentation;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.details.providers.LanguageContentProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for the "name" property (which is common to most BPEL elements).
 */

@SuppressWarnings("boxing")
public class DocumentationSection extends BPELPropertySection {
	
	protected Text fSourceText;
	protected StatusLabel2 fSourceLabel;
	
	protected StatusLabel2 fLangLabel;
	protected Text fDescription;	
	protected StatusLabel2 fDescriptionLabel;
	
	/** The current documentation model */
	protected Documentation fDocumentation;	
		
	protected Combo fLangCombo;
	protected ComboViewer fLangViewer;
	
	
	EditController fValueEditHelper ;
	EditController fSourceEditHelper;
	EditController fLangEditHelper;
	
	IValue fContext;
	
	BPELExtensibleElement fModelEE;
	

	/**
	 * The adapter here is on the model object for this section, which is any BPELExtensibleElement
	 * 
	 */
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new MultiObjectAdapter() {
				
				@Override
				public void notify (Notification n) {					
					if (markersHaveChanged(n)) {
						updateMarkers();
						return ;
					}
					
					if (n.getFeature() == BPELPackage.eINSTANCE.getBPELExtensibleElement_Documentation()) {
						/** Documentation has been replaced. */
						Documentation eObj = (Documentation) n.getNewValue();
						
						if ( eObj != fDocumentation ) {
							
							fValueEditHelper.setInput( eObj );
							fSourceEditHelper.setInput( eObj );
							fLangEditHelper.setInput( eObj );
							
							fDocumentation = eObj;
						}
					}
				}
			},
		};
	}

	
	CompoundCommand attachDocumentationCommand () {
		CompoundCommand ccmd = null;
		if (fDocumentation.eContainer() == null) {
			ccmd = new CompoundCommand();
			fDocumentation.setSource(fSourceText.getText());
			fDocumentation.setLang(fLangCombo.getText());
			fDocumentation.setValue(fDescription.getText());
			ccmd.add( new SetCommand(fModelEE,fDocumentation,BPELPackage.eINSTANCE.getBPELExtensibleElement_Documentation()) );
		}
		return ccmd;
	}
	
	
	@SuppressWarnings("nls")
	@Override
	protected void basicSetInput (EObject input) {
		
		saveUserContextToInput();
		
		super.basicSetInput (input);
		
		restoreUserContextFromInput();
		
		if (input instanceof BPELExtensibleElement == false) {
			throw new IllegalArgumentException("input must be BPELExtensibleElement");
		}
		
		fModelEE = (BPELExtensibleElement) input;
		
		fDocumentation = fModelEE.getDocumentation();
		
		// Create one if not there.
		if (fDocumentation == null) {
			fDocumentation = BPELFactory.eINSTANCE.createDocumentation();
		}
		
		fValueEditHelper.setInput(fDocumentation) ;
		fSourceEditHelper.setInput(fDocumentation) ;
		fLangEditHelper.setInput(fDocumentation) ;			
	}
	
	 

	@SuppressWarnings("nls")
	protected void createSourceWidgets(Composite composite) {
		FlatFormData data;

		DecoratedLabel nameLabel = new DecoratedLabel(composite,SWT.LEFT);
		fWidgetFactory.adapt(nameLabel);		
		nameLabel.setText(Messages.DocumentationSection_Source_1); 
		fSourceLabel = new StatusLabel2( nameLabel );		
		
		fSourceText = fWidgetFactory.createText(composite, EMPTY_STRING);
		fSourceText.setData(FocusContext.NAME,"source");
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(IDetailsAreaConstants.HSPACE, BPELUtil.calculateLabelWidth(nameLabel, STANDARD_LABEL_WIDTH_AVG));
		data.right = new FlatFormAttachment(100,  -2 * IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		fSourceText.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0,IDetailsAreaConstants.HSPACE );
		data.right = new FlatFormAttachment(fSourceText, 0);
		data.top = new FlatFormAttachment(fSourceText, 0, SWT.CENTER);
		nameLabel.setLayoutData(data);
	}

	@SuppressWarnings("nls")
	protected void createLanguageWidgets(Composite composite) {
		FlatFormData data;

		DecoratedLabel nameLabel = new DecoratedLabel(composite,SWT.LEFT);
		fWidgetFactory.adapt(nameLabel);		
		nameLabel.setText(Messages.DocumentationSection_Language_1); 
		fLangLabel = new StatusLabel2( nameLabel );				
		fLangCombo = new Combo(composite, SWT.READ_ONLY);		
		fWidgetFactory.adapt(fLangCombo);
		fLangCombo.setData(FocusContext.NAME,"language");
		
		fLangViewer = new ComboViewer(fLangCombo);
		fLangViewer.setContentProvider(new LanguageContentProvider());
		fLangViewer.setLabelProvider( new ILabelProvider () {
			public Image getImage(Object element) {				
				return null;
			}

			public String getText(Object element) {
				Locale locale = (Locale) element;
				return locale.getDisplayName();
			}

			public void addListener(ILabelProviderListener listener) {
				
			}

			public void dispose() {			
				
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {				
			}
			
		});		
		fLangViewer.setInput(Locale.getDefault());		
		
		// Combo
		data = new FlatFormData();
		data.left = new FlatFormAttachment(IDetailsAreaConstants.HSPACE, BPELUtil.calculateLabelWidth(nameLabel, STANDARD_LABEL_WIDTH_AVG));
		// data.right = new FlatFormAttachment(100,-2 * IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(fSourceLabel.getControl(), IDetailsAreaConstants.HSPACE);
		fLangCombo.setLayoutData(data);

		// Label
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(fLangCombo, 0 );
		data.top = new FlatFormAttachment(fLangCombo, 0, SWT.CENTER);
		nameLabel.setLayoutData(data);	
									
	}

	@SuppressWarnings("nls")
	protected void createDescriptionWidgets (Composite composite) {
		FlatFormData data;

		DecoratedLabel nameLabel = new DecoratedLabel(composite,SWT.LEFT);
		fWidgetFactory.adapt(nameLabel);		
		nameLabel.setText(Messages.DocumentationSection_Description_1); 
		fDescriptionLabel = new StatusLabel2( nameLabel );		
		
		fDescription = fWidgetFactory.createText(composite, EMPTY_STRING , SWT.V_SCROLL | SWT.MULTI );
		fDescription.setData(FocusContext.NAME,"description");
		
		// description
		data = new FlatFormData();
		data.left = new FlatFormAttachment(IDetailsAreaConstants.HSPACE, BPELUtil.calculateLabelWidth(nameLabel, STANDARD_LABEL_WIDTH_AVG));
		data.right = new FlatFormAttachment(100, -2 * IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(fLangCombo, IDetailsAreaConstants.HSPACE );
		data.bottom = new FlatFormAttachment(100, -3*IDetailsAreaConstants.VSPACE);
		fDescription.setLayoutData(data);

		// label
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE );
		data.right = new FlatFormAttachment(fDescription, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(fDescription, IDetailsAreaConstants.VSPACE, SWT.TOP);		
		nameLabel.setLayoutData(data);	
		
	
	}
	

	

	@Override
	protected EditController createEditController() {
		 return new EditController(getCommandFramework()) {
				@Override
				public Command createApplyCommand() {
					CompoundCommand cmd = attachDocumentationCommand();
					if (cmd != null) {					
						cmd.add (super.createApplyCommand());
						return wrapInShowContextCommand (cmd);
					}
					return wrapInShowContextCommand (super.createApplyCommand() ) ;
				}			
			};
	}


	protected void createChangeTrackers() {			
	
		/** Value Edit Helper */
		fValueEditHelper = createEditController() ;
		fValueEditHelper.setFeature( BPELPackage.eINSTANCE.getDocumentation_Value() );
		fValueEditHelper.setViewIValue(new TextIValue ( fDescription ) );
		fValueEditHelper.startListeningTo(fDescription);
		
		
		/** Source Edit Helper */
		fSourceEditHelper = createEditController() ;	
		fSourceEditHelper.setFeature( BPELPackage.eINSTANCE.getDocumentation_Source() );
		fSourceEditHelper.setViewIValue( new TextIValue ( fSourceText ) );
		fSourceEditHelper.startListeningTo(fSourceText);
		
		
		/** Language Edit Helper */
		fLangEditHelper = createEditController() ;		
		fLangEditHelper.setFeature( BPELPackage.eINSTANCE.getDocumentation_Lang() );		
		fLangEditHelper.setViewIValue( new DelegateIValue( new ViewerIValue ( fLangViewer )) {
			@Override
			public Object get() {				
				Locale locale = (Locale) fDelegate.get() ;
				return locale.getLanguage();
			}
			@Override
			public void set(Object object) {
				fDelegate.set( BPELUtils.lookupLocaleFor( (String) object ));				
			}			
		});
		
		fLangEditHelper.startListeningTo( fLangCombo );
	}
	
	
	
	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		
		createSourceWidgets(composite);
		createLanguageWidgets(composite);
		createDescriptionWidgets(composite);
		
		fContext = new FocusContext( fDescription, fSourceText, fLangCombo );
		
		createChangeTrackers();
		PlatformUI.getWorkbench().getHelpSystem().setHelp(		composite, IHelpContextIds.PROPERTY_PAGE_DOCUMENTATION);
	}

		
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() {		
		return true;
	}

	@Override
	protected void updateMarkers () {				
		fSourceLabel.clear();		
		for(IMarker m : getMarkers(getInput())) {
			fSourceLabel.addStatus( BPELUtil.adapt(m, IStatus.class) );
		}		
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
	public void restoreUserContext (Object userContext) {
		fContext.set( userContext );
	}

	/**
	 * Goto the specific marker. This is only called when isValidMarker
	 * returns true.
	 * 
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#gotoMarker(org.eclipse.core.resources.IMarker)
	 */
	
	@Override
	public void gotoMarker (IMarker marker) {
		// fDescription.setFocus() ;		
	}

	/**
	 * 
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#isValidMarker(org.eclipse.core.resources.IMarker)
	 */
	
	@Override
	public boolean isValidMarker (IMarker marker) {
		return false;
	}	
}
