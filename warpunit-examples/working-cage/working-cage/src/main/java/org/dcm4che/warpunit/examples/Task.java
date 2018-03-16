package org.dcm4che.warpunit.examples;

import java.io.Serializable;

public class Task implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
