package org.wso2.developerstudio.eclipse.ds.wizards.util;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.validator.routines.UrlValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class DLoader {

	public static boolean download(String address, String localFileName) throws IOException {

		String[] schemes = { "http", "https" };
		UrlValidator urlValidator = new UrlValidator(schemes);

		if (urlValidator.isValid(address)) {

			BufferedOutputStream out = null;
			URLConnection conn = null;
			InputStream in = null;

			URL url = new URL(address);

			out = new BufferedOutputStream(new FileOutputStream(localFileName));
			conn = url.openConnection();
			in = conn.getInputStream();

			byte[] buffer = new byte[1024];
			int numRead;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
			}

			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			return true;

		} else {

			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Invalied URL ",
			                              "Invalied URL");
			return false;
		}

	}

}
