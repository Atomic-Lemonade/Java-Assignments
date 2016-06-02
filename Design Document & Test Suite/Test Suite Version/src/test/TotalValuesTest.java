package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.MagicSquare;

/**
 * Tests the MagicSquare class against inputs that fail validation for
 * total values input being the result of squaring an integer.
 * 
 * @author  Marcinina Alvaran
 * @version 1.0
 */
public class TotalValuesTest
{    
    MagicSquare emptySquare, notSquare;

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
     * Creates a magic square object using an empty array and an array whose
     * total values is not the result of a squared integer.
     * 
     * @throws Exception if any instantiation causes an exception
     */
    @Before
    public void setUp() throws Exception {
        int[] emptyArray = new int[0],
              nonSquaredTotalArray = {1,2,3,4,5,6,7,8};
        
        emptySquare = new MagicSquare(emptyArray);
        notSquare = new MagicSquare(nonSquaredTotalArray);
    }

    /**
     * Sets all MagicSquare objects to null.
     * 
     * @throws Exception if any assignment to null causes an exception
     */
    @After
    public void tearDown() throws Exception {
        emptySquare = null;
        notSquare = null;
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
     * magic square using an empty array and an array whose total values is
     * not the result of a squared integer.
     */
    @Test
    public void testIsMagicSquare()
    {
        String notification = "Invalid magic square assessment";
        
        // Test empty array
        assertFalse(message(notification, "emptySquare"),
                emptySquare.isMagicSquare());
        
        // Test array whose total values is not the result of a squared integer
        assertFalse(message(notification, "notSquare"),
                notSquare.isMagicSquare());
    }

    /**
     * Tests the method that checks whether an array meets the value total
     * criteria of a magic square using an empty array and an array whose total
     * values is not the result of a squared integer.
     */
    @Test
    public void testValidateTotal()
    {
        String notification = "Invalid value total assessment";
        
        // Test empty array
        assertFalse(message(notification, "emptySquare"),
                emptySquare.validateTotal());
        
        // Test array whose total values is not the result of a squared integer
        assertFalse(message(notification, "notSquare"),
                notSquare.validateTotal());
    }

    /**
     * Tests the method that checks whether an array meets the non-duplicate
     * value criteria of a magic square using an empty array and an array whose
     * total values is not the result of a squared integer.
     */
    @Test
    public void testValidateNumbers()
    {
        String notification = "Invalid value set assessment";
        
        // Test empty array
        assertFalse(message(notification, "emptySquare"),
                emptySquare.validateNumbers());
        
        // Test array whose total values is not the result of a squared integer
        assertTrue(message(notification, "notSquare"),
                notSquare.validateNumbers());
    }

    /**
     * Tests the method that checks whether an array meets the
     * row/column/diagonal sums criteria of a magic square using an empty
     * array and an array whose total value is not the result of a squared
     * integer.
     */
    @Test
    public void testValidateSums()
    {
        String notification = "Invalid sums assessment";
        
        // Test empty array
        assertTrue(message(notification, "emptySquare"),
                emptySquare.validateSums());
        
        // Test array whose total values is not the result of a squared integer
        assertFalse(message(notification, "notSquare"),
                notSquare.validateSums());
    }

}
