package dataMapper.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class DataMapperModelingAssistantProviderOfInNode3EditPart extends
		dataMapper.diagram.providers.DataMapperModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((dataMapper.diagram.edit.parts.InNode3EditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(
			dataMapper.diagram.edit.parts.InNode3EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((dataMapper.diagram.edit.parts.InNode3EditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(
			dataMapper.diagram.edit.parts.InNode3EditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001) {
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3006);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3009);
			types.add(dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3018);
		}
		return types;
	}

}
