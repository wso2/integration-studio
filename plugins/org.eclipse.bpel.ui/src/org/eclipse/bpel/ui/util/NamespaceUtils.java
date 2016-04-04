/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Utility class for calculating default namespaces based on namespace templates from the preference store.
 */
public class NamespaceUtils
{
    protected static char NS_SEPARATOR = '/';
    protected static char PACKAGE_SEPARATOR = '.';
    protected static String HEX_PREFIX = "%"; //$NON-NLS-1$
    protected static String CHARSET_UTF8 = "UTF-8"; //$NON-NLS-1$

    // unsafe characters
    public static final String SPACE = " "; //$NON-NLS-1$
    public static final String DOUBLE_QUOTE = "\""; //$NON-NLS-1$
    public static final String LESS_THAN = "<"; //$NON-NLS-1$
    public static final String GREATER_THAN = ">"; //$NON-NLS-1$
    public static final String POUND = "#"; //$NON-NLS-1$
    public static final String PERCENT = "%"; //$NON-NLS-1$
    public static final String LEFT_CURLY = "{"; //$NON-NLS-1$
    public static final String RIGHT_CURLY = "}"; //$NON-NLS-1$
    public static final String PIPE = "|"; //$NON-NLS-1$
    public static final String BACKSLASH = "\\"; //$NON-NLS-1$
    public static final String CARET = "^"; //$NON-NLS-1$
    public static final String TILDE = "~"; //$NON-NLS-1$
    public static final String LEFT_SQUARE = "["; //$NON-NLS-1$
    public static final String RIGHT_SQUARE = "]"; //$NON-NLS-1$
    public static final String GRAVE = "`"; //$NON-NLS-1$

    // escaped characters
    public static final String ESCAPED_SPACE = "%20"; //$NON-NLS-1$
    public static final String ESCAPED_DOUBLE_QUOTE = "%22"; //$NON-NLS-1$
    public static final String ESCAPED_LESS_THAN = "%3C"; //$NON-NLS-1$
    public static final String ESCAPED_GREATER_THAN = "%3E"; //$NON-NLS-1$
    public static final String ESCAPED_POUND = "%23"; //$NON-NLS-1$
    public static final String ESCAPED_PERCENT = "%25"; //$NON-NLS-1$
    public static final String ESCAPED_LEFT_CURLY = "%7B"; //$NON-NLS-1$
    public static final String ESCAPED_RIGHT_CURLY = "%7D"; //$NON-NLS-1$
    public static final String ESCAPED_PIPE = "%7C"; //$NON-NLS-1$
    public static final String ESCAPED_BACKSLASH = "%5C"; //$NON-NLS-1$
    public static final String ESCAPED_CARET = "%5E"; //$NON-NLS-1$
    public static final String ESCAPED_TILDE = "%7E"; //$NON-NLS-1$
    public static final String ESCAPED_LEFT_SQUARE = "%5B"; //$NON-NLS-1$
    public static final String ESCAPED_RIGHT_SQUARE = "%5D"; //$NON-NLS-1$
    public static final String ESCAPED_GRAVE = "%60"; //$NON-NLS-1$

    protected static HashMap fCharToEscaped = new HashMap(15);
    static
    {
        fCharToEscaped.put(SPACE, ESCAPED_SPACE);
        fCharToEscaped.put(DOUBLE_QUOTE, ESCAPED_DOUBLE_QUOTE);
        fCharToEscaped.put(LESS_THAN, ESCAPED_LESS_THAN);
        fCharToEscaped.put(GREATER_THAN, ESCAPED_GREATER_THAN);
        fCharToEscaped.put(POUND, ESCAPED_POUND);
        fCharToEscaped.put(PERCENT, ESCAPED_PERCENT);
        fCharToEscaped.put(LEFT_CURLY, ESCAPED_LEFT_CURLY);
        fCharToEscaped.put(RIGHT_CURLY, ESCAPED_RIGHT_CURLY);
        fCharToEscaped.put(PIPE, ESCAPED_PIPE);
        fCharToEscaped.put(BACKSLASH, ESCAPED_BACKSLASH);
        fCharToEscaped.put(CARET, ESCAPED_CARET);
        fCharToEscaped.put(TILDE, ESCAPED_TILDE);
        fCharToEscaped.put(LEFT_SQUARE, ESCAPED_LEFT_SQUARE);
        fCharToEscaped.put(RIGHT_SQUARE, ESCAPED_RIGHT_SQUARE);
        fCharToEscaped.put(GRAVE, ESCAPED_GRAVE);
    }

