package org.wso2.developerstudio.eclipse.ds.presentation.md;

import java.math.BigInteger;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.ds.DataService;

public class DetailSectionUiUtil {

	public static boolean isFocusedOnDetailSection;
	DataService dataService;
	EditingDomain editingDomain;

	protected DetailSectionUiUtil(DataService dataService, EditingDomain editingDomain) {

		this.dataService = dataService;
		this.editingDomain = editingDomain;
	}

	/**
	 * @param detailsclient
	 * @param toolkit
	 * @param input
	 *            Selected object
	 * @param initialValue
	 * @param metaObject
	 * @param displayValues
	 * @return
	 */
	public Combo getCustomComboField(Composite detailsclient, FormToolkit toolkit, Object input,
	                                 String initialValue, EAttribute metaObject,
	                                 String[] displayValues) {

		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.widthHint = 200;
		Combo combo = new Combo(detailsclient, SWT.READ_ONLY);

		combo.setLayoutData(gd);
		addFocusListner(combo);

		toolkit.adapt(combo, true, true);

		for (int i = 0; i < displayValues.length; i++) {

			if (displayValues[i] != null)
				combo.add(displayValues[i], i);
		}
		if (initialValue != null && !initialValue.equals("")) {

			for (int j = 0; j < displayValues.length; j++) {

				if (displayValues[j] != null) {
					if (initialValue.equals(displayValues[j])) {
						combo.select(j);
						break;
					}
				}
			}
		} else {
			if (combo.getItemCount() >= 1) {

				combo.select(0);
			}
		}
		
		if (input != null && metaObject != null) {

			addModifyListnerForCustomComboFields(combo, input, metaObject);

		}
		
		return combo;
	}

	/**
	 * @param detailsclient
	 *            :
	 * @param toolkit
	 * @param input
	 * @param initialVal
	 * @param metaObject
	 * @return Combo with boolean persistence feature.
	 */
	public Combo getBooleanComboField(Composite detailsclient, FormToolkit toolkit, Object input,
	                                  boolean initialVal, EAttribute metaObject) {

		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.widthHint = 200;
		Combo combo = new Combo(detailsclient, SWT.READ_ONLY);
		combo.add("True", 0);
		combo.add("False", 1);
		combo.setLayoutData(gd);
		addFocusListner(combo);
		if (initialVal) {
			combo.select(0);
		} else {
			combo.select(1);
		}

		toolkit.adapt(combo, true, true);

		if (input != null && metaObject != null) {

			addModifylistnersForBooleanComboFields(combo, input, metaObject);
		}

		return combo;
	}

	/**
	 * @param detailsclient
	 *            : Client that hold the creating combo.
	 * @param toolkit
	 * @param input
	 * @param initialVal
	 * @param metaObject
	 * @return : Combo with string persistence feature.
	 */
	public Combo getBooleanComboWithStringPersistance(Composite detailsclient, FormToolkit toolkit,
	                                                  Object input, String initialVal,
	                                                  EAttribute metaObject) {

		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.widthHint = 200;
		Combo combo = new Combo(detailsclient, SWT.READ_ONLY);
		combo.add("True", 0);
		combo.add("False", 1);
		combo.setLayoutData(gd);
		addFocusListner(combo);
		boolean isSet = new Boolean(initialVal).booleanValue();
		if (isSet) {
			combo.select(0);
		} else {
			combo.select(1);
		}

		toolkit.adapt(combo, true, true);

		if (input != null && metaObject != null) {

			addModifylistnersForBooleanComboWithStringPersi(combo, input, metaObject);

		}

		return combo;
	}

