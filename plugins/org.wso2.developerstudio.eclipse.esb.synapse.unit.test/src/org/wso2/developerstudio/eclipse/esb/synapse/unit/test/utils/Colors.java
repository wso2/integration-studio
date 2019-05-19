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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

/**
 * Class responsible for maintaining the colors for syntaxes.
 */
public class Colors {

    public static Color getSystemColor(int id) {
        return Display.getDefault().getSystemColor(id);
    }

    public static Color createColor(RGB rgb) {
        return SWTResourceManager.getColor(rgb);
    }

    public static RGB toRGB(String code) throws NumberFormatException {
        java.awt.Color c = java.awt.Color.decode(code);
        return new RGB(c.getRed(), c.getGreen(), c.getBlue());
    }

    public static Color decode(String code) throws NumberFormatException {
        java.awt.Color c = java.awt.Color.decode(code);
        RGB rgb = new RGB(c.getRed(), c.getGreen(), c.getBlue());
        return createColor(rgb);
    }

    public static Color decode2(String code) throws NumberFormatException {
        try {
            if (code == null)
                return null;

            return decode(code);
        } catch (Exception e) {
            return null;
        }
    }

    public static String toHex(RGB rgb) {
        return toHex(rgb.red, rgb.green, rgb.blue);
    }

    public static String toHex(int r, int g, int b) {
        return "#" + toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
    }

    private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }

}
