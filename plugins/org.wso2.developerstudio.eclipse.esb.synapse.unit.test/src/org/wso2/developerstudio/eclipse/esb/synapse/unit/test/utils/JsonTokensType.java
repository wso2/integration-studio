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

/**
 * Class responsible for defining JSON tokens.
 */
public enum JsonTokensType {
    TEXT(true), KEYWORD(true), QUOTED_LITERAL(true), NUMBER(true), SYMBOL(true), EOF(false), EOL(false), SPACE(
            false), OTHER(true), JRPARAMETER(true), JRVARIABLE(true), JRFIELD(true), STARTSYMBOL(true), FREE_MARKUP_LOOP(true), FREE_MARKUP_DOLLER_SYNTAX(true);

    private boolean hasColor;

    private JsonTokensType(boolean hasColor) {
        this.hasColor = hasColor;
    }

    public static int getColoredTokensNum() {
        int num = 0;
        for (JsonTokensType t : values()) {
            if (t.hasColor) {
                num++;
            }
        }
        return num;
    }
}