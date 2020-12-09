/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.ds.editor.contentassistant;

import org.eclipse.wst.xml.ui.internal.contentassist.ProposalComparator;
import org.eclipse.wst.xml.ui.internal.contentassist.XMLContentAssistProcessor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.wso2.developerstudio.eclipse.ds.data.DataserviceTemplate;
import org.wso2.developerstudio.eclipse.ds.editor.contentassistant.proposals.DataserviceAttributeNameCompletionProposal;
import org.wso2.developerstudio.eclipse.ds.editor.contentassistant.proposals.DataserviceTagCompletionProposal;
import org.wso2.developerstudio.eclipse.ds.model.DataserviceAttributeElement;
import org.wso2.developerstudio.eclipse.ds.model.DataserviceTagElement;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wst.xml.ui.internal.contentassist.ContentAssistRequest;

public class DataServiceContentAssistantProcessor extends XMLContentAssistProcessor {
	private static final ProposalComparator PROPOSAL_COMPARATOR = new ProposalComparator();

	private ISourceViewer sourceViewer;

	public DataServiceContentAssistantProcessor(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer;
	}

	protected void addTagNameProposals(ContentAssistRequest contentAssistRequest, int childPosition) {
		addTagInsertionProposals(contentAssistRequest, childPosition);
	}

	@SuppressWarnings("restriction")
	protected void addTagInsertionProposals(ContentAssistRequest contentAssistRequest,
	                                        int childPosition) {
		DataserviceTagElement currentDataserviceElement =
		                                                  getCurrentDataserviceElement(contentAssistRequest);
		if (currentDataserviceElement != null) {
			List<DataserviceTagElement> subElements = currentDataserviceElement.getSubElements();
			Node currentNode = getCurrentNode(contentAssistRequest);
			for (DataserviceTagElement element : subElements) {
				if (element.isUpperLimitUnbound() ||
				    getChildNodeCount(currentNode, element.getName()) < element.getMaxOccurances()) {
					contentAssistRequest.addProposal(getTagProposal(element));
				}
			}
		} else {
			super.addTagInsertionProposals(contentAssistRequest, childPosition);
		}
	}

	protected void addAttributeNameProposals(ContentAssistRequest contentAssistRequest) {
		DataserviceTagElement currentDataserviceElement =
		                                                  getCurrentDataserviceElement(contentAssistRequest);
		if (currentDataserviceElement != null) {
			List<DataserviceAttributeElement> attributes =
			                                               currentDataserviceElement.getAttributes();
			Node currentNode = getCurrentNode(contentAssistRequest);
			for (DataserviceAttributeElement element : attributes) {
				if (!isAttributePresent(currentNode, element.getName())) {
					contentAssistRequest.addProposal(getAttributeNameProposal(element));
				}
			}

		} else {
			super.addAttributeNameProposals(contentAssistRequest);
		}
	}

	protected void addAttributeValueProposals(ContentAssistRequest contentAssistRequest) {
		super.addAttributeValueProposals(contentAssistRequest);
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { '<' };
	}

	private DataserviceTagCompletionProposal getTagProposal(DataserviceTagElement element) {
		DataserviceTagCompletionProposal dataserviceCompletionProposal =
		                                                                 new DataserviceTagCompletionProposal(
		                                                                                                      element);
		return dataserviceCompletionProposal;
	}

	private DataserviceAttributeNameCompletionProposal getAttributeNameProposal(DataserviceAttributeElement element) {
		DataserviceAttributeNameCompletionProposal dataserviceCompletionProposal =
		                                                                           new DataserviceAttributeNameCompletionProposal(
		                                                                                                                          element);
		return dataserviceCompletionProposal;
	}

	private Node getCurrentNode(ContentAssistRequest contentAssistRequest) {
		Node currentNode = contentAssistRequest.getParent();
		if (currentNode instanceof Text) {
			currentNode = currentNode.getParentNode();
		}
		return currentNode;
	}

	private NodeList getChildrenForNode(Node currentNode) {
		return currentNode.getChildNodes();
	}

