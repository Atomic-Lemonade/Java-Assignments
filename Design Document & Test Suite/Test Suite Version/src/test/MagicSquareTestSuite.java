package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TotalValuesTest.class, UnequalSumsTest.class,
                ValidMagicSquareTest.class, ValidNumbersTest.class })

/**
 * A test suite that contains test cases for the Magic Square class.
 * <p>
 * Test cases include:
 * <ul>
 * <li> Total value validation failure
 * <li> Number value validation failure
 * <li> Row/Column/Diagonal sum validation failure
 * <li> Successful magic square validation
 * </ul>
 * 
 * @author  Marcinina Alvaran
 * @version 1.0
 */
public class MagicSquareTestSuite {

}
