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
package org.eclipse.bpel.ui.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.ui.ImageUtils;
import org.eclipse.bpel.common.ui.details.viewers.ComboViewer;
import org.eclipse.bpel.common.ui.details.widgets.DecoratedLabel;
import org.eclipse.bpel.common.ui.markers.ModelMarkerUtil;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CompensateScope;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.adapters.AdapterRegistry;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.names.NCNameWordDetector;
import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.Policy;
import org.eclipse.bpel.ui.adapters.BPELUIAdapterFactory;
import org.eclipse.bpel.ui.adapters.BPELUIExtensionAdapterFactory;
import org.eclipse.bpel.ui.adapters.BPELUIMessagePropertiesAdapterFactory;
import org.eclipse.bpel.ui.adapters.BPELUIPartnerLinkTypeAdapterFactory;
import org.eclipse.bpel.ui.adapters.BPELUIWSDLAdapterFactory;
import org.eclipse.bpel.ui.adapters.BPELUIWSILAdapterFactory;
import org.eclipse.bpel.ui.adapters.BPELUIXSDAdapterFactory;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.INamedElement;
import org.eclipse.bpel.ui.bpelactions.AbstractBPELAction;
import org.eclipse.bpel.ui.dialogs.NamespaceMappingDialog;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.FlowEditPart;
import org.eclipse.bpel.ui.editparts.InvokeEditPart;
import org.eclipse.bpel.ui.editparts.LinkEditPart;
import org.eclipse.bpel.ui.editparts.ScopeEditPart;
import org.eclipse.bpel.ui.editparts.StartNodeEditPart;
import org.eclipse.bpel.ui.editparts.borders.GradientBorder;
import org.eclipse.bpel.ui.editparts.util.OverlayCompositeImageDescriptor;
import org.eclipse.bpel.ui.extensions.ActionDescriptor;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage;
import org.eclipse.bpel.validator.EmfModelQuery;
import org.eclipse.bpel.wsil.model.inspection.InspectionPackage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Tool;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.accessibility.AccessibleControlEvent;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.wst.common.componentcore.ComponentCore;
import org.eclipse.wst.common.componentcore.ModuleCoreNature;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.IProjectFacet;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Fault;
import org.eclipse.wst.wsdl.Input;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Output;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.wst.wsdl.WSDLPackage;
import org.eclipse.wst.wsdl.util.WSDLResourceImpl;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDPackage;


/**
 * BPELUtil is a place to put *static* helper methods for the BPEL editor.
 *
 * Note that helpers which have specifically to do with accessing model objects are
 * usually found in the ModelHelper class.
 */
public class BPELUtil {

	private static final Variable[] EMPTY_VARIABLE_ARRAY = new Variable[0];
	private static final PartnerLink[] EMPTY_PARTNERLINK_ARRAY = new PartnerLink[0];
	private static final CorrelationSet[] EMPTY_CORRELATIONSET_ARRAY = new CorrelationSet[0];

	/**
	 * This global variable stores the path of the last WSDL file selected with
	 * a WorkbenchFileSelectionDialog.
	 */
	public static IPath lastWSDLFilePath = null;
	/**
	 * Global variable storing the path of the last BPEL file selected
	 */
	public static IPath lastBPELFilePath = null;

	/**
	 * Global variable storing the path of the last XSD file selected
	 */
	public static IPath lastXSDFilePath;


	static {
		AdapterRegistry.INSTANCE.registerAdapterFactory(
				BPELPackage.eINSTANCE, BPELUIAdapterFactory.getInstance());

		AdapterRegistry.INSTANCE.registerAdapterFactory(
			    WSDLPackage.eINSTANCE, BPELUIWSDLAdapterFactory.getInstance());

		AdapterRegistry.INSTANCE.registerAdapterFactory(
			    PartnerlinktypePackage.eINSTANCE, BPELUIPartnerLinkTypeAdapterFactory.getInstance());

		AdapterRegistry.INSTANCE.registerAdapterFactory(
			    XSDPackage.eINSTANCE, BPELUIXSDAdapterFactory.getInstance());

		AdapterRegistry.INSTANCE.registerAdapterFactory(
			    MessagepropertiesPackage.eINSTANCE, BPELUIMessagePropertiesAdapterFactory.getInstance());

		AdapterRegistry.INSTANCE.registerAdapterFactory(
			    UiextensionmodelPackage.eINSTANCE, BPELUIExtensionAdapterFactory.getInstance());

		AdapterRegistry.INSTANCE.registerAdapterFactory(
			    InspectionPackage.eINSTANCE, BPELUIWSILAdapterFactory.getInstance() );

	}


	/**
	 * Register adapter factory for the given EClass.
	 *
	 * @param key
	 * @param factory
	 */

	public static void registerAdapterFactory(EClass key, AdapterFactory factory) {
		AdapterRegistry.INSTANCE.registerAdapterFactory(key,factory);
	}

	public static void registerAdapterFactory(EPackage key, AdapterFactory factory) {
		AdapterRegistry.INSTANCE.registerAdapterFactory(key, factory);
	}

