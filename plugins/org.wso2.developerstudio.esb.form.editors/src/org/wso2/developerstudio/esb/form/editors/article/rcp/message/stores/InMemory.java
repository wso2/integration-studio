package org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores;

import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class InMemory implements IMessageStore {

	ScrolledForm form;
	FormToolkit toolkit;
	
	public InMemory(ScrolledForm form, FormToolkit toolkit) {
		this.form = form;
		this.toolkit = toolkit;
	}

	@Override
	public void createConnectionSectionFields() {}

	@Override
	public void createParameterSectionFields() {}

	@Override
	public boolean hasGuaranteedDelivery() {
		return false;
	}

	@Override
	public boolean hasParameters() {
		return false;
	}

	@Override
	public boolean hasConnection() {
		return false;
	}

	@Override
	public void hideGuaranteedDeliverySection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideParametersSection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideConnectionSection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showGuaranteedDeliverySection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showParametersSection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showConnectionSection() {
		// TODO Auto-generated method stub
		
	}
	
	
}
