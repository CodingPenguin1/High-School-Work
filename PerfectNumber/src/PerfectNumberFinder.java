/*
 * Title: Perfect Number Finder
 * Author: Ryan Slater
 * Date: 9/5/2017
 * Purpose: Find the first 5 perfect numbers (sum of factors excluding number equal the number, i.e. 1+2+3=6)
 */
public class PerfectNumberFinder {

	public static void main(String[] args) {
		
		int count = 0;
		int num = 6;
		while(count<=5){
			int sum = 1;
			for(int i=2; i<=(num/2); i++){
				if(num%i == 0){
					sum+= i;
				}
			}
			if(sum==num){
				System.out.println(num);
				count++;
			}
			if(count==5){
				break;
			}
			num+=2;
		}
		
	}
}