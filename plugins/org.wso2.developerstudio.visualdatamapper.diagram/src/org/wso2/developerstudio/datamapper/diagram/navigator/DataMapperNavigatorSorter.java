package org.wso2.developerstudio.datamapper.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

/**
 * @generated
 */
public class DataMapperNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof DataMapperNavigatorItem) {
			DataMapperNavigatorItem item = (DataMapperNavigatorItem) element;
			return DataMapperVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
