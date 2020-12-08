package org.wso2.developerstudio.eclipse.registry.core.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.registry.core.ui.widgets.GRegImageUtils;

public class RegistryFileImpl extends RegistryResourceImpl implements
		IRegistryFile {

	public RegistryFileImpl(IRegistryCollection parent) {
		super(parent);
	}

	public InputStream getStream() throws Exception {
		if (getSource() instanceof File) {
			File file = (File) getSource();
			return new FileInputStream(file);
		}else if (getSource() instanceof IFile) {
			IFile file = (IFile) getSource();
			return file.getContents();
		}
		return null;
	}

	public ImageDescriptor getIcon() {
		return GRegImageUtils.getInstance().getImageDescriptor("resource.png");
	}

	public Object[] getChildren(Map<String,List<String>> filters) {
		return null;
	}

	public String getId() {
		return null;
	}

	public boolean hasChildren(Map<String,List<String>> filters) {
		return false;
	}

	public String getText() {
		return getParent()==null? getPath():getName();
	}

	public String getKey() {
		return getPath();
	}
}
