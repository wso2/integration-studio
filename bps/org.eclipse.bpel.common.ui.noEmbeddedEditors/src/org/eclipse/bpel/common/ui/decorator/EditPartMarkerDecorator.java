/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.decorator;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.bpel.common.ui.layouts.AlignedFlowLayout;
import org.eclipse.bpel.common.ui.layouts.FillParentLayout;
import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.bpel.common.ui.markers.ModelMarkerUtil;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;


/**
 * A class to encapsulate marker support for an <code>EditPart</code>. 
 * The <code>EditPart</code> should hold an instance of this class in a field.
 * It makes use of the EMF markers support.
 * 
 * <p> 
 * In its <code>refreshVisuals()</code> method, the <code>EditPart</code> should call <code>refresh().</code>
 * 
 * In its <code>createFigure()</code> method, the <code>EditPart</code> should call the 
 * <code>createFigure(IFigure)</code> of this class to decorate its figure.
 * </p>
 */

public class EditPartMarkerDecorator {

	protected EObject modelObject;
	
	// Multiple model objects that use this decorator to display markers
	private List<EObject> modelObjects = new ArrayList<EObject>();
	
	private boolean fillParent = false;
	
	// A Layer to contain the Marker Images.
	protected Layer decorationLayer;
	// The layout for the decorationLayer
	private AbstractLayout decorationLayout;
	
	//The layout for the layer that contains the figure to be decorated.
	private AbstractLayout figureLayout;
	
	// by default, the children are bounded to their natural size, otherwise, the size of the children are not
	// touched and somebody else is responsible for sizing them
	protected boolean resizeChildren = true; 

	private Object defaultConstraint = IMarkerConstants.CENTER;

	/**
	 * Brand new shiny EditPartMarkerDecorator with the model object given.
	 * 
	 * @param aModelObject  the model object.
	 */
	
	public EditPartMarkerDecorator(EObject aModelObject) {
		this(aModelObject, null, null);
	}
	
	/**
	 * Brand new shiny EditPartMarkerDecorator with a list of model objects.
	 * 
	 * @param aListOfModelObjects  the model object list.
	 */

	public EditPartMarkerDecorator(List<EObject> aListOfModelObjects) {
		this(aListOfModelObjects, null, null);
	}
	
	/**
	 * Brand new shiny EditPartMarkerDecorator with a model object and a layout.
	 * 
	 * @param aModelObject
	 * @param aLayout  the layout to use.
	 */

	public EditPartMarkerDecorator (EObject aModelObject, AbstractLayout aLayout) {
		this(aModelObject, aLayout, null);
	}
	
	/**
	 * Brand new shiny EditPartMarkerDecorator with a list of model objects and a
	 * layout.
	 * 
	 * @param aListOfModelObjects
	 *            the list of model objects
	 * @param aLayout
	 *            the layout to use.
	 */
	
	public EditPartMarkerDecorator(List<EObject> aListOfModelObjects, AbstractLayout aLayout) {
		this(aListOfModelObjects, aLayout, null);
	}
	
	/**
	 * @param aModelObject
	 * @param aFigureLayout
	 * @param aDecorationLayout
	 */
	
	public EditPartMarkerDecorator(EObject aModelObject, AbstractLayout aFigureLayout, AbstractLayout aDecorationLayout) {
		this.modelObject = aModelObject;
		
		setFigureLayout(aFigureLayout);
		
		if (aDecorationLayout == null) {
			aDecorationLayout = new DecorationLayout();
		}
		setDecorationLayout(aDecorationLayout);
	}
	
	/**
	 * @param aListOfModelObjects
	 * @param aLayout
	 * @param aDecorationLayout
	 */
	
	public EditPartMarkerDecorator(List<EObject> aListOfModelObjects, AbstractLayout aLayout, AbstractLayout aDecorationLayout) {
		this((EObject)null, aLayout, aDecorationLayout);
		this.modelObjects = aListOfModelObjects;
	}

	
    /**
     * 
     * @param fillParentSwitch
     */
    public void setFillParent(boolean fillParentSwitch) {
        this.fillParent = fillParentSwitch;
    }

    
    static IMarker[] EMPTY_MARKERS = {};
    
    
	/**
	 * Draws the markers. 
	 * This method should be called from the EditPart's refreshVisuals() method.
	 */
    
	protected void refreshMarkers() {
		
		if (decorationLayer == null) {
			return ;
		}
		
		for (List<IMarker> markerList : sortByType ( getMarkers())) {
			
			IMarker[] list = markerList.toArray( EMPTY_MARKERS );
			Object constraint = getConstraint(list[0]);
			IFigure markerFigure = createFigureForMarkers(list);
			if (markerFigure != null) {
				decorationLayer.add(markerFigure, constraint);
			}
		}
	}
	
	
	/**
	 * Subclasses may override this. Here we sort the  markers by type into several lists.
	 * Equivalent markers are displayed as "multiple" errors.
	 * 
	 * @param markers an array of markers.
	 * @return a collection of lists of markers.
	 */
	
