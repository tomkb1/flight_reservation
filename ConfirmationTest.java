

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ConfirmationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ConfirmationTest{
    /**
     * Default constructor for test class ConfirmationTest
     */
    public ConfirmationTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }
    
    @Test
    public void testGetConfirmationNameAndNumber(){
        Confirmation myConfirmation = new Confirmation("Vincent Gough", "Starry");
        assertEquals(myConfirmation.getName(), "Vincent Gough");
        assertEquals(myConfirmation.getConfirmationNumber(), "Starry");
    }
}
