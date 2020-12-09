package org.wso2.developerstudio.eclipse.ds.dbseditor;

import java.util.Iterator;
import java.util.Vector;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

class DsCompletionProcessor implements IContentAssistProcessor, DsSyntax {

	private static final String NO_PRIVIOUS_TAG = "No_privious_tag";
	private static final String TAG_WITH_CLOSING_CHAR_AND_NO_CLOSING_TAG =
	                                                                       "Tag_With_Closing_Char_And_No_Closing_Tag";
	private static final String TAG_WITH_NO_CLOSING_CHAR = "Tag_with_No_Closing_Char";
	private static final String TAG_CLOSING_WITH_NO_XML_BODY = "Tag_Closing_With_No_Xml_Body";
	private static final String NO_CLOSING_TAG_FOUND = "Closing_tag_not_found";
	private static final String NEXT_OPEN_TAG_NOT_FOUND = "Next_Open_Tag_Not_Found";
	private static final String INSIDE_A_TAG = "Inside_a_tag";
	private static final String INSIDE_XML_VAL_SEC = "Inside_XML_val_sec";
	private static final String CHILDREN = "Children";
	private static final String SIBLINGS = "Siblings";

	protected Vector<String> proposalList = new Vector<String>();

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {

		ICompletionProposal[] proposalArry = null;
		String levelTag = null;
		String attriTag = null;
		String fetchType = null;

		TagInfo previousClosingTagInfo = getPreviousClosedTag(viewer, offset);

		TagInfo previousOpendTag = getPreviousOpenedTag(viewer, offset);

		TagInfo previousOpenTagClosedInfo =
		                                    getPreviousOpenTagClosedInfo(viewer,
		                                                                 previousOpendTag.getTag(),
		                                                                 previousOpendTag.getIndex());

		if (previousOpendTag.getIndex() > previousClosingTagInfo.getIndex()) {
			// if we found opening before closing tag then we -> opening based
			// sugession
			// opening index > closing index means we near to opening more..-->
			// opening

			if (previousOpenTagClosedInfo != null) {

				if (previousOpenTagClosedInfo.getTag()
				                             .equals(TAG_WITH_CLOSING_CHAR_AND_NO_CLOSING_TAG)) {
					// suggest the opened tag for the proposal and get the
					// children of that
					// levelTag = previousTag.getTag();

					TagInfo nextOpendTag = getNextOpenedTagInfo(viewer, offset); // get
					                                                             // the
					                                                             // current
					                                                             // tag
					                                                             // info

					String nextTag = nextOpendTag.getTag();

					if (nextTag.equals(INSIDE_A_TAG)) {
						// use for attribute suggest
						attriTag = previousOpendTag.getTag();

					} else if (nextTag.equals(INSIDE_XML_VAL_SEC)) {

						levelTag = previousOpendTag.getTag();
						fetchType = CHILDREN;
					} else {

						levelTag = previousOpendTag.getTag();
						fetchType = CHILDREN;
					}

				} else if (previousOpenTagClosedInfo.getTag().equals(TAG_WITH_NO_CLOSING_CHAR)) {
					// use for suggest the arrtibutes
					attriTag = previousOpendTag.getTag();

				} else if (previousOpenTagClosedInfo.getTag().equals(TAG_CLOSING_WITH_NO_XML_BODY)) {

					TagInfo nextOpendTag = getNextOpenedTagInfo(viewer, offset);
					String nextTag = nextOpendTag.getTag();

					if (nextTag.equals(INSIDE_A_TAG)) {
						// use for attribute suggest
						attriTag = previousOpendTag.getTag();

					} else if (nextTag.equals(INSIDE_XML_VAL_SEC)) {

						levelTag = previousOpendTag.getTag();
						fetchType = SIBLINGS;
					} else {

						levelTag = previousOpendTag.getTag();
						fetchType = SIBLINGS;

					}

				} else {

					String closingTag = previousOpenTagClosedInfo.getTag(); // open
					                                                        // and
					                                                        // close
					                                                        // with
					                                                        // this
					                                                        // tag
					boolean isItValidClosing = previousOpenTagClosedInfo.isDetected();

					TagInfo nextOpendTag = getNextOpenedTagInfo(viewer, offset);

					String nextTag = nextOpendTag.getTag();
					boolean validClosingWithoutAttrib =
					                                    nextOpendTag.isValidClosingwithNoAttribute();
					boolean validClosingWithAttrib = nextOpendTag.isValidClosingWithAtrribute();

					if (nextTag.equals(INSIDE_A_TAG)) {
						// use for attribute suggest
						attriTag = previousOpendTag.getTag();

					} else if (nextTag.equals(INSIDE_XML_VAL_SEC)) {

						levelTag = previousOpendTag.getTag();
						fetchType = CHILDREN;
					} else if (validClosingWithoutAttrib || validClosingWithAttrib) {

						levelTag = previousOpendTag.getTag();
						fetchType = CHILDREN;
					}
				}

			}
		} else if (previousClosingTagInfo.getIndex() > previousOpendTag.getIndex()) {
			// if we found closing before opening tag then we -> closing based
			// sugession.
			// closing index > opening index means we near to closing to more
			// --> closing
			levelTag = previousClosingTagInfo.getTag();
			fetchType = SIBLINGS;

		} else if (previousOpenTagClosedInfo.getTag()
		                                    .equals(TAG_WITH_CLOSING_CHAR_AND_NO_CLOSING_TAG) &&
		           (previousOpendTag.getIndex() == previousClosingTagInfo.getIndex())) {

			TagInfo nextOpendTag = getNextOpenedTagInfo(viewer, offset);

			String nextTag = nextOpendTag.getTag();

			if (nextTag.equals(INSIDE_A_TAG)) {
				// use for attribute suggest
				attriTag = previousOpendTag.getTag();

			} else if (nextTag.equals(INSIDE_XML_VAL_SEC)) {

				levelTag = previousOpendTag.getTag();
				fetchType = CHILDREN;
			} else {

				levelTag = previousOpendTag.getTag();
				fetchType = CHILDREN;
			}

		} else if (previousOpendTag.getTag().equals(NO_PRIVIOUS_TAG) &&
		           previousOpendTag.getIndex() == previousClosingTagInfo.getIndex()) {

			levelTag = "root";

		} else if (previousOpendTag.getTag().equals(previousOpenTagClosedInfo.getTag())) {

			levelTag = previousOpendTag.getTag();
			fetchType = CHILDREN;
		}

		if (levelTag != null) {

			String[] sugessionlist = createTagSuggesionList(levelTag.trim(), fetchType);

			for (int j = 0; j < sugessionlist.length; j++) {

				proposalList.add(sugessionlist[j]);

			}
			proposalArry = turnTagProposalVectorIntoAdaptedArray(offset);

		} else {

			String[] sugessionlist = createAttributeSuggesionList(attriTag.trim());

			for (int j = 0; j < sugessionlist.length; j++) {

				proposalList.add(sugessionlist[j]);

			}

			proposalArry = turnAttributeProposalVectorIntoAdaptedArray(offset);

		}

		return proposalArry;

	}

