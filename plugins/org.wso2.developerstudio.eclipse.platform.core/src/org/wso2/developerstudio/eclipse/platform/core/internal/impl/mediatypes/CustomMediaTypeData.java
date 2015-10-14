package org.wso2.developerstudio.eclipse.platform.core.internal.impl.mediatypes;

public class CustomMediaTypeData {
	private String mediaType;
	private String[] extensions;
	private int priority;
	private String name;
	
	public CustomMediaTypeData(String mediaType, String value) {
		String[] split = value.split("\\|");
		setMediaType(mediaType);
		setName(split[0]);
		setPriority(Integer.parseInt(split[1]));
		setExtensions(split[2].split(","));
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setExtensions(String[] extensions) {
		this.extensions = extensions;
	}

	public String[] getExtensions() {
		return extensions;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
