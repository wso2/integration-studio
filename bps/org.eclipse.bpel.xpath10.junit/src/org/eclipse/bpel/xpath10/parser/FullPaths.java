package org.eclipse.bpel.xpath10.parser;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 * 
 */

@SuppressWarnings("nls")
public class FullPaths extends AbstractTC {

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprFullSample1() throws RecognitionException {
		String input = "child::para";

		runTest(CMP_EXPR_TEXT, input, "child::para");
		runTest(CMP_AST, input, "(:: child) para");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample1NS() throws RecognitionException {
		String input = "child::ns:para";

		runTest(CMP_EXPR_TEXT, input, "child::ns:para");
		runTest(CMP_AST, input, "(:: child) ns : para");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample2() throws RecognitionException {
		String input = "child::*";
		runTest(CMP_EXPR_TEXT, input, "child::*");
		runTest(CMP_AST, input, "(:: child) *");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample2NS() throws RecognitionException {
		String input = "child::ns:*";
		runTest(CMP_EXPR_TEXT, input, "child::ns:*");
		runTest(CMP_AST, input, "(:: child) ns : *");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample3() throws RecognitionException {
		String input = "child::text()";
		runTest(CMP_EXPR_TEXT, input, "child::text()");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample3Absolute() throws RecognitionException {
		String input = "/child::text ( )";
		runTest(CMP_EXPR_TEXT, input, "/child::text()");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample4() throws RecognitionException {
		String input = "attribute::name";
		runTest(CMP_EXPR_TEXT, input, "attribute::name");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample5() throws RecognitionException {
		String input = "attribute::*";
		runTest(CMP_EXPR_TEXT, input, "attribute::*");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample6() throws RecognitionException {
		String input = "child::para [ 1 ] ";
		runTest(CMP_EXPR_TEXT, input, "child::para[1]");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample7() throws RecognitionException {
		String input = "child::para [ last ( ) ]";
		runTest(CMP_EXPR_TEXT, input, "child::para[last()]");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample8() throws RecognitionException {
		String input = "child::*/child::para";
		runTest(CMP_EXPR_TEXT, input, "child::*/child::para");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample9() throws RecognitionException {
		String input = " / child::doc / child::chapter  [ 5  ] /  section [ 2   ]";
		runTest(CMP_EXPR_TEXT, input,
				"/child::doc/child::chapter[5]/child::section[2]");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample10() throws RecognitionException {
		String input = "child::chapter//child::para";
		runTest(CMP_EXPR_TEXT, input,
				"child::chapter/descendant-or-self::node()/child::para");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample11() throws RecognitionException {
		String input = "//  child::para";
		runTest(CMP_EXPR_TEXT, input, "/descendant-or-self::node()/child::para");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample12() throws RecognitionException {
		String input = "//  child::olist /  child::item";
		runTest(CMP_EXPR_TEXT, input,
				"/descendant-or-self::node()/child::olist/child::item");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample13() throws RecognitionException {
		String input = "self::node()";
		runTest(CMP_EXPR_TEXT, input, "self::node()");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample14() throws RecognitionException {
		String input = "self::node() /descendant-or-self::node()  / child::para";

		runTest(CMP_EXPR_TEXT, input,
				"self::node()/descendant-or-self::node()/child::para");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprFullSample15() throws RecognitionException {
		String input = "parent::node ( ) ";
		runTest(CMP_EXPR_TEXT, input, "parent::node()");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprFullSample16() throws RecognitionException {
		String input = "parent::node(  ) / attribute::lang";
		runTest(CMP_EXPR_TEXT, input, "parent::node()/attribute::lang");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample17() throws RecognitionException {
		String input = "child::para [ attribute::type  =   \"warning\" ] ";
		runTest(CMP_EXPR_TEXT, input,
				"child::para[attribute::type = \"warning\"]");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample18() throws RecognitionException {
		String input = "child::para[ attribute::type = \"warning\" ] [   5   ] ";
		runTest(CMP_EXPR_TEXT, input,
				"child::para[attribute::type = \"warning\"][5]");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample19() throws RecognitionException {
		String input = "child::para  [ 5 ] [  attribute::type =  \"warning\"  ] ";
		runTest(CMP_EXPR_TEXT, input,
				"child::para[5][attribute::type = \"warning\"]");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample20() throws RecognitionException {
		String input = "child::chapter  [  child::title  =   \"Introduction\"]";
		runTest(CMP_EXPR_TEXT, input,
				"child::chapter[child::title = \"Introduction\"]");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample21() throws RecognitionException {
		String input = "child::chapter  [  child::title ]";
		runTest(CMP_EXPR_TEXT, input, "child::chapter[child::title]");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprFullSample22() throws RecognitionException {
		String input = "child::employee [attribute::secretary and attribute::assistant]";
		runTest(CMP_EXPR_TEXT, input,
				"child::employee[attribute::secretary and attribute::assistant]");
	}

}
