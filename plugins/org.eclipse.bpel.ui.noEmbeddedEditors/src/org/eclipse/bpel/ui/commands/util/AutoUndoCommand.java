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
package org.eclipse.bpel.ui.commands.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.sse.core.internal.format.IStructuredFormatProcessor;
import org.eclipse.wst.wsdl.WSDLElement;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.eclipse.wst.xml.core.internal.provisional.format.FormatProcessorXML;
import org.w3c.dom.Element;

/**
 * A base class for BPEL editor commands. Since the BPEL editor will have
 * automatic EMF-based Undo/Redo support, editor commands should not implement
 * the undo() or redo() methods (and the framework should not call them!).
 */
public abstract class AutoUndoCommand extends AbstractEditModelCommand {
	private Set<Object> fModelRoots;
	
	public AutoUndoCommand(String label, EObject modelRoot) {
		super(label);
		if (modelRoot == null) {
			throw new IllegalStateException("modelRoot cannot be null here");
		}
		fModelRoots = Collections.singleton((Object) modelRoot);
	}

	public AutoUndoCommand(EObject modelRoot) {
		if (modelRoot == null) {
			throw new IllegalStateException("modelRoot cannot be null here");
		}
		fModelRoots = Collections.singleton((Object) modelRoot);
	}

	public AutoUndoCommand(String label, ArrayList<Object> modelRoots) {
		super(label);
		fModelRoots = new HashSet<Object>();
		fModelRoots.addAll(modelRoots);
	}

	public AutoUndoCommand(ArrayList<Object> modelRoots) {
		fModelRoots = new HashSet<Object>();
		fModelRoots.addAll(modelRoots);
	}

	private void beginRecording(Object element) {
		if (element instanceof IDOMNode) {			
			IDOMModel model = ((IDOMNode) element).getModel();
			model.aboutToChangeModel();
			model.beginRecording(this,
					getUndoDescription());
		}
	}

	private void endRecording(Object element) {
		if (element instanceof IDOMNode) {
			IDOMModel model = ((IDOMNode) element).getModel();
			model.changedModel();
			model.endRecording(this);
		}
	}

	protected String getUndoDescription() {
		return getLabel();
	}

	protected void formatChild(Element child) {
		if (child instanceof IDOMNode) {
			IDOMModel model = ((IDOMNode) child).getModel();
			try {
				// tell the model that we are about to make a big model change
				model.aboutToChangeModel();

				IStructuredFormatProcessor formatProcessor = new FormatProcessorXML();
				formatProcessor.formatNode(child);
			} finally {
				// tell the model that we are done with the big model change
				model.changedModel();
			}
		}
	}

	public void execute() {
		if (canDoExecute()) {
			Object element = calculateLeastCommonAncestor();
			try {
				beginRecording(element);
				doExecute();
			} finally {
				endRecording(element);
			}
		}
	}

	private Object calculateLeastCommonAncestor() {
		Object[] roots = getModelRoots().toArray();
		if (roots.length == 0) {
			return null;
		}
		if (roots.length == 1) {
			return ((WSDLElement)roots[0]).getElement();
		}
		Integer worms = roots.length;
		HashMap<Object, Integer> wormed = new HashMap<Object, Integer>();
		Set<WSDLElement> old = new HashSet<WSDLElement>();
		Set<WSDLElement> current = new HashSet<WSDLElement>();
		for (Object node : roots) {
			wormed.put(node, 1);
			current.add((WSDLElement)node);
		}
		while (true) {
			Set<WSDLElement> temp = old;
			old = current;
			current = temp;
			current.clear();
			for (WSDLElement node : old) {
				if (node.getContainer() == null) {
					if (node instanceof Process) {
						return node.getElement();
					} else {
						continue;
					}
				}
				Integer count = wormed.get(node);
				if (count == null) {
					wormed.put(node, 1);
				} else if (worms.equals(count + 1)) {
					return node.getElement();
				} else if (count != null) {
					wormed.put(node, count + 1);
				}
				current.add(node.getContainer());
			}
			if (current.isEmpty()) {
				return ((BPELResource)((WSDLElement)roots[0]).eResource()).getProcess().getElement();
			}
		}		
	}
	
	/**
	 * @return true if we can execute this, false otherwise.
	 */

	public boolean canDoExecute() {
		return true;
	}

	public void doExecute() {

	}
	
	@SuppressWarnings("nls")
	protected void addModelRoot(Object modelRoot) {
		if (modelRoot == null) {
			throw new IllegalStateException("modelRoot cannot be null here");
		}
		getModelRoots().add(modelRoot);
	}
	
	protected void addModelRoots(List<Object> modelRoot) {
		getModelRoots().addAll(modelRoot);
	}
	
	protected void addModelRoots(Set<Object> modelRoot) {
		getModelRoots().addAll(modelRoot);
	}
	
	public Set<Object> getModelRoots() {
		return fModelRoots;
	}
	
	protected Resource getResource (Object modelRoot) {
		if (modelRoot instanceof EObject) return ((EObject)modelRoot).eResource();
		if (modelRoot instanceof Resource) return (Resource)modelRoot;
		throw new IllegalArgumentException();
	}
	
	/**
	 * Default implementation.  Assume that any resource containing a modelRoot
	 * will be modified by the command.
	 */
	@Override
	public Resource[] getResources() {
		if (getModelRoots().size() < 2) {
			if (getModelRoots().isEmpty()) {
				// This should never happen. ?
				throw new IllegalStateException();
				// return new Resource[0]
			}
			Resource resource = getResource(getModelRoots().toArray()[0]);
			if (resource != null) {
				return new Resource[] { resource };
			}
			return EMPTY_RESOURCE_ARRAY;
		}
		Set<Resource> resultSet = new HashSet<Resource>(getModelRoots().size());
		for (Object next : getModelRoots()) {
			Resource resource = getResource(next);
			if (resource != null) {
				resultSet.add(resource);
			}
		}
		return resultSet.toArray( EMPTY_RESOURCE_ARRAY );
	}
	
	/**
	 * Default implementation: assume that all modelRoots resources were modified.
	 * 
	 * TODO: comment out this method and check each place where a red X appears, to
	 * see if it should implement the method.
	 * 
	 * TODO: maybe a better way is to just query the recorder for affected resources...!
	 */
	
	@Override
	public final Resource[] getModifiedResources() {
		return getResources(); 
	}
}
