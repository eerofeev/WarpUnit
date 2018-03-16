package org.dcm4che.warpunit.examples;

import java.util.Date;

public class Appointment extends Task {
	private static final long serialVersionUID = 1L;

	protected Date appointmentDate;

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	
}