    /**
     * Converts a UTF-8 escaped string back into a unicode string.  This method undoes the
     * operation performed in convertNamespaceToUri.
     *
     * @param uri
     * @return - a unicode representation of the given UTF-8 escaped string.
     * @see convertNamespaceToUri
     */
    public static String convertUriToNamespace(String uri)
    {
        if (uri==null || uri.length()<1)
            return null;

        String namespace = uri;

        int prevIndex = 0; // index of the previously found %, plus 1
        int contiguousIndex = 0; // index of next contiguous hex number
        Byte hexByte = null;
        ArrayList contiguousBytes = null;
        String hexChunk = null;

        for (int i=uri.indexOf(HEX_PREFIX); i>=0; i=uri.indexOf(HEX_PREFIX, prevIndex))
        {
            // get hex byte
            hexByte = getHexByte(uri, i);
            contiguousBytes = new ArrayList();
            contiguousIndex = i;
            hexChunk = "";

            prevIndex = contiguousIndex+1; // +1 for %

            // get contiguous bytes
            while (hexByte!=null)
            {
                contiguousBytes.add(hexByte);

                hexChunk += uri.substring(contiguousIndex, contiguousIndex+3);
                prevIndex = contiguousIndex+1; // +1 for %

                hexByte = getHexByte(uri, contiguousIndex+3); // 2 for current hex num, 1 for %

                contiguousIndex += 3;
            }
            prevIndex = prevIndex>=uri.length()?uri.length()-1:prevIndex;

            if (contiguousBytes.size()<=0)
                continue;

            // convert hex string to bytes
            byte[] cbytes = new byte[contiguousBytes.size()];
            for (int j=0; j<cbytes.length; j++)
                cbytes[j] = ((Byte)contiguousBytes.get(j)).byteValue();

            try
            {
                // convert bytes to unicode
                String unicode = new String(cbytes, CHARSET_UTF8);

                // now find the hex string in the namespace and replace it with the proper unicode
                int beginIndex = namespace.indexOf(hexChunk);
                int endIndex = beginIndex+hexChunk.length();
                int lastIndex = namespace.length();
                endIndex = endIndex>lastIndex?lastIndex:endIndex;

                namespace = namespace.substring(0, beginIndex) + unicode + namespace.substring(endIndex);
            }
            catch(UnsupportedEncodingException e)
            {
                // this should never happen -- log anyway
            	// JM: Commented out:
                //ModelUtilPlugin.logWarning(e, e.getMessage());
            }
        }

        return namespace;
    }

    /**
     * Returns the Byte value of the hex string at position index in string uri.
     *
     * @param uri
     * @param index
     * @return null if characters at position index aren't of the form %HH
     */
    protected static Byte getHexByte(String uri, int index)
    {
        if (uri==null || uri.length()<1)
            return null;

        if (index>=uri.length())
            return null;

        // first character must be %
        if (!HEX_PREFIX.equals(String.valueOf(uri.charAt(index))))
            return null;

        // hex string is two digits
        int lastIndex = uri.length();
        int endIndex = index+3;

        // ensure endIndex doesn't extend the length of the string
        if (endIndex>lastIndex)
            endIndex = lastIndex;

        String hexString = uri.substring(index+1, endIndex);
        byte hexByte = 0;

        try
        {
            hexByte = Integer.valueOf(hexString, 16).byteValue();
        }
        catch (NumberFormatException e)
        {
            // not a hex number, return
            return null;
        }

        return Byte.valueOf( hexByte );
    }

