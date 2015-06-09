package org.wso2.developerstudio.eclipse.gmf.esb.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated
 */
public class EsbNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7059;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof EsbNavigatorItem) {
			EsbNavigatorItem item = (EsbNavigatorItem) element;
			return EsbVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
