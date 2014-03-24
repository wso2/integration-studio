package dataMapper.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class DataMapperModelingAssistantProviderOfOutNode2EditPart extends
		dataMapper.diagram.providers.DataMapperModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((dataMapper.diagram.edit.parts.OutNode2EditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(
			dataMapper.diagram.edit.parts.OutNode2EditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(dataMapper.diagram.edit.parts.OutNode2EditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			dataMapper.diagram.edit.parts.OutNode2EditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNodeEditPart) {
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001);
		}
		if (targetEditPart instanceof dataMapper.diagram.edit.parts.InNode2EditPart) {
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((dataMapper.diagram.edit.parts.OutNode2EditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(
			dataMapper.diagram.edit.parts.OutNode2EditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001) {
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.InNode_3005);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.InNode_3008);
		}
		return types;
	}

}
