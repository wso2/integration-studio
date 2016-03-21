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
package org.eclipse.bpel.validator.adapters;

import javax.xml.namespace.QName;

import org.eclipse.bpel.fnmeta.model.Argument;
import org.eclipse.bpel.fnmeta.model.Function;
import org.eclipse.bpel.fnmeta.model.Optionality;
import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.bpel.validator.model.IFunctionMeta;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 7, 2007
 */

public class FunctionAdapter extends AbstractStatefulAdapter 
		implements IFunctionMeta {

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getClassName()
	 */
	public String getClassName() {
		return getTarget(null,Function.class).getClassName();
	}

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getComment()
	 */
	public String getComment() {
		return getTarget(null,Function.class).getHelp();
	}

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getDeprecateComment()
	 */
	public String getDeprecateComment() {
		return getTarget(null,Function.class).getDeprecateComment();		
	}

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getMaxArity()
	 */
	public int getMaxArity() {

		int cnt = 0;
		Function fn = getTarget(null,Function.class) ;
		for(Argument a : fn.getArguments()) {
			if (a.getOptionality() == Optionality.OPTIONAL_MANY) {
				return Integer.MAX_VALUE;
			}
			cnt += 1;
		}		
		return cnt;	
	}

	
	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getMinArity()
	 */
	public int getMinArity() {
		Function fn = getTarget(null,Function.class) ;
		
		int cnt = 0;
		for(Argument a : fn.getArguments()) {
			if (a.getOptionality() == Optionality.REQUIRED) {
				cnt += 1;
			}
		}
		
		return cnt;
	}

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getName()
	 */
	public String getName() {
		return getTarget(null,Function.class).getName();
	}

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getNamespacePrefix()
	 */
	public String getNamespacePrefix() {
		return getTarget(null,Function.class).getPrefix();
	}

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getNamespaceUri()
	 */
	public String getNamespaceUri() {
		return getTarget(null,Function.class).getNamespace();
	}

	QName fFunctionQName = null;
	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getQName()
	 */
	public QName getQName() {
		if (fFunctionQName != null) {
			return fFunctionQName;			
		}
		Function fn = getTarget(null,Function.class) ;
		fFunctionQName = new QName(fn.getNamespace(),fn.getName(),fn.getPrefix() );
		return fFunctionQName;
	}

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#getReturnType()
	 */
	@SuppressWarnings("nls")
	public Class<?> getReturnType() {
		Function fn = getTarget(null,Function.class) ;
		
		if ("string".equalsIgnoreCase(fn.getReturnType())) {
			return String.class;
		} else if ("boolean".equalsIgnoreCase(fn.getReturnType())) {
			return Boolean.class;
		} else if ("number".equalsIgnoreCase(fn.getReturnType())) {
			return Number.class;
		}
		
		return null;
	}

	/**
	 * @see org.eclipse.bpel.validator.model.IFunctionMeta#isDeprecated()
	 */
	@SuppressWarnings("boxing")
	public boolean isDeprecated() {
		return getTarget(null,Function.class).getIsDeprecated();
	}
	

}
