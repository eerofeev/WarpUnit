package org.dcm4che.warpunit.examples;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class WorkingCageRestService {

	@Inject
	private WorkingCage workingCage;

    @GET
    @Path("/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getOpenTasks(){
    	return workingCage.getOpenTasks();
    }
}
