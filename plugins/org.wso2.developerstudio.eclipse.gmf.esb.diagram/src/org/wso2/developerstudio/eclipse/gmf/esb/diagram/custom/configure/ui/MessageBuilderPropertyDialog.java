package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder;

public class MessageBuilderPropertyDialog extends Dialog {

	private Table builderTable;
	private Button addBtn;
	private Button removeBtn;
	private Text cTypeTxt;
	private Text builderClassTxt;
	private Text formatterClassTxt;

	private BuilderMediator builderMediator;
	private TransactionalEditingDomain editingDomain;
	private TableItem currentSelectedItem;

	public MessageBuilderPropertyDialog(Shell parentShell,
			BuilderMediator builderMediator) {
		super(parentShell);
		this.builderMediator = builderMediator;
		this.editingDomain = TransactionUtil.getEditingDomain(builderMediator);
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setSize(1000, 2000);

		// Set layout for the main container
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		// setting up the builder table
		builderTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn builder = new TableColumn(builderTable, SWT.LEFT);

		builder.setText("Message Builder");
		builder.setWidth(300);

		builderTable.setHeaderVisible(true);
		builderTable.setLinesVisible(true);

		addBtn = new Button(container, SWT.NONE);
		addBtn.setText("Add...");
		addBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				addMessageBuilder();
			}
		});

		removeBtn = new Button(container, SWT.NONE);
		removeBtn.setText("Remove");
		removeBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				removeMessageBuilder();

			}
		});

		builderTable.addListener(SWT.Selection, getTableListner());

		for (MessageBuilder mBuilder : builderMediator.getMessageBuilders()) {

			bindBuilder(mBuilder);
		}

		Group configGrp = new Group(container, SWT.NONE);
		configGrp.setText("Message Builder Properties");

		GridLayout gl = new GridLayout(2, false);
		configGrp.setLayout(gl);

		Label cTypeLabel = new Label(configGrp, SWT.NONE);
		cTypeLabel.setText("Content Type");

		GridData gd1 = new GridData();
		gd1.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd1.verticalIndent = 10;
		cTypeLabel.setLayoutData(gd1);

		cTypeTxt = new Text(configGrp, SWT.SINGLE | SWT.BORDER);

		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.verticalIndent = 10;
		cTypeTxt.setLayoutData(gd2);
		cTypeTxt.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				setBuilderType();
			}
		});

		Label builderClsLabel = new Label(configGrp, SWT.NONE);
		builderClsLabel.setText("Builder Class");
		builderClsLabel.setLayoutData(gd1);

		builderClassTxt = new Text(configGrp, SWT.SINGLE | SWT.BORDER);
		builderClassTxt.setLayoutData(gd2);
		builderClassTxt.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				setBuilderClass();
			}
		});

		Label formatterClassLabel = new Label(configGrp, SWT.NONE);
		formatterClassLabel.setText("Formatter Class");
		formatterClassLabel.setLayoutData(gd1);

		formatterClassTxt = new Text(configGrp, SWT.SINGLE | SWT.BORDER);
		formatterClassTxt.setLayoutData(gd2);
		formatterClassTxt.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				setFormatterClass();
			}
		});

		if (builderTable.getItemCount() > 0) {
			builderTable.select(0);
			TableItem item = builderTable.getItem(builderTable
					.getSelectionIndex());
			setCurrentSelectedItem(item);
			updateFields(item);
		}

		// Layout related configurations
		FormData builderTableLayoutData = new FormData(SWT.DEFAULT, 150);
		builderTableLayoutData.top = new FormAttachment(0, 0);
		builderTableLayoutData.left = new FormAttachment(0, 0);
		builderTable.setLayoutData(builderTableLayoutData);

		FormData frmData = new FormData();
		frmData.left = new FormAttachment(builderTable, 5);
		frmData.right = new FormAttachment(100, 0);
		addBtn.setLayoutData(frmData);

		frmData = new FormData();
		frmData.top = new FormAttachment(addBtn, 5);
		frmData.left = new FormAttachment(builderTable, 5);
		removeBtn.setLayoutData(frmData);

		frmData = new FormData();
		frmData.top = new FormAttachment(builderTable, 20);
		frmData.left = new FormAttachment(0, 0);
		frmData.right = new FormAttachment(100, 0);
		frmData.bottom = new FormAttachment(100, 0);
		configGrp.setLayoutData(frmData);

		return parent;

	}

	/**
	 * 
	 * Adding Message builder to builder table.
	 */
	private void addMessageBuilder() {

		MessageBuilder messageBuilder = EsbFactory.eINSTANCE
				.createMessageBuilder();
		TableItem item = bindBuilder(messageBuilder);

		AddCommand addCmd = new AddCommand(editingDomain, builderMediator,
				EsbPackage.Literals.BUILDER_MEDIATOR__MESSAGE_BUILDERS,
				messageBuilder);

		if (addCmd.canExecute()) {

			editingDomain.getCommandStack().execute(addCmd);
		}
		builderTable.select(builderTable.indexOf(item));
		setCurrentSelectedItem(item);

	}

	/**
	 * 
	 * Remove Message builder from builder table.
	 */

	private void removeMessageBuilder() {

		int selectedIndex = builderTable.getSelectionIndex();
		if (-1 != selectedIndex) {

			unbindBuilder(selectedIndex);

			// Select the next available candidate for deletion.
			if (selectedIndex < builderTable.getItemCount()) {
				builderTable.select(selectedIndex);
			} else {
				builderTable.select(selectedIndex - 1);
			}
		}
	}

	/**
	 * create Listener for table
	 * 
	 */
	private Listener getTableListner() {

		Listener builderTableListner = new Listener() {

			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {

						TableItem item = (TableItem) evt.item;
						setCurrentSelectedItem(item);
						updateFields(item);

					}
				}
			}
		};

		return builderTableListner;
	}

	private TableItem bindBuilder(MessageBuilder builder) {

		TableItem item = new TableItem(builderTable, SWT.NONE);
		item.setText(new String[] { "MessageBuilder" });
		item.setData(builder);
		return item;
	}

	private void unbindBuilder(int itemIndex) {

		MessageBuilder builder = getcurrentMesssageBuilder();

		if (builder != null && builder.eContainer() != null) {

			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					builderMediator,
					EsbPackage.Literals.BUILDER_MEDIATOR__MESSAGE_BUILDERS,
					builder);

			if (removeCmd.canExecute()) {

				editingDomain.getCommandStack().execute(removeCmd);
			}
		}

		builderTable.remove(itemIndex);
	}

	private void setBuilderType() {
		MessageBuilder builder = getcurrentMesssageBuilder();

		if (builder != null) {
			SetCommand setCmd = new SetCommand(editingDomain, builder,
					EsbPackage.Literals.MESSAGE_BUILDER__CONTENT_TYPE,
					cTypeTxt.getText());
			if (setCmd.canExecute()) {

				editingDomain.getCommandStack().execute(setCmd);
			}
		}
	}

	private void setBuilderClass() {

		MessageBuilder builder = getcurrentMesssageBuilder();

		if (builder != null) {
			SetCommand setCmd = new SetCommand(editingDomain, builder,
					EsbPackage.Literals.MESSAGE_BUILDER__BUILDER_CLASS,
					builderClassTxt.getText());
			if (setCmd.canExecute()) {

				editingDomain.getCommandStack().execute(setCmd);
			}
		}
	}

	private void setFormatterClass() {

		MessageBuilder builder = getcurrentMesssageBuilder();

		if (builder != null) {
			SetCommand setCmd = new SetCommand(editingDomain, builder,
					EsbPackage.Literals.MESSAGE_BUILDER__FORMATTER_CLASS,
					formatterClassTxt.getText());
			if (setCmd.canExecute()) {

				editingDomain.getCommandStack().execute(setCmd);
			}
		}

	}

	private void updateFields(TableItem item) {

		MessageBuilder builder = getcurrentMesssageBuilder();

		if (builder != null) {

			if (builder.getContentType() != null) {

				cTypeTxt.setText(builder.getContentType());

			} else {

				cTypeTxt.setText("");
			}

			if (builder.getBuilderClass() != null) {

				builderClassTxt.setText(builder.getBuilderClass());

			} else {

				builderClassTxt.setText("");
			}

			if (builder.getFormatterClass() != null) {

				formatterClassTxt.setText(builder.getFormatterClass());

			} else {

				formatterClassTxt.setText("");
			}
		}
	}

	private MessageBuilder getcurrentMesssageBuilder() {

		TableItem currentItem = getCurrentSelectedItem();

		if (currentItem != null && currentItem.getData() != null) {

			MessageBuilder builder = (MessageBuilder) currentItem.getData();

			return builder;
		}

		return null;

	}

	public TableItem getCurrentSelectedItem() {
		return currentSelectedItem;
	}

	public void setCurrentSelectedItem(TableItem currentSelectedItem) {
		this.currentSelectedItem = currentSelectedItem;
	}

	public void okPressed() {

		super.okPressed();
	}

}
