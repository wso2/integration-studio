package org.wso2.developerstudio.eclipse.platform.core.manifest;


public class SimpleJarManifest extends AbstractManifest {
	private String manifestVersion="1.0";
	
	public String toString() {
		String manifest;
		manifest=appendLine(null, getManifestHeaderLine("Manifest-Version",getManifestVersion()));
		manifest=appendLine(manifest, "\n\n");
		return manifest;
    }
	
	protected String getDefaultName() {
		return "MANIFEST.MF";
	}

	protected String getManifestVersion() {
	    return manifestVersion;
    }
	
	protected String getManifestHeaderLine(String name,String value){
		return name+": "+value;
	}
	protected String appendLine(String currentStr,String appendStr){
		if (currentStr==null){
			return appendStr;
		}else{
			return currentStr+"\n"+appendStr;
		}
	}

}

