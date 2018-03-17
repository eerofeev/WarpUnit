package org.dcm4che.warpunit.examples.db;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.dcm4che.test.em.EntityManipulator;
import org.dcm4che.test.remote.WarpGate;
import org.dcm4che.test.remote.WarpUnit;
import org.dcm4che.warpunit.examples.Document;
import org.dcm4che.warpunit.examples.WorkingCage;
import org.junit.Assert;
import org.junit.Test;

public class DBTest {

    @Inject
    WorkingCage workingCage;

    @Test
    public void testNoDocuments() {

        System.out.println("This is printed in the JUnit test log");

        WarpGate gate = WarpUnit.builder()
                .primaryClass(DBTest.class)
                .createGate();

        List<Document> documents = gate.warp(() -> {
            System.out.println("This is printed in the server log");
            return workingCage.getOpenDocuments();
        });

        Assert.assertEquals(0, documents.size());
    }
    
    @Test
    public void testOpenDocuments() throws IOException {
    	try (EntityManipulator manipulator = new EntityManipulator()) {
    		Preference preference = new Preference();
    		preference.setPreferenceKey("med.open");
    		preference.setPreferenceValue("true");
    		manipulator.insertEntity(preference);
    		
    		WarpGate gate = WarpUnit.builder()
                    .primaryClass(DBTest.class)
                    .createGate();

            List<Document> documents = gate.warp(() -> {
                System.out.println("This is printed in the server log");
                return workingCage.getOpenDocuments();
            });
            
            Assert.assertEquals(1, documents.size());
    	}
    }
    
    @Test
    public void testOpenAndRestrictedDocuments() throws Exception {
    	try (EntityManipulator manipulator = new EntityManipulator()) {
    		Preference openPreference = new Preference();
    		openPreference.setPreferenceKey("med.open");
    		openPreference.setPreferenceValue("true");
    		manipulator.insertEntity(openPreference);
    		
    		Preference restrictedPreference = manipulator.loadEntityByQuery("SELECT p FROM Preference p where preferenceKey = 'med.restricted'", Preference.class);
    		restrictedPreference.setPreferenceValue("true");
    		manipulator.updateEntity(restrictedPreference);
    		
    		WarpGate gate = WarpUnit.builder()
                    .primaryClass(DBTest.class)
                    .createGate();

            List<Document> documents = gate.warp(() -> {
                System.out.println("This is printed in the server log");
                return workingCage.getOpenDocuments();
            });
            
            Assert.assertEquals(2, documents.size());
    	}
    }
}
