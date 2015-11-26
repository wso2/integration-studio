package org.wso2.developerstudio.eclipse.ds.dbseditor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.ContentFormatter;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.texteditor.HippieProposalProcessor;

public class DsSourceViewerConfiguration extends TextSourceViewerConfiguration {

	private DsSourceEditor editor;

	private final ISharedTextColors fSharedColors;

	public DsSourceViewerConfiguration(ISharedTextColors sharedColors, IPreferenceStore store,
	                                   DsSourceEditor editor) {
		super(store);
		fSharedColors = sharedColors;
		this.editor = editor;
	}

	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		return DsDocumentProvider.DS_PARTITIONING;
	}

	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return DsDocumentProvider.CONTENT_TYPES;
	}

	public IContentAssistant getContentAssistant(final ISourceViewer sourceViewer) {
		ContentAssistant assistant = new ContentAssistant();
		assistant.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);

		assistant.setContentAssistProcessor(new HippieProposalProcessor(),
		                                    DsDocumentProvider.XML_COMMENT);
		assistant.setContentAssistProcessor(new DsCompletionProcessor(editor),
		                                    DsDocumentProvider.DS_CODE);
		assistant.setContentAssistProcessor(new DsCompletionProcessor(editor),
		                                    DsDocumentProvider.XML_TAG);
		return assistant;
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(XMLTagScanner());
		reconciler.setDamager(dr, XMLPartitionScanner.XML_TAG);
		reconciler.setRepairer(dr, XMLPartitionScanner.XML_TAG);

		dr = new DefaultDamagerRepairer(XMLScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		addDamagerRepairer(reconciler, createCommentScanner(), DsDocumentProvider.XML_COMMENT);

		return reconciler;
	}

	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {

		ContentFormatter formatter = new ContentFormatter();
		XMLFormattingStrategy formattingStrategy = new XMLFormattingStrategy();
		formatter.setFormattingStrategy(formattingStrategy, XMLPartitionScanner.XML_TAG);
		return formatter;
	}

	private void addDamagerRepairer(PresentationReconciler reconciler,
	                                RuleBasedScanner commentScanner, String contentType) {
		DefaultDamagerRepairer commentDamagerRepairer = new DefaultDamagerRepairer(commentScanner);
		reconciler.setDamager(commentDamagerRepairer, contentType);
		reconciler.setRepairer(commentDamagerRepairer, contentType);
	}

	private RuleBasedScanner createCommentScanner() {
		Color green = fSharedColors.getColor(new RGB(0, 150, 0));
		RuleBasedScanner commentScanner = new RuleBasedScanner();
		commentScanner.setDefaultReturnToken(new Token(new TextAttribute(green, null, SWT.ITALIC)));
		return commentScanner;
	}

	private RuleBasedScanner XMLTagScanner() { // XMLPartitionScanner.XML_TAG
		Color green = fSharedColors.getColor(new RGB(0, 128, 0));
		IToken string = new Token(new TextAttribute(green));
		IRule[] rules = new IRule[3];

		// Add rule for double quotes
		rules[0] = new SingleLineRule("\"", "\"", string, '\\');
		// Add a rule for single quotes
		rules[1] = new SingleLineRule("'", "'", string, '\\');
		// Add generic whitespace rule.
		rules[2] = new WhitespaceRule(new XMLWhitespaceDetector());

		RuleBasedScanner tagScanner = new RuleBasedScanner();
		tagScanner.setRules(rules);

		Color tag = fSharedColors.getColor(new RGB(0, 0, 128));
		tagScanner.setDefaultReturnToken(new Token(new TextAttribute(tag)));
		return tagScanner;

	}

	private RuleBasedScanner XMLScanner() { // IDocument.DEFAULT_CONTENT_TYPE
		Color blue = fSharedColors.getColor(new RGB(128, 128, 128));
		IToken procInstr = new Token(new TextAttribute(blue));

		IRule[] rules = new IRule[2];
		// Add rule for processing instructions
		rules[0] = new SingleLineRule("<?", "?>", procInstr);
		// Add generic whitespace rule.
		rules[1] = new WhitespaceRule(new XMLWhitespaceDetector());

		RuleBasedScanner tagScanner = new RuleBasedScanner();
		tagScanner.setRules(rules);

		Color defauult = fSharedColors.getColor(new RGB(0, 0, 0));
		tagScanner.setDefaultReturnToken(new Token(new TextAttribute(defauult)));
		return tagScanner;
	}

}
