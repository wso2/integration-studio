package org.wso2.developerstudio.eclipse.ds.dbseditor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class DsDocumentProvider extends FileDocumentProvider {

	public static final String DS_PARTITIONING =
	                                             "org.wso2.developerstudio.eclipse.ds.dbseditor.dspartitioning"; //$NON-NLS-1$

	/**
	 * The identifier of the comment body type.
	 */
	public static final String DS_CODE = IDocument.DEFAULT_CONTENT_TYPE;
	/**
	 * The identifier of the comment partition type.
	 */
	public static final String XML_COMMENT = "__xml_comment";

	public final static String XML_TAG = "__xml_tag";

	public static final String[] CONTENT_TYPES = { DS_CODE, XML_COMMENT, XML_TAG };

	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		if (document != null) {
			IDocumentExtension3 ext = (IDocumentExtension3) document;
			IDocumentPartitioner partitioner = createDsPartitioner();
			ext.setDocumentPartitioner(DS_PARTITIONING, partitioner);
			partitioner.connect(document);
		}
		return document;
	}

	private IDocumentPartitioner createDsPartitioner() {

		IToken xmlComment = new Token(XML_COMMENT);
		MultiLineRule comment = new MultiLineRule("<!--", "-->", xmlComment); // define
		                                                                      // the
		                                                                      // comment
		                                                                      // multiline
		                                                                      // rule

		IToken tag = new Token(XML_TAG);
		TagRule tagRule = new TagRule(tag); // define tag rule (multiline rule)

		IPredicateRule[] rules = { comment, tagRule };

		RuleBasedPartitionScanner scanner = new RuleBasedPartitionScanner();
		scanner.setPredicateRules(rules);

		return new FastPartitioner(scanner, CONTENT_TYPES);
	}

}
