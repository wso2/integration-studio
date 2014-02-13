package org.wso2.developerstudio.eclipse.platform.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class ClientTrustStorePreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	public static final String TRUST_STORE_PASSWORD = "TRUST_STORE_PASSWORD";
	public static final String SHOW_PLAIN_PASSWORD = "SHOW_PLAIN_PASSWORD";
	public static final String TRUST_STORE_TYPE = "TRUST_STORE_TYPE";
	public static final String TRUST_STORE_LOCATION = "TRUST_STORE_LOCATION";
	private StringFieldEditor stringField1;
	private IPreferenceStore preferenceStore;

	public ClientTrustStorePreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench arg0) {
		preferenceStore = Activator.getDefault().getPreferenceStore();
		setPreferenceStore(preferenceStore);
		setDescription("WSO2 Developer Studio Custom Client Trust Store Preference.");
	}

	@Override
	protected void createFieldEditors() {
		addField(new FileFieldEditor(TRUST_STORE_LOCATION,
				"&Trust Store Location:", getFieldEditorParent()));
		String[][] a = { { "JKS", "JKS" } };
		addField(new ComboFieldEditor(TRUST_STORE_TYPE, "Trust &Store Type", a,
				getFieldEditorParent()));
		stringField1 = new StringFieldEditor(TRUST_STORE_PASSWORD,
				"Trust Store &Password", getFieldEditorParent());
		addField(stringField1);
		BooleanFieldEditor booleanFieldEditor = new BooleanFieldEditor(
				SHOW_PLAIN_PASSWORD, "S&how Password in Plain Text",
				getFieldEditorParent());
		addField(booleanFieldEditor);
		if (!preferenceStore.getBoolean(SHOW_PLAIN_PASSWORD)) {
			stringField1.getTextControl(getFieldEditorParent())
					.setEchoChar('*');
		}
		preferenceStore
				.addPropertyChangeListener(new IPropertyChangeListener() {

					@Override
					public void propertyChange(
							org.eclipse.jface.util.PropertyChangeEvent arg0) {
						// Setting/unsetting echo char
						if (arg0.getProperty() == SHOW_PLAIN_PASSWORD) {
							boolean boolean1 = preferenceStore
									.getBoolean(SHOW_PLAIN_PASSWORD);
							if (boolean1) {
								stringField1.getTextControl(
										getFieldEditorParent()).setEchoChar(
										'\0');
							} else {
								stringField1.getTextControl(
										getFieldEditorParent())
										.setEchoChar('*');
							}
						}

						if (arg0.getProperty() == TRUST_STORE_LOCATION) {
							String string = preferenceStore
									.getString(TRUST_STORE_LOCATION);
							if (!string.equals("") && !string.endsWith(".jks")) {
								setErrorMessage("You cannot set non JKS trust stores from Developer Studio");
							}
						}
					}
				});
	}

}
