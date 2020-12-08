/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver42.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;

public class FileMonitor implements Runnable {
	String path;
	long lastModified = 0;
	boolean existed;
	boolean stop = true;
	private long pollMilliseconds = 5000;
	List<IFileStatusListener> fileStatusListeners = new ArrayList<IFileStatusListener>();

	public FileMonitor(String path) {
		this.path = path;
	}

	public void run() {
		File file = new File(path);
		existed = file.exists();
		if (file.exists()) {
			lastModified = file.lastModified();
		}
		while (true) {
			file = new File(path);
			if (file.exists()) {
				if (!existed) {
					existed = true;
					triggerFileCreateEvents(file, file.lastModified());
				}
				if (lastModified != file.lastModified()) {
					long newModified = file.lastModified();
					triggerFileChangeEvents(file, lastModified, newModified);
					lastModified = newModified;
				}
			} else {
				if (existed) {
					existed = false;
					triggerFileDeleteEvents(file, lastModified);
				}
			}
			try {
				Thread.sleep(pollMilliseconds);
			} catch (InterruptedException e) {
			}
			if (stop)
				break;
		}
	}

	private void triggerFileChangeEvents(File file, long lastModified, long newModified) {
		for (IFileStatusListener fileStatusListener : fileStatusListeners) {
			fileStatusListener.fileChanged(file, lastModified, newModified);
		}
	}

	private void triggerFileCreateEvents(File file, long createTime) {
		for (IFileStatusListener fileStatusListener : fileStatusListeners) {
			fileStatusListener.fileCreated(file, createTime);
		}
	}

	private void triggerFileDeleteEvents(File file, long deleteTime) {
		// here the deleteTime is currently wrong
		for (IFileStatusListener fileStatusListener : fileStatusListeners) {
			fileStatusListener.fileDeleted(file, deleteTime);
		}
	}

	public void addFileStatusListener(IFileStatusListener fileStatusListener) {
		fileStatusListeners.add(fileStatusListener);
	}

	public void removeFileStatusListener(IFileStatusListener fileStatusListener) {
		if (fileStatusListeners.contains(fileStatusListener))
			fileStatusListeners.remove(fileStatusListener);
	}

	public static interface IFileStatusListener {
		public void fileChanged(File file, long lastModified, long newModified);

		public void fileCreated(File file, long createTime);

		public void fileDeleted(File file, long deleteTime);
	}

	public void startMonitoring() {
		startMonitoring(null);
	}

	public void startMonitoring(Display display) {
		if (stop) {
			stop = false;
			if (display == null)
				new Thread(this).start();
			else
				display.asyncExec(this);
		}
	}

	public void stopMonitoring() {
		stop = true;
	}

	public void setPollMilliseconds(long pollMilliseconds) {
		this.pollMilliseconds = pollMilliseconds;
	}

	public long getPollMilliseconds() {
		return pollMilliseconds;
	}
}
