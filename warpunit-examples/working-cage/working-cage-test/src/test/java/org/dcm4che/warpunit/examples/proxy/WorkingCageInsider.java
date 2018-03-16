package org.dcm4che.warpunit.examples.proxy;

import java.util.List;

import org.dcm4che.warpunit.examples.Appointment;
import org.dcm4che.warpunit.examples.Document;
import org.dcm4che.warpunit.examples.Request;

public interface WorkingCageInsider {
	public List<Request> getOpenRequests();
	public List<Document> getOpenDocuments();
	public List<Appointment> getOpenAppointments();
}