	static Class<?> adapterInterface ( Object type ) {

		if (type instanceof Class) {
			return (Class) type;
		}

		if (type instanceof String) {
			try {
				return Class.forName((String)type);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		throw new RuntimeException("Adapter type " + type + " is not understood.");		 //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @param <T>
	 * @param target
	 * @param clazz
	 * @return the adapted interface or object
	 */
	public static <T extends Object> T adapt ( Object target,  Class<T> clazz) {
		return AdapterRegistry.INSTANCE.adapt(target, clazz);
	}



	/**
	 * This method tries the registered adapter factories one by one, returning
	 * the first non-null result it gets.  If none of the factories can adapt
	 * the result, it returns null.
	 * @param target target object
	 * @param type type of the adapter to find
	 * @return the adapter for the target.
	 */

	public static Object adapt (Object target, Object type) {
		return AdapterRegistry.INSTANCE.adapt(target, type);
	}


	/**
	 * Create an adapter for the given target of the given type.
	 * In addition, pass a context object to the adapter(s) of the target.
	 *
	 * The idea is that some adapters can be stateful and depend not only
	 * on the objects that they wrap, but also on some other context that is needed
	 * to completely and correctly implement the interface for which the adaptor is
	 * needed.
	 *
	 * Adapters that are stateless, should ignore any notifications sent to them.
	 *
	 * @param target the target object
	 * @param type the type it wants to adapt to
	 * @param context the context object
	 *
	 * @return the adapter
	 */
	public static Object adapt (Object target, Object type, Object context) {
		return AdapterRegistry.INSTANCE.adapt(target, type,context);
	}


	/**
	 * Returns the effective EClass for a custom activity (action).
	 */
	public static EClass getEClassFor(Object target) {
	    if (target instanceof Invoke) {
	        ActionDescriptor[] descriptors = BPELUIRegistry.getInstance().getActionDescriptors();
	        for( ActionDescriptor descriptor : descriptors ) {
	            AbstractBPELAction action = descriptor.getAction();
                if (action.isInstanceOf(target)) {
                    return action.getModelType();
                }
            }
	    }
	    if (!(target instanceof EObject)) {
	        return null;
	    }
	    return ((EObject)target).eClass();
	}

	public static boolean isCustomActivity(Object target) {
        if (target instanceof Invoke) {
	        ActionDescriptor[] descriptors = BPELUIRegistry.getInstance().getActionDescriptors();
	        for( ActionDescriptor descriptor : descriptors ) {
	            AbstractBPELAction action = descriptor.getAction();
	            if (action.getModelType() == BPELPackage.eINSTANCE.getInvoke()) continue;
                if (action.isInstanceOf(target)) {
                    return true;
                }
            }
        }
		return false;
	}

	public static boolean isBPELAction(EClass target) {
		ActionDescriptor[] descriptors = BPELUIRegistry.getInstance().getActionDescriptors();
        for( ActionDescriptor descriptor : descriptors ) {
            AbstractBPELAction action = descriptor.getAction();
            if (action.getModelType() == target) {
                return true;
            }
        }
		return false;
	}

	/**
	 * Creates a new instance of clazz using the EFactory of the EPackage clazz belongs to.
	 */
	public static EObject createEObject(EClass clazz) {
		return clazz.getEPackage().getEFactoryInstance().create(clazz);
	}

	// This is a hack to bundle the result of a cloneSubtree with enough state to undo/redo
	// the extension map changes it caused.
	public static class CloneResult {

		/** The result of the clone */
		public EObject targetRoot;
		Map<EObject,EObject> targetMap;
		Map<EObject,EObject> targetMapAdditions = new HashMap<EObject,EObject>();

		/**
		 * Undo ... ?
		 */
		public void undo() {
			for (EObject next : this.targetMapAdditions.keySet()) {
				this.targetMap.remove(next);
			}
		}

		/**
		 * Redo ... ?
		 */
		public void redo() {
			for (EObject key : this.targetMapAdditions.keySet()) {
				this.targetMap.put(key, this.targetMapAdditions.get(key));
			}
		}
	}

	// This helper is used by the cloneSubtree() method.
	protected static void cloneSubtreeHelper (EObject source, Map<EObject,EObject> sourceMap, Map<EObject,EObject> targetMap,
		Map<EObject,EObject> copyMap, CloneResult result)
	{
		EObject targetObject = createEObject(source.eClass());
		copyMap.put(source, targetObject);

		if (sourceMap != null && sourceMap.containsKey(source)) {

			EObject sourceExtension = sourceMap.get(source);
			EObject targetExtension = createEObject(sourceExtension.eClass());

			copyMap.put(sourceExtension, targetExtension);

			for (TreeIterator<?> it2 = sourceExtension.eAllContents(); it2.hasNext(); ) {
				EObject source2 = (EObject)it2.next();
				EObject target2 = createEObject(source2.eClass());
				copyMap.put(source2, target2);
			}

			targetMap.put(targetObject, targetExtension);
			result.targetMapAdditions.put(targetObject, targetExtension);
		}
	}

	/**
	 * Clones an EObject and all EObjects contained directly or indirectly within it.  All
	 * cloned objects possessing an extension in the sourceMap will also have their extensions
	 * cloned into the targetMap.  Containment references and other references to any of the
	 * cloned object(s) will be fixed up to point into the target objects.  Any references to
	 * non-cloned objects will be copied as-is in the cloned objects.
	 *
	 * NOTE: This method relies on BPELUtil.createEObject() knowing how to create new instances
	 * of the EClasses of all copied objects (i.e. objectFactories must contain the necessary
	 * EFactory instances for everything copied by this method).
	 *
	 * @param source The root of the source subtree to clone.
	 * @param sourceMap The extension map containing source extensions of cloned objects.
	 * @param targetMap The extension map in which cloned extensions should be recorded.
	 * @return a CloneResult containing the root of the target subtree, which can be used
	 * for undo/redo.
	 */
	@SuppressWarnings("nls")
	public static CloneResult cloneSubtree (EObject source, Map<EObject,EObject> sourceMap, Map<EObject,EObject> targetMap) {

		HashMap<EObject,EObject> copyMap = new HashMap<EObject,EObject>();

		CloneResult result = new CloneResult();
		result.targetMap = targetMap;

		// (1) Create target objects for each EObject in the containment subtree of source.
		// If the source object has an extension in sourceMap, create copies of the extension
		// and its containment tree as well.
		// NOTE: we can NOT just recursively call cloneSubtree for the extension, it wouldn't
		// work with fixing up references.  We have to iterate its eAllContents also here.

		cloneSubtreeHelper(source, sourceMap, targetMap, copyMap, result);

		for (TreeIterator<?> it = source.eAllContents(); it.hasNext(); ) {
			EObject sourceObject = (EObject)it.next();
			cloneSubtreeHelper(sourceObject, sourceMap, targetMap, copyMap, result);
		}

		// (2) Copy the features from each cloned source object to the corresponding target
		// object.  As we copy, we replace any references to cloned source objects with
		// references to the corresponding target objects--but references to non-cloned
		// objects are copied as-is.

		for (Map.Entry<EObject,EObject> entry : copyMap.entrySet() ) {

			EObject sourceObject = entry.getKey();
			EObject targetObject = entry.getValue();

			if (sourceObject.eClass() != targetObject.eClass()) {
				throw new IllegalStateException("Source and target objects are not of the same class after cloning.");
			}

			if (Policy.DEBUG) {
				System.out.println("copying a "+sourceObject.eClass().getName()); //$NON-NLS-1$
			}

			for ( EStructuralFeature feature : sourceObject.eClass().getEAllStructuralFeatures()) {

				// special cases first.
				if (!feature.isChangeable()) {
					if (Policy.DEBUG) System.out.println("  *** skipping unchangeable feature "+feature); //$NON-NLS-1$
					continue;
				}

				if (feature.isUnsettable() && !targetObject.eIsSet(feature)) {
					if (Policy.DEBUG) System.out.println("  unsetting feature "+feature.getName()); //$NON-NLS-1$
					targetObject.eUnset(feature);
					continue;
				}

				Object value = sourceObject.eGet(feature);

				boolean treatAsReference = (feature instanceof EReference);

				if (treatAsReference) {
					if (feature.isMany()) {
						// list of references.
						EList<Object> newValues = new BasicEList<Object>();
						if (Policy.DEBUG) System.out.println("  copying multi-reference feature "+feature.getName()+":"); //$NON-NLS-1$ //$NON-NLS-2$

						for (Iterator<?> it3 = ((Collection)value).iterator(); it3.hasNext(); ) {
							Object oldValue = it3.next();
							Object newValue = (oldValue==null ? null : copyMap.get(oldValue));

							if (newValue == null)  {
								newValue = oldValue;
							}
							if (Policy.DEBUG) System.out.println("+ (oldValue="+oldValue+" newValue="+newValue+")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							newValues.add(newValue);
						}
						targetObject.eSet(feature, newValues);
					} else {
						// single reference.
						Object newValue = (value==null? null : copyMap.get(value));
						if (newValue == null)  {
							newValue = value;
						}
						if (Policy.DEBUG) System.out.println("  copying reference feature "+feature.getName() //$NON-NLS-1$
							+" (value="+value+" newValue="+newValue+")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						targetObject.eSet(feature, newValue);
					}
				} else {

					/** In case of a DOM Node and the "element" feature, we simply clone the result */
					if (value instanceof org.w3c.dom.Node && "element".equals(feature.getName())) {
						org.w3c.dom.Node  e = (org.w3c.dom.Node)value;
						value = e.cloneNode(true);
					}

					// non-reference attribute.  just copy the value
					if (Policy.DEBUG) System.out.println("  copying attr feature "+feature.getName()+" (value="+value+")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					targetObject.eSet(feature, value);
				}
			}
		}

		result.targetRoot = copyMap.get(source);
		return result;
	}


	/**
	 * Convenience formatting methods.
	 */
	public static String formatString(String format, String arg1) {
		return MessageFormat.format(format, new Object[] { arg1 });
	}
	public static String formatString(String format, String arg1, String arg2) {
		return MessageFormat.format(format, new Object[] { arg1, arg2 });
	}

	/**
	 * strips out invalid characters to conform to QName specs.
	 * If the resulting name is null, returns "bpel" as a valid QName
	 * to guarantee that something valid is returned.
	 *
	 * TODO: This has to be a valid NCName ...
	 *
	 * @param str
	 *
	 * @return
	 */

	public static String generateValidName(String str) {

		StringBuilder result = new StringBuilder(""); //$NON-NLS-1$
		if (str != null) {
			for(char ch : str.trim().toCharArray()) {
				int destLength = result.length();
				if (((destLength == 0) && (Character.isLetter(ch) || ch == '_'))
					|| ((destLength > 0) && Character.isJavaIdentifierPart(ch))) {
					result.append(ch);
				}
			}
		}

		if (result.length() == 0)
			result.append(IBPELUIConstants.EXTENSION_BPEL);

		return result.toString();
	}

	/**
	 * Helper that traverses the IContainer hierarchy of the given modelObject in depth
	 * first fashion and applies the given visitor to each node.
	 *
	 * DO NOT USE THIS for anything that must see "all" model objects (including implicit
	 * sequences, for example).  Use TreeIterator modelObject.eAllContents() for that.
	 */
	public static void visitModelDepthFirst(Object modelObject, IModelVisitor visitor) {
		if (visitor.visit(modelObject)) {
			IContainer container = BPELUtil.adapt(modelObject, IContainer.class);
			if (container != null) {
				for (Iterator it = container.getChildren(modelObject).iterator(); it.hasNext(); ) {
					visitModelDepthFirst(it.next(), visitor);
				}
			}
			// TODO: Make this go away
			if (modelObject instanceof Flow) {
				// Hack: also visit the links of a flow!
				Flow flow = (Flow)modelObject;
				for (Iterator it = FlowLinkUtil.getFlowLinks(flow).iterator(); it.hasNext(); ) {
					visitModelDepthFirst(it.next(), visitor);
				}
			}
		}
	}

	private static class NameUnusedVisitor implements IModelVisitor {
		private boolean unused = true;
		private final String candidateName;
		private final Collection<EObject> ignoreObjects;

		NameUnusedVisitor(String candidateName, Collection<EObject> ignoreObjects) {
			this.candidateName = candidateName;
			if (ignoreObjects == null)  ignoreObjects = Collections.emptySet();
			this.ignoreObjects = ignoreObjects;
		}

		@Override
		public boolean visit(Object child) {
			if (!this.ignoreObjects.contains(child)) {
			INamedElement namedElement = BPELUtil.adapt(child, INamedElement.class);
				if (namedElement != null) {
					String name = namedElement.getName(child);
					if ((name != null) && (name.compareToIgnoreCase(this.candidateName) == 0))
						this.unused = false;
				}
			}
			return true;//unused;
		}

		public boolean isUnused() {
			return this.unused;
		}
	}

	/**
	 * checks if a name is available for use within the given process (i.e. if this name
	 * were added within the modelRoot, would it be unique).
	 */
	public static boolean isNameUnused(EObject modelRoot, String candidateName, Collection ignoreObjects) {
		NameUnusedVisitor visitor = new NameUnusedVisitor(candidateName, ignoreObjects);
		for (TreeIterator<EObject> it = modelRoot.eAllContents(); it.hasNext(); ) {
			visitor.visit(it.next());
			if (visitor.isUnused() == false) return false;
		}
		return true;
	}

	/**
	 * return a mangled name (based on the given hint) which is unique in the given process.
	 */
	public static String getUniqueModelName(EObject context, String hint, Collection ignoreObjects) {
		return getUniqueModelName2(context, hint, ignoreObjects);
	}

	/**
	 * return a mangled name (based on the given hint) which is unique in the given WSDL definition.
	 */
	public static String getUniqueModelName (Definition definition, String hint, Collection ignoreObjects) {
		return getUniqueModelName2(definition, hint, ignoreObjects);
	}

	protected static String getUniqueModelName2 (EObject modelRoot, String hint, Collection ignoreObjects) {

		// first try it exactly as hinted.
		String result = BPELUtil.generateValidName((hint==null)?"":hint.trim()); //$NON-NLS-1$
		if (isNameUnused(modelRoot, result, ignoreObjects))  return result;

		// go back to the first non-digit
		int digitPos = result.length()-1;
		while (digitPos >= 0 && Character.isDigit(result.charAt(digitPos)))  digitPos--;
		digitPos++; // move back to the digit
		String nameWithoutNum = result.substring(0, digitPos);

		// try increasing numbers until one is accepted.
		for (int num = 1; ; num++)  {
			result = nameWithoutNum+String.valueOf(num);
			if (isNameUnused(modelRoot, result, ignoreObjects))  return result;
		}
	}

	public static String generateUniqueModelName (EObject context, String hint, EObject model) {

		if (hint == null || "".equals(hint)) { //$NON-NLS-1$
			ILabeledElement element = BPELUtil.adapt(model, ILabeledElement.class);
			hint = (element != null) ? element.getTypeLabel(model) : ""; //$NON-NLS-1$
		}
		return BPELUtil.getUniqueModelName(context, hint, Collections.singletonList(model));
	}

	public static String getFilenameFromUri(String uri) {
		if (uri == null)  return Messages.BPELUtil__unknown_URI__54;
		// Hack. Why aren't we just using URI objects?
		int idx = Math.max(uri.lastIndexOf("/"), uri.lastIndexOf("\\")); //$NON-NLS-1$ //$NON-NLS-2$
		return (idx >= 0)? uri.substring(idx+1) : uri;
	}

	/**
	 * Converts the first letter of the target String to upper case.
	 * @param target
	 * @return the name with the first letter uppercased.
	 */
	public static String upperCaseFirstLetter (String target) {
		if (target.length() < 1) {
			return target;
		}
		StringBuilder buf = new StringBuilder (target.length());
		buf.append(target.substring(0, 1).toUpperCase());
		buf.append(target.substring(1, target.length()));
		return buf.toString();
	}

	/**
	 * Converts the first letter of the target String to lower case.
	 */
	public static String lowerCaseFirstLetter(String target) {
		if (target.length() < 1) {
			return target;
		}
		StringBuffer buf = new StringBuffer(target.length());
		buf.append(target.substring(0, 1).toLowerCase());
		buf.append(target.substring(1, target.length()));
		return buf.toString();
	}

	/**
	 * Returns all of the PropertyAlias objects from WSDL files in the same ResourceSet as
	 * the resource containing messageType, which are aliases for messageType.
	 */
	public static List<PropertyAlias> getPropertyAliasesForMessageType(Message messageType) {
		List<PropertyAlias> aliases = new ArrayList<PropertyAlias>();
		Resource resource = messageType.eResource();
		if (resource == null) {
			return aliases;
		}
		ResourceSet resourceSet = resource.getResourceSet();
		for (Iterator<Resource> it = resourceSet.getResources().iterator(); it.hasNext(); ) {
			resource = it.next();
			// TODO: this is a hack.  Why is there no WSDLResource interface??
			if (resource instanceof WSDLResourceImpl) {
				for (TreeIterator<EObject> treeIt = resource.getAllContents(); treeIt.hasNext(); ) {
					EObject object = treeIt.next();
					if (object instanceof PropertyAlias) {
						PropertyAlias alias = (PropertyAlias)object;
						if (messageType.equals(alias.getMessageType()))
							aliases.add(alias);
					}
				}
			}
		}
		return aliases;
	}

	// Creates an implicit sequence with a name that is unique in the editor's process.
	// Note that an ActivityExtension is created and inserted in the extension map,
	// but the implicit sequence itself should be inserted in the model by the caller.
	public static Sequence createImplicitSequence (Process process, ExtensionMap extensionMap) {
		Sequence impSeq = BPELFactory.eINSTANCE.createSequence();
		ModelHelper.createExtensionIfNecessary(extensionMap, impSeq);
		Collection ignoreObjects = Collections.singletonList(impSeq);
		if (ModelHelper.isSpecCompliant(process)) {
			impSeq.setName(getUniqueModelName(process, Messages.BPELUtil_Sequence_1, ignoreObjects));
		} else {
			impSeq.setName(getUniqueModelName(process, Messages.BPELUtil_HiddenSequence_2, ignoreObjects));
			((ActivityExtension)ModelHelper.getExtension(impSeq)).setImplicit(true);
		}
		// TODO: also give sequence a unique ID marked as implicit!
		return impSeq;
	}

	public static TreeIterator nodeAndAllContents(final EObject node) {
		final TreeIterator<EObject> allContents = node.eAllContents();
		return new TreeIterator() {
			boolean didNode = false;
			@Override
			public void prune() {
				// TODO: This won't work when calling on the first item.
				if (!this.didNode) throw new IllegalStateException();
				allContents.prune();
			}

			@Override
			public boolean hasNext() {
				if (this.didNode) return allContents.hasNext();
				return node != null;
			}

			@Override
			public Object next() {
				if (this.didNode) return allContents.next();
				this.didNode = true;	return node;
			}

			@Override
			public void remove() {
				// This won't work when calling on the first item.
				if (!this.didNode) throw new IllegalStateException();
				allContents.remove();
			}
		};
	}

	private static class RefreshActionVisitor implements IModelVisitor {
		private final GraphicalViewer viewer;
		public RefreshActionVisitor(GraphicalViewer viewer) {
			this.viewer = viewer;
		}

		@Override
		public boolean visit(Object child) {
			EditPart ep = (EditPart) this.viewer.getEditPartRegistry().get(child);
			if (ep != null && ep instanceof BPELEditPart) {
				IFigure fig = ((BPELEditPart)ep).getContentPane();
				if (fig != null) {
					((BPELEditPart)ep).regenerateVisuals();
					ep.refresh();
				}
			}
			if(ep instanceof LinkEditPart){
				ep.refresh();
			}
			return true;//unused;
		}
	}

	/**
	 * refreshes all the editparts of the process. Useful for changing layouts etc
	 */
	public static void regenerateVisuals(Process process, GraphicalViewer viewer) {
		RefreshActionVisitor visitor = new RefreshActionVisitor(viewer);
		visitModelDepthFirst(process, visitor);
		return;
	}


	/**
	 * The policy for whether a BPELEditPart's edges should be hilighted or not.  This one defers
	 * to the active tool if it is an IHilightControllingTool and says no otherwise.
	 */
	public static boolean shouldHilightEdges(EditDomain domain, EObject modelObject) {
		Tool tool = domain.getActiveTool();
		if (tool instanceof IHilightControllingTool) {
			return ((IHilightControllingTool)tool).hilightModelTarget(modelObject);
		}
		return false;
	}


	/**
	 * Used to determine the type of pattern to paint a container in the Process.
	 * Because the nesting of containers is confusing, we want to draw nice gradients
	 * to help the user.
	 * 1 and 3 return values mean solid fill.
	 * 0 and 2 mean gradient fills.
	 */
	public static int getRepaintFillType(IFigure fig) {
		int depth = 0;
		IFigure parent = fig.getParent();
		while (parent != null) {
			if (parent != null && parent.getBorder() != null &&  parent.getBorder() instanceof GradientBorder) {
				depth++;
			}
			parent = parent.getParent();
		}
		return depth % 4;
	}

	public static void sortFlowList(List<FlowEditPart> listOfFlowEditParts) {
		List<FlowEditPart> result = listOfFlowEditParts;
		int resultSize = result.size();

		for (int i = 0; i<resultSize; i++) {
			for (int j = i+1; j<resultSize; j++) {
				Flow flow1 = (Flow)(result.get(i)).getModel();
				Flow flow2 = (Flow)(result.get(j)).getModel();
				Flow[] parents = FlowLinkUtil.getParentFlows(flow2);
				for( Flow parent : parents ) {
					if (parent == flow1) {
						// flow2 must be layed out before flow1 so its size will be known!
						FlowEditPart temp = result.get(i);
						result.set(i, result.get(j));
						result.set(j, temp);
					}
				}
			}
		}
	}

	/**
	 * Refresh the given ComboViewer, and also make sure selectedObject is selected in it.
	 */
	public static void refreshCombo(ComboViewer viewer, Object selectedObject) {
		viewer.refresh();
		String s = ((ILabelProvider)viewer.getLabelProvider()).getText(selectedObject);
		viewer.getCombo().setText(s);
	}

	/**
	 * Helper method to calculate the width of a button.
	 * This is necessary for internationalization and accessibility.
	 * Returned value is the calculated width or defaultSize, whichever
	 * is larger.
	 */
	public static int calculateButtonWidth(Widget widget, int defaultSize){
		GC gc;
		int width = 0;

		if (widget instanceof Button) {
			Button w = (Button)widget;
			gc = new GC(w);
			gc.setFont(w.getFont());
			width = gc.textExtent(w.getText()).x + 17;
			gc.dispose();
			return Math.max(width, defaultSize);
		}
		return defaultSize;
	}


	public static String getMaxLengthString(String strings[]) {
		int max = -1;
		int index = -1;
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].length() > max) {
				max = strings[i].length();
				index = i;
			}
		}

		if (index >= 0) return strings[index];
		return "";  //$NON-NLS-1$
	}

	/**
	 * Helper method to calculate the width of a CLabel.
	 * This is necessary for internationalization and accessibility.
	 *
	 * Returned value is the calculated width or defaultSize, whichever
	 * is larger.
	 */
	public static int calculateLabelWidth(Widget widget, int defaultSize){
		GC gc;
		int width = 0;

		if (widget instanceof CLabel) {
			CLabel w = (CLabel)widget;
			gc = new GC(w);
			gc.setFont(w.getFont());
			width = gc.textExtent(w.getText()).x + 17;
			gc.dispose();

			return Math.max(width, defaultSize);
		}
		if (widget instanceof DecoratedLabel) {
			DecoratedLabel w = (DecoratedLabel)widget;
			gc = new GC(w);
			gc.setFont(w.getFont());
			width = gc.textExtent(w.getText()).x + 17;
			gc.dispose();
			return Math.max(width, defaultSize);
		}


		if (widget instanceof Label) {
			Label w = (Label)widget;
			gc = new GC(w);
			gc.setFont(w.getFont());
			width = gc.textExtent(w.getText()).x + 5;
			gc.dispose();
			return Math.max(width, defaultSize);
		}
		return defaultSize;
	}

	public static IFile getFileFromURI(URI uri) {
		if (uri.isFile()) {
			return getFileFromDeviceURI(uri);
		}
		return getFileFromPlatformURI(uri);
	}

	public static IFile getFileFromDeviceURI(URI uri) {
		String device = uri.device();
		Iterator pathIt = uri.segmentsList().iterator();
		StringBuffer path = new StringBuffer();
		while (pathIt.hasNext()) {
			path.append("/" + pathIt.next()); //$NON-NLS-1$
		}
		return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(device, path.toString()));
	}

	public static IFile getFileFromPlatformURI(URI uri) {
		String [] segs  = uri.segments();
		IPath path = null;
		// start at 1 to skip resource
		for (int i = 1; i< segs.length; i++) {
			if (path == null) {
				path = new Path(segs[i]);
			} else {
				path = path.append(segs[i]);
			}
		}
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	}

	/**
	 * Function to return a platform URI from a standard hierarchital URI.
	 * Normally we can use URI.createPlatformURI, but that function always assumes
	 * that it is non-platform
	 */
	public static URI getPlatformURI(URI uri) {
		String str = uri.toString();
		if (str.startsWith("platform:")) return uri; //$NON-NLS-1$
		return URI.createPlatformResourceURI(uri.toString());
	}

	/* external fault handler helpers */

	public static boolean getShowFaultHandler(EditPart part) {
		if (part instanceof ScopeEditPart)
			return ((ScopeEditPart)part).getShowFaultHandler();
		else if (part instanceof InvokeEditPart)
			return ((InvokeEditPart)part).getShowFaultHandler();
		else if (part instanceof StartNodeEditPart)
			return ((StartNodeEditPart)part).getShowFaultHandler();
		return false;
	}

	public static void setShowFaultHandler(EditPart part, boolean show) {
		if (part instanceof ScopeEditPart)
			((ScopeEditPart)part).setShowFaultHandler(show);
		else if (part instanceof InvokeEditPart)
			((InvokeEditPart)part).setShowFaultHandler(show);
		else if (part instanceof StartNodeEditPart)
			((StartNodeEditPart)part).setShowFaultHandler(show);
	}

	/* external compensation handler helpers */

	public static boolean getShowCompensationHandler(EditPart part) {
		if (part instanceof ScopeEditPart)
			return ((ScopeEditPart)part).getShowCompensationHandler();
		else if (part instanceof InvokeEditPart)
			return ((InvokeEditPart)part).getShowCompensationHandler();
		return false;
	}

	public static boolean getShowTerminationHandler(EditPart part) {
		if (part instanceof ScopeEditPart)
			return ((ScopeEditPart)part).getShowTerminationHandler();
		return false;
	}

	public static void setShowCompensationHandler(EditPart part, boolean show) {
		if (part instanceof ScopeEditPart)
			((ScopeEditPart)part).setShowCompensationHandler(show);
		else if (part instanceof InvokeEditPart)
			((InvokeEditPart)part).setShowCompensationHandler(show);
	}

	public static void setShowTerminationHandler(EditPart part, boolean show) {
		if (part instanceof ScopeEditPart)
			((ScopeEditPart)part).setShowTerminationHandler(show);
	}

	/* external event handler helpers */

	public static boolean getShowEventHandler(EditPart part) {
		if (part instanceof ScopeEditPart)
			return ((ScopeEditPart)part).getShowEventHandler();
		else if (part instanceof StartNodeEditPart)
			return ((StartNodeEditPart)part).getShowEventHandler();
		return false;
	}

	public static void setShowEventHandler(EditPart part, boolean show) {
		if (part instanceof ScopeEditPart)
			((ScopeEditPart)part).setShowEventHandler(show);
		else if (part instanceof StartNodeEditPart)
			((StartNodeEditPart)part).setShowEventHandler(show);
	}

	/**
	 * Returns the extension file of the given BPEL file.
	 */
	public static IFile getBPELEXFile(IFile bpelFile) {
		IPath path = bpelFile.getFullPath().removeFileExtension().addFileExtension(IBPELUIConstants.EXTENSION_MODEL_EXTENSIONS);
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	}

	/**
	 * Returns the artifacts WSDL of the given BPEL file.
	 */
	public static IFile getArtifactsWSDLFile(IFile bpelFile) {
		IPath wsdlPath = bpelFile.getFullPath().removeFileExtension();
		String fileName = wsdlPath.lastSegment() + "Artifacts"; //$NON-NLS-1$
		wsdlPath = wsdlPath.removeLastSegments(1).append(fileName);
		wsdlPath = wsdlPath.addFileExtension(IBPELUIConstants.EXTENSION_WSDL);
		return ResourcesPlugin.getWorkspace().getRoot().getFile(wsdlPath);
	}

	public static Image getImage(IMarker marker) {
	    Image img = ModelMarkerUtil.getImage(marker);
	    ImageData background = null;
	    if (img != null) {
	    	background = img.getImageData();
	    }
		if (background == null) {
			// Don't give up yet. If this is also a problem marker, we can find an image to
			// display...
			try {
				if (marker.isSubtypeOf(IMarker.PROBLEM)) {
					background = ImageUtils.getImage(marker).getImageData();
				}
			} catch (CoreException e) {
				BPELUIPlugin.log(e);
				return null;
			}
		}
		if (background == null) return null;
		String uri = marker.getAttribute(IBPELUIConstants.MARKER_OVERLAYIMAGETOPLEFT, ""); //$NON-NLS-1$
		ImageData topLeft = getImageData(uri);
		uri = marker.getAttribute(IBPELUIConstants.MARKER_OVERLAYIMAGETOPRIGHT, ""); //$NON-NLS-1$
		ImageData topRight = getImageData(uri);
		uri = marker.getAttribute(IBPELUIConstants.MARKER_OVERLAYIMAGEBOTTOMLEFT, ""); //$NON-NLS-1$
		ImageData bottomLeft = getImageData(uri);
		uri = marker.getAttribute(IBPELUIConstants.MARKER_OVERLAYIMAGEBOTTOMRIGHT, ""); //$NON-NLS-1$
		ImageData bottomRight = getImageData(uri);
		OverlayCompositeImageDescriptor descriptor = new OverlayCompositeImageDescriptor(background, topLeft, topRight, bottomLeft, bottomRight);
		return descriptor.createImage();
	}

	private static ImageData getImageData(String uri) {
		if (uri.length() == 0) return null;
		URL url = null;
		try {
			url = new URL(uri);
		} catch (MalformedURLException e) {
			return null;
		}
		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
		return desc.getImageData();
	}

	/**
	 * Returns the EditPart which is responsible for the given IFigure.
	 */
	public static EditPart mapFigure2EditPart(EditPartViewer viewer, IFigure figure) {
		Map visualPartMap = viewer.getVisualPartMap();
		EditPart part = null;
		while (part == null && figure != null) {
			part = (EditPart)visualPartMap.get(figure);
			figure = figure.getParent();
		}
		return part;
	}

	/**
	 * Reads the process from disk.
	 */
	public static Process getProcess(IResource bpelFile, ResourceSet resourceSet) throws IOException {
		URI uri = URI.createPlatformResourceURI(bpelFile.getFullPath().toString());
		Resource processResource = resourceSet.getResource(uri, true);
		EList<EObject> contents = processResource.getContents();
		if (!contents.isEmpty()) {
			return (Process) contents.get(0);
		}
		return null;
	}

	public static AccessibleEditPart getAccessibleEditPart(GraphicalEditPart part) {
		final GraphicalEditPart thisPart = part;

		return new AccessibleEditPart() {
				@Override
				public void getName(AccessibleEvent e) {
					String childType = null;
					String displayName = null;
					ILabeledElement labeledElement = BPELUtil.adapt(thisPart.getModel(), ILabeledElement.class);
					if (labeledElement != null) {
						childType = labeledElement.getTypeLabel(thisPart.getModel());
						displayName = labeledElement.getLabel(thisPart.getModel());
						if (childType != null && displayName.equals(childType)) {
							childType = null;
						}
					} else {
						e.result = null;
						return;
					}

					// return something reasonable (type followed by name if any)
					// or nothing at all

					StringBuffer concat = new StringBuffer();
					if (childType != null && childType.length() > 0)
						concat.append(childType);
					if (concat.length() > 0)
						concat.append(" "); //$NON-NLS-1$
					if (displayName != null && displayName.length() > 0)
						concat.append(displayName);
					if (concat.length() > 0)
						e.result = concat.toString();
					else
						e.result = null;
					return;
				}

				@Override
				public void getChildCount(AccessibleControlEvent e) {
					List<EditPart> list = thisPart.getChildren();
					int count = 0;
					for (EditPart part : list) {
						AccessibleEditPart access = (AccessibleEditPart)part.getAdapter(AccessibleEditPart.class);
						if (access == null)
							continue;
						count++;
					}
					e.detail = count;
				}

				@Override
				public void getChildren(AccessibleControlEvent e) {
					List<EditPart> list = thisPart.getChildren();
					Vector<Integer> childList = new Vector<Integer>();
					for (EditPart part : list) {
						AccessibleEditPart access = (AccessibleEditPart)part.getAdapter(AccessibleEditPart.class);
						if (access == null)
							continue;
						childList.add( Integer.valueOf( access.getAccessibleID()));
					}
					e.children = childList.toArray();
				}

				@Override
				public void getLocation(AccessibleControlEvent e) {
					Rectangle bounds = thisPart.getFigure().getBounds().getCopy();
					thisPart.getFigure().translateToAbsolute(bounds);
					org.eclipse.swt.graphics.Point p = new org.eclipse.swt.graphics.Point(0, 0);
					p = thisPart.getViewer().getControl().toDisplay(p);
					e.x = bounds.x + p.x;
					e.y = bounds.y + p.y;
					e.width = bounds.width;
					e.height = bounds.height;
				}

				/**
				 * @see AccessibleEditPart#getState(AccessibleControlEvent)
				 */
				@Override
				public void getState(AccessibleControlEvent e) {
					e.detail = ACC.STATE_SELECTABLE | ACC.STATE_FOCUSABLE;
					if (thisPart.getSelected() != EditPart.SELECTED_NONE)
						e.detail |= ACC.STATE_SELECTED;
					if (thisPart.getViewer().getFocusEditPart() == thisPart)
						e.detail = ACC.STATE_FOCUSED;
				}
			};
	}


	/** creates a table cursor that can be used to navigate tables for keyboard accessibility **/

	public static TableCursor createTableCursor(final Table table, final TableViewer tableViewer) {
		// create a TableCursor to navigate around the table
		final TableCursor cursor = new TableCursor(table, SWT.NONE);
		cursor.addSelectionListener(new SelectionAdapter() {
			// when the TableEditor is over a cell, select the corresponding row in the table
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cursor.getRow() != null)
					table.setSelection(new TableItem[] {cursor.getRow()});
			}
			// when the user hits "ENTER" in the TableCursor, pop up an editor
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				TableItem row = cursor.getRow();
				if (row != null) {
					int nRow = table.indexOf(row);
					int column = cursor.getColumn();
					Object obj = tableViewer.getElementAt(nRow);
					tableViewer.editElement(obj, column);
				}
			}
		});

