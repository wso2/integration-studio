/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator.helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 *  
 */

@SuppressWarnings("nls")
public class JavaScriptSource {

    static final JavaScriptSource singleton = new JavaScriptSource();

    static private Map<String,Boolean> R = new HashMap<String,Boolean>();
    
    static {
        addReserved ("abstract,as,boolean,break,byte,case,catch,char,class,continue");
        addReserved ("const,debugger,default,delete,do,double,else,enum,export,extends");
        addReserved ("false,final,finally,float,for,function,goto,if,implements");
        addReserved ("import,in,instanceof,int,interface,is,long,namespace,native");
        addReserved ("new,null,package,private,protected,public,return,short");
        addReserved( "static,super,switch,synchronized,this,throw,throws,transient");
        addReserved( "true,try,typeof,use,var,void,volatile,while,with");
    }
    
    static private void addReserved (String s) 
    {
        StringTokenizer tokenizer = new StringTokenizer(s,",;");
        while (tokenizer.hasMoreElements()) {
            String next = (String) tokenizer.nextElement();    
            String nextTrim = next.trim();
            if (nextTrim.length() < 1) {
                continue;
            }
            R.put(nextTrim, Boolean.TRUE);
        }
    }
    
    /**
     * Answer if the word is reserved
     * @param word
     * @return true if so, false otherwise
     */
    
    static public boolean isReserved (String word) {
        return R.containsKey(word); 
    }
    
    /**
     * Answer if we are valid javascript identifier.
     * 
     * @param word
     * @return true of yes, false if no 
     */
    
    static public boolean isValidJSIdentifier (String word) 
    {        
        for(int i=0, j=word.length(); i < j; i++) {
            char ch = word.charAt(i);
            if (i==0) {
                if (Character.isJavaIdentifierStart(ch) == false) {
                    return false;
                }
            } else if (Character.isJavaIdentifierPart(ch) == false) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Return the singleton instance
     * 
     * @return the singleton instance of this object
     */
    
    public static JavaScriptSource getInstance() {
        return singleton;
    }

    /**
     * 
     * @author mchmiele
     *
     */
    static public class Expression 
    {
        String mExpr;
        /**
         * @param str
         */
        public Expression (String str) {
            mExpr = str;
        }
        
        /**
         * @see java.lang.Object#toString()
         */
        @Override
		public String toString()
        {
            return mExpr;
        }
    }
    
    /**
     * Convert a string into a JavaScript equivalent
     * 
     * @param value
     * @return a JavaScript string source representation
     */
    
    public String toSource(String value) {
        if (value == null) {
            return "null";
        }

        StringBuilder result = new StringBuilder(value.length());
        result.append('"');

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);

            if (c == '"') {
                result.append("\\\"");
            } else if (c == '\\') {
                result.append("\\\\");
            } else if (c == '\n') {
                result.append("\\n");
            } else if (c == '\t') {
                result.append("\\t");
            } else if (c == '\\') {
                result.append("\\\\");
            } else if (c != '\r') {
                result.append(c);
            }
            
            // TODO: Need to deal with other unicode characters here ...
        }

        result.append('"');
        return result.toString();
    }

    /**
     * Dispatch method for conversion
     * 
     * @param o any object
     * @return the JavaScript equivalent
     */
    public String toSource(Object o) {
        if (o == null) {
            return "null";
        }
        if (o instanceof Map) {
            return toSource( (Map<?,?>) o);            
        }
        if (o instanceof Object[]) {
            return toSource( (Object[]) o);            
        }
        if (o instanceof List) {
            return toSource( (List<?>) o);
        }
        if (o instanceof Number) {
            return toSource( (Number) o);            
        }
        if (o instanceof Boolean) {
            return toSource( (Boolean) o);
        }
        if (o instanceof Date) {
            return toSource( (Date) o);            
        }
        if (o instanceof String) {
            return toSource( (String) o);
        }        
        if (o instanceof StringBuilder) {
            return toSource ( ((StringBuilder)o).toString() );
        }
        if (o instanceof Expression) {
            return ((Expression)o).toString();
        }
        return "null";        
    }

    /**
     * Maps of any kind (including HashMaps)
     * 
     * <i>Note:</i> The only constraint here is that keys must make sense after being 
     * converted to JS object. That is, it must be a string
     * 
     * @param aMap
     * @return a JavaScript representation of that map
     */
    
    public String toSource(Map<?,?> aMap) {

        if (aMap == null) {
            return "null";
        }

        // { name1:"value1", name2:"value2" }

        StringBuilder js = new StringBuilder("{");

        for(Map.Entry<?, ?> entry : aMap.entrySet()) {
            // Note: Although key is an object, it only makes sense if it can be converted
            // into a JavaScript property, namely, a string            
            String key = entry.getKey().toString();
            if ( isReserved(key) || isValidJSIdentifier(key) == false) {
                js.append( toSource( key ) );
            } else {
                js.append( key );
            }            
            js.append(":");
            js.append(toSource(entry.getValue()));
            js.append(",");
        }
        /** erase last , */
        if (js.length() > 1) {
        	js.setLength(js.length()-1);
        }
        js.append("}");
        return js.toString();
    } 
    
    
    /**
     * Lists of any kind (including vectors)
     * 
     * @param o the list object to convert
     * @return a string to source rendition of this list
     */

    public String toSource(List<?> o) {
        if (o == null) {
            return "null";
        }
        return toSource(o.toArray());
    }

    
    /**
     * Object arrays are JavaScript arrays
     * @param o the object array to convert to JavaScript source
     * @return a string to source rendition of this array
     */
    public String toSource(Object[] o) {
        if (o == null) {
            return "null";
        }

        StringBuilder buf = new StringBuilder("[");
        for (int i = 0; i < o.length; i++) {
            if (i > 0) {
                buf.append(',');
            }
            buf.append(toSource(o[i]));
        }
        buf.append("]");
        return buf.toString();
    }

    
    /**
     * 
     * @param d a date object
     * @return a JS representation of a Date
     */
    public String toSource(Date d) {
        if (d == null) {
            return "null";
        }

        return "new Date(" + d.getTime() + ")";
    }

    
    /**
     * 
     * @param n a number
     * @return a JS script representation of a number
     */
    
    public String toSource(Number n) {
        if (n == null) {
            return "0";
        }
        return n.toString();
    }

    /**
     * 
     * @param b boolean
     * @return a JS script representation of a boolean
     */
    
    public String toSource(Boolean b) {
        if (b == null) {
            return "false";
        }
        return b.toString();
    }

}