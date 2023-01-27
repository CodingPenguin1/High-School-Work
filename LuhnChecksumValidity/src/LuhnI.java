/*
 * Title: Luhn Checksum Validity
 * Author: Ryan Slater
 * Date: 9/272017
 */
public class LuhnI {
	
	public String isValid(int[] number){
		String validity = "NO";
		int sum = 0;
		int count = 1;
		
		for(int i=number.length-1; i>=0; i--){
			if(count%2 == 0){
				int factor = number[i]*2;
				if(factor >= 10){
					factor -= 9;
				}
				sum += factor;
			}else{
				sum += number[i];
			}
			count += 1;
		}
		if(sum%10 == 0){
			validity = "YES";
		}
		
		return validity;
	}
	
}
