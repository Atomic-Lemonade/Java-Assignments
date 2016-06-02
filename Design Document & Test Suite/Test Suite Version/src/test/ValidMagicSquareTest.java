package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.MagicSquare;

/**
 * Tests the MagicSquare class against inputs that pass all validation
 * requirements.
 * 
 * @author  Marcinina Alvaran
 * @version 1.0
 */
public class ValidMagicSquareTest
{
    MagicSquare singletonSquare, magicSquare;

    /**
     * Empty fixture method.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
    }

    /**
     * Empty deallocation method.
     */
    @AfterClass
    public static void tearDownAfterClass() {
    }

    /**
     * Creates a magic square object using an empty array, a single-integer
     * non-one array, and an array with unequal row/column/diagonal sums.
     * 
     * @throws Exception if any instantiation causes an exception
     */
    @Before
    public void setUp() throws Exception {
        int[] singletonArray = {1},
              magicSquareArray = {8,3,4,1,5,9,6,7,2};
        
        singletonSquare = new MagicSquare(singletonArray);
        magicSquare = new MagicSquare(magicSquareArray);
    }

    /**
     * Sets all MagicSquare objects to null.
     * 
     * @throws Exception if any assignment to null causes an exception
     */
    @After
    public void tearDown() throws Exception {
        singletonSquare = null;
        magicSquare = null;
    }
    
    /**
     * Returns a formatted message string that allows a notification to
     * specify an object.
     * 
     * @param notification the String containing the notification message
     * @param object       the object about which the notification applies
     * @return             the formatted notification message
     */
    public String message(String notification, String object)
    {
        return notification + " for " + object + ".";
    }

    /**
     * Tests the method that checks whether an array meets the criteria of a
     * magic square using a singleton array with one and an array of numbers
     * that meets the criteria for a magic square.
     */
    @Test
    public void testIsMagicSquare()
    {
        String notification = "Invalid magic square assessment";
        
        // Test a singleton array of one
        assertTrue(message(notification, "singletonSquare"),
                singletonSquare.isMagicSquare());
        
        // Test magic square array
        assertTrue(message(notification, "magicSquare"),
                magicSquare.isMagicSquare());
    }

    /**
     * Tests the method that checks whether an array meets the value total
     * criteria of a magic square using a singleton array with one and an
     * array of numbers that meets the criteria for a magic square.
     */
    @Test
    public void testValidateTotal()
    {
        String notification = "Invalid value total assessment";
        
        // Test a singleton array of one
        assertTrue(message(notification, "singletonSquare"),
                singletonSquare.validateTotal());
        
        // Test magic square array
        assertTrue(message(notification, "magicSquare"),
                magicSquare.validateTotal());
    }

    /**
     * Tests the method that checks whether an array meets the non-duplicate
     * value criteria of a magic square using a singleton array with one and
     * an array of numbers that meets the criteria for a magic square.
     */
    @Test
    public void testValidateNumbers()
    {
        String notification = "Invalid value set assessment";
        
        // Test a singleton array of one
        assertTrue(message(notification, "singletonSquare"),
                singletonSquare.validateNumbers());
        
        // Test magic square array
        assertTrue(message(notification, "magicSquare"),
                magicSquare.validateNumbers());
    }

    /**
     * Tests the method that checks whether an array meets the
     * row/column/diagonal sums criteria of a magic square using
     * a singleton array with one and an array of numbers that meets
     * the criteria for a magic square.
     */
    @Test
    public void testValidateSums()
    {
        String notification = "Invalid sum assessment";
        
        // Test a singleton array of one
        assertTrue(message(notification, "singletonSquare"),
                singletonSquare.validateSums());
        
        // Test magic square array
        assertTrue(message(notification, "magicSquare"),
                magicSquare.validateSums());
    }

}
