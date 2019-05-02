/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.developerstudio.eclipse.gmf.esb.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.junit.Assert;

public class FontUtils {

    public static final String FONT_ITALIC = "italic";
    public static final String FONT_BOLD = "bold";
    public static final String FONT_NORMAL = "normal";
    public static final String OS_NAME = "os.name";
    public static final String OS_TYPE_MACOSX = "macosx";
    public static final String OS_TYPE_NOT_AVAILABLE = "";
    public static final String OS_TYPE_LINUX = "linux";
    public static final String OS_TYPE_LINUX_GTK = "linux_gtk";
    public static final String OS_TYPE_WINDOWS = "windows";
    public static final String OS_TYPE_AIX = "aix";
    public static final String OS_TYPE_HP_UX = "hp-ux";
    public static final String OS_TYPE_SUNOS = "sunos";
    public static final String OS_TYPE_WINDOWS_NT = "windowsnt";
    public static final String OS_TYPE_WINDOWS_XP = "windowsxp";
    public static final String OS_TYPE_WINDOWS_VISTA = "windowsvista";
    public static final String OS_TYPE_WINDOWS_7 = "windows7";
    public static final String OS_TYPE_WINDOWS_8 = "windows8";
    public static final String OS_TYPE_WINDOWS_10 = "windows10";
    private static final Map<Device, Font> FONTS_MONOSPACED = new HashMap<>();

    private FontUtils() {
        // Static class.
    }

    public static Font getMonospacedFont() {
        synchronized (FONTS_MONOSPACED) {
            // Get current display.
            Display display = Display.getCurrent();
            if (display == null) {
                String msg = "Must be invoked for a SWT UI thread.";
                throw new IllegalStateException(msg);
            }

            return getMonospacedFont(display);
        }
    }

    public static Font getMonospacedFont(final Display display) {

        synchronized (FONTS_MONOSPACED) {

            Font fontFromCache = FONTS_MONOSPACED.get(display);
            if (fontFromCache != null)
                return fontFromCache;

            String osName = System.getProperty(OS_NAME);
            String platformName = SWT.getPlatform();
            osName = StringUtils.deleteWhitespace(osName).toLowerCase(Locale.US);
            platformName = StringUtils.deleteWhitespace(platformName).toLowerCase(Locale.US);

            String[] names = { osName + "_" + platformName, osName, "" };

            String[] fontStyle = null;
            for (String name : names) {
                if (name.equals(OS_TYPE_AIX)) {
                    fontStyle = new String[] { "adobe-courier|normal|12" };
                    break;
                } else if (name.equals(OS_TYPE_HP_UX)) {
                    fontStyle = new String[] { "adobe-courier|normal|14" };
                    break;
                } else if (name.equals(OS_TYPE_LINUX_GTK)) {
                    fontStyle = new String[] { "Monospace|normal|10" };
                    break;
                } else if (name.equals(OS_TYPE_LINUX)) {
                    fontStyle = new String[] { "adobe-courier|normal|12" };
                    break;
                } else if (name.equals(OS_TYPE_MACOSX)) {
                    fontStyle = new String[] { "Monaco|normal|11", "Courier|normal|12", "Courier New|normal|12" };
                    break;
                } else if (name.equals(OS_TYPE_SUNOS) || name.equals("solaris")) {
                    fontStyle = new String[] { "adobe-courier|normal|12" };
                    break;
                } else if (name.equals(OS_TYPE_WINDOWS_NT)) {
                    fontStyle = new String[] { "Courier New|normal|10", "Courier|normal|10",
                            "Lucida Console|normal|9" };
                    break;
                } else if (name.equals(OS_TYPE_WINDOWS_XP)) {
                    fontStyle = new String[] { "Courier New|normal|10", "Courier|normal|10",
                            "Lucida Console|normal|9" };
                    break;
                } else if (name.equals(OS_TYPE_WINDOWS_VISTA)) {
                    fontStyle = new String[] { "Consolas|normal|10", "Courier New|normal|10" };
                    break;
                } else if (name.equals(OS_TYPE_WINDOWS_7)) {
                    fontStyle = new String[] { "Consolas|normal|10", "Courier New|normal|10" };
                    break;
                } else if (name.equals(OS_TYPE_WINDOWS_8)) {
                    fontStyle = new String[] { "Consolas|normal|10", "Courier New|normal|10" };
                    break;
                } else if (name.equals(OS_TYPE_WINDOWS_10)) {
                    fontStyle = new String[] { "Consolas|normal|10", "Courier New|normal|10" };
                    break;
                } else if (name.equals(OS_TYPE_NOT_AVAILABLE)) {
                    fontStyle = new String[] { "Courier New|normal|10", "Courier|normal|10",
                            "b&h-lucidabright|normal|9" };
                    break;
                }
            }
            if (fontStyle == null) {
                // Can't happen, but silences a warning.
                throw new AssertionError();
            }

            FontData[] fontData = new FontData[fontStyle.length];
            for (int i = 0; i < fontData.length; i++) {

                String txt = fontStyle[i];
                int bar2 = txt.lastIndexOf('|');
                Assert.assertTrue(bar2 != -1);
                int bar1 = txt.lastIndexOf('|', bar2 - 1);
                Assert.assertTrue(bar1 != -1);

                String name = txt.substring(0, bar1);
                Assert.assertTrue(name.length() > 0);

                String[] styles = txt.substring(bar1 + 1, bar2).split(",");
                int style = 0;
                for (String s : styles) {
                    if (s.equals(FONT_NORMAL)) {
                        style |= SWT.NORMAL;
                    } else if (s.equals(FONT_BOLD)) {
                        style |= SWT.BOLD;
                    } else if (s.equals(FONT_ITALIC)) {
                        style |= SWT.ITALIC;
                    } else {
                        throw new RuntimeException("Invalid style: " + s);
                    }
                }

                int height = Integer.parseInt(txt.substring(bar2 + 1));

                fontData[i] = new FontData(name, height, style);
            }

            final Font font = new Font(display, fontData);

            display.disposeExec(new Runnable() {
                @Override
                public void run() {
                    synchronized (FONTS_MONOSPACED) {
                        FONTS_MONOSPACED.remove(display);
                        font.dispose();
                    }
                }
            });
            FONTS_MONOSPACED.put(display, font);

            return font;
        }
    }
}
