/*
 * Title: Integer Sort
 * Author: Ryan Slater
 * Date: 10/4/2017
 */

import java.util.Arrays;

public class IntegerSort {
	
	private int[] evenList;
	private int[] oddList;
	private int[] negativeList;
	
	public void sortArray(int[] myInts){
		
		//Even list
		int evenLength = 0;
		for(int i=0; i<myInts.length; i++){
			if(myInts[i] % 2 == 0){
				evenLength += 1;
			}
		}
		evenList = new int[evenLength];
		int evenCounter = 0;
		for(int i=0; i<myInts.length; i++){
			if(myInts[i] % 2 == 0){
				evenList[evenCounter] = myInts[i];
				evenCounter += 1;
			}
		}
		
		//Odd list
		int oddCounter = 0;
		oddList = new int[myInts.length-evenList.length];
		for(int i=0; i<myInts.length; i++){
			if(myInts[i] % 2 != 0){
				oddList[oddCounter] = myInts[i];
				oddCounter += 1;
			}
		}
		
		//Negative list
		int negLength = 0;
		for(int i=0; i<myInts.length; i++){
			if(myInts[i] < 0){
				negLength += 1;
			}
		}
		negativeList = new int[negLength];
		int negCounter = 0;
		for(int i=0; i<myInts.length; i++){
			if(myInts[i] < 0){
				negativeList[negCounter] = myInts[i];
				negCounter += 1;
			}
		}
	}
	
	public void printArrays(){
		
		
		System.out.println("Even List     Odd List     Negative List");
		int stop = 0;
		if((evenList.length >= oddList.length) && (evenList.length >= negativeList.length)){
			stop = evenList.length;
		}
		else if((oddList.length >= evenList.length) && (oddList.length >= negativeList.length)){
			stop = oddList.length;
		}
		else{
			stop = negativeList.length;
		}
		for(int i=0; i<stop; i++){
			//EVEN
			if(i<evenList.length){
				int evenLength = (int)(Math.log10(Math.abs(evenList[i])) + 1);
				if(evenList[i] < 0){
					evenLength += 1;
				}
				int evenSpace = 14 - evenLength;
				if(evenList[i] == 0){
					evenSpace = 1;
				}
				System.out.print(evenList[i]);
				for(int l=0; l<evenSpace; l++){
					System.out.print(" ");
				}
			}
			else{
				System.out.print("              ");
			}
			
			
			//ODD
			
			
			if(i<oddList.length){
				int oddLength = (int)(Math.log10(Math.abs(oddList[i])) + 1);
				if(oddList[i] < 0){
					oddLength += 1;
				}
				int oddSpace = 13 - oddLength;
				System.out.print(oddList[i]);
				for(int l=0; l<oddSpace; l++){
					System.out.print(" ");
				}
			}
			else{
				System.out.print("             ");
			}
			
			//NEGATIVE
			if(i<negativeList.length){
				System.out.print(negativeList[i]);
			}
			System.out.println("");
		}
		
		
	}
	
}