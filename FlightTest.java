import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FlightTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FlightTest{
    /**
     * Default constructor for test class FlightTest
     */
    public FlightTest(){
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
    public void testGetFlightNumber(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY", "09/21/2018");
        assertEquals(myFlight.getFlightNumber(), "ab12345");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidFlightNumber(){
        Flight myFlight = new Flight("ab1*&345", "DGY", "CBY", "09/21/2018");
    }
    
    @Test
    public void testGetOrigAndDest(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY", "09/21/2018");
        assertEquals(myFlight.getOrigin(), "DGY");
        assertEquals(myFlight.getDestination(), "CBY");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidOrigin(){
        Flight myFlight = new Flight("ab12345", "DGYgf", "CBY", "09/21/2018");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidDestination(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBYfg", "09/21/2018");
    }
    
    @Test
    public void testGetDate(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY", "09/21/2018");
        assertEquals(myFlight.getDate(), "09/21/2018");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidMonth(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY", "13/21/2018");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidDay(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY", "10/33/2018");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidYear(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY", "10/12/88");
    }
    
    @Test
    public void testGetSeat(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY",   "09/21/2018");
        assertEquals(myFlight.getSeat(20, 4).getSeatNumber(),   "20D");
        assertEquals(myFlight.getSeat(20, 4).getPrice(),        250.78, 0.0001);
        assertEquals(myFlight.getSeat(20, 4).getRecline(),      10);
        assertEquals(myFlight.getSeat(20, 4).getMealType(),     MealType.SNACK);
    }
    
    @Test
    public void testGetPassangerCount(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY", "09/21/2018");
        myFlight.getSeat(20, 3).setConfirmation("John Doe", "ASDFGH");
        myFlight.getSeat(20, 4).setConfirmation("Jane Doe", "GHETYU");
        myFlight.getSeat(20, 5).setConfirmation("Sadey Badey", "LMNOPQ");
        assertEquals(myFlight.getPassengerCount(), 3);
        myFlight.getSeat(20, 3).removeConfirmation();
        assertEquals(myFlight.getPassengerCount(), 2);
    }
    
    @Test
    public void testGetConfirmedSeats(){
        Flight myFlight = new Flight("ab12345", "DGY", "CBY", "09/21/2018");
        myFlight.getSeat(20, 4).setConfirmation("John Doe", "ASDFGH");
        myFlight.getSeat(20, 3).removeConfirmation();
    }
}
