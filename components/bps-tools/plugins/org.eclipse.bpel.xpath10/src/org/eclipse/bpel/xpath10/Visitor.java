/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.xpath10 ;

/**
 * Java JDK dependencies ...
 */
import java.util.List;


/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 */

public class Visitor  {
			
	protected void visit ( PathExpr expr ) {			
		visit ( expr.getFilterExpr() );		
		visit ( expr.getLocationPath() );
	}
		
	
	protected void visit (LocationPath expr ) {		
		visitList( expr.getSteps() );
	}


		
	protected void visit (FilterExpr expr) {		
		visit(expr.getExpr());		
		visitList( expr.getPredicates() );
	}

	protected void visit (BinaryExpr expr) {
		
		visit(expr.getLHS());					
		visit(expr.getRHS());				
	}
	
	
	protected void visit(UnaryExpr expr) {
		visit( expr.getExpr() );
	}

	
	protected void visit(UnionExpr expr) {				
		visit(expr.getLHS());				
		visit(expr.getRHS());		
			
	}
	
	protected void visit (NumberExpr expr) {
		 
	}
	
	
	protected void visit (LiteralExpr expr) {
		 
	}

		
	protected void visit (VariableReferenceExpr expr) {
		 
	}

	
	protected void visit (FunctionCallExpr expr) {
		visitList( expr.getParameters() );
	}
			
	protected void visit (NameStep step) {
		visitList(step.getPredicates());			
	}

	protected void visit(ProcessingInstructionNodeStep step) {
		visitList(step.getPredicates());		
	}

	protected void visit(AllNodeStep step) {		
		visitList(step.getPredicates());
	}

	
	protected void visit (TextNodeStep step) {
		visitList(step.getPredicates());		
	}

	protected void visit (CommentNodeStep step) {
		visitList(step.getPredicates());			
	}

	protected void visit (Predicate predicate) {		
		visit(predicate.getExpr());				
	}
	

	void visitList ( List<?> list) {
		for(Object next: list) {
			visit(next);
		}
	}

	
	/**
	 * @param obj
	 */
	public void visit ( Object obj ) {
		
		if (obj instanceof PathExpr) {
			visit((PathExpr) obj);
		} else if (obj instanceof LocationPath) {
			visit((LocationPath) obj);
		} else if (obj instanceof BinaryExpr) {
			visit((BinaryExpr) obj);
		} else if (obj instanceof FilterExpr) {
			visit((FilterExpr)obj);			
		} else if (obj instanceof UnaryExpr) {
			visit((UnaryExpr)obj);			
		} else if (obj instanceof NumberExpr) {
			visit((NumberExpr)obj);
		} else if (obj instanceof LiteralExpr) {
			visit((LiteralExpr)obj);			
		} else if (obj instanceof VariableReferenceExpr) {
			visit((VariableReferenceExpr)obj);
		} else if (obj instanceof FunctionCallExpr) {
			visit((FunctionCallExpr) obj);			
		} else if (obj instanceof List) { 
			visitList((List<?>) obj);
		} else if (obj instanceof NameStep) {
			visit((NameStep)obj);
		} else if (obj instanceof ProcessingInstructionNodeStep) {
			visit((ProcessingInstructionNodeStep) obj);
		} else if (obj instanceof AllNodeStep) {
			visit((AllNodeStep)obj);			
		} else if (obj instanceof TextNodeStep) {
			visit((TextNodeStep)obj);
		} else if (obj instanceof CommentNodeStep) {
			visit((CommentNodeStep)obj);
		} else if (obj instanceof Predicate) {
			visit((Predicate)obj);
		} else {
			// ignore or throw error ... ?
		}
	}
	
}