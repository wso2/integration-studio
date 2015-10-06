package org.wso2.developerstudio.eclipse.platform.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeResolverProvider;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSMediaUtils;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.mediatypes.CustomMediaTypeReader;

public class MediaManager {
	
	private static final String ECLIPSE_LAUNCHER_SYSTEM_PROPERTY = "eclipse.launcher";
	private static final String MIMETYPES_CONF_FILE_NAME = "mimetypes.conf";
	private static final String CONFIGURATION_FOLDER_NAME = "configuration";
	
	static Map userMediaTypes = new HashMap<String, String>();
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public static IMediaTypeResolverProvider[] getMediaTypeResolver(){
		return CSMediaUtils.getMediaTypeResolver();
	}
	
	public static IMediaTypeResolverProvider[] getMediaTypeResolverProvider(String mediaType){
		IMediaTypeResolverProvider[] resourceMediaTypeResolver = MediaManager.getMediaTypeResolver();
		List<IMediaTypeResolverProvider> providers=new ArrayList<IMediaTypeResolverProvider>();
		for (IMediaTypeResolverProvider resolverProvider : resourceMediaTypeResolver) {
			if (resolverProvider.getMediaType().equalsIgnoreCase(mediaType)){
				providers.add(resolverProvider);
			}
		}
		return providers.toArray(new IMediaTypeResolverProvider[]{});
	}
	
	public static String getMediaType(String fileName) {
		String mediaType = getCustomMediaTypeIfSet(fileName);
		if (mediaType == null) { 
			IMediaTypeResolverProvider selectedProvider = getMediaTypeResolver(fileName);
			if (selectedProvider != null) {
				mediaType = selectedProvider.getMediaType();
			}
		}
		return mediaType;
	}
	
	public static String getCustomMediaTypeIfSet(String fileName) {
		String mediaType = null;
		String mimeTypesFileLoc = null;
		File mimeTypesFile = null;
		String resourceFileExt = getFileExtension(fileName);
		String launcherLocation = System.getProperty(ECLIPSE_LAUNCHER_SYSTEM_PROPERTY);//eclipse conf directory path
		File launcherLocationFile;
		if (resourceFileExt == null) {
			log.error("resource file does not have an extension");
		}
		if (launcherLocation != null && userMediaTypes.isEmpty()) {
			launcherLocationFile = new File(launcherLocation);
			mimeTypesFileLoc = launcherLocationFile.getParent() + File.separator +
			                           CONFIGURATION_FOLDER_NAME + File.separator +
			                           MIMETYPES_CONF_FILE_NAME;
			mimeTypesFile = new File(mimeTypesFileLoc);
			if (mimeTypesFile.exists()) {// check for media types in the custom file by user
				CustomMediaTypeReader customMediaTypeReader = new CustomMediaTypeReader();
				userMediaTypes = customMediaTypeReader.customMimeTypes(mimeTypesFileLoc);
			}
		}
		if (userMediaTypes.containsKey(resourceFileExt)) {
			mediaType = (String) userMediaTypes.get(resourceFileExt);
		}
		return mediaType;
	}
	
	public static IMediaTypeResolverProvider getMediaTypeResolver(
			String fileName) {
		IMediaTypeResolverProvider[] resourceMediaTypeResolver = MediaManager.getMediaTypeResolver();
		IMediaTypeResolverProvider selectedProvider=null;
		for (IMediaTypeResolverProvider resolverProvider : resourceMediaTypeResolver) {
			if (resolverProvider.isMediaType(fileName)){
				if ((selectedProvider==null) || (selectedProvider.getPriority()<resolverProvider.getPriority())){
					selectedProvider=resolverProvider;
				}
			}
		}
		return selectedProvider;
	}

	public static String getMediaType(File file) {
		String fileName = file.getName();
		String mediaType = getCustomMediaTypeIfSet(fileName);
		if (mediaType == null) { 
			IMediaTypeResolverProvider selectedProvider = getMediaTypeResolver(file);
			if (selectedProvider != null) {
				mediaType = selectedProvider.getMediaType();
			}
		}
		return mediaType;
	}

	public static IMediaTypeResolverProvider getMediaTypeResolver(File file) {
		if (file.isFile()){
			IMediaTypeResolverProvider[] resourceMediaTypeResolver = MediaManager.getMediaTypeResolver();
			String extension = FilenameUtils.getExtension(file.getAbsolutePath());
			return getSelectedProvider(file, resourceMediaTypeResolver, extension);
		}
		return null;
	}

    private static IMediaTypeResolverProvider getSelectedProvider(File file,
            IMediaTypeResolverProvider[] resourceMediaTypeResolver,
            String extension) {
        IMediaTypeResolverProvider selectedProvider = null;
        if (extension != null) {
            for (IMediaTypeResolverProvider resolverProvider : resourceMediaTypeResolver) {
                if (resolverProvider.getExtensions().contains(extension)) {
                    if (resolverProvider.isMediaType(file)) {
                        if ((selectedProvider == null)
                                || (selectedProvider.getPriority() < resolverProvider.getPriority())) {
                            selectedProvider = resolverProvider;
                        }
                    }
                }
            }
        } else {
            for (IMediaTypeResolverProvider resolverProvider : resourceMediaTypeResolver) {
                if (resolverProvider.isMediaType(file)) {
                    if ((selectedProvider == null) || (selectedProvider.getPriority() < resolverProvider.getPriority())) {
                        selectedProvider = resolverProvider;
                    }
                }
            }
        }
        return selectedProvider;
    }
	
	public static String getMediaType(URL url) throws IOException {
		IMediaTypeResolverProvider selectedProvider = getMediaTypeResolver(url);
		if (selectedProvider!=null){
			return selectedProvider.getMediaType();
		}
		return null;
	}

	public static IMediaTypeResolverProvider getMediaTypeResolver(URL url) throws IOException {
		if (url.getProtocol().toLowerCase().startsWith("http")){
			try {
				ITemporaryFileTag mediaTypeTempTag = FileUtils.createNewTempTag();
				File tempFile = FileUtils.createTempFile();
				FileUtils.createFile(tempFile, url.openStream());
				IMediaTypeResolverProvider mediaTypeResolver = getMediaTypeResolver(tempFile);
				mediaTypeTempTag.clearAndEnd();
				return mediaTypeResolver;
			} catch (FileNotFoundException e) {
				// not gonna happen
			}
		}
		IMediaTypeResolverProvider[] resourceMediaTypeResolver = MediaManager.getMediaTypeResolver();
		IMediaTypeResolverProvider selectedProvider=null;
		for (IMediaTypeResolverProvider resolverProvider : resourceMediaTypeResolver) {
				if (resolverProvider.isMediaType(url)){
					if ((selectedProvider==null) || (selectedProvider.getPriority()<resolverProvider.getPriority())){
						selectedProvider=resolverProvider;
					}
				}
		}
		return selectedProvider;
	}
	
	/**
	 * method to get the file extension
	 * @param file 
	 * @return extension of the file
	 */
	private static String getFileExtension(String file) {
	    int lastIndexOf = file.lastIndexOf(".");
	    if (lastIndexOf == -1) {// if there is no "." in the file name
	    	//no file extension
	        return null; // return empty extension	       
	    }
	    return file.substring(lastIndexOf);
	}
}
