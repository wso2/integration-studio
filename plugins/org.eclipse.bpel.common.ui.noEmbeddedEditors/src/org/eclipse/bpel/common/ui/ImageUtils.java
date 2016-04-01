/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

/**
 * General image utilities.
 */
public final class ImageUtils {

	/**
	 * Rotates the image data in 90 degrees.
	 */
	public static ImageData rotateLeft(ImageData source) {
		ImageData result = new ImageData(source.height, source.width, source.depth, source.palette);
		result.transparentPixel = source.transparentPixel;
		for (int x = 0; x < source.width; x++) {
			for (int y = 0; y < source.height; y++) {
				int newX = y;
				int newY = result.height - x - 1;
				result.setPixel(newX, newY, source.getPixel(x, y));
				result.setAlpha(newX, newY, source.getAlpha(x, y));
			}
		}
		return result;
	}
	
	/**
	 * Inverts the image left to right. 
	 */
	public static ImageData flip(ImageData source) {
		ImageData result = (ImageData)source.clone();
		result.transparentPixel = source.transparentPixel;
		for (int y = 0; y < source.height; y++) {
			for (int x = 0; x < source.width; x++) {
				int newX = source.width - x - 1;
				result.setPixel(newX, y, source.getPixel(x, y));
				result.setAlpha(newX, y, source.getAlpha(x, y));
			}
		}
		return result;
	}
	
	/**
	 * Creates an image with a transparent background. The given color
	 * is considered the transparent color.
	 */
	public static Image createTransparentImage(int width, int height, Color transparent) {
		Image tmp = new Image(null, width, height);
		ImageData data = tmp.getImageData();
		tmp.dispose();
		data.transparentPixel = data.palette.getPixel(transparent.getRGB());
		for(int i = 0; i < data.width; i++) {
			for (int j = 0; j < data.height; j++) {
				data.setPixel(i, j, data.transparentPixel);
			}
		}
		return new Image(null, data);
	}

	/**
	 * Return an image according to the given a marker severity.
	 */
	public static Image getImage(IMarker marker) {
		switch (marker.getAttribute(IMarker.SEVERITY, -1)) {
			case IMarker.SEVERITY_ERROR:
				return CommonUIPlugin.getDefault().getImageRegistry().get(ICommonUIConstants.ICON_ERROR);
			case IMarker.SEVERITY_WARNING:
				return CommonUIPlugin.getDefault().getImageRegistry().get(ICommonUIConstants.ICON_WARNING);
			case IMarker.SEVERITY_INFO:
				return CommonUIPlugin.getDefault().getImageRegistry().get(ICommonUIConstants.ICON_INFO);
		}
		return null;
	}
}
