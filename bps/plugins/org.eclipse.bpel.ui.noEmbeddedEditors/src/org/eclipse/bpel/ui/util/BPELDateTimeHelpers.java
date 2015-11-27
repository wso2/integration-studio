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

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.eclipse.bpel.ui.properties.DateTimeSelector;


/**
 * Helpers for interacting with DateTimeSelector and DurationSelector widgets, and
 * serializing their values to XPath.
 */
public class BPELDateTimeHelpers {

	// TODO: order must match the DateTimeSelector and DurationSelector values..
	protected static final int YEAR = 0;
	protected static final int MONTH = 1;
	protected static final int DAY = 2;
	protected static final int HOUR = 3;
	protected static final int MINUTE = 4;
	protected static final int SECOND = 5;
	
	protected static final String[] dateTimeFormats = {
		"yyyy","MM","dd","HH","mm","ss" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
	};
	protected static String dateTimeFormat = "yyyy-MM-ddTHH:mm:ss"; //$NON-NLS-1$

	// these values are used to populate the Year combo of the DateTimeSelector.
	// they are also used directly by some helpers below.
	public static final int yearMin = 2002;
	public static final int yearMax = Calendar.getInstance().get(Calendar.YEAR) + 5;

	// Returns the number of consecutive ASCII zeroes in s beginning at position start.
	protected static int numZeroes(String s, int start) {
		int i; for (i = start; i<s.length(); i++) if (s.charAt(i) != '0') break;
		return i-start;
	}

	// Returns the number of consecutive ASCII digits in s beginning at position start.
	protected static int numDigits(String s, int start) {
		int i; for (i = start; i<s.length(); i++) {
			char c = s.charAt(i); if ((c < '0') || (c > '9')) break;
		}
		return i-start;
	}
	
	protected static int fQuotient(int a, int b) {
		return (int)Math.floor((double)a/(double)b);
	}
	protected static int modulo(int a, int b) {
		return a-fQuotient(a,b)*b;
	}
	protected static int fQuotient3(int a, int low, int high) {
		return fQuotient(a-low, high-low);
	}
	protected static int modulo3(int a, int low, int high) {
		return modulo(a-low, high-low) + low;
	}
	protected static int maximumDayInMonthFor(int yearValue, int monthValue) {
		int month = modulo3(monthValue, 1, 13);
		int year = yearValue + fQuotient3(monthValue, 1, 13);
		return DateTimeSelector.daysInMonth(month-1, year);
	}

	public static int[] dateTimePlusDuration(int[] dateTime, int[] duration) {
		int[] result = new int[6];
		// This algorithm from XML Schema spec:
		//http://www.w3.org/TR/2001/REC-xmlschema-2-20010502/#adding-durations-to-dateTimes
			
	    // months
		int temp = dateTime[MONTH] + duration[MONTH];
		result[MONTH] = modulo3(temp, 1, 13);
		int carry = fQuotient3(temp, 1, 13); 
		// years
		result[YEAR] = dateTime[YEAR] + duration[YEAR] + carry;
		// seconds
		temp = dateTime[SECOND] + duration[SECOND];
		result[SECOND] = modulo(temp,60);
		carry = fQuotient(temp,60);
		// minutes
		temp = dateTime[MINUTE] + duration[MINUTE] + carry;
		result[MINUTE] = modulo(temp,60);
		carry = fQuotient(temp,60);
		// hours
		temp = dateTime[HOUR] + duration[HOUR] + carry;
		result[HOUR] = modulo(temp,24);
		carry = fQuotient(temp,24);
		// days
		
		int tempDays;
		if (dateTime[DAY] > maximumDayInMonthFor(result[YEAR], result[MONTH])) {
			tempDays = maximumDayInMonthFor(result[YEAR], result[MONTH]);
		} else if (dateTime[DAY] < 1) {
			tempDays = 1;
		} else {
			tempDays = dateTime[DAY];
		}
		result[DAY] = tempDays + duration[DAY] + carry;
		for (;;) {
			if (result[DAY] < 1) {
				result[DAY] = result[DAY] + maximumDayInMonthFor(result[YEAR],result[MONTH]-1);
				carry = -1;
			} else if (result[DAY] > maximumDayInMonthFor(result[YEAR], result[MONTH])) {
				result[DAY] = result[DAY] - maximumDayInMonthFor(result[YEAR], result[MONTH]);
				carry = 1;
			} else break;
			temp = result[MONTH] + carry;
			result[MONTH] = modulo3(temp,1,13);
			result[YEAR] = result[YEAR] + fQuotient3(temp,1,13);
		}
		
		return result;
	}
	
