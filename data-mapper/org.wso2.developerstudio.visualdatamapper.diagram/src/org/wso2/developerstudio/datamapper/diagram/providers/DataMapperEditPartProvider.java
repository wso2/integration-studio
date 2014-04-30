package org.wso2.developerstudio.datamapper.diagram.providers;

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
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperEditPartFactory;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

/**
 * @generated
 */
public class DataMapperEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public DataMapperEditPartProvider() {
		super(new DataMapperEditPartFactory(), DataMapperVisualIDRegistry.TYPED_INSTANCE,
				DataMapperRootEditPart.MODEL_ID);
	}
}
