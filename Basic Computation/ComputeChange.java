import java.util.Scanner;
import java.math.BigDecimal;

/**
 * [ Assignment 1 - Compute Change ]
 * This program takes a user-input decimal number that represents an
 * amount of money in US dollars and cents and outputs the maximum amount
 * of dollars and change equal to the currency amount that was input.
 *
 * @author  Marcinina Alvaran
 * @version %I%, %G%
 */
public class ComputeChange
{
     public static void main(String[] args)
     {
          BigDecimal currency;
          
          introduction();
          currency = enterCurrency();
          calculateChange(currency);
     }
     
     /**
      *  Provides program information and instructions for the user.
      */
     private static void introduction()
     {
          System.out.println(
               "\n\n\n\n=======================\n\n\n" +
               "<< CHANGE CALCULATOR >>\n\n\n" +
               "This program converts a currency amount in US dollars " +
               "and cents to the maximum\nchange that provides that " +
               "amount. Change is represented by single dollars,\n" +
               "quarters, dimes, nickels, and pennies.\n\n" +
               "Only positive numbers and decimal points are accepted, " +
               "and currency should be\nformatted as follows (see " +
               "README for more formatting information):\n\nXX.xx\n\n" +
               "(XX represents dollars, and xx represents cents.)\n\n\n" +
               "-----------------------\n"
          );
     }
     
     /**
      * Asks user for and validates an amount of currency and returns
      * the input currency amount to two decimal places. Will continue to
      * ask for an input until a valid input is received.
      *
      * @return the BigDecimal amount of currency input by the user
      * @throws NumberFormatException if user inputs a string
      */
     private static BigDecimal enterCurrency()
     {
          Scanner scan = new Scanner(System.in);
          boolean validFormat, validSign;
          String currencyIn;
          BigDecimal currencyNum;
          
          // Validate currency input
          do
          {
               validFormat = false;
               validSign = false;
               currencyNum = new BigDecimal("00.00");
               System.out.print("Enter currency: ");
               currencyIn = scan.nextLine();
               System.out.println();

               // Validate input format
               try
               {
                    currencyNum = new BigDecimal(currencyIn);
                    validFormat = true;
               }
               catch (NumberFormatException exception)
               {
                    System.out.println(
                         "Please use the format XX.xx when " +
                         "entering currency and do not include $\n"
                    );
               }

               // Validate currency sign
               if (currencyNum.signum() == -1)
                    System.out.println("Please enter a positive number.");
               else
                    validSign = true;
          } while (validFormat == false || validSign == false);
          
          // Format currency
          currencyNum = currencyNum.setScale(2, BigDecimal.ROUND_FLOOR);
          return currencyNum;
     }
     
     /**
      * Calculates and displays the maximum amount of change needed to
      * represent the given amount of currency, starting from highest
      * value change (i.e. dollars) to lowest value change (i.e. pennies).
      */
     private static void calculateChange(BigDecimal currencyAmount)
     {
          BigDecimal cents, dollars;
          BigDecimal totalValue = new BigDecimal("0.00");
          BigDecimal[] coinAmount = new BigDecimal[4];
          BigDecimal[] value = {new BigDecimal("0.25"), // Quarter
                                new BigDecimal("0.10"), // Dime
                                new BigDecimal("0.05"), // Nickel
                                new BigDecimal("0.01")}; // Penny

          dollars = currencyAmount.setScale(0, BigDecimal.ROUND_FLOOR);
          cents = currencyAmount.subtract(dollars);

          // Computes change from highest value coin to lowest value coin
          for (int index = 0; index<4; index++)
          {
               coinAmount[index] = cents.divide(value[index], 0, 
                                            BigDecimal.ROUND_FLOOR);
               totalValue = coinAmount[index].multiply(value[index]);
               cents = cents.subtract(totalValue);
          }
          
          // Display amount of change
          System.out.println(
               "-----------------------\n\n" +
               "[ CHANGE COMPUTED ]\n\n" +
               "   Dollars: " + dollars       + "\n" +
               "  Quarters: " + coinAmount[0] + "\n" +
               "     Dimes: " + coinAmount[1] + "\n" +
               "   Nickels: " + coinAmount[2] + "\n" +
               "   Pennies: " + coinAmount[3] + "\n\n" +
               "=======================\n"
          );
     }
}