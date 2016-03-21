package org.eclipse.bpel.xpath10.parser;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

/**
 * Various expressions tests.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 * 
 */

@SuppressWarnings("nls")
public class Expressions extends AbstractTC {

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void StringDoubleQuote() throws RecognitionException {
		String input = "\"a b c d\"";

		runTest(CMP_EXPR_TEXT, input, "\"a b c d\"");
		runTest(CMP_AST, "\"a b c d\"", "\"a b c d\"");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void StringSingleQuote() throws RecognitionException {
		String input = " 'ab cd' ";
		runTest(CMP_EXPR_TEXT, input, "'ab cd'");
		runTest(CMP_AST, input, "'ab cd'");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PositiveInteger() throws RecognitionException {
		String input = "  12345  ";
		runTest(CMP_EXPR_TEXT, input, "12345");
		runTest(CMP_AST, input, "12345");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void NegativeInteger() throws RecognitionException {
		String input = "   -12345  ";
		runTest(CMP_EXPR_TEXT, input, "-12345");
		runTest(CMP_AST, input, "- 12345");
	}

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void PositiveFloat() throws RecognitionException {
		String input = " 12345.01 ";
		runTest(CMP_EXPR_TEXT, input, "12345.01");
		runTest(CMP_AST, input, "12345.01");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void NegativeFloat() throws RecognitionException {
		String input = "   -12345.01  ";
		runTest(CMP_EXPR_TEXT, input, "-12345.01");
		runTest(CMP_AST, input, "- 12345.01");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void NegativeFloatNoLeading0() throws RecognitionException {
		String input = " -.01 ";
		runTest(CMP_EXPR_TEXT, input, "-.01");
		runTest(CMP_AST, input, "- .01");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void FloatNoLeading0() throws RecognitionException {
		String input = "  .01 ";
		runTest(CMP_EXPR_TEXT, input, ".01");
		runTest(CMP_AST, input, ".01");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void FloatNoLeading0Dot() throws RecognitionException {
		String input = " .  +  01 ";
		runTest(CMP_EXPR_TEXT, input, "self::node() + 01");
		runTest(CMP_AST, input, "(+ . 01)");
	}

	/**
	 * Additive Expression with + operator
	 * 
	 * @throws RecognitionException
	 */
	@Test
	public void AdditiveExpr() throws RecognitionException {
		String input = " 12    +  13 ";
		runTest(CMP_EXPR_TEXT, input, "12 + 13");
		runTest(CMP_AST, input, "(+ 12 13)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void AdditiveExpr3() throws RecognitionException {
		String input = "  12   +   13 + 7  ";
		runTest(CMP_EXPR_TEXT, input, "12 + 13 + 7");
		runTest(CMP_AST, input, "(+ (+ 12 13) 7)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void AdditiveExpr3P() throws RecognitionException {
		String input = "    12   +(13+ 7)";
		runTest(CMP_EXPR_TEXT, input, "12 + (13 + 7)");
		runTest(CMP_AST, input, "(+ 12 (+ 13 7))");

	}

	/**
	 * Additive Expression with - operator
	 * 
	 * @throws RecognitionException
	 */

	@Test
	public void AdditiveExprMinus() throws RecognitionException {
		String input = "   12-14";
		runTest(CMP_EXPR_TEXT, input, "12 - 14");
		runTest(CMP_AST, input, "(- 12 14)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void AdditiveExprMinus3() throws RecognitionException {
		String input = " 12 - 14-15  ";
		runTest(CMP_EXPR_TEXT, input, "12 - 14 - 15");
		runTest(CMP_AST, input, "(- (- 12 14) 15)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void AdditiveExprMinus3P() throws RecognitionException {
		String input = "    12-(14-15)";
		runTest(CMP_EXPR_TEXT, input, "12 - (14 - 15)");
		runTest(CMP_AST, input, "(- 12 (- 14 15))");
	}

	/**
	 * Multiplicative Expression with * operator
	 * 
	 * @throws RecognitionException
	 */

	@Test
	public void MultiplicativeExprTimes() throws RecognitionException {
		String input = " 12 * 14 ";
		runTest(CMP_EXPR_TEXT, input, "12 * 14");
		runTest(CMP_AST, input, "(* 12 14)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void MultiplicativeExprTimes3() throws RecognitionException {
		String input = "12*14*15";
		runTest(CMP_EXPR_TEXT, input, "12 * 14 * 15");
		runTest(CMP_AST, input, "(* (* 12 14) 15)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void MultiplicativeExprTimes3P() throws RecognitionException {
		String input = "12*(14*15)";

		runTest(CMP_EXPR_TEXT, input, "12 * (14 * 15)");
		runTest(CMP_AST, input, "(* 12 (* 14 15))");
	}

	/**
	 * Multiplicative Expression with MOD operator
	 * 
	 * @throws RecognitionException
	 */

	@Test
	public void MultiplicativeExprMOD() throws RecognitionException {
		String input = "12 mod 14";
		runTest(CMP_EXPR_TEXT, input, "12 mod 14");
		runTest(CMP_AST, input, "(mod 12 14)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void MultiplicativeExprMOD3() throws RecognitionException {
		String input = "12 mod   14 mod 7";
		runTest(CMP_EXPR_TEXT, input, "12 mod 14 mod 7");
		runTest(CMP_AST, input, "(mod (mod 12 14) 7)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void MultiplicativeExprMOD3P() throws RecognitionException {
		String input = " 12  mod ( 14  mod  7)";
		runTest(CMP_EXPR_TEXT, input, "12 mod (14 mod 7)");
		runTest(CMP_AST, input, "(mod 12 (mod 14 7))");
	}

	/**
	 * Multiplicative Expression with DIV operator
	 * 
	 * @throws RecognitionException
	 */
	@Test
	public void MultiplicativeExprDIV() throws RecognitionException {
		String input = "12 div 14";
		runTest(CMP_EXPR_TEXT, input, "12 div 14");
		runTest(CMP_AST, input, "(div 12 14)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void MultiplicativeExprDIV3() throws RecognitionException {
		String input = " 12 div   14   div 7";
		runTest(CMP_EXPR_TEXT, input, "12 div 14 div 7");
		runTest(CMP_AST, input, "(div (div 12 14) 7)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void EqualityExprEQ() throws RecognitionException {
		String input = " 12  = 14";

		runTest(CMP_EXPR_TEXT, input, "12 = 14");
		runTest(CMP_AST, input, "(= 12 14)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void EqualitylExprNEQ() throws RecognitionException {
		String input = " 12 != 14 ";
		runTest(CMP_EXPR_TEXT, input, "12 != 14");
		runTest(CMP_AST, input, "(!= 12 14)");
	}

	/**
	 * AND Logical Expressions
	 * 
	 * @throws RecognitionException
	 */
	@Test
	public void LogicalAndExpr() throws RecognitionException {
		String input = "12 and 14";
		runTest(CMP_EXPR_TEXT, input, "12 and 14");
		runTest(CMP_AST, input, "(and 12 14)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void LogicalAndExpr3() throws RecognitionException {
		String input = " 12 and 14 and 15";

		runTest(CMP_EXPR_TEXT, input, "12 and 14 and 15");
		runTest(CMP_AST, input, "(and (and 12 14) 15)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void LogicalAndExpr3P() throws RecognitionException {
		String input = " 12 and (14 and 15)";

		runTest(CMP_EXPR_TEXT, input, "12 and (14 and 15)");
		runTest(CMP_AST, input, "(and 12 (and 14 15))");

	}

	/**
	 * OR Logical Expressions
	 * 
	 * @throws RecognitionException
	 */
	@Test
	public void LogicalORExpr() throws RecognitionException {
		String input = "12 or 14";
		runTest(CMP_EXPR_TEXT, input, "12 or 14");
		runTest(CMP_AST, input, "(or 12 14)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void LogicalOrExpr3() throws RecognitionException {
		String input = "12 or 14 or 15";
		runTest(CMP_EXPR_TEXT, input, "12 or 14 or 15");
		runTest(CMP_AST, input, "(or (or 12 14) 15)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void LogicalOrExpr3P() throws RecognitionException {
		String input = "12 or (14 or 15))";

		runTest(CMP_EXPR_TEXT, input, "12 or (14 or 15)");
		runTest(CMP_AST, input, "(or 12 (or 14 15))");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void VariableReference() throws RecognitionException {
		String input = "$foo";
		runTest(CMP_EXPR_TEXT, input, "$foo");
		runTest(CMP_AST, input, "($ foo)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void VariableReference2() throws RecognitionException {
		String input = "$foo:bar";
		runTest(CMP_EXPR_TEXT, input, "$foo:bar");
		runTest(CMP_AST, input, "($ (: foo bar))");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void Expr2() throws RecognitionException {
		String input = " ( 12+ $foo )-(12   +$bar)";
		runTest(CMP_EXPR_TEXT, input, "(12 + $foo) - (12 + $bar)");
		runTest(CMP_AST, input, "(- (+ 12 ($ foo)) (+ 12 ($ bar)))");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void Expr3() throws RecognitionException {
		String input = " 12 + ( $foo   - 13)";

		runTest(CMP_EXPR_TEXT, input, "12 + ($foo - 13)");
		runTest(CMP_AST, input, "(+ 12 (- ($ foo) 13))");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void FuncCallNoArgs() throws RecognitionException {
		String input = "foobar()";
		runTest(CMP_EXPR_TEXT, input, "foobar()");
		runTest(CMP_AST, input, "foobar");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void FuncCall1() throws RecognitionException {
		String input = "foobar('Hello')";
		runTest(CMP_EXPR_TEXT, input, "foobar('Hello')");
		runTest(CMP_AST, input, "foobar (Args 'Hello')");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void FuncCall2() throws RecognitionException {
		String input = "foobar(2+$var)";
		runTest(CMP_EXPR_TEXT, input, "foobar(2 + $var)");
		runTest(CMP_AST, input, "foobar (Args (+ 2 ($ var)))");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void FuncCall3() throws RecognitionException {
		String input = "foobar(2+$var,'Hello',12)";
		runTest(CMP_EXPR_TEXT, input, "foobar(2 + $var, 'Hello', 12)");
		runTest(CMP_AST, input, "foobar (Args (+ 2 ($ var)) 'Hello' 12)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void Expr4() throws RecognitionException {
		String input = "$foo mod 5";
		runTest(CMP_EXPR_TEXT, input, "$foo mod 5");
		runTest(CMP_AST, input, "(mod ($ foo) 5)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void Expr5() throws RecognitionException {
		String input = "$foo/bar mod 5";
		runTest(CMP_EXPR_TEXT, input, "$foo/child::bar mod 5");
		runTest(CMP_AST, "$foo//bar mod 5", "(mod ($ foo) // bar 5)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void Expr6() throws RecognitionException {
		String input = "$foo//bar mod 5";
		runTest(CMP_EXPR_TEXT, input,
				"$foo/descendant-or-self::node()/child::bar mod 5");
		runTest(CMP_AST, "$foo//bar mod 5", "(mod ($ foo) // bar 5)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprAxis() throws RecognitionException {
		String input = "/descendant::ns1:foo/parent::ns2:bar/child::child";

		runTest(CMP_EXPR_TEXT, input,
				"/descendant::ns1:foo/parent::ns2:bar/child::child");
		runTest(CMP_AST, input,
				"(/ (:: descendant) ns1 : foo / (:: parent) ns2 : bar / (:: child) child)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprAxis2() throws RecognitionException {
		String input = "/ancestor::ns1:foo/following-sibling::ns2:sib/preceding-sibling::sib2";
		runTest(CMP_EXPR_TEXT, input,
				"/ancestor::ns1:foo/following-sibling::ns2:sib/preceding-sibling::sib2");
		runTest(
				CMP_AST,
				input,
				"(/ (:: ancestor) ns1 : foo / (:: following-sibling) ns2 : sib / (:: preceding-sibling) sib2)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprAxis3() throws RecognitionException {
		String input = "/following::ns1:foo/preceding::ns2:sib/attribute::attr2";
		runTest(CMP_EXPR_TEXT, input,
				"/following::ns1:foo/preceding::ns2:sib/attribute::attr2");
		runTest(
				CMP_AST,
				input,
				"(/ (:: following) ns1 : foo / (:: preceding) ns2 : sib / (:: attribute) attr2)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprAxis4() throws RecognitionException {
		String input = "/namespace::ns1:foo/self::ns2:sib/descendant-or-self::ds/ancestor-or-self::ns:as";
		runTest(
				CMP_EXPR_TEXT,
				input,
				"/namespace::ns1:foo/self::ns2:sib/descendant-or-self::ds/ancestor-or-self::ns:as");
		runTest(
				CMP_AST,
				input,
				"(/ (:: namespace) ns1 : foo / (:: self) ns2 : sib / (:: descendant-or-self) ds / (:: ancestor-or-self) ns : as)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprAxisBadAxis() throws RecognitionException {
		String input = "/badaxis::foo";

		runTest(CMP_EXPR_TEXT, input, "/unknown-axis-name::foo");
		runTest(CMP_AST, input, "(/ (:: badaxis) foo)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void PathExprSlashSlash() throws RecognitionException {
		String input = "//foo//bar";
		runTest(CMP_EXPR_TEXT, input,
				"/descendant-or-self::node()/child::foo/descendant-or-self::node()/child::bar");
		runTest(CMP_AST, input, "(// foo // bar)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void Query() throws RecognitionException {
		String input = "$v//bar";
		runTest(CMP_EXPR_TEXT, input,
				"$v/descendant-or-self::node()/child::bar");
		runTest(CMP_AST, input, "($ v) // bar");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void Query2() throws RecognitionException {
		String input = "$v/bar";
		runTest(CMP_EXPR_TEXT, input, "$v/child::bar");
		runTest(CMP_AST, input, "($ v) / bar");
	}

}
