/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: QueryImpl.java,v 1.9 2011/06/06 16:53:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.messageproperties.impl;

//Bugzilla 340654 - renamed to avoid confusion with WSDL's ExtensibilityElement
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.impl.BPELExtensibilityElementImpl;
import java.util.Collection;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.bpel.model.messageproperties.util.MessagepropertiesConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.internal.impl.ExtensibilityElementImpl;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * CAUTION: We want to reuse the XPath editor for query expression, but unfortunately it requires that
 * the model object implements the Expression interface (only used in the BPEL model currently).
 * I have added the Expression methods by hand. These have essentially the same functionality as the Query
 * interface, only the names are changed.
 * 
 * @see https://jira.jboss.org/browse/JBIDE-7107
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=348434
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.impl.QueryImpl#getQueryLanguage <em>Query Language</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.messageproperties.impl.QueryImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @customized
 */
public class QueryImpl extends BPELExtensibilityElementImpl implements Query,
		Expression {
	/**
	 * The default value of the '{@link #getQueryLanguage() <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueryLanguage() <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryLanguage()
	 * @generated
	 * @ordered
	 */
	protected String queryLanguage = QUERY_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MessagepropertiesPackage.Literals.QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueryLanguage() {
		return queryLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryLanguage(String newQueryLanguage) {
		String oldQueryLanguage = queryLanguage;
		queryLanguage = newQueryLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MessagepropertiesPackage.QUERY__QUERY_LANGUAGE,
					oldQueryLanguage, queryLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MessagepropertiesPackage.QUERY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MessagepropertiesPackage.QUERY__QUERY_LANGUAGE:
			return getQueryLanguage();
		case MessagepropertiesPackage.QUERY__VALUE:
			return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MessagepropertiesPackage.QUERY__QUERY_LANGUAGE:
			setQueryLanguage((String) newValue);
			return;
		case MessagepropertiesPackage.QUERY__VALUE:
			setValue((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MessagepropertiesPackage.QUERY__QUERY_LANGUAGE:
			setQueryLanguage(QUERY_LANGUAGE_EDEFAULT);
			return;
		case MessagepropertiesPackage.QUERY__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MessagepropertiesPackage.QUERY__QUERY_LANGUAGE:
			return QUERY_LANGUAGE_EDEFAULT == null ? queryLanguage != null
					: !QUERY_LANGUAGE_EDEFAULT.equals(queryLanguage);
		case MessagepropertiesPackage.QUERY__VALUE:
			return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT
					.equals(value);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (queryLanguage: "); //$NON-NLS-1$
		result.append(queryLanguage);
		result.append(", value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

	//
	// Reconcile methods: DOM -> Model
	//

	@Override
	public void reconcileAttributes(Element changedElement) {
		//System.out.println("RoleImpl.reconcileAttributes("+changedElement+")");
		super.reconcileAttributes(changedElement);

		setQueryLanguage(MessagepropertiesConstants.getAttribute(
				changedElement,
				MessagepropertiesConstants.QUERY_QUERYLANGUAGE_ATTRIBUTE));

		// Determine whether or not there is an element in the child list.
		Node candidateChild = null;
		NodeList nodeList = changedElement.getChildNodes();
		int length = nodeList.getLength();
		for (int i = 0; i < length; i++) {
			Node child = nodeList.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				candidateChild = child;
				break;
			}
		}
		if (candidateChild == null) {
			candidateChild = changedElement.getFirstChild();
		}
		String data = getText(candidateChild);
		if (data != null) {
			setValue(data);
		}
		reconcileReferences(true); // TODO true?
	}

	@Override
	public void handleUnreconciledElement(Element child,
			Collection remainingModelObjects) {
		//System.out.println("QueryImpl.handleUnreconciledElement()");
		//		String value = getText(child);
		//		if (value != null) {
		//			setValue(value);
		//		}
	}

	//
	// For reconciliation: Model -> DOM
	//

	@Override
	protected void changeAttribute(EAttribute eAttribute) {
		//System.out.println("RoleImpl.changeAttribute("+eAttribute+")");
		if (isReconciling)
			return;

		super.changeAttribute(eAttribute);
		Element theElement = getElement();
		if (theElement != null) {
			if (eAttribute == null
					|| eAttribute == MessagepropertiesPackage.eINSTANCE
							.getQuery_QueryLanguage())
				niceSetAttribute(
						theElement,
						MessagepropertiesConstants.QUERY_QUERYLANGUAGE_ATTRIBUTE,
						getQueryLanguage());
		}
	}

	@Override
	public Element createElement() {
		//System.out.println("QueryImpl.createElement()");
		Element newElement = super.createElement();

		String value = getValue();
		if (value != null) {
			CDATASection cdata = getEnclosingDefinition().getDocument()
					.createCDATASection(value);
			newElement.appendChild(cdata);
		}

		return newElement;
	}

	/**
	 * Helper method to get a string from the given text node or CDATA text node.
	 */
	private String getText(Node node) {
		StringBuilder data = new StringBuilder();
		boolean containsValidData = false;
		while (node != null) {
			if (node.getNodeType() == Node.TEXT_NODE) {
				Text text = (Text) node;
				data.append(text.getData());
			} else if (node.getNodeType() == Node.CDATA_SECTION_NODE) {
				data = new StringBuilder();
				do {
					CDATASection cdata = (CDATASection) node;
					data.append(cdata.getData());
					node = node.getNextSibling();
					containsValidData = true;
				} while (node != null
						&& node.getNodeType() == Node.CDATA_SECTION_NODE);
				break;
			}
			node = node.getNextSibling();
		}

		if (!containsValidData) {
			for (int i = 0; i < data.length(); i++) {
				char charData = data.charAt(i);
				if (charData == '\n' || Character.isWhitespace(charData)) {
				}//ignore
				else { //valid data
					containsValidData = true;
					break;
				}
			}
		}

		return containsValidData ? data.toString() : null;
	}

	/**
	 * Override the XML element token.
	 */
	@Override
	public QName getElementType() {
		if (elementType == null)
			elementType = new QName(MessagepropertiesConstants.NAMESPACE,
					MessagepropertiesConstants.QUERY_ELEMENT_TAG);
		return elementType;
	}

	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7107
	// the Expression interface methods
	public Object getBody() {
		return getValue();
	}

	public void setBody(Object value) {
		setValue(value.toString());
	}

	public String getExpressionLanguage() {
		return getQueryLanguage();
	}

	public void setExpressionLanguage(String value) {
		setQueryLanguage(value);
	}

	public void unsetExpressionLanguage() {
		setQueryLanguage(null);
	}

	public boolean isSetExpressionLanguage() {
		return getQueryLanguage() != null;
	}

	public Boolean getOpaque() {
		return null;
	}

	public void setOpaque(Boolean value) {
	}

	public void unsetOpaque() {
	}

	public boolean isSetOpaque() {
		return false;
	}

} //QueryImpl
