/**
 * Tester.java - Mean Median Mode Project
 */

/**
 * Programmer: Mr. Schultz
 * Date: 10/11/2010
 * Purpose: Test the MeanMedianMode class
 */

public class MeanMedianModeTester {

	public static void main(String[] args) {
	
		int[] myArray1 = {1, 1, 1, 1, 1, 1, 1};
		int[] myArray2 = {9, 2, 4, 5, 8, 10, 1, 6, 5, 3, 2, 4, 1, 8, 7};
		int[] myArray3 = {5, 2, 3, 9, 7, 1, 6, 2, 9, 2, 10, 9};
		//MeanMedianMode myMMM0 = new MeanMedianMode();
		MeanMedianMode myMMM1 = new MeanMedianMode(myArray1);
		MeanMedianMode myMMM2 = new MeanMedianMode(myArray2);
		MeanMedianMode myMMM3 = new MeanMedianMode(myArray3);
		
		//myMMM1.setArray(myArray1);
		System.out.print("Original Array: ");
		for (int x: myArray1)
			System.out.print(x + " ");
		System.out.println("");
		
		/*
		System.out.println("\nMean: " + myMMM0.findMean());
		System.out.println("Median: " + myMMM0.findMedian());
		System.out.println("Mode(s): " + myMMM0.findMode());
		System.out.println("");
		*/		

		System.out.println("Mean (1.0): " + myMMM1.findMean());
		System.out.println("Median (1.0): " + myMMM1.findMedian());
		System.out.println("Mode(s) (1): " + myMMM1.findModes());
		System.out.println("\n");
		
		
		//myMMM2.setArray(myArray2);
		System.out.println("Original Array: ");
		for (int x: myArray2)
			System.out.print(x + " ");
		System.out.println("\nMean (5.0): " + myMMM2.findMean());
		System.out.println("Median (5.0): " + myMMM2.findMedian());
		System.out.println("Mode(s) (2 4 5 8 1): " + myMMM2.findModes());
		System.out.println("\n");
		
		
		//myMMM3.setArray(myArray3);
		System.out.println("Original Array: ");
		for (int x: myArray3)
			System.out.print(x + " ");
		System.out.println("\nMean (5.41667): " + myMMM3.findMean());
		System.out.println("Median (5.5): " + myMMM3.findMedian());
		System.out.println("Mode(s) (2 9): " + myMMM3.findModes());
		System.out.println("\n");		

	}

}
