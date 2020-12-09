/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.tray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author IBM, Original Contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 5, 2007
 * 
 */

public class MultiViewerSelectionProvider implements ISelectionProvider, IPostSelectionProvider {

  static ISelectionChangedListener[] EMPTY_LISTENERS = {};

  protected List<EditPartViewer> viewers = new ArrayList<EditPartViewer>();

  protected List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>();

  protected List<ISelectionChangedListener> postListeners = new ArrayList<ISelectionChangedListener>();

  protected boolean changingSelection = false;

  protected boolean broadcastingSelectionChange = false;

  protected IStructuredSelection cachedSelection;

  /**
   * Brand new shiny MultiViewerSelectionProvider
   */
  public MultiViewerSelectionProvider() {
    // Empty constructor
  }

  /**
   * Brand new shiny MultiViewerSelectionProvider
   * 
   * @param viewer
   */
  public MultiViewerSelectionProvider(EditPartViewer viewer) {
    addViewer(viewer);
  }

  /**
   * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
   */
  public void addSelectionChangedListener(ISelectionChangedListener listener) {
    listeners.add(listener);
  }

  /**
   * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
   */
  public void removeSelectionChangedListener(ISelectionChangedListener listener) {
    listeners.remove(listener);
  }

  /**
   * @see org.eclipse.jface.viewers.IPostSelectionProvider#addPostSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
   */
  public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
    postListeners.add(listener);
  }

  /**
   * @see org.eclipse.jface.viewers.IPostSelectionProvider#removePostSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
   */
  public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
    postListeners.remove(listener);
  }

  /**
   * Add the viewer to the list of viewers that are listening for selection changes.
   * 
   * @param viewer
   */
  public void addViewer(EditPartViewer viewer) {
    viewers.add(viewer);
    viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        if (changingSelection) {
          return;
        }
        setSelection(event.getSelection());
      }
    });
  }

  /**
   * Get the current selection
   * 
   * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
   */
  public ISelection getSelection() {
    if (cachedSelection == null) {
      List<EditPartViewer> result = new ArrayList<EditPartViewer>();
      for (EditPartViewer next : viewers) {
        result.addAll(next.getSelectedEditParts());
      }
      cachedSelection = calculateSelection(new StructuredSelection(result));
    }
    return cachedSelection;
  }

  /**
   * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
   */
  public void setSelection(ISelection selection) {
    if (selection instanceof IStructuredSelection == false) {
      return;
    }

    cachedSelection = calculateSelection((IStructuredSelection) selection);
    internalSetSelection(cachedSelection);
    fireSelectionChanged(this, cachedSelection);
  }

  protected void fireSelectionChanged(ISelectionProvider provider, ISelection selection) {
    SelectionChangedEvent event = new SelectionChangedEvent(provider, selection);
    try {
      broadcastingSelectionChange = true;
      for (ISelectionChangedListener listener : this.listeners.toArray(EMPTY_LISTENERS)) {
        listener.selectionChanged(event);
      }
      for (ISelectionChangedListener listener : this.postListeners.toArray(EMPTY_LISTENERS)) {
        listener.selectionChanged(event);
      }
    } finally {
      broadcastingSelectionChange = false;
    }
  }

  protected IStructuredSelection calculateSelection(IStructuredSelection baseSelection) {

    List<EditPart> result = new ArrayList<EditPart>();
    for (EditPartViewer viewer : viewers) {

      Map<Object, EditPart> registry = viewer.getEditPartRegistry();

      for (Object n : baseSelection.toArray()) {
        EditPart part = (EditPart) n;
        Object model = part.getModel();
        EditPart viewerEditPart = registry.get(model);
        if (viewerEditPart != null) {
          result.add(viewerEditPart);
        }
      }
    }
    if (result.isEmpty()) {
      return StructuredSelection.EMPTY;
    }
    return new StructuredSelection(result);
  }

  // TODO: try getting rid of the isEmpty() check here and in the same
  // place in AdaptingSelectionProvider.

  // Set selection to each of the viewers and make sure we ignore callbacks

  protected void internalSetSelection(IStructuredSelection selection) {
    if (selection == null || selection.isEmpty()) {
      return;
    }

    try {
      changingSelection = true;

      for (EditPartViewer viewer : viewers) {

        Map<Object, EditPart> registry = viewer.getEditPartRegistry();
        List<EditPart> newList = new ArrayList<EditPart>();
        Set<EditPart> newSet = new HashSet<EditPart>();

        for (Object n : selection.toArray()) {
          EditPart part = (EditPart) n;
          Object model = part.getModel();
          EditPart viewerEditPart = registry.get(model);
          if (viewerEditPart != null && newSet.add(viewerEditPart)) {
            newList.add(viewerEditPart);
          }
        }
        viewer.setSelection(new StructuredSelection(newList));
      }
    } finally {
      changingSelection = false;
    }
  }

  /**
   * Answer true if we are broadcasting a selection change.
   * 
   * @return answer true if we are broadcasting selection change.
   */

  public boolean isBroadcastingSelectionChange() {
    return broadcastingSelectionChange;
  }
}
