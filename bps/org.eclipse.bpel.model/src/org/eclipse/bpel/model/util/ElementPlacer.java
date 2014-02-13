/*******************************************************************************
 * Copyright (c) 2007 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dennis Ushakov, Intel - Initial API and Implementation
 *    Oleg Danilov, Intel
 *
 *******************************************************************************/

package org.eclipse.bpel.model.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.wst.wsdl.WSDLElement;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class ElementPlacer {
	private static HashMap<String, List<String>> mapper = new HashMap<String, List<String>>();
	private static final String ACTIVITY = "activity";

	static {
		// TODO: (DU) add other activities
		// Process
		String processElements[] = { BPELConstants.ND_EXTENSIONS,
				BPELConstants.ND_IMPORT, BPELConstants.ND_PARTNER_LINKS,
				BPELConstants.ND_MESSAGE_EXCHANGES, BPELConstants.ND_VARIABLES,
				BPELConstants.ND_CORRELATION_SETS,
				BPELConstants.ND_FAULT_HANDLERS,
				BPELConstants.ND_EVENT_HANDLERS, ACTIVITY };
		mapper.put(BPELConstants.ND_PROCESS, Arrays.asList(processElements));
		// FaultHandlers
		String faultHandlersElements[] = { BPELConstants.ND_CATCH,
				BPELConstants.ND_CATCH_ALL };
		mapper.put(BPELConstants.ND_FAULT_HANDLERS, Arrays
				.asList(faultHandlersElements));
		// EventHandlers
		String eventHandlersElements[] = { BPELConstants.ND_ON_EVENT,
				BPELConstants.ND_ON_ALARM };
		mapper.put(BPELConstants.ND_EVENT_HANDLERS, Arrays
				.asList(eventHandlersElements));
		// Invoke
		String invokeElements[] = { BPELConstants.ND_CORRELATIONS,
				BPELConstants.ND_CATCH, BPELConstants.ND_CATCH_ALL,
				BPELConstants.ND_COMPENSATION_HANDLER,
				BPELConstants.ND_TO_PARTS, BPELConstants.ND_FROM_PARTS };
		mapper.put(BPELConstants.ND_INVOKE, Arrays.asList(invokeElements));
		// While
		String whileElements[] = { BPELConstants.ND_CONDITION, ACTIVITY };
		mapper.put(BPELConstants.ND_WHILE, Arrays.asList(whileElements));
		// ForEach
		String forEachElements[] = { BPELConstants.ND_START_COUNTER_VALUE,
				BPELConstants.ND_FINAL_COUNTER_VALUE,
				BPELConstants.ND_COMPLETION_CONDITION, ACTIVITY };
		mapper.put(BPELConstants.ND_FOR_EACH, Arrays.asList(forEachElements));
		// RepeatUntil
		String repeatElements[] = { ACTIVITY, BPELConstants.ND_CONDITION };
		mapper
				.put(BPELConstants.ND_REPEAT_UNTIL, Arrays
						.asList(repeatElements));
		// If
		String ifElements[] = { BPELConstants.ND_CONDITION, ACTIVITY,
				BPELConstants.ND_ELSEIF, BPELConstants.ND_ELSE };
		mapper.put(BPELConstants.ND_IF, Arrays.asList(ifElements));
		// ElseIf
		String elseIfElements[] = { BPELConstants.ND_CONDITION, ACTIVITY };
		mapper.put(BPELConstants.ND_ELSEIF, Arrays.asList(elseIfElements));
	}

	public static void placeChild(WSDLElement parent, Node child) {
		Element parentElement = parent.getElement();
		
		if (parent instanceof ExtensionActivity){
			parentElement = ReconciliationHelper.getExtensionActivityChildElement(parentElement);
		}
		
		List<String> nodeTypeList = mapper.get(parentElement.getLocalName());
		if (nodeTypeList != null) {
			String nodeName = child.getLocalName();
			String nodeType = findType(nodeName, nodeTypeList);
			if (nodeType != null) {
				Node beforeElement = parentElement.getFirstChild();
				while (beforeElement != null
						&& (!isPreviousType(nodeType, findType(beforeElement
								.getLocalName(), nodeTypeList), nodeTypeList) || beforeElement
								.getNodeType() != Node.ELEMENT_NODE)) {
					beforeElement = beforeElement.getNextSibling();
				}
				while (beforeElement != null
						&& (isType(beforeElement.getLocalName(), nodeType) || beforeElement
								.getNodeType() != Node.ELEMENT_NODE)) {
					beforeElement = beforeElement.getNextSibling();
				}
				ElementPlacer.niceInsertBefore(parent, child, beforeElement);
				return;
			}
		}
		ElementPlacer.niceAppend(parent, child);
	}

	private static String findType(String nodeName, List<String> nodeTypeList) {
		for (String nodeType : nodeTypeList) {
			if (isType(nodeName, nodeType)) {
				return nodeType;
			}
		}
		return null;
	}

	private static boolean isPreviousType(String typeName1, String typeName2,
			List<String> nodeTypeList) {
		int type1Index = nodeTypeList.indexOf(typeName1);
		int type2Index = nodeTypeList.indexOf(typeName2);
		return type1Index < type2Index || (type2Index < 0 && type1Index >= 0);
	}

	private static boolean isType(String nodeName, String typeName) {
		return ACTIVITY.equals(typeName) ? isActivity(nodeName) : typeName
				.equals(nodeName);
	}

	private static boolean isActivity(String nodeName) {
		return BPELConstants.ND_ASSIGN.equals(nodeName)
				|| BPELConstants.ND_COMPENSATE.equals(nodeName)
				|| BPELConstants.ND_COMPENSATE_SCOPE.equals(nodeName)
				|| BPELConstants.ND_EMPTY.equals(nodeName)
				|| BPELConstants.ND_EXIT.equals(nodeName)
				|| BPELConstants.ND_EXTENSION_ACTIVITY.equals(nodeName)
				|| BPELConstants.ND_FLOW.equals(nodeName)
				|| BPELConstants.ND_FOR_EACH.equals(nodeName)
				|| BPELConstants.ND_IF.equals(nodeName)
				|| BPELConstants.ND_INVOKE.equals(nodeName)
				|| BPELConstants.ND_PICK.equals(nodeName)
				|| BPELConstants.ND_RECEIVE.equals(nodeName)
				|| BPELConstants.ND_REPEAT_UNTIL.equals(nodeName)
				|| BPELConstants.ND_REPLY.equals(nodeName)
				|| BPELConstants.ND_RETHROW.equals(nodeName)
				|| BPELConstants.ND_SCOPE.equals(nodeName)
				|| BPELConstants.ND_SEQUENCE.equals(nodeName)
				|| BPELConstants.ND_THROW.equals(nodeName)
				|| BPELConstants.ND_VALIDATE.equals(nodeName)
				|| BPELConstants.ND_WAIT.equals(nodeName)
				|| BPELConstants.ND_WHILE.equals(nodeName)
				|| BPELConstants.ND_OPAQUEACTIVITY.equals(nodeName);
	}

	public static void niceInsertBefore(WSDLElement parent, Node newChild,
			Node referenceChild) {
		boolean was = ReconciliationHelper.isUpdatingDom(parent);
		Element parentElement = parent.getElement();
		
		if (parent instanceof ExtensionActivity){
			parentElement = ReconciliationHelper.getExtensionActivityChildElement(parentElement);
		}
		
		ReconciliationHelper.setUpdatingDom(parent, true);
		Node child = (referenceChild == null) ? parentElement.getLastChild()
				: referenceChild.getPreviousSibling();

		// DO: parentElement has no children ( <tag /> )
		if (child == null) {
			StringBuffer indent = new StringBuffer();
			for (Node ancestor = parentElement.getParentNode(); ancestor != null
					&& ancestor.getNodeType() != Node.DOCUMENT_NODE; ancestor = ancestor
					.getParentNode()) {
				indent.append("    ");
			}
			Text text = parentElement.getOwnerDocument().createTextNode(
					"\n" + indent + "    ");
			parentElement.insertBefore(text, referenceChild);
			text = parentElement.getOwnerDocument().createTextNode(
					"\n" + indent);
			referenceChild = parentElement.insertBefore(text, referenceChild);
			parentElement.insertBefore(newChild, referenceChild);
			return;
		}

		while (child != null) {
			short nodeType = child.getNodeType();
			if (nodeType == Node.ELEMENT_NODE)
				break;
			if (nodeType != Node.TEXT_NODE) {
				child = child.getPreviousSibling();
				continue;
			}

			Text text = (Text) child;
			String data = text.getData();
			int index = data.lastIndexOf('\n');
			if (index == -1) {
				child = child.getPreviousSibling();
				continue;
			}

			StringBuffer indent = new StringBuffer();
			for (Node ancestor = parentElement.getParentNode(); ancestor != null
					&& ancestor.getNodeType() != Node.DOCUMENT_NODE; ancestor = ancestor
					.getParentNode()) {
				indent.append("    ");
			}
			if (index + 1 < data.length() && data.charAt(index + 1) == '\r') {
				index++;
			}
			text.replaceData(index + 1, data.length() - index - 1, indent
					+ "    ");

			// DO:
			// Format children of the newChild.
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=335458
			// traverse the child's descendants also, inserting the
			// proper indentation for each
			StringBuffer childIndent = new StringBuffer(indent);
			Node nextNewChild = newChild;
			Node innerChild = newChild.getFirstChild();
			while (innerChild != null) {
				// add "\n" + indent before every child
				Node nextInnerChild = innerChild;
				while (nextInnerChild != null) {
					boolean textNodeIsWhitespaceOnly = false;
					if (nextInnerChild instanceof Text) {
						String content = ((Text)nextInnerChild).getData();
						textNodeIsWhitespaceOnly = (content==null || content.trim().isEmpty());
					}
					if (textNodeIsWhitespaceOnly) {
						// remove an old indentation
						nextNewChild.removeChild(nextInnerChild);
					} else {
						nextNewChild.insertBefore(nextNewChild.getOwnerDocument()
								.createTextNode("\n" + childIndent + "        "),
								nextInnerChild);
					}
					nextInnerChild = nextInnerChild.getNextSibling();
				}
				// add "\n" after the last child
				nextNewChild.appendChild(nextNewChild.getOwnerDocument()
						.createTextNode("\n" + childIndent + "    "));
				childIndent.append("    ");
				nextNewChild = innerChild;
				innerChild = innerChild.getFirstChild();
			}

			if (referenceChild != null) {
				indent.append("    ");
			}
			text = parentElement.getOwnerDocument().createTextNode(
					"\n" + indent);
			parentElement.insertBefore(text, referenceChild);
			referenceChild = text;
			break;
		}

		parentElement.insertBefore(newChild, referenceChild);
		ReconciliationHelper.setUpdatingDom(parent, was);
	}

	public static void niceAppend(WSDLElement parent, Node child) {
		niceInsertBefore(parent, child, null);
	}

	public static void niceRemoveChild(WSDLElement parent, Node child) {
		boolean was = ReconciliationHelper.isUpdatingDom(parent);
		ReconciliationHelper.setUpdatingDom(parent, true);

		
		Element parseElement = parent.getElement();

		if (parent instanceof ExtensionActivity) {
			parseElement = ReconciliationHelper.getExtensionActivityChildElement(parseElement);
		}
		
		boolean done = false;

		Node previous = child.getPreviousSibling();
		if (previous != null && previous.getNodeType() == Node.TEXT_NODE) {
			Text text = (Text) previous;
			String data = text.getData();
			int index = data.lastIndexOf('\n');
			if (index != -1) {
				if (index - 1 > 0 && data.charAt(index - 1) == '\r') {
					text.deleteData(index - 1, data.length() - index + 1);
				} else {
					text.deleteData(index, data.length() - index);
				}
				done = true;
			}
		}

		if (!done) {
			for (Node next = child.getNextSibling(); next != null; next = next
					.getNextSibling()) {
				if (next.getNodeType() == Node.TEXT_NODE) {
					Text text = (Text) next;
					String data = text.getData();
					int index = data.indexOf('\n');
					if (index != -1) {
						if (index + 1 < data.length()
								&& data.charAt(index + 1) == '\r') {
							text.deleteData(0, index + 2);
						} else {
							text.deleteData(0, index + 1);
						}
						break;
					}
					continue;
				}

				if (next.getNodeType() == Node.ELEMENT_NODE) {
					break;
				}
			}
		}

		parseElement.removeChild(child);
		ReconciliationHelper.setUpdatingDom(parent, was);
	}
}
