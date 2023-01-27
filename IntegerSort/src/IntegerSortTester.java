/**
 * IntegerSortTester.java - Integer Sort Project
 */

/**
 * Mr. Schultz
 * 10/5/2011
 * Test the IntegerSort class.
 */

public class IntegerSortTester {

	public static void main(String[] args) {

		int[] intList1 = {2, 5, 8, -1, -10, 11};
		int[] intList2 = {-10, 9, -8, 7, -6, 5, 4, -3, 2, -1};
		int[] intList3 = {-10, 8, -6, 4, -2, 0, 2, 3, -1, -5};
		
		System.out.print("Test 1 ( ");
		for (int lcv=0; lcv < intList1.length; lcv++) System.out.print(intList1[lcv] + " ");
		System.out.println(")");
		IntegerSort myChecker1 = new IntegerSort();
		myChecker1.sortArray(intList1);
		myChecker1.printArrays();

		System.out.print("\nTest 2 ( ");
		for (int lcv=0; lcv < intList2.length; lcv++) System.out.print(intList2[lcv] + " ");
		System.out.println(")");
		IntegerSort myChecker2 = new IntegerSort();
		myChecker2.sortArray(intList2);
		myChecker2.printArrays();
		
		System.out.print("\nTest 3 ( ");
		for (int lcv=0; lcv < intList3.length; lcv++) System.out.print(intList3[lcv] + " ");
		System.out.println(")");
		IntegerSort myChecker3 = new IntegerSort();
		myChecker3.sortArray(intList3);
		myChecker3.printArrays();
	}

}