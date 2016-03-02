package org.wso2.developerstudio.eclipse.gmf.esb.diagram.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloudConnectorOperationEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.navigator.EsbNavigatorGroup;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class EsbSheetLabelProvider extends BaseLabelProvider implements ILabelProvider {

	/**
	 * @generated NOT
	 */
	public String getText(Object element) {
		element = unwrap(element);
		if (element instanceof EsbNavigatorGroup) {
			return ((EsbNavigatorGroup) element).getGroupName();
		} else if (element instanceof ProxyServiceEditPart) {
			ProxyServiceEditPart editPart = (ProxyServiceEditPart) element;
			if (editPart.getModel() instanceof View) {
				View view = (View) editPart.getModel();
				if (view.getElement() instanceof ProxyService) {
					ProxyService proxy = (ProxyService) view.getElement();
					if (proxy.isMainSequence()) {
						return "Main-Sequence";
					}
				}
			}
		} else if (element instanceof CloudConnectorOperationEditPart) {
			return "Connector Operation";
		}
		IElementType etype = getElementType(getView(element));
		return etype == null ? "" : etype.getDisplayName();
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		IElementType etype = getElementType(getView(unwrap(element)));
		return etype == null ? null : EsbElementTypes.getImage(etype);
	}

	/**
	 * @generated
	 */
	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return ((IStructuredSelection) element).getFirstElement();
		}
		return element;
	}

	/**
	 * @generated
	 */
	private View getView(Object element) {
		if (element instanceof View) {
			return (View) element;
		}
		if (element instanceof IAdaptable) {
			return (View) ((IAdaptable) element).getAdapter(View.class);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getElementType(View view) {
		// For intermediate views climb up the containment hierarchy to find the one associated with an element type.
		while (view != null) {
			int vid = EsbVisualIDRegistry.getVisualID(view);
			IElementType etype = EsbElementTypes.getElementType(vid);
			if (etype != null) {
				return etype;
			}
			view = view.eContainer() instanceof View ? (View) view.eContainer() : null;
		}
		return null;
	}

}
