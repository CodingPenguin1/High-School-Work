/*
 * Title: Locker Problem
 * Author: Ryan Slater
 * Date: 9/28/2017
 */
public class Locker {
	
	public void modLockers(Boolean[] lockers){
		
		int n = 1;
		while(n < lockers.length){
			for(int i=n; i<lockers.length; i+=n){
				if(lockers[i] == true){
					lockers[i] = false;
				}else{
					lockers[i] = true;
				}
			}
			n++;
		}
		
		for(int i=0; i<lockers.length; i++){
			if(lockers[i] == true){
				System.out.println(i);
			}
		}
		
	}
}

/*OUTPUT:
1
4
9
16
25
36
49
64
81
 */