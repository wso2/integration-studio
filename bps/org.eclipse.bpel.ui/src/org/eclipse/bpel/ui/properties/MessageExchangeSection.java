/**
 * <copyright>
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 */
 
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.assist.FieldAssistAdapter;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.commands.AddMessageExchangeCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetMessageExchangeCommand;
import org.eclipse.bpel.ui.details.providers.MessageExchangeContentProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.proposal.providers.ModelContentProposalProvider;
import org.eclipse.bpel.ui.proposal.providers.RunnableProposal;
import org.eclipse.bpel.ui.proposal.providers.Separator;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.bpel.ui.util.NameDialog;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
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
import org.eclipse.ui.PlatformUI;

/**
 * @author Miriam Grundig (MGrundig@de.ibm.com)
 */
public class MessageExchangeSection extends BPELPropertySection {
	
	Composite parentComposite; 
	
	//SWT widgets
	private Label  messExLabel;
	private Text   messExName;
	private Button messExBrowseButton; 
	
	private IControlContentAdapter fTextContentAdapter = new TextContentAdapter() {
		@Override
		public void insertControlContents(Control control, String text, int cursorPosition) {
			if (text != null) {
				super.insertControlContents(control, text, cursorPosition);
			}
		}
		@Override
		public void setControlContents(Control control, String text, int cursorPosition) {
			if (text != null) {
				super.setControlContents(control, text, cursorPosition);
			}
		}			
	};
		
