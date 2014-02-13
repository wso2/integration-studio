package dataMapper.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class DataMapperNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4004;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof dataMapper.diagram.navigator.DataMapperNavigatorItem) {
			dataMapper.diagram.navigator.DataMapperNavigatorItem item = (dataMapper.diagram.navigator.DataMapperNavigatorItem) element;
			return dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
