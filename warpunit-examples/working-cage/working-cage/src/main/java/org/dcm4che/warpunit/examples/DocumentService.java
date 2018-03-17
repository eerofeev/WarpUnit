package org.dcm4che.warpunit.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dcm4che.warpunit.examples.db.MedicalDocument;

public class DocumentService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	PreferenceService preferenceService;
	
	public List<Document> getOpenDocuments(){
		List<Document> documents = new ArrayList<>();
		documents.addAll(getOpenMedicalDocumentsIfPermitted());
		documents.addAll(getRestrictedMedicalDocumentsIfPermitted());
		return documents;
	}
	

	private Collection<? extends Document> getOpenMedicalDocumentsIfPermitted() {
		return getMedicalDocumentsIfPermitted("open");
	}
	
	private Collection<? extends Document> getRestrictedMedicalDocumentsIfPermitted() {
		return getMedicalDocumentsIfPermitted("restricted");
	}

	private List<Document> getMedicalDocumentsIfPermitted(String state) {
		if(!Objects.equals("true", preferenceService.getPreference("med." + state))){
			return new ArrayList<>();
		}
		
		List<MedicalDocument> medicalDocuments = em
				.createQuery("SELECT md FROM MedicalDocument md where md.state = :state ", MedicalDocument.class)
				.setParameter("state", state)
				.getResultList();
		
		return medicalDocuments.stream().map(
				(MedicalDocument md) -> 
				{
					Document doc = new Document();
					doc.text = md.getText();
					return doc;
				}).collect(Collectors.toList());
	}
}
