package org.wso2.developerstudio.eclipse.updater.ui;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.updater.model.EnhancedFeature;

public class SelectableFeatureButton extends Button {
	
	private EnhancedFeature feature;

	public SelectableFeatureButton(Composite parent, int style) {
		super(parent, style);
	}

	public EnhancedFeature getFeature() {
		return feature;
	}

	public void setFeature(EnhancedFeature feature) {
		this.feature = feature;
	}

}