	protected ICompletionProposal[] turnAttributeProposalVectorIntoAdaptedArray(int offset) {
		ICompletionProposal[] result = new ICompletionProposal[proposalList.size()];

		int index = 0;

		for (Iterator i = proposalList.iterator(); i.hasNext();) {
			String keyWord = (String) i.next();

			IContextInformation info = new ContextInformation(keyWord, "intfo1");

			result[index] = new CompletionProposal(keyWord + "=" + "\"\"", // replacementString
			                                       offset, // replacementOffset
			                                               // the offset of the
			                                               // text to be
			                                               // replaced
			                                       0, // replacementLength the
			                                          // length of the text to
			                                          // be replaced
			                                       keyWord.length() + 2, // cursorPosition
			                                                             // the
			                                                             // position
			                                                             // of
			                                                             // the
			                                                             // cursor
			                                                             // following
			                                                             // the
			                                                             // insert
			                                                             // relative
			                                                             // to
			                                                             // replacementOffset
			                                       null, // image to display
			                                       keyWord, // displayString the
			                                                // string to be
			                                                // displayed for the
			                                                // proposal
			                                       info, // contntentInformation
			                                             // the context
			                                             // information
			                                             // associated with this
			                                             // proposal
			                                       "info2");
			index++;
		}
		proposalList.removeAllElements();
		return result;

	}

