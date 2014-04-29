/*
 * Copyright 2005,2014 WSO2, Inc. http://www.wso2.org
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

package dataMapper.diagram.custom.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


// FIXME This is not the real implementation of this class only for R&D
public class JavaScriptGenerator {

	private static final String ARRAY = "[]";
	private String inRoot;
	private String outRoot;
	private Stack<Character> characters;
	private Queue<Character> indexSequence;
	private Set<Integer> elementSet;
	private Loop lasLoop;
	private List<MappingWire> operation;
	private Map<String, Loop> loopMap;
	private List<String> bodys;

	
	public JavaScriptGenerator(List<MappingWire> operation,String inputRoot,String outRoot) {
		characters = new Stack<Character>();
		this.operation = operation;
		indexSequence = new PriorityQueue<Character>();
		loopMap = new HashMap<String, Loop>();
		bodys = new ArrayList<String>();
		elementSet = new HashSet<Integer>();
		this.inRoot = inputRoot;
		this.outRoot = outRoot;		
	}

	private void loadCharQue() {
		characters.clear();
		
		characters.add('n');
		characters.add('m');
		characters.add('l');
		
		characters.add('z');
		characters.add('y');
		characters.add('x');
		
		characters.add('k');
		characters.add('j');
		characters.add('i');
	}
         
	public void generate() throws Exception {
	 
			for (MappingWire operator : operation) {
				Map<Integer, String> inputs = operator.getInputs();
				Map<Integer, String> outputs = operator.getOutputs();
				elementSet.clear();
				loadCharQue();
				int operatorCode = operator.getOperatorName().getOperatorCode();
				if (OperatorName.ASSIGNE.getOperatorCode() == operatorCode) {
					String inputPath = inputs.get(1);
					String outPath = outputs.get(1);

					if (inputPath.contains(ARRAY) || outPath.contains(ARRAY)) {
						// required a loop
						if (inputPath.contains(ARRAY)) {
							// required input iteration
							String[] elements = inputPath.split("\\.");
							String[] outElements = outPath.split("\\.");
							int index = 0;
							String source = null;
							for (String element : elements) {
								index++;
								if (source == null) {
									source = element;
								} else {
									source = source + "." + element.replaceAll("\\W", "");
								}
								if (element.contains(ARRAY)) {
									// check the loop
									Loop loop = loopMap.get(element);
									if (loop == null) {
										// not yet created
										Character indexChar = characters.pop();
										loop = new Loop(indexChar);
										//indexSequence.add(indexChar);
										loopMap.put(element, loop);
									}
									loop.setSource(source);
									createLoopTemplate(elements, loop, index, source);
									createLoopBody(elements, outElements);
									break;// Top level loop created
								}
							}// End of the elements loop
								// function Create Loop
						} else {
							// required output iteration
						}

					} else {
						// not required a loop
						String body = inputPath + " = " + outPath + ";";
						bodys.add(body);
					}

				} else {
					// TODO Implements other operators
				}
			}// End of the Operation Loop
	}

	private String createInputWire(String[] inelements) {
		String insource = lasLoop.getSource();
		String[] sourcItems = insource.split("\\.");
		String midElements = "";
		for (int i = sourcItems.length; i < inelements.length; i++) {
			midElements = midElements + "." + inelements[i];
		}
		String line = insource + "[" + lasLoop.getIndex() + "]" + midElements;
		return line;
	}

	private String createOutputWire(String[] outelements) {
		String outLine = null;
		for (String el : outelements) {
			if (outLine == null) {
				outLine = el;
			} else {
				if (el.contains("[]")) {
					if (outLine.contains("[]")) {
						outLine = outLine + "[" + indexSequence.poll() + "]";
					} else {
						outLine = outLine + "." + el.replaceAll("\\W", "") + "["
								+ indexSequence.poll() + "]";
					}

				} else {
					outLine = outLine + "." + el;
				}
			}
		}
		return outLine;
	}

	private String doAssigneOperation(String inputWire, String outWire) {
		return outWire + " = " + inputWire + ";";
	}

	private void createLoopBody(String[] inelements, String[] outelements) {

		String inputWire = createInputWire(inelements);
		String outputWire = createOutputWire(outelements);
		String line = doAssigneOperation(inputWire, outputWire);
		lasLoop.getSingleLine().add(line);
	}

	private void createLoopTemplate(String[] elements, Loop loop, int currentIndex, String source) {
		// Loop loop = new Loop();
		lasLoop = loop;
		indexSequence.add(loop.getIndex());
		for (int i = currentIndex; i < elements.length; i++) {
			if (elements[i].contains(ARRAY)) {
				Loop nestedloop = loop.getLoops().get(elements[i]);
				if (nestedloop == null) {
					Character indexChar = characters.pop();
					nestedloop = new JavaScriptGenerator.Loop(indexChar);
				//	indexSequence.add(indexChar);
					nestedloop.setSource(source);
					loop.getLoops().put(elements[i], nestedloop);
				}

				createLoopTemplate(elements, nestedloop, ++i, source + "[" + loop.getIndex() + "]");
			} else {
				// single line mapping or function call
				// need to loop from Current index
				elementSet.add(i);
			}
		}
	}

	private String printLoop(Loop loop) {
		StringBuilder op = new StringBuilder();
		op.append("for(var " + loop.getIndex() + " in " + loop.getSource() + "){");
		op.append("\n");
		op.append("\n\t");
		List<String> singleLine = loop.getSingleLine();
		for (String line : singleLine) {
			op.append(line);
			op.append("\n");
		}
		Map<String, Loop> loops = loop.getLoops();
		if (!loops.isEmpty()) {
			Set<String> keySet = loops.keySet();
			for (String key : keySet) {
				printLoop(loops.get(key));
			}
		}
		op.append("\n");
		op.append("}");

		return op.toString();
	}

	public String printConfig() throws Exception{
		
		Set<String> keySet = getLoopMap().keySet();
		for (String key : keySet) {
			String printLoop = printLoop(getLoopMap().get(key));
			getBodys().add(printLoop);
		}	
		StringBuilder fun = new StringBuilder();
		fun.append("function map_S_");
		fun.append(inRoot);
		fun.append("_S_");
		fun.append(outRoot);
		fun.append("(" + inRoot + ", " + outRoot + ")");
		fun.append("{ ");
		fun.append("\n");
		for (String bodyCode : bodys) {
			fun.append(bodyCode);
			fun.append("\n");
		}
		fun.append("\n");
		fun.append("return " + outRoot);
		fun.append(";");
		fun.append("\n");
		fun.append("}");

		return fun.toString();
	}

	public Map<String, Loop> getLoopMap() {
		return loopMap;
	}

	public List<String> getBodys() {
		return bodys;
	}

	class Function {
		String signature;
		String paramList;

		/**
		 * @return the signature
		 */
		public String getSignature() {
			return signature;
		}

		/**
		 * @param signature
		 *            the signature to set
		 */
		public void setSignature(String signature) {
			this.signature = signature;
		}

		/**
		 * @return the paramList
		 */
		public String getParamList() {
			return paramList;
		}

		/**
		 * @param paramList
		 *            the paramList to set
		 */
		public void setParamList(String paramList) {
			this.paramList = paramList;
		}
	}

	class Loop {
		String source;
		Character index;

		List<String> singleLine;
		Map<String, JavaScriptGenerator.Loop> loops;
		List<Function> functions;

		public Loop(Character index) {
			singleLine = new ArrayList<String>();
			loops = new HashMap<String, JavaScriptGenerator.Loop>();
			functions = new ArrayList<JavaScriptGenerator.Function>();
			this.index = index;

		}

		/**
		 * @return the source
		 */
		public String getSource() {
			return source;
		}

		/**
		 * @param source
		 *            the source to set
		 */
		public void setSource(String source) {
			this.source = source;
		}

		/**
		 * @return the index
		 */
		public Character getIndex() {
			return index;
		}

		/**
		 * @return the singleLine
		 */
		public List<String> getSingleLine() {
			return singleLine;
		}

		/**
		 * @return the functions
		 */
		public List<Function> getFunctions() {
			return functions;
		}

		/**
		 * @return the loops
		 */
		public Map<String, JavaScriptGenerator.Loop> getLoops() {
			return loops;
		}
	}
}
