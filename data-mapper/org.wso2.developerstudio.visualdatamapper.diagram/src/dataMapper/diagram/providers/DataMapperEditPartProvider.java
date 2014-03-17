package dataMapper.diagram.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class DataMapperEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public DataMapperEditPartProvider() {
		super(new dataMapper.diagram.edit.parts.DataMapperEditPartFactory(),
				dataMapper.diagram.part.DataMapperVisualIDRegistry.TYPED_INSTANCE,
				dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID);
	}
}
