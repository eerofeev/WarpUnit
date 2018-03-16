package org.dcm4che.warpunit.examples.proxy;


import java.util.List;

import org.dcm4che.test.remote.WarpUnit;
import org.dcm4che.warpunit.examples.Appointment;
import org.junit.Assert;
import org.junit.Test;

public class ProxyStyleWorkingCageTest {

    @Test
    public void testWorkingCageWithProxy() {

        WorkingCageInsider proxyGate = WarpUnit.builder()
                .primaryClass(WorkingCageInsiderImpl.class)
                .includeInterface(true)
                .createProxyGate(WorkingCageInsider.class);

        System.out.println("This is printed in the JUnit test log");

        List<Appointment> appointments = proxyGate.getOpenAppointments();

        Assert.assertEquals(1, appointments.size());
    }

}
