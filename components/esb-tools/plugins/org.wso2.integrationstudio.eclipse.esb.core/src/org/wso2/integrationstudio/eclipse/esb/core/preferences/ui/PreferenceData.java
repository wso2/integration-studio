package org.wso2.integrationstudio.eclipse.esb.core.preferences.ui;

import org.eclipse.jface.preference.IPreferenceStore;
import org.wso2.integrationstudio.eclipse.esb.core.Activator;

public class PreferenceData {
	private static IPreferenceStore store = Activator.getDefault()
			.getPreferenceStore();

	public static String getEsbVersionPreference() {
		return store.getString(PreferenceConstants.PREF_ESBVERSION);
	}
}
