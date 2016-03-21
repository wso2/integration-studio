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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.Problem;
import org.eclipse.bpel.validator.model.RuleFactory;
import org.eclipse.bpel.validator.model.Runner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * This is a skeleton of a validator that driver that only works with DOM document tree.
 * Note that there is implementation for various IModelQuery lookups by using just the DOM
 * of BPEL and WSDL and schema.
 * 
 * So while this does run it does not produce correct results. 
 * 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 2, 2007
 *
 */

@SuppressWarnings("nls")

public class CmdValidator {
	
	static protected PrintStream OUT = System.out;
	
	static final protected IProblem[] EMPTY_RESULT = {};
	
	protected Runner fRunner = null;
	
	/**
	 * Create a brand new 
	 */
	@SuppressWarnings("unchecked")	
	public CmdValidator () {
		
		//
		// register the rule factories for the validator. This is done via
		
		// the org.eclipse.bpel.validator.factories extension point in the plug-in.
		
		RuleFactory.INSTANCE.registerFactory( org.eclipse.bpel.validator.rules.Factory.INSTANCE );
		RuleFactory.INSTANCE.registerFactory( org.eclipse.bpel.validator.vprop.Factory.INSTANCE);
		RuleFactory.INSTANCE.registerFactory( org.eclipse.bpel.validator.plt.Factory.INSTANCE);
		RuleFactory.INSTANCE.registerFactory( org.eclipse.bpel.validator.wsdl.Factory.INSTANCE);
		RuleFactory.INSTANCE.registerFactory( org.eclipse.bpel.validator.xpath.Factory.INSTANCE);
		
		// RuleFactory.INSTANCE.registerFactory( org.eclipse.bpel.validator.xpath0.Factory.INSTANCE);		
		// This just prints an error message for the "process" elements in an unrecognized namespace
		RuleFactory.INSTANCE.registerFactory( org.eclipse.bpel.validator.unsupported.Factory.INSTANCE);			
	}
	
	/**
	 * Validate the given file.
	 * @param file
	 * @return the list of validation errors.
	 */
	
	public IProblem[] validate (File file) {
		//
		//Step 1. Read the BPEL process using the Model API.
		Element elm = null;
		
		try {
			
			LocationCapturingDOMParser parser = new LocationCapturingDOMParser();
			parser.parse( file.toString() );
			elm = parser.getDocument().getDocumentElement();
			
		} catch (Exception ex) {
			
			OUT.printf("Error: Cannot read BPEL Process in %1$s", file);
			ex.printStackTrace(OUT);
			return EMPTY_RESULT;
			
		}
		
		if (elm == null) {
			OUT.printf("Error: Cannot read BPEL Process in %1$s",file);	
			return EMPTY_RESULT;
		}
		// Step 2. Preparation for the validator.
				
		// Process as INode 		
		INode node = ModelQueryImpl.getModelQuery().adapt(elm, INode.class,IModelQueryLookups.ADAPT_HINT_NONE);
		
		// Step 3. Run it
		fRunner = new Runner ( ModelQueryImpl.getModelQuery(), node);
		return fRunner.run();		
	}
	
	
	/**
	 * @param source
	 * @return a list of problems
	 */
	
	public IProblem[] validate (URL source) {
		//
		//Step 1. Read the BPEL process using the Model API.
		Element elm = null;
		
		try {
			
			LocationCapturingDOMParser parser = new LocationCapturingDOMParser();
			InputSource is = new InputSource();
			is.setPublicId(source.toString());
			is.setSystemId(source.toString());
			is.setByteStream( source.openStream() );
			parser.parse( is );
			elm = parser.getDocument().getDocumentElement();
			
		} catch (Exception ex) {
			
			OUT.printf("Error: Cannot read BPEL Process in %1$s", source);
			ex.printStackTrace(OUT);
			return EMPTY_RESULT;
			
		}
		
		if (elm == null) {
			OUT.printf("Error: Cannot read BPEL Process in %1$s",source);	
			return EMPTY_RESULT;
		}
		
		// Process as INode 		
		INode node = ModelQueryImpl.getModelQuery().adapt(elm, INode.class,IModelQueryLookups.ADAPT_HINT_NONE);
		
		// Step 3. Run it
		fRunner = new Runner ( ModelQueryImpl.getModelQuery(), node);
		return fRunner.run();			
	}
		
	/**
	 * Log to a print stream 
	 * @param problems 
	 * @param ps
	 */
	
