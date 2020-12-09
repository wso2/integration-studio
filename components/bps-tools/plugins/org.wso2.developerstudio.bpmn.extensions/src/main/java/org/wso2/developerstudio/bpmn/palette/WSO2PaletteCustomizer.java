/*
 * Copyright 2005-2015 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.bpmn.palette;

import org.activiti.designer.integration.palette.AbstractDefaultPaletteCustomizer;
import org.activiti.designer.integration.palette.PaletteEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * WSO2PaletteCustomizer - customize Activiti editor palette.
 */
public class WSO2PaletteCustomizer extends AbstractDefaultPaletteCustomizer {

    @Override
    public List<PaletteEntry> disablePaletteEntries() {
        List<PaletteEntry> result = new ArrayList<PaletteEntry>();
        //Disabling non generic activities.
        result.add(PaletteEntry.ALFRESCO_START_EVENT);
        result.add(PaletteEntry.ALFRESCO_MAIL_TASK);
        result.add(PaletteEntry.ALFRESCO_SCRIPT_TASK);
        result.add(PaletteEntry.ALFRESCO_USER_TASK);
        return result;
    }
}
