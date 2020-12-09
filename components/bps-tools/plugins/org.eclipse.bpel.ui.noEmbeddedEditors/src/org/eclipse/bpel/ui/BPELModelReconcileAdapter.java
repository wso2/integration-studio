/*******************************************************************************
 * Copyright (c) 2008, 2012 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dennis Ushakov, Intel
 *    Oleg Danilov, Intel
 *
 *******************************************************************************/

package org.eclipse.bpel.ui;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.impl.BPELExtensibilityElementImpl;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.util.BPELEditorUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.sse.core.internal.provisional.INodeNotifier;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.wsdl.internal.impl.WSDLElementImpl;
import org.eclipse.wst.wsdl.internal.impl.XSDSchemaExtensibilityElementImpl;
import org.eclipse.wst.xsd.ui.internal.util.ModelReconcileAdapter;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.impl.XSDSchemaImpl;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

class BPELModelReconcileAdapter extends ModelReconcileAdapter {
	protected Process process;
	protected Resource bpelResource;
	private BPELEditor fEditor;

	public BPELModelReconcileAdapter(Document document, Process process,
			Resource bpelResource, BPELEditor editor) {
		super(document);
		this.process = process;
		this.bpelResource = bpelResource;
		this.fEditor = editor;
	}

	// This method is clever enough to deal with 'bad' documents that happen
	// to have more than one root element. It picks of the first 'matching'
	// element.
	private Element getProcessElement(Document document) {
		Element processElement = null;
		for (Node node = document.getFirstChild(); node != null; node = node
				.getNextSibling()) {
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (BPELEditorUtil.getInstance().getBPELType(element).equals(
						BPELConstants.ND_PROCESS)) {
					processElement = element;
					break;
				}
			}
		}
		return processElement;
	}

	@Override
	protected void handleNodeChanged(Node node) {
		if (node instanceof Element
				&& !BPELConstants.ND_LITERAL.equals(node.getLocalName())) {
			reconcileModelObjectForElement((Element) node);
		} else if (node instanceof Document) {
			Document document = (Document) node;
			Element processElement = getProcessElement(document);
			if (processElement != null
					&& process.getElement() != processElement) {
				process.setElement(processElement);
			} else if (processElement != null) {
				process.elementChanged(processElement);
			} else {
				process.setPartnerLinks(null);
				process.setVariables(null);
				process.setCorrelationSets(null);
				process.setActivity(null);
				process.setDocumentation(null);
				process.setName(null);
				process.setTargetNamespace(null);
				process.unsetQueryLanguage();
				process.unsetExpressionLanguage();
				process.unsetSuppressJoinFailure();
				process.unsetVariableAccessSerializable();
				process.unsetAbstractProcessProfile();
				process.setFaultHandlers(null);
				process.setExtensions(null);
				process.setExitOnStandardFault(false);
				process.setMessageExchanges(null);
				process.setEventHandlers(null);
				if (processElement != null) {
					process.setElement(processElement);
					process.elementChanged(processElement);
				}
			}
		} else if (node.getNodeType() == Node.CDATA_SECTION_NODE
				|| BPELConstants.ND_LITERAL.equals(node.getLocalName())) {
			reconcileModelObjectForElement((Element) node.getParentNode());
		}
	}

	private void reconcileModelObjectForElement(Element elementCandidate) {
		Object modelObjectCandidate = BPELEditorUtil.getInstance()
				.findModelObjectForElement(process, elementCandidate);

		// Get out of possible nested XML within the literal
		while (modelObjectCandidate == null
				&& elementCandidate.getParentNode() != null) {
			elementCandidate = (Element) elementCandidate.getParentNode();
			modelObjectCandidate = BPELEditorUtil.getInstance()
					.findModelObjectForElement(process, elementCandidate);
		}

		// Wrap changes in source tab to the Command
		if (modelObjectCandidate != null) {
			final Object modelObject = modelObjectCandidate;
			final Element element = elementCandidate;
//			UpdateModelCommand cmd = new UpdateModelCommand(
//					(EObject) modelObject, "Change text") {
//				@SuppressWarnings("restriction")
//				@Override
//				public void doExecute() {
					if (modelObject instanceof BPELExtensibleElement) {
						((BPELExtensibleElement) modelObject)
								.elementChanged(element);
						// https://jira.jboss.org/browse/JBIDE-7497
						// Bugzilla 330519
						this.fEditor.getMultipageEditor().updateMarkers((BPELExtensibleElement)modelObject);
					} else if (modelObject instanceof BPELExtensibilityElementImpl) {
						((BPELExtensibilityElementImpl) modelObject)
								.elementChanged(element);
					} else if (modelObject instanceof XSDSchemaExtensibilityElementImpl) {
						XSDSchemaExtensibilityElementImpl ee = (XSDSchemaExtensibilityElementImpl) modelObject;
						((XSDSchemaImpl) ee.getSchema())
								.elementChanged(element);
						ee.elementChanged(element);
					} else if (modelObject instanceof WSDLElementImpl) {
						((WSDLElementImpl) modelObject).elementChanged(element);
					} else if (modelObject instanceof XSDConcreteComponent) {
						((XSDConcreteComponent) modelObject)
								.elementChanged(element);
					}
//				}
//			};

//			fEditor.getCommandFramework().execute(cmd);
		}
	}

	@Override
	public void modelDirtyStateChanged(IStructuredModel model, boolean isDirty) {
		if (!isDirty) {
			// cs : At this time (when a save occurs) it's a good opportunity
			// to update the model to ensure it's in sync with the source.
			// That way if the incremental sync between DOM and model has gotten
			// the model out of whack we'll be able to put things right at this
			// point.
			//   
			// TODO (cs) need to do more to ensure model is sync'd up properly

			// FIXME uncomment
			// ((ProcessImpl)process).reconcileReferences(true);
		}
	}

	@Override
	public void handleNotifyChange(INodeNotifier notifier, int eventType,
			final Object feature, final Object oldValue, final Object newValue,
			int index) {
		final Node node = (Node) notifier;
		switch (eventType) {
		case INodeNotifier.ADD: {
			if (newValue instanceof Element) {
				Element element = (Element) newValue;
				adapt(element);
			}
			break;
		}
		case INodeNotifier.REMOVE: {
			break;
		}
		case INodeNotifier.CHANGE:
		case INodeNotifier.STRUCTURE_CHANGED: {
			if (feature instanceof Attr
					&& XSDConstants.XMLNS_URI_2000.equals(((Attr) feature)
							.getNamespaceURI())) {
				final Attr attr = (Attr) feature;
				final EObject modelObject = (EObject) BPELEditorUtil
						.getInstance().findModelObjectForElement(process,
								(Element) node);
				final INamespaceMap<String, String> objectMap = BPELUtils
						.getNamespaceMap(modelObject);
//				UpdateModelCommand cmd = new UpdateModelCommand(modelObject,
//						"Change text") {
//					@SuppressWarnings("restriction")
//					@Override
//					public void doExecute() {
						if (newValue == null) {
							objectMap.remove(BPELUtils.getNSPrefixMapKey(attr
									.getLocalName()));
						} else {
							objectMap.put(BPELUtils.getNSPrefixMapKey(attr
									.getLocalName()), attr.getValue());
						}
//					}
//				};
//				if (fEditor != null) {
//					fEditor.getCommandFramework().execute(cmd);
//				}
				// We should continue reconciling only if BPEL namespace has
				// been changed
				// otherwise we should not update children
				if (!BPELConstants.NAMESPACE.equals(attr.getValue()))
					break;
			}
			handleNodeChanged(node);
			break;
		}
		case INodeNotifier.CONTENT_CHANGED: {
			handleNodeChanged(node);
			break;
		}
		}
	}
}
