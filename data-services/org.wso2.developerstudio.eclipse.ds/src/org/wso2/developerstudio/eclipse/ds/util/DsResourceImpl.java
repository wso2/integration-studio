/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * 
 * @see org.wso2.developerstudio.eclipse.ds.util.DsResourceFactoryImpl
 * @generated NOT
 */
public class DsResourceImpl extends XMLResourceImpl {
	
	private static final String prettyPrintStylesheet =
	                                                    "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0' "
	                                                            + " xmlns:xalan='http://xml.apache.org/xslt' "
	                                                            + " exclude-result-prefixes='xalan'>"
	                                                            + "  <xsl:output method='xml' indent='yes' xalan:indent-amount='4'/>"
	                                                            + "  <xsl:strip-space elements='*'/>"
	                                                            + "  <xsl:template match='/'>"
	                                                            + "    <xsl:apply-templates/>"
	                                                            + "  </xsl:template>"
	                                                            + "  <xsl:template match='node() | @*'>"
	                                                            + "        <xsl:copy>"
	                                                            + "          <xsl:apply-templates select='node() | @*'/>"
	                                                            + "        </xsl:copy>"
	                                                            + "  </xsl:template>"
	                                                            + "</xsl:stylesheet>";

	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param uri
	 *            the URI of the new resource.
	 * @generated
	 */
	public DsResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		XMLSave xmlSave = createXMLSave();
		StringWriter source = new StringWriter();

		if (options == null) {
			options = Collections.EMPTY_MAP;
		}

		ResourceHandler handler = (ResourceHandler) options.get(OPTION_RESOURCE_HANDLER);

		if (handler != null) {
			handler.preSave(this, outputStream, options);
		}

		try {
			xmlSave.save(this, source, options);
			Source stylesheetSource =
			                          new StreamSource(
			                                           new ByteArrayInputStream(
			                                                                    prettyPrintStylesheet.getBytes()));
			String tempSource = source.toString();
			tempSource = tempSource.replaceAll("&#xD;", "");
			Source xmlSource =
			                   new StreamSource(new ByteArrayInputStream(tempSource.toString()
			                                                                   .getBytes()));

			TransformerFactory tf = TransformerFactory.newInstance();
			Templates templates = tf.newTemplates(stylesheetSource);
			Transformer transformer = templates.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.transform(xmlSource, new StreamResult(outputStream));
		} catch (Exception e) {
			// ignored transformation errors and save xml to default
			// outputStream
			xmlSave.save(this, outputStream, options);
		}

		if (handler != null) {
			handler.postSave(this, outputStream, options);
		}
	}

} // DsResourceImpl