	protected Collection<List<IMarker>> sortByType ( IMarker[] markers ) {
		
		Map <String,List<IMarker>> sorter = new HashMap<String,List<IMarker>>();
		
		for(IMarker m : markers) {
			String type = null;
			try {
				type = m.getType();
			} catch (CoreException e) {
				continue;
			}
			List<IMarker> list = sorter.get(type);
			if (list == null) {
				list = new ArrayList<IMarker>();
				sorter.put(type, list);
			}
			list.add(m);			
		}
		return sorter.values();		
	}
	
	
	/**
	 * Draws the markers. This method should be called from the EditPart's
	 * refreshVisuals() method.
	 */
	public void refresh(){
		 if(decorationLayer != null) {
		 	 decorationLayer.removeAll();
		 }
		 refreshMarkers();
	}
	
	/** 
	 * Get the image to be drawn for the marker's figure.  This is obtained 
	 * from an IModelMarkerContentProvider that must be implemented by the client. 
	 * If we can't find an image using the content provider we check to see if the
	 * marker is a problem marker and get the correct icon for it.
	 * 
	 * May be overridden by subclasses to change the image.
	 * 
	 * @param marker 
	 * @return an image representing the marker or null if none is available
	 */
	protected Image getImage(IMarker marker) {
		return ModelMarkerUtil.getImage(marker);
	}
	
	protected IMarker[] getMarkers() {
		return getMarkerMap().values().toArray(EMPTY_MARKERS);
		
	}

	/**
	 * The EditPart's createFigure() method should call this method in order to decorate
	 * it's figure.
	 * 
	 * @param figure The figure to be decorated
	 * @return the created figure.
	 */
	
	public IFigure createFigure(IFigure figure) {
		LayeredPane pane = new LayeredPane();
		Layer layer = new Layer();
		if (figureLayout == null) {
		    if (fillParent) {
		        figureLayout = new FillParentLayout();
		    } else {
				figureLayout = new AlignedFlowLayout() {
					
					@Override
					protected void setBoundsOfChild(IFigure parent,	IFigure child,	Rectangle bounds) {
						parent.getClientArea(Rectangle.SINGLETON);
						bounds.translate(Rectangle.SINGLETON.x, Rectangle.SINGLETON.y);
						if (resizeChildren)
							child.setBounds(bounds);
						else 
							child.setLocation(bounds.getLocation());
					}
				};
		    }
		}
		layer.setLayoutManager(figureLayout);
		pane.add(layer);
		layer.add(figure);
		if (decorationLayer == null) {
			decorationLayer = new Layer();
		}
		decorationLayer.setLayoutManager(decorationLayout);
		
		pane.add(decorationLayer);
		
		return pane;
	}

	/**
	 * Set the decoration layout.
	 * 
	 * @param layout the layout to use
	 */
	
	public void setDecorationLayout(AbstractLayout layout) {
		decorationLayout = layout;
		if(decorationLayer != null) {
			decorationLayer.setLayoutManager(decorationLayout);
		}
	}

	/**
	 * Resize children flag.
	 * 
	 * @param resizeChildrenFlag
	 */
	
	public void setResizeChildren (boolean resizeChildrenFlag) {
		this.resizeChildren = resizeChildrenFlag;
	}

	/**
	 * Set the figure layout the layout given.
	 * 
	 * @param layout
	 */
	
	public void setFigureLayout(AbstractLayout layout) {
		figureLayout = layout;
	}

	/**
	 * @return Returns the modelObject.
	 */
	public EObject getModelObject() {
		return modelObject;
	}
	
	/**
	 * Return the list of model objects.
	 * @return the list of model objects.
	 */
	
	public List<EObject> getModelObjects() {
		return modelObjects;
	}

	/**
	 * Returns a map where the keys are layout constraints and the values are the
	 * IMarkers that should be displayed for the corresponding constraint.
	 * 
	 * May be overridden by subclasses.
	 * 
	 * @return Map
	 */
	
	protected Map<Object,IMarker> getMarkerMap() {
		return Collections.emptyMap();
	}
	
	/**
	 * Returns the priority of the given marker
	 * @param marker
	 * @return the marker priority.
	 */
	protected int getPriority (IMarker marker) {
		
		Integer priority = null;
		// first see if we have a priority attribute
		try {
			priority = (Integer)marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR);
		} catch	(CoreException e) {
			// do nothing
		} catch (ClassCastException e) {
			// do nothing
		}
		if (priority != null)
			return priority.intValue();

