package org.dcm4che.warpunit.examples;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WorkingCage {
	@Inject
	private CalenderService calenderService;
	
	@Inject
	private MailService mailService;
	
	@Inject
	private DocumentService documentService;
	
	public List<Task> getOpenTasks(){
		List<Task> openTasks = new ArrayList<>();
		openTasks.addAll(getOpenAppointments());
		openTasks.addAll(getOpenDocuments());
		openTasks.addAll(getOpenRequests());
		
		return openTasks;
	}
	
	public List<Request> getOpenRequests() {
		return mailService.getOpenRequests();
	}
	
	public List<Document> getOpenDocuments() {
		return documentService.getOpenDocuments();
	}
	
	public List<Appointment> getOpenAppointments() {
		return calenderService.getOpenAppointments();
	} 
}
