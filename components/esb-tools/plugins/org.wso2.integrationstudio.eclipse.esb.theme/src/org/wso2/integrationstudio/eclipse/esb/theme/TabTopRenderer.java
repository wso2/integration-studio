/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.integrationstudio.eclipse.esb.theme;

import org.eclipse.e4.ui.workbench.renderers.swt.CTabRendering;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

@SuppressWarnings("restriction")
public class TabTopRenderer extends CTabRendering {

    private CTabFolder tabFolder;

    public TabTopRenderer(CTabFolder parent) {
        super(parent);
        this.tabFolder = parent;
    }

    @Override
    protected void draw(int part, int state, Rectangle bounds, GC gc) {
        super.draw(part, state, bounds, gc);

        if ((part >= 0) && (part == tabFolder.getSelectionIndex())) {
            int x = bounds.x;
            int y = bounds.y;
            int width = bounds.width;

            gc.setBackground(new Color(null, 52, 152, 219));
            gc.fillRectangle(x, y , width , 3);
        }
    }
}