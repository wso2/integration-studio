package dataMapper.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		dataMapper.diagram.preferences.DiagramGeneralPreferencePage
				.initDefaults(store);
		dataMapper.diagram.preferences.DiagramAppearancePreferencePage
				.initDefaults(store);
		dataMapper.diagram.preferences.DiagramConnectionsPreferencePage
				.initDefaults(store);
		dataMapper.diagram.preferences.DiagramPrintingPreferencePage
				.initDefaults(store);
		dataMapper.diagram.preferences.DiagramRulersAndGridPreferencePage
				.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return dataMapper.diagram.part.DataMapperDiagramEditorPlugin
				.getInstance().getPreferenceStore();
	}
}