	/**
	 * @param detailsclient
	 *            : Client that hold the creating text
	 * @param toolkit
	 *            : Form toolkit
	 * @param input
	 *            : Input Object currently selected
	 * @param text
	 *            : Initial value
	 * @param metaObject
	 *            : Meta Object describes the EMF context
	 * @param dataType
	 *            : Data Type of the focused value
	 * @return Configured Styled Text field
	 */
	public Text getAttributeField(Composite detailsclient, FormToolkit toolkit, Object input,
	                              String existingVal, EAttribute metaObject, String dataType) {

		Text dtxt = toolkit.createText(detailsclient, "", SWT.NONE);
		addCommonActions(dtxt);
		dtxt.setEditable(true);
		dtxt.setEnabled(true);

		// adding control decoration for validation
		final ControlDecoration controlDecoration = crateControlDecoration(dtxt);
		controlDecoration.hide();
		toolkit.adapt(dtxt, true, true);
		if (existingVal != null)
			dtxt.setText(existingVal);

		/*
		 * StyleRange styleRange = new StyleRange();
		 * styleRange.start = 0;
		 * styleRange.length = "".length();
		 * styleRange.fontStyle = SWT.NORMAL;
		 * styleRange.foreground =
		 * detailsclient.getDisplay().getSystemColor(SWT.COLOR_BLACK);
		 * dtxt.setStyleRange(styleRange);
		 */

		GridData gd = new GridData();
		gd.widthHint = 200;
		gd.heightHint = 15;
		dtxt.setLayoutData(gd);
		addModifyListnersForTextFields(dtxt, dataType, input, metaObject, controlDecoration);
		addFocusListner(dtxt);
		addTraverseListner(dtxt);
		return dtxt;

	}

	public Text getPassWordField(Composite detailsclient, FormToolkit toolkit, Object input,
	                             String existingVal, EAttribute metaObject, String dataType) {

		Text dtxt = toolkit.createText(detailsclient, "", SWT.PASSWORD);
		addCommonActions(dtxt);
		dtxt.setEditable(true);
		dtxt.setEnabled(true);

		// adding control decoration for validation
		final ControlDecoration controlDecoration = crateControlDecoration(dtxt);
		controlDecoration.hide();
		toolkit.adapt(dtxt, true, true);
		if (existingVal != null)
			dtxt.setText(existingVal);

		/*
		 * StyleRange styleRange = new StyleRange();
		 * styleRange.start = 0;
		 * styleRange.length = "".length();
		 * styleRange.fontStyle = SWT.NORMAL;
		 * styleRange.foreground =
		 * detailsclient.getDisplay().getSystemColor(SWT.COLOR_BLACK);
		 * dtxt.setStyleRange(styleRange);
		 */

		GridData gd = new GridData();
		gd.widthHint = 200;
		gd.heightHint = 15;
		dtxt.setLayoutData(gd);
		addModifyListnersForTextFields(dtxt, dataType, input, metaObject, controlDecoration);
		addFocusListner(dtxt);
		addTraverseListner(dtxt);
		return dtxt;

	}

	/**
	 * @param detailsclient
	 *            : Client that hold the creating text
	 * @param toolkit
	 *            : Form toolkit
	 * @param input
	 *            : Input Object currently selected
	 * @param text
	 *            : Initial value
	 * @param metaObject
	 *            : Meta Object describes the EMF context
	 * @param dataType
	 *            : Data Type of the focused value
	 * @return Configured Styled Text field
	 */
	public Text getMultilineTextFileld(Composite detailsclient, FormToolkit toolkit, Object input,
	                                   String existingVal, EAttribute metaObject, String dataType) {

		Text dtxt = toolkit.createText(detailsclient, "", SWT.MULTI | SWT.WRAP);
		addCommonActions(dtxt);
		dtxt.setEditable(true);
		dtxt.setEnabled(true);

		// adding control decoration for validation
		final ControlDecoration controlDecoration = crateControlDecoration(dtxt);
		controlDecoration.hide();
		toolkit.adapt(dtxt, true, true);
		if (existingVal != null)
			dtxt.setText(existingVal);

		/*
		 * StyleRange styleRange = new StyleRange();
		 * styleRange.start = 0;
		 * styleRange.length = "".length();
		 * styleRange.fontStyle = SWT.NORMAL;
		 * styleRange.foreground =
		 * detailsclient.getDisplay().getSystemColor(SWT.COLOR_BLACK);
		 * dtxt.setStyleRange(styleRange);
		 */

		GridData gd = new GridData();
		gd.widthHint = 350;
		gd.heightHint = 200;
		dtxt.setLayoutData(gd);
		addModifyListnersForTextFields(dtxt, dataType, input, metaObject, controlDecoration);
		addFocusListner(dtxt);
		addTraverseListner(dtxt);
		return dtxt;

	}

