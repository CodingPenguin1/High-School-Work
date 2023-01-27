/*
 * Title: Pythagorean Triplets
 * Author: Ryan Slater
 * Date: 8/24/2017
 * Purpose: A Pythagorean Triplet is a set of three natural
 * numbers, a < b < c, for which a^2 + b^2 = c^2. There exists
 * exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class PythagoreanTriplets {
	public static void main(String[] args) {
		
		for(int a=0; a<1000; a++){
			for(int b=0; b<1000; b++){
				for(int c=0; c<1000; c++){
					
					if ((a<b) && (b<c) && (a+b+c==1000) && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){
						System.out.print("a=" + a + " b=" + b + " c=" + c);
						break;
					}
				}
			}
		}
	}
}