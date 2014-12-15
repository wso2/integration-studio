package org.wso2.developerstudio.eclipse.platform.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeResolverProvider;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSMediaUtils;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class MediaManager {
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
		IMediaTypeResolverProvider selectedProvider = getMediaTypeResolver(fileName);
		if (selectedProvider!=null){
			return selectedProvider.getMediaType();
		}
		return null;
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
		IMediaTypeResolverProvider selectedProvider = getMediaTypeResolver(file);
		if (selectedProvider!=null){
			return selectedProvider.getMediaType();
		}
		return null;
	}

	public static IMediaTypeResolverProvider getMediaTypeResolver(File file) {
		if (file.isFile()){
			IMediaTypeResolverProvider[] resourceMediaTypeResolver = MediaManager.getMediaTypeResolver();
			IMediaTypeResolverProvider selectedProvider=null;
			for (IMediaTypeResolverProvider resolverProvider : resourceMediaTypeResolver) {
				if (resolverProvider.isMediaType(file)){
					if ((selectedProvider==null) || (selectedProvider.getPriority()<resolverProvider.getPriority())){
						selectedProvider=resolverProvider;
					}
				}
			}
			return selectedProvider;
		}
		return null;
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
}