		// now see if is a problem marker 
		try {
			if (marker.isSubtypeOf(IMarker.PROBLEM)) {
				int severity = marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
				if (severity == IMarker.SEVERITY_ERROR)
					return IMarkerConstants.PRIORITY_ERROR_INDICATOR;
				if (severity == IMarker.SEVERITY_WARNING)
					return IMarkerConstants.PRIORITY_WARNING_INDICATOR;
				if (severity == IMarker.SEVERITY_INFO)
					return IMarkerConstants.PRIORITY_INFO_INDICATOR;
			}
		} catch (CoreException e) {
			// do nothing
		}
		
		// return the default priority
		return IMarkerConstants.PRIORITY_DEFAULT;
	}

	/**
	 * Default behavior.  May be overridden by subclasses.
	 * 
	 * @param marker 
	 * @return a layout constraint
	 */
	protected Object getConstraint (IMarker marker) {
		
		try {
			if (marker.isSubtypeOf(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ID)) {
				String key = marker.getAttribute(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR, ""); //$NON-NLS-1$
				Object constraint = convertAnchorKeyToConstraint(key);
				if (constraint != null) {
					return constraint;
				}
			}
		} catch (CoreException e) {
        	// Just ignore exceptions getting marker info.
        	// It is possible that the marker no longer exists.
        	// Eventually the UI will be notified that the
        	// marker is removed and it will update.
		}
		return defaultConstraint;
	}

	protected Object convertAnchorKeyToConstraint(String key) {
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_TOP_CENTRE)) return IMarkerConstants.TOP;
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_BOTTOM_CENTRE)) return IMarkerConstants.BOTTOM;
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_LEFT)) return IMarkerConstants.LEFT;
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_RIGHT)) return IMarkerConstants.RIGHT;
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_CENTRE)) return IMarkerConstants.CENTER;
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_TOP_LEFT)) return IMarkerConstants.TOP_LEFT;
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_TOP_RIGHT)) return IMarkerConstants.TOP_RIGHT;
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_BOTTOM_LEFT)) return IMarkerConstants.BOTTOM_LEFT;
		if (key.equals(IMarkerConstants.MARKER_ANCHORPOINT_BOTTOM_RIGHT)) return IMarkerConstants.BOTTOM_RIGHT;
		return null;
	}
	
	/**
	 * Return the default constraint.
	 * 
	 * @return the default constraint.
	 */
	
	public Object getDefaultConstraint() {
		return defaultConstraint;
	}

	/**
	 * Set the default constraint.
	 * 
	 * @param aDefaultContraint the new default constraint.
	 */
	
	public void setDefaultConstraint(Object aDefaultContraint) {
		this.defaultConstraint = aDefaultContraint;
	}

	/**
	 * Creates a figure for the given marker.
	 * 
	 * May be overridden by subclasses to change the figure created.
	 * @param marker
	 * @return the figure for the marker
	 */
	
	protected IFigure createFigureForMarker(IMarker marker) {
		Image image = getImage(marker);
		String text = getText(marker);
		if (image != null) {
			ImageFigure imageFigure = new ImageFigure(image);
			if (text != null) {
				imageFigure.setToolTip(new Label(text));
			}
			return imageFigure;
		}
		return null;
	}

	/**
	 * Creates a figure for the given markers.
	 * 
	 * May be overridden by subclasses to change the figure created.
	 * @param marker
	 * @return the figure for the marker
	 */
	
	@SuppressWarnings({ "boxing", "nls" })
	protected IFigure createFigureForMarkers ( IMarker[] markers ) {
		
		if (markers.length == 1) {
			return createFigureForMarker(markers[0]);
		}
		
		Image image = null;
		
		StringBuilder builder = new StringBuilder(128);				
		builder.append( NLS.bind(Messages.EditPartMarkerEectorator_1, (new Object[] { markers.length })) );
		
		for(IMarker m : markers) {
			if (image == null) {
				image = getImage(m);
			}
			String text = getText(m);
			if (text != null) {
				builder.append("\no ").append(text);
			}
		}
				
		if (image != null) {
			ImageFigure imageFigure = new ImageFigure(image);
			imageFigure.setToolTip(new Label( builder.toString() ));
			return imageFigure;
		}
		return null;
	}
	
	/** 
	 * Get the tooltip text for the marker's figure.  This is obtained 
	 * from an IModelMarkerContentProvider that must be implemented by the client. 
	 * If we can't get the text using a content provider we check to see if the
	 * marker is a problem marker and get the correct text for it.
	 * 
	 * May be overridden by subclasses to change the tooltip text.
	 * 
	 * @param  marker for which to retrieve the tooltip text
	 * @return a String of text to display as a tooltip for the marker
	 */
	protected String getText(IMarker marker) {
		return ModelMarkerUtil.getText(marker);
	}

	/**
	 * Determines whether the marker is acceptable and should be shown
	 * for this edit part.
	 *
	 * @param marker the marker
	 * @return <code>true</code> if the marker is acceptable
	 */
	protected boolean isAcceptable(IMarker marker) {
		return true;
	}
}