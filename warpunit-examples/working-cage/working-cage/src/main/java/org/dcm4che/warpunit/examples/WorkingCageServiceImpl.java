package org.dcm4che.warpunit.examples;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService
public class WorkingCageServiceImpl implements WorkingCageService {
	
	@Inject
	private WorkingCage workingCage;

	@Override
	public List<Task> getOpenTasks() {
		return workingCage.getOpenTasks();
	}

}
