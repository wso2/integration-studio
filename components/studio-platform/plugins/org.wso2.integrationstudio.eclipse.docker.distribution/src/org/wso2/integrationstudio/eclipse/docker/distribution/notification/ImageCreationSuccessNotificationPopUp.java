/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.integrationstudio.eclipse.docker.distribution.notification;

import org.eclipse.mylyn.commons.ui.dialogs.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.wso2.integrationstudio.eclipse.docker.distribution.resources.DockerGenConstants;

/**
 * This class represents the notification popup displayed when the docker image
 * creation is successful.
 *
 */
public class ImageCreationSuccessNotificationPopUp extends AbstractNotificationPopup {

	private String imageId;
	private String imageName;
	private String imageTag;

	public ImageCreationSuccessNotificationPopUp(Display display, String imageId, String imageName, String imageTag) {
		super(display);
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageTag = imageTag;
	}

	@Override
	protected void createContentArea(Composite parent) {

		Composite container = new Composite(parent, SWT.NULL);

		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		container.setLayoutData(data);

		container.setLayout(new GridLayout(1, false));
		
		String imageNameWithTag = "";
		
		if (null == imageName || imageName.isEmpty()) {
			imageNameWithTag = imageName;
		} else {
			imageNameWithTag = imageName + ":" + imageTag;
		}

		Label successMsg = new Label(container, SWT.NULL);
		successMsg.setText(DockerGenConstants.SuccessMessages.DOCKER_IMAGE_GEN_SUCCESS_MESSAGE 
				+ imageNameWithTag + "\n" + DockerGenConstants.SuccessMessages.DOCKER_IMAGE_ID_MESSAGE
				+ imageId);

	}

	@Override
	protected String getPopupShellTitle() {
		return DockerGenConstants.SuccessMessages.SUCCESSFUL_TITLE;
	}

}
