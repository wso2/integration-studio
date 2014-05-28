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

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * General color utilities.
 */
public final class ColorUtils {

	/**
	 * Gets a different color shade by changing its brightness
	 * with the provided variation. 
	 */
	public static Color getShade(Color original, float brightnessVariation, Display display) {
		brightnessVariation  = isInvertedColorScheme() ? -brightnessVariation : brightnessVariation;
		return new Color(display, getShadeRGB(original.getRGB(), brightnessVariation));
	}

	/**
	 * Gets a different color shade by changing its brightness
	 * with the provided variation. 
	 */
	public static RGB getShadeRGB(RGB original, float brightnessVariation) {
//		System.out.println("started " + original);
		brightnessVariation  = isInvertedColorScheme() ? -brightnessVariation : brightnessVariation;
		float[] hsb = RGBtoHSB(original.red, original.green, original.blue, null);
		hsb[2] += brightnessVariation;
		int rgb = HSBtoRGB(hsb[0], hsb[1], hsb[2]);
//		System.out.println(new RGB(getRed(rgb), getGreen(rgb), getBlue(rgb)));
		return new RGB(getRed(rgb), getGreen(rgb), getBlue(rgb));
	}

	/**
	 * Returns an array of gradient colors from source to destination.
	 * The source and destination colors are not included in the array.
	 */
	public static Color[] getColorShades(Color source, Color destination, int n, Display display) {
		float interval = getBrightnessInterval(source.getRGB(), destination.getRGB());
		interval = interval / (n+2);
		Color[] result = new Color[n];
		Color base = source;
		for (int i = 0; i < result.length; i++) {
			result[i] = getShade(base, interval, display);
			base = result[i];
		}
		return result;
	}

	/**
	 * Returns an array of gradient colors from source to destination.
	 * The source and destination colors are not included in the array.
	 */
	public static float getBrightnessInterval(RGB source, RGB destination) {
		float[] sourceHSB = RGBtoHSB(source.red, source.green, source.blue, null);
		float[] destinationHSB = RGBtoHSB(destination.red, destination.green, destination.blue, null);
		return (destinationHSB[2] - sourceHSB[2]);
	}

	/**
	 * Returns an array of gradient colors from source to middle and from middle to destination.
	 * The middle color is included but the source and destination are not.
	 */
	public static Color[] getColorShades(Color source, Color middle, Color destination, int n, Display display) {
		Color[] result = new Color[n+1];
		Color[] temp = getColorShades(source, middle, (n/2), display);
		System.arraycopy(temp, 0, result, 0, temp.length);
		int pos = temp.length;
		result[pos] = new Color(display, middle.getRGB());
		temp = getColorShades(middle, destination, (n - temp.length), display);
		System.arraycopy(temp, 0, result, (pos+1), temp.length);
		return result;
	}

	/**
	 * Takes the source color and calculates the brightness interval with each
	 * color of the shades array. Then creates a new color array based on the
	 * destination color and the brightness intervals.  
	 */
	public static RGB[] getColorShades(RGB source, RGB[] shades, RGB destination) {
		RGB[] result = new RGB[shades.length];
		for (int i = 0; i < shades.length; i++) {
			RGB shade = shades[i];
			float interval = getBrightnessInterval(source, shade);
			result[i] = getShadeRGB(destination, interval);
		}
		return result;
	}

	/**
	 * Converts the specified HSB values to a RBG value.
	 *
	 * @version 	initial
	 *
	 * @param	hue			the hue component
	 * @param	saturation	the saturation component
	 * @param	brightness	the brightness component
	 *
	 * @return	an <code>int</code> which is the converted RGB value
	 */
	public static int HSBtoRGB(float hue, float saturation, float brightness) {
		float s = saturation;
		float v = brightness;

		int x = Math.round(v * 255);

		if (s == 0) {
			return 0xff000000 | (x << 16) | (x << 8) | x;
		} else {
			float h;
			if (hue == 1.0f)
				h = 0f;
			else
				h = (hue - (float)Math.floor(hue)) * 6.0f;

			int i = (int)Math.floor(h);
			float f = h - i;

			int p = Math.round(255 * (v * (1 - s)));
			int q = Math.round(255 * (v * (1 - (s * f))));
			int t = Math.round(255 * (v * (1 - (s * (1 - f)))));
			switch(i){
				case 0: return 0xff000000 | (x << 16) | (t << 8) | p;
				case 1: return 0xff000000 | (q << 16) | (x << 8) | p;
				case 2: return 0xff000000 | (p << 16) | (x << 8) | t;
				case 3: return 0xff000000 | (p << 16) | (q << 8) | x;
				case 4: return 0xff000000 | (t << 16) | (p << 8) | x;
				case 5: return 0xff000000 | (x << 16) | (p << 8) | q;
				default: return 0;
			}
		}
	}