	//TODO check this
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new MultiObjectAdapter() {
				@Override
				public void notify (Notification n) {
				    try {
						if (ModelHelper.isMessageExchangeAffected(getInput(), n)) {
							updateMessExWidgets();
						}
				    } catch (Exception e) {
						BPELUIPlugin.log(e);
				    }
				}
			},
		};
	}

	@SuppressWarnings("nls")
	@Override
	/**
	 * Depending on the element selected a entry for the table will be defined
	 */
	protected void basicSetInput (EObject input) {
		super.basicSetInput(input);

		updateMessExWidgets();
	}
	

	protected void createMessExWidgets(Composite composite) {
		
		// create items
		messExLabel = fWidgetFactory.createLabel(composite, Messages.MessageExchangeImplSection_1);
		messExName 	= fWidgetFactory.createText(composite, EMPTY_STRING, SWT.NONE); 
		messExBrowseButton = fWidgetFactory.createButton(composite,EMPTY_STRING,SWT.ARROW | SWT.DOWN | SWT.RIGHT );				

		// Content Assist for Message Exchange
		RunnableProposal proposal = new RunnableProposal() {
			@Override
			public String getLabel() {
				return Messages.MessageExchangeImplSection_Create_Global;
			}
			public void run() {
				createMessageExchange ( BPELUtils.getProcess( getInput () ) , null );
			}			
		};

		RunnableProposal proposal2 = new RunnableProposal() {
			@Override
			public String getLabel() {
				return Messages.MessageExchangeImplSection_Create_Local;
			}
			public void run() {
				createMessageExchange ( ModelHelper.getContainingScope( getInput()), null);
			}			
		};

		RunnableProposal proposal3 = new RunnableProposal() {			
			@Override
			public String getLabel() {
				return Messages.MessageExchangeImplSection_Clear;
			}
			public void run() {				
				Command cmd = new SetMessageExchangeCommand(getInput(), null) ;
				cmd.setLabel(IBPELUIConstants.CMD_ADD_MESSAGEEXCHANGE);
				runCommand(cmd);
			}			
		};
		
		MessageExchangeContentProvider provider = new MessageExchangeContentProvider();
		ModelContentProposalProvider proposalProvider;
		proposalProvider = new ModelContentProposalProvider( new ModelContentProposalProvider.ValueProvider () {
			@Override
			public Object value() {
				return getInput();
			}			
		}, provider );
		
		proposalProvider.addProposalToEnd( new Separator () );
		proposalProvider.addProposalToEnd( proposal );
		proposalProvider.addProposalToEnd( proposal2 );
		proposalProvider.addProposalToEnd( proposal3 );
		final FieldAssistAdapter contentAssist = new FieldAssistAdapter (
				messExName, 
				fTextContentAdapter, 
				proposalProvider, 
				null, 
				null, false ); // installDecoration = false --> no icon that shows that we have content assist.
		
		contentAssist.setLabelProvider( new ModelLabelProvider () );		
		contentAssist.setPopupSize( new Point(300,100) );
		contentAssist.setFilterStyle(ContentProposalAdapter.FILTER_CUMULATIVE);
		contentAssist.setProposalAcceptanceStyle( ContentProposalAdapter.PROPOSAL_REPLACE);
		contentAssist.addContentProposalListener( proposal );	
		contentAssist.addContentProposalListener( proposal2 );
		contentAssist.addContentProposalListener( proposal3 );
		contentAssist.addContentProposalListener(new IContentProposalListener () {

			public void proposalAccepted(IContentProposal chosenProposal) {
				if (chosenProposal.getContent() == null) {
					return ;
				}
				MessageExchange me = null;
				try {
					me = (MessageExchange) ((Adapter)chosenProposal).getTarget();
				} catch (Throwable t) {
					return ;
				}
				Command cmd = new SetMessageExchangeCommand(getInput(),me);
				cmd.setLabel(IBPELUIConstants.CMD_ADD_MESSAGEEXCHANGE);
				runCommand(cmd);
			}			
		});
			
		// Open content assist window on button click
		messExBrowseButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				contentAssist.openProposals();
			}			
		});
		
		messExName.addListener(SWT.KeyDown, new Listener () {
			public void handleEvent(Event event) {
				if (event.keyCode == SWT.CR) {
					findAndSetOrCreateMessageExchange( messExName.getText() );
				}
			}        	
		});		
		// End of content assist for message exchange
		
		// Layout
		FlatFormData data	= new FlatFormData();
		data.right 			= new FlatFormAttachment(100, 0);		
		data.top 			= new FlatFormAttachment(messExName,+2,SWT.TOP);
		data.bottom 		= new FlatFormAttachment(messExName,-2,SWT.BOTTOM);		
		messExBrowseButton.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(messExLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(messExBrowseButton, 0);
		messExName.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(messExName, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(messExName, 0, SWT.CENTER);
		messExLabel.setLayoutData(data);
	}

	@Override
	protected void createClient(Composite parent) {
		Composite composite = parentComposite = createFlatFormComposite(parent);
		createMessExWidgets(composite);
    PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IHelpContextIds.PROPERTY_PAGE_MESSAGE_EXCHANGE);
	}
    
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return null;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		messExName.setFocus();
	}
	
	void findAndSetOrCreateMessageExchange ( String name ) {
		name = name.trim();
		EObject model = getInput();
					
		MessageExchange me = null;
		if (name.length() > 0) {
			
			me = (MessageExchange) ModelHelper.findElementByName(ModelHelper.getContainingScope(model),
					name, MessageExchange.class);
			// does not exist
			if (me == null) {			
				createMessageExchange ( ModelHelper.getContainingScope(model), name );						
				return ;			
			}			
		}
		
		SetMessageExchangeCommand cmd = new SetMessageExchangeCommand(model, me);
		cmd.setLabel(IBPELUIConstants.CMD_ADD_MESSAGEEXCHANGE);
		runCommand (cmd);
	}
	
	private void createMessageExchange ( EObject ref , String name ) {
		MessageExchange me = BPELFactory.eINSTANCE.createMessageExchange();
		
		if (name == null) {
			name = EMPTY_STRING;
		}

		// ask for the name, we know the type.
		NameDialog nameDialog = new NameDialog( 
				parentComposite.getShell(), 
				Messages.MessageExchange_Create_Dialog_Title,
				Messages.MessageExchange_Create_Dialog_NameField_Label, 
				name, 
				BPELUtil.getNCNameValidator());
		
		if (nameDialog.open() == Window.CANCEL)
			return ;
			
		// set name
		me.setName ( nameDialog.getValue() );
		
		CompoundCommand cmd = new CompoundCommand();
		cmd.add(new AddMessageExchangeCommand(ref, me));
		cmd.add(new SetMessageExchangeCommand(getInput(), me));
		cmd.setLabel(IBPELUIConstants.CMD_ADD_MESSAGEEXCHANGE);
		runCommand( cmd );
	}
	
	private void updateMessExWidgets() {
		MessageExchange messEx = ModelHelper.getMessageExchange(getInput());
		if (messEx == null) {
			messExName.setText(EMPTY_STRING); 			
		} else {
			ILabeledElement labeledElement = BPELUtil.adapt(messEx, ILabeledElement.class);
			messExName.setText(labeledElement.getLabel(messEx));			
		}
	}
}
