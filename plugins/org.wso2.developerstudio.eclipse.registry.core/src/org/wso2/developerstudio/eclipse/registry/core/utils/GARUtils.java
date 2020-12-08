package org.wso2.developerstudio.eclipse.registry.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.wso2.developerstudio.eclipse.platform.core.MediaManager;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.GARFileType;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IGARImportDependency;
import org.wso2.developerstudio.eclipse.registry.core.internal.impl.GARImportDependencyImpl;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class GARUtils {
	public static IGARImportDependency getGARDependencyModel(URL url) throws IOException{
		String mediaType = MediaManager.getMediaType(url);
		GARFileType type;
		if (mediaType.equalsIgnoreCase(PlatformMediaTypeConstants.MEDIA_TYPE_WSDL)){
			type=GARFileType.WSDL;
		}else if (mediaType.equalsIgnoreCase(PlatformMediaTypeConstants.MEDIA_TYPE_XSD)){
			type=GARFileType.SCHEMA_IMPORTS;
		}else{
			return null;
		}
		GARImportDependencyImpl garImportDependencyImpl = new GARImportDependencyImpl(url, type);
		return garImportDependencyImpl;
	}
	
	public static File createGAR(IGARImportDependency dependency) throws Exception{
		if (dependency.isExclude()){
			return null;
		}
		String garName = FileUtils.getResourceFileName(FileUtils.getFileName(dependency.getSource()));
		File garTemporaryLocation = FileUtils.createTempDirectory();
		File garFolder = new File(garTemporaryLocation,garName);
		garFolder.mkdirs();
		
		if (dependency.getType()==GARFileType.WSDL){
			dependency.toFile(garFolder, true);
		}
		ArchiveManipulator archiveManipulator = new ArchiveManipulator();
		File garFile = new File(garTemporaryLocation,garName+".gar");
		archiveManipulator.archiveDir(garFile,garFolder);
		return garFile;
	}
}
