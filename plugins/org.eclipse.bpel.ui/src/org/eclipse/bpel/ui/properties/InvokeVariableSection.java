/*******************************************************************************
 * Copyright (c) 2007, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.properties;

import java.util.Collections;
import java.util.List;

import org.eclipse.bpel.common.ui.assist.FieldAssistAdapter;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.IOngoingChange;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.FromPart;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Reply;
import org.eclipse.bpel.model.ToPart;
import org.eclipse.bpel.model.ToParts;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddFromPartCommand;
import org.eclipse.bpel.ui.commands.AddToPartCommand;
import org.eclipse.bpel.ui.commands.AddVariableCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetVariableCommand;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.details.providers.VariableContentProvider;
import org.eclipse.bpel.ui.details.providers.VariableFilter;
import org.eclipse.bpel.ui.proposal.providers.ModelContentProposalProvider;
import org.eclipse.bpel.ui.proposal.providers.RunnableProposal;
import org.eclipse.bpel.ui.proposal.providers.Separator;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.bpel.ui.util.NameDialog;
import org.eclipse.bpel.ui.util.PartMappingUtil;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.wst.wsdl.util.WSDLConstants;
import org.eclipse.xsd.XSDElementDeclaration;

public class InvokeVariableSection extends BPELPropertySection {

	/**
	 * Selection Listener for the "Use Part Mapping" checkbox
	 */
	private class UsePartMappingCheckboxSelectionListener implements
			SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {

			// Null out the variable/inputVariable/outputVarable fields
			CompoundCommand ccmd = new CompoundCommand();
			if (ModelHelper.isMessageActivity(getModel(), ModelHelper.INCOMING)) {
				ccmd.add(new SetVariableCommand(getModel(), null,
						ModelHelper.INCOMING));
			}
			if (ModelHelper.isMessageActivity(getModel(), ModelHelper.OUTGOING)) {
				ccmd.add(new SetVariableCommand(getModel(), null,
						ModelHelper.OUTGOING));
			}
			// Null out the fromParts and toParts
			ccmd.add(new AutoUndoCommand(getInput()) {
				@Override
				public void doExecute() {
					try {
						ModelHelper.setToParts(getInput(), null);
					} catch (IllegalArgumentException e) {
					}
					try {
						ModelHelper.setFromParts(getInput(), null);
					} catch (IllegalArgumentException e) {
					}
				}
			});

			getCommandFramework().execute(ccmd);
		}
	}

	private VariableFilter fInputVariableFilter = new VariableFilter();
	private VariableFilter fOutputVariableFilter = new VariableFilter();
	private IControlContentAdapter fTextContentAdapter = new TextContentAdapter() {
		@Override
		public void insertControlContents(Control control, String text,
				int cursorPosition) {
			if (text != null) {
				super.insertControlContents(control, text, cursorPosition);
			}
		}

		@Override
		public void setControlContents(Control control, String text,
				int cursorPosition) {
			if (text != null) {
				super.setControlContents(control, text, cursorPosition);
			}
		}
	};
	private Button inputVariableButton;
	private Composite inputVariableComposite;
	private Label inputVariableLabel;
	private Text inputVariableText;
	private Composite nonPartMappingComposite;
	private Widget operationLabel;
	private Button outputVariableButton;
	private Composite outputVariableComposite;
	private Label outputVariableLabel;
	private Text outputVariableText;
	private Composite parentComposite;
	private Composite partMappingComposite;
	private Button usePartMappingCheckbox;

	@Override
	protected void addAllAdapters() {
		// model object
		super.addAllAdapters();

		// fromParts
		try {
			FromParts fromParts = ModelHelper.getFromParts(getModel());
			if (fromParts != null) {
				fAdapters[0].addToObject(fromParts);
				if (fromParts.getChildren() != null) {
					// add it to every single fromPart
					for (FromPart fromPart : fromParts.getChildren()) {
						fAdapters[0].addToObject(fromPart);
					}
				}
			}
		} catch (IllegalArgumentException e) {
		}

		// toParts
		try {
			ToParts toParts = ModelHelper.getToParts(getModel());
			if (toParts != null) {
				fAdapters[0].addToObject(toParts);
				if (toParts.getChildren() != null) {
					// add it to every single fromPart
					for (ToPart toPart : toParts.getChildren()) {
						fAdapters[0].addToObject(toPart);
					}
				}
			}
		} catch (IllegalArgumentException e) {
		}
	}

	@Override
	protected void basicSetInput(EObject newInput) {
		super.basicSetInput(newInput);

		this.usePartMappingCheckbox
				.setSelection(shouldUsePartMapping(getModel()));
	}

	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
		/* model object */
		new BatchedMultiObjectAdapter() {

			@Override
			public void finish() {
				refresh();
			}

			@Override
			public void notify(Notification n) {

				/*
				 * This is a hack to make the QuickPicker work: If a variable is
				 * set to our model object (either by command or by the
				 * QuickPicker) we deselect the checkbox.
				 */
				if (ModelHelper.isVariableAffected(getInput(), n,
						ModelHelper.INCOMING)
						|| ModelHelper.isVariableAffected(getInput(), n,
								ModelHelper.OUTGOING)) {
					// something has happened to our variable
					if (n.getEventType() == Notification.SET
							&& n.getNewValue() != null) {
						// a new variable has been set
						usePartMappingCheckbox.setSelection(false);
						try {
							ModelHelper.setToParts(getInput(), null);
						} catch (IllegalArgumentException e) {
						}
						try {
							ModelHelper.setFromParts(getInput(), null);
						} catch (IllegalArgumentException e) {
						}
					}
				}
			}

		} };
	}

	@Override
	protected void createClient(Composite parent) {

		Composite composite = createFlatFormComposite(parent);
		createWidgets(composite);
	}

	private Composite createInputVariableWidgets(Composite top, Composite parent) {
		FlatFormData data;

		final Composite composite = inputVariableComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		} else {
			data.top = new FlatFormAttachment(top, IDetailsAreaConstants.VSPACE);
		}
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(InvokeImplSection.SPLIT_POINT,
				-InvokeImplSection.SPLIT_POINT_OFFSET);
		composite.setLayoutData(data);

		inputVariableLabel = fWidgetFactory.createLabel(composite,
				Messages.InvokeImplSection_7);
		inputVariableText = fWidgetFactory.createText(composite, EMPTY_STRING);
		inputVariableButton = fWidgetFactory.createButton(composite,
				EMPTY_STRING, SWT.ARROW | SWT.DOWN | SWT.CENTER);

		// Provide Content Assist for the variables
		// Content assist on partnerName
		RunnableProposal proposal = new RunnableProposal() {

			@Override
			public String getLabel() {
				return Messages.InvokeImplSection_10;
			}

			public void run() {
				createVariable(BPELUtils.getProcess(getInput()), null,
						isInvoke() ? ModelHelper.OUTGOING
								: ModelHelper.INCOMING);
			}
		};

		RunnableProposal proposal2 = new RunnableProposal() {

			@Override
			public String getLabel() {
				return Messages.InvokeImplSection_11;
			}

			public void run() {
				createVariable(getInput(), null,
						isInvoke() ? ModelHelper.OUTGOING
								: ModelHelper.INCOMING);
			}
		};

		RunnableProposal proposal3 = new RunnableProposal() {
			@Override
			public String getLabel() {
				return Messages.InvokeImplSection_12;
			}

			public void run() {
				int direction = isInvoke() ? ModelHelper.OUTGOING
						: ModelHelper.INCOMING;
				getCommandFramework().execute(
						new SetVariableCommand(getInput(), null, direction));
			}
		};

		VariableContentProvider provider = new VariableContentProvider();
		ModelContentProposalProvider proposalProvider;
		proposalProvider = new ModelContentProposalProvider(
				new ModelContentProposalProvider.ValueProvider() {
					@Override
					public Object value() {
						return getInput();
					}
				}, provider, fInputVariableFilter);

		proposalProvider.addProposalToEnd(new Separator());
		proposalProvider.addProposalToEnd(proposal);
		proposalProvider.addProposalToEnd(proposal2);
		proposalProvider.addProposalToEnd(proposal3);

		final FieldAssistAdapter contentAssist = new FieldAssistAdapter(
				inputVariableText, fTextContentAdapter, proposalProvider, null,
				null, true);
		// 
		contentAssist.setLabelProvider(new ModelLabelProvider());
		contentAssist.setPopupSize(new Point(300, 100));
		contentAssist.setFilterStyle(ContentProposalAdapter.FILTER_CUMULATIVE);
		contentAssist
				.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		contentAssist.addContentProposalListener(proposal);
		contentAssist.addContentProposalListener(proposal2);
		contentAssist.addContentProposalListener(proposal3);
		contentAssist
				.addContentProposalListener(new IContentProposalListener() {

					public void proposalAccepted(IContentProposal chosenProposal) {
						if (chosenProposal.getContent() == null) {
							return;
						}
						Variable variable = null;
						try {
							variable = (Variable) ((Adapter) chosenProposal)
									.getTarget();
						} catch (Throwable t) {
							return;
						}
						SetVariableCommand cmd = new SetVariableCommand(
								getInput(), variable);
						getCommandFramework().execute(cmd);
					}
				});

		// End of Content Assist for variable
		inputVariableButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				contentAssist.openProposals();
			}
		});

		inputVariableText.addListener(SWT.KeyDown, new Listener() {
			public void handleEvent(Event event) {
				if (event.keyCode == SWT.CR) {
					findAndSetOrCreateVariable(inputVariableText.getText(),
							isInvoke() ? ModelHelper.OUTGOING
									: ModelHelper.INCOMING);
				}
			}
		});
		
		// https://issues.jboss.org/browse/JBIDE-8048
		// do the same thing when variable name widget loses focus
		inputVariableText.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent arg0) {
			}

			public void focusLost(FocusEvent arg0) {
				findAndSetOrCreateVariable(inputVariableText.getText(),
						isInvoke() ? ModelHelper.OUTGOING
								: ModelHelper.INCOMING);
			}
		});

		data = new FlatFormData();
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(inputVariableText, +2, SWT.TOP);
		data.bottom = new FlatFormAttachment(inputVariableText, -2, SWT.BOTTOM);
		inputVariableButton.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
				operationLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(inputVariableButton, 0);
		inputVariableText.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(inputVariableText,
				-IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(inputVariableText, 0, SWT.CENTER);
		inputVariableLabel.setLayoutData(data);

		return composite;

	}

	/**
	 * The output variable widgets are only pertaining to Invoke activity, if
	 * there is an output message on the partner link
	 * 
	 * @param top
	 * @param parent
	 * @return the output variable composite
	 */

	private Composite createOutputVariableWidgets(Composite top,
			Composite parent) {
		FlatFormData data;

		final Composite composite = this.outputVariableComposite = createFlatFormComposite(parent);
		if (isReceive()) {
			// https://issues.jboss.org/browse/JBIDE-8048
			// don't even bother creating widgets we will never use
			return composite;
		}

		data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		} else {
			data.top = new FlatFormAttachment(top, IDetailsAreaConstants.VSPACE);
		}
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(InvokeImplSection.SPLIT_POINT,
				-InvokeImplSection.SPLIT_POINT_OFFSET);
		composite.setLayoutData(data);

		outputVariableLabel = fWidgetFactory.createLabel(composite,
				Messages.InvokeImplSection_13);
		outputVariableText = fWidgetFactory.createText(composite, EMPTY_STRING);
		outputVariableButton = fWidgetFactory.createButton(composite,
				EMPTY_STRING, SWT.ARROW | SWT.DOWN | SWT.CENTER);

		// Provide Content Assist for the operation

		// Runnable proposal.
		RunnableProposal proposal = new RunnableProposal() {

			@Override
			public String getLabel() {
				return Messages.InvokeImplSection_16;
			}

			public void run() {
				createVariable(BPELUtils.getProcess(getInput()), null,
						isInvoke() ? ModelHelper.INCOMING
								: ModelHelper.OUTGOING);
			}
		};

		RunnableProposal proposal2 = new RunnableProposal() {
			@Override
			public String getLabel() {
				return "Create Local Output Variable"; //$NON-NLS-1$
			}

			public void run() {
				createVariable(getInput(), null,
						isInvoke() ? ModelHelper.INCOMING
								: ModelHelper.OUTGOING);
			}
		};

		RunnableProposal proposal3 = new RunnableProposal() {
			@Override
			public String getLabel() {
				return "Clear Output Variable"; //$NON-NLS-1$
			}

			public void run() {
				getCommandFramework().execute(
						new SetVariableCommand(getInput(), null,
								isInvoke() ? ModelHelper.INCOMING
										: ModelHelper.OUTGOING));
			}
		};

		VariableContentProvider provider = new VariableContentProvider();
		ModelContentProposalProvider proposalProvider;
		proposalProvider = new ModelContentProposalProvider(
				new ModelContentProposalProvider.ValueProvider() {
					@Override
					public Object value() {
						return getInput();
					}
				}, provider, fOutputVariableFilter);

		proposalProvider.addProposalToEnd(new Separator());
		proposalProvider.addProposalToEnd(proposal);
		proposalProvider.addProposalToEnd(proposal2);
		proposalProvider.addProposalToEnd(proposal3);

		final FieldAssistAdapter contentAssist = new FieldAssistAdapter(
				outputVariableText, fTextContentAdapter, proposalProvider,
				null, null, true);
		// 
		contentAssist.setLabelProvider(new ModelLabelProvider());
		contentAssist.setPopupSize(new Point(300, 100));
		contentAssist.setFilterStyle(ContentProposalAdapter.FILTER_CUMULATIVE);
		contentAssist
				.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		contentAssist.addContentProposalListener(proposal);
		contentAssist.addContentProposalListener(proposal2);
		contentAssist.addContentProposalListener(proposal3);
		contentAssist
				.addContentProposalListener(new IContentProposalListener() {

					public void proposalAccepted(IContentProposal chosenProposal) {
						if (chosenProposal.getContent() == null) {
							return;
						}
						Variable variable = null;
						try {
							variable = (Variable) ((Adapter) chosenProposal)
									.getTarget();
						} catch (Throwable t) {
							return;
						}
						SetVariableCommand cmd = new SetVariableCommand(
								getInput(), variable, ModelHelper.INCOMING);
						getCommandFramework().execute(cmd);
					}
				});

		// End of Content Assist for operation

		outputVariableButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				contentAssist.openProposals();
			}
		});
		outputVariableText.addListener(SWT.KeyDown, new Listener() {
			public void handleEvent(Event event) {
				if (event.keyCode == SWT.CR) {
					findAndSetOrCreateVariable(outputVariableText.getText(),
							ModelHelper.INCOMING);
				}
			}
		});

		data = new FlatFormData();
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(outputVariableText, +2, SWT.TOP);
		data.bottom = new FlatFormAttachment(outputVariableText, -2, SWT.BOTTOM);
		outputVariableButton.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
				operationLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(outputVariableButton, 0);
		outputVariableText.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(outputVariableText,
				-IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(outputVariableText, 0, SWT.CENTER);
		outputVariableLabel.setLayoutData(data);

		return composite;
	}

	private void createPartMappingRows(ILabelProvider labelProvider,
			final EObject model, List<Part> messageParts, Group refGroup,
			EObject fromPartsOrToParts, final boolean isFromParts) {

		FlatFormData data;
		CLabel ref = null;

		for (final Part part : messageParts) {

			boolean isFirst = ref == null;

			// create text
			final Text text = fWidgetFactory.createText(refGroup, EMPTY_STRING);
			Variable var = null;
			// get the variable from a fromPart
			if (isFromParts) {
				FromParts fromParts = (FromParts) fromPartsOrToParts;
				if (fromParts != null && !fromParts.getChildren().isEmpty()) {
					for (FromPart fromPart : fromParts.getChildren()) {
						if (fromPart.getPart() != null
								&& fromPart.getPart().equals(part)) {
							var = fromPart.getToVariable();
							break;
						}
					}
				}
			}
			// get the variable from a toPart
			else {
				ToParts toParts = (ToParts) fromPartsOrToParts;
				if (toParts != null && !toParts.getChildren().isEmpty()) {
					for (ToPart toPart : toParts.getChildren()) {
						if (toPart.getPart() != null
								&& toPart.getPart().equals(part)) {
							var = toPart.getFromVariable();
							break;
						}
					}
				}
			}
			if (var != null) {
				text.setText(var.getName());
			} else {
				text.setText(EMPTY_STRING);
			}

			Button button = null;
			if (model instanceof OnEvent == false) {
				text.setEditable(false);

				// create button
				button = fWidgetFactory.createButton(refGroup, EMPTY_STRING,
						SWT.ARROW | SWT.DOWN | SWT.CENTER);

				// align button
				data = new FlatFormData();
				data.right = new FlatFormAttachment(100,
						-IDetailsAreaConstants.HSPACE);
				data.top = new FlatFormAttachment(text, +2, SWT.TOP);
				data.bottom = new FlatFormAttachment(text, -2, SWT.BOTTOM);
				button.setLayoutData(data);
			}

			// align text
			data = new FlatFormData();
			if (isFirst) {
				data.top = new FlatFormAttachment(0,
						IDetailsAreaConstants.VSPACE);
			} else {
				data.top = new FlatFormAttachment(ref,
						IDetailsAreaConstants.VSPACE);
			}
			data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
					ref, STANDARD_LABEL_WIDTH_LRG));
			if (button == null) {
				data.right = new FlatFormAttachment(100,
						-IDetailsAreaConstants.HSPACE);
			} else {
				data.right = new FlatFormAttachment(button,
						-IDetailsAreaConstants.HSPACE);
			}
			text.setLayoutData(data);

			// create label
			ref = new CLabel(refGroup, SWT.LEFT);
			ref.setText(labelProvider.getText(part));
			ref.setImage(labelProvider.getImage(part));
			ref.setBackground(refGroup.getBackground());

			// align label
			data = new FlatFormData();
			data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
			data.right = new FlatFormAttachment(text,
					-IDetailsAreaConstants.HSPACE);
			data.top = new FlatFormAttachment(text, 0, SWT.CENTER);
			ref.setLayoutData(data);

			/*
			 * CONTENT ASSIST
			 */
			RunnableProposal proposal1 = new RunnableProposal() {

				@Override
				public String getLabel() {
					return "Create global Variable";
				}

				public void run() {
					createVariableForPartMapping(BPELUtils.getProcess(model),
							model, part, isFromParts);
				}

			};

			RunnableProposal proposal2 = new RunnableProposal() {

				@Override
				public String getLabel() {
					return "Create local Variable";
				}

				public void run() {
					createVariableForPartMapping(model, model, part,
							isFromParts);
				}

			};

			RunnableProposal proposal3 = new RunnableProposal() {

				@Override
				public String getLabel() {
					return "Clear Variable";
				}

				public void run() {
					Command cmd = null;
					if (isFromParts) {
						cmd = new AddFromPartCommand(model, null, part);
					} else {
						cmd = new AddToPartCommand(model, null, part);
					}
					getCommandFramework().execute(cmd);
				}

			};

			VariableFilter filter = new VariableFilter();
			if (part.getElementDeclaration() != null) {
				filter.setType(part.getElementDeclaration());
			} else if (part.getTypeDefinition() != null) {
				filter.setType(part.getTypeDefinition());
			}
			VariableContentProvider provider = new VariableContentProvider();
			ModelContentProposalProvider proposalProvider = new ModelContentProposalProvider(
					new ModelContentProposalProvider.ValueProvider() {

						@Override
						public Object value() {
							return getInput();
						}

					}, provider, filter);

			proposalProvider.addProposalToEnd(new Separator());
			proposalProvider.addProposalToEnd(proposal1);
			proposalProvider.addProposalToEnd(proposal2);
			proposalProvider.addProposalToEnd(proposal3);

			final FieldAssistAdapter contentAssist = new FieldAssistAdapter(
					text, fTextContentAdapter, proposalProvider, null, null,
					true);
			contentAssist.setLabelProvider(labelProvider);
			contentAssist.setPopupSize(new Point(300, 100));
			contentAssist
					.setFilterStyle(ContentProposalAdapter.FILTER_CUMULATIVE);
			contentAssist
					.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
			contentAssist.addContentProposalListener(proposal1);
			contentAssist.addContentProposalListener(proposal2);
			contentAssist.addContentProposalListener(proposal3);
			contentAssist
					.addContentProposalListener(new IContentProposalListener() {

						public void proposalAccepted(IContentProposal proposal) {
							if (proposal.getContent() == null) {
								return;
							}
							Variable variable = null;
							try {
								variable = (Variable) ((Adapter) proposal)
										.getTarget();
							} catch (Throwable t) {
								return;
							}

							Command cmd = null;
							if (isFromParts) {
								cmd = new AddFromPartCommand(model, variable,
										part);
							} else {
								cmd = new AddToPartCommand(model, variable,
										part);
							}
							getCommandFramework().execute(cmd);
						}

					});

			// End of Content Assist for variable
			if (button != null) {
				button.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						contentAssist.openProposals();
					}
				});
			} else if (model instanceof OnEvent) {
				IOngoingChange change = new IOngoingChange() {

					public Command createApplyCommand() {
						OnEvent onEvent = (OnEvent) model;
						String s = text.getText();
						if (EMPTY_STRING.equals(s)) {
							s = null;
						}
						CompoundCommand ccmd = new CompoundCommand();
						FromParts fromParts = onEvent.getFromParts();
						FromPart fromPart = null;
						Variable variable = null;
						if (fromParts != null
								&& fromParts.getChildren() != null) {
							for (FromPart fp : fromParts.getChildren()) {
								if (part.equals(fp.getPart())) {
									fromPart = fp;
								}
							}
						}
						if (s != null) {
							if (fromPart != null) {
								variable = fromPart.getToVariable();
							}
							if (variable == null) {
								variable = BPELFactory.eINSTANCE
										.createVariable();
								// set the variable's type to the part's type
								variable.setType(part.getTypeDefinition());
								variable.setXSDElement(part
										.getElementDeclaration());
							}
							variable.setName(s);
							ccmd.add(new AddFromPartCommand(onEvent, variable,
									part));
						} else {
							ccmd
									.add(new AddFromPartCommand(onEvent, null,
											part));
						}
						return ccmd;
					}

					public String getLabel() {
						return IBPELUIConstants.CMD_SELECT_VARIABLE;
					}

					public void restoreOldState() {
						updatePartMappingWidgets();
					}

				};
				ChangeTracker onEventVariableTracker = new ChangeTracker(text,
						change, getCommandFramework());
				onEventVariableTracker.startTracking();
			}
		}
	}

	/**
	 * Create an input variable, set it to the right type, and set the input
	 * variable pon the activity.
	 * 
	 * @param ref
	 *            the object on which to create the variable (Scope or Process)
	 * @param name
	 *            the name of the variable, or null
	 * @param the
	 *            direction of the variable
	 */

	private void createVariable(EObject ref, String name, int direction) {

		Variable variable = BPELFactory.eINSTANCE.createVariable();

		if (name == null) {
			name = plainLabelWordFor(direction);
		}

		Message messageType = null;
		XSDElementDeclaration elementType = null;

		Object type = ModelHelper.getVariableType(getInput(), direction);

		if (type != null && type instanceof Message) {
			messageType = (Message) type;
			if (messageType.getEParts().size() == 1) {
				Part part = (Part) messageType.getEParts().get(0);
				elementType = part.getElementDeclaration();
			}
		}

		// ask for the name, we know the type.
		NameDialog nameDialog = new NameDialog(inputVariableComposite
				.getShell(), Messages.VariableSelectorDialog_New_Variable_4,
				Messages.VariableSelectorDialog_Variable_Name_5, name, BPELUtil
						.getNCNameValidator());

		if (nameDialog.open() == Window.CANCEL) {
			return;
		}

		// set name and type
		variable.setName(nameDialog.getValue());

		if (elementType != null) {
			variable.setXSDElement(elementType);
		} else if (messageType != null) {
			variable.setMessageType(messageType);
		}

		// create the variable and then set the input variable to it.
		CompoundCommand cmd = new CompoundCommand();
		cmd.add(new AddVariableCommand(ref, variable));
		cmd.add(new SetVariableCommand(getInput(), variable, direction));

		getCommandFramework().execute(cmd);
	}

	private void createVariableForPartMapping(EObject ref, EObject model,
			Part part, boolean isFromPart) {

		Variable variable = BPELFactory.eINSTANCE.createVariable();

		// set the variable's type to the part's type
		if (part.getTypeDefinition() != null) {
			variable.setType(part.getTypeDefinition());
		} else if (part.getElementDeclaration() != null) {
			variable.setXSDElement(part.getElementDeclaration());
		}

		// let the user choose a name for the variable
		NameDialog nameDialog = new NameDialog(inputVariableComposite
				.getShell(), Messages.VariableSelectorDialog_New_Variable_4,
				Messages.VariableSelectorDialog_Variable_Name_5, null, BPELUtil
						.getNCNameValidator());
		if (nameDialog.open() == Window.CANCEL) {
			return;
		}
		variable.setName(nameDialog.getValue());

		CompoundCommand cmd = new CompoundCommand();
		cmd.add(new AddVariableCommand(ref, variable));
		if (isFromPart) {
			cmd.add(new AddFromPartCommand(model, variable, part));
		} else {
			cmd.add(new AddToPartCommand(model, variable, part));
		}

		getCommandFramework().execute(cmd);
	}

	private void createWidgets(Composite composite) {

		this.parentComposite = composite;

		// create the widgets
		this.usePartMappingCheckbox = fWidgetFactory.createButton(composite,
				"Use WSDL Message Parts Mapping", SWT.CHECK);
		this.usePartMappingCheckbox
				.addSelectionListener(new UsePartMappingCheckboxSelectionListener());

		this.nonPartMappingComposite = createFlatFormComposite(composite);
		Composite ref = createInputVariableWidgets(null,
				nonPartMappingComposite);
		createOutputVariableWidgets(ref, nonPartMappingComposite);

		// part mapping composite
		this.partMappingComposite = createFlatFormComposite(composite);

		// layout the widgets
		FlatFormData ffd = new FlatFormData();
		ffd.top = new FlatFormAttachment(0, 0);
		ffd.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		this.usePartMappingCheckbox.setLayoutData(ffd);

		ffd = new FlatFormData();
		ffd.top = new FlatFormAttachment(this.usePartMappingCheckbox,
				IDetailsAreaConstants.VSPACE);
		ffd.left = new FlatFormAttachment(0, 0);
		ffd.right = new FlatFormAttachment(100, 0);
		this.partMappingComposite.setLayoutData(ffd);

		ffd = new FlatFormData();
		ffd.top = new FlatFormAttachment(this.usePartMappingCheckbox,
				IDetailsAreaConstants.VSPACE);
		ffd.left = new FlatFormAttachment(0, 0);
		ffd.right = new FlatFormAttachment(100, 0);
		this.nonPartMappingComposite.setLayoutData(ffd);
	}

	private void findAndSetOrCreateVariable(String text, int direction) {

		text = text.trim();
		EObject model = getInput();

		SetVariableCommand cmd = new SetVariableCommand(getInput(), null,
				direction);
		if (text.length() > 0) {
			Variable variable = (Variable) ModelHelper
					.findElementByName(ModelHelper.getContainingScope(model),
							text, Variable.class);
			if (variable == null) {

				createVariable(getInput(), text, direction);
				return;
			}

			cmd.setNewValue(variable);
		}

		getCommandFramework().execute(cmd);
	}

	/**
	 * Answer, based on the model, whether we should display "Fault" instead of
	 * "Response".
	 */
	private boolean getDisplayFault() {
		EObject model = getModel();
		if (model instanceof Reply) {
			Reply reply = (Reply) model;
			if (reply.getFaultName() != null) {
				return true;
			}
		}
		return false;
	}

	private boolean isInvoke() {
		return (getInput() instanceof Invoke);
	}

	private boolean isReply() {
		return getInput() instanceof Reply;
	}

	private boolean isReceive() {
		// https://issues.jboss.org/browse/JBIDE-8048
		// OnEvent is also a type of Receive
		return getInput() instanceof Receive || getInput() instanceof OnMessage || getInput() instanceof OnEvent;
	}

	/**
	 * The same as labelWordFor(), except these strings don't contain mnemonics!
	 * 
	 * @param direction
	 * @return the label
	 */
	private String plainLabelWordFor(int direction) {
		if (isInvoke()) {
			return (direction == ModelHelper.OUTGOING || direction == ModelHelper.NOT_SPECIFIED) ? Messages.InvokeImplDetails_Request_3_Plain
					: Messages.InvokeImplDetails_Response_4_Plain;
		}
		return (direction == ModelHelper.OUTGOING || direction == ModelHelper.NOT_SPECIFIED) ? Messages.InvokeImplDetails_Response_4_Plain
				: Messages.InvokeImplDetails_Request_3_Plain;
	}

	@Override
	public void refresh() {
		super.refresh();

		boolean showPartMappingComposite = this.usePartMappingCheckbox
				.getSelection();
		updateWidgets(showPartMappingComposite);

		if (showPartMappingComposite) {
			updatePartMappingWidgets();
		} else {
			updateInputVariableWidgets();
			updateOutputVariableWidgets();
		}
	}

	private boolean shouldUsePartMapping(EObject model) {

		boolean shouldUsePartMapping = false;

		if (model instanceof Reply || model instanceof Invoke) {
			shouldUsePartMapping = true;
			if (ModelHelper.getVariable(model, ModelHelper.OUTGOING) != null) {
				return false;
			}
		}

		if (model instanceof Receive || model instanceof Invoke
				|| model instanceof OnMessage || model instanceof OnEvent) {
			shouldUsePartMapping = true;
			if (ModelHelper.getVariable(model, ModelHelper.INCOMING) != null) {
				return false;
			}
		}

		return shouldUsePartMapping;
	}

	private void updateInputVariableWidgets() {

		inputVariableComposite.setVisible(!isReply());
		if (getInput() instanceof OnEvent) {
			// https://issues.jboss.org/browse/JBIDE-8048
			// hide the proposal drop-down button - user must enter variable name
			inputVariableButton.setVisible(false);
		}

		if (isReply())
			return;

		if (isInvoke()) {
			inputVariableLabel.setText(Messages.InvokeImplSection_22);
		} else {
			inputVariableLabel.setText(Messages.InvokeImplSection_23);
		}

		Variable inputVar = ModelHelper.getVariable(getInput(),
				isInvoke() ? ModelHelper.OUTGOING : ModelHelper.INCOMING);

		if (inputVar != null) {
			inputVariableText.setText(inputVar.getName());
		} else {
			inputVariableText.setText(EMPTY_STRING);
		}

		// Figure out the type of the message.
		fInputVariableFilter.clear();
		Object type = ModelHelper.getVariableType(getInput(),
				isInvoke() ? ModelHelper.OUTGOING : ModelHelper.INCOMING);
		if (type != null && type instanceof Message) {
			fInputVariableFilter.setType((Message) type);
		}
	}

	private void updateOutputVariableWidgets() {

		outputVariableComposite.setVisible(!isReceive());

		if (isReceive()) {
			return;
		}

		if (isInvoke()) {
			outputVariableLabel.setText(Messages.InvokeImplSection_13);
		} else {
			outputVariableLabel.setText(Messages.InvokeImplSection_23);
		}

		Variable outputVar = ModelHelper.getVariable(getInput(),
				isInvoke() ? ModelHelper.INCOMING : ModelHelper.OUTGOING);
		if (outputVar != null) {
			outputVariableText.setText(outputVar.getName());
		} else {
			outputVariableText.setText(EMPTY_STRING);
		}

		// Figure out the type of the message.
		fOutputVariableFilter.clear();
		Object type = ModelHelper.getVariableType(getInput(),
				isInvoke() ? ModelHelper.INCOMING : ModelHelper.OUTGOING);
		if (type != null) {
			if (type instanceof Message) {
				fOutputVariableFilter.setType((Message) type);
			}
		}
	}

	private void updatePartMappingWidgets() {

		ILabelProvider labelProvider = new ModelLabelProvider();

		final EObject model = getModel();

		boolean showInputs = ModelHelper.isMessageActivity(model,
				(isInvoke() ? ModelHelper.OUTGOING : ModelHelper.INCOMING));
		boolean showFaults = getDisplayFault();
		boolean showOutputs = !showFaults
				&& ModelHelper.isMessageActivity(model,
						(isInvoke() ? ModelHelper.INCOMING
								: ModelHelper.OUTGOING));

		Operation operation = ModelHelper.getOperation(model);

		if (operation != null && !operation.eIsProxy()) {

			this.usePartMappingCheckbox.setEnabled(true);

			List<Part> inputParts = Collections.emptyList();
			if (showInputs) {
				inputParts = PartMappingUtil.getPartsForPartMapping(operation,
						WSDLConstants.INPUT, null);
			}

			List<Part> outputParts = Collections.emptyList();
			if (showOutputs) {
				outputParts = PartMappingUtil.getPartsForPartMapping(operation,
						WSDLConstants.OUTPUT, null);
			}

			List<Part> faultParts = Collections.emptyList();
			if (showFaults) {
				String faultName = ModelHelper.getFaultName(model);
				if (faultName != null) {
					faultParts = PartMappingUtil.getPartsForPartMapping(
							operation, WSDLConstants.FAULT, faultName);
				}
			}

			Group refGroup = null;
			// print out all input parts
			if (inputParts.size() > 0) {

				FromParts fromParts = ModelHelper.getFromParts(model);

				FlatFormData data = new FlatFormData();
				data.left = new FlatFormAttachment(0,
						IDetailsAreaConstants.HSPACE);
				data.right = new FlatFormAttachment(100,
						-IDetailsAreaConstants.HSPACE);
				if (refGroup != null) {
					data.top = new FlatFormAttachment(refGroup,
							IDetailsAreaConstants.VSPACE);
				} else {
					data.top = new FlatFormAttachment(0,
							IDetailsAreaConstants.VSPACE);
				}
				refGroup = fWidgetFactory.createGroup(
						this.partMappingComposite, "Input(s)");
				refGroup.setLayoutData(data);
				refGroup.setLayout(new FlatFormLayout());

				createPartMappingRows(labelProvider, model, inputParts,
						refGroup, fromParts, true);
			}

			// print out all output parts
			if (outputParts.size() > 0) {

				ToParts toParts = ModelHelper.getToParts(model);

				FlatFormData data = new FlatFormData();
				data.left = new FlatFormAttachment(0,
						IDetailsAreaConstants.HSPACE);
				data.right = new FlatFormAttachment(100,
						-IDetailsAreaConstants.HSPACE);
				if (refGroup != null) {
					data.top = new FlatFormAttachment(refGroup,
							IDetailsAreaConstants.VSPACE);
				} else {
					data.top = new FlatFormAttachment(0,
							IDetailsAreaConstants.VSPACE);
				}
				refGroup = fWidgetFactory.createGroup(
						this.partMappingComposite, "Output(s)");
				refGroup.setLayoutData(data);
				refGroup.setLayout(new FlatFormLayout());

				createPartMappingRows(labelProvider, model, outputParts,
						refGroup, toParts, false);
			}

			// print out all fault parts
			if (faultParts.size() > 0) {

				ToParts toParts = ModelHelper.getToParts(model);

				FlatFormData data = new FlatFormData();
				data.left = new FlatFormAttachment(0,
						IDetailsAreaConstants.HSPACE);
				data.right = new FlatFormAttachment(100,
						-IDetailsAreaConstants.HSPACE);
				if (refGroup != null) {
					data.top = new FlatFormAttachment(refGroup,
							IDetailsAreaConstants.VSPACE);
				} else {
					data.top = new FlatFormAttachment(0,
							IDetailsAreaConstants.VSPACE);
				}
				refGroup = fWidgetFactory.createGroup(
						this.partMappingComposite, "Fault(s)");
				refGroup.setLayoutData(data);
				refGroup.setLayout(new FlatFormLayout());

				createPartMappingRows(labelProvider, model, faultParts,
						refGroup, toParts, false);
			}
			this.parentComposite.layout(true);
		} else {
			// TODO - we have an OperationProxy. What shall we do???
			this.usePartMappingCheckbox.setEnabled(false);
		}
	}

	private void updateWidgets(boolean showPartMappingComposite) {

		if (this.partMappingComposite != null) {
			this.partMappingComposite.dispose();
		}
		this.partMappingComposite = createFlatFormComposite(this.parentComposite);
		FlatFormData ffd = new FlatFormData();
		ffd.top = new FlatFormAttachment(this.usePartMappingCheckbox,
				IDetailsAreaConstants.VSPACE);
		ffd.left = new FlatFormAttachment(0, 0);
		ffd.right = new FlatFormAttachment(100, 0);
		this.partMappingComposite.setLayoutData(ffd);

		if (!showPartMappingComposite) {
			this.usePartMappingCheckbox.setSelection(false);
			this.partMappingComposite.setVisible(false);
			this.nonPartMappingComposite.setVisible(true);
		} else {
			this.usePartMappingCheckbox.setSelection(true);
			this.partMappingComposite.setVisible(true);
			this.nonPartMappingComposite.setVisible(false);
		}
	}
}
