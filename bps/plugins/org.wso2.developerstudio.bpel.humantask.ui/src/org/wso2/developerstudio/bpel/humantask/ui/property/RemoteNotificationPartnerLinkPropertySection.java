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
package org.wso2.developerstudio.bpel.humantask.ui.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.common.ui.assist.FieldAssistAdapter;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Extension;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddPartnerLinkCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.details.providers.AbstractContentProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.details.providers.ModelTreeLabelProvider;
import org.eclipse.bpel.ui.details.providers.PartnerLinkContentProvider;
import org.eclipse.bpel.ui.details.providers.PartnerLinkTreeContentProvider;
import org.eclipse.bpel.ui.details.providers.PartnerRoleFilter;
import org.eclipse.bpel.ui.dialogs.PartnerLinkRoleSelectorDialog;
import org.eclipse.bpel.ui.dialogs.PartnerLinkTypeSelectorDialog;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.proposal.providers.ModelContentProposalProvider;
import org.eclipse.bpel.ui.proposal.providers.RunnableProposal;
import org.eclipse.bpel.ui.proposal.providers.Separator;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.NameDialog;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.wst.wsdl.WSDLFactory;
import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN;
import org.wso2.developerstudio.bpel.humantask.model.RemoteNotification;
import org.wso2.developerstudio.bpel.humantask.ui.HTConstants;

public class RemoteNotificationPartnerLinkPropertySection extends BPELPropertySection{

	
	private Composite parentComposite;
	
	private Label partnerLabel;
	private Text partnerName;
	private Button partnerBrowseButton;
	
	private Label operationLabel;
	private Text operationName;
	private Button operationButton;
	
	
	public static final int SPLIT_POINT = 55;
	public static final int SPLIT_POINT_OFFSET = 3 * IDetailsAreaConstants.HSPACE;
	public static final String EMPTY_TEXT = "";
	
	private PartnerRoleFilter fPartnerRoleFilter = new PartnerRoleFilter();
	private Label quickPickLabel;
	private Tree quickViewTree;	
	private TreeViewer quickViewTreeViewer;
	
	private IControlContentAdapter fTextContentAdapter = new TextContentAdapter() {
		
		public void insertControlContents(Control control, String text, int cursorPosition) {
			if (text != null) {
				super.insertControlContents(control, text, cursorPosition);
			}
		}
		
		public void setControlContents(Control control, String text, int cursorPosition) {
			if (text != null) {
				super.setControlContents(control, text, cursorPosition);
			}
		}			
	};
	
	private static final PartnerLink IGNORE_PARTNER_LINK = BPELFactory.eINSTANCE.createPartnerLink();
	private static final Operation IGNORE_OPERATION = WSDLFactory.eINSTANCE.createOperation();
	
	
	
	protected void createClient(Composite parent) {
		
		Composite composite = parentComposite = createFlatFormComposite(parent);
		Composite ref = null;
		ref= createPartnerLinkWidget(ref,composite);
		ref = createOpeartionWidget(ref,composite);
		
		// This creates it on the top
		ref= null;
		ref = createQuickViewWidget(ref,composite);
		
	}
	
	
	protected void basicSetInput(EObject input) {
		
		super.basicSetInput(input);	
		UpdateWidgets();
		addExtensionTag();
	}
	
	//(1) Widgets and widgets updates
	
