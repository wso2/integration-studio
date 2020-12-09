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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.viewers.CComboViewer;
import org.eclipse.bpel.common.ui.details.widgets.DecoratedLabel;
import org.eclipse.bpel.common.ui.details.widgets.StatusLabel2;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.details.providers.AddSelectedObjectFilter;
import org.eclipse.bpel.ui.details.providers.ModelTreeLabelProvider;
import org.eclipse.bpel.ui.details.providers.OperationsTreeContentProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.BrowseUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.PortType;

/**
 * VariableTypeSection provides viewing and editing of the type of a BPEL variable
 * (whether that be an XSD type, WSDL message, or built-in simple type).
 */

@SuppressWarnings("boxing")

public class PartnerLinkImplSection extends BPELPropertySection {

	private static final int BID_MY_ROLE_1 = 1;
	private static final int BID_MY_ROLE_2 = 2;
	private static final int BID_MY_ROLE_NONE = 3;
	
	private static final int BID_PARTNER_ROLE_1 = 101;
	private static final int BID_PARTNER_ROLE_2 = 102;
	private static final int BID_PARTNER_ROLE_NONE = 103;
	
	private static final int BID_INITIALIZE_PARTNER_ROLE = 201;
	
	
	private static final Role[] NO_ROLES = {};		
	
	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() { 
		return true; 
	}
	
	protected boolean inUpdate = false;
	
	protected Composite interfaceComposite, referenceComposite;

	protected Composite parentComposite;
	
	protected Button interfaceBrowseButton;
	protected AddSelectedObjectFilter interfaceAddSelectedObjectFilter;

	protected CComboViewer referenceViewer;
	protected Button referenceBrowseButton;
	protected AddSelectedObjectFilter referenceAddSelectedObjectFilter;

	protected int lastChangeContext = -1;
	
	private Button partnerLinkTypeBrowseButton;
	
	private Button fMyRole1;
	private Button fMyRole2;
	private Button fMyRoleNone;
	private Button fPartnerRole1;
	private Button fPartnerRole2;
	private Button fPartnerRoleNone;
	private Role[] fRoles;
	
	private TreeViewer fMyOperationsTreeViewer;
	private TreeViewer fPartnerOperationsTreeViewer;
	
	private Hyperlink fPartnerLinkTypeHref;
	
	private StatusLabel2 fPartnerLinkTypeLabel;
	
	private Button fInitializePartnerRole;
	

