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
package org.eclipse.bpel.names;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 25, 2006
 *
 */
public class XMLNameWordDetector  {
		
	/**
	 * Check if the character sequence is a valid name.
	 * @param seq
	 * @return true if valid, false otherwise.
	 */
	
	public boolean isValid (CharSequence seq) {
		if (seq.length() == 0) {
			return false;
		}
		if (isWordStart(seq.charAt(0)) == false) {
			return false;
		}
		for(int i=1, j = seq.length(); i < j; i++) {
			if (isWordPart(seq.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if a character can be part of the word.
	 * @param c
	 * @return true if character can be part of word, false otherwise.
	 */
	
	public boolean isWordPart (char c) {		
		return isNameChar(c);
	}

	/**
	 * 
	 * @param c 
	 * @return true of character can be a word start, false otherwise.
	 *    
	 */
	
	public boolean isWordStart (char c) {
		return (c == '_' || isLetter(c)) ;
	}
	

	/**
	 * Answer if we are a name character.
	 * 
	 * @param c
	 * @return true if name character, false otherwise 
	 */
	
	static public boolean isNameChar (char c) {
		return isLetter(c) || 
				isDigit(c) || 
				c == '.' || 
				c == '-' ||
				c == '_' ||				
				isCombiningCharacter(c) || 
				isExtender ( c );
				
	}
	/**
	 * Return of we are a letter according to the XML spec.
	 * 
	 * @param c
	 * @return true if letter, false otherwise.
	 */
	
	static public boolean isLetter ( char c ) {
		return isBaseChar ( c ) || isIdeographic ( c );
		
	}
	
	
	/**
	 * Check if we are base character according to the XML spec.
	 * @param c the character
	 * @return true if base, false otherwise.
	 */
	
	
	static public boolean isBaseChar ( char c ) {
		
		switch ( getPlane ( c ) ) {
		
		case 0x00 :
			return range(c,0x0041,0x005A) || 
					range(c,0x0061,0x007A) || 
					range(c,0x00C0,0x00D6) || 
					range(c,0x00D8,0x00F6) || 
					range(c,0x00F8,0x00FF) ;
			
		case 0x01 :
			return range(c,0x0100,0x0131) || 
					range(c,0x0134,0x013E) || 
					range(c,0x0141,0x0148) || 
					range(c,0x014A,0x017E) || 
					range(c,0x0180,0x01C3) || 
					range(c,0x01CD,0x01F0) || 
					range(c,0x01F4,0x01F5) || 
					range(c,0x01FA,0x01FF);
		
		case 0x02 : 
			return range(c,0x0200, 0x0217) ||
					range(c,0x0250,0x02A8)  ||
					range(c,0x02BB,0x02C1); 
		
		case 0x03 :
			return c == 0x0386 || 
					range(c,0x0388,0x038A) ||
					c == 0x038C ||
					range(c,0x038E,0x03A1) ||
					range(c,0x03A3,0x03CE) || 
					range(c,0x03D0,0x03D6) || 
					c == 0x03DA || 
					c == 0x03DC || 
					c == 0x03DE || 
					c == 0x03E0 || 
					range(c,0x03E2,0x03F3);
		
		case 0x04 :
			return range(c,0x0401,0x040C) || 
					range(c,0x040E,0x044F) || 
					range(c,0x0451,0x045C) || 
					range(c,0x045E,0x0481) || 
					range(c,0x0490,0x04C4) || 
					range(c,0x04C7,0x04C8) || 
					range(c,0x04CB,0x04CC) || 
					range(c,0x04D0,0x04EB) || 
					range(c,0x04EE,0x04F5) || 
					range(c,0x04F8,0x04F9);
		
		case 0x05 :
			return range(c,0x0531,0x0556) || 
					c == 0x0559 || 
					range(c,0x0561,0x0586) || 
					range(c,0x05D0,0x05EA) || 
					range(c,0x05F0,0x05F2); 

		case 0x06 :
			return range(c,0x0621,0x063A) || 
					range(c,0x0641,0x064A) || 
					range(c,0x0671,0x06B7) || 
					range(c,0x06BA,0x06BE) || 
					range(c,0x06C0,0x06CE) || 
					range(c,0x06D0,0x06D3) || 
					c == 0x06D5 || 
					range(c,0x06E5,0x06E6); 			

		case 0x07 :
		case 0x08 :
			return false;
		
		case 0x09 :
			return range(c,0x0905,0x0939) || 
					c == 0x093D || 
					range(c,0x0958,0x0961) || 
					range(c,0x0985,0x098C) || 
					range(c,0x098F,0x0990) || 
					range(c,0x0993,0x09A8) || 
					range(c,0x09AA,0x09B0) || 
					c == 0x09B2 || 
					range(c,0x09B6,0x09B9) || 
					range(c,0x09DC,0x09DD) || 
					range(c,0x09DF,0x09E1) || 
					range(c,0x09F0,0x09F1) ;

		case 0x0A :
			return range(c,0x0A05,0x0A0A) || 
					range(c,0x0A0F,0x0A10) || 
					range(c,0x0A13,0x0A28) || 
					range(c,0x0A2A,0x0A30) || 
					range(c,0x0A32,0x0A33) || 
					range(c,0x0A35,0x0A36) || 
					range(c,0x0A38,0x0A39) || 
					range(c,0x0A59,0x0A5C) || 
					c == 0x0A5E || 
					range(c,0x0A72,0x0A74) || 
					range(c,0x0A85,0x0A8B) || 
					c == 0x0A8D || 
					range(c,0x0A8F,0x0A91) || 
					range(c,0x0A93,0x0AA8) || 
					range(c,0x0AAA,0x0AB0) || 
					range(c,0x0AB2,0x0AB3) || 
					range(c,0x0AB5,0x0AB9) || 
					c == 0x0ABD ||
					c == 0x0AE0;
			
		case 0x0B :
			return range(c,0x0B05,0x0B0C) || 
					range(c,0x0B0F,0x0B10) || 
					range(c,0x0B13,0x0B28) || 
					range(c,0x0B2A,0x0B30) || 
					range(c,0x0B32,0x0B33) || 
					range(c,0x0B36,0x0B39) || 
					c == 0x0B3D || 
					range(c,0x0B5C,0x0B5D) || 
					range(c,0x0B5F,0x0B61) || 
					range(c,0x0B85,0x0B8A) || 
					range(c,0x0B8E,0x0B90) || 
					range(c,0x0B92,0x0B95) || 
					range(c,0x0B99,0x0B9A) || 
					c == 0x0B9C || 
					range(c,0x0B9E,0x0B9F) || 
					range(c,0x0BA3,0x0BA4) || 
					range(c,0x0BA8,0x0BAA) || 
					range(c,0x0BAE,0x0BB5) || 
					range(c,0x0BB7,0x0BB9);
			
		case 0x0C :
			return range(c,0x0C05,0x0C0C) || 
					range(c,0x0C0E,0x0C10) || 
					range(c,0x0C12,0x0C28) || 
					range(c,0x0C2A,0x0C33) || 
					range(c,0x0C35,0x0C39) || 
					range(c,0x0C60,0x0C61) || 
					range(c,0x0C85,0x0C8C) ||
					range(c,0x0C8E,0x0C90) || 
					range(c,0x0C92,0x0CA8) || 
					range(c,0x0CAA,0x0CB3) || 
					range(c,0x0CB5,0x0CB9) || 
					c == 0x0CDE || 
					range(c,0x0CE0,0x0CE1);
		
		case 0x0D :
			return range(c,0x0D05,0x0D0C) || 
					range(c,0x0D0E,0x0D10) || 
					range(c,0x0D12,0x0D28) || 
					range(c,0x0D2A,0x0D39) || 
					range(c,0x0D60,0x0D61) ;
			
		case 0x0E :
			return range(c,0x0E01,0x0E2E) || 
					c == 0x0E30 || 
					range(c,0x0E32,0x0E33) || 
					range(c,0x0E40,0x0E45) || 
					range(c,0x0E81,0x0E82) || 
					c == 0x0E84 || 
					range(c,0x0E87,0x0E88) || 
					c == 0x0E8A || 
					c == 0x0E8D || 
					range(c,0x0E94,0x0E97) || 
					range(c,0x0E99,0x0E9F) || 
					range(c,0x0EA1,0x0EA3) || 
					c == 0x0EA5 || 
					c == 0x0EA7 || 
					range(c,0x0EAA,0x0EAB) || 
					range(c,0x0EAD,0x0EAE) || 
					c == 0x0EB0 || 
					range(c,0x0EB2,0x0EB3) || 
					c == 0x0EBD || 
					range(c,0x0EC0,0x0EC4);
			
		case 0x0F :
			return range(c,0x0F40,0x0F47) || 
					range(c,0x0F49,0x0F69);
			
		case 0x10 :
			return range(c,0x0F40,0x0F47) || 
					range(c,0x0F49,0x0F69);
			
		case 0x11 :
			return c == 0x1100 || 
					range(c,0x1102,0x1103) || 
					range(c,0x1105,0x1107) || 
					c == 0x1109 || 
					range(c,0x110B,0x110C) || 
					range(c,0x110E,0x1112) || 
					c == 0x113C || 
					c == 0x113E || 
					c == 0x1140 || 
					c == 0x114C || 
					c == 0x114E || 
					c == 0x1150 || 
					range(c,0x1154,0x1155) || 
					c == 0x1159 || 
					range(c,0x115F,0x1161) || 
					c == 0x1163 || 
					c == 0x1165 || 
					c == 0x1167 || 
					c == 0x1169 || 
					range(c,0x116D,0x116E) || 
					range(c,0x1172,0x1173) || 
					c == 0x1175 || 
					c == 0x119E || 
					c == 0x11A8 || 
					c == 0x11AB || 
					range(c,0x11AE,0x11AF) || 
					range(c,0x11B7,0x11B8) || 
					c == 0x11BA || 
					range(c,0x11BC,0x11C2) || 
					c == 0x11EB || 
					c == 0x11F0 || 
					c == 0x11F9;
			
		case 0x1E :
			return range(c,0x1E00,0x1E9B) || 
					range(c,0x1EA0,0x1EF9);
		
		case 0x1F :
			return range(c,0x1F00,0x1F15) || 
					range(c,0x1F18,0x1F1D) || 
					range(c,0x1F20,0x1F45) || 
					range(c,0x1F48,0x1F4D) || 
					range(c,0x1F50,0x1F57) || 
					c == 0x1F59 || 
					c == 0x1F5B || 
					c == 0x1F5D || 
					range(c,0x1F5F,0x1F7D) || 
					range(c,0x1F80,0x1FB4) || 
					range(c,0x1FB6,0x1FBC) || 
					c == 0x1FBE || 
					range(c,0x1FC2,0x1FC4) || 
					range(c,0x1FC6,0x1FCC) || 
					range(c,0x1FD0,0x1FD3) || 
					range(c,0x1FD6,0x1FDB) || 
					range(c,0x1FE0,0x1FEC) || 
					range(c,0x1FF2,0x1FF4) || 
					range(c,0x1FF6,0x1FFC);

		case 0x21 :
			return c ==  0x2126 || 
					range(c,0x212A,0x212B) || 
					c == 0x212E || 
					range(c,0x2180,0x2182);
			                                     
		case 0x30 :
			return range(c,0x3041,0x3094) || 
			 		range(c,0x30A1,0x30FA);
		case 0x31 :
			return range(c,0x3105,0x312C); 
			                                                                                                                                                                                                                                                                                                 
		default :
			return range(c,0xAC00,0xD7A3);
		}
	}
	
	
	/**
	 * Answer if the character is a combining character.
	 * 
	 * @param c the character
	 * @return true of combining, false otherwise.
	 */
	
	static public boolean isCombiningCharacter ( char c ) {
		
		switch ( getPlane ( c ) ) {
		
		case 0x03 :
			return range(c,0x0300,0x0345) || 
					range(c,0x0360,0x0361) ;
			
		case 0x04 :
			return range(c,0x0483,0x0486);
		
		case 0x05 :
			return range(c,0x0591,0x05A1) || 
					range(c,0x05A3,0x05B9) || 
					range(c,0x05BB,0x05BD) || 
					c == 0x05BF || 
					range(c,0x05C1,0x05C2) || 
					c == 0x05C4 ;
		
		case 0x06 :
			return range(c,0x064B,0x0652) || 
					c == 0x0670 || 
					range(c,0x06D6,0x06DC) || 
					range(c,0x06DD,0x06DF) || 
					range(c,0x06E0,0x06E4) || 
					range(c,0x06E7,0x06E8) || 
					range(c,0x06EA,0x06ED) ;
			
		case 0x09 :
			return range(c,0x0901,0x0903) || 
					c == 0x093C || 
					range(c,0x093E,0x094C) || 
					c == 0x094D || 
					range(c,0x0951,0x0954) || 
					range(c,0x0962,0x0963) || 
					range(c,0x0981,0x0983) ||
					c == 0x09BC || 
					c == 0x09BE || 
					c == 0x09BF || 
					range(c,0x09C0,0x09C4) || 
					range(c,0x09C7,0x09C8) || 
					range(c,0x09CB,0x09CD) || 
					c == 0x09D7 || 
					range(c,0x09E2,0x09E3)  ;
		
		case 0x0A :
			return c == 0x0A02 ||
					c == 0x0A3C || 
					c == 0x0A3E || 
					c == 0x0A3F || 
					range(c,0x0A40,0x0A42) || 
					range(c,0x0A47,0x0A48) || 
					range(c,0x0A4B,0x0A4D) || 
					range(c,0x0A70,0x0A71) || 
					range(c,0x0A81,0x0A83) || 
					c == 0x0ABC || 
					range(c,0x0ABE,0x0AC5) || 
					range(c,0x0AC7,0x0AC9) || 
					range(c,0x0ACB,0x0ACD) ;
		
		case 0x0B :
			return range(c,0x0B01,0x0B03) || 
					c == 0x0B3C || 
					range(c,0x0B3E,0x0B43) || 
					range(c,0x0B47,0x0B48) || 
					range(c,0x0B4B,0x0B4D) || 
					range(c,0x0B56,0x0B57) || 
					range(c,0x0B82,0x0B83) || 
					range(c,0x0BBE,0x0BC2) || 
					range(c,0x0BC6,0x0BC8) || 
					range(c,0x0BCA,0x0BCD) || 
					c == 0x0BD7 ;
		
		case 0x0C :
			return range(c,0x0C01,0x0C03) || 
					range(c,0x0C3E,0x0C44) || 
					range(c,0x0C46,0x0C48) || 
					range(c,0x0C4A,0x0C4D) || 
					range(c,0x0C55,0x0C56) || 
					range(c,0x0C82,0x0C83) || 
					range(c,0x0CBE,0x0CC4) || 
					range(c,0x0CC6,0x0CC8) || 
					range(c,0x0CCA,0x0CCD) || 
					range(c,0x0CD5,0x0CD6) ;
		
		case 0x0D :
			return range(c,0x0D02,0x0D03) || 
					range(c,0x0D3E,0x0D43) || 
					range(c,0x0D46,0x0D48) || 
					range(c,0x0D4A,0x0D4D) || 
					c == 0x0D57 ;
		
		case 0x0E :
			return c == 0x0E31 || 
					range(c,0x0E34,0x0E3A) || 
					range(c,0x0E47,0x0E4E) || 
					c == 0x0EB1 || 
					range(c,0x0EB4,0x0EB9) || 
					range(c,0x0EBB,0x0EBC) || 
					range(c,0x0EC8,0x0ECD);
			
		case 0x0F :
			return range(c,0x0F18,0x0F19) || 
			 		c == 0x0F35 || 
			 		c == 0x0F37 || 
			 		c == 0x0F39 || 
			 		c == 0x0F3E || 
			 		c == 0x0F3F || 
			 		range(c,0x0F71,0x0F84) || 
			 		range(c,0x0F86,0x0F8B) || 
			 		range(c,0x0F90,0x0F95) || 
			 		c == 0x0F97 || 
			 		range(c,0x0F99,0x0FAD) || 
			 		range(c,0x0FB1,0x0FB7) || 
			 		c == 0x0FB9 ;
		
		case 0x20 :
			return range(c,0x20D0,0x20DC) || 
					c == 0x20E1;
		case 0x30 :
			return range(c,0x302A,0x302F) || 
					c == 0x3099 || 
					c == 0x309A ;
			
		default :
			return false;
		}
	}
	
	/**
	 * Answer is the character is an Ideographic, per XML spec.
	 * <pre>
	 *   [#x4E00-#x9FA5] | #x3007 | [#x3021-#x3029]
	 * </pre>
	 * @param c the character to test 
	 * @return return true if yes, false if no.
	 */
	
	static public boolean isIdeographic (char c) {
		
		return  range(c,0x4e00, 0x9fa5) ||
				c == 0x3007 || 
				range(c,0x3021, 0x3029 ) ;
	}
	
	
	/**
	 * Answer if we are a digit, based on the XML specification.
	 * <pre>
	 * 	[#x0030-#x0039] | [#x0660-#x0669] | [#x06F0-#x06F9] | [#x0966-#x096F] |
	 *  [#x09E6-#x09EF] | [#x0A66-#x0A6F] | [#x0AE6-#x0AEF] | [#x0B66-#x0B6F] | 
	 *  [#x0BE7-#x0BEF] | [#x0C66-#x0C6F] | [#x0CE6-#x0CEF] | [#x0D66-#x0D6F] | 
	 *  [#x0E50-#x0E59] | [#x0ED0-#x0ED9] | [#x0F20-#x0F29]
	 * </pre>
	 * @param c
	 * @return true if digit, false otherwise.
	 */
	static public boolean isDigit ( char c ) {		
		
		switch ( getPlane ( c ) ) {
		
		case 0x00 :
			return range(c,0x0030,0x0039);
		case 0x06 :
			return range(c,0x0660,0x0669) || 
					range(c,0x06F0,0x06F9);
		case 0x09 :
			return range(c,0x0966,0x096F) ||
					range(c,0x09E6,0x09EF);
		case 0x0A:
			return range(c,0x0A66,0x0A6F) ||
					range(c,0x0AE6,0x0AEF);
		case 0x0B:
			return range(c,0x0B66,0x0B6F) ||
					range(c,0x0BE7,0x0BEF);		
		case 0x0C:
			return range(c,0x0C66,0x0C6F) || 
					range(c,0x0CE6,0x0CEF);
		case 0x0D:
			return range(c,0x0D66,0x0D6F);
		
		case 0x0E:
			return range(c,0x0E50,0x0E59) ||
					range(c,0x0ED0,0x0ED9);		
		case 0x0F:
			return range(c,0x0F20,0x0F29);
			
		default	:
			return false;
		}
	}
	
	
	/**
	 * Answer if we are an extender character.
	 * <pre>
	 *    #x00B7 | #x02D0 | #x02D1 | #x0387 | #x0640 | #x0E46 | #x0EC6 | #x3005 | 
	 *    [#x3031-#x3035] | [#x309D-#x309E] | [#x30FC-#x30FE]
	 * </pre>
	 * @param c
	 * @return true if extender false otherwise.
	 */
	
	static public boolean isExtender (char c) {
		
		boolean res = 
			(	c == 0x00B7 || 
				c == 0x02D0 ||
				c == 0x02D1 ||
				c == 0x0387 ||
				c == 0x0640 ||
				c == 0x0E46 ||
				c == 0x0EC6 ||
				c == 0x3005 );
		
		if (res) {
			return res;
		}		
		
		return range(c,0x3031,0x3035) ||
				range(c,0x309D,0x309E) ||
				range(c,0x30FC,0x30FE); 
	}
	
	/**
	 * Return the plane of the character in the unicode system.
	 * 
	 * @param c
	 * @return the plane (high 2 bytes)
	 */
	
	static public int getPlane (int c) {
		return (c >>> 16);
	}
	
	
	/**
	 * Ask if the character is in the range specified.
	 * 
	 * @param c the character
	 * @param l low value (inclusive)
	 * @param h high value (inclusive)
	 * @return true if in range, false otherwise.
	 */
	
	static public boolean range ( char c, int l, int h) {
		return ( c >= l && c <= h );
	}

}
