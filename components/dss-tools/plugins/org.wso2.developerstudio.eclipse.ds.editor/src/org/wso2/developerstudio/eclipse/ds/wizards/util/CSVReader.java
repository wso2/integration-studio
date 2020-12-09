package org.wso2.developerstudio.eclipse.ds.wizards.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CSVReader {

	String filePath;

	public CSVReader(String filePath) {

		this.filePath = filePath;

	}

	public ArrayList<String> getHeaders() throws IOException {

		ArrayList<String> headerHolder = new ArrayList<String>();

		BufferedReader br = new BufferedReader(new FileReader(filePath));

		StringTokenizer st = null;

		String headersLine = br.readLine();

		if (headersLine != null) {
			st = new StringTokenizer(headersLine, ",");

			while (st.hasMoreTokens()) {

				headerHolder.add(st.nextToken());
			}
		}

		return headerHolder;

	}
}
