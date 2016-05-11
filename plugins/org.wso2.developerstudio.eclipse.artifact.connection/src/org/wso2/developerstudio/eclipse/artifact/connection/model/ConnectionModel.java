package org.wso2.developerstudio.eclipse.artifact.connection.model;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.wso2.developerstudio.eclipse.artifact.localentry.model.LocalEntryModel;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;

public class ConnectionModel extends LocalEntryModel {

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (key.equals("save.file")) {
			IContainer container = getLocalEntrySaveLocation();
			if (container != null && container instanceof IFolder) {
				IFolder localEntryFolder = container.getProject().getFolder("src").getFolder("main")
						.getFolder("integration-config").getFolder("connections");
				modelPropertyValue = localEntryFolder;
			} else {
				modelPropertyValue = container;
			}
		}
		return modelPropertyValue;
	}

	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getLocalEntrySaveLocation() == null && absolutionPath != null) {
			IContainer newEndpointSaveLocation = getContainer(absolutionPath,
					"org.wso2.developerstudio.eclipse.integration.project.nature");
			setLocalEntrySaveLocation(newEndpointSaveLocation);
		}
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		if (key.equals("save.file")) {
			IContainer container = (IContainer) data;
			if (container != null && container instanceof IFolder) {
				IFolder localEntryFolder = container.getProject().getFolder("src").getFolder("main")
						.getFolder("integration-config").getFolder("connections");
				setLocalEntrySaveLocation(localEntryFolder);
			} else {
				setLocalEntrySaveLocation(container);
			}
		}
		return returnResult;
	}
}