	/**
	 * Turns the vector into an Array of ICompletionProposal objects
	 */
	protected ICompletionProposal[] turnTagProposalVectorIntoAdaptedArray(int offset) {
		ICompletionProposal[] result = new ICompletionProposal[proposalList.size()];

		int index = 0;

		for (Iterator i = proposalList.iterator(); i.hasNext();) {
			String keyWord = (String) i.next();

			IContextInformation info = new ContextInformation(keyWord, "intfo1");
			result[index] =
			                new CompletionProposal("<" + keyWord + ">" + "</" + keyWord + ">",
			                                       offset, 0, keyWord.length() + 2, null, keyWord,
			                                       info, "info2");
			index++;
		}

		proposalList.removeAllElements();
		return result;
	}

	DsCompletionProcessor(DsSourceEditor editor) {
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { '<' };
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	private String[] createAttributeSuggesionList(String attriTag) {

		String[] sugession = {};
		if (attriTag != null) {
			if (attriTag.equals("data")) {

				sugession = dataAttributes;

			} else if (attriTag.equals("config")) {

				sugession = configAttributes;

			} else if (attriTag.equals("query")) {

				sugession = queryAttributes;

			} else if (attriTag.equals("event-trigger")) {

				sugession = eventTriggerAttributes;

			} else if (attriTag.equals("operation")) {

				sugession = operationAttributes;

			} else if (attriTag.equals("resource")) {

				sugession = resourceAttributes;

			} else if (attriTag.equals("property")) {

				sugession = propertyAttributes;

			} else if (attriTag.equals("sql")) {

				sugession = sqlAtrributes;

			} else if (attriTag.equals("result")) {

				sugession = resultAttributes;

			} else if (attriTag.equals("param")) {

				sugession = resultParamAttributes;

			} else if (attriTag.equals("element")) {

				sugession = elementAtrributes;

			} else if (attriTag.equals("attribute")) {

				sugession = resultAttributeAtrributes;

			} else if (attriTag.equals("validateLongRange")) {

				sugession = validaterAtrributes;

			} else if (attriTag.equals("validateDoubleRange")) {

				sugession = validaterAtrributes;

			} else if (attriTag.equals("validateLength")) {

				sugession = validaterAtrributes;

			} else if (attriTag.equals("validatePattern")) {

				sugession = validaterPatternAttributes;

			} else if (attriTag.equals("validateCustom")) {

				sugession = validateCustomAttributes;

			} else if (attriTag.equals("with-param")) {

				sugession = withParamAttributes;

			} else if (attriTag.equals("call-query")) {

				sugession = callQueryAttributes;
			}
		}
		return sugession;
	}

	private String[] createTagSuggesionList(String leveTag, String fetchType) {

		String[] sugession = {};

		if (leveTag != null) {
			if (leveTag.equals("data")) {
				if (fetchType.equals(CHILDREN)) {

					sugession = leveLOne;

				} else {

				}
			} else if (leveTag.equals("description")) {
				if (fetchType.equals(SIBLINGS)) {

					sugession = leveLOne;
				}

			} else if (leveTag.equals("config")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = leveLOne;

				} else {
					sugession = configLevel;
				}

			} else if (leveTag.equals("query")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = leveLOne;

				} else {

					sugession = queryLevel;
				}

			} else if (leveTag.equals("event-trigger")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = leveLOne;
				} else {

					sugession = eventTrigLevel;
				}

			} else if (leveTag.equals("operation")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = leveLOne;

				} else {
					sugession = operationLevel;
				}

			} else if (leveTag.equals("resource")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = leveLOne;

				} else {
					sugession = resourceLevel;
				}

			} else if (leveTag.equals("property")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = propertyLevel;

				} else {
					sugession = propertyLevel;
				}

			} else if (leveTag.equals("sql")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryLevel;

				} else {

				}

			} else if (leveTag.equals("result")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryLevel;

				} else {

					sugession = resultLevel;
				}
			} else if (leveTag.equals("param")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryLevel;

				} else {

					sugession = queryParamLevel;

				}
			} else if (leveTag.equals("properties")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryLevel;
				} else {

					sugession = propertyLevel;
				}
			} else if (leveTag.equals("gspread")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryLevel;

				} else {
					sugession = gspreadLevel;
				}
			} else if (leveTag.equals("worksheetnumber")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = gspreadLevel;
				} else {

				}
			} else if (leveTag.equals("startingrow")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = exelLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("maxrowcount")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = gspreadLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("hasheader")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = exelLevel; // this should be reviewed
				} else {
					// no children
				}
			} else if (leveTag.equals("workbookname")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = exelLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("element")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = resultLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("attribute")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = resultLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("call-query")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = operationLevel; // this should be reviewed
				} else {
					sugession = callQueryLevel;
				}
			} else if (leveTag.equals("validateLongRange")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryParamLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("validateDoubleRange")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryParamLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("validateLength")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryParamLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("validatePattern")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryParamLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("validateCustom")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = queryParamLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("with-param")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = callQueryLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("expression")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = eventTrigLevel;

				} else {
					// no children
				}
			} else if (leveTag.equals("target-topic")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = eventTrigLevel;

				} else {
					// no children
				}
			} else if (leveTag.equals("subscriptions")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = eventTrigLevel;
				} else {
					sugession = eventTrigSubscriptionLevel;
				}
			} else if (leveTag.equals("call-query-group")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = operationLevel;

				} else {

					sugession = callQueryGroupLevel;
				}
			} else if (leveTag.equals("subscription")) {

				if (fetchType.equals(SIBLINGS)) {

					sugession = eventTrigSubscriptionLevel;
				} else {
					// no children
				}
			} else if (leveTag.equals("root")) {

				sugession = rootTag;
			}
		}
		return sugession;

	}

	private TagInfo getNextOpenedTagInfo(ITextViewer viewer, int documentOffset) {

		int docOffset = documentOffset;
		int gtIndex = 0;
		int inTagSlashIndex = 0;
		boolean gtDetected = false;
		boolean slashDetectedInSideTag = false;
		boolean validClosingWithNoAttributes = false;
		boolean validClosingWithAttributes = false;
		boolean spaceFound = false;

		StringBuilder keywordbucket = new StringBuilder();

		try {
			while (((docOffset) <= viewer.getBottomIndexEndOffset())) {

				char currChar = viewer.getDocument().getChar(docOffset);

				if (currChar == '<') {

					gtDetected = true;
					gtIndex = docOffset;
				}

				if (gtDetected) {

					if (currChar == '/') {

						if (docOffset == (gtIndex + 1)) {

							gtDetected = false;

							return new TagInfo(INSIDE_XML_VAL_SEC, false, false);
						}
					}

					if (currChar != '<') {

						if (currChar == '/') {
							slashDetectedInSideTag = true;
							inTagSlashIndex = docOffset;
						}
						if (slashDetectedInSideTag) {

							if (currChar == '>') {

								if (docOffset == (inTagSlashIndex + 1)) {
									if (spaceFound) {

										validClosingWithAttributes = true;
										break;

									}

								} else {
									slashDetectedInSideTag = false;
								}

							}

						}

						if (currChar == ' ') {

							spaceFound = true;
						}

						if (currChar == '>') {

							if (spaceFound) {
								validClosingWithAttributes = true;
								break;
							} else {
								validClosingWithNoAttributes = true;
								break;
							}
						}

						if (!spaceFound)
							keywordbucket.append(currChar);

					}
				} else {

					if (currChar == '>') {

						return new TagInfo(INSIDE_A_TAG, false, false);
					}

					if (currChar == '<') {

					}
				}

				docOffset++;

			}

		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String tag = null;

		if (keywordbucket.toString().equals("")) {
			tag = NEXT_OPEN_TAG_NOT_FOUND;
		} else {

			tag = keywordbucket.toString();
		}

		return new TagInfo(tag, validClosingWithNoAttributes, validClosingWithAttributes);

	}

	/**
	 * 
	 * @param viewer
	 * @param documentOffset
	 * @return TagInfo --previous opened Tag and its starting index
	 */
	private TagInfo getPreviousOpenedTag(ITextViewer viewer, int documentOffset) {

		TagInfo tagAndIndex = null;
		String opentag = null;
		int gtIndex = 0;

		StringBuilder keywordbucket = new StringBuilder();

		if (documentOffset != 0) {
			gtIndex = getGtIndexForOpenTag(viewer, documentOffset);
		} else {

			gtIndex = 0;
			return new TagInfo(NO_PRIVIOUS_TAG, gtIndex);
		}

		int forwordIndex = gtIndex;

		try {
			while (((forwordIndex) <= viewer.getBottomIndexEndOffset())) {
				char currChar = viewer.getDocument().getChar(forwordIndex);

				if (currChar == ' ') {

					break;

				} else if (currChar == '>') {

					break;
				}

				if (currChar != '<')
					keywordbucket.append(currChar);

				forwordIndex++;
			}

			opentag = keywordbucket.toString();

			tagAndIndex = new TagInfo(opentag, gtIndex);

		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}

		return tagAndIndex;
	}

	/**
	 * 
	 * @param viewer
	 * @param documentOffset
	 * @return Previously closed tag
	 */
	private TagInfo getPreviousClosedTag(ITextViewer viewer, int documentOffset) {

		TagInfo tagAndIndex = null;
		String closeTag = null;
		int gtIndex = getGtIndexForClosedTag(viewer, documentOffset);
		int forwordIndex = gtIndex;

		StringBuilder keywordbucket = new StringBuilder();

		try {
			while (((forwordIndex) <= viewer.getBottomIndexEndOffset())) {

				char currChar = viewer.getDocument().getChar(forwordIndex);

				if (gtIndex == 0 && forwordIndex == (gtIndex + 1)) {

					if (currChar != '/') {

						return new TagInfo(NO_CLOSING_TAG_FOUND, 0);
					}
				}

				if (currChar != '>' && currChar != '<' && currChar != '/')
					keywordbucket.append(currChar);

				if (currChar == '>') {

					break;
				}

				forwordIndex++;
			}

			closeTag = keywordbucket.toString();

		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}

		return new TagInfo(closeTag, gtIndex);
	}

	/**
	 * 
	 * @param viewer
	 * @param tag
	 * @param tagStratingIndex
	 * @return TagInfo -- tag and closing tag detected or not
	 */
	private TagInfo getPreviousOpenTagClosedInfo(ITextViewer viewer, String tag,
	                                             int tagStratingIndex) {

		int forwordIndex = tagStratingIndex;
		int gtIndexOfClosingTag = 0;
		int outerSlashIndex = 0;
		StringBuilder keywordbucket = new StringBuilder();
		String closingseq = null;
		TagInfo taginfo = null;
		boolean openTagClosed = false;
		boolean gtDetectedForClosingtag = false;
		boolean closingTagDetected = false;
		boolean outerSlashDetected = false;
		boolean tagClosingWithNoXMLBody = false;

		try {
			while (((forwordIndex) <= viewer.getBottomIndexEndOffset())) {

				char currChar = viewer.getDocument().getChar(forwordIndex);

				if (currChar == '/') {

					outerSlashDetected = true;
					outerSlashIndex = forwordIndex;
				}

				if (currChar == '>') {

					openTagClosed = true;

					if (outerSlashDetected) {

						if (forwordIndex == (outerSlashIndex + 1)) {

							tagClosingWithNoXMLBody = true;
						} else {

							outerSlashDetected = false;
						}
					} else {
						int internalForwordIndex = forwordIndex;
						boolean internalGtDetected = false;

						int internalGtIndex = 0;
						boolean closingSeqDetected = false;
						StringBuilder internalKeywordbucket = new StringBuilder();
						// handle the incomplete tag case;
						while (((internalForwordIndex) <= viewer.getBottomIndexEndOffset())) {

							char internaCurrChar =
							                       viewer.getDocument()
							                             .getChar(internalForwordIndex);

							if (internaCurrChar == '<') {

								internalGtDetected = true;
								internalGtIndex = internalForwordIndex;

							}

							if (internalGtDetected) {

								if (internaCurrChar == '/') {

									if (internalForwordIndex == (internalGtIndex + 1)) {

										closingSeqDetected = true;
									}

								}
							}

							if (closingSeqDetected) {
								if (internaCurrChar != '/' && internaCurrChar != '<' &&
								    internaCurrChar != '>') {

									internalKeywordbucket.append(internaCurrChar);

								}
								if (internaCurrChar == '>') {
									break;
								}
							}

							internalForwordIndex++;
						}
						closingseq = internalKeywordbucket.toString();

						if (closingseq.equals(tag)) {

							return new TagInfo(tag, true);

						} else {

							return new TagInfo(TAG_WITH_CLOSING_CHAR_AND_NO_CLOSING_TAG, false);
						}
						//

					}

				}

				if (tagClosingWithNoXMLBody) {

					taginfo = new TagInfo(TAG_CLOSING_WITH_NO_XML_BODY, true);
					return taginfo;
				}

				if (openTagClosed) {

					if (currChar == '<') {

						gtIndexOfClosingTag = forwordIndex;
						gtDetectedForClosingtag = true;
					}

					if (gtDetectedForClosingtag) {
						if (currChar == '/') {
							if (forwordIndex == (gtIndexOfClosingTag + 1)) {
								closingTagDetected = true;
							} else {
								gtDetectedForClosingtag = false;
							}
						}
					}
				}

				if (closingTagDetected) {

					keywordbucket.append(currChar);
					if (currChar == '>') {
						break;
					}
				}

				forwordIndex++;
			}

			String tagString = null;
			if (!openTagClosed) {

				tagString = TAG_WITH_NO_CLOSING_CHAR;
			} else if (openTagClosed && keywordbucket.toString().equals("")) {

				tagString = TAG_WITH_CLOSING_CHAR_AND_NO_CLOSING_TAG;

			} else {
				tagString = keywordbucket.toString();
			}

			taginfo = new TagInfo(tagString, closingTagDetected);

		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}

		return taginfo;

	}

	/**
	 * 
	 * @param viewer
	 * @param documentOffset
	 * @return
	 */
	private int getGtIndexForOpenTag(ITextViewer viewer, int documentOffset) {

		int gtIndex = 0;
		int docOffset = documentOffset - 1;
		int slashIndex = 0;

		try {
			while (((docOffset) >= viewer.getTopIndexStartOffset())) {

				char currChar = viewer.getDocument().getChar(docOffset);

				if (currChar == '/') {

					slashIndex = docOffset;
				}
				if (currChar == '<') {

					if (docOffset == (slashIndex - 1)) {
						// do nothing
					} else {
						gtIndex = docOffset;
						break;
					}
				}

				docOffset--;
			}
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}

		return gtIndex;

	}

	/**
	 * 
	 * @param viewer
	 * @param documentOffset
	 * @return
	 */
	private int getGtIndexForClosedTag(ITextViewer viewer, int documentOffset) {

		int gtIndex = 0;
		int docOffset = documentOffset - 1;
		int slashIndex = 0;
		boolean slashDetected = false;

		try {
			while (((docOffset) >= viewer.getTopIndexStartOffset())) {

				char currChar = viewer.getDocument().getChar(docOffset);

				if (currChar == '/') {

					slashIndex = docOffset;
					slashDetected = true;
				}
				if (currChar == '<') {

					if (slashDetected) {

						if (docOffset == (slashIndex - 1)) {

							gtIndex = docOffset;

							break;
						} else {
							slashDetected = false;
						}
					}
				}

				docOffset--;
			}

		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}

		return gtIndex;

	}

	private class TagInfo {
		private int index;
		private String tag;
		private boolean detected;
		private boolean validClosingwithNoAttribute;
		private boolean validClosingWithAtrribute;

		public TagInfo(String tag, int index) {
			this.index = index;
			this.tag = tag;
		}

		public TagInfo(String tag, boolean detected) {
			this.tag = tag;
			this.detected = detected;
		}

		public TagInfo(String tag, boolean validClosingwithNoAttribute,
		               boolean validClosingWithAtrribute) {
			this.tag = tag;
			this.validClosingwithNoAttribute = validClosingwithNoAttribute;
			this.validClosingWithAtrribute = validClosingWithAtrribute;

		}

		public int getIndex() {
			return index;
		}

		public String getTag() {
			return tag;
		}

		public boolean isDetected() {
			return detected;
		}

		public boolean isValidClosingwithNoAttribute() {
			return validClosingwithNoAttribute;
		}

		public boolean isValidClosingWithAtrribute() {
			return validClosingWithAtrribute;
		}

	}

}