package org.dcm4che.warpunit.examples;

import java.util.ArrayList;
import java.util.List;

public class CalenderService {
	
	public List<Appointment> getOpenAppointments() {
		List<Appointment> appointments = new ArrayList<>();
		Appointment testAppointment = new Appointment();
		testAppointment.setDescription("Test appointment");
		appointments.add(testAppointment);
		return appointments;
	}
}
