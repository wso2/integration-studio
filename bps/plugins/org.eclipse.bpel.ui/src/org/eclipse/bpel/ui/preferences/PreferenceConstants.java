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
		
//		store.setDefault(PreferenceConstants.EDITOR_SHOW_SEGMENTS, false);
//
//		// JavaBasePreferencePage
//		store.setDefault(PreferenceConstants.LINK_PACKAGES_TO_EDITOR, false);
//		store.setDefault(PreferenceConstants.LINK_TYPEHIERARCHY_TO_EDITOR, false);
//		store.setDefault(PreferenceConstants.OPEN_TYPE_HIERARCHY, PreferenceConstants.OPEN_TYPE_HIERARCHY_IN_VIEW_PART);
//		store.setDefault(PreferenceConstants.DOUBLE_CLICK, PreferenceConstants.DOUBLE_CLICK_EXPANDS);
//		store.setDefault(PreferenceConstants.UPDATE_JAVA_VIEWS, PreferenceConstants.UPDATE_WHILE_EDITING);	
//		store.setToDefault(PreferenceConstants.UPDATE_JAVA_VIEWS); // clear preference, update on save not supported anymore
//		
//		store.setDefault(PreferenceConstants.LINK_BROWSING_PROJECTS_TO_EDITOR, true);
//		store.setDefault(PreferenceConstants.LINK_BROWSING_PACKAGES_TO_EDITOR, true);
//		store.setDefault(PreferenceConstants.LINK_BROWSING_TYPES_TO_EDITOR, true);
//		store.setDefault(PreferenceConstants.LINK_BROWSING_MEMBERS_TO_EDITOR, true);
//
//		store.setDefault(PreferenceConstants.SEARCH_USE_REDUCED_MENU, true);
//		// AppearancePreferencePage
//		store.setDefault(PreferenceConstants.APPEARANCE_COMPRESS_PACKAGE_NAMES, false);
//		store.setDefault(PreferenceConstants.APPEARANCE_METHOD_RETURNTYPE, false);
//		store.setDefault(PreferenceConstants.SHOW_CU_CHILDREN, true);
//		store.setDefault(PreferenceConstants.BROWSING_STACK_VERTICALLY, false);
//		store.setDefault(PreferenceConstants.APPEARANCE_PKG_NAME_PATTERN_FOR_PKG_VIEW, ""); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.APPEARANCE_FOLD_PACKAGES_IN_PACKAGE_EXPLORER, true);
//
//		// ImportOrganizePreferencePage
//		store.setDefault(PreferenceConstants.ORGIMPORTS_IMPORTORDER, "java;javax;org;com"); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.ORGIMPORTS_ONDEMANDTHRESHOLD, 99);
//		store.setDefault(PreferenceConstants.ORGIMPORTS_IGNORELOWERCASE, true);
//
//		// TypeFilterPreferencePage
//		store.setDefault(PreferenceConstants.TYPEFILTER_ENABLED, ""); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.TYPEFILTER_DISABLED, ""); //$NON-NLS-1$
//		
//		// ClasspathVariablesPreferencePage
//		// CodeFormatterPreferencePage
//		// CompilerPreferencePage
//		// no initialization needed
//		
//		// RefactoringPreferencePage
//		store.setDefault(PreferenceConstants.REFACTOR_ERROR_PAGE_SEVERITY_THRESHOLD, PreferenceConstants.REFACTOR_ERROR_SEVERITY);
//		store.setDefault(PreferenceConstants.REFACTOR_SAVE_ALL_EDITORS, false);		
//
//		// TemplatePreferencePage
//		store.setDefault(PreferenceConstants.TEMPLATES_USE_CODEFORMATTER, true);
//		
//		// CodeGenerationPreferencePage
//		// compatibility code
//		if (store.getBoolean(PreferenceConstants.CODEGEN_USE_GETTERSETTER_PREFIX)) {
//			String prefix= store.getString(PreferenceConstants.CODEGEN_GETTERSETTER_PREFIX);
//			if (prefix.length() > 0) {
//				JavaCore.getPlugin().getPluginPreferences().setValue(JavaCore.CODEASSIST_FIELD_PREFIXES, prefix);
//				store.setToDefault(PreferenceConstants.CODEGEN_USE_GETTERSETTER_PREFIX);
//				store.setToDefault(PreferenceConstants.CODEGEN_GETTERSETTER_PREFIX);
//			}
//		}
//		if (store.getBoolean(PreferenceConstants.CODEGEN_USE_GETTERSETTER_SUFFIX)) {
//			String suffix= store.getString(PreferenceConstants.CODEGEN_GETTERSETTER_SUFFIX);
//			if (suffix.length() > 0) {
//				JavaCore.getPlugin().getPluginPreferences().setValue(JavaCore.CODEASSIST_FIELD_SUFFIXES, suffix);
//				store.setToDefault(PreferenceConstants.CODEGEN_USE_GETTERSETTER_SUFFIX);
//				store.setToDefault(PreferenceConstants.CODEGEN_GETTERSETTER_SUFFIX);
//			}
//		}
//		store.setDefault(PreferenceConstants.CODEGEN_KEYWORD_THIS, false);
//		store.setDefault(PreferenceConstants.CODEGEN_IS_FOR_GETTERS, true);
//		store.setDefault(PreferenceConstants.CODEGEN_EXCEPTION_VAR_NAME, "e"); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.CODEGEN_ADD_COMMENTS, true);
//
//		// MembersOrderPreferencePage
//		store.setDefault(PreferenceConstants.APPEARANCE_MEMBER_SORT_ORDER, "T,SF,SI,SM,I,F,C,M"); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.APPEARANCE_VISIBILITY_SORT_ORDER, "B,V,R,D"); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.APPEARANCE_ENABLE_VISIBILITY_SORT_ORDER, false);
//		// must add here to guarantee that it is the first in the listener list
//		store.addPropertyChangeListener(JavaPlugin.getDefault().getMemberOrderPreferenceCache());
//
//
//		// JavaEditorPreferencePage
		store.setDefault(PreferenceConstants.EDITOR_MATCHING_BRACKETS, true);
		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, new RGB(192, 192,192));
