

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SeatTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SeatTest{
    /**
     * Default constructor for test class SeatTest
     */
    public SeatTest(){
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
    public void testGetSeatNumberAndPrice(){
        Seat mySeat = new Seat("1A", 200.50, 10, MealType.GOURMET);
        assertEquals(mySeat.getSeatNumber(), "1A");
        assertEquals(mySeat.getPrice(), 200.50, 0.00001);
        mySeat.setPrice(600.75);
        assertEquals(mySeat.getPrice(), 600.75, 0.00001);
    }
    
    @Test
    public void testReclineAndMealType(){
        Seat mySeat = new Seat("1A", 200.50, 10, MealType.GOURMET);
        assertEquals(mySeat.getRecline(), 10);
        assertEquals(mySeat.getMealType(), MealType.GOURMET);
        mySeat.setRecline(15);
        assertEquals(mySeat.getRecline(), 15);
        mySeat.setMealType(MealType.FULL);
        assertEquals(mySeat.getMealType(), MealType.FULL);
    }
}
