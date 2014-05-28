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

package org.eclipse.bpel.xpath10;

/**
 * A number expression.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */
public class NumberExpr extends Expr {
	
	Number fNumber = Integer.valueOf( 0 );
	
	/**
	 * Brand new shiny number expression.
	 * @param number
	 */
	public NumberExpr (String number) {
		super( number );
		fNumber = extractNumber(number);
	}
	
	/**
	 * Brand new shiny number expression.
	 * @param num
	 */
	public NumberExpr (Number num) {
		super(num.toString());
		fNumber = num;
	}
	
	/**	 
	 * @return the number.
	 */
	public Number getNumber() {
		return fNumber;
	}
	
	Number extractNumber(String numberBody) {       
        boolean isReal = numberBody.indexOf('.') >= 0; 
        if (!isReal) {
            return new Integer(numberBody);
        }
		double result = Double.parseDouble(numberBody);
		return new Double(result);
    }
   
	
	/**
	 * negate the number expression.
	 */
	public void negate () {
		
		if (fNumber instanceof Float) {
			fNumber = Float.valueOf( -1 * fNumber.floatValue());
		} else if (fNumber instanceof Short) {
			fNumber = Short.valueOf((short) (-1 * fNumber.shortValue()));
		} else if (fNumber instanceof Integer) {
			fNumber = Integer.valueOf( -1*fNumber.intValue());
		} else if (fNumber instanceof Long) {
			fNumber = Long.valueOf( -1*fNumber.longValue());
		} else {
			fNumber = Double.valueOf( -1.0 * fNumber.doubleValue());
		}		
	}
	
}
