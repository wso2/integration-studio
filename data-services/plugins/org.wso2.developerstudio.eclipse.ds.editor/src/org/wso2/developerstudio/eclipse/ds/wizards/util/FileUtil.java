package org.wso2.developerstudio.eclipse.ds.wizards.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

public class FileUtil {

	private static final String TEMP_FOLDER_NAME = ".dbs_temp";

	public static IProject createTempLoaction() throws CoreException {

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IProject[] projects = root.getProjects();

		for (IProject project : projects) {

			if (project.getName().equals(TEMP_FOLDER_NAME)) {

				project.delete(true, true, null);

			}

		}

		IProject project = root.getProject(TEMP_FOLDER_NAME);

		project.create(null);
		project.open(null);

		return project;

	}

	public static void saveToFile(String location, File tempFile) throws IOException {

		FileWriter fw = new FileWriter(tempFile.getAbsolutePath(), true); // the
		                                                                  // true
		                                                                  // will
		                                                                  // append
		                                                                  // the
		                                                                  // string
		                                                                  // to
		                                                                  // the
		                                                                  // file
		fw.write(location + "\n");
		fw.close();
	}

	public static boolean isListed(String locationfile, String selectedfile) throws IOException {

		ArrayList<String> fileList = new ArrayList<String>();

		BufferedReader br;

		br =
		     new BufferedReader(
		                        new InputStreamReader(
		                                              new DataInputStream(
		                                                                  new FileInputStream(
		                                                                                      locationfile))));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			fileList.add(strLine);
		}
		br.close();

		Iterator<String> it = fileList.iterator();

		while (it.hasNext()) {

			String inlist = it.next();
			if (inlist.equals(selectedfile)) {
				return true;
			}

		}

		return false;

	}

	public static boolean deleteFile(String fileLocation) {
		File f = new File(fileLocation);
		if (f.exists()) {
			return f.delete();
		} else {
			return false;
		}
	}

}
