package org.eclipse.bpel.extensionssample.ui.factories;

import org.eclipse.bpel.extensionsample.model.util.ModelAdapterFactory;
import org.eclipse.bpel.extensionssample.ui.adapters.SampleSimpleActivityAdapter;
import org.eclipse.bpel.extensionssample.ui.adapters.SampleStructuredActivityAdapter;
import org.eclipse.emf.common.notify.Adapter;

public class ExtensionSampleUIAdapterFactory extends ModelAdapterFactory {

	private SampleSimpleActivityAdapter sampleSimpleActivityAdapter;
	private SampleStructuredActivityAdapter sampleStructuredActivityAdapter;
		
	@Override
	public Adapter createSampleSimpleActivityAdapter() {
		if (this.sampleSimpleActivityAdapter == null) {
			this.sampleSimpleActivityAdapter = new SampleSimpleActivityAdapter();
		}
		return this.sampleSimpleActivityAdapter;
	}
	
	@Override
	public Adapter createSampleStructuredActivityAdapter() {
		if (this.sampleStructuredActivityAdapter == null) {
			this.sampleStructuredActivityAdapter = new SampleStructuredActivityAdapter();
		}
		return this.sampleStructuredActivityAdapter;
	}
	
}
