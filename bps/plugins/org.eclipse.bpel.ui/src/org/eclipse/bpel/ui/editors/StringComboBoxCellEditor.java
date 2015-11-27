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
package org.eclipse.bpel.ui.editors;

import java.text.MessageFormat;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * A cell editor that presents a list of items in a combo box
 * and allows to edit the content of the editor. 
 * The cell editor's value is the zero-based index of the selected
 * item. 
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 */
public class StringComboBoxCellEditor extends CellEditor {

	/**
	 * The list of items to present in the combo box.
	 */
	protected String[] items;

	/**
	 * The zero-based index of the selected item.
	 */
	private int selection;

	/**
	 * The custom combo box control.
	 */
	protected CCombo comboBox;

	/**
	 * Default ComboBoxCellEditor style
	 */
	private static final int defaultStyle = SWT.NONE;

	private ModifyListener modifyListener;

	/**
	 * Creates a new cell editor with no control and no  st of choices. Initially,
	 * the cell editor has no cell validator.
	 * 
	 * @since 2.1
	 * @see #setStyle
	 * @see #create
	 * @see #setItems
	 * @see #dispose
	 */

	public StringComboBoxCellEditor() {
		setStyle(defaultStyle);
	}

	/**
	 * Creates a new cell editor with a combo containing the given 
	 * list of choices and parented under the given control. The cell
	 * editor value is the zero-based index of the selected item.
	 * Initially, the cell editor has no cell validator and
	 * the first item in the list is selected. 
	 *
	 * @param parent the parent control
	 * @param items the list of strings for the combo box
	 */
	public StringComboBoxCellEditor(Composite parent, String[] items) {
		this(parent, items, defaultStyle);
	}

	/**
	 * Creates a new cell editor with a combo containing the given 
	 * list of choices and parented under the given control. The cell
	 * editor value is the zero-based index of the selected item.
	 * Initially, the cell editor has no cell validator and
	 * the first item in the list is selected. 
	 *
	 * @param parent the parent control
	 * @param items the list of strings for the combo box
	 * @param style the style bits
	 * @since 2.1
	 */
	public StringComboBoxCellEditor(Composite parent, String[] items, int style) {
		super(parent, style);
		setItems(items);
	}

	public StringComboBoxCellEditor(Composite parent) {
		this(parent, new String[0]);
	}

	/**
	 * Returns the list of choices for the combo box
	 *
	 * @return the list of choices for the combo box
	 */
	public String[] getItems() {
		return this.items;
	}

	/**
	 * Sets the list of choices for the combo box
	 *
	 * @param items the list of choices for the combo box
	 */
	public void setItems(String[] items) {
		Assert.isNotNull(items);
		this.items = items;
		populateComboBoxItems();
	}

