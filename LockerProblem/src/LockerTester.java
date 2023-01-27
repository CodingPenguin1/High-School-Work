/*
 * Title: Locker Problem
 * Author: Ryan Slater
 * Date: 9/28/2017
 */
public class LockerTester {

	public static void main(String[] args) {
		
		Locker l = new Locker();
		Boolean[] lockerList = new Boolean[100];
		for(int i=0; i<lockerList.length; i++){
			lockerList[i] = false;
		}
		
		l.modLockers(lockerList);
		
	}
}