	static Set<EStructuralFeature> notificationInterest = new HashSet<EStructuralFeature>();
	static {
		notificationInterest.add ( BPELPackage.eINSTANCE.getPartnerLink_PartnerLinkType() );
		notificationInterest.add ( BPELPackage.eINSTANCE.getPartnerLink_MyRole() );
		notificationInterest.add ( BPELPackage.eINSTANCE.getPartnerLink_PartnerRole() );	
		notificationInterest.add ( BPELPackage.eINSTANCE.getPartnerLink_InitializePartnerRole() );
		
		notificationInterest.add ( PartnerlinktypePackage.eINSTANCE.getPartnerLinkType_Role() );
		notificationInterest.add ( PartnerlinktypePackage.eINSTANCE.getRole_PortType() );
		notificationInterest.add ( PartnerlinktypePackage.eINSTANCE.getRole_Name() );
	}
		
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new BatchedMultiObjectAdapter() {
				boolean updateInterface = false;
				boolean refreshAdapters = false;
				
				@Override
				public void notify(Notification n) {
					updateInterface = updateInterface || notificationInterest.contains( n.getFeature() );
					refreshAdapters = refreshAdapters || updateInterface;
				}
				
				@Override
				public void finish() {
					if (updateInterface) {
						updatePartnerLinkTypeWidgets();
						doChildLayout();
						updateInterface = false;
					}
					if (refreshAdapters) {
						refreshAdapters();
						refreshAdapters = false;
					}
				}
			}
		};
	}

	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		if (fAdapters.length > 0) {
			PartnerLink partnerLink = (PartnerLink)getInput();
			if (partnerLink.getPartnerLinkType() != null) {
				fAdapters[0].addToObject(partnerLink.getPartnerLinkType());
			}
			Role[] roles = {partnerLink.getMyRole(), partnerLink.getPartnerRole()};
			for (int i = 0; i < roles.length; i++) {
				Role role = roles[i];
				if (role != null) {
					fAdapters[0].addToObject(role);
				}
			}
		}
	}
	
	
	
	protected Composite createPartnerLinkTypeWidgets (Composite top, final Composite parent) {
		
		FlatFormData data;

		Composite composite = createFlatFormComposite(parent);
		data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VMARGIN);
		} else {
			data.top = new FlatFormAttachment(top,IDetailsAreaConstants.VMARGIN);
		}
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		
		composite.setLayoutData(data);
			
		partnerLinkTypeBrowseButton = fWidgetFactory.createButton(composite, Messages.PartnerLinkImplSection_Browse_1, SWT.PUSH); 

		DecoratedLabel label = new DecoratedLabel ( composite, SWT.LEFT );
		label.setText( Messages.PartnerLinkImplSection_0 );
		fWidgetFactory.adapt(label);
		
		fPartnerLinkTypeLabel = new StatusLabel2 ( label ); 

		fPartnerLinkTypeHref = fWidgetFactory.createHyperlink(composite, "", SWT.NONE); //$NON-NLS-1$
		fPartnerLinkTypeHref.addHyperlinkListener(new HyperlinkAdapter() {
			
			@Override
			public void linkActivated(HyperlinkEvent e) {
				PartnerLinkType plt = getPartnerLinkType();
				if (plt == null) {
					return ;
				}				
				BPELUtil.openEditor(getPartnerLinkType(), getBPELEditor());
			}
		});
		fPartnerLinkTypeHref.setToolTipText(Messages.PartnerLinkImplSection_1);
				
		 
		partnerLinkTypeBrowseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {				
				browseForPartnerLink();
			}
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
		

		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		// data.bottom = new FlatFormAttachment(fPartnerLinkTypeHref, -2, SWT.BOTTOM);
		data.right = new FlatFormAttachment(100,-IDetailsAreaConstants.HSPACE);
		partnerLinkTypeBrowseButton.setLayoutData(data);		
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0,IDetailsAreaConstants.HSPACE);		
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE );
		fPartnerLinkTypeLabel.setLayoutData(data);
	
