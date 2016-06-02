import java.util.Scanner;
import java.util.HashSet;

/**
 * This program checks whether an input of integers matches the definition
 * of a magic square.
 * 
 * @author  Marcinina Alvaran
 * @version %I%
 */
public class MagicSquare
{
	static Scanner scan = new Scanner(System.in);
	private static int[][] squareArray;
	private static int[] numberArray;
	
	public static void main(String[] args)
	{
		introduction();
		promptInput();
		isMagicSquare();
	}
	
	/**
	 * Provide user information and instructions along with a program
	 * header for the user interface.
	 */
	public static void introduction()
	{
		System.out.println(
				"\n\n================\n\n" +
		        "[ MAGIC SQUARE ]\n\n" +
				"Welcome to Magic Square! Give me a list of whole \n" +
		        "numbers, and I'll determine if they meet the criteria \n" +
				"for a Magic Square.\n\n" +
		        "Please separate the numbers with spaces and leave \n" +
				"out any punctuation marks. Here's an example:\n\n" +
		        "1 2 3 4 5 6 7 8 9\n\n" +
				"Enter as many numbers as you want! Only one list can " +
		        "be processed.\n\n" +
				"----------------\n");
	}
	
	/**
	 * Prompt user for a list of numbers and store the numbers in an array.
	 */
	public static void promptInput()
	{
		String input;
		String[] inputArray;
		
		System.out.println(
				"Please enter a list of numbers separated by spaces:");
		input = scan.nextLine();
		inputArray = input.split(" ");
		
		// Convert to int values and store results in an array
		numberArray = new int[inputArray.length];
		for (int index=0; index < inputArray.length; index++)
			numberArray[index] = Integer.parseInt(inputArray[index]);
	}
	
	/**
	 * Determine if user input numbers create a valid magic square and
	 * display result with number array.
	 */
	public static void isMagicSquare()
	{
		int maxColumn, sideLength,
		    index = 0;
		
		// Display square array
		sideLength = (int)Math.sqrt(numberArray.length);
		System.out.println("\n[ NUMBER ARRAY ]\n");
		if (Math.pow(sideLength, 2) == numberArray.length)
			maxColumn = sideLength;
		else
			maxColumn = sideLength + 1;
		for (int row=0; row < (sideLength + 1); row++)
		{
			for (int column=0; column < maxColumn; column ++)
			{
				if (index < numberArray.length)
				{
					System.out.print(numberArray[index] + " ");
				    index++;
				}
			}
			System.out.print("\n");
		}
		
		// Display result of magic square validation
		System.out.print("Is the number array a Magic Square? ");
		
		if(validateTotal() && validateNumbers() && validateSums())
			System.out.println("true");
		else
			System.out.println("false");
		
		System.out.print("\nPress Enter to exit the program...");
		scan.nextLine();
	}
	
	/**
	 * Check if the square root of the total values input is a whole number.
	 * 
	 * @return true if the square root of the total values input is a
	 *         whole number and false otherwise
	 */
	private static boolean validateTotal()
	{
		int squareRootInt,
		    totalValues = numberArray.length;
		boolean validity = false;
		
		// Determine if the total values is the square of a whole number.
		squareRootInt = (int)Math.sqrt(totalValues);
		if (Math.pow(squareRootInt, 2) == totalValues)
			validity = true;
			
		// For debugging: System.out.println("Checkpoint 1: " + validity);
		
		return validity;
	}
	
	/**
	 * Check if any input numbers are duplicates.
	 * 
	 * @return true if there are no duplicate numbers and false otherwise
	 */
	private static boolean validateNumbers()
	{
		HashSet<Integer> validNumbers = new HashSet<Integer>();
		boolean validity = false;
		int index = 0;
		Integer current;
		
		// Store valid magic square numbers in a set
		for (int number=1; number <= numberArray.length; number++)
			validNumbers.add(new Integer(number));
		
		// Remove initial number input matches from set
		do 
		{
			current = new Integer(numberArray[index]);
			index++;
		} while (validNumbers.remove(current)
				 && index < numberArray.length);
		
		// Empty set implies no duplicates.
		if (validNumbers.size() == 0)
			validity = true;
		
		// For debugging: System.out.println("Checkpoint 2: " + validity);
		
		return validity;
	}
	
	/**
	 * Check if row, column, and diagonal sums of resulting number square
	 * are all equal. Must have validated input value total first.
	 * 
	 * @return true if all sums are equal and false otherwise
	 */
	private static boolean validateSums()
	{
		boolean validity;
		int sideLength,
		    position = 0,
		    targetSum = 0,
			currentSum = 0;
		
		// Use first row as target sum to compare all other sums against
		// For safe int cast, input value must be validated first.
		sideLength = (int)Math.sqrt(numberArray.length);
		for (int index = 0; index < sideLength; index++)
			targetSum += numberArray[index];
		
		// Fill square array with input numbers
		squareArray = new int[sideLength][sideLength];
		for (int row=0; row < sideLength; row++)
			for (int column=0; column < sideLength; column++)
			{
				squareArray[row][column] = numberArray[position];
				position++;
			}
		
		// Compare target sum against remaining row sums
		position = 0;
		do
		{
			currentSum = 0;
			for (int column=0; column < sideLength; column++)
				currentSum += squareArray[position][column];
			position++;
			validity = (targetSum == currentSum);
		} while (validity == true && position < sideLength);
		
		// If all row sums were valid,
		// compare target sum against column sums.
		if (validity == true)
		{
			position = 0;
			do
			{
				currentSum = 0;
				for (int row=0; row < sideLength; row++)
					currentSum += squareArray[row][position];
				validity = (targetSum == currentSum);
				position++;
			} while (validity == true && position < sideLength);
		}
		
		// If all previous sums were valid,
		// compare target sum against diagonal sums.
		if (validity == true)
		{
			currentSum = 0;
			for (position=0; position < sideLength; position++)
				currentSum += squareArray[position][position];
			validity = (targetSum == currentSum);
			
			// If previous diagonal sum was valid,
			// compare target sum against other diagonal sum.
			currentSum = 0;
			for (position=1; position <= sideLength; position++)
				currentSum += squareArray[sideLength-position][position-1];
			validity = (targetSum == currentSum);
		}
		
		// For debugging: System.out.println("Checkpoint 3: " + validity);
		
		return validity;
	}
}