	/**
	 * Fill and return the specified array with the specified RGB values
	 * converted to HSB. Create, fill and return a new array if <code>null</code>
	 * is passed in.
	 * <p>
	 * Color components must be in the range (0 - 255).
	 *
	 * @version 	initial
	 *
	 * @param	red		the red component
	 * @param	green	the green component
	 * @param	blue	the blue component
	 * @param	hsb		the return value or <code>null</code>
	 *
	 * @return	an <code>float[]</code> containing the converted HSB values
	 *
	 * @throws	IllegalArgumentException	if any of the components are invalid
	 */
	public static float[] RGBtoHSB(int red, int green, int blue, float hsb[]) {
		if ((red < 0 || red > 255) ||
			(green < 0 || green > 255) ||
			(blue < 0 || blue > 255))
				throw new IllegalArgumentException();

		float r = red / 255f;
		float g = green / 255f;
		float b = blue / 255f;

		float h = 0; // hue
		float s; // saturation
		float v; // brightnees

		float max = Math.max(r, Math.max(g, b));
		float min = Math.min(r, Math.min(g, b));

		// Calculate brightness
		v = max;

		// Calculate saturation
		if (max != 0)
			s = (max - min)/max;
		else
			s = 0;

		// Calculate hue
		if (s != 0) {
			float delta = max - min;
			if (r == max)
				h = (g - b)/delta;
			else if (g == max)
				h = 2 + (b - r)/delta;
			else if (b == max)
				h = 4 + (r - g)/delta;

			h = h * 60f;
			if (h < 0)
				h = h + 360f;
			h /= 360f;
		}

		// Fill return value
		if (hsb == null)
			return new float[]{h, s, v};
		else {
			hsb[0] = h;
			hsb[1] = s;
			hsb[2] = v;
			return hsb;
		}
	}

	/**
	 * Answers the blue component of the receiver.
	 *
	 * @version 	initial
	 *
	 * @return	an <code>int</code> which is the blue component of the receiver
	 * 			in the range (0 - 255)
	 *
	 */
	private static final int getBlue(int rgb) {
		return rgb & 0xff;
	}

	/**
	 * Answers the green component of the receiver.
	 *
	 * @version 	initial
	 *
	 * @return	an <code>int</code> which is the green component of the receiver
	 * 			in the range (0 - 255)
	 */
	private static final int getGreen(int rgb) {
		return (rgb & 0xff00) >> 8;
	}

	/**
	 * Answers the red component of the receiver.
	 *
	 * @version 	initial
	 *
	 * @return	an <code>int</code> which is the red component of the receiver
	 * 			in the range (0 - 255)
	 */
	private static final int getRed(int rgb) {
		return (rgb & 0xff0000) >> 16;
	}

	/**
	 * Replaces the given color in the image data.
	 */
	public static void replaceColor(ImageData data, RGB from, RGB to) {
		for (int x = 0; x < data.width; x++) {
			for (int y = 0; y < data.height; y++) {
				int pixel = data.getPixel(x, y);
				RGB rgb = data.palette.getRGB(pixel);
				if (rgb.equals(from)) {
					pixel = data.palette.getPixel(to);
				}
				data.setPixel(x, y, pixel);
			}
		}
	}
	
	/**
	 *  scales the colors to be relative to the background and foreground colors (used to handle
	 *  high contrast mode)
	 *  
	 **/
	public static Color getRelativeColor(Device device, int r, int g, int b) {
		Color baseForeground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_FOREGROUND);
		Color baseBackground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		int fr = baseForeground.getRed();
		int fg = baseForeground.getGreen();
		int fb = baseForeground.getBlue();
		int br = baseBackground.getRed();
		int bg = baseBackground.getGreen();
		int bb = baseBackground.getBlue();
		
		int nr = (int) (fr + ((float)r * (br-fr) / 255));
		int ng = (int) (fg + ((float)g * (bg-fg) / 255));
		int nb = (int) (fb + ((float)b * (bb-fb) / 255));
		
		// safety check, make sure all colors are in the correct range (in case we change the calculation above
		nr = Math.max(0, nr);
		nr = Math.min(255, nr);
		ng = Math.max(0, ng);
		ng = Math.min(255, ng);
		nb = Math.max(0, nb);
		nb = Math.min(255, nb);
		return new Color(null, nr, ng, nb);
	}
	
	/**
	 *  Scales the colors to be relative to the background and foreground colors (used to handle
	 *  high contrast mode)
	 */
	public static RGB getRelativeRGB(int r, int g, int b) {
		Color baseForeground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_FOREGROUND);
		Color baseBackground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		int fr = baseForeground.getRed();
		int fg = baseForeground.getGreen();
		int fb = baseForeground.getBlue();
		int br = baseBackground.getRed();
		int bg = baseBackground.getGreen();
		int bb = baseBackground.getBlue();
		
		int nr = (int) (fr + ((float)r * (br-fr) / 255));
		int ng = (int) (fg + ((float)g * (bg-fg) / 255));
		int nb = (int) (fb + ((float)b * (bb-fb) / 255));
		
		// safety check, make sure all colors are in the correct range (in case we change the calculation above
		nr = Math.max(0, nr);
		nr = Math.min(255, nr);
		ng = Math.max(0, ng);
		ng = Math.min(255, ng);
		nb = Math.max(0, nb);
		nb = Math.min(255, nb);
		return new RGB(nr, ng, nb);
	}

	public static Color getRelativeColor(Color c) {
		Color cr = getRelativeColor(null, c.getRed(), c.getGreen(), c.getBlue());
		c.dispose();
		return cr;
	}
	
	public static Color getRelativeColorFromSystem(Color c) {
		return getRelativeColor(null, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static boolean isInvertedColorScheme() {
		Color baseForeground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_FOREGROUND);
		Color baseBackground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		
		// normally, the foreground color is dark, compare the sums to see which one is "lighter"
		if ((baseForeground.getRed() + baseForeground.getBlue() + baseForeground.getGreen()) >
			(baseBackground.getRed() + baseBackground.getBlue() + baseBackground.getGreen())) {
				return true;
			}
		return false;
	}
	
	public static RGB getLightShade(RGB rgb, int numerator, int denominator) {
		int light = 255 * numerator;
		int red = (rgb.red + light) / denominator;
		int green = (rgb.green + light) / denominator;
		int blue = (rgb.blue + light) / denominator;
		return new RGB(red, green, blue);
	}
}
