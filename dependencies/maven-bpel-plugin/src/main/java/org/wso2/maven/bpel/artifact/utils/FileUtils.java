package org.wso2.maven.bpel.artifact.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileUtils {
	private static List<String> excludeList=new ArrayList<String>();

	static {
		excludeList.add(".svn");
		excludeList.add("target");
		excludeList.add(".settings");
	}

	public FileUtils() {
		super();
	}

	public static void copyFile(String src, String dest) {
		InputStream is = null;
		FileOutputStream fos = null;

		try {
			is = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			int c = 0;
			byte[] array = new byte[1024];
			while ((c = is.read(array)) >= 0) {
				fos.write(array, 0, c);
			}
		} catch (Exception e) {
			// log.error(e);
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (is != null)
					is.close();
			} catch (Exception e) {
				// log.error(e);
			}
		}
	}

	// Copies all files under srcDir to dstDir.
	// If dstDir does not exist, it will be created.
	public static void copyDirectory(File srcDir, File dstDir) throws IOException {
		if (srcDir.isDirectory()) {
			if (!dstDir.exists()) {
				dstDir.mkdirs();
			}

			String[] children = srcDir.list();
			for (int i = 0; i < children.length; i++) {
				copyDirectory(new File(srcDir, children[i]), new File(dstDir, children[i]));
			}
		} else {
			copy(srcDir, dstDir);
		}
	}

	public static void copyDirectoryContents(File srcDir, File dstDir) throws IOException {
		File[] listFiles = srcDir.listFiles();
		for (File srcFile : listFiles) {
			if (srcFile.isDirectory()) {
				copyDirectory(srcFile, new File(dstDir, srcFile.getName()));
			} else {
				copy(srcFile, new File(dstDir, srcFile.getName()));
			}
		}
	}

	// Copies src file to dst file.
	// If the dst file does not exist, it is created
	public static void copy(File src, File dst) throws IOException {
		if (dst.getParentFile() != null && !dst.getParentFile().exists()) {
			dst.getParentFile().mkdirs();
		}
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);

		// Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	public static File createArchive(File location, File artifactLocation, String artifactName) throws Exception {
		String path = location.toString();
		List<File> allFilesPresentInFolder = getAllFilesPresentInFolder(new File(path));
		List<File> bpelValidFileList =
		                         getBpelValidFileList(path,
		                                              (File[]) allFilesPresentInFolder.toArray(new File[allFilesPresentInFolder.size()]));
		if (bpelValidFileList.size() == 0) {
			throw new Exception("The selected location " + location.getName() + "(" +
			                    location.toString() + ") does not contain any bpel processes.");
		}

		File targetFolder = null;
		try {
			targetFolder = new File(location.getPath() , "target");
			File bpelDataFolder=new File(targetFolder,"bpel-tmp");
			bpelDataFolder.mkdirs();
			File zipFolder = new File(bpelDataFolder, artifactLocation.getName());
			zipFolder.mkdirs();
			copyDirectory(artifactLocation, zipFolder, bpelValidFileList);
			removeEmptyDirectories(zipFolder);
			File zipFile = new File(targetFolder,artifactName);
			zipFolder(zipFolder.getAbsolutePath(), zipFile.toString());
			org.wso2.developerstudio.eclipse.utils.file.FileUtils.deleteDir(bpelDataFolder);
			return zipFile;
		} catch (Exception e) {
			throw e;
		}

	}

	public static File createTempFile() throws IOException {
		File tempFile = File.createTempFile("maven", ".tmp");
		// addFileToTempTags(tempFile);
		return tempFile;
	}

	public static File createTempDirectory() throws IOException {
		File tempDirectory = createTempFile();
		tempDirectory.delete();
		tempDirectory.mkdirs();
		return tempDirectory;
	}

	public static List<File> getBpelValidFileList(String relativePath, File[] fileList) {
		List<File> list = new ArrayList<File>();
		List<String> excludeList=new ArrayList<String>();
		excludeList.add("pom.xml");
		excludeList.add("build.xml");
		excludeList.add(".project");
		excludeList.add(".classpath");
		excludeList.add(".svn");
		excludeList.add("target");
		excludeList.add(".settings");
		
		for (File file : fileList) {
			if (!file.isDirectory()) {
				try {
					if ((file.getName().toLowerCase().endsWith(".bpel")) &&
					    (isValidBPelFile(file))){
						list.add(file);
//					}else if ((file.getName().toLowerCase().endsWith(".wsdl")) &&
//					         (isValidWSDLFile(file))){
//						existingWSDL.add(file);
					}else if (!excludeList.contains(file.getName()) && !excludeList.contains(file.getParentFile().getName())) {
	                	list.add(file);
					}
				} catch (IOException e) {
				}
			}
		}
//		List<String> compareList=getToStringList(requiredWsdl);
//		for (File wsdlFileName : existingWSDL) {
//			if (compareList.contains(wsdlFileName.toString()))
//				list.add(wsdlFileName);
//		}
		return list;
	}

	private static List<String> getToStringList(List<File> fileList){
		List<String> resultStrings=new ArrayList<String>();
		for (Object object : fileList) {
			resultStrings.add(object.toString());
		}
		return resultStrings;
	}
	
	public static boolean isValidDeployFile(File file) {
		Document xmlDocument = getXmlDocument(file);
		if (xmlDocument == null)
			return false;
		else
			return xmlDocument.getDocumentElement().getNodeName().equalsIgnoreCase("deploy");
	}

	public static boolean isValidWSDLFile(File file) {
		return true;
	}
	
	public static boolean isValidXSDFile(File fileName){
		return getXmlDocument(fileName)!= null?true:false;
	}
	
	public static boolean isValidXSLTFile(File fileName){
		return getXmlDocument(fileName)!= null?true:false;
	}

	public static boolean isValidBPelFile(File file) throws IOException {
		Document xmlDocument = getXmlDocument(file);
		if (xmlDocument == null){
			return false;
		}else {
			if (xmlDocument.getDocumentElement().getNodeName().toLowerCase().endsWith("process")) {
//				NodeList childNodes = xmlDocument.getDocumentElement().getChildNodes();
//				for (int i = 0; i < childNodes.getLength(); i++) {
//					Node item = childNodes.item(i);
//					if (item.getNodeName().toLowerCase().endsWith("import")) {
//						Node namedItem = item.getAttributes().getNamedItem("location");
//						String nodeValue = namedItem.getNodeValue();
//						File parentFile = file.getParentFile();
//						File importedFile = new File(parentFile, nodeValue);
//						wsdlList.add(importedFile.getCanonicalFile());
//					}
//				}
				return true;
			} else{
				return false;
			}
		}
	}

	private static Document getXmlDocument(File file) {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			return doc;
		} catch (ParserConfigurationException e) {
			return null;
		} catch (SAXException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	public static void copyDirectory(File srcPath, File dstPath, List<File> filesToBeCopied)
	                                                                                  throws IOException {
		List<String> pathStringList = getToStringList(filesToBeCopied);
		
		
		for (String string : pathStringList) {
	        String path=string.substring(srcPath.getPath().length()+1);
	        File destFile=new File(dstPath,path);
	        destFile.getParentFile().mkdirs();
	        copy(new File(string), destFile);
        }
		
		
		
//		for (String string : pathStringList) {
//	        System.out.println("Path String: "+string );
//        }
//		
//		if (srcPath.isDirectory()) {
//			if (!dstPath.exists()) {
//				dstPath.mkdir();
//			}
//			String files[] = srcPath.list();
//			for (int i = 0; i < files.length; i++) {
//				copyDirectory(new File(srcPath, files[i]), new File(dstPath, files[i]),
//				              filesToBeCopied);
//			}
//		} else {
//			if (!pathStringList.contains(srcPath.getAbsolutePath()))
//				return;
//			if (!srcPath.exists()) {
//				return;
//			} else {
//				copy(srcPath, dstPath);
//			}
//		}
	}

	public static List<File> getAllFilesPresentInFolder(File srcPath) {
		List<File> fileList = new ArrayList<File>();
		if (srcPath.isDirectory()) {
		if (!excludeList.contains(srcPath.getName())) {
		    String files[] = srcPath.list();
	            for (int i = 0; i < files.length; i++) {
		            fileList.addAll(getAllFilesPresentInFolder(new File(srcPath, files[i])));
	            }
            	}
		} else {
			fileList.add(srcPath);
		}
		return fileList;
	}

	public static void removeEmptyDirectories(File srcPath) {
		if (srcPath.isDirectory()) {
			String files[] = srcPath.list();
			for (int i = 0; i < files.length; i++) {
				removeEmptyDirectories(new File(srcPath, files[i]));
			}
			if (srcPath.list().length == 0) {
				srcPath.delete();
			}
		}
	}

	static public void zipFolder(String srcFolder, String destZipFile) {
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;
		try {
			fileWriter = new FileOutputStream(destZipFile);
			zip = new ZipOutputStream(fileWriter);
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
		addFolderContentsToZip(srcFolder, zip);
		try {
			zip.flush();
			zip.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	static private void addToZip(String path, String srcFile, ZipOutputStream zip) {

		File folder = new File(srcFile);
		if (folder.isDirectory()) {
			addFolderToZip(path, srcFile, zip);
		} else {
			// Transfer bytes from in to out
			byte[] buf = new byte[1024];
			int len;
			try {
				FileInputStream in = new FileInputStream(srcFile);
				String nextEntryPath = path + "/" + folder.getName();		//This path-separator is hard coded purposely
				if (path != null && path.trim().equalsIgnoreCase("")) {
					nextEntryPath = folder.getName();
				}
				zip.putNextEntry(new ZipEntry(nextEntryPath));
				while ((len = in.read(buf)) > 0) {
					zip.write(buf, 0, len);
				}
				in.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	static private void addFolderContentsToZip(String srcFolder, ZipOutputStream zip) {
		File folder = new File(srcFolder);
		String fileListe[] = folder.list();
		try {
			int i = 0;
			while (i<=fileListe.length) {
				addToZip("", srcFolder + File.separator + fileListe[i], zip);
				i++;
			}
		} catch (Exception ex) {
		}
	}

	static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) {
		File folder = new File(srcFolder);
		String fileListe[] = folder.list();
		try {
			int i = 0;
			while (i <= fileListe.length) {
				String newPath = folder.getName();
				if (!path.equalsIgnoreCase(""))
					newPath = path + "/" + newPath;		//This path-separator is hard coded purposely
				addToZip(newPath, srcFolder + File.separator + fileListe[i], zip);
				i++;
			}
		} catch (Exception ex) {
		}
	}

}
