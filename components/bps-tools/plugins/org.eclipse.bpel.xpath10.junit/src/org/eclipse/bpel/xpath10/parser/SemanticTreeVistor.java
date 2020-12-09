package org.eclipse.bpel.xpath10.parser;

import org.eclipse.bpel.xpath10.AllNodeStep;
import org.eclipse.bpel.xpath10.BinaryExpr;
import org.eclipse.bpel.xpath10.CommentNodeStep;
import org.eclipse.bpel.xpath10.FilterExpr;
import org.eclipse.bpel.xpath10.FunctionCallExpr;
import org.eclipse.bpel.xpath10.LiteralExpr;
import org.eclipse.bpel.xpath10.LocationPath;
import org.eclipse.bpel.xpath10.NameStep;
import org.eclipse.bpel.xpath10.NumberExpr;
import org.eclipse.bpel.xpath10.PathExpr;
import org.eclipse.bpel.xpath10.Predicate;
import org.eclipse.bpel.xpath10.ProcessingInstructionNodeStep;
import org.eclipse.bpel.xpath10.TextNodeStep;
import org.eclipse.bpel.xpath10.UnaryExpr;
import org.eclipse.bpel.xpath10.UnionExpr;
import org.eclipse.bpel.xpath10.VariableReferenceExpr;
import org.eclipse.bpel.xpath10.Visitor;;

/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */


@SuppressWarnings({ "boxing", "nls" })

public class SemanticTreeVistor extends Visitor {

	int fLevel = 0;
	
	void pushLevel () {
		fLevel ++;
	}
	void popLevel () {
		fLevel--;
	}
		
	@Override
	protected void visit (AllNodeStep step) {		
		pushLevel();		
		p("> %s ", step.getText());
		p0(" [%d,%d] %s\n",step.getPosition(), step.getEndPosition(),step.getClass().getSimpleName());		
		super.visit(step);
		popLevel();
	}

	@Override
	protected void visit (BinaryExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());		
		super.visit(expr);
		popLevel();
	}

	@Override
	protected void visit(CommentNodeStep step) {
		pushLevel();
		p("> %s",step.getText());
		p0(" [%d,%d] %s\n",step.getPosition(), step.getEndPosition(),step.getClass().getSimpleName());
		super.visit(step);
		popLevel();
	}

	@Override
	protected void visit(FilterExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());
		super.visit(expr);
		popLevel();
	}

	@Override
	protected void visit(FunctionCallExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());
		super.visit(expr);
		popLevel();	
	}

	@Override
	protected void visit(LiteralExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());
		super.visit(expr);
		popLevel();
	}

	@Override
	protected void visit(LocationPath expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());
		super.visit(expr);
		popLevel();
	}

	@Override
	protected void visit(NameStep step) {
		pushLevel();
		p("> %s",step.getText());
		p0(" [%d,%d] %s\n",step.getPosition(), step.getEndPosition(),step.getClass().getSimpleName());
		super.visit(step);
		popLevel();
	}

	@Override
	protected void visit(NumberExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());
		super.visit(expr);
		popLevel();
	}

	@Override
	protected void visit(PathExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());
		super.visit(expr);
		popLevel();
	}

	@Override
	protected void visit(Predicate predicate) {
		pushLevel();
		p("> %s",predicate.getText());
		p0(" [%d,%d] %s\n",predicate.getPosition(), predicate.getEndPosition() ,predicate.getClass().getSimpleName());
		super.visit(predicate);
		popLevel();
	}

	@Override
	protected void visit(ProcessingInstructionNodeStep step) {
		pushLevel();
		p("> %s",step.getText());
		p0(" [%d,%d] %s\n",step.getPosition(), step.getEndPosition(),step.getClass().getSimpleName() );
		super.visit(step);
		popLevel();
	}

	@Override
	protected void visit(TextNodeStep step) {
		pushLevel();
		p("> %s",step.getText());
		p0(" [%d,%d] %s\n",step.getPosition(), step.getEndPosition() ,step.getClass().getSimpleName() );
		super.visit(step);
		popLevel();
	}

	@Override
	protected void visit(UnaryExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());
		super.visit(expr);
		popLevel();
	}

	@Override
	protected void visit(UnionExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName() );
		super.visit(expr);
		popLevel();
	}

	@Override
	protected void visit(VariableReferenceExpr expr) {
		pushLevel();
		p("> %s",expr.getText());
		p0(" [%d,%d] %s\n",expr.getPosition(), expr.getEndPosition(),expr.getClass().getSimpleName());
		super.visit(expr);
		popLevel();
	}

	
	void p (String msg, Object ... args) {
		for(int i=0 ; i < fLevel; i++) {
			System.out.print("  ");
		}
		System.out.printf(msg, args);
	}
	void p0(String msg, Object ... args) {
		System.out.printf(msg, args);
	}
}
