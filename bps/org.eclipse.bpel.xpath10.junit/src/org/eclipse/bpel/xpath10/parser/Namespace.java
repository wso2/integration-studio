package org.eclipse.bpel.xpath10.parser;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 * 
 */

@SuppressWarnings("nls")
public class Namespace extends AbstractTC {

	/**
	 * @throws RecognitionException
	 */

	@Test
	public void QNameSteps() throws RecognitionException {
		String input = "ns1:foo";
		runTest(CMP_EXPR_TEXT, input, "child::ns1:foo");
		runTest(CMP_AST, input, "ns1 : foo");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void QNameFunctionCall() throws RecognitionException {
		String input = "ns1:foo ( ns2:bar () )";
		runTest(CMP_EXPR_TEXT, input, "ns1:foo(ns2:bar())");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void QNameFunctionCallArg1LocationPath() throws RecognitionException {
		String input = "ns1:foo ( bar )";
		runTest(CMP_EXPR_TEXT, input, "ns1:foo(child::bar)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void QNameFunctionCallArg1LocationPathNS()
			throws RecognitionException {
		String input = "ns1:foo ( ns:bar )";
		runTest(CMP_EXPR_TEXT, input, "ns1:foo(child::ns:bar)");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void QNameStepsAbs() throws RecognitionException {
		String input = "/ns1:foo/ns2:bar";
		runTest(CMP_EXPR_TEXT, input, "/child::ns1:foo/child::ns2:bar");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void QNameStepsVarRef() throws RecognitionException {
		String input = "$ns1:var/ns1:foo/ns2:foo";

		runTest(CMP_EXPR_TEXT, input, "$ns1:var/child::ns1:foo/child::ns2:foo");
		runTest(CMP_AST, input, "($ (: ns1 var)) / ns1 : foo / ns2 : foo");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void QNameVar() throws RecognitionException {
		String input = "$ns1:foo";

		runTest(CMP_AST, input, "($ (: ns1 foo))");
		runTest(CMP_EXPR_TEXT, input, "$ns1:foo");
	}

	/**
	 * @throws RecognitionException
	 */
	@Test
	public void QNameFunction() throws RecognitionException {
		String input = "ns1:func ( 1, 'A', 3.14 )";

		runTest(CMP_AST, input, "(: ns1 func) (Args 1 'A' 3.14)");
		runTest(CMP_EXPR_TEXT, input, "ns1:func(1, 'A', 3.14)");
	}

}
