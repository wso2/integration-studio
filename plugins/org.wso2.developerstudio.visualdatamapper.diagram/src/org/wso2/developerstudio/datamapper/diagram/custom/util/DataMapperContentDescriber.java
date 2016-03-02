package org.wso2.developerstudio.datamapper.diagram.custom.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;

public class DataMapperContentDescriber implements IContentDescriber {

	@Override
	public int describe(InputStream arg0, IContentDescription arg1) throws IOException {
		String myString = IOUtils.toString(arg0, "UTF-8");
		if ("/* WSO2 Data Mapper Config */".equals(myString)) {
			return VALID;
		} else {
			return INVALID;
		}
	}

	@Override
	public QualifiedName[] getSupportedOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
