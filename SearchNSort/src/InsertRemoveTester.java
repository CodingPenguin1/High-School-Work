/*
 * Title: InsertRemove
 * Author: Ryan Slater
 * Date: 10/8/2017
 */

public class InsertRemoveTester {

	public static void main(String args[]) {
		
		int logSz = 5;
		
		InsertRemove ir = new InsertRemove();
		int[] array = { 1, 2, 4, 5, 6, 0, 0, 0 };
		System.out.println("Original {1, 2, 4, 5, 6, 0, 0, 0}");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println("Insert 3 at 2 {1, 2, 3, 4, 5, 6, 0, 0}");
		if(ir.insert(array, logSz, 2, 3)) {
			System.out.println("True");
			logSz++;
		}else {
			System.out.println("False");
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		
		
		if(ir.insert(array, logSz, 10, 3)) {
			System.out.println("True");
			logSz++;
		}else {
			System.out.println("False");
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		
		
		if(ir.insert(array, logSz, 7, 8)) {
			System.out.println("True");
			logSz++;
		}else {
			System.out.println("False");
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println("Remove 1 {1, 3, 4, 5, 6, 0, 0, 0}");
		if(ir.remove(array, logSz, 1)) {
			System.out.println("True");
			logSz--;
		}else {
			System.out.println("False");
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		
		
		if(ir.remove(array, 5, 0)) {
			System.out.println("True");
			logSz--;
		}else {
			System.out.println("False");
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
	}
}