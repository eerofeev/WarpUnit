package org.dcm4che.warpunit.examples.proxy;

import java.util.List;

import javax.inject.Inject;

import org.dcm4che.warpunit.examples.Appointment;
import org.dcm4che.warpunit.examples.Document;
import org.dcm4che.warpunit.examples.Request;
import org.dcm4che.warpunit.examples.WorkingCage;

public class WorkingCageInsiderImpl implements WorkingCageInsider {

    @Inject
	WorkingCage workingCage;

	@Override
	public List<Request> getOpenRequests() {
		System.out.println("This is printed in the server log");
		return workingCage.getOpenRequests();
	}

	@Override
	public List<Document> getOpenDocuments() {
		System.out.println("This is printed in the server log");
		return workingCage.getOpenDocuments();
	}

	@Override
	public List<Appointment> getOpenAppointments() {
		System.out.println("This is printed in the server log");
		return workingCage.getOpenAppointments();
	}
}