//
//		store.setDefault(PreferenceConstants.EDITOR_CURRENT_LINE, true);
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_CURRENT_LINE_COLOR, new RGB(232, 242, 254));
//
//		store.setDefault(PreferenceConstants.EDITOR_PRINT_MARGIN, false);
//		store.setDefault(PreferenceConstants.EDITOR_PRINT_MARGIN_COLUMN, 80);
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_PRINT_MARGIN_COLOR, new RGB(176, 180 , 185));
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_FIND_SCOPE_COLOR, new RGB(185, 176 , 180));
//
//		store.setDefault(PreferenceConstants.EDITOR_CORRECTION_INDICATION, true);
//		store.setDefault(PreferenceConstants.EDITOR_SYNC_OUTLINE_ON_CURSOR_MOVE, true);
//
//		store.setDefault(PreferenceConstants.EDITOR_EVALUTE_TEMPORARY_PROBLEMS, true);
//
//		store.setDefault(PreferenceConstants.EDITOR_OVERVIEW_RULER, true);
//
//		store.setDefault(PreferenceConstants.EDITOR_LINE_NUMBER_RULER, false);
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_LINE_NUMBER_RULER_COLOR, new RGB(0, 0, 0));
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_LINKED_POSITION_COLOR, new RGB(121, 121, 121));
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_LINK_COLOR, new RGB(0, 0, 255));
//
//		store.setDefault(PreferenceConstants.EDITOR_FOREGROUND_DEFAULT_COLOR, true);
//
//		store.setDefault(PreferenceConstants.EDITOR_BACKGROUND_DEFAULT_COLOR, true);
//
//		store.setDefault(PreferenceConstants.EDITOR_TAB_WIDTH, 4);
//		store.setDefault(PreferenceConstants.EDITOR_SPACES_FOR_TABS, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_MULTI_LINE_COMMENT_COLOR, new RGB(63, 127, 95));
//		store.setDefault(PreferenceConstants.EDITOR_MULTI_LINE_COMMENT_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_MULTI_LINE_COMMENT_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_SINGLE_LINE_COMMENT_COLOR, new RGB(63, 127, 95));
//		store.setDefault(PreferenceConstants.EDITOR_SINGLE_LINE_COMMENT_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_SINGLE_LINE_COMMENT_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVA_KEYWORD_COLOR, new RGB(127, 0, 85));
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_KEYWORD_BOLD, true);
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_KEYWORD_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_STRING_COLOR, new RGB(42, 0, 255));
//		store.setDefault(PreferenceConstants.EDITOR_STRING_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_STRING_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVA_DEFAULT_COLOR, new RGB(0, 0, 0));
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_DEFAULT_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_DEFAULT_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVA_METHOD_NAME_COLOR, new RGB(0, 0, 0));
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_METHOD_NAME_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_METHOD_NAME_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVA_KEYWORD_RETURN_COLOR, new RGB(127, 0, 85));
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_KEYWORD_RETURN_BOLD, true);
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_KEYWORD_RETURN_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVA_OPERATOR_COLOR, new RGB(0, 0, 0));
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_OPERATOR_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_JAVA_OPERATOR_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_TASK_TAG_COLOR, new RGB(127, 159, 191));
//		store.setDefault(PreferenceConstants.EDITOR_TASK_TAG_BOLD, true);
//		store.setDefault(PreferenceConstants.EDITOR_TASK_TAG_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVADOC_KEYWORD_COLOR, new RGB(127, 159, 191));
//		store.setDefault(PreferenceConstants.EDITOR_JAVADOC_KEYWORD_BOLD, true);
//		store.setDefault(PreferenceConstants.EDITOR_JAVADOC_KEYWORD_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVADOC_TAG_COLOR, new RGB(127, 127, 159));
//		store.setDefault(PreferenceConstants.EDITOR_JAVADOC_TAG_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_JAVADOC_TAG_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVADOC_LINKS_COLOR, new RGB(63, 63, 191));
//		store.setDefault(PreferenceConstants.EDITOR_JAVADOC_LINKS_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_JAVADOC_LINKS_ITALIC, false);
//
//		PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_JAVADOC_DEFAULT_COLOR, new RGB(63, 95, 191));
//		store.setDefault(PreferenceConstants.EDITOR_JAVADOC_DEFAULT_BOLD, false);
//		store.setDefault(PreferenceConstants.EDITOR_JAVADOC_DEFAULT_ITALIC, false);
//
//		store.setDefault(PreferenceConstants.CODEASSIST_AUTOACTIVATION, true);
//		store.setDefault(PreferenceConstants.CODEASSIST_AUTOACTIVATION_DELAY, 500);
//
//		store.setDefault(PreferenceConstants.CODEASSIST_AUTOINSERT, true);
//		PreferenceConverter.setDefault(store, PreferenceConstants.CODEASSIST_PROPOSALS_BACKGROUND, new RGB(255, 255, 255));
//		PreferenceConverter.setDefault(store, PreferenceConstants.CODEASSIST_PROPOSALS_FOREGROUND, new RGB(0, 0, 0));
//		PreferenceConverter.setDefault(store, PreferenceConstants.CODEASSIST_PARAMETERS_BACKGROUND, new RGB(255, 255, 255));
//		PreferenceConverter.setDefault(store, PreferenceConstants.CODEASSIST_PARAMETERS_FOREGROUND, new RGB(0, 0, 0));
//		PreferenceConverter.setDefault(store, PreferenceConstants.CODEASSIST_REPLACEMENT_BACKGROUND, new RGB(255, 255, 0));
//		PreferenceConverter.setDefault(store, PreferenceConstants.CODEASSIST_REPLACEMENT_FOREGROUND, new RGB(255, 0, 0));
//		store.setDefault(PreferenceConstants.CODEASSIST_AUTOACTIVATION_TRIGGERS_JAVA, "."); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.CODEASSIST_AUTOACTIVATION_TRIGGERS_JAVADOC, "@#"); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.CODEASSIST_SHOW_VISIBLE_PROPOSALS, true);
//		store.setDefault(PreferenceConstants.CODEASSIST_CASE_SENSITIVITY, false);
//		store.setDefault(PreferenceConstants.CODEASSIST_ORDER_PROPOSALS, false);
//		store.setDefault(PreferenceConstants.CODEASSIST_ADDIMPORT, true);
//		store.setDefault(PreferenceConstants.CODEASSIST_INSERT_COMPLETION, true);
//		store.setDefault(PreferenceConstants.CODEASSIST_FILL_ARGUMENT_NAMES, false);
//		store.setDefault(PreferenceConstants.CODEASSIST_GUESS_METHOD_ARGUMENTS, true);
//		store.setDefault(PreferenceConstants.CODEASSIST_PREFIX_COMPLETION, false);
//
//		store.setDefault(PreferenceConstants.EDITOR_SMART_HOME_END, true);
//		store.setDefault(PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION, true);
//		store.setDefault(PreferenceConstants.EDITOR_SMART_PASTE, true);
//		store.setDefault(PreferenceConstants.EDITOR_IMPORTS_ON_PASTE, true);
		
		store.setDefault(PreferenceConstants.EDITOR_CLOSE_STRINGS, true);
		store.setDefault(PreferenceConstants.EDITOR_CLOSE_BRACKETS, true);
		
