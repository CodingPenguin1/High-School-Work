/* Title: Recursive Binary Search
 * Author: Ryan J Slater
 * Date: 2/12/2018
 */

public class BinarySearchRecursion {

	int[] array = new int[100];

	public static void main(String[] args) {
		int[] a = new int[100];
		for (int i = 0; i < 100; i++) {
			a[i] = i;
		}
		
		int l = 0, h = a.length - 1;
		int t = 100;
		System.out.println("Found value " + t + " at index " + binarySearchRecursive(a, t, l, h));
	}

	public static int binarySearchRecursive(int[] a, int t, int l, int h) {
		if (h == l || Math.abs(h - l) <= 1) {
			if (a[h] == t) {
				return h;
			} else if (a[l] == t) {
				return l;
			}
			return -1;
		}

		int mid = (h + l) / 2;
		if (a[mid] == t) {
			return mid;
		} else if (a[mid] < t) {
			return binarySearchRecursive(a, t, mid, h);
		} else if (a[mid] > t) {
			return binarySearchRecursive(a, t, l, mid);
		}
		return -1;

	}

}