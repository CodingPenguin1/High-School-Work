/*
 * Title: Multiples of 3 and 5
 * Author: Ryan Slater
 * Date: 8/24/2017
 * Purpose: Find all multiples of 3 and 5 less than 1000
 */
public class MultiplesOf3And5 {
	public static void main(String[] args) {
		
		int sum = 0;
		for(int i=0; i<1000; i++){
			if ((i%3 == 0) || (i%5 == 0)){
				sum += i;
			}
		}
		System.out.println(sum);
	}
}