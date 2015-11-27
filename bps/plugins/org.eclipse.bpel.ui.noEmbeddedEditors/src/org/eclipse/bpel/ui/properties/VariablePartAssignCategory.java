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

import java.util.ArrayList;
import java.util.Collections;

import javax.xml.namespace.QName;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.XSD2XMLGenerator;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide;
import org.eclipse.bpel.ui.commands.InsertCopyCommand;
import org.eclipse.bpel.ui.details.providers.ModelTreeLabelProvider;
import org.eclipse.bpel.ui.details.providers.VariableTreeContentProvider;
import org.eclipse.bpel.ui.details.tree.ITreeNode;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.impl.XSDTypeDefinitionImpl;

/**
 * An AssignCategory presenting a tree from which the user can select any of: -
 * a Variable - a Part within a Variable - some XSD element within a Part within
 * a Variable.
 * 
 */

public class VariablePartAssignCategory extends AssignCategoryBase {

	Label fNameLabel;
	Text fNameText;
	Tree fVariableTree;

	TreeViewer fVariableViewer;

	VariableTreeContentProvider variableContentProvider;
	Shell shell;

	protected VariablePartAssignCategory(BPELPropertySection anOwnerSection) {
		super(anOwnerSection);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getName()
	 */
	@Override
	public String getName() {
		return Messages.VariablePartAssignCategory_Variable_or_Part_1;
	}

	protected boolean isPropertyTree() {
		return false;
	}

	/**
	 * This is for XPath specific queries.
	 * 
	 * TODO: Need to somehow externalized this for for non-XPath languages.
	 */

	@SuppressWarnings("nls")
	protected void updateQueryFieldFromTreeSelection() {

		if (displayQuery() == false || fChangeHelper.isNonUserChange()
				|| this.fModelObject == null || fModelObject.eContainer()==null) {
			return;
		}

		IStructuredSelection sel = (IStructuredSelection) fVariableViewer
				.getSelection();
		Object[] path = variableContentProvider.getPathToRoot(sel
				.getFirstElement());

		StringBuilder builder = new StringBuilder();
		ArrayList<String> querySegments = new ArrayList<String>();

		for (Object next : path) {

			Object eObj = BPELUtil.resolveXSDObject(BPELUtil.adapt(next,
					ITreeNode.class).getModelObject());
			builder.setLength(0);

			String targetNamespace = null;
			String namespacePrefix = null;

			if (eObj instanceof XSDAttributeDeclaration) {

				XSDAttributeDeclaration att = (XSDAttributeDeclaration) eObj;
				targetNamespace = att.getTargetNamespace();
				builder.append("/@");

				if (targetNamespace != null) {

					namespacePrefix = BPELUtil.lookupOrCreateNamespacePrefix(
							fModelObject, targetNamespace, "xsd", shell);
					if (namespacePrefix == null) {
						break;
					}

					builder.append(namespacePrefix).append(":");
				}
				builder.append(att.getName());

			} else if (eObj instanceof XSDElementDeclaration) {

				XSDElementDeclaration elm = (XSDElementDeclaration) eObj;
				targetNamespace = elm.getTargetNamespace();
				int maxOccurs = XSDUtils.getMaxOccurs(elm);

				builder.append("/");
				if (targetNamespace != null) {
					namespacePrefix = BPELUtil.lookupOrCreateNamespacePrefix(
							fModelObject, targetNamespace, "xsd", shell);
					if (namespacePrefix == null) {
						break;
					}
					builder.append(namespacePrefix).append(":");
				}

				builder.append(elm.getName());
				// Unbounded or bounded by something higher then 1.
				if (maxOccurs != 1) {
					builder.append("[1]");
				}
			}

			// If the current builder has length > 0, then there is a query
			// segment for us to put in.
			if (builder.length() > 0) {
				querySegments.add(builder.toString());
			}
		}

		Collections.reverse(querySegments);
		builder.setLength(0);
		for (String s : querySegments) {
			builder.append(s);
		}

		if (builder.length() > 0) {
			builder.deleteCharAt(0);
		}

		try {
			fChangeHelper.startNonUserChange();

			fNameText.setText(builder.toString());
			fNameText.setEnabled(true);
			fNameLabel.setEnabled(true);

		} finally {
			fChangeHelper.finishNonUserChange();
		}
	}

	@Override
	protected void createClient2(Composite parent) {

		FlatFormData data;

		fVariableTree = fWidgetFactory
				.createTree(parent, SWT.NONE /* SWT.BORDER */);

		if (displayQuery()) {
			// area for query string and wizard button
			fNameLabel = fWidgetFactory.createLabel(parent,
					Messages.VariablePartAssignCategory_Query__8);
			fNameText = fWidgetFactory.createText(parent, ""); //$NON-NLS-1$
			data = new FlatFormData();
			data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
					fNameText, STANDARD_LABEL_WIDTH_SM));
			data.right = new FlatFormAttachment(100,
					-IDetailsAreaConstants.HSPACE);
			data.bottom = new FlatFormAttachment(100, 0);

			data.top = new FlatFormAttachment(100, (-1)
					* (fNameText.getLineHeight() + 4 * fNameText
							.getBorderWidth()) - IDetailsAreaConstants.VSPACE);
			fNameText.setLayoutData(data);

			fChangeHelper.startListeningTo(fNameText);
			fChangeHelper.startListeningForEnter(fNameText);

			data = new FlatFormData();
			data.left = new FlatFormAttachment(0, 0);
			data.right = new FlatFormAttachment(fNameText,
					-IDetailsAreaConstants.HSPACE);
			data.top = new FlatFormAttachment(fNameText, 0, SWT.CENTER);
			fNameLabel.setLayoutData(data);
		}

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		if (displayQuery()) {
			data.bottom = new FlatFormAttachment(fNameText,
					-IDetailsAreaConstants.VSPACE, SWT.TOP);
		} else {
			data.bottom = new FlatFormAttachment(100, 0);
		}

