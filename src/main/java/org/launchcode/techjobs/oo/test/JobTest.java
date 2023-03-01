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

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstChar = job6.toString().charAt(0);
        char lastChar = job6.toString().charAt(job6.toString().length() - 1);
        String newLn = "\n";
        char newLine = newLn.charAt(0);
        //System.out.println(firstChar);
        Assert.assertEquals(firstChar, newLine);
        Assert.assertEquals(lastChar, newLine);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){

    }

    @Test
    public void testToStringHandlesEmptyField(){

    }
}