	@Override
	protected Control createControl(Composite parent) {

		comboBox = new CCombo(parent, getStyle());
		comboBox.setFont(parent.getFont());

		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				keyReleaseOccured(e);
			}
		});

		comboBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent event) {
				applyEditorValueAndDeactivate();
			}
		});

		comboBox.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_ESCAPE || e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
				}
			}
		});

		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				StringComboBoxCellEditor.this.focusLost();
			}
		});

		comboBox.addModifyListener(getModifyListener());

		return comboBox;
	}

	/**
	 * The <code>ComboBoxCellEditor</code> implementation of
	 * this <code>CellEditor</code> framework method returns
	 * the zero-based index of the current selection.
	 *
	 * @return the zero-based index of the current selection wrapped
	 *  as an <code>Integer</code>
	 */
	@Override
	protected Object doGetValue() {

		//********************************************************
		//* The doGetValue() must handle the 2 possible cases, if 
		//* called. It could be, that a selection in the dropdown 
		//* was made, then use the selectionIndex. Or a direct 
		//* editing action was made and then it is necessary to 
		//* use getText() to get the result of the CComboBoxEditor. 
		//*********************************************************
		int curSelected = comboBox.getSelectionIndex();
		String strComboSelectedContent = null;

		if (curSelected != -1) {
			strComboSelectedContent = comboBox.getItem(curSelected);
		} else {
			strComboSelectedContent = comboBox.getText();
		}

		return strComboSelectedContent;

	}

	@Override
	protected void doSetFocus() {
		comboBox.setFocus();
	}

	/**
	 * method getLayoutData  ( overwriting method )
	 * 
	 * The <code>StringComboBoxCellEditor</code> implementation of
	 * this <code>CellEditor</code> framework method sets the 
	 * minimum width of the cell.  The minimum width is 10 characters
	 * if <code>comboBox</code> is not <code>null</code> or <code>disposed</code>
	 * eles it is 60 pixels to make sure the arrow button and some text is visible.
	 * The list of CCombo will be wide enough to show its longest item.
	 * 
	 * Import are the grabHorizontal and the horizontalAlignment settings, because 
	 * so you can control, that the button for dropdownbox is at the right corner 
	 * of your parent composite. In the CellEditor implementation it would be outside 
	 * the parent control (as wide as the longest item in the dropdown list. 
	 */
	@Override
	public LayoutData getLayoutData() {
		LayoutData layoutData = super.getLayoutData();
		if ((comboBox == null) || comboBox.isDisposed()) {

			layoutData.minimumWidth = 60;
			layoutData.grabHorizontal = true;
			layoutData.horizontalAlignment = SWT.RIGHT;
		} else {
			// make the comboBox 10 characters wide
			GC gc = new GC(comboBox);
			layoutData.minimumWidth = (gc.getFontMetrics().getAverageCharWidth() * 10) + 10;
			layoutData.grabHorizontal = true;
			layoutData.horizontalAlignment = SWT.RIGHT;

			gc.dispose();
		}
		return layoutData;
	}

	/**
	 * The <code>ComboBoxCellEditor</code> implementation of
	 * this <code>CellEditor</code> framework method
	 * accepts a zero-based index of a selection.
	 *
	 * @param value the zero-based index of the selection wrapped
	 *   as an <code>Integer</code>
	 */
	@Override
	protected void doSetValue(Object value) {
		Assert.isTrue(comboBox != null && ((value instanceof Integer) || (value instanceof String)));
		//selection = ((Integer) value).intValue();
		//comboBox.select(selection);
		comboBox.setText((String) value);

	}

	/**
	 * Updates the list of choices for the combo box for the current control.
	 * 
	 */
	private void populateComboBoxItems() {
		int num = 0;

		if (comboBox != null && items != null) {
			num = comboBox.getItemCount();
			comboBox.remove(0, num - 1);

			for (int i = 0; i < items.length; i++)
				comboBox.add(items[i], i);

			setValueValid(true);
			selection = 0;
		}
	}
	/**
	 * Applies the currently selected value and deactiavates the cell editor
	 */
	private void applyEditorValueAndDeactivate() {
		//	must set the selection before getting value
		selection = comboBox.getSelectionIndex();
		Object newValue = doGetValue();
		markDirty();
		boolean isValid = isCorrect(newValue);
		setValueValid(isValid);
		if (!isValid) {
			// try to insert the current value into the error message.
			setErrorMessage(MessageFormat.format(getErrorMessage(), new Object[] { items[selection] }));
		}
		fireApplyEditorValue();
		deactivate();
	}

	@Override
	protected void focusLost() {
		if (isActivated()) {
			applyEditorValueAndDeactivate();
		}
	}

	/**
	 * Return the modify listener.
	 */
	private ModifyListener getModifyListener() {
		if (modifyListener == null) {
			modifyListener = new ModifyListener() {
				public void modifyText(ModifyEvent e) {
						//editOccured(e);
	fireEditorValueChanged(true, true);
				}
			};
		}
		return modifyListener;
	}

	@Override
	protected void keyReleaseOccured(KeyEvent keyEvent) {
		if (keyEvent.character == '\u001b') { // Escape character
			fireCancelEditor();
		} else if (keyEvent.character == '\t') { // tab key
			applyEditorValueAndDeactivate();
		}
	}
}
