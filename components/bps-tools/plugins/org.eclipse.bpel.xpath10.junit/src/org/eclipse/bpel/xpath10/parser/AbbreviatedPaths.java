package org.eclipse.bpel.xpath10.parser;

import org.antlr.runtime.*;
import org.junit.Test;

/**
 * These come from http://www.w3.org/TR/xpath#path-abbrev
 * 
 */

@SuppressWarnings("nls")
public class AbbreviatedPaths extends AbstractTC {

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample1() throws RecognitionException {
		String input = "para";

		runTest(CMP_AST, input, "para");
		runTest(CMP_EXPR_TEXT, input, "child::para");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample1NS() throws RecognitionException {
		String input = "ns:para";

		runTest(CMP_EXPR_TEXT, input, "child::ns:para");
		runTest(CMP_AST, input, "ns : para");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample2() throws RecognitionException {
		String input = "*";
		runTest(CMP_AST, input, "*");
		runTest(CMP_EXPR_TEXT, input, "child::*");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample2NS() throws RecognitionException {
		String input = "ns:*";
		runTest(CMP_EXPR_TEXT, input, "child::ns:*");
		runTest(CMP_AST, input, "ns : *");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample3() throws RecognitionException {
		String input = " text () ";
		runTest(CMP_EXPR_TEXT, input, "child::text()");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample3Absolute()
			throws RecognitionException {
		String input = "/text ( )";
		runTest(CMP_EXPR_TEXT, input, "/child::text()");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample4() throws RecognitionException {
		String input = "@name";

		runTest(CMP_AST, input, "@ name");
		runTest(CMP_EXPR_TEXT, input, "attribute::name");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample5() throws RecognitionException {
		String input = "@*";

		runTest(CMP_AST, input, "@ *");
		runTest(CMP_EXPR_TEXT, input, "attribute::*");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample6() throws RecognitionException {
		String input = "para[1]";
		runTest(CMP_AST, input, "para ([ 1)");
		runTest(CMP_EXPR_TEXT, input, "child::para[1]");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample7() throws RecognitionException {
		String input = "para [ last ( ) ]";
		runTest(CMP_AST, input, "para ([ last)");
		runTest(CMP_EXPR_TEXT, input, "child::para[last()]");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample8() throws RecognitionException {
		String input = "*/para";
		runTest(CMP_AST, input, "* / para");
		runTest(CMP_EXPR_TEXT, input, "child::*/child::para");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample9() throws RecognitionException {
		String input = "/doc/chapter[5]/section[2]";
		runTest(CMP_AST, input, "(/ doc / chapter ([ 5) / section ([ 2))");
		runTest(CMP_EXPR_TEXT, input,
				"/child::doc/child::chapter[5]/child::section[2]");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample10() throws RecognitionException {
		String input = "chapter//para";
		runTest(CMP_AST, input, "chapter // para");
		runTest(CMP_EXPR_TEXT, input,
				"child::chapter/descendant-or-self::node()/child::para");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample11() throws RecognitionException {
		String input = "//para";
		runTest(CMP_AST, input, "(// para)");
		runTest(CMP_EXPR_TEXT, input, "/descendant-or-self::node()/child::para");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample12() throws RecognitionException {
		String input = "//olist/item";
		runTest(CMP_EXPR_TEXT, input,
				"/descendant-or-self::node()/child::olist/child::item");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample13() throws RecognitionException {
		String input = ".";
		runTest(CMP_AST, input, ".");
		runTest(CMP_EXPR_TEXT, input, "self::node()");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprAbbreviatedSample14() throws RecognitionException {
		String input = ".//para";

		runTest(CMP_EXPR_TEXT, input,
				"self::node()/descendant-or-self::node()/child::para");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample15() throws RecognitionException {
		String input = "..";
		runTest(CMP_AST, input, "..");
		runTest(CMP_EXPR_TEXT, input, "parent::node()");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample16() throws RecognitionException {
		String input = "../@lang";

		runTest(CMP_AST, input, ".. / @ lang");
		runTest(CMP_EXPR_TEXT, input, "parent::node()/attribute::lang");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample17() throws RecognitionException {
		String input = "para[@type=\"warning\"]";
		runTest(CMP_AST, input, "para ([ (= @ type \"warning\"))");
		runTest(CMP_EXPR_TEXT, input,
				"child::para[attribute::type = \"warning\"]");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample18() throws RecognitionException {
		String input = "para[@type=\"warning\"][5]";
		runTest(CMP_AST, input, "para ([ (= @ type \"warning\")) ([ 5)");
		runTest(CMP_EXPR_TEXT, input,
				"child::para[attribute::type = \"warning\"][5]");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample19() throws RecognitionException {
		String input = "para[5][@type=\"warning\"]";
		runTest(CMP_AST, input, "para ([ 5) ([ (= @ type \"warning\"))");
		runTest(CMP_EXPR_TEXT, input,
				"child::para[5][attribute::type = \"warning\"]");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample20() throws RecognitionException {
		String input = "chapter[title=\"Introduction\"]";
		runTest(CMP_AST, input, "chapter ([ (= title \"Introduction\"))");
		runTest(CMP_EXPR_TEXT, input,
				"child::chapter[child::title = \"Introduction\"]");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample21() throws RecognitionException {
		String input = "chapter[title]";
		runTest(CMP_AST, input, "chapter ([ title)");
		runTest(CMP_EXPR_TEXT, input, "child::chapter[child::title]");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PathExprAbbreviatedSample22() throws RecognitionException {
		String input = "employee[@secretary and @assistant]";
		runTest(CMP_AST, input, "employee ([ (and @ secretary @ assistant))");
		runTest(CMP_EXPR_TEXT, input,
				"child::employee[attribute::secretary and attribute::assistant]");
	}

}
