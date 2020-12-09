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
package org.eclipse.bpel.ui.dialogs;

import java.util.ArrayList;

import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.details.providers.VariableTreeContentProvider;
import org.eclipse.bpel.ui.details.tree.BPELVariableTreeNode;
import org.eclipse.bpel.ui.details.tree.XSDAttributeDeclarationTreeNode;
import org.eclipse.bpel.ui.details.tree.XSDElementDeclarationTreeNode;
import org.eclipse.bpel.ui.details.tree.PartTreeNode;
import org.eclipse.bpel.ui.details.tree.ITreeNode;
import org.eclipse.bpel.ui.details.tree.TreeNode;
import org.eclipse.bpel.ui.expressions.XPathExpressionUtil;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDTypeDefinition;


public class ElementTreePreviewSelectionDialog extends ElementTreeSelectionDialog {
	protected Label previewLabel;
	protected Text previewText;
	protected Label filterLabel;
	protected Text filterText;
	private String thePreviewText;
	private String theFilter = ""; //$NON-NLS-1$
	
	public class TreeFilter extends ViewerFilter {
	    @Override
		public Object[] filter(Viewer viewer, Object parent, Object[] elements) {
	        int size = elements.length;
	        ArrayList out = new ArrayList(size);
	        for (int i = 0; i < size; ++i) {
	            Object element = elements[i];
	            if (select(viewer, parent, element)) {
					out.add(element);
				}
	        }
	        return out.toArray();
	    }
	    
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof BPELVariableTreeNode) {
				Variable var = (Variable)((BPELVariableTreeNode)element).getModelObject();
				if (var.getName().indexOf(theFilter) > -1)
					return true;
			}			
			else if (element instanceof XSDElementDeclarationTreeNode) {
				XSDElementDeclaration xsdelem = ((XSDElementDeclarationTreeNode)element).getResolvedModelObject();
				if (xsdelem.getName().indexOf(theFilter) > -1)
					return true;
				}
			else if (element instanceof XSDAttributeDeclarationTreeNode) {
				XSDAttributeDeclaration xsdattribute = ((XSDAttributeDeclarationTreeNode)element).getResolvedModelObject();
				if (xsdattribute.getName().indexOf(theFilter) > -1)
					return true;
			}
			else if (element instanceof PartTreeNode) {
				Part part = (Part)((PartTreeNode)element).getModelObject();
				if (part.getName().indexOf(theFilter) > -1)
					return true;
			}			
			
			// determine if node has child nodes and see if they would
			// pass the filter test
			if (((TreeNode)element).hasChildren()) {
				Object[] children = ((TreeNode)element).getChildren();
				for (int i=0; i<children.length; i++) {
					if (select(viewer, element, children[i]))
						return true;
				}
			}

