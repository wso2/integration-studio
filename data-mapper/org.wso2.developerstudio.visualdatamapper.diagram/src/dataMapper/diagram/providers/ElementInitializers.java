package dataMapper.diagram.providers;

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
		ElementInitializers cached = dataMapper.diagram.part.DataMapperDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			dataMapper.diagram.part.DataMapperDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
