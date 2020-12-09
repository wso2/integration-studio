package org.eclipse.bpel.extensionssample.ui.properties;

import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SampleSimpleActivityPropertySection extends BPELPropertySection {

	@Override
	protected void createClient(Composite parent) {
		Label label = getWidgetFactory().createLabel(parent, "Hello World");
	}

}
