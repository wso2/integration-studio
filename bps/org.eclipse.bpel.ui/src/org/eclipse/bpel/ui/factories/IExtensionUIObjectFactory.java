package org.eclipse.bpel.ui.factories;

import org.eclipse.emf.ecore.EClass;

public interface IExtensionUIObjectFactory {

	EClass[] getClassArray();
	void setModelType(EClass modelType);
	
}
