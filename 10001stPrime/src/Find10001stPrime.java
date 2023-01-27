/*
 * Title: 10001st Prime
 * Author: Ryan Slater
 * Date: 8/24/2017
 * Purpose: Determine the 10,001st prime number
 */
public class Find10001stPrime {
	public static void main(String[] args) {
		
		int primeCount = 0;
		int x = 1;
		
		while (primeCount<10001){
			boolean isPrime = true;
			if (x%2==0){
				isPrime = false;
			}
			else if (x%2!=0){
				for(int i=3; i<Math.sqrt(x)+1; i+=2){
					if (x%i==0){
						isPrime = false;
					}
				}
			}
			
			if (isPrime == true){
				primeCount++;
			}
			x++;
		}
		System.out.println(x-1);
	
	}
}