import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

/**
 * [ Assignment 6 - PSP0 Statistics Calculator ]
 * This program receives a set or more of real numbers through the
 * keyboard from the user and calculates each set's mean and standard
 * deviation. The results are then displayed in a formatted output to the
 * monitor. Data sets are assumed to have the same size (i.e. number of
 * data points).
 * 
 * The abbreviation stdev represents standard deviation.
 * 
 * @author  Marcinina Alvaran
 * @version %I%,%G%
 */
public class StatisticsCalculator
{
	
	public static void main(String[] args)
	{
	    int totalDataSets, dataSetSize;
	    double[] meanArray, stdevArray;
	    double[][] dataSetArray;
	    String[] dataSetNames;
	    
	    introduction();
	    totalDataSets = askDataSetTotal();
		dataSetSize = askDataSetSize();
		dataSetArray = new double[totalDataSets][dataSetSize];
		dataSetNames = new String[totalDataSets];
		fillDataSet(dataSetSize, dataSetArray, dataSetNames);
		meanArray = calculateMean(dataSetArray, dataSetSize, totalDataSets);
		stdevArray = calculateStdev(dataSetArray, dataSetSize,
		                            totalDataSets, meanArray);
		displayStatistics(totalDataSets, dataSetNames, meanArray, stdevArray);
		exitProgram();
	}
	
	/**
	 * Provides information and instructions to the user
	 */
	public static void introduction()
	{
		System.out.println(
		    "\n\n\n============================\n\n" +
		    "<< STATISTICS CALCULATOR >>\n\n" +
		    "This program calculates both the mean and standard \n" +
		    "deviation of your data. Provide the number and size of \n" +
		    "the data sets you want statistics for, then enter each \n" +
		    "data point from the sets one at a time. You also must \n" +
		    "name your data sets.\n\n" +
		    "============================\n"
		);
	}
	
	/**
	 * Receives and validates number of data sets from the user. Returns
	 * the number of data sets to calculate statistics for.
	 * 
	 * @returns the total number of data sets
	 * @throws InputMismatchException if a string is input
	 */
	public static int askDataSetTotal()
	{
	    boolean validInput, notNegative;
	    int dataSetTotal = 0;
	    Scanner scan = new Scanner(System.in);
	    
	    do // Validate number of data sets
	    {
	        validInput = false;
	        notNegative = false;
	        System.out.print("How many data sets? ");
	        
	        try // Validate number input
	        {
	            dataSetTotal = scan.nextInt();
	            validInput = true;
	        }
	        catch (InputMismatchException e)
	        {
	            scan.next();
	            System.out.println("\nPlease enter a valid number.\n");
	        }
	        
	        // Validate if number is positive
	        if (validInput == true)
	        {
	            if (dataSetTotal > 0)
	                notNegative = true;
	            else
	                System.out.println(
	                    "\nPlease enter a positive number.\n"
	                );
	        }
	    } while(validInput == false || notNegative == false);
	    
	    return dataSetTotal;
	}
	
	/**
	 * Receives and validates the size of a single data set. Returns the
	 * size of the data set. Assumes all data sets have the same size.
	 * 
	 * @returns the number of data points in a single data set
	 * @throws InputMismatchException if a string is input
	 */
	public static int askDataSetSize()
	{
	    boolean validInput, notNegative;
	    int dataSize = 0;
	    Scanner scan = new Scanner(System.in);
	    
	    do // Validate data set size
	    {
	        validInput = false;
	        notNegative = false;
	        System.out.print(
	                "How many data points are in a single data set? "
	            );
	        
	        try // Validate number input
	        {
	            dataSize = scan.nextInt();
	            validInput = true;
	        }
	        catch (InputMismatchException e)
	        {
	            scan.next();
	            System.out.println("\nPlease enter a valid number.\n");
	        }
	        
	        // Validate if number is positive
	        if (validInput == true)
	        {
	            if (dataSize > 0)
	                notNegative = true;
	            else
	                System.out.println(
	                    "\nPlease enter a positive number.\n"
	                );
	        }
	    } while (validInput == false || notNegative == false);
	    
	    return dataSize;
	}
	
