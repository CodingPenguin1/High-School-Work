/*
 * Title: InsertRemove
 * Author: Ryan Slater
 * Date: 10/8/2017
 */

public class InsertRemove {
	
	public boolean insert(int[] myInts, int logSz, int target, int value) {
		if (myInts.length > logSz) {
			if (target > 0 && target < logSz) {
				for (int i = logSz; i > target-1; i--) {
					myInts[i+1] = myInts[i];
				}
				myInts[target] = value;
				return true;
			}
		}
		return false;
	}

	public boolean remove(int[] myInts, int logSz, int target) {
		if (myInts.length > logSz) {
			if (target >= 0 && target < logSz) {
				for (int i = target; i < logSz; i++) {
					myInts[i] = myInts[i+1];
				}
				myInts[logSz] = 0;
				return true;
			}
		}
		return false;
	}
}