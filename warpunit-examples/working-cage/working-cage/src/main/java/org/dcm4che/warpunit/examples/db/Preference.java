package org.dcm4che.warpunit.examples.db;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Preference.selectAll", query = "SELECT p FROM Preference p")
public class Preference implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long preferenceId;
	private String preferenceKey;
	private String preferenceValue;
	public Long getPreferenceId() {
		return preferenceId;
	}
	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}
	public String getPreferenceKey() {
		return preferenceKey;
	}
	public void setPreferenceKey(String preferenceKey) {
		this.preferenceKey = preferenceKey;
	}
	public String getPreferenceValue() {
		return preferenceValue;
	}
	public void setPreferenceValue(String preferenceValue) {
		this.preferenceValue = preferenceValue;
	}
	
	
	
}