	/**
	 * Receives , validates, and stores data points for all data sets.
     * 
	 * @param dataSize  the number of data points in a single data set
	 * @param dataArray the array with data sets
	 * @param dataNames the array with data set names
	 * @throws InputMismatchException if a string is input
	 */
	public static void fillDataSet(int dataSize, double[][] dataArray,
	                               String[] dataNames)
	{
	    boolean validInput;
	    int nameIndex = 0;
	    Scanner scan = new Scanner(System.in);
	    
	    // Fill all data sets, one set at a time
	    for (double[] dataSet : dataArray)
	    {
	        // Label data set
	        System.out.print(
	            "\nWhat is the name of data set " + (nameIndex+1) + "? "
	        );
	        dataNames[nameIndex] = scan.nextLine();
	        
	        // Fill single data set, one data point at a time
	        for (int index=0; index<dataSize; index++)
	        {
	            do // Validate data point
	            {
	                validInput = false;
	                System.out.print(
	                    "\nPlease enter data point " + (index + 1) +
	                    " for " + dataNames[nameIndex] + ": "
	                );
	                
	                try // Validate input
	                {
	                    dataSet[index] = scan.nextDouble();
	                    validInput = true;
	                }
	                catch (InputMismatchException e)
	                {
	                    scan.next();
	                    System.out.println(
	                        "\nPlease enter a valid number.\n"
	                    );
	                }
	            } while (validInput == false);
	            scan.nextLine();
	        }
	        
	        // Prepare for next data set if any
            nameIndex++;
	    }
	}
	
	/**
	 * Calculates the mean for each data set and returns an array with the
	 * means.
	 * 
	 * @param dataArray        the array of data sets
	 * @param dataSetSize      the number of data points in a single data set
	 * @param numberOfDataSets the number of data sets
	 * @return the array with each data set's mean
	 */
	public static double[] calculateMean(double[][] dataArray, int dataSize,
	                                     int numberOfDataSets)
	{
	    double sum = 0;
	    int index = 0;
	    double[] dataMean = new double[numberOfDataSets];
	    
	    // Calculate the mean for each set
	    for (double[] dataSet : dataArray)
	    {
	        // Calculate the mean for an individual set
	        for (double dataPoint : dataSet)
	        {
	            sum += dataPoint;
	        }
	        dataMean[index] = sum/dataSize;
	        sum = 0;
	        index++;
	    }
	    
	    return dataMean;
	}
	
	/**
	 * Calculates the standard deviation for each data set and returns an
	 * array with the standard deviations.
	 * 
	 * @param dataArray        the array of data sets
	 * @param dataSize         the number of data points in a single data set
	 * @param numberOfDataSets the number of data sets
	 * @param dataMean         the array with the means of the data sets
	 * @return the array with each data set's standard deviation
	 */
	public static double[] calculateStdev(double[][] dataArray, int dataSize,
	                                      int numberOfDataSets,
	                                      double[] dataMean)
	{
	    int index = 0, sum = 0;
	    double[] dataStdev = new double[numberOfDataSets];
	    
	    // Calculate standard deviation for each set
	    for (double[] dataSet : dataArray)
	    {
	        // Calculate standard deviation for an individual set
	        for (double dataPoint : dataSet)
	        {
	            sum += Math.pow(dataPoint-dataMean[index], 2);
	        }
	        
	        // Consider single data point set inputs
	        if (dataSize>1)
	            dataStdev[index] = Math.sqrt(sum/(dataSize-1));
	        else
	            dataStdev[index] = 0;
	        sum = 0;
	        index++;
	    }
	    
	    return dataStdev;
	}
	
	/**
	 * Displays a formatted output with all the data sets' statistics
	 * 
	 * @param dataSize  the number of data points in a single data set
	 * @param dataNames the array with the data sets' names
	 * @param dataMean  the array with the data sets' means
	 * @param dataStdev the array with the data sets' standard deviation
	 */
	public static void displayStatistics(int numberOfDataSets,
	                                     String[] dataNames,
	                                     double[] dataMean, 
	                                     double[] dataStdev)
	{
	    DecimalFormat formatter = new DecimalFormat("#.00");
	    
	    for (int index=0; index<numberOfDataSets; index++)
	        System.out.println(
	            "\n============================\n\n" +
	            dataNames[index] + "\n\n" +
	            "Mean: " + formatter.format(dataMean[index]) + "\n\n" +
	            "Standard Deviation: " +
	            formatter.format(dataStdev[index]) + "\n\n" +
	            "============================\n"
	        );
	}
	
	/**
	 * Prompts user to exit the program
	 */
	public static void exitProgram()
	{
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.print(
	        "Thank you for using the Statistics Calculator!\n\n" +
	        "Press enter or return to exit the program..."
	    );
	    scan.nextLine();
	}
}
