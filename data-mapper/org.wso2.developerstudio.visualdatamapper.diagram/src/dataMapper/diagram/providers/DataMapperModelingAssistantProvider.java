package dataMapper.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class DataMapperModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof dataMapper.diagram.edit.parts.DataMapperRootEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperDiagram_2001);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.DataMapperDiagramEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Input_3001);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Output_3002);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Concat_3013);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.InputEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3004);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.TreeNodeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3005);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Attribute_3006);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Element_3007);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.TreeNode2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3005);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Attribute_3006);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Element_3007);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.AttributeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.InNode_3009);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3010);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.ElementEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.InNode_3011);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3012);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.OutputEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3008);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.TreeNode3EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3005);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Attribute_3006);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.Element_3007);
			return types;
		}
		if (editPart instanceof dataMapper.diagram.edit.parts.ConcatEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.InNode_3014);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3015);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.InNode_3016);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNodeEditPart) {
			return ((dataMapper.diagram.edit.parts.OutNodeEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNode2EditPart) {
			return ((dataMapper.diagram.edit.parts.OutNode2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNode3EditPart) {
			return ((dataMapper.diagram.edit.parts.OutNode3EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNodeEditPart) {
			return ((dataMapper.diagram.edit.parts.InNodeEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNode2EditPart) {
			return ((dataMapper.diagram.edit.parts.InNode2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNode3EditPart) {
			return ((dataMapper.diagram.edit.parts.InNode3EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNode4EditPart) {
			return ((dataMapper.diagram.edit.parts.InNode4EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNodeEditPart) {
			return ((dataMapper.diagram.edit.parts.OutNodeEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNode2EditPart) {
			return ((dataMapper.diagram.edit.parts.OutNode2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNode3EditPart) {
			return ((dataMapper.diagram.edit.parts.OutNode3EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNodeEditPart) {
			return ((dataMapper.diagram.edit.parts.InNodeEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNode2EditPart) {
			return ((dataMapper.diagram.edit.parts.InNode2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNode3EditPart) {
			return ((dataMapper.diagram.edit.parts.InNode3EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNode4EditPart) {
			return ((dataMapper.diagram.edit.parts.InNode4EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNodeEditPart) {
			return ((dataMapper.diagram.edit.parts.OutNodeEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNode2EditPart) {
			return ((dataMapper.diagram.edit.parts.OutNode2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof dataMapper.diagram.edit.parts.OutNode3EditPart) {
			return ((dataMapper.diagram.edit.parts.OutNode3EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target,
				getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source,
				getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				dataMapper.diagram.part.DataMapperDiagramEditorPlugin
						.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(dataMapper.diagram.part.Messages.DataMapperModelingAssistantProviderMessage);
		dialog.setTitle(dataMapper.diagram.part.Messages.DataMapperModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
