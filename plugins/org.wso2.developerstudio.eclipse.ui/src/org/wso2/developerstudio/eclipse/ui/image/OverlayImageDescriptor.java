/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.ui.image;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class OverlayImageDescriptor extends CompositeImageDescriptor {
	private ImageDescriptor imageDescriptor;
	private ImageDescriptor overlayImage;
	Point size;
	Point overlaySize;
	private OverlayImagePosition position;
	
	public OverlayImageDescriptor(ImageDescriptor imgDescriptor,ImageDescriptor overlayImage, OverlayImagePosition position) {
		setImageDescriptor(imgDescriptor);
		setOverlayImage(overlayImage);
		setPosition(position);
    }
	
	public OverlayImageDescriptor(ImageDescriptor imgDescriptor,ImageDescriptor overlayImage) {
		setImageDescriptor(imgDescriptor);
		setOverlayImage(overlayImage);
		setPosition(OverlayImagePosition.BOTTOM_RIGHT);
    }
	
	protected void drawCompositeImage(int arg0, int arg1) {
		drawImage(getImageDescriptor().getImageData(), 0, 0); 
		ImageData overlayImageData = getOverlayImage().getImageData();
        int xValue = size.x-overlaySize.x;
        int yValue = size.y-overlaySize.y;
        switch(getPosition()){
        	case TOP_LEFT:
        		xValue=0;
        		yValue=0;
        		break;
        	case TOP_RIGHT:
        		yValue=0;
        		break;
        	case BOTTOM_LEFT:
        		xValue=0;
        }
        drawImage(overlayImageData, xValue, yValue); 
	}

	protected Point getSize() {
		return size;
	}

	public void setImageDescriptor(ImageDescriptor imageDescriptor) {
	    this.imageDescriptor = imageDescriptor;
	    Rectangle bounds = imageDescriptor.createImage().getBounds();
		size=new Point(bounds.width,bounds.height);
    }

	public ImageDescriptor getImageDescriptor() {
	    return imageDescriptor;
    }

	public void setOverlayImage(ImageDescriptor overlayImage) {
	    this.overlayImage = overlayImage;
	    Rectangle bounds = overlayImage.createImage().getBounds();
		overlaySize=new Point(bounds.width,bounds.height);
    }

	public ImageDescriptor getOverlayImage() {
	    return overlayImage;
    }

	public void setPosition(OverlayImagePosition position) {
		this.position = position;
	}

	public OverlayImagePosition getPosition() {
		return position;
	}

	public enum OverlayImagePosition{
		TOP_LEFT,
		TOP_RIGHT,
		BOTTOM_LEFT,
		BOTTOM_RIGHT,
		CENTER
	}
}