	// 1.1.A partneLink widget
	private Composite createPartnerLinkWidget(Composite top , Composite parent)
	{
		FlatFormData data;
	
		final Composite composite = createFlatFormComposite(parent);
		
		data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0, 5);
		} else {
			data.top = new FlatFormAttachment(top, 5);
		}		
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);		
		data.right = new FlatFormAttachment(SPLIT_POINT, -SPLIT_POINT_OFFSET);
		composite.setLayoutData(data);
		
		partnerLabel = fWidgetFactory.createLabel(composite, "PartnerLink");
		partnerName = fWidgetFactory.createText(composite, EMPTY_TEXT , SWT.BORDER|SWT.READ_ONLY);
		partnerBrowseButton = fWidgetFactory.createButton(composite, EMPTY_TEXT, SWT.ARROW | SWT.DOWN | SWT.RIGHT );
		
		RunnableProposal proposal = new RunnableProposal() {
			
			
			public String getLabel() {
				return Messages.InvokeImplSection_0;
			}
			public void run() {
				createPartnerLink ( BPELUtils.getProcess( getInput () ) , null );
			}			
		};

		RunnableProposal proposal3 = new RunnableProposal() {			
			
			public String getLabel() {
				return Messages.InvokeImplSection_2;
			}
			public void run() {				
				SetRNPartnerLinkCommand(IGNORE_PARTNER_LINK);
				SetRNOperaitonCommand(IGNORE_OPERATION);
				UpdateWidgets();
			}			
		};
		
		PartnerLinkContentProvider provider = new PartnerLinkContentProvider();
		ModelContentProposalProvider proposalProvider;
		proposalProvider = new ModelContentProposalProvider( new ModelContentProposalProvider.ValueProvider () {
			
			public Object value() {
				return getInput();
			}			
		}, provider,fPartnerRoleFilter );
		
		
		proposalProvider.addProposalToEnd( new Separator () );
		proposalProvider.addProposalToEnd( proposal );
		proposalProvider.addProposalToEnd( proposal3 );

		
		final FieldAssistAdapter contentAssist = new FieldAssistAdapter (
				partnerName, 
				fTextContentAdapter, 
				proposalProvider, 
				null, 
				null, true );
		// 
		contentAssist.setLabelProvider( new ModelLabelProvider () );		
		contentAssist.setPopupSize( new Point(300,100) );
		contentAssist.setFilterStyle(ContentProposalAdapter.FILTER_CUMULATIVE);
		contentAssist.setProposalAcceptanceStyle( ContentProposalAdapter.PROPOSAL_REPLACE);
		contentAssist.addContentProposalListener( proposal );	
		contentAssist.addContentProposalListener( proposal3 );

		contentAssist.addContentProposalListener(new IContentProposalListener () {
			public void proposalAccepted(IContentProposal chosenProposal) {
				if (chosenProposal.getContent() == null) {
					return ;
				}
				PartnerLink pl = null;
				try {
					pl = (PartnerLink) ((Adapter)chosenProposal).getTarget();
				} catch (Throwable t) {
					return ;
				}
				getRemoteNotification().setPartnerLink(pl);
				SetRNPartnerLinkCommand(pl);
				SetRNOperaitonCommand(IGNORE_OPERATION);
				UpdateWidgets();
			}			
		});
		
		data = new FlatFormData();
		data.right = new FlatFormAttachment(100, 0);		
		data.top = new FlatFormAttachment(partnerName,0,SWT.TOP);
		data.bottom = new FlatFormAttachment(partnerName,0,SWT.BOTTOM);		
		partnerBrowseButton.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(partnerLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(partnerBrowseButton, 0);
		partnerName.setLayoutData(data);

		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(partnerName, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(partnerName, 0, SWT.CENTER);
		partnerLabel.setLayoutData(data);
			
		// End of Content Assist for variable
		partnerBrowseButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				contentAssist.openProposals();
			}			
		});
		
		return composite;
	}

	// 1.1.B partneLink widget
	private void updatePartnerWidgets() 
	{
		if(getRemoteNotification().getPartnerLink()!=null){
			String partnerLinkName = getRemoteNotification().getPartnerLink().getName();
			if (partnerLinkName == null) {
				partnerName.setText(EMPTY_STRING); 			
			} else {
				partnerName.setText(partnerLinkName);
			}
		}else
		{
			partnerName.setText("SELECT A PARTNERLINK");
		}
	}
	
	// 1.2.A Operation widget
	private Composite createOpeartionWidget (Composite top, Composite parent){
		
		FlatFormData data;
		
		final Composite composite = createFlatFormComposite(parent);
		data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0, 5);
		} else {
			data.top = new FlatFormAttachment(top,  5 );
		}
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(SPLIT_POINT, -SPLIT_POINT_OFFSET);
		composite.setLayoutData(data);
	
		operationName = fWidgetFactory.createText(composite, EMPTY_TEXT ,SWT.BORDER|SWT.READ_ONLY);
		operationLabel =fWidgetFactory.createLabel(composite, "Operation");
		operationButton = fWidgetFactory.createButton(composite, EMPTY_TEXT, SWT.ARROW | SWT.DOWN | SWT.RIGHT );
		
		data = new FlatFormData();		
		data.right = new FlatFormAttachment(100,0);
		data.top = new FlatFormAttachment(operationName,0,SWT.TOP);
		data.bottom = new FlatFormAttachment(operationName,0,SWT.BOTTOM);
		operationButton.setLayoutData(data);
		

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(operationLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(operationButton, 0);
		operationName.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(operationName, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(operationName, 0, SWT.CENTER);
		operationLabel.setLayoutData(data);
		
		// Provide Content Assist for the variables		
		AbstractContentProvider provider = new AbstractContentProvider(){
			
			
			public void collectElements(Object input, List list){
				if(input instanceof PeopleActivityRN)
				{	
					PeopleActivityRN peopleActivity = (PeopleActivityRN) input;
					RemoteNotification remoteNotification = peopleActivity.getRemoteNotification();
					PartnerLink currentPartnerLink;
					if(remoteNotification!=null)
					{
						currentPartnerLink = remoteNotification.getPartnerLink();
						if (currentPartnerLink != null) {
							
							PartnerLink[] partnerLinks = BPELUtil.getVisiblePartnerLinks((EObject)input);
							for(PartnerLink pt: partnerLinks)
							{	// taking partner Link form BPEL registry.
								if(currentPartnerLink.getName().equals(pt.getName()))
								{
									Role partnerRole = pt.getPartnerRole();
									if (partnerRole != null) {
										collectElements ( partnerRole.getPortType(), list );
									}
									break;
								}
							}
							
						}
						
					}
					return ;
				}
				
				if (input instanceof PortType) {
					PortType pt = (PortType) input;
					list.addAll ( pt.getOperations() );
					
					return ;
				}
				
			}
			
		};
		
		ModelContentProposalProvider proposalProvider;
		proposalProvider = new ModelContentProposalProvider( new ModelContentProposalProvider.ValueProvider () {
			
			public Object value() {
				return getInput();
			}			
		}, provider);
		

		
		final FieldAssistAdapter contentAssist = new FieldAssistAdapter (
				operationName, 
				fTextContentAdapter, 
				proposalProvider, 
				null, 
				null, true );
		// 
		contentAssist.setLabelProvider( new ModelLabelProvider () );		
		contentAssist.setPopupSize( new Point(300,100) );
		contentAssist.setFilterStyle(ContentProposalAdapter.FILTER_CUMULATIVE);
		contentAssist.setProposalAcceptanceStyle( ContentProposalAdapter.PROPOSAL_REPLACE);

	
		contentAssist.addContentProposalListener(new IContentProposalListener () {

			public void proposalAccepted(IContentProposal chosenProposal) {
				if (chosenProposal.getContent() == null) {
					return ;
				}
				Operation oper = null;
				try {
					oper = (Operation) ((Adapter)chosenProposal).getTarget();
				} catch (Throwable t) {
					return ;
				}
				SetRNOperaitonCommand(oper);
			}			
		});
		
		// End of Content Assist for variable
		
		operationButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				contentAssist.openProposals();
			}			
		});
		
		return composite;
	}

	// 1.2.B Operation widget update
	private void updateOperationWidgets() 
	{	
		if(getRemoteNotification().getOperation()!=null){
			String currentOperationName = getRemoteNotification().getOperation().getName();
			if (currentOperationName == null) {
				operationName.setText(EMPTY_STRING); 			
			} else {
				operationName.setText(currentOperationName);
			}
		}else
		{
			operationName.setText("SELECT AN OPERATION");
		}
	}
	
	// 1.3.A Quick view widget
	private Composite createQuickViewWidget(Composite top, Composite parent) {
		
		FlatFormData data;
		
		final Composite composite = createFlatFormComposite(parent);
		data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		} else {
			data.top = new FlatFormAttachment(top,IDetailsAreaConstants.VSPACE);
		} 
		data.left = new FlatFormAttachment(SPLIT_POINT, SPLIT_POINT_OFFSET);		
		data.right = new FlatFormAttachment(100, -IDetailsAreaConstants.HSPACE);
		data.bottom = new FlatFormAttachment(100,-IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		quickPickLabel = fWidgetFactory.createLabel(composite, "Quick View:");  //$NON-NLS-1$
		
		// Tree viewer for variable structure ...
		quickViewTree = fWidgetFactory.createTree(composite, SWT.NONE);
		PartnerLinkTreeContentProvider treeContentProvider = new PartnerLinkTreeContentProvider(true);
		quickViewTreeViewer = new TreeViewer(quickViewTree);
		quickViewTreeViewer.setContentProvider(treeContentProvider);
		quickViewTreeViewer.setLabelProvider(new ModelTreeLabelProvider());
		quickViewTreeViewer.addFilter( fPartnerRoleFilter );
		quickViewTreeViewer.setInput ( null );
		// https://issues.jboss.org/browse/JBIDE-8305
		// show tree down to message part level so that tree node highlight works
		// when the tree viewer is constructed.
		quickViewTreeViewer.setAutoExpandLevel(5);
		// end tree viewer for variable structure
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment ( 0,0);
		data.left = new FlatFormAttachment(0,0);
		quickPickLabel.setLayoutData(data);
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment( quickPickLabel, IDetailsAreaConstants.VSPACE);
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(100,-IDetailsAreaConstants.HSPACE);
		data.height = 100;
		quickViewTree.setLayoutData(data);
		
		return composite;
		
	}

	// 1.3.B quick view widget update
	private  void updateQuickViewWidgets (int view) {
		
		switch (view) {
		case HTConstants.QVIEW_ALL:
			fPartnerRoleFilter.setRequireMyRole( true );
			fPartnerRoleFilter.setRequirePartnerRole( true );
			break;
		case HTConstants.QVIEW_MYROLE:
			fPartnerRoleFilter.setRequireMyRole( true );
			fPartnerRoleFilter.setRequirePartnerRole( false );
			break;
		case HTConstants.QVIEW_PARTNERROLE:
			fPartnerRoleFilter.setRequireMyRole( false );
			fPartnerRoleFilter.setRequirePartnerRole( true );
			break;
		default:
			fPartnerRoleFilter.setRequireMyRole( false );
			fPartnerRoleFilter.setRequirePartnerRole( false );
			break;
		}
		
		
		
		Object myInput = getInput();
		if ( myInput != quickViewTreeViewer.getInput() ) {
			quickViewTreeViewer.setInput( myInput );			
			if (myInput != null) {
				quickViewTree.getVerticalBar().setSelection(0);
			}						
		}
		quickViewTreeViewer.refresh();
	}
	
	private void UpdateWidgets()
	{
		updateOperationWidgets();
		updatePartnerWidgets();
		// shows only partnerLinks which have partnerRole only. RemoteNotification is a one way operation.
		updateQuickViewWidgets(HTConstants.QVIEW_PARTNERROLE);
	}
	
	
	//2 Functions Methods
	/**
	 *  Creates a PartnerLink and returns the partnerLink
	 */
	private PartnerLink createPartnerLink(EObject ref, String name)
	{
		PartnerLink pl = BPELFactory.eINSTANCE.createPartnerLink();
		
		if (name == null) {
			name = EMPTY_STRING;
		}
		
		// ask for the name.
		NameDialog nameDialog = new NameDialog( 
				parentComposite.getShell(), 
				Messages.PartnerLinkSelectorDialog_5, 
				Messages.PartnerLinkSelectorDialog_6, 
				name, 
				BPELUtil.getNCNameValidator());
		
		if (nameDialog.open() == Window.CANCEL) {
			return null;
		}		
		
		PartnerLinkTypeSelectorDialog dialog = new PartnerLinkTypeSelectorDialog(
				partnerName.getShell(),	getInput());
		if (dialog.open() == Window.CANCEL) {
			return  null;
		}
		Object result = dialog.getFirstResult();
		PartnerLinkType plt = null;
		if (result != null && result instanceof PartnerLinkType) {
			plt = (PartnerLinkType) result;
		}
		
		// Ask About Roles
		EList<Role> list = plt.getRole();
		if (list.size() >= 1){
			// PartnerRole
			PartnerLinkRoleSelectorDialog roleDialog = new PartnerLinkRoleSelectorDialog(parentComposite.getShell(), list, plt);
			roleDialog.setTitle(Messages.PartnerRoleSelectorDialog_Title_PartnerRole);
			if (roleDialog.open() == Window.CANCEL){
				return  null;
			}
			pl.setPartnerRole(list.get(roleDialog.getSelectedRole()));
			
		}else{
			
		}
		
		// set name and type
		pl.setName ( nameDialog.getValue() );
		pl.setPartnerLinkType( plt );
		getRemoteNotification().setPartnerLink(pl);
		// Writing it
		SetRNPartnerLinkCommand(pl);
		SetRNOperaitonCommand(null);
		partnerName.setText(pl.getName());
		List<Command> cmds = new ArrayList<Command>(8);
		cmds.add(0, new AddPartnerLinkCommand( ref, pl ));
		//SetPartnerLinkAttributeCommand // 
		CompoundCommand cmd = new CompoundCommand();
		cmd.getCommands().addAll(cmds);
		getCommandFramework().execute(cmd);
		
		
		//TODO: update quick pick
		quickViewTreeViewer.refresh();
		return pl;
	}
	
	

	//Commands 
	/***
	 *  Returns the remoteNotification of the activity
	 */
	private RemoteNotification getRemoteNotification() {
		return ((PeopleActivityRN)getInput()).getRemoteNotification();
	}
	
	private void SetRNPartnerLinkCommand(PartnerLink pl) {
		
		RemoteNotification remoteNotification = getRemoteNotification();
		if(remoteNotification!=null){
			getCommandFramework().execute( wrapInShowContextCommand((
					new SetCommand(remoteNotification, pl , 
							ModelPackage.eINSTANCE.getRemoteNotification_PartnerLink()))));
			refreshAdapters();
		}
	}
	
	private void SetRNOperaitonCommand(Operation op) {
		
		RemoteNotification remoteNotification = getRemoteNotification();
		if(remoteNotification!=null){
			getCommandFramework().execute( wrapInShowContextCommand((
					new SetCommand(remoteNotification, op , 
							ModelPackage.eINSTANCE.getRemoteNotification_Operation()))));
		
			refreshAdapters();
		}
	}
	
	
	/**
	 * Creating <Extensions /> & <extension /> tags
	 */
	protected void addExtensionTag() {
		Extensions exts;
		Extension ext;
		String ns= ModelPackage.eINSTANCE.getNsURI();
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
						new SetCommand( exts, exts.getChildren(), BPELPackage.eINSTANCE.getExtensions_Children()))));
			}
		}else{
			System.err.println("Error: Fail to add Extensions;");
		}
	}
	
}
