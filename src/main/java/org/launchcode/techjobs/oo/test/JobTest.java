package org.launchcode.techjobs.oo.test;
import org.junit.Assert;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        Assert.assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertEquals(job3.getName(), "Product tester");
        Assert.assertEquals(job3.getEmployer(), new Employer("ACME"));
        Assert.assertEquals(job3.getLocation(), new Location("Desert"));
        Assert.assertEquals(job3.getPositionType(), new PositionType("Quality control"));
        Assert.assertEquals(job3.getCoreCompetency(), new CoreCompetency("Persistence"));
        Assert.assertTrue(job3 instanceof Job);
        Assert.assertTrue(job3.getEmployer() instanceof Employer);
        Assert.assertTrue(job3.getLocation() instanceof Location);
        Assert.assertTrue(job3.getPositionType() instanceof PositionType);
        Assert.assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertNotEquals(job4, job5);
    }

    Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        char firstChar = job6.toString().charAt(0);
        char lastChar = job6.toString().charAt(job6.toString().length() - 1);
        char newLine = '\n';
        Assert.assertEquals(firstChar, newLine);
        Assert.assertEquals(lastChar, newLine);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        //job6.getId() = ;
        String job = job6.toString();

        String jobData = String.format("\nID: %d\n" +
                "\nName: %s\n" +
                "\nEmployer: %s\n"+
                "\nLocation: %s\n" +
                "\nPosition Type: %s\n" +
                "\nCore Competency: %s\n", job6.getId(), job6.getName(), job6.getEmployer(), job6.getLocation(), job6.getPositionType(), job6.getCoreCompetency());
        //System.out.println(job);
        Assert.assertEquals(job, jobData);
        //Assert.assertTrue((job.));

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location(), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job7Str = job7.toString();
        String jobData = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: %s\n"+
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n", job7.getId(), job7.getName(), job7.getEmployer(), "Data not available", job7.getPositionType(), job7.getCoreCompetency());
        Assert.assertEquals(jobData, job7Str);
    }
}