			return false;
		}
	}
	
    public ElementTreePreviewSelectionDialog(Shell parent,
            ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
        super(parent, labelProvider, contentProvider);
        
       addFilter(new TreeFilter());
    }
	
    protected void updatePreviewText(IStructuredSelection selection) {
    	if (previewText == null)
    		return;
    	
    	VariableTreeContentProvider contentProvider = (VariableTreeContentProvider)super.getTreeViewer().getContentProvider();
		Object[] path = contentProvider.getPathToRoot(selection.getFirstElement());
		String preview = "$"; //$NON-NLS-1$
		if (path != null) {
			Variable var = null;
			for (int i=path.length-1; i >=0 ; i--) {
				String targetNamespace = null;
				String namespacePrefix = null;			
				String segment = null;
				Object modelObject = BPELUtil.resolveXSDObject(((ITreeNode)path[i]).getModelObject());;		
				if (modelObject instanceof Variable) {
					var = (Variable)modelObject;
					segment = var.getName();
				} else if (modelObject instanceof XSDAttributeDeclaration) {
					
					XSDAttributeDeclaration att = (XSDAttributeDeclaration) modelObject;

					targetNamespace = att.getTargetNamespace();
					if (targetNamespace != null) {
						namespacePrefix = BPELUtils.getNamespacePrefix( var, targetNamespace );
						Assert.isNotNull(namespacePrefix, XPathExpressionUtil.MSG_NS_PREFIX_NULL);
						segment = "/@" + namespacePrefix + ":" + att.getName(); //$NON-NLS-1$ //$NON-NLS-2$
					} else {				 
						segment = "/@" + att.getName(); //$NON-NLS-1$
					}
					
				} else if (modelObject instanceof XSDElementDeclaration) {
				
					XSDElementDeclaration elm = (XSDElementDeclaration) modelObject;
					targetNamespace = elm.getTargetNamespace();
					
					XSDTypeDefinition typeDef = elm.getType();				
					XSDParticle particle = typeDef.getComplexType();				
					
					boolean isArray = particle != null && 
										(particle.getMaxOccurs() == XSDParticle.UNBOUNDED || particle.getMaxOccurs() > 1);

					if (targetNamespace != null) {
						namespacePrefix = BPELUtils.getNamespacePrefix( var, targetNamespace );
						Assert.isNotNull(namespacePrefix, XPathExpressionUtil.MSG_NS_PREFIX_NULL);
						segment = "/" + namespacePrefix + ":" + elm.getName(); //$NON-NLS-1$ //$NON-NLS-2$
					} else {				 
						segment = "/" + elm.getName() ; //$NON-NLS-1$
					}
					
					if (isArray) {
						segment += "[1]"; //$NON-NLS-1$
					}
					
				}
				else if (modelObject instanceof Part) {
					Part part = (Part)modelObject;
					segment = "." + part.getName(); //$NON-NLS-1$
				}
				
				if (segment != null)
					preview += segment;
			}
			
			// store away value
			previewText.setText(preview);
			thePreviewText = preview;
		}
    }
    
    @Override
	protected Control createDialogArea(Composite parent) {
    	Composite filter = new Composite(parent, SWT.NONE);
    	GridData data1 = new GridData(GridData.FILL_BOTH);
    	filter.setLayoutData(data1);
    	
    	GridLayout layout1 = new GridLayout();
    	layout1.numColumns = 1;
    	layout1.makeColumnsEqualWidth = false;
    	filter.setLayout(layout1);
 	
    	filterLabel = new Label(filter, SWT.NONE);
    	filterLabel.setText(XPathExpressionUtil.LBL_FILTER_TEXT);
        data1 = new GridData();
        data1.widthHint = 80;
        filterLabel.setLayoutData(data1);
    	
    	filterText = new Text(filter, SWT.BORDER);
    	data1 = new GridData(GridData.FILL_HORIZONTAL);
    	//data.widthHint = 300;
    	filterText.setLayoutData(data1);
    	filterText.addKeyListener(new KeyListener() {
    		public void keyPressed(KeyEvent e) {
    		}
    		public void keyReleased(KeyEvent e) {
       			theFilter = filterText.getText();
       			if (theFilter.length() > 0) {
       				// try to filter all leaf nodes as well
  	    			getTreeViewer().refresh();
  	    			getTreeViewer().expandAll();
       			}
       			else {
       				getTreeViewer().refresh(); 
       				getTreeViewer().collapseAll();
       			}      				
    		}
    	});
   
    	Composite comp = (Composite)super.createDialogArea(parent);

    	Composite previewMain = new Composite(parent, SWT.NONE);
    	GridData data = new GridData(GridData.FILL_BOTH);
    	previewMain.setLayoutData(data);
    	
    	GridLayout layout = new GridLayout();
    	layout.numColumns = 2;
    	layout.makeColumnsEqualWidth = false;
    	previewMain.setLayout(layout);
 	
    	previewLabel = new Label(previewMain, SWT.NONE);
    	previewLabel.setText(XPathExpressionUtil.LBL_PREVIEW_TEXT);
        data = new GridData();
        data.widthHint = 80;
    	previewLabel.setLayoutData(data);
    	
    	previewText = new Text(previewMain, SWT.BORDER);
    	data = new GridData(GridData.FILL_HORIZONTAL);
    	//data.widthHint = 300;
    	previewText.setLayoutData(data);
    	
    	TreeViewer treeViewer = super.getTreeViewer();
    	treeViewer.addSelectionChangedListener((new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent event) {
            	updatePreviewText((IStructuredSelection)event.getSelection());
            }
    	}));
    	
    	return comp;
    }
    
    public String getPreviewResult() {
    	return thePreviewText;
    }
}