	/**
	 * This method reads an XPath string and tries to parse it into a DateTime.
	 * The string MUST conform to the XML Schema DateTime type or parsing will fail.
	 * Returns an int[6] array if parsing is successful, or null if it fails.
	 *
	 * If the isValidFrom flag is true, any timezone specifier is IGNORED and UTC
	 * is assumed.  It will also accept a value WITHOUT QUOTES AROUND IT if this
	 * flag is true.
	 *  
	 * TODO: this doesn't support negative fields, fractional seconds or years
	 * greater than Integer.MAX_VALUE.
	 * 
	 */
	public static int[] parseXPathDateTime(String xpath, boolean isValidFrom) {
		int[] v = new int[6];
		if (xpath == null) return null;
		
		String s = removeLiteralQuotes(xpath);
		if (s == null && !isValidFrom) return null;
		if (s != null) xpath = s;
		
		if (xpath.length() < 19) return null;

		// The year field must be at least 4 digits (padded with leading zeroes), but if
		// the year is greater than 999, the year field may not contain leading zeroes.
		int i = numDigits(xpath,0);
		if (i<4) return null;
		int j = numZeroes(xpath,0);
		if ((i>4) && (j>0)) return null;
		if (j > 3) return null;  // year 0 is not allowed 
		
		if (xpath.length() < 15+i) return null;
		
		try {
			v[YEAR] = Integer.parseInt(xpath.substring(j,i));
			if (v[YEAR] < yearMin || v[YEAR] > yearMax) return null;

			if (xpath.charAt(i++) != '-') return null;
			if (numDigits(xpath,i) != 2) return null;
			v[MONTH] = Integer.parseInt(xpath.substring(i,i+2)); i += 2;
			if (v[MONTH] < 1 || v[MONTH] > 12) return null;

			if (xpath.charAt(i++) != '-') return null;
			if (numDigits(xpath,i) != 2) return null;
			v[DAY] = Integer.parseInt(xpath.substring(i,i+2)); i += 2;
			if (v[DAY] < 1 || v[DAY] > DateTimeSelector.daysInMonth(v[MONTH]-1, v[YEAR])) return null;

			if (xpath.charAt(i++) != 'T') return null;
			if (numDigits(xpath,i) != 2) return null;
			v[HOUR] = Integer.parseInt(xpath.substring(i,i+2)); i += 2;
			if (v[HOUR] < 0 || v[HOUR] > 23) return null;

			if (xpath.charAt(i++) != ':') return null;
			if (numDigits(xpath,i) != 2) return null;
			v[MINUTE] = Integer.parseInt(xpath.substring(i,i+2)); i += 2;
			if (v[MINUTE] < 0 || v[MINUTE] > 59) return null;

			if (xpath.charAt(i++) != ':') return null;
			if (numDigits(xpath,i) != 2) return null;
			v[SECOND] = Integer.parseInt(xpath.substring(i,i+2)); i += 2;
			if (v[SECOND] < 0 || v[SECOND] > 59) return null;
			if (xpath.length() == i) {
				// no timezone indicator
				// if isValidFrom is true, we assume it means UTC anyways
				if (isValidFrom) return v;
				// treat it as local time--convert it to UTC and return.
				convertLocalToGMT(v); return v;
			}
			if (xpath.charAt(i) == '.') {
				// discard fractional seconds.
				++i; i += numDigits(xpath, i);
			}

			int[] delta = new int[6];
			boolean neg = false;
			switch (xpath.charAt(i++)) {
			case 'Z':
				// UTC timezone.  we're done.
				return (xpath.length() == i)? v : null;
			case '-': neg=true;  // fall through
			case '+':
				if (xpath.length() != i+5) return null;
				if (numDigits(xpath,i) != 2) return null;
				delta[HOUR] = Integer.parseInt(xpath.substring(i,i+2)); i += 2;
				if ((delta[HOUR] < 0) || (delta[HOUR] > 23)) return null; 
				if (xpath.charAt(i++) != ':') return null;
				if (numDigits(xpath,i) != 2) return null;
				delta[MINUTE] = Integer.parseInt(xpath.substring(i,i+2)); i += 2;
				if ((delta[MINUTE] < 0) || (delta[MINUTE] > 59)) return null; 
				break;
			}
			if (neg) delta[HOUR] = -delta[HOUR];
			if (xpath.length() != i) return null;
			if (isValidFrom) {
				// if isValidFrom is true, we ignore any specified timezone!
				return v;
			}
			return dateTimePlusDuration(v,delta);
		} catch (NumberFormatException e) {
			return null;
		} catch (NullPointerException e) {
			// hack
			return null;
		}
	}

