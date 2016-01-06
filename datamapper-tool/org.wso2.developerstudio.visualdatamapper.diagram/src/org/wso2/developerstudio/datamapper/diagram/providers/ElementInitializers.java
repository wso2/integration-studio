package org.wso2.developerstudio.datamapper.diagram.providers;

import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = DataMapperDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			DataMapperDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
