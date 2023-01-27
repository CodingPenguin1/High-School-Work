/*
 * Title: Bagel Counter
 * Author: Ryan Slater
 * Date: 9/27/2017
 */
public class Bagels {
	
	public int bagelCount(int[] orders){
		int count = 0;
		for(int i = 0; i < orders.length; i++){
			count += orders[i] + (int)(orders[i]/12);
		}
		
		
		return count;
		
	}
	
}