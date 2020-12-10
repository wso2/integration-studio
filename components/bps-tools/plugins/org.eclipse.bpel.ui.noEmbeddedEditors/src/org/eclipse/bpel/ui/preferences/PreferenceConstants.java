/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.preferences;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 27, 2006
 *
 */
public class PreferenceConstants {

	/**
	 * Matching brackets enabled
	 */
	static final public String EDITOR_MATCHING_BRACKETS = "org.eclipse.bpel.ui.xpath.editor.MatchingBrackets"; //$NON-NLS-1$

	/**
	 * The matching brackets color.
	 */
	static final public String EDITOR_MATCHING_BRACKETS_COLOR = "org.eclipse.bpel.ui.xpath.editor.MatchingBracketsColor"; //$NON-NLS-1$

	/**
	 * A named preference that controls whether the 'close strings' feature
	 *  is   enabled.
	 * <p>
	 * Value is of type <code>Boolean</code>.
	 * </p>
	 *
	 */
	static final public String EDITOR_CLOSE_STRINGS = "closeString"; //$NON-NLS-1$

	/**
	 * A named preference that controls whether the 'close brackets' feature is
	 * enabled.
	 * <p>
	 * Value is of type <code>Boolean</code>.
	 * </p>
	 * @since 2.1
	 */
	public final static String EDITOR_CLOSE_BRACKETS= "closeBrackets"; //$NON-NLS-1$



	public final static RGB AXIS = new RGB(0, 136, 0);

	public final static RGB BRACKET = new RGB(0, 0, 0);

	public final static RGB DEFAULT = new RGB(0, 0, 0);

	public final static RGB NUMBER = new RGB(100, 100, 100);

	public final static RGB OPERAND = new RGB(155, 68, 208);

	public final static RGB PARENS = new RGB(255, 0, 0);

	public final static RGB PATH_SEPARATOR = new RGB(0, 0, 255);

	public final static RGB STRING = new RGB(0, 136, 0);

	public final static RGB TAG = new RGB(0, 0, 128);

	public final static RGB FUNCTIONS_XPATH = new RGB(0,0,200);

	public static final RGB VARIABLES = new RGB(10,10,10);

	public static final RGB VARIABLE_PART = new RGB(0xe0,80,0);



	/**
	 * Initializes the given preference store with the default values.
	 *
	 * @param store the preference store to be initialized
	 *
	 * @since 2.1
	 */
	public static void initializeDefaultValues(IPreferenceStore store) {

		// set the default values from AbstractDecoratedTextEditor
		AbstractDecoratedTextEditorPreferenceConstants.initializeDefaultValues(store);

		store.setDefault(PreferenceConstants.EDITOR_MATCHING_BRACKETS, true);
		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, new RGB(192, 192,192));

		store.setDefault(PreferenceConstants.EDITOR_CLOSE_STRINGS, true);
		store.setDefault(PreferenceConstants.EDITOR_CLOSE_BRACKETS, true);
	}

	/**
	 * Returns the preference store.
	 *
	 * @return the preference store
	 */
	public static IPreferenceStore getPreferenceStore() {
		return BPELUIPlugin.INSTANCE.getPreferenceStore();
	}

}
