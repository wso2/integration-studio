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
package org.eclipse.bpel.ui.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Abstract base class of sections that acts as host for two other sections
 * aligned side by side.
 * 
 * NB: Dec 12th, 2006
 * 
 * The main intention to create this class was the "Counter Values" properties
 * tab of the ForEach activity. It just looks nicer if the editors for
 * "StartCounterValue" and "FinalCounterValue" are aligned side by side instead
 * of one below the other.
 * 
 * The tabbed properties view framework doesn't provide possibilities to align
 * sections side by side and we wanted to reuse the ExpressionSection - so we
 * had to introduce something new...
 * 
 * Since hosting sections in another section is surely not intended by the
 * framework most of this class is nasty and crampy. Anyway it works and looks
 * good... :-)
 * 
 * @author Michael Illiger (milliger@de.ibm.com)
 */
public abstract class TwoSectionsHostSection extends BPELPropertySection {

	/**
	 * The left guest section.
	 */
	protected BPELPropertySection leftSection;

	/**
	 * The right guest section.
	 */
	protected BPELPropertySection rightSection;

	/**
	 * The parent composite which is passed to the guests to draw on.
	 */
	private Composite parentComposite;

	/**
	 * Since this section is nothing more than the host of two other ones it
	 * actually doesn't really need an input to be set for itself. But it needs
	 * to pass the input to its guests.
	 */
	@Override
	protected void basicSetInput(EObject newInput) {

		super.basicSetInput(newInput);

		// pass input to guest sections
		leftSection.basicSetInput(newInput);
		rightSection.basicSetInput(newInput);

		/*
		 * Calling addAllAdapters() in the basicSetInput() method is a real ugly
		 * hack and should better be done in createClient(). Anyway
		 * addAllAdapters() requires the model object to be attached to the
		 * sections and here's the place we can be sure about that...
		 */
		leftSection.addAllAdapters();
		rightSection.addAllAdapters();
	}

	/**
	 * Create the client area. This is just done once.
	 */
	@Override
	protected void createClient(Composite parent) {

		// initialize the guest sections
		leftSection = initLeftSection();
		rightSection = initRightSection();

		parentComposite = createFlatFormComposite(parent);
		FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);
		parentComposite.setLayout(fillLayout);

		leftSection.createControls(parentComposite, this
				.getTabbedPropertySheetPage());

		rightSection.createControls(parentComposite, this
				.getTabbedPropertySheetPage());
	}

	/**
	 * Subclasses implement this method to configure wich section shall be
	 * schown as guest on the left hand side.
	 * 
	 * Something like: <code>return new XYZSection();</code> should be enough
	 * in most cases.
	 */
	protected abstract BPELPropertySection initRightSection();

	/**
	 * Subclasses implement this method to configure wich section shall be
	 * schown as guest on the right hand side.
	 * 
	 * Something like: <code>return new XYZSection();</code> should be enough
	 * in most cases.
	 */
	protected abstract BPELPropertySection initLeftSection();

	/**
	 * Make sure that the sections we created by hand are disposed.
	 */
	@Override
	public void dispose() {
		if (leftSection != null) {
			leftSection.dispose();
		}
		if (rightSection != null) {
			rightSection.dispose();
		}
		super.dispose();
	}

	
	/** (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() { 
		return true;
	}
	
	
}