    /**
     * Convert a string intended to be a target namespace, i.e. any string typed with xsd:anyURI.  According to the
     * XSD spec, any string typed with xsd:anyURI cannot contain any characters outside the US-ASCII character set.
     * These characters must be escaped in the UTF-8 hex notation, %HH.  This method also escapes "unwise" characters
     * by calling escapeUnsafeCharacters first.
     *
     * Note that models saving to an XMLResource don't need this method since the XMLResource saves/loads using a
     * Xerces parser which automatically does this.  Models using the SSE parser for saving/loading need this as the
     * SSE parser doesn't do this automatically.
     *
     * @param namespace
     * @return - UTF-8 character escaped string of any characters outside the US-ASCII character set.
     * @see convertUriToNamespace
     * @see escapeUnsafeCharacters
     */
    public static String convertNamespaceToUri(String namespace)
    {
        return convertNamespaceToUri(namespace, true);
    }

    /**
     * Convert a string intended to be a target namespace, i.e. any string typed with xsd:anyURI.  According to the
     * XSD spec, any string typed with xsd:anyURI cannot contain any characters outside the US-ASCII character set.
     * These characters must be escaped in the UTF-8 hex notation, %HH.  This method also escapes "unwise" characters
     * (except for '%' if escapePercent is set to false) by calling escapeUnsafeCharacters first.  Setting escapePercent
     * to false means you can call this method on previously converted strings without the '%' from '%HH' being converted
     * again.
     *
     * Note that models saving to an XMLResource don't need this method since the XMLResource saves/loads using a
     * Xerces parser which automatically does this.  Models using the SSE parser for saving/loading need this as the
     * SSE parser doesn't do this automatically.
     *
     * @param namespace
     * @param escapePercent - escapes '%' to it's hex value if true, ignores it otherwise.
     * @return - UTF-8 character escaped string of any characters outside the US-ASCII character set.
     * @see convertUriToNamespace
     * @see escapeUnsafeCharacters
     */
    public static String convertNamespaceToUri(String namespace, boolean escapePercent)
    {
        if (namespace==null || namespace.length()<1)
            return null;

        StringBuffer buffer = new StringBuffer();

        // first escape "unsafe" characters
        namespace = escapeUnsafeCharacters(namespace, escapePercent);

        char[] nsChars = namespace.toCharArray();
        byte[] utf8 = null;

        try
        {
	        for( char nsChar : nsChars ) {
	            // Convert all characters outside the US-ASCII range (>127) to
	            // UTF-8 bytes as dictated by the anyURI definition in the
	            // XSD spec.
	            if (nsChar>127)
	            {
	                utf8 = String.valueOf(nsChar).getBytes(CHARSET_UTF8);
	                for( byte element : utf8 ) {
	                    buffer.append(HEX_PREFIX);

	                    // 2-digit hex value
	                    buffer.append(Integer.toString(( element & 0xff ), 16).toUpperCase());
	                }
	            }
	            else
	            {
	                buffer.append(nsChar);
	            }
	        }
        }
        catch (UnsupportedEncodingException e)
        {
            // this should never happen -- log anyway
        	// JM commented out:
            //ModelUtilPlugin.logWarning(e, e.getMessage());
        }

        return buffer.toString();
    }

    /**
     * Escapes the "delim" and "unwise" characters as specified by rfc2396.  Also escapes the tilde (~) as this
     * also seems to cause problems with the XSD validator.  The characters are escaped using the UTF-8 hex
     * notation, %HH.
     *
     * To do undo this operation, call convertUriToNamespace
     *
     * @param anyURI
     * @param escapePercent - escapes '%' to it's hex value if true, ignores it otherwise.
     * @return
     */
    public static String escapeUnsafeCharacters(String anyURI, boolean escapePercent)
    {
        if (anyURI==null)
            return null;

        // must escape % first since our escapes have % in them.
        if (escapePercent)
            anyURI = anyURI.replaceAll("\\"+PERCENT, (String)fCharToEscaped.get(PERCENT)); //$NON-NLS-1$

        String key = null;

        // escape all other characters except %
        for (Iterator i = fCharToEscaped.keySet().iterator(); i.hasNext();)
        {
            key = (String)i.next();
            if (key.equals(PERCENT))
                continue;

            anyURI = anyURI.replaceAll("\\"+key, (String)fCharToEscaped.get(key)); //$NON-NLS-1$
        }

        return anyURI;
    }
}
