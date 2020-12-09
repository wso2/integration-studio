/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Assign category shows the current assign category section. 
 * There is one for "from" and one for "to"
 * 
 * This is also used in the Variable Initialization section.
 *
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 11, 2007
 *
 */

class CategorySection {
		
	IAssignCategory[] fAllowed = {}; 
	IAssignCategory   fCurrent;
	
	Label fLabel;
	Combo fCombo;		
	Composite fOuterComposite;
	
	
	BPELPropertySection fParentSection ;
	
	CategorySection ( BPELPropertySection aSection ) {
		fParentSection = aSection;
	}
	

	Composite ensureCategoryCompositeCreated () {
		
		if (fCurrent.getComposite() == null) {
			
			Composite c = fParentSection.createFlatFormComposite(fOuterComposite);
			FlatFormData data = new FlatFormData();
			data.left = new FlatFormAttachment(0,0);
			data.right = new FlatFormAttachment(100,0);
			data.top = new FlatFormAttachment(0,0);
			data.bottom = new FlatFormAttachment(100,0);
			c.setLayoutData(data);
			FillLayout fillLayout = new FillLayout();
			fillLayout.marginHeight = fillLayout.marginWidth = 0;
			c.setLayout(fillLayout);								
			fCurrent.createControls(c, fParentSection.getTabbedPropertySheetPage());
			fOuterComposite.layout(true);										
			return c;
		}			
		return fCurrent.getComposite();
	}
	
	@SuppressWarnings("nls")
	void showCurrent ( ) {
		
		assert(fCurrent != null);
		
		if (fCurrent.isHidden()) {
			fCurrent.aboutToBeShown();
		}
		fCurrent.getComposite().setVisible(true);				
	}
	
	void hideCurrent ( ) {			
		if (fCurrent == null) {
			return ;
		}
		
		if (fCurrent.isHidden() == false) {
			fCurrent.aboutToBeHidden();
		}
		fCurrent.getComposite().setVisible(false);
	}
	
	void updateCombo () {
		for(int i=0; i < fAllowed.length; i++) {
			if (fAllowed[i] == fCurrent) {
				fCombo.select(i);
				return ;
			}
		}
	}
};