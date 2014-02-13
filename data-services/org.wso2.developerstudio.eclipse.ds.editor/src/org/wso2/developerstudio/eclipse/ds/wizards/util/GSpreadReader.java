package org.wso2.developerstudio.eclipse.ds.wizards.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class GSpreadReader {

	String feedURL;
	String mailAddress;
	String password;
	private boolean isTagsLoaded;
	private boolean isPrivate;

	public GSpreadReader(String mailAddress, String password, String feedURL) {

		this.mailAddress = mailAddress;
		this.password = password;
		this.feedURL = feedURL;
		isTagsLoaded = false;
		isPrivate = true;
	}

	public GSpreadReader(String feedURL) {

		this.feedURL = feedURL;
		isTagsLoaded = false;
		isPrivate = false;
	}

	public ArrayList<String> getWorkSheets() throws IOException, ServiceException {

		ArrayList<String> sheetNames = new ArrayList<String>();

		SpreadsheetService service = new SpreadsheetService("Service");

		if (isPrivate)
			service.setUserCredentials(mailAddress, password);

		URL metafeedUrl = new URL(feedURL);

		WorksheetFeed feed = service.getFeed(metafeedUrl, WorksheetFeed.class);

		List<WorksheetEntry> worksheetEntryl = feed.getEntries();

		for (int j = 0; j < worksheetEntryl.size(); j++) {

			WorksheetEntry worksheet = worksheetEntryl.get(j);

			sheetNames.add(worksheet.getTitle().getPlainText());

		}

		return sheetNames;

	}

	public ArrayList<String> getHeaders(String nameOfWorkSheet) {

		ArrayList<String> headers = new ArrayList<String>();
		isTagsLoaded = false;

		try {
			SpreadsheetService service = new SpreadsheetService("example-service");

			if (isPrivate)
				service.setUserCredentials(mailAddress, password);

			URL metafeedUrl = new URL(feedURL);

			WorksheetFeed feed = service.getFeed(metafeedUrl, WorksheetFeed.class);

			List<WorksheetEntry> worksheetEntryl = feed.getEntries();

			for (int j = 0; j < worksheetEntryl.size(); j++) {

				WorksheetEntry worksheet = worksheetEntryl.get(j);

				if (worksheet.getTitle().getPlainText().equals(nameOfWorkSheet)) {

					URL listFeedUrl = worksheet.getListFeedUrl();

					ListFeed lfeed = service.getFeed(listFeedUrl, ListFeed.class);

					for (ListEntry entry : lfeed.getEntries()) {

						if (entry.getCustomElements().getTags() != null &&
						    !entry.getCustomElements().getTags().isEmpty()) {

							if (!isTagsLoaded) {

								isTagsLoaded = true;

								for (String tag : entry.getCustomElements().getTags()) {

									headers.add(tag);

								}

							}

						}
					}

				}

			}
		} catch (AuthenticationException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Wrong user name or password", e.toString());

		} catch (MalformedURLException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Malformed URL",
			                              e.toString());

		} catch (IOException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Error occured while reading the file", e.toString());
		} catch (ServiceException e) {

			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "Google Data Service can not be established",
			                              e.toString());
		}

		return headers;

	}
}
