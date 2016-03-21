/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.extensions;

import org.eclipse.bpel.ui.bpelactions.AbstractBPELAction;

public class ActionDescriptor {

    protected String id;
    protected String categoryId;
    protected AbstractBPELAction action;
    protected boolean specCompliant;
    
    public ActionDescriptor() {
    }

    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public AbstractBPELAction getAction() {
        return action;
    }
    public void setAction(AbstractBPELAction action) {
        this.action = action;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
	public boolean isSpecCompliant() {
		return specCompliant;
	}
	public void setSpecCompliant(boolean specCompliant) {
		this.specCompliant = specCompliant;
	}
}
