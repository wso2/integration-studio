/*******************************************************************************
 * Copyright (c) 2007, 2012 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oleg Danilov, Intel - Initial API and Implementation
 *
 *******************************************************************************/

package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.extensions.ExpressionEditorDescriptor;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.xsd.XSDTypeDefinition;

public class AnnotationHelper {
	
	private AnnotationHelper() {
	}

	public static String getAnnotation(Variable var) {
		if (var == null || var.getName() == null) {
			return null;
		}

		String type = null;
		Message messageType = var.getMessageType();
		if (messageType != null && messageType.getQName() != null) {
			String prefix = messageType.getQName().getPrefix();
			type = (prefix != null && prefix.length() > 0) ?
					prefix + ":" + messageType.getQName().getLocalPart() :
						messageType.getQName().getLocalPart();
		} else {
			XSDTypeDefinition varType = var.getType();
			if (varType != null && varType.getName() != null) {
				type = varType.getQName();
			}
		}

		if (type != null) {
			return var.getName() + " (" + type + ")";
		}
		return var.getName();
	}
	
	public static String getAnnotation(PartnerLink pLink) {
		if (pLink == null || pLink.getName() == null) {
			return null;
		}
		PartnerLinkType plType = pLink.getPartnerLinkType();
		if (plType != null) {
			return pLink.getName() + " (" + plType.getName() + ")";
		}
		return pLink.getName();
	}
	
	public static String getAnnotation(Role role) {
		if (role == null) {
			return Messages.NONE;
		}
		return role.getName();
	}

	public static String getAnnotation(Operation operation) {
		if (operation == null || operation.getName() == null) {
			return null;
		}
		return operation.getName();
	}
	
	public static String getAnnotation(Expression expression) {
		if (expression == null) {
			return null;
		}
		return (expression.getBody() instanceof String) ? 
				(String)expression.getBody() : null;
	}

	public static String getExpressionLanguage(Expression expression) {
		if (expression == null) {
			return null;
		}
		String language = expression.getExpressionLanguage();
		ExpressionEditorDescriptor descriptor = 
			BPELUIRegistry.getInstance().getExpressionEditorDescriptor(language);
		if (descriptor != null) {
			language = descriptor.getLabel();
		}
		return language;
	}
}
