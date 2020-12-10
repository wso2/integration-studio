package org.eclipse.bpel.xpath10.parser;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 * 
 */

@SuppressWarnings("nls")
public class Specials extends AbstractTC {

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void SpecialsText() throws RecognitionException {
		String input = "text () ";
		runTest(CMP_EXPR_TEXT, input, "child::text()");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void SpecialsTextAbs() throws RecognitionException {
		String input = "/text () ";
		runTest(CMP_EXPR_TEXT, input, "/child::text()");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void SpecialsNode() throws RecognitionException {
		String input = "node () ";
		runTest(CMP_EXPR_TEXT, input, "child::node()");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void SpecialsNodeAbs() throws RecognitionException {
		String input = "/node () ";
		runTest(CMP_EXPR_TEXT, input, "/child::node()");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void SpecialsPI() throws RecognitionException {
		String input = "processing-instruction () ";
		runTest(CMP_EXPR_TEXT, input, "child::processing-instruction()");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void SpecialsPIAbs() throws RecognitionException {
		String input = "/processing-instruction () ";
		runTest(CMP_EXPR_TEXT, input, "/child::processing-instruction()");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void TextAsNamespacedFunctionCall() throws RecognitionException {
		String input = "ns1:text ( 1 , 5, 9 ) ";
		runTest(CMP_EXPR_TEXT, input, "ns1:text(1, 5, 9)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void NodeAsNamespacedFunctionCall() throws RecognitionException {
		String input = "ns1:node ( 1 , 5, 9 ) ";
		runTest(CMP_EXPR_TEXT, input, "ns1:node(1, 5, 9)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void CommentAsNamespacedFunctionCall() throws RecognitionException {
		String input = "ns1:comment ( 1 , 5, 9 ) ";
		runTest(CMP_EXPR_TEXT, input, "ns1:comment(1, 5, 9)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PIAsNamespacedFunctionCall() throws RecognitionException {
		String input = "ns1:processing-instruction ( 1 , 5, 9 ) ";
		runTest(CMP_EXPR_TEXT, input, "ns1:processing-instruction(1, 5, 9)");
	}

}
