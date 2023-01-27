/**
 * SearchNSortTester.java - test program for the SearchNSort class
 */

/**
 * Mr. Schultz 11/10/2009 Purpose: test the methods of the SearchNSort class
 */

// import java.util.Random;

public class SearchNSortTester {

	public static void main(String[] args) {

		// Random gen = new Random();
		int indexValue = 0;
		SearchNSort mySS = new SearchNSort();
		int searchValue = 0;
		int searchValue2 = 0;
		boolean searchLinear = false;
		boolean sortBubble = false;
		boolean sortSelection = false;
		boolean sortInsert = false;
		boolean searchBinary = true;

		if (searchBinary && !sortBubble) {
			System.out.println("Activiting Bubble Sort for Binary Search...");
			sortBubble = true;
		}

		/***************
		 * Test Arrays *
		 ***************/
		int[] test1B = { 79, 68, 47, 12, 46, 30, 61, 87, 31, 9, 9, 2, 63, 19, 17, 15, 14, 88, 40, 91, 51, 75, 5, 74, 61,
				99, 71, 83, 64, 30 };
		int[] test1S = { 79, 68, 47, 12, 46, 30, 61, 87, 31, 9, 9, 2, 63, 19, 17, 15, 14, 88, 40, 91, 51, 75, 5, 74, 61,
				99, 71, 83, 64, 30 };
		int[] test1I = { 79, 68, 47, 12, 46, 30, 61, 87, 31, 9, 9, 2, 63, 19, 17, 15, 14, 88, 40, 91, 51, 75, 5, 74, 61,
				99, 71, 83, 64, 30 };
		int[] test2B = { 2, 8, 4, 6, 0, -2, 10, 2 };
		int[] test2S = { 2, 8, 4, 6, 0, -2, 10, 2 };
		int[] test2I = { 2, 8, 4, 6, 0, -2, 10, 2 };
		int[] test3B = { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] test3S = { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] test3I = { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] test4B = { 5 };
		int[] test4S = { 5 };
		int[] test4I = { 5 };
		// or
		// int arrayLength = 50000;
		// int[] myArray = new int[arrayLength];
		// for (int lcv = 0; lcv < myArray.length; lcv++)
		// myArray[lcv] = gen.nextInt(100);

		System.out.println("Original Array...");
		System.out.print("Test 1 - ");
		displayArray(test1B);
		System.out.print("Test 2 - ");
		displayArray(test2B);
		System.out.print("Test 3 - ");
		displayArray(test3B);
		System.out.print("Test 4 - ");
		displayArray(test4B);

		/*****************
		 * Sorting Tests *
		 *****************/

		// TEST 1
		System.out.println("Sort TEST 1");
		if (sortBubble) {
			mySS.bubbleSort(test1B);
			System.out.print("Bubble Test 1 - ");
			displayArray(test1B);
		}
		if (sortSelection) {
			mySS.selectionSort(test1S);
			System.out.print("Selection Test 1 - ");
			displayArray(test1S);
		}
		if (sortInsert) {
			mySS.insertionSort(test1I);
			System.out.print("Insertion Test 1 - ");
			displayArray(test1I);
		}

		// TEST2
		System.out.println("\n\nSort TEST 2");
		if (sortBubble) {
			mySS.bubbleSort(test2B);
			System.out.print("Bubble Test 2 - ");
			displayArray(test2B);
		}
		if (sortSelection) {
			mySS.selectionSort(test2S);
			System.out.print("Selection Test 2 - ");
			displayArray(test2S);
		}
		if (sortInsert) {
			mySS.insertionSort(test2I);
			System.out.print("Insertion Test 2 - ");
			displayArray(test2I);
		}

		// TEST3
		System.out.println("\n\nSort TEST 3");
		if (sortBubble) {
			mySS.bubbleSort(test3B);
			System.out.print("Bubble Test 3 - ");
			displayArray(test3B);
		}
		if (sortSelection) {
			mySS.selectionSort(test3S);
			System.out.print("Selection Test 3 - ");
			displayArray(test3S);
		}
		if (sortInsert) {
			mySS.insertionSort(test3I);
			System.out.print("Insertion Test 3 - ");
			displayArray(test3I);
		}

		// TEST4
		System.out.println("\n\nSort TEST 4");
		if (sortBubble) {
			mySS.bubbleSort(test4B);
			System.out.print("Bubble Test 4 - ");
			displayArray(test4B);
		}
		if (sortSelection) {
			mySS.selectionSort(test4S);
			System.out.print("Selection Test 4 - ");
			displayArray(test4S);
		}
		if (sortInsert) {
			mySS.insertionSort(test4I);
			System.out.print("Insertion Test 4 - ");
			displayArray(test4I);
		}

		/****************
		 * SEARCH TESTS *
		 ****************/

		// TEST1
		System.out.println("\n\nSearch TEST 1 - (47,14)");
		if (searchLinear) {
			searchValue = 47;
			indexValue = mySS.linearSearch(test1B, searchValue);
			System.out.println("Linear - The value " + searchValue + " was found at position " + indexValue + ".");
		}
		if (searchBinary) {
			searchValue = 47;
			indexValue = mySS.binarySearch(test1B, searchValue);
			System.out.println("Binary - The value " + searchValue + " was found at position " + indexValue + ".");
		}

		// TEST2
		System.out.println("\n\nSearch TEST 2 - (-2,0)");
		if (searchLinear) {
			searchValue = -2;
			indexValue = mySS.linearSearch(test2B, searchValue);
			System.out.println("Linear - The value " + searchValue + " was found at position " + indexValue + ".");
		}
		if (searchBinary) {
			searchValue = -2;
			indexValue = mySS.binarySearch(test2B, searchValue);
			System.out.println("Binary - The value " + searchValue + " was found at position " + indexValue + ".");
		}

		// TEST3
		System.out.println("\n\nSearch TEST 3 - (6,5)");
		if (searchLinear) {
			searchValue = 6;
			indexValue = mySS.linearSearch(test3B, searchValue);
			System.out.println("Linear - The value " + searchValue + " was found at position " + indexValue + ".");
		}
		if (searchBinary) {
			searchValue = 6;
			indexValue = mySS.binarySearch(test3B, searchValue);
			System.out.println("Binary - The value " + searchValue + " was found at position " + indexValue + ".");
		}

		// TEST4
		System.out.println("\n\nSearch TEST 4 - (16,-1)");
		if (searchLinear) {
			searchValue = 16;
			indexValue = mySS.linearSearch(test3B, searchValue);
			System.out.println("Linear - The value " + searchValue + " was found at position " + indexValue + ".");
		}
		if (searchBinary) {
			searchValue = 16;
			indexValue = mySS.binarySearch(test3B, searchValue);
			System.out.println("Binary - The value " + searchValue + " was found at position " + indexValue + ".");
		}

		// TEST5
		System.out.println("\n\nSearch TEST 5 - (5,0)");
		if (searchLinear) {
			searchValue = 5;
			indexValue = mySS.linearSearch(test4B, searchValue);
			System.out.println("Linear - The value " + searchValue + " was found at position " + indexValue + ".");
		}
		if (searchBinary) {
			searchValue = 5;
			indexValue = mySS.binarySearch(test4B, searchValue);
			System.out.println("Binary - The value " + searchValue + " was found at position " + indexValue + ".");
		}

		// TEST6
		System.out.println("\n\nSearch TEST 6 - (6,-1)");
		if (searchLinear) {
			searchValue = 6;
			indexValue = mySS.linearSearch(test4B, searchValue);
			System.out.println("Linear - The value " + searchValue + " was found at position " + indexValue + ".");
		}
		if (searchBinary) {
			searchValue = 6;
			indexValue = mySS.binarySearch(test4B, searchValue);
			System.out.println("Binary - The value " + searchValue + " was found at position " + indexValue + ".");
		}

	}

	public static void displayArray(int[] a) {
		// display the contents of any 1-D integer array
		for (int lcv = 0; lcv < a.length; lcv++) {
			System.out.print(a[lcv] + " ");
		}
		System.out.print("\n");
	}
}