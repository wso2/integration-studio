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
package org.eclipse.bpel.validator.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.namespace.QName;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @author Glenn Mi (glenn.me@oracle.com)
 * 
 * @date Sep 29, 2006
 * 
 */
public class ParserTool {

	private static final Locale INTERNAL_PARSE_LOCALE = Locale.US;

	private static final Locale INTERNAL_CAL_LOCALE = Locale.US;

	private static SimpleDateFormat zulu = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", INTERNAL_PARSE_LOCALE); //$NON-NLS-1$

	static {
		zulu.setTimeZone(TimeZone.getDefault());
	}

	/**
	 * Format date time string into the format:
	 *  2005-04-04T14:59:11.302-08:00
	 *  
	 * @param time
	 * @return the formatted date time string.
	 */
	
	public static String getDateTimeString(long time) {
		// 2005-04-04T14:59:11.302-08:00
		SimpleDateFormat xmlDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSZ", INTERNAL_PARSE_LOCALE); //$NON-NLS-1$
		Calendar cal = Calendar.getInstance(INTERNAL_CAL_LOCALE);
		cal.setTime(new Date(time));
		String javaFmt = xmlDateFormat.format(cal.getTime());

		int length = javaFmt.length();
		String dt = javaFmt.substring(0, length - 2);

		StringBuilder retVal = new StringBuilder(dt);
		retVal.append(":"); //$NON-NLS-1$
		retVal.append(javaFmt.substring(length - 2, length));

		return retVal.toString();
	}

	public static String getDateString(long time) {
		Calendar cal = Calendar.getInstance(INTERNAL_CAL_LOCALE);
		cal.setTime(new Date(time));
		SimpleDateFormat xmlDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd", INTERNAL_PARSE_LOCALE); //$NON-NLS-1$
		return xmlDateFormat.format(cal.getTime());
	}

	/**
	 * parse XML duration in the format of P1Y2M3DT10H30M12.3S
	 * 
	 * @param src
	 * @return ?
	 * @throws IllegalArgumentException
	 */

	public static long parseDuration(String src)
			throws IllegalArgumentException {
		int years = 0;
		int months = 0;
		int days = 0;
		int hours = 0;
		int minutes = 0;
		double seconds = 0.;

		int idx = 0;
		int idx2 = 0;
		if (src.charAt(idx) != 'P')
			throw new IllegalArgumentException(
					"Duration has to start with 'P'."); //$NON-NLS-1$
		idx++;

		String dayPart = null;
		String timePart = null;

		idx2 = src.indexOf('T');
		if (idx2 > 0) {
			dayPart = src.substring(idx, idx2);
			timePart = src.substring(idx2 + 1);
		} else {
			dayPart = src.substring(idx);
		}

		try {
			String str;
			if (dayPart != null && dayPart.length() > 0) {
				// parse day part
				idx = 0;

				idx2 = dayPart.indexOf('Y');
				if (idx2 > 0) {
					str = dayPart.substring(idx, idx2);
					years = Integer.parseInt(str);
					idx = idx2 + 1;
				}

				idx2 = dayPart.indexOf('M');
				if (idx2 > 0) {
					str = dayPart.substring(idx, idx2);
					months = Integer.parseInt(str);
					idx = idx2 + 1;
				}

				idx2 = dayPart.indexOf('D');
				if (idx2 > 0) {
					str = dayPart.substring(idx, idx2);
					days = Integer.parseInt(str);
					idx = idx2 + 1;
				}

				if (dayPart.indexOf('H') >= 0 || dayPart.indexOf('S') >= 0)
					throw new NumberFormatException();
			}

			if (timePart != null) {
				// parse time part
				idx = 0;

				idx2 = timePart.indexOf('H');
				if (idx2 > 0) {
					str = timePart.substring(idx, idx2);
					hours = Integer.parseInt(str);
					idx = idx2 + 1;
				}

				idx2 = timePart.indexOf('M');
				if (idx2 > 0) {
					str = timePart.substring(idx, idx2);
					minutes = Integer.parseInt(str);
					idx = idx2 + 1;
				}

				idx2 = timePart.indexOf('S');
				if (idx2 > 0) {
					str = timePart.substring(idx, idx2);
					seconds = Double.parseDouble(str);
				}

				if (timePart.indexOf('Y') >= 0 || timePart.indexOf('D') >= 0)
					throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					"duration should be in the format of 'P1Y2M3DT10H30M12.3S'"); //$NON-NLS-1$
		}

		long duration = (long) (((((((years * 365 + months * 30) + days) * 24 + hours) * 60) + minutes) * 60 + seconds) * 1000);
		return duration;
	}

	/**
	 * Parse date string into a Date.
	 * 
	 * @param dateStr
	 * @return the date
	 */

	public static Date parseDate(String dateStr) {
		try {
			if( dateStr == null || dateStr.length() < 10 )
				throw new NumberFormatException("badDateTime"); //$NON-NLS-1$
			
			SimpleDateFormat df = new SimpleDateFormat(
					"yyyy-MM-dd", INTERNAL_PARSE_LOCALE); //$NON-NLS-1$
			return df.parse( dateStr );
			
		} catch (Exception e) {
			throw new NumberFormatException(e.toString());
		}
	}