		// Hide the TableCursor when the user hits the "CTRL" or "SHIFT" key.
		// This alows the user to select multiple items in the table.
		cursor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.keyCode == SWT.CTRL) || (e.keyCode == SWT.SHIFT)	||
					(e.stateMask & SWT.CONTROL) != 0	|| (e.stateMask & SWT.SHIFT) != 0) {
					cursor.setVisible(false);
				}
			}
		});

		cursor.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent e) { }
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem row = cursor.getRow();
				if (row != null) {
					int nRow = table.indexOf(row);
					int column = cursor.getColumn();
					Object obj = tableViewer.getElementAt(nRow);
					tableViewer.editElement(obj, column);
				}
			}
			@Override
			public void mouseUp(MouseEvent e) {
			}
		});

		// Show the TableCursor when the user releases the "SHIFT" or "CTRL" key.
		// This signals the end of the multiple selection task.
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.CONTROL && (e.stateMask & SWT.SHIFT) != 0)
					return;
				if (e.keyCode == SWT.SHIFT && (e.stateMask & SWT.CONTROL) != 0)
					return;
				if (e.keyCode != SWT.CONTROL && (e.stateMask & SWT.CONTROL) != 0)
					return;
				if (e.keyCode != SWT.SHIFT && (e.stateMask & SWT.SHIFT) != 0)
					return;

				if (table.getItemCount() == 0)
					return;
				TableItem[] selection = table.getSelection();
				TableItem row = (selection.length == 0) ? table.getItem(table.getTopIndex()) : selection[0];
				table.showItem(row);
				cursor.setSelection(row, 0);
				cursor.setVisible(true);
				cursor.setFocus();
			}
		});
		return cursor;
	}

	public static ResourceSet createResourceSetImpl() {
		// TODO: Extensibility
		return new ResourceSetImpl();
	}

	static final NCNameWordDetector NCNAME_DETECTOR = new NCNameWordDetector ();

	/**
	 * Returns a validator that checks that the new value is a valid NCName.
	 */
	public static IInputValidator getNCNameValidator() {
		return new IInputValidator() {
			@Override
			public String isValid (String newText) {
				if ( NCNAME_DETECTOR.isValid( newText ) == false ) {
					return Messages.BPELUtil_NCName;
				}
				// TODO ! temporary hack
				return null;
			}
		};
	}

	public static void deleteNonContainmentRefs(EObject modelObject, Collection referents) {
		if (modelObject == null) return;
		for (EReference feature : modelObject.eClass().getEAllReferences()) {
			if (feature.isMany()) {
				EList<Object> list = (EList<Object>)modelObject.eGet(feature, true);
				for (Object referent : referents) {
					if (list.contains(referent)) list.remove(referent);
					// TODO: support non-changeable features!  print a warning.
				}
			} else {
				Object oldValue = modelObject.eGet(feature, true);
				for (Object referent : referents) {
					if (oldValue == referent) {
						if (feature.isUnsettable()) {
							// this is okay, default is always null for EReferences.
							modelObject.eUnset(feature);
						} else {
							modelObject.eSet(feature, null);
						}
						break;
					}
					// TODO: support non-changeable features!  print a warning.
				}
			}
		}
	}

	//@return:  returns arraylist with all activities the compensate
	//			can validly point to
	public static ArrayList getCompensableActivities(Object context){
		final ArrayList returnObjects = new ArrayList();
		if (context instanceof CompensateScope) {
			CompensateScope compensateScope = (CompensateScope) context;
			EObject enclosingContainer = compensateScope;
			if (compensateScope.eContainer() != null) {
				enclosingContainer = enclosingContainer.eContainer();
				// Go to parent scope where compensate is contained
				while (!(enclosingContainer instanceof Scope)
						&& (enclosingContainer.eContainer() != null)) {
					enclosingContainer = enclosingContainer.eContainer();
				}
			}

			// Put all scopes and invokes within parent scope in arraylist
			visitModelDepthFirst(enclosingContainer,
					new IModelVisitor() {
						@Override
						public boolean visit(Object modelObject) {
							if (modelObject instanceof Scope) {
								returnObjects.add(modelObject);
							} else if (modelObject instanceof Invoke) {
								returnObjects.add(modelObject);
							}
							return true;
						}
					});
			// https://issues.jboss.org/browse/JBIDE-8044
			if (!returnObjects.isEmpty())
				returnObjects.remove(0);	//remove the scope containing the compensate
			return returnObjects;
		}
		throw new IllegalArgumentException();
	}

	public static Object resolveXSDObject(Object xsdObject) {
		if (xsdObject instanceof XSDElementDeclaration) {
			XSDElementDeclaration resolvedElement = ((XSDElementDeclaration)xsdObject).getResolvedElementDeclaration();
			if (resolvedElement != null) xsdObject = resolvedElement;
		} else if (xsdObject instanceof XSDAttributeDeclaration) {
			XSDAttributeDeclaration resolvedAttribute = ((XSDAttributeDeclaration)xsdObject).getResolvedAttributeDeclaration();
			if (resolvedAttribute != null) xsdObject = resolvedAttribute;
		}
		return xsdObject;
	}

	public static String debugObject(Object object) {
		if (object == null) return "null"; //$NON-NLS-1$
		if (object instanceof String) { return "\""+(String)object+"\""; } //$NON-NLS-1$ //$NON-NLS-2$
		if (object.getClass().getName().startsWith("java.lang")) { //$NON-NLS-1$
			return object.toString();
		}
		if (object instanceof List) {
			StringBuffer b = new StringBuffer("("); //$NON-NLS-1$
			for (Iterator it = ((List)object).iterator(); it.hasNext(); ) {
				b.append(debugObject(it.next()));
				if (it.hasNext()) b.append(", "); //$NON-NLS-1$
			}
			b.append(")"); //$NON-NLS-1$
			return b.toString();
		}
		if (object instanceof QName) {
			QName qname = (QName)object;
			return "QName(\""+qname.getNamespaceURI()+"\", \""+qname.getLocalPart()+"\")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		StringBuffer b = new StringBuffer(shortClassName(object.getClass()));
		boolean proxy = (object instanceof EObject) && ((EObject)object).eIsProxy();
		if (proxy) b.append("-proxy"); //$NON-NLS-1$
		boolean isEObject = (object instanceof EObject);
		INamedElement namedElement = null;
		if (isEObject) {
			namedElement = BPELUtil.adapt(object, INamedElement.class);
			if (namedElement != null) {
				try {
					String s = namedElement.getName(object);
					b.append((s==null)? "<null>" : "<\""+s+"\">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				} catch (Exception e) {
					b.append("<???>"); //$NON-NLS-1$
				}
			}
		}
		if (namedElement==null) {
			b.append("{"); b.append(String.valueOf(object.hashCode())); b.append("}"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return b.toString();
	}

	public static String debug(Notification n) {
		StringBuffer b = new StringBuffer(shortClassName(n.getClass()));
		b.append("("); //$NON-NLS-1$
		b.append(debugObject(n.getNotifier()));
		b.append(", "); //$NON-NLS-1$
		switch (n.getEventType()) {
		case Notification.SET-1: b.append("CREATE"); break; //$NON-NLS-1$
		case Notification.SET: b.append("SET"); break; //$NON-NLS-1$
		case Notification.UNSET: b.append("UNSET"); break; //$NON-NLS-1$
		case Notification.ADD: b.append("ADD"); break; //$NON-NLS-1$
		case Notification.REMOVE: b.append("REMOVE"); break; //$NON-NLS-1$
		case Notification.ADD_MANY: b.append("ADD_MANY"); break; //$NON-NLS-1$
		case Notification.MOVE: b.append("MOVE"); break; //$NON-NLS-1$
		case Notification.REMOVING_ADAPTER: b.append("REMOVING_ADAPTER"); break; //$NON-NLS-1$
		case Notification.RESOLVE: b.append("RESOLVE"); break; //$NON-NLS-1$
		default: b.append("??? ("+String.valueOf(n.getEventType())+")"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		b.append(" "); //$NON-NLS-1$
		EStructuralFeature feature = (EStructuralFeature)n.getFeature();
		if (feature == null) b.append("???"); else b.append(feature.getName()); //$NON-NLS-1$
		if (n.getPosition() >= 0) {
			b.append("["); //$NON-NLS-1$
			b.append(String.valueOf(n.getPosition()));
			b.append("]"); //$NON-NLS-1$
		} else {
			if (feature != null && feature.isMany()) b.append("{***}"); //$NON-NLS-1$
		}
		b.append(": "); //$NON-NLS-1$
		b.append(debugObject(n.getOldValue()));
		b.append(" --> "); //$NON-NLS-1$
		b.append(debugObject(n.getNewValue()));
		b.append(")"); //$NON-NLS-1$
		return b.toString();

	}
	protected static String shortClassName(Class clazz) {
		StringBuffer b = new StringBuffer(clazz.getName());
		for (int i = b.indexOf("."); i >= 0; i = b.indexOf(".")) b.delete(0,i+1); //$NON-NLS-1$ //$NON-NLS-2$
		//if (b.indexOf("Impl") == b.length()-4) b.delete(b.length()-4, b.length()));
		return b.toString();
	}

	/**
	 * Creates a composite with a flat border around it.
	 */
	public static Composite createBorderComposite(Composite parent, TabbedPropertySheetWidgetFactory wf) {
		final Composite result = wf.createComposite(parent);
		FillLayout layout = new FillLayout();
		final int margin = 1;
		layout.marginHeight = margin;
		layout.marginWidth = margin;
		result.setLayout(layout);
		result.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				org.eclipse.swt.graphics.Rectangle bounds = result.getBounds();
				bounds.x = margin-1;
				bounds.y = margin-1;
				bounds.width = bounds.width - (margin*2) + 1;
				bounds.height = bounds.height - (margin*2) + 1;
				e.gc.drawRectangle(bounds);
			}
		});
		return result;
	}

	static void addVariablesToMap(Map<String, Variable> targetMap, Variables vars, Variable refVar ) {
		if (vars == null) {
			return;
		}
		for(Variable v : vars.getChildren()) {
			// scoping for initialization (only visible from).
			if (v == refVar) {
				break;
			}
			if (v.getName() != null) {
				targetMap.put(v.getName(),v);
			}
		}
	}


	static void addVisibleVariables (Map<String,Variable> targetMap, EObject target, Variable refVariable ) {
		if (target == null) {
			return;
		}
		if (target instanceof Resource) {
			return;
		}

		if (target instanceof Process) {
			addVariablesToMap(targetMap, ((Process)target).getVariables(), refVariable );
			return ;
		}
		// recursively add less local variables first
		addVisibleVariables(targetMap, target.eContainer(), refVariable );

		if (target instanceof Scope) {
			addVariablesToMap(targetMap, ((Scope)target).getVariables(), refVariable );
		}
		if (target instanceof Catch) {
			Variable v = ((Catch)target).getFaultVariable();
			if (v != null && v.getName() != null) {
				targetMap.put(v.getName(), v);
			}
		}
		if (target instanceof OnEvent) {
			Variable v = ((OnEvent)target).getVariable();
			if (v != null && v.getName() != null) {
				targetMap.put(v.getName(), v);
			}
		}

		if (target instanceof ForEach) {
			Variable v = ((ForEach)target).getCounterName();
			if (v != null && v.getName() != null) {
				targetMap.put(v.getName(), v);
			}
		}
	}

	private static void addPartnerLinksToMap(Map<String, PartnerLink> targetMap, PartnerLinks plinks) {
		if (plinks == null) return;
		for (PartnerLink p : plinks.getChildren()) {
			if (p.getName() != null) targetMap.put(p.getName(), p);
		}
	}
	private static void addVisiblePartnerLinks(Map<String, PartnerLink> targetMap, EObject target) {
		if (target == null) return;
		if (target instanceof Resource) return;
		if (target instanceof Process) {
			addPartnerLinksToMap(targetMap, ((Process)target).getPartnerLinks());
		} else {
			// recursively add less local partnerlinks first
			addVisiblePartnerLinks(targetMap, target.eContainer());
			if (target instanceof Scope) {
				addPartnerLinksToMap(targetMap, ((Scope)target).getPartnerLinks());
			}
		}
	}

	private static void addCorrelationSetsToMap(Map<String, CorrelationSet> targetMap, CorrelationSets csets) {
		if (csets == null) return;
		for( CorrelationSet c : csets.getChildren() ) {
			if (c.getName() != null) targetMap.put(c.getName(), c);
		}
	}
	private static void addVisibleCorrelationSets(Map<String, CorrelationSet> targetMap, EObject target) {
		if (target == null) return;
		if (target instanceof Resource) return;
		if (target instanceof Process) {
			addCorrelationSetsToMap(targetMap, ((Process)target).getCorrelationSets());
		} else {
			// recursively add less local correlationsets first
			addVisibleCorrelationSets(targetMap, target.eContainer());
			if (target instanceof Scope) {
				addCorrelationSetsToMap(targetMap, ((Scope)target).getCorrelationSets());
			}
		}
	}

	/**
	 * Look up the variables visible to a certain context activity (or the whole process).
	 * Variables in BPEL follow lexical scoping rules (resolved OASIS issue 101).
	 *
	 * The returned variables are in no particular order.
	 */
	public static Variable[] getVisibleVariables (EObject target) {

		Map<String,Variable> name2Variable = new HashMap<String,Variable>();

		addVisibleVariables(name2Variable, target,  target instanceof Variable ? (Variable) target: null );

		if (name2Variable.isEmpty()) {
			return EMPTY_VARIABLE_ARRAY;
		}

		Collection<Variable> variables =  name2Variable.values();
		if (variables.size() == 1) {
			return variables.toArray(EMPTY_VARIABLE_ARRAY);
		}
		ArrayList<Variable> list = new ArrayList<Variable>( variables );
		Collections.sort(list, new Comparator<Variable>() {
			@Override
			public int compare(Variable o1, Variable o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return list.toArray(EMPTY_VARIABLE_ARRAY);
	}

	/**
	 * Look up the PartnerLinks visible to a certain context activity (or the whole process).
	 * When local PartnerLinks are added to the spec, they will follow lexical scoping rules
	 * just like variables.
	 *
	 * The returned PartnerLinks are in no particular order.
	 */
	public static PartnerLink[] getVisiblePartnerLinks(EObject target) {
		Map<String, PartnerLink> name2PartnerLink = new HashMap<String, PartnerLink>();
		addVisiblePartnerLinks(name2PartnerLink, target);
		if (name2PartnerLink.isEmpty()) return EMPTY_PARTNERLINK_ARRAY;
		PartnerLink[] result = new PartnerLink[name2PartnerLink.size()];
		name2PartnerLink.values().toArray(result);
		return result;
	}

	/**
	 * Look up the PartnerLinks visible to a certain context activity (or the whole process).
	 * When local PartnerLinks are added to the spec, they will follow lexical scoping rules
	 * just like variables.
	 *
	 * The returned PartnerLinks are in no particular order.
	 */
	public static CorrelationSet[] getVisibleCorrelationSets(EObject target) {
		Map<String, CorrelationSet> name2CorrelationSet = new HashMap<String, CorrelationSet>();
		addVisibleCorrelationSets(name2CorrelationSet, target);
		if (name2CorrelationSet.isEmpty()) return EMPTY_CORRELATIONSET_ARRAY;
		CorrelationSet[] result = new CorrelationSet[name2CorrelationSet.size()];
		name2CorrelationSet.values().toArray(result);
		return result;
	}

	/**
	 * If the given message is used by an operation in the same definition,
	 * returns the Operation that uses the given message.
	 * Otherwise, returns null.
	 */
	public static Operation getOperationFromMessage(Message message) {
		if (message == null) return null;
		Definition def = message.getEnclosingDefinition();
		if (def == null) return null;
		Iterator<PortType> ptIt = def.getEPortTypes().iterator();
		while (ptIt.hasNext()) {
			PortType pt = ptIt.next();
			Iterator<Operation> it = pt.getOperations().iterator();
			while (it.hasNext()) {
				Operation op = it.next();
				Input input = op.getEInput();
				if (input != null) {
					if (input.getMessage().getQName().equals(message.getQName())) {
						return op;
					}
				}
				Output output = op.getEOutput();
				if (output != null) {
					if (output.getMessage().getQName().equals(message.getQName())) {
						return op;
					}
				}
				Iterator<Fault> faultIterator = op.getEFaults().iterator();
				while (faultIterator.hasNext()) {
					Fault fault = faultIterator.next();
					Message faultMessage = fault.getEMessage();
					if (faultMessage != null) {
						if (faultMessage.getQName() != null) {
							if (faultMessage.getQName().equals(message.getQName())) {
								return op;
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static void openEditor(EObject modelObject, BPELEditor editor) {
		try {
			// https://issues.jboss.org/browse/JBIDE-8044
			if (modelObject==null) {
				// https://issues.jboss.org/browse/JBIDE-8601
				MessageDialog.openError(editor.getEditorSite().getShell(),
						Messages.BPELUtil__Error,
						Messages.BPELUtil_NoEditorForNullObject);
				return;
			}

			EObject resolvedObject = null;
			if (modelObject.eResource()==null) {
				// https://jira.jboss.org/browse/JBIDE-7351
				// try to resolve proxies here, otherwise we don't know editor input
				if (modelObject.eIsProxy()) {
					resolvedObject = EmfModelQuery.resolveProxy(editor.getProcess(), modelObject);
				}
			}
			else
				resolvedObject = modelObject;

			if (resolvedObject==null) {
				// https://issues.jboss.org/browse/JBIDE-8601
				MessageDialog.openError(editor.getEditorSite().getShell(),
						Messages.BPELUtil__Error, NLS.bind(
								Messages.BPELUtil_NoEditorForObject,
								(new Object[] { modelObject.getClass().getSimpleName() })));
				return;
			}
			IFile file = BPELUtil.getFileFromURI(resolvedObject.eResource().getURI());
			IDE.openEditor(editor.getSite().getWorkbenchWindow().getActivePage(), file);
		} catch (PartInitException ex) {
			BPELUIPlugin.log(ex, IStatus.WARNING);
		}
	}

	/**
	 * Returns the BPEL file associated with the given process.
	 */
	public static IFile getBPELFile(Process process) {
		return getFileFromURI(process.eResource().getURI());
	}



	public static String lookupOrCreateNamespacePrefix ( EObject context, String namespace, String prefix, Shell shell ) {

		String nsPrefix = BPELUtils.getNamespacePrefix(context, namespace);
		if (nsPrefix != null && nsPrefix.length() > 0) {
			return nsPrefix;
		}

		NamespaceMappingDialog dialog = new NamespaceMappingDialog (shell, context);
		dialog.setNamespace(namespace);
		if (prefix != null) {
			dialog.setPrefix(prefix);
		}

		if (dialog.open() == Window.CANCEL) {
			return nsPrefix;
		}

		nsPrefix = dialog.getPrefix();
		BPELUtils.setNamespacePrefix(context, namespace, nsPrefix);
		return nsPrefix;
	}


	/**
	 * Traverses the root object and returns all objects under it that are of the same
	 * class or subclasses of "target".
	 */
	public static List<EObject> getAllEObjectsOfType(EObject root, EClass eClass) {
		List<EObject> allElems = new ArrayList<EObject>();
		for (TreeIterator<EObject> iter = root.eAllContents(); iter.hasNext();) {
			EObject element = iter.next();
			if (eClass.isSuperTypeOf(element.eClass()) ||
				element.eClass() == eClass) {
				allElems.add(element);
			}
		}
		return allElems;
	}


	public static boolean isBPELProject(IProject project){
		if (project == null) {
			return false;
		}
		if (ModuleCoreNature.isFlexibleProject(project)) {
			IFacetedProject fproj = null;
			try {
			    fproj = ProjectFacetsManager.create(project);
			} catch (CoreException e) {
				return false;
			}
			if (fproj.hasProjectFacet(getBPELFacetVersion())) {
				return true;
			}
			// added for backward compatibility with jbt.bpel.facet.core:
			if (fproj.hasProjectFacet(getJBT_BPELFacetVersion())) {
				return true;
			}
		}
		return false;

	}

	public static IProjectFacetVersion getBPELFacetVersion() {
		IProjectFacet bpelFacet = ProjectFacetsManager.getProjectFacet(IBPELModuleFacetConstants.BPEL20_PROJECT_FACET);
		IProjectFacetVersion bpelFacetVersion = bpelFacet.getVersion(IBPELModuleFacetConstants.BPEL20_MODULE_VERSION);
		return bpelFacetVersion;
	}

	public static IProjectFacetVersion getJBT_BPELFacetVersion() {
		IProjectFacet bpelFacet = ProjectFacetsManager.getProjectFacet(IBPELModuleFacetConstants.JBT_BPEL20_PROJECT_FACET);
		IProjectFacetVersion bpelFacetVersion = bpelFacet.getVersion(IBPELModuleFacetConstants.BPEL20_MODULE_VERSION);
		return bpelFacetVersion;
	}


	public static org.eclipse.core.resources.IContainer getBPELContentFolder(IProject project) {
		org.eclipse.core.resources.IContainer bpelContent = null;
		if (BPELUtil.isBPELProject(project)) {
			IPath rootPath = getWebContentRootPath(project);
			if (rootPath != null && !rootPath.isEmpty()) {
				bpelContent = project.getFolder(rootPath);
			}
		}
		return bpelContent;
	}

	public static IPath getWebContentRootPath(IProject project) {
		IPath path = null;
		IVirtualComponent component = ComponentCore.createComponent(project);
		if (component != null && component.exists()) {
			path = component.getRootFolder().getProjectRelativePath();
		}
		return path;
	}
}