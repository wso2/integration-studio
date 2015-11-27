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

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Base class with some shared behavior for details panes that edit a through a {@link StyledText}.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @author Vincent Zurczak - EBM WebSourcing (Merge this class with TextSection, simplify it by only using the XPath viewer)
 * @author Lorenzo Bettini abstract class for all StyledText based expression sections
 * FIXME: There are probably cases that are not handled correctly. To be fixed on the fly.
 * FIXME: Undo is not supported correctly.
 */
public abstract class AbstractStyledTextExpressionSection extends BPELPropertySection {

	protected Composite fEditorArea ;
	protected StyledText expressionText;

	protected Font boldFont;
	protected String title;
	protected Label titleLabel;

	protected EStructuralFeature fStructuralFeature;
	protected AtomicBoolean modelUpdate = new AtomicBoolean( false );


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection
	 * #addAllAdapters()
	 */
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		Expression e = getExprFromModel();
		if( e != null && this.fAdapters.length > 0 )
			this.fAdapters[0].addToObject(e);
	}


	/**
	 *  When this method is called, the section has already been created.
	 *
	 *  The widgets are available to be configured, however, the section may not be shown yet.
	 *
	 *  The concept here is that we are reflecting the input selected in the UI. So the path that is taken
	 *  by this code must not create any re-doable commands, just set the widgets to what they are supposed to
	 *  be based on the model.
	 */
	@Override
	protected void basicSetInput( EObject newInput ) {

		this.modelUpdate.set( true );
		super.basicSetInput(newInput);

		/** Figure out based in the input, what EMF structural feature we are setting */
		this.fStructuralFeature = getStructuralFeature( newInput );

		Expression exp = getExprFromModel();
		Object o = exp != null ? exp.getBody() : null;
		String content = o == null ? "" : String.valueOf( o );
		this.expressionText.setText( content );
		this.expressionText.setSelection( content.length());
		this.expressionText.setFocus();

		this.modelUpdate.set( false );
	}


	/**
	 * The expression target is the target object on which we can execute
	 * the SetCommand(target,object,structural-feature).
	 *
	 * In most cases, it is just the input of the section. But in some cases
	 * the input if the section does not match the target, so sub-classes
	 * may override this method.
	 *
	 * @return
	 */
	protected EObject getExpressionTarget() {
		return getInput();
	}


	/**
	 * @return
	 */
	protected String getExpressionType() {
		return IEditorConstants.ET_ANY ;
	}


	/**
	 * Return the previously computed structural feature of the input object.
	 * @return
	 */
	protected EStructuralFeature getStructuralFeature() {
		return this.fStructuralFeature;
	}


	/**
	 * @param object
	 * @return the structural feature to update on the model object
	 */
	protected abstract EStructuralFeature getStructuralFeature( EObject object );


	/**
	 * @return
	 */
	protected Expression getExprFromModel() {

		Expression result = null;
		EObject target = getExpressionTarget();
		if( target != null ) {
			Object o = target.eGet( getStructuralFeature());
			if( o instanceof Expression )
				result = (Expression) o;
		}

		return result;
	}


	/**
	 * @param expression
	 * @return
	 */
	protected Expression getExpression4Target( Expression expression ) {
		return expression;
	}


	/**
	 * Determines whether a notification affects this section.
	 * @param n a notification
	 * @return true if it affects this section, false otherwise
	 */
	protected boolean isBodyAffected( Notification n ) {

		return n.getOldValue() instanceof Expression
				|| n.getNewValue() instanceof Expression
				|| n.getNotifier() instanceof Expression
				|| n.getFeature() == getStructuralFeature();
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection
	 * #isValidMarker(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public final boolean isValidMarker( IMarker marker ) {

		// FIXME: the implementation may not be valid for all the sub-classes
		boolean result = false;
		try {
			String context = (String) marker.getAttribute( "href.context" );
			result = "name".equals ( context );

		} catch( Exception ex ) {
			// nothing
		}

		return result;
	}


	protected String getCommandLabel() {
		return IBPELUIConstants.CMD_EDIT_EXPRESSION;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection
	 * #createClient(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createClient( Composite parent ) {

		// The top
		this.fEditorArea = getWidgetFactory().createComposite( parent );
		this.fEditorArea.setLayout( new GridLayout());
		if( this.title != null ) {

			// The font
			FontData[] fontData = parent.getDisplay().getSystemFont().getFontData();
			fontData[ 0 ].setStyle( SWT.BOLD );
			this.boldFont = new Font( parent.getDisplay(), fontData[ 0 ]);

			// The title
			this.titleLabel = this.fWidgetFactory.createLabel( this.fEditorArea, this.title);
			this.titleLabel.setFont(this.boldFont);
		}

		// The expression editor
		getWidgetFactory().createLabel( this.fEditorArea, getStyledTextLabelString() );

		this.expressionText = createStyledText(this.fEditorArea);
		this.expressionText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				saveExpressionToModel();
			}
		});
	}

	/**
	 * Saves the expression to the model.
	 */
	protected void saveExpressionToModel() {

		if( this.modelUpdate.get())
			return;

		CompoundCommand result = new CompoundCommand();
		Expression exp = BPELFactory.eINSTANCE.createCondition();
		exp.setBody( this.expressionText != null ? this.expressionText.getText().trim() : "" );
		exp.setExpressionLanguage(getExpressionLanguage());
		result.add( new SetCommand( getExpressionTarget(), getExpression4Target( exp ) , getStructuralFeature()));

		getCommandFramework().execute( result );
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.TextSection
	 * #dispose()
	 */
	@Override
	public void dispose() {

		if( this.boldFont != null && ! this.boldFont.isDisposed())
			this.boldFont.dispose();

		super.dispose();
	}

	/**
	 * @param styledTextComposite
	 *            the Composite for the StyledText
	 * @return the created and configured StyledText
	 */
	protected abstract StyledText createStyledText(Composite styledTextComposite);

	/**
	 * @return The string for the label to be shown above the StyledText.
	 */
	protected abstract String getStyledTextLabelString();


	/**
	 * @return the expression language
	 */
	protected abstract String getExpressionLanguage();

}