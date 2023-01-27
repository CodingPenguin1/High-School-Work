/*
 * Title: Search N Sort
 * Author: Ryan Slater
 * Date: 11/6/2017
 */
public class SearchNSort {

	int[] array;

	public void selectionSort(int[] myInts) {
		array = myInts;
		for (int sortedLength = 0; sortedLength < array.length; sortedLength++) {
			int minValIndex = sortedLength;
			for (int i = sortedLength; i < array.length; i++) {
				if (array[i] < array[minValIndex]) {
					minValIndex = i;
				}
			}
			swap(sortedLength, minValIndex);
		}
	}

	public void insertionSort(int[] myInts) {
		array = myInts;
		for (int i = 1; i < myInts.length; i++) {

			int tmp = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > tmp) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = tmp;
		}
	}

	public int binarySearch(int[] myInts, int targetValue) {
		array = myInts;
		int l = 0;
		int h = myInts.length - 1;

		if (h == l) {
			if (array[h] == targetValue) {
				return h;
			} else {
				return -1;
			}
		}
		while (true) {
			int t = (int) ((l + h) / 2);
			if (array[t] == targetValue) {
				return t;
			} else if (array[t] > targetValue) {
				h = t - 1;
			} else if (array[t] < targetValue) {
				l = t + 1;
			}
			if (h == l || Math.abs(h-l) == 1) {
				if (array[h] == targetValue) {
					return h;
				} else if (array[l] == targetValue) {
					return l;
				}
				break;
			}
		}

		return -1;
	}

	public void bubbleSort(int[] myInts) {
		array = myInts;
		for (int runforever = 0; runforever < myInts.length; runforever++) {
			for (int i = 1; i < myInts.length; i++) {
				if (myInts[i - 1] > myInts[i]) {
					swap(i - 1, i);
					myInts = array;
				}
			}
		}
	}

	public int linearSearch(int[] myInts, int targetValue) {
		int index = -1;
		for (int i = 0; i < myInts.length; i++) {
			if (targetValue == myInts[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	private void swap(int ind1, int ind2) {
		int tmp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = tmp;
	}
}