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

import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.XSD2XMLGenerator;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.bpel.validator.EmfModelQuery;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;


/**
 * Variable from-spec section. This is allowed in BPEL 2.0.
 *
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date June, 2007
 */


public class VariableInitializationSection extends BPELPropertySection {

	/** The from section */
	CategorySection fFromSection = null;

	/** The current copy rule being edited. */
	Variable fVariable;

	Composite copySelectComposite;


	/**
	 * Variable initialization section. This is the LHS of the copy rule.
	 *
	 */

	public VariableInitializationSection()  {

		super();
		this.fFromSection = new CategorySection(this);

		this.fFromSection.fAllowed = new IAssignCategory[] {
			new VariablePartAssignCategory( this ),
			new ExpressionAssignCategory( this ),
			new LiteralAssignCategory( this ),
			new VariablePropertyAssignCategory( this ),
			new PartnerRoleAssignCategory( this, true ),
			new EndpointReferenceAssignCategory( this ),
			new OpaqueAssignCategory( this ),
			new NullAssignCategory (this  )
		};

	}

	protected boolean isFromAffected ( Notification n ) {
		return n.getFeature() == BPELPackage.eINSTANCE.getVariable_From();
	}


	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new MultiObjectAdapter() {

				@Override
				public void notify (Notification n) {
					if ( isFromAffected (n) ) {
						selectCategoriesForInput( null );
					}
				}
			},
		};
	}

	protected void createCategorySectionWidgets (Composite composite, final CategorySection section ) {

		FlatFormData data;

		section.fLabel = this.fWidgetFactory.createLabel(composite, Messages.AssignImplDetails_From__1 );

		section.fCombo = new Combo(composite,SWT.FLAT | SWT.BORDER | SWT.READ_ONLY );
		data = new FlatFormData();

		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(section.fLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(100, 0);

		data.top = new FlatFormAttachment(0,0);
		section.fCombo.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(section.fCombo, -IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(section.fCombo, 0, SWT.CENTER);
		section.fLabel.setLayoutData(data);

		for (IAssignCategory category : section.fAllowed ) {
			section.fCombo.add( category.getName() );
		}

		section.fCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected (SelectionEvent e) {
				int index = section.fCombo.getSelectionIndex();
				updateCategorySelection ( section , index , true );
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		section.fOuterComposite = createFlatFormComposite(composite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(section.fLabel, 0, SWT.LEFT);
		data.right = new FlatFormAttachment(section.fCombo, 0, SWT.RIGHT);
		data.top = new FlatFormAttachment(section.fCombo, IDetailsAreaConstants.VSPACE);
		data.bottom = new FlatFormAttachment(100,0);
		section.fOuterComposite.setLayoutData(data);
	}


	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}


	@Override
	protected void createClient(Composite parent) {

		Composite composite = createFlatFormComposite(parent);
		Composite mainComposite = createFlatFormComposite(composite);
		FlatFormData data = new FlatFormData();
		data.left = new FlatFormAttachment (this.copySelectComposite, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0,0);
		data.right = new FlatFormAttachment(100,0);
		data.bottom = new FlatFormAttachment(100,0);
		mainComposite.setLayoutData(data);

		createCategorySectionWidgets(mainComposite,this.fFromSection );

	}


	// Total Hack until we have Copy objects in graphical editor
	@Override
	protected void basicSetInput (EObject newInput) {
		super.basicSetInput(newInput);

		this.fVariable = getModel();
		selectCategoriesForInput (this.fVariable);
	}




	/**
	 * Called when the copy rule changes or is created.
	 *
	 */
	protected void selectCategoriesForInput (Variable variable) {

		if (variable != null) {
			this.fVariable = variable;
		}

		for (IAssignCategory category : this.fFromSection.fAllowed) {
			if (category.isCategoryForModel( this.fVariable.getFrom() )) {
				updateCategorySelection(this.fFromSection,category,false);
				return;
			}
		}

		/** In case we can't find the appropriate one, just display the first one */
		if ( this.fFromSection.fCurrent == null)  {
			updateCategorySelection(this.fFromSection,0,false);
		}
	}


	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();

		if (this.fFromSection.fCurrent != null) {
			this.fFromSection.fCurrent.aboutToBeHidden();
		}

	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeShown()
	 */
	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		if (this.fFromSection.fCurrent != null) {
			this.fFromSection.fCurrent.aboutToBeShown();
		}
	}


	void updateCategorySelection ( CategorySection section, int index , boolean bVisual ) {
		updateCategorySelection(section, section.fAllowed[index], bVisual);
	}

	void updateCategorySelection ( CategorySection section, IAssignCategory newCurrent, boolean bVisual) {

		if (section.fCurrent != newCurrent) {
			/** Hide current */
			section.hideCurrent();

			/** Update current to the one that picked from */
			section.fCurrent = newCurrent;
			section.ensureCategoryCompositeCreated();
		}

		/** Visual selection */

		if (bVisual || this.fVariable.getFrom() == null) {

			Command cmd ;

			if ( section.fCurrent.isCategoryForModel (null) == false ) {
				cmd = new SetCommand( getInput(), BPELFactory.eINSTANCE.createFrom(), BPELPackage.eINSTANCE.getVariable_From() );
			} else {
				cmd = new SetCommand( getInput(), null , BPELPackage.eINSTANCE.getVariable_From() );

			}
			// Execute this right away.
			getBPELEditor().getCommandFramework().execute( cmd );
		}

		if (!bVisual) {
			section.updateCombo();
		}

        // https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7351
		// generate an appropriate XML initializer literal if currently empty
		if (section.fCurrent instanceof LiteralAssignCategory) {
			From from = this.fVariable.getFrom();
			if (from!=null) {
				String literal = from.getLiteral();
				// https://issues.jboss.org/browse/JBIDE-8345
				// remove dependency on Java 1.6
				if (literal==null || "".equals(literal.trim())) {
					literal = createDefaultInitializer(getBPELEditor(), this.fVariable, null);
					from.setLiteral(literal);
				}
			}
		}

		// Set the input of the category after we insert the to or from into the model.
		section.fCurrent.setInput( this.fVariable.getFrom() );
		section.showCurrent();
		section.fCurrent.refresh();

		// TODO: should the categories only store when a widget change is committed?
		// Cons of that idea:
		//   - Changing the category in the combo, but *not* changing anything else,
		//     then clicking elsewhere and back, would cause the combo to revert.
		//   - The OpaqueAssignCategory doesn't have any widgets..
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return null;
	}


	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@SuppressWarnings("boxing")
	@Override
	public void restoreUserContext(Object userContext) {

	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#gotoMarker(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void gotoMarker(IMarker marker) {
		refresh();
	}

	/**
	 * Construct an appropriate XML literal initializer for the given "from" and "to" parts
	 *
	 * @param bpelEditor
	 * @param from
	 * @param to
	 * @return
	 */
	public static String createDefaultInitializer(BPELEditor bpelEditor, From from, To to) {
		String literal = EMPTY_STRING;
		if ( from!=null && to!=null) {
			literal = from.getLiteral();
			if (literal==null || literal.isEmpty()) {
				literal = createDefaultInitializer(bpelEditor, to.getVariable(), to.getPart());
				from.setLiteral(literal);
			}
		}
		return literal;
	}

	/**
	 * Construct an appropriate XML literal initializer for the given variable and message part.
	 *
	 * @param bpelEditor
	 * @param var - the variable to be initialized
	 * @param part - if the variable is defined as a message, this is the message part
	 *               otherwise null
	 * @return - XML string representing an initializer for the given variable
     * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	 * @see https://jira.jboss.org/browse/JBIDE-7351
	 */
	public static String createDefaultInitializer(BPELEditor bpelEditor, Variable var, Part part) {
		String fromString = EMPTY_STRING;
		try {
			String rootElement = null;
			String uriWSDL = null;

			// Variable is defined using "messageType"
			Message msg = var.getMessageType();
			if (msg != null) {
				if (msg.eIsProxy()) {
					msg = (Message)EmfModelQuery.resolveProxy(bpelEditor.getProcess(), msg);
				}
				if (part==null) {
					Map parts = msg.getParts();
					if (parts!=null && !parts.isEmpty()) {
						Map.Entry entry = (Map.Entry)parts.entrySet().iterator().next();
						part = (Part)entry.getValue();
					}
				}
				if (part!=null) {
					XSDElementDeclaration declaration = part.getElementDeclaration();
					if (declaration != null) {
						uriWSDL = declaration.getSchema().getSchemaLocation();
						rootElement = declaration.getName();
					}
				}
			}

			// Variable is defined using "type"
			XSDTypeDefinition type = var.getType();
			if (type != null) {
				QName qname = new QName(type.getTargetNamespace(), type.getName());
				rootElement = qname.getLocalPart();
				uriWSDL = type.eResource().getURI().toString();
			}

			// Variable is defined using "element"
			XSDElementDeclaration element = var.getXSDElement();
			if (element != null) {
				QName qname = new QName(element.getTargetNamespace(), element
						.getName());
				rootElement = qname.getLocalPart();
				uriWSDL = element.eResource().getURI().toString();
			}

			XSD2XMLGenerator generator = new XSD2XMLGenerator(uriWSDL, rootElement);
			fromString = generator.createXML();
		}
		catch (Exception e) {
		}
		return fromString;
	}
}
