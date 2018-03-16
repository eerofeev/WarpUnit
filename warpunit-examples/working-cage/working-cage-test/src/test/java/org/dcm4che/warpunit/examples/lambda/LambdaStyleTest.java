package org.dcm4che.warpunit.examples.lambda;

import java.util.List;

import javax.inject.Inject;

import org.dcm4che.test.remote.WarpGate;
import org.dcm4che.test.remote.WarpUnit;
import org.dcm4che.warpunit.examples.Appointment;
import org.dcm4che.warpunit.examples.WorkingCage;
import org.junit.Assert;
import org.junit.Test;

public class LambdaStyleTest {

    @Inject
    WorkingCage workingCage;

    @Test
    public void testWorkingCage() {

        System.out.println("This is printed in the JUnit test log");

        WarpGate gate = WarpUnit.builder()
                .primaryClass(LambdaStyleTest.class)
                .createGate();

        List<Appointment> appointments = gate.warp(() -> {
            System.out.println("This is printed in the server log");
            return workingCage.getOpenAppointments();
        });

        Assert.assertEquals(1, appointments.size());
    }
}
