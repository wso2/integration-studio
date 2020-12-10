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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;

/**
 * Class responsible for suggesting combo items while typing on it.
 */
public class ComboTypingSuggestUtil {
    public static void addAutoCompleteFeature(Combo combo) {
        // Add a key listener
        combo.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent keyEvent) {
                Combo cmb = ((Combo) keyEvent.getSource());
                setClosestMatch(cmb);
            }

            // Move the highlight back by one character for backspace
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.keyCode == SWT.BS) {
                    Combo cmb = ((Combo) keyEvent.getSource());
                    Point pt = cmb.getSelection();
                    cmb.setSelection(new Point(Math.max(0, pt.x - 1), pt.y));
                }
            }

            private void setClosestMatch(Combo combo) {
                String str = combo.getText();
                String[] cItems = combo.getItems();
                // Find Item in Combo Items. If full match returns index
                int index = -1;
                for (int i = 0; i < cItems.length; i++) {
                    if (cItems[i].toLowerCase().startsWith(str.toLowerCase())) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    Point pt = combo.getSelection();
                    combo.select(index);
                    combo.setText(cItems[index]);
                    combo.setSelection(new Point(pt.x, cItems[index].length()));
                }
            }
        });
    }
}