		// data.borderType = IBorderConstants.BORDER_2P2_BLACK;
		fVariableTree.setLayoutData(data);

		variableContentProvider = new VariableTreeContentProvider(true,
				isPropertyTree(), displayQuery());
		fVariableViewer = new TreeViewer(fVariableTree);
		fVariableViewer.setContentProvider(variableContentProvider);
		fVariableViewer.setLabelProvider(new ModelTreeLabelProvider());
		// TODO: does this sorter work at the top level? does it affect nested
		// levels too?
		// variableViewer.setSorter(ModelViewerSorter.getInstance());
		fVariableViewer.setInput(fOwnerSection.getModel());

		fVariableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						updateQueryFieldFromTreeSelection();
					}
				});

		fChangeHelper.startListeningTo(fVariableTree);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */

	@Override
	public boolean isCategoryForModel(EObject aModel) {

		if (aModel == null) {
			return false;
		}
		IVirtualCopyRuleSide side = BPELUtil.adapt(aModel,
				IVirtualCopyRuleSide.class);
		if (side == null) {
			return false;
		}
		return side.getVariable() != null
				&& (side.getProperty() != null) == isPropertyTree();
	}

	@SuppressWarnings("nls")
	@Override
	protected void load(IVirtualCopyRuleSide side) {

		fChangeHelper.startNonUserChange();
		try {
			fVariableViewer.setSelection(StructuredSelection.EMPTY, false);
			if (displayQuery()) {
				fNameText.setText(EMPTY_STRING);
				fNameText.setEnabled(true);
				fNameLabel.setEnabled(true);
			}
		} finally {
			fChangeHelper.finishNonUserChange();
		}

		ArrayList<ITreeNode> pathToNode = new ArrayList<ITreeNode>();
		ITreeNode node = null;

		// First, find the variable node.
		Object context = side.getVariable();
		if (context != null) {

			Object[] items = variableContentProvider
					.getElements(fVariableViewer.getInput());
			node = variableContentProvider.findModelNode(items, context, 0);
			if (node != null) {
				pathToNode.add(node);
			}
		}

		// Find the part (or property) node within the container node.
		if (isPropertyTree()) {
			context = side.getProperty();
		} else {
			context = side.getPart();
		}

		if (node != null && context != null) {
			Object[] items = variableContentProvider.getChildren(node);
			node = variableContentProvider.findModelNode(items, context,
					variableContentProvider.isCondensed() ? 0 : 1);
			if (node != null) {
				pathToNode.add(node);
			}
		}

		if (context == null) {
			context = side.getVariable();
		}

		String query = null;

		if (node != null && context != null) {

			Query queryObject = side.getQuery();
			if (queryObject != null) {
				// TODO: we shouldn't ignore the queryLanguage here!!
				query = queryObject.getValue();
			}

			if (query != null && !query.equals(EMPTY_STRING)) {

				int tokenCount = 0;
				outer: for (String token : query.split("\\/")) {
					tokenCount += 1;
					if (token.length() == 0) {
						// Is it the first empty string preceeding the first /
						if (tokenCount == 1) {
							continue;
						}
						// could be // , as in //foo:bar/bar, which is
						// impossible to show here.
						break outer;
					}

					QueryStep step = new QueryStep(token);
					step.updateNamespaceURI(this.fModelObject);

					if (step.fAxis.equals("child") == false) {
						break outer;
					}

					Object[] items = variableContentProvider.getChildren(node);

					inner: for (Object item : items) {

						Object originalMatch = ((ITreeNode) item)
								.getModelObject();
						Object match = BPELUtil.resolveXSDObject(originalMatch);

						if (match instanceof XSDElementDeclaration) {
							XSDElementDeclaration elmDecl = (XSDElementDeclaration) match;

							if (match(step, elmDecl) == false) {
								continue;
							}
							node = variableContentProvider.findModelNode(items,
									originalMatch, 0);
							// no matching node, we are done
							if (node == null) {
								break outer;
							}
							pathToNode.add(node);
							break inner;

						} else if (match instanceof XSDAttributeDeclaration) {

							XSDAttributeDeclaration attrDecl = (XSDAttributeDeclaration) match;
							if (match(step, attrDecl)) {
								node = variableContentProvider.findModelNode(
										items, originalMatch, 0);
								if (node != null) {
									pathToNode.add(node);
								}
							}
							// attribute is the leaf node
							break outer;
						}
					}
				}
			}
		}

		if (pathToNode.size() > 0) {
			node = pathToNode.get(pathToNode.size() - 1);
		}

		if (node != null) {

			fChangeHelper.startNonUserChange();
			try {
				if (displayQuery()) {
					fNameText.setText(query == null ? EMPTY_STRING : query);
				}
				fVariableViewer.expandToLevel(node, 0);
				fVariableViewer.setSelection(new StructuredSelection(node),
						true);
			} finally {
				fChangeHelper.finishNonUserChange();
			}

		}
	}

	boolean match(QueryStep step, XSDNamedComponent xsdNamed) {
		// local name
		if (step.fLocalPart.equals(xsdNamed.getName()) == false) {
			return false;
		}

		// namespace
		return (step.fNamespaceURI.equals(xsdNamed.getTargetNamespace()) || (step.fNamespaceURI
				.equals(EMPTY_STRING) && xsdNamed.getTargetNamespace() == null));
	}

	@Override
	protected void store(IVirtualCopyRuleSide side) {
		IStructuredSelection sel = (IStructuredSelection) fVariableViewer
				.getSelection();

		Object[] path = variableContentProvider.getPathToRoot(sel
				.getFirstElement());
		String query = displayQuery() ? fNameText.getText() : EMPTY_STRING;

		side.setVariable(null);
		side.setPart(null);
		side.setProperty(null);
		side.setQuery(null);

		for (Object n : path) {
			ITreeNode treeNode = BPELUtil.adapt(n, ITreeNode.class);

			Object model = treeNode.getModelObject();
			if (model instanceof Variable) {
				side.setVariable((Variable) model);
			}
			if (model instanceof Part) {
				side.setPart((Part) model);
			}
			if (model instanceof Property) {
				side.setProperty((Property) model);
			}
		}

		query = query.trim();
		if (displayQuery() && query.length() > 0) {
			Query queryObject = BPELFactory.eINSTANCE.createQuery();
			queryObject
					.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
			queryObject.setValue(query);
			side.setQuery(queryObject);
		} else {
			side.setQuery(null);
		}

		// https://jira.jboss.org/browse/JBIDE-7351
		// TODO: Think about how to implement this in a way that makes sense...
		// currently, a popup dialog asks the user to initialize variables whenever
		// focus changes - this makes for a bad user experience!
		// From?
		if (side.isSource())
			return;

		// if initializer doesn't exist and query != null then we should
		// generate it
		if (query == null)
			return;
		Variable var = side.getVariable();
		if (needInitializer(var, side)) {
			if (MessageDialog
					.openQuestion(
							PlatformUI.getWorkbench().getActiveWorkbenchWindow()
									.getShell(),
							"Initializer",
							NLS
									.bind(
											"Variable {0} doesn't have initializer. Should it be generated?",
											(new Object[] { var.getName() })))) {
				initTargetVariable(var, side);
			}
		}
	}

	private boolean needInitializer(Variable var, IVirtualCopyRuleSide side) {
		Assign a = (Assign) ((To) side.getCopyRuleSide()).getContainer()
				.getContainer();
		EList<Copy> list = a.getCopy();
		for (Copy copy : list) {
			if (copy.getFrom().getLiteral() == null)
				continue;
			To to = copy.getTo();
			Variable v = to.getVariable();
			if (v == null)
				continue;
			if (!v.equals(var))
				continue;
			Part p = to.getPart();
			if (p == null)
				continue;
			if (p.equals(side.getPart()))
				return false;
		}
		
		// https://issues.jboss.org/browse/JBIDE-8048
		// check if initialization is possible: this is not possible if the
		// variable is implicit (e.g. in a ForEach or OnEvent)
		String rootElement = null;
		String uriWSDL = null;

		// Variable is defined using "messageType"
		Message msg = var.getMessageType();
		if (msg != null && !msg.eIsProxy()) {
			// https://jira.jboss.org/browse/JBIDE-6697
			// from eclipse.org/bpel rev 1.17 on 7/23/2010 3:13AM bugzilla 302943 by gqian: apply the patch from bugzilla
			if (side.getPart() != null) {
				XSDElementDeclaration declaration = side.getPart().getElementDeclaration();
				if (declaration != null) {
					uriWSDL = declaration.getSchema().getSchemaLocation();
					rootElement = declaration.getName();
				}
			}
		}

		// can we construct an initializer for this variable?
		// Variable is defined using "type"
		XSDTypeDefinitionImpl type = (XSDTypeDefinitionImpl)var.getType();
		if (type != null && !type.eIsProxy()) {
			QName qname = new QName(type.getTargetNamespace(), type.getName());
			rootElement = qname.getLocalPart();
			uriWSDL = type.eResource().getURI().toString();
		}

		// Variable is defined using "element"
		XSDElementDeclaration element = var.getXSDElement();
		if (element != null && !element.eIsProxy()) {
			QName qname = new QName(element.getTargetNamespace(), element
					.getName());
			rootElement = qname.getLocalPart();
			uriWSDL = element.eResource().getURI().toString();
		}

		// Incomplete variable definition
		if (rootElement == null || uriWSDL == null) {
			return false;
		}
		
		return true;
	}

	private void initTargetVariable(Variable var, IVirtualCopyRuleSide side) {
		String rootElement = null;
		String uriWSDL = null;

		// Variable is defined using "messageType"
		Message msg = var.getMessageType();
		if (msg != null) {
			// https://jira.jboss.org/browse/JBIDE-6697
			// from eclipse.org/bpel rev 1.17 on 7/23/2010 3:13AM bugzilla 302943 by gqian: apply the patch from bugzilla
			if (side.getPart() != null) {
				XSDElementDeclaration declaration = side.getPart().getElementDeclaration();
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

		// Incomplete variable definition
		if (rootElement == null || uriWSDL == null) {
			return;
		}

		// https://jira.jboss.org/browse/JBIDE-7351
		// use the new and improved XSD -> XML generator
		// this was an internal class that was moved to org.eclipse.bpel.model.util
		XSD2XMLGenerator generator = new XSD2XMLGenerator(uriWSDL, rootElement);

		// be sure to tell the generator which elements in a "choice" we are interested in
		if (side.getQuery()!=null && side.getQuery().getValue().trim().length()>0)
			generator.setQueryPath(side.getQuery().getValue());

		try {
			String literal = generator.createXML();
			Copy copy = BPELFactory.eINSTANCE.createCopy();
			Assign a = (Assign) ((To) side.getCopyRuleSide()).getContainer()
					.getContainer();
			getCommandFramework()
			.execute(
					wrapInShowContextCommand(new InsertCopyCommand(a,
							copy, 0)));
			To to = BPELFactory.eINSTANCE.createTo();
			From from = BPELFactory.eINSTANCE.createFrom();
			from.setLiteral(literal);
			copy.setFrom(from);
			to.setVariable(side.getVariable());
			to.setPart(side.getPart());
			copy.setTo(to);
			fChangeHelper.startNonUserChange();
			fOwnerSection.basicSetInput(a);
			fChangeHelper.finishNonUserChange();
		} catch (Exception e) {
			throw new IllegalStateException(
					"Can't generate initializer, check WSDL file");
		}
	}

	@Override
	protected void basicSetInput(EObject newInput) {

		super.basicSetInput(newInput);

		/**
		 * During initialization of variable, the list of available variables
		 * must not include the current variable and the variables logically
		 * after. So we just alter the input to the variable viewer, if we are
		 * looking at a variable. In assign statement, where the model is Copy,
		 * this does not happen.
		 */

		EObject container = newInput.eContainer();
		if (container instanceof Variable) {

			fChangeHelper.startNonUserChange();
			try {
				fVariableViewer.setInput(container);
			} finally {
				fChangeHelper.finishNonUserChange();
			}
		}
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
	@Override
	public void restoreUserContext(Object userContext) {
		fVariableTree.setFocus();
	}

	private boolean displayQuery() {
		return !isPropertyTree();
	}

	/**
	 * Parse the query step into this object.
	 * 
	 * TODO: This has to be externalized someplace. We can't just assume it is
	 * XPath all the time ...
	 */

	@SuppressWarnings("nls")
	class QueryStep {

		String fAxis = "child";

		String fPrefix = EMPTY_STRING;
		String fLocalPart = EMPTY_STRING;
		String fNamespaceURI = EMPTY_STRING;

		@SuppressWarnings("nls")
		QueryStep(String step) {

			int axisMark = step.indexOf("::");
			if (axisMark >= 0) {
				fAxis = step.substring(0, axisMark);
				step = step.substring(axisMark + 2);
			}

			int qnameMark = step.indexOf(":");
			if (qnameMark < 0) {
				fLocalPart = step;
			} else {
				fLocalPart = step.substring(qnameMark + 1);
				fPrefix = step.substring(0, qnameMark);
			}

			if (fLocalPart.charAt(0) == '@') {
				fLocalPart = fLocalPart.substring(1);
			}

			int arrayMark1 = fLocalPart.indexOf('[');
			int arrayMark2 = fLocalPart.indexOf(']');
			if (arrayMark2 > arrayMark1 && arrayMark1 > 0) {
				fLocalPart = fLocalPart.substring(0, arrayMark1);
			}
		}

		void updateNamespaceURI(EObject eObj) {
			if (fPrefix.length() > 0) {
				fNamespaceURI = BPELUtils.getNamespace(eObj, fPrefix);
				if (fNamespaceURI == null) {
					fNamespaceURI = "urn:unresolved:"
							+ System.currentTimeMillis() + ":" + fPrefix;
				}
			} else {
				fNamespaceURI = EMPTY_STRING;
			}
		}

	}
}
