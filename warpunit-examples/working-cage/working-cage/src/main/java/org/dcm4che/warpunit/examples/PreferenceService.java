package org.dcm4che.warpunit.examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dcm4che.warpunit.examples.db.Preference;

public class PreferenceService {
	@PersistenceContext
	private EntityManager em;
	
	public String getPreference(String name) {
		List<Preference> preferences = em
				.createQuery("SELECT p FROM Preference p where preferenceKey = :key", Preference.class)
				.setParameter("key", name)
				.getResultList();
		if(preferences.isEmpty()) {
			return null;
		} else {
			return preferences.get(0).getPreferenceValue();
		}
	}
}