	public static Date parseDateFromLong(String longString) {
		if (longString != null) {
			return new Date(Long.parseLong(longString));
		}
		return null;
	}

	public static Calendar parseDateTimeFromLong(String longString) {
		if (longString != null) {
			Calendar calendar = Calendar.getInstance(INTERNAL_CAL_LOCALE);
			calendar.setTime(new Date(Long.parseLong(longString)));
			return calendar;
		}
		return null;
	}

	public static Calendar parseDateTime(String source) {
		return parseDateAndTime(source);
	}

	/**
	 * The simple deserializer provides most of the stuff. We just need to
	 * override makeValue().
	 * 
	 * @param source
	 *            the source string to parse
	 * @return the Calandar instance that the string was parsed into
	 * 
	 */

	public static Calendar parseDateAndTime(String source) {
		if (source == null || isEmpty(source))
			return null;

		Calendar calendar = Calendar.getInstance(INTERNAL_CAL_LOCALE);
		Date date;
		boolean bc = false;

		// validate fixed portion of format
		if (source.charAt(0) == '+')
			source = source.substring(1);

		if (source.charAt(0) == '-') {
			source = source.substring(1);
			bc = true;
		}
		if (source.length() < 19) {
			throw new NumberFormatException("badDateTime"); //$NON-NLS-1$
		}

		if (source.charAt(4) != '-' || source.charAt(7) != '-'
				|| source.charAt(10) != 'T') {
			throw new NumberFormatException("badDate"); //$NON-NLS-1$
		}

		if (source.charAt(13) != ':' || source.charAt(16) != ':') {
			throw new NumberFormatException("badTime"); //$NON-NLS-1$
		}

		// convert what we have validated so far
		try {
			synchronized (zulu) {
				date = zulu.parse((source.substring(0, 19) + ".000Z")); //$NON-NLS-1$
			}
		} catch (Exception e) {
			throw new NumberFormatException(e.toString());
		}

		int pos = 19;

		// parse optional milliseconds
		if (pos < source.length() && source.charAt(pos) == '.') {
			int milliseconds = 0;
			int start = ++pos;
			while (pos < source.length()
					&& Character.isDigit(source.charAt(pos)))
				pos++;

			String decimal = source.substring(start, pos);
			if (decimal.length() == 3)
				milliseconds = Integer.parseInt(decimal);
			else if (decimal.length() < 3)
				milliseconds = Integer.parseInt((decimal + "000") //$NON-NLS-1$
						.substring(0, 3));
			else {
				milliseconds = Integer.parseInt(decimal.substring(0, 3));
				if (decimal.charAt(3) >= '5')
					++milliseconds;
			}

			// add milliseconds to the current date
			date.setTime(date.getTime() + milliseconds);
		}

		// parse optional timezone
		if (pos + 5 < source.length()
				&& (source.charAt(pos) == '+' || (source.charAt(pos) == '-'))) {
			if (!Character.isDigit(source.charAt(pos + 1))
					|| !Character.isDigit(source.charAt(pos + 2))
					|| source.charAt(pos + 3) != ':'
					|| !Character.isDigit(source.charAt(pos + 4))
					|| !Character.isDigit(source.charAt(pos + 5))) {
				throw new NumberFormatException("badTimezone"); //$NON-NLS-1$
			}

			// subtract milliseconds from current date to obtain GMT
			// if (source.charAt(pos)=='+') milliseconds=-milliseconds;
			// date.setTime(date.getTime()+milliseconds);
			pos += 6;
		}

		if (pos < source.length() && source.charAt(pos) == 'Z') {
			pos++;
			// calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		}

		if (pos < source.length())
			throw new NumberFormatException("badChars");

		calendar.setTime(date);

		// support dates before the Christian era
		if (bc) {
			calendar.set(Calendar.ERA, GregorianCalendar.BC);
		}

		return calendar;
	}

	public static float parseFloat(String floatStr) {
		if (!isEmpty(floatStr)) {
			return Float.parseFloat(floatStr);
		}
		return 0f;
	}

	public static double parseDouble(String value) {
		String v = String.valueOf(value);
		if (!isEmpty(v)) {
			return Double.parseDouble(v);
		}
		return 0d;
	}

	public static int parseInt(String value) {
		try {
			if (!isEmpty(value)) {
				value = String.valueOf(adjustResult(value));
				return Integer.parseInt(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public static boolean parseBoolean(String value) {
		if (!isEmpty(value)) {
			return Boolean.valueOf( value );
		}
		return false;
	}

	public static short parseShort(String value) {
		if (!isEmpty(value)) {
			value = String.valueOf(adjustResult(value));
			return Short.parseShort(value);
		}
		return 0;
	}

	public static byte parseByte(String value) {
		if (!isEmpty(value)) {
			return Byte.parseByte(value);
		}
		return 0;
	}

	public static long parseLong(String value) {
		if (!isEmpty(value)) {
			return Long.parseLong(value);
		}
		return 0l;
	}

	public static char parseChar(String value) {
		if (!isEmpty(value)) {
			char arr[] = value.toCharArray();
			return arr[0];
		}
		return 0;
	}

	public static Object convertToObject(double d) {
		return Double.valueOf( d );
	}

	public static Object convertToObject(int d) {
		return Integer.valueOf( d );
	}

	public static Object convertToObject(char d) {
		return Character.valueOf( d );
	}

	public static Object convertToObject(byte d) {
		return Byte.valueOf( d );
	}

	public static Object convertToObject(short d) {
		return Short.valueOf( d );
	}

	public static Object convertToObject(long d) {
		return Long.valueOf( d );
	}

	public static Object convertToObject(float d) {
		return Float.valueOf( d );
	}

	public static Object convertToObject(Object d) {
		return d;
	}

	public static String convertToXMLString(Object value) {
		String xmlString = null;
		if (value != null) {
			// Conversion process:
			// Object -> Object
			// primitve -> String
			//
			Class type = value.getClass();
			if (type.isPrimitive()) {
				xmlString = primitiveToXMLString(value, type);
			} else if (value instanceof QName) {
				// calender
				QName qname = (QName) value;
				if (qname.getPrefix() != null && qname.getPrefix().length() > 0)
					xmlString = qname.getPrefix() + ":" + qname.getLocalPart();
				else
					xmlString = qname.getLocalPart();
			} else if (value instanceof Calendar) {
				// calender
				xmlString = calendarToXMLString((Calendar) value);
			} else if (value instanceof Date) {
				xmlString = dateToXMLString((Date) value);
			}
			// else if (value instanceof DateTimeBase)
			// {
			// xmlString = dateTimeToXMLString( (DateTimeBase) value );
			// }
			// else if (value instanceof Duration)
			// {
			// xmlString = durationToXMLString( (Duration) value );
			// }
			else {
				xmlString = String.valueOf(value);
			}

		}
		return xmlString;
	}

	// public static String durationToXMLString( Duration value )
	// {
	// return value != null ? value.toString() : "";
	// }
	//	    
	// public static String dateTimeToXMLString( DateTimeBase value )
	// {
	// return value != null ? calendarToXMLString( value.toCalendar() ) : "";
	// }
	//	    
	public static String dateToXMLString(Date value) {
		return value != null ? getDateString(value.getTime()) : "";
	}

	public static String calendarToXMLString(Calendar value) {
		return value != null ? getDateTimeString(value.getTime().getTime())
				: "";
	}

	public static String primitiveToXMLString(Object primitiveObject, Class type) {
		String xmlString = null;
		if (type == Double.class) {
			xmlString = ((Double) primitiveObject).toString();
		} else if (type == Integer.class) {
			xmlString = ((Integer) primitiveObject).toString();
		} else if (type == Boolean.class) {
			xmlString = ((Boolean) primitiveObject).toString();
		} else if (type == Float.class) {
			xmlString = ((Float) primitiveObject).toString();
		} else if (type == Byte.class) {
			xmlString = ((Byte) primitiveObject).toString();
		} else if (type == Short.class) {
			xmlString = ((Short) primitiveObject).toString();
		} else if (type == Long.class) {
			xmlString = ((Long) primitiveObject).toString();
		} else if (type == Character.class) {
			xmlString = ((Character) primitiveObject).toString();
		}
		return xmlString;
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(parseDuration(args[0]));

		Date d = new Date();
		String dtStr = getDateTimeString(d.getTime());
		System.out.println("dateTime=" + dtStr);
		Calendar cal = parseDateTime(dtStr);
		System.out.println("cal is: " + cal);
		System.out.println("date is: " + cal.getTime());
		System.out.println("XML Datetime "
				+ getDateTimeString(cal.getTime().getTime()));
		System.out
				.println("XML Date " + getDateString(cal.getTime().getTime()));

	}

	private static Object adjustResult(String result) {
		if (result != null && result.indexOf(".") > 0) {
			String dS = result;

			int fracIndex = dS.indexOf(".");
			String fr = dS.substring(fracIndex + 1, dS.length());
			String in = dS.substring(0, fracIndex);
			// fraction = (n - abs(n))
			// if the fraction is 0 then assume that the result is an integer
			// and construct an integer object and return it.
			//
			// TODO: FIXME Once we have schema types then we should do proper
			// typed return value
			// System.out.println("___________ fraction : " + fr );
			// System.out.println("___________ before decimal : " + in );
			Double d1 = new Double(fr);
			if (d1.doubleValue() == 0) {
				return new Integer(in);
			}
		}
		return result;
	}

	/**
	 * Returns true if the string is either null or contains just whitespace.
	 */

	static boolean isEmpty(String value) {
		if (value == null || value.length() == 0) {
			return true;
		}
		for (int i = 0, j = value.length(); i < j; i++) {
			if (!Character.isWhitespace(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
