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

import java.util.Arrays;
import java.util.List;

/**
 * Class responsible for identify the JSON types from the texts lines.
 */
public class JsonScanner {
    public static final int EOF_CHAR = -1;
    public static final int EOL_CHAR = 10;
    private static List<String> jsonKeywords;
    private static List<String> jsonOperatorsAndSymbols;

    private StringBuffer fBuffer = new StringBuffer();
    private String fDoc;
    private int fPos;
    private int fEnd;
    private int fStartToken;
    private boolean isFreeMarkerSyntaxOccured = false;
    private boolean isTextHighlighter = false;

    public JsonScanner(boolean isTextHighlighter) {
        initJsonKeywords();
        initJsonSymbolsAndOperators();
        this.isTextHighlighter = isTextHighlighter;
    }

    /**
     * Gets next token type in order to decide how to "style it".
     * 
     * @return the token type
     */
    public JsonTokensType nextToken() {
        int c;
        fStartToken = fPos;
        while (true) {
        	if (isFreeMarkerSyntaxOccured && !isTextHighlighter) {
        		isFreeMarkerSyntaxOccured = false;
        		for (;;) {
                    c = read();
                    switch (c) {
                    case '"':
                        return JsonTokensType.QUOTED_LITERAL;
                    case EOF_CHAR:
                        unread(c);
                        return JsonTokensType.QUOTED_LITERAL;
                    case '$':
                        unread(c);
                        return JsonTokensType.QUOTED_LITERAL;
                    case '<':
                        unread(c);
                        return JsonTokensType.QUOTED_LITERAL;
                    case '\\':
                        c = read();
                        break;
                    }
                }
        	}
            switch (c = read()) {
            case EOF_CHAR:
                return JsonTokensType.EOF;
            case '$':
                c = read();
                JsonTokensType jrbaseExprType = null;
                if (c == 'P') {
                    jrbaseExprType = JsonTokensType.JRPARAMETER;
                } else if (c == 'F') {
                    jrbaseExprType = JsonTokensType.JRFIELD;
                } else if (c == 'V') {
                    jrbaseExprType = JsonTokensType.JRVARIABLE;
                } 
                if (c == '{') {
                	isFreeMarkerSyntaxOccured = true;
                    for (;;) {
                        c = read();
                        switch (c) {
                        case '}':
                            return JsonTokensType.FREE_MARKUP_DOLLER_SYNTAX;
                        case EOF_CHAR:
                            unread(c);
                            return JsonTokensType.FREE_MARKUP_DOLLER_SYNTAX;
                        case '\\':
                            c = read();
                            break;
                        }
                    }
                }
            case '"':
                for (;;) {
                    c = read();
                    switch (c) {
                    case '"':
                        return JsonTokensType.QUOTED_LITERAL;
                    case EOF_CHAR:
                        unread(c);
                        return JsonTokensType.QUOTED_LITERAL;
                    case '$':
                        unread(c);
                        return JsonTokensType.QUOTED_LITERAL;
                    case '<':
                        unread(c);
                        return JsonTokensType.QUOTED_LITERAL;
                    case '\\':
                        c = read();
                        break;
                    }
                }
            case '\'':
                for (;;) {
                    c = read();
                    switch (c) {
                    case '\'':
                        return JsonTokensType.QUOTED_LITERAL;
                    case EOF_CHAR:
                        unread(c);
                        return JsonTokensType.QUOTED_LITERAL;
                    case '\\':
                        c = read();
                        break;
                    }
                }
            case '<':
            	c = read();
            	if (c == '#' || c == '/') {
                	isFreeMarkerSyntaxOccured = true;
                    for (;;) {
                        c = read();
                        switch (c) {
                        case '>':
                            return JsonTokensType.FREE_MARKUP_LOOP;
                        case EOF_CHAR:
                            unread(c);
                            return JsonTokensType.FREE_MARKUP_LOOP;
                        case '\\':
                            c = read();
                            break;
                        }
                    }
                } else {
                	for (;;) {
                        c = read();
                        switch (c) {
                        case '"':
                            return JsonTokensType.QUOTED_LITERAL;
                        case EOF_CHAR:
                            unread(c);
                            return JsonTokensType.QUOTED_LITERAL;
                        case '$':
                            unread(c);
                            return JsonTokensType.QUOTED_LITERAL;
                        case '<':
                            unread(c);
                            return JsonTokensType.QUOTED_LITERAL;
                        case '\\':
                            c = read();
                            break;
                        }
                    }
                }
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                do {
                    c = read();
                } while (Character.isDigit((char) c));
                unread(c);
                return JsonTokensType.NUMBER;
            default:
                if (jsonOperatorsAndSymbols.contains(Character.toString((char) c))) {
                    return JsonTokensType.SYMBOL;
                }
                if (Character.isWhitespace((char) c)) {
                    do {
                        c = read();
                    } while (Character.isWhitespace((char) c));
                    unread(c);
                    return JsonTokensType.SPACE;
                }
                if (Character.isJavaIdentifierStart((char) c)) {
                    fBuffer.setLength(0);
                    do {
                        fBuffer.append((char) c);
                        c = read();
                    } while (Character.isJavaIdentifierPart((char) c));
                    unread(c);

                    if (jsonKeywords.contains(fBuffer.toString().toLowerCase())) {
                        return JsonTokensType.KEYWORD;
                    }
                    return JsonTokensType.OTHER;
                }
                return JsonTokensType.OTHER;
            }
        }
    }

    private int read() {
        if (fPos <= fEnd) {
            return fDoc.charAt(fPos++);
        }
        return EOF_CHAR;
    }

    private void unread(int c) {
        if (c != EOF_CHAR)
            fPos--;
    }

    public void setRange(String text) {
        fDoc = text;
        fPos = 0;
        fEnd = fDoc.length() - 1;
    }

    public int getStartOffset() {
        return fStartToken;
    }

    public int getLength() {
        return fPos - fStartToken;
    }

    /**
     * Initializes, if needed, the Json keywords used by the scanner instance.
     */
    protected void initJsonKeywords() {
        if (jsonKeywords == null) {
            jsonKeywords = Arrays.asList(new String[] { "true", "false", "null" });
        }
    }

    /**
     * Initializes, if needed, the Json symbols and operators used by the scanner
     * instance.
     */
    protected void initJsonSymbolsAndOperators() {
        if (jsonOperatorsAndSymbols == null) {
            jsonOperatorsAndSymbols = Arrays.asList(new String[] { "[", "]", "=", "!", ">", "<" });
        }
    }
}
