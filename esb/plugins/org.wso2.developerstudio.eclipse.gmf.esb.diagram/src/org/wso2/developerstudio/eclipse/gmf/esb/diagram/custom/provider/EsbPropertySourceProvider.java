package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
 
public class EsbPropertySourceProvider implements
		IPropertySourceProvider {
 
	private AdapterFactory adapterFactory;
 
	public EsbPropertySourceProvider(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}
 
	//
	public IPropertySource getPropertySource(Object object) {
		if (object instanceof IPropertySource) {
			return (IPropertySource) object;
		} else {
			IItemPropertySource itemPropertySource = (IItemPropertySource) (object instanceof EObject
					&& ((EObject) object).eClass() == null ? null
					: adapterFactory.adapt(object, IItemPropertySource.class));
 
			return itemPropertySource != null ? createPropertySource(object,
					itemPropertySource) : null;
		}
	}
 
	protected IPropertySource createPropertySource(Object object,
			IItemPropertySource itemPropertySource) {
		// Returns the custom property source
		return new EsbPropertySource(object, itemPropertySource);
	}
 
}