//		store.setDefault(PreferenceConstants.EDITOR_CLOSE_BRACES, true);
//		store.setDefault(PreferenceConstants.EDITOR_CLOSE_JAVADOCS, true);
//		store.setDefault(PreferenceConstants.EDITOR_WRAP_STRINGS, true);
//		store.setDefault(PreferenceConstants.EDITOR_ESCAPE_STRINGS, false);
//		store.setDefault(PreferenceConstants.EDITOR_ADD_JAVADOC_TAGS, true);
//		store.setDefault(PreferenceConstants.EDITOR_FORMAT_JAVADOCS, false);
//		store.setDefault(PreferenceConstants.EDITOR_DISABLE_OVERWRITE_MODE, false);
//		
//		String mod1Name= Action.findModifierString(SWT.MOD1);	// SWT.COMMAND on Mac; SWT.CONTROL elsewhere
//		store.setDefault(PreferenceConstants.EDITOR_TEXT_HOVER_MODIFIERS, "org.eclipse.jdt.ui.BestMatchHover;0;org.eclipse.jdt.ui.JavaSourceHover;" + mod1Name); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.EDITOR_TEXT_HOVER_MODIFIER_MASKS, "org.eclipse.jdt.ui.BestMatchHover;0;org.eclipse.jdt.ui.JavaSourceHover;" + SWT.MOD1); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.EDITOR_SHOW_TEXT_HOVER_AFFORDANCE, true);
//		
//		store.setDefault(PreferenceConstants.EDITOR_BROWSER_LIKE_LINKS, true);
//		store.setDefault(PreferenceConstants.EDITOR_BROWSER_LIKE_LINKS_KEY_MODIFIER, mod1Name);
//		store.setDefault(PreferenceConstants.EDITOR_BROWSER_LIKE_LINKS_KEY_MODIFIER_MASK, SWT.MOD1);
//		
//		store.setDefault(PreferenceConstants.EDITOR_SMART_TAB, true);
//		store.setDefault(PreferenceConstants.EDITOR_SMART_BACKSPACE, true);
//		store.setDefault(PreferenceConstants.EDITOR_ANNOTATION_ROLL_OVER, false);
//		
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_FORMAT, true);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_FORMATHEADER, false);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_FORMATSOURCE, true);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_INDENTPARAMETERDESCRIPTION, true);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_INDENTROOTTAGS, true);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_NEWLINEFORPARAMETER, true);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_SEPARATEROOTTAGS, true);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_CLEARBLANKLINES, false);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_FORMATHTML, true);
//		store.setDefault(PreferenceConstants.FORMATTER_COMMENT_LINELENGTH, 80);
//		
//		store.setDefault(PreferenceConstants.FORMATTER_PROFILE, ProfileManager.JAVA_PROFILE);
//		ProfileStore.checkCurrentOptionsVersion();
//		
//		// mark occurrences
//		store.setDefault(PreferenceConstants.EDITOR_MARK_OCCURRENCES, false);
//		store.setDefault(PreferenceConstants.EDITOR_STICKY_OCCURRENCES, true);
//		store.setDefault(PreferenceConstants.EDITOR_MARK_TYPE_OCCURRENCES, true);
//		store.setDefault(PreferenceConstants.EDITOR_MARK_METHOD_OCCURRENCES, true);
//		store.setDefault(PreferenceConstants.EDITOR_MARK_CONSTANT_OCCURRENCES, true);
//		store.setDefault(PreferenceConstants.EDITOR_MARK_FIELD_OCCURRENCES, true);
//		store.setDefault(PreferenceConstants.EDITOR_MARK_LOCAL_VARIABLE_OCCURRENCES, true);
//		store.setDefault(PreferenceConstants.EDITOR_MARK_EXCEPTION_OCCURRENCES, true);
//		store.setDefault(PreferenceConstants.EDITOR_MARK_METHOD_EXIT_POINTS, true);
//		
//		// spell checking
//		store.setDefault(PreferenceConstants.SPELLING_CHECK_SPELLING, false);
//		store.setDefault(PreferenceConstants.SPELLING_LOCALE, SpellCheckEngine.getDefaultLocale().toString());
//		store.setDefault(PreferenceConstants.SPELLING_IGNORE_DIGITS, true);
//		store.setDefault(PreferenceConstants.SPELLING_IGNORE_MIXED, true);
//		store.setDefault(PreferenceConstants.SPELLING_IGNORE_SENTENCE, true);
//		store.setDefault(PreferenceConstants.SPELLING_IGNORE_UPPER, true);
//		store.setDefault(PreferenceConstants.SPELLING_IGNORE_URLS, true);
//		store.setDefault(PreferenceConstants.SPELLING_USER_DICTIONARY, ""); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.SPELLING_PROPOSAL_THRESHOLD, 20);
//		store.setDefault(PreferenceConstants.SPELLING_ENABLE_CONTENTASSIST, false);
//		
//		// folding
//		store.setDefault(PreferenceConstants.EDITOR_FOLDING_ENABLED, true);
//		store.setDefault(PreferenceConstants.EDITOR_FOLDING_PROVIDER, "org.eclipse.jdt.ui.text.defaultFoldingProvider"); //$NON-NLS-1$
//		store.setDefault(PreferenceConstants.EDITOR_FOLDING_JAVADOC, false);
//		store.setDefault(PreferenceConstants.EDITOR_FOLDING_INNERTYPES, true);
//		store.setDefault(PreferenceConstants.EDITOR_FOLDING_METHODS, false);
//		store.setDefault(PreferenceConstants.EDITOR_FOLDING_IMPORTS, true);
//		
//		// override default extended text editor prefs
//		store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_USE_CUSTOM_CARETS, true);
//		
//
//		SemanticHighlightings.initDefaults(store);
//
//		// do more complicated stuff
//		NewJavaProjectPreferencePage.initDefaults(store);	
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