	/**
	 * This method will return a substring with either matching sinqle quotes or matching
	 * double quotes removed.  If there weren't matching quotes, it returns null.
	 */
	public static String removeLiteralQuotes(String s) {
		if (s.length() < 2) return null;
		if (s.charAt(0) != '\"' || s.charAt(s.length()-1) != '\"') {
			if (s.charAt(0) != '\'' || s.charAt(s.length()-1) != '\'') {
				return null;
			}
		}
		return s.substring(1,s.length()-1);
	}
	
	/**
	 * This method formats an array int[6] of dateTime values into an XPath string.
	 * The resulting string complies with the XML Schema DateTime type.
	 * If the values are invalid and can't be formatted, null is returned.
	 * 
	 * If the isValidFrom flag is true, the UTC specifier "Z" is not appended,
	 * and literal quotes are not added around the text.
	 */
	public static String createXPathDateTime(int[] dateTime, boolean isValidFrom) {
		StringBuffer result = new StringBuffer(dateTimeFormat);
		for (int i = 0; i<6; i++) {
			String s = String.valueOf(dateTime[i]);
			if (s.length() < ((i==YEAR)?4:2))  s = "0"+s; //$NON-NLS-1$
			setValueToStringBuffer(dateTimeFormat, result, s, dateTimeFormats[i]);
		}
		if (isValidFrom) return result.toString();
		return "\'"+result.toString()+"Z\'"; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * Returns an int[6] array representing the current DateTime in the local timezone.
	 */
	public static int[] getCurrentLocalDateTime() {
		int[] dateTime = new int[6];
		Calendar local = new GregorianCalendar();
		dateTime[YEAR]   = local.get(Calendar.YEAR);
		dateTime[MONTH]  = local.get(Calendar.MONTH)+1;
		dateTime[DAY]    = local.get(Calendar.DATE);
		dateTime[HOUR]   = local.get(Calendar.HOUR_OF_DAY);
		dateTime[MINUTE] = local.get(Calendar.MINUTE);
		dateTime[SECOND] = local.get(Calendar.SECOND);
		return dateTime;
	}
	
	/**
	 * Use this method on values returned from a DateTimeSelector, if you want the
	 * selector to show local time but serialize to GMT.
	 */
	public static void convertLocalToGMT(int[] dateTime) {
		// convert local timezone to GMT.
		Calendar local = new GregorianCalendar();
		local.set(dateTime[YEAR],dateTime[MONTH],dateTime[DAY],
			dateTime[HOUR],dateTime[MINUTE],dateTime[SECOND]);
		Calendar GMTcal = new GregorianCalendar(TimeZone.getTimeZone("GMT+0")); //$NON-NLS-1$
		GMTcal.setTime(local.getTime());
		dateTime[YEAR]   = GMTcal.get(Calendar.YEAR);
		dateTime[MONTH]  = GMTcal.get(Calendar.MONTH);
		dateTime[DAY]    = GMTcal.get(Calendar.DATE);
		dateTime[HOUR]   = GMTcal.get(Calendar.HOUR_OF_DAY);
		dateTime[MINUTE] = GMTcal.get(Calendar.MINUTE);
		dateTime[SECOND] = GMTcal.get(Calendar.SECOND);
	}
	
	/**
	 * Use this method on values before storing them in a DateTimeSelector, if you
	 * want the selector to show local time but serialize to GMT.
	 */
	public static void convertGMTToLocal(int [] dateTime) {
		// convert GMT to local timezone
		Calendar GMTcal = new GregorianCalendar(TimeZone.getTimeZone("GMT+0")); //$NON-NLS-1$
		GMTcal.set(dateTime[YEAR],dateTime[MONTH],dateTime[DAY],
			dateTime[HOUR],dateTime[MINUTE],dateTime[SECOND]);
		Calendar local = new GregorianCalendar();
		local.setTime(GMTcal.getTime());
		dateTime[YEAR]   = local.get(Calendar.YEAR);
		dateTime[MONTH]  = local.get(Calendar.MONTH);
		dateTime[DAY]    = local.get(Calendar.DATE);
		dateTime[HOUR]   = local.get(Calendar.HOUR_OF_DAY);
		dateTime[MINUTE] = local.get(Calendar.MINUTE);
		dateTime[SECOND] = local.get(Calendar.SECOND);
	}
	
	
//	private static String getValueFromString(String format, String dateString, String unit){
//		int beginIdx = format.indexOf(unit);
//		if (beginIdx < 0)  return null;
//		int endIdx = beginIdx + unit.length();
//		if (beginIdx > dateString.length() || endIdx > dateString.length()) return null;
//		return dateString.substring(beginIdx, endIdx);
//	}
	private static void setValueToStringBuffer(String format, StringBuffer dateBuffer, String value, String unit) {
		int beginIdx = format.indexOf(unit);
		if (beginIdx < 0)  return;
		int endIdx = beginIdx + unit.length();
		dateBuffer.replace(beginIdx, endIdx, value);
	}

	/**
	 * This method reads an XPath string and tries to parse it into a Duration.
	 * The string MUST conform to the XML Schema Duration type or parsing will fail.
	 * Returns an int[6] array if parsing is successful, or null if it fails.
	 * 
	 * Note that the string should begin and end with a single quote.
	 */
	public static int[] parseXPathDuration(String dtStr) {
		if (dtStr == null) return null;
		dtStr = removeLiteralQuotes(dtStr);
		if (dtStr == null) return null;

		int pos = 0;
		
		if (dtStr.length() < 3)  return null;
		if (dtStr.charAt(pos++) != 'P')  return null;
		if (dtStr.endsWith("P") || dtStr.endsWith("T"))  return null; //$NON-NLS-1$ //$NON-NLS-2$
	
		int[] value = new int[6];
	
		StringBuffer digits = new StringBuffer();
		boolean timePart = false;
		for (int i = 0; i<6; i++) {
			if (pos == dtStr.length())  break;
			if (dtStr.charAt(pos) == 'T')  {
				pos++;
				if (timePart)  return null;
				timePart = true;
			}
			digits.setLength(0);
			while (Character.isDigit(dtStr.charAt(pos))) {
			    digits.append(dtStr.charAt(pos++));
			    // We reached the end of the string without finding another letter.
			    if (pos >= dtStr.length()) return null;
			}
			
			// Skip unused terms.  Note that M is used both in the date part and the time part.
			switch (dtStr.charAt(pos++))  {
			case 'Y': if (timePart || i>0) return null; i = 0; break;
			case 'M': if (i > (timePart?4:1)) return null; i = timePart?4:1; break;
			case 'D': if (timePart || i>2) return null; i = 2; break;
			case 'H': if (!timePart || i>3) return null; i = 3; break;
			case 'S': if (!timePart || i>5) return null; i = 5; break;
			default: return null;
			}
			try {
				value[i] = Integer.parseInt(digits.toString());
				if (value[i] < 0)  return null;
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return value;
	}
	
	/**
	 * This method formats an array int[6] of dateTime values into an XPath string.
	 * The resulting string is in ISO 8601 extended format and complies with the
	 * XML Schema Duration type.
	 * If the values are invalid and can't be formatted, null is returned.
	 */
	public static String createXPathDuration(int[] duration) {
		String result = "P"; //$NON-NLS-1$
		String spec = "YMDHMS"; //$NON-NLS-1$

		boolean timePart = false;
		for (int i = 0; i<6; i++)  {
			int nv = duration[i];
			if (nv > 0) {
				if (i >= 3 && !timePart) { timePart = true; result += "T"; }  //$NON-NLS-1$
				result += nv; result += spec.charAt(i);
			}
		}
		return ("P".equals(result))? "\'P0D\'" : "\'" + result + "\'"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
}