	@SuppressWarnings("boxing")
	public void log ( IProblem[] problems,PrintStream ps ) {
		
		ps.printf("<problems count=\"%1$d\">\n", problems.length);

		// Which SA-analysis cases are covered ?
		if (fRunner != null) {
			
			Set<ARule> saChecks = new TreeSet<ARule>(new Comparator<ARule> ( ){
				public int compare(ARule o1, ARule o2) {
					return o1.sa() - o2.sa();
				} 
			});
			
			saChecks.addAll( fRunner.getSAChecks() );
			ps.printf(" <sa-cases>");			
			for(ARule a : saChecks) {
				ps.printf("%1$d,", a.sa() );				
			}
			ps.printf("0</sa-cases>\n");
		}

		// Step 5. Dump problems.
		for(IProblem problem : problems) {
			Map<String,Object> map = problem.getAttributes();
			ps.println(" <problem>");
			for(Map.Entry<String,Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				if (value == null) {
					continue;
				}
				String v = toSafeXML(value);
				if (value == null || "null".equals(v)) {
					v = toSafeXML(value.toString());
				}
					
				ps.printf("  <%1$s>%2$s</%1$s>\n",entry.getKey(), v);				
			}
			ps.println(" </problem>\n");
		}
		ps.println("</problems>");		
		// done.
	}
	
	
	@SuppressWarnings("boxing")
	protected void logStats ( IProblem[] list, PrintStream ps ) {
		int error = 0, warning = 0, info = 0, unknown = 0;
		for(IProblem n : list) {
			switch (n.getAttribute(IProblem.SEVERITY, -1)) {
				case IProblem.SEVERITY_ERROR:
						error ++;
						break;
				case IProblem.SEVERITY_WARNING:
						warning ++;
						break;
				case IProblem.SEVERITY_INFO:
						info ++;
						break;
				default :
						unknown ++;
						break;
			}
		}
		ps.printf("%d errors, %d warnings, %d information\n", error,warning,info);
	}

	protected String toSafeXML ( Object value ) {
		if (value instanceof String) {
			return toSafeXML ((String) value);
		}
		return toSafeXML(JavaScriptSource.getInstance().toSource(value));
	}
	
	
	protected String toSafeXML ( String s)  {			
		if (s.indexOf("&") >= 0) {
			s = s.replaceAll("\\&", "&amp;");
		}
		if (s.indexOf("<") >= 0) {
			s = s.replaceAll("\\<", "&lt;");
		}
		if (s.indexOf(">") >= 0) {
			s = s.replaceAll("\\>", "&gt;");
		}
		return s;
	}
	
	
	
	
	
	/**
	 * @param list
	 * @throws Exception
	 */
	
	public void run (String ... list ) throws Exception {
		
		// process validation as before
		for(String a : list ) {			
			
			File aFile = new File(a);
			
			OUT.printf("Validating %1$s ...\n",aFile);			
			IProblem problems[] = validate (aFile);
						
			logStats(problems,OUT);
			
			if (problems.length == 0) {
				continue;
			}
			
			// Write the file which contains the current run errors 
			File log = new File(aFile + ".out.xml");			
			OUT.printf(" - error list as XML to %1$s\n", log );
			PrintStream ps = null;
			try {
				ps = new PrintStream( log );
				log(problems, ps);
			} catch (FileNotFoundException e) {
				// 
			} finally {
				if (ps != null) {
					ps.close();
				}
			}
			
			// write the log file which contains the source and superimposed on it 
			// we have the errors
			log = new File(aFile + ".log");			
			OUT.printf(" - log (xml source + errors) to %1$s\n", log );			
			ps = null;
			try {
				ps = new PrintStream( log );
				errorListing(new FileInputStream(aFile) , problems, ps);				
			} catch (FileNotFoundException e) {
				// 
			} finally {
				if (ps != null) {
					ps.close();
				}
			}
			
			// 
			OUT.println();			
		}
			
	}
	
	/** 
	 * Do the actual run
	 *  
	 * @param opt
	 * @throws Exception 
	 */
	
	public void run (GetOpt opt) throws Exception {
		run (opt.parameters().toArray(EMPTY));
	}
	
	
	static String [] EMPTY = {};
	
	/**
	 * Main entry point for the command line validator.
	 * @param argv
	 * @throws Exception 
	 */
	
	
	static public void main (String argv[]) throws Exception {
				
		CmdValidator builder = new CmdValidator();
		GetOpt opt = new GetOpt("-h",argv);		
		builder.run( opt  );
	}	

	

	/**
	 * Log to a print stream 
	 * @param is the process definition (bpel)
	 * @param problems an array of problems
	 * @param ps the output stream to write to
	 * @throws Exception  any exception that may be thrown.
	 */
		
