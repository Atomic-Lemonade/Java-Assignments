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
 * non-duplicate numbers that fall within the range 1-n^2.
 * 
 * @author  Marcinina Alvaran
 * @version 1.0
 */
public class ValidNumbersTest
{
    MagicSquare emptySquare, singletonSquare, duplicateSquare;

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
     * non-one array, and a duplicate value array.
     * 
     * @throws Exception if any instantiation causes an exception
     */
    @Before
    public void setUp() throws Exception {
        int[] emptyArray = new int[0],
              singleIntegerArray = {7},
              duplicateValueArray = {9,9,9,9,9,9,9,9,9};
        
        emptySquare = new MagicSquare(emptyArray);
        singletonSquare = new MagicSquare(singleIntegerArray);
        duplicateSquare = new MagicSquare(duplicateValueArray);
    }

    /**
     * Sets all MagicSquare objects to null.
     * 
     * @throws Exception if any assignment to null causes an exception
     */
    @After
    public void tearDown() throws Exception {
        emptySquare = null;
        singletonSquare = null;
        duplicateSquare = null;
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
     * magic square using an empty array, a single-integer non-one array, and
     * a duplicate value array.
     */
    @Test
    public void testIsMagicSquare()
    {
        String notification = "Invalid magic square assessment";
        
        // Test empty array
        assertFalse(message(notification, "emptySquare"),
                emptySquare.isMagicSquare());
        
        // Test single-integer, non-one array
        assertFalse(message(notification, "singletonArray"),
                singletonSquare.isMagicSquare());
        
        // Test duplicate value array
        assertFalse(message(notification, "duplicateSquare"),
                duplicateSquare.isMagicSquare());
    }

    /**
     * Tests the method that checks whether an array meets the value total
     * criteria of a magic square using an empty array, a single-integer
     * non-one array, and a duplicate value array.
     */
    @Test
    public void testValidateTotal()
    {
        String notification = "Invalid value total assessment";
        
        // Test empty array
        assertFalse(message(notification, "emptySquare"),
                emptySquare.validateTotal());
        
        // Test single-integer, non-one array
        assertTrue(message(notification, "singletonArray"),
                singletonSquare.validateTotal());
        
        // Test duplicate value array
        assertTrue(message(notification, "duplicateSquare"),
                duplicateSquare.validateTotal());
    }

    /**
     * Tests the method that checks whether an array meets the non-duplicate
     * value criteria of a magic square using an empty array, a single-integer
     * non-one array, and a duplicate value array.
     */
    @Test
    public void testValidateNumbers()
    {
        String notification = "Invalid value set assessment";
        
        // Test empty array
        assertFalse(message(notification, "emptySquare"),
                emptySquare.validateNumbers());
        
        // Test single-integer, non-one array
        assertFalse(message(notification, "singletonSquare"),
                singletonSquare.validateNumbers());
        
       // Test duplicate value array
        assertFalse(message(notification, "duplicateSquare"),
                duplicateSquare.validateNumbers());
    }

    /**
     * Tests the method that checks whether an array meets the
     * row/column/diagonal sums criteria of a magic square using an empty
     * array, a single-integer non-one array, and a duplicate value array.
     */
    @Test
    public void testValidateSums()
    {
        String notification = "Invalid sum assessment";
        
        // Test empty array
        assertTrue(message(notification, "emptySquare"),
                emptySquare.validateSums());
        
        // Test single-integer, non-one array
        assertTrue(message(notification, "singletonArray"),
                singletonSquare.validateSums());
        
        // Test duplicate value array
        assertTrue(message(notification, "duplicateSquare"),
                duplicateSquare.validateSums());
    }

}