	private int getChildNodeCount(Node currentNode, String name) {
		NodeList childrenForCurrentNode = getChildrenForNode(currentNode);
		int count = 0;
		for (int i = 0; i < childrenForCurrentNode.getLength(); i++) {
			Node node = childrenForCurrentNode.item(i);
			if (!(node instanceof Text)) {
				if (node.getNodeName().equals(name)) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean isAttributePresent(Node currentNode, String name) {
		NamedNodeMap attributes = currentNode.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Node node = attributes.item(i);
			if (node.getNodeName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	private DataserviceTagElement getCurrentDataserviceElement(ContentAssistRequest contentAssistRequest) {
		List<String> path = new ArrayList<String>();
		Node currentNode = getCurrentNode(contentAssistRequest);
		while (currentNode != null) {
			if (!(currentNode instanceof Text) && currentNode.getOwnerDocument() != null) {
				path.add(currentNode.getNodeName());
			}
			currentNode = currentNode.getParentNode();
		}
		DataserviceTagElement rootElement = DataserviceTemplate.getRootElement();
		DataserviceTagElement currentElement = null;
		if (rootElement.getName().equals(path.get(path.size() - 1))) {
			currentElement = rootElement;
		} else {
			return null;
		}
		for (int i = path.size() - 2; i >= 0; i--) {
			String s = path.get(i);
			DataserviceTagElement subElement = currentElement.getSubElement(s);
			if (subElement == null) {
				return null;
			} else {
				currentElement = subElement;
			}

		}
		return currentElement;
	}

	// private void addProposals(ContentAssistRequest request,
	// PomTemplateContext context) {
	// if(request != null) {
	// ITextFileBuffer buf =
	// FileBuffers.getTextFileBufferManager().getTextFileBuffer(sourceViewer.getDocument());
	// IFileStore folder = buf.getFileStore();
	// File file = new File(folder.toURI());
	// IPath path = Path.fromOSString(file.getAbsolutePath());
	// IFile ifile =
	// ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
	// IProject prj = ifile != null ? ifile.getProject() : null;
	//
	// ICompletionProposal[] templateProposals = getTemplateProposals(prj,
	// sourceViewer,
	// request.getReplacementBeginPosition(), context.getContextTypeId(),
	// getCurrentNode(request));
	// for(ICompletionProposal proposal : templateProposals) {
	// if(request.shouldSeparate()) {
	// request.addMacro(proposal);
	// } else {
	// request.addProposal(proposal);
	// }
	// }
	// }
	// }
	//
	// private ICompletionProposal[] getTemplateProposals(IProject project,
	// ITextViewer viewer, int offset, String contextTypeId, Node currentNode) {
	// ITextSelection selection = (ITextSelection)
	// viewer.getSelectionProvider().getSelection();
	//
	// // adjust offset to end of normalized selection
	// if(selection.getOffset() == offset) {
	// offset = selection.getOffset() + selection.getLength();
	// }
	//
	// String prefix = extractPrefix(viewer, offset);
	// Region region = new Region(offset - prefix.length(), prefix.length());
	// TemplateContext context = createContext(viewer, region, contextTypeId);
	// if(context == null) {
	// return new ICompletionProposal[0];
	// }
	//
	// // name of the selection variables {line, word}_selection
	//	    context.setVariable("selection", selection.getText()); //$NON-NLS-1$
	//
	// PomTemplateContext templateContext =
	// PomTemplateContext.fromId(contextTypeId);
	// Image image = null;
	// switch(templateContext) {
	// case CONFIGURATION:
	// image = MvnImages.IMG_PARAMETER;
	// break;
	// case PLUGINS:
	// image = MvnImages.IMG_PLUGIN;
	// break;
	// case DEPENDENCIES:
	// image = MvnImages.IMG_JAR;
	// break;
	// case EXECUTIONS:
	// image = MvnImages.IMG_EXECUTION;
	// break;
	// case PROFILES:
	// image = MvnImages.IMG_PROFILE;
	// break;
	// case PROPERTIES:
	// image = MvnImages.IMG_PROPERTY;
	// break;
	// case REPOSITORIES:
	// image = MvnImages.IMG_REPOSITORY;
	// break;
	// }
	//
	// List<TemplateProposal> matches = new ArrayList<TemplateProposal>();
	// Template[] templates = templateContext.getTemplates(project, currentNode,
	// prefix);
	// for(final Template template : templates) {
	// try {
	// context.getContextType().validate(template.getPattern());
	// if(template.matches(prefix, context.getContextType().getId())) {
	// TemplateProposal proposal = new TemplateProposal(template, context,
	// region, image, getRelevance(template, prefix)) {
	// public String getAdditionalProposalInfo() {
	// return getTemplate().getDescription();
	// }
	//
	// public String getDisplayString() {
	// return template.getName();
	// }
	// };
	// matches.add(proposal);
	// }
	// } catch(TemplateException e) {
	// // ignore
	// }
	// }
	// if (templateContext!=PomTemplateContext.VERSION) {
	// // versions are already sorted with
	// o.a.m.artifact.versioning.ComparableVersion
	// Collections.sort(matches, PROPOSAL_COMPARATOR);
	// }
	//
	// return (ICompletionProposal[]) matches.toArray(new
	// ICompletionProposal[matches.size()]);
	//
	// }
	//
	// protected TemplateContext createContext(ITextViewer viewer, IRegion
	// region, String contextTypeId) {
	// TemplateContextType contextType= getContextType(viewer, region,
	// contextTypeId);
	// if (contextType != null) {
	// IDocument document= viewer.getDocument();
	// return new DocumentTemplateContext(contextType, document,
	// region.getOffset(), region.getLength());
	// }
	// return null;
	// }
	//
	// protected int getRelevance(Template template, String prefix) {
	// if (template.getName().startsWith(prefix))
	// return 90;
	// return 0;
	// }
	//
	// protected TemplateContextType getContextType(ITextViewer viewer, IRegion
	// region, String contextTypeId) {
	// ContextTypeRegistry registry =
	// MvnIndexPlugin.getDefault().getTemplateContextRegistry();
	// if(registry != null) {
	// return registry.getContextType(contextTypeId);
	// }
	// return null;
	// }

	public static final String extractPrefix(ITextViewer viewer, int offset) {
		int i = offset;
		IDocument document = viewer.getDocument();
		if (i > document.getLength()) {
			return ""; //$NON-NLS-1$
		}

		try {
			while (i > 0) {
				char ch = document.getChar(i - 1);
				if (ch == '>' || ch == '\n') {
					break;
				}
				i--;
			}
			return document.get(i, offset - i);
		} catch (BadLocationException e) {
			return ""; //$NON-NLS-1$
		}
	}

	static final class ProposalComparator implements Comparator<TemplateProposal> {
		public int compare(TemplateProposal o1, TemplateProposal o2) {
			int res = o2.getRelevance() - o1.getRelevance();
			if (res == 0) {
				res = o1.getDisplayString().compareTo(o2.getDisplayString());
			}
			return res;
		}
	}

}