	@SuppressWarnings("boxing")
	public void errorListing ( InputStream is, IProblem[] problems, PrintStream ps ) throws Exception {
		
		// sort the problems according to line number
		Arrays.sort(problems, new Comparator<IProblem> () {
			public int compare(IProblem o1, IProblem o2) {
				return o1.getAttribute(IProblem.LINE_NUMBER,0) - o2.getAttribute(IProblem.LINE_NUMBER,0);
			}			
		});
		
		// TODO: Don't assume UTF-8;		
		BufferedReader br = new BufferedReader(new InputStreamReader( is,"UTF-8"));
		
		for(int lineNo = 1, index = 0; ; lineNo++) {
			
			String nextLine = br.readLine();
			if (nextLine == null) {
				break;
			}
			ps.printf("%5d: %s\n",lineNo, nextLine );
			
			for(;index < problems.length; index++) {				
				IProblem p = problems[index];				
				int problemLineNo = p.getAttribute(IProblem.LINE_NUMBER,-1);
				if (problemLineNo <= lineNo) {
					// current line
					ps.printf("%s: %s\n", severityOf ( p ),
							 p.getAttribute(IProblem.MESSAGE,"? Unknown ?"));	
					
					ps.printf(" meta: rule=%s, sa=%s, msg.id=%s\n", p.getAttribute(IProblem.RULE),
							p.getAttribute(IProblem.SA_CODE), p.getAttribute(IProblem.MESSAGE_ID));
					
					String fix = p.getAttribute(IProblem.FIX, null);
					
					if (fix != null) {
						ps.printf("  fix: %s\n", fix);
					}
					ps.println();
				} else {
					break;
				}
			}			
		} 
		
		br.close();
		ps.println();
		ps.println();
		logStats(problems, ps);
	}
	

	/**
	 * @param problem
	 * @return the severity string
	 */
	@SuppressWarnings("boxing")
	public String severityOf ( IProblem problem ) {
		int severity = problem.getAttribute( IProblem.SEVERITY,-1);
		
		switch (severity) {
			case IProblem.SEVERITY_ERROR: 
				return "error";
			case IProblem.SEVERITY_INFO: 
				return "info";
			case IProblem.SEVERITY_WARNING:
				return "warning";
		}
		return "error";				
	}
	
	
	/**
	 * Reads the messages file into a problems array so that comparison of 
	 * results can take place.
	 * 
	 * @param aFile
	 * @return a list of problems.
	 * @throws Exception 
	 */
		
	
	static public IProblem[]  readMessages ( File aFile ) throws Exception {
		return readMessages( new FileInputStream(aFile), aFile.getPath() );
	}
	
	
	/**
	 * @param is
	 * @param id
	 * @return a list of problems.
	 * @throws Exception
	 */
	static public IProblem[]  readMessages ( InputStream is , String id ) throws Exception {
		
		LocationCapturingDOMParser parser = new LocationCapturingDOMParser();
		
		InputSource inputSource = new InputSource();
		inputSource.setByteStream(is);
		inputSource.setPublicId(id);
		inputSource.setSystemId(id);
		parser.parse( inputSource );
		
		Document doc = parser.getDocument() ;
		
		Element elm = doc.getDocumentElement();
		
		if ("problems".equals (elm.getTagName()) == false) {
			return EMPTY_RESULT;
		}
		
		List<IProblem> list = new LinkedList<IProblem>();
		
		NodeList nl = elm.getElementsByTagName("problem");
		
		for(int i=0, j=nl.getLength(); i<j; i++) {
			Element e = (Element) nl.item(i);
			list.add( Element2Problem (e) );
		}
		
		return list.toArray(EMPTY_RESULT);
	}
	
	static Set<String> KEY_SET = keys ( IProblem.class) ;
	
	
	static IProblem Element2Problem ( Element e ) {
		
		IProblem p = new Problem ();
		
		Node n = e.getFirstChild();
		while (n != null) {			
			if (n instanceof Element) {				
				Element ne = (Element) n;
				String key = ne.getTagName();
				if (KEY_SET.contains(key)) {
					p.setAttribute(key, ne.getTextContent());
				}
			}
			n = n.getNextSibling();
		}
			
		return p;
	}
	
	
	static Set<String> keys ( Class<?> klazz ) {
		
		Set<String> set = new HashSet<String>();
		
		for(Field f: klazz.getFields() ) {
			int modifies = f.getModifiers();
			String name = f.getName();
			if (name.equals ( name.toUpperCase() ) == false) {
				continue;
			}
			if ((modifies & Member.PUBLIC) != Member.PUBLIC ) {
				continue;
			}
			if (f.getType() != String.class) {
				continue;
			}
			
			try {
				String value = (String) f.get(null);				
				set.add( value );				
			} catch (Throwable t) {
				// should not happen.
			}			
		}
		
		return set;
	}
}