//		data = new FlatFormData();
//		data.left = new FlatFormAttachment(partnerLinkTypeLabel, IDetailsAreaConstants.HSPACE);
//		data.top = new FlatFormAttachment(partnerLinkTypeLabel, -4 , SWT.TOP);
//		// data.bottom = new FlatFormAttachment(partnerLinkTypeLabel, 4 , SWT.BOTTOM);
//		data.right = new FlatFormAttachment( partnerLinkTypeBrowseButton, -30 );
//		partnerLinkTypeName.setLayoutData(data);		
						
		data = new FlatFormData();
		data.right = new FlatFormAttachment( 60, 0 );
		data.left = new FlatFormAttachment ( fPartnerLinkTypeLabel.getLabel() , 20);
		data.bottom = new FlatFormAttachment ( fPartnerLinkTypeLabel.getLabel(), -1 , SWT.BOTTOM);
		fPartnerLinkTypeHref.setLayoutData(data);
		
		return composite;
		
	}

	protected void browseForPartnerLink ( ) {
		
		Object obj = BrowseUtil.browseForPartnerLinkType( getInput() , 
				partnerLinkTypeBrowseButton.getShell() );
		if (obj == null) {
			return;
		}
		
		if (obj instanceof PartnerLinkType) {
			setPartnerLinkType ( (PartnerLinkType) obj);
		}						
	}


	protected Composite createMyRolePartnerRoleWidgets ( Composite top, Composite parent) {

		Composite composite = fWidgetFactory.createComposite(parent);
		FlatFormData data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0,5);
		} else {
			data.top = new FlatFormAttachment(top,5);
		}		
		
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);		
		composite.setLayoutData(data);

		
		GridLayout layout = new GridLayout();
		layout.makeColumnsEqualWidth = true;		
		layout.numColumns = 2;
		composite.setLayout(layout);
		
		GridData gridData;
				
				
		Group myGroup = fWidgetFactory.createGroup(composite,Messages.PartnerLinkImplSection_2);		
		layout = new GridLayout();
		layout.makeColumnsEqualWidth = false;		
		layout.numColumns = 3;		
		myGroup.setLayout(layout);
		gridData = new GridData();        
		gridData.grabExcessVerticalSpace = false;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalIndent = 10;
		gridData.minimumWidth = 150;
		myGroup.setLayoutData(gridData);

		fMyRole1 = createButton(myGroup, null, BID_MY_ROLE_1,    false, SWT.RADIO );
		fMyRole2 = createButton(myGroup, null, BID_MY_ROLE_2,    false, SWT.RADIO);
		fMyRoleNone = createButton(myGroup, Messages.PartnerLinkImplSection_10, BID_MY_ROLE_NONE, true,  SWT.RADIO);
		
		updateRadio(fMyRole1, null);
		updateRadio(fMyRole2, null);
		
		Group partnerGroup = fWidgetFactory.createGroup(composite, Messages.PartnerLinkImplSection_4);		
		
		layout = new GridLayout();
		layout.makeColumnsEqualWidth = false;		
		layout.numColumns = 3;		
		partnerGroup.setLayout(layout);
		gridData = new GridData();        
		gridData.grabExcessVerticalSpace = false;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalIndent = 10;
		gridData.minimumWidth = 150;
		partnerGroup.setLayoutData(gridData);
		
		fPartnerRole1 = createButton(partnerGroup, null, BID_PARTNER_ROLE_1,    false, SWT.RADIO);
		fPartnerRole2 = createButton(partnerGroup, null, BID_PARTNER_ROLE_2,    false, SWT.RADIO);
		fPartnerRoleNone = createButton(partnerGroup, Messages.PartnerLinkImplSection_5, BID_PARTNER_ROLE_NONE, true, SWT.RADIO);

		// The initialize partner role button
		fInitializePartnerRole = createButton(partnerGroup, Messages.PartnerLinkImplSection_11, BID_INITIALIZE_PARTNER_ROLE, false, SWT.CHECK);

		
		updateRadio(fPartnerRole1, null);
		updateRadio(fPartnerRole2, null);		
		
		
		return composite;
	}
	
	protected Composite createRoleWidgets ( Composite top, Composite parent) {
		return createMyRolePartnerRoleWidgets(top, parent);
	}
	
	
	protected Composite createPartnerLinkStructureWidgets (Composite top, Composite parent) {
		
		Composite composite = createFlatFormComposite(parent);
		
		FlatFormData data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0,5);
		} else {
			data.top = new FlatFormAttachment(top,5);
		}		
		
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(100,0);
		
		composite.setLayoutData(data);
			
		Label treeLabel = fWidgetFactory.createLabel(composite, Messages.PartnerLinkImplSection_6); 
		
		// Tree viewer for variable structure ...
		Tree tree  = fWidgetFactory.createTree(composite, SWT.NONE);		
		fMyOperationsTreeViewer = new TreeViewer( tree );
		fMyOperationsTreeViewer.setContentProvider(  new OperationsTreeContentProvider(true) );
		fMyOperationsTreeViewer.setLabelProvider(new ModelTreeLabelProvider());
		fMyOperationsTreeViewer.setInput ( null );
		fMyOperationsTreeViewer.setAutoExpandLevel(4);
		
		// end tree viewer for variable structure
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE + 10 );
		data.top = new FlatFormAttachment(treeLabel, IDetailsAreaConstants.VSPACE, SWT.BOTTOM);
		treeLabel.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE + 10 );
		data.top = new FlatFormAttachment(treeLabel,IDetailsAreaConstants.HSPACE, SWT.BOTTOM);
		data.right = new FlatFormAttachment(50,  -IDetailsAreaConstants.HSPACE) ;		
		data.bottom = new FlatFormAttachment(100, -IDetailsAreaConstants.HSPACE);	
		tree.setLayoutData(data);

		
		treeLabel = fWidgetFactory.createLabel(composite, Messages.PartnerLinkImplSection_7); 
		
		// Tree viewer for variable structure ...
		tree = fWidgetFactory.createTree(composite, SWT.NONE);		
		fPartnerOperationsTreeViewer = new TreeViewer( tree );
		fPartnerOperationsTreeViewer.setContentProvider(new OperationsTreeContentProvider(true));
		fPartnerOperationsTreeViewer.setLabelProvider(new ModelTreeLabelProvider());
		fPartnerOperationsTreeViewer.setInput ( null );
		fPartnerOperationsTreeViewer.setAutoExpandLevel(4);
		
		// end tree viewer for variable structure
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(50, IDetailsAreaConstants.HSPACE + 10 );
		data.top = new FlatFormAttachment(treeLabel, IDetailsAreaConstants.VSPACE, SWT.BOTTOM);
		treeLabel.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(50, IDetailsAreaConstants.HSPACE + 10 );
		data.top = new FlatFormAttachment(treeLabel,IDetailsAreaConstants.HSPACE, SWT.BOTTOM);
		data.right = new FlatFormAttachment(100,  -IDetailsAreaConstants.HSPACE) ;		
		data.bottom = new FlatFormAttachment(100, -IDetailsAreaConstants.HSPACE);	
		tree.setLayoutData(data);
				
		return null;
	}
	
	
	
	@Override
	protected void createClient(Composite parent) {
		
		Composite composite = parentComposite = createFlatFormComposite(parent);
				
//		FlatFormData data = new FlatFormData();
//		data.top = new FlatFormAttachment(0,0);				
//		data.left = new FlatFormAttachment(0, 0);
//		data.right = new FlatFormAttachment(100, 0);
//		data.bottom = new FlatFormAttachment(100,0);		
//		composite.setLayoutData(data);		
		
		Composite ref = createPartnerLinkTypeWidgets(null,composite);
		
		ref = createRoleWidgets ( ref, composite );
				
		createPartnerLinkStructureWidgets( ref, composite  );
		
		// createInterfaceWidgets(composite);
		// createReferenceWidgets(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			parentComposite, IHelpContextIds.PROPERTY_PAGE_PARTNER_LINK);
	}
	
	
	
	
	protected void doChildLayout() {
		parentComposite.layout(true,true);
	}	
	

	
	protected void updateMyRolePartnerRoleWidgets ( PartnerLink pl ) {
		
		PartnerLinkType plt = pl.getPartnerLinkType();
		fRoles = NO_ROLES ;
		if (plt != null) {
			fRoles = plt.getRole().toArray( NO_ROLES );			
		}
		
		Role myRole = pl.getMyRole();
		Role partnerRole = pl.getPartnerRole();
		
		
		updateRadio(fMyRole1,null);
		updateRadio(fMyRole2,null);
		updateRadio(fPartnerRole1,null);
		updateRadio(fPartnerRole2,null);

		select(fPartnerRoleNone);
		select(fMyRoleNone);
		select(fInitializePartnerRole);
		
		// Roles are 1..2, so technically, this should never happen.

		// If at least 1 role specified ...
		if (fRoles.length >= 1) {
			String role1 = fRoles[0].getName();
			
			updateRadio (fMyRole1, role1);
			updateRadio (fPartnerRole1,role1);
			
			if ( fRoles[0].equals( myRole ) ) {
				select (fMyRole1);
			} 
			if (fRoles[0].equals(partnerRole)) {
				select (fPartnerRole1);
			} 
		}
		
		Boolean ipr = pl.getInitializePartnerRole();
		
		// If at most 2 roles specified ...
		if (fRoles.length >= 2) {
			String role2 = fRoles[1].getName();
			updateRadio (fMyRole2, role2);
			updateRadio (fPartnerRole2,role2);
			
			if (fRoles[1].equals ( myRole) ) {
				select(fMyRole2);
			} 
			if (fRoles[1].equals ( partnerRole )) {
				select(fPartnerRole2);
			}
			fInitializePartnerRole.setEnabled( true );
			fInitializePartnerRole.setSelection(ipr != null && ipr );
			
		} else {
			
			fInitializePartnerRole.setSelection( false );
			fInitializePartnerRole.setEnabled( false );
		}
		
		
	}
	
	protected void updatePartnerLinkType (PartnerLink pl) {
		PartnerLinkType plt = pl.getPartnerLinkType();
		if (plt == null) {
			fPartnerLinkTypeHref.setText(Messages.PartnerLinkImplSection_8);
			// partnerLinkTypeName.setText("(None)");
			
			// added by Grid.Qian
			fPartnerLinkTypeHref.setEnabled(false);
			return;
		}
		
		String name = null;
		ILabeledElement label = BPELUtil.adapt(plt, ILabeledElement.class );
		if (label != null) {
			name = label.getLabel( plt );
		} 	
		fPartnerLinkTypeHref.setText( name );
		
		// added by Grid.Qian
		fPartnerLinkTypeHref.setEnabled(true);
		// partnerLinkTypeName.setText(name);
	}
	
	protected void updatePartnerLinkTypeWidgets() {
		Object obj = getInput();
		if (obj == null) {
			throw new IllegalStateException();
		}
		PartnerLink pl = (PartnerLink) obj;
		updateMyRolePartnerRoleWidgets( pl );
		updatePartnerLinkType (pl);
		
		
		fMyOperationsTreeViewer.setInput( ModelHelper.getPartnerPortType(pl, ModelHelper.INCOMING) );
		fPartnerOperationsTreeViewer.setInput( ModelHelper.getPartnerPortType(pl, ModelHelper.OUTGOING ) );
		
		updateMarkers();
	}
	
	
	protected PartnerLinkType getPartnerLinkType () {
		PartnerLink pl = (PartnerLink) fModelObject;
		return pl.getPartnerLinkType();
	}
	
	
	
	@Override
	protected void basicSetInput(EObject newInput) {
		
		super.basicSetInput(newInput);
		
		updatePartnerLinkTypeWidgets();
		doChildLayout();		
	}

	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return Integer.valueOf( lastChangeContext );
	}
	
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
				
	}

	
	/**
	 * @param portType
	 * @param whichRole
	 */
	public void storeInterface (final PortType portType, final int whichRole) {
		
		final PartnerLink partnerLink = (PartnerLink)getInput();
		CompoundCommand cmd = new CompoundCommand();
		PartnerLinkType plt = partnerLink.getPartnerLinkType();
		
		if (((plt == null) || plt.eIsProxy()) && (portType != null)) {
			// need a PLT.
			plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
			Definition artifactsDefinition = getBPELEditor().getArtifactsDefinition();
			cmd.add(ModelHelper.getCreatePartnerLinkTypeCommand(getProcess(), partnerLink, plt, artifactsDefinition, whichRole));
		}
		if (plt != null) {
			// set port type
			cmd.add(new AutoUndoCommand(plt) {
				
	            @Override
				public void doExecute() {
	            	Role role = (whichRole == ModelHelper.MY_ROLE) ? partnerLink.getMyRole() : partnerLink.getPartnerRole();
	            	role.setPortType(portType);
	            }
	        });
		}
		
		// lastChangeContext is set by caller
		if (!cmd.isEmpty()) getCommandFramework().execute(wrapInShowContextCommand(cmd));
	}
	
	
	Button createButton (Composite parent, String label, int id, boolean checked, int type ) {
		
		Button button = fWidgetFactory.createButton(parent, label, type );
		
		button.setData( Integer.valueOf( id ));		
		button.setSelection( checked );
		
		button.addSelectionListener (new SelectionAdapter() {
			
			@Override
			public void widgetSelected (SelectionEvent event) {
				Button b = (Button) event.widget;				
				buttonPressed(((Integer) b.getData()), b.getSelection(),true);
			}
		});
		
		return button;	
	}

	
	
	void updateRadio ( Button button, String text ) {
		
		if ( text == null ) {
			button.setText(Messages.PartnerLinkImplSection_9);
			button.setEnabled(false);
			button.setSelection(false);
		} else {
			button.setText (text);
			button.setEnabled (true);
		}
	}
	
	
	
	void select ( Button button ) {
				
		if ((button.getStyle() & SWT.RADIO) == SWT.RADIO) {
			for(Control child : button.getParent().getChildren()) {
				if (button != child && child instanceof Button) {
					Button b = (Button)child;
					if ((b.getStyle() & SWT.RADIO) == SWT.RADIO) {
						unselect( b );
					}
				}
			}
		}
		
		button.setSelection(true);
		int id = ((Integer)button.getData()).intValue();
		buttonPressed( id, true, false ) ;
	}
	
	
	void unselect (Button button) {
		if (button.getSelection () ) {
			button.setSelection (false);
			int id = ((Integer)button.getData()).intValue();
			buttonPressed( id, false , false ) ;
		}
	}
	
	
	/**
	 * @param id
	 * @param selection
	 */
	protected void buttonPressed(int id, boolean selection, boolean event ) {
		
		if (!event || (!selection && id != BID_INITIALIZE_PARTNER_ROLE)) {
			// only respond to events
			return ;
		}
		
		PartnerLink pl = (PartnerLink) getInput();
		SetCommand cmd = null;
		
		// Current myRole or partnerRole may be null
		Role myRole = pl.getMyRole();
		Role partnerRole = pl.getPartnerRole();
				
		switch (id) {
		case BID_MY_ROLE_1 :
			
			if (myRole == null || myRole.equals( fRoles[0]) == false ) {			
				cmd = new SetCommand(pl,fRoles[0],BPELPackage.eINSTANCE.getPartnerLink_MyRole() );
			}			
			break;
			
		case BID_MY_ROLE_2 :
			if (myRole == null || myRole.equals( fRoles[1]) == false ) {
				cmd = new SetCommand(pl,fRoles[1],BPELPackage.eINSTANCE.getPartnerLink_MyRole() );				
			}
			break;
			
		case BID_MY_ROLE_NONE :
			if (myRole != null) {
				cmd = new SetCommand(pl,null,BPELPackage.eINSTANCE.getPartnerLink_MyRole() );				
			}
			break;
			
		case BID_PARTNER_ROLE_1 :
			if (partnerRole == null || partnerRole.equals( fRoles[0]) == false) {				
				cmd = new SetCommand(pl,fRoles[0],BPELPackage.eINSTANCE.getPartnerLink_PartnerRole() );
			}
			break;
			
		case BID_PARTNER_ROLE_2 :
			if (partnerRole == null || partnerRole.equals( fRoles[1]) == false) {
				cmd = new SetCommand(pl,fRoles[1],BPELPackage.eINSTANCE.getPartnerLink_PartnerRole() );
			}
			break;
					
		case BID_PARTNER_ROLE_NONE :
			if (partnerRole != null) {
				cmd = new SetCommand(pl,null,BPELPackage.eINSTANCE.getPartnerLink_PartnerRole() );				
			}
			break;
		case BID_INITIALIZE_PARTNER_ROLE :
			cmd = new SetCommand(pl,fInitializePartnerRole.getSelection(),BPELPackage.eINSTANCE.getPartnerLink_InitializePartnerRole() );
			break;
		}
		
		if (cmd != null) {
			getCommandFramework().execute( cmd );
		}
		
		// System.out.println("ButtonID=" + id + "; selection=" + selection);
	}
	
	
	
	private void setPartnerLinkType (PartnerLinkType type) {
		
		PartnerLink pl = (PartnerLink) getInput();
		
		CompoundCommand cmd = new CompoundCommand ();				
		cmd.add(  new SetCommand(pl, type, BPELPackage.eINSTANCE.getPartnerLink_PartnerLinkType() ) );				
		cmd.add ( new SetCommand(pl, null, BPELPackage.eINSTANCE.getPartnerLink_MyRole() ) ) ;		
		cmd.add ( new SetCommand(pl, null, BPELPackage.eINSTANCE.getPartnerLink_PartnerRole() ) );				
		getCommandFramework().execute(cmd);	
	}

	/**
	 * 
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#isValidMarker(org.eclipse.core.resources.IMarker)
	 */
	
	@Override
	public boolean isValidMarker (IMarker marker) {

		boolean isValid = super.isValidMarker(marker);
		
		if (!isValid) {
			return false;
		}
		
		String context = null;
		try {
			context = (String) marker.getAttribute("href.context");
		} catch (Exception ex) {
			return false;
		}
		
		return "name".equals (context) == false; 
	}	
	
	

	@Override
	protected void updateMarkers () {				
		fPartnerLinkTypeLabel.clear();		
		for(IMarker m : getMarkers(getInput())) {
			fPartnerLinkTypeLabel.addStatus( BPELUtil.adapt(m, IStatus.class));
		}		
	}
	
	
}