	private void addCommonActions(Text text) {

		Listener keyBindListener = new Listener() {

			public void handleEvent(Event event) {
				if (event.stateMask == SWT.CTRL && event.keyCode == 'a') {

					((Text) event.widget).selectAll();

				} else if (event.stateMask == SWT.CTRL && event.keyCode == 'c') {

					((Text) event.widget).copy();

				} else if (event.stateMask == SWT.CTRL && event.keyCode == 'v') {

					((Text) event.widget).paste();

				} else if (event.stateMask == SWT.CTRL && event.keyCode == 'x') {

					((Text) event.widget).cut();

				} else if (event.stateMask == SWT.CTRL && event.keyCode == 'z') {

					// ((StyledText)event.widget).
				}
			}
		};

		text.addListener(SWT.KeyUp, keyBindListener);
	}

	private ControlDecoration crateControlDecoration(Text dtxt) {

		ControlDecoration controlDecoration = new ControlDecoration(dtxt, SWT.LEFT | SWT.TOP);

		FieldDecoration fieldDecoration =
		                                  FieldDecorationRegistry.getDefault()
		                                                         .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);

		controlDecoration.setImage(fieldDecoration.getImage());

		return controlDecoration;
	}

	private void addFocusListner(Control comp) {

		comp.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				isFocusedOnDetailSection = false;

			}

			public void focusGained(FocusEvent e) {

				isFocusedOnDetailSection = true;
			}
		});
	}

	private void addTraverseListner(Control comp) {

		comp.addTraverseListener(new TraverseListener() {

			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_TAB_NEXT || e.detail == SWT.TRAVERSE_TAB_PREVIOUS) {
					e.doit = true;

				}
			}
		});
	}

	private void addModifyListnerForCustomComboFields(final Combo combo, final Object input,
	                                                  final EAttribute metaObject) {

		combo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				setStringAttribute(input, metaObject, combo.getItem(combo.getSelectionIndex()));

			}
		});

	}

	private void addModifylistnersForBooleanComboWithStringPersi(final Combo combo,
	                                                             final Object input,
	                                                             final EAttribute metaObject) {

		combo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				setStringAttribute(input, metaObject, (combo.getSelectionIndex() == 0) ? "true"
				                                                                      : "false");

			}
		});
	}

	private void addModifylistnersForBooleanComboFields(final Combo combo, final Object input,
	                                                    final EAttribute metaObject) {

		combo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				setBooleanAttribute(input, metaObject, (combo.getSelectionIndex() == 0) ? true
				                                                                       : false);

			}
		});

	}

	private void addModifyListnersForTextFields(Text dtxt, String dataType, final Object input,
	                                            final EAttribute metaObject,
	                                            final ControlDecoration controlDecoration) {

		if (dataType.equals(DetailSectionCustomUiConstants.STRING)) {

			dtxt.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent event) {

					setStringAttribute(input, metaObject, ((Text) event.widget).getText());
				}
			});

		} else if (dataType.equals(DetailSectionCustomUiConstants.LONG)) {

			dtxt.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent event) {

					String longNum = ((Text) event.widget).getText();
					if (isValidLongString(longNum)) {

						setLongAttribute(input, metaObject, longNum);
						controlDecoration.hide();

					} else {

						controlDecoration.setDescriptionText("Please enter valid long value");
						controlDecoration.show();
					}

				}
			});
		} else if (dataType.equals(DetailSectionCustomUiConstants.DOUBLE)) {

			dtxt.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent event) {

					String doubleNum = ((Text) event.widget).getText();
					if (isValidDoubleString(doubleNum)) {

						setDoubleAttribute(input, metaObject, doubleNum);
						controlDecoration.hide();

					} else {

						controlDecoration.setDescriptionText("Please enter valid double value");
						controlDecoration.show();

					}

				}
			});
		} else if (dataType.equals(DetailSectionCustomUiConstants.BIGINTEGER)) {

			dtxt.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent event) {

					String bigInt = ((Text) event.widget).getText();
					if (isValidBigIntString(bigInt)) {

						setBigIntAttribute(input, metaObject, bigInt);
						controlDecoration.hide();

					} else {

						controlDecoration.setDescriptionText("Please enter valid integer value");
						controlDecoration.show();
					}

				}
			});
		} else if (dataType.equals(DetailSectionCustomUiConstants.INTEGER)) {

			dtxt.addModifyListener(new ModifyListener() {

				@Override
				public void modifyText(ModifyEvent event) {

					String Int = ((Text) event.widget).getText();
					if (isValidIntString(Int)) {

						setIntegerAttribute(input, metaObject, Int);
						controlDecoration.hide();

					} else {

						controlDecoration.setDescriptionText("Please enter valid integer value");
						controlDecoration.show();

					}

				}
			});

		}

	}

	private void setStringAttribute(Object input, EAttribute attributeRef, String text) {

		/*
		 * Fixing TOOLS-2068
		 */
		if ("".equals(text)) {
			text = null;
		}
		Command setAttribCommand = SetCommand.create(editingDomain, input, attributeRef, text);
		if (setAttribCommand.canExecute()) {

			OutlineBlock.isEditAction = true;
			editingDomain.getCommandStack().execute(setAttribCommand);

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Problem Occurred!",
			                              "Can not modify " + attributeRef.getName());
		}

	}

	private void setLongAttribute(Object input, EAttribute attributeRef, String text) {
		Command setAttribCommand =
		                           SetCommand.create(editingDomain, input, attributeRef,
		                                             new Long(text));
		if (setAttribCommand.canExecute()) {

			OutlineBlock.isEditAction = true;
			editingDomain.getCommandStack().execute(setAttribCommand);

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Problem Occurred!",
			                              "Can not modify " + attributeRef.getName());
		}
	}

	private void setDoubleAttribute(Object input, EAttribute attributeRef, String text) {
		Command setAttribCommand =
		                           SetCommand.create(editingDomain, input, attributeRef,
		                                             new Double(text));
		if (setAttribCommand.canExecute()) {

			OutlineBlock.isEditAction = true;
			editingDomain.getCommandStack().execute(setAttribCommand);

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Problem Occurred!",
			                              "Can not modify " + attributeRef.getName());
		}
	}

	private void setBigIntAttribute(Object input, EAttribute attributeRef, String text) {

		Command setAttribCommand =
		                           SetCommand.create(editingDomain, input, attributeRef,
		                                             new BigInteger(text));
		if (setAttribCommand.canExecute()) {

			OutlineBlock.isEditAction = true;
			editingDomain.getCommandStack().execute(setAttribCommand);

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Problem Occurred!",
			                              "Can not modify " + attributeRef.getName());
		}
	}

	private void setIntegerAttribute(Object input, EAttribute attributeRef, String text) {

		Command setAttribCommand =
		                           SetCommand.create(editingDomain, input, attributeRef,
		                                             new Integer(text));
		if (setAttribCommand.canExecute()) {

			OutlineBlock.isEditAction = true;
			editingDomain.getCommandStack().execute(setAttribCommand);

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Problem Occurred!",
			                              "Can not modify " + attributeRef.getName());
		}
	}

	private void setBooleanAttribute(Object input, EAttribute attributeRef, boolean isSet) {
		Command setAttribCommand =
		                           SetCommand.create(editingDomain, input, attributeRef,
		                                             new Boolean(isSet));
		if (setAttribCommand.canExecute()) {

			OutlineBlock.isEditAction = true;
			editingDomain.getCommandStack().execute(setAttribCommand);

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Problem Occurred!",
			                              "Can not modify " + attributeRef.getName());
		}
	}

	public boolean isValidLongString(String text) {

		try {

			new Long(text);

		} catch (NumberFormatException e) {

			return false;
		}

		return true;
	}

	private boolean isValidDoubleString(String text) {

		try {

			new Double(text);

		} catch (NumberFormatException e) {

			return false;
		}

		return true;
	}

	private boolean isValidBigIntString(String text) {

		try {

			new BigInteger(text);

		} catch (NumberFormatException e) {

			return false;
		}

		return true;
	}

	private boolean isValidIntString(String text) {

		try {

			new Integer(text);

		} catch (NumberFormatException e) {

			return false;
		}

		return true;
	}
}
