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

package org.eclipse.bpel.validator.model;

import java.lang.annotation.*;

/**
 * Annotation to tag rule methods in rule classes.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 12, 2007
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface ARule {
	
	/** The date in which this rule was added */
	String date()      default "01/01/1970";
	
	/** The static analysis reference code
	 * @return the static analysis code.
	 */
	
	int sa ()       default 0;
	
	/** Brief description of the rule */
	String desc()      default "No description";
	
	/** The author to bug about this */
	String author()    default "Unknown";	
	
	/** Tags are used for marked execution of rules */
	String tag ()      default "pass1";
	
	/** the order in which the rule will be executed */ 
	int order () default 0;

	String errors() default "";

	String warnings() default "";

	String infos() default "";
}
