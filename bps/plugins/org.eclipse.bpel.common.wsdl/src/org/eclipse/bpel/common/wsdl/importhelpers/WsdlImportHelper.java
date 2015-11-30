/****************************************************************************
 *
 * Copyright (c) 2008-2011, EBM WebSourcing
 *
 * This source code is available under agreement available at
 * http://www.petalslink.com/legal/licenses/petals-studio
 *
 * You should have received a copy of the agreement along with this program.
 * If not, write to EBM WebSourcing (4, rue Amelie - 31200 Toulouse, France).
 *
 *****************************************************************************/

package org.eclipse.bpel.common.wsdl.importhelpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.bpel.common.wsdl.SoaWsdlCommonPlugin;
import org.eclipse.bpel.common.wsdl.helpers.UriAndUrlHelper;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * A class that can import a WSDL (1.1 and 2.0) and all its dependencies (XSD, XML, WSDL).
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class WsdlImportHelper {

	public final static String RELOCATED_DIRECTORY = "relocated";

	public final static String WSDL20_NAMESPACE = "http://www.w3.org/ns/wsdl";
	public final static String WSDL11_NAMESPACE = "http://schemas.xmlsoap.org/wsdl/";
	public final static String SCHEMA_NAMESPACE = "http://www.w3.org/2001/XMLSchema";
	public final static String XSI_NAMESPACE = "http://http://www.w3.org/2001/XMLSchema-instance";

	private final DocumentBuilder documentBuilder;



	/**
	 * Constructor.
	 * @throws ParserConfigurationException if a parser could not be created
	 */
	public WsdlImportHelper() throws ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware( true );
		this.documentBuilder = factory.newDocumentBuilder();
	}


	/**
	 * Imports a WSDL or a XSD will all its dependencies.
	 * @param targetDirectory
	 * @param wsdlUris
	 * @return
	 * @throws IOException if a resource could not be read or imported
	 * @throws IllegalArgumentException if an import could not be resolved into an URI
	 * @throws URISyntaxException if an import could not be resolved into an URI
	 * @throws SAXException if an import could not be parsed
	 */
	public Map<String,File> importWsdlOrXsdAndDependencies( File targetDirectory, String... wsdlUris )
	throws IllegalArgumentException, IOException, URISyntaxException, SAXException {

		// Analyze the resources
		Map<String,WsdlImportBean> resourceUriToWIBean = new HashMap<String,WsdlImportBean> ();
		analyzeResources( resourceUriToWIBean, null, wsdlUris );


		// Now, we have to find the target path and solve conflicts in target files
		Set<File> targetFiles = new HashSet<File> ();
		IPath rootPath = new Path( targetDirectory.getAbsolutePath());
		for( Map.Entry<String,WsdlImportBean> entry : resourceUriToWIBean.entrySet()) {

			// Get the real relative file path
			String relativeFilePath = entry.getValue().getRelativePathToTargetDirectory();
			if( relativeFilePath.length() == 0 )
				relativeFilePath = UriAndUrlHelper.extractOrGenerateFileName( entry.getKey());

			else if( ! relativeFilePath.contains( "/" )
					&& ! relativeFilePath.contains( "\\" ))
				relativeFilePath = UriAndUrlHelper.extractOrGenerateFileName( relativeFilePath );

			// Imported files which are above the target directory will be put inside a specific directory
			IPath path = rootPath.append( relativeFilePath );
			if( ! rootPath.isPrefixOf( path ))
				relativeFilePath = RELOCATED_DIRECTORY + "/" + UriAndUrlHelper.extractOrGenerateFileName( entry.getKey());

			// Prevent conflicts with existing files and files to be written
			File targetFile;
			String newRelativeFilePath = relativeFilePath;
			int cpt = 0;
			while(( targetFile = new File( targetDirectory, newRelativeFilePath )).exists()
					|| targetFiles.contains( targetFile )) {
				newRelativeFilePath = insertSuffixBeforeFileExtension( relativeFilePath, "_" + cpt );
				cpt ++;
			}

			entry.getValue().setRelativePathToTargetDirectory( newRelativeFilePath );
			targetFiles.add( targetFile );
		}


		// Last steps:
		// Resolve the final target files
		// And update the import declarations in the files
		// And import the file
		Map<String,File> originUriToTargetFile = new HashMap<String,File> ();
		for( WsdlImportBean bean : resourceUriToWIBean.values()) {
			File targetFile = new File( targetDirectory, bean.getRelativePathToTargetDirectory());
			URI uri = UriAndUrlHelper.urlToUri( bean.getOriginUri());
			StringBuilder fileContent = new StringBuilder( readResourceContent( uri ));

			for( Map.Entry<String,String> entry : bean.getImportDeclarationToImportFullUri().entrySet()) {
				WsdlImportBean importBean = resourceUriToWIBean.get( entry.getValue());
				File importFile = new File( targetDirectory, importBean.getRelativePathToTargetDirectory());
				String relLoc = getRelativeLocationToFile( targetFile, importFile );

				// Make the replacement - XSD imports are more complicated
				String pattern = "(\\s|\")" + Pattern.quote( entry.getKey()) + "(\\s|\")";
				Matcher matcher = Pattern.compile( pattern, Pattern.MULTILINE | Pattern.DOTALL ).matcher( fileContent.toString());
				while( matcher.find()) {
					int start = matcher.start() + 1;	// Skip the white space or double quote
					int end = matcher.end() - 1;		// Skip the white space or double quote
					fileContent.replace( start, end, relLoc );
				}
			}

			if( ! targetFile.getParentFile().exists()
					&& ! targetFile.getParentFile().mkdirs())
				throw new IOException( "Could not create " + targetFile.getParentFile());

			OutputStream os = new FileOutputStream( targetFile );
			ByteArrayInputStream is;
			try {
				is = new ByteArrayInputStream( fileContent.toString().getBytes( "UTF-8" ));
			} catch( UnsupportedEncodingException e ) {
				is = new ByteArrayInputStream( fileContent.toString().getBytes());
			}

			copyStream( is, os );
			os.close ();

			originUriToTargetFile.put( bean.getOriginUri(), targetFile );
		}

		return originUriToTargetFile;
	}


	/**
	 * Analyzes a set of resources and gets all the import declarations.
	 * @param wsdlUris a set of URIs to WSDL or XML schemas
	 * @param referentUri the URI to use to determine the relative location of the target file
	 * @param resourceUriToWIBean a map (key = resource full URI, value = {@link WsdlImportBean})
	 * @throws URISyntaxException if an import could not be resolved to an URI
	 * @throws SAXException if an import could not be parsed
	 * @throws IOException if an import could not be read
	 */
	private void analyzeResources( Map<String,WsdlImportBean> resourceUriToWIBean, URI referentUri, String... wsdlUris )
	throws URISyntaxException, IOException, SAXException {

		for( String wsdlUri : wsdlUris ) {

			// Original URI: add it to the root
			if( ! resourceUriToWIBean.containsKey( wsdlUri )) {
				WsdlImportBean bean = new WsdlImportBean();
				bean.setOriginUri( wsdlUri );
				bean.setRelativePathToTargetDirectory( "" );
				resourceUriToWIBean.put( wsdlUri, bean );
			}

			// Now, parse it and get its dependencies
			WsdlImportBean bean = resourceUriToWIBean.get( wsdlUri );
			bean.setAnalyzed( true );
			URI uri = UriAndUrlHelper.urlToUri( wsdlUri );
			referentUri = referentUri != null ? referentUri : uri;

			Set<String> brutImports = findImports( uri );
			for( String brutImport : brutImports ) {

				// Absolute URI: we will put them at the same level than the original URI
				URI importFullUri = null;
				String importFullUriAsString = null;
				if( UriAndUrlHelper.isAbsoluteUri( brutImport )) {
					importFullUri = UriAndUrlHelper.urlToUri( brutImport );
					importFullUriAsString = brutImport;
				} else {
					importFullUri = UriAndUrlHelper.buildNewURI( uri, brutImport );
					importFullUriAsString = importFullUri.toString();
				}

				// Keep a trace of the import declaration
				bean.registerImport( brutImport, importFullUriAsString );

				// Remember the import for further processing
				if( ! resourceUriToWIBean.containsKey( importFullUriAsString )) {
					WsdlImportBean childBean = new WsdlImportBean();
					childBean.setOriginUri( importFullUriAsString );

					URI relativeUri = UriAndUrlHelper.getRelativeLocationToUri( referentUri, importFullUri );
					String relPath = relativeUri.toString();
					if( UriAndUrlHelper.isAbsoluteUri( relPath ))
						relPath = "";

					childBean.setRelativePathToTargetDirectory( relPath );
					resourceUriToWIBean.put( importFullUriAsString, childBean );
				}

				// And we need to process recursively all the new imports
				WsdlImportBean childBean = resourceUriToWIBean.get( importFullUriAsString );
				if( ! childBean.wasAnalyzed())
					analyzeResources( resourceUriToWIBean, referentUri, importFullUriAsString );
			}
		}
	}


	/**
	 * Finds all the import declarations in a given document.
	 * @param referencerUri the URI of the XML file
	 * @return a non-list of import declarations (as found in the document)
	 * @throws IOException if an import could not be read
	 * @throws SAXException if an import could not be parsed
	 */
	private Set<String> findImports( final URI referencerUri ) throws IOException, SAXException {

		Set<String> result = new HashSet<String> ();

		// Parse the XML document
		URLConnection connection = referencerUri.toURL().openConnection();
		InputStream is = connection.getInputStream();
		Document referencerDocument = this.documentBuilder.parse( is );


		// Check the root element is a valid one...
		Element docRoot = referencerDocument.getDocumentElement();
		String rootNs = docRoot.getNamespaceURI();
		String rootName = docRoot.getLocalName();
		int index = rootName.lastIndexOf( ':' );
		if( index != -1 )
			rootName = rootName.substring( ++ index );


		// ... and if so, get its import declarations
		if( "definitions".equals( rootName ) && WSDL11_NAMESPACE.equals( rootNs )
				|| "description".equals( rootName ) && WSDL20_NAMESPACE.equals( rootNs )
				|| "schema".equals( rootName ) && SCHEMA_NAMESPACE.equals( rootNs )) {
			result.addAll( findImports( docRoot ));
		}

		return result;
	}


	/**
	 * Gets all the import declarations from a XML document (XSD, WSDL).
	 * @param docRoot the root element
	 * @return a non-null list of import locations, as defined in the document
	 */
	private Set<String> findImports( Element docRoot ) {

		// Get the imports
		List<NodeList> importElements = new ArrayList<NodeList> ();
		importElements.add( docRoot.getElementsByTagNameNS( WSDL11_NAMESPACE, "import" ));
		importElements.add( docRoot.getElementsByTagNameNS( WSDL20_NAMESPACE, "import" ));
		importElements.add( docRoot.getElementsByTagNameNS( WSDL20_NAMESPACE, "include" ));
		importElements.add( docRoot.getElementsByTagNameNS( SCHEMA_NAMESPACE, "import" ));
		importElements.add( docRoot.getElementsByTagNameNS( SCHEMA_NAMESPACE, "include" ));

		// Now, get the import locations
		Set<String> importLocations = new HashSet<String> ();
		for( NodeList nodeList : importElements ) {
			for( int i=0; i<nodeList.getLength(); i++ ) {

				Element importElement = (Element) nodeList.item( i );
				String location = importElement.hasAttribute( "location" ) ? importElement.getAttribute( "location" ) : null;
				if( location == null ) {
					location = importElement.hasAttribute( "schemaLocation" ) ? importElement.getAttribute( "schemaLocation" ) : null;
					int index;
					if( location != null
							&& (index = location.lastIndexOf( ' ' )) != -1 )
						location = location.substring( ++ index );
				}

				if( location != null )
					importLocations.add( location );
			}
		}

		return importLocations;
	}


	/**
	 * Return the relative position of <code>file</code> with respect to originFile.
	 * <p>
	 * Legacy and more complete than {@link #getBasicRelativePath(File, File)}.
	 * </p>
	 *
	 * @param originFile the absolute file which acts as the <i>origin</i>.
	 * @param file the file whose relative path must be computed with respect to originFile.
	 * @return the relative path of <code>file</code> with respect to originFile.
	 * @see UriUtils#getRelativeLocationToUri(URI, URI)
	 */
	private static String getRelativeLocationToFile( File originFile, File file ) {

		String result = file.getAbsolutePath();
		try {
			URI originUri = UriAndUrlHelper.urlToUri( originFile.toURI().toURL());
			URI fileUri = UriAndUrlHelper.urlToUri( file.toURI().toURL());
			result = UriAndUrlHelper.getRelativeLocationToUri( originUri, fileUri ).toString();

		} catch( MalformedURLException e ) {
			SoaWsdlCommonPlugin.log( e, IStatus.ERROR );
		}

		return result;
	}


	/**
	 * Reads the content of a resource and returns it as a string.
	 * <p>
	 * The content is tried to be read with UTF-8 encoding.
	 * If it fails, the default system encoding is used.
	 * </p>
	 *
	 * @param uri the URI of the resource whose content must be loaded
	 * @return the resource's content
	 * @throws IOException if the resource's content could not be read
	 */
	public static String readResourceContent( URI uri ) throws IOException {

		String result = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		InputStream is = null;
		try {
			is = uri.toURL().openStream();
			copyStream( is, os );

		} finally {
			if( is != null )
				is.close();
		}

		try {
			result = os.toString( "UTF-8" );
		} catch( UnsupportedEncodingException e ) {
			result = os.toString();
		}

		return result;
	}


	/**
	 * Copies the content from in into os.
	 * <p>
	 * Neither <i>in</i> nor <i>os</i> are closed by this method.<br />
	 * They must be explicitly closed after this method is called.
	 * </p>
	 *
	 * @param in
	 * @param os
	 * @throws IOException
	 */
	private static void copyStream( InputStream in, OutputStream os ) throws IOException {

		byte[] buf = new byte[ 1024 ];
		int len;
		while((len = in.read( buf )) > 0) {
			os.write( buf, 0, len );
		}
	}


	/**
	 * Inserts a suffix before the file extension in a given string.
	 * @param string a string, file name or file path
	 * @param suffix a suffix to insert before the file extension
	 * @return a new string
	 */
	private static String insertSuffixBeforeFileExtension( String string, String suffix ) {

		int index = string.lastIndexOf( '.' );
		String result;
		if( index == -1 )
			result = string + suffix;
		else
			result = string.substring( 0, index ) + suffix + string.substring( index );

		return result;
	}
}
