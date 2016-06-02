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
 * row/column/diagonal sum equality.
 * 
 * @author  Marcinina Alvaran
 * @version 1.0
 */
public class UnequalSumsTest
{
    MagicSquare unequalRowsSquare, unequalColumnsSquare, unequalDiagonalsSquare;

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
     * Creates a magic square object using an arrays with unequal
     * row/column/diagonal sums.
     * 
     * @throws Exception if any instantiation causes an exception
     */
    @Before
    public void setUp() throws Exception {
        int[] unequalRowsArray = {1,2,3,4},
              unequalColumnsArray = {4,3,8,1,5,9,7,6,2},
              unequalDiagonalsArray = {8,3,4,6,7,2,1,5,9};
        
        unequalRowsSquare = new MagicSquare(unequalRowsArray);
        unequalColumnsSquare = new MagicSquare(unequalColumnsArray);
        unequalDiagonalsSquare = new MagicSquare(unequalDiagonalsArray);
    }

    /**
     * Sets all MagicSquare objects to null.
     * 
     * @throws Exception if any assignment to null causes an exception
     */
    @After
    public void tearDown() throws Exception {
        unequalRowsSquare = null;
        unequalColumnsSquare = null;
        unequalDiagonalsSquare = null;
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
     * magic square using arrays with unequal row/column/diagonal sums.
     */
    @Test
    public void testIsMagicSquare()
    {
        String notification = "Invalid magic square assessment";
        
        // Test unequal row sums
        assertFalse(message(notification, "unequalRowsSquare"),
                unequalRowsSquare.isMagicSquare());
        
        // Test unequal column sums
        assertFalse(message(notification, "unequalColumnsSquare"),
                unequalColumnsSquare.isMagicSquare());
        
        // Test unequal diagonal sums
        assertFalse(message(notification, "unequalDiagonalsSquare"),
                unequalDiagonalsSquare.isMagicSquare());
    }

    /**
     * Tests the method that checks whether an array meets the value total
     * criteria of a magic square using arrays with unequal row/column/diagonal
     * sums.
     */
    @Test
    public void testValidateTotal()
    {
        String notification = "Invalid value total assessment";
        
        // Test unequal row sums
        assertTrue(message(notification, "unequalRowsSquare"),
                unequalRowsSquare.validateTotal());
        
        // Test unequal column sums
        assertTrue(message(notification, "unequalColumnsSquare"),
                unequalColumnsSquare.validateTotal());
        
        // Test unequal diagonal sums
        assertTrue(message(notification, "unequalDiagonalsSquare"),
                unequalDiagonalsSquare.validateTotal());
    }

    /**
     * Tests the method that checks whether an array meets the non-duplicate
     * value criteria of a magic square using arrays with unequal
     * row/column/diagonal sums.
     */
    @Test
    public void testValidateNumbers()
    {
        String notification = "Invalid value set assessment";
        
        // Test unequal row sums
        assertTrue(message(notification, "unequalRowsSquare"),
                unequalRowsSquare.validateNumbers());
        
        // Test unequal column sums
        assertTrue(message(notification, "unequalColumnsSquare"),
                unequalColumnsSquare.validateNumbers());
        
        // Test unequal diagonal sums
        assertTrue(message(notification, "unequalDiagonalsSquare"),
                unequalDiagonalsSquare.validateNumbers());
    }

    /**
     * Tests the method that checks whether an array meets the
     * row/column/diagonal sums criteria of a magic square using
     * arrays with unequal row/column/diagonal sums.
     */
    @Test
    public void testValidateSums()
    {
        String notification = "Invalid sum assessment";
        
        // Test unequal row sums
        assertFalse(message(notification, "unequalRowsSquare"),
                unequalRowsSquare.validateSums());
        
        // Test unequal column sums
        assertFalse(message(notification, "unequalColumnsSquare"),
                unequalColumnsSquare.validateSums());
        
        // Test unequal diagonal sums
        assertFalse(message(notification, "unequalDiagonalsSquare"),
                unequalDiagonalsSquare.validateSums());
    }